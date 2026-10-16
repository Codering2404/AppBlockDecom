package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiInputConnection extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f37001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EmojiCompatDeleteHelper f37002b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class EmojiCompatDeleteHelper {
        public boolean a(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z2) {
            return EmojiCompat.h(inputConnection, editable, i3, i4, z2);
        }

        public void b(EditorInfo editorInfo) {
            if (EmojiCompat.k()) {
                EmojiCompat.c().x(editorInfo);
            }
        }
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable b() {
        return this.f37001a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        return this.f37002b.a(this, b(), i3, i4, false) || super.deleteSurroundingText(i3, i4);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        return this.f37002b.a(this, b(), i3, i4, true) || super.deleteSurroundingTextInCodePoints(i3, i4);
    }

    EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f37001a = textView;
        this.f37002b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.b(editorInfo);
    }
}
