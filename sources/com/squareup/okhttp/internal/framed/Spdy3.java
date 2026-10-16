package com.squareup.okhttp.internal.framed;

import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Spdy3 implements Variant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f93301a;

    static {
        try {
            f93301a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.f93121c.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader a(BufferedSource bufferedSource, boolean z2) {
        return new Reader(bufferedSource, z2);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter b(BufferedSink bufferedSink, boolean z2) {
        return new Writer(bufferedSink, z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Reader implements FrameReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f93302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f93303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final NameValueBlockReader f93304c;

        Reader(BufferedSource bufferedSource, boolean z2) {
            this.f93302a = bufferedSource;
            this.f93304c = new NameValueBlockReader(bufferedSource);
            this.f93303b = z2;
        }

        private static IOException a(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        private void b(FrameReader.Handler handler, int i3, int i4) throws IOException {
            if (i4 != 8) {
                throw a("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i4));
            }
            int i5 = this.f93302a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i6 = this.f93302a.readInt();
            ErrorCode errorCodeC = ErrorCode.c(i6);
            if (errorCodeC == null) {
                throw a("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i6));
            }
            handler.D(i5, errorCodeC, ByteString.f144998f);
        }

        private void c(FrameReader.Handler handler, int i3, int i4) {
            handler.C(false, false, this.f93302a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, -1, this.f93304c.f(i4 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void f(FrameReader.Handler handler, int i3, int i4) throws IOException {
            if (i4 != 4) {
                throw a("TYPE_PING length: %d != 4", Integer.valueOf(i4));
            }
            int i5 = this.f93302a.readInt();
            handler.q(this.f93303b == ((i5 & 1) == 1), i5, 0);
        }

        private void i(FrameReader.Handler handler, int i3, int i4) throws IOException {
            if (i4 != 8) {
                throw a("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i4));
            }
            int i5 = this.f93302a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i6 = this.f93302a.readInt();
            ErrorCode errorCodeB = ErrorCode.b(i6);
            if (errorCodeB == null) {
                throw a("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i6));
            }
            handler.x(i5, errorCodeB);
        }

        private void j(FrameReader.Handler handler, int i3, int i4) throws IOException {
            int i5 = this.f93302a.readInt();
            if (i4 != (i5 * 8) + 4) {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i4), Integer.valueOf(i5));
            }
            Settings settings = new Settings();
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = this.f93302a.readInt();
                settings.l(i7 & 16777215, ((-16777216) & i7) >>> 24, this.f93302a.readInt());
            }
            handler.B((i3 & 1) != 0, settings);
        }

        private void k(FrameReader.Handler handler, int i3, int i4) {
            handler.C(false, (i3 & 1) != 0, this.f93302a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, -1, this.f93304c.f(i4 - 4), HeadersMode.SPDY_REPLY);
        }

        private void l(FrameReader.Handler handler, int i3, int i4) {
            int i5 = this.f93302a.readInt();
            int i6 = this.f93302a.readInt();
            int i7 = i5 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i8 = i6 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f93302a.readShort();
            handler.C((i3 & 2) != 0, (i3 & 1) != 0, i7, i8, this.f93304c.f(i4 - 10), HeadersMode.SPDY_SYN_STREAM);
        }

        private void m(FrameReader.Handler handler, int i3, int i4) throws IOException {
            if (i4 != 8) {
                throw a("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i4));
            }
            int i5 = this.f93302a.readInt();
            int i6 = this.f93302a.readInt();
            int i7 = i5 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j3 = i6 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (j3 == 0) {
                throw a("windowSizeIncrement was 0", Long.valueOf(j3));
            }
            handler.e(i7, j3);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f93304c.c();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean y0(FrameReader.Handler handler) throws IOException {
            try {
                int i3 = this.f93302a.readInt();
                int i4 = this.f93302a.readInt();
                int i5 = ((-16777216) & i4) >>> 24;
                int i6 = i4 & 16777215;
                if (!((Integer.MIN_VALUE & i3) != 0)) {
                    handler.z((i5 & 1) != 0, i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER, this.f93302a, i6);
                    return true;
                }
                int i7 = (2147418112 & i3) >>> 16;
                int i8 = i3 & 65535;
                if (i7 != 3) {
                    throw new ProtocolException("version != 3: " + i7);
                }
                switch (i8) {
                    case 1:
                        l(handler, i5, i6);
                        return true;
                    case 2:
                        k(handler, i5, i6);
                        return true;
                    case 3:
                        i(handler, i5, i6);
                        return true;
                    case 4:
                        j(handler, i5, i6);
                        return true;
                    case 5:
                    default:
                        this.f93302a.skip(i6);
                        return true;
                    case 6:
                        f(handler, i5, i6);
                        return true;
                    case 7:
                        b(handler, i5, i6);
                        return true;
                    case 8:
                        c(handler, i5, i6);
                        return true;
                    case 9:
                        m(handler, i5, i6);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void N0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Writer implements FrameWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSink f93305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Buffer f93306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BufferedSink f93307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f93308d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f93309f;

        Writer(BufferedSink bufferedSink, boolean z2) {
            this.f93305a = bufferedSink;
            this.f93308d = z2;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.f93301a);
            Buffer buffer = new Buffer();
            this.f93306b = buffer;
            this.f93307c = Okio.c(new DeflaterSink((Sink) buffer, deflater));
        }

        private void b(List list) {
            this.f93307c.writeInt(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ByteString byteString = ((Header) list.get(i3)).f93241a;
                this.f93307c.writeInt(byteString.C());
                this.f93307c.q2(byteString);
                ByteString byteString2 = ((Header) list.get(i3)).f93242b;
                this.f93307c.writeInt(byteString2.C());
                this.f93307c.q2(byteString2);
            }
            this.f93307c.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void E2(Settings settings) {
            try {
                if (this.f93309f) {
                    throw new IOException("closed");
                }
                int iM = settings.m();
                this.f93305a.writeInt(-2147287036);
                this.f93305a.writeInt(((iM * 8) + 4) & 16777215);
                this.f93305a.writeInt(iM);
                for (int i3 = 0; i3 <= 10; i3++) {
                    if (settings.i(i3)) {
                        this.f93305a.writeInt(((settings.b(i3) & 255) << 24) | (i3 & 16777215));
                        this.f93305a.writeInt(settings.c(i3));
                    }
                }
                this.f93305a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void Y(int i3, ErrorCode errorCode, byte[] bArr) {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            if (errorCode.f93145c == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            this.f93305a.writeInt(-2147287033);
            this.f93305a.writeInt(8);
            this.f93305a.writeInt(i3);
            this.f93305a.writeInt(errorCode.f93145c);
            this.f93305a.flush();
        }

        void a(int i3, int i4, Buffer buffer, int i5) throws IOException {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            long j3 = i5;
            if (j3 > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i5);
            }
            this.f93305a.writeInt(i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f93305a.writeInt(((i4 & 255) << 24) | (16777215 & i5));
            if (i5 > 0) {
                this.f93305a.H0(buffer, j3);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f93309f = true;
            Util.b(this.f93305a, this.f93307c);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void d0() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void e(int i3, long j3) {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            if (j3 == 0 || j3 > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j3);
            }
            this.f93305a.writeInt(-2147287031);
            this.f93305a.writeInt(8);
            this.f93305a.writeInt(i3);
            this.f93305a.writeInt((int) j3);
            this.f93305a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int f1() {
            return 16383;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            this.f93305a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void k0(boolean z2, int i3, Buffer buffer, int i4) {
            a(i3, z2 ? 1 : 0, buffer, i4);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void q(boolean z2, int i3, int i4) {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            if (z2 != (this.f93308d != ((i3 & 1) == 1))) {
                throw new IllegalArgumentException("payload != reply");
            }
            this.f93305a.writeInt(-2147287034);
            this.f93305a.writeInt(4);
            this.f93305a.writeInt(i3);
            this.f93305a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void x(int i3, ErrorCode errorCode) {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            if (errorCode.f93144b == -1) {
                throw new IllegalArgumentException();
            }
            this.f93305a.writeInt(-2147287037);
            this.f93305a.writeInt(8);
            this.f93305a.writeInt(i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f93305a.writeInt(errorCode.f93144b);
            this.f93305a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void y2(boolean z2, boolean z3, int i3, int i4, List list) {
            if (this.f93309f) {
                throw new IOException("closed");
            }
            b(list);
            int size = (int) (this.f93306b.size() + 10);
            int i5 = (z2 ? 1 : 0) | (z3 ? 2 : 0);
            this.f93305a.writeInt(-2147287039);
            this.f93305a.writeInt(((i5 & 255) << 24) | (size & 16777215));
            this.f93305a.writeInt(i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f93305a.writeInt(Integer.MAX_VALUE & i4);
            this.f93305a.writeShort(0);
            this.f93305a.K0(this.f93306b);
            this.f93305a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void d2(Settings settings) {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public void h(int i3, int i4, List list) {
        }
    }
}
