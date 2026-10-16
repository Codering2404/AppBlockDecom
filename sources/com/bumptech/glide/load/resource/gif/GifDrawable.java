package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GifState f66967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f66968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f66969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f66970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f66971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f66972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f66974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f66975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Rect f66976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f66977l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GifState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GifFrameLoader f66978a;

        GifState(GifFrameLoader gifFrameLoader) {
            this.f66978a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation transformation, int i3, int i4, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.c(context), gifDecoder, i3, i4, transformation, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f66976k == null) {
            this.f66976k = new Rect();
        }
        return this.f66976k;
    }

    private Paint h() {
        if (this.f66975j == null) {
            this.f66975j = new Paint(2);
        }
        return this.f66975j;
    }

    private void j() {
        List list = this.f66977l;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Animatable2Compat.AnimationCallback) this.f66977l.get(i3)).b(this);
            }
        }
    }

    private void l() {
        this.f66972g = 0;
    }

    private void n() {
        Preconditions.b(!this.f66970d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f66967a.f66978a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f66968b) {
                return;
            }
            this.f66968b = true;
            this.f66967a.f66978a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f66968b = false;
        this.f66967a.f66978a.s(this);
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f66972g++;
        }
        int i3 = this.f66973h;
        if (i3 == -1 || this.f66972g < i3) {
            return;
        }
        stop();
        j();
    }

    public ByteBuffer c() {
        return this.f66967a.f66978a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f66970d) {
            return;
        }
        if (this.f66974i) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f66974i = false;
        }
        canvas.drawBitmap(this.f66967a.f66978a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f66967a.f66978a.e();
    }

    public int f() {
        return this.f66967a.f66978a.f();
    }

    public int g() {
        return this.f66967a.f66978a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f66967a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f66967a.f66978a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f66967a.f66978a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f66967a.f66978a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f66968b;
    }

    public void k() {
        this.f66970d = true;
        this.f66967a.f66978a.a();
    }

    public void m(Transformation transformation, Bitmap bitmap) {
        this.f66967a.f66978a.o(transformation, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f66974i = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        h().setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Preconditions.b(!this.f66970d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f66971f = z2;
        if (!z2) {
            o();
        } else if (this.f66969c) {
            n();
        }
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f66969c = true;
        l();
        if (this.f66971f) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f66969c = false;
        o();
    }

    GifDrawable(GifState gifState) {
        this.f66971f = true;
        this.f66973h = -1;
        this.f66967a = (GifState) Preconditions.e(gifState);
    }
}
