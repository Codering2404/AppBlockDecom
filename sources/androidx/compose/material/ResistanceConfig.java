package androidx.compose.material;

import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class ResistanceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f13613c;

    public ResistanceConfig(float f3, float f4, float f5) {
        this.f13611a = f3;
        this.f13612b = f4;
        this.f13613c = f5;
    }

    public final float a(float f3) {
        float f4 = f3 < 0.0f ? this.f13612b : this.f13613c;
        if (f4 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f13611a;
        float f6 = f3 / f5;
        if (f6 < -1.0f) {
            f6 = -1.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        return (f5 / f4) * ((float) Math.sin((f6 * 3.1415927f) / 2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        return this.f13611a == resistanceConfig.f13611a && this.f13612b == resistanceConfig.f13612b && this.f13613c == resistanceConfig.f13613c;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f13611a) * 31) + Float.hashCode(this.f13612b)) * 31) + Float.hashCode(this.f13613c);
    }

    public String toString() {
        return "ResistanceConfig(basis=" + this.f13611a + ", factorAtMin=" + this.f13612b + ", factorAtMax=" + this.f13613c + ')';
    }
}
