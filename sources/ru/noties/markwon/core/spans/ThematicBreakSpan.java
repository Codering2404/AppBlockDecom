package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ThematicBreakSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f147180b = ObjectsPool.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f147181c = ObjectsPool.a();

    public ThematicBreakSpan(MarkwonTheme markwonTheme) {
        this.f147179a = markwonTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        int width;
        int i10 = i5 + ((i7 - i5) / 2);
        this.f147181c.set(paint);
        this.f147179a.i(this.f147181c);
        int strokeWidth = (int) ((((int) (this.f147181c.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i4 > 0) {
            width = canvas.getWidth();
        } else {
            width = i3;
            i3 -= canvas.getWidth();
        }
        this.f147180b.set(i3, i10 - strokeWidth, width, i10 + strokeWidth);
        canvas.drawRect(this.f147180b, this.f147181c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return 0;
    }
}
