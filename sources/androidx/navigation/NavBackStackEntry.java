package androidx.navigation;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavContext;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f48787k = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavContext f48788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavDestination f48789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f48790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Lifecycle.State f48791d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NavViewModelStoreProvider f48792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f48793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f48794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NavBackStackEntryImpl f48795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f48796j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(Companion companion, NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                bundle = null;
            }
            if ((i3 & 8) != 0) {
                state = Lifecycle.State.f39949c;
            }
            if ((i3 & 16) != 0) {
                navViewModelStoreProvider = null;
            }
            if ((i3 & 32) != 0) {
                str = companion.c();
            }
            if ((i3 & 64) != 0) {
                bundle2 = null;
            }
            return companion.a(navContext, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
        }

        public final NavBackStackEntry a(NavContext navContext, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, NavViewModelStoreProvider navViewModelStoreProvider, String id, Bundle bundle2) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
            Intrinsics.checkNotNullParameter(id, "id");
            return new NavBackStackEntry(navContext, destination, bundle, hostLifecycleState, navViewModelStoreProvider, id, bundle2, null);
        }

        public final String c() {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private Companion() {
        }
    }

    public /* synthetic */ NavBackStackEntry(NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(navContext, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateHandle m(NavBackStackEntry navBackStackEntry) {
        return navBackStackEntry.f48795i.l();
    }

    public final Bundle b() {
        return this.f48795i.e();
    }

    public final NavContext c() {
        return this.f48788a;
    }

    public final NavDestination d() {
        return this.f48789b;
    }

    public final Lifecycle.State e() {
        return this.f48791d;
    }

    public boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj != null && (obj instanceof NavBackStackEntry)) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (Intrinsics.areEqual(this.f48793g, navBackStackEntry.f48793g) && Intrinsics.areEqual(this.f48789b, navBackStackEntry.f48789b) && Intrinsics.areEqual(getLifecycle(), navBackStackEntry.getLifecycle()) && Intrinsics.areEqual(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
                if (Intrinsics.areEqual(this.f48790c, navBackStackEntry.f48790c)) {
                    return true;
                }
                Bundle bundle = this.f48790c;
                if (bundle != null && (setKeySet = bundle.keySet()) != null) {
                    Set<String> set = setKeySet;
                    if ((set instanceof Collection) && set.isEmpty()) {
                        return true;
                    }
                    for (String str : set) {
                        Object obj2 = this.f48790c.get(str);
                        Bundle bundle2 = navBackStackEntry.f48790c;
                        if (!Intrinsics.areEqual(obj2, bundle2 != null ? bundle2.get(str) : null)) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final String f() {
        return this.f48793g;
    }

    public final Bundle g() {
        return this.f48790c;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtrasG = this.f48795i.g();
        NavContext navContext = this.f48788a;
        Object objA = navContext != null ? navContext.a() : null;
        Application application = objA instanceof Application ? (Application) objA : null;
        if (application != null) {
            mutableCreationExtrasG.c(ViewModelProvider.AndroidViewModelFactory.f40129e, application);
        }
        return mutableCreationExtrasG;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return this.f48795i.h();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f48795i.i();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f48795i.m();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.f48795i.n();
    }

    public final Lifecycle.State h() {
        return this.f48795i.j();
    }

    public int hashCode() {
        Set<String> setKeySet;
        int iHashCode = (this.f48793g.hashCode() * 31) + this.f48789b.hashCode();
        Bundle bundle = this.f48790c;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i3 = iHashCode * 31;
                Object obj = this.f48790c.get((String) it.next());
                iHashCode = i3 + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (((iHashCode * 31) + getLifecycle().hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final Bundle i() {
        return this.f48794h;
    }

    public final NavViewModelStoreProvider j() {
        return this.f48792f;
    }

    public final void k(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f48795i.o(event);
    }

    public final void l(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.f48795i.r(outBundle);
    }

    public final void n(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "<set-?>");
        this.f48789b = navDestination;
    }

    public final void o(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.f48791d = state;
    }

    public final void p(Lifecycle.State value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f48795i.t(value);
    }

    public final void q() {
        this.f48795i.u();
    }

    public String toString() {
        return this.f48795i.toString();
    }

    private NavBackStackEntry(NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
        this.f48788a = navContext;
        this.f48789b = navDestination;
        this.f48790c = bundle;
        this.f48791d = state;
        this.f48792f = navViewModelStoreProvider;
        this.f48793g = str;
        this.f48794h = bundle2;
        this.f48795i = new NavBackStackEntryImpl(this);
        this.f48796j = LazyKt.b(new Function0() { // from class: androidx.navigation.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavBackStackEntry.m(this.f49008a);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry entry, Bundle bundle) {
        this(entry.f48788a, entry.f48789b, bundle, entry.f48791d, entry.f48792f, entry.f48793g, entry.f48794h);
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.f48795i.s(entry.f48791d);
        this.f48795i.t(entry.h());
    }
}
