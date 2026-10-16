package okhttp3.internal.http2;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

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
public final class Hpack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hpack f144595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Header[] f144596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f144597c;

    private Hpack() {
    }

    private final Map d() {
        Header[] headerArr = f144596b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            Header[] headerArr2 = f144596b;
            if (!linkedHashMap.containsKey(headerArr2[i3].f144592a)) {
                linkedHashMap.put(headerArr2[i3].f144592a, Integer.valueOf(i3));
            }
            i3 = i4;
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final ByteString a(ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int iC = name.C();
        int i3 = 0;
        while (i3 < iC) {
            int i4 = i3 + 1;
            byte bG = name.g(i3);
            if (65 <= bG && bG <= 90) {
                throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR response malformed: mixed case name: ", name.I()));
            }
            i3 = i4;
        }
        return name;
    }

    public final Map b() {
        return f144597c;
    }

    public final Header[] c() {
        return f144596b;
    }

    static {
        Hpack hpack = new Hpack();
        f144595a = hpack;
        Header header = new Header(Header.f144591j, "");
        ByteString byteString = Header.f144588g;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.f144589h;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.f144590i;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.f144587f;
        f144596b = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(DiagnosticsTracker.HOST_KEY, ""), new Header(rnFwbPAQmQTnL.ezKpBtoMlWqboM, ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f144597c = hpack.d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f144598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f144599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final BufferedSource f144601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Header[] f144602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f144603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f144604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f144605h;

        public Reader(Source source, int i3, int i4) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f144598a = i3;
            this.f144599b = i4;
            this.f144600c = new ArrayList();
            this.f144601d = Okio.d(source);
            this.f144602e = new Header[8];
            this.f144603f = r2.length - 1;
        }

        private final void a() {
            int i3 = this.f144599b;
            int i4 = this.f144605h;
            if (i3 < i4) {
                if (i3 == 0) {
                    b();
                } else {
                    d(i4 - i3);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.f144602e, (Object) null, 0, 0, 6, (Object) null);
            this.f144603f = this.f144602e.length - 1;
            this.f144604g = 0;
            this.f144605h = 0;
        }

        private final int c(int i3) {
            return this.f144603f + 1 + i3;
        }

        private final int d(int i3) {
            int i4;
            int i5 = 0;
            if (i3 > 0) {
                int length = this.f144602e.length;
                while (true) {
                    length--;
                    i4 = this.f144603f;
                    if (length < i4 || i3 <= 0) {
                        break;
                    }
                    Header header = this.f144602e[length];
                    Intrinsics.checkNotNull(header);
                    int i6 = header.f144594c;
                    i3 -= i6;
                    this.f144605h -= i6;
                    this.f144604g--;
                    i5++;
                }
                Header[] headerArr = this.f144602e;
                System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i5, this.f144604g);
                this.f144603f += i5;
            }
            return i5;
        }

        private final ByteString f(int i3) throws IOException {
            if (h(i3)) {
                return Hpack.f144595a.c()[i3].f144592a;
            }
            int iC = c(i3 - Hpack.f144595a.c().length);
            if (iC >= 0) {
                Header[] headerArr = this.f144602e;
                if (iC < headerArr.length) {
                    Header header = headerArr[iC];
                    Intrinsics.checkNotNull(header);
                    return header.f144592a;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(i3 + 1)));
        }

        private final void g(int i3, Header header) {
            this.f144600c.add(header);
            int i4 = header.f144594c;
            if (i3 != -1) {
                Header header2 = this.f144602e[c(i3)];
                Intrinsics.checkNotNull(header2);
                i4 -= header2.f144594c;
            }
            int i5 = this.f144599b;
            if (i4 > i5) {
                b();
                return;
            }
            int iD = d((this.f144605h + i4) - i5);
            if (i3 == -1) {
                int i6 = this.f144604g + 1;
                Header[] headerArr = this.f144602e;
                if (i6 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f144603f = this.f144602e.length - 1;
                    this.f144602e = headerArr2;
                }
                int i7 = this.f144603f;
                this.f144603f = i7 - 1;
                this.f144602e[i7] = header;
                this.f144604g++;
            } else {
                this.f144602e[i3 + c(i3) + iD] = header;
            }
            this.f144605h += i4;
        }

        private final boolean h(int i3) {
            return i3 >= 0 && i3 <= Hpack.f144595a.c().length - 1;
        }

        private final int i() {
            return Util.d(this.f144601d.readByte(), 255);
        }

        private final void l(int i3) throws IOException {
            if (h(i3)) {
                this.f144600c.add(Hpack.f144595a.c()[i3]);
                return;
            }
            int iC = c(i3 - Hpack.f144595a.c().length);
            if (iC >= 0) {
                Header[] headerArr = this.f144602e;
                if (iC < headerArr.length) {
                    List list = this.f144600c;
                    Header header = headerArr[iC];
                    Intrinsics.checkNotNull(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(i3 + 1)));
        }

        private final void n(int i3) {
            g(-1, new Header(f(i3), j()));
        }

        private final void o() {
            g(-1, new Header(Hpack.f144595a.a(j()), j()));
        }

        private final void p(int i3) throws IOException {
            this.f144600c.add(new Header(f(i3), j()));
        }

        private final void q() throws IOException {
            this.f144600c.add(new Header(Hpack.f144595a.a(j()), j()));
        }

        public final List e() {
            List list = CollectionsKt.toList(this.f144600c);
            this.f144600c.clear();
            return list;
        }

        public final ByteString j() {
            int i3 = i();
            boolean z2 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128;
            long jM = m(i3, 127);
            if (!z2) {
                return this.f144601d.q1(jM);
            }
            Buffer buffer = new Buffer();
            Huffman.f144773a.b(this.f144601d, jM, buffer);
            return buffer.M();
        }

        public final void k() throws IOException {
            while (!this.f144601d.G1()) {
                int iD = Util.d(this.f144601d.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
                    l(m(iD, 127) - 1);
                } else if (iD == 64) {
                    o();
                } else if ((iD & 64) == 64) {
                    n(m(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iM = m(iD, 31);
                    this.f144599b = iM;
                    if (iM < 0 || iM > this.f144598a) {
                        throw new IOException(Intrinsics.stringPlus("Invalid dynamic table size update ", Integer.valueOf(this.f144599b)));
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    q();
                } else {
                    p(m(iD, 15) - 1);
                }
            }
        }

        public final int m(int i3, int i4) {
            int i5 = i3 & i4;
            if (i5 < i4) {
                return i5;
            }
            int i6 = 0;
            while (true) {
                int i7 = i();
                if ((i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                    return i4 + (i7 << i6);
                }
                i4 += (i7 & 127) << i6;
                i6 += 7;
            }
        }

        public /* synthetic */ Reader(Source source, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i3, (i5 & 4) != 0 ? i3 : i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f144606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f144607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Buffer f144608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f144609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f144610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f144611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Header[] f144612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f144613h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f144614i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f144615j;

        public Writer(int i3, boolean z2, Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.f144606a = i3;
            this.f144607b = z2;
            this.f144608c = out;
            this.f144609d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f144611f = i3;
            this.f144612g = new Header[8];
            this.f144613h = r2.length - 1;
        }

        private final void a() {
            int i3 = this.f144611f;
            int i4 = this.f144615j;
            if (i3 < i4) {
                if (i3 == 0) {
                    b();
                } else {
                    c(i4 - i3);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.f144612g, (Object) null, 0, 0, 6, (Object) null);
            this.f144613h = this.f144612g.length - 1;
            this.f144614i = 0;
            this.f144615j = 0;
        }

        private final int c(int i3) {
            int i4;
            int i5 = 0;
            if (i3 > 0) {
                int length = this.f144612g.length;
                while (true) {
                    length--;
                    i4 = this.f144613h;
                    if (length < i4 || i3 <= 0) {
                        break;
                    }
                    Header header = this.f144612g[length];
                    Intrinsics.checkNotNull(header);
                    i3 -= header.f144594c;
                    int i6 = this.f144615j;
                    Header header2 = this.f144612g[length];
                    Intrinsics.checkNotNull(header2);
                    this.f144615j = i6 - header2.f144594c;
                    this.f144614i--;
                    i5++;
                }
                Header[] headerArr = this.f144612g;
                System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i5, this.f144614i);
                Header[] headerArr2 = this.f144612g;
                int i7 = this.f144613h;
                Arrays.fill(headerArr2, i7 + 1, i7 + 1 + i5, (Object) null);
                this.f144613h += i5;
            }
            return i5;
        }

        private final void d(Header header) {
            int i3 = header.f144594c;
            int i4 = this.f144611f;
            if (i3 > i4) {
                b();
                return;
            }
            c((this.f144615j + i3) - i4);
            int i5 = this.f144614i + 1;
            Header[] headerArr = this.f144612g;
            if (i5 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f144613h = this.f144612g.length - 1;
                this.f144612g = headerArr2;
            }
            int i6 = this.f144613h;
            this.f144613h = i6 - 1;
            this.f144612g[i6] = header;
            this.f144614i++;
            this.f144615j += i3;
        }

        public final void e(int i3) {
            this.f144606a = i3;
            int iMin = Math.min(i3, 16384);
            int i4 = this.f144611f;
            if (i4 == iMin) {
                return;
            }
            if (iMin < i4) {
                this.f144609d = Math.min(this.f144609d, iMin);
            }
            this.f144610e = true;
            this.f144611f = iMin;
            a();
        }

        public final void f(ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.f144607b) {
                Huffman huffman = Huffman.f144773a;
                if (huffman.d(data) < data.C()) {
                    Buffer buffer = new Buffer();
                    huffman.c(data, buffer);
                    ByteString byteStringM = buffer.M();
                    h(byteStringM.C(), 127, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f144608c.q2(byteStringM);
                    return;
                }
            }
            h(data.C(), 127, 0);
            this.f144608c.q2(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void g(java.util.List r14) {
            /*
                Method dump skipped, instruction units count: 265
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.g(java.util.List):void");
        }

        public final void h(int i3, int i4, int i5) {
            if (i3 < i4) {
                this.f144608c.writeByte(i3 | i5);
                return;
            }
            this.f144608c.writeByte(i5 | i4);
            int i6 = i3 - i4;
            while (i6 >= 128) {
                this.f144608c.writeByte(128 | (i6 & 127));
                i6 >>>= 7;
            }
            this.f144608c.writeByte(i6);
        }

        public /* synthetic */ Writer(int i3, boolean z2, Buffer buffer, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 4096 : i3, (i4 & 2) != 0 ? true : z2, buffer);
        }
    }
}
