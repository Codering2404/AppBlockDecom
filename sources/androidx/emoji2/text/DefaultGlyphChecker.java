package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f36842b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f36843a;

    DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.f36843a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = f36842b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean a(CharSequence charSequence, int i3, int i4, int i5) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i3 < i4) {
            sbB.append(charSequence.charAt(i3));
            i3++;
        }
        return PaintCompat.a(this.f36843a, sbB.toString());
    }
}
