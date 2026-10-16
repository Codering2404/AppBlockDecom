package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f33035d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f33036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f33037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ViewOutlineProvider f33038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    RectF f33039i;

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f33036f;
    }

    public float getRoundPercent() {
        return this.f33035d;
    }

    public void setRound(float f3) {
        if (Float.isNaN(f3)) {
            this.f33036f = f3;
            float f4 = this.f33035d;
            this.f33035d = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z2 = this.f33036f != f3;
        this.f33036f = f3;
        if (f3 != 0.0f) {
            if (this.f33037g == null) {
                this.f33037g = new Path();
            }
            if (this.f33039i == null) {
                this.f33039i = new RectF();
            }
            if (this.f33038h == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f33036f);
                    }
                };
                this.f33038h = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f33039i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f33037g.reset();
            Path path = this.f33037g;
            RectF rectF = this.f33039i;
            float f5 = this.f33036f;
            path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f3) {
        boolean z2 = this.f33035d != f3;
        this.f33035d = f3;
        if (f3 != 0.0f) {
            if (this.f33037g == null) {
                this.f33037g = new Path();
            }
            if (this.f33039i == null) {
                this.f33039i = new RectF();
            }
            if (this.f33038h == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.f33035d) / 2.0f);
                    }
                };
                this.f33038h = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f33035d) / 2.0f;
            this.f33039i.set(0.0f, 0.0f, width, height);
            this.f33037g.reset();
            this.f33037g.addRoundRect(this.f33039i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }
}
