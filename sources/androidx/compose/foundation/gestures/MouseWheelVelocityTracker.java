package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class MouseWheelVelocityTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VelocityTracker1D f6029a = new VelocityTracker1D(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VelocityTracker1D f6030b = new VelocityTracker1D(true);

    public final void a(long j3, long j4) {
        this.f6029a.a(j3, Float.intBitsToFloat((int) (j4 >> 32)));
        this.f6030b.a(j3, Float.intBitsToFloat((int) (j4 & 4294967295L)));
    }

    public final long b() {
        return VelocityKt.a(this.f6029a.d(Float.MAX_VALUE), this.f6030b.d(Float.MAX_VALUE));
    }
}
