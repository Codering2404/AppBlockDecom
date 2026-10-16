package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
class NullableInputConnectionWrapperApi21 implements NullableInputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f29392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputConnection f29393b;

    public NullableInputConnectionWrapperApi21(InputConnection inputConnection, Function1 function1) {
        this.f29392a = function1;
        this.f29393b = inputConnection;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public final void a() {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            b(inputConnection);
            this.f29393b = null;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.beginBatchEdit();
        }
        return false;
    }

    protected final InputConnection c() {
        return this.f29393b;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.clearMetaKeyStates(i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        if (this.f29393b != null) {
            a();
            this.f29392a.invoke(this);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.commitCompletion(completionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.commitCorrection(correctionInfo);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.commitText(charSequence, i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.deleteSurroundingText(i3, i4);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.endBatchEdit();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.finishComposingText();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.getCursorCapsMode(i3);
        }
        return 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.getExtractedText(extractedTextRequest, i3);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.getSelectedText(i3);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i3, int i4) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.getTextAfterCursor(i3, i4);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i3, int i4) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.getTextBeforeCursor(i3, i4);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.performContextMenuAction(i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.performEditorAction(i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.performPrivateCommand(str, bundle);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z2) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.reportFullscreenMode(z2);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.requestCursorUpdates(i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.sendKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i4) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.setComposingRegion(i3, i4);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.setComposingText(charSequence, i3);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i4) {
        InputConnection inputConnection = this.f29393b;
        if (inputConnection != null) {
            return inputConnection.setSelection(i3, i4);
        }
        return false;
    }

    protected void b(InputConnection inputConnection) {
    }
}
