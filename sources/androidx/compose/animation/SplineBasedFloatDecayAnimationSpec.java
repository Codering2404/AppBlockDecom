package androidx.compose.animation;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;
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
public final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlingCalculator f3754a;

    public SplineBasedFloatDecayAnimationSpec(Density density) {
        this.f3754a = new FlingCalculator(SplineBasedFloatDecayAnimationSpec_androidKt.a(), density);
    }

    private final float f(float f3) {
        return this.f3754a.b(f3) * Math.signum(f3);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float a() {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float b(long j3, float f3, float f4) {
        return this.f3754a.d(f4).b(j3 / 1000000);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long c(float f3, float f4) {
        return this.f3754a.c(f4) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float d(float f3, float f4) {
        return f3 + f(f4);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float e(long j3, float f3, float f4) {
        return f3 + this.f3754a.d(f4).a(j3 / 1000000);
    }
}
