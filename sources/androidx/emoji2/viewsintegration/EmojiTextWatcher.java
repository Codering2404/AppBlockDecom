package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiTextWatcher implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f37014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmojiCompat.InitCallback f37016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37017d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37018f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f37019g = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f37020a;

        InitCallbackImpl(EditText editText) {
            this.f37020a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            Handler handler;
            super.b();
            EditText editText = (EditText) this.f37020a.get();
            if (editText == null || (handler = editText.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            EmojiTextWatcher.b((EditText) this.f37020a.get(), 1);
        }
    }

    EmojiTextWatcher(EditText editText, boolean z2) {
        this.f37014a = editText;
        this.f37015b = z2;
    }

    static void b(EditText editText, int i3) {
        if (i3 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.c().r(editableText);
            EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        if (this.f37019g) {
            return (this.f37015b || EmojiCompat.k()) ? false : true;
        }
        return true;
    }

    EmojiCompat.InitCallback a() {
        if (this.f37016c == null) {
            this.f37016c = new InitCallbackImpl(this.f37014a);
        }
        return this.f37016c;
    }

    public void c(boolean z2) {
        if (this.f37019g != z2) {
            if (this.f37016c != null) {
                EmojiCompat.c().w(this.f37016c);
            }
            this.f37019g = z2;
            if (z2) {
                b(this.f37014a, EmojiCompat.c().g());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        if (this.f37014a.isInEditMode() || d() || i4 > i5 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iG = EmojiCompat.c().g();
        if (iG != 0) {
            if (iG == 1) {
                EmojiCompat.c().u((Spannable) charSequence, i3, i3 + i5, this.f37017d, this.f37018f);
                return;
            } else if (iG != 3) {
                return;
            }
        }
        EmojiCompat.c().v(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }
}
