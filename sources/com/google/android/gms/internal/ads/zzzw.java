package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzzw implements zzaba {
    protected final zzbg zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzv[] zzd;
    private int zze;

    public zzzw(zzbg zzbgVar, int[] iArr, int i3) {
        int length = iArr.length;
        zzgtj.zzi(length > 0);
        zzbgVar.getClass();
        this.zza = zzbgVar;
        this.zzb = length;
        this.zzd = new zzv[length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.zzd[i4] = zzbgVar.zza(iArr[i4]);
        }
        Arrays.sort(this.zzd, zzzv.zza);
        this.zzc = new int[this.zzb];
        for (int i5 = 0; i5 < this.zzb; i5++) {
            this.zzc[i5] = zzbgVar.zzb(this.zzd[i5]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzzw zzzwVar = (zzzw) obj;
            if (this.zza.equals(zzzwVar.zza) && Arrays.equals(this.zzc, zzzwVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zze;
        if (i3 != 0) {
            return i3;
        }
        int iIdentityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = iIdentityHashCode;
        return iIdentityHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final zzv zzb(int i3) {
        return this.zzd[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final zzv zzc() {
        return this.zzd[0];
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zze() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zzf(int i3) {
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zzg(int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            if (this.zzc[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final int zzh() {
        return this.zzc[0];
    }
}
