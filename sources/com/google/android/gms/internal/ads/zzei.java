package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzei {
    private int zza;
    private int zzb;
    private int zzc;
    private long[] zzd;
    private int zze;

    public zzei() {
        throw null;
    }

    public final void zza(long j3) {
        int i3 = this.zzc;
        long[] jArr = this.zzd;
        int length = jArr.length;
        if (i3 == length) {
            int i4 = length + length;
            if (i4 < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[i4];
            int i5 = this.zza;
            int i6 = length - i5;
            System.arraycopy(jArr, i5, jArr2, 0, i6);
            System.arraycopy(this.zzd, 0, jArr2, i6, i5);
            this.zza = 0;
            this.zzb = this.zzc - 1;
            this.zzd = jArr2;
            this.zze = jArr2.length - 1;
            jArr = jArr2;
        }
        int i7 = (this.zzb + 1) & this.zze;
        this.zzb = i7;
        jArr[i7] = j3;
        this.zzc++;
    }

    public final long zzb() {
        int i3 = this.zzc;
        if (i3 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.zzd;
        int i4 = this.zza;
        long j3 = jArr[i4];
        this.zza = this.zze & (i4 + 1);
        this.zzc = i3 - 1;
        return j3;
    }

    public final long zzc() {
        if (this.zzc != 0) {
            return this.zzd[this.zza];
        }
        throw new NoSuchElementException();
    }

    public final boolean zzd() {
        return this.zzc == 0;
    }

    public final void zze() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
    }

    public zzei(int i3) {
        int i4 = 16;
        if (Integer.bitCount(16) != 1) {
            int iHighestOneBit = Integer.highestOneBit(15);
            i4 = iHighestOneBit + iHighestOneBit;
        }
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
        this.zzd = new long[i4];
        this.zze = r3.length - 1;
    }
}
