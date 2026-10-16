package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Paint f36944h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextPaint f36945g;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        super(typefaceEmojiRasterizer);
    }

    private TextPaint c(CharSequence charSequence, int i3, int i4, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i3, i4, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f36945g;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f36945g = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    if (!(characterStyle instanceof MetricAffectingSpan)) {
                        characterStyle.updateDrawState(textPaint);
                    }
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    private static Paint e() {
        if (f36944h == null) {
            TextPaint textPaint = new TextPaint();
            f36944h = textPaint;
            textPaint.setColor(EmojiCompat.c().e());
            f36944h.setStyle(Paint.Style.FILL);
        }
        return f36944h;
    }

    void d(Canvas canvas, TextPaint textPaint, float f3, float f4, float f5, float f6) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f3, f5, f4, f6, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        TextPaint textPaintC = c(charSequence, i3, i4, paint);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f3, f3 + b(), i5, i7);
        }
        Paint paint2 = textPaintC;
        if (EmojiCompat.c().l()) {
            canvas.drawRect(f3, i5, f3 + b(), i7, e());
        }
        TypefaceEmojiRasterizer typefaceEmojiRasterizerA = a();
        float f4 = i6;
        if (paint2 == null) {
            paint2 = paint;
        }
        typefaceEmojiRasterizerA.a(canvas, f3, f4, paint2);
    }
}
