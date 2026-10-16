package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class KeyedComposedModifier1 extends ComposedModifier {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f25115d;

    public boolean equals(Object obj) {
        if (!(obj instanceof KeyedComposedModifier1)) {
            return false;
        }
        KeyedComposedModifier1 keyedComposedModifier1 = (KeyedComposedModifier1) obj;
        return Intrinsics.areEqual(this.f25114c, keyedComposedModifier1.f25114c) && Intrinsics.areEqual(this.f25115d, keyedComposedModifier1.f25115d);
    }

    public int hashCode() {
        int iHashCode = this.f25114c.hashCode() * 31;
        Object obj = this.f25115d;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }
}
