package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbio f77110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SocketAddress f77111b;

    public zzbwu(zzbio zzbioVar, SocketAddress socketAddress) {
        this.f77110a = zzbioVar;
        this.f77111b = socketAddress;
    }

    final /* synthetic */ zzbka a() {
        return new zzbka(Collections.singletonList(this.f77111b), this.f77110a);
    }

    final /* synthetic */ zzbio b() {
        return this.f77110a;
    }

    final /* synthetic */ SocketAddress c() {
        return this.f77111b;
    }
}
