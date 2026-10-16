package com.google.android.datatransport.cct;

import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CCTDestination implements EncodedDestination {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f69061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f69062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f69063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f69064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CCTDestination f69065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CCTDestination f69066h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69068b;

    static {
        String strA = StringMerger.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f69061c = strA;
        String strA2 = StringMerger.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f69062d = strA2;
        String strA3 = StringMerger.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f69063e = strA3;
        f69064f = Collections.unmodifiableSet(new HashSet(Arrays.asList(Encoding.b("proto"), Encoding.b(GraphRequest.FORMAT_JSON))));
        f69065g = new CCTDestination(strA, null);
        f69066h = new CCTDestination(strA2, strA3);
    }

    public CCTDestination(String str, String str2) {
        this.f69067a = str;
        this.f69068b = str2;
    }

    public static CCTDestination c(byte[] bArr) {
        String str = new String(bArr, Charset.forName(Utf8Charset.NAME));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new CCTDestination(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public Set a() {
        return f69064f;
    }

    public byte[] b() {
        String str = this.f69068b;
        if (str == null && this.f69067a == null) {
            return null;
        }
        String str2 = this.f69067a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName(Utf8Charset.NAME));
    }

    public String d() {
        return this.f69068b;
    }

    public String e() {
        return this.f69067a;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public String getName() {
        return "cct";
    }
}
