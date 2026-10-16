package androidx.compose.ui.graphics;

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
public final class LightingColorFilter extends ColorFilter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f25807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f25808d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LightingColorFilter)) {
            return false;
        }
        LightingColorFilter lightingColorFilter = (LightingColorFilter) obj;
        return Color.t(this.f25807c, lightingColorFilter.f25807c) && Color.t(this.f25808d, lightingColorFilter.f25808d);
    }

    public int hashCode() {
        return (Color.z(this.f25807c) * 31) + Color.z(this.f25808d);
    }

    public String toString() {
        return "LightingColorFilter(multiply=" + ((Object) Color.A(this.f25807c)) + ", add=" + ((Object) Color.A(this.f25808d)) + ')';
    }
}
