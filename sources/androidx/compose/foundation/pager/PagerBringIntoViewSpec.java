package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
final class PagerBringIntoViewSpec implements BringIntoViewSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PagerState f8665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BringIntoViewSpec f8666c;

    public PagerBringIntoViewSpec(PagerState pagerState, BringIntoViewSpec bringIntoViewSpec) {
        this.f8665b = pagerState;
        this.f8666c = bringIntoViewSpec;
    }

    private final float b(float f3) {
        float fZ = this.f8665b.z() * (-1);
        while (f3 > 0.0f && fZ < f3) {
            fZ += this.f8665b.J();
        }
        while (f3 < 0.0f && fZ > f3) {
            fZ -= this.f8665b.J();
        }
        return fZ;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float a(float f3, float f4, float f5) {
        float fA = this.f8666c.a(f3, f4, f5);
        boolean z2 = false;
        if (f3 <= 0.0f ? f3 + f4 <= 0.0f : f3 + f4 > f5) {
            z2 = true;
        }
        if (Math.abs(fA) != 0.0f && z2) {
            return b(fA);
        }
        if (Math.abs(this.f8665b.z()) < 1.0E-6d) {
            return 0.0f;
        }
        float fZ = this.f8665b.z() * (-1.0f);
        if (this.f8665b.B()) {
            fZ += this.f8665b.J();
        }
        return RangesKt.o(fZ, -f5, f5);
    }
}
