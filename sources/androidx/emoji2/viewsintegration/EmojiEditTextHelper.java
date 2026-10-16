package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EmojiEditTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HelperInternal f36993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36994b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36995c = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class HelperInternal19 extends HelperInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EditText f36996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EmojiTextWatcher f36997b;

        HelperInternal19(EditText editText, boolean z2) {
            this.f36996a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z2);
            this.f36997b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.f36996a, inputConnection, editorInfo);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void c(boolean z2) {
            this.f36997b.c(z2);
        }
    }

    public EmojiEditTextHelper(EditText editText, boolean z2) {
        Preconditions.i(editText, "editText cannot be null");
        this.f36993a = new HelperInternal19(editText, z2);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f36993a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f36993a.b(inputConnection, editorInfo);
    }

    public void c(boolean z2) {
        this.f36993a.c(z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class HelperInternal {
        HelperInternal() {
        }

        KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        void c(boolean z2) {
        }

        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }
    }
}
