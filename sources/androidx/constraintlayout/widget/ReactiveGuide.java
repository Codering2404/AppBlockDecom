package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33397c;

    public int getApplyToConstraintSetId() {
        return this.f33397c;
    }

    public int getAttributeId() {
        return this.f33395a;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z2) {
        this.f33396b = z2;
    }

    public void setApplyToConstraintSetId(int i3) {
        this.f33397c = i3;
    }

    public void setAttributeId(int i3) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i4 = this.f33395a;
        if (i4 != -1) {
            sharedValues.b(i4, this);
        }
        this.f33395a = i3;
        if (i3 != -1) {
            sharedValues.a(i3, this);
        }
    }

    public void setGuidelineBegin(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f33106a = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f33108b = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f33110c = f3;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }
}
