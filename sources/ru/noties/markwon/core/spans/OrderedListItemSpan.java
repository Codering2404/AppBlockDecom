package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.utils.LeadingMarginUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class OrderedListItemSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f147176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f147177c = ObjectsPool.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f147178d;

    public OrderedListItemSpan(MarkwonTheme markwonTheme, String str) {
        this.f147175a = markwonTheme;
        this.f147176b = str;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            OrderedListItemSpan[] orderedListItemSpanArr = (OrderedListItemSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), OrderedListItemSpan.class);
            if (orderedListItemSpanArr != null) {
                TextPaint paint = textView.getPaint();
                for (OrderedListItemSpan orderedListItemSpan : orderedListItemSpanArr) {
                    orderedListItemSpan.f147178d = (int) (paint.measureText(orderedListItemSpan.f147176b) + 0.5f);
                }
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        if (z2 && LeadingMarginUtils.b(i8, charSequence, this)) {
            this.f147177c.set(paint);
            this.f147175a.h(this.f147177c);
            int iMeasureText = (int) (this.f147177c.measureText(this.f147176b) + 0.5f);
            int iK = this.f147175a.k();
            if (iMeasureText > iK) {
                this.f147178d = iMeasureText;
                iK = iMeasureText;
            } else {
                this.f147178d = 0;
            }
            canvas.drawText(this.f147176b, i4 > 0 ? (i3 + (iK * i4)) - iMeasureText : i3 + (i4 * iK) + (iK - iMeasureText), i6, this.f147177c);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return Math.max(this.f147178d, this.f147175a.k());
    }
}
