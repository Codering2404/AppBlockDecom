package okio;

import java.io.IOException;
import java.io.InputStream;
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
class InputStreamSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f145062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeout f145063b;

    public InputStreamSource(InputStream input, Timeout timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f145062a = input;
        this.f145063b = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f145062a.close();
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 == 0) {
            return 0L;
        }
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        try {
            this.f145063b.g();
            Segment segmentZ0 = sink.z0(1);
            int i3 = this.f145062a.read(segmentZ0.f145104a, segmentZ0.f145106c, (int) Math.min(j3, 8192 - segmentZ0.f145106c));
            if (i3 != -1) {
                segmentZ0.f145106c += i3;
                long j4 = i3;
                sink.j0(sink.size() + j4);
                return j4;
            }
            if (segmentZ0.f145105b != segmentZ0.f145106c) {
                return -1L;
            }
            sink.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
            return -1L;
        } catch (AssertionError e3) {
            if (Okio.e(e3)) {
                throw new IOException(e3);
            }
            throw e3;
        }
    }

    public String toString() {
        return "source(" + this.f145062a + ')';
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145063b;
    }
}
