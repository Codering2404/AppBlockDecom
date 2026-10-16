package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
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
public final class TextUndoManagerKt {
    private static final boolean a(TextUndoOperation textUndoOperation) {
        return Intrinsics.areEqual(textUndoOperation.f(), "\n") || Intrinsics.areEqual(textUndoOperation.f(), "\r\n");
    }

    public static final TextUndoOperation b(TextUndoOperation textUndoOperation, TextUndoOperation textUndoOperation2) {
        if (!textUndoOperation.b() || !textUndoOperation2.b() || textUndoOperation2.j() < textUndoOperation.j() || textUndoOperation2.j() - textUndoOperation.j() >= UndoManagerKt.a() || a(textUndoOperation) || a(textUndoOperation2) || textUndoOperation.i() != textUndoOperation2.i()) {
            return null;
        }
        if (textUndoOperation.i() == TextEditType.f10971a && textUndoOperation.d() + textUndoOperation.f().length() == textUndoOperation2.d()) {
            return new TextUndoOperation(textUndoOperation.d(), "", textUndoOperation.f() + textUndoOperation2.f(), textUndoOperation.g(), textUndoOperation2.e(), textUndoOperation.j(), false, 64, null);
        }
        if (textUndoOperation.i() == TextEditType.f10972b && textUndoOperation.c() == textUndoOperation2.c() && (textUndoOperation.c() == TextDeleteType.f10965a || textUndoOperation.c() == TextDeleteType.f10966b)) {
            if (textUndoOperation.d() == textUndoOperation2.d() + textUndoOperation2.h().length()) {
                return new TextUndoOperation(textUndoOperation2.d(), textUndoOperation2.h() + textUndoOperation.h(), "", textUndoOperation.g(), textUndoOperation2.e(), textUndoOperation.j(), false, 64, null);
            }
            if (textUndoOperation.d() == textUndoOperation2.d()) {
                return new TextUndoOperation(textUndoOperation.d(), textUndoOperation.h() + textUndoOperation2.h(), "", textUndoOperation.g(), textUndoOperation2.e(), textUndoOperation.j(), false, 64, null);
            }
        }
        return null;
    }

    public static final void c(TextUndoManager textUndoManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, boolean z2) {
        if (changeList.b() > 1) {
            textUndoManager.h(new TextUndoOperation(0, textFieldCharSequence.toString(), textFieldCharSequence2.toString(), textFieldCharSequence.g(), textFieldCharSequence2.g(), 0L, false, 32, null));
            return;
        }
        if (changeList.b() == 1) {
            long jA = changeList.a(0);
            long jC = changeList.c(0);
            if (TextRange.h(jA) && TextRange.h(jC)) {
                return;
            }
            textUndoManager.h(new TextUndoOperation(TextRange.l(jA), TextRangeKt.e(textFieldCharSequence, jA), TextRangeKt.e(textFieldCharSequence2, jC), textFieldCharSequence.g(), textFieldCharSequence2.g(), 0L, z2, 32, null));
        }
    }
}
