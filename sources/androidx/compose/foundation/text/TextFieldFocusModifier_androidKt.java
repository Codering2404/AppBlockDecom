package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
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
public final class TextFieldFocusModifier_androidKt {
    public static final Modifier b(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final FocusManager focusManager) {
        return KeyInputModifierKt.b(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean c(android.view.KeyEvent keyEvent) {
                InputDevice device = keyEvent.getDevice();
                boolean zE = false;
                if (device != null && device.supportsSource(513) && !device.isVirtual() && KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a()) && keyEvent.getSource() != 257) {
                    if (TextFieldFocusModifier_androidKt.c(keyEvent, 19)) {
                        zE = focusManager.e(FocusDirection.f25444b.h());
                    } else if (TextFieldFocusModifier_androidKt.c(keyEvent, 20)) {
                        zE = focusManager.e(FocusDirection.f25444b.a());
                    } else if (TextFieldFocusModifier_androidKt.c(keyEvent, 21)) {
                        zE = focusManager.e(FocusDirection.f25444b.d());
                    } else if (TextFieldFocusModifier_androidKt.c(keyEvent, 22)) {
                        zE = focusManager.e(FocusDirection.f25444b.g());
                    } else if (TextFieldFocusModifier_androidKt.c(keyEvent, 23)) {
                        SoftwareKeyboardController softwareKeyboardControllerJ = legacyTextFieldState.j();
                        if (softwareKeyboardControllerJ != null) {
                            softwareKeyboardControllerJ.show();
                        }
                        zE = true;
                    }
                }
                return Boolean.valueOf(zE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((KeyEvent) obj).f());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(android.view.KeyEvent keyEvent, int i3) {
        return Key_androidKt.b(KeyEvent_androidKt.a(keyEvent)) == i3;
    }
}
