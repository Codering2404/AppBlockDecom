package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CircularRevealHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f80497j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Delegate f80498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f80499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f80500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f80501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f80502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CircularRevealWidget.RevealInfo f80503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f80504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f80505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f80506i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Delegate {
        void c(Canvas canvas);

        boolean d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    private void d(Canvas canvas) {
        if (o()) {
            Rect bounds = this.f80504g.getBounds();
            float fWidth = this.f80503f.f80513a - (bounds.width() / 2.0f);
            float fHeight = this.f80503f.f80514b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f80504g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    private float g(CircularRevealWidget.RevealInfo revealInfo) {
        return MathUtils.b(revealInfo.f80513a, revealInfo.f80514b, 0.0f, 0.0f, this.f80499b.getWidth(), this.f80499b.getHeight());
    }

    private void i() {
        if (f80497j == 1) {
            this.f80500c.rewind();
            CircularRevealWidget.RevealInfo revealInfo = this.f80503f;
            if (revealInfo != null) {
                this.f80500c.addCircle(revealInfo.f80513a, revealInfo.f80514b, revealInfo.f80515c, Path.Direction.CW);
            }
        }
        this.f80499b.invalidate();
    }

    private boolean n() {
        CircularRevealWidget.RevealInfo revealInfo = this.f80503f;
        boolean z2 = revealInfo == null || revealInfo.a();
        return f80497j == 0 ? !z2 && this.f80506i : !z2;
    }

    private boolean o() {
        return (this.f80505h || this.f80504g == null || this.f80503f == null) ? false : true;
    }

    private boolean p() {
        return (this.f80505h || Color.alpha(this.f80502e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f80497j == 0) {
            this.f80505h = true;
            this.f80506i = false;
            this.f80499b.buildDrawingCache();
            Bitmap drawingCache = this.f80499b.getDrawingCache();
            if (drawingCache == null && this.f80499b.getWidth() != 0 && this.f80499b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f80499b.getWidth(), this.f80499b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f80499b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f80501d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f80505h = false;
            this.f80506i = true;
        }
    }

    public void b() {
        if (f80497j == 0) {
            this.f80506i = false;
            this.f80499b.destroyDrawingCache();
            this.f80501d.setShader(null);
            this.f80499b.invalidate();
        }
    }

    public void c(Canvas canvas) {
        Canvas canvas2;
        if (n()) {
            int i3 = f80497j;
            if (i3 == 0) {
                canvas2 = canvas;
                CircularRevealWidget.RevealInfo revealInfo = this.f80503f;
                canvas2.drawCircle(revealInfo.f80513a, revealInfo.f80514b, revealInfo.f80515c, this.f80501d);
                if (p()) {
                    CircularRevealWidget.RevealInfo revealInfo2 = this.f80503f;
                    canvas2.drawCircle(revealInfo2.f80513a, revealInfo2.f80514b, revealInfo2.f80515c, this.f80502e);
                }
            } else if (i3 == 1) {
                canvas2 = canvas;
                int iSave = canvas2.save();
                canvas2.clipPath(this.f80500c);
                this.f80498a.c(canvas2);
                if (p()) {
                    canvas2.drawRect(0.0f, 0.0f, this.f80499b.getWidth(), this.f80499b.getHeight(), this.f80502e);
                }
                canvas2.restoreToCount(iSave);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i3);
                }
                this.f80498a.c(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f80499b.getWidth(), this.f80499b.getHeight(), this.f80502e);
                    canvas2 = canvas;
                } else {
                    canvas2 = canvas;
                }
            }
        } else {
            canvas2 = canvas;
            this.f80498a.c(canvas2);
            if (p()) {
                canvas2.drawRect(0.0f, 0.0f, this.f80499b.getWidth(), this.f80499b.getHeight(), this.f80502e);
            }
        }
        d(canvas2);
    }

    public Drawable e() {
        return this.f80504g;
    }

    public int f() {
        return this.f80502e.getColor();
    }

    public CircularRevealWidget.RevealInfo h() {
        CircularRevealWidget.RevealInfo revealInfo = this.f80503f;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.a()) {
            revealInfo2.f80515c = g(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean j() {
        return this.f80498a.d() && !n();
    }

    public void k(Drawable drawable) {
        this.f80504g = drawable;
        this.f80499b.invalidate();
    }

    public void l(int i3) {
        this.f80502e.setColor(i3);
        this.f80499b.invalidate();
    }

    public void m(CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.f80503f = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.f80503f;
            if (revealInfo2 == null) {
                this.f80503f = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.c(revealInfo);
            }
            if (MathUtils.c(revealInfo.f80515c, g(revealInfo), 1.0E-4f)) {
                this.f80503f.f80515c = Float.MAX_VALUE;
            }
        }
        i();
    }
}
