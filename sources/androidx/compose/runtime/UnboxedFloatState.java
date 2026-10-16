package androidx.compose.runtime;

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
public final class UnboxedFloatState implements FloatState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f24308a;

    @Override // androidx.compose.runtime.FloatState
    public float c() {
        return ((Number) this.f24308a.getValue()).floatValue();
    }

    public String toString() {
        return "UnboxedFloatState(baseState=" + this.f24308a + ")@" + hashCode();
    }

    @Override // androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    public Float getValue() {
        return (Float) this.f24308a.getValue();
    }
}
