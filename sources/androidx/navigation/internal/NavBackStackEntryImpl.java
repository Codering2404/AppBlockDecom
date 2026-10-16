package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavViewModelStoreProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class NavBackStackEntryImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavBackStackEntry f49318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavContext f49319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NavDestination f49320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f49321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Lifecycle.State f49322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NavViewModelStoreProvider f49323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f49324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f49325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SavedStateRegistryController f49326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f49327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f49328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LifecycleRegistry f49329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Lifecycle.State f49330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ViewModelProvider.Factory f49331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f49332o;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class SavedStateViewModel extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SavedStateHandle f49333a;

        public SavedStateViewModel(SavedStateHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            this.f49333a = handle;
        }

        public final SavedStateHandle y0() {
            return this.f49333a;
        }
    }

    public NavBackStackEntryImpl(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.f49318a = entry;
        this.f49319b = entry.c();
        this.f49320c = entry.d();
        this.f49321d = entry.g();
        this.f49322e = entry.e();
        this.f49323f = entry.j();
        this.f49324g = entry.f();
        this.f49325h = entry.i();
        this.f49326i = SavedStateRegistryController.f53001c.b(entry);
        this.f49328k = LazyKt.b(new Function0() { // from class: androidx.navigation.internal.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavBackStackEntryImpl.d();
            }
        });
        this.f49329l = new LifecycleRegistry(entry);
        this.f49330m = Lifecycle.State.f39948b;
        this.f49331n = f();
        this.f49332o = LazyKt.b(new Function0() { // from class: androidx.navigation.internal.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavBackStackEntryImpl.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateViewModelFactory d() {
        return new SavedStateViewModelFactory();
    }

    private final ViewModelProvider.Factory k() {
        return (ViewModelProvider.Factory) this.f49332o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory p() {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.a(Reflection.b(SavedStateViewModel.class), new Function1() { // from class: androidx.navigation.internal.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavBackStackEntryImpl.q((CreationExtras) obj);
            }
        });
        return initializerViewModelFactoryBuilder.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateViewModel q(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SavedStateViewModel(SavedStateHandleSupport.a(initializer));
    }

    public final Bundle e() {
        Pair[] pairArr;
        if (this.f49321d == null) {
            return null;
        }
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.d(SavedStateWriter.a(bundleB), this.f49321d);
        return bundleB;
    }

    public final SavedStateViewModelFactory f() {
        return (SavedStateViewModelFactory) this.f49328k.getValue();
    }

    public final MutableCreationExtras g() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(null, 1, null);
        mutableCreationExtras.c(SavedStateHandleSupport.f40088a, this.f49318a);
        mutableCreationExtras.c(SavedStateHandleSupport.f40089b, this.f49318a);
        Bundle bundleE = e();
        if (bundleE != null) {
            mutableCreationExtras.c(SavedStateHandleSupport.f40090c, bundleE);
        }
        return mutableCreationExtras;
    }

    public final ViewModelProvider.Factory h() {
        return this.f49331n;
    }

    public final LifecycleRegistry i() {
        return this.f49329l;
    }

    public final Lifecycle.State j() {
        return this.f49330m;
    }

    public final SavedStateHandle l() {
        if (!this.f49327j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (this.f49329l.getCurrentState() != Lifecycle.State.f39947a) {
            return ((SavedStateViewModel) ViewModelProvider.Companion.d(ViewModelProvider.f40124b, this.f49318a, k(), null, 4, null).d(Reflection.b(SavedStateViewModel.class))).y0();
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.");
    }

    public final SavedStateRegistry m() {
        return this.f49326i.b();
    }

    public final ViewModelStore n() {
        if (!this.f49327j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (this.f49329l.getCurrentState() == Lifecycle.State.f39947a) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
        NavViewModelStoreProvider navViewModelStoreProvider = this.f49323f;
        if (navViewModelStoreProvider != null) {
            return navViewModelStoreProvider.h(this.f49324g);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    public final void o(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f49318a.o(event.c());
        this.f49322e = event.c();
        u();
    }

    public final void r(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.f49326i.e(outBundle);
    }

    public final void s(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.f49322e = state;
    }

    public final void t(Lifecycle.State maxState) {
        Intrinsics.checkNotNullParameter(maxState, "maxState");
        this.f49330m = maxState;
        u();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.b(this.f49318a.getClass()).m());
        sb.append('(' + this.f49324g + ')');
        sb.append(" destination=");
        sb.append(this.f49320c);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void u() {
        if (!this.f49327j) {
            this.f49326i.c();
            this.f49327j = true;
            if (this.f49323f != null) {
                SavedStateHandleSupport.c(this.f49318a);
            }
            this.f49326i.d(this.f49325h);
        }
        if (this.f49322e.ordinal() < this.f49330m.ordinal()) {
            this.f49329l.l(this.f49322e);
        } else {
            this.f49329l.l(this.f49330m);
        }
    }
}
