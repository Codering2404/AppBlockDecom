package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AuthProxyOptions implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthProxyOptions f70974b = new AuthProxyOptions(new Bundle(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f70975a;

    /* synthetic */ AuthProxyOptions(Bundle bundle, zzb zzbVar) {
        this.f70975a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f70975a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthProxyOptions) {
            return Objects.a(this.f70975a, ((AuthProxyOptions) obj).f70975a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(this.f70975a);
    }
}
