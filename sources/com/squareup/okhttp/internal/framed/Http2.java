package com.squareup.okhttp.internal.framed;

import com.google.android.gms.common.api.Api;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.squareup.okhttp.internal.framed.FrameReader;
import com.squareup.okhttp.internal.framed.Hpack;
import com.sun.jna.Function;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Http2 implements Variant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f93260a = Logger.getLogger(FrameLogger.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ByteString f93261b = ByteString.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FrameLogger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f93268a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f93269b = new String[64];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f93270c = new String[Function.MAX_NARGS];

        static {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr = f93270c;
                if (i4 >= strArr.length) {
                    break;
                }
                strArr[i4] = String.format("%8s", Integer.toBinaryString(i4)).replace(' ', '0');
                i4++;
            }
            String[] strArr2 = f93269b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i5 = iArr[0];
            strArr2[i5 | 8] = strArr2[i5] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr2[i6];
                int i8 = iArr[0];
                String[] strArr3 = f93269b;
                int i9 = i8 | i7;
                strArr3[i9] = strArr3[i8] + '|' + strArr3[i7];
                strArr3[i9 | 8] = strArr3[i8] + '|' + strArr3[i7] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f93269b;
                if (i3 >= strArr4.length) {
                    return;
                }
                if (strArr4[i3] == null) {
                    strArr4[i3] = f93270c[i3];
                }
                i3++;
            }
        }

        static String a(byte b3, byte b4) {
            if (b4 == 0) {
                return "";
            }
            if (b3 != 2 && b3 != 3) {
                if (b3 == 4 || b3 == 6) {
                    return b4 == 1 ? "ACK" : f93270c[b4];
                }
                if (b3 != 7 && b3 != 8) {
                    String[] strArr = f93269b;
                    String str = b4 < strArr.length ? strArr[b4] : f93270c[b4];
                    return (b3 != 5 || (b4 & 4) == 0) ? (b3 != 0 || (b4 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f93270c[b4];
        }

        static String b(boolean z2, int i3, int i4, byte b3, byte b4) {
            String[] strArr = f93268a;
            return String.format("%s 0x%08x %5d %-13s %s", z2 ? "<<" : vfptEEmYY.EikqlSuOK, Integer.valueOf(i3), Integer.valueOf(i4), b3 < strArr.length ? strArr[b3] : String.format("0x%02x", Byte.valueOf(b3)), a(b3, b4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Reader implements FrameReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f93271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ContinuationSource f93272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f93273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Hpack.Reader f93274d;

        Reader(BufferedSource bufferedSource, int i3, boolean z2) {
            this.f93271a = bufferedSource;
            this.f93273c = z2;
            ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
            this.f93272b = continuationSource;
            this.f93274d = new Hpack.Reader(i3, continuationSource);
        }

        private void a(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            boolean z2 = (b3 & 1) != 0;
            if ((b3 & 32) != 0) {
                throw Http2.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s2 = (b3 & 8) != 0 ? (short) (this.f93271a.readByte() & 255) : (short) 0;
            handler.z(z2, i4, this.f93271a, Http2.l(i3, b3, s2));
            this.f93271a.skip(s2);
        }

        private void b(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i3 < 8) {
                throw Http2.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i3));
            }
            if (i4 != 0) {
                throw Http2.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int i5 = this.f93271a.readInt();
            int i6 = this.f93271a.readInt();
            int i7 = i3 - 8;
            ErrorCode errorCodeA = ErrorCode.a(i6);
            if (errorCodeA == null) {
                throw Http2.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i6));
            }
            ByteString byteStringQ1 = ByteString.f144998f;
            if (i7 > 0) {
                byteStringQ1 = this.f93271a.q1(i7);
            }
            handler.D(i5, errorCodeA, byteStringQ1);
        }

        private List c(int i3, short s2, byte b3, int i4) throws IOException {
            ContinuationSource continuationSource = this.f93272b;
            continuationSource.f93266f = i3;
            continuationSource.f93263b = i3;
            continuationSource.f93267g = s2;
            continuationSource.f93264c = b3;
            continuationSource.f93265d = i4;
            this.f93274d.l();
            return this.f93274d.e();
        }

        private void f(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i4 == 0) {
                throw Http2.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z2 = (b3 & 1) != 0;
            short s2 = (b3 & 8) != 0 ? (short) (this.f93271a.readByte() & 255) : (short) 0;
            if ((b3 & 32) != 0) {
                j(handler, i4);
                i3 -= 5;
            }
            handler.C(false, z2, i4, -1, c(Http2.l(i3, b3, s2), s2, b3, i4), HeadersMode.HTTP_20_HEADERS);
        }

        private void i(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i3 != 8) {
                throw Http2.k("TYPE_PING length != 8: %s", Integer.valueOf(i3));
            }
            if (i4 != 0) {
                throw Http2.k("TYPE_PING streamId != 0", new Object[0]);
            }
            handler.q((b3 & 1) != 0, this.f93271a.readInt(), this.f93271a.readInt());
        }

        private void j(FrameReader.Handler handler, int i3) {
            int i4 = this.f93271a.readInt();
            handler.A(i3, i4 & Api.BaseClientBuilder.API_PRIORITY_OTHER, (this.f93271a.readByte() & 255) + 1, (Integer.MIN_VALUE & i4) != 0);
        }

        private void k(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i3 != 5) {
                throw Http2.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i3));
            }
            if (i4 == 0) {
                throw Http2.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            j(handler, i4);
        }

        private void l(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i4 == 0) {
                throw Http2.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short s2 = (b3 & 8) != 0 ? (short) (this.f93271a.readByte() & 255) : (short) 0;
            handler.h(i4, this.f93271a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, c(Http2.l(i3 - 4, b3, s2), s2, b3, i4));
        }

        private void m(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i3 != 4) {
                throw Http2.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i3));
            }
            if (i4 == 0) {
                throw Http2.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int i5 = this.f93271a.readInt();
            ErrorCode errorCodeA = ErrorCode.a(i5);
            if (errorCodeA == null) {
                throw Http2.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i5));
            }
            handler.x(i4, errorCodeA);
        }

        private void n(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i4 != 0) {
                throw Http2.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b3 & 1) != 0) {
                if (i3 != 0) {
                    throw Http2.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.y();
                return;
            }
            if (i3 % 6 != 0) {
                throw Http2.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i3));
            }
            Settings settings = new Settings();
            for (int i5 = 0; i5 < i3; i5 += 6) {
                short s2 = this.f93271a.readShort();
                int i6 = this.f93271a.readInt();
                switch (s2) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (i6 != 0 && i6 != 1) {
                            throw Http2.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                        break;
                    case 3:
                        s2 = 4;
                        break;
                    case 4:
                        if (i6 < 0) {
                            throw Http2.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        s2 = 7;
                        break;
                        break;
                    case 5:
                        if (i6 < 16384 || i6 > 16777215) {
                            throw Http2.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i6));
                        }
                        break;
                        break;
                    default:
                        throw Http2.k("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(s2));
                }
                settings.l(s2, 0, i6);
            }
            handler.B(false, settings);
            if (settings.d() >= 0) {
                this.f93274d.g(settings.d());
            }
        }

        private void r(FrameReader.Handler handler, int i3, byte b3, int i4) throws IOException {
            if (i3 != 4) {
                throw Http2.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i3));
            }
            long j3 = ((long) this.f93271a.readInt()) & 2147483647L;
            if (j3 == 0) {
                throw Http2.k("windowSizeIncrement was 0", Long.valueOf(j3));
            }
            handler.e(i4, j3);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public void N0() throws IOException {
            if (this.f93273c) {
                return;
            }
            ByteString byteStringQ1 = this.f93271a.q1(Http2.f93261b.C());
            if (Http2.f93260a.isLoggable(Level.FINE)) {
                Http2.f93260a.fine(String.format("<< CONNECTION %s", byteStringQ1.l()));
            }
            if (!Http2.f93261b.equals(byteStringQ1)) {
                throw Http2.k("Expected a connection header but was %s", byteStringQ1.I());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f93271a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader
        public boolean y0(FrameReader.Handler handler) throws IOException {
            try {
                this.f93271a.g1(9L);
                int iM = Http2.m(this.f93271a);
                if (iM < 0 || iM > 16384) {
                    throw Http2.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM));
                }
                byte b3 = (byte) (this.f93271a.readByte() & 255);
                byte b4 = (byte) (this.f93271a.readByte() & 255);
                int i3 = this.f93271a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (Http2.f93260a.isLoggable(Level.FINE)) {
                    Http2.f93260a.fine(FrameLogger.b(true, i3, iM, b3, b4));
                }
                switch (b3) {
                    case 0:
                        a(handler, iM, b4, i3);
                        return true;
                    case 1:
                        f(handler, iM, b4, i3);
                        return true;
                    case 2:
                        k(handler, iM, b4, i3);
                        return true;
                    case 3:
                        m(handler, iM, b4, i3);
                        return true;
                    case 4:
                        n(handler, iM, b4, i3);
                        return true;
                    case 5:
                        l(handler, iM, b4, i3);
                        return true;
                    case 6:
                        i(handler, iM, b4, i3);
                        return true;
                    case 7:
                        b(handler, iM, b4, i3);
                        return true;
                    case 8:
                        r(handler, iM, b4, i3);
                        return true;
                    default:
                        this.f93271a.skip(iM);
                        return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Writer implements FrameWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSink f93275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f93276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Buffer f93277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Hpack.Writer f93278d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f93279f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f93280g;

        Writer(BufferedSink bufferedSink, boolean z2) {
            this.f93275a = bufferedSink;
            this.f93276b = z2;
            Buffer buffer = new Buffer();
            this.f93277c = buffer;
            this.f93278d = new Hpack.Writer(buffer);
            this.f93279f = 16384;
        }

        private void f(int i3, long j3) {
            while (j3 > 0) {
                int iMin = (int) Math.min(this.f93279f, j3);
                long j4 = iMin;
                j3 -= j4;
                b(i3, iMin, (byte) 9, j3 == 0 ? (byte) 4 : (byte) 0);
                this.f93275a.H0(this.f93277c, j4);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void E2(Settings settings) {
            try {
                if (this.f93280g) {
                    throw new IOException("closed");
                }
                int i3 = 0;
                b(0, settings.m() * 6, (byte) 4, (byte) 0);
                while (i3 < 10) {
                    if (settings.i(i3)) {
                        this.f93275a.writeShort(i3 == 4 ? 3 : i3 == 7 ? 4 : i3);
                        this.f93275a.writeInt(settings.c(i3));
                    }
                    i3++;
                }
                this.f93275a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void Y(int i3, ErrorCode errorCode, byte[] bArr) {
            try {
                if (this.f93280g) {
                    throw new IOException("closed");
                }
                if (errorCode.f93143a == -1) {
                    throw Http2.j("errorCode.httpCode == -1", new Object[0]);
                }
                b(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f93275a.writeInt(i3);
                this.f93275a.writeInt(errorCode.f93143a);
                if (bArr.length > 0) {
                    this.f93275a.write(bArr);
                }
                this.f93275a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }

        void a(int i3, byte b3, Buffer buffer, int i4) {
            b(i3, i4, (byte) 0, b3);
            if (i4 > 0) {
                this.f93275a.H0(buffer, i4);
            }
        }

        void b(int i3, int i4, byte b3, byte b4) {
            if (Http2.f93260a.isLoggable(Level.FINE)) {
                Http2.f93260a.fine(FrameLogger.b(false, i3, i4, b3, b4));
            }
            int i5 = this.f93279f;
            if (i4 > i5) {
                throw Http2.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i5), Integer.valueOf(i4));
            }
            if ((Integer.MIN_VALUE & i3) != 0) {
                throw Http2.j("reserved bit set: %s", Integer.valueOf(i3));
            }
            Http2.n(this.f93275a, i4);
            this.f93275a.writeByte(b3 & 255);
            this.f93275a.writeByte(b4 & 255);
            this.f93275a.writeInt(i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        void c(boolean z2, int i3, List list) throws IOException {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            this.f93278d.b(list);
            long size = this.f93277c.size();
            int iMin = (int) Math.min(this.f93279f, size);
            long j3 = iMin;
            byte b3 = size == j3 ? (byte) 4 : (byte) 0;
            if (z2) {
                b3 = (byte) (b3 | 1);
            }
            b(i3, iMin, (byte) 1, b3);
            this.f93275a.H0(this.f93277c, j3);
            if (size > j3) {
                f(i3, size - j3);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f93280g = true;
            this.f93275a.close();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void d0() {
            try {
                if (this.f93280g) {
                    throw new IOException("closed");
                }
                if (this.f93276b) {
                    if (Http2.f93260a.isLoggable(Level.FINE)) {
                        Http2.f93260a.fine(String.format(">> CONNECTION %s", Http2.f93261b.l()));
                    }
                    this.f93275a.write(Http2.f93261b.H());
                    this.f93275a.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void d2(Settings settings) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            this.f93279f = settings.g(this.f93279f);
            b(0, 0, (byte) 4, (byte) 1);
            this.f93275a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void e(int i3, long j3) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            if (j3 == 0 || j3 > 2147483647L) {
                throw Http2.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j3));
            }
            b(i3, 4, (byte) 8, (byte) 0);
            this.f93275a.writeInt((int) j3);
            this.f93275a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public int f1() {
            return this.f93279f;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void flush() {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            this.f93275a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void h(int i3, int i4, List list) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            this.f93278d.b(list);
            long size = this.f93277c.size();
            int iMin = (int) Math.min(this.f93279f - 4, size);
            long j3 = iMin;
            b(i3, iMin + 4, (byte) 5, size == j3 ? (byte) 4 : (byte) 0);
            this.f93275a.writeInt(i4 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.f93275a.H0(this.f93277c, j3);
            if (size > j3) {
                f(i3, size - j3);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void k0(boolean z2, int i3, Buffer buffer, int i4) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            a(i3, z2 ? (byte) 1 : (byte) 0, buffer, i4);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void q(boolean z2, int i3, int i4) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            b(0, 8, (byte) 6, z2 ? (byte) 1 : (byte) 0);
            this.f93275a.writeInt(i3);
            this.f93275a.writeInt(i4);
            this.f93275a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void x(int i3, ErrorCode errorCode) {
            if (this.f93280g) {
                throw new IOException("closed");
            }
            if (errorCode.f93143a == -1) {
                throw new IllegalArgumentException();
            }
            b(i3, 4, (byte) 3, (byte) 0);
            this.f93275a.writeInt(errorCode.f93143a);
            this.f93275a.flush();
        }

        @Override // com.squareup.okhttp.internal.framed.FrameWriter
        public synchronized void y2(boolean z2, boolean z3, int i3, int i4, List list) {
            if (z3) {
                throw new UnsupportedOperationException();
            }
            if (this.f93280g) {
                throw new IOException("closed");
            }
            c(z2, i3, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException k(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i3, byte b3, short s2) throws IOException {
        if ((b3 & 8) != 0) {
            i3--;
        }
        if (s2 <= i3) {
            return (short) (i3 - s2);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(BufferedSink bufferedSink, int i3) {
        bufferedSink.writeByte((i3 >>> 16) & 255);
        bufferedSink.writeByte((i3 >>> 8) & 255);
        bufferedSink.writeByte(i3 & 255);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameReader a(BufferedSource bufferedSource, boolean z2) {
        return new Reader(bufferedSource, 4096, z2);
    }

    @Override // com.squareup.okhttp.internal.framed.Variant
    public FrameWriter b(BufferedSink bufferedSink, boolean z2) {
        return new Writer(bufferedSink, z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ContinuationSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f93262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f93263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte f93264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f93265d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f93266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        short f93267g;

        public ContinuationSource(BufferedSource bufferedSource) {
            this.f93262a = bufferedSource;
        }

        private void a() throws IOException {
            int i3 = this.f93265d;
            int iM = Http2.m(this.f93262a);
            this.f93266f = iM;
            this.f93263b = iM;
            byte b3 = (byte) (this.f93262a.readByte() & 255);
            this.f93264c = (byte) (this.f93262a.readByte() & 255);
            if (Http2.f93260a.isLoggable(Level.FINE)) {
                Http2.f93260a.fine(FrameLogger.b(true, this.f93265d, this.f93263b, b3, this.f93264c));
            }
            int i4 = this.f93262a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f93265d = i4;
            if (b3 != 9) {
                throw Http2.k("%s != TYPE_CONTINUATION", Byte.valueOf(b3));
            }
            if (i4 != i3) {
                throw Http2.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source
        public long t2(Buffer buffer, long j3) throws IOException {
            while (true) {
                int i3 = this.f93266f;
                if (i3 != 0) {
                    long jT2 = this.f93262a.t2(buffer, Math.min(j3, i3));
                    if (jT2 == -1) {
                        return -1L;
                    }
                    this.f93266f = (int) (((long) this.f93266f) - jT2);
                    return jT2;
                }
                this.f93262a.skip(this.f93267g);
                this.f93267g = (short) 0;
                if ((this.f93264c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f93262a.v();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
