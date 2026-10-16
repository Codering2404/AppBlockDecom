package okio;

import java.util.zip.CRC32;
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
public final class GzipSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealBufferedSink f145042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deflater f145043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeflaterSink f145044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f145045d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CRC32 f145046f;

    private final void a(Buffer buffer, long j3) {
        Segment segment = buffer.f144986a;
        Intrinsics.checkNotNull(segment);
        while (j3 > 0) {
            int iMin = (int) Math.min(j3, segment.f145106c - segment.f145105b);
            this.f145046f.update(segment.f145104a, segment.f145105b, iMin);
            j3 -= (long) iMin;
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
        }
    }

    private final void b() {
        this.f145042a.a((int) this.f145046f.getValue());
        this.f145042a.a((int) this.f145043b.getBytesRead());
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (j3 == 0) {
            return;
        }
        a(source, j3);
        this.f145044c.H0(source, j3);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f145045d) {
            return;
        }
        try {
            this.f145044c.b();
            b();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f145043b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f145042a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f145045d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f145044c.flush();
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145042a.v();
    }
}
