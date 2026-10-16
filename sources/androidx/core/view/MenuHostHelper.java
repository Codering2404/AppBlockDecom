package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MenuHostHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f34411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f34412b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f34413c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LifecycleContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lifecycle f34414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LifecycleEventObserver f34415b;

        LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f34414a = lifecycle;
            this.f34415b = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }

        void a() {
            this.f34414a.removeObserver(this.f34415b);
            this.f34415b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f34411a = runnable;
    }

    public static /* synthetic */ void a(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        menuHostHelper.getClass();
        if (event == Lifecycle.Event.d(state)) {
            menuHostHelper.c(menuProvider);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            menuHostHelper.j(menuProvider);
        } else if (event == Lifecycle.Event.b(state)) {
            menuHostHelper.f34412b.remove(menuProvider);
            menuHostHelper.f34411a.run();
        }
    }

    public static /* synthetic */ void b(MenuHostHelper menuHostHelper, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        menuHostHelper.getClass();
        if (event == Lifecycle.Event.ON_DESTROY) {
            menuHostHelper.j(menuProvider);
        }
    }

    public void c(MenuProvider menuProvider) {
        this.f34412b.add(menuProvider);
        this.f34411a.run();
    }

    public void d(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f34413c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.f34413c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.m
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.b(this.f34616a, menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    public void e(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f34413c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.f34413c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.l
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.a(this.f34613a, state, menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    public void f(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f34412b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).d(menu, menuInflater);
        }
    }

    public void g(Menu menu) {
        Iterator it = this.f34412b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).a(menu);
        }
    }

    public boolean h(MenuItem menuItem) {
        Iterator it = this.f34412b.iterator();
        while (it.hasNext()) {
            if (((MenuProvider) it.next()).c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void i(Menu menu) {
        Iterator it = this.f34412b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).b(menu);
        }
    }

    public void j(MenuProvider menuProvider) {
        this.f34412b.remove(menuProvider);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f34413c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.f34411a.run();
    }
}
