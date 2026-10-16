package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.facebook.internal.Utility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static boolean f53850v = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f53851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f53852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CompositeOnPageChangeCallback f53853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f53854d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f53855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f53856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    LinearLayoutManager f53857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f53858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Parcelable f53859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    RecyclerView f53860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PagerSnapHelper f53861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ScrollEventAdapter f53862m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CompositeOnPageChangeCallback f53863n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private FakeDrag f53864o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PageTransformerAdapter f53865p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RecyclerView.ItemAnimator f53866q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f53867r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f53868s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f53869t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    AccessibilityProvider f53870u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean b(int i3) {
            return (i3 == 8192 || i3 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.e()) {
                return;
            }
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34581r);
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34580q);
            accessibilityNodeInfoCompat.K0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean l(int i3) {
            if (b(i3)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence o() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i3, int i4, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i3, int i4, Object obj) {
            onChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void R1(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.R1(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void S0(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.S0(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f53870u.j(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void U0(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewPager2.this.f53870u.k(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean m1(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, Bundle bundle) {
            return ViewPager2.this.f53870u.b(i3) ? ViewPager2.this.f53870u.l(i3) : super.m1(recycler, state, i3, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean x1(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessibilityViewCommand f53877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AccessibilityViewCommand f53878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f53879d;

        PageAwareAccessibilityProvider() {
            super();
            this.f53877b = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.x(((ViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.f53878c = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.x(((ViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        private void u(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() != null) {
                itemCount2 = 1;
                if (ViewPager2.this.getOrientation() == 1) {
                    itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                    itemCount = 1;
                } else {
                    itemCount = ViewPager2.this.getAdapter().getItemCount();
                }
            } else {
                itemCount = 0;
                itemCount2 = 0;
            }
            accessibilityNodeInfoCompat.k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(itemCount2, itemCount, false, 0));
        }

        private void v(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.f53857h.m0(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.f53857h.m0(view) : 0, 1, false, false));
        }

        private void w(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f53854d > 0) {
                accessibilityNodeInfoCompat.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
            if (ViewPager2.this.f53854d < itemCount - 1) {
                accessibilityNodeInfoCompat.a(4096);
            }
            accessibilityNodeInfoCompat.K0(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean c(int i3, Bundle bundle) {
            return i3 == 8192 || i3 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void e(RecyclerView.Adapter adapter) {
            y();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f53879d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f53879d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            recyclerView.setImportantForAccessibility(2);
            this.f53879d = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.3
                @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.y();
                }
            };
            if (ViewPager2.this.getImportantForAccessibility() == 0) {
                ViewPager2.this.setImportantForAccessibility(1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatZ0 = AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo);
            u(accessibilityNodeInfoCompatZ0);
            w(accessibilityNodeInfoCompatZ0);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        void k(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            v(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean m(int i3, Bundle bundle) {
            if (!c(i3, bundle)) {
                throw new IllegalStateException();
            }
            x(i3 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void n() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void p(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void q() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void r() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void s() {
            y();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void t() {
            y();
        }

        void x(int i3) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i3, true);
            }
        }

        void y() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i3 = R.id.accessibilityActionPageLeft;
            ViewCompat.g0(viewPager2, R.id.accessibilityActionPageLeft);
            ViewCompat.g0(viewPager2, R.id.accessibilityActionPageRight);
            ViewCompat.g0(viewPager2, R.id.accessibilityActionPageUp);
            ViewCompat.g0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f53854d < itemCount - 1) {
                    ViewCompat.i0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.f53877b);
                }
                if (ViewPager2.this.f53854d > 0) {
                    ViewCompat.i0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.f53878c);
                    return;
                }
                return;
            }
            boolean zD = ViewPager2.this.d();
            int i4 = zD ? 16908360 : 16908361;
            if (zD) {
                i3 = 16908361;
            }
            if (ViewPager2.this.f53854d < itemCount - 1) {
                ViewCompat.i0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i4, null), null, this.f53877b);
            }
            if (ViewPager2.this.f53854d > 0) {
                ViewCompat.i0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, null), null, this.f53878c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PageTransformer {
        void transformPage(View view, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View h(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.h(layoutManager);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f53870u.d() ? ViewPager2.this.f53870u.o() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f53854d);
            accessibilityEvent.setToIndex(ViewPager2.this.f53854d);
            ViewPager2.this.f53870u.p(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SmoothScrollToPosition implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f53888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f53889b;

        SmoothScrollToPosition(int i3, RecyclerView recyclerView) {
            this.f53888a = i3;
            this.f53889b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f53889b.D1(this.f53888a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f53851a = new Rect();
        this.f53852b = new Rect();
        this.f53853c = new CompositeOnPageChangeCallback(3);
        this.f53855f = false;
        this.f53856g = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f53855f = true;
                viewPager2.f53862m.l();
            }
        };
        this.f53858i = -1;
        this.f53866q = null;
        this.f53867r = false;
        this.f53868s = true;
        this.f53869t = -1;
        b(context, attributeSet);
    }

    private RecyclerView.OnChildAttachStateChangeListener a() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: androidx.viewpager2.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void d(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void b(View view) {
            }
        };
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f53870u = f53850v ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f53860k = recyclerViewImpl;
        recyclerViewImpl.setId(View.generateViewId());
        this.f53860k.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f53857h = linearLayoutManagerImpl;
        this.f53860k.setLayoutManager(linearLayoutManagerImpl);
        this.f53860k.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f53860k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f53860k.l(a());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f53862m = scrollEventAdapter;
        this.f53864o = new FakeDrag(this, scrollEventAdapter, this.f53860k);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f53861l = pagerSnapHelperImpl;
        pagerSnapHelperImpl.b(this.f53860k);
        this.f53860k.n(this.f53862m);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f53863n = compositeOnPageChangeCallback;
        this.f53862m.o(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void a(int i3) {
                if (i3 == 0) {
                    ViewPager2.this.o();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i3) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f53854d != i3) {
                    viewPager2.f53854d = i3;
                    viewPager2.f53870u.r();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i3) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f53860k.requestFocus(2);
                }
            }
        };
        this.f53863n.d(onPageChangeCallback);
        this.f53863n.d(onPageChangeCallback2);
        this.f53870u.h(this.f53863n, this.f53860k);
        this.f53863n.d(this.f53853c);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f53857h);
        this.f53865p = pageTransformerAdapter;
        this.f53863n.d(pageTransformerAdapter);
        RecyclerView recyclerView = this.f53860k;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f53856g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f53858i == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f53859j;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).e(parcelable);
            }
            this.f53859j = null;
        }
        int iMax = Math.max(0, Math.min(this.f53858i, adapter.getItemCount() - 1));
        this.f53854d = iMax;
        this.f53858i = -1;
        this.f53860k.u1(iMax);
        this.f53870u.n();
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = androidx.viewpager2.R.styleable.f53792a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.k0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.f53793b, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f53856g);
        }
    }

    public boolean c() {
        return this.f53864o.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        return this.f53860k.canScrollHorizontally(i3);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.f53860k.canScrollVertically(i3);
    }

    boolean d() {
        return this.f53857h.e0() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i3 = ((SavedState) parcelable).f53885a;
            sparseArray.put(this.f53860k.getId(), (Parcelable) sparseArray.get(i3));
            sparseArray.remove(i3);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f53868s;
    }

    public void g(OnPageChangeCallback onPageChangeCallback) {
        this.f53853c.d(onPageChangeCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.f53870u.a() ? this.f53870u.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f53860k.getAdapter();
    }

    public int getCurrentItem() {
        return this.f53854d;
    }

    public int getItemDecorationCount() {
        return this.f53860k.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f53869t;
    }

    public int getOrientation() {
        return this.f53857h.q2() == 1 ? 1 : 0;
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f53860k;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f53862m.h();
    }

    public void h() {
        if (this.f53865p.d() == null) {
            return;
        }
        double dG = this.f53862m.g();
        int i3 = (int) dG;
        float f3 = (float) (dG - ((double) i3));
        this.f53865p.b(i3, f3, Math.round(getPageSize() * f3));
    }

    public void j(int i3, boolean z2) {
        if (c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        k(i3, z2);
    }

    void k(int i3, boolean z2) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f53858i != -1) {
                this.f53858i = Math.max(i3, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i3, 0), adapter.getItemCount() - 1);
        if (iMin == this.f53854d && this.f53862m.j()) {
            return;
        }
        int i4 = this.f53854d;
        if (iMin == i4 && z2) {
            return;
        }
        double dG = i4;
        this.f53854d = iMin;
        this.f53870u.r();
        if (!this.f53862m.j()) {
            dG = this.f53862m.g();
        }
        this.f53862m.m(iMin, z2);
        if (!z2) {
            this.f53860k.u1(iMin);
            return;
        }
        double d3 = iMin;
        if (Math.abs(d3 - dG) <= 3.0d) {
            this.f53860k.D1(iMin);
            return;
        }
        this.f53860k.u1(d3 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f53860k;
        recyclerView.post(new SmoothScrollToPosition(iMin, recyclerView));
    }

    public void n(OnPageChangeCallback onPageChangeCallback) {
        this.f53853c.e(onPageChangeCallback);
    }

    void o() {
        PagerSnapHelper pagerSnapHelper = this.f53861l;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewH = pagerSnapHelper.h(this.f53857h);
        if (viewH == null) {
            return;
        }
        int iM0 = this.f53857h.m0(viewH);
        if (iM0 != this.f53854d && getScrollState() == 0) {
            this.f53863n.c(iM0);
        }
        this.f53855f = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f53870u.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int measuredWidth = this.f53860k.getMeasuredWidth();
        int measuredHeight = this.f53860k.getMeasuredHeight();
        this.f53851a.left = getPaddingLeft();
        this.f53851a.right = (i5 - i3) - getPaddingRight();
        this.f53851a.top = getPaddingTop();
        this.f53851a.bottom = (i6 - i4) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f53851a, this.f53852b);
        RecyclerView recyclerView = this.f53860k;
        Rect rect = this.f53852b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f53855f) {
            o();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        measureChild(this.f53860k, i3, i4);
        int measuredWidth = this.f53860k.getMeasuredWidth();
        int measuredHeight = this.f53860k.getMeasuredHeight();
        int measuredState = this.f53860k.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f53858i = savedState.f53886b;
        this.f53859j = savedState.f53887c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f53885a = this.f53860k.getId();
        int i3 = this.f53858i;
        if (i3 == -1) {
            i3 = this.f53854d;
        }
        savedState.f53886b = i3;
        Parcelable parcelable = this.f53859j;
        if (parcelable != null) {
            savedState.f53887c = parcelable;
            return savedState;
        }
        Object adapter = this.f53860k.getAdapter();
        if (adapter instanceof StatefulAdapter) {
            savedState.f53887c = ((StatefulAdapter) adapter).a();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        return this.f53870u.c(i3, bundle) ? this.f53870u.m(i3, bundle) : super.performAccessibilityAction(i3, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f53860k.getAdapter();
        this.f53870u.f(adapter2);
        m(adapter2);
        this.f53860k.setAdapter(adapter);
        this.f53854d = 0;
        i();
        this.f53870u.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i3) {
        j(i3, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        super.setLayoutDirection(i3);
        this.f53870u.q();
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1 && i3 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f53869t = i3;
        this.f53860k.requestLayout();
    }

    public void setOrientation(int i3) {
        this.f53857h.E2(i3);
        this.f53870u.s();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f53867r) {
                this.f53866q = this.f53860k.getItemAnimator();
                this.f53867r = true;
            }
            this.f53860k.setItemAnimator(null);
        } else if (this.f53867r) {
            this.f53860k.setItemAnimator(this.f53866q);
            this.f53866q = null;
            this.f53867r = false;
        }
        if (pageTransformer == this.f53865p.d()) {
            return;
        }
        this.f53865p.e(pageTransformer);
        h();
    }

    public void setUserInputEnabled(boolean z2) {
        this.f53868s = z2;
        this.f53870u.t();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager2.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f53885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f53886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f53887c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f53885a = parcel.readInt();
            this.f53886b = parcel.readInt();
            this.f53887c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f53885a);
            parcel.writeInt(this.f53886b);
            parcel.writeParcelable(this.f53887c, i3);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i3) {
            return false;
        }

        boolean c(int i3, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i3) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean m(int i3, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence o() {
            throw new IllegalStateException("Not implemented.");
        }

        void n() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        void t() {
        }

        void e(RecyclerView.Adapter adapter) {
        }

        void f(RecyclerView.Adapter adapter) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        void p(AccessibilityEvent accessibilityEvent) {
        }

        void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        void k(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class OnPageChangeCallback {
        public void a(int i3) {
        }

        public void c(int i3) {
        }

        public void b(int i3, float f3, int i4) {
        }
    }
}
