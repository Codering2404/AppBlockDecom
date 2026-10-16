package androidx.compose.ui.text.input;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
@Deprecated
@Metadata
public final class RecordingInputConnection implements InputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputEventCallback2 f29405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextFieldValue f29408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f29410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f29411g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29412h = true;

    public RecordingInputConnection(TextFieldValue textFieldValue, InputEventCallback2 inputEventCallback2, boolean z2) {
        this.f29405a = inputEventCallback2;
        this.f29406b = z2;
        this.f29408d = textFieldValue;
    }

    private final void b(EditCommand editCommand) {
        c();
        try {
            this.f29411g.add(editCommand);
        } finally {
            d();
        }
    }

    private final boolean c() {
        this.f29407c++;
        return true;
    }

    private final boolean d() {
        int i3 = this.f29407c - 1;
        this.f29407c = i3;
        if (i3 == 0 && !this.f29411g.isEmpty()) {
            this.f29405a.d(CollectionsKt.toMutableList((Collection) this.f29411g));
            this.f29411g.clear();
        }
        return this.f29407c > 0;
    }

    private final void e(int i3) {
        sendKeyEvent(new KeyEvent(0, i3));
        sendKeyEvent(new KeyEvent(1, i3));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean z2 = this.f29412h;
        return z2 ? c() : z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i3) {
        boolean z2 = this.f29412h;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.f29411g.clear();
        this.f29407c = 0;
        this.f29412h = false;
        this.f29405a.e(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z2 = this.f29412h;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        boolean z2 = this.f29412h;
        if (z2) {
            return false;
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z2 = this.f29412h;
        return z2 ? this.f29406b : z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        boolean z2 = this.f29412h;
        if (z2) {
            b(new CommitTextCommand(String.valueOf(charSequence), i3));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        boolean z2 = this.f29412h;
        if (!z2) {
            return z2;
        }
        b(new DeleteSurroundingTextCommand(i3, i4));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        boolean z2 = this.f29412h;
        if (!z2) {
            return z2;
        }
        b(new DeleteSurroundingTextInCodePointsCommand(i3, i4));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return d();
    }

    public final void f(TextFieldValue textFieldValue) {
        this.f29408d = textFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean z2 = this.f29412h;
        if (!z2) {
            return z2;
        }
        b(new FinishComposingTextCommand());
        return true;
    }

    public final void g(TextFieldValue textFieldValue, InputMethodManager inputMethodManager) {
        if (this.f29412h) {
            f(textFieldValue);
            if (this.f29410f) {
                inputMethodManager.updateExtractedText(this.f29409e, InputState_androidKt.a(textFieldValue));
            }
            TextRange textRangeG = textFieldValue.g();
            int iL = textRangeG != null ? TextRange.l(textRangeG.r()) : -1;
            TextRange textRangeG2 = textFieldValue.g();
            inputMethodManager.a(TextRange.l(textFieldValue.h()), TextRange.k(textFieldValue.h()), iL, textRangeG2 != null ? TextRange.k(textRangeG2.r()) : -1);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i3) {
        return TextUtils.getCapsMode(this.f29408d.i(), TextRange.l(this.f29408d.h()), i3);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
        boolean z2 = (i3 & 1) != 0;
        this.f29410f = z2;
        if (z2) {
            this.f29409e = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return InputState_androidKt.a(this.f29408d);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i3) {
        if (TextRange.h(this.f29408d.h())) {
            return null;
        }
        return TextFieldValueKt.a(this.f29408d).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i3, int i4) {
        return TextFieldValueKt.b(this.f29408d, i3).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i3, int i4) {
        return TextFieldValueKt.c(this.f29408d, i3).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        boolean z2 = this.f29412h;
        if (z2) {
            z2 = false;
            switch (i3) {
                case R.id.selectAll:
                    b(new SetSelectionCommand(0, this.f29408d.i().length()));
                    break;
                case R.id.cut:
                    e(277);
                    break;
                case R.id.copy:
                    e(278);
                    break;
                case R.id.paste:
                    e(279);
                    break;
            }
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        int iA;
        boolean z2 = this.f29412h;
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
        this.f29405a.a(iA);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z2 = this.f29412h;
        if (z2) {
            return true;
        }
        return z2;
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
        boolean z6 = this.f29412h;
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
        this.f29405a.c(z8, z9, z4, z5, z2, z3);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z2 = this.f29412h;
        if (!z2) {
            return z2;
        }
        this.f29405a.b(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i4) {
        boolean z2 = this.f29412h;
        if (z2) {
            b(new SetComposingRegionCommand(i3, i4));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        boolean z2 = this.f29412h;
        if (z2) {
            b(new SetComposingTextCommand(String.valueOf(charSequence), i3));
        }
        return z2;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i4) {
        boolean z2 = this.f29412h;
        if (!z2) {
            return z2;
        }
        b(new SetSelectionCommand(i3, i4));
        return true;
    }
}
