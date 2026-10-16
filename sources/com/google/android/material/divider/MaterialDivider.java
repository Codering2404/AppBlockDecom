package com.google.android.material.divider;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f80937g = R.style.P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialShapeDrawable f80938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f80939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f80941d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80942f;

    public int getDividerColor() {
        return this.f80940c;
    }

    public int getDividerInsetEnd() {
        return this.f80942f;
    }

    public int getDividerInsetStart() {
        return this.f80941d;
    }

    public int getDividerThickness() {
        return this.f80939b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i3;
        super.onDraw(canvas);
        boolean z2 = ViewCompat.y(this) == 1;
        int i4 = z2 ? this.f80942f : this.f80941d;
        if (z2) {
            width = getWidth();
            i3 = this.f80941d;
        } else {
            width = getWidth();
            i3 = this.f80942f;
        }
        this.f80938a.setBounds(i4, 0, width - i3, getBottom() - getTop());
        this.f80938a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i5 = this.f80939b;
            if (i5 > 0 && measuredHeight != i5) {
                measuredHeight = i5;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i3) {
        if (this.f80940c != i3) {
            this.f80940c = i3;
            this.f80938a.a0(ColorStateList.valueOf(i3));
            invalidate();
        }
    }

    public void setDividerColorResource(int i3) {
        setDividerColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setDividerInsetEnd(int i3) {
        this.f80942f = i3;
    }

    public void setDividerInsetEndResource(int i3) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i3));
    }

    public void setDividerInsetStart(int i3) {
        this.f80941d = i3;
    }

    public void setDividerInsetStartResource(int i3) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i3));
    }

    public void setDividerThickness(int i3) {
        if (this.f80939b != i3) {
            this.f80939b = i3;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i3) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i3));
    }
}
