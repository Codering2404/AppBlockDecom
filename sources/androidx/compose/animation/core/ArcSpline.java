package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ArcSpline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Arc[][] f3876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3877b = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Arc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f3878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f3879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f3880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f3881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f3882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f3883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f3884g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f3885h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f3886i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float[] f3887j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final float f3888k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final float f3889l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final float f3890m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f3891n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f3892o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f3893p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final float f3894q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final float f3895r;

        public Arc(int i3, float f3, float f4, float f5, float f6, float f7, float f8) {
            this.f3878a = f3;
            this.f3879b = f4;
            this.f3880c = f5;
            this.f3881d = f6;
            this.f3882e = f7;
            this.f3883f = f8;
            float f9 = f7 - f5;
            float f10 = f8 - f6;
            boolean z2 = true;
            boolean z3 = i3 == 1 || (i3 == 4 ? f10 > 0.0f : !(i3 != 5 || f10 >= 0.0f));
            float f11 = z3 ? -1.0f : 1.0f;
            this.f3890m = f11;
            float f12 = 1 / (f4 - f3);
            this.f3888k = f12;
            this.f3887j = new float[101];
            boolean z4 = i3 == 3;
            if (z4 || Math.abs(f9) < 0.001f || Math.abs(f10) < 0.001f) {
                float fHypot = (float) Math.hypot(f10, f9);
                this.f3884g = fHypot;
                this.f3889l = fHypot * f12;
                this.f3894q = f9 * f12;
                this.f3895r = f10 * f12;
                this.f3891n = Float.NaN;
                this.f3892o = Float.NaN;
            } else {
                this.f3891n = f9 * f11;
                this.f3892o = f10 * (-f11);
                this.f3894q = z3 ? f7 : f5;
                this.f3895r = z3 ? f6 : f8;
                c(f5, f6, f7, f8);
                this.f3889l = this.f3884g * f12;
                z2 = z4;
            }
            this.f3893p = z2;
        }

        private final float j(float f3) {
            if (f3 <= 0.0f) {
                return 0.0f;
            }
            if (f3 >= 1.0f) {
                return 1.0f;
            }
            float f4 = f3 * 100;
            int i3 = (int) f4;
            float f5 = f4 - i3;
            float[] fArr = this.f3887j;
            float f6 = fArr[i3];
            return f6 + (f5 * (fArr[i3 + 1] - f6));
        }

        public final void c(float f3, float f4, float f5, float f6) {
            float f7;
            float f8;
            float fHypot;
            float f9 = f5 - f3;
            float f10 = f4 - f6;
            float[] fArr = ArcSplineKt.f3896a;
            int length = fArr.length - 1;
            float f11 = length;
            float[] fArr2 = this.f3887j;
            if (1 <= length) {
                float f12 = f10;
                int i3 = 1;
                fHypot = 0.0f;
                float f13 = 0.0f;
                while (true) {
                    f8 = 0.0f;
                    double radians = (float) Math.toRadians((((double) i3) * 90.0d) / ((double) length));
                    float fSin = ((float) Math.sin(radians)) * f9;
                    float fCos = ((float) Math.cos(radians)) * f10;
                    f7 = f11;
                    fHypot += (float) Math.hypot(fSin - f13, fCos - f12);
                    fArr[i3] = fHypot;
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                    f12 = fCos;
                    f11 = f7;
                    f13 = fSin;
                }
            } else {
                f7 = f11;
                f8 = 0.0f;
                fHypot = 0.0f;
            }
            this.f3884g = fHypot;
            if (1 <= length) {
                int i4 = 1;
                while (true) {
                    fArr[i4] = fArr[i4] / fHypot;
                    if (i4 == length) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            int length2 = fArr2.length;
            for (int i5 = 0; i5 < length2; i5++) {
                float f14 = i5 / 100.0f;
                int iBinarySearch$default = ArraysKt.binarySearch$default(fArr, f14, 0, 0, 6, (Object) null);
                if (iBinarySearch$default >= 0) {
                    fArr2[i5] = iBinarySearch$default / f7;
                } else if (iBinarySearch$default == -1) {
                    fArr2[i5] = f8;
                } else {
                    int i6 = -iBinarySearch$default;
                    int i7 = i6 - 2;
                    float f15 = i7;
                    float f16 = fArr[i7];
                    fArr2[i5] = (f15 + ((f14 - f16) / (fArr[i6 - 1] - f16))) / f7;
                }
            }
        }

        public final float d() {
            float f3 = this.f3891n * this.f3886i;
            return f3 * this.f3890m * (this.f3889l / ((float) Math.hypot(f3, (-this.f3892o) * this.f3885h)));
        }

        public final float e() {
            float f3 = this.f3891n * this.f3886i;
            float f4 = (-this.f3892o) * this.f3885h;
            return f4 * this.f3890m * (this.f3889l / ((float) Math.hypot(f3, f4)));
        }

        public final float f(float f3) {
            float f4 = (f3 - this.f3878a) * this.f3888k;
            float f5 = this.f3880c;
            return f5 + (f4 * (this.f3882e - f5));
        }

        public final float g(float f3) {
            float f4 = (f3 - this.f3878a) * this.f3888k;
            float f5 = this.f3881d;
            return f5 + (f4 * (this.f3883f - f5));
        }

        public final float h() {
            return this.f3878a;
        }

        public final float i() {
            return this.f3879b;
        }

        public final void k(float f3) {
            double dJ = j((this.f3890m == -1.0f ? this.f3879b - f3 : f3 - this.f3878a) * this.f3888k) * 1.5707964f;
            this.f3885h = (float) Math.sin(dJ);
            this.f3886i = (float) Math.cos(dJ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[PHI: r10
      0x0028: PHI (r10v1 int) = (r10v0 int), (r10v3 int), (r10v4 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ArcSpline(int[] r22, float[] r23, float[][] r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r0.<init>()
            r2 = 1
            r0.f3877b = r2
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = new androidx.compose.animation.core.ArcSpline.Arc[r3][]
            r5 = 0
            r7 = r2
            r8 = r7
            r6 = r5
        L12:
            if (r6 >= r3) goto L69
            r9 = r22[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L28
            if (r9 == r2) goto L31
            if (r9 == r11) goto L2f
            if (r9 == r10) goto L2a
            r10 = 4
            if (r9 == r10) goto L28
            r10 = 5
            if (r9 == r10) goto L28
            r13 = r8
            goto L33
        L28:
            r13 = r10
            goto L33
        L2a:
            if (r7 != r2) goto L31
            goto L2f
        L2d:
            r13 = r7
            goto L33
        L2f:
            r7 = r11
            goto L2d
        L31:
            r7 = r2
            goto L2d
        L33:
            r8 = r24[r6]
            int r9 = r6 + 1
            r10 = r24[r9]
            r14 = r1[r6]
            r15 = r1[r9]
            int r12 = r8.length
            int r12 = r12 / r11
            int r2 = r8.length
            int r2 = r2 % r11
            int r2 = r2 + r12
            androidx.compose.animation.core.ArcSpline$Arc[] r11 = new androidx.compose.animation.core.ArcSpline.Arc[r2]
            r12 = r5
        L45:
            if (r12 >= r2) goto L63
            int r16 = r12 * 2
            r17 = r12
            androidx.compose.animation.core.ArcSpline$Arc r12 = new androidx.compose.animation.core.ArcSpline$Arc
            r18 = r16
            r16 = r8[r18]
            int r19 = r18 + 1
            r20 = r17
            r17 = r8[r19]
            r18 = r10[r18]
            r19 = r10[r19]
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r11[r20] = r12
            int r12 = r20 + 1
            goto L45
        L63:
            r4[r6] = r11
            r6 = r9
            r8 = r13
            r2 = 1
            goto L12
        L69:
            r0.f3876a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.<init>(int[], float[], float[][]):void");
    }

    public final void a(float f3, float[] fArr) {
        Arc[][] arcArr = this.f3876a;
        int length = arcArr.length - 1;
        int i3 = 0;
        float fH = arcArr[0][0].h();
        float fI = arcArr[length][0].i();
        int length2 = fArr.length;
        if (!this.f3877b) {
            f3 = Math.min(Math.max(f3, fH), fI);
        } else if (f3 < fH || f3 > fI) {
            if (f3 > fI) {
                fH = fI;
            } else {
                length = 0;
            }
            float f4 = f3 - fH;
            int i4 = 0;
            while (i3 < length2 - 1) {
                Arc arc = arcArr[length][i4];
                if (arc.f3893p) {
                    fArr[i3] = arc.f(fH) + (arc.f3894q * f4);
                    fArr[i3 + 1] = arc.g(fH) + (arc.f3895r * f4);
                } else {
                    arc.k(fH);
                    fArr[i3] = arc.f3894q + (arc.f3891n * arc.f3885h) + (arc.d() * f4);
                    fArr[i3 + 1] = arc.f3895r + (arc.f3892o * arc.f3886i) + (arc.e() * f4);
                }
                i3 += 2;
                i4++;
            }
            return;
        }
        boolean z2 = false;
        for (Arc[] arcArr2 : arcArr) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2 - 1) {
                Arc arc2 = arcArr2[i6];
                if (f3 <= arc2.i()) {
                    if (arc2.f3893p) {
                        fArr[i5] = arc2.f(f3);
                        fArr[i5 + 1] = arc2.g(f3);
                    } else {
                        arc2.k(f3);
                        fArr[i5] = arc2.f3894q + (arc2.f3891n * arc2.f3885h);
                        fArr[i5 + 1] = arc2.f3895r + (arc2.f3892o * arc2.f3886i);
                    }
                    z2 = true;
                }
                i5 += 2;
                i6++;
            }
            if (z2) {
                return;
            }
        }
    }

    public final void b(float f3, float[] fArr) {
        Arc[][] arcArr = this.f3876a;
        float fH = arcArr[0][0].h();
        float fI = arcArr[arcArr.length - 1][0].i();
        if (f3 < fH) {
            f3 = fH;
        }
        if (f3 <= fI) {
            fI = f3;
        }
        int length = fArr.length;
        boolean z2 = false;
        for (Arc[] arcArr2 : arcArr) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < length - 1) {
                Arc arc = arcArr2[i4];
                if (fI <= arc.i()) {
                    if (arc.f3893p) {
                        fArr[i3] = arc.f3894q;
                        fArr[i3 + 1] = arc.f3895r;
                    } else {
                        arc.k(fI);
                        fArr[i3] = arc.d();
                        fArr[i3 + 1] = arc.e();
                    }
                    z2 = true;
                }
                i3 += 2;
                i4++;
            }
            if (z2) {
                return;
            }
        }
    }
}
