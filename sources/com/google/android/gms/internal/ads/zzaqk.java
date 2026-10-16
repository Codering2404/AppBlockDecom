package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqk {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zzaqk(int i3, int i4) {
        this.zzc = i3;
        byte[] bArr = new byte[131];
        this.zza = bArr;
        bArr[2] = 1;
    }

    public final void zza() {
        this.zzd = false;
        this.zze = false;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final void zzc(int i3) {
        zzgtj.zzi(!this.zzd);
        boolean z2 = i3 == this.zzc;
        this.zzd = z2;
        if (z2) {
            this.zzb = 3;
            this.zze = false;
        }
    }

    public final void zzd(byte[] bArr, int i3, int i4) {
        if (this.zzd) {
            int i5 = i4 - i3;
            byte[] bArr2 = this.zza;
            int length = bArr2.length;
            int i6 = this.zzb + i5;
            if (length < i6) {
                this.zza = Arrays.copyOf(bArr2, i6 + i6);
            }
            System.arraycopy(bArr, i3, this.zza, this.zzb, i5);
            this.zzb += i5;
        }
    }

    public final boolean zze(int i3) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= i3;
        this.zzd = false;
        this.zze = true;
        return true;
    }
}
