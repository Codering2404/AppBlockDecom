package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.utils.LeadingMarginUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HeadingSpan extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f147166b = ObjectsPool.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f147167c = ObjectsPool.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f147168d;

    public HeadingSpan(MarkwonTheme markwonTheme, int i3) {
        this.f147165a = markwonTheme;
        this.f147168d = i3;
    }

    private void a(TextPaint textPaint) {
        this.f147165a.e(textPaint, this.f147168d);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        int width;
        int i10 = this.f147168d;
        if ((i10 == 1 || i10 == 2) && LeadingMarginUtils.a(i9, charSequence, this)) {
            this.f147167c.set(paint);
            this.f147165a.d(this.f147167c);
            float strokeWidth = this.f147167c.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i11 = (int) ((i7 - strokeWidth) + 0.5f);
                if (i4 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i3;
                    i3 -= canvas.getWidth();
                }
                this.f147166b.set(i3, i11, width, i7);
                canvas.drawRect(this.f147166b, this.f147167c);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
