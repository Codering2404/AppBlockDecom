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
public final class EasingFunctionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Easing f3919a = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Easing f3920b = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Easing f3921c = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Easing f3922d = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Easing f3923e = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Easing f3924f = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Easing f3925g = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Easing f3926h = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Easing f3927i = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Easing f3928j = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Easing f3929k = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Easing f3930l = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Easing f3931m = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Easing f3932n = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Easing f3933o = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Easing f3934p = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Easing f3935q = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Easing f3936r = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Easing f3937s = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Easing f3938t = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Easing f3939u = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Easing f3940v = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Easing f3941w = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Easing f3942x = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Easing f3943y = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Easing f3944z = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);
    private static final Easing A = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);
    private static final Easing B = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);
    private static final Easing C = new Easing() { // from class: androidx.compose.animation.core.a
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.h(f3);
        }
    };
    private static final Easing D = new Easing() { // from class: androidx.compose.animation.core.b
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.l(f3);
        }
    };
    private static final Easing E = new Easing() { // from class: androidx.compose.animation.core.c
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.j(f3);
        }
    };
    private static final Easing F = new Easing() { // from class: androidx.compose.animation.core.d
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.k(f3);
        }
    };
    private static final Easing G = new Easing() { // from class: androidx.compose.animation.core.e
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.g(f3);
        }
    };
    private static final Easing H = new Easing() { // from class: androidx.compose.animation.core.f
        @Override // androidx.compose.animation.core.Easing
        public final float a(float f3) {
            return EasingFunctionsKt.i(f3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(float f3) {
        return 1 - F.a(1.0f - f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        if (f3 == 1.0f) {
            return 1.0f;
        }
        return (float) (((double) (-((float) Math.pow(2.0f, r6 - 10.0f)))) * Math.sin(((double) ((f3 * 10.0f) - 10.75f)) * 2.0943951023931953d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i(float f3) {
        return (((double) f3) < 0.5d ? 1 - F.a(1.0f - (f3 * 2.0f)) : 1 + F.a((f3 * 2.0f) - 1.0f)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        if (f3 == 1.0f) {
            return 1.0f;
        }
        if (0.0f > f3 || f3 > 0.5f) {
            double d3 = 2.0f;
            return ((float) ((((double) ((float) Math.pow(d3, ((-20.0f) * f3) + 10.0f))) * Math.sin(((double) ((f3 * 20.0f) - 11.125f)) * 1.3962634015954636d)) / d3)) + 1.0f;
        }
        double d4 = 2.0f;
        return (float) ((-(((double) ((float) Math.pow(d4, r12 - 10.0f))) * Math.sin(((double) ((f3 * 20.0f) - 11.125f)) * 1.3962634015954636d))) / d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(float f3) {
        if (f3 < 0.36363637f) {
            return 7.5625f * f3 * f3;
        }
        if (f3 < 0.72727275f) {
            float f4 = f3 - 0.54545456f;
            return (7.5625f * f4 * f4) + 0.75f;
        }
        if (f3 < 0.90909094f) {
            float f5 = f3 - 0.8181818f;
            return (7.5625f * f5 * f5) + 0.9375f;
        }
        float f6 = f3 - 0.95454544f;
        return (7.5625f * f6 * f6) + 0.984375f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        if (f3 == 1.0f) {
            return 1.0f;
        }
        return (float) ((((double) ((float) Math.pow(2.0f, (-10.0f) * f3))) * Math.sin(((double) ((f3 * 10.0f) - 0.75f)) * 2.0943951023931953d)) + ((double) 1.0f));
    }

    public static final Easing m() {
        return f3925g;
    }
}
