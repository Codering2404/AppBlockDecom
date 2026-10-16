package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;

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
@Navigator.Name("fragment")
@Metadata
public class FragmentNavigator extends Navigator<Destination> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Companion f49266k = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f49267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FragmentManager f49268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f49269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f49270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f49271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LifecycleEventObserver f49272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function1 f49273j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ClearEntryStateViewModel extends ViewModel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f49274a;

        @Override // androidx.lifecycle.ViewModel
        protected void onCleared() {
            super.onCleared();
            Function0 function0 = (Function0) y0().get();
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final WeakReference y0() {
            WeakReference weakReference = this.f49274a;
            if (weakReference != null) {
                return weakReference;
            }
            Intrinsics.throwUninitializedPropertyAccessException("completeTransition");
            return null;
        }

        public final void z0(WeakReference weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.f49274a = weakReference;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Destination extends NavDestination {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f49275i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator fragmentNavigator) {
            super(fragmentNavigator);
            Intrinsics.checkNotNullParameter(fragmentNavigator, "fragmentNavigator");
        }

        public final String H() {
            String str = this.f49275i;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set");
            }
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
            return str;
        }

        public final Destination I(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.f49275i = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && (obj instanceof Destination) && super.equals(obj) && Intrinsics.areEqual(this.f49275i, ((Destination) obj).f49275i);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            String str = this.f49275i;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f49275i;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @Override // androidx.navigation.NavDestination
        public void x(Context context, AttributeSet attrs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            super.x(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.f49292c);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "obtainAttributes(...)");
            String string = typedArrayObtainAttributes.getString(R.styleable.f49293d);
            if (string != null) {
                I(string);
            }
            Unit unit = Unit.f139807a;
            typedArrayObtainAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Extras implements Navigator.Extras {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedHashMap f49276a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        public final Map a() {
            return MapsKt.toMap(this.f49276a);
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.f49267d = context;
        this.f49268e = fragmentManager;
        this.f49269f = i3;
        this.f49270g = new LinkedHashSet();
        this.f49271h = new ArrayList();
        this.f49272i = new LifecycleEventObserver() { // from class: androidx.navigation.fragment.f
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FragmentNavigator.J(this.f49302a, lifecycleOwner, event);
            }
        };
        this.f49273j = new Function1() { // from class: androidx.navigation.fragment.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FragmentNavigator.K(this.f49303a, (NavBackStackEntry) obj);
            }
        };
    }

    static /* synthetic */ void A(FragmentNavigator fragmentNavigator, String str, boolean z2, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPendingOps");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = true;
        }
        fragmentNavigator.z(str, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(String str, Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.e(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(NavBackStackEntry navBackStackEntry, NavigatorState navigatorState, FragmentNavigator fragmentNavigator, Fragment fragment) {
        for (NavBackStackEntry navBackStackEntry2 : (Iterable) navigatorState.d().getValue()) {
            if (fragmentNavigator.N(2)) {
                Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry2 + " due to fragment " + fragment + " viewmodel being cleared");
            }
            navigatorState.f(navBackStackEntry2);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClearEntryStateViewModel D(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new ClearEntryStateViewModel();
    }

    private final void F(final NavBackStackEntry navBackStackEntry, final Fragment fragment) {
        fragment.getViewLifecycleOwnerLiveData().j(fragment, new FragmentNavigator$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: androidx.navigation.fragment.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FragmentNavigator.G(this.f49308a, fragment, navBackStackEntry, (LifecycleOwner) obj);
            }
        }));
        fragment.getLifecycle().addObserver(this.f49272i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(FragmentNavigator fragmentNavigator, Fragment fragment, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner) {
        List list = fragmentNavigator.f49271h;
        boolean z2 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(((Pair) it.next()).e(), fragment.getTag())) {
                    z2 = true;
                    break;
                }
            }
        }
        if (lifecycleOwner != null && !z2) {
            Lifecycle lifecycle = fragment.getViewLifecycleOwner().getLifecycle();
            if (lifecycle.getCurrentState().b(Lifecycle.State.f39949c)) {
                lifecycle.addObserver((LifecycleObserver) fragmentNavigator.f49273j.invoke(navBackStackEntry));
            }
        }
        return Unit.f139807a;
    }

    private final FragmentTransaction I(NavBackStackEntry navBackStackEntry, NavOptions navOptions) {
        NavDestination navDestinationD = navBackStackEntry.d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.fragment.FragmentNavigator.Destination");
        Bundle bundleB = navBackStackEntry.b();
        String strH = ((Destination) navDestinationD).H();
        if (strH.charAt(0) == '.') {
            strH = this.f49267d.getPackageName() + strH;
        }
        Fragment fragmentA = this.f49268e.B0().a(this.f49267d.getClassLoader(), strH);
        Intrinsics.checkNotNullExpressionValue(fragmentA, "instantiate(...)");
        fragmentA.setArguments(bundleB);
        FragmentTransaction fragmentTransactionQ = this.f49268e.q();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction(...)");
        int iA = navOptions != null ? navOptions.a() : -1;
        int iB = navOptions != null ? navOptions.b() : -1;
        int iC = navOptions != null ? navOptions.c() : -1;
        int iD = navOptions != null ? navOptions.d() : -1;
        if (iA != -1 || iB != -1 || iC != -1 || iD != -1) {
            if (iA == -1) {
                iA = 0;
            }
            if (iB == -1) {
                iB = 0;
            }
            if (iC == -1) {
                iC = 0;
            }
            fragmentTransactionQ.u(iA, iB, iC, iD != -1 ? iD : 0);
        }
        fragmentTransactionQ.t(this.f49269f, fragmentA, navBackStackEntry.f());
        fragmentTransactionQ.w(fragmentA);
        fragmentTransactionQ.x(true);
        return fragmentTransactionQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(FragmentNavigator fragmentNavigator, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            Fragment fragment = (Fragment) source;
            Object obj = null;
            for (Object obj2 : (Iterable) fragmentNavigator.d().d().getValue()) {
                if (Intrinsics.areEqual(((NavBackStackEntry) obj2).f(), fragment.getTag())) {
                    obj = obj2;
                }
            }
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (navBackStackEntry != null) {
                if (fragmentNavigator.N(2)) {
                    Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + source + " lifecycle reaching DESTROYED");
                }
                fragmentNavigator.d().f(navBackStackEntry);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleEventObserver K(final FragmentNavigator fragmentNavigator, final NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return new LifecycleEventObserver() { // from class: androidx.navigation.fragment.i
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FragmentNavigator.L(this.f49306a, entry, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FragmentNavigator fragmentNavigator, NavBackStackEntry navBackStackEntry, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && ((List) fragmentNavigator.d().c().getValue()).contains(navBackStackEntry)) {
            if (fragmentNavigator.N(2)) {
                Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + owner + " view lifecycle reaching RESUMED");
            }
            fragmentNavigator.d().f(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (fragmentNavigator.N(2)) {
                Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + owner + " view lifecycle reaching DESTROYED");
            }
            fragmentNavigator.d().f(navBackStackEntry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(int i3) {
        return Log.isLoggable("FragmentManager", i3) || Log.isLoggable("FragmentNavigator", i3);
    }

    private final void O(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        boolean zIsEmpty = ((List) d().c().getValue()).isEmpty();
        if (navOptions != null && !zIsEmpty && navOptions.l() && this.f49270g.remove(navBackStackEntry.f())) {
            this.f49268e.t1(navBackStackEntry.f());
            d().m(navBackStackEntry);
            return;
        }
        FragmentTransaction fragmentTransactionI = I(navBackStackEntry, navOptions);
        if (!zIsEmpty) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) d().c().getValue());
            if (navBackStackEntry2 != null) {
                A(this, navBackStackEntry2.f(), false, false, 6, null);
            }
            A(this, navBackStackEntry.f(), false, false, 6, null);
            fragmentTransactionI.h(navBackStackEntry.f());
        }
        if (extras instanceof Extras) {
            for (Map.Entry entry : ((Extras) extras).a().entrySet()) {
                fragmentTransactionI.g((View) entry.getKey(), (String) entry.getValue());
            }
        }
        fragmentTransactionI.j();
        if (N(2)) {
            Log.v("FragmentNavigator", "Calling pushWithTransition via navigate() on entry " + navBackStackEntry);
        }
        d().m(navBackStackEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(NavigatorState navigatorState, FragmentNavigator fragmentNavigator, FragmentManager fragmentManager, Fragment fragment) {
        Object objPrevious;
        Intrinsics.checkNotNullParameter(fragmentManager, "<unused var>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        List list = (List) navigatorState.c().getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious).f(), fragment.getTag())) {
                    break;
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
        if (fragmentNavigator.N(2)) {
            Log.v("FragmentNavigator", "Attaching fragment " + fragment + " associated with entry " + navBackStackEntry + " to FragmentManager " + fragmentNavigator.f49268e);
        }
        if (navBackStackEntry != null) {
            fragmentNavigator.F(navBackStackEntry, fragment);
            fragmentNavigator.E(fragment, navBackStackEntry, navigatorState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) it.e();
    }

    private final void z(final String str, boolean z2, boolean z3) {
        if (z3) {
            CollectionsKt.removeAll(this.f49271h, new Function1() { // from class: androidx.navigation.fragment.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(FragmentNavigator.B(str, (Pair) obj));
                }
            });
        }
        this.f49271h.add(TuplesKt.a(str, Boolean.valueOf(z2)));
    }

    public final void E(final Fragment fragment, final NavBackStackEntry entry, final NavigatorState state) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(state, "state");
        ViewModelStore viewModelStore = fragment.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.a(Reflection.b(ClearEntryStateViewModel.class), new Function1() { // from class: androidx.navigation.fragment.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FragmentNavigator.D((CreationExtras) obj);
            }
        });
        ((ClearEntryStateViewModel) new ViewModelProvider(viewModelStore, initializerViewModelFactoryBuilder.b(), CreationExtras.Empty.f40230c).a(ClearEntryStateViewModel.class)).z0(new WeakReference(new Function0() { // from class: androidx.navigation.fragment.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FragmentNavigator.C(entry, state, this, fragment);
            }
        }));
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Destination c() {
        return new Destination(this);
    }

    public final List M() {
        return this.f49271h;
    }

    @Override // androidx.navigation.Navigator
    public void g(List entries, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        if (this.f49268e.Y0()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            O((NavBackStackEntry) it.next(), navOptions, extras);
        }
    }

    @Override // androidx.navigation.Navigator
    public void i(final NavigatorState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.i(state);
        if (N(2)) {
            Log.v("FragmentNavigator", "onAttach");
        }
        this.f49268e.k(new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.h
            @Override // androidx.fragment.app.FragmentOnAttachListener
            public final void a(FragmentManager fragmentManager, Fragment fragment) {
                FragmentNavigator.P(state, this, fragmentManager, fragment);
            }
        });
        this.f49268e.l(new FragmentManager.OnBackStackChangedListener() { // from class: androidx.navigation.fragment.FragmentNavigator$onAttach$2
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void a(Fragment fragment, boolean z2) {
                Object obj;
                Object objPrevious;
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                List listPlus = CollectionsKt.plus((Collection) state.c().getValue(), (Iterable) state.d().getValue());
                ListIterator listIterator = listPlus.listIterator(listPlus.size());
                while (true) {
                    obj = null;
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    } else {
                        objPrevious = listIterator.previous();
                        if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious).f(), fragment.getTag())) {
                            break;
                        }
                    }
                }
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
                boolean z3 = z2 && this.M().isEmpty() && fragment.isRemoving();
                Iterator it = this.M().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((Pair) next).e(), fragment.getTag())) {
                        obj = next;
                        break;
                    }
                }
                Pair pair = (Pair) obj;
                if (pair != null) {
                    this.M().remove(pair);
                }
                if (!z3 && this.N(2)) {
                    Log.v("FragmentNavigator", "OnBackStackChangedCommitted for fragment " + fragment + " associated with entry " + navBackStackEntry);
                }
                boolean z4 = pair != null && ((Boolean) pair.f()).booleanValue();
                if (!z2 && !z4 && navBackStackEntry == null) {
                    throw new IllegalArgumentException(("The fragment " + fragment + " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.").toString());
                }
                if (navBackStackEntry != null) {
                    this.E(fragment, navBackStackEntry, state);
                    if (z3) {
                        if (this.N(2)) {
                            Log.v("FragmentNavigator", "OnBackStackChangedCommitted for fragment " + fragment + " popping associated entry " + navBackStackEntry + " via system back");
                        }
                        state.j(navBackStackEntry, false);
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void b(Fragment fragment, boolean z2) {
                Object objPrevious;
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                if (z2) {
                    List list = (List) state.c().getValue();
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            objPrevious = null;
                            break;
                        } else {
                            objPrevious = listIterator.previous();
                            if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious).f(), fragment.getTag())) {
                                break;
                            }
                        }
                    }
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
                    if (this.N(2)) {
                        Log.v("FragmentNavigator", "OnBackStackChangedStarted for fragment " + fragment + " associated with entry " + navBackStackEntry);
                    }
                    if (navBackStackEntry != null) {
                        state.k(navBackStackEntry);
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChanged() {
            }
        });
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        if (this.f49268e.Y0()) {
            Log.i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        FragmentTransaction fragmentTransactionI = I(backStackEntry, null);
        List list = (List) d().c().getValue();
        if (list.size() > 1) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.getOrNull(list, CollectionsKt.getLastIndex(list) - 1);
            if (navBackStackEntry != null) {
                A(this, navBackStackEntry.f(), false, false, 6, null);
            }
            A(this, backStackEntry.f(), true, false, 4, null);
            this.f49268e.i1(backStackEntry.f(), 1);
            A(this, backStackEntry.f(), false, false, 2, null);
            fragmentTransactionI.h(backStackEntry.f());
        }
        fragmentTransactionI.j();
        d().g(backStackEntry);
    }

    @Override // androidx.navigation.Navigator
    public void l(Bundle savedState) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        ArrayList<String> stringArrayList = savedState.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.f49270g.clear();
            CollectionsKt.addAll(this.f49270g, stringArrayList);
        }
    }

    @Override // androidx.navigation.Navigator
    public Bundle m() {
        if (this.f49270g.isEmpty()) {
            return null;
        }
        return BundleKt.b(TuplesKt.a("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.f49270g)));
    }

    @Override // androidx.navigation.Navigator
    public void n(NavBackStackEntry popUpTo, boolean z2) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        if (this.f49268e.Y0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) d().c().getValue();
        int iIndexOf = list.indexOf(popUpTo);
        List listSubList = list.subList(iIndexOf, list.size());
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.first(list);
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.getOrNull(list, iIndexOf - 1);
        if (navBackStackEntry2 != null) {
            A(this, navBackStackEntry2.f(), false, false, 6, null);
        }
        List list2 = listSubList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
            if (SequencesKt.r(SequencesKt.M(CollectionsKt.asSequence(this.f49271h), new Function1() { // from class: androidx.navigation.fragment.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FragmentNavigator.Q((Pair) obj2);
                }
            }), navBackStackEntry3.f()) || !Intrinsics.areEqual(navBackStackEntry3.f(), navBackStackEntry.f())) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            A(this, ((NavBackStackEntry) arrayList.get(i3)).f(), true, false, 4, null);
        }
        if (z2) {
            for (NavBackStackEntry navBackStackEntry4 : CollectionsKt.reversed(list2)) {
                if (Intrinsics.areEqual(navBackStackEntry4, navBackStackEntry)) {
                    Log.i("FragmentNavigator", "FragmentManager cannot save the state of the initial destination " + navBackStackEntry4);
                } else {
                    this.f49268e.y1(navBackStackEntry4.f());
                    this.f49270g.add(navBackStackEntry4.f());
                }
            }
        } else {
            this.f49268e.i1(popUpTo.f(), 1);
        }
        if (N(2)) {
            Log.v("FragmentNavigator", "Calling popWithTransition via popBackStack() on entry " + popUpTo + " with savedState " + z2);
        }
        d().j(popUpTo, z2);
    }
}
