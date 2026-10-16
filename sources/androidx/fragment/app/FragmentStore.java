package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f37317a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f37318b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f37319c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FragmentManagerViewModel f37320d;

    FragmentStore() {
    }

    void A(FragmentManagerViewModel fragmentManagerViewModel) {
        this.f37320d = fragmentManagerViewModel;
    }

    Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.f37319c.put(str, bundle) : (Bundle) this.f37319c.remove(str);
    }

    void a(Fragment fragment) {
        if (this.f37317a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f37317a) {
            this.f37317a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f37318b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.f37318b.get(str) != null;
    }

    void d(int i3) {
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.t(i3);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f37318b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragmentK = fragmentStateManager.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f37317a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = (Fragment) this.f37317a.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) this.f37318b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    Fragment g(int i3) {
        for (int size = this.f37317a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f37317a.get(size);
            if (fragment != null && fragment.mFragmentId == i3) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentK = fragmentStateManager.k();
                if (fragmentK.mFragmentId == i3) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.f37317a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f37317a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentK = fragmentStateManager.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentFindFragmentByWho;
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null && (fragmentFindFragmentByWho = fragmentStateManager.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f37317a.indexOf(fragment);
        for (int i3 = iIndexOf - 1; i3 >= 0; i3--) {
            Fragment fragment2 = (Fragment) this.f37317a.get(i3);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f37317a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f37317a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    HashMap m() {
        return this.f37319c;
    }

    FragmentStateManager n(String str) {
        return (FragmentStateManager) this.f37318b.get(str);
    }

    List o() {
        ArrayList arrayList;
        if (this.f37317a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f37317a) {
            arrayList = new ArrayList(this.f37317a);
        }
        return arrayList;
    }

    FragmentManagerViewModel p() {
        return this.f37320d;
    }

    Bundle q(String str) {
        return (Bundle) this.f37319c.get(str);
    }

    void r(FragmentStateManager fragmentStateManager) {
        Fragment fragmentK = fragmentStateManager.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f37318b.put(fragmentK.mWho, fragmentStateManager);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f37320d.y0(fragmentK);
            } else {
                this.f37320d.I0(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void s(FragmentStateManager fragmentStateManager) {
        Fragment fragmentK = fragmentStateManager.k();
        if (fragmentK.mRetainInstance) {
            this.f37320d.I0(fragmentK);
        }
        if (this.f37318b.get(fragmentK.mWho) == fragmentStateManager && ((FragmentStateManager) this.f37318b.put(fragmentK.mWho, null)) != null && FragmentManager.R0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void t() {
        ArrayList arrayList = this.f37317a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) this.f37318b.get(((Fragment) obj).mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (FragmentStateManager fragmentStateManager2 : this.f37318b.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.m();
                Fragment fragmentK = fragmentStateManager2.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    if (fragmentK.mBeingSaved && !this.f37319c.containsKey(fragmentK.mWho)) {
                        B(fragmentK.mWho, fragmentStateManager2.r());
                    }
                    s(fragmentStateManager2);
                }
            }
        }
    }

    void u(Fragment fragment) {
        synchronized (this.f37317a) {
            this.f37317a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void v() {
        this.f37318b.clear();
    }

    void w(List list) {
        this.f37317a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    void x(HashMap map) {
        this.f37319c.clear();
        this.f37319c.putAll(map);
    }

    ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f37318b.size());
        for (FragmentStateManager fragmentStateManager : this.f37318b.values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentK = fragmentStateManager.k();
                B(fragmentK.mWho, fragmentStateManager.r());
                arrayList.add(fragmentK.mWho);
                if (FragmentManager.R0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    ArrayList z() {
        synchronized (this.f37317a) {
            try {
                if (this.f37317a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f37317a.size());
                ArrayList arrayList2 = this.f37317a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    Fragment fragment = (Fragment) obj;
                    arrayList.add(fragment.mWho);
                    if (FragmentManager.R0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
