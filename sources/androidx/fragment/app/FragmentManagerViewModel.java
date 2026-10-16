package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FragmentManagerViewModel extends ViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ViewModelProvider.Factory f37280i = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class cls) {
            return new FragmentManagerViewModel(true);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f37284d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f37281a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f37282b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f37283c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f37285f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f37286g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37287h = false;

    FragmentManagerViewModel(boolean z2) {
        this.f37284d = z2;
    }

    private void B0(String str, boolean z2) {
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.f37282b.get(str);
        if (fragmentManagerViewModel != null) {
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(fragmentManagerViewModel.f37282b.keySet());
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    fragmentManagerViewModel.A0((String) obj, true);
                }
            }
            fragmentManagerViewModel.onCleared();
            this.f37282b.remove(str);
        }
        ViewModelStore viewModelStore = (ViewModelStore) this.f37283c.get(str);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.f37283c.remove(str);
        }
    }

    static FragmentManagerViewModel E0(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, f37280i).a(FragmentManagerViewModel.class);
    }

    void A0(String str, boolean z2) {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        B0(str, z2);
    }

    Fragment C0(String str) {
        return (Fragment) this.f37281a.get(str);
    }

    FragmentManagerViewModel D0(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.f37282b.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.f37284d);
        this.f37282b.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    Collection F0() {
        return new ArrayList(this.f37281a.values());
    }

    ViewModelStore G0(Fragment fragment) {
        ViewModelStore viewModelStore = (ViewModelStore) this.f37283c.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f37283c.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    boolean H0() {
        return this.f37285f;
    }

    void I0(Fragment fragment) {
        if (this.f37287h) {
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f37281a.remove(fragment.mWho) == null || !FragmentManager.R0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void J0(boolean z2) {
        this.f37287h = z2;
    }

    boolean K0(Fragment fragment) {
        if (this.f37281a.containsKey(fragment.mWho)) {
            return this.f37284d ? this.f37285f : !this.f37286g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FragmentManagerViewModel.class == obj.getClass()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
            if (this.f37281a.equals(fragmentManagerViewModel.f37281a) && this.f37282b.equals(fragmentManagerViewModel.f37282b) && this.f37283c.equals(fragmentManagerViewModel.f37283c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f37281a.hashCode() * 31) + this.f37282b.hashCode()) * 31) + this.f37283c.hashCode();
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f37285f = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f37281a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f37282b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f37283c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    void y0(Fragment fragment) {
        if (this.f37287h) {
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f37281a.containsKey(fragment.mWho)) {
                return;
            }
            this.f37281a.put(fragment.mWho, fragment);
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void z0(Fragment fragment, boolean z2) {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        B0(fragment.mWho, z2);
    }
}
