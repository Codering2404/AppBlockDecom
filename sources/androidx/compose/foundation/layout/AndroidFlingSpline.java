package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

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
final class AndroidFlingSpline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidFlingSpline f6566a = new AndroidFlingSpline();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f6567b = new float[101];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float[] f6568c = new float[101];

    static {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = 0.0f;
        int i3 = 0;
        float f14 = 0.0f;
        while (true) {
            float f15 = 1.0f;
            if (i3 >= 100) {
                f6568c[100] = 1.0f;
                f6567b[100] = 1.0f;
                return;
            }
            float f16 = i3 / 100;
            float f17 = 1.0f;
            while (true) {
                f3 = ((f17 - f13) / 2.0f) + f13;
                f4 = f15 - f3;
                f5 = f3 * 3.0f * f4;
                f6 = f3 * f3 * f3;
                float f18 = (((f4 * 0.175f) + (f3 * 0.35000002f)) * f5) + f6;
                f7 = f15;
                f8 = f16;
                if (Math.abs(f18 - f16) < 1.0E-5d) {
                    break;
                }
                if (f18 > f8) {
                    f17 = f3;
                } else {
                    f13 = f3;
                }
                f15 = f7;
                f16 = f8;
            }
            f6567b[i3] = (f5 * ((f4 * 0.5f) + f3)) + f6;
            float f19 = f7;
            while (true) {
                f9 = ((f19 - f14) / 2.0f) + f14;
                f10 = f7 - f9;
                f11 = f9 * 3.0f * f10;
                f12 = f9 * f9 * f9;
                float f20 = (((f10 * 0.5f) + f9) * f11) + f12;
                if (Math.abs(f20 - f8) >= 1.0E-5d) {
                    if (f20 > f8) {
                        f19 = f9;
                    } else {
                        f14 = f9;
                    }
                }
            }
            f6568c[i3] = (f11 * ((f10 * 0.175f) + (f9 * 0.35000002f))) + f12;
            i3++;
        }
    }

    private AndroidFlingSpline() {
    }

    public final double a(float f3, float f4) {
        return Math.log(((double) (Math.abs(f3) * 0.35f)) / ((double) f4));
    }

    public final long b(float f3) {
        float f4;
        float f5;
        float f6 = 100;
        int i3 = (int) (f6 * f3);
        if (i3 < 100) {
            float f7 = i3 / f6;
            int i4 = i3 + 1;
            float f8 = i4 / f6;
            float[] fArr = f6567b;
            float f9 = fArr[i3];
            f5 = (fArr[i4] - f9) / (f8 - f7);
            f4 = f9 + ((f3 - f7) * f5);
        } else {
            f4 = 1.0f;
            f5 = 0.0f;
        }
        return FlingResult.a((((long) Float.floatToRawIntBits(f5)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class FlingResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6569a;

        public static boolean b(long j3, Object obj) {
            return (obj instanceof FlingResult) && j3 == ((FlingResult) obj).g();
        }

        public static final float c(long j3) {
            return Float.intBitsToFloat((int) (j3 >> 32));
        }

        public static final float d(long j3) {
            return Float.intBitsToFloat((int) (j3 & 4294967295L));
        }

        public static int e(long j3) {
            return Long.hashCode(j3);
        }

        public static String f(long j3) {
            return "FlingResult(packedValue=" + j3 + ')';
        }

        public boolean equals(Object obj) {
            return b(this.f6569a, obj);
        }

        public final /* synthetic */ long g() {
            return this.f6569a;
        }

        public int hashCode() {
            return e(this.f6569a);
        }

        public String toString() {
            return f(this.f6569a);
        }

        public static long a(long j3) {
            return j3;
        }
    }
}
