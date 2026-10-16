package cz.mobilesoft.coreblock.view.graph;

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
final class DrawingAngles {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f132740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f132741b;

    public DrawingAngles(float f3, float f4) {
        this.f132740a = f3;
        this.f132741b = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawingAngles)) {
            return false;
        }
        DrawingAngles drawingAngles = (DrawingAngles) obj;
        return Float.compare(this.f132740a, drawingAngles.f132740a) == 0 && Float.compare(this.f132741b, drawingAngles.f132741b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f132740a) * 31) + Float.hashCode(this.f132741b);
    }

    public String toString() {
        return "DrawingAngles(start=" + this.f132740a + ", end=" + this.f132741b + ")";
    }
}
