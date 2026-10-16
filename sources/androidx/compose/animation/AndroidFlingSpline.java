package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class AndroidFlingSpline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidFlingSpline f3178a = new AndroidFlingSpline();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f3179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float[] f3180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3181d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FlingResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f3182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f3183b;

        public FlingResult(float f3, float f4) {
            this.f3182a = f3;
            this.f3183b = f4;
        }

        public final float a() {
            return this.f3182a;
        }

        public final float b() {
            return this.f3183b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingResult)) {
                return false;
            }
            FlingResult flingResult = (FlingResult) obj;
            return Float.compare(this.f3182a, flingResult.f3182a) == 0 && Float.compare(this.f3183b, flingResult.f3183b) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.f3182a) * 31) + Float.hashCode(this.f3183b);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.f3182a + ", velocityCoefficient=" + this.f3183b + ')';
        }
    }

    static {
        float[] fArr = new float[101];
        f3179b = fArr;
        float[] fArr2 = new float[101];
        f3180c = fArr2;
        SplineBasedDecayKt.b(fArr, fArr2, 100);
        f3181d = 8;
    }

    private AndroidFlingSpline() {
    }

    public final double a(float f3, float f4) {
        return Math.log(((double) (Math.abs(f3) * 0.35f)) / ((double) f4));
    }

    public final FlingResult b(float f3) {
        float f4 = 0.0f;
        float f5 = 1.0f;
        float fO = RangesKt.o(f3, 0.0f, 1.0f);
        float f6 = 100;
        int i3 = (int) (f6 * fO);
        if (i3 < 100) {
            float f7 = i3 / f6;
            int i4 = i3 + 1;
            float f8 = i4 / f6;
            float[] fArr = f3179b;
            float f9 = fArr[i3];
            float f10 = (fArr[i4] - f9) / (f8 - f7);
            float f11 = ((fO - f7) * f10) + f9;
            f4 = f10;
            f5 = f11;
        }
        return new FlingResult(f5, f4);
    }
}
