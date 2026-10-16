package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f81198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f81199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f81200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f81201d;

    private static int a(int i3, int i4, int i5) {
        return i4 != Integer.MIN_VALUE ? i4 != 1073741824 ? i5 : i3 : Math.min(i5, i3);
    }

    public int b(View view) {
        Object tag = view.getTag(R.id.f79633g0);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f81200c;
    }

    protected int getItemSpacing() {
        return this.f81199b;
    }

    protected int getLineSpacing() {
        return this.f81198a;
    }

    protected int getRowCount() {
        return this.f81201d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int iA;
        int iB;
        if (getChildCount() == 0) {
            this.f81201d = 0;
            return;
        }
        this.f81201d = 1;
        boolean z3 = ViewCompat.y(this) == 1;
        int paddingRight = z3 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z3 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = (i5 - i3) - paddingLeft;
        int measuredWidth = paddingRight;
        int i8 = paddingTop;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.f79633g0, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iB = MarginLayoutParamsCompat.b(marginLayoutParams);
                    iA = MarginLayoutParamsCompat.a(marginLayoutParams);
                } else {
                    iA = 0;
                    iB = 0;
                }
                int measuredWidth2 = measuredWidth + iB + childAt.getMeasuredWidth();
                if (!this.f81200c && measuredWidth2 > i7) {
                    i8 = this.f81198a + paddingTop;
                    this.f81201d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.f79633g0, Integer.valueOf(this.f81201d - 1));
                int i10 = measuredWidth + iB;
                int measuredWidth3 = childAt.getMeasuredWidth() + i10;
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (z3) {
                    childAt.layout(i7 - measuredWidth3, i8, (i7 - measuredWidth) - iB, measuredHeight);
                } else {
                    childAt.layout(i10, i8, measuredWidth3, measuredHeight);
                }
                measuredWidth += iB + iA + childAt.getMeasuredWidth() + this.f81199b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i4);
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i4);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin;
                    i6 = marginLayoutParams.rightMargin;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int i11 = paddingLeft2;
                if (paddingLeft2 + i5 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i11;
                } else {
                    paddingLeft = getPaddingLeft();
                    i8 = this.f81198a + paddingTop;
                }
                int measuredWidth = paddingLeft + i5 + childAt.getMeasuredWidth();
                int measuredHeight = i8 + childAt.getMeasuredHeight();
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i5 + i6 + childAt.getMeasuredWidth() + this.f81199b;
                if (i10 == getChildCount() - 1) {
                    i9 += i6;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i9 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i3) {
        this.f81199b = i3;
    }

    protected void setLineSpacing(int i3) {
        this.f81198a = i3;
    }

    public void setSingleLine(boolean z2) {
        this.f81200c = z2;
    }
}
