package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zay extends GoogleApi implements ModuleInstallClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f72188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api f72189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f72190d = 0;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72187a = clientKey;
        zaq zaqVar = new zaq();
        f72188b = zaqVar;
        f72189c = new Api("ModuleInstall.API", zaqVar, clientKey);
    }
}
