package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f33294a;

    public Guideline(Context context) {
        super(context);
        this.f33294a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z2) {
        this.f33294a = z2;
    }

    public void setGuidelineBegin(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f33294a && layoutParams.f33106a == i3) {
            return;
        }
        layoutParams.f33106a = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f33294a && layoutParams.f33108b == i3) {
            return;
        }
        layoutParams.f33108b = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f33294a && layoutParams.f33110c == f3) {
            return;
        }
        layoutParams.f33110c = f3;
        setLayoutParams(layoutParams);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33294a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }
}
