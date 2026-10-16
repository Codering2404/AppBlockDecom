package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f82107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f82108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f82109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f82110d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82109c = MotionUtils.g(context, R.attr.f79487f0, AnimationUtils.f79850b);
    }

    private static void d(View view, int i3, int i4) {
        if (ViewCompat.T(view)) {
            ViewCompat.D0(view, ViewCompat.D(view), i3, ViewCompat.C(view), i4);
        } else {
            view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), i4);
        }
    }

    private boolean e(int i3, int i4, int i5) {
        boolean z2;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f82107a.getPaddingTop() == i4 && this.f82107a.getPaddingBottom() == i5) {
            return z2;
        }
        d(this.f82107a, i4, i5);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void a(int i3, int i4) {
        this.f82107a.setAlpha(0.0f);
        long j3 = i4;
        long j4 = i3;
        this.f82107a.animate().alpha(1.0f).setDuration(j3).setInterpolator(this.f82109c).setStartDelay(j4).start();
        if (this.f82108b.getVisibility() == 0) {
            this.f82108b.setAlpha(0.0f);
            this.f82108b.animate().alpha(1.0f).setDuration(j3).setInterpolator(this.f82109c).setStartDelay(j4).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void b(int i3, int i4) {
        this.f82107a.setAlpha(1.0f);
        long j3 = i4;
        long j4 = i3;
        this.f82107a.animate().alpha(0.0f).setDuration(j3).setInterpolator(this.f82109c).setStartDelay(j4).start();
        if (this.f82108b.getVisibility() == 0) {
            this.f82108b.setAlpha(1.0f);
            this.f82108b.animate().alpha(0.0f).setDuration(j3).setInterpolator(this.f82109c).setStartDelay(j4).start();
        }
    }

    void c(float f3) {
        if (f3 != 1.0f) {
            this.f82108b.setTextColor(MaterialColors.l(MaterialColors.d(this, R.attr.f79518v), this.f82108b.getCurrentTextColor(), f3));
        }
    }

    public Button getActionView() {
        return this.f82108b;
    }

    public TextView getMessageView() {
        return this.f82107a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f82107a = (TextView) findViewById(R.id.f79639j0);
        this.f82108b = (Button) findViewById(R.id.f79637i0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f79572j);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f79570i);
        Layout layout = this.f82107a.getLayout();
        boolean z2 = layout != null && layout.getLineCount() > 1;
        if (!z2 || this.f82110d <= 0 || this.f82108b.getMeasuredWidth() <= this.f82110d) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!e(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!e(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i3, i4);
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f82110d = i3;
    }
}
