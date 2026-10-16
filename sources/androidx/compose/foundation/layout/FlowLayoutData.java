package androidx.compose.foundation.layout;

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
public final class FlowLayoutData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6813a;

    public FlowLayoutData(float f3) {
        this.f6813a = f3;
    }

    public final float a() {
        return this.f6813a;
    }

    public final void b(float f3) {
        this.f6813a = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FlowLayoutData) && Float.compare(this.f6813a, ((FlowLayoutData) obj).f6813a) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.f6813a);
    }

    public String toString() {
        return "FlowLayoutData(fillCrossAxisFraction=" + this.f6813a + ')';
    }
}
