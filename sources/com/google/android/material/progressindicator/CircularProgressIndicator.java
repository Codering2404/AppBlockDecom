package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f81514q = R.style.H;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79492i);
    }

    private void s() {
        CircularDrawingDelegate circularDrawingDelegate = new CircularDrawingDelegate((CircularProgressIndicatorSpec) this.f81469a);
        setIndeterminateDrawable(IndeterminateDrawable.t(getContext(), (CircularProgressIndicatorSpec) this.f81469a, circularDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.v(getContext(), (CircularProgressIndicatorSpec) this.f81469a, circularDrawingDelegate));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f81469a).f81517j;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f81469a).f81516i;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f81469a).f81515h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndicatorDirection(int i3) {
        ((CircularProgressIndicatorSpec) this.f81469a).f81517j = i3;
        invalidate();
    }

    public void setIndicatorInset(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81516i != i3) {
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81516i = i3;
            invalidate();
        }
    }

    public void setIndicatorSize(int i3) {
        int iMax = Math.max(i3, getTrackThickness() * 2);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81515h != iMax) {
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81515h = iMax;
            ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).e();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i3) {
        super.setTrackThickness(i3);
        ((CircularProgressIndicatorSpec) this.f81469a).e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3, f81514q);
        s();
    }
}
