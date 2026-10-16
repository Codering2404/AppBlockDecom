package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Handshake {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f92916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f92917c;

    private Handshake(String str, List list, List list2) {
        this.f92915a = str;
        this.f92916b = list;
        this.f92917c = list2;
    }

    public static Handshake b(String str, List list, List list2) {
        if (str != null) {
            return new Handshake(str, Util.j(list), Util.j(list2));
        }
        throw new IllegalArgumentException("cipherSuite == null");
    }

    public static Handshake c(SSLSession sSLSession) {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listK = peerCertificates != null ? Util.k(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new Handshake(cipherSuite, listK, localCertificates != null ? Util.k(localCertificates) : Collections.EMPTY_LIST);
    }

    public String a() {
        return this.f92915a;
    }

    public List d() {
        return this.f92917c;
    }

    public List e() {
        return this.f92916b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return this.f92915a.equals(handshake.f92915a) && this.f92916b.equals(handshake.f92916b) && this.f92917c.equals(handshake.f92917c);
    }

    public int hashCode() {
        return ((((527 + this.f92915a.hashCode()) * 31) + this.f92916b.hashCode()) * 31) + this.f92917c.hashCode();
    }
}
