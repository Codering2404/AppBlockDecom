package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

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
public final class Http2Writer implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f144765h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Logger f144766i = Logger.getLogger(Http2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f144767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f144768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Buffer f144769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f144770d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f144771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Hpack.Writer f144772g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Http2Writer(BufferedSink sink, boolean z2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f144767a = sink;
        this.f144768b = z2;
        Buffer buffer = new Buffer();
        this.f144769c = buffer;
        this.f144770d = 16384;
        this.f144772g = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void l(int i3, long j3) {
        while (j3 > 0) {
            long jMin = Math.min(this.f144770d, j3);
            j3 -= jMin;
            c(i3, (int) jMin, 9, j3 == 0 ? 4 : 0);
            this.f144767a.H0(this.f144769c, jMin);
        }
    }

    public final synchronized void a(Settings peerSettings) {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (this.f144771f) {
                throw new IOException("closed");
            }
            this.f144770d = peerSettings.e(this.f144770d);
            if (peerSettings.b() != -1) {
                this.f144772g.e(peerSettings.b());
            }
            c(0, 0, 4, 1);
            this.f144767a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(int i3, int i4, Buffer buffer, int i5) {
        c(i3, i5, 0, i4);
        if (i5 > 0) {
            BufferedSink bufferedSink = this.f144767a;
            Intrinsics.checkNotNull(buffer);
            bufferedSink.H0(buffer, i5);
        }
    }

    public final void c(int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        Logger logger = f144766i;
        if (logger.isLoggable(Level.FINE)) {
            i7 = i3;
            i8 = i4;
            i9 = i5;
            i10 = i6;
            logger.fine(Http2.f144616a.c(false, i7, i8, i9, i10));
        } else {
            i7 = i3;
            i8 = i4;
            i9 = i5;
            i10 = i6;
        }
        if (i8 > this.f144770d) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f144770d + ": " + i8).toString());
        }
        if ((Integer.MIN_VALUE & i7) != 0) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("reserved bit set: ", Integer.valueOf(i7)).toString());
        }
        Util.c0(this.f144767a, i8);
        this.f144767a.writeByte(i9 & 255);
        this.f144767a.writeByte(i10 & 255);
        this.f144767a.writeInt(Integer.MAX_VALUE & i7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f144771f = true;
        this.f144767a.close();
    }

    public final synchronized void d0() {
        try {
            if (this.f144771f) {
                throw new IOException("closed");
            }
            if (this.f144768b) {
                Logger logger = f144766i;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.t(Intrinsics.stringPlus(">> CONNECTION ", Http2.f144617b.l()), new Object[0]));
                }
                this.f144767a.q2(Http2.f144617b);
                this.f144767a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e(int i3, long j3) {
        if (this.f144771f) {
            throw new IOException("closed");
        }
        if (j3 == 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j3)).toString());
        }
        c(i3, 4, 8, 0);
        this.f144767a.writeInt((int) j3);
        this.f144767a.flush();
    }

    public final synchronized void f(int i3, ErrorCode errorCode, byte[] debugData) {
        try {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            if (this.f144771f) {
                throw new IOException("closed");
            }
            if (errorCode.b() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            c(0, debugData.length + 8, 7, 0);
            this.f144767a.writeInt(i3);
            this.f144767a.writeInt(errorCode.b());
            if (!(debugData.length == 0)) {
                this.f144767a.write(debugData);
            }
            this.f144767a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int f1() {
        return this.f144770d;
    }

    public final synchronized void flush() {
        if (this.f144771f) {
            throw new IOException("closed");
        }
        this.f144767a.flush();
    }

    public final synchronized void h(int i3, int i4, List requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (this.f144771f) {
            throw new IOException("closed");
        }
        this.f144772g.g(requestHeaders);
        long size = this.f144769c.size();
        int iMin = (int) Math.min(((long) this.f144770d) - 4, size);
        long j3 = iMin;
        c(i3, iMin + 4, 5, size == j3 ? 4 : 0);
        this.f144767a.writeInt(i4 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f144767a.H0(this.f144769c, j3);
        if (size > j3) {
            l(i3, size - j3);
        }
    }

    public final synchronized void i(boolean z2, int i3, List headerBlock) {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.f144771f) {
            throw new IOException("closed");
        }
        this.f144772g.g(headerBlock);
        long size = this.f144769c.size();
        long jMin = Math.min(this.f144770d, size);
        int i4 = size == jMin ? 4 : 0;
        if (z2) {
            i4 |= 1;
        }
        c(i3, (int) jMin, 1, i4);
        this.f144767a.H0(this.f144769c, jMin);
        if (size > jMin) {
            l(i3, size - jMin);
        }
    }

    public final synchronized void j(int i3, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f144771f) {
            throw new IOException("closed");
        }
        if (errorCode.b() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        c(i3, 4, 3, 0);
        this.f144767a.writeInt(errorCode.b());
        this.f144767a.flush();
    }

    public final synchronized void k(Settings settings) {
        try {
            Intrinsics.checkNotNullParameter(settings, "settings");
            if (this.f144771f) {
                throw new IOException("closed");
            }
            int i3 = 0;
            c(0, settings.i() * 6, 4, 0);
            while (i3 < 10) {
                int i4 = i3 + 1;
                if (settings.f(i3)) {
                    this.f144767a.writeShort(i3 != 4 ? i3 != 7 ? i3 : 4 : 3);
                    this.f144767a.writeInt(settings.a(i3));
                }
                i3 = i4;
            }
            this.f144767a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k0(boolean z2, int i3, Buffer buffer, int i4) {
        if (this.f144771f) {
            throw new IOException("closed");
        }
        b(i3, z2 ? 1 : 0, buffer, i4);
    }

    public final synchronized void q(boolean z2, int i3, int i4) {
        if (this.f144771f) {
            throw new IOException("closed");
        }
        c(0, 8, 6, z2 ? 1 : 0);
        this.f144767a.writeInt(i3);
        this.f144767a.writeInt(i4);
        this.f144767a.flush();
    }
}
