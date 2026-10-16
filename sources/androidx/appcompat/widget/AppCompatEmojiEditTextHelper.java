package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f1797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EmojiEditTextHelper f1798b;

    AppCompatEmojiEditTextHelper(EditText editText) {
        this.f1797a = editText;
        this.f1798b = new EmojiEditTextHelper(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f1798b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes = this.f1797a.getContext().obtainStyledAttributes(attributeSet, R.styleable.f838i0, i3, 0);
        try {
            int i4 = R.styleable.f889w0;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getBoolean(i4, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f1798b.b(inputConnection, editorInfo);
    }

    void e(boolean z2) {
        this.f1798b.c(z2);
    }
}
