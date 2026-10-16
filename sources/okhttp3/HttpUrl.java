package okhttp3;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.FacebookContentProvider;
import com.facebook.share.HKJ.pnxuebdT;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Buffer;

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
public final class HttpUrl {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f144085k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f144086l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f144087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f144088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f144089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f144090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f144091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f144092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f144093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f144094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f144095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f144096j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Companion f144097i = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f144098a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f144101d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f144103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List f144104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f144105h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f144099b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f144100c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f144102e = -1;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String str, int i3, int i4) {
                int i5;
                try {
                    i5 = Integer.parseInt(Companion.b(HttpUrl.f144085k, str, i3, i4, "", false, false, false, false, null, 248, null));
                } catch (NumberFormatException unused) {
                }
                if (1 > i5 || i5 >= 65536) {
                    return -1;
                }
                return i5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String str, int i3, int i4) {
                while (i3 < i4) {
                    char cCharAt = str.charAt(i3);
                    if (cCharAt == '[') {
                        do {
                            i3++;
                            if (i3 < i4) {
                            }
                        } while (str.charAt(i3) != ']');
                    } else if (cCharAt == ':') {
                        return i3;
                    }
                    i3++;
                }
                return i4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String str, int i3, int i4) {
                if (i4 - i3 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i3);
                if ((Intrinsics.compare((int) cCharAt, 97) >= 0 && Intrinsics.compare((int) cCharAt, 122) <= 0) || (Intrinsics.compare((int) cCharAt, 65) >= 0 && Intrinsics.compare((int) cCharAt, 90) <= 0)) {
                    int i5 = i3 + 1;
                    while (true) {
                        if (i5 >= i4) {
                            break;
                        }
                        int i6 = i5 + 1;
                        char cCharAt2 = str.charAt(i5);
                        if (('a' <= cCharAt2 && cCharAt2 < '{') || (('A' <= cCharAt2 && cCharAt2 < '[') || (('0' <= cCharAt2 && cCharAt2 < ':') || cCharAt2 == '+' || cCharAt2 == '-' || cCharAt2 == '.'))) {
                            i5 = i6;
                        } else if (cCharAt2 == ':') {
                            return i5;
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i3, int i4) {
                int i5 = 0;
                while (i3 < i4) {
                    int i6 = i3 + 1;
                    char cCharAt = str.charAt(i3);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i5++;
                    i3 = i6;
                }
                return i5;
            }

            private Companion() {
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f144103f = arrayList;
            arrayList.add("");
        }

        private final int d() {
            int i3 = this.f144102e;
            if (i3 != -1) {
                return i3;
            }
            Companion companion = HttpUrl.f144085k;
            String str = this.f144098a;
            Intrinsics.checkNotNull(str);
            return companion.c(str);
        }

        private final boolean p(String str) {
            return Intrinsics.areEqual(str, FacebookContentProvider.INVALID_FILE_NAME) || StringsKt.F(str, "%2e.", true) || StringsKt.F(str, ".%2e", true) || StringsKt.F(str, "%2e%2e", true);
        }

        private final void s() {
            if (((String) this.f144103f.remove(r0.size() - 1)).length() != 0 || this.f144103f.isEmpty()) {
                this.f144103f.add("");
            } else {
                this.f144103f.set(r0.size() - 1, "");
            }
        }

        private final void u(String str, int i3, int i4, boolean z2, boolean z3) {
            String strB = Companion.b(HttpUrl.f144085k, str, i3, i4, " \"<>^`{}|/\\?#", z3, false, false, false, null, 240, null);
            if (o(strB)) {
                return;
            }
            if (p(strB)) {
                s();
                return;
            }
            if (((CharSequence) this.f144103f.get(r14.size() - 1)).length() == 0) {
                this.f144103f.set(r14.size() - 1, strB);
            } else {
                this.f144103f.add(strB);
            }
            if (z2) {
                this.f144103f.add("");
            }
        }

        private final void w(String str, int i3, int i4) {
            if (i3 == i4) {
                return;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f144103f.clear();
                this.f144103f.add("");
                i3++;
            } else {
                List list = this.f144103f;
                list.set(list.size() - 1, "");
            }
            int i5 = i3;
            while (i5 < i4) {
                int iQ = Util.q(str, "/\\", i5, i4);
                boolean z2 = iQ < i4;
                String str2 = str;
                u(str2, i5, iQ, z2, true);
                if (z2) {
                    i5 = iQ + 1;
                    str = str2;
                } else {
                    str = str2;
                    i5 = iQ;
                }
            }
        }

        public final void A(List list) {
            this.f144104g = list;
        }

        public final void B(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f144099b = str;
        }

        public final void C(String str) {
            this.f144101d = str;
        }

        public final void D(int i3) {
            this.f144102e = i3;
        }

        public final void E(String str) {
            this.f144098a = str;
        }

        public final Builder F(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            B(Companion.b(HttpUrl.f144085k, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder a(String encodedName, String str) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (i() == null) {
                A(new ArrayList());
            }
            List listI = i();
            Intrinsics.checkNotNull(listI);
            Companion companion = HttpUrl.f144085k;
            listI.add(Companion.b(companion, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List listI2 = i();
            Intrinsics.checkNotNull(listI2);
            listI2.add(str == null ? null : Companion.b(companion, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder b(String name, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (i() == null) {
                A(new ArrayList());
            }
            List listI = i();
            Intrinsics.checkNotNull(listI);
            Companion companion = HttpUrl.f144085k;
            listI.add(Companion.b(companion, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List listI2 = i();
            Intrinsics.checkNotNull(listI2);
            listI2.add(str == null ? null : Companion.b(companion, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            return this;
        }

        public final HttpUrl c() {
            ArrayList arrayList;
            String str = this.f144098a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.f144085k;
            String strH = Companion.h(companion, this.f144099b, 0, 0, false, 7, null);
            String strH2 = Companion.h(companion, this.f144100c, 0, 0, false, 7, null);
            String str2 = this.f144101d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iD = d();
            List list = this.f144103f;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.h(HttpUrl.f144085k, (String) it.next(), 0, 0, false, 7, null));
            }
            List list2 = this.f144104g;
            if (list2 == null) {
                arrayList = null;
            } else {
                List<String> list3 = list2;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (String str3 : list3) {
                    arrayList3.add(str3 == null ? null : Companion.h(HttpUrl.f144085k, str3, 0, 0, true, 3, null));
                }
                arrayList = arrayList3;
            }
            String str4 = this.f144105h;
            return new HttpUrl(str, strH, strH2, str2, iD, arrayList2, arrayList, str4 != null ? Companion.h(HttpUrl.f144085k, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final Builder e(String str) {
            Companion companion;
            String strB;
            List listJ = null;
            if (str != null && (strB = Companion.b((companion = HttpUrl.f144085k), str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null)) != null) {
                listJ = companion.j(strB);
            }
            A(listJ);
            return this;
        }

        public final String f() {
            return this.f144105h;
        }

        public final String g() {
            return this.f144100c;
        }

        public final List h() {
            return this.f144103f;
        }

        public final List i() {
            return this.f144104g;
        }

        public final String j() {
            return this.f144099b;
        }

        public final String k() {
            return this.f144101d;
        }

        public final int l() {
            return this.f144102e;
        }

        public final String m() {
            return this.f144098a;
        }

        public final Builder n(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String strE = HostnamesKt.e(Companion.h(HttpUrl.f144085k, host, 0, 0, false, 7, null));
            if (strE == null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected host: ", host));
            }
            C(strE);
            return this;
        }

        public final Builder q(HttpUrl httpUrl, String str) {
            int iQ;
            int i3;
            String str2;
            int i4;
            String str3;
            boolean z2;
            int i5;
            int i6;
            int i7;
            char c3;
            int i8;
            String input = str;
            Intrinsics.checkNotNullParameter(input, "input");
            int iA = Util.A(input, 0, 0, 3, null);
            int iC = Util.C(input, iA, 0, 2, null);
            Companion companion = f144097i;
            int iG = companion.g(input, iA, iC);
            String str4 = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean z3 = true;
            int i9 = -1;
            if (iG != -1) {
                if (StringsKt.R(input, "https:", iA, true)) {
                    this.f144098a = "https";
                    iA += 6;
                } else {
                    if (!StringsKt.R(input, "http:", iA, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iG);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f144098a = "http";
                    iA += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Expected URL scheme 'http' or 'https' but no scheme was found for ", input.length() > 6 ? Intrinsics.stringPlus(StringsKt.B1(input, 6), "...") : input));
                }
                this.f144098a = httpUrl.r();
            }
            int iH = companion.h(input, iA, iC);
            int i10 = 63;
            int i11 = 35;
            if (iH >= 2 || httpUrl == null || !Intrinsics.areEqual(httpUrl.r(), this.f144098a)) {
                int i12 = iA + iH;
                boolean z4 = false;
                boolean z5 = false;
                while (true) {
                    iQ = Util.q(input, "@/\\?#", i12, iC);
                    int iCharAt = iQ != iC ? input.charAt(iQ) : i9;
                    if (iCharAt == i9 || iCharAt == i11 || iCharAt == 47 || iCharAt == 92 || iCharAt == i10) {
                        break;
                    }
                    if (iCharAt == 64) {
                        if (z4) {
                            i4 = iC;
                            str3 = str4;
                            z2 = z3;
                            i5 = i9;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f144100c);
                            sb2.append("%40");
                            input = str;
                            i6 = iQ;
                            sb2.append(Companion.b(HttpUrl.f144085k, input, i12, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f144100c = sb2.toString();
                        } else {
                            int iP = Util.p(input, ':', i12, iQ);
                            Companion companion2 = HttpUrl.f144085k;
                            str3 = str4;
                            i5 = i9;
                            i4 = iC;
                            z2 = z3;
                            String strB = Companion.b(companion2, input, i12, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z5) {
                                strB = this.f144099b + "%40" + strB;
                            }
                            this.f144099b = strB;
                            if (iP != iQ) {
                                i7 = iQ;
                                this.f144100c = Companion.b(companion2, str, iP + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z4 = z2;
                            } else {
                                i7 = iQ;
                            }
                            input = str;
                            i6 = i7;
                            z5 = z2;
                        }
                        i12 = i6 + 1;
                        i9 = i5;
                        iC = i4;
                        str4 = str3;
                        z3 = z2;
                        i10 = 63;
                        i11 = 35;
                    }
                }
                i3 = iC;
                String str5 = str4;
                int i13 = i9;
                Companion companion3 = f144097i;
                int iF = companion3.f(input, i12, iQ);
                int i14 = iF + 1;
                if (i14 < iQ) {
                    this.f144101d = HostnamesKt.e(Companion.h(HttpUrl.f144085k, input, i12, iF, false, 4, null));
                    int iE = companion3.e(input, i14, iQ);
                    this.f144102e = iE;
                    if (iE == i13) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i14, iQ);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, str5);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str2 = str5;
                } else {
                    str2 = str5;
                    Companion companion4 = HttpUrl.f144085k;
                    this.f144101d = HostnamesKt.e(Companion.h(companion4, input, i12, iF, false, 4, null));
                    String str6 = this.f144098a;
                    Intrinsics.checkNotNull(str6);
                    this.f144102e = companion4.c(str6);
                }
                if (this.f144101d == null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i12, iF);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, str2);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iA = iQ;
            } else {
                this.f144099b = httpUrl.g();
                this.f144100c = httpUrl.c();
                this.f144101d = httpUrl.i();
                this.f144102e = httpUrl.n();
                this.f144103f.clear();
                this.f144103f.addAll(httpUrl.e());
                if (iA == iC || input.charAt(iA) == '#') {
                    e(httpUrl.f());
                }
                i3 = iC;
            }
            int i15 = i3;
            int iQ2 = Util.q(input, "?#", iA, i15);
            w(input, iA, iQ2);
            if (iQ2 >= i15 || input.charAt(iQ2) != '?') {
                c3 = '#';
                i8 = iQ2;
            } else {
                c3 = '#';
                int iP2 = Util.p(input, '#', iQ2, i15);
                Companion companion5 = HttpUrl.f144085k;
                this.f144104g = companion5.j(Companion.b(companion5, input, iQ2 + 1, iP2, " \"'<>#", true, false, true, false, null, 208, null));
                i8 = iP2;
            }
            if (i8 < i15 && input.charAt(i8) == c3) {
                this.f144105h = Companion.b(HttpUrl.f144085k, input, i8 + 1, i15, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder r(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            z(Companion.b(HttpUrl.f144085k, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder t(int i3) {
            if (1 > i3 || i3 >= 65536) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected port: ", Integer.valueOf(i3)).toString());
            }
            D(i3);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instruction units count: 233
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder v() {
            String strK = k();
            C(strK == null ? null : new Regex("[\"<>^`{|}]").replace(strK, ""));
            int size = h().size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                h().set(i4, Companion.b(HttpUrl.f144085k, (String) h().get(i4), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List listI = i();
            if (listI != null) {
                int size2 = listI.size();
                while (i3 < size2) {
                    int i5 = i3 + 1;
                    String str = (String) listI.get(i3);
                    listI.set(i3, str == null ? null : Companion.b(HttpUrl.f144085k, str, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null));
                    i3 = i5;
                }
            }
            String strF = f();
            y(strF != null ? Companion.b(HttpUrl.f144085k, strF, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null);
            return this;
        }

        public final Builder x(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.F(scheme, "http", true)) {
                E("http");
                return this;
            }
            if (!StringsKt.F(scheme, "https", true)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected scheme: ", scheme));
            }
            E("https");
            return this;
        }

        public final void y(String str) {
            this.f144105h = str;
        }

        public final void z(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f144100c = str;
        }

        private final boolean o(String str) {
            return Intrinsics.areEqual(str, ".") || StringsKt.F(str, YgVrd.lBmpXOJFTUefN, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String b(Companion companion, String str, int i3, int i4, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i3 = 0;
            }
            if ((i5 & 2) != 0) {
                i4 = str.length();
            }
            if ((i5 & 8) != 0) {
                z2 = false;
            }
            if ((i5 & 16) != 0) {
                z3 = false;
            }
            if ((i5 & 32) != 0) {
                z4 = false;
            }
            if ((i5 & 64) != 0) {
                z5 = false;
            }
            if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                charset = null;
            }
            return companion.a(str, i3, i4, str2, z2, z3, z4, z5, charset);
        }

        private final boolean e(String str, int i3, int i4) {
            int i5 = i3 + 2;
            return i5 < i4 && str.charAt(i3) == '%' && Util.I(str.charAt(i3 + 1)) != -1 && Util.I(str.charAt(i5)) != -1;
        }

        public static /* synthetic */ String h(Companion companion, String str, int i3, int i4, boolean z2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i3 = 0;
            }
            if ((i5 & 2) != 0) {
                i4 = str.length();
            }
            if ((i5 & 4) != 0) {
                z2 = false;
            }
            return companion.g(str, i3, i4, z2);
        }

        private final void l(Buffer buffer, String str, int i3, int i4, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) throws EOFException {
            int iCharCount = i3;
            Buffer buffer2 = null;
            while (iCharCount < i4) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z4) {
                        buffer.C0(z2 ? "+" : "%2B");
                    } else {
                        if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || z5)) {
                            if (!StringsKt.Z(str2, (char) iCodePointAt, false, 2, null) && (iCodePointAt != 37 || (z2 && (!z3 || e(str, iCharCount, i4))))) {
                                buffer.Y1(iCodePointAt);
                            }
                        }
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset == null || Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                            buffer2.Y1(iCodePointAt);
                        } else {
                            buffer2.L1(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!buffer2.G1()) {
                            byte b3 = buffer2.readByte();
                            buffer.writeByte(37);
                            buffer.writeByte(HttpUrl.f144086l[((b3 & 255) >> 4) & 15]);
                            buffer.writeByte(HttpUrl.f144086l[b3 & Ascii.SI]);
                        }
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void m(Buffer buffer, String str, int i3, int i4, boolean z2) {
            int i5;
            while (i3 < i4) {
                int iCodePointAt = str.codePointAt(i3);
                if (iCodePointAt == 37 && (i5 = i3 + 2) < i4) {
                    int I = Util.I(str.charAt(i3 + 1));
                    int I2 = Util.I(str.charAt(i5));
                    if (I == -1 || I2 == -1) {
                        buffer.Y1(iCodePointAt);
                        i3 += Character.charCount(iCodePointAt);
                    } else {
                        buffer.writeByte((I << 4) + I2);
                        i3 = Character.charCount(iCodePointAt) + i5;
                    }
                } else if (iCodePointAt == 43 && z2) {
                    buffer.writeByte(32);
                    i3++;
                } else {
                    buffer.Y1(iCodePointAt);
                    i3 += Character.charCount(iCodePointAt);
                }
            }
        }

        public final String a(String str, int i3, int i4, String encodeSet, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) throws EOFException {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int iCharCount = i3;
            while (iCharCount < i4) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z5) || StringsKt.Z(encodeSet, (char) iCodePointAt, false, 2, null) || ((iCodePointAt == 37 && (!z2 || (z3 && !e(str, iCharCount, i4)))) || (iCodePointAt == 43 && z4)))) {
                    Buffer buffer = new Buffer();
                    buffer.J0(str, i3, iCharCount);
                    l(buffer, str, iCharCount, i4, encodeSet, z2, z3, z4, z5, charset);
                    return buffer.e0();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = str.substring(i3, i4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int c(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
        }

        public final HttpUrl d(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new Builder().q(null, str).c();
        }

        public final HttpUrl f(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String g(String str, int i3, int i4, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            int i5 = i3;
            while (i5 < i4) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                    Buffer buffer = new Buffer();
                    buffer.J0(str, i3, i5);
                    m(buffer, str, i5, i4, z2);
                    return buffer.e0();
                }
                i5 = i6;
            }
            String strSubstring = str.substring(i3, i4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void i(List list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                out.append('/');
                out.append((String) list.get(i3));
            }
        }

        public final List j(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 <= str.length()) {
                String str2 = str;
                int iM0 = StringsKt.m0(str2, '&', i3, false, 4, null);
                if (iM0 == -1) {
                    iM0 = str2.length();
                }
                int iM02 = StringsKt.m0(str2, '=', i3, false, 4, null);
                if (iM02 == -1 || iM02 > iM0) {
                    String strSubstring = str2.substring(i3, iM0);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str2.substring(i3, iM02);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str2.substring(iM02 + 1, iM0);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i3 = iM0 + 1;
                str = str2;
            }
            return arrayList;
        }

        public final void k(List list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, list.size()), 2);
            int iG = intProgressionZ.g();
            int iH = intProgressionZ.h();
            int iL = intProgressionZ.l();
            if ((iL <= 0 || iG > iH) && (iL >= 0 || iH > iG)) {
                return;
            }
            while (true) {
                int i3 = iG + iL;
                String str = (String) list.get(iG);
                String str2 = (String) list.get(iG + 1);
                if (iG > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (iG == iH) {
                    return;
                } else {
                    iG = i3;
                }
            }
        }

        private Companion() {
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i3, List pathSegments, List list, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f144087a = scheme;
        this.f144088b = username;
        this.f144089c = password;
        this.f144090d = host;
        this.f144091e = i3;
        this.f144092f = pathSegments;
        this.f144093g = list;
        this.f144094h = str;
        this.f144095i = url;
        this.f144096j = Intrinsics.areEqual(scheme, "https");
    }

    public static final HttpUrl h(String str) {
        return f144085k.d(str);
    }

    public final String b() {
        if (this.f144094h == null) {
            return null;
        }
        String strSubstring = this.f144095i.substring(StringsKt.m0(this.f144095i, '#', 0, false, 6, null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String c() {
        if (this.f144089c.length() == 0) {
            return "";
        }
        String strSubstring = this.f144095i.substring(StringsKt.m0(this.f144095i, ':', this.f144087a.length() + 3, false, 4, null) + 1, StringsKt.m0(this.f144095i, '@', 0, false, 6, null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String d() {
        int iM0 = StringsKt.m0(this.f144095i, '/', this.f144087a.length() + 3, false, 4, null);
        String str = this.f144095i;
        String strSubstring = this.f144095i.substring(iM0, Util.q(str, "?#", iM0, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List e() {
        int iM0 = StringsKt.m0(this.f144095i, '/', this.f144087a.length() + 3, false, 4, null);
        String str = this.f144095i;
        int iQ = Util.q(str, "?#", iM0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iM0 < iQ) {
            int i3 = iM0 + 1;
            int iP = Util.p(this.f144095i, '/', i3, iQ);
            String strSubstring = this.f144095i.substring(i3, iP);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iM0 = iP;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).f144095i, this.f144095i);
    }

    public final String f() {
        if (this.f144093g == null) {
            return null;
        }
        int iM0 = StringsKt.m0(this.f144095i, '?', 0, false, 6, null) + 1;
        String str = this.f144095i;
        String strSubstring = this.f144095i.substring(iM0, Util.p(str, '#', iM0, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        if (this.f144088b.length() == 0) {
            return "";
        }
        int length = this.f144087a.length() + 3;
        String str = this.f144095i;
        String strSubstring = this.f144095i.substring(length, Util.q(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public int hashCode() {
        return this.f144095i.hashCode();
    }

    public final String i() {
        return this.f144090d;
    }

    public final boolean j() {
        return this.f144096j;
    }

    public final Builder k() {
        Builder builder = new Builder();
        builder.E(this.f144087a);
        builder.B(g());
        builder.z(c());
        builder.C(this.f144090d);
        builder.D(this.f144091e != f144085k.c(this.f144087a) ? this.f144091e : -1);
        builder.h().clear();
        builder.h().addAll(e());
        builder.e(f());
        builder.y(b());
        return builder;
    }

    public final Builder l(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().q(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List m() {
        return this.f144092f;
    }

    public final int n() {
        return this.f144091e;
    }

    public final String o() {
        if (this.f144093g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f144085k.k(this.f144093g, sb);
        return sb.toString();
    }

    public final HttpUrl q(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder builderL = l(link);
        if (builderL == null) {
            return null;
        }
        return builderL.c();
    }

    public final String r() {
        return this.f144087a;
    }

    public final URI s() {
        String string = k().v().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e3) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNullExpressionValue(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final URL t() {
        try {
            return new URL(this.f144095i);
        } catch (MalformedURLException e3) {
            throw new RuntimeException(e3);
        }
    }

    public String toString() {
        return this.f144095i;
    }

    public final String p() {
        Builder builderL = l("/...");
        Intrinsics.checkNotNull(builderL);
        String str = pnxuebdT.lhOOgatFtaUb;
        return builderL.F(str).r(str).c().toString();
    }
}
