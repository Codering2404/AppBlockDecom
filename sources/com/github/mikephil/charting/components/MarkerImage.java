package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MarkerImage implements IMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f68464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MPPointF f68465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MPPointF f68466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference f68467d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FSize f68468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Rect f68469g;

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Canvas canvas, float f3, float f4) {
        if (this.f68464a == null) {
            return;
        }
        MPPointF mPPointFE = e(f3, f4);
        FSize fSize = this.f68468f;
        float intrinsicWidth = fSize.f68786c;
        float intrinsicHeight = fSize.f68787d;
        if (intrinsicWidth == 0.0f) {
            intrinsicWidth = this.f68464a.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f) {
            intrinsicHeight = this.f68464a.getIntrinsicHeight();
        }
        this.f68464a.copyBounds(this.f68469g);
        Drawable drawable = this.f68464a;
        Rect rect = this.f68469g;
        int i3 = rect.left;
        int i4 = rect.top;
        drawable.setBounds(i3, i4, ((int) intrinsicWidth) + i3, ((int) intrinsicHeight) + i4);
        int iSave = canvas.save();
        canvas.translate(f3 + mPPointFE.f68793c, f4 + mPPointFE.f68794d);
        this.f68464a.draw(canvas);
        canvas.restoreToCount(iSave);
        this.f68464a.setBounds(this.f68469g);
    }

    public Chart c() {
        WeakReference weakReference = this.f68467d;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF d() {
        return this.f68465b;
    }

    public MPPointF e(float f3, float f4) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF mPPointFD = d();
        MPPointF mPPointF = this.f68466c;
        mPPointF.f68793c = mPPointFD.f68793c;
        mPPointF.f68794d = mPPointFD.f68794d;
        Chart chartC = c();
        FSize fSize = this.f68468f;
        float intrinsicWidth = fSize.f68786c;
        float intrinsicHeight = fSize.f68787d;
        if (intrinsicWidth == 0.0f && (drawable2 = this.f68464a) != null) {
            intrinsicWidth = drawable2.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f && (drawable = this.f68464a) != null) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.f68466c;
        float f5 = mPPointF2.f68793c;
        if (f3 + f5 < 0.0f) {
            mPPointF2.f68793c = -f3;
        } else if (chartC != null && f3 + intrinsicWidth + f5 > chartC.getWidth()) {
            this.f68466c.f68793c = (chartC.getWidth() - f3) - intrinsicWidth;
        }
        MPPointF mPPointF3 = this.f68466c;
        float f6 = mPPointF3.f68794d;
        if (f4 + f6 < 0.0f) {
            mPPointF3.f68794d = -f4;
        } else if (chartC != null && f4 + intrinsicHeight + f6 > chartC.getHeight()) {
            this.f68466c.f68794d = (chartC.getHeight() - f4) - intrinsicHeight;
        }
        return this.f68466c;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void b(Entry entry, Highlight highlight) {
    }
}
