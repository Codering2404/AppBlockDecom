package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ApiKey<O extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f71549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Api f71550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Api.ApiOptions f71551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f71552d;

    private ApiKey(Api api, Api.ApiOptions apiOptions, String str) {
        this.f71550b = api;
        this.f71551c = apiOptions;
        this.f71552d = str;
        this.f71549a = Objects.c(api, apiOptions, str);
    }

    public static ApiKey a(Api api, Api.ApiOptions apiOptions, String str) {
        return new ApiKey(api, apiOptions, str);
    }

    public final String b() {
        return this.f71550b.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return Objects.b(this.f71550b, apiKey.f71550b) && Objects.b(this.f71551c, apiKey.f71551c) && Objects.b(this.f71552d, apiKey.f71552d);
    }

    public final int hashCode() {
        return this.f71549a;
    }
}
