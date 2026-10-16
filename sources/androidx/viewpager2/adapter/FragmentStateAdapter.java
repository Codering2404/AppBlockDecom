package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Lifecycle f53794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final FragmentManager f53795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final LongSparseArray f53796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LongSparseArray f53797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LongSparseArray f53798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f53799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    FragmentEventDispatcher f53800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f53801p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f53802q;

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
    public @interface ExperimentalFragmentStateAdapterApi {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FragmentEventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f53812a = new CopyOnWriteArrayList();

        FragmentEventDispatcher() {
        }

        public List a(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f53812a.iterator();
            while (it.hasNext()) {
                arrayList.add(((FragmentTransactionCallback) it.next()).a(fragment, state));
            }
            return arrayList;
        }

        public void b(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((FragmentTransactionCallback.OnPostEventListener) it.next()).a();
            }
        }

        public List c(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f53812a.iterator();
            while (it.hasNext()) {
                arrayList.add(((FragmentTransactionCallback) it.next()).b(fragment));
            }
            return arrayList;
        }

        public List d(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f53812a.iterator();
            while (it.hasNext()) {
                arrayList.add(((FragmentTransactionCallback) it.next()).c(fragment));
            }
            return arrayList;
        }

        public List e(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f53812a.iterator();
            while (it.hasNext()) {
                arrayList.add(((FragmentTransactionCallback) it.next()).d(fragment));
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class FragmentMaxLifecycleEnforcer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f53813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f53814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LifecycleEventObserver f53815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ViewPager2 f53816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f53817e = -1;

        FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(RecyclerView recyclerView) {
            this.f53816d = a(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void a(int i3) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void c(int i3) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f53813a = onPageChangeCallback;
            this.f53816d.g(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.d(true);
                }
            };
            this.f53814b = dataSetChangeObserver;
            FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f53815c = lifecycleEventObserver;
            FragmentStateAdapter.this.f53794i.addObserver(lifecycleEventObserver);
        }

        void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.f53813a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f53814b);
            FragmentStateAdapter.this.f53794i.removeObserver(this.f53815c);
            this.f53816d = null;
        }

        void d(boolean z2) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.z() || this.f53816d.getScrollState() != 0 || FragmentStateAdapter.this.f53796k.j() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.f53816d.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f53817e || z2) && (fragment = (Fragment) FragmentStateAdapter.this.f53796k.g(itemId)) != null && fragment.isAdded()) {
                this.f53817e = itemId;
                FragmentTransaction fragmentTransactionQ = FragmentStateAdapter.this.f53795j.q();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                Fragment fragment2 = null;
                for (int i4 = 0; i4 < FragmentStateAdapter.this.f53796k.r(); i4++) {
                    long jK = FragmentStateAdapter.this.f53796k.k(i4);
                    Fragment fragment3 = (Fragment) FragmentStateAdapter.this.f53796k.s(i4);
                    if (fragment3.isAdded()) {
                        if (jK != this.f53817e) {
                            Lifecycle.State state = Lifecycle.State.f39950d;
                            fragmentTransactionQ.v(fragment3, state);
                            arrayList.add(FragmentStateAdapter.this.f53800o.a(fragment3, state));
                        } else {
                            fragment2 = fragment3;
                        }
                        fragment3.setMenuVisibility(jK == this.f53817e);
                    }
                }
                if (fragment2 != null) {
                    Lifecycle.State state2 = Lifecycle.State.f39951f;
                    fragmentTransactionQ.v(fragment2, state2);
                    arrayList.add(FragmentStateAdapter.this.f53800o.a(fragment2, state2));
                }
                if (fragmentTransactionQ.q()) {
                    return;
                }
                fragmentTransactionQ.l();
                Collections.reverse(arrayList);
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    FragmentStateAdapter.this.f53800o.b((List) obj);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class FragmentTransactionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final OnPostEventListener f53822a = new OnPostEventListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentTransactionCallback.1
            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.FragmentTransactionCallback.OnPostEventListener
            public void a() {
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface OnPostEventListener {
            void a();
        }

        public OnPostEventListener a(Fragment fragment, Lifecycle.State state) {
            return f53822a;
        }

        public OnPostEventListener b(Fragment fragment) {
            return f53822a;
        }

        public OnPostEventListener c(Fragment fragment) {
            return f53822a;
        }

        public OnPostEventListener d(Fragment fragment) {
            return f53822a;
        }
    }

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    private static String j(String str, long j3) {
        return str + j3;
    }

    private void k(int i3) {
        long itemId = getItemId(i3);
        if (this.f53796k.e(itemId)) {
            return;
        }
        Fragment fragmentI = i(i3);
        fragmentI.setInitialSavedState((Fragment.SavedState) this.f53797l.g(itemId));
        this.f53796k.m(itemId, fragmentI);
    }

    private boolean m(long j3) {
        View view;
        if (this.f53798m.e(j3)) {
            return true;
        }
        Fragment fragment = (Fragment) this.f53796k.g(j3);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean n(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long o(int i3) {
        Long lValueOf = null;
        for (int i4 = 0; i4 < this.f53798m.r(); i4++) {
            if (((Integer) this.f53798m.s(i4)).intValue() == i3) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f53798m.k(i4));
            }
        }
        return lValueOf;
    }

    private static long u(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void w(long j3) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.f53796k.g(j3);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!h(j3)) {
            this.f53797l.p(j3);
        }
        if (!fragment.isAdded()) {
            this.f53796k.p(j3);
            return;
        }
        if (z()) {
            this.f53802q = true;
            return;
        }
        if (fragment.isAdded() && h(j3)) {
            List listE = this.f53800o.e(fragment);
            Fragment.SavedState savedStateA1 = this.f53795j.A1(fragment);
            this.f53800o.b(listE);
            this.f53797l.m(j3, savedStateA1);
        }
        List listD = this.f53800o.d(fragment);
        try {
            this.f53795j.q().r(fragment).l();
            this.f53796k.p(j3);
        } finally {
            this.f53800o.b(listD);
        }
    }

    private void x() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f53801p = false;
                fragmentStateAdapter.l();
            }
        };
        this.f53794i.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    private void y(final Fragment fragment, final FrameLayout frameLayout) {
        this.f53795j.o1(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void m(FragmentManager fragmentManager, Fragment fragment2, View view, Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.M1(this);
                    FragmentStateAdapter.this.g(view, frameLayout);
                }
            }
        }, false);
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f53796k.r() + this.f53797l.r());
        for (int i3 = 0; i3 < this.f53796k.r(); i3++) {
            long jK = this.f53796k.k(i3);
            Fragment fragment = (Fragment) this.f53796k.g(jK);
            if (fragment != null && fragment.isAdded()) {
                this.f53795j.n1(bundle, j("f#", jK), fragment);
            }
        }
        for (int i4 = 0; i4 < this.f53797l.r(); i4++) {
            long jK2 = this.f53797l.k(i4);
            if (h(jK2)) {
                bundle.putParcelable(j("s#", jK2), (Parcelable) this.f53797l.g(jK2));
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void e(Parcelable parcelable) {
        if (!this.f53797l.j() || !this.f53796k.j()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (n(str, "f#")) {
                this.f53796k.m(u(str, "f#"), this.f53795j.z0(bundle, str));
            } else {
                if (!n(str, "s#")) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jU = u(str, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (h(jU)) {
                    this.f53797l.m(jU, savedState);
                }
            }
        }
        if (this.f53796k.j()) {
            return;
        }
        this.f53802q = true;
        this.f53801p = true;
        l();
        x();
    }

    void g(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public boolean h(long j3) {
        return j3 >= 0 && j3 < ((long) getItemCount());
    }

    public abstract Fragment i(int i3);

    void l() {
        if (!this.f53802q || z()) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        for (int i3 = 0; i3 < this.f53796k.r(); i3++) {
            long jK = this.f53796k.k(i3);
            if (!h(jK)) {
                arraySet.add(Long.valueOf(jK));
                this.f53798m.p(jK);
            }
        }
        if (!this.f53801p) {
            this.f53802q = false;
            for (int i4 = 0; i4 < this.f53796k.r(); i4++) {
                long jK2 = this.f53796k.k(i4);
                if (!m(jK2)) {
                    arraySet.add(Long.valueOf(jK2));
                }
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            w(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Preconditions.a(this.f53799n == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f53799n = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f53799n.c(recyclerView);
        this.f53799n = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int i3) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.c().getId();
        Long lO = o(id);
        if (lO != null && lO.longValue() != itemId) {
            w(lO.longValue());
            this.f53798m.p(lO.longValue());
        }
        this.f53798m.m(itemId, Integer.valueOf(id));
        k(i3);
        if (fragmentViewHolder.c().isAttachedToWindow()) {
            v(fragmentViewHolder);
        }
        l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return FragmentViewHolder.b(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        v(fragmentViewHolder);
        l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long lO = o(fragmentViewHolder.c().getId());
        if (lO != null) {
            w(lO.longValue());
            this.f53798m.p(lO.longValue());
        }
    }

    void v(final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = (Fragment) this.f53796k.g(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutC = fragmentViewHolder.c();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            y(fragment, frameLayoutC);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayoutC) {
                g(view, frameLayoutC);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            g(view, frameLayoutC);
            return;
        }
        if (z()) {
            if (this.f53795j.Q0()) {
                return;
            }
            this.f53794i.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.z()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (fragmentViewHolder.c().isAttachedToWindow()) {
                        FragmentStateAdapter.this.v(fragmentViewHolder);
                    }
                }
            });
            return;
        }
        y(fragment, frameLayoutC);
        List listC = this.f53800o.c(fragment);
        try {
            fragment.setMenuVisibility(false);
            this.f53795j.q().e(fragment, "f" + fragmentViewHolder.getItemId()).v(fragment, Lifecycle.State.f39950d).l();
            this.f53799n.d(false);
        } finally {
            this.f53800o.b(listC);
        }
    }

    boolean z() {
        return this.f53795j.Y0();
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.f53796k = new LongSparseArray();
        this.f53797l = new LongSparseArray();
        this.f53798m = new LongSparseArray();
        this.f53800o = new FragmentEventDispatcher();
        this.f53801p = false;
        this.f53802q = false;
        this.f53795j = fragmentManager;
        this.f53794i = lifecycle;
        super.setHasStableIds(true);
    }
}
