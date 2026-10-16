package ru.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import ru.noties.markwon.core.MarkwonTheme;
import ru.noties.markwon.utils.LeadingMarginUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BulletListItemSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MarkwonTheme f147155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f147156b = ObjectsPool.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f147157c = ObjectsPool.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f147158d = ObjectsPool.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f147159f;

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i3) {
        this.f147155a = markwonTheme;
        this.f147159f = i3;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        if (z2 && LeadingMarginUtils.b(i8, charSequence, this)) {
            this.f147156b.set(paint);
            this.f147155a.h(this.f147156b);
            int iSave = canvas.save();
            try {
                int iK = this.f147155a.k();
                int iM = this.f147155a.m((int) ((this.f147156b.descent() - this.f147156b.ascent()) + 0.5f));
                int i10 = (iK - iM) / 2;
                int width = i4 < 0 ? i3 - (layout.getWidth() - (iK * this.f147159f)) : (iK * this.f147159f) - i3;
                int i11 = i3 + (i10 * i4);
                int i12 = (i4 * iM) + i11;
                int i13 = i4 * width;
                int iMin = Math.min(i11, i12) + i13;
                int iMax = Math.max(i11, i12) + i13;
                int iDescent = (i6 + ((int) (((this.f147156b.descent() + this.f147156b.ascent()) / 2.0f) + 0.5f))) - (iM / 2);
                int i14 = iM + iDescent;
                int i15 = this.f147159f;
                if (i15 == 0 || i15 == 1) {
                    this.f147157c.set(iMin, iDescent, iMax, i14);
                    this.f147156b.setStyle(this.f147159f == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.f147157c, this.f147156b);
                } else {
                    this.f147158d.set(iMin, iDescent, iMax, i14);
                    this.f147156b.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.f147158d, this.f147156b);
                }
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        return this.f147155a.k();
    }
}
