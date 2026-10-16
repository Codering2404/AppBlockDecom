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
public final class SpringSimulation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f4139b = Math.sqrt(50.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f4140c = 1.0f;

    public SpringSimulation(float f3) {
        this.f4138a = f3;
    }

    public final float a() {
        return this.f4140c;
    }

    public final float b() {
        double d3 = this.f4139b;
        return (float) (d3 * d3);
    }

    public final void c(float f3) {
        if (f3 < 0.0f) {
            PreconditionsKt.a("Damping ratio must be non-negative");
        }
        this.f4140c = f3;
    }

    public final void d(float f3) {
        this.f4138a = f3;
    }

    public final void e(float f3) {
        if (b() <= 0.0f) {
            PreconditionsKt.a("Spring stiffness constant must be positive.");
        }
        this.f4139b = Math.sqrt(f3);
    }

    public final long f(float f3, float f4, long j3) {
        double dExp;
        double dExp2;
        float f5 = f3 - this.f4138a;
        double d3 = j3 / 1000.0d;
        float f6 = this.f4140c;
        double d4 = ((double) f6) * ((double) f6);
        double d5 = this.f4139b;
        double d6 = ((double) (-f6)) * d5;
        if (f6 > 1.0f) {
            double dSqrt = d5 * Math.sqrt(d4 - ((double) 1));
            double d7 = d6 + dSqrt;
            double d8 = d6 - dSqrt;
            double d9 = f5;
            double d10 = ((d8 * d9) - ((double) f4)) / (d8 - d7);
            double d11 = d9 - d10;
            double d12 = d8 * d3;
            double d13 = d3 * d7;
            dExp2 = (Math.exp(d12) * d11) + (Math.exp(d13) * d10);
            dExp = (d11 * d8 * Math.exp(d12)) + (d10 * d7 * Math.exp(d13));
        } else if (f6 == 1.0f) {
            double d14 = f5;
            double d15 = ((double) f4) + (d5 * d14);
            double d16 = (-d5) * d3;
            double d17 = d14 + (d3 * d15);
            dExp2 = d17 * Math.exp(d16);
            dExp = (d17 * Math.exp(d16) * (-this.f4139b)) + (d15 * Math.exp(d16));
        } else {
            double d18 = 1;
            double dSqrt2 = d5 * Math.sqrt(d18 - d4);
            double d19 = f5;
            double d20 = (d18 / dSqrt2) * (((-d6) * d19) + ((double) f4));
            double d21 = dSqrt2 * d3;
            double d22 = d3 * d6;
            double dExp3 = Math.exp(d22) * ((Math.cos(d21) * d19) + (Math.sin(d21) * d20));
            dExp = (d6 * dExp3) + (Math.exp(d22) * (((-dSqrt2) * d19 * Math.sin(d21)) + (dSqrt2 * d20 * Math.cos(d21))));
            dExp2 = dExp3;
        }
        return Motion.a((((long) Float.floatToRawIntBits((float) dExp)) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp2 + ((double) this.f4138a))) << 32));
    }
}
