package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f33296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33297c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f33296b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f33296b.getLayoutParams();
        layoutParams2.f33149v0.q1(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = layoutParams.f33149v0.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviourC != dimensionBehaviour) {
            layoutParams.f33149v0.r1(layoutParams2.f33149v0.a0());
        }
        if (layoutParams.f33149v0.X() != dimensionBehaviour) {
            layoutParams.f33149v0.S0(layoutParams2.f33149v0.z());
        }
        layoutParams2.f33149v0.q1(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f33295a == -1 && !isInEditMode()) {
            setVisibility(this.f33297c);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f33295a);
        this.f33296b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams()).f33125j0 = true;
            this.f33296b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f33296b;
    }

    public int getEmptyVisibility() {
        return this.f33297c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i3) {
        View viewFindViewById;
        if (this.f33295a == i3) {
            return;
        }
        View view = this.f33296b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f33296b.getLayoutParams()).f33125j0 = false;
            this.f33296b = null;
        }
        this.f33295a = i3;
        if (i3 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i3)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i3) {
        this.f33297c = i3;
    }
}
