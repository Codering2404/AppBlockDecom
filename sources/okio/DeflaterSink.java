package okio;

import java.util.zip.Deflater;
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
public final class DeflaterSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f145012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f145013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f145014c;

    public DeflaterSink(BufferedSink sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.f145012a = sink;
        this.f145013b = deflater;
    }

    private final void a(boolean z2) {
        Segment segmentZ0;
        int iDeflate;
        Buffer bufferU = this.f145012a.u();
        while (true) {
            segmentZ0 = bufferU.z0(1);
            if (z2) {
                Deflater deflater = this.f145013b;
                byte[] bArr = segmentZ0.f145104a;
                int i3 = segmentZ0.f145106c;
                iDeflate = deflater.deflate(bArr, i3, 8192 - i3, 2);
            } else {
                Deflater deflater2 = this.f145013b;
                byte[] bArr2 = segmentZ0.f145104a;
                int i4 = segmentZ0.f145106c;
                iDeflate = deflater2.deflate(bArr2, i4, 8192 - i4);
            }
            if (iDeflate > 0) {
                segmentZ0.f145106c += iDeflate;
                bufferU.j0(bufferU.size() + ((long) iDeflate));
                this.f145012a.o0();
            } else if (this.f145013b.needsInput()) {
                break;
            }
        }
        if (segmentZ0.f145105b == segmentZ0.f145106c) {
            bufferU.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
        }
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.size(), 0L, j3);
        while (j3 > 0) {
            Segment segment = source.f144986a;
            Intrinsics.checkNotNull(segment);
            int iMin = (int) Math.min(j3, segment.f145106c - segment.f145105b);
            this.f145013b.setInput(segment.f145104a, segment.f145105b, iMin);
            a(false);
            long j4 = iMin;
            source.j0(source.size() - j4);
            int i3 = segment.f145105b + iMin;
            segment.f145105b = i3;
            if (i3 == segment.f145106c) {
                source.f144986a = segment.b();
                SegmentPool.b(segment);
            }
            j3 -= j4;
        }
    }

    public final void b() {
        this.f145013b.finish();
        a(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f145014c) {
            return;
        }
        try {
            b();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f145013b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f145012a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f145014c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        a(true);
        this.f145012a.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f145012a + ')';
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145012a.v();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.c(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }
}
