package androidx.compose.material.ripple;

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
public final class RippleAlpha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f15351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f15352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f15353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f15354d;

    public RippleAlpha(float f3, float f4, float f5, float f6) {
        this.f15351a = f3;
        this.f15352b = f4;
        this.f15353c = f5;
        this.f15354d = f6;
    }

    public final float a() {
        return this.f15351a;
    }

    public final float b() {
        return this.f15352b;
    }

    public final float c() {
        return this.f15353c;
    }

    public final float d() {
        return this.f15354d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleAlpha)) {
            return false;
        }
        RippleAlpha rippleAlpha = (RippleAlpha) obj;
        return this.f15351a == rippleAlpha.f15351a && this.f15352b == rippleAlpha.f15352b && this.f15353c == rippleAlpha.f15353c && this.f15354d == rippleAlpha.f15354d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f15351a) * 31) + Float.hashCode(this.f15352b)) * 31) + Float.hashCode(this.f15353c)) * 31) + Float.hashCode(this.f15354d);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.f15351a + ", focusedAlpha=" + this.f15352b + ", hoveredAlpha=" + this.f15353c + ", pressedAlpha=" + this.f15354d + ')';
    }
}
