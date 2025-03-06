package dev.kkkkkksssssaaaa.spay.exchange.common

import org.springframework.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Configuration
@EnableCaching
class LocalCacheConfiguration {
    @Bean
    fun cacheManager(): CacheManager {
        return CustomCacheManager()
    }
}

internal class CustomCacheManager : CacheManager {
    private val caches: MutableMap<String, CustomConcurrentMapCache> = ConcurrentHashMap()

    override fun getCache(name: String): Cache {
        return caches.computeIfAbsent(name) { CustomConcurrentMapCache(it, 60) } // TTL 60초
    }

    override fun getCacheNames(): Collection<String> {
        return caches.keys
    }
}

internal class CustomConcurrentMapCache(
    name: String,
    private val ttlSeconds: Long
) : ConcurrentMapCache(name, ConcurrentHashMap(), false) {
    private val expiryMap = ConcurrentHashMap<Any, Long>()
    private val scheduler = Executors.newScheduledThreadPool(1)

    init {
        scheduler.scheduleAtFixedRate({ removeExpiredEntries() }, ttlSeconds, ttlSeconds, TimeUnit.SECONDS)
    }

    override fun put(key: Any, value: Any?) {
        super.put(key, value)
        expiryMap[key] = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(ttlSeconds)
    }

    override fun get(key: Any): Cache.ValueWrapper? {
        if (isExpired(key)) {
            evict(key)
            return null
        }
        return super.get(key)
    }

    override fun evict(key: Any) {
        super.evict(key)
        expiryMap.remove(key)
    }

    private fun isExpired(key: Any): Boolean {
        return expiryMap[key]?.let { it < System.currentTimeMillis() } ?: false
    }

    private fun removeExpiredEntries() {
        expiryMap.keys.forEach {
            if (isExpired(it)) evict(it)
        }
    }
}