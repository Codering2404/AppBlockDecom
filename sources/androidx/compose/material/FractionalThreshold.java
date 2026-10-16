package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.MathHelpersKt;
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
public final class FractionalThreshold implements ThresholdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13000a;

    @Override // androidx.compose.material.ThresholdConfig
    public float a(Density density, float f3, float f4) {
        return MathHelpersKt.b(f3, f4, this.f13000a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FractionalThreshold) && Float.compare(this.f13000a, ((FractionalThreshold) obj).f13000a) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.f13000a);
    }

    public String toString() {
        return "FractionalThreshold(fraction=" + this.f13000a + ')';
    }
}
