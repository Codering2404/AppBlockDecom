package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeh {
    private int zza;
    private long[] zzb;

    public zzeh() {
        this(32);
    }

    public final void zza(long j3) {
        int i3 = this.zza;
        long[] jArr = this.zzb;
        if (i3 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i3 + i3);
        }
        long[] jArr2 = this.zzb;
        int i4 = this.zza;
        this.zza = i4 + 1;
        jArr2[i4] = 0;
    }

    public final void zzb(long[] jArr) {
        int i3 = this.zza;
        int length = jArr.length;
        int i4 = i3 + length;
        long[] jArr2 = this.zzb;
        int length2 = jArr2.length;
        if (i4 > length2) {
            this.zzb = Arrays.copyOf(jArr2, Math.max(length2 + length2, i4));
        }
        System.arraycopy(jArr, 0, this.zzb, this.zza, length);
        this.zza = i4;
    }

    public final long zzc(int i3) {
        if (i3 >= 0 && i3 < this.zza) {
            return this.zzb[i3];
        }
        int i4 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 24 + String.valueOf(i4).length());
        sb.append("Invalid index ");
        sb.append(i3);
        sb.append(", size is ");
        sb.append(i4);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int zzd() {
        return this.zza;
    }

    public zzeh(int i3) {
        this.zzb = new long[i3];
    }
}
