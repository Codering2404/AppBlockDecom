package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageFilterView.ImageMatrix f32984d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f32986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f32987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Path f32988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ViewOutlineProvider f32989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    RectF f32990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Drawable[] f32991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    LayerDrawable f32992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f32993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f32994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f32995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f32996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f32997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f32998s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f32999t;

    private void c() {
        if (Float.isNaN(this.f32996q) && Float.isNaN(this.f32997r) && Float.isNaN(this.f32998s) && Float.isNaN(this.f32999t)) {
            return;
        }
        float f3 = Float.isNaN(this.f32996q) ? 0.0f : this.f32996q;
        float f4 = Float.isNaN(this.f32997r) ? 0.0f : this.f32997r;
        float f5 = Float.isNaN(this.f32998s) ? 1.0f : this.f32998s;
        float f6 = Float.isNaN(this.f32999t) ? 0.0f : this.f32999t;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f7 = f5 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f7, f7);
        float f8 = intrinsicWidth * f7;
        float f9 = f7 * intrinsicHeight;
        matrix.postTranslate((((f3 * (width - f8)) + width) - f8) * 0.5f, (((f4 * (height - f9)) + height) - f9) * 0.5f);
        matrix.postRotate(f6, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void d() {
        if (Float.isNaN(this.f32996q) && Float.isNaN(this.f32997r) && Float.isNaN(this.f32998s) && Float.isNaN(this.f32999t)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    private void setOverlay(boolean z2) {
        this.f32993n = z2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f32984d.f33025f;
    }

    public float getCrossfade() {
        return this.f32985f;
    }

    public float getImagePanX() {
        return this.f32996q;
    }

    public float getImagePanY() {
        return this.f32997r;
    }

    public float getImageRotate() {
        return this.f32999t;
    }

    public float getImageZoom() {
        return this.f32998s;
    }

    public float getRound() {
        return this.f32987h;
    }

    public float getRoundPercent() {
        return this.f32986g;
    }

    public float getSaturation() {
        return this.f32984d.f33024e;
    }

    public float getWarmth() {
        return this.f32984d.f33026g;
    }

    @Override // android.view.View
    public void layout(int i3, int i4, int i5, int i6) {
        super.layout(i3, i4, i5, i6);
        c();
    }

    public void setAltImageResource(int i3) {
        Drawable drawableMutate = AppCompatResources.b(getContext(), i3).mutate();
        this.f32994o = drawableMutate;
        Drawable[] drawableArr = this.f32991l;
        drawableArr[0] = this.f32995p;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f32991l);
        this.f32992m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f32985f);
    }

    public void setBrightness(float f3) {
        ImageFilterView.ImageMatrix imageMatrix = this.f32984d;
        imageMatrix.f33023d = f3;
        imageMatrix.c(this);
    }

    public void setContrast(float f3) {
        ImageFilterView.ImageMatrix imageMatrix = this.f32984d;
        imageMatrix.f33025f = f3;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f3) {
        this.f32985f = f3;
        if (this.f32991l != null) {
            if (!this.f32993n) {
                this.f32992m.getDrawable(0).setAlpha((int) ((1.0f - this.f32985f) * 255.0f));
            }
            this.f32992m.getDrawable(1).setAlpha((int) (this.f32985f * 255.0f));
            super.setImageDrawable(this.f32992m);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f32994o == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f32995p = drawableMutate;
        Drawable[] drawableArr = this.f32991l;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f32994o;
        LayerDrawable layerDrawable = new LayerDrawable(this.f32991l);
        this.f32992m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f32985f);
    }

    public void setImagePanX(float f3) {
        this.f32996q = f3;
        d();
    }

    public void setImagePanY(float f3) {
        this.f32997r = f3;
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i3) {
        if (this.f32994o == null) {
            super.setImageResource(i3);
            return;
        }
        Drawable drawableMutate = AppCompatResources.b(getContext(), i3).mutate();
        this.f32995p = drawableMutate;
        Drawable[] drawableArr = this.f32991l;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f32994o;
        LayerDrawable layerDrawable = new LayerDrawable(this.f32991l);
        this.f32992m = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f32985f);
    }

    public void setImageRotate(float f3) {
        this.f32999t = f3;
        d();
    }

    public void setImageZoom(float f3) {
        this.f32998s = f3;
        d();
    }

    public void setRound(float f3) {
        if (Float.isNaN(f3)) {
            this.f32987h = f3;
            float f4 = this.f32986g;
            this.f32986g = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z2 = this.f32987h != f3;
        this.f32987h = f3;
        if (f3 != 0.0f) {
            if (this.f32988i == null) {
                this.f32988i = new Path();
            }
            if (this.f32990k == null) {
                this.f32990k = new RectF();
            }
            if (this.f32989j == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f32987h);
                    }
                };
                this.f32989j = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f32990k.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f32988i.reset();
            Path path = this.f32988i;
            RectF rectF = this.f32990k;
            float f5 = this.f32987h;
            path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f3) {
        boolean z2 = this.f32986g != f3;
        this.f32986g = f3;
        if (f3 != 0.0f) {
            if (this.f32988i == null) {
                this.f32988i = new Path();
            }
            if (this.f32990k == null) {
                this.f32990k = new RectF();
            }
            if (this.f32989j == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f32986g) / 2.0f);
                    }
                };
                this.f32989j = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f32986g) / 2.0f;
            this.f32990k.set(0.0f, 0.0f, width, height);
            this.f32988i.reset();
            this.f32988i.addRoundRect(this.f32990k, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f3) {
        ImageFilterView.ImageMatrix imageMatrix = this.f32984d;
        imageMatrix.f33024e = f3;
        imageMatrix.c(this);
    }

    public void setWarmth(float f3) {
        ImageFilterView.ImageMatrix imageMatrix = this.f32984d;
        imageMatrix.f33026g = f3;
        imageMatrix.c(this);
    }
}
