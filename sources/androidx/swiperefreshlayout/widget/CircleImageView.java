package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class CircleImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f53268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f53269b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OvalShadow extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RadialGradient f53270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Paint f53271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CircleImageView f53272c;

        private void a(int i3) {
            float f3 = i3 / 2;
            RadialGradient radialGradient = new RadialGradient(f3, f3, this.f53272c.f53269b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f53270a = radialGradient;
            this.f53271b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.f53272c.getWidth() / 2;
            float height = this.f53272c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f53271b);
            canvas.drawCircle(width, height, r0 - this.f53272c.f53269b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f3, float f4) {
            super.onResize(f3, f4);
            a((int) f3);
        }
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f53268a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f53268a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f53268a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f53269b * 2), getMeasuredHeight() + (this.f53269b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i3);
        }
    }
}
