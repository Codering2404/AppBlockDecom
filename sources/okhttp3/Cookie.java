package okhttp3;

import com.facebook.ads.AdError;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

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
public final class Cookie {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f144035j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f144036k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f144037l = Pattern.compile(sECyKyO.sLCY);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f144038m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f144039n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f144040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f144041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f144042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f144043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f144044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f144045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f144046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f144047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f144048i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f144049a = 253402300799999L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f144050b = "/";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(String str, int i3, int i4, boolean z2) {
            while (i3 < i4) {
                int i5 = i3 + 1;
                char cCharAt = str.charAt(i3);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt <= '9' && '0' <= cCharAt) || ((cCharAt <= 'z' && 'a' <= cCharAt) || ((cCharAt <= 'Z' && 'A' <= cCharAt) || cCharAt == ':'))) == (!z2)) {
                    return i3;
                }
                i3 = i5;
            }
            return i4;
        }

        private final boolean b(String str, String str2) {
            if (Intrinsics.areEqual(str, str2)) {
                return true;
            }
            return StringsKt.E(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.i(str);
        }

        private final String f(String str) {
            if (StringsKt.E(str, ".", false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strE = HostnamesKt.e(StringsKt.K0(str, "."));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        private final long g(String str, int i3, int i4) {
            int iA = a(str, i3, i4, false);
            Matcher matcher = Cookie.f144039n.matcher(str);
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int iN0 = -1;
            int i8 = -1;
            int i9 = -1;
            while (iA < i4) {
                int iA2 = a(str, iA + 1, i4, true);
                matcher.region(iA, iA2);
                if (i6 == -1 && matcher.usePattern(Cookie.f144039n).matches()) {
                    String strGroup = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
                    i6 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "matcher.group(2)");
                    i8 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(strGroup3, "matcher.group(3)");
                    i9 = Integer.parseInt(strGroup3);
                } else if (i7 == -1 && matcher.usePattern(Cookie.f144038m).matches()) {
                    String strGroup4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup4, "matcher.group(1)");
                    i7 = Integer.parseInt(strGroup4);
                } else if (iN0 == -1 && matcher.usePattern(Cookie.f144037l).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "matcher.group(1)");
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.f144037l.pattern();
                    Intrinsics.checkNotNullExpressionValue(strPattern, "MONTH_PATTERN.pattern()");
                    iN0 = StringsKt.n0(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i5 == -1 && matcher.usePattern(Cookie.f144036k).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup6);
                }
                iA = a(str, iA2 + 1, i4, false);
            }
            if (70 <= i5 && i5 < 100) {
                i5 += 1900;
            }
            if (i5 >= 0 && i5 < 70) {
                i5 += AdError.SERVER_ERROR_CODE;
            }
            if (i5 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iN0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i7 || i7 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i8 < 0 || i8 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i9 < 0 || i9 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.f144279f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i5);
            gregorianCalendar.set(2, iN0 - 1);
            gregorianCalendar.set(5, i7);
            gregorianCalendar.set(11, i6);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long h(String str) {
            try {
                long j3 = Long.parseLong(str);
                if (j3 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j3;
            } catch (NumberFormatException e3) {
                if (new Regex("-?\\d+").k(str)) {
                    return StringsKt.U(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e3;
            }
        }

        public final Cookie c(HttpUrl url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return d(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie d(long j3, HttpUrl url, String setCookie) {
            long j4;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int iR = Util.r(setCookie, ';', 0, 0, 6, null);
            int iR2 = Util.r(setCookie, '=', 0, iR, 2, null);
            Cookie cookie = null;
            if (iR2 == iR) {
                return null;
            }
            String strA0 = Util.a0(setCookie, 0, iR2, 1, null);
            if (strA0.length() == 0 || Util.y(strA0) != -1) {
                return null;
            }
            String strZ = Util.Z(setCookie, iR2 + 1, iR);
            if (Util.y(strZ) != -1) {
                return null;
            }
            int i3 = iR + 1;
            int length = setCookie.length();
            String strF = null;
            String str = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = true;
            long jH = -1;
            long jG = 253402300799999L;
            while (i3 < length) {
                int iP = Util.p(setCookie, ';', i3, length);
                int iP2 = Util.p(setCookie, '=', i3, iP);
                String strZ2 = Util.Z(setCookie, i3, iP2);
                String strZ3 = iP2 < iP ? Util.Z(setCookie, iP2 + 1, iP) : "";
                Cookie cookie2 = cookie;
                if (StringsKt.F(strZ2, "expires", true)) {
                    try {
                        jG = g(strZ3, 0, strZ3.length());
                        z3 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (StringsKt.F(strZ2, "max-age", true)) {
                    jH = h(strZ3);
                    z3 = true;
                } else if (StringsKt.F(strZ2, "domain", true)) {
                    strF = f(strZ3);
                    z5 = false;
                } else if (StringsKt.F(strZ2, "path", true)) {
                    str = strZ3;
                } else if (StringsKt.F(strZ2, "secure", true)) {
                    z4 = true;
                } else if (StringsKt.F(strZ2, "httponly", true)) {
                    z2 = true;
                }
                i3 = iP + 1;
                cookie = cookie2;
            }
            Cookie cookie3 = cookie;
            if (jH == Long.MIN_VALUE) {
                j4 = Long.MIN_VALUE;
            } else if (jH != -1) {
                long j5 = j3 + (jH <= 9223372036854775L ? jH * ((long) 1000) : Long.MAX_VALUE);
                j4 = (j5 < j3 || j5 > 253402300799999L) ? 253402300799999L : j5;
            } else {
                j4 = jG;
            }
            String strI = url.i();
            if (strF == null) {
                strF = strI;
            } else if (!b(strI, strF)) {
                return cookie3;
            }
            if (strI.length() != strF.length() && PublicSuffixDatabase.f144851e.c().c(strF) == null) {
                return cookie3;
            }
            String strSubstring = "/";
            if (str == null || !StringsKt.U(str, "/", false, 2, cookie3)) {
                String strD = url.d();
                int iT0 = StringsKt.t0(strD, '/', 0, false, 6, null);
                if (iT0 != 0) {
                    strSubstring = strD.substring(0, iT0);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str = strSubstring;
            }
            return new Cookie(strA0, strZ, j4, strF, str, z4, z2, z3, z5, null);
        }

        public final List e(HttpUrl url, Headers headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List listL = headers.l("Set-Cookie");
            int size = listL.size();
            ArrayList arrayList = null;
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                Cookie cookieC = c(url, (String) listL.get(i3));
                if (cookieC != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookieC);
                }
                i3 = i4;
            }
            if (arrayList == null) {
                return CollectionsKt.emptyList();
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j3, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, str3, str4, z2, z3, z4, z5);
    }

    public final String e() {
        return this.f144043d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual(cookie.f144040a, this.f144040a) && Intrinsics.areEqual(cookie.f144041b, this.f144041b) && cookie.f144042c == this.f144042c && Intrinsics.areEqual(cookie.f144043d, this.f144043d) && Intrinsics.areEqual(cookie.f144044e, this.f144044e) && cookie.f144045f == this.f144045f && cookie.f144046g == this.f144046g && cookie.f144047h == this.f144047h && cookie.f144048i == this.f144048i;
    }

    public final long f() {
        return this.f144042c;
    }

    public final boolean g() {
        return this.f144048i;
    }

    public final boolean h() {
        return this.f144046g;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f144040a.hashCode()) * 31) + this.f144041b.hashCode()) * 31) + Long.hashCode(this.f144042c)) * 31) + this.f144043d.hashCode()) * 31) + this.f144044e.hashCode()) * 31) + Boolean.hashCode(this.f144045f)) * 31) + Boolean.hashCode(this.f144046g)) * 31) + Boolean.hashCode(this.f144047h)) * 31) + Boolean.hashCode(this.f144048i);
    }

    public final String i() {
        return this.f144040a;
    }

    public final String j() {
        return this.f144044e;
    }

    public final boolean k() {
        return this.f144047h;
    }

    public final boolean l() {
        return this.f144045f;
    }

    public final String m(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i());
        sb.append('=');
        sb.append(n());
        if (k()) {
            if (f() == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.b(new Date(f())));
            }
        }
        if (!g()) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(e());
        }
        sb.append("; path=");
        sb.append(j());
        if (l()) {
            sb.append("; secure");
        }
        if (h()) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }

    public final String n() {
        return this.f144041b;
    }

    public String toString() {
        return m(false);
    }

    private Cookie(String str, String str2, long j3, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f144040a = str;
        this.f144041b = str2;
        this.f144042c = j3;
        this.f144043d = str3;
        this.f144044e = str4;
        this.f144045f = z2;
        this.f144046g = z3;
        this.f144047h = z4;
        this.f144048i = z5;
    }
}
