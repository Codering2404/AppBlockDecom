package androidx.constraintlayout.compose.carousel;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ResistanceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f31136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f31137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f31138c;

    public ResistanceConfig(float f3, float f4, float f5) {
        this.f31136a = f3;
        this.f31137b = f4;
        this.f31138c = f5;
    }

    public final float a(float f3) {
        float f4 = f3 < 0.0f ? this.f31137b : this.f31138c;
        if (f4 == 0.0f) {
            return 0.0f;
        }
        return (this.f31136a / f4) * ((float) Math.sin((RangesKt.o(f3 / this.f31136a, -1.0f, 1.0f) * 3.1415927f) / 2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        return this.f31136a == resistanceConfig.f31136a && this.f31137b == resistanceConfig.f31137b && this.f31138c == resistanceConfig.f31138c;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f31136a) * 31) + Float.hashCode(this.f31137b)) * 31) + Float.hashCode(this.f31138c);
    }

    public String toString() {
        return "ResistanceConfig(basis=" + this.f31136a + ", factorAtMin=" + this.f31137b + ", factorAtMax=" + this.f31138c + ')';
    }
}
