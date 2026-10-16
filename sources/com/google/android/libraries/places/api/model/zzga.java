package com.google.android.libraries.places.api.model;

import android.util.Log;
import com.google.common.collect.ImmutableMap;
import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap f75346a = ImmutableMap.a().g(java.time.DayOfWeek.SUNDAY, DayOfWeek.SUNDAY).g(java.time.DayOfWeek.MONDAY, DayOfWeek.MONDAY).g(java.time.DayOfWeek.TUESDAY, DayOfWeek.TUESDAY).g(java.time.DayOfWeek.WEDNESDAY, DayOfWeek.WEDNESDAY).g(java.time.DayOfWeek.THURSDAY, DayOfWeek.THURSDAY).g(java.time.DayOfWeek.FRIDAY, DayOfWeek.FRIDAY).g(java.time.DayOfWeek.SATURDAY, DayOfWeek.SATURDAY).d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LocalTime f75347b = LocalTime.e(23, 59);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f75348c = 0;

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean a(com.google.android.libraries.places.api.model.Place r11, long r12) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.api.model.zzga.a(com.google.android.libraries.places.api.model.Place, long):java.lang.Boolean");
    }

    static long b(ZoneOffset zoneOffset, LocalDate localDate, int i3, int i4) {
        return OffsetDateTime.of(java.time.LocalDate.of(localDate.e(), localDate.d(), localDate.c()), java.time.LocalTime.of(i3, i4), zoneOffset).toInstant().toEpochMilli();
    }

    private static ZoneOffset c(int i3) {
        try {
            return ZoneOffset.ofTotalSeconds(i3 * 60);
        } catch (DateTimeException unused) {
            Log.w("Places OpeningHoursUtil", String.format("Cannot find timezone that associates with utcOffsetMinutes %d from Place object.", Integer.valueOf(i3)));
            return null;
        }
    }
}
