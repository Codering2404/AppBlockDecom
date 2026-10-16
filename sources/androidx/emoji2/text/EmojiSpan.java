package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypefaceEmojiRasterizer f36904b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f36903a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f36905c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short f36906d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f36907f = 1.0f;

    EmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.i(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.f36904b = typefaceEmojiRasterizer;
    }

    public final TypefaceEmojiRasterizer a() {
        return this.f36904b;
    }

    final int b() {
        return this.f36905c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f36903a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f36903a;
        this.f36907f = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f36904b.e();
        this.f36906d = (short) (this.f36904b.e() * this.f36907f);
        short sI = (short) (this.f36904b.i() * this.f36907f);
        this.f36905c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f36903a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
