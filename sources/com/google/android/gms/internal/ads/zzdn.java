package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdn {
    private int zzb;
    private int zzc;
    private int zzd = 7;
    private int[] zza = new int[8];

    public final void zza(int i3) {
        int[] iArr = this.zza;
        int i4 = this.zzc;
        iArr[i4] = i3;
        int i5 = this.zzd & (i4 + 1);
        this.zzc = i5;
        int i6 = this.zzb;
        if (i5 == i6) {
            int length = iArr.length;
            int i7 = length - i6;
            int i8 = length + length;
            int[] iArr2 = new int[i8];
            System.arraycopy(iArr, i6, iArr2, 0, i7);
            System.arraycopy(this.zza, 0, iArr2, i7, this.zzb);
            this.zza = iArr2;
            this.zzb = 0;
            this.zzc = length;
            this.zzd = i8 - 1;
        }
    }

    public final int zzb() {
        int i3 = this.zzb;
        if (i3 == this.zzc) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.zza[i3];
        this.zzb = (i3 + 1) & this.zzd;
        return i4;
    }

    public final void zzc() {
        this.zzc = this.zzb;
    }

    public final boolean zzd() {
        return this.zzb == this.zzc;
    }
}
