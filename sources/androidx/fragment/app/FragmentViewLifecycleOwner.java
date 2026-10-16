package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f37387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewModelStore f37388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f37389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewModelProvider.Factory f37390d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LifecycleRegistry f37391f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SavedStateRegistryController f37392g = null;

    FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore, Runnable runnable) {
        this.f37387a = fragment;
        this.f37388b = viewModelStore;
        this.f37389c = runnable;
    }

    void a(Lifecycle.Event event) {
        this.f37391f.g(event);
    }

    void b() {
        if (this.f37391f == null) {
            this.f37391f = new LifecycleRegistry(this);
            SavedStateRegistryController savedStateRegistryControllerA = SavedStateRegistryController.a(this);
            this.f37392g = savedStateRegistryControllerA;
            savedStateRegistryControllerA.c();
            this.f37389c.run();
        }
    }

    boolean c() {
        return this.f37391f != null;
    }

    void d(Bundle bundle) {
        this.f37392g.d(bundle);
    }

    void e(Bundle bundle) {
        this.f37392g.e(bundle);
    }

    void f(Lifecycle.State state) {
        this.f37391f.l(state);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f37387a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f40129e, application);
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f40088a, this.f37387a);
        mutableCreationExtras.c(SavedStateHandleSupport.f40089b, this);
        if (this.f37387a.getArguments() != null) {
            mutableCreationExtras.c(SavedStateHandleSupport.f40090c, this.f37387a.getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f37387a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f37387a.mDefaultFactory)) {
            this.f37390d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f37390d == null) {
            Context applicationContext = this.f37387a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            Fragment fragment = this.f37387a;
            this.f37390d = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.f37390d;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        b();
        return this.f37391f;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f37392g.b();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        b();
        return this.f37388b;
    }
}
