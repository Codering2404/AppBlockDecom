package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawd {
    public final ArrayList zza = new ArrayList();
    public int zzb = 0;

    public zzawd(int i3) {
    }

    public final int zza(long j3) throws zzawb {
        long j4;
        int[] iArr = {2001100545, 2130723407, 140753313, -149863858, -2003236720, 202391198, 23353437, 1141616124, 84353895};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + (((((~i3) & i4) | i5) + ((i3 & i6) | i7)) - i8);
        int i12 = i10 % 84353895;
        long[] jArr = {269441500, 1994078854, 158128940, -158130045, -1992289935, 556430036, 8936987, 2147469841, 438792350};
        long j5 = jArr[0];
        long j6 = jArr[1];
        long j7 = jArr[2];
        long j8 = jArr[3];
        long j9 = jArr[4];
        long j10 = jArr[5];
        long j11 = jArr[6];
        long j12 = jArr[7];
        long j13 = j11 + (((((~j5) & j6) | j7) + ((j5 & j8) | j9)) - j10);
        long j14 = j12 % 438792350;
        if (j3 >= 0) {
            j4 = ((long) (this.zzb + (i11 ^ i12))) - j3;
        } else {
            j4 = (j13 ^ j14) + (-j3);
        }
        if (j4 < 0 || j4 >= this.zzb) {
            throw new zzawb();
        }
        return (int) j4;
    }

    public final void zzb(zzawm zzawmVar) throws zzawc {
        int[] iArr = {524133589, 740889625, 408955079, 621796408, 24562149, 1207357565, 297783268, 1066077375, 937558955};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
        int i12 = this.zzb;
        if (i12 >= ((i10 % 937558955) ^ i11)) {
            throw new zzawc();
        }
        ArrayList arrayList = this.zza;
        if (i12 == arrayList.size()) {
            arrayList.add(zzawmVar);
        } else {
            arrayList.set(this.zzb, zzawmVar);
        }
        this.zzb++;
    }

    public final zzawm zzc() throws zzawb {
        int[] iArr = {91119157, 1459677288, 586253619, -183145911, -1567288443, 919325394, 146725508, 787086305, 459541652};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8);
        int i12 = i10 % 459541652;
        int i13 = this.zzb;
        if (i13 <= 0) {
            throw new zzawb();
        }
        int i14 = i12 ^ i11;
        ArrayList arrayList = this.zza;
        zzawm zzawmVar = (zzawm) arrayList.get(i13 + i14);
        arrayList.set(this.zzb + i14, null);
        this.zzb += i14;
        return zzawmVar;
    }

    public final zzawm zzd(long j3) throws zzawb {
        return (zzawm) this.zza.get(zza(j3));
    }

    public final void zze(long j3, zzawm zzawmVar) throws zzawb {
        this.zza.set(zza(j3), zzawmVar);
    }
}
