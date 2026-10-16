package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class TouchSlopDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Orientation f6286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6287b;

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, j3);
    }

    private final long b(float f3) {
        if (this.f6286a == null) {
            long j3 = this.f6287b;
            return Offset.p(this.f6287b, Offset.r(Offset.h(j3, Offset.k(j3)), f3));
        }
        float fD = d(this.f6287b) - (Math.signum(d(this.f6287b)) * f3);
        float fC = c(this.f6287b);
        if (this.f6286a == Orientation.f6032b) {
            return Offset.e((((long) Float.floatToRawIntBits(fD)) << 32) | (((long) Float.floatToRawIntBits(fC)) & 4294967295L));
        }
        return Offset.e((((long) Float.floatToRawIntBits(fC)) << 32) | (((long) Float.floatToRawIntBits(fD)) & 4294967295L));
    }

    public final long a(PointerInputChange pointerInputChange, float f3) {
        long jQ = Offset.q(this.f6287b, Offset.p(pointerInputChange.h(), pointerInputChange.k()));
        this.f6287b = jQ;
        return (this.f6286a == null ? Offset.k(jQ) : Math.abs(d(jQ))) >= f3 ? b(f3) : Offset.f25596b.b();
    }

    public final float c(long j3) {
        return Float.intBitsToFloat((int) (this.f6286a == Orientation.f6032b ? j3 & 4294967295L : j3 >> 32));
    }

    public final float d(long j3) {
        return Float.intBitsToFloat((int) (this.f6286a == Orientation.f6032b ? j3 >> 32 : j3 & 4294967295L));
    }

    public final void e() {
        this.f6287b = Offset.f25596b.c();
    }

    private TouchSlopDetector(Orientation orientation, long j3) {
        this.f6286a = orientation;
        this.f6287b = j3;
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : orientation, (i3 & 2) != 0 ? Offset.f25596b.c() : j3, null);
    }
}
