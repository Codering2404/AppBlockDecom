package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SocketAddress f76320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InetSocketAddress f76321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f76322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f76323d;

    private zzbkh() {
        throw null;
    }

    public final zzbkh a(SocketAddress socketAddress) {
        this.f76320a = (SocketAddress) Preconditions.u(socketAddress, "proxyAddress");
        return this;
    }

    public final zzbkh b(InetSocketAddress inetSocketAddress) {
        this.f76321b = (InetSocketAddress) Preconditions.u(inetSocketAddress, "targetAddress");
        return this;
    }

    public final zzbkh c(String str) {
        this.f76322c = str;
        return this;
    }

    public final zzbkh d(String str) {
        this.f76323d = str;
        return this;
    }

    public final zzbki e() {
        return new zzbki(this.f76320a, this.f76321b, this.f76322c, this.f76323d, null);
    }

    /* synthetic */ zzbkh(byte[] bArr) {
    }
}
