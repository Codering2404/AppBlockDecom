package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Route {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Address f93038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Proxy f93039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final InetSocketAddress f93040c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f93038a = address;
        this.f93039b = proxy;
        this.f93040c = inetSocketAddress;
    }

    public Address a() {
        return this.f93038a;
    }

    public Proxy b() {
        return this.f93039b;
    }

    public InetSocketAddress c() {
        return this.f93040c;
    }

    public boolean d() {
        return this.f93038a.f92765i != null && this.f93039b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (this.f93038a.equals(route.f93038a) && this.f93039b.equals(route.f93039b) && this.f93040c.equals(route.f93040c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f93038a.hashCode()) * 31) + this.f93039b.hashCode()) * 31) + this.f93040c.hashCode();
    }
}
