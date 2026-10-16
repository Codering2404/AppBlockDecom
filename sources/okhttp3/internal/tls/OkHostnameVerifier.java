package okhttp3.internal.tls;

import com.facebook.FacebookContentProvider;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;

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
public final class OkHostnameVerifier implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHostnameVerifier f144863a = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List c(X509Certificate x509Certificate, int i3) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i3)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt.emptyList();
        }
    }

    private final boolean d(String str) {
        return str.length() == ((int) Utf8.b(str, 0, 0, 3, null));
    }

    private final boolean f(String str, String str2) {
        if (str != null && str.length() != 0 && !StringsKt.U(str, ".", false, 2, null) && !StringsKt.E(str, FacebookContentProvider.INVALID_FILE_NAME, false, 2, null) && str2 != null && str2.length() != 0 && !StringsKt.U(str2, ".", false, 2, null) && !StringsKt.E(str2, FacebookContentProvider.INVALID_FILE_NAME, false, 2, null)) {
            if (!StringsKt.E(str, ".", false, 2, null)) {
                str = Intrinsics.stringPlus(str, ".");
            }
            String str3 = str;
            if (!StringsKt.E(str2, ".", false, 2, null)) {
                str2 = Intrinsics.stringPlus(str2, ".");
            }
            String strB = b(str2);
            if (!StringsKt.a0(strB, "*", false, 2, null)) {
                return Intrinsics.areEqual(str3, strB);
            }
            if (!StringsKt.U(strB, "*.", false, 2, null) || StringsKt.m0(strB, '*', 1, false, 4, null) != -1 || str3.length() < strB.length() || Intrinsics.areEqual("*.", strB)) {
                return false;
            }
            String strSubstring = strB.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!StringsKt.E(str3, strSubstring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - strSubstring.length();
            return length <= 0 || StringsKt.t0(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    private final boolean g(String str, X509Certificate x509Certificate) {
        String strB = b(str);
        List listC = c(x509Certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (f144863a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String str, X509Certificate x509Certificate) {
        String strE = HostnamesKt.e(str);
        List listC = c(x509Certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(strE, HostnamesKt.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List a(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) c(certificate, 7), (Iterable) c(certificate, 2));
    }

    public final boolean e(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return Util.i(host) ? h(host, certificate) : g(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (!d(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return e(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
