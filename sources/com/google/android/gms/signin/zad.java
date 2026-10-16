package com.google.android.gms.signin;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.ClientKey f74577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Api.ClientKey f74578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f74579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Api.AbstractClientBuilder f74580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f74581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f74582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Api f74583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Api f74584h;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f74577a = clientKey;
        Api.ClientKey clientKey2 = new Api.ClientKey();
        f74578b = clientKey2;
        zaa zaaVar = new zaa();
        f74579c = zaaVar;
        zab zabVar = new zab();
        f74580d = zabVar;
        f74581e = new Scope("profile");
        f74582f = new Scope(AuthenticationTokenClaims.JSON_KEY_EMAIL);
        f74583g = new Api("SignIn.API", zaaVar, clientKey);
        f74584h = new Api("SignIn.INTERNAL_API", zabVar, clientKey2);
    }
}
