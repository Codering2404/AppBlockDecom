package androidx.compose.foundation.text.input.internal;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StatelessInputConnection implements InputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputSession f10433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableVector f10435c = new MutableVector(new Function1[16], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StatelessInputConnection$terminalInputConnection$1 f10436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InputConnection f10437e;

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.inputmethod.InputConnection, androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1] */
    public StatelessInputConnection(TextInputSession textInputSession, EditorInfo editorInfo) {
        this.f10433a = textInputSession;
        ?? r3 = new InputConnectionWrapper(this) { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1
            {
                super(this, false);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
                return false;
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(String str, Bundle bundle) {
                return true;
            }
        };
        this.f10436d = r3;
        this.f10437e = InputConnectionCompat.d(r3, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$commitContentDelegateInputConnection$1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean a(InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle) {
                if ((i3 & 1) != 0) {
                    try {
                        inputContentInfoCompat.d();
                        Object objE = inputContentInfoCompat.e();
                        Intrinsics.checkNotNull(objE, "null cannot be cast to non-null type android.os.Parcelable");
                        Parcelable parcelable = (Parcelable) objE;
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable("EXTRA_INPUT_CONTENT_INFO", parcelable);
                    } catch (Exception e3) {
                        this.f10438a.g("Can't insert content from IME; requestPermission() failed, " + e3);
                        return false;
                    }
                }
                return this.f10438a.f10433a.f(StatelessInputConnection_androidKt.h(inputContentInfoCompat, bundle));
            }
        });
    }

    private final boolean d() {
        return this.f10433a.beginBatchEdit();
    }

    private final boolean e() {
        return this.f10433a.endBatchEdit();
    }

    private final TextFieldCharSequence f() {
        return this.f10433a.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str) {
    }

    private final void h(int i3) {
        sendKeyEvent(new KeyEvent(0, i3));
        sendKeyEvent(new KeyEvent(1, i3));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        g("beginBatchEdit()");
        return d();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        g("closeConnection()");
        this.f10435c.i();
        this.f10434b = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("commitCompletion(");
        sb.append((Object) (completionInfo != null ? completionInfo.getText() : null));
        sb.append(')');
        g(sb.toString());
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        g("commitContent(" + inputContentInfo + ", " + i3 + ", " + bundle + ')');
        return Api25CommitContentImpl.f10237a.a(this.f10437e, inputContentInfo, i3, bundle);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        g("commitText(\"" + ((Object) charSequence) + "\", " + i3 + ')');
        if (charSequence == null) {
            return true;
        }
        ImeEditCommand_androidKt.b(this.f10433a, charSequence.toString(), i3);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        g("deleteSurroundingText(" + i3 + ", " + i4 + ')');
        ImeEditCommand_androidKt.c(this.f10433a, i3, i4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        g("deleteSurroundingTextInCodePoints(" + i3 + ", " + i4 + ')');
        ImeEditCommand_androidKt.d(this.f10433a, i3, i4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        g("endBatchEdit()");
        return e();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        g("finishComposingText()");
        ImeEditCommand_androidKt.e(this.f10433a);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i3) {
        g("getCursorCapsMode(" + i3 + ')');
        return TextUtils.getCapsMode(f(), TextRange.l(f().g()), i3);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
        g("getExtractedText(" + extractedTextRequest + ", " + i3 + ')');
        return StatelessInputConnection_androidKt.e(f());
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        g("getHandler()");
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i3) {
        String string = TextRange.h(f().g()) ? null : TextFieldCharSequenceKt.a(f()).toString();
        g("getSelectedText(" + i3 + "): " + ((Object) string));
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i3, int i4) {
        String string = TextFieldCharSequenceKt.b(f(), i3).toString();
        g("getTextAfterCursor(" + i3 + ", " + i4 + "): " + string);
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i3, int i4) {
        String string = TextFieldCharSequenceKt.c(f(), i3).toString();
        g("getTextBeforeCursor(" + i3 + ", " + i4 + "): " + string);
        return string;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        g("performContextMenuAction(" + i3 + ')');
        switch (i3) {
            case R.id.selectAll:
                ImeEditCommand_androidKt.k(this.f10433a, 0, f().length());
                return false;
            case R.id.cut:
                h(277);
                return false;
            case R.id.copy:
                h(278);
                return false;
            case R.id.paste:
                h(279);
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        int iA;
        g("performEditorAction(" + i3 + ')');
        if (i3 != 0) {
            switch (i3) {
                case 2:
                    iA = ImeAction.f29348b.c();
                    break;
                case 3:
                    iA = ImeAction.f29348b.g();
                    break;
                case 4:
                    iA = ImeAction.f29348b.h();
                    break;
                case 5:
                    iA = ImeAction.f29348b.d();
                    break;
                case 6:
                    iA = ImeAction.f29348b.b();
                    break;
                case 7:
                    iA = ImeAction.f29348b.f();
                    break;
                default:
                    g("IME sent an unrecognized editor action: " + i3);
                    iA = ImeAction.f29348b.a();
                    break;
            }
        } else {
            iA = ImeAction.f29348b.a();
        }
        this.f10433a.a(iA);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        g("performHandwritingGesture(" + handwritingGesture + ", " + executor + ", " + intConsumer + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        Api34PerformHandwritingGestureImpl.f10239a.b(this.f10433a, handwritingGesture, executor, intConsumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        g("performPrivateCommand(" + str + ", " + bundle + ')');
        return this.f10437e.performPrivateCommand(str, bundle);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        g("previewHandwritingGesture(" + previewableHandwritingGesture + ", " + cancellationSignal + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return Api34PerformHandwritingGestureImpl.f10239a.d(this.f10433a, previewableHandwritingGesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z2) {
        g("reportFullscreenMode(" + z2 + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i3) {
        g("requestCursorUpdates(" + i3 + ')');
        this.f10433a.requestCursorUpdates(i3);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        g("sendKeyEvent(" + keyEvent + ')');
        this.f10433a.sendKeyEvent(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i4) {
        g("setComposingRegion(" + i3 + ", " + i4 + ')');
        ImeEditCommand_androidKt.i(this.f10433a, i3, i4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        g("setComposingText(\"" + ((Object) charSequence) + "\", " + i3 + ')');
        if (charSequence == null) {
            return true;
        }
        TextInputSession textInputSession = this.f10433a;
        String string = charSequence.toString();
        Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
        ImeEditCommand_androidKt.j(textInputSession, string, i3, spanned != null ? StatelessInputConnection_androidKt.d(spanned) : null);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i4) {
        g("setSelection(" + i3 + ", " + i4 + ')');
        ImeEditCommand_androidKt.k(this.f10433a, i3, i4);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i3) {
        g(muQRKXGtpOhe.mTYM + i3 + ')');
        return false;
    }
}
