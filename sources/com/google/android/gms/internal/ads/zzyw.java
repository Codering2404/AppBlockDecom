package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyw {
    private final zzabl zza;
    private final zzet zzb = new zzet(32);
    private zzyv zzc;
    private zzyv zzd;
    private zzyv zze;
    private long zzf;

    public zzyw(zzabl zzablVar) {
        this.zza = zzablVar;
        zzyv zzyvVar = new zzyv(0L, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.zzc = zzyvVar;
        this.zzd = zzyvVar;
        this.zze = zzyvVar;
    }

    private final int zzi(int i3) {
        zzyv zzyvVar = this.zze;
        if (zzyvVar.zzc == null) {
            zzabj zzabjVarZza = this.zza.zza();
            zzyv zzyvVar2 = new zzyv(this.zze.zzb, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            zzyvVar.zzc = zzabjVarZza;
            zzyvVar.zzd = zzyvVar2;
        }
        return Math.min(i3, (int) (this.zze.zzb - this.zzf));
    }

    private final void zzj(int i3) {
        long j3 = this.zzf + ((long) i3);
        this.zzf = j3;
        zzyv zzyvVar = this.zze;
        if (j3 == zzyvVar.zzb) {
            this.zze = zzyvVar.zzd;
        }
    }

    private static zzyv zzk(zzyv zzyvVar, zziv zzivVar, zzyx zzyxVar, zzet zzetVar) {
        zzyv zzyvVarZzm;
        if (zzivVar.zzk()) {
            long j3 = zzyxVar.zzb;
            int iZzt = 1;
            zzetVar.zza(1);
            zzyv zzyvVarZzm2 = zzm(zzyvVar, j3, zzetVar.zzi(), 1);
            long j4 = j3 + 1;
            byte b3 = zzetVar.zzi()[0];
            int i3 = b3 & 128;
            int i4 = b3 & Ascii.DEL;
            zzis zzisVar = zzivVar.zzb;
            byte[] bArr = zzisVar.zza;
            if (bArr == null) {
                zzisVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z2 = i3 != 0;
            zzyvVarZzm = zzm(zzyvVarZzm2, j4, zzisVar.zza, i4);
            long j5 = j4 + ((long) i4);
            if (z2) {
                zzetVar.zza(2);
                zzyvVarZzm = zzm(zzyvVarZzm, j5, zzetVar.zzi(), 2);
                j5 += 2;
                iZzt = zzetVar.zzt();
            }
            int i5 = iZzt;
            int[] iArr = zzisVar.zzd;
            if (iArr == null || iArr.length < i5) {
                iArr = new int[i5];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzisVar.zze;
            if (iArr3 == null || iArr3.length < i5) {
                iArr3 = new int[i5];
            }
            int[] iArr4 = iArr3;
            if (z2) {
                int i6 = i5 * 6;
                zzetVar.zza(i6);
                zzyvVarZzm = zzm(zzyvVarZzm, j5, zzetVar.zzi(), i6);
                j5 += (long) i6;
                zzetVar.zzh(0);
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr2[i7] = zzetVar.zzt();
                    iArr4[i7] = zzetVar.zzH();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzyxVar.zza - ((int) (j5 - zzyxVar.zzb));
            }
            zzahj zzahjVar = zzyxVar.zzc;
            String str = zzfl.zza;
            zzisVar.zza(i5, iArr2, iArr4, zzahjVar.zzb, zzisVar.zza, zzahjVar.zza, zzahjVar.zzc, zzahjVar.zzd);
            long j6 = zzyxVar.zzb;
            int i8 = (int) (j5 - j6);
            zzyxVar.zzb = j6 + ((long) i8);
            zzyxVar.zza -= i8;
        } else {
            zzyvVarZzm = zzyvVar;
        }
        if (!zzivVar.zze()) {
            zzivVar.zzj(zzyxVar.zza);
            return zzl(zzyvVarZzm, zzyxVar.zzb, zzivVar.zzc, zzyxVar.zza);
        }
        zzetVar.zza(4);
        zzyv zzyvVarZzm3 = zzm(zzyvVarZzm, zzyxVar.zzb, zzetVar.zzi(), 4);
        int iZzH = zzetVar.zzH();
        zzyxVar.zzb += 4;
        zzyxVar.zza -= 4;
        zzivVar.zzj(iZzH);
        zzyv zzyvVarZzl = zzl(zzyvVarZzm3, zzyxVar.zzb, zzivVar.zzc, iZzH);
        zzyxVar.zzb += (long) iZzH;
        int i9 = zzyxVar.zza - iZzH;
        zzyxVar.zza = i9;
        ByteBuffer byteBuffer = zzivVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i9) {
            zzivVar.zzf = ByteBuffer.allocate(i9);
        } else {
            zzivVar.zzf.clear();
        }
        return zzl(zzyvVarZzl, zzyxVar.zzb, zzivVar.zzf, zzyxVar.zza);
    }

    private static zzyv zzl(zzyv zzyvVar, long j3, ByteBuffer byteBuffer, int i3) {
        zzyv zzyvVarZzn = zzn(zzyvVar, j3);
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (zzyvVarZzn.zzb - j3));
            byteBuffer.put(zzyvVarZzn.zzc.zza, zzyvVarZzn.zzb(j3), iMin);
            i3 -= iMin;
            j3 += (long) iMin;
            if (j3 == zzyvVarZzn.zzb) {
                zzyvVarZzn = zzyvVarZzn.zzd;
            }
        }
        return zzyvVarZzn;
    }

    private static zzyv zzm(zzyv zzyvVar, long j3, byte[] bArr, int i3) {
        zzyv zzyvVarZzn = zzn(zzyvVar, j3);
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(i4, (int) (zzyvVarZzn.zzb - j3));
            System.arraycopy(zzyvVarZzn.zzc.zza, zzyvVarZzn.zzb(j3), bArr, i3 - i4, iMin);
            i4 -= iMin;
            j3 += (long) iMin;
            if (j3 == zzyvVarZzn.zzb) {
                zzyvVarZzn = zzyvVarZzn.zzd;
            }
        }
        return zzyvVarZzn;
    }

    private static zzyv zzn(zzyv zzyvVar, long j3) {
        while (j3 >= zzyvVar.zzb) {
            zzyvVar = zzyvVar.zzd;
        }
        return zzyvVar;
    }

    public final void zza() {
        zzyv zzyvVar = this.zzc;
        if (zzyvVar.zzc != null) {
            this.zza.zzc(zzyvVar);
            zzyvVar.zzc();
        }
        this.zzc.zza(0L, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        zzyv zzyvVar2 = this.zzc;
        this.zzd = zzyvVar2;
        this.zze = zzyvVar2;
        this.zzf = 0L;
        this.zza.zzd();
    }

    public final void zzb() {
        this.zzd = this.zzc;
    }

    public final void zzc(zziv zzivVar, zzyx zzyxVar) {
        this.zzd = zzk(this.zzd, zzivVar, zzyxVar, this.zzb);
    }

    public final void zzd(zziv zzivVar, zzyx zzyxVar) {
        zzk(this.zzd, zzivVar, zzyxVar, this.zzb);
    }

    public final void zze(long j3) {
        zzyv zzyvVar;
        if (j3 != -1) {
            while (true) {
                zzyvVar = this.zzc;
                if (j3 < zzyvVar.zzb) {
                    break;
                }
                this.zza.zzb(zzyvVar.zzc);
                this.zzc = this.zzc.zzc();
            }
            if (this.zzd.zza < zzyvVar.zza) {
                this.zzd = zzyvVar;
            }
        }
    }

    public final long zzf() {
        return this.zzf;
    }

    public final int zzg(zzj zzjVar, int i3, boolean z2) throws IOException {
        int iZzi = zzi(i3);
        zzyv zzyvVar = this.zze;
        int iZza = zzjVar.zza(zzyvVar.zzc.zza, zzyvVar.zzb(this.zzf), iZzi);
        if (iZza != -1) {
            zzj(iZza);
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzh(zzet zzetVar, int i3) {
        while (i3 > 0) {
            int iZzi = zzi(i3);
            zzyv zzyvVar = this.zze;
            zzetVar.zzm(zzyvVar.zzc.zza, zzyvVar.zzb(this.zzf), iZzi);
            i3 -= iZzi;
            zzj(iZzi);
        }
    }
}
