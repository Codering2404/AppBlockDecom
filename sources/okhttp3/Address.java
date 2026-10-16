package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Address {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dns f143863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SocketFactory f143864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SSLSocketFactory f143865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HostnameVerifier f143866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CertificatePinner f143867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Authenticator f143868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Proxy f143869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ProxySelector f143870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HttpUrl f143871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f143872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f143873k;

    public Address(String uriHost, int i3, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, Proxy proxy, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f143863a = dns;
        this.f143864b = socketFactory;
        this.f143865c = sSLSocketFactory;
        this.f143866d = hostnameVerifier;
        this.f143867e = certificatePinner;
        this.f143868f = proxyAuthenticator;
        this.f143869g = proxy;
        this.f143870h = proxySelector;
        this.f143871i = new HttpUrl.Builder().x(sSLSocketFactory != null ? "https" : "http").n(uriHost).t(i3).c();
        this.f143872j = Util.V(protocols);
        this.f143873k = Util.V(connectionSpecs);
    }

    public final CertificatePinner a() {
        return this.f143867e;
    }

    public final List b() {
        return this.f143873k;
    }

    public final Dns c() {
        return this.f143863a;
    }

    public final boolean d(Address that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.f143863a, that.f143863a) && Intrinsics.areEqual(this.f143868f, that.f143868f) && Intrinsics.areEqual(this.f143872j, that.f143872j) && Intrinsics.areEqual(this.f143873k, that.f143873k) && Intrinsics.areEqual(this.f143870h, that.f143870h) && Intrinsics.areEqual(this.f143869g, that.f143869g) && Intrinsics.areEqual(this.f143865c, that.f143865c) && Intrinsics.areEqual(this.f143866d, that.f143866d) && Intrinsics.areEqual(this.f143867e, that.f143867e) && this.f143871i.n() == that.f143871i.n();
    }

    public final HostnameVerifier e() {
        return this.f143866d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Intrinsics.areEqual(this.f143871i, address.f143871i) && d(address);
    }

    public final List f() {
        return this.f143872j;
    }

    public final Proxy g() {
        return this.f143869g;
    }

    public final Authenticator h() {
        return this.f143868f;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f143871i.hashCode()) * 31) + this.f143863a.hashCode()) * 31) + this.f143868f.hashCode()) * 31) + this.f143872j.hashCode()) * 31) + this.f143873k.hashCode()) * 31) + this.f143870h.hashCode()) * 31) + Objects.hashCode(this.f143869g)) * 31) + Objects.hashCode(this.f143865c)) * 31) + Objects.hashCode(this.f143866d)) * 31) + Objects.hashCode(this.f143867e);
    }

    public final ProxySelector i() {
        return this.f143870h;
    }

    public final SocketFactory j() {
        return this.f143864b;
    }

    public final SSLSocketFactory k() {
        return this.f143865c;
    }

    public final HttpUrl l() {
        return this.f143871i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f143871i.i());
        sb.append(':');
        sb.append(this.f143871i.n());
        sb.append(", ");
        Proxy proxy = this.f143869g;
        sb.append(proxy != null ? Intrinsics.stringPlus("proxy=", proxy) : Intrinsics.stringPlus("proxySelector=", this.f143870h));
        sb.append('}');
        return sb.toString();
    }
}
