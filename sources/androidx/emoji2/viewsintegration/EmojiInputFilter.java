package androidx.emoji2.viewsintegration;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiInputFilter implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f37003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EmojiCompat.InitCallback f37004b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InitCallbackImpl extends EmojiCompat.InitCallback implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f37005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Reference f37006b;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f37005a = new WeakReference(textView);
            this.f37006b = new WeakReference(emojiInputFilter);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            Handler handler;
            super.b();
            TextView textView = (TextView) this.f37005a.get();
            if (textView == null || (handler = textView.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            CharSequence text;
            CharSequence charSequenceR;
            TextView textView = (TextView) this.f37005a.get();
            if (c(textView, (InputFilter) this.f37006b.get()) && textView.isAttachedToWindow() && text != (charSequenceR = EmojiCompat.c().r((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceR);
                int selectionEnd = Selection.getSelectionEnd(charSequenceR);
                textView.setText(charSequenceR);
                if (charSequenceR instanceof Spannable) {
                    EmojiInputFilter.b((Spannable) charSequenceR, selectionStart, selectionEnd);
                }
            }
        }
    }

    EmojiInputFilter(TextView textView) {
        this.f37003a = textView;
    }

    static void b(Spannable spannable, int i3, int i4) {
        if (i3 >= 0 && i4 >= 0) {
            Selection.setSelection(spannable, i3, i4);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        } else if (i4 >= 0) {
            Selection.setSelection(spannable, i4);
        }
    }

    EmojiCompat.InitCallback a() {
        if (this.f37004b == null) {
            this.f37004b = new InitCallbackImpl(this.f37003a, this);
        }
        return this.f37004b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        if (this.f37003a.isInEditMode()) {
            return charSequence;
        }
        int iG = EmojiCompat.c().g();
        if (iG != 0) {
            if (iG == 1) {
                if ((i6 == 0 && i5 == 0 && spanned.length() == 0 && charSequence == this.f37003a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i3 != 0 || i4 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i3, i4);
                }
                return EmojiCompat.c().s(charSequence, 0, charSequence.length());
            }
            if (iG != 3) {
                return charSequence;
            }
        }
        EmojiCompat.c().v(a());
        return charSequence;
    }
}
