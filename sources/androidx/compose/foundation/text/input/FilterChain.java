package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
final class FilterChain implements InputTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputTransformation f10123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputTransformation f10124c;

    public FilterChain(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        this.f10123b = inputTransformation;
        this.f10124c = inputTransformation2;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.f10123b.N(semanticsPropertyReceiver);
        this.f10124c.N(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void O(TextFieldBuffer textFieldBuffer) {
        this.f10123b.O(textFieldBuffer);
        this.f10124c.O(textFieldBuffer);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions P() {
        KeyboardOptions keyboardOptionsE;
        KeyboardOptions keyboardOptionsP = this.f10124c.P();
        return (keyboardOptionsP == null || (keyboardOptionsE = keyboardOptionsP.e(this.f10123b.P())) == null) ? this.f10123b.P() : keyboardOptionsE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FilterChain.class != obj.getClass()) {
            return false;
        }
        FilterChain filterChain = (FilterChain) obj;
        return Intrinsics.areEqual(this.f10123b, filterChain.f10123b) && Intrinsics.areEqual(this.f10124c, filterChain.f10124c) && Intrinsics.areEqual(P(), filterChain.P());
    }

    public int hashCode() {
        int iHashCode = ((this.f10123b.hashCode() * 31) + this.f10124c.hashCode()) * 32;
        KeyboardOptions keyboardOptionsP = P();
        return iHashCode + (keyboardOptionsP != null ? keyboardOptionsP.hashCode() : 0);
    }

    public String toString() {
        return this.f10123b + ".then(" + this.f10124c + ')';
    }
}
