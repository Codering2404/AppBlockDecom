package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    public boolean b(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1 function1, boolean z2, boolean z3, Function0 function0) {
        if (KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) && keyEvent.isFromSource(257) && !TextFieldKeyEventHandler_androidKt.c(keyEvent)) {
            textFieldSelectionState.y0(false);
        }
        return super.b(keyEvent, transformedTextFieldState, textLayoutState, textFieldSelectionState, function1, z2, z3, function0);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    public boolean c(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (super.c(keyEvent, transformedTextFieldState, textFieldSelectionState, focusManager, softwareKeyboardController)) {
            return true;
        }
        InputDevice device = keyEvent.getDevice();
        if (device == null || !device.supportsSource(513) || device.isVirtual() || !KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) || keyEvent.getSource() == 257) {
            return false;
        }
        if (TextFieldKeyEventHandler_androidKt.d(keyEvent, 19)) {
            return focusManager.e(FocusDirection.f25444b.h());
        }
        if (TextFieldKeyEventHandler_androidKt.d(keyEvent, 20)) {
            return focusManager.e(FocusDirection.f25444b.a());
        }
        if (TextFieldKeyEventHandler_androidKt.d(keyEvent, 21)) {
            return focusManager.e(FocusDirection.f25444b.d());
        }
        if (TextFieldKeyEventHandler_androidKt.d(keyEvent, 22)) {
            return focusManager.e(FocusDirection.f25444b.g());
        }
        if (!TextFieldKeyEventHandler_androidKt.d(keyEvent, 23)) {
            return false;
        }
        softwareKeyboardController.show();
        return true;
    }
}
