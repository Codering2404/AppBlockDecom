package androidx.constraintlayout.compose;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class CarouselState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MotionCarouselDirection f30356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30360e;

    public CarouselState(MotionCarouselDirection motionCarouselDirection, int i3, int i4, boolean z2, boolean z3) {
        this.f30356a = motionCarouselDirection;
        this.f30357b = i3;
        this.f30358c = i4;
        this.f30359d = z2;
        this.f30360e = z3;
    }

    public final MotionCarouselDirection a() {
        return this.f30356a;
    }

    public final int b() {
        return this.f30357b;
    }

    public final void c(MotionCarouselDirection motionCarouselDirection) {
        this.f30356a = motionCarouselDirection;
    }

    public final void d(int i3) {
        this.f30357b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselState)) {
            return false;
        }
        CarouselState carouselState = (CarouselState) obj;
        return this.f30356a == carouselState.f30356a && this.f30357b == carouselState.f30357b && this.f30358c == carouselState.f30358c && this.f30359d == carouselState.f30359d && this.f30360e == carouselState.f30360e;
    }

    public int hashCode() {
        return (((((((this.f30356a.hashCode() * 31) + Integer.hashCode(this.f30357b)) * 31) + Integer.hashCode(this.f30358c)) * 31) + Boolean.hashCode(this.f30359d)) * 31) + Boolean.hashCode(this.f30360e);
    }

    public String toString() {
        return "CarouselState(direction=" + this.f30356a + ", index=" + this.f30357b + ", targetIndex=" + this.f30358c + ", snapping=" + this.f30359d + ", animating=" + this.f30360e + ')';
    }
}
