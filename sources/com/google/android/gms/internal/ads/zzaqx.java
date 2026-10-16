package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqx implements zzafj {
    private final zzfi zza;
    private final zzet zzb = new zzet();
    private final int zzc;

    public zzaqx(int i3, zzfi zzfiVar, int i4) {
        this.zzc = i3;
        this.zza = zzfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzafi zza(zzafz zzafzVar, long j3) throws IOException {
        int iZza;
        int iZza2;
        long jZzn = zzafzVar.zzn();
        int iMin = (int) Math.min(112800L, zzafzVar.zzo() - jZzn);
        zzet zzetVar = this.zzb;
        zzetVar.zza(iMin);
        zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
        int iZze = zzetVar.zze();
        long j4 = -1;
        long j5 = -9223372036854775807L;
        long j6 = -1;
        while (zzetVar.zzd() >= 188 && (iZza2 = (iZza = zzarj.zza(zzetVar.zzi(), zzetVar.zzg(), iZze)) + 188) <= iZze) {
            long jZzb = zzarj.zzb(zzetVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZze = this.zza.zze(jZzb);
                if (jZze > j3) {
                    return j5 == -9223372036854775807L ? zzafi.zza(jZze, jZzn) : zzafi.zzc(jZzn + j6);
                }
                j6 = iZza;
                if (100000 + jZze > j3) {
                    return zzafi.zzc(jZzn + j6);
                }
                j5 = jZze;
            }
            zzetVar.zzh(iZza2);
            j4 = iZza2;
        }
        return j5 != -9223372036854775807L ? zzafi.zzb(j5, jZzn + j4) : zzafi.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void zzb() {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
    }
}
