package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Handshake {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f144074e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TlsVersion f144075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CipherSuite f144076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f144077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f144078d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List c(Certificate[] certificateArr) {
            return certificateArr != null ? Util.w(Arrays.copyOf(certificateArr, certificateArr.length)) : CollectionsKt.emptyList();
        }

        public final Handshake a(SSLSession sSLSession) throws IOException {
            final List listEmptyList;
            Intrinsics.checkNotNullParameter(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (Intrinsics.areEqual(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.areEqual(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(Intrinsics.stringPlus("cipherSuite == ", cipherSuite));
            }
            CipherSuite cipherSuiteB = CipherSuite.f143950b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (Intrinsics.areEqual("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionA = TlsVersion.f144266b.a(protocol);
            try {
                listEmptyList = c(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new Handshake(tlsVersionA, cipherSuiteB, c(sSLSession.getLocalCertificates()), new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    return listEmptyList;
                }
            });
        }

        public final Handshake b(TlsVersion tlsVersion, CipherSuite cipherSuite, List peerCertificates, List localCertificates) {
            Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
            Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
            Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
            Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
            final List listV = Util.V(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, Util.V(localCertificates), new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List invoke() {
                    return listV;
                }
            });
        }

        private Companion() {
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List localCertificates, final Function0 peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f144075a = tlsVersion;
        this.f144076b = cipherSuite;
        this.f144077c = localCertificates;
        this.f144078d = LazyKt.b(new Function0<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                try {
                    return (List) peerCertificatesFn.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return CollectionsKt.emptyList();
                }
            }
        });
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return type;
    }

    public final CipherSuite a() {
        return this.f144076b;
    }

    public final List c() {
        return this.f144077c;
    }

    public final List d() {
        return (List) this.f144078d.getValue();
    }

    public final TlsVersion e() {
        return this.f144075a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.f144075a == this.f144075a && Intrinsics.areEqual(handshake.f144076b, this.f144076b) && Intrinsics.areEqual(handshake.d(), d()) && Intrinsics.areEqual(handshake.f144077c, this.f144077c);
    }

    public int hashCode() {
        return ((((((527 + this.f144075a.hashCode()) * 31) + this.f144076b.hashCode()) * 31) + d().hashCode()) * 31) + this.f144077c.hashCode();
    }

    public String toString() {
        List listD = d();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.f144075a);
        sb.append(" cipherSuite=");
        sb.append(this.f144076b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List list = this.f144077c;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
