package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private boolean A;
    private final Matrix B;
    private Bitmap C;
    private Canvas D;
    private Rect E;
    private RectF F;
    private Paint G;
    private Rect H;
    private Rect I;
    private RectF J;
    private RectF K;
    private Matrix L;
    private Matrix M;
    private boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LottieComposition f56320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LottieValueAnimator f56321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f56322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f56323d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f56324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnVisibleAction f56325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList f56326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f56327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageAssetManager f56328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f56329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageAssetDelegate f56330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private FontAssetManager f56331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map f56332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f56333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    FontAssetDelegate f56334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextDelegate f56335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f56336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f56337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f56338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CompositionLayer f56339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f56340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f56341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f56342x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f56343y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RenderMode f56344z;

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieDrawable$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends LottieValueCallback<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SimpleLottieValueCallback f56346d;

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public Object a(LottieFrameInfo lottieFrameInfo) {
            return this.f56346d.a(lottieFrameInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface LazyCompositionTask {
        void a(LottieComposition lottieComposition);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.f56321b = lottieValueAnimator;
        this.f56322c = true;
        this.f56323d = false;
        this.f56324f = false;
        this.f56325g = OnVisibleAction.NONE;
        this.f56326h = new ArrayList();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.f56339u != null) {
                    LottieDrawable.this.f56339u.L(LottieDrawable.this.f56321b.m());
                }
            }
        };
        this.f56327i = animatorUpdateListener;
        this.f56337s = false;
        this.f56338t = true;
        this.f56340v = 255;
        this.f56344z = RenderMode.AUTOMATIC;
        this.A = false;
        this.B = new Matrix();
        this.N = false;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    private void A() {
        if (this.D != null) {
            return;
        }
        this.D = new Canvas();
        this.K = new RectF();
        this.L = new Matrix();
        this.M = new Matrix();
        this.E = new Rect();
        this.F = new RectF();
        this.G = new LPaint();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new RectF();
    }

    private Context E() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private FontAssetManager F() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f56331m == null) {
            FontAssetManager fontAssetManager = new FontAssetManager(getCallback(), this.f56334p);
            this.f56331m = fontAssetManager;
            String str = this.f56333o;
            if (str != null) {
                fontAssetManager.c(str);
            }
        }
        return this.f56331m;
    }

    private ImageAssetManager H() {
        ImageAssetManager imageAssetManager = this.f56328j;
        if (imageAssetManager != null && !imageAssetManager.b(E())) {
            this.f56328j = null;
        }
        if (this.f56328j == null) {
            this.f56328j = new ImageAssetManager(getCallback(), this.f56329k, this.f56330l, this.f56320a.j());
        }
        return this.f56328j;
    }

    private boolean V() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    private void b0(Canvas canvas, CompositionLayer compositionLayer) {
        if (this.f56320a == null || compositionLayer == null) {
            return;
        }
        A();
        canvas.getMatrix(this.L);
        canvas.getClipBounds(this.E);
        u(this.E, this.F);
        this.L.mapRect(this.F);
        v(this.F, this.E);
        if (this.f56338t) {
            this.K.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            compositionLayer.f(this.K, null, false);
        }
        this.L.mapRect(this.K);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        e0(this.K, fWidth, fHeight);
        if (!V()) {
            RectF rectF = this.K;
            Rect rect = this.E;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.K.width());
        int iCeil2 = (int) Math.ceil(this.K.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        z(iCeil, iCeil2);
        if (this.N) {
            this.B.set(this.L);
            this.B.preScale(fWidth, fHeight);
            Matrix matrix = this.B;
            RectF rectF2 = this.K;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.C.eraseColor(0);
            compositionLayer.i(this.D, this.B, this.f56340v);
            this.L.invert(this.M);
            this.M.mapRect(this.J, this.K);
            v(this.J, this.I);
        }
        this.H.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.C, this.H, this.I, this.G);
    }

    private void e0(RectF rectF, float f3, float f4) {
        rectF.set(rectF.left * f3, rectF.top * f4, rectF.right * f3, rectF.bottom * f4);
    }

    private boolean q() {
        return this.f56322c || this.f56323d;
    }

    private void r() {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            return;
        }
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.a(lottieComposition), lottieComposition.k(), lottieComposition);
        this.f56339u = compositionLayer;
        if (this.f56342x) {
            compositionLayer.J(true);
        }
        this.f56339u.O(this.f56338t);
    }

    private void t() {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            return;
        }
        this.A = this.f56344z.b(Build.VERSION.SDK_INT, lottieComposition.q(), lottieComposition.m());
    }

    private void u(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void v(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void w(Canvas canvas) {
        CompositionLayer compositionLayer = this.f56339u;
        LottieComposition lottieComposition = this.f56320a;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        this.B.reset();
        if (!getBounds().isEmpty()) {
            this.B.preScale(r2.width() / lottieComposition.b().width(), r2.height() / lottieComposition.b().height());
            this.B.preTranslate(r2.left, r2.top);
        }
        compositionLayer.i(canvas, this.B, this.f56340v);
    }

    private void z(int i3, int i4) {
        Bitmap bitmap = this.C;
        if (bitmap == null || bitmap.getWidth() < i3 || this.C.getHeight() < i4) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            this.C = bitmapCreateBitmap;
            this.D.setBitmap(bitmapCreateBitmap);
            this.N = true;
            return;
        }
        if (this.C.getWidth() > i3 || this.C.getHeight() > i4) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.C, 0, 0, i3, i4);
            this.C = bitmapCreateBitmap2;
            this.D.setBitmap(bitmapCreateBitmap2);
            this.N = true;
        }
    }

    public void A0(final float f3) {
        if (this.f56320a == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f57108a.A0(f3);
                }
            });
            return;
        }
        L.a("Drawable#setProgress");
        this.f56321b.D(this.f56320a.h(f3));
        L.b("Drawable#setProgress");
    }

    public Bitmap B(String str) {
        ImageAssetManager imageAssetManagerH = H();
        if (imageAssetManagerH != null) {
            return imageAssetManagerH.a(str);
        }
        return null;
    }

    public void B0(RenderMode renderMode) {
        this.f56344z = renderMode;
        t();
    }

    public boolean C() {
        return this.f56338t;
    }

    public void C0(int i3) {
        this.f56321b.setRepeatCount(i3);
    }

    public LottieComposition D() {
        return this.f56320a;
    }

    public void D0(int i3) {
        this.f56321b.setRepeatMode(i3);
    }

    public void E0(boolean z2) {
        this.f56324f = z2;
    }

    public void F0(float f3) {
        this.f56321b.H(f3);
    }

    public int G() {
        return (int) this.f56321b.o();
    }

    public void G0(TextDelegate textDelegate) {
        this.f56335q = textDelegate;
    }

    public void H0(boolean z2) {
        this.f56321b.I(z2);
    }

    public String I() {
        return this.f56329k;
    }

    public boolean I0() {
        return this.f56332n == null && this.f56335q == null && this.f56320a.c().q() > 0;
    }

    public LottieImageAsset J(String str) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            return null;
        }
        return (LottieImageAsset) lottieComposition.j().get(str);
    }

    public boolean K() {
        return this.f56337s;
    }

    public float L() {
        return this.f56321b.q();
    }

    public float M() {
        return this.f56321b.r();
    }

    public PerformanceTracker N() {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition != null) {
            return lottieComposition.n();
        }
        return null;
    }

    public float O() {
        return this.f56321b.m();
    }

    public RenderMode P() {
        return this.A ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public int Q() {
        return this.f56321b.getRepeatCount();
    }

    public int R() {
        return this.f56321b.getRepeatMode();
    }

    public float S() {
        return this.f56321b.s();
    }

    public TextDelegate T() {
        return this.f56335q;
    }

    public Typeface U(Font font) {
        Map map = this.f56332n;
        if (map != null) {
            String strA = font.a();
            if (map.containsKey(strA)) {
                return (Typeface) map.get(strA);
            }
            String strB = font.b();
            if (map.containsKey(strB)) {
                return (Typeface) map.get(strB);
            }
            String str = font.a() + "-" + font.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        FontAssetManager fontAssetManagerF = F();
        if (fontAssetManagerF != null) {
            return fontAssetManagerF.b(font);
        }
        return null;
    }

    public boolean W() {
        LottieValueAnimator lottieValueAnimator = this.f56321b;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    boolean X() {
        if (isVisible()) {
            return this.f56321b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f56325g;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public boolean Y() {
        return this.f56343y;
    }

    public void Z() {
        this.f56326h.clear();
        this.f56321b.u();
        if (isVisible()) {
            return;
        }
        this.f56325g = OnVisibleAction.NONE;
    }

    public void a0() {
        if (this.f56339u == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f57081a.a0();
                }
            });
            return;
        }
        t();
        if (q() || Q() == 0) {
            if (isVisible()) {
                this.f56321b.v();
                this.f56325g = OnVisibleAction.NONE;
            } else {
                this.f56325g = OnVisibleAction.PLAY;
            }
        }
        if (q()) {
            return;
        }
        l0((int) (S() < 0.0f ? M() : L()));
        this.f56321b.k();
        if (isVisible()) {
            return;
        }
        this.f56325g = OnVisibleAction.NONE;
    }

    public List c0(KeyPath keyPath) {
        if (this.f56339u == null) {
            Logger.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        this.f56339u.e(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public void d0() {
        if (this.f56339u == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f56948a.d0();
                }
            });
            return;
        }
        t();
        if (q() || Q() == 0) {
            if (isVisible()) {
                this.f56321b.z();
                this.f56325g = OnVisibleAction.NONE;
            } else {
                this.f56325g = OnVisibleAction.RESUME;
            }
        }
        if (q()) {
            return;
        }
        l0((int) (S() < 0.0f ? M() : L()));
        this.f56321b.k();
        if (isVisible()) {
            return;
        }
        this.f56325g = OnVisibleAction.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        L.a("Drawable#draw");
        if (this.f56324f) {
            try {
                if (this.A) {
                    b0(canvas, this.f56339u);
                } else {
                    w(canvas);
                }
            } catch (Throwable th) {
                Logger.b("Lottie crashed in draw!", th);
            }
        } else if (this.A) {
            b0(canvas, this.f56339u);
        } else {
            w(canvas);
        }
        this.N = false;
        L.b("Drawable#draw");
    }

    public void f0(boolean z2) {
        this.f56343y = z2;
    }

    public void g0(boolean z2) {
        if (z2 != this.f56338t) {
            this.f56338t = z2;
            CompositionLayer compositionLayer = this.f56339u;
            if (compositionLayer != null) {
                compositionLayer.O(z2);
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f56340v;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0(LottieComposition lottieComposition) {
        if (this.f56320a == lottieComposition) {
            return false;
        }
        this.N = true;
        s();
        this.f56320a = lottieComposition;
        r();
        this.f56321b.B(lottieComposition);
        A0(this.f56321b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f56326h).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.a(lottieComposition);
            }
            it.remove();
        }
        this.f56326h.clear();
        lottieComposition.v(this.f56341w);
        t();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void i0(String str) {
        this.f56333o = str;
        FontAssetManager fontAssetManagerF = F();
        if (fontAssetManagerF != null) {
            fontAssetManagerF.c(str);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
            return;
        }
        this.N = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return W();
    }

    public void j0(FontAssetDelegate fontAssetDelegate) {
        this.f56334p = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.f56331m;
        if (fontAssetManager != null) {
            fontAssetManager.d(fontAssetDelegate);
        }
    }

    public void k0(Map map) {
        if (map == this.f56332n) {
            return;
        }
        this.f56332n = map;
        invalidateSelf();
    }

    public void l0(final int i3) {
        if (this.f56320a == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f57143a.l0(i3);
                }
            });
        } else {
            this.f56321b.D(i3);
        }
    }

    public void m0(boolean z2) {
        this.f56323d = z2;
    }

    public void n0(ImageAssetDelegate imageAssetDelegate) {
        this.f56330l = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.f56328j;
        if (imageAssetManager != null) {
            imageAssetManager.d(imageAssetDelegate);
        }
    }

    public void o0(String str) {
        this.f56329k = str;
    }

    public void p(final KeyPath keyPath, final Object obj, final LottieValueCallback lottieValueCallback) {
        CompositionLayer compositionLayer = this.f56339u;
        if (compositionLayer == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f56944a.p(keyPath, obj, lottieValueCallback);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (keyPath == KeyPath.f56708c) {
            compositionLayer.d(obj, lottieValueCallback);
        } else if (keyPath.d() != null) {
            keyPath.d().d(obj, lottieValueCallback);
        } else {
            List listC0 = c0(keyPath);
            for (int i3 = 0; i3 < listC0.size(); i3++) {
                ((KeyPath) listC0.get(i3)).d().d(obj, lottieValueCallback);
            }
            zIsEmpty = true ^ listC0.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (obj == LottieProperty.E) {
                A0(O());
            }
        }
    }

    public void p0(boolean z2) {
        this.f56337s = z2;
    }

    public void q0(final int i3) {
        if (this.f56320a == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f57145a.q0(i3);
                }
            });
        } else {
            this.f56321b.E(i3 + 0.99f);
        }
    }

    public void r0(final String str) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.q
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    this.f57077a.r0(str);
                }
            });
            return;
        }
        Marker markerL = lottieComposition.l(str);
        if (markerL != null) {
            q0((int) (markerL.f56714b + markerL.f56715c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void s() {
        if (this.f56321b.isRunning()) {
            this.f56321b.cancel();
            if (!isVisible()) {
                this.f56325g = OnVisibleAction.NONE;
            }
        }
        this.f56320a = null;
        this.f56339u = null;
        this.f56328j = null;
        this.f56321b.j();
        invalidateSelf();
    }

    public void s0(final float f3) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    this.f56664a.s0(f3);
                }
            });
        } else {
            this.f56321b.E(MiscUtils.i(lottieComposition.p(), this.f56320a.f(), f3));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f56340v = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z2, z3);
        if (z2) {
            OnVisibleAction onVisibleAction = this.f56325g;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                a0();
                return visible;
            }
            if (onVisibleAction == OnVisibleAction.RESUME) {
                d0();
                return visible;
            }
        } else {
            if (this.f56321b.isRunning()) {
                Z();
                this.f56325g = OnVisibleAction.RESUME;
                return visible;
            }
            if (zIsVisible) {
                this.f56325g = OnVisibleAction.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        a0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        y();
    }

    public void t0(final int i3, final int i4) {
        if (this.f56320a == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f56933a.t0(i3, i4);
                }
            });
        } else {
            this.f56321b.F(i3, i4 + 0.99f);
        }
    }

    public void u0(final String str) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.k
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    this.f56662a.u0(str);
                }
            });
            return;
        }
        Marker markerL = lottieComposition.l(str);
        if (markerL != null) {
            int i3 = (int) markerL.f56714b;
            t0(i3, ((int) markerL.f56715c) + i3);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v0(final int i3) {
        if (this.f56320a == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    this.f57147a.v0(i3);
                }
            });
        } else {
            this.f56321b.G(i3);
        }
    }

    public void w0(final String str) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.s
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    this.f57079a.w0(str);
                }
            });
            return;
        }
        Marker markerL = lottieComposition.l(str);
        if (markerL != null) {
            v0((int) markerL.f56714b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean x() {
        return this.f56336r;
    }

    public void x0(final float f3) {
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition == null) {
            this.f56326h.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    this.f57082a.x0(f3);
                }
            });
        } else {
            v0((int) MiscUtils.i(lottieComposition.p(), this.f56320a.f(), f3));
        }
    }

    public void y() {
        this.f56326h.clear();
        this.f56321b.k();
        if (isVisible()) {
            return;
        }
        this.f56325g = OnVisibleAction.NONE;
    }

    public void y0(boolean z2) {
        if (this.f56342x == z2) {
            return;
        }
        this.f56342x = z2;
        CompositionLayer compositionLayer = this.f56339u;
        if (compositionLayer != null) {
            compositionLayer.J(z2);
        }
    }

    public void z0(boolean z2) {
        this.f56341w = z2;
        LottieComposition lottieComposition = this.f56320a;
        if (lottieComposition != null) {
            lottieComposition.v(z2);
        }
    }
}
