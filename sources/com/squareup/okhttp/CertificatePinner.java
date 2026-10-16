package com.squareup.okhttp;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.common.Constants;
import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class CertificatePinner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CertificatePinner f92833b = new Builder().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f92834a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f92835a = new LinkedHashMap();

        public CertificatePinner b() {
            return new CertificatePinner(this);
        }
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha1/" + d((X509Certificate) certificate).a();
    }

    private static ByteString d(X509Certificate x509Certificate) {
        return Util.q(ByteString.v(x509Certificate.getPublicKey().getEncoded()));
    }

    Set b(String str) {
        Set set;
        Set set2 = (Set) this.f92834a.get(str);
        int iIndexOf = str.indexOf(46);
        if (iIndexOf != str.lastIndexOf(46)) {
            set = (Set) this.f92834a.get("*." + str.substring(iIndexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 == null || set == null) {
            return set2 != null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set2);
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }

    private CertificatePinner(Builder builder) {
        this.f92834a = Util.l(builder.f92835a);
    }

    public void a(String str, List list) throws SSLPeerUnverifiedException {
        Set<ByteString> setB = b(str);
        if (setB != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (setB.contains(d((X509Certificate) list.get(i3)))) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i4 = 0; i4 < size2; i4++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i4);
                sb.append(YznnJpHcAmeoW.MVNTb);
                sb.append(c(x509Certificate));
                sb.append(": ");
                sb.append(x509Certificate.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            for (ByteString byteString : setB) {
                sb.append("\n    sha1/");
                sb.append(byteString.a());
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }
}
