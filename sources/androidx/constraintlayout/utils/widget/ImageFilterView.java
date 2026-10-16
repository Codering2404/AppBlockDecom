package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageMatrix f33002d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f33004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f33005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f33006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f33007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f33008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f33009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ViewOutlineProvider f33010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    RectF f33011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable[] f33012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    LayerDrawable f33013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f33014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f33015r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f33016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f33017t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ImageMatrix {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f33020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ColorMatrix f33021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorMatrix f33022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f33023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f33024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f33025f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f33026g;

        private void a(float f3) {
            float[] fArr = this.f33020a;
            fArr[0] = f3;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f3;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f3;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f3) {
            float f4 = 1.0f - f3;
            float f5 = 0.2999f * f4;
            float f6 = 0.587f * f4;
            float f7 = f4 * 0.114f;
            float[] fArr = this.f33020a;
            fArr[0] = f5 + f3;
            fArr[1] = f6;
            fArr[2] = f7;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f5;
            fArr[6] = f6 + f3;
            fArr[7] = f7;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f5;
            fArr[11] = f6;
            fArr[12] = f7 + f3;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f3) {
            float fLog;
            float fPow;
            if (f3 <= 0.0f) {
                f3 = 0.01f;
            }
            float f4 = (5000.0f / f3) / 100.0f;
            if (f4 > 66.0f) {
                double d3 = f4 - 60.0f;
                fPow = ((float) Math.pow(d3, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d3, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f4)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            float fLog2 = f4 < 66.0f ? f4 > 19.0f ? (((float) Math.log(f4 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f33020a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void c(ImageView imageView) {
            boolean z2;
            this.f33021b.reset();
            float f3 = this.f33024e;
            boolean z3 = true;
            if (f3 != 1.0f) {
                b(f3);
                this.f33021b.set(this.f33020a);
                z2 = true;
            } else {
                z2 = false;
            }
            float f4 = this.f33025f;
            if (f4 != 1.0f) {
                this.f33022c.setScale(f4, f4, f4, 1.0f);
                this.f33021b.postConcat(this.f33022c);
                z2 = true;
            }
            float f5 = this.f33026g;
            if (f5 != 1.0f) {
                d(f5);
                this.f33022c.set(this.f33020a);
                this.f33021b.postConcat(this.f33022c);
                z2 = true;
            }
            float f6 = this.f33023d;
            if (f6 != 1.0f) {
                a(f6);
                this.f33022c.set(this.f33020a);
                this.f33021b.postConcat(this.f33022c);
            } else {
                z3 = z2;
            }
            if (z3) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f33021b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    private void e() {
        if (Float.isNaN(this.f33014q) && Float.isNaN(this.f33015r) && Float.isNaN(this.f33016s) && Float.isNaN(this.f33017t)) {
            return;
        }
        float f3 = Float.isNaN(this.f33014q) ? 0.0f : this.f33014q;
        float f4 = Float.isNaN(this.f33015r) ? 0.0f : this.f33015r;
        float f5 = Float.isNaN(this.f33016s) ? 1.0f : this.f33016s;
        float f6 = Float.isNaN(this.f33017t) ? 0.0f : this.f33017t;
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

    private void f() {
        if (Float.isNaN(this.f33014q) && Float.isNaN(this.f33015r) && Float.isNaN(this.f33016s) && Float.isNaN(this.f33017t)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            e();
        }
    }

    private void setOverlay(boolean z2) {
        this.f33003f = z2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f33002d.f33023d;
    }

    public float getContrast() {
        return this.f33002d.f33025f;
    }

    public float getCrossfade() {
        return this.f33006i;
    }

    public float getImagePanX() {
        return this.f33014q;
    }

    public float getImagePanY() {
        return this.f33015r;
    }

    public float getImageRotate() {
        return this.f33017t;
    }

    public float getImageZoom() {
        return this.f33016s;
    }

    public float getRound() {
        return this.f33008k;
    }

    public float getRoundPercent() {
        return this.f33007j;
    }

    public float getSaturation() {
        return this.f33002d.f33024e;
    }

    public float getWarmth() {
        return this.f33002d.f33026g;
    }

    @Override // android.view.View
    public void layout(int i3, int i4, int i5, int i6) {
        super.layout(i3, i4, i5, i6);
        e();
    }

    public void setAltImageResource(int i3) {
        Drawable drawableMutate = AppCompatResources.b(getContext(), i3).mutate();
        this.f33004g = drawableMutate;
        Drawable[] drawableArr = this.f33012o;
        drawableArr[0] = this.f33005h;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f33012o);
        this.f33013p = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f33006i);
    }

    public void setBrightness(float f3) {
        ImageMatrix imageMatrix = this.f33002d;
        imageMatrix.f33023d = f3;
        imageMatrix.c(this);
    }

    public void setContrast(float f3) {
        ImageMatrix imageMatrix = this.f33002d;
        imageMatrix.f33025f = f3;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f3) {
        this.f33006i = f3;
        if (this.f33012o != null) {
            if (!this.f33003f) {
                this.f33013p.getDrawable(0).setAlpha((int) ((1.0f - this.f33006i) * 255.0f));
            }
            this.f33013p.getDrawable(1).setAlpha((int) (this.f33006i * 255.0f));
            super.setImageDrawable(this.f33013p);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f33004g == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f33005h = drawableMutate;
        Drawable[] drawableArr = this.f33012o;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f33004g;
        LayerDrawable layerDrawable = new LayerDrawable(this.f33012o);
        this.f33013p = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f33006i);
    }

    public void setImagePanX(float f3) {
        this.f33014q = f3;
        f();
    }

    public void setImagePanY(float f3) {
        this.f33015r = f3;
        f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        if (this.f33004g == null) {
            super.setImageResource(i3);
            return;
        }
        Drawable drawableMutate = AppCompatResources.b(getContext(), i3).mutate();
        this.f33005h = drawableMutate;
        Drawable[] drawableArr = this.f33012o;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f33004g;
        LayerDrawable layerDrawable = new LayerDrawable(this.f33012o);
        this.f33013p = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f33006i);
    }

    public void setImageRotate(float f3) {
        this.f33017t = f3;
        f();
    }

    public void setImageZoom(float f3) {
        this.f33016s = f3;
        f();
    }

    public void setRound(float f3) {
        if (Float.isNaN(f3)) {
            this.f33008k = f3;
            float f4 = this.f33007j;
            this.f33007j = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z2 = this.f33008k != f3;
        this.f33008k = f3;
        if (f3 != 0.0f) {
            if (this.f33009l == null) {
                this.f33009l = new Path();
            }
            if (this.f33011n == null) {
                this.f33011n = new RectF();
            }
            if (this.f33010m == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f33008k);
                    }
                };
                this.f33010m = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f33011n.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f33009l.reset();
            Path path = this.f33009l;
            RectF rectF = this.f33011n;
            float f5 = this.f33008k;
            path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f3) {
        boolean z2 = this.f33007j != f3;
        this.f33007j = f3;
        if (f3 != 0.0f) {
            if (this.f33009l == null) {
                this.f33009l = new Path();
            }
            if (this.f33011n == null) {
                this.f33011n = new RectF();
            }
            if (this.f33010m == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f33007j) / 2.0f);
                    }
                };
                this.f33010m = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f33007j) / 2.0f;
            this.f33011n.set(0.0f, 0.0f, width, height);
            this.f33009l.reset();
            this.f33009l.addRoundRect(this.f33011n, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f3) {
        ImageMatrix imageMatrix = this.f33002d;
        imageMatrix.f33024e = f3;
        imageMatrix.c(this);
    }

    public void setWarmth(float f3) {
        ImageMatrix imageMatrix = this.f33002d;
        imageMatrix.f33026g = f3;
        imageMatrix.c(this);
    }
}
