package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqz {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzet zzb = new zzet();

    zzaqz(int i3) {
    }

    private final int zze(zzafz zzafzVar) {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzafzVar.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zzafz zzafzVar, zzagy zzagyVar, int i3) throws IOException {
        if (i3 <= 0) {
            zze(zzafzVar);
            return 0;
        }
        long j3 = -9223372036854775807L;
        if (this.zze) {
            if (this.zzg == -9223372036854775807L) {
                zze(zzafzVar);
                return 0;
            }
            if (this.zzd) {
                long j4 = this.zzf;
                if (j4 == -9223372036854775807L) {
                    zze(zzafzVar);
                    return 0;
                }
                zzfi zzfiVar = this.zza;
                this.zzh = zzfiVar.zzf(this.zzg) - zzfiVar.zze(j4);
                zze(zzafzVar);
                return 0;
            }
            int iMin = (int) Math.min(112800L, zzafzVar.zzo());
            if (zzafzVar.zzn() != 0) {
                zzagyVar.zza = 0L;
                return 1;
            }
            zzet zzetVar = this.zzb;
            zzetVar.zza(iMin);
            zzafzVar.zzl();
            zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
            int iZzg = zzetVar.zzg();
            int iZze = zzetVar.zze();
            while (true) {
                if (iZzg >= iZze) {
                    break;
                }
                if (zzetVar.zzi()[iZzg] == 71) {
                    long jZzb = zzarj.zzb(zzetVar, iZzg, i3);
                    if (jZzb != -9223372036854775807L) {
                        j3 = jZzb;
                        break;
                    }
                }
                iZzg++;
            }
            this.zzf = j3;
            this.zzd = true;
            return 0;
        }
        long jZzo = zzafzVar.zzo();
        int iMin2 = (int) Math.min(112800L, jZzo);
        long j5 = jZzo - ((long) iMin2);
        if (zzafzVar.zzn() != j5) {
            zzagyVar.zza = j5;
            return 1;
        }
        zzet zzetVar2 = this.zzb;
        zzetVar2.zza(iMin2);
        zzafzVar.zzl();
        zzafzVar.zzi(zzetVar2.zzi(), 0, iMin2);
        int iZzg2 = zzetVar2.zzg();
        int iZze2 = zzetVar2.zze();
        int i4 = iZze2 - 188;
        while (true) {
            if (i4 < iZzg2) {
                break;
            }
            byte[] bArrZzi = zzetVar2.zzi();
            int i5 = -4;
            int i6 = 0;
            while (true) {
                if (i5 > 4) {
                    break;
                }
                int i7 = (i5 * 188) + i4;
                if (i7 < iZzg2 || i7 >= iZze2 || bArrZzi[i7] != 71) {
                    i6 = 0;
                } else {
                    i6++;
                    if (i6 == 5) {
                        long jZzb2 = zzarj.zzb(zzetVar2, i4, i3);
                        if (jZzb2 != -9223372036854775807L) {
                            j3 = jZzb2;
                            break;
                        }
                    }
                }
                i5++;
            }
            i4--;
        }
        this.zzg = j3;
        this.zze = true;
        return 0;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzfi zzd() {
        return this.zza;
    }
}
