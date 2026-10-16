package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqp {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzet zzb = new zzet();

    zzaqp() {
    }

    public static long zze(zzet zzetVar) {
        int iZzg = zzetVar.zzg();
        if (zzetVar.zzd() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzetVar.zzm(bArr, 0, 9);
        zzetVar.zzh(iZzg);
        byte b3 = bArr[0];
        if ((b3 & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b4 = bArr[2];
        if ((b4 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b5 = bArr[4];
        if ((b5 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j3 = b3;
        long j4 = b4;
        long j5 = (248 & j4) >> 3;
        long j6 = (j4 & 3) << 13;
        return j6 | ((bArr[1] & 255) << 20) | ((j3 & 3) << 28) | (((j3 & 56) >> 3) << 30) | (j5 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b5) & 248) >> 3);
    }

    private final int zzf(zzafz zzafzVar) {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzafzVar.zzl();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzfi zzb() {
        return this.zza;
    }

    public final int zzc(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        long j3 = -9223372036854775807L;
        if (!this.zze) {
            long jZzo = zzafzVar.zzo();
            int iMin = (int) Math.min(20000L, jZzo);
            long j4 = jZzo - ((long) iMin);
            if (zzafzVar.zzn() != j4) {
                zzagyVar.zza = j4;
                return 1;
            }
            zzet zzetVar = this.zzb;
            zzetVar.zza(iMin);
            zzafzVar.zzl();
            zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
            int iZzg = zzetVar.zzg();
            int iZze = zzetVar.zze() - 4;
            while (true) {
                if (iZze < iZzg) {
                    break;
                }
                if (zzg(zzetVar.zzi(), iZze) == 442) {
                    zzetVar.zzh(iZze + 4);
                    long jZze = zze(zzetVar);
                    if (jZze != -9223372036854775807L) {
                        j3 = jZze;
                        break;
                    }
                }
                iZze--;
            }
            this.zzg = j3;
            this.zze = true;
            return 0;
        }
        if (this.zzg == -9223372036854775807L) {
            zzf(zzafzVar);
            return 0;
        }
        if (this.zzd) {
            long j5 = this.zzf;
            if (j5 == -9223372036854775807L) {
                zzf(zzafzVar);
                return 0;
            }
            zzfi zzfiVar = this.zza;
            this.zzh = zzfiVar.zzf(this.zzg) - zzfiVar.zze(j5);
            zzf(zzafzVar);
            return 0;
        }
        int iMin2 = (int) Math.min(20000L, zzafzVar.zzo());
        if (zzafzVar.zzn() != 0) {
            zzagyVar.zza = 0L;
            return 1;
        }
        zzet zzetVar2 = this.zzb;
        zzetVar2.zza(iMin2);
        zzafzVar.zzl();
        zzafzVar.zzi(zzetVar2.zzi(), 0, iMin2);
        int iZzg2 = zzetVar2.zzg();
        int iZze2 = zzetVar2.zze();
        while (true) {
            if (iZzg2 >= iZze2 - 3) {
                break;
            }
            if (zzg(zzetVar2.zzi(), iZzg2) == 442) {
                zzetVar2.zzh(iZzg2 + 4);
                long jZze2 = zze(zzetVar2);
                if (jZze2 != -9223372036854775807L) {
                    j3 = jZze2;
                    break;
                }
            }
            iZzg2++;
        }
        this.zzf = j3;
        this.zzd = true;
        return 0;
    }

    public final long zzd() {
        return this.zzh;
    }
}
