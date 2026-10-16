package androidx.compose.foundation.layout;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.foundation.layout.AndroidFlingSpline;
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
final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7159a;

    public SplineBasedFloatDecayAnimationSpec(Density density) {
        this.f7159a = density.getDensity() * 386.0878f * 160.0f * 0.84f;
    }

    private final double g(float f3) {
        return AndroidFlingSpline.f6566a.a(f3, WindowInsetsConnection_androidKt.f7174a * this.f7159a);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float a() {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float b(long j3, float f3, float f4) {
        long jC = c(0.0f, f4);
        return ((AndroidFlingSpline.FlingResult.d(AndroidFlingSpline.f6566a.b(jC > 0 ? j3 / jC : 1.0f)) * f(f4)) / jC) * 1.0E9f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long c(float f3, float f4) {
        return (long) (Math.exp(g(f4) / WindowInsetsConnection_androidKt.f7176c) * 1.0E9d);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float d(float f3, float f4) {
        return f3 + f(f4);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float e(long j3, float f3, float f4) {
        long jC = c(0.0f, f4);
        return f3 + (f(f4) * AndroidFlingSpline.FlingResult.c(AndroidFlingSpline.f6566a.b(jC > 0 ? j3 / jC : 1.0f)));
    }

    public final float f(float f3) {
        return ((float) (((double) (WindowInsetsConnection_androidKt.f7174a * this.f7159a)) * Math.exp((WindowInsetsConnection_androidKt.f7175b / WindowInsetsConnection_androidKt.f7176c) * g(f3)))) * Math.signum(f3);
    }
}
