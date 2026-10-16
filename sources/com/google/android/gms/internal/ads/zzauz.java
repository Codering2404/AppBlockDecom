package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzauz extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzauz(zzauy zzauyVar, zzauw zzauwVar, long j3) {
        int i3 = (((((~2143124030) & 85005376) | 430547086) + ((2143124030 & 878451808) | 1894615585)) - (-2031609844)) ^ (1747844822 % 1617876982);
        Locale locale = Locale.US;
        Object[] objArr = new Object[i3];
        objArr[0] = Long.valueOf(zzauyVar.zza());
        objArr[1] = Long.valueOf(zzauwVar.zza());
        int i4 = (((((~1434433518) & 1229726181) | 671269892) + ((1434433518 & 1096561121) | 546312716)) - 1772679974) ^ (1830539036 % 1290127955);
        Long lValueOf = Long.valueOf(j3);
        objArr[i4] = lValueOf;
        super(String.format(locale, zzavo.zza("bk3t6gFTc30="), objArr));
        Optional.of(zzauwVar);
        Optional.of(lValueOf);
    }

    public zzauz(zzauy zzauyVar, Throwable th) {
        super(String.format(Locale.US, zzavo.zza("bk0="), Long.valueOf(zzauyVar.zza())), th);
        Optional.empty();
        Optional.empty();
    }
}
