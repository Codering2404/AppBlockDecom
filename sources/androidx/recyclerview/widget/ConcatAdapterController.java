package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ConcatAdapterController implements NestedAdapterWrapper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcatAdapter f51541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewTypeStorage f51542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f51543c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IdentityHashMap f51544d = new IdentityHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f51545e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WrapperAndLocalPosition f51546f = new WrapperAndLocalPosition();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConcatAdapter.Config.StableIdMode f51547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StableIdStorage f51548h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WrapperAndLocalPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        NestedAdapterWrapper f51549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f51551c;

        WrapperAndLocalPosition() {
        }
    }

    ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.f51541a = concatAdapter;
        if (config.f51535a) {
            this.f51542b = new ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.f51542b = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.f51536b;
        this.f51547g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.f51548h = new StableIdStorage.NoStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.f51548h = new StableIdStorage.IsolatedStableIdStorage();
        } else {
            if (stableIdMode != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.f51548h = new StableIdStorage.SharedPoolStableIdStorage();
        }
    }

    private void E(WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.f51551c = false;
        wrapperAndLocalPosition.f51549a = null;
        wrapperAndLocalPosition.f51550b = -1;
        this.f51546f = wrapperAndLocalPosition;
    }

    private void i() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicyJ = j();
        if (stateRestorationPolicyJ != this.f51541a.getStateRestorationPolicy()) {
            this.f51541a.j(stateRestorationPolicyJ);
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy j() {
        for (NestedAdapterWrapper nestedAdapterWrapper : this.f51545e) {
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = nestedAdapterWrapper.f51822c.getStateRestorationPolicy();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2 || (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && nestedAdapterWrapper.b() == 0)) {
                return stateRestorationPolicy2;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int k(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper nestedAdapterWrapper2;
        Iterator it = this.f51545e.iterator();
        int iB = 0;
        while (it.hasNext() && (nestedAdapterWrapper2 = (NestedAdapterWrapper) it.next()) != nestedAdapterWrapper) {
            iB += nestedAdapterWrapper2.b();
        }
        return iB;
    }

    private WrapperAndLocalPosition l(int i3) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.f51546f;
        if (wrapperAndLocalPosition.f51551c) {
            wrapperAndLocalPosition = new WrapperAndLocalPosition();
        } else {
            wrapperAndLocalPosition.f51551c = true;
        }
        Iterator it = this.f51545e.iterator();
        int iB = i3;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) it.next();
            if (nestedAdapterWrapper.b() > iB) {
                wrapperAndLocalPosition.f51549a = nestedAdapterWrapper;
                wrapperAndLocalPosition.f51550b = iB;
                break;
            }
            iB -= nestedAdapterWrapper.b();
        }
        if (wrapperAndLocalPosition.f51549a != null) {
            return wrapperAndLocalPosition;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i3);
    }

    private NestedAdapterWrapper m(RecyclerView.Adapter adapter) {
        int iU = u(adapter);
        if (iU == -1) {
            return null;
        }
        return (NestedAdapterWrapper) this.f51545e.get(iU);
    }

    private NestedAdapterWrapper s(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f51544d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int u(RecyclerView.Adapter adapter) {
        int size = this.f51545e.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((NestedAdapterWrapper) this.f51545e.get(i3)).f51822c == adapter) {
                return i3;
            }
        }
        return -1;
    }

    private boolean v(RecyclerView recyclerView) {
        Iterator it = this.f51543c.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public boolean A(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f51544d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            boolean zOnFailedToRecycleView = nestedAdapterWrapper.f51822c.onFailedToRecycleView(viewHolder);
            this.f51544d.remove(viewHolder);
            return zOnFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    public void B(RecyclerView.ViewHolder viewHolder) {
        s(viewHolder).f51822c.onViewAttachedToWindow(viewHolder);
    }

    public void C(RecyclerView.ViewHolder viewHolder) {
        s(viewHolder).f51822c.onViewDetachedFromWindow(viewHolder);
    }

    public void D(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f51544d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            nestedAdapterWrapper.f51822c.onViewRecycled(viewHolder);
            this.f51544d.remove(viewHolder);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    boolean F(RecyclerView.Adapter adapter) {
        int iU = u(adapter);
        if (iU == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f51545e.get(iU);
        int iK = k(nestedAdapterWrapper);
        this.f51545e.remove(iU);
        this.f51541a.notifyItemRangeRemoved(iK, nestedAdapterWrapper.b());
        Iterator it = this.f51543c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.a();
        i();
        return true;
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void a(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4, Object obj) {
        this.f51541a.notifyItemRangeChanged(i3 + k(nestedAdapterWrapper), i4, obj);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void b(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4) {
        this.f51541a.notifyItemRangeInserted(i3 + k(nestedAdapterWrapper), i4);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void c(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4) {
        int iK = k(nestedAdapterWrapper);
        this.f51541a.notifyItemMoved(i3 + iK, i4 + iK);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void d(NestedAdapterWrapper nestedAdapterWrapper) {
        i();
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void e(NestedAdapterWrapper nestedAdapterWrapper) {
        this.f51541a.notifyDataSetChanged();
        i();
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void f(NestedAdapterWrapper nestedAdapterWrapper, int i3, int i4) {
        this.f51541a.notifyItemRangeRemoved(i3 + k(nestedAdapterWrapper), i4);
    }

    boolean g(int i3, RecyclerView.Adapter adapter) {
        if (i3 < 0 || i3 > this.f51545e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f51545e.size() + ". Given:" + i3);
        }
        if (t()) {
            Preconditions.b(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (m(adapter) != null) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(adapter, this, this.f51542b, this.f51548h.a());
        this.f51545e.add(i3, nestedAdapterWrapper);
        Iterator it = this.f51543c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (nestedAdapterWrapper.b() > 0) {
            this.f51541a.notifyItemRangeInserted(k(nestedAdapterWrapper), nestedAdapterWrapper.b());
        }
        i();
        return true;
    }

    boolean h(RecyclerView.Adapter adapter) {
        return g(this.f51545e.size(), adapter);
    }

    public List n() {
        if (this.f51545e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.f51545e.size());
        Iterator it = this.f51545e.iterator();
        while (it.hasNext()) {
            arrayList.add(((NestedAdapterWrapper) it.next()).f51822c);
        }
        return arrayList;
    }

    public long o(int i3) {
        WrapperAndLocalPosition wrapperAndLocalPositionL = l(i3);
        long jC = wrapperAndLocalPositionL.f51549a.c(wrapperAndLocalPositionL.f51550b);
        E(wrapperAndLocalPositionL);
        return jC;
    }

    public int p(int i3) {
        WrapperAndLocalPosition wrapperAndLocalPositionL = l(i3);
        int iD = wrapperAndLocalPositionL.f51549a.d(wrapperAndLocalPositionL.f51550b);
        E(wrapperAndLocalPositionL);
        return iD;
    }

    public int q(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i3) {
        NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f51544d.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int iK = i3 - k(nestedAdapterWrapper);
        int itemCount = nestedAdapterWrapper.f51822c.getItemCount();
        if (iK >= 0 && iK < itemCount) {
            return nestedAdapterWrapper.f51822c.findRelativeAdapterPositionIn(adapter, viewHolder, iK);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + iK + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + viewHolder + "adapter:" + adapter);
    }

    public int r() {
        Iterator it = this.f51545e.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB += ((NestedAdapterWrapper) it.next()).b();
        }
        return iB;
    }

    public boolean t() {
        return this.f51547g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    public void w(RecyclerView recyclerView) {
        if (v(recyclerView)) {
            return;
        }
        this.f51543c.add(new WeakReference(recyclerView));
        Iterator it = this.f51545e.iterator();
        while (it.hasNext()) {
            ((NestedAdapterWrapper) it.next()).f51822c.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void x(RecyclerView.ViewHolder viewHolder, int i3) {
        WrapperAndLocalPosition wrapperAndLocalPositionL = l(i3);
        this.f51544d.put(viewHolder, wrapperAndLocalPositionL.f51549a);
        wrapperAndLocalPositionL.f51549a.e(viewHolder, wrapperAndLocalPositionL.f51550b);
        E(wrapperAndLocalPositionL);
    }

    public RecyclerView.ViewHolder y(ViewGroup viewGroup, int i3) {
        return this.f51542b.a(i3).f(viewGroup, i3);
    }

    public void z(RecyclerView recyclerView) {
        int size = this.f51543c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.f51543c.get(size);
            if (weakReference.get() == null) {
                this.f51543c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.f51543c.remove(size);
                break;
            }
            size--;
        }
        Iterator it = this.f51545e.iterator();
        while (it.hasNext()) {
            ((NestedAdapterWrapper) it.next()).f51822c.onDetachedFromRecyclerView(recyclerView);
        }
    }
}
