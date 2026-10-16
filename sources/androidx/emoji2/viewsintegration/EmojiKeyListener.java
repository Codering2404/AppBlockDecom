package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiKeyListener implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyListener f37007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EmojiCompatHandleKeyDownHelper f37008b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class EmojiCompatHandleKeyDownHelper {
        public boolean a(Editable editable, int i3, KeyEvent keyEvent) {
            return EmojiCompat.i(editable, i3, keyEvent);
        }
    }

    EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i3) {
        this.f37007a.clearMetaKeyState(view, editable, i3);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f37007a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f37008b.a(editable, i3, keyEvent) || this.f37007a.onKeyDown(view, editable, i3, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f37007a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i3, KeyEvent keyEvent) {
        return this.f37007a.onKeyUp(view, editable, i3, keyEvent);
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f37007a = keyListener;
        this.f37008b = emojiCompatHandleKeyDownHelper;
    }
}
