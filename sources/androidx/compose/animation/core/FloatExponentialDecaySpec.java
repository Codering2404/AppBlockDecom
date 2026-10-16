package androidx.compose.animation.core;

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
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3950b;

    public FloatExponentialDecaySpec(float f3, float f4) {
        this.f3949a = Math.max(1.0E-7f, Math.abs(f4));
        this.f3950b = Math.max(1.0E-4f, f3) * (-4.2f);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float a() {
        return this.f3949a;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float b(long j3, float f3, float f4) {
        return f4 * ((float) Math.exp(((j3 / 1000000) / 1000.0f) * this.f3950b));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long c(float f3, float f4) {
        return ((long) ((((float) Math.log(a() / Math.abs(f4))) * 1000.0f) / this.f3950b)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float d(float f3, float f4) {
        if (Math.abs(f4) <= a()) {
            return f3;
        }
        double dLog = Math.log(Math.abs(a() / f4));
        float f5 = this.f3950b;
        return (f3 - (f4 / f5)) + ((f4 / f5) * ((float) Math.exp((((double) f5) * ((dLog / ((double) f5)) * ((double) 1000))) / ((double) 1000.0f))));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float e(long j3, float f3, float f4) {
        float f5 = this.f3950b;
        return (f3 - (f4 / f5)) + ((f4 / f5) * ((float) Math.exp((f5 * (j3 / 1000000)) / 1000.0f)));
    }
}
