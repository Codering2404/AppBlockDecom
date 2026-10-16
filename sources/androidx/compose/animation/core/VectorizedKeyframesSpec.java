package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntList f4336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntObjectMap f4337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Easing f4340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f4342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f4343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AnimationVector f4344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AnimationVector f4345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AnimationVector f4346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimationVector f4347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float[] f4348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float[] f4349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArcSpline f4350o;

    public /* synthetic */ VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i3, int i4, Easing easing, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i3, i4, easing, i5);
    }

    private final int h(int i3) {
        int iB = IntList.b(this.f4336a, i3, 0, 0, 6, null);
        return iB < -1 ? -(iB + 2) : iB;
    }

    private final float i(int i3) {
        return j(h(i3), i3, false);
    }

    private final float j(int i3, int i4, boolean z2) {
        Easing easingB;
        float f3;
        IntList intList = this.f4336a;
        if (i3 >= intList.f2877b - 1) {
            f3 = i4;
        } else {
            int iE = intList.e(i3);
            int iE2 = this.f4336a.e(i3 + 1);
            if (i4 == iE) {
                f3 = iE;
            } else {
                int i5 = iE2 - iE;
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(iE);
                if (vectorizedKeyframeSpecElementInfo == null || (easingB = vectorizedKeyframeSpecElementInfo.b()) == null) {
                    easingB = this.f4340e;
                }
                float f4 = i5;
                float fA = easingB.a((i4 - iE) / f4);
                if (z2) {
                    return fA;
                }
                f3 = (f4 * fA) + iE;
            }
        }
        return f3 / 1000;
    }

    private final void k(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        float[] fArr;
        boolean z2 = this.f4350o != VectorizedAnimationSpecKt.f4316c;
        if (this.f4344i == null) {
            this.f4344i = AnimationVectorsKt.g(animationVector);
            this.f4345j = AnimationVectorsKt.g(animationVector3);
            int i3 = this.f4336a.f2877b;
            float[] fArr2 = new float[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                fArr2[i4] = this.f4336a.e(i4) / 1000;
            }
            this.f4343h = fArr2;
            int i5 = this.f4336a.f2877b;
            int[] iArr = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(this.f4336a.e(i6));
                int iA = vectorizedKeyframeSpecElementInfo != null ? vectorizedKeyframeSpecElementInfo.a() : this.f4341f;
                if (!ArcMode.d(iA, ArcMode.f3871b.a())) {
                    z2 = true;
                }
                iArr[i6] = iA;
            }
            this.f4342g = iArr;
        }
        if (z2) {
            if (this.f4350o != VectorizedAnimationSpecKt.f4316c && Intrinsics.areEqual(this.f4346k, animationVector) && Intrinsics.areEqual(this.f4347l, animationVector2)) {
                return;
            }
            this.f4346k = animationVector;
            this.f4347l = animationVector2;
            int iB = (animationVector.b() % 2) + animationVector.b();
            this.f4348m = new float[iB];
            this.f4349n = new float[iB];
            int i7 = this.f4336a.f2877b;
            float[][] fArr3 = new float[i7][];
            for (int i8 = 0; i8 < i7; i8++) {
                int iE = this.f4336a.e(i8);
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo2 = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(iE);
                if (iE == 0 && vectorizedKeyframeSpecElementInfo2 == null) {
                    fArr = new float[iB];
                    for (int i9 = 0; i9 < iB; i9++) {
                        fArr[i9] = animationVector.a(i9);
                    }
                } else if (iE == e() && vectorizedKeyframeSpecElementInfo2 == null) {
                    fArr = new float[iB];
                    for (int i10 = 0; i10 < iB; i10++) {
                        fArr[i10] = animationVector2.a(i10);
                    }
                } else {
                    Intrinsics.checkNotNull(vectorizedKeyframeSpecElementInfo2);
                    AnimationVector animationVectorC = vectorizedKeyframeSpecElementInfo2.c();
                    float[] fArr4 = new float[iB];
                    for (int i11 = 0; i11 < iB; i11++) {
                        fArr4[i11] = animationVectorC.a(i11);
                    }
                    fArr = fArr4;
                }
                fArr3[i8] = fArr;
            }
            this.f4350o = new ArcSpline(this.f4342g, this.f4343h, fArr3);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int c() {
        return this.f4339d;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int e() {
        return this.f4338c;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long jE = VectorizedAnimationSpecKt.e(this, j3 / 1000000);
        if (jE < 0) {
            return animationVector3;
        }
        k(animationVector, animationVector2, animationVector3);
        AnimationVector animationVector4 = this.f4345j;
        Intrinsics.checkNotNull(animationVector4);
        int i3 = 0;
        if (this.f4350o != VectorizedAnimationSpecKt.f4316c) {
            float fI = i((int) jE);
            float[] fArr = this.f4349n;
            this.f4350o.b(fI, fArr);
            int length = fArr.length;
            while (i3 < length) {
                animationVector4.e(i3, fArr[i3]);
                i3++;
            }
        } else {
            AnimationVector animationVectorG = VectorizedAnimationSpecKt.g(this, jE - 1, animationVector, animationVector2, animationVector3);
            AnimationVector animationVectorG2 = VectorizedAnimationSpecKt.g(this, jE, animationVector, animationVector2, animationVector3);
            int iB = animationVectorG.b();
            while (i3 < iB) {
                animationVector4.e(i3, (animationVectorG.a(i3) - animationVectorG2.a(i3)) * 1000.0f);
                i3++;
            }
        }
        return animationVector4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AnimationVector animationVectorC;
        AnimationVector animationVectorC2;
        int iE = (int) VectorizedAnimationSpecKt.e(this, j3 / 1000000);
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(iE);
        if (vectorizedKeyframeSpecElementInfo != null) {
            return vectorizedKeyframeSpecElementInfo.c();
        }
        if (iE >= e()) {
            return animationVector2;
        }
        if (iE <= 0) {
            return animationVector;
        }
        k(animationVector, animationVector2, animationVector3);
        AnimationVector animationVector4 = this.f4344i;
        Intrinsics.checkNotNull(animationVector4);
        int i3 = 0;
        if (this.f4350o != VectorizedAnimationSpecKt.f4316c) {
            float fI = i(iE);
            float[] fArr = this.f4348m;
            this.f4350o.a(fI, fArr);
            int length = fArr.length;
            while (i3 < length) {
                animationVector4.e(i3, fArr[i3]);
                i3++;
            }
            return animationVector4;
        }
        int iH = h(iE);
        float fJ = j(iH, iE, true);
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo2 = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(this.f4336a.e(iH));
        if (vectorizedKeyframeSpecElementInfo2 != null && (animationVectorC2 = vectorizedKeyframeSpecElementInfo2.c()) != null) {
            animationVector = animationVectorC2;
        }
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo3 = (VectorizedKeyframeSpecElementInfo) this.f4337b.b(this.f4336a.e(iH + 1));
        if (vectorizedKeyframeSpecElementInfo3 != null && (animationVectorC = vectorizedKeyframeSpecElementInfo3.c()) != null) {
            animationVector2 = animationVectorC;
        }
        int iB = animationVector4.b();
        while (i3 < iB) {
            animationVector4.e(i3, (animationVector.a(i3) * (1 - fJ)) + (animationVector2.a(i3) * fJ));
            i3++;
        }
        return animationVector4;
    }

    private VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i3, int i4, Easing easing, int i5) {
        this.f4336a = intList;
        this.f4337b = intObjectMap;
        this.f4338c = i3;
        this.f4339d = i4;
        this.f4340e = easing;
        this.f4341f = i5;
        this.f4342g = VectorizedAnimationSpecKt.f4314a;
        this.f4343h = VectorizedAnimationSpecKt.f4315b;
        this.f4348m = VectorizedAnimationSpecKt.f4315b;
        this.f4349n = VectorizedAnimationSpecKt.f4315b;
        this.f4350o = VectorizedAnimationSpecKt.f4316c;
    }
}
