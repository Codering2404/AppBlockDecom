package com.google.android.libraries.places.internal;

import com.applovin.sdk.AppLovinEventParameters;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbki extends zzbng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SocketAddress f76324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InetSocketAddress f76325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f76326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f76327d;

    /* synthetic */ zzbki(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, byte[] bArr) {
        Preconditions.u(socketAddress, "proxyAddress");
        Preconditions.u(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Preconditions.D(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f76324a = socketAddress;
        this.f76325b = inetSocketAddress;
        this.f76326c = str;
        this.f76327d = str2;
    }

    public static zzbkh e() {
        return new zzbkh(null);
    }

    public final String a() {
        return this.f76327d;
    }

    public final String b() {
        return this.f76326c;
    }

    public final SocketAddress c() {
        return this.f76324a;
    }

    public final InetSocketAddress d() {
        return this.f76325b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbki)) {
            return false;
        }
        zzbki zzbkiVar = (zzbki) obj;
        return Objects.a(this.f76324a, zzbkiVar.f76324a) && Objects.a(this.f76325b, zzbkiVar.f76325b) && Objects.a(this.f76326c, zzbkiVar.f76326c) && Objects.a(this.f76327d, zzbkiVar.f76327d);
    }

    public final int hashCode() {
        return Objects.b(this.f76324a, this.f76325b, this.f76326c, this.f76327d);
    }

    public final String toString() {
        return MoreObjects.c(this).d("proxyAddr", this.f76324a).d("targetAddr", this.f76325b).d(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, this.f76326c).e("hasPassword", this.f76327d != null).toString();
    }
}
