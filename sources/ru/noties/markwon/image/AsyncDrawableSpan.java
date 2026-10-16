package ru.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AsyncDrawableSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsyncDrawable f147365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f147366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f147367d;

    public AsyncDrawableSpan(MarkwonTheme markwonTheme, AsyncDrawable asyncDrawable, int i3, boolean z2) {
        this.f147364a = markwonTheme;
        this.f147365b = asyncDrawable;
        this.f147366c = i3;
        this.f147367d = z2;
        if (asyncDrawable.getBounds().isEmpty()) {
            asyncDrawable.setBounds(0, 0, asyncDrawable.getIntrinsicWidth(), asyncDrawable.getIntrinsicHeight());
        }
    }

    private static float b(int i3, int i4, Paint paint) {
        return (int) ((i3 + ((i4 - i3) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    public AsyncDrawable a() {
        return this.f147365b;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
        int iHeight;
        this.f147365b.c(canvas.getWidth(), paint.getTextSize());
        AsyncDrawable asyncDrawable = this.f147365b;
        if (!asyncDrawable.a()) {
            float fB = b(i5, i7, paint);
            if (this.f147367d) {
                this.f147364a.f(paint);
            }
            canvas.drawText(charSequence, i3, i4, f3, fB, paint);
            return;
        }
        int i8 = i7 - asyncDrawable.getBounds().bottom;
        int iSave = canvas.save();
        try {
            int i9 = this.f147366c;
            if (2 != i9) {
                if (1 == i9) {
                    iHeight = paint.getFontMetricsInt().descent;
                }
                canvas.translate(f3, i8);
                asyncDrawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            iHeight = ((i7 - i5) - asyncDrawable.getBounds().height()) / 2;
            i8 -= iHeight;
            canvas.translate(f3, i8);
            asyncDrawable.draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.f147365b.a()) {
            if (this.f147367d) {
                this.f147364a.f(paint);
            }
            return (int) (paint.measureText(charSequence, i3, i4) + 0.5f);
        }
        Rect bounds = this.f147365b.getBounds();
        if (fontMetricsInt != null) {
            int i5 = -bounds.bottom;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i5;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
