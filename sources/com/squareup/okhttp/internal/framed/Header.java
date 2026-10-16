package com.squareup.okhttp.internal.framed;

import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Header {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f93234d = ByteString.e(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f93235e = ByteString.e(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f93236f = ByteString.e(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f93237g = ByteString.e(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f93238h = ByteString.e(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f93239i = ByteString.e(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteString f93240j = ByteString.e(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f93241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteString f93242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f93243c;

    public Header(String str, String str2) {
        this(ByteString.e(str), ByteString.e(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            if (this.f93241a.equals(header.f93241a) && this.f93242b.equals(header.f93242b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f93241a.hashCode()) * 31) + this.f93242b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f93241a.I(), this.f93242b.I());
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.e(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.f93241a = byteString;
        this.f93242b = byteString2;
        this.f93243c = byteString.C() + 32 + byteString2.C();
    }
}
