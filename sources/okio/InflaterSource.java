package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
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
public final class InflaterSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f145058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f145059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f145061d;

    public InflaterSource(BufferedSource source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f145058a = source;
        this.f145059b = inflater;
    }

    private final void c() {
        int i3 = this.f145060c;
        if (i3 == 0) {
            return;
        }
        int remaining = i3 - this.f145059b.getRemaining();
        this.f145060c -= remaining;
        this.f145058a.skip(remaining);
    }

    public final long a(Buffer sink, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f145061d) {
            throw new IllegalStateException("closed");
        }
        if (j3 == 0) {
            return 0L;
        }
        try {
            Segment segmentZ0 = sink.z0(1);
            int iMin = (int) Math.min(j3, 8192 - segmentZ0.f145106c);
            b();
            int iInflate = this.f145059b.inflate(segmentZ0.f145104a, segmentZ0.f145106c, iMin);
            c();
            if (iInflate > 0) {
                segmentZ0.f145106c += iInflate;
                long j4 = iInflate;
                sink.j0(sink.size() + j4);
                return j4;
            }
            if (segmentZ0.f145105b == segmentZ0.f145106c) {
                sink.f144986a = segmentZ0.b();
                SegmentPool.b(segmentZ0);
            }
            return 0L;
        } catch (DataFormatException e3) {
            throw new IOException(e3);
        }
    }

    public final boolean b() {
        if (!this.f145059b.needsInput()) {
            return false;
        }
        if (this.f145058a.G1()) {
            return true;
        }
        Segment segment = this.f145058a.u().f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145106c;
        int i4 = segment.f145105b;
        int i5 = i3 - i4;
        this.f145060c = i5;
        this.f145059b.setInput(segment.f145104a, i4, i5);
        return false;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f145061d) {
            return;
        }
        this.f145059b.end();
        this.f145061d = true;
        this.f145058a.close();
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long jA = a(sink, j3);
            if (jA > 0) {
                return jA;
            }
            if (this.f145059b.finished() || this.f145059b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f145058a.G1());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145058a.v();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.d(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }
}
