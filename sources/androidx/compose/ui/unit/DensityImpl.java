package androidx.compose.ui.unit;

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
final class DensityImpl implements Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29966b;

    public DensityImpl(float f3, float f4) {
        this.f29965a = f3;
        this.f29966b = f4;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f29966b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) obj;
        return Float.compare(this.f29965a, densityImpl.f29965a) == 0 && Float.compare(this.f29966b, densityImpl.f29966b) == 0;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f29965a;
    }

    public int hashCode() {
        return (Float.hashCode(this.f29965a) * 31) + Float.hashCode(this.f29966b);
    }

    public String toString() {
        return "DensityImpl(density=" + this.f29965a + ", fontScale=" + this.f29966b + ')';
    }
}
