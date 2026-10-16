package androidx.compose.foundation.text.input.internal;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RecordingInputConnection implements InputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputEventCallback2 f10418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LegacyTextFieldState f10420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextFieldSelectionManager f10421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewConfiguration f10422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextFieldValue f10424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f10427j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10428k = true;

    public RecordingInputConnection(TextFieldValue textFieldValue, InputEventCallback2 inputEventCallback2, boolean z2, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration) {
        this.f10418a = inputEventCallback2;
        this.f10419b = z2;
        this.f10420c = legacyTextFieldState;
        this.f10421d = textFieldSelectionManager;
        this.f10422e = viewConfiguration;
        this.f10424g = textFieldValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(EditCommand editCommand) {
        d();
        try {
            this.f10427j.add(editCommand);
        } finally {
            e();
        }
    }

    private final boolean d() {
        this.f10423f++;
        return true;
    }

    private final boolean e() {
        int i3 = this.f10423f - 1;
        this.f10423f = i3;
        if (i3 == 0 && !this.f10427j.isEmpty()) {
            this.f10418a.d(CollectionsKt.toMutableList((Collection) this.f10427j));
            this.f10427j.clear();
        }
        return this.f10423f > 0;
    }

    private final void f(int i3) {
        sendKeyEvent(new KeyEvent(0, i3));
        sendKeyEvent(new KeyEvent(1, i3));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z2 = this.f10428k;
        return z2 ? d() : z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i3) {
        boolean z2 = this.f10428k;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.f10427j.clear();
        this.f10423f = 0;
        this.f10428k = false;
        this.f10418a.e(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z2 = this.f10428k;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        boolean z2 = this.f10428k;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z2 = this.f10428k;
        return z2 ? this.f10419b : z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        boolean z2 = this.f10428k;
        if (z2) {
            c(new CommitTextCommand(String.valueOf(charSequence), i3));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
        c(new DeleteSurroundingTextCommand(i3, i4));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
        c(new DeleteSurroundingTextInCodePointsCommand(i3, i4));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return e();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
        c(new FinishComposingTextCommand());
        return true;
    }

    public final void g(TextFieldValue textFieldValue) {
        this.f10424g = textFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i3) {
        return TextUtils.getCapsMode(this.f10424g.i(), TextRange.l(this.f10424g.h()), i3);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
        boolean z2 = (i3 & 1) != 0;
        this.f10426i = z2;
        if (z2) {
            this.f10425h = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return RecordingInputConnection_androidKt.b(this.f10424g);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i3) {
        if (TextRange.h(this.f10424g.h())) {
            return null;
        }
        return TextFieldValueKt.a(this.f10424g).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i3, int i4) {
        return TextFieldValueKt.b(this.f10424g, i3).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i3, int i4) {
        return TextFieldValueKt.c(this.f10424g, i3).toString();
    }

    public final void h(TextFieldValue textFieldValue, InputMethodManager inputMethodManager) {
        if (this.f10428k) {
            g(textFieldValue);
            if (this.f10426i) {
                inputMethodManager.updateExtractedText(this.f10425h, RecordingInputConnection_androidKt.b(textFieldValue));
            }
            TextRange textRangeG = textFieldValue.g();
            int iL = textRangeG != null ? TextRange.l(textRangeG.r()) : -1;
            TextRange textRangeG2 = textFieldValue.g();
            inputMethodManager.a(TextRange.l(textFieldValue.h()), TextRange.k(textFieldValue.h()), iL, textRangeG2 != null ? TextRange.k(textRangeG2.r()) : -1);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        boolean z2 = this.f10428k;
        if (z2) {
            z2 = false;
            switch (i3) {
                case R.id.selectAll:
                    c(new SetSelectionCommand(0, this.f10424g.i().length()));
                    break;
                case R.id.cut:
                    f(277);
                    break;
                case R.id.copy:
                    f(278);
                    break;
                case R.id.paste:
                    f(279);
                    break;
            }
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        int iA;
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
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
                    Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i3);
                    iA = ImeAction.f29348b.a();
                    break;
            }
        } else {
            iA = ImeAction.f29348b.a();
        }
        this.f10418a.a(iA);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34LegacyPerformHandwritingGestureImpl.f10238a.b(this.f10420c, this.f10421d, handwritingGesture, this.f10422e, executor, intConsumer, new Function1<EditCommand, Unit>() { // from class: androidx.compose.foundation.text.input.internal.RecordingInputConnection.performHandwritingGesture.1
                {
                    super(1);
                }

                public final void c(EditCommand editCommand) {
                    RecordingInputConnection.this.c(editCommand);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((EditCommand) obj);
                    return Unit.f139807a;
                }
            });
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z2 = this.f10428k;
        if (z2) {
            return true;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34LegacyPerformHandwritingGestureImpl.f10238a.d(this.f10420c, this.f10421d, previewableHandwritingGesture, cancellationSignal);
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z2) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = this.f10428k;
        if (!z6) {
            return z6;
        }
        boolean z7 = false;
        boolean z8 = (i3 & 1) != 0;
        boolean z9 = (i3 & 2) != 0;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            boolean z10 = (i3 & 16) != 0;
            boolean z11 = (i3 & 8) != 0;
            boolean z12 = (i3 & 4) != 0;
            if (i4 >= 34 && (i3 & 32) != 0) {
                z7 = true;
            }
            if (z10 || z11 || z12 || z7) {
                z3 = z7;
                z2 = z12;
                z5 = z11;
                z4 = z10;
            } else if (i4 >= 34) {
                z4 = true;
                z5 = true;
                z2 = true;
                z3 = true;
            } else {
                z3 = z7;
                z4 = true;
                z5 = true;
                z2 = true;
            }
        } else {
            z2 = false;
            z3 = false;
            z4 = true;
            z5 = true;
        }
        this.f10418a.c(z8, z9, z4, z5, z2, z3);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
        this.f10418a.b(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i4) {
        boolean z2 = this.f10428k;
        if (z2) {
            c(new SetComposingRegionCommand(i3, i4));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        boolean z2 = this.f10428k;
        if (z2) {
            c(new SetComposingTextCommand(String.valueOf(charSequence), i3));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i4) {
        boolean z2 = this.f10428k;
        if (!z2) {
            return z2;
        }
        c(new SetSelectionCommand(i3, i4));
        return true;
    }
}
