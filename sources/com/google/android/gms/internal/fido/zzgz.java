package com.google.android.gms.internal.fido;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgz extends zzhb {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;

    /* synthetic */ zzgz(byte[] bArr, int i3, int i4, boolean z2, zzgy zzgyVar) {
        super(null);
        this.zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i3) throws zzhd {
        int i4 = this.zze;
        this.zze = 0;
        int i5 = this.zzc + this.zzd;
        this.zzc = i5;
        if (i5 <= 0) {
            this.zzd = 0;
            return i4;
        }
        this.zzd = i5;
        this.zzc = 0;
        return i4;
    }
}
