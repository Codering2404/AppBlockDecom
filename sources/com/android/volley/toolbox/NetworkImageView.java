package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f57834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f57835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f57836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f57837d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f57838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f57839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap f57840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageLoader f57841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageLoader.ImageContainer f57842j;

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ImageLoader.ImageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f57843a;

        AnonymousClass1(boolean z2) {
            this.f57843a = z2;
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageListener
        public void a(final ImageLoader.ImageContainer imageContainer, boolean z2) {
            if (z2 && this.f57843a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.a(imageContainer, false);
                    }
                });
                return;
            }
            if (imageContainer.d() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer.d());
                return;
            }
            if (NetworkImageView.this.f57835b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f57835b);
            } else if (NetworkImageView.this.f57836c != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f57836c);
            } else if (NetworkImageView.this.f57837d != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f57837d);
            }
        }

        @Override // com.android.volley.Response.ErrorListener
        public void c(VolleyError volleyError) {
            if (NetworkImageView.this.f57838f != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f57838f);
            } else if (NetworkImageView.this.f57839g != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f57839g);
            } else if (NetworkImageView.this.f57840h != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f57840h);
            }
        }
    }

    private void h() {
        int i3 = this.f57835b;
        if (i3 != 0) {
            setImageResource(i3);
            return;
        }
        Drawable drawable = this.f57836c;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.f57837d;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    void g(boolean z2) {
        boolean z3;
        boolean z4;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (getLayoutParams() != null) {
            z3 = getLayoutParams().width == -2;
            z4 = getLayoutParams().height == -2;
        } else {
            z3 = false;
            z4 = false;
        }
        boolean z5 = z3 && z4;
        if (width == 0 && height == 0 && !z5) {
            return;
        }
        if (TextUtils.isEmpty(this.f57834a)) {
            ImageLoader.ImageContainer imageContainer = this.f57842j;
            if (imageContainer != null) {
                imageContainer.c();
                this.f57842j = null;
            }
            h();
            return;
        }
        ImageLoader.ImageContainer imageContainer2 = this.f57842j;
        if (imageContainer2 != null && imageContainer2.e() != null) {
            if (this.f57842j.e().equals(this.f57834a)) {
                return;
            }
            this.f57842j.c();
            h();
        }
        if (z3) {
            width = 0;
        }
        this.f57842j = this.f57841i.e(this.f57834a, new AnonymousClass1(z2), width, z4 ? 0 : height, scaleType);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.f57842j;
        if (imageContainer != null) {
            imageContainer.c();
            setImageBitmap(null);
            this.f57842j = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        g(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f57835b = 0;
        this.f57836c = null;
        this.f57837d = bitmap;
    }

    public void setDefaultImageDrawable(Drawable drawable) {
        this.f57835b = 0;
        this.f57837d = null;
        this.f57836c = drawable;
    }

    public void setDefaultImageResId(int i3) {
        this.f57837d = null;
        this.f57836c = null;
        this.f57835b = i3;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f57838f = 0;
        this.f57839g = null;
        this.f57840h = bitmap;
    }

    public void setErrorImageDrawable(Drawable drawable) {
        this.f57838f = 0;
        this.f57840h = null;
        this.f57839g = drawable;
    }

    public void setErrorImageResId(int i3) {
        this.f57840h = null;
        this.f57839g = null;
        this.f57838f = i3;
    }
}
