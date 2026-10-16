package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

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
public final class FixedLengthSource extends ForwardingSource {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f145168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f145169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f145170d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source delegate, long j3, boolean z2) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f145168b = j3;
        this.f145169c = z2;
    }

    private final void b(Buffer buffer, long j3) throws EOFException {
        Buffer buffer2 = new Buffer();
        buffer2.K0(buffer);
        buffer.H0(buffer2, j3);
        buffer2.a();
    }

    @Override // okio.ForwardingSource, okio.Source
    public long t2(Buffer sink, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j4 = this.f145170d;
        long j5 = this.f145168b;
        if (j4 > j5) {
            j3 = 0;
        } else if (this.f145169c) {
            long j6 = j5 - j4;
            if (j6 == 0) {
                return -1L;
            }
            j3 = Math.min(j3, j6);
        }
        long jT2 = super.t2(sink, j3);
        if (jT2 != -1) {
            this.f145170d += jT2;
        }
        long j7 = this.f145170d;
        long j8 = this.f145168b;
        if ((j7 >= j8 || jT2 != -1) && j7 <= j8) {
            return jT2;
        }
        if (jT2 > 0 && j7 > j8) {
            b(sink, sink.size() - (this.f145170d - this.f145168b));
        }
        throw new IOException("expected " + this.f145168b + " bytes but got " + this.f145170d);
    }
}
