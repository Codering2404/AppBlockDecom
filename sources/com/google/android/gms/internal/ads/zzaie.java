package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaie extends zzafk {
    public zzaie(final zzagl zzaglVar, int i3, long j3, long j4) {
        long j5;
        Objects.requireNonNull(zzaglVar);
        zzafh zzafhVar = new zzafh() { // from class: com.google.android.gms.internal.ads.zzaic
            @Override // com.google.android.gms.internal.ads.zzafh
            public final /* synthetic */ long zza(long j6) {
                return zzaglVar.zzb(j6);
            }
        };
        zzaid zzaidVar = new zzaid(zzaglVar, i3, null);
        long jZza = zzaglVar.zza();
        long j6 = zzaglVar.zzj;
        int i4 = zzaglVar.zzd;
        if (i4 > 0) {
            j5 = ((((long) i4) + ((long) zzaglVar.zzc)) / 2) + 1;
        } else {
            int i5 = zzaglVar.zza;
            long j7 = 4096;
            if (i5 == zzaglVar.zzb && i5 > 0) {
                j7 = i5;
            }
            j5 = 64 + (((j7 * ((long) zzaglVar.zzg)) * ((long) zzaglVar.zzh)) / 8);
        }
        super(zzafhVar, zzaidVar, jZza, 0L, j6, j3, j4, j5, Math.max(6, zzaglVar.zzc));
    }
}
