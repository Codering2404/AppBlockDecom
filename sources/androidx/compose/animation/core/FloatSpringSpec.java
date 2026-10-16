package androidx.compose.animation.core;

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
public final class FloatSpringSpec implements FloatAnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SpringSimulation f3954d;

    public FloatSpringSpec(float f3, float f4, float f5) {
        this.f3951a = f3;
        this.f3952b = f4;
        this.f3953c = f5;
        SpringSimulation springSimulation = new SpringSimulation(1.0f);
        springSimulation.c(f3);
        springSimulation.e(f4);
        this.f3954d = springSimulation;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float b(float f3, float f4, float f5) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float c(long j3, float f3, float f4, float f5) {
        this.f3954d.d(f4);
        return Float.intBitsToFloat((int) (this.f3954d.f(f3, f5, j3 / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float d(long j3, float f3, float f4, float f5) {
        this.f3954d.d(f4);
        return Float.intBitsToFloat((int) (this.f3954d.f(f3, f5, j3 / 1000000) & 4294967295L));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long e(float f3, float f4, float f5) {
        float fB = this.f3954d.b();
        float fA = this.f3954d.a();
        float f6 = f3 - f4;
        float f7 = this.f3953c;
        return SpringEstimationKt.b(fB, fA, f5 / f7, f6 / f7, 1.0f) * 1000000;
    }

    public /* synthetic */ FloatSpringSpec(float f3, float f4, float f5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f3, (i3 & 2) != 0 ? 1500.0f : f4, (i3 & 4) != 0 ? 0.01f : f5);
    }
}
