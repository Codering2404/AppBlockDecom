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
@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f67223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f67224i = R.id.f66095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final View f67225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SizeDeterminer f67226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnAttachStateChangeListener f67227d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f67228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f67229g;

    /* JADX INFO: renamed from: com.bumptech.glide.request.target.ViewTarget$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewTarget f67230a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f67230a.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f67230a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeDeterminer {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static Integer f67231e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f67232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f67233b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f67234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private SizeDeterminerLayoutListener f67235d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference f67236a;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f67236a = new WeakReference(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f67236a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f67232a = view;
        }

        private static int c(Context context) {
            if (f67231e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f67231e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f67231e.intValue();
        }

        private int e(int i3, int i4, int i5) {
            int i6 = i4 - i5;
            if (i6 > 0) {
                return i6;
            }
            if (this.f67234c && this.f67232a.isLayoutRequested()) {
                return 0;
            }
            int i7 = i3 - i5;
            if (i7 > 0) {
                return i7;
            }
            if (this.f67232a.isLayoutRequested() || i4 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f67232a.getContext());
        }

        private int f() {
            int paddingTop = this.f67232a.getPaddingTop() + this.f67232a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f67232a.getLayoutParams();
            return e(this.f67232a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f67232a.getPaddingLeft() + this.f67232a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f67232a.getLayoutParams();
            return e(this.f67232a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i3) {
            return i3 > 0 || i3 == Integer.MIN_VALUE;
        }

        private boolean i(int i3, int i4) {
            return h(i3) && h(i4);
        }

        private void j(int i3, int i4) {
            ArrayList arrayList = new ArrayList(this.f67233b);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ((SizeReadyCallback) obj).d(i3, i4);
            }
        }

        void a() {
            if (this.f67233b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f67232a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f67235d);
            }
            this.f67235d = null;
            this.f67233b.clear();
        }

        void d(SizeReadyCallback sizeReadyCallback) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                sizeReadyCallback.d(iG, iF);
                return;
            }
            if (!this.f67233b.contains(sizeReadyCallback)) {
                this.f67233b.add(sizeReadyCallback);
            }
            if (this.f67235d == null) {
                ViewTreeObserver viewTreeObserver = this.f67232a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f67235d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        void k(SizeReadyCallback sizeReadyCallback) {
            this.f67233b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(View view) {
        this.f67225b = (View) Preconditions.e(view);
        this.f67226c = new SizeDeterminer(view);
    }

    private Object l() {
        return this.f67225b.getTag(f67224i);
    }

    private void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f67227d;
        if (onAttachStateChangeListener == null || this.f67229g) {
            return;
        }
        this.f67225b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f67229g = true;
    }

    private void n() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f67227d;
        if (onAttachStateChangeListener == null || !this.f67229g) {
            return;
        }
        this.f67225b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f67229g = false;
    }

    private void q(Object obj) {
        f67223h = true;
        this.f67225b.setTag(f67224i, obj);
    }

    public View a() {
        return this.f67225b;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public Request b() {
        Object objL = l();
        if (objL == null) {
            return null;
        }
        if (objL instanceof Request) {
            return (Request) objL;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void c(SizeReadyCallback sizeReadyCallback) {
        this.f67226c.k(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
        super.f(drawable);
        m();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
        super.g(drawable);
        this.f67226c.b();
        if (this.f67228f) {
            return;
        }
        n();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void i(Request request) {
        q(request);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void k(SizeReadyCallback sizeReadyCallback) {
        this.f67226c.d(sizeReadyCallback);
    }

    void o() {
        Request requestB = b();
        if (requestB != null) {
            this.f67228f = true;
            requestB.clear();
            this.f67228f = false;
        }
    }

    void p() {
        Request requestB = b();
        if (requestB == null || !requestB.e()) {
            return;
        }
        requestB.i();
    }

    public String toString() {
        return "Target for: " + this.f67225b;
    }
}
