package okio;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
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
public final class CipherSink implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSink f145002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Cipher f145003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f145004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f145005d;

    private final Throwable a() {
        int outputSize = this.f145003b.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.f145002a;
                byte[] bArrDoFinal = this.f145003b.doFinal();
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal()");
                bufferedSink.write(bArrDoFinal);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
        Buffer bufferU = this.f145002a.u();
        Segment segmentZ0 = bufferU.z0(outputSize);
        try {
            int iDoFinal = this.f145003b.doFinal(segmentZ0.f145104a, segmentZ0.f145106c);
            segmentZ0.f145106c += iDoFinal;
            bufferU.j0(bufferU.size() + ((long) iDoFinal));
        } catch (Throwable th3) {
            th = th3;
        }
        if (segmentZ0.f145105b == segmentZ0.f145106c) {
            bufferU.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
        }
        return th;
    }

    private final int b(Buffer buffer, long j3) throws ShortBufferException {
        Segment segment = buffer.f144986a;
        Intrinsics.checkNotNull(segment);
        int iMin = (int) Math.min(j3, segment.f145106c - segment.f145105b);
        Buffer bufferU = this.f145002a.u();
        int outputSize = this.f145003b.getOutputSize(iMin);
        int i3 = iMin;
        while (outputSize > 8192) {
            int i4 = this.f145004c;
            if (i3 <= i4) {
                BufferedSink bufferedSink = this.f145002a;
                byte[] bArrUpdate = this.f145003b.update(buffer.S0(j3));
                Intrinsics.checkNotNullExpressionValue(bArrUpdate, "cipher.update(source.readByteArray(remaining))");
                bufferedSink.write(bArrUpdate);
                return (int) j3;
            }
            i3 -= i4;
            outputSize = this.f145003b.getOutputSize(i3);
        }
        Segment segmentZ0 = bufferU.z0(outputSize);
        int iUpdate = this.f145003b.update(segment.f145104a, segment.f145105b, i3, segmentZ0.f145104a, segmentZ0.f145106c);
        segmentZ0.f145106c += iUpdate;
        bufferU.j0(bufferU.size() + ((long) iUpdate));
        if (segmentZ0.f145105b == segmentZ0.f145106c) {
            bufferU.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
        }
        this.f145002a.o0();
        buffer.j0(buffer.size() - ((long) i3));
        int i5 = segment.f145105b + i3;
        segment.f145105b = i5;
        if (i5 == segment.f145106c) {
            buffer.f144986a = segment.b();
            SegmentPool.b(segment);
        }
        return i3;
    }

    @Override // okio.Sink
    public void H0(Buffer source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.size(), 0L, j3);
        if (this.f145005d) {
            throw new IllegalStateException("closed");
        }
        long jB = j3;
        while (jB > 0) {
            jB -= (long) b(source, jB);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f145005d) {
            return;
        }
        this.f145005d = true;
        Throwable thA = a();
        try {
            this.f145002a.close();
        } catch (Throwable th) {
            if (thA == null) {
                thA = th;
            }
        }
        if (thA != null) {
            throw thA;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f145002a.flush();
    }

    @Override // okio.Sink
    public Timeout v() {
        return this.f145002a.v();
    }
}
