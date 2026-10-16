package nl.dionsegijn.konfetti.modules;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.models.Vector;

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
public final class VelocityModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f143780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Double f143781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f143782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Float f143783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f143784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f143785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f143786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Random f143787h;

    public VelocityModule(Random random) {
        Intrinsics.checkNotNullParameter(random, "random");
        this.f143787h = random;
        this.f143784e = -1.0f;
        this.f143785f = 1.0f;
        this.f143786g = 0.2f;
    }

    public final float a() {
        return this.f143784e;
    }

    public final double b() {
        Double d3 = this.f143781b;
        if (d3 == null) {
            return this.f143780a;
        }
        Intrinsics.checkNotNull(d3);
        return ((d3.doubleValue() - this.f143780a) * this.f143787h.nextDouble()) + this.f143780a;
    }

    public final float c() {
        float fNextFloat = (this.f143787h.nextFloat() * 2.0f) - 1.0f;
        float f3 = this.f143785f;
        return f3 + (this.f143786g * f3 * fNextFloat);
    }

    public final float d() {
        Float f3 = this.f143783d;
        if (f3 == null) {
            return this.f143782c;
        }
        Intrinsics.checkNotNull(f3);
        return ((f3.floatValue() - this.f143782c) * this.f143787h.nextFloat()) + this.f143782c;
    }

    public final Vector e() {
        float fD = d();
        double dB = b();
        return new Vector(((float) Math.cos(dB)) * fD, fD * ((float) Math.sin(dB)));
    }

    public final void f(Double d3) {
        this.f143781b = d3;
    }

    public final void g(Float f3) {
        Intrinsics.checkNotNull(f3);
        if (f3.floatValue() < 0) {
            f3 = Float.valueOf(0.0f);
        }
        this.f143783d = f3;
    }

    public final void h(double d3) {
        this.f143780a = d3;
    }

    public final void i(float f3) {
        if (f3 < 0) {
            f3 = 0.0f;
        }
        this.f143782c = f3;
    }
}
