package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class RealBufferedSink implements BufferedSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sink f145095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Buffer f145096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f145097c;

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f145095a = sink;
        this.f145096b = new Buffer();
    }

    @Override // okio.BufferedSink
    public BufferedSink C0(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.C0(string);
        return o0();
    }

    @Override // okio.BufferedSink
    public OutputStream D2() {
        return new OutputStream() { // from class: okio.RealBufferedSink$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                this.f145098a.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = this.f145098a;
                if (realBufferedSink.f145097c) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return this.f145098a + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i3) throws IOException {
                RealBufferedSink realBufferedSink = this.f145098a;
                if (realBufferedSink.f145097c) {
                    throw new IOException("closed");
                }
                realBufferedSink.f145096b.writeByte((byte) i3);
                this.f145098a.o0();
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i3, int i4) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                RealBufferedSink realBufferedSink = this.f145098a;
                if (!realBufferedSink.f145097c) {
                    realBufferedSink.f145096b.write(data, i3, i4);
                    this.f145098a.o0();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.H0(source, j3);
        o0();
    }

    @Override // okio.BufferedSink
    public BufferedSink J0(String string, int i3, int i4) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.J0(string, i3, i4);
        return o0();
    }

    @Override // okio.BufferedSink
    public long K0(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = 0;
        while (true) {
            long jT2 = source.t2(this.f145096b, 8192L);
            if (jT2 == -1) {
                return j3;
            }
            j3 += jT2;
            o0();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink U() {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        long size = this.f145096b.size();
        if (size > 0) {
            this.f145095a.H0(this.f145096b, size);
        }
        return this;
    }

    public BufferedSink a(int i3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.w1(i3);
        return o0();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f145097c) {
            return;
        }
        try {
            if (this.f145096b.size() > 0) {
                Sink sink = this.f145095a;
                Buffer buffer = this.f145096b;
                sink.H0(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f145095a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f145097c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink e2(long j3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.e2(j3);
        return o0();
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        if (this.f145096b.size() > 0) {
            Sink sink = this.f145095a;
            Buffer buffer = this.f145096b;
            sink.H0(buffer, buffer.size());
        }
        this.f145095a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f145097c;
    }

    @Override // okio.BufferedSink
    public BufferedSink j1(long j3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.j1(j3);
        return o0();
    }

    @Override // okio.BufferedSink
    public BufferedSink o0() {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        long jC = this.f145096b.c();
        if (jC > 0) {
            this.f145095a.H0(this.f145096b, jC);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink q2(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.q2(byteString);
        return o0();
    }

    @Override // okio.BufferedSink
    public Buffer s() {
        return this.f145096b;
    }

    public String toString() {
        return "buffer(" + this.f145095a + ')';
    }

    @Override // okio.BufferedSink
    public Buffer u() {
        return this.f145096b;
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145095a.v();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f145096b.write(source);
        o0();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.writeByte(i3);
        return o0();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.writeInt(i3);
        return o0();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i3) {
        if (this.f145097c) {
            throw new IllegalStateException("closed");
        }
        this.f145096b.writeShort(i3);
        return o0();
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f145097c) {
            this.f145096b.write(source);
            return o0();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.f145097c) {
            this.f145096b.write(source, i3, i4);
            return o0();
        }
        throw new IllegalStateException("closed");
    }
}
