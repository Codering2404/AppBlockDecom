package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;

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
public final class TextFieldKeyInputKt {
    public static final Modifier a(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager, final TextFieldValue textFieldValue, final Function1 function1, final boolean z2, final boolean z3, final OffsetMapping offsetMapping, final UndoManager undoManager, final int i3) {
        return ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$textFieldKeyInput$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i4) {
                composer.a0(851809892);
                if (ComposerKt.M()) {
                    ComposerKt.U(851809892, i4, -1, "androidx.compose.foundation.text.textFieldKeyInput.<anonymous> (TextFieldKeyInput.kt:252)");
                }
                Object objG = composer.G();
                Composer.Companion companion = Composer.f23746a;
                if (objG == companion.a()) {
                    objG = new TextPreparedSelectionState();
                    composer.w(objG);
                }
                TextPreparedSelectionState textPreparedSelectionState = (TextPreparedSelectionState) objG;
                Object objG2 = composer.G();
                if (objG2 == companion.a()) {
                    objG2 = new DeadKeyCombiner();
                    composer.w(objG2);
                }
                TextFieldKeyInput textFieldKeyInput = new TextFieldKeyInput(legacyTextFieldState, textFieldSelectionManager, textFieldValue, z2, z3, textPreparedSelectionState, offsetMapping, undoManager, (DeadKeyCombiner) objG2, null, function1, i3, 512, null);
                Modifier.Companion companion2 = Modifier.b8;
                boolean zI = composer.I(textFieldKeyInput);
                Object objG3 = composer.G();
                if (zI || objG3 == companion.a()) {
                    objG3 = new TextFieldKeyInputKt$textFieldKeyInput$2$1$1(textFieldKeyInput);
                    composer.w(objG3);
                }
                Modifier modifierA = KeyInputModifierKt.a(companion2, (Function1) ((KFunction) objG3));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierA;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null);
    }
}
