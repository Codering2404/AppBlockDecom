package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfh {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzfh() {
        throw null;
    }

    private final Object zzf() {
        zzgtj.zzi(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i3 = this.zzc;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.zzc = (i3 + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized void zza(long j3, Object obj) {
        try {
            if (this.zzd > 0) {
                if (j3 <= this.zza[((this.zzc + r0) - 1) % this.zzb.length]) {
                    zzb();
                }
            }
            int length = this.zzb.length;
            if (this.zzd >= length) {
                int i3 = length + length;
                long[] jArr = new long[i3];
                Object[] objArr = new Object[i3];
                int i4 = this.zzc;
                int i5 = length - i4;
                System.arraycopy(this.zza, i4, jArr, 0, i5);
                System.arraycopy(this.zzb, this.zzc, objArr, 0, i5);
                int i6 = this.zzc;
                if (i6 > 0) {
                    System.arraycopy(this.zza, 0, jArr, i5, i6);
                    System.arraycopy(this.zzb, 0, objArr, i5, this.zzc);
                }
                this.zza = jArr;
                this.zzb = objArr;
                this.zzc = 0;
            }
            int i7 = this.zzc;
            int i8 = this.zzd;
            Object[] objArr2 = this.zzb;
            int length2 = (i7 + i8) % objArr2.length;
            this.zza[length2] = j3;
            objArr2[length2] = obj;
            this.zzd = i8 + 1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public final synchronized int zzc() {
        return this.zzd;
    }

    public final synchronized Object zzd() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    public final synchronized Object zze(long j3) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j3 - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }

    public zzfh(int i3) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }
}
