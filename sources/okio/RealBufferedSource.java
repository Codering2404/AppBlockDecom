package okio;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.android.gms.common.api.Api;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RealBufferedSource implements BufferedSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Source f145099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f145100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f145101c;

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f145099a = source;
        this.f145100b = new Buffer();
    }

    @Override // okio.BufferedSource
    public byte[] D1() {
        this.f145100b.K0(this.f145099a);
        return this.f145100b.D1();
    }

    @Override // okio.BufferedSource
    public boolean E0(long j3, ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return f(j3, bytes, 0, bytes.C());
    }

    @Override // okio.BufferedSource
    public long F2() throws EOFException {
        byte bR;
        g1(1L);
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (!y(i4)) {
                break;
            }
            bR = this.f145100b.r(i3);
            if ((bR < 48 || bR > 57) && ((bR < 97 || bR > 102) && (bR < 65 || bR > 70))) {
                break;
            }
            i3 = i4;
        }
        if (i3 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bR, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f145100b.F2();
    }

    @Override // okio.BufferedSource
    public boolean G1() {
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        return this.f145100b.G1() && this.f145099a.t2(this.f145100b, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    public InputStream H2() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = this.f145102a;
                if (realBufferedSource.f145101c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.f145100b.size(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws EOFException {
                this.f145102a.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = this.f145102a;
                if (realBufferedSource.f145101c) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.f145100b.size() == 0) {
                    RealBufferedSource realBufferedSource2 = this.f145102a;
                    if (realBufferedSource2.f145099a.t2(realBufferedSource2.f145100b, 8192L) == -1) {
                        return -1;
                    }
                }
                return this.f145102a.f145100b.readByte() & 255;
            }

            public String toString() {
                return this.f145102a + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int i3, int i4) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!this.f145102a.f145101c) {
                    SegmentedByteString.b(data.length, i3, i4);
                    if (this.f145102a.f145100b.size() == 0) {
                        RealBufferedSource realBufferedSource = this.f145102a;
                        if (realBufferedSource.f145099a.t2(realBufferedSource.f145100b, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return this.f145102a.f145100b.read(data, i3, i4);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.BufferedSource
    public int I2(Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iE = okio.internal.Buffer.e(this.f145100b, options, true);
            if (iE != -2) {
                if (iE == -1) {
                    return -1;
                }
                this.f145100b.skip(options.e()[iE].C());
                return iE;
            }
        } while (this.f145099a.t2(this.f145100b, 8192L) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public long M1() throws EOFException {
        byte bR;
        g1(1L);
        long j3 = 0;
        while (true) {
            long j4 = j3 + 1;
            if (!y(j4)) {
                break;
            }
            bR = this.f145100b.r(j3);
            if ((bR < 48 || bR > 57) && !(j3 == 0 && bR == 45)) {
                break;
            }
            j3 = j4;
        }
        if (j3 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(bR, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f145100b.M1();
    }

    @Override // okio.BufferedSource
    public String Q0() {
        return r0(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public byte[] S0(long j3) throws EOFException {
        g1(j3);
        return this.f145100b.S0(j3);
    }

    @Override // okio.BufferedSource
    public short W0() throws EOFException {
        g1(2L);
        return this.f145100b.W0();
    }

    @Override // okio.BufferedSource
    public String Z1(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.f145100b.K0(this.f145099a);
        return this.f145100b.Z1(charset);
    }

    public long a(byte b3) {
        return m0(b3, 0L, Long.MAX_VALUE);
    }

    public long b(ByteString bytes, long j3) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jZ = this.f145100b.z(bytes, j3);
            if (jZ != -1) {
                return jZ;
            }
            long size = this.f145100b.size();
            if (this.f145099a.t2(this.f145100b, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, (size - ((long) bytes.C())) + 1);
        }
    }

    @Override // okio.BufferedSource
    public long b1() throws EOFException {
        g1(8L);
        return this.f145100b.b1();
    }

    public long c(ByteString targetBytes, long j3) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jF = this.f145100b.F(targetBytes, j3);
            if (jF != -1) {
                return jF;
            }
            long size = this.f145100b.size();
            if (this.f145099a.t2(this.f145100b, 8192L) == -1) {
                return -1L;
            }
            j3 = Math.max(j3, size);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f145101c) {
            return;
        }
        this.f145101c = true;
        this.f145099a.close();
        this.f145100b.a();
    }

    public boolean f(long j3, ByteString bytes, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        if (j3 < 0 || i3 < 0 || i4 < 0 || bytes.C() - i3 < i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            long j4 = ((long) i5) + j3;
            if (!y(1 + j4) || this.f145100b.r(j4) != bytes.g(i3 + i5)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void g1(long j3) throws EOFException {
        if (!y(j3)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f145101c;
    }

    @Override // okio.BufferedSource
    public void l0(Buffer sink, long j3) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            g1(j3);
            this.f145100b.l0(sink, j3);
        } catch (EOFException e3) {
            sink.K0(this.f145100b);
            throw e3;
        }
    }

    @Override // okio.BufferedSource
    public int l2() throws EOFException {
        g1(4L);
        return this.f145100b.l2();
    }

    @Override // okio.BufferedSource
    public long m0(byte b3, long j3, long j4) {
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j3 || j3 > j4) {
            throw new IllegalArgumentException(("fromIndex=" + j3 + " toIndex=" + j4).toString());
        }
        long jMax = j3;
        while (jMax < j4) {
            byte b4 = b3;
            long j5 = j4;
            long jM0 = this.f145100b.m0(b4, jMax, j5);
            if (jM0 != -1) {
                return jM0;
            }
            long size = this.f145100b.size();
            if (size >= j5 || this.f145099a.t2(this.f145100b, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b3 = b4;
            j4 = j5;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public String m1(long j3) throws EOFException {
        g1(j3);
        return this.f145100b.m1(j3);
    }

    @Override // okio.BufferedSource
    public long n0(ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return c(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public ByteString q1(long j3) throws EOFException {
        g1(j3);
        return this.f145100b.q1(j3);
    }

    @Override // okio.BufferedSource
    public String r0(long j3) throws EOFException {
        if (j3 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j3).toString());
        }
        long j4 = j3 == Long.MAX_VALUE ? Long.MAX_VALUE : j3 + 1;
        long jM0 = m0((byte) 10, 0L, j4);
        if (jM0 != -1) {
            return okio.internal.Buffer.d(this.f145100b, jM0);
        }
        if (j4 < Long.MAX_VALUE && y(j4) && this.f145100b.r(j4 - 1) == 13 && y(j4 + 1) && this.f145100b.r(j4) == 10) {
            return okio.internal.Buffer.d(this.f145100b, j4);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f145100b;
        buffer2.j(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f145100b.size(), j3) + " content=" + buffer.M().l() + (char) 8230);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.f145100b.size() == 0 && this.f145099a.t2(this.f145100b, 8192L) == -1) {
            return -1;
        }
        return this.f145100b.read(sink);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        g1(1L);
        return this.f145100b.readByte();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            g1(sink.length);
            this.f145100b.readFully(sink);
        } catch (EOFException e3) {
            int i3 = 0;
            while (this.f145100b.size() > 0) {
                Buffer buffer = this.f145100b;
                int i4 = buffer.read(sink, i3, (int) buffer.size());
                if (i4 == -1) {
                    throw new AssertionError();
                }
                i3 += i4;
            }
            throw e3;
        }
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        g1(4L);
        return this.f145100b.readInt();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        g1(8L);
        return this.f145100b.readLong();
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        g1(2L);
        return this.f145100b.readShort();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer s() {
        return this.f145100b;
    }

    @Override // okio.BufferedSource
    public void skip(long j3) throws EOFException {
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        while (j3 > 0) {
            if (this.f145100b.size() == 0 && this.f145099a.t2(this.f145100b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j3, this.f145100b.size());
            this.f145100b.skip(jMin);
            j3 -= jMin;
        }
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        if (this.f145100b.size() == 0 && this.f145099a.t2(this.f145100b, 8192L) == -1) {
            return -1L;
        }
        return this.f145100b.t2(sink, Math.min(j3, this.f145100b.size()));
    }

    public String toString() {
        return "buffer(" + this.f145099a + ')';
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer u() {
        return this.f145100b;
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145099a.v();
    }

    @Override // okio.BufferedSource
    public long w2(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = 0;
        while (this.f145099a.t2(this.f145100b, 8192L) != -1) {
            long jC = this.f145100b.c();
            if (jC > 0) {
                j3 += jC;
                sink.H0(this.f145100b, jC);
            }
        }
        if (this.f145100b.size() <= 0) {
            return j3;
        }
        long size = j3 + this.f145100b.size();
        Buffer buffer = this.f145100b;
        sink.H0(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public boolean y(long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f145101c) {
            throw new IllegalStateException("closed");
        }
        while (this.f145100b.size() < j3) {
            if (this.f145099a.t2(this.f145100b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public long c0(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, QgXempTBEfV.LNxWEee);
        return b(byteString, 0L);
    }
}
