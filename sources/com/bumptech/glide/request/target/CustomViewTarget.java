package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f67190g = R.id.f66095a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SizeDeterminer f67191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final View f67192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnAttachStateChangeListener f67193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f67194d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f67195f;

    /* JADX INFO: renamed from: com.bumptech.glide.request.target.CustomViewTarget$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomViewTarget f67196a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f67196a.o();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f67196a.n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeDeterminer {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static Integer f67197e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f67198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f67199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f67200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private SizeDeterminerLayoutListener f67201d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference f67202a;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f67202a = new WeakReference(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f67202a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        private static int c(Context context) {
            if (f67197e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f67197e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f67197e.intValue();
        }

        private int e(int i3, int i4, int i5) {
            int i6 = i4 - i5;
            if (i6 > 0) {
                return i6;
            }
            if (this.f67200c && this.f67198a.isLayoutRequested()) {
                return 0;
            }
            int i7 = i3 - i5;
            if (i7 > 0) {
                return i7;
            }
            if (this.f67198a.isLayoutRequested() || i4 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f67198a.getContext());
        }

        private int f() {
            int paddingTop = this.f67198a.getPaddingTop() + this.f67198a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f67198a.getLayoutParams();
            return e(this.f67198a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f67198a.getPaddingLeft() + this.f67198a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f67198a.getLayoutParams();
            return e(this.f67198a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i3) {
            return i3 > 0 || i3 == Integer.MIN_VALUE;
        }

        private boolean i(int i3, int i4) {
            return h(i3) && h(i4);
        }

        private void j(int i3, int i4) {
            ArrayList arrayList = new ArrayList(this.f67199b);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ((SizeReadyCallback) obj).d(i3, i4);
            }
        }

        void a() {
            if (this.f67199b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f67198a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f67201d);
            }
            this.f67201d = null;
            this.f67199b.clear();
        }

        void d(SizeReadyCallback sizeReadyCallback) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                sizeReadyCallback.d(iG, iF);
                return;
            }
            if (!this.f67199b.contains(sizeReadyCallback)) {
                this.f67199b.add(sizeReadyCallback);
            }
            if (this.f67201d == null) {
                ViewTreeObserver viewTreeObserver = this.f67198a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f67201d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void k(SizeReadyCallback sizeReadyCallback) {
            this.f67199b.remove(sizeReadyCallback);
        }
    }

    private Object a() {
        return this.f67192b.getTag(f67190g);
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f67193c;
        if (onAttachStateChangeListener == null || this.f67195f) {
            return;
        }
        this.f67192b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f67195f = true;
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f67193c;
        if (onAttachStateChangeListener == null || !this.f67195f) {
            return;
        }
        this.f67192b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f67195f = false;
    }

    private void p(Object obj) {
        this.f67192b.setTag(f67190g, obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request b() {
        Object objA = a();
        if (objA == null) {
            return null;
        }
        if (objA instanceof Request) {
            return (Request) objA;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void c(SizeReadyCallback sizeReadyCallback) {
        this.f67191a.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void f(Drawable drawable) {
        d();
        m(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void g(Drawable drawable) {
        this.f67191a.b();
        l(drawable);
        if (this.f67194d) {
            return;
        }
        e();
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void i(Request request) {
        p(request);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k(SizeReadyCallback sizeReadyCallback) {
        this.f67191a.d(sizeReadyCallback);
    }

    protected abstract void l(Drawable drawable);

    final void n() {
        Request requestB = b();
        if (requestB != null) {
            this.f67194d = true;
            requestB.clear();
            this.f67194d = false;
        }
    }

    final void o() {
        Request requestB = b();
        if (requestB == null || !requestB.e()) {
            return;
        }
        requestB.i();
    }

    public String toString() {
        return "Target for: " + this.f67192b;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    protected void m(Drawable drawable) {
    }
}
