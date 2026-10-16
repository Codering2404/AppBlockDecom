package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.facebook.ads.AdError;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.common.Constants;
import com.sun.jna.Function;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static boolean E0;
    static boolean F0;
    private static final int[] G0 = {R.attr.nestedScrollingEnabled};
    private static final float H0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    static final boolean I0 = false;
    static final boolean J0 = true;
    static final boolean K0 = true;
    static final boolean L0 = true;
    private static final boolean M0 = false;
    private static final boolean N0 = false;
    private static final Class[] O0;
    static final Interpolator P0;
    static final StretchEdgeEffectFactory Q0;
    boolean A;
    private boolean A0;
    private boolean B;
    private int B0;
    private int C;
    private int C0;
    boolean D;
    private final ViewInfoStore.ProcessCallback D0;
    private final AccessibilityManager E;
    private List F;
    boolean G;
    boolean H;
    private int I;
    private int J;
    private EdgeEffectFactory K;
    private EdgeEffect L;
    private EdgeEffect M;
    private EdgeEffect N;
    private EdgeEffect O;
    ItemAnimator P;
    private int Q;
    private int R;
    private VelocityTracker S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f51839a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f51840a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerViewDataObserver f51841b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private OnFlingListener f51842b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Recycler f51843c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final int f51844c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SavedState f51845d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final int f51846d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f51847e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AdapterHelper f51848f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f51849f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ChildHelper f51850g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f51851g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ViewInfoStore f51852h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    final ViewFlinger f51853h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f51854i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    GapWorker f51855i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Runnable f51856j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    GapWorker.LayoutPrefetchRegistryImpl f51857j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Rect f51858k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    final State f51859k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Rect f51860l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private OnScrollListener f51861l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final RectF f51862m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private List f51863m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Adapter f51864n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    boolean f51865n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    LayoutManager f51866o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    boolean f51867o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    RecyclerListener f51868p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private ItemAnimator.ItemAnimatorListener f51869p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final List f51870q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    boolean f51871q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final ArrayList f51872r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    RecyclerViewAccessibilityDelegate f51873r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ArrayList f51874s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private ChildDrawingOrderCallback f51875s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private OnItemTouchListener f51876t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final int[] f51877t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f51878u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private NestedScrollingChildHelper f51879u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f51880v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private final int[] f51881v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f51882w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final int[] f51883w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f51884x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    final int[] f51885x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f51886y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    final List f51887y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f51888z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private Runnable f51889z0;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f51895a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f51895a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51895a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH vh, int i3) {
            boolean z2 = vh.mBindingAdapter == null;
            if (z2) {
                vh.mPosition = i3;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i3);
                }
                vh.setFlags(1, 519);
                TraceCompat.a("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            if (RecyclerView.E0) {
                if (vh.itemView.getParent() == null && ViewCompat.Q(vh.itemView) != vh.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh.isTmpDetached() + ", attached to window: " + ViewCompat.Q(vh.itemView) + ", holder: " + vh);
                }
                if (vh.itemView.getParent() == null && ViewCompat.Q(vh.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh);
                }
            }
            onBindViewHolder(vh, i3, vh.getUnmodifiedPayloads());
            if (z2) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f51937c = true;
                }
                TraceCompat.b();
            }
        }

        boolean canRestoreState() {
            int i3 = AnonymousClass7.f51895a[this.mStateRestorationPolicy.ordinal()];
            return i3 != 1 && (i3 != 2 || getItemCount() > 0);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i3) {
            try {
                TraceCompat.a("RV CreateView");
                VH vh = (VH) onCreateViewHolder(viewGroup, i3);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i3;
                return vh;
            } finally {
                TraceCompat.b();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> adapter, ViewHolder viewHolder, int i3) {
            if (adapter == this) {
                return i3;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i3) {
            return -1L;
        }

        public int getItemViewType(int i3) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i3) {
            this.mObservable.d(i3, 1);
        }

        public final void notifyItemInserted(int i3) {
            this.mObservable.f(i3, 1);
        }

        public final void notifyItemMoved(int i3, int i4) {
            this.mObservable.c(i3, i4);
        }

        public final void notifyItemRangeChanged(int i3, int i4) {
            this.mObservable.d(i3, i4);
        }

        public final void notifyItemRangeInserted(int i3, int i4) {
            this.mObservable.f(i3, i4);
        }

        public final void notifyItemRangeRemoved(int i3, int i4) {
            this.mObservable.g(i3, i4);
        }

        public final void notifyItemRemoved(int i3) {
            this.mObservable.g(i3, 1);
        }

        public abstract void onBindViewHolder(ViewHolder viewHolder, int i3);

        public void onBindViewHolder(VH vh, int i3, List<Object> list) {
            onBindViewHolder(vh, i3);
        }

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3);

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z2) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z2;
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i3, Object obj) {
            this.mObservable.e(i3, 1, obj);
        }

        public final void notifyItemRangeChanged(int i3, int i4, Object obj) {
            this.mObservable.e(i3, i4, obj);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void c(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i3, i4, 1);
            }
        }

        public void d(int i3, int i4) {
            e(i3, i4, null);
        }

        public void e(int i3, int i4, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i3, i4, obj);
            }
        }

        public void f(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i3, i4);
            }
        }

        public void g(int i3, int i4) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i3, i4);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class AdapterDataObserver {
        public void onItemRangeChanged(int i3, int i4) {
        }

        public void onItemRangeChanged(int i3, int i4, Object obj) {
            onItemRangeChanged(i3, i4);
        }

        public void onChanged() {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeInserted(int i3, int i4) {
        }

        public void onItemRangeRemoved(int i3, int i4) {
        }

        public void onItemRangeMoved(int i3, int i4, int i5) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface ChildDrawingOrderCallback {
        int a(int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class EdgeEffectFactory {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        protected EdgeEffect a(RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void a(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (viewHolder.shouldBeKeptAsChild() || RecyclerView.this.i1(viewHolder.itemView) || !viewHolder.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface OnChildAttachStateChangeListener {
        void b(View view);

        void d(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class OnFlingListener {
        public abstract boolean a(int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface OnItemTouchListener {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class RecycledViewPool {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray f51939a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51940b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Set f51941c = Collections.newSetFromMap(new IdentityHashMap());

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class ScrapData {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList f51942a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f51943b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f51944c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f51945d = 0;

            ScrapData() {
            }
        }

        private ScrapData i(int i3) {
            ScrapData scrapData = (ScrapData) this.f51939a.get(i3);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.f51939a.put(i3, scrapData2);
            return scrapData2;
        }

        void a() {
            this.f51940b++;
        }

        void b(Adapter adapter) {
            this.f51941c.add(adapter);
        }

        public void c() {
            for (int i3 = 0; i3 < this.f51939a.size(); i3++) {
                ScrapData scrapData = (ScrapData) this.f51939a.valueAt(i3);
                ArrayList arrayList = scrapData.f51942a;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    PoolingContainer.b(((ViewHolder) obj).itemView);
                }
                scrapData.f51942a.clear();
            }
        }

        void d() {
            this.f51940b--;
        }

        void e(Adapter adapter, boolean z2) {
            this.f51941c.remove(adapter);
            if (this.f51941c.size() != 0 || z2) {
                return;
            }
            for (int i3 = 0; i3 < this.f51939a.size(); i3++) {
                SparseArray sparseArray = this.f51939a;
                ArrayList arrayList = ((ScrapData) sparseArray.get(sparseArray.keyAt(i3))).f51942a;
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    PoolingContainer.b(((ViewHolder) arrayList.get(i4)).itemView);
                }
            }
        }

        void f(int i3, long j3) {
            ScrapData scrapDataI = i(i3);
            scrapDataI.f51945d = l(scrapDataI.f51945d, j3);
        }

        void g(int i3, long j3) {
            ScrapData scrapDataI = i(i3);
            scrapDataI.f51944c = l(scrapDataI.f51944c, j3);
        }

        public ViewHolder h(int i3) {
            ScrapData scrapData = (ScrapData) this.f51939a.get(i3);
            if (scrapData == null || scrapData.f51942a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = scrapData.f51942a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((ViewHolder) arrayList.get(size)).isAttachedToTransitionOverlay()) {
                    return (ViewHolder) arrayList.remove(size);
                }
            }
            return null;
        }

        void j(Adapter adapter, Adapter adapter2, boolean z2) {
            if (adapter != null) {
                d();
            }
            if (!z2 && this.f51940b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList arrayList = i(itemViewType).f51942a;
            if (((ScrapData) this.f51939a.get(itemViewType)).f51943b <= arrayList.size()) {
                PoolingContainer.b(viewHolder.itemView);
            } else {
                if (RecyclerView.E0 && arrayList.contains(viewHolder)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        long l(long j3, long j4) {
            return j3 == 0 ? j4 : ((j3 / 4) * 3) + (j4 / 4);
        }

        boolean m(int i3, long j3, long j4) {
            long j5 = i(i3).f51945d;
            return j5 == 0 || j3 + j5 < j4;
        }

        boolean n(int i3, long j3, long j4) {
            long j5 = i(i3).f51944c;
            return j5 == 0 || j3 + j5 < j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public final class Recycler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList f51946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList f51947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList f51948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f51949d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f51950e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f51951f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        RecycledViewPool f51952g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ViewCacheExtension f51953h;

        public Recycler() {
            ArrayList arrayList = new ArrayList();
            this.f51946a = arrayList;
            this.f51947b = null;
            this.f51948c = new ArrayList();
            this.f51949d = Collections.unmodifiableList(arrayList);
            this.f51950e = 2;
            this.f51951f = 2;
        }

        private void B(Adapter adapter) {
            C(adapter, false);
        }

        private void C(Adapter adapter, boolean z2) {
            RecycledViewPool recycledViewPool = this.f51952g;
            if (recycledViewPool != null) {
                recycledViewPool.e(adapter, z2);
            }
        }

        private boolean M(ViewHolder viewHolder, int i3, int i4, long j3) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z2 = false;
            if (j3 != Long.MAX_VALUE && !this.f51952g.m(itemViewType, nanoTime, j3)) {
                return false;
            }
            if (viewHolder.isTmpDetached()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(viewHolder.itemView, recyclerView.getChildCount(), viewHolder.itemView.getLayoutParams());
                z2 = true;
            }
            RecyclerView.this.f51864n.bindViewHolder(viewHolder, i3);
            if (z2) {
                RecyclerView.this.detachViewFromParent(viewHolder.itemView);
            }
            this.f51952g.f(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(viewHolder);
            if (RecyclerView.this.f51859k0.e()) {
                viewHolder.mPreLayoutPosition = i4;
            }
            return true;
        }

        private void b(ViewHolder viewHolder) {
            if (RecyclerView.this.D0()) {
                View view = viewHolder.itemView;
                if (ViewCompat.w(view) == 0) {
                    ViewCompat.w0(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.f51873r0;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat accessibilityDelegateCompatN = recyclerViewAccessibilityDelegate.n();
                if (accessibilityDelegateCompatN instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) accessibilityDelegateCompatN).o(view);
                }
                ViewCompat.m0(view, accessibilityDelegateCompatN);
            }
        }

        private void q(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z2) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        private void u() {
            if (this.f51952g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f51864n == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.f51952g.b(RecyclerView.this.f51864n);
            }
        }

        void A() {
            for (int i3 = 0; i3 < this.f51948c.size(); i3++) {
                PoolingContainer.b(((ViewHolder) this.f51948c.get(i3)).itemView);
            }
            B(RecyclerView.this.f51864n);
        }

        void D(View view) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            viewHolderN0.mScrapContainer = null;
            viewHolderN0.mInChangeScrap = false;
            viewHolderN0.clearReturnedFromScrapFlag();
            H(viewHolderN0);
        }

        void E() {
            for (int size = this.f51948c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f51948c.clear();
            if (RecyclerView.L0) {
                RecyclerView.this.f51857j0.b();
            }
        }

        void F(int i3) {
            if (RecyclerView.F0) {
                Log.d("RecyclerView", "Recycling cached view at index " + i3);
            }
            ViewHolder viewHolder = (ViewHolder) this.f51948c.get(i3);
            if (RecyclerView.F0) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + viewHolder);
            }
            a(viewHolder, true);
            this.f51948c.remove(i3);
        }

        public void G(View view) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (viewHolderN0.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (viewHolderN0.isScrap()) {
                viewHolderN0.unScrap();
            } else if (viewHolderN0.wasReturnedFromScrap()) {
                viewHolderN0.clearReturnedFromScrapFlag();
            }
            H(viewHolderN0);
            if (RecyclerView.this.P == null || viewHolderN0.isRecyclable()) {
                return;
            }
            RecyclerView.this.P.j(viewHolderN0);
        }

        void H(ViewHolder viewHolder) {
            boolean z2;
            boolean z3 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                sb.append(viewHolder.itemView.getParent() != null);
                sb.append(RecyclerView.this.V());
                throw new IllegalArgumentException(sb.toString());
            }
            if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.V());
            }
            if (viewHolder.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.V());
            }
            boolean zDoesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
            Adapter adapter = RecyclerView.this.f51864n;
            boolean z4 = adapter != null && zDoesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder);
            if (RecyclerView.E0 && this.f51948c.contains(viewHolder)) {
                throw new IllegalArgumentException("cached view received recycle internal? " + viewHolder + RecyclerView.this.V());
            }
            if (z4 || viewHolder.isRecyclable()) {
                if (this.f51951f <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                    z2 = false;
                } else {
                    int size = this.f51948c.size();
                    if (size >= this.f51951f && size > 0) {
                        F(0);
                        size--;
                    }
                    if (RecyclerView.L0 && size > 0 && !RecyclerView.this.f51857j0.d(viewHolder.mPosition)) {
                        int i3 = size - 1;
                        while (i3 >= 0) {
                            if (!RecyclerView.this.f51857j0.d(((ViewHolder) this.f51948c.get(i3)).mPosition)) {
                                break;
                            } else {
                                i3--;
                            }
                        }
                        size = i3 + 1;
                    }
                    this.f51948c.add(size, viewHolder);
                    z2 = true;
                }
                if (z2) {
                    z3 = false;
                } else {
                    a(viewHolder, true);
                }
                z = z2;
            } else {
                if (RecyclerView.F0) {
                    Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.V());
                }
                z3 = false;
            }
            RecyclerView.this.f51852h.q(viewHolder);
            if (z || z3 || !zDoesTransientStatePreventRecycling) {
                return;
            }
            PoolingContainer.b(viewHolder.itemView);
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
        }

        void I(View view) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (!viewHolderN0.hasAnyOfTheFlags(12) && viewHolderN0.isUpdated() && !RecyclerView.this.s(viewHolderN0)) {
                if (this.f51947b == null) {
                    this.f51947b = new ArrayList();
                }
                viewHolderN0.setScrapContainer(this, true);
                this.f51947b.add(viewHolderN0);
                return;
            }
            if (!viewHolderN0.isInvalid() || viewHolderN0.isRemoved() || RecyclerView.this.f51864n.hasStableIds()) {
                viewHolderN0.setScrapContainer(this, false);
                this.f51946a.add(viewHolderN0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.V());
            }
        }

        void J(RecycledViewPool recycledViewPool) {
            B(RecyclerView.this.f51864n);
            RecycledViewPool recycledViewPool2 = this.f51952g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.d();
            }
            this.f51952g = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.f51952g.a();
            }
            u();
        }

        void K(ViewCacheExtension viewCacheExtension) {
            this.f51953h = viewCacheExtension;
        }

        public void L(int i3) {
            this.f51950e = i3;
            P();
        }

        /* JADX WARN: Removed duplicated region for block: B:110:0x0248  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0256  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0272 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0275  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01c6  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01f2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        androidx.recyclerview.widget.RecyclerView.ViewHolder N(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 689
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.N(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        void O(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.f51947b.remove(viewHolder);
            } else {
                this.f51946a.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        void P() {
            LayoutManager layoutManager = RecyclerView.this.f51866o;
            this.f51951f = this.f51950e + (layoutManager != null ? layoutManager.f51923m : 0);
            for (int size = this.f51948c.size() - 1; size >= 0 && this.f51948c.size() > this.f51951f; size--) {
                F(size);
            }
        }

        boolean Q(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                if (!RecyclerView.E0 || RecyclerView.this.f51859k0.e()) {
                    return RecyclerView.this.f51859k0.e();
                }
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.V());
            }
            int i3 = viewHolder.mPosition;
            if (i3 >= 0 && i3 < RecyclerView.this.f51864n.getItemCount()) {
                if (RecyclerView.this.f51859k0.e() || RecyclerView.this.f51864n.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                    return !RecyclerView.this.f51864n.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.f51864n.getItemId(viewHolder.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.V());
        }

        void R(int i3, int i4) {
            int i5;
            int i6 = i4 + i3;
            for (int size = this.f51948c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f51948c.get(size);
                if (viewHolder != null && (i5 = viewHolder.mPosition) >= i3 && i5 < i6) {
                    viewHolder.addFlags(2);
                    F(size);
                }
            }
        }

        void a(ViewHolder viewHolder, boolean z2) {
            RecyclerView.u(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.f51873r0;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat accessibilityDelegateCompatN = recyclerViewAccessibilityDelegate.n();
                ViewCompat.m0(view, accessibilityDelegateCompatN instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) accessibilityDelegateCompatN).n(view) : null);
            }
            if (z2) {
                g(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            i().k(viewHolder);
        }

        public void c() {
            this.f51946a.clear();
            E();
        }

        void d() {
            int size = this.f51948c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ViewHolder) this.f51948c.get(i3)).clearOldPosition();
            }
            int size2 = this.f51946a.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ((ViewHolder) this.f51946a.get(i4)).clearOldPosition();
            }
            ArrayList arrayList = this.f51947b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    ((ViewHolder) this.f51947b.get(i5)).clearOldPosition();
                }
            }
        }

        void e() {
            this.f51946a.clear();
            ArrayList arrayList = this.f51947b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i3) {
            if (i3 >= 0 && i3 < RecyclerView.this.f51859k0.b()) {
                return !RecyclerView.this.f51859k0.e() ? i3 : RecyclerView.this.f51848f.m(i3);
            }
            throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + RecyclerView.this.f51859k0.b() + RecyclerView.this.V());
        }

        void g(ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.f51868p;
            if (recyclerListener != null) {
                recyclerListener.a(viewHolder);
            }
            int size = RecyclerView.this.f51870q.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((RecyclerListener) RecyclerView.this.f51870q.get(i3)).a(viewHolder);
            }
            Adapter adapter = RecyclerView.this.f51864n;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f51859k0 != null) {
                recyclerView.f51852h.q(viewHolder);
            }
            if (RecyclerView.F0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + viewHolder);
            }
        }

        ViewHolder h(int i3) {
            int size;
            int iM;
            ArrayList arrayList = this.f51947b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    ViewHolder viewHolder = (ViewHolder) this.f51947b.get(i4);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i3) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.f51864n.hasStableIds() && (iM = RecyclerView.this.f51848f.m(i3)) > 0 && iM < RecyclerView.this.f51864n.getItemCount()) {
                    long itemId = RecyclerView.this.f51864n.getItemId(iM);
                    for (int i5 = 0; i5 < size; i5++) {
                        ViewHolder viewHolder2 = (ViewHolder) this.f51947b.get(i5);
                        if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        RecycledViewPool i() {
            if (this.f51952g == null) {
                this.f51952g = new RecycledViewPool();
                u();
            }
            return this.f51952g;
        }

        int j() {
            return this.f51946a.size();
        }

        public List k() {
            return this.f51949d;
        }

        ViewHolder l(long j3, int i3, boolean z2) {
            for (int size = this.f51946a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f51946a.get(size);
                if (viewHolder.getItemId() == j3 && !viewHolder.wasReturnedFromScrap()) {
                    if (i3 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.f51859k0.e()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    }
                    if (!z2) {
                        this.f51946a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        D(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.f51948c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = (ViewHolder) this.f51948c.get(size2);
                if (viewHolder2.getItemId() == j3 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i3 == viewHolder2.getItemViewType()) {
                        if (!z2) {
                            this.f51948c.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z2) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        ViewHolder m(int i3, boolean z2) {
            View viewE;
            int size = this.f51946a.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = (ViewHolder) this.f51946a.get(i4);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i3 && !viewHolder.isInvalid() && (RecyclerView.this.f51859k0.f51979h || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!z2 && (viewE = RecyclerView.this.f51850g.e(i3)) != null) {
                ViewHolder viewHolderN0 = RecyclerView.n0(viewE);
                RecyclerView.this.f51850g.s(viewE);
                int iM = RecyclerView.this.f51850g.m(viewE);
                if (iM != -1) {
                    RecyclerView.this.f51850g.d(iM);
                    I(viewE);
                    viewHolderN0.addFlags(8224);
                    return viewHolderN0;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + viewHolderN0 + RecyclerView.this.V());
            }
            int size2 = this.f51948c.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ViewHolder viewHolder2 = (ViewHolder) this.f51948c.get(i5);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i3 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z2) {
                        this.f51948c.remove(i5);
                    }
                    if (RecyclerView.F0) {
                        Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i3 + ") found match in cache: " + viewHolder2);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        View n(int i3) {
            return ((ViewHolder) this.f51946a.get(i3)).itemView;
        }

        public View o(int i3) {
            return p(i3, false);
        }

        View p(int i3, boolean z2) {
            return N(i3, z2, Long.MAX_VALUE).itemView;
        }

        void s() {
            int size = this.f51948c.size();
            for (int i3 = 0; i3 < size; i3++) {
                LayoutParams layoutParams = (LayoutParams) ((ViewHolder) this.f51948c.get(i3)).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f51937c = true;
                }
            }
        }

        void t() {
            int size = this.f51948c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = (ViewHolder) this.f51948c.get(i3);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.f51864n;
            if (adapter == null || !adapter.hasStableIds()) {
                E();
            }
        }

        void v(int i3, int i4) {
            int size = this.f51948c.size();
            for (int i5 = 0; i5 < size; i5++) {
                ViewHolder viewHolder = (ViewHolder) this.f51948c.get(i5);
                if (viewHolder != null && viewHolder.mPosition >= i3) {
                    if (RecyclerView.F0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i5 + " holder " + viewHolder + " now at position " + (viewHolder.mPosition + i4));
                    }
                    viewHolder.offsetPosition(i4, false);
                }
            }
        }

        void w(int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            if (i3 < i4) {
                i5 = -1;
                i7 = i3;
                i6 = i4;
            } else {
                i5 = 1;
                i6 = i3;
                i7 = i4;
            }
            int size = this.f51948c.size();
            for (int i9 = 0; i9 < size; i9++) {
                ViewHolder viewHolder = (ViewHolder) this.f51948c.get(i9);
                if (viewHolder != null && (i8 = viewHolder.mPosition) >= i7 && i8 <= i6) {
                    if (i8 == i3) {
                        viewHolder.offsetPosition(i4 - i3, false);
                    } else {
                        viewHolder.offsetPosition(i5, false);
                    }
                    if (RecyclerView.F0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i9 + " holder " + viewHolder);
                    }
                }
            }
        }

        void x(int i3, int i4, boolean z2) {
            int i5 = i3 + i4;
            for (int size = this.f51948c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f51948c.get(size);
                if (viewHolder != null) {
                    int i6 = viewHolder.mPosition;
                    if (i6 >= i5) {
                        if (RecyclerView.F0) {
                            Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.mPosition - i4));
                        }
                        viewHolder.offsetPosition(-i4, z2);
                    } else if (i6 >= i3) {
                        viewHolder.addFlags(8);
                        F(size);
                    }
                }
            }
        }

        void y(Adapter adapter, Adapter adapter2, boolean z2) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z2);
            u();
        }

        void z() {
            u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface RecyclerListener {
        void a(ViewHolder viewHolder);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        void a() {
            if (RecyclerView.K0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f51880v && recyclerView.f51878u) {
                    ViewCompat.e0(recyclerView, recyclerView.f51856j);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.D = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.r(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f51859k0.f51978g = true;
            recyclerView.a1(true);
            if (RecyclerView.this.f51848f.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i4, Object obj) {
            RecyclerView.this.r(null);
            if (RecyclerView.this.f51848f.r(i3, i4, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            RecyclerView.this.r(null);
            if (RecyclerView.this.f51848f.s(i3, i4)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i4, int i5) {
            RecyclerView.this.r(null);
            if (RecyclerView.this.f51848f.t(i3, i4, i5)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i4) {
            RecyclerView.this.r(null);
            if (RecyclerView.this.f51848f.u(i3, i4)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f51845d == null || (adapter = recyclerView.f51864n) == null || !adapter.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class SmoothScroller {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f51958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LayoutManager f51959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f51960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f51961e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f51962f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f51964h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f51957a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Action f51963g = new Action(0, 0);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Action {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f51965a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f51966b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f51967c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f51968d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f51969e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f51970f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f51971g;

            public Action(int i3, int i4) {
                this(i3, i4, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f51969e != null && this.f51967c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f51967c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f51968d >= 0;
            }

            public void b(int i3) {
                this.f51968d = i3;
            }

            void c(RecyclerView recyclerView) {
                int i3 = this.f51968d;
                if (i3 >= 0) {
                    this.f51968d = -1;
                    recyclerView.G0(i3);
                    this.f51970f = false;
                } else {
                    if (!this.f51970f) {
                        this.f51971g = 0;
                        return;
                    }
                    e();
                    recyclerView.f51853h0.e(this.f51965a, this.f51966b, this.f51967c, this.f51969e);
                    int i4 = this.f51971g + 1;
                    this.f51971g = i4;
                    if (i4 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f51970f = false;
                }
            }

            public void d(int i3, int i4, int i5, Interpolator interpolator) {
                this.f51965a = i3;
                this.f51966b = i4;
                this.f51967c = i5;
                this.f51969e = interpolator;
                this.f51970f = true;
            }

            public Action(int i3, int i4, int i5, Interpolator interpolator) {
                this.f51968d = -1;
                this.f51970f = false;
                this.f51971g = 0;
                this.f51965a = i3;
                this.f51966b = i4;
                this.f51967c = i5;
                this.f51969e = interpolator;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ScrollVectorProvider {
            PointF e(int i3);
        }

        public PointF a(int i3) {
            Object objE = e();
            if (objE instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) objE).e(i3);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View b(int i3) {
            return this.f51958b.f51866o.I(i3);
        }

        public int c() {
            return this.f51958b.f51866o.P();
        }

        public int d(View view) {
            return this.f51958b.l0(view);
        }

        public LayoutManager e() {
            return this.f51959c;
        }

        public int f() {
            return this.f51957a;
        }

        public boolean g() {
            return this.f51960d;
        }

        public boolean h() {
            return this.f51961e;
        }

        protected void i(PointF pointF) {
            float f3 = pointF.x;
            float f4 = pointF.y;
            float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void j(int i3, int i4) {
            PointF pointFA;
            RecyclerView recyclerView = this.f51958b;
            if (this.f51957a == -1 || recyclerView == null) {
                r();
            }
            if (this.f51960d && this.f51962f == null && this.f51959c != null && (pointFA = a(this.f51957a)) != null) {
                float f3 = pointFA.x;
                if (f3 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.t1((int) Math.signum(f3), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f51960d = false;
            View view = this.f51962f;
            if (view != null) {
                if (d(view) == this.f51957a) {
                    o(this.f51962f, recyclerView.f51859k0, this.f51963g);
                    this.f51963g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f51962f = null;
                }
            }
            if (this.f51961e) {
                l(i3, i4, recyclerView.f51859k0, this.f51963g);
                boolean zA = this.f51963g.a();
                this.f51963g.c(recyclerView);
                if (zA && this.f51961e) {
                    this.f51960d = true;
                    recyclerView.f51853h0.d();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f51962f = view;
                if (RecyclerView.F0) {
                    Log.d("RecyclerView", "smooth scroll target view has been attached");
                }
            }
        }

        protected abstract void l(int i3, int i4, State state, Action action);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, State state, Action action);

        public void p(int i3) {
            this.f51957a = i3;
        }

        void q(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.f51853h0.f();
            if (this.f51964h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f51958b = recyclerView;
            this.f51959c = layoutManager;
            int i3 = this.f51957a;
            if (i3 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f51859k0.f51972a = i3;
            this.f51961e = true;
            this.f51960d = true;
            this.f51962f = b(f());
            m();
            this.f51958b.f51853h0.d();
            this.f51964h = true;
        }

        protected final void r() {
            if (this.f51961e) {
                this.f51961e = false;
                n();
                this.f51958b.f51859k0.f51972a = -1;
                this.f51962f = null;
                this.f51957a = -1;
                this.f51960d = false;
                this.f51959c.k1(this);
                this.f51959c = null;
                this.f51958b = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class State {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray f51973b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f51984m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f51985n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f51986o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f51987p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f51988q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51972a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f51974c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f51975d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f51976e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f51977f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f51978g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f51979h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f51980i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f51981j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f51982k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f51983l = false;

        void a(int i3) {
            if ((this.f51976e & i3) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f51976e));
        }

        public int b() {
            return this.f51979h ? this.f51974c - this.f51975d : this.f51977f;
        }

        public int c() {
            return this.f51972a;
        }

        public boolean d() {
            return this.f51972a != -1;
        }

        public boolean e() {
            return this.f51979h;
        }

        void f(Adapter adapter) {
            this.f51976e = 1;
            this.f51977f = adapter.getItemCount();
            this.f51979h = false;
            this.f51980i = false;
            this.f51981j = false;
        }

        public boolean g() {
            return this.f51983l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f51972a + ", mData=" + this.f51973b + ", mItemCount=" + this.f51977f + ", mIsMeasuring=" + this.f51981j + ", mPreviousLayoutItemCount=" + this.f51974c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f51975d + ", mStructureChanged=" + this.f51978g + ", mInPreLayout=" + this.f51979h + ", mRunSimpleAnimations=" + this.f51982k + ", mRunPredictiveAnimations=" + this.f51983l + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        StretchEdgeEffectFactory() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
        protected EdgeEffect a(RecyclerView recyclerView, int i3) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ViewCacheExtension {
        public abstract View a(Recycler recycler, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    class ViewFlinger implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f51989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f51990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        OverScroller f51991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Interpolator f51992d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f51993f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f51994g;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.P0;
            this.f51992d = interpolator;
            this.f51993f = false;
            this.f51994g = false;
            this.f51991c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i3, int i4) {
            int iAbs = Math.abs(i3);
            int iAbs2 = Math.abs(i4);
            boolean z2 = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z2) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), AdError.SERVER_ERROR_CODE);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.e0(RecyclerView.this, this);
        }

        public void b(int i3, int i4) {
            RecyclerView.this.setScrollState(2);
            this.f51990b = 0;
            this.f51989a = 0;
            Interpolator interpolator = this.f51992d;
            Interpolator interpolator2 = RecyclerView.P0;
            if (interpolator != interpolator2) {
                this.f51992d = interpolator2;
                this.f51991c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f51991c.fling(0, 0, i3, i4, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            d();
        }

        void d() {
            if (this.f51993f) {
                this.f51994g = true;
            } else {
                c();
            }
        }

        public void e(int i3, int i4, int i5, Interpolator interpolator) {
            if (i5 == Integer.MIN_VALUE) {
                i5 = a(i3, i4);
            }
            int i6 = i5;
            if (interpolator == null) {
                interpolator = RecyclerView.P0;
            }
            if (this.f51992d != interpolator) {
                this.f51992d = interpolator;
                this.f51991c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f51990b = 0;
            this.f51989a = 0;
            RecyclerView.this.setScrollState(2);
            this.f51991c.startScroll(0, 0, i3, i4, i6);
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f51991c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f51866o == null) {
                f();
                return;
            }
            this.f51994g = false;
            this.f51993f = true;
            recyclerView.A();
            OverScroller overScroller = this.f51991c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.f51989a;
                int i6 = currY - this.f51990b;
                this.f51989a = currX;
                this.f51990b = currY;
                int iX = RecyclerView.this.x(i5);
                int iZ = RecyclerView.this.z(i6);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f51885x0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.L(iX, iZ, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f51885x0;
                    iX -= iArr2[0];
                    iZ -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.w(iX, iZ);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f51864n != null) {
                    int[] iArr3 = recyclerView3.f51885x0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.t1(iX, iZ, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f51885x0;
                    int i7 = iArr4[0];
                    int i8 = iArr4[1];
                    iX -= i7;
                    iZ -= i8;
                    SmoothScroller smoothScroller = recyclerView4.f51866o.f51917g;
                    if (smoothScroller != null && !smoothScroller.g() && smoothScroller.h()) {
                        int iB = RecyclerView.this.f51859k0.b();
                        if (iB == 0) {
                            smoothScroller.r();
                        } else if (smoothScroller.f() >= iB) {
                            smoothScroller.p(iB - 1);
                            smoothScroller.j(i7, i8);
                        } else {
                            smoothScroller.j(i7, i8);
                        }
                    }
                    i4 = i8;
                    i3 = i7;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int i9 = iX;
                int i10 = iZ;
                if (!RecyclerView.this.f51872r.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f51885x0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.M(i3, i4, i9, i10, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f51885x0;
                int i11 = i9 - iArr6[0];
                int i12 = i10 - iArr6[1];
                if (i3 != 0 || i4 != 0) {
                    recyclerView6.O(i3, i4);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.f51866o.f51917g;
                if ((smoothScroller2 == null || !smoothScroller2.g()) && z2) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.b(i13, currVelocity);
                    }
                    if (RecyclerView.L0) {
                        RecyclerView.this.f51857j0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.f51855i0;
                    if (gapWorker != null) {
                        gapWorker.f(recyclerView7, i3, i4);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.f51866o.f51917g;
            if (smoothScroller3 != null && smoothScroller3.g()) {
                smoothScroller3.j(0, 0);
            }
            this.f51993f = false;
            if (this.f51994g) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.I1(1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void a() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                a();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i3) {
            this.mFlags = i3 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.O(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i3, int i4, boolean z2) {
            addFlags(8);
            offsetPosition(i4, z2);
            this.mPosition = i3;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.i0(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int iI0;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (iI0 = this.mOwnerRecyclerView.i0(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, iI0);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i3 = this.mPreLayoutPosition;
            return i3 == -1 ? this.mPosition : i3;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i3 = this.mPreLayoutPosition;
            return i3 == -1 ? this.mPosition : i3;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i3) {
            return (i3 & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.O(this.itemView);
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i3, boolean z2) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z2) {
                this.mPreLayoutPosition += i3;
            }
            this.mPosition += i3;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f51937c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i3 = this.mPendingAccessibilityState;
            if (i3 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i3;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.w(this.itemView);
            }
            recyclerView.w1(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.w1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            if (RecyclerView.E0 && isTmpDetached()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.u(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i3, int i4) {
            this.mFlags = (i3 & i4) | (this.mFlags & (~i4));
        }

        public final void setIsRecyclable(boolean z2) {
            int i3 = this.mIsRecyclableCount;
            int i4 = z2 ? i3 - 1 : i3 + 1;
            this.mIsRecyclableCount = i4;
            if (i4 < 0) {
                this.mIsRecyclableCount = 0;
                if (RecyclerView.E0) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z2 && i4 == 1) {
                this.mFlags |= 16;
            } else if (z2 && i4 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.F0) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this);
            }
        }

        void setScrapContainer(Recycler recycler, boolean z2) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z2;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void unScrap() {
            this.mScrapContainer.O(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        Class cls = Integer.TYPE;
        O0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        P0 = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f3) {
                float f4 = f3 - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
            }
        };
        Q0 = new StretchEdgeEffectFactory();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void B(Context context, String str, AttributeSet attributeSet, int i3, int i4) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strR0 = r0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strR0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                try {
                    constructor = clsAsSubclass.getConstructor(O0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i4)};
                } catch (NoSuchMethodException e3) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e4) {
                        e4.initCause(e3);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strR0, e4);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LayoutManager) constructor.newInstance(objArr));
            } catch (ClassCastException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strR0, e5);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strR0, e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strR0, e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strR0, e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strR0, e9);
            }
        }
    }

    private boolean D(int i3, int i4) {
        b0(this.f51877t0);
        int[] iArr = this.f51877t0;
        return (iArr[0] == i3 && iArr[1] == i4) ? false : true;
    }

    private boolean F0(View view, View view2, int i3) {
        int i4;
        if (view2 == null || view2 == this || view2 == view || Y(view2) == null) {
            return false;
        }
        if (view == null || Y(view) == null) {
            return true;
        }
        this.f51858k.set(0, 0, view.getWidth(), view.getHeight());
        this.f51860l.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f51858k);
        offsetDescendantRectToMyCoords(view2, this.f51860l);
        byte b3 = -1;
        int i5 = this.f51866o.e0() == 1 ? -1 : 1;
        Rect rect = this.f51858k;
        int i6 = rect.left;
        Rect rect2 = this.f51860l;
        int i7 = rect2.left;
        if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
            i4 = 1;
        } else {
            int i8 = rect.right;
            int i9 = rect2.right;
            i4 = ((i8 > i9 || i6 >= i9) && i6 > i7) ? -1 : 0;
        }
        int i10 = rect.top;
        int i11 = rect2.top;
        if ((i10 < i11 || rect.bottom <= i11) && rect.bottom < rect2.bottom) {
            b3 = 1;
        } else {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if ((i12 <= i13 && i10 < i13) || i10 <= i11) {
                b3 = 0;
            }
        }
        if (i3 == 1) {
            return b3 < 0 || (b3 == 0 && i4 * i5 < 0);
        }
        if (i3 == 2) {
            return b3 > 0 || (b3 == 0 && i4 * i5 > 0);
        }
        if (i3 == 17) {
            return i4 < 0;
        }
        if (i3 == 33) {
            return b3 < 0;
        }
        if (i3 == 66) {
            return i4 > 0;
        }
        if (i3 == 130) {
            return b3 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i3 + V());
    }

    private void G() {
        int i3 = this.C;
        this.C = 0;
        if (i3 == 0 || !D0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AccessibilityEventCompat.b(accessibilityEventObtain, i3);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private boolean G1(MotionEvent motionEvent) {
        boolean z2;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z2 = false;
        } else {
            EdgeEffectCompat.d(this.L, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z2 = true;
        }
        EdgeEffect edgeEffect2 = this.N;
        if (edgeEffect2 != null && EdgeEffectCompat.b(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            EdgeEffectCompat.d(this.N, 0.0f, motionEvent.getY() / getHeight());
            z2 = true;
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && EdgeEffectCompat.b(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            EdgeEffectCompat.d(this.M, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 == null || EdgeEffectCompat.b(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z2;
        }
        EdgeEffectCompat.d(this.O, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void I() {
        this.f51859k0.a(1);
        W(this.f51859k0);
        this.f51859k0.f51981j = false;
        E1();
        this.f51852h.f();
        R0();
        Z0();
        q1();
        State state = this.f51859k0;
        state.f51980i = state.f51982k && this.f51867o0;
        this.f51867o0 = false;
        this.f51865n0 = false;
        state.f51979h = state.f51983l;
        state.f51977f = this.f51864n.getItemCount();
        b0(this.f51877t0);
        if (this.f51859k0.f51982k) {
            int iG = this.f51850g.g();
            for (int i3 = 0; i3 < iG; i3++) {
                ViewHolder viewHolderN0 = n0(this.f51850g.f(i3));
                if (!viewHolderN0.shouldIgnore() && (!viewHolderN0.isInvalid() || this.f51864n.hasStableIds())) {
                    this.f51852h.e(viewHolderN0, this.P.u(this.f51859k0, viewHolderN0, ItemAnimator.e(viewHolderN0), viewHolderN0.getUnmodifiedPayloads()));
                    if (this.f51859k0.f51980i && viewHolderN0.isUpdated() && !viewHolderN0.isRemoved() && !viewHolderN0.shouldIgnore() && !viewHolderN0.isInvalid()) {
                        this.f51852h.c(j0(viewHolderN0), viewHolderN0);
                    }
                }
            }
        }
        if (this.f51859k0.f51983l) {
            r1();
            State state2 = this.f51859k0;
            boolean z2 = state2.f51978g;
            state2.f51978g = false;
            this.f51866o.c1(this.f51843c, state2);
            this.f51859k0.f51978g = z2;
            for (int i4 = 0; i4 < this.f51850g.g(); i4++) {
                ViewHolder viewHolderN02 = n0(this.f51850g.f(i4));
                if (!viewHolderN02.shouldIgnore() && !this.f51852h.i(viewHolderN02)) {
                    int iE = ItemAnimator.e(viewHolderN02);
                    boolean zHasAnyOfTheFlags = viewHolderN02.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!zHasAnyOfTheFlags) {
                        iE |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo itemHolderInfoU = this.P.u(this.f51859k0, viewHolderN02, iE, viewHolderN02.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        c1(viewHolderN02, itemHolderInfoU);
                    } else {
                        this.f51852h.a(viewHolderN02, itemHolderInfoU);
                    }
                }
            }
            v();
        } else {
            v();
        }
        S0();
        H1(false);
        this.f51859k0.f51976e = 2;
    }

    private void J() {
        E1();
        R0();
        this.f51859k0.a(6);
        this.f51848f.j();
        this.f51859k0.f51977f = this.f51864n.getItemCount();
        this.f51859k0.f51975d = 0;
        if (this.f51845d != null && this.f51864n.canRestoreState()) {
            Parcelable parcelable = this.f51845d.f51956c;
            if (parcelable != null) {
                this.f51866o.h1(parcelable);
            }
            this.f51845d = null;
        }
        State state = this.f51859k0;
        state.f51979h = false;
        this.f51866o.c1(this.f51843c, state);
        State state2 = this.f51859k0;
        state2.f51978g = false;
        state2.f51982k = state2.f51982k && this.P != null;
        state2.f51976e = 4;
        S0();
        H1(false);
    }

    private void J0(int i3, int i4, MotionEvent motionEvent, int i5) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) {
            return;
        }
        int[] iArr = this.f51885x0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zQ = layoutManager.q();
        boolean zR = this.f51866o.r();
        int i6 = zR ? (zQ ? 1 : 0) | 2 : zQ ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iF1 = i3 - f1(i3, height);
        int iG1 = i4 - g1(i4, width);
        F1(i6, i5);
        if (L(zQ ? iF1 : 0, zR ? iG1 : 0, this.f51885x0, this.f51881v0, i5)) {
            int[] iArr2 = this.f51885x0;
            iF1 -= iArr2[0];
            iG1 -= iArr2[1];
        }
        s1(zQ ? iF1 : 0, zR ? iG1 : 0, motionEvent, i5);
        GapWorker gapWorker = this.f51855i0;
        if (gapWorker != null && (iF1 != 0 || iG1 != 0)) {
            gapWorker.f(this, iF1, iG1);
        }
        I1(i5);
    }

    private void K() {
        RecyclerView recyclerView;
        this.f51859k0.a(4);
        E1();
        R0();
        State state = this.f51859k0;
        state.f51976e = 1;
        if (state.f51982k) {
            for (int iG = this.f51850g.g() - 1; iG >= 0; iG--) {
                ViewHolder viewHolderN0 = n0(this.f51850g.f(iG));
                if (!viewHolderN0.shouldIgnore()) {
                    long jJ0 = j0(viewHolderN0);
                    ItemAnimator.ItemHolderInfo itemHolderInfoT = this.P.t(this.f51859k0, viewHolderN0);
                    ViewHolder viewHolderG = this.f51852h.g(jJ0);
                    if (viewHolderG == null || viewHolderG.shouldIgnore()) {
                        this.f51852h.d(viewHolderN0, itemHolderInfoT);
                    } else {
                        boolean zH = this.f51852h.h(viewHolderG);
                        boolean zH2 = this.f51852h.h(viewHolderN0);
                        if (zH && viewHolderG == viewHolderN0) {
                            this.f51852h.d(viewHolderN0, itemHolderInfoT);
                        } else {
                            ItemAnimator.ItemHolderInfo itemHolderInfoN = this.f51852h.n(viewHolderG);
                            this.f51852h.d(viewHolderN0, itemHolderInfoT);
                            ItemAnimator.ItemHolderInfo itemHolderInfoM = this.f51852h.m(viewHolderN0);
                            if (itemHolderInfoN == null) {
                                u0(jJ0, viewHolderN0, viewHolderG);
                            } else {
                                p(viewHolderG, viewHolderN0, itemHolderInfoN, itemHolderInfoM, zH, zH2);
                            }
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.f51852h.o(recyclerView.D0);
        } else {
            recyclerView = this;
        }
        recyclerView.f51866o.q1(recyclerView.f51843c);
        State state2 = recyclerView.f51859k0;
        state2.f51974c = state2.f51977f;
        recyclerView.G = false;
        recyclerView.H = false;
        state2.f51982k = false;
        state2.f51983l = false;
        recyclerView.f51866o.f51918h = false;
        ArrayList arrayList = recyclerView.f51843c.f51947b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = recyclerView.f51866o;
        if (layoutManager.f51924n) {
            layoutManager.f51923m = 0;
            layoutManager.f51924n = false;
            recyclerView.f51843c.P();
        }
        recyclerView.f51866o.d1(recyclerView.f51859k0);
        S0();
        H1(false);
        recyclerView.f51852h.f();
        int[] iArr = recyclerView.f51877t0;
        if (D(iArr[0], iArr[1])) {
            O(0, 0);
        }
        d1();
        o1();
    }

    private void K1() {
        this.f51853h0.f();
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.P1();
        }
    }

    private boolean Q(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.f51876t;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return a0(motionEvent);
        }
        onItemTouchListener.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f51876t = null;
        }
        return true;
    }

    private void U0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.R) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.R = motionEvent.getPointerId(i3);
            int x2 = (int) (motionEvent.getX(i3) + 0.5f);
            this.V = x2;
            this.T = x2;
            int y2 = (int) (motionEvent.getY(i3) + 0.5f);
            this.W = y2;
            this.U = y2;
        }
    }

    private boolean Y0() {
        return this.P != null && this.f51866o.Q1();
    }

    private void Z0() {
        boolean z2;
        if (this.G) {
            this.f51848f.y();
            if (this.H) {
                this.f51866o.X0(this);
            }
        }
        if (Y0()) {
            this.f51848f.w();
        } else {
            this.f51848f.j();
        }
        boolean z3 = this.f51865n0 || this.f51867o0;
        this.f51859k0.f51982k = this.f51884x && this.P != null && ((z2 = this.G) || z3 || this.f51866o.f51918h) && (!z2 || this.f51864n.hasStableIds());
        State state = this.f51859k0;
        state.f51983l = state.f51982k && z3 && !this.G && Y0();
    }

    private boolean a0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f51874s.size();
        for (int i3 = 0; i3 < size; i3++) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.f51874s.get(i3);
            if (onItemTouchListener.c(this, motionEvent) && action != 3) {
                this.f51876t = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void b0(int[] iArr) {
        int iG = this.f51850g.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iG; i5++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.f(i5));
            if (!viewHolderN0.shouldIgnore()) {
                int layoutPosition = viewHolderN0.getLayoutPosition();
                if (layoutPosition < i3) {
                    i3 = layoutPosition;
                }
                if (layoutPosition > i4) {
                    i4 = layoutPosition;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b1(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.S()
            android.widget.EdgeEffect r1 = r6.L
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.EdgeEffectCompat.d(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.T()
            android.widget.EdgeEffect r1 = r6.N
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.d(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.U()
            android.widget.EdgeEffect r9 = r6.M
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.EdgeEffectCompat.d(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.R()
            android.widget.EdgeEffect r9 = r6.O
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.EdgeEffectCompat.d(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7e
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7e
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            androidx.core.view.ViewCompat.d0(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.b1(float, float, float, float):void");
    }

    static RecyclerView c0(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView recyclerViewC0 = c0(viewGroup.getChildAt(i3));
            if (recyclerViewC0 != null) {
                return recyclerViewC0;
            }
        }
        return null;
    }

    private View d0() {
        ViewHolder viewHolderE0;
        State state = this.f51859k0;
        int i3 = state.f51984m;
        if (i3 == -1) {
            i3 = 0;
        }
        int iB = state.b();
        for (int i4 = i3; i4 < iB; i4++) {
            ViewHolder viewHolderE02 = e0(i4);
            if (viewHolderE02 == null) {
                break;
            }
            if (viewHolderE02.itemView.hasFocusable()) {
                return viewHolderE02.itemView;
            }
        }
        int iMin = Math.min(iB, i3);
        do {
            iMin--;
            if (iMin < 0 || (viewHolderE0 = e0(iMin)) == null) {
                return null;
            }
        } while (!viewHolderE0.itemView.hasFocusable());
        return viewHolderE0.itemView;
    }

    private void d1() {
        View viewFindViewById;
        if (!this.f51851g0 || this.f51864n == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!N0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f51850g.n(focusedChild)) {
                    return;
                }
            } else if (this.f51850g.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewD0 = null;
        ViewHolder viewHolderF0 = (this.f51859k0.f51985n == -1 || !this.f51864n.hasStableIds()) ? null : f0(this.f51859k0.f51985n);
        if (viewHolderF0 != null && !this.f51850g.n(viewHolderF0.itemView) && viewHolderF0.itemView.hasFocusable()) {
            viewD0 = viewHolderF0.itemView;
        } else if (this.f51850g.g() > 0) {
            viewD0 = d0();
        }
        if (viewD0 != null) {
            int i3 = this.f51859k0.f51986o;
            if (i3 != -1 && (viewFindViewById = viewD0.findViewById(i3)) != null && viewFindViewById.isFocusable()) {
                viewD0 = viewFindViewById;
            }
            viewD0.requestFocus();
        }
    }

    private void e1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.L.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.M;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        EdgeEffect edgeEffect3 = this.N;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.N.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.O.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.d0(this);
        }
    }

    private int f1(int i3, float f3) {
        float height = f3 / getHeight();
        float width = i3 / getWidth();
        EdgeEffect edgeEffect = this.L;
        float f4 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.N;
            if (edgeEffect2 != null && EdgeEffectCompat.b(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.N.onRelease();
                } else {
                    float fD = EdgeEffectCompat.d(this.N, width, height);
                    if (EdgeEffectCompat.b(this.N) == 0.0f) {
                        this.N.onRelease();
                    }
                    f4 = fD;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.L.onRelease();
            } else {
                float f5 = -EdgeEffectCompat.d(this.L, -width, 1.0f - height);
                if (EdgeEffectCompat.b(this.L) == 0.0f) {
                    this.L.onRelease();
                }
                f4 = f5;
            }
            invalidate();
        }
        return Math.round(f4 * getWidth());
    }

    private int g1(int i3, float f3) {
        float width = f3 / getWidth();
        float height = i3 / getHeight();
        EdgeEffect edgeEffect = this.M;
        float f4 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.O;
            if (edgeEffect2 != null && EdgeEffectCompat.b(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.O.onRelease();
                } else {
                    float fD = EdgeEffectCompat.d(this.O, height, 1.0f - width);
                    if (EdgeEffectCompat.b(this.O) == 0.0f) {
                        this.O.onRelease();
                    }
                    f4 = fD;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.M.onRelease();
            } else {
                float f5 = -EdgeEffectCompat.d(this.M, -height, width);
                if (EdgeEffectCompat.b(this.M) == 0.0f) {
                    this.M.onRelease();
                }
                f4 = f5;
            }
            invalidate();
        }
        return Math.round(f4 * getHeight());
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f51879u0 == null) {
            this.f51879u0 = new NestedScrollingChildHelper(this);
        }
        return this.f51879u0;
    }

    private void i(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z2 = view.getParent() == this;
        this.f51843c.O(m0(view));
        if (viewHolder.isTmpDetached()) {
            this.f51850g.c(view, -1, view.getLayoutParams(), true);
        } else if (z2) {
            this.f51850g.k(view);
        } else {
            this.f51850g.b(view, true);
        }
    }

    static ViewHolder n0(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f51935a;
    }

    private void n1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f51858k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f51937c) {
                Rect rect = layoutParams2.f51936b;
                Rect rect2 = this.f51858k;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f51858k);
            offsetRectIntoDescendantCoords(view, this.f51858k);
        }
        this.f51866o.x1(this, view, this.f51858k, !this.f51884x, view2 == null);
    }

    private void o1() {
        State state = this.f51859k0;
        state.f51985n = -1L;
        state.f51984m = -1;
        state.f51986o = -1;
    }

    private void p(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z2, boolean z3) {
        viewHolder.setIsRecyclable(false);
        if (z2) {
            i(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z3) {
                i(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            i(viewHolder);
            this.f51843c.O(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.P.b(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            X0();
        }
    }

    static void p0(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f51936b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private void p1() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        I1(0);
        e1();
    }

    private int q0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private void q1() {
        View focusedChild = (this.f51851g0 && hasFocus() && this.f51864n != null) ? getFocusedChild() : null;
        ViewHolder viewHolderZ = focusedChild != null ? Z(focusedChild) : null;
        if (viewHolderZ == null) {
            o1();
            return;
        }
        this.f51859k0.f51985n = this.f51864n.hasStableIds() ? viewHolderZ.getItemId() : -1L;
        this.f51859k0.f51984m = this.G ? -1 : viewHolderZ.isRemoved() ? viewHolderZ.mOldPosition : viewHolderZ.getAbsoluteAdapterPosition();
        this.f51859k0.f51986o = q0(viewHolderZ.itemView);
    }

    private String r0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public static void setDebugAssertionsEnabled(boolean z2) {
        E0 = z2;
    }

    public static void setVerboseLoggingEnabled(boolean z2) {
        F0 = z2;
    }

    private void t() {
        p1();
        setScrollState(0);
    }

    private float t0(int i3) {
        double dLog = Math.log((Math.abs(i3) * 0.35f) / (this.f51839a * 0.015f));
        float f3 = H0;
        return (float) (((double) (this.f51839a * 0.015f)) * Math.exp((((double) f3) / (((double) f3) - 1.0d)) * dLog));
    }

    static void u(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private void u0(long j3, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int iG = this.f51850g.g();
        for (int i3 = 0; i3 < iG; i3++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.f(i3));
            if (viewHolderN0 != viewHolder && j0(viewHolderN0) == j3) {
                Adapter adapter = this.f51864n;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + viewHolderN0 + " \n View Holder 2:" + viewHolder + V());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + viewHolderN0 + " \n View Holder 2:" + viewHolder + V());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + V());
    }

    private void v1(Adapter adapter, boolean z2, boolean z3) {
        Adapter adapter2 = this.f51864n;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f51841b);
            this.f51864n.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            h1();
        }
        this.f51848f.y();
        Adapter adapter3 = this.f51864n;
        this.f51864n = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f51841b);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.J0(adapter3, this.f51864n);
        }
        this.f51843c.y(adapter3, this.f51864n, z2);
        this.f51859k0.f51978g = true;
    }

    private boolean w0() {
        int iG = this.f51850g.g();
        for (int i3 = 0; i3 < iG; i3++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.f(i3));
            if (viewHolderN0 != null && !viewHolderN0.shouldIgnore() && viewHolderN0.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    private boolean x1(EdgeEffect edgeEffect, int i3, int i4) {
        if (i3 > 0) {
            return true;
        }
        return t0(-i3) < EdgeEffectCompat.b(edgeEffect) * ((float) i4);
    }

    private int y(int i3, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i4) {
        if (i3 > 0 && edgeEffect != null && EdgeEffectCompat.b(edgeEffect) != 0.0f) {
            int iRound = Math.round(((-i4) / 4.0f) * EdgeEffectCompat.d(edgeEffect, ((-i3) * 4.0f) / i4, 0.5f));
            if (iRound != i3) {
                edgeEffect.finish();
            }
            return i3 - iRound;
        }
        if (i3 >= 0 || edgeEffect2 == null || EdgeEffectCompat.b(edgeEffect2) == 0.0f) {
            return i3;
        }
        float f3 = i4;
        int iRound2 = Math.round((f3 / 4.0f) * EdgeEffectCompat.d(edgeEffect2, (i3 * 4.0f) / f3, 0.5f));
        if (iRound2 != i3) {
            edgeEffect2.finish();
        }
        return i3 - iRound2;
    }

    private void y0() {
        if (ViewCompat.x(this) == 0) {
            ViewCompat.y0(this, 8);
        }
    }

    private void z0() {
        this.f51850g = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View a(int i3) {
                return RecyclerView.this.getChildAt(i3);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void addView(View view, int i3) {
                RecyclerView.this.addView(view, i3);
                RecyclerView.this.E(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void b(View view) {
                ViewHolder viewHolderN0 = RecyclerView.n0(view);
                if (viewHolderN0 != null) {
                    viewHolderN0.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int c() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder d(View view) {
                return RecyclerView.n0(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void e(int i3) {
                View viewA = a(i3);
                if (viewA != null) {
                    ViewHolder viewHolderN0 = RecyclerView.n0(viewA);
                    if (viewHolderN0 != null) {
                        if (viewHolderN0.isTmpDetached() && !viewHolderN0.shouldIgnore()) {
                            throw new IllegalArgumentException("called detach on an already detached child " + viewHolderN0 + RecyclerView.this.V());
                        }
                        if (RecyclerView.F0) {
                            Log.d("RecyclerView", "tmpDetach " + viewHolderN0);
                        }
                        viewHolderN0.addFlags(Function.MAX_NARGS);
                    }
                } else if (RecyclerView.E0) {
                    throw new IllegalArgumentException("No view at offset " + i3 + RecyclerView.this.V());
                }
                RecyclerView.this.detachViewFromParent(i3);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void f() {
                int iC = c();
                for (int i3 = 0; i3 < iC; i3++) {
                    View viewA = a(i3);
                    RecyclerView.this.F(viewA);
                    viewA.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int g(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void h(View view) {
                ViewHolder viewHolderN0 = RecyclerView.n0(view);
                if (viewHolderN0 != null) {
                    viewHolderN0.onLeftHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void i(int i3) {
                View childAt = RecyclerView.this.getChildAt(i3);
                if (childAt != null) {
                    RecyclerView.this.F(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i3);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void j(View view, int i3, ViewGroup.LayoutParams layoutParams) {
                ViewHolder viewHolderN0 = RecyclerView.n0(view);
                if (viewHolderN0 != null) {
                    if (!viewHolderN0.isTmpDetached() && !viewHolderN0.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + viewHolderN0 + RecyclerView.this.V());
                    }
                    if (RecyclerView.F0) {
                        Log.d("RecyclerView", "reAttach " + viewHolderN0);
                    }
                    viewHolderN0.clearTmpDetachFlag();
                } else if (RecyclerView.E0) {
                    throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i3 + RecyclerView.this.V());
                }
                RecyclerView.this.attachViewToParent(view, i3, layoutParams);
            }
        });
    }

    void A() {
        if (!this.f51884x || this.G) {
            TraceCompat.a("RV FullInvalidate");
            H();
            TraceCompat.b();
            return;
        }
        if (this.f51848f.p()) {
            if (!this.f51848f.o(4) || this.f51848f.o(11)) {
                if (this.f51848f.p()) {
                    TraceCompat.a("RV FullInvalidate");
                    H();
                    TraceCompat.b();
                    return;
                }
                return;
            }
            TraceCompat.a("RV PartialInvalidate");
            E1();
            R0();
            this.f51848f.w();
            if (!this.f51888z) {
                if (w0()) {
                    H();
                } else {
                    this.f51848f.i();
                }
            }
            H1(true);
            S0();
            TraceCompat.b();
        }
    }

    void A0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.f51441a), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.f51443c), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.f51442b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + V());
        }
    }

    public void A1(int i3, int i4, Interpolator interpolator) {
        B1(i3, i4, interpolator, Integer.MIN_VALUE);
    }

    void B0() {
        this.O = null;
        this.M = null;
        this.N = null;
        this.L = null;
    }

    public void B1(int i3, int i4, Interpolator interpolator, int i5) {
        C1(i3, i4, interpolator, i5, false);
    }

    void C(int i3, int i4) {
        setMeasuredDimension(LayoutManager.t(i3, getPaddingLeft() + getPaddingRight(), ViewCompat.A(this)), LayoutManager.t(i4, getPaddingTop() + getPaddingBottom(), ViewCompat.z(this)));
    }

    public void C0() {
        if (this.f51872r.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.m("Cannot invalidate item decorations during a scroll or layout");
        }
        H0();
        requestLayout();
    }

    void C1(int i3, int i4, Interpolator interpolator, int i5, boolean z2) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) {
            return;
        }
        if (!layoutManager.q()) {
            i3 = 0;
        }
        if (!this.f51866o.r()) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        if (i5 != Integer.MIN_VALUE && i5 <= 0) {
            scrollBy(i3, i4);
            return;
        }
        if (z2) {
            int i6 = i3 != 0 ? 1 : 0;
            if (i4 != 0) {
                i6 |= 2;
            }
            F1(i6, 1);
        }
        this.f51853h0.e(i3, i4, i5, interpolator);
    }

    boolean D0() {
        AccessibilityManager accessibilityManager = this.E;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void D1(int i3) {
        if (this.A) {
            return;
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.N1(this, this.f51859k0, i3);
        }
    }

    void E(View view) {
        ViewHolder viewHolderN0 = n0(view);
        P0(view);
        Adapter adapter = this.f51864n;
        if (adapter != null && viewHolderN0 != null) {
            adapter.onViewAttachedToWindow(viewHolderN0);
        }
        List list = this.F;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.F.get(size)).d(view);
            }
        }
    }

    public boolean E0() {
        return this.I > 0;
    }

    void E1() {
        int i3 = this.f51886y + 1;
        this.f51886y = i3;
        if (i3 != 1 || this.A) {
            return;
        }
        this.f51888z = false;
    }

    void F(View view) {
        ViewHolder viewHolderN0 = n0(view);
        Q0(view);
        Adapter adapter = this.f51864n;
        if (adapter != null && viewHolderN0 != null) {
            adapter.onViewDetachedFromWindow(viewHolderN0);
        }
        List list = this.F;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.F.get(size)).b(view);
            }
        }
    }

    public boolean F1(int i3, int i4) {
        return getScrollingChildHelper().p(i3, i4);
    }

    void G0(int i3) {
        if (this.f51866o == null) {
            return;
        }
        setScrollState(2);
        this.f51866o.C1(i3);
        awakenScrollBars();
    }

    void H() {
        if (this.f51864n == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f51866o == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.f51859k0.f51981j = false;
        boolean z2 = this.A0 && !(this.B0 == getWidth() && this.C0 == getHeight());
        this.B0 = 0;
        this.C0 = 0;
        this.A0 = false;
        if (this.f51859k0.f51976e == 1) {
            I();
            this.f51866o.E1(this);
            J();
        } else if (this.f51848f.q() || z2 || this.f51866o.t0() != getWidth() || this.f51866o.c0() != getHeight()) {
            this.f51866o.E1(this);
            J();
        } else {
            this.f51866o.E1(this);
        }
        K();
    }

    void H0() {
        int iJ = this.f51850g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ((LayoutParams) this.f51850g.i(i3).getLayoutParams()).f51937c = true;
        }
        this.f51843c.s();
    }

    void H1(boolean z2) {
        if (this.f51886y < 1) {
            if (E0) {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + V());
            }
            this.f51886y = 1;
        }
        if (!z2 && !this.A) {
            this.f51888z = false;
        }
        if (this.f51886y == 1) {
            if (z2 && this.f51888z && !this.A && this.f51866o != null && this.f51864n != null) {
                H();
            }
            if (!this.A) {
                this.f51888z = false;
            }
        }
        this.f51886y--;
    }

    void I0() {
        int iJ = this.f51850g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i3));
            if (viewHolderN0 != null && !viewHolderN0.shouldIgnore()) {
                viewHolderN0.addFlags(6);
            }
        }
        H0();
        this.f51843c.t();
    }

    public void I1(int i3) {
        getScrollingChildHelper().r(i3);
    }

    public void J1() {
        setScrollState(0);
        K1();
    }

    public void K0(int i3) {
        int iG = this.f51850g.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f51850g.f(i4).offsetLeftAndRight(i3);
        }
    }

    public boolean L(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return getScrollingChildHelper().d(i3, i4, iArr, iArr2, i5);
    }

    public void L0(int i3) {
        int iG = this.f51850g.g();
        for (int i4 = 0; i4 < iG; i4++) {
            this.f51850g.f(i4).offsetTopAndBottom(i3);
        }
    }

    void L1(int i3, int i4, Object obj) {
        int i5;
        int iJ = this.f51850g.j();
        int i6 = i3 + i4;
        for (int i7 = 0; i7 < iJ; i7++) {
            View viewI = this.f51850g.i(i7);
            ViewHolder viewHolderN0 = n0(viewI);
            if (viewHolderN0 != null && !viewHolderN0.shouldIgnore() && (i5 = viewHolderN0.mPosition) >= i3 && i5 < i6) {
                viewHolderN0.addFlags(2);
                viewHolderN0.addChangePayload(obj);
                ((LayoutParams) viewI.getLayoutParams()).f51937c = true;
            }
        }
        this.f51843c.R(i3, i4);
    }

    public final void M(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        getScrollingChildHelper().e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    void M0(int i3, int i4) {
        int iJ = this.f51850g.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i5));
            if (viewHolderN0 != null && !viewHolderN0.shouldIgnore() && viewHolderN0.mPosition >= i3) {
                if (F0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i5 + " holder " + viewHolderN0 + " now at position " + (viewHolderN0.mPosition + i4));
                }
                viewHolderN0.offsetPosition(i4, false);
                this.f51859k0.f51978g = true;
            }
        }
        this.f51843c.v(i3, i4);
        requestLayout();
    }

    void N(int i3) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.j1(i3);
        }
        V0(i3);
        OnScrollListener onScrollListener = this.f51861l0;
        if (onScrollListener != null) {
            onScrollListener.a(this, i3);
        }
        List list = this.f51863m0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.f51863m0.get(size)).a(this, i3);
            }
        }
    }

    void O(int i3, int i4) {
        this.J++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i3, scrollY - i4);
        W0(i3, i4);
        OnScrollListener onScrollListener = this.f51861l0;
        if (onScrollListener != null) {
            onScrollListener.b(this, i3, i4);
        }
        List list = this.f51863m0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.f51863m0.get(size)).b(this, i3, i4);
            }
        }
        this.J--;
    }

    void O0(int i3, int i4, boolean z2) {
        int i5 = i3 + i4;
        int iJ = this.f51850g.j();
        for (int i6 = 0; i6 < iJ; i6++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i6));
            if (viewHolderN0 != null && !viewHolderN0.shouldIgnore()) {
                int i7 = viewHolderN0.mPosition;
                if (i7 >= i5) {
                    if (F0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i6 + " holder " + viewHolderN0 + " now at position " + (viewHolderN0.mPosition - i4));
                    }
                    viewHolderN0.offsetPosition(-i4, z2);
                    this.f51859k0.f51978g = true;
                } else if (i7 >= i3) {
                    if (F0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i6 + " holder " + viewHolderN0 + " now REMOVED");
                    }
                    viewHolderN0.flagRemovedAndOffsetPosition(i3 - 1, -i4, z2);
                    this.f51859k0.f51978g = true;
                }
            }
        }
        this.f51843c.x(i3, i4, z2);
        requestLayout();
    }

    void P() {
        int i3;
        for (int size = this.f51887y0.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.f51887y0.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i3 = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.w0(viewHolder.itemView, i3);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.f51887y0.clear();
    }

    public void P0(View view) {
    }

    public void Q0(View view) {
    }

    void R() {
        if (this.O != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.K.a(this, 3);
        this.O = edgeEffectA;
        if (this.f51854i) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void R0() {
        this.I++;
    }

    void S() {
        if (this.L != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.K.a(this, 0);
        this.L = edgeEffectA;
        if (this.f51854i) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void S0() {
        T0(true);
    }

    void T() {
        if (this.N != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.K.a(this, 2);
        this.N = edgeEffectA;
        if (this.f51854i) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void T0(boolean z2) {
        int i3 = this.I - 1;
        this.I = i3;
        if (i3 < 1) {
            if (E0 && i3 < 0) {
                throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + V());
            }
            this.I = 0;
            if (z2) {
                G();
                P();
            }
        }
    }

    void U() {
        if (this.M != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.K.a(this, 1);
        this.M = edgeEffectA;
        if (this.f51854i) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String V() {
        return " " + super.toString() + ", adapter:" + this.f51864n + ", layout:" + this.f51866o + ", context:" + getContext();
    }

    public void V0(int i3) {
    }

    final void W(State state) {
        if (getScrollState() != 2) {
            state.f51987p = 0;
            state.f51988q = 0;
        } else {
            OverScroller overScroller = this.f51853h0.f51991c;
            state.f51987p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f51988q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public void W0(int i3, int i4) {
    }

    public View X(float f3, float f4) {
        for (int iG = this.f51850g.g() - 1; iG >= 0; iG--) {
            View viewF = this.f51850g.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f3 >= viewF.getLeft() + translationX && f3 <= viewF.getRight() + translationX && f4 >= viewF.getTop() + translationY && f4 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    void X0() {
        if (this.f51871q0 || !this.f51878u) {
            return;
        }
        ViewCompat.e0(this, this.f51889z0);
        this.f51871q0 = true;
    }

    public View Y(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public ViewHolder Z(View view) {
        View viewY = Y(view);
        if (viewY == null) {
            return null;
        }
        return m0(viewY);
    }

    void a1(boolean z2) {
        this.H = z2 | this.H;
        this.G = true;
        I0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i3, int i4) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null || !layoutManager.K0(this, arrayList, i3, i4)) {
            super.addFocusables(arrayList, i3, i4);
        }
    }

    void b(int i3, int i4) {
        if (i3 < 0) {
            S();
            if (this.L.isFinished()) {
                this.L.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            T();
            if (this.N.isFinished()) {
                this.N.onAbsorb(i3);
            }
        }
        if (i4 < 0) {
            U();
            if (this.M.isFinished()) {
                this.M.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            R();
            if (this.O.isFinished()) {
                this.O.onAbsorb(i4);
            }
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        ViewCompat.d0(this);
    }

    void c1(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.f51859k0.f51980i && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.f51852h.c(j0(viewHolder), viewHolder);
        }
        this.f51852h.e(viewHolder, itemHolderInfo);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f51866o.s((LayoutParams) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.q()) {
            return this.f51866o.w(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.q()) {
            return this.f51866o.x(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.q()) {
            return this.f51866o.y(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.r()) {
            return this.f51866o.z(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.r()) {
            return this.f51866o.A(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null && layoutManager.r()) {
            return this.f51866o.B(this.f51859k0);
        }
        return 0;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z2) {
        return getScrollingChildHelper().a(f3, f4, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return getScrollingChildHelper().b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return getScrollingChildHelper().f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.f51872r.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ((ItemDecoration) this.f51872r.get(i3)).k(canvas, this, this.f51859k0);
        }
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f51854i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.L;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f51854i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.M;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.N;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f51854i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.N;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.O;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f51854i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.O;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.P == null || this.f51872r.size() <= 0 || !this.P.p()) ? z2 : true) {
            ViewCompat.d0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        return super.drawChild(canvas, view, j3);
    }

    public ViewHolder e0(int i3) {
        ViewHolder viewHolder = null;
        if (this.G) {
            return null;
        }
        int iJ = this.f51850g.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i4));
            if (viewHolderN0 != null && !viewHolderN0.isRemoved() && i0(viewHolderN0) == i3) {
                if (!this.f51850g.n(viewHolderN0.itemView)) {
                    return viewHolderN0;
                }
                viewHolder = viewHolderN0;
            }
        }
        return viewHolder;
    }

    public ViewHolder f0(long j3) {
        Adapter adapter = this.f51864n;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int iJ = this.f51850g.j();
            for (int i3 = 0; i3 < iJ; i3++) {
                ViewHolder viewHolderN0 = n0(this.f51850g.i(i3));
                if (viewHolderN0 != null && !viewHolderN0.isRemoved() && viewHolderN0.getItemId() == j3) {
                    if (!this.f51850g.n(viewHolderN0.itemView)) {
                        return viewHolderN0;
                    }
                    viewHolder = viewHolderN0;
                }
            }
        }
        return viewHolder;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        View viewO0;
        boolean z2;
        View viewV0 = this.f51866o.V0(view, i3);
        if (viewV0 != null) {
            return viewV0;
        }
        boolean z3 = (this.f51864n == null || this.f51866o == null || E0() || this.A) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i3 == 2 || i3 == 1)) {
            if (this.f51866o.r()) {
                int i4 = i3 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i4) == null;
                if (M0) {
                    i3 = i4;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f51866o.q()) {
                int i5 = (this.f51866o.e0() == 1) ^ (i3 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i5) == null;
                if (M0) {
                    i3 = i5;
                }
                z2 = z4;
            }
            if (z2) {
                A();
                if (Y(view) == null) {
                    return null;
                }
                E1();
                this.f51866o.O0(view, i3, this.f51843c, this.f51859k0);
                H1(false);
            }
            viewO0 = focusFinder.findNextFocus(this, view, i3);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i3);
            if (viewFindNextFocus == null && z3) {
                A();
                if (Y(view) == null) {
                    return null;
                }
                E1();
                viewO0 = this.f51866o.O0(view, i3, this.f51843c, this.f51859k0);
                H1(false);
            } else {
                viewO0 = viewFindNextFocus;
            }
        }
        if (viewO0 == null || viewO0.hasFocusable()) {
            return F0(view, viewO0, i3) ? viewO0 : super.focusSearch(view, i3);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i3);
        }
        n1(viewO0, null);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.ViewHolder g0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.f51850g
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.ChildHelper r3 = r5.f51850g
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = n0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.ChildHelper r1 = r5.f51850g
            android.view.View r4 = r3.itemView
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            return layoutManager.J();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + V());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            return layoutManager.K(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + V());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f51864n;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.f51866o;
        return layoutManager != null ? layoutManager.M() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.f51875s0;
        return childDrawingOrderCallback == null ? super.getChildDrawingOrder(i3, i4) : childDrawingOrderCallback.a(i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f51854i;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f51873r0;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.K;
    }

    public ItemAnimator getItemAnimator() {
        return this.P;
    }

    public int getItemDecorationCount() {
        return this.f51872r.size();
    }

    public LayoutManager getLayoutManager() {
        return this.f51866o;
    }

    public int getMaxFlingVelocity() {
        return this.f51846d0;
    }

    public int getMinFlingVelocity() {
        return this.f51844c0;
    }

    long getNanoTime() {
        if (L0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public OnFlingListener getOnFlingListener() {
        return this.f51842b0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f51851g0;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.f51843c.i();
    }

    public int getScrollState() {
        return this.Q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean h0(int i3, int i4) {
        int iMax;
        int i5;
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.A) {
            return false;
        }
        int iQ = layoutManager.q();
        boolean zR = this.f51866o.r();
        if (iQ == 0 || Math.abs(i3) < this.f51844c0) {
            i3 = 0;
        }
        if (!zR || Math.abs(i4) < this.f51844c0) {
            i4 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        if (i3 == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.L;
            if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.N;
                if (edgeEffect2 != null && EdgeEffectCompat.b(edgeEffect2) != 0.0f) {
                    if (x1(this.N, i3, getWidth())) {
                        this.N.onAbsorb(i3);
                        i3 = 0;
                    }
                    iMax = i3;
                    i3 = 0;
                }
                iMax = 0;
            } else {
                int i6 = -i3;
                if (x1(this.L, i6, getWidth())) {
                    this.L.onAbsorb(i6);
                    i3 = 0;
                }
                iMax = i3;
                i3 = 0;
            }
        }
        if (i4 == 0) {
            i5 = i4;
            i4 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.M;
            if (edgeEffect3 == null || EdgeEffectCompat.b(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.O;
                if (edgeEffect4 != null && EdgeEffectCompat.b(edgeEffect4) != 0.0f) {
                    if (x1(this.O, i4, getHeight())) {
                        this.O.onAbsorb(i4);
                        i4 = 0;
                    }
                    i5 = 0;
                }
                i5 = i4;
                i4 = 0;
            } else {
                int i7 = -i4;
                if (x1(this.M, i7, getHeight())) {
                    this.M.onAbsorb(i7);
                    i4 = 0;
                }
                i5 = 0;
            }
        }
        if (iMax != 0 || i4 != 0) {
            int i8 = this.f51846d0;
            iMax = Math.max(-i8, Math.min(iMax, i8));
            int i9 = this.f51846d0;
            i4 = Math.max(-i9, Math.min(i4, i9));
            this.f51853h0.b(iMax, i4);
        }
        if (i3 == 0 && i5 == 0) {
            return (iMax == 0 && i4 == 0) ? false : true;
        }
        float f3 = i3;
        float f4 = i5;
        if (!dispatchNestedPreFling(f3, f4)) {
            boolean z2 = iQ != 0 || zR;
            dispatchNestedFling(f3, f4, z2);
            OnFlingListener onFlingListener = this.f51842b0;
            if (onFlingListener != null && onFlingListener.a(i3, i5)) {
                return true;
            }
            if (z2) {
                if (zR) {
                    iQ = (iQ == true ? 1 : 0) | 2;
                }
                F1(iQ, 1);
                int i10 = this.f51846d0;
                int iMax2 = Math.max(-i10, Math.min(i3, i10));
                int i11 = this.f51846d0;
                this.f51853h0.b(iMax2, Math.max(-i11, Math.min(i5, i11)));
                return true;
            }
        }
        return false;
    }

    void h1() {
        ItemAnimator itemAnimator = this.P;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.p1(this.f51843c);
            this.f51866o.q1(this.f51843c);
        }
        this.f51843c.c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    int i0(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.f51848f.e(viewHolder.mPosition);
    }

    boolean i1(View view) {
        E1();
        boolean zR = this.f51850g.r(view);
        if (zR) {
            ViewHolder viewHolderN0 = n0(view);
            this.f51843c.O(viewHolderN0);
            this.f51843c.H(viewHolderN0);
            if (F0) {
                Log.d("RecyclerView", "after removing animated view: " + view + ", " + this);
            }
        }
        H1(!zR);
        return zR;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f51878u;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.A;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(ItemDecoration itemDecoration) {
        k(itemDecoration, -1);
    }

    long j0(ViewHolder viewHolder) {
        return this.f51864n.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    public void j1(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.m("Cannot remove item decoration during a scroll  or layout");
        }
        this.f51872r.remove(itemDecoration);
        if (this.f51872r.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        H0();
        requestLayout();
    }

    public void k(ItemDecoration itemDecoration, int i3) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.m("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f51872r.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i3 < 0) {
            this.f51872r.add(itemDecoration);
        } else {
            this.f51872r.add(i3, itemDecoration);
        }
        H0();
        requestLayout();
    }

    public int k0(View view) {
        ViewHolder viewHolderN0 = n0(view);
        if (viewHolderN0 != null) {
            return viewHolderN0.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public void k1(OnItemTouchListener onItemTouchListener) {
        this.f51874s.remove(onItemTouchListener);
        if (this.f51876t == onItemTouchListener) {
            this.f51876t = null;
        }
    }

    public void l(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.F == null) {
            this.F = new ArrayList();
        }
        this.F.add(onChildAttachStateChangeListener);
    }

    public int l0(View view) {
        ViewHolder viewHolderN0 = n0(view);
        if (viewHolderN0 != null) {
            return viewHolderN0.getLayoutPosition();
        }
        return -1;
    }

    public void l1(OnScrollListener onScrollListener) {
        List list = this.f51863m0;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void m(OnItemTouchListener onItemTouchListener) {
        this.f51874s.add(onItemTouchListener);
    }

    public ViewHolder m0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return n0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void m1() {
        ViewHolder viewHolder;
        int iG = this.f51850g.g();
        for (int i3 = 0; i3 < iG; i3++) {
            View viewF = this.f51850g.f(i3);
            ViewHolder viewHolderM0 = m0(viewF);
            if (viewHolderM0 != null && (viewHolder = viewHolderM0.mShadowingHolder) != null) {
                View view = viewHolder.itemView;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void n(OnScrollListener onScrollListener) {
        if (this.f51863m0 == null) {
            this.f51863m0 = new ArrayList();
        }
        this.f51863m0.add(onScrollListener);
    }

    void o(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.P.a(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            X0();
        }
    }

    public void o0(View view, Rect rect) {
        p0(view, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.I = r0
            r1 = 1
            r5.f51878u = r1
            boolean r2 = r5.f51884x
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f51884x = r1
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.f51843c
            r1.z()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.f51866o
            if (r1 == 0) goto L23
            r1.F(r5)
        L23:
            r5.f51871q0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.L0
            if (r0 == 0) goto L66
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.GapWorker.f51663f
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.f51855i0 = r1
            if (r1 != 0) goto L61
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.f51855i0 = r1
            android.view.Display r1 = androidx.core.view.ViewCompat.s(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L53
            if (r1 == 0) goto L53
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L53
            goto L55
        L53:
            r1 = 1114636288(0x42700000, float:60.0)
        L55:
            androidx.recyclerview.widget.GapWorker r2 = r5.f51855i0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f51667c = r3
            r0.set(r2)
        L61:
            androidx.recyclerview.widget.GapWorker r0 = r5.f51855i0
            r0.a(r5)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.P;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        J1();
        this.f51878u = false;
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            layoutManager.G(this, this.f51843c);
        }
        this.f51887y0.clear();
        removeCallbacks(this.f51889z0);
        this.f51852h.j();
        this.f51843c.A();
        PoolingContainer.c(this);
        if (!L0 || (gapWorker = this.f51855i0) == null) {
            return;
        }
        gapWorker.j(this);
        this.f51855i0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f51872r.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ItemDecoration) this.f51872r.get(i3)).i(canvas, this, this.f51859k0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.f51866o
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.A
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.f51866o
            boolean r0 = r0.r()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f51866o
            boolean r3 = r3.q()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f51866o
            boolean r3 = r3.r()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f51866o
            boolean r3 = r3.q()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.f51847e0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f51849f0
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.J0(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.A) {
            return false;
        }
        this.f51876t = null;
        if (a0(motionEvent)) {
            t();
            return true;
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            return false;
        }
        boolean zQ = layoutManager.q();
        boolean zR = this.f51866o.r();
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.B) {
                this.B = false;
            }
            this.R = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.V = x2;
            this.T = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.W = y2;
            this.U = y2;
            if (G1(motionEvent) || this.Q == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                I1(1);
            }
            int[] iArr = this.f51883w0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i3 = zQ;
            if (zR) {
                i3 = (zQ ? 1 : 0) | 2;
            }
            F1(i3, 0);
        } else if (actionMasked == 1) {
            this.S.clear();
            I1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.R);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.R + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.Q != 1) {
                int i4 = x3 - this.T;
                int i5 = y3 - this.U;
                if (!zQ || Math.abs(i4) <= this.f51840a0) {
                    z2 = false;
                } else {
                    this.V = x3;
                    z2 = true;
                }
                if (zR && Math.abs(i5) > this.f51840a0) {
                    this.W = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            t();
        } else if (actionMasked == 5) {
            this.R = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.V = x4;
            this.T = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.W = y4;
            this.U = y4;
        } else if (actionMasked == 6) {
            U0(motionEvent);
        }
        return this.Q == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        TraceCompat.a("RV OnLayout");
        H();
        TraceCompat.b();
        this.f51884x = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            C(i3, i4);
            return;
        }
        boolean z2 = false;
        if (layoutManager.x0()) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f51866o.e1(this.f51843c, this.f51859k0, i3, i4);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.A0 = z2;
            if (z2 || this.f51864n == null) {
                return;
            }
            if (this.f51859k0.f51976e == 1) {
                I();
            }
            this.f51866o.F1(i3, i4);
            this.f51859k0.f51981j = true;
            J();
            this.f51866o.I1(i3, i4);
            if (this.f51866o.L1()) {
                this.f51866o.F1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f51859k0.f51981j = true;
                J();
                this.f51866o.I1(i3, i4);
            }
            this.B0 = getMeasuredWidth();
            this.C0 = getMeasuredHeight();
            return;
        }
        if (this.f51880v) {
            this.f51866o.e1(this.f51843c, this.f51859k0, i3, i4);
            return;
        }
        if (this.D) {
            E1();
            R0();
            Z0();
            S0();
            State state = this.f51859k0;
            if (state.f51983l) {
                state.f51979h = true;
            } else {
                this.f51848f.j();
                this.f51859k0.f51979h = false;
            }
            this.D = false;
            H1(false);
        } else if (this.f51859k0.f51983l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f51864n;
        if (adapter != null) {
            this.f51859k0.f51977f = adapter.getItemCount();
        } else {
            this.f51859k0.f51977f = 0;
        }
        E1();
        this.f51866o.e1(this.f51843c, this.f51859k0, i3, i4);
        H1(false);
        this.f51859k0.f51979h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (E0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f51845d = savedState;
        super.onRestoreInstanceState(savedState.c());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f51845d;
        if (savedState2 != null) {
            savedState.d(savedState2);
            return savedState;
        }
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            savedState.f51956c = layoutManager.i1();
            return savedState;
        }
        savedState.f51956c = null;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 && i4 == i6) {
            return;
        }
        B0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r1
      0x00df: PHI (r1v46 int) = (r1v26 int), (r1v50 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void q(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        i(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.P.c(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            X0();
        }
    }

    void r(String str) {
        if (E0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + V());
        }
        if (this.J > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + V()));
        }
    }

    void r1() {
        int iJ = this.f51850g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i3));
            if (E0 && viewHolderN0.mPosition == -1 && !viewHolderN0.isRemoved()) {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + V());
            }
            if (!viewHolderN0.shouldIgnore()) {
                viewHolderN0.saveOldPosition();
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        ViewHolder viewHolderN0 = n0(view);
        if (viewHolderN0 != null) {
            if (viewHolderN0.isTmpDetached()) {
                viewHolderN0.clearTmpDetachFlag();
            } else if (!viewHolderN0.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + viewHolderN0 + V());
            }
        } else if (E0) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + V());
        }
        view.clearAnimation();
        F(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f51866o.g1(this, this.f51859k0, view, view2) && view2 != null) {
            n1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f51866o.w1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.f51874s.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((OnItemTouchListener) this.f51874s.get(i3)).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f51886y != 0 || this.A) {
            this.f51888z = true;
        } else {
            super.requestLayout();
        }
    }

    boolean s(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.P;
        return itemAnimator == null || itemAnimator.g(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    Rect s0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f51937c) {
            return layoutParams.f51936b;
        }
        if (this.f51859k0.e() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f51936b;
        }
        Rect rect = layoutParams.f51936b;
        rect.set(0, 0, 0, 0);
        int size = this.f51872r.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f51858k.set(0, 0, 0, 0);
            ((ItemDecoration) this.f51872r.get(i3)).g(this.f51858k, view, this, this.f51859k0);
            int i4 = rect.left;
            Rect rect2 = this.f51858k;
            rect.left = i4 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f51937c = false;
        return rect;
    }

    boolean s1(int i3, int i4, MotionEvent motionEvent, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        A();
        if (this.f51864n != null) {
            int[] iArr = this.f51885x0;
            iArr[0] = 0;
            iArr[1] = 0;
            t1(i3, i4, iArr);
            int[] iArr2 = this.f51885x0;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            i8 = i3 - i10;
            i9 = i4 - i11;
            i7 = i11;
            i6 = i10;
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
        }
        if (!this.f51872r.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f51885x0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        M(i6, i7, i8, i9, this.f51881v0, i5, iArr3);
        int[] iArr4 = this.f51885x0;
        int i12 = iArr4[0];
        int i13 = i8 - i12;
        int i14 = iArr4[1];
        int i15 = i9 - i14;
        boolean z2 = (i12 == 0 && i14 == 0) ? false : true;
        int i16 = this.V;
        int[] iArr5 = this.f51881v0;
        int i17 = iArr5[0];
        this.V = i16 - i17;
        int i18 = this.W;
        int i19 = iArr5[1];
        this.W = i18 - i19;
        int[] iArr6 = this.f51883w0;
        iArr6[0] = iArr6[0] + i17;
        iArr6[1] = iArr6[1] + i19;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.a(motionEvent, 8194)) {
                b1(motionEvent.getX(), i13, motionEvent.getY(), i15);
            }
            w(i3, i4);
        }
        if (i6 != 0 || i7 != 0) {
            O(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i6 == 0 && i7 == 0) ? false : true;
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i4) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) {
            return;
        }
        boolean zQ = layoutManager.q();
        boolean zR = this.f51866o.r();
        if (zQ || zR) {
            if (!zQ) {
                i3 = 0;
            }
            if (!zR) {
                i4 = 0;
            }
            s1(i3, i4, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (y1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f51873r0 = recyclerViewAccessibilityDelegate;
        ViewCompat.m0(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        v1(adapter, false, true);
        a1(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.f51875s0) {
            return;
        }
        this.f51875s0 = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f51854i) {
            B0();
        }
        this.f51854i = z2;
        super.setClipToPadding(z2);
        if (this.f51884x) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.h(edgeEffectFactory);
        this.K = edgeEffectFactory;
        B0();
    }

    public void setHasFixedSize(boolean z2) {
        this.f51880v = z2;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.P;
        if (itemAnimator2 != null) {
            itemAnimator2.k();
            this.P.w(null);
        }
        this.P = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.w(this.f51869p0);
        }
    }

    public void setItemViewCacheSize(int i3) {
        this.f51843c.L(i3);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager == this.f51866o) {
            return;
        }
        J1();
        if (this.f51866o != null) {
            ItemAnimator itemAnimator = this.P;
            if (itemAnimator != null) {
                itemAnimator.k();
            }
            this.f51866o.p1(this.f51843c);
            this.f51866o.q1(this.f51843c);
            this.f51843c.c();
            if (this.f51878u) {
                this.f51866o.G(this, this.f51843c);
            }
            this.f51866o.J1(null);
            this.f51866o = null;
        } else {
            this.f51843c.c();
        }
        this.f51850g.o();
        this.f51866o = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.f51912b != null) {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f51912b.V());
            }
            layoutManager.J1(this);
            if (this.f51878u) {
                this.f51866o.F(this);
            }
        }
        this.f51843c.P();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.f51842b0 = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f51861l0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f51851g0 = z2;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.f51843c.J(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f51868p = recyclerListener;
    }

    void setScrollState(int i3) {
        if (i3 == this.Q) {
            return;
        }
        if (F0) {
            Log.d("RecyclerView", "setting scroll state to " + i3 + " from " + this.Q, new Exception());
        }
        this.Q = i3;
        if (i3 != 2) {
            K1();
        }
        N(i3);
    }

    public void setScrollingTouchSlop(int i3) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i3 != 0) {
            if (i3 == 1) {
                this.f51840a0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i3 + "; using default value");
        }
        this.f51840a0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.f51843c.K(viewCacheExtension);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().o(i3);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.A) {
            r("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.A = true;
                this.B = true;
                J1();
                return;
            }
            this.A = false;
            if (this.f51888z && this.f51866o != null && this.f51864n != null) {
                requestLayout();
            }
            this.f51888z = false;
        }
    }

    void t1(int i3, int i4, int[] iArr) {
        E1();
        R0();
        TraceCompat.a("RV Scroll");
        W(this.f51859k0);
        int iB1 = i3 != 0 ? this.f51866o.B1(i3, this.f51843c, this.f51859k0) : 0;
        int iD1 = i4 != 0 ? this.f51866o.D1(i4, this.f51843c, this.f51859k0) : 0;
        TraceCompat.b();
        m1();
        S0();
        H1(false);
        if (iArr != null) {
            iArr[0] = iB1;
            iArr[1] = iD1;
        }
    }

    public void u1(int i3) {
        if (this.A) {
            return;
        }
        J1();
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.C1(i3);
            awakenScrollBars();
        }
    }

    void v() {
        int iJ = this.f51850g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i3));
            if (!viewHolderN0.shouldIgnore()) {
                viewHolderN0.clearOldPosition();
            }
        }
        this.f51843c.d();
    }

    public boolean v0() {
        return !this.f51884x || this.G || this.f51848f.p();
    }

    void w(int i3, int i4) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || edgeEffect.isFinished() || i3 <= 0) {
            zIsFinished = false;
        } else {
            this.L.onRelease();
            zIsFinished = this.L.isFinished();
        }
        EdgeEffect edgeEffect2 = this.N;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i3 < 0) {
            this.N.onRelease();
            zIsFinished |= this.N.isFinished();
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i4 > 0) {
            this.M.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i4 < 0) {
            this.O.onRelease();
            zIsFinished |= this.O.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.d0(this);
        }
    }

    boolean w1(ViewHolder viewHolder, int i3) {
        if (!E0()) {
            ViewCompat.w0(viewHolder.itemView, i3);
            return true;
        }
        viewHolder.mPendingAccessibilityState = i3;
        this.f51887y0.add(viewHolder);
        return false;
    }

    int x(int i3) {
        return y(i3, this.L, this.N, getWidth());
    }

    void x0() {
        this.f51848f = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void a(int i3, int i4) {
                RecyclerView.this.N0(i3, i4);
                RecyclerView.this.f51865n0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void b(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void c(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void d(int i3, int i4) {
                RecyclerView.this.O0(i3, i4, false);
                RecyclerView.this.f51865n0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void e(int i3, int i4, Object obj) {
                RecyclerView.this.L1(i3, i4, obj);
                RecyclerView.this.f51867o0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder f(int i3) {
                ViewHolder viewHolderG0 = RecyclerView.this.g0(i3, true);
                if (viewHolderG0 == null) {
                    return null;
                }
                if (!RecyclerView.this.f51850g.n(viewHolderG0.itemView)) {
                    return viewHolderG0;
                }
                if (RecyclerView.F0) {
                    Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
                }
                return null;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void g(int i3, int i4) {
                RecyclerView.this.M0(i3, i4);
                RecyclerView.this.f51865n0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void h(int i3, int i4) {
                RecyclerView.this.O0(i3, i4, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f51865n0 = true;
                recyclerView.f51859k0.f51975d += i4;
            }

            void i(AdapterHelper.UpdateOp updateOp) {
                int i3 = updateOp.f51467a;
                if (i3 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.f51866o.W0(recyclerView, updateOp.f51468b, updateOp.f51470d);
                    return;
                }
                if (i3 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.f51866o.Z0(recyclerView2, updateOp.f51468b, updateOp.f51470d);
                } else if (i3 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.f51866o.b1(recyclerView3, updateOp.f51468b, updateOp.f51470d, updateOp.f51469c);
                } else {
                    if (i3 != 8) {
                        return;
                    }
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.f51866o.Y0(recyclerView4, updateOp.f51468b, updateOp.f51470d, 1);
                }
            }
        });
    }

    boolean y1(AccessibilityEvent accessibilityEvent) {
        if (!E0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? AccessibilityEventCompat.a(accessibilityEvent) : 0;
        this.C |= iA != 0 ? iA : 0;
        return true;
    }

    int z(int i3) {
        return y(i3, this.M, this.O, getHeight());
    }

    public void z1(int i3, int i4) {
        A1(i3, i4, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.f51440a);
    }

    void N0(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int iJ = this.f51850g.j();
        if (i3 < i4) {
            i7 = -1;
            i6 = i3;
            i5 = i4;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = 1;
        }
        for (int i9 = 0; i9 < iJ; i9++) {
            ViewHolder viewHolderN0 = n0(this.f51850g.i(i9));
            if (viewHolderN0 != null && (i8 = viewHolderN0.mPosition) >= i6 && i8 <= i5) {
                if (F0) {
                    Log.d("RecyclerView", tDEtWsFLJfe.ntmaFuRJybUeAWf + i9 + " holder " + viewHolderN0);
                }
                if (viewHolderN0.mPosition == i3) {
                    viewHolderN0.offsetPosition(i4 - i3, false);
                } else {
                    viewHolderN0.offsetPosition(i7, false);
                }
                this.f51859k0.f51978g = true;
            }
        }
        this.f51843c.w(i3, i4);
        requestLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f51956c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f51956c = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        void d(SavedState savedState) {
            this.f51956c = savedState.f51956c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f51956c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f51841b = new RecyclerViewDataObserver();
        this.f51843c = new Recycler();
        this.f51852h = new ViewInfoStore();
        this.f51856j = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.f51884x || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f51878u) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.A) {
                    recyclerView2.f51888z = true;
                } else {
                    recyclerView2.A();
                }
            }
        };
        this.f51858k = new Rect();
        this.f51860l = new Rect();
        this.f51862m = new RectF();
        this.f51870q = new ArrayList();
        this.f51872r = new ArrayList();
        this.f51874s = new ArrayList();
        this.f51886y = 0;
        this.G = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        this.K = Q0;
        this.P = new DefaultItemAnimator();
        this.Q = 0;
        this.R = -1;
        this.f51847e0 = Float.MIN_VALUE;
        this.f51849f0 = Float.MIN_VALUE;
        this.f51851g0 = true;
        this.f51853h0 = new ViewFlinger();
        this.f51857j0 = L0 ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.f51859k0 = new State();
        this.f51865n0 = false;
        this.f51867o0 = false;
        this.f51869p0 = new ItemAnimatorRestoreListener();
        this.f51871q0 = false;
        this.f51877t0 = new int[2];
        this.f51881v0 = new int[2];
        this.f51883w0 = new int[2];
        this.f51885x0 = new int[2];
        this.f51887y0 = new ArrayList();
        this.f51889z0 = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.P;
                if (itemAnimator != null) {
                    itemAnimator.v();
                }
                RecyclerView.this.f51871q0 = false;
            }
        };
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.o(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void b(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f51866o.r1(viewHolder.itemView, recyclerView.f51843c);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.f51843c.O(viewHolder);
                RecyclerView.this.q(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void d(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.G) {
                    if (recyclerView.P.b(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.X0();
                    }
                } else if (recyclerView.P.d(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.X0();
                }
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f51840a0 = viewConfiguration.getScaledTouchSlop();
        this.f51847e0 = ViewConfigurationCompat.e(viewConfiguration, context);
        this.f51849f0 = ViewConfigurationCompat.h(viewConfiguration, context);
        this.f51844c0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f51846d0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f51839a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.P.w(this.f51869p0);
        x0();
        z0();
        y0();
        if (ViewCompat.w(this) == 0) {
            ViewCompat.w0(this, 1);
        }
        this.E = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = androidx.recyclerview.R.styleable.f51446a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.f51455j);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.f51449d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f51854i = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.f51448c, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.f51450e, false);
        this.f51882w = z2;
        if (z2) {
            A0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.f51453h), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.f51454i), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.f51451f), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.f51452g));
        }
        typedArrayObtainStyledAttributes.recycle();
        B(context, string, attributeSet, i3, 0);
        int[] iArr2 = G0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i3, 0);
        ViewCompat.k0(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i3, 0);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
        PoolingContainer.h(this, true);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ViewHolder f51935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f51936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f51937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f51938d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f51936b = new Rect();
            this.f51937c = true;
            this.f51938d = false;
        }

        public int a() {
            return this.f51935a.getLayoutPosition();
        }

        public boolean b() {
            return this.f51935a.isUpdated();
        }

        public boolean c() {
            return this.f51935a.isRemoved();
        }

        public boolean d() {
            return this.f51935a.isInvalid();
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f51936b = new Rect();
            this.f51937c = true;
            this.f51938d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f51936b = new Rect();
            this.f51937c = true;
            this.f51938d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f51936b = new Rect();
            this.f51937c = true;
            this.f51938d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f51936b = new Rect();
            this.f51937c = true;
            this.f51938d = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.f51866o;
        if (layoutManager != null) {
            return layoutManager.L(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + V());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ItemAnimator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ItemAnimatorListener f51900a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList f51901b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f51902c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f51903d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f51904e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f51905f = 250;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface ItemAnimatorFinishedListener {
            void a();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        interface ItemAnimatorListener {
            void a(ViewHolder viewHolder);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class ItemHolderInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f51906a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f51907b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f51908c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f51909d;

            public ItemHolderInfo a(ViewHolder viewHolder) {
                return b(viewHolder, 0);
            }

            public ItemHolderInfo b(ViewHolder viewHolder, int i3) {
                View view = viewHolder.itemView;
                this.f51906a = view.getLeft();
                this.f51907b = view.getTop();
                this.f51908c = view.getRight();
                this.f51909d = view.getBottom();
                return this;
            }
        }

        static int e(ViewHolder viewHolder) {
            int i3 = viewHolder.mFlags;
            int i4 = i3 & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i3 & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                if (oldPosition != -1 && absoluteAdapterPosition != -1 && oldPosition != absoluteAdapterPosition) {
                    return i4 | 2048;
                }
            }
            return i4;
        }

        public abstract boolean a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean b(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean d(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean f(ViewHolder viewHolder) {
            return true;
        }

        public boolean g(ViewHolder viewHolder, List list) {
            return f(viewHolder);
        }

        public final void h(ViewHolder viewHolder) {
            s(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.f51900a;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.a(viewHolder);
            }
        }

        public final void i() {
            int size = this.f51901b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((ItemAnimatorFinishedListener) this.f51901b.get(i3)).a();
            }
            this.f51901b.clear();
        }

        public abstract void j(ViewHolder viewHolder);

        public abstract void k();

        public long l() {
            return this.f51902c;
        }

        public long m() {
            return this.f51905f;
        }

        public long n() {
            return this.f51904e;
        }

        public long o() {
            return this.f51903d;
        }

        public abstract boolean p();

        public final boolean q(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean zP = p();
            if (itemAnimatorFinishedListener != null) {
                if (!zP) {
                    itemAnimatorFinishedListener.a();
                    return zP;
                }
                this.f51901b.add(itemAnimatorFinishedListener);
            }
            return zP;
        }

        public ItemHolderInfo r() {
            return new ItemHolderInfo();
        }

        public ItemHolderInfo t(State state, ViewHolder viewHolder) {
            return r().a(viewHolder);
        }

        public ItemHolderInfo u(State state, ViewHolder viewHolder, int i3, List list) {
            return r().a(viewHolder);
        }

        public abstract void v();

        void w(ItemAnimatorListener itemAnimatorListener) {
            this.f51900a = itemAnimatorListener;
        }

        public void s(ViewHolder viewHolder) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class LayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ChildHelper f51911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView f51912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewBoundsCheck.Callback f51913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ViewBoundsCheck.Callback f51914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewBoundsCheck f51915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewBoundsCheck f51916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        SmoothScroller f51917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f51918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f51919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f51920j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f51921k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f51922l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f51923m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f51924n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f51925o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f51926p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f51927q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f51928r;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface LayoutPrefetchRegistry {
            void a(int i3, int i4);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Properties {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f51931a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f51932b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f51933c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f51934d;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View a(int i3) {
                    return LayoutManager.this.O(i3);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int b(View view) {
                    return LayoutManager.this.W(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int c() {
                    return LayoutManager.this.j0();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int d() {
                    return LayoutManager.this.t0() - LayoutManager.this.k0();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int e(View view) {
                    return LayoutManager.this.Z(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }
            };
            this.f51913c = callback;
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View a(int i3) {
                    return LayoutManager.this.O(i3);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int b(View view) {
                    return LayoutManager.this.a0(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int c() {
                    return LayoutManager.this.l0();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int d() {
                    return LayoutManager.this.c0() - LayoutManager.this.i0();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int e(View view) {
                    return LayoutManager.this.U(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }
            };
            this.f51914d = callback2;
            this.f51915e = new ViewBoundsCheck(callback);
            this.f51916f = new ViewBoundsCheck(callback2);
            this.f51918h = false;
            this.f51919i = false;
            this.f51920j = false;
            this.f51921k = true;
            this.f51922l = true;
        }

        private void A1(Recycler recycler, int i3, View view) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (viewHolderN0.shouldIgnore()) {
                if (RecyclerView.F0) {
                    Log.d("RecyclerView", "ignoring view " + viewHolderN0);
                    return;
                }
                return;
            }
            if (viewHolderN0.isInvalid() && !viewHolderN0.isRemoved() && !this.f51912b.f51864n.hasStableIds()) {
                v1(i3);
                recycler.H(viewHolderN0);
            } else {
                D(i3);
                recycler.I(view);
                this.f51912b.f51852h.k(viewHolderN0);
            }
        }

        private static boolean B0(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (i5 > 0 && i3 != i5) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i3;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i3;
            }
            return true;
        }

        private void E(int i3, View view) {
            this.f51911a.d(i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int Q(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.Q(int, int, int, int, boolean):int");
        }

        private int[] R(View view, Rect rect) {
            int iJ0 = j0();
            int iL0 = l0();
            int iT0 = t0() - k0();
            int iC0 = c0() - i0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i3 = left - iJ0;
            int iMin = Math.min(0, i3);
            int i4 = top - iL0;
            int iMin2 = Math.min(0, i4);
            int i5 = iWidth - iT0;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, iHeight - iC0);
            if (e0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i3, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i5);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i4, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        private void l(View view, int i3, boolean z2) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (z2 || viewHolderN0.isRemoved()) {
                this.f51912b.f51852h.b(viewHolderN0);
            } else {
                this.f51912b.f51852h.p(viewHolderN0);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (viewHolderN0.wasReturnedFromScrap() || viewHolderN0.isScrap()) {
                if (viewHolderN0.isScrap()) {
                    viewHolderN0.unScrap();
                } else {
                    viewHolderN0.clearReturnedFromScrapFlag();
                }
                this.f51911a.c(view, i3, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f51912b) {
                int iM = this.f51911a.m(view);
                if (i3 == -1) {
                    i3 = this.f51911a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f51912b.indexOfChild(view) + this.f51912b.V());
                }
                if (iM != i3) {
                    this.f51912b.f51866o.G0(iM, i3);
                }
            } else {
                this.f51911a.a(view, i3, false);
                layoutParams.f51937c = true;
                SmoothScroller smoothScroller = this.f51917g;
                if (smoothScroller != null && smoothScroller.h()) {
                    this.f51917g.k(view);
                }
            }
            if (layoutParams.f51938d) {
                if (RecyclerView.F0) {
                    Log.d("RecyclerView", "consuming pending invalidate on child " + layoutParams.f51935a);
                }
                viewHolderN0.itemView.invalidate();
                layoutParams.f51938d = false;
            }
        }

        public static Properties n0(Context context, AttributeSet attributeSet, int i3, int i4) {
            Properties properties = new Properties();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.f51446a, i3, i4);
            properties.f51931a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.f51447b, 1);
            properties.f51932b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.f51457l, 1);
            properties.f51933c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.f51456k, false);
            properties.f51934d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.f51458m, false);
            typedArrayObtainStyledAttributes.recycle();
            return properties;
        }

        public static int t(int i3, int i4, int i5) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i4, i5) : size : Math.min(size, Math.max(i4, i5));
        }

        private boolean y0(RecyclerView recyclerView, int i3, int i4) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iJ0 = j0();
            int iL0 = l0();
            int iT0 = t0() - k0();
            int iC0 = c0() - i0();
            Rect rect = this.f51912b.f51858k;
            V(focusedChild, rect);
            return rect.left - i3 < iT0 && rect.right - i3 > iJ0 && rect.top - i4 < iC0 && rect.bottom - i4 > iL0;
        }

        public int A(State state) {
            return 0;
        }

        public boolean A0(Recycler recycler, State state) {
            return false;
        }

        public int B(State state) {
            return 0;
        }

        public int B1(int i3, Recycler recycler, State state) {
            return 0;
        }

        public void C(Recycler recycler) {
            for (int iP = P() - 1; iP >= 0; iP--) {
                A1(recycler, iP, O(iP));
            }
        }

        public boolean C0() {
            SmoothScroller smoothScroller = this.f51917g;
            return smoothScroller != null && smoothScroller.h();
        }

        public void C1(int i3) {
            if (RecyclerView.F0) {
                Log.e("RecyclerView", "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        public void D(int i3) {
            E(i3, O(i3));
        }

        public boolean D0(View view, boolean z2, boolean z3) {
            boolean z4 = this.f51915e.b(view, 24579) && this.f51916f.b(view, 24579);
            return z2 ? z4 : !z4;
        }

        public int D1(int i3, Recycler recycler, State state) {
            return 0;
        }

        public void E0(View view, int i3, int i4, int i5, int i6) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f51936b;
            view.layout(i3 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i4 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i5 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i6 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        void E1(RecyclerView recyclerView) {
            F1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void F(RecyclerView recyclerView) {
            this.f51919i = true;
            L0(recyclerView);
        }

        public void F0(View view, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rectS0 = this.f51912b.s0(view);
            int i5 = i3 + rectS0.left + rectS0.right;
            int i6 = i4 + rectS0.top + rectS0.bottom;
            int iQ = Q(t0(), u0(), j0() + k0() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, q());
            int iQ2 = Q(c0(), d0(), l0() + i0() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i6, ((ViewGroup.MarginLayoutParams) layoutParams).height, r());
            if (K1(view, iQ, iQ2, layoutParams)) {
                view.measure(iQ, iQ2);
            }
        }

        void F1(int i3, int i4) {
            this.f51927q = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            this.f51925o = mode;
            if (mode == 0 && !RecyclerView.J0) {
                this.f51927q = 0;
            }
            this.f51928r = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i4);
            this.f51926p = mode2;
            if (mode2 != 0 || RecyclerView.J0) {
                return;
            }
            this.f51928r = 0;
        }

        void G(RecyclerView recyclerView, Recycler recycler) {
            this.f51919i = false;
            N0(recyclerView, recycler);
        }

        public void G0(int i3, int i4) {
            View viewO = O(i3);
            if (viewO != null) {
                D(i3);
                n(viewO, i4);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i3 + this.f51912b.toString());
            }
        }

        public void G1(int i3, int i4) {
            this.f51912b.setMeasuredDimension(i3, i4);
        }

        public View H(View view) {
            View viewY;
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView == null || (viewY = recyclerView.Y(view)) == null || this.f51911a.n(viewY)) {
                return null;
            }
            return viewY;
        }

        public void H0(int i3) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                recyclerView.K0(i3);
            }
        }

        public void H1(Rect rect, int i3, int i4) {
            G1(t(i3, rect.width() + j0() + k0(), h0()), t(i4, rect.height() + l0() + i0(), g0()));
        }

        public View I(int i3) {
            int iP = P();
            for (int i4 = 0; i4 < iP; i4++) {
                View viewO = O(i4);
                ViewHolder viewHolderN0 = RecyclerView.n0(viewO);
                if (viewHolderN0 != null && viewHolderN0.getLayoutPosition() == i3 && !viewHolderN0.shouldIgnore() && (this.f51912b.f51859k0.e() || !viewHolderN0.isRemoved())) {
                    return viewO;
                }
            }
            return null;
        }

        public void I0(int i3) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                recyclerView.L0(i3);
            }
        }

        void I1(int i3, int i4) {
            int iP = P();
            if (iP == 0) {
                this.f51912b.C(i3, i4);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MAX_VALUE;
            for (int i9 = 0; i9 < iP; i9++) {
                View viewO = O(i9);
                Rect rect = this.f51912b.f51858k;
                V(viewO, rect);
                int i10 = rect.left;
                if (i10 < i8) {
                    i8 = i10;
                }
                int i11 = rect.right;
                if (i11 > i5) {
                    i5 = i11;
                }
                int i12 = rect.top;
                if (i12 < i6) {
                    i6 = i12;
                }
                int i13 = rect.bottom;
                if (i13 > i7) {
                    i7 = i13;
                }
            }
            this.f51912b.f51858k.set(i8, i6, i5, i7);
            H1(this.f51912b.f51858k, i3, i4);
        }

        public abstract LayoutParams J();

        void J1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f51912b = null;
                this.f51911a = null;
                this.f51927q = 0;
                this.f51928r = 0;
            } else {
                this.f51912b = recyclerView;
                this.f51911a = recyclerView.f51850g;
                this.f51927q = recyclerView.getWidth();
                this.f51928r = recyclerView.getHeight();
            }
            this.f51925o = 1073741824;
            this.f51926p = 1073741824;
        }

        public LayoutParams K(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public boolean K0(RecyclerView recyclerView, ArrayList arrayList, int i3, int i4) {
            return false;
        }

        boolean K1(View view, int i3, int i4, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.f51921k && B0(view.getWidth(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width) && B0(view.getHeight(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public LayoutParams L(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        boolean L1() {
            return false;
        }

        public int M() {
            return -1;
        }

        boolean M1(View view, int i3, int i4, LayoutParams layoutParams) {
            return (this.f51921k && B0(view.getMeasuredWidth(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width) && B0(view.getMeasuredHeight(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public int N(View view) {
            return ((LayoutParams) view.getLayoutParams()).f51936b.bottom;
        }

        public void N0(RecyclerView recyclerView, Recycler recycler) {
            M0(recyclerView);
        }

        public void N1(RecyclerView recyclerView, State state, int i3) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public View O(int i3) {
            ChildHelper childHelper = this.f51911a;
            if (childHelper != null) {
                return childHelper.f(i3);
            }
            return null;
        }

        public View O0(View view, int i3, Recycler recycler, State state) {
            return null;
        }

        public void O1(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f51917g;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.h()) {
                this.f51917g.r();
            }
            this.f51917g = smoothScroller;
            smoothScroller.q(this.f51912b, this);
        }

        public int P() {
            ChildHelper childHelper = this.f51911a;
            if (childHelper != null) {
                return childHelper.g();
            }
            return 0;
        }

        public void P0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f51912b;
            Q0(recyclerView.f51843c, recyclerView.f51859k0, accessibilityEvent);
        }

        void P1() {
            SmoothScroller smoothScroller = this.f51917g;
            if (smoothScroller != null) {
                smoothScroller.r();
            }
        }

        public void Q0(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z2 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f51912b.canScrollVertically(-1) && !this.f51912b.canScrollHorizontally(-1) && !this.f51912b.canScrollHorizontally(1)) {
                z2 = false;
            }
            accessibilityEvent.setScrollable(z2);
            Adapter adapter = this.f51912b.f51864n;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public boolean Q1() {
            return false;
        }

        void R0(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f51912b;
            S0(recyclerView.f51843c, recyclerView.f51859k0, accessibilityNodeInfoCompat);
        }

        public boolean S() {
            RecyclerView recyclerView = this.f51912b;
            return recyclerView != null && recyclerView.f51854i;
        }

        public void S0(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f51912b.canScrollVertically(-1) || this.f51912b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                accessibilityNodeInfoCompat.K0(true);
            }
            if (this.f51912b.canScrollVertically(1) || this.f51912b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.K0(true);
            }
            accessibilityNodeInfoCompat.k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(p0(recycler, state), T(recycler, state), A0(recycler, state), q0(recycler, state)));
        }

        public int T(Recycler recycler, State state) {
            return -1;
        }

        void T0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (viewHolderN0 == null || viewHolderN0.isRemoved() || this.f51911a.n(viewHolderN0.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.f51912b;
            U0(recyclerView.f51843c, recyclerView.f51859k0, view, accessibilityNodeInfoCompat);
        }

        public int U(View view) {
            return view.getBottom() + N(view);
        }

        public void V(View view, Rect rect) {
            RecyclerView.p0(view, rect);
        }

        public View V0(View view, int i3) {
            return null;
        }

        public int W(View view) {
            return view.getLeft() - f0(view);
        }

        public int X(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f51936b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int Y(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f51936b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int Z(View view) {
            return view.getRight() + o0(view);
        }

        public int a() {
            RecyclerView recyclerView = this.f51912b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int a0(View view) {
            return view.getTop() - r0(view);
        }

        public View b0() {
            View focusedChild;
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f51911a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void b1(RecyclerView recyclerView, int i3, int i4, Object obj) {
            a1(recyclerView, i3, i4);
        }

        public int c0() {
            return this.f51928r;
        }

        public void c1(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int d0() {
            return this.f51926p;
        }

        public int e0() {
            return ViewCompat.y(this.f51912b);
        }

        public void e1(Recycler recycler, State state, int i3, int i4) {
            this.f51912b.C(i3, i4);
        }

        public int f0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f51936b.left;
        }

        public boolean f1(RecyclerView recyclerView, View view, View view2) {
            return C0() || recyclerView.E0();
        }

        public int g0() {
            return ViewCompat.z(this.f51912b);
        }

        public boolean g1(RecyclerView recyclerView, State state, View view, View view2) {
            return f1(recyclerView, view, view2);
        }

        public void h(View view) {
            i(view, -1);
        }

        public int h0() {
            return ViewCompat.A(this.f51912b);
        }

        public void i(View view, int i3) {
            l(view, i3, true);
        }

        public int i0() {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable i1() {
            return null;
        }

        public void j(View view) {
            k(view, -1);
        }

        public int j0() {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void k(View view, int i3) {
            l(view, i3, false);
        }

        public int k0() {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void k1(SmoothScroller smoothScroller) {
            if (this.f51917g == smoothScroller) {
                this.f51917g = null;
            }
        }

        public int l0() {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        boolean l1(int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f51912b;
            return m1(recyclerView.f51843c, recyclerView.f51859k0, i3, bundle);
        }

        public void m(String str) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                recyclerView.r(str);
            }
        }

        public int m0(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        public boolean m1(Recycler recycler, State state, int i3, Bundle bundle) {
            int iL0;
            int iJ0;
            int i4;
            int i5;
            if (this.f51912b == null) {
                return false;
            }
            int iC0 = c0();
            int iT0 = t0();
            Rect rect = new Rect();
            if (this.f51912b.getMatrix().isIdentity() && this.f51912b.getGlobalVisibleRect(rect)) {
                iC0 = rect.height();
                iT0 = rect.width();
            }
            if (i3 == 4096) {
                iL0 = this.f51912b.canScrollVertically(1) ? (iC0 - l0()) - i0() : 0;
                if (this.f51912b.canScrollHorizontally(1)) {
                    iJ0 = (iT0 - j0()) - k0();
                    i4 = iL0;
                    i5 = iJ0;
                }
                i4 = iL0;
                i5 = 0;
            } else if (i3 != 8192) {
                i5 = 0;
                i4 = 0;
            } else {
                iL0 = this.f51912b.canScrollVertically(-1) ? -((iC0 - l0()) - i0()) : 0;
                if (this.f51912b.canScrollHorizontally(-1)) {
                    iJ0 = -((iT0 - j0()) - k0());
                    i4 = iL0;
                    i5 = iJ0;
                }
                i4 = iL0;
                i5 = 0;
            }
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            this.f51912b.C1(i5, i4, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void n(View view, int i3) {
            o(view, i3, (LayoutParams) view.getLayoutParams());
        }

        boolean n1(View view, int i3, Bundle bundle) {
            RecyclerView recyclerView = this.f51912b;
            return o1(recyclerView.f51843c, recyclerView.f51859k0, view, i3, bundle);
        }

        public void o(View view, int i3, LayoutParams layoutParams) {
            ViewHolder viewHolderN0 = RecyclerView.n0(view);
            if (viewHolderN0.isRemoved()) {
                this.f51912b.f51852h.b(viewHolderN0);
            } else {
                this.f51912b.f51852h.p(viewHolderN0);
            }
            this.f51911a.c(view, i3, layoutParams, viewHolderN0.isRemoved());
        }

        public int o0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f51936b.right;
        }

        public boolean o1(Recycler recycler, State state, View view, int i3, Bundle bundle) {
            return false;
        }

        public void p(View view, Rect rect) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.s0(view));
            }
        }

        public int p0(Recycler recycler, State state) {
            return -1;
        }

        public void p1(Recycler recycler) {
            for (int iP = P() - 1; iP >= 0; iP--) {
                if (!RecyclerView.n0(O(iP)).shouldIgnore()) {
                    s1(iP, recycler);
                }
            }
        }

        public boolean q() {
            return false;
        }

        public int q0(Recycler recycler, State state) {
            return 0;
        }

        void q1(Recycler recycler) {
            int iJ = recycler.j();
            for (int i3 = iJ - 1; i3 >= 0; i3--) {
                View viewN = recycler.n(i3);
                ViewHolder viewHolderN0 = RecyclerView.n0(viewN);
                if (!viewHolderN0.shouldIgnore()) {
                    viewHolderN0.setIsRecyclable(false);
                    if (viewHolderN0.isTmpDetached()) {
                        this.f51912b.removeDetachedView(viewN, false);
                    }
                    ItemAnimator itemAnimator = this.f51912b.P;
                    if (itemAnimator != null) {
                        itemAnimator.j(viewHolderN0);
                    }
                    viewHolderN0.setIsRecyclable(true);
                    recycler.D(viewN);
                }
            }
            recycler.e();
            if (iJ > 0) {
                this.f51912b.invalidate();
            }
        }

        public boolean r() {
            return false;
        }

        public int r0(View view) {
            return ((LayoutParams) view.getLayoutParams()).f51936b.top;
        }

        public void r1(View view, Recycler recycler) {
            u1(view);
            recycler.G(view);
        }

        public boolean s(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void s0(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f51936b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f51912b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f51912b.f51862m;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void s1(int i3, Recycler recycler) {
            View viewO = O(i3);
            v1(i3);
            recycler.G(viewO);
        }

        public int t0() {
            return this.f51927q;
        }

        public boolean t1(Runnable runnable) {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int u0() {
            return this.f51925o;
        }

        public void u1(View view) {
            this.f51911a.p(view);
        }

        boolean v0() {
            int iP = P();
            for (int i3 = 0; i3 < iP; i3++) {
                ViewGroup.LayoutParams layoutParams = O(i3).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void v1(int i3) {
            if (O(i3) != null) {
                this.f51911a.q(i3);
            }
        }

        public int w(State state) {
            return 0;
        }

        public boolean w0() {
            return this.f51919i;
        }

        public boolean w1(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return x1(recyclerView, view, rect, z2, false);
        }

        public int x(State state) {
            return 0;
        }

        public boolean x0() {
            return this.f51920j;
        }

        public boolean x1(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] iArrR = R(view, rect);
            int i3 = iArrR[0];
            int i4 = iArrR[1];
            if ((z3 && !y0(recyclerView, i3, i4)) || (i3 == 0 && i4 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i3, i4);
            } else {
                recyclerView.z1(i3, i4);
            }
            return true;
        }

        public int y(State state) {
            return 0;
        }

        public void y1() {
            RecyclerView recyclerView = this.f51912b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int z(State state) {
            return 0;
        }

        public final boolean z0() {
            return this.f51922l;
        }

        public void z1() {
            this.f51918h = true;
        }

        public void L0(RecyclerView recyclerView) {
        }

        public void M0(RecyclerView recyclerView) {
        }

        public void X0(RecyclerView recyclerView) {
        }

        public void d1(State state) {
        }

        public void h1(Parcelable parcelable) {
        }

        public void j1(int i3) {
        }

        public void J0(Adapter adapter, Adapter adapter2) {
        }

        public void v(int i3, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void W0(RecyclerView recyclerView, int i3, int i4) {
        }

        public void Z0(RecyclerView recyclerView, int i3, int i4) {
        }

        public void a1(RecyclerView recyclerView, int i3, int i4) {
        }

        public void U0(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void Y0(RecyclerView recyclerView, int i3, int i4, int i5) {
        }

        public void u(int i3, int i4, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void e(boolean z2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class ItemDecoration {
        public void f(Rect rect, int i3, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, State state) {
            f(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }

        public void i(Canvas canvas, RecyclerView recyclerView, State state) {
            h(canvas, recyclerView);
        }

        public void k(Canvas canvas, RecyclerView recyclerView, State state) {
            j(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class OnScrollListener {
        public void a(RecyclerView recyclerView, int i3) {
        }

        public void b(RecyclerView recyclerView, int i3, int i4) {
        }
    }
}
