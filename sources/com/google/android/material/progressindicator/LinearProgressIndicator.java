package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f81577q = R.style.M;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f81469a).f81578h;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f81469a).f81579i;
    }

    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.f81469a).f81581k;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void o(int i3, boolean z2) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (baseProgressIndicatorSpec != null && ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81578h == 0 && isIndeterminate()) {
            return;
        }
        super.o(i3, z2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) baseProgressIndicatorSpec;
        boolean z3 = true;
        if (((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81579i != 1 && ((ViewCompat.y(this) != 1 || ((LinearProgressIndicatorSpec) this.f81469a).f81579i != 2) && (ViewCompat.y(this) != 0 || ((LinearProgressIndicatorSpec) this.f81469a).f81579i != 3))) {
            z3 = false;
        }
        linearProgressIndicatorSpec.f81580j = z3;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        int paddingLeft = i3 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i4 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec i(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i3) {
        if (((LinearProgressIndicatorSpec) this.f81469a).f81578h == i3) {
            return;
        }
        if (q() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81578h = i3;
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).e();
        if (i3 == 0) {
            getIndeterminateDrawable().x(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.f81469a));
        } else {
            getIndeterminateDrawable().x(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.f81469a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f81469a).e();
    }

    public void setIndicatorDirection(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81579i = i3;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) baseProgressIndicatorSpec;
        boolean z2 = true;
        if (i3 != 1 && ((ViewCompat.y(this) != 1 || ((LinearProgressIndicatorSpec) this.f81469a).f81579i != 2) && (ViewCompat.y(this) != 0 || i3 != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f81580j = z2;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i3) {
        super.setTrackCornerRadius(i3);
        ((LinearProgressIndicatorSpec) this.f81469a).e();
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i3) {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81469a;
        if (((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81581k != i3) {
            ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81581k = Math.min(i3, ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81487a);
            ((LinearProgressIndicatorSpec) this.f81469a).e();
            invalidate();
        }
    }
}
