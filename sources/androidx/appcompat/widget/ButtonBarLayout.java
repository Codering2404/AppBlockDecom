package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1940c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1940c = -1;
        int[] iArr = R.styleable.P0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.k0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f1938a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Q0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1938a);
        }
    }

    private int a(int i3) {
        int childCount = getChildCount();
        while (i3 < childCount) {
            if (getChildAt(i3).getVisibility() == 0) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1939b;
    }

    private void setStacked(boolean z2) {
        if (this.f1939b != z2) {
            if (!z2 || this.f1938a) {
                this.f1939b = z2;
                setOrientation(z2 ? 1 : 0);
                setGravity(z2 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.M);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z2 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int iMakeMeasureSpec;
        boolean z2;
        int size = View.MeasureSpec.getSize(i3);
        int paddingBottom = 0;
        if (this.f1938a) {
            if (size > this.f1940c && b()) {
                setStacked(false);
            }
            this.f1940c = size;
        }
        if (b() || View.MeasureSpec.getMode(i3) != 1073741824) {
            iMakeMeasureSpec = i3;
            z2 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z2 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i4);
        if (this.f1938a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z2 = true;
        }
        if (z2) {
            super.onMeasure(i3, i4);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.z(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i4 == 0) {
                super.onMeasure(i3, i4);
            }
        }
    }

    public void setAllowStacking(boolean z2) {
        if (this.f1938a != z2) {
            this.f1938a = z2;
            if (!z2 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
