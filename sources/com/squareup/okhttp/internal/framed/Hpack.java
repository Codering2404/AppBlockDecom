package com.squareup.okhttp.internal.framed;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
final class Hpack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Header[] f93249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f93250b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Reader {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSource f93252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f93253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f93254d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f93256f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f93251a = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Header[] f93255e = new Header[8];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f93257g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f93258h = 0;

        Reader(int i3, Source source) {
            this.f93256f = r0.length - 1;
            this.f93253c = i3;
            this.f93254d = i3;
            this.f93252b = Okio.d(source);
        }

        private void a() {
            int i3 = this.f93254d;
            int i4 = this.f93258h;
            if (i3 < i4) {
                if (i3 == 0) {
                    b();
                } else {
                    d(i4 - i3);
                }
            }
        }

        private void b() {
            this.f93251a.clear();
            Arrays.fill(this.f93255e, (Object) null);
            this.f93256f = this.f93255e.length - 1;
            this.f93257g = 0;
            this.f93258h = 0;
        }

        private int c(int i3) {
            return this.f93256f + 1 + i3;
        }

        private int d(int i3) {
            int i4;
            int i5 = 0;
            if (i3 > 0) {
                int length = this.f93255e.length;
                while (true) {
                    length--;
                    i4 = this.f93256f;
                    if (length < i4 || i3 <= 0) {
                        break;
                    }
                    int i6 = this.f93255e[length].f93243c;
                    i3 -= i6;
                    this.f93258h -= i6;
                    this.f93257g--;
                    i5++;
                }
                Header[] headerArr = this.f93255e;
                System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i5, this.f93257g);
                this.f93256f += i5;
            }
            return i5;
        }

        private ByteString f(int i3) {
            return i(i3) ? Hpack.f93249a[i3].f93241a : this.f93255e[c(i3 - Hpack.f93249a.length)].f93241a;
        }

        private void h(int i3, Header header) {
            this.f93251a.add(header);
            int i4 = header.f93243c;
            if (i3 != -1) {
                i4 -= this.f93255e[c(i3)].f93243c;
            }
            int i5 = this.f93254d;
            if (i4 > i5) {
                b();
                return;
            }
            int iD = d((this.f93258h + i4) - i5);
            if (i3 == -1) {
                int i6 = this.f93257g + 1;
                Header[] headerArr = this.f93255e;
                if (i6 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f93256f = this.f93255e.length - 1;
                    this.f93255e = headerArr2;
                }
                int i7 = this.f93256f;
                this.f93256f = i7 - 1;
                this.f93255e[i7] = header;
                this.f93257g++;
            } else {
                this.f93255e[i3 + c(i3) + iD] = header;
            }
            this.f93258h += i4;
        }

        private boolean i(int i3) {
            return i3 >= 0 && i3 <= Hpack.f93249a.length - 1;
        }

        private int j() {
            return this.f93252b.readByte() & 255;
        }

        private void m(int i3) throws IOException {
            if (i(i3)) {
                this.f93251a.add(Hpack.f93249a[i3]);
                return;
            }
            int iC = c(i3 - Hpack.f93249a.length);
            if (iC >= 0) {
                Header[] headerArr = this.f93255e;
                if (iC <= headerArr.length - 1) {
                    this.f93251a.add(headerArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i3 + 1));
        }

        private void o(int i3) {
            h(-1, new Header(f(i3), k()));
        }

        private void p() {
            h(-1, new Header(Hpack.d(k()), k()));
        }

        private void q(int i3) {
            this.f93251a.add(new Header(f(i3), k()));
        }

        private void r() throws IOException {
            this.f93251a.add(new Header(Hpack.d(k()), k()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f93251a);
            this.f93251a.clear();
            return arrayList;
        }

        void g(int i3) {
            this.f93253c = i3;
            this.f93254d = i3;
            a();
        }

        ByteString k() {
            int iJ = j();
            boolean z2 = (iJ & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128;
            int iN = n(iJ, 127);
            return z2 ? ByteString.v(Huffman.d().c(this.f93252b.S0(iN))) : this.f93252b.q1(iN);
        }

        void l() throws IOException {
            while (!this.f93252b.G1()) {
                byte b3 = this.f93252b.readByte();
                int i3 = b3 & 255;
                if (i3 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b3 & 128) == 128) {
                    m(n(i3, 127) - 1);
                } else if (i3 == 64) {
                    p();
                } else if ((b3 & 64) == 64) {
                    o(n(i3, 63) - 1);
                } else if ((b3 & 32) == 32) {
                    int iN = n(i3, 31);
                    this.f93254d = iN;
                    if (iN < 0 || iN > this.f93253c) {
                        throw new IOException("Invalid dynamic table size update " + this.f93254d);
                    }
                    a();
                } else if (i3 == 16 || i3 == 0) {
                    r();
                } else {
                    q(n(i3, 15) - 1);
                }
            }
        }

        int n(int i3, int i4) {
            int i5 = i3 & i4;
            if (i5 < i4) {
                return i5;
            }
            int i6 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                    return i4 + (iJ << i6);
                }
                i4 += (iJ & 127) << i6;
                i6 += 7;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f93259a;

        Writer(Buffer buffer) {
            this.f93259a = buffer;
        }

        void a(ByteString byteString) {
            c(byteString.C(), 127, 0);
            this.f93259a.q2(byteString);
        }

        void b(List list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ByteString byteStringG = ((Header) list.get(i3)).f93241a.G();
                Integer num = (Integer) Hpack.f93250b.get(byteStringG);
                if (num != null) {
                    c(num.intValue() + 1, 15, 0);
                    a(((Header) list.get(i3)).f93242b);
                } else {
                    this.f93259a.writeByte(0);
                    a(byteStringG);
                    a(((Header) list.get(i3)).f93242b);
                }
            }
        }

        void c(int i3, int i4, int i5) {
            if (i3 < i4) {
                this.f93259a.writeByte(i3 | i5);
                return;
            }
            this.f93259a.writeByte(i5 | i4);
            int i6 = i3 - i4;
            while (i6 >= 128) {
                this.f93259a.writeByte(128 | (i6 & 127));
                i6 >>>= 7;
            }
            this.f93259a.writeByte(i6);
        }
    }

    static {
        Header header = new Header(Header.f93238h, "");
        ByteString byteString = Header.f93235e;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.f93236f;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.f93237g;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.f93234d;
        f93249a = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(DiagnosticsTracker.HOST_KEY, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f93250b = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString d(ByteString byteString) throws IOException {
        int iC = byteString.C();
        for (int i3 = 0; i3 < iC; i3++) {
            byte bG = byteString.g(i3);
            if (bG >= 65 && bG <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.I());
            }
        }
        return byteString;
    }

    private static Map e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f93249a.length);
        int i3 = 0;
        while (true) {
            Header[] headerArr = f93249a;
            if (i3 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i3].f93241a)) {
                linkedHashMap.put(headerArr[i3].f93241a, Integer.valueOf(i3));
            }
            i3++;
        }
    }
}
