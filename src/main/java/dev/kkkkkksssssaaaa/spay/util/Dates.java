package dev.kkkkkksssssaaaa.spay.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class Dates {

    private static final ZoneId sysDefault = ZoneId.of("UTC");

    private Dates() {}

    public static ZonedDateTime now() {
        return ZonedDateTime.now(sysDefault);
    }

}
