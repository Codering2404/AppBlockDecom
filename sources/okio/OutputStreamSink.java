package okio;

import java.io.IOException;
import java.io.OutputStream;
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
final class OutputStreamSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f145071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeout f145072b;

    public OutputStreamSink(OutputStream out, Timeout timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f145071a = out;
        this.f145072b = timeout;
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.size(), 0L, j3);
        while (j3 > 0) {
            this.f145072b.g();
            Segment segment = source.f144986a;
            Intrinsics.checkNotNull(segment);
            int iMin = (int) Math.min(j3, segment.f145106c - segment.f145105b);
            this.f145071a.write(segment.f145104a, segment.f145105b, iMin);
            segment.f145105b += iMin;
            long j4 = iMin;
            j3 -= j4;
            source.j0(source.size() - j4);
            if (segment.f145105b == segment.f145106c) {
                source.f144986a = segment.b();
                SegmentPool.b(segment);
            }
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f145071a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f145071a.flush();
    }

    public String toString() {
        return "sink(" + this.f145071a + ')';
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145072b;
    }
}
