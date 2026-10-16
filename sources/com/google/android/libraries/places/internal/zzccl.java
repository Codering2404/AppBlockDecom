package com.google.android.libraries.places.internal;

import com.facebook.FacebookContentProvider;
import com.google.common.base.Ascii;
import com.google.common.base.Utf8;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccl implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzccl f77563a = new zzccl();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f77564b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private zzccl() {
    }

    private static List a(X509Certificate x509Certificate, int i3) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i3 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    private static final boolean b(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith(FacebookContentProvider.INVALID_FILE_NAME) && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith(FacebookContentProvider.INVALID_FILE_NAME)) {
            if (!str.endsWith(".")) {
                str = str.concat(".");
            }
            if (!str2.endsWith(".")) {
                str2 = str2.concat(".");
            }
            String strE = Ascii.e(str2);
            if (!strE.contains("*")) {
                return str.equals(strE);
            }
            if (!strE.startsWith("*.") || strE.indexOf(42, 1) != -1 || str.length() < strE.length() || "*.".equals(strE)) {
                return false;
            }
            String strSubstring = strE.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length + (-1)) == -1;
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        String strA;
        if (Utf8.a(str) == str.length()) {
            try {
                X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
                if (f77564b.matcher(str).matches()) {
                    List listA = a(x509Certificate, 7);
                    int size = listA.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (str.equalsIgnoreCase((String) listA.get(i3))) {
                            return true;
                        }
                    }
                    return false;
                }
                String strE = Ascii.e(str);
                List listA2 = a(x509Certificate, 2);
                int size2 = listA2.size();
                int i4 = 0;
                boolean z2 = false;
                while (i4 < size2) {
                    if (b(strE, (String) listA2.get(i4))) {
                        return true;
                    }
                    i4++;
                    z2 = true;
                }
                if (!z2 && (strA = new zzcci(x509Certificate.getSubjectX500Principal()).a("cn")) != null) {
                    return b(strE, strA);
                }
            } catch (SSLException unused) {
            }
        }
        return false;
    }
}
