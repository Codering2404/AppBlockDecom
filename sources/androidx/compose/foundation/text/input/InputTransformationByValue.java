package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
final class InputTransformationByValue implements InputTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f10127b;

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void O(TextFieldBuffer textFieldBuffer) {
        TextFieldCharSequence textFieldCharSequenceA = TextFieldBuffer.A(textFieldBuffer, 0L, null, null, 7, null);
        CharSequence charSequence = (CharSequence) this.f10127b.invoke(textFieldBuffer.k(), textFieldCharSequenceA);
        if (charSequence == textFieldCharSequenceA) {
            return;
        }
        if (charSequence == textFieldBuffer.k()) {
            textFieldBuffer.s();
        } else {
            textFieldBuffer.y(charSequence);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InputTransformationByValue) && Intrinsics.areEqual(this.f10127b, ((InputTransformationByValue) obj).f10127b);
    }

    public int hashCode() {
        return this.f10127b.hashCode();
    }

    public String toString() {
        return "InputTransformation.byValue(transformation=" + this.f10127b + ')';
    }
}
