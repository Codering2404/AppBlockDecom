package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzli extends zzlj {
    private int zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzli(byte[] bArr, int i3, int i4, boolean z2, byte[] bArr2) {
        super(null);
        this.zzd = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzb = 0;
    }

    public final int zza(int i3) throws zzmr {
        int i4 = this.zzd;
        this.zzd = 0;
        int i5 = this.zzb + this.zzc;
        this.zzb = i5;
        if (i5 <= 0) {
            this.zzc = 0;
            return i4;
        }
        this.zzc = i5;
        this.zzb = 0;
        return i4;
    }
}
