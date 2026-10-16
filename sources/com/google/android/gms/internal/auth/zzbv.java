package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbv implements ProxyApi.SpatulaHeaderResult {
    private final Status zza;
    private final String zzb;

    public zzbv(@Nonnull Status status) {
        this.zza = (Status) Preconditions.m(status);
        this.zzb = "";
    }

    public final String getSpatulaHeader() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(@Nonnull String str) {
        this.zzb = (String) Preconditions.m(str);
        this.zza = Status.f71537g;
    }
}
