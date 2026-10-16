package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbsy implements zzbmb {
    zzbsy() {
    }

    @Override // com.google.android.libraries.places.internal.zzbmb
    public final /* bridge */ /* synthetic */ Object zza(String str) {
        Preconditions.e(str.length() > 0, "empty timeout");
        Preconditions.e(str.length() <= 9, "bad timeout format");
        long j3 = Long.parseLong(str.substring(0, str.length() - 1));
        char cCharAt = str.charAt(str.length() - 1);
        if (cCharAt == 'H') {
            return Long.valueOf(TimeUnit.HOURS.toNanos(j3));
        }
        if (cCharAt == 'M') {
            return Long.valueOf(TimeUnit.MINUTES.toNanos(j3));
        }
        if (cCharAt == 'S') {
            return Long.valueOf(TimeUnit.SECONDS.toNanos(j3));
        }
        if (cCharAt == 'u') {
            return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j3));
        }
        if (cCharAt == 'm') {
            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j3));
        }
        if (cCharAt == 'n') {
            return Long.valueOf(j3);
        }
        throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
    }

    @Override // com.google.android.libraries.places.internal.zzbmb
    public final /* bridge */ /* synthetic */ String zzb(Object obj) {
        long jMax = Math.max(1L, ((Long) obj).longValue());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (jMax < 100000000) {
            StringBuilder sb = new StringBuilder(String.valueOf(jMax).length() + 1);
            sb.append(jMax);
            sb.append("n");
            return sb.toString();
        }
        if (jMax < 100000000000L) {
            long micros = timeUnit.toMicros(jMax);
            StringBuilder sb2 = new StringBuilder(String.valueOf(micros).length() + 1);
            sb2.append(micros);
            sb2.append("u");
            return sb2.toString();
        }
        if (jMax < 100000000000000L) {
            long millis = timeUnit.toMillis(jMax);
            StringBuilder sb3 = new StringBuilder(String.valueOf(millis).length() + 1);
            sb3.append(millis);
            sb3.append("m");
            return sb3.toString();
        }
        if (jMax < 100000000000000000L) {
            long seconds = timeUnit.toSeconds(jMax);
            StringBuilder sb4 = new StringBuilder(String.valueOf(seconds).length() + 1);
            sb4.append(seconds);
            sb4.append("S");
            return sb4.toString();
        }
        if (jMax < 6000000000000000000L) {
            long minutes = timeUnit.toMinutes(jMax);
            StringBuilder sb5 = new StringBuilder(String.valueOf(minutes).length() + 1);
            sb5.append(minutes);
            sb5.append("M");
            return sb5.toString();
        }
        long hours = timeUnit.toHours(jMax);
        StringBuilder sb6 = new StringBuilder(String.valueOf(hours).length() + 1);
        sb6.append(hours);
        sb6.append("H");
        return sb6.toString();
    }
}
