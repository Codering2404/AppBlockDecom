package okio;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
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
public final class CipherSource implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f145006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Cipher f145007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f145008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Buffer f145009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f145010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f145011g;

    private final void a() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.f145007b.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment segmentZ0 = this.f145009d.z0(outputSize);
        int iDoFinal = this.f145007b.doFinal(segmentZ0.f145104a, segmentZ0.f145105b);
        segmentZ0.f145106c += iDoFinal;
        Buffer buffer = this.f145009d;
        buffer.j0(buffer.size() + ((long) iDoFinal));
        if (segmentZ0.f145105b == segmentZ0.f145106c) {
            this.f145009d.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
        }
    }

    private final void b() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        while (this.f145009d.size() == 0 && !this.f145010f) {
            if (this.f145006a.G1()) {
                this.f145010f = true;
                a();
                return;
            }
            c();
        }
    }

    private final void c() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Segment segment = this.f145006a.u().f144986a;
        Intrinsics.checkNotNull(segment);
        int i3 = segment.f145106c - segment.f145105b;
        int outputSize = this.f145007b.getOutputSize(i3);
        int i4 = i3;
        while (outputSize > 8192) {
            int i5 = this.f145008c;
            if (i4 <= i5) {
                this.f145010f = true;
                Buffer buffer = this.f145009d;
                byte[] bArrDoFinal = this.f145007b.doFinal(this.f145006a.D1());
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(source.readByteArray())");
                buffer.write(bArrDoFinal);
                return;
            }
            i4 -= i5;
            outputSize = this.f145007b.getOutputSize(i4);
        }
        Segment segmentZ0 = this.f145009d.z0(outputSize);
        int iUpdate = this.f145007b.update(segment.f145104a, segment.f145105b, i4, segmentZ0.f145104a, segmentZ0.f145105b);
        this.f145006a.skip(i4);
        segmentZ0.f145106c += iUpdate;
        Buffer buffer2 = this.f145009d;
        buffer2.j0(buffer2.size() + ((long) iUpdate));
        if (segmentZ0.f145105b == segmentZ0.f145106c) {
            this.f145009d.f144986a = segmentZ0.b();
            SegmentPool.b(segmentZ0);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f145011g = true;
        this.f145006a.close();
    }

    @Override // okio.Source
    public long t2(Buffer sink, long j3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (this.f145011g) {
            throw new IllegalStateException("closed");
        }
        if (j3 == 0) {
            return 0L;
        }
        b();
        return this.f145009d.t2(sink, j3);
    }

    @Override // okio.Source
    public Timeout v() {
        return this.f145006a.v();
    }
}
