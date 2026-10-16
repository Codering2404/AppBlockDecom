package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzbt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AuthProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api f70970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ProxyApi f70971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api.ClientKey f70972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70973d;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f70972c = clientKey;
        zza zzaVar = new zza();
        f70973d = zzaVar;
        f70970a = new Api("Auth.PROXY_API", zzaVar, clientKey);
        f70971b = new zzbt();
    }
}
