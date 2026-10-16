package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Common {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.ClientKey f72029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Api f72030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f72031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zae f72032d;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72029a = clientKey;
        zab zabVar = new zab();
        f72031c = zabVar;
        f72030b = new Api("Common.API", zabVar, clientKey);
        f72032d = new zae();
    }
}
