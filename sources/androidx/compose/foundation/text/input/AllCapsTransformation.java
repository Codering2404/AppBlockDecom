package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.ui.text.StringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.intl.Locale;
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
final class AllCapsTransformation implements InputTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Locale f10121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KeyboardOptions f10122c;

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void O(TextFieldBuffer textFieldBuffer) {
        TextFieldBuffer.ChangeList changeListF = textFieldBuffer.f();
        for (int i3 = 0; i3 < changeListF.b(); i3++) {
            long jC = changeListF.c(i3);
            changeListF.a(i3);
            if (!TextRange.h(jC)) {
                textFieldBuffer.p(TextRange.l(jC), TextRange.k(jC), StringKt.g(TextRangeKt.e(textFieldBuffer.a(), jC), this.f10121b));
            }
        }
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions P() {
        return this.f10122c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AllCapsTransformation) && Intrinsics.areEqual(this.f10121b, ((AllCapsTransformation) obj).f10121b);
    }

    public int hashCode() {
        return this.f10121b.hashCode();
    }

    public String toString() {
        return "InputTransformation.allCaps(locale=" + this.f10121b + ')';
    }
}
