package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimeSource {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TimeSource f80913c = new TimeSource(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f80914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeZone f80915b;

    private TimeSource(Long l3, TimeZone timeZone) {
        this.f80914a = l3;
        this.f80915b = timeZone;
    }

    static TimeSource c() {
        return f80913c;
    }

    Calendar a() {
        return b(this.f80915b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l3 = this.f80914a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
