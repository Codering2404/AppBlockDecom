package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
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
public final class CubicBezierEasing implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f3900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f3901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f3902f;

    public CubicBezierEasing(float f3, float f4, float f5, float f6) {
        this.f3897a = f3;
        this.f3898b = f4;
        this.f3899c = f5;
        this.f3900d = f6;
        if (!((Float.isNaN(f3) || Float.isNaN(f4) || Float.isNaN(f5) || Float.isNaN(f6)) ? false : true)) {
            PreconditionsKt.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f3 + ", " + f4 + ", " + f5 + ", " + f6 + '.');
        }
        long jB = BezierKt.b(0.0f, f4, f6, 1.0f, new float[5], 0);
        this.f3901e = Float.intBitsToFloat((int) (jB >> 32));
        this.f3902f = Float.intBitsToFloat((int) (jB & 4294967295L));
    }

    private final void b(float f3) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f3897a + ", " + this.f3898b + ", " + this.f3899c + ", " + this.f3900d + ") has no solution at " + f3);
    }

    @Override // androidx.compose.animation.core.Easing
    public float a(float f3) {
        if (f3 > 0.0f && f3 < 1.0f) {
            float fMax = Math.max(f3, 1.1920929E-7f);
            float fL = BezierKt.l(0.0f - fMax, this.f3897a - fMax, this.f3899c - fMax, 1.0f - fMax);
            if (Float.isNaN(fL)) {
                b(f3);
            }
            f3 = BezierKt.e(this.f3898b, this.f3900d, fL);
            float f4 = this.f3901e;
            float f5 = this.f3902f;
            if (f3 < f4) {
                f3 = f4;
            }
            if (f3 > f5) {
                return f5;
            }
        }
        return f3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CubicBezierEasing)) {
            return false;
        }
        CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) obj;
        return this.f3897a == cubicBezierEasing.f3897a && this.f3898b == cubicBezierEasing.f3898b && this.f3899c == cubicBezierEasing.f3899c && this.f3900d == cubicBezierEasing.f3900d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f3897a) * 31) + Float.hashCode(this.f3898b)) * 31) + Float.hashCode(this.f3899c)) * 31) + Float.hashCode(this.f3900d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f3897a + ", b=" + this.f3898b + ", c=" + this.f3899c + ", d=" + this.f3900d + ')';
    }
}
