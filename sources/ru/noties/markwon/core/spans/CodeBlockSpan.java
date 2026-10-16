package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CodeBlockSpan extends MetricAffectingSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f147161b = ObjectsPool.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f147162c = ObjectsPool.a();

    public CodeBlockSpan(MarkwonTheme markwonTheme) {
        this.f147160a = markwonTheme;
    }

    private void a(TextPaint textPaint) {
        this.f147160a.b(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        int width;
        this.f147162c.setStyle(Paint.Style.FILL);
        this.f147162c.setColor(this.f147160a.o(paint));
        if (i4 > 0) {
            width = canvas.getWidth();
        } else {
            i3 -= canvas.getWidth();
            width = i3;
        }
        this.f147161b.set(i3, i5, width, i7);
        canvas.drawRect(this.f147161b, this.f147162c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return this.f147160a.p();
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
