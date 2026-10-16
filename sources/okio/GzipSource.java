package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
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
public final class GzipSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f145047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealBufferedSource f145048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f145049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InflaterSource f145050d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CRC32 f145051f;

    public GzipSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f145048b = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f145049c = inflater;
        this.f145050d = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.f145051f = new CRC32();
    }

    private final void a(String str, int i3, int i4) throws IOException {
        if (i4 == i3) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i3)}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    private final void b() throws IOException {
        this.f145048b.g1(10L);
        byte bR = this.f145048b.f145100b.r(3L);
        boolean z2 = ((bR >> 1) & 1) == 1;
        if (z2) {
            f(this.f145048b.f145100b, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f145048b.readShort());
        this.f145048b.skip(8L);
        if (((bR >> 2) & 1) == 1) {
            this.f145048b.g1(2L);
            if (z2) {
                f(this.f145048b.f145100b, 0L, 2L);
            }
            long jW0 = this.f145048b.f145100b.W0() & 65535;
            this.f145048b.g1(jW0);
            if (z2) {
                f(this.f145048b.f145100b, 0L, jW0);
            }
            this.f145048b.skip(jW0);
        }
        if (((bR >> 3) & 1) == 1) {
            long jA = this.f145048b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z2) {
                f(this.f145048b.f145100b, 0L, jA + 1);
            }
            this.f145048b.skip(jA + 1);
        }
        if (((bR >> 4) & 1) == 1) {
            long jA2 = this.f145048b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z2) {
                f(this.f145048b.f145100b, 0L, jA2 + 1);
            }
            this.f145048b.skip(jA2 + 1);
        }
        if (z2) {
            a("FHCRC", this.f145048b.W0(), (short) this.f145051f.getValue());
            this.f145051f.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.f145048b.l2(), (int) this.f145051f.getValue());
        a("ISIZE", this.f145048b.l2(), (int) this.f145049c.getBytesWritten());
    }

    private final void f(Buffer buffer, long j3, long j4) {
        Segment segment = buffer.f144986a;
        Intrinsics.checkNotNull(segment);
        while (true) {
            int i3 = segment.f145106c;
            int i4 = segment.f145105b;
            if (j3 < i3 - i4) {
                break;
            }
            j3 -= (long) (i3 - i4);
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
        }
        while (j4 > 0) {
            int i5 = (int) (((long) segment.f145105b) + j3);
            int iMin = (int) Math.min(segment.f145106c - i5, j4);
            this.f145051f.update(segment.f145104a, i5, iMin);
            j4 -= (long) iMin;
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
            j3 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f145050d.close();
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) throws IOException {
        GzipSource gzipSource;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (j3 == 0) {
            return 0L;
        }
        if (this.f145047a == 0) {
            b();
            this.f145047a = (byte) 1;
        }
        if (this.f145047a == 1) {
            long size = sink.size();
            long jT2 = this.f145050d.t2(sink, j3);
            if (jT2 != -1) {
                f(sink, size, jT2);
                return jT2;
            }
            gzipSource = this;
            gzipSource.f145047a = (byte) 2;
        } else {
            gzipSource = this;
        }
        if (gzipSource.f145047a == 2) {
            c();
            gzipSource.f145047a = (byte) 3;
            if (!gzipSource.f145048b.G1()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145048b.v();
    }
}
