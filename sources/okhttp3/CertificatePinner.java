package okhttp3;

import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

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
public final class CertificatePinner {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f143935c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CertificatePinner f143936d = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f143937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CertificateChainCleaner f143938b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f143939a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner a() {
            return new CertificatePinner(CollectionsKt.toSet(this.f143939a), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return Intrinsics.stringPlus("sha256/", c((X509Certificate) certificate).a());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }

        public final ByteString b(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f144997d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, null).A();
        }

        public final ByteString c(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.f144997d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
            return ByteString.Companion.g(companion, encoded, 0, 0, 3, null).B();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Pin {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f143940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f143941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ByteString f143942c;

        public final ByteString a() {
            return this.f143942c;
        }

        public final String b() {
            return this.f143941b;
        }

        public final boolean c(String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (StringsKt.U(this.f143940a, "**.", false, 2, null)) {
                int length = this.f143940a.length() - 3;
                int length2 = hostname.length() - length;
                return StringsKt.J(hostname, hostname.length() - length, this.f143940a, 3, length, false, 16, null) && (length2 == 0 || hostname.charAt(length2 - 1) == '.');
            }
            if (!StringsKt.U(this.f143940a, "*.", false, 2, null)) {
                return Intrinsics.areEqual(hostname, this.f143940a);
            }
            int length3 = this.f143940a.length() - 1;
            return StringsKt.J(hostname, hostname.length() - length3, this.f143940a, 1, length3, false, 16, null) && StringsKt.t0(hostname, '.', (hostname.length() - length3) + (-1), false, 4, null) == -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return Intrinsics.areEqual(this.f143940a, pin.f143940a) && Intrinsics.areEqual(this.f143941b, pin.f143941b) && Intrinsics.areEqual(this.f143942c, pin.f143942c);
        }

        public int hashCode() {
            return (((this.f143940a.hashCode() * 31) + this.f143941b.hashCode()) * 31) + this.f143942c.hashCode();
        }

        public String toString() {
            return this.f143941b + '/' + this.f143942c.a();
        }
    }

    public CertificatePinner(Set pins, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.f143937a = pins;
        this.f143938b = certificateChainCleaner;
    }

    public final void a(final String hostname, final List peerCertificates) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        b(hostname, new Function0<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                CertificateChainCleaner certificateChainCleanerD = this.f143943a.d();
                List listA = certificateChainCleanerD == null ? null : certificateChainCleanerD.a(peerCertificates, hostname);
                if (listA == null) {
                    listA = peerCertificates;
                }
                List list = listA;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((X509Certificate) ((Certificate) it.next()));
                }
                return arrayList;
            }
        });
    }

    public final void b(String hostname, Function0 cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> listC = c(hostname);
        if (listC.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : list) {
            ByteString byteStringC = null;
            ByteString byteStringB = null;
            for (Pin pin : listC) {
                String strB = pin.b();
                if (Intrinsics.areEqual(strB, SigningManager.POST_PARAMS_ALGORITHM)) {
                    if (byteStringC == null) {
                        byteStringC = f143935c.c(x509Certificate);
                    }
                    if (Intrinsics.areEqual(pin.a(), byteStringC)) {
                        return;
                    }
                } else {
                    if (!Intrinsics.areEqual(strB, "sha1")) {
                        throw new AssertionError(Intrinsics.stringPlus("unsupported hashAlgorithm: ", pin.b()));
                    }
                    if (byteStringB == null) {
                        byteStringB = f143935c.b(x509Certificate);
                    }
                    if (Intrinsics.areEqual(pin.a(), byteStringB)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(f143935c.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        for (Pin pin2 : listC) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List c(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Set set = this.f143937a;
        List listEmptyList = CollectionsKt.emptyList();
        for (Object obj : set) {
            if (((Pin) obj).c(hostname)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                TypeIntrinsics.c(listEmptyList).add(obj);
            }
        }
        return listEmptyList;
    }

    public final CertificateChainCleaner d() {
        return this.f143938b;
    }

    public final CertificatePinner e(CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics.areEqual(this.f143938b, certificateChainCleaner) ? this : new CertificatePinner(this.f143937a, certificateChainCleaner);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Intrinsics.areEqual(certificatePinner.f143937a, this.f143937a) && Intrinsics.areEqual(certificatePinner.f143938b, this.f143938b);
    }

    public int hashCode() {
        int iHashCode = (1517 + this.f143937a.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.f143938b;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i3 & 2) != 0 ? null : certificateChainCleaner);
    }
}
