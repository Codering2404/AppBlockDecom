package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentLifecycleCallbacksDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f37213a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentManager f37214b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FragmentLifecycleCallbacksHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final FragmentManager.FragmentLifecycleCallbacks f37215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f37216b;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
            this.f37215a = fragmentLifecycleCallbacks;
            this.f37216b = z2;
        }
    }

    FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.f37214b = fragmentManager;
    }

    void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().a(fragment, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.a(this.f37214b, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, boolean z2) {
        Context contextF = this.f37214b.E0().f();
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().b(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.b(this.f37214b, fragment, contextF);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().c(fragment, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.c(this.f37214b, fragment, bundle);
            }
        }
    }

    void d(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().d(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.d(this.f37214b, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().e(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.e(this.f37214b, fragment);
            }
        }
    }

    void f(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().f(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.f(this.f37214b, fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z2) {
        Context contextF = this.f37214b.E0().f();
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().g(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.g(this.f37214b, fragment, contextF);
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().h(fragment, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.h(this.f37214b, fragment, bundle);
            }
        }
    }

    void i(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().i(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.i(this.f37214b, fragment);
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().j(fragment, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.j(this.f37214b, fragment, bundle);
            }
        }
    }

    void k(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().k(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.k(this.f37214b, fragment);
            }
        }
    }

    void l(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().l(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.l(this.f37214b, fragment);
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().m(fragment, view, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.m(this.f37214b, fragment, view, bundle);
            }
        }
    }

    void n(Fragment fragment, boolean z2) {
        Fragment fragmentH0 = this.f37214b.H0();
        if (fragmentH0 != null) {
            fragmentH0.getParentFragmentManager().G0().n(fragment, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.f37213a) {
            if (!z2 || fragmentLifecycleCallbacksHolder.f37216b) {
                fragmentLifecycleCallbacksHolder.f37215a.n(this.f37214b, fragment);
            }
        }
    }

    public void o(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.f37213a.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z2));
    }

    public void p(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f37213a) {
            try {
                int size = this.f37213a.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (((FragmentLifecycleCallbacksHolder) this.f37213a.get(i3)).f37215a == fragmentLifecycleCallbacks) {
                        this.f37213a.remove(i3);
                        break;
                    }
                    i3++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
