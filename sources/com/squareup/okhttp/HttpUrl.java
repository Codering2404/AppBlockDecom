package com.squareup.okhttp;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.FacebookContentProvider;
import com.revenuecat.purchases.common.Constants;
import java.io.EOFException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpUrl {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f92920j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f92923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f92924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f92925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f92926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f92927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f92928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f92929i;

    /* JADX INFO: renamed from: com.squareup.okhttp.HttpUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f92930a;

        static {
            int[] iArr = new int[Builder.ParseResult.values().length];
            f92930a = iArr;
            try {
                iArr[Builder.ParseResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f92930a[Builder.ParseResult.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f92930a[Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f92930a[Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f92930a[Builder.ParseResult.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f92931a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f92934d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List f92936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List f92937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f92938h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f92932b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f92933c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f92935e = -1;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f92936f = arrayList;
            arrayList.add("");
        }

        private static String b(String str, int i3, int i4) {
            String strW = HttpUrl.w(str, i3, i4, false);
            if (!strW.startsWith("[") || !strW.endsWith("]")) {
                return f(strW);
            }
            InetAddress inetAddressE = e(strW, 1, strW.length() - 1);
            if (inetAddressE == null) {
                return null;
            }
            byte[] address = inetAddressE.getAddress();
            if (address.length == 16) {
                return j(address);
            }
            throw new AssertionError();
        }

        private static boolean c(String str) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean d(String str, int i3, int i4, byte[] bArr, int i5) {
            int i6 = i5;
            while (i3 < i4) {
                if (i6 == bArr.length) {
                    return false;
                }
                if (i6 != i5) {
                    if (str.charAt(i3) != '.') {
                        return false;
                    }
                    i3++;
                }
                int i7 = i3;
                int i8 = 0;
                while (i7 < i4) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i8 == 0 && i3 != i7) || (i8 = ((i8 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i7++;
                }
                if (i7 - i3 == 0) {
                    return false;
                }
                bArr[i6] = (byte) i8;
                i6++;
                i3 = i7;
            }
            return i6 == i5 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
        
            if (r4 == 16) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        
            if (r5 != (-1)) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
        
            r12 = r4 - r5;
            java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
            java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
        
            return java.net.InetAddress.getByAddress(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress e(java.lang.String r12, int r13, int r14) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = 0
                r3 = -1
                r4 = r2
                r5 = r3
                r6 = r5
            L9:
                r7 = 0
                if (r13 >= r14) goto L79
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r13 + 2
                r9 = 2
                if (r8 > r14) goto L27
                java.lang.String r10 = "::"
                boolean r10 = r12.regionMatches(r13, r10, r2, r9)
                if (r10 == 0) goto L27
                if (r5 == r3) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r14) goto L25
                goto L79
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L34
                java.lang.String r8 = ":"
                r10 = 1
                boolean r8 = r12.regionMatches(r13, r8, r2, r10)
                if (r8 == 0) goto L36
                int r13 = r13 + 1
            L34:
                r6 = r13
                goto L4b
            L36:
                java.lang.String r8 = "."
                boolean r13 = r12.regionMatches(r13, r8, r2, r10)
                if (r13 == 0) goto L4a
                int r13 = r4 + (-2)
                boolean r12 = d(r12, r6, r14, r1, r13)
                if (r12 != 0) goto L47
                return r7
            L47:
                int r4 = r4 + 2
                goto L79
            L4a:
                return r7
            L4b:
                r8 = r2
                r13 = r6
            L4d:
                if (r13 >= r14) goto L60
                char r10 = r12.charAt(r13)
                int r10 = com.squareup.okhttp.HttpUrl.h(r10)
                if (r10 != r3) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r10
                int r13 = r13 + 1
                goto L4d
            L60:
                int r10 = r13 - r6
                if (r10 == 0) goto L78
                r11 = 4
                if (r10 <= r11) goto L68
                goto L78
            L68:
                int r7 = r4 + 1
                int r10 = r8 >>> 8
                r10 = r10 & 255(0xff, float:3.57E-43)
                byte r10 = (byte) r10
                r1[r4] = r10
                int r4 = r4 + r9
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L78:
                return r7
            L79:
                if (r4 == r0) goto L8a
                if (r5 != r3) goto L7e
                return r7
            L7e:
                int r12 = r4 - r5
                int r13 = 16 - r12
                java.lang.System.arraycopy(r1, r5, r1, r13, r12)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r2)
            L8a:
                java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
                return r12
            L8f:
                java.lang.AssertionError r12 = new java.lang.AssertionError
                r12.<init>()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.e(java.lang.String, int, int):java.net.InetAddress");
        }

        private static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (c(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String j(byte[] bArr) {
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i5 < bArr.length) {
                int i7 = i5;
                while (i7 < 16 && bArr[i7] == 0 && bArr[i7 + 1] == 0) {
                    i7 += 2;
                }
                int i8 = i7 - i5;
                if (i8 > i6) {
                    i3 = i5;
                    i6 = i8;
                }
                i5 = i7 + 2;
            }
            Buffer buffer = new Buffer();
            while (i4 < bArr.length) {
                if (i4 == i3) {
                    buffer.writeByte(58);
                    i4 += i6;
                    if (i4 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i4 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.e2(((bArr[i4] & 255) << 8) | (bArr[i4 + 1] & 255));
                    i4 += 2;
                }
            }
            return buffer.e0();
        }

        private boolean k(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean l(String str) {
            return str.equals(FacebookContentProvider.INVALID_FILE_NAME) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int n(String str, int i3, int i4) {
            int i5;
            try {
                i5 = Integer.parseInt(HttpUrl.e(str, i3, i4, "", false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (i5 <= 0 || i5 > 65535) {
                return -1;
            }
            return i5;
        }

        private void o() {
            if (!((String) this.f92936f.remove(r0.size() - 1)).isEmpty() || this.f92936f.isEmpty()) {
                this.f92936f.add("");
            } else {
                this.f92936f.set(r0.size() - 1, "");
            }
        }

        private static int q(String str, int i3, int i4) {
            while (i3 < i4) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == ':') {
                    return i3;
                }
                if (cCharAt == '[') {
                    do {
                        i3++;
                        if (i3 < i4) {
                        }
                    } while (str.charAt(i3) != ']');
                }
                i3++;
            }
            return i4;
        }

        private void r(String str, int i3, int i4, boolean z2, boolean z3) throws EOFException {
            String strE = HttpUrl.e(str, i3, i4, " \"<>^`{}|/\\?#", z3, false, true);
            if (k(strE)) {
                return;
            }
            if (l(strE)) {
                o();
                return;
            }
            if (((String) this.f92936f.get(r9.size() - 1)).isEmpty()) {
                this.f92936f.set(r9.size() - 1, strE);
            } else {
                this.f92936f.add(strE);
            }
            if (z2) {
                this.f92936f.add("");
            }
        }

        private void t(String str, int i3, int i4) throws EOFException {
            if (i3 == i4) {
                return;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f92936f.clear();
                this.f92936f.add("");
                i3++;
            } else {
                List list = this.f92936f;
                list.set(list.size() - 1, "");
            }
            int i5 = i3;
            while (i5 < i4) {
                int iJ = HttpUrl.j(str, i5, i4, "/\\");
                boolean z2 = iJ < i4;
                String str2 = str;
                r(str2, i5, iJ, z2, true);
                if (z2) {
                    iJ++;
                }
                i5 = iJ;
                str = str2;
            }
        }

        private static int v(String str, int i3, int i4) {
            if (i4 - i3 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i3);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i3++;
                    if (i3 >= i4) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i3;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private int w(String str, int i3, int i4) {
            while (i3 < i4) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3;
                }
                i3++;
            }
            return i4;
        }

        private int x(String str, int i3, int i4) {
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                char cCharAt = str.charAt(i5);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i5 + 1;
                }
            }
            return i3;
        }

        private static int y(String str, int i3, int i4) {
            int i5 = 0;
            while (i3 < i4) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i5++;
                i3++;
            }
            return i5;
        }

        public HttpUrl a() {
            if (this.f92931a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f92934d != null) {
                return new HttpUrl(this, null);
            }
            throw new IllegalStateException("host == null");
        }

        int g() {
            int i3 = this.f92935e;
            return i3 != -1 ? i3 : HttpUrl.i(this.f92931a);
        }

        public Builder h(String str) {
            this.f92937g = str != null ? HttpUrl.C(HttpUrl.f(str, " \"'<>#", true, true, true)) : null;
            return this;
        }

        public Builder i(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strB = b(str, 0, str.length());
            if (strB != null) {
                this.f92934d = strB;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        ParseResult m(HttpUrl httpUrl, String str) throws EOFException {
            int iJ;
            int i3;
            String str2 = str;
            int iW = w(str2, 0, str2.length());
            int iX = x(str2, iW, str2.length());
            if (v(str2, iW, iX) != -1) {
                if (str2.regionMatches(true, iW, "https:", 0, 6)) {
                    this.f92931a = "https";
                    iW += 6;
                    str2 = str;
                } else {
                    str2 = str;
                    if (!str2.regionMatches(true, iW, "http:", 0, 5)) {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                    this.f92931a = "http";
                    iW += 5;
                }
            } else {
                if (httpUrl == null) {
                    return ParseResult.MISSING_SCHEME;
                }
                this.f92931a = httpUrl.f92921a;
            }
            int iY = y(str2, iW, iX);
            if (iY >= 2 || httpUrl == null || !httpUrl.f92921a.equals(this.f92931a)) {
                int i4 = iW + iY;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    iJ = HttpUrl.j(str2, i4, iX, "@/\\?#");
                    byte bCharAt = iJ != iX ? str2.charAt(iJ) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == 35 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z2) {
                            i3 = iJ;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.f92933c);
                            sb.append("%40");
                            str2 = str;
                            sb.append(HttpUrl.e(str2, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, true));
                            this.f92933c = sb.toString();
                        } else {
                            int iJ2 = HttpUrl.j(str2, i4, iJ, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                            String strE = HttpUrl.e(str2, i4, iJ2, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                            if (z3) {
                                strE = this.f92932b + "%40" + strE;
                            }
                            this.f92932b = strE;
                            if (iJ2 != iJ) {
                                i3 = iJ;
                                this.f92933c = HttpUrl.e(str, iJ2 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                                z2 = true;
                            } else {
                                i3 = iJ;
                            }
                            str2 = str;
                            z3 = true;
                        }
                        i4 = i3 + 1;
                    }
                }
                iW = iJ;
                int iQ = q(str2, i4, iW);
                int i5 = iQ + 1;
                if (i5 < iW) {
                    this.f92934d = b(str2, i4, iQ);
                    int iN = n(str2, i5, iW);
                    this.f92935e = iN;
                    if (iN == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                } else {
                    this.f92934d = b(str2, i4, iQ);
                    this.f92935e = HttpUrl.i(this.f92931a);
                }
                if (this.f92934d == null) {
                    return ParseResult.INVALID_HOST;
                }
            } else {
                this.f92932b = httpUrl.p();
                this.f92933c = httpUrl.l();
                this.f92934d = httpUrl.f92924d;
                this.f92935e = httpUrl.f92925e;
                this.f92936f.clear();
                this.f92936f.addAll(httpUrl.n());
                if (iW == iX || str2.charAt(iW) == '#') {
                    h(httpUrl.o());
                }
            }
            int iJ3 = HttpUrl.j(str2, iW, iX, "?#");
            t(str2, iW, iJ3);
            if (iJ3 < iX && str2.charAt(iJ3) == '?') {
                int iJ4 = HttpUrl.j(str2, iJ3, iX, "#");
                this.f92937g = HttpUrl.C(HttpUrl.e(str2, iJ3 + 1, iJ4, " \"'<>#", true, true, true));
                iJ3 = iJ4;
            }
            if (iJ3 < iX && str2.charAt(iJ3) == '#') {
                this.f92938h = HttpUrl.e(str2, iJ3 + 1, iX, "", true, false, false);
            }
            return ParseResult.SUCCESS;
        }

        public Builder p(int i3) {
            if (i3 > 0 && i3 <= 65535) {
                this.f92935e = i3;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i3);
        }

        Builder s() {
            int size = this.f92936f.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f92936f.set(i3, HttpUrl.f((String) this.f92936f.get(i3), "[]", true, false, true));
            }
            List list = this.f92937g;
            if (list != null) {
                int size2 = list.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    String str = (String) this.f92937g.get(i4);
                    if (str != null) {
                        this.f92937g.set(i4, HttpUrl.f(str, "\\^`{|}", true, true, true));
                    }
                }
            }
            String str2 = this.f92938h;
            if (str2 != null) {
                this.f92938h = HttpUrl.f(str2, " \"#<>\\^`{|}", true, false, false);
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f92931a);
            sb.append("://");
            if (!this.f92932b.isEmpty() || !this.f92933c.isEmpty()) {
                sb.append(this.f92932b);
                if (!this.f92933c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f92933c);
                }
                sb.append('@');
            }
            if (this.f92934d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f92934d);
                sb.append(']');
            } else {
                sb.append(this.f92934d);
            }
            int iG = g();
            if (iG != HttpUrl.i(this.f92931a)) {
                sb.append(':');
                sb.append(iG);
            }
            HttpUrl.v(sb, this.f92936f);
            if (this.f92937g != null) {
                sb.append('?');
                HttpUrl.s(sb, this.f92937g);
            }
            if (this.f92938h != null) {
                sb.append('#');
                sb.append(this.f92938h);
            }
            return sb.toString();
        }

        public Builder u(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f92931a = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.f92931a = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }
    }

    /* synthetic */ HttpUrl(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static List C(String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 <= str.length()) {
            int iIndexOf = str.indexOf(38, i3);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i3);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i3, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i3, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i3 = iIndexOf + 1;
        }
        return arrayList;
    }

    static String e(String str, int i3, int i4, String str2, boolean z2, boolean z3, boolean z4) throws EOFException {
        int iCharCount = i3;
        while (iCharCount < i4) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && !z2) || (iCodePointAt == 43 && z3)))) {
                Buffer buffer = new Buffer();
                buffer.J0(str, i3, iCharCount);
                g(buffer, str, iCharCount, i4, str2, z2, z3, z4);
                return buffer.e0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i3, i4);
    }

    static String f(String str, String str2, boolean z2, boolean z3, boolean z4) {
        return e(str, 0, str.length(), str2, z2, z3, z4);
    }

    static void g(Buffer buffer, String str, int i3, int i4, String str2, boolean z2, boolean z3, boolean z4) throws EOFException {
        Buffer buffer2 = null;
        while (i3 < i4) {
            int iCodePointAt = str.codePointAt(i3);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.C0(z2 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && !z2))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.Y1(iCodePointAt);
                    while (!buffer2.G1()) {
                        byte b3 = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f92920j;
                        buffer.writeByte(cArr[((b3 & 255) >> 4) & 15]);
                        buffer.writeByte(cArr[b3 & Ascii.SI]);
                    }
                } else {
                    buffer.Y1(iCodePointAt);
                }
            }
            i3 += Character.charCount(iCodePointAt);
        }
    }

    static int h(char c3) {
        if (c3 >= '0' && c3 <= '9') {
            return c3 - '0';
        }
        if (c3 >= 'a' && c3 <= 'f') {
            return c3 - 'W';
        }
        if (c3 < 'A' || c3 > 'F') {
            return -1;
        }
        return c3 - '7';
    }

    public static int i(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(String str, int i3, int i4, String str2) {
        while (i3 < i4) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    static void s(StringBuilder sb, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3 += 2) {
            String str = (String) list.get(i3);
            String str2 = (String) list.get(i3 + 1);
            if (i3 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static HttpUrl u(String str) {
        Builder builder = new Builder();
        if (builder.m(null, str) == Builder.ParseResult.SUCCESS) {
            return builder.a();
        }
        return null;
    }

    static void v(StringBuilder sb, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append('/');
            sb.append((String) list.get(i3));
        }
    }

    static String w(String str, int i3, int i4, boolean z2) {
        for (int i5 = i3; i5 < i4; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                Buffer buffer = new Buffer();
                buffer.J0(str, i3, i5);
                z(buffer, str, i5, i4, z2);
                return buffer.e0();
            }
        }
        return str.substring(i3, i4);
    }

    static String x(String str, boolean z2) {
        return w(str, 0, str.length(), z2);
    }

    private List y(List list, boolean z2) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            arrayList.add(str != null ? x(str, z2) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void z(okio.Buffer r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = h(r2)
            char r3 = r6.charAt(r1)
            int r3 = h(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.Y1(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.z(okio.Buffer, java.lang.String, int, int, boolean):void");
    }

    public int A() {
        return this.f92925e;
    }

    public String B() {
        if (this.f92927g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        s(sb, this.f92927g);
        return sb.toString();
    }

    public HttpUrl D(String str) {
        Builder builder = new Builder();
        if (builder.m(this, str) == Builder.ParseResult.SUCCESS) {
            return builder.a();
        }
        return null;
    }

    public String E() {
        return this.f92921a;
    }

    public URI F() {
        try {
            return new URI(t().s().toString());
        } catch (URISyntaxException unused) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.f92929i);
        }
    }

    public URL G() {
        try {
            return new URL(this.f92929i);
        } catch (MalformedURLException e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f92929i.equals(this.f92929i);
    }

    public int hashCode() {
        return this.f92929i.hashCode();
    }

    public String k() {
        if (this.f92928h == null) {
            return null;
        }
        return this.f92929i.substring(this.f92929i.indexOf(35) + 1);
    }

    public String l() {
        if (this.f92923c.isEmpty()) {
            return "";
        }
        return this.f92929i.substring(this.f92929i.indexOf(58, this.f92921a.length() + 3) + 1, this.f92929i.indexOf(64));
    }

    public String m() {
        int iIndexOf = this.f92929i.indexOf(47, this.f92921a.length() + 3);
        String str = this.f92929i;
        return this.f92929i.substring(iIndexOf, j(str, iIndexOf, str.length(), "?#"));
    }

    public List n() {
        int iIndexOf = this.f92929i.indexOf(47, this.f92921a.length() + 3);
        String str = this.f92929i;
        int iJ = j(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iJ) {
            int i3 = iIndexOf + 1;
            int iJ2 = j(this.f92929i, i3, iJ, "/");
            arrayList.add(this.f92929i.substring(i3, iJ2));
            iIndexOf = iJ2;
        }
        return arrayList;
    }

    public String o() {
        if (this.f92927g == null) {
            return null;
        }
        int iIndexOf = this.f92929i.indexOf(63);
        int i3 = iIndexOf + 1;
        String str = this.f92929i;
        return this.f92929i.substring(i3, j(str, iIndexOf + 2, str.length(), "#"));
    }

    public String p() {
        if (this.f92922b.isEmpty()) {
            return "";
        }
        int length = this.f92921a.length() + 3;
        String str = this.f92929i;
        return this.f92929i.substring(length, j(str, length, str.length(), ":@"));
    }

    public String q() {
        return this.f92924d;
    }

    public boolean r() {
        return this.f92921a.equals("https");
    }

    public Builder t() {
        Builder builder = new Builder();
        builder.f92931a = this.f92921a;
        builder.f92932b = p();
        builder.f92933c = l();
        builder.f92934d = this.f92924d;
        builder.f92935e = this.f92925e != i(this.f92921a) ? this.f92925e : -1;
        builder.f92936f.clear();
        builder.f92936f.addAll(n());
        builder.h(o());
        builder.f92938h = k();
        return builder;
    }

    public String toString() {
        return this.f92929i;
    }

    private HttpUrl(Builder builder) {
        this.f92921a = builder.f92931a;
        this.f92922b = x(builder.f92932b, false);
        this.f92923c = x(builder.f92933c, false);
        this.f92924d = builder.f92934d;
        this.f92925e = builder.g();
        this.f92926f = y(builder.f92936f, false);
        List list = builder.f92937g;
        this.f92927g = list != null ? y(list, true) : null;
        String str = builder.f92938h;
        this.f92928h = str != null ? x(str, false) : null;
        this.f92929i = builder.toString();
    }
}
