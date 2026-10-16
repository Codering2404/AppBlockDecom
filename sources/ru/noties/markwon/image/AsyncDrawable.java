package ru.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AsyncDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f147331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AsyncDrawableLoader f147332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageSize f147333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImageSizeResolver f147334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f147335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable.Callback f147336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f147337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f147338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f147339i;

    public AsyncDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, ImageSize imageSize) {
        this.f147331a = str;
        this.f147332b = asyncDrawableLoader;
        this.f147334d = imageSizeResolver;
        this.f147333c = imageSize;
        Drawable drawableC = asyncDrawableLoader.c();
        if (drawableC != null) {
            if (drawableC.getBounds().isEmpty()) {
                Rect rect = new Rect(0, 0, drawableC.getIntrinsicWidth(), drawableC.getIntrinsicHeight());
                drawableC.setBounds(rect);
                setBounds(rect);
            }
            g(drawableC);
        }
    }

    private void b() {
        if (this.f147337g == 0) {
            this.f147339i = true;
            return;
        }
        this.f147339i = false;
        Rect rectE = e();
        this.f147335e.setBounds(rectE);
        setBounds(rectE);
        invalidateSelf();
    }

    private Rect e() {
        ImageSizeResolver imageSizeResolver = this.f147334d;
        return imageSizeResolver != null ? imageSizeResolver.a(this.f147333c, this.f147335e.getBounds(), this.f147337g, this.f147338h) : this.f147335e.getBounds();
    }

    public boolean a() {
        return this.f147335e != null;
    }

    public void c(int i3, float f3) {
        this.f147337g = i3;
        this.f147338h = f3;
        if (this.f147339i) {
            b();
        }
    }

    public boolean d() {
        return getCallback() != null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (a()) {
            this.f147335e.draw(canvas);
        }
    }

    public void f(Drawable.Callback callback) {
        this.f147336f = callback;
        super.setCallback(callback);
        if (callback != null) {
            Drawable drawable = this.f147335e;
            if (drawable != null && drawable.getCallback() == null) {
                this.f147335e.setCallback(callback);
            }
            this.f147332b.b(this.f147331a, this);
            return;
        }
        Drawable drawable2 = this.f147335e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            Object obj = this.f147335e;
            if (obj instanceof Animatable) {
                ((Animatable) obj).stop();
            }
        }
        this.f147332b.a(this.f147331a);
    }

    public void g(Drawable drawable) {
        Drawable drawable2 = this.f147335e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f147335e = drawable;
        drawable.setCallback(this.f147336f);
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (a()) {
            return this.f147335e.getIntrinsicHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (a()) {
            return this.f147335e.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (a()) {
            return this.f147335e.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
