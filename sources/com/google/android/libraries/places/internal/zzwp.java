package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzwp {
    TIME_HOUR_OF_DAY_PADDED('H'),
    TIME_HOUR_OF_DAY('k'),
    TIME_HOUR_12H_PADDED('I'),
    TIME_HOUR_12H('l'),
    TIME_MINUTE_OF_HOUR_PADDED('M'),
    TIME_SECONDS_OF_MINUTE_PADDED('S'),
    TIME_MILLIS_OF_SECOND_PADDED('L'),
    TIME_NANOS_OF_SECOND_PADDED('N'),
    TIME_AM_PM('p'),
    TIME_TZ_NUMERIC('z'),
    TIME_TZ_SHORT('Z'),
    TIME_EPOCH_SECONDS('s'),
    TIME_EPOCH_MILLIS('Q'),
    DATE_MONTH_FULL('B'),
    DATE_MONTH_SHORT('b'),
    DATE_MONTH_SHORT_ALT('h'),
    DATE_DAY_FULL('A'),
    DATE_DAY_SHORT('a'),
    DATE_CENTURY_PADDED('C'),
    DATE_YEAR_PADDED('Y'),
    DATE_YEAR_OF_CENTURY_PADDED('y'),
    DATE_DAY_OF_YEAR_PADDED('j'),
    DATE_MONTH_PADDED('m'),
    DATE_DAY_OF_MONTH_PADDED('d'),
    DATE_DAY_OF_MONTH('e'),
    DATETIME_HOURS_MINUTES('R'),
    DATETIME_HOURS_MINUTES_SECONDS('T'),
    DATETIME_HOURS_MINUTES_SECONDS_12H('r'),
    DATETIME_MONTH_DAY_YEAR('D'),
    DATETIME_YEAR_MONTH_DAY('F'),
    DATETIME_FULL('c');

    private static final Map H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f78778a;

    static {
        HashMap map = new HashMap();
        for (zzwp zzwpVar : values()) {
            if (map.put(Character.valueOf(zzwpVar.f78778a), zzwpVar) != null) {
                throw new IllegalStateException("duplicate format character: ".concat(String.valueOf(zzwpVar)));
            }
        }
        H = Collections.unmodifiableMap(map);
    }

    zzwp(char c3) {
        this.f78778a = c3;
    }

    public static final zzwp a(char c3) {
        return (zzwp) H.get(Character.valueOf(c3));
    }

    public final char b() {
        return this.f78778a;
    }
}
