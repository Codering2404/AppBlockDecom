package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BlockQuoteSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f147153b = ObjectsPool.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f147154c = ObjectsPool.a();

    public BlockQuoteSpan(MarkwonTheme markwonTheme) {
        this.f147152a = markwonTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        int iL = this.f147152a.l();
        this.f147154c.set(paint);
        this.f147152a.a(this.f147154c);
        int i10 = i4 * iL;
        int i11 = i3 + i10;
        int i12 = i10 + i11;
        this.f147153b.set(Math.min(i11, i12), i5, Math.max(i11, i12), i7);
        canvas.drawRect(this.f147153b, this.f147154c);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return this.f147152a.k();
    }
}
