package androidx.compose.foundation.text.input;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
final class MaxLengthFilter implements InputTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10128b;

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m0(semanticsPropertyReceiver, this.f10128b);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void O(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.j() > this.f10128b) {
            textFieldBuffer.s();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MaxLengthFilter) && this.f10128b == ((MaxLengthFilter) obj).f10128b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f10128b);
    }

    public String toString() {
        return "InputTransformation.maxLength(" + this.f10128b + ')';
    }
}
