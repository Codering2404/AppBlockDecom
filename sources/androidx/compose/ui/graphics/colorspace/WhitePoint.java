package androidx.compose.ui.graphics.colorspace;

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
public final class WhitePoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f26065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f26066b;

    public WhitePoint(float f3, float f4) {
        this.f26065a = f3;
        this.f26066b = f4;
    }

    public final float a() {
        return this.f26065a;
    }

    public final float b() {
        return this.f26066b;
    }

    public final float[] c() {
        float f3 = this.f26065a;
        float f4 = this.f26066b;
        return new float[]{f3 / f4, 1.0f, ((1.0f - f3) - f4) / f4};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        return Float.compare(this.f26065a, whitePoint.f26065a) == 0 && Float.compare(this.f26066b, whitePoint.f26066b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.f26065a) * 31) + Float.hashCode(this.f26066b);
    }

    public String toString() {
        return "WhitePoint(x=" + this.f26065a + ", y=" + this.f26066b + ')';
    }
}
