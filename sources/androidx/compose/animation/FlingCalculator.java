package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

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
public final class FlingCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f3573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f3574c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FlingInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f3575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f3576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f3577c;

        public FlingInfo(float f3, float f4, long j3) {
            this.f3575a = f3;
            this.f3576b = f4;
            this.f3577c = j3;
        }

        public final float a(long j3) {
            long j4 = this.f3577c;
            return this.f3576b * Math.signum(this.f3575a) * AndroidFlingSpline.f3178a.b(j4 > 0 ? j3 / j4 : 1.0f).a();
        }

        public final float b(long j3) {
            long j4 = this.f3577c;
            return (((AndroidFlingSpline.f3178a.b(j4 > 0 ? j3 / j4 : 1.0f).b() * Math.signum(this.f3575a)) * this.f3576b) / this.f3577c) * 1000.0f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            return Float.compare(this.f3575a, flingInfo.f3575a) == 0 && Float.compare(this.f3576b, flingInfo.f3576b) == 0 && this.f3577c == flingInfo.f3577c;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f3575a) * 31) + Float.hashCode(this.f3576b)) * 31) + Long.hashCode(this.f3577c);
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.f3575a + ", distance=" + this.f3576b + ", duration=" + this.f3577c + ')';
        }
    }

    public FlingCalculator(float f3, Density density) {
        this.f3572a = f3;
        this.f3573b = density;
        this.f3574c = a(density);
    }

    private final float a(Density density) {
        return FlingCalculatorKt.c(0.84f, density.getDensity());
    }

    private final double e(float f3) {
        return AndroidFlingSpline.f3178a.a(f3, this.f3572a * this.f3574c);
    }

    public final float b(float f3) {
        return (float) (((double) (this.f3572a * this.f3574c)) * Math.exp((((double) FlingCalculatorKt.f3578a) / (((double) FlingCalculatorKt.f3578a) - 1.0d)) * e(f3)));
    }

    public final long c(float f3) {
        return (long) (Math.exp(e(f3) / (((double) FlingCalculatorKt.f3578a) - 1.0d)) * 1000.0d);
    }

    public final FlingInfo d(float f3) {
        double dE = e(f3);
        double d3 = ((double) FlingCalculatorKt.f3578a) - 1.0d;
        return new FlingInfo(f3, (float) (((double) (this.f3572a * this.f3574c)) * Math.exp((((double) FlingCalculatorKt.f3578a) / d3) * dE)), (long) (Math.exp(dE / d3) * 1000.0d));
    }
}
