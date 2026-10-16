package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Auth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api f70960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Api f70961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ProxyApi f70962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final GoogleSignInApi f70963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Api.ClientKey f70964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Api.ClientKey f70965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Api f70968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.android.gms.internal.p000authapi.zbd f70969j;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f70964e = clientKey;
        Api.ClientKey clientKey2 = new Api.ClientKey();
        f70965f = clientKey2;
        zba zbaVar = new zba();
        f70966g = zbaVar;
        zbb zbbVar = new zbb();
        f70967h = zbbVar;
        f70960a = AuthProxy.f70970a;
        f70968i = new Api("Auth.CREDENTIALS_API", zbaVar, clientKey);
        f70961b = new Api("Auth.GOOGLE_SIGN_IN_API", zbbVar, clientKey2);
        f70962c = AuthProxy.f70971b;
        f70969j = new com.google.android.gms.internal.p000authapi.zbd();
        f70963d = new com.google.android.gms.auth.api.signin.internal.zbd();
    }
}
