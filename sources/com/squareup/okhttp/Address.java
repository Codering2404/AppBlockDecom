package com.squareup.okhttp;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Address {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HttpUrl f92757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Dns f92758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SocketFactory f92759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Authenticator f92760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List f92761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List f92762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ProxySelector f92763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Proxy f92764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final SSLSocketFactory f92765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final HostnameVerifier f92766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final CertificatePinner f92767k;

    public Address(String str, int i3, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f92757a = new HttpUrl.Builder().u(sSLSocketFactory != null ? "https" : "http").i(str).p(i3).a();
        if (dns == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.f92758b = dns;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.f92759c = socketFactory;
        if (authenticator == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        this.f92760d = authenticator;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.f92761e = Util.j(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f92762f = Util.j(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.f92763g = proxySelector;
        this.f92764h = proxy;
        this.f92765i = sSLSocketFactory;
        this.f92766j = hostnameVerifier;
        this.f92767k = certificatePinner;
    }

    public Authenticator a() {
        return this.f92760d;
    }

    public CertificatePinner b() {
        return this.f92767k;
    }

    public List c() {
        return this.f92762f;
    }

    public Dns d() {
        return this.f92758b;
    }

    public HostnameVerifier e() {
        return this.f92766j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f92757a.equals(address.f92757a) && this.f92758b.equals(address.f92758b) && this.f92760d.equals(address.f92760d) && this.f92761e.equals(address.f92761e) && this.f92762f.equals(address.f92762f) && this.f92763g.equals(address.f92763g) && Util.h(this.f92764h, address.f92764h) && Util.h(this.f92765i, address.f92765i) && Util.h(this.f92766j, address.f92766j) && Util.h(this.f92767k, address.f92767k)) {
                return true;
            }
        }
        return false;
    }

    public List f() {
        return this.f92761e;
    }

    public Proxy g() {
        return this.f92764h;
    }

    public ProxySelector h() {
        return this.f92763g;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f92757a.hashCode()) * 31) + this.f92758b.hashCode()) * 31) + this.f92760d.hashCode()) * 31) + this.f92761e.hashCode()) * 31) + this.f92762f.hashCode()) * 31) + this.f92763g.hashCode()) * 31;
        Proxy proxy = this.f92764h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f92765i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f92766j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f92767k;
        return iHashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f92759c;
    }

    public SSLSocketFactory j() {
        return this.f92765i;
    }

    public String k() {
        return this.f92757a.q();
    }

    public int l() {
        return this.f92757a.A();
    }

    public HttpUrl m() {
        return this.f92757a;
    }
}
