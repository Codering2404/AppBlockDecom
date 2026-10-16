package androidx.compose.material3.carousel;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Arrangement {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f21603h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f21605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f21607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f21609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21610g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float a(float f3, int i3, float f4, int i4, int i5) {
            float f5 = i4 / 2.0f;
            return (f3 - ((i3 + f5) * f4)) / (i5 + f5);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final androidx.compose.material3.carousel.Arrangement c(int r5, float r6, float r7, int r8, float r9, float r10, float r11, int r12, float r13, int r14, float r15) {
            /*
                r4 = this;
                int r0 = r14 + r12
                int r0 = r0 + r8
                int r0 = r0 + (-1)
                float r0 = (float) r0
                float r0 = r0 * r7
                float r7 = r6 - r0
                float r6 = kotlin.ranges.RangesKt.o(r9, r10, r11)
                float r0 = (float) r14
                float r9 = r15 * r0
                float r1 = (float) r12
                float r13 = r13 * r1
                float r9 = r9 + r13
                float r13 = (float) r8
                float r2 = r6 * r13
                float r9 = r9 + r2
                float r9 = r7 - r9
                r2 = 0
                if (r8 <= 0) goto L28
                int r3 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r3 <= 0) goto L28
                float r9 = r9 / r13
                float r11 = r11 - r6
                float r9 = java.lang.Math.min(r9, r11)
            L26:
                float r6 = r6 + r9
                goto L35
            L28:
                if (r8 <= 0) goto L35
                int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r11 >= 0) goto L35
                float r9 = r9 / r13
                float r10 = r10 - r6
                float r9 = java.lang.Math.max(r9, r10)
                goto L26
            L35:
                if (r8 <= 0) goto L3c
                r9 = r6
                r10 = r12
                r11 = r14
                r6 = r4
                goto L40
            L3c:
                r9 = r2
                r6 = r4
                r10 = r12
                r11 = r14
            L40:
                float r7 = r6.a(r7, r8, r9, r10, r11)
                r6 = r9
                float r9 = r7 + r6
                r12 = 1073741824(0x40000000, float:2.0)
                float r9 = r9 / r12
                if (r10 <= 0) goto L69
                int r12 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
                if (r12 != 0) goto L51
                goto L69
            L51:
                float r15 = r15 - r7
                float r15 = r15 * r0
                r12 = 1036831949(0x3dcccccd, float:0.1)
                float r12 = r12 * r9
                float r12 = r12 * r1
                float r13 = java.lang.Math.abs(r15)
                float r12 = java.lang.Math.min(r13, r12)
                int r13 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
                if (r13 <= 0) goto L6e
                float r13 = r12 / r1
                float r9 = r9 - r13
                float r12 = r12 / r0
                float r7 = r7 + r12
            L69:
                r14 = r7
                r12 = r9
                r15 = r11
                r11 = r8
                goto L74
            L6e:
                float r13 = r12 / r1
                float r9 = r9 + r13
                float r12 = r12 / r0
                float r7 = r7 - r12
                goto L69
            L74:
                androidx.compose.material3.carousel.Arrangement r8 = new androidx.compose.material3.carousel.Arrangement
                r9 = r5
                r13 = r10
                r10 = r6
                r8.<init>(r9, r10, r11, r12, r13, r14, r15)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.c(int, float, float, int, float, float, float, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }

        public final Arrangement b(float f3, float f4, float f5, float f6, float f7, int[] iArr, float f8, int[] iArr2, float f9, int[] iArr3) {
            int[] iArr4 = iArr;
            int length = iArr3.length;
            Arrangement arrangement = null;
            int i3 = 1;
            int i4 = 0;
            while (i4 < length) {
                int i5 = iArr3[i4];
                int length2 = iArr2.length;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = iArr2[i6];
                    int length3 = iArr4.length;
                    int i8 = 0;
                    while (i8 < length3) {
                        int i9 = i6;
                        int i10 = iArr4[i8];
                        Arrangement arrangement2 = arrangement;
                        int i11 = i4;
                        int i12 = length2;
                        int i13 = length3;
                        int i14 = i8;
                        Arrangement arrangementC = c(i3, f3, f4, i10, f5, f6, f7, i7, f8, i5, f9);
                        if (arrangement2 != null && arrangementC.b(f9) >= arrangement2.b(f9)) {
                            arrangement = arrangement2;
                        } else {
                            if (arrangementC.b(f9) == 0.0f) {
                                return arrangementC;
                            }
                            arrangement = arrangementC;
                        }
                        i3++;
                        i8 = i14 + 1;
                        iArr4 = iArr;
                        i4 = i11;
                        length2 = i12;
                        i6 = i9;
                        length3 = i13;
                    }
                    i6++;
                    iArr4 = iArr;
                }
                i4++;
                iArr4 = iArr;
            }
            return arrangement;
        }

        private Companion() {
        }
    }

    public Arrangement(int i3, float f3, int i4, float f4, int i5, float f5, int i6) {
        this.f21604a = i3;
        this.f21605b = f3;
        this.f21606c = i4;
        this.f21607d = f4;
        this.f21608e = i5;
        this.f21609f = f5;
        this.f21610g = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float b(float f3) {
        if (i()) {
            return Math.abs(f3 - this.f21609f) * this.f21604a;
        }
        return Float.MAX_VALUE;
    }

    private final boolean i() {
        int i3 = this.f21610g;
        if (i3 <= 0 || this.f21606c <= 0 || this.f21608e <= 0) {
            return i3 <= 0 || this.f21606c <= 0 || this.f21609f > this.f21605b;
        }
        float f3 = this.f21609f;
        float f4 = this.f21607d;
        return f3 > f4 && f4 > this.f21605b;
    }

    public final int c() {
        return this.f21610g;
    }

    public final float d() {
        return this.f21609f;
    }

    public final int e() {
        return this.f21608e;
    }

    public final float f() {
        return this.f21607d;
    }

    public final int g() {
        return this.f21606c;
    }

    public final float h() {
        return this.f21605b;
    }

    public final int j() {
        return this.f21610g + this.f21608e + this.f21606c;
    }
}
