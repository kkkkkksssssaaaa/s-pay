package dev.kkkkkksssssaaaa.spay.wallet.common.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    basePackages = ["dev.kkkkkksssssaaaa.spay.wallet.domain"],
)
class FeignConfiguration