package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

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
public final class Http2Reader implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f144725f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f144726g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f144727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f144728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContinuationSource f144729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Hpack.Reader f144730d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return Http2Reader.f144726g;
        }

        public final int b(int i3, int i4, int i5) throws IOException {
            if ((i4 & 8) != 0) {
                i3--;
            }
            if (i5 <= i3) {
                return i3 - i5;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i5 + " > remaining length " + i3);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Handler {
        void A(int i3, int i4, int i5, boolean z2);

        void c(boolean z2, Settings settings);

        void d(boolean z2, int i3, int i4, List list);

        void e(int i3, long j3);

        void h(int i3, int i4, List list);

        void m(int i3, ErrorCode errorCode);

        void p(int i3, ErrorCode errorCode, ByteString byteString);

        void q(boolean z2, int i3, int i4);

        void y();

        void z(boolean z2, int i3, BufferedSource bufferedSource, int i4);
    }

    static {
        Logger logger = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(Http2::class.java.name)");
        f144726g = logger;
    }

    public Http2Reader(BufferedSource source, boolean z2) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f144727a = source;
        this.f144728b = z2;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.f144729c = continuationSource;
        this.f144730d = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void C(Handler handler, int i3, int i4, int i5) throws IOException {
        int i6;
        if (i5 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i4 & 1) != 0) {
            if (i3 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.y();
            return;
        }
        if (i3 % 6 != 0) {
            throw new IOException(Intrinsics.stringPlus("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i3)));
        }
        Settings settings = new Settings();
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, i3), 6);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                int i7 = iG + iL;
                int iE = Util.e(this.f144727a.readShort(), 65535);
                i6 = this.f144727a.readInt();
                if (iE != 2) {
                    if (iE == 3) {
                        iE = 4;
                    } else if (iE != 4) {
                        if (iE == 5 && (i6 < 16384 || i6 > 16777215)) {
                            break;
                        }
                    } else {
                        if (i6 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iE = 7;
                    }
                } else if (i6 != 0 && i6 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.h(iE, i6);
                if (iG == iH) {
                    break;
                } else {
                    iG = i7;
                }
            }
            throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(i6)));
        }
        handler.c(false, settings);
    }

    private final void F(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i3 != 4) {
            throw new IOException(Intrinsics.stringPlus("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i3)));
        }
        long jF = Util.f(this.f144727a.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.e(i5, jF);
    }

    private final void f(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i5 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z2 = (i4 & 1) != 0;
        if ((i4 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (i4 & 8) != 0 ? Util.d(this.f144727a.readByte(), 255) : 0;
        handler.z(z2, i5, this.f144727a, f144725f.b(i3, i4, iD));
        this.f144727a.skip(iD);
    }

    private final void i(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i3 < 8) {
            throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY length < 8: ", Integer.valueOf(i3)));
        }
        if (i5 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i6 = this.f144727a.readInt();
        int i7 = this.f144727a.readInt();
        int i8 = i3 - 8;
        ErrorCode errorCodeA = ErrorCode.f144568b.a(i7);
        if (errorCodeA == null) {
            throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(i7)));
        }
        ByteString byteStringQ1 = ByteString.f144998f;
        if (i8 > 0) {
            byteStringQ1 = this.f144727a.q1(i8);
        }
        handler.p(i6, errorCodeA, byteStringQ1);
    }

    private final List j(int i3, int i4, int i5, int i6) throws IOException {
        this.f144729c.f(i3);
        ContinuationSource continuationSource = this.f144729c;
        continuationSource.i(continuationSource.a());
        this.f144729c.j(i4);
        this.f144729c.c(i5);
        this.f144729c.k(i6);
        this.f144730d.k();
        return this.f144730d.e();
    }

    private final void k(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i5 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z2 = (i4 & 1) != 0;
        int iD = (i4 & 8) != 0 ? Util.d(this.f144727a.readByte(), 255) : 0;
        if ((i4 & 32) != 0) {
            m(handler, i5);
            i3 -= 5;
        }
        handler.d(z2, i5, -1, j(f144725f.b(i3, i4, iD), iD, i4, i5));
    }

    private final void l(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i3 != 8) {
            throw new IOException(Intrinsics.stringPlus("TYPE_PING length != 8: ", Integer.valueOf(i3)));
        }
        if (i5 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.q((i4 & 1) != 0, this.f144727a.readInt(), this.f144727a.readInt());
    }

    private final void m(Handler handler, int i3) {
        int i4 = this.f144727a.readInt();
        handler.A(i3, i4 & Api.BaseClientBuilder.API_PRIORITY_OTHER, Util.d(this.f144727a.readByte(), 255) + 1, (Integer.MIN_VALUE & i4) != 0);
    }

    private final void n(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i3 == 5) {
            if (i5 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            m(handler, i5);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i3 + " != 5");
        }
    }

    private final void r(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i5 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (i4 & 8) != 0 ? Util.d(this.f144727a.readByte(), 255) : 0;
        handler.h(i5, this.f144727a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, j(f144725f.b(i3 - 4, i4, iD), iD, i4, i5));
    }

    private final void z(Handler handler, int i3, int i4, int i5) throws IOException {
        if (i3 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i3 + " != 4");
        }
        if (i5 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i6 = this.f144727a.readInt();
        ErrorCode errorCodeA = ErrorCode.f144568b.a(i6);
        if (errorCodeA == null) {
            throw new IOException(Intrinsics.stringPlus("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(i6)));
        }
        handler.m(i5, errorCodeA);
    }

    public final boolean b(boolean z2, Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.f144727a.g1(9L);
            int iK = Util.K(this.f144727a);
            if (iK > 16384) {
                throw new IOException(Intrinsics.stringPlus("FRAME_SIZE_ERROR: ", Integer.valueOf(iK)));
            }
            int iD = Util.d(this.f144727a.readByte(), 255);
            int iD2 = Util.d(this.f144727a.readByte(), 255);
            int i3 = this.f144727a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            Logger logger = f144726g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.f144616a.c(true, i3, iK, iD, iD2));
            }
            if (z2 && iD != 4) {
                throw new IOException(Intrinsics.stringPlus("Expected a SETTINGS frame but was ", Http2.f144616a.b(iD)));
            }
            switch (iD) {
                case 0:
                    f(handler, iK, iD2, i3);
                    return true;
                case 1:
                    k(handler, iK, iD2, i3);
                    return true;
                case 2:
                    n(handler, iK, iD2, i3);
                    return true;
                case 3:
                    z(handler, iK, iD2, i3);
                    return true;
                case 4:
                    C(handler, iK, iD2, i3);
                    return true;
                case 5:
                    r(handler, iK, iD2, i3);
                    return true;
                case 6:
                    l(handler, iK, iD2, i3);
                    return true;
                case 7:
                    i(handler, iK, iD2, i3);
                    return true;
                case 8:
                    F(handler, iK, iD2, i3);
                    return true;
                default:
                    this.f144727a.skip(iK);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.f144728b) {
            if (!b(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.f144727a;
        ByteString byteString = Http2.f144617b;
        ByteString byteStringQ1 = bufferedSource.q1(byteString.C());
        Logger logger = f144726g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.t(Intrinsics.stringPlus("<< CONNECTION ", byteStringQ1.l()), new Object[0]));
        }
        if (!Intrinsics.areEqual(byteString, byteStringQ1)) {
            throw new IOException(Intrinsics.stringPlus("Expected a connection header but was ", byteStringQ1.I()));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f144727a.close();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ContinuationSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f144731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f144732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f144733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f144734d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f144735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f144736g;

        public ContinuationSource(BufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f144731a = source;
        }

        private final void b() throws IOException {
            int i3 = this.f144734d;
            int iK = Util.K(this.f144731a);
            this.f144735f = iK;
            this.f144732b = iK;
            int iD = Util.d(this.f144731a.readByte(), 255);
            this.f144733c = Util.d(this.f144731a.readByte(), 255);
            Companion companion = Http2Reader.f144725f;
            if (companion.a().isLoggable(Level.FINE)) {
                companion.a().fine(Http2.f144616a.c(true, this.f144734d, this.f144732b, iD, this.f144733c));
            }
            int i4 = this.f144731a.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f144734d = i4;
            if (iD == 9) {
                if (i4 != i3) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        public final int a() {
            return this.f144735f;
        }

        public final void c(int i3) {
            this.f144733c = i3;
        }

        public final void f(int i3) {
            this.f144735f = i3;
        }

        public final void i(int i3) {
            this.f144732b = i3;
        }

        public final void j(int i3) {
            this.f144736g = i3;
        }

        public final void k(int i3) {
            this.f144734d = i3;
        }

        @Override // okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (true) {
                int i3 = this.f144735f;
                if (i3 != 0) {
                    long jT2 = this.f144731a.t2(sink, Math.min(j3, i3));
                    if (jT2 == -1) {
                        return -1L;
                    }
                    this.f144735f -= (int) jT2;
                    return jT2;
                }
                this.f144731a.skip(this.f144736g);
                this.f144736g = 0;
                if ((this.f144733c & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f144731a.v();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
