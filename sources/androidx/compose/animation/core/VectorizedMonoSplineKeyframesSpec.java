package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

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
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntList f4351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntObjectMap f4352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f4355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AnimationVector f4356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AnimationVector f4357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f4358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MonoSpline f4359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[][] f4360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AnimationVector f4361k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimationVector f4362l;

    public VectorizedMonoSplineKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i3, int i4, float f3) {
        this.f4351a = intList;
        this.f4352b = intObjectMap;
        this.f4353c = i3;
        this.f4354d = i4;
        this.f4355e = f3;
    }

    private final int h(int i3) {
        int iB = IntList.b(this.f4351a, i3, 0, 0, 6, null);
        return iB < -1 ? -(iB + 2) : iB;
    }

    private final float i(int i3, int i4) {
        float f3;
        IntList intList = this.f4351a;
        if (i3 >= intList.f2877b - 1) {
            f3 = i4;
        } else {
            int iE = intList.e(i3);
            int iE2 = this.f4351a.e(i3 + 1);
            if (i4 != iE) {
                float f4 = iE2 - iE;
                return ((f4 * j(i3).a((i4 - iE) / f4)) + iE) / 1000;
            }
            f3 = iE;
        }
        return f3 / 1000;
    }

    private final Easing j(int i3) {
        Easing easing;
        Pair pair = (Pair) this.f4352b.b(this.f4351a.e(i3));
        return (pair == null || (easing = (Easing) pair.f()) == null) ? EasingKt.e() : easing;
    }

    private final void k(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        float[] fArr;
        if (this.f4356f == null) {
            this.f4356f = AnimationVectorsKt.g(animationVector);
            this.f4357g = AnimationVectorsKt.g(animationVector3);
            int i3 = this.f4351a.f2877b;
            float[] fArr2 = new float[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                fArr2[i4] = this.f4351a.e(i4) / 1000;
            }
            this.f4358h = fArr2;
        }
        if (this.f4359i != null && Intrinsics.areEqual(this.f4361k, animationVector) && Intrinsics.areEqual(this.f4362l, animationVector2)) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(this.f4361k, animationVector);
        boolean zAreEqual2 = Intrinsics.areEqual(this.f4362l, animationVector2);
        this.f4361k = animationVector;
        this.f4362l = animationVector2;
        int iB = animationVector.b();
        float[][] fArr3 = this.f4360j;
        if (fArr3 == null) {
            int i5 = this.f4351a.f2877b;
            fArr3 = new float[i5][];
            for (int i6 = 0; i6 < i5; i6++) {
                int iE = this.f4351a.e(i6);
                Pair pair = (Pair) this.f4352b.b(iE);
                if (iE == 0 && pair == null) {
                    fArr = new float[iB];
                    for (int i7 = 0; i7 < iB; i7++) {
                        fArr[i7] = animationVector.a(i7);
                    }
                } else if (iE == e() && pair == null) {
                    fArr = new float[iB];
                    for (int i8 = 0; i8 < iB; i8++) {
                        fArr[i8] = animationVector2.a(i8);
                    }
                } else {
                    Intrinsics.checkNotNull(pair);
                    AnimationVector animationVector4 = (AnimationVector) pair.e();
                    float[] fArr4 = new float[iB];
                    for (int i9 = 0; i9 < iB; i9++) {
                        fArr4[i9] = animationVector4.a(i9);
                    }
                    fArr = fArr4;
                }
                fArr3[i6] = fArr;
            }
            this.f4360j = fArr3;
        } else {
            if (!zAreEqual && !this.f4352b.a(0)) {
                int iB2 = IntList.b(this.f4351a, 0, 0, 0, 6, null);
                float[] fArr5 = new float[iB];
                for (int i10 = 0; i10 < iB; i10++) {
                    fArr5[i10] = animationVector.a(i10);
                }
                fArr3[iB2] = fArr5;
            }
            if (!zAreEqual2 && !this.f4352b.a(e())) {
                int iB3 = IntList.b(this.f4351a, e(), 0, 0, 6, null);
                float[] fArr6 = new float[iB];
                for (int i11 = 0; i11 < iB; i11++) {
                    fArr6[i11] = animationVector2.a(i11);
                }
                fArr3[iB3] = fArr6;
            }
        }
        float[] fArr7 = this.f4358h;
        if (fArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("times");
            fArr7 = null;
        }
        this.f4359i = new MonoSpline(fArr7, fArr3, this.f4355e);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int c() {
        return this.f4354d;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int e() {
        return this.f4353c;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int iE = (int) VectorizedAnimationSpecKt.e(this, j3 / 1000000);
        k(animationVector, animationVector2, animationVector3);
        int iH = h(iE);
        AnimationVector animationVector4 = this.f4357g;
        Intrinsics.checkNotNull(animationVector4);
        MonoSpline monoSpline = this.f4359i;
        Intrinsics.checkNotNull(monoSpline);
        monoSpline.b(i(iH, iE), animationVector4, iH);
        return animationVector4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int iE = (int) VectorizedAnimationSpecKt.e(this, j3 / 1000000);
        Pair pair = (Pair) this.f4352b.b(iE);
        if (pair != null) {
            return (AnimationVector) pair.e();
        }
        if (iE >= e()) {
            return animationVector2;
        }
        if (iE <= 0) {
            return animationVector;
        }
        k(animationVector, animationVector2, animationVector3);
        int iH = h(iE);
        AnimationVector animationVector4 = this.f4356f;
        Intrinsics.checkNotNull(animationVector4);
        MonoSpline monoSpline = this.f4359i;
        Intrinsics.checkNotNull(monoSpline);
        monoSpline.a(i(iH, iE), animationVector4, iH);
        return animationVector4;
    }
}
