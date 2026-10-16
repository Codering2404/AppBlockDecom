package cz.mobilesoft.coreblock.view.compose.material3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShimmerBorderState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f131193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f131194b;

    public ShimmerBorderState(float f3, float f4) {
        this.f131193a = f3;
        this.f131194b = f4;
    }

    public final float a() {
        return this.f131193a;
    }

    public final float b() {
        return this.f131194b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShimmerBorderState)) {
            return false;
        }
        ShimmerBorderState shimmerBorderState = (ShimmerBorderState) obj;
        return Float.compare(this.f131193a, shimmerBorderState.f131193a) == 0 && Float.compare(this.f131194b, shimmerBorderState.f131194b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f131193a) * 31) + Float.hashCode(this.f131194b);
    }

    public String toString() {
        return "ShimmerBorderState(progress=" + this.f131193a + ", visibility=" + this.f131194b + ")";
    }
}
