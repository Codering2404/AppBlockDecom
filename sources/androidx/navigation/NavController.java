package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class NavController {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f48798j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f48799k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavControllerImpl f48801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NavContext f48802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f48803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private NavInflater f48804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f48805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OnBackPressedCallback f48806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f48807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f48808i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public class NavControllerNavigatorState extends NavigatorState {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Navigator f48809g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ NavController f48810h;

        public NavControllerNavigatorState(NavController navController, Navigator navigator) {
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.f48810h = navController;
            this.f48809g = navigator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit s(NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry) {
            super.f(navBackStackEntry);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit t(NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z2) {
            super.i(navBackStackEntry, z2);
            return Unit.f139807a;
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry b(NavDestination destination, Bundle bundle) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            return this.f48810h.f48801b.q(destination, bundle);
        }

        @Override // androidx.navigation.NavigatorState
        public void f(final NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f48810h.f48801b.a0(this, entry, new Function0() { // from class: androidx.navigation.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavController.NavControllerNavigatorState.s(this.f49314a, entry);
                }
            });
        }

        @Override // androidx.navigation.NavigatorState
        public void i(final NavBackStackEntry popUpTo, final boolean z2) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            this.f48810h.f48801b.k0(this, popUpTo, z2, new Function0() { // from class: androidx.navigation.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavController.NavControllerNavigatorState.t(this.f49405a, popUpTo, z2);
                }
            });
        }

        @Override // androidx.navigation.NavigatorState
        public void j(NavBackStackEntry popUpTo, boolean z2) {
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            super.j(popUpTo, z2);
        }

        @Override // androidx.navigation.NavigatorState
        public void k(NavBackStackEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            super.k(entry);
            this.f48810h.f48801b.y0(entry);
        }

        @Override // androidx.navigation.NavigatorState
        public void l(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            this.f48810h.f48801b.z0(this, backStackEntry);
        }

        public final void q(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            super.l(backStackEntry);
        }

        public final Navigator r() {
            return this.f48809g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public interface OnDestinationChangedListener {
        void a(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public NavController(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48800a = context;
        this.f48801b = new NavControllerImpl(this, new Function0() { // from class: androidx.navigation.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavController.I(this.f49009a);
            }
        });
        this.f48802c = new NavContext(context);
        Iterator it = SequencesKt.h(context, new Function1() { // from class: androidx.navigation.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavController.h((Context) obj);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.f48803d = (Activity) next;
        this.f48806g = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            {
                super(false);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.f48811a.R();
            }
        };
        this.f48807h = true;
        this.f48801b.U().b(new NavGraphNavigator(this.f48801b.U()));
        this.f48801b.U().b(new ActivityNavigator(this.f48800a));
        this.f48808i = LazyKt.b(new Function0() { // from class: androidx.navigation.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NavController.J(this.f49246a);
            }
        });
    }

    private final boolean E(int[] iArr, Bundle[] bundleArr, boolean z2) {
        NavDestination navDestinationJ;
        NavGraph navGraph;
        int i3 = 0;
        if (z2) {
            if (!this.f48801b.G().isEmpty()) {
                NavGraph navGraphT = this.f48801b.T();
                Intrinsics.checkNotNull(navGraphT);
                V(this, navGraphT.o(), true, false, 4, null);
            }
            while (i3 < iArr.length) {
                int i4 = iArr[i3];
                int i5 = i3 + 1;
                Bundle bundle = bundleArr[i3];
                final NavDestination navDestinationM = m(this, i4, null, 2, null);
                if (navDestinationM == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f48864g.d(this.f48802c, i4) + " cannot be found from the current destination " + v());
                }
                K(navDestinationM, bundle, NavOptionsBuilderKt.a(new Function1() { // from class: androidx.navigation.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavController.F(navDestinationM, this, (NavOptionsBuilder) obj);
                    }
                }), null);
                i3 = i5;
            }
            this.f48805f = true;
            return true;
        }
        NavGraph navGraphT2 = this.f48801b.T();
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            Bundle bundle2 = bundleArr[i6];
            if (i6 == 0) {
                navDestinationJ = this.f48801b.T();
            } else {
                Intrinsics.checkNotNull(navGraphT2);
                navDestinationJ = navGraphT2.J(i7);
            }
            if (navDestinationJ == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f48864g.d(this.f48802c, i7) + " cannot be found in graph " + navGraphT2);
            }
            if (i6 == iArr.length - 1) {
                NavOptions.Builder builder = new NavOptions.Builder();
                NavGraph navGraphT3 = this.f48801b.T();
                Intrinsics.checkNotNull(navGraphT3);
                K(navDestinationJ, bundle2, NavOptions.Builder.k(builder, navGraphT3.o(), true, false, 4, null).b(0).c(0).a(), null);
            } else if (navDestinationJ instanceof NavGraph) {
                while (true) {
                    navGraph = (NavGraph) navDestinationJ;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.J(navGraph.P()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationJ = navGraph.J(navGraph.P());
                }
                navGraphT2 = navGraph;
            }
        }
        this.f48805f = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(NavDestination navDestination, NavController navController, NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.a(new Function1() { // from class: androidx.navigation.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavController.G((AnimBuilder) obj);
            }
        });
        if (navDestination instanceof NavGraph) {
            Iterator it = NavDestination.f48864g.e(navDestination).iterator();
            while (true) {
                if (it.hasNext()) {
                    NavDestination navDestination2 = (NavDestination) it.next();
                    NavDestination navDestinationV = navController.v();
                    if (Intrinsics.areEqual(navDestination2, navDestinationV != null ? navDestinationV.s() : null)) {
                        break;
                    }
                } else if (f48799k) {
                    navOptions.c(NavGraph.f48886j.d(navController.x()).o(), new Function1() { // from class: androidx.navigation.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavController.H((PopUpToBuilder) obj);
                        }
                    });
                }
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(AnimBuilder anim) {
        Intrinsics.checkNotNullParameter(anim, "$this$anim");
        anim.e(0);
        anim.f(0);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.d(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(NavController navController) {
        navController.g0();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavInflater J(NavController navController) {
        NavInflater navInflater = navController.f48804e;
        return navInflater == null ? new NavInflater(navController.f48800a, navController.f48801b.U()) : navInflater;
    }

    private final void K(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        this.f48801b.c0(navDestination, bundle, navOptions, extras);
    }

    public static /* synthetic */ void O(NavController navController, Object obj, NavOptions navOptions, Navigator.Extras extras, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i3 & 2) != 0) {
            navOptions = null;
        }
        if ((i3 & 4) != 0) {
            extras = null;
        }
        navController.L(obj, navOptions, extras);
    }

    public static /* synthetic */ void P(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i3 & 2) != 0) {
            navOptions = null;
        }
        if ((i3 & 4) != 0) {
            extras = null;
        }
        navController.M(str, navOptions, extras);
    }

    private final boolean U(int i3, boolean z2, boolean z3) {
        return this.f48801b.r0(i3, z2, z3);
    }

    static /* synthetic */ boolean V(NavController navController, int i3, boolean z2, boolean z3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return navController.U(i3, z2, z3);
    }

    private final boolean e0() {
        Pair[] pairArr;
        int i3 = 0;
        if (!this.f48805f) {
            return false;
        }
        Activity activity = this.f48803d;
        Intrinsics.checkNotNull(activity);
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        if (mutableList.size() < 2) {
            return false;
        }
        int iIntValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
        }
        NavDestination navDestinationO = o(this, x(), iIntValue, false, null, 4, null);
        if (navDestinationO instanceof NavGraph) {
            iIntValue = NavGraph.f48886j.d((NavGraph) navDestinationO).o();
        }
        NavDestination navDestinationV = v();
        if (navDestinationV == null || iIntValue != navDestinationV.o()) {
            return false;
        }
        NavDeepLinkBuilder navDeepLinkBuilderJ = j();
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
        Bundle bundleA = SavedStateWriter.a(bundleB);
        Intrinsics.checkNotNull(intent);
        SavedStateWriter.x(bundleA, "android-support-nav:controller:deepLinkIntent", intent);
        Bundle bundle = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle != null) {
            SavedStateWriter.d(bundleA, bundle);
        }
        navDeepLinkBuilderJ.i(bundleB);
        for (Object obj : mutableList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            navDeepLinkBuilderJ.e(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i3) : null);
            i3 = i4;
        }
        navDeepLinkBuilderJ.f().l();
        Activity activity2 = this.f48803d;
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    private final boolean f0() {
        Pair[] pairArr;
        Bundle bundleD;
        NavDestination navDestinationV = v();
        Intrinsics.checkNotNull(navDestinationV);
        int iO = navDestinationV.o();
        for (NavGraph navGraphS = navDestinationV.s(); navGraphS != null; navGraphS = navGraphS.s()) {
            if (navGraphS.P() != iO) {
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
                Bundle bundleA = SavedStateWriter.a(bundleB);
                Activity activity = this.f48803d;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.f48803d;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.f48803d;
                            Intrinsics.checkNotNull(activity3);
                            Intent intent = activity3.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                            SavedStateWriter.x(bundleA, "android-support-nav:controller:deepLinkIntent", intent);
                            NavGraph navGraphQ = this.f48801b.Q();
                            Activity activity4 = this.f48803d;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent2 = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                            NavDestination.DeepLinkMatch deepLinkMatchR = navGraphQ.R(NavControllerKt.a(intent2), true, true, navGraphQ);
                            if ((deepLinkMatchR != null ? deepLinkMatchR.c() : null) != null && (bundleD = deepLinkMatchR.b().d(deepLinkMatchR.c())) != null) {
                                SavedStateWriter.d(bundleA, bundleD);
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.k(new NavDeepLinkBuilder(this), navGraphS.o(), null, 2, null).i(bundleB).f().l();
                Activity activity5 = this.f48803d;
                if (activity5 != null) {
                    activity5.finish();
                }
                return true;
            }
            iO = navGraphS.o();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g0() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.f48806g
            boolean r1 = r3.f48807h
            if (r1 == 0) goto Le
            int r1 = r3.w()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.g0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context h(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ContextWrapper) {
            return ((ContextWrapper) it).getBaseContext();
        }
        return null;
    }

    public static /* synthetic */ NavDestination m(NavController navController, int i3, NavDestination navDestination, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestination");
        }
        if ((i4 & 2) != 0) {
            navDestination = null;
        }
        return navController.l(i3, navDestination);
    }

    public static /* synthetic */ NavDestination o(NavController navController, NavDestination navDestination, int i3, boolean z2, NavDestination navDestination2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findDestinationComprehensive");
        }
        if ((i4 & 4) != 0) {
            navDestination2 = null;
        }
        return navController.n(navDestination, i3, z2, navDestination2);
    }

    private final String p(int[] iArr) {
        return this.f48801b.E(iArr);
    }

    private final int w() {
        ArrayDeque arrayDequeG = this.f48801b.G();
        int i3 = 0;
        if (arrayDequeG != null && arrayDequeG.isEmpty()) {
            return 0;
        }
        Iterator<E> it = arrayDequeG.iterator();
        while (it.hasNext()) {
            if (!(((NavBackStackEntry) it.next()).d() instanceof NavGraph) && (i3 = i3 + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i3;
    }

    public NavigatorProvider A() {
        return this.f48801b.O();
    }

    public NavBackStackEntry B() {
        return this.f48801b.P();
    }

    public final StateFlow C() {
        return this.f48801b.R();
    }

    public boolean D(Intent intent) {
        int[] intArray;
        Pair[] pairArr;
        NavGraph navGraphQ;
        NavDestination.DeepLinkMatch deepLinkMatchR;
        Pair[] pairArr2;
        Bundle bundle;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        ArrayList arrayList = null;
        if (extras != null) {
            try {
                intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
            } catch (Exception e3) {
                Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e3);
                intArray = null;
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList2 = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList2.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList2.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            SavedStateWriter.d(SavedStateWriter.a(bundleB), bundle2);
        }
        if ((intArray == null || intArray.length == 0) && (deepLinkMatchR = (navGraphQ = this.f48801b.Q()).R(NavControllerKt.a(intent), true, true, navGraphQ)) != null) {
            NavDestination navDestinationB = deepLinkMatchR.b();
            int[] iArrF = NavDestination.f(navDestinationB, null, 1, null);
            Bundle bundleD = navDestinationB.d(deepLinkMatchR.c());
            if (bundleD != null) {
                SavedStateWriter.d(SavedStateWriter.a(bundleB), bundleD);
            }
            intArray = iArrF;
        } else {
            arrayList = parcelableArrayList;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strP = p(intArray);
        if (strP != null) {
            androidx.navigation.internal.Log.f49317a.a("NavController", "Could not find destination " + strP + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        SavedStateWriter.x(SavedStateWriter.a(bundleB), "android-support-nav:controller:deepLinkIntent", intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i3 = 0; i3 < length; i3++) {
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry2 : mapEmptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.a((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            Bundle bundleB2 = BundleKt.b((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            Bundle bundleA = SavedStateWriter.a(bundleB2);
            SavedStateWriter.d(bundleA, bundleB);
            if (arrayList != null && (bundle = (Bundle) arrayList.get(i3)) != null) {
                SavedStateWriter.d(bundleA, bundle);
            }
            bundleArr[i3] = bundleB2;
        }
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 == 0 || (flags & 32768) != 0) {
            return E(intArray, bundleArr, i4 != 0);
        }
        intent.addFlags(32768);
        TaskStackBuilder taskStackBuilderB = TaskStackBuilder.f(this.f48800a).b(intent);
        Intrinsics.checkNotNullExpressionValue(taskStackBuilderB, "addNextIntentWithParentStack(...)");
        taskStackBuilderB.l();
        Activity activity = this.f48803d;
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
        return true;
    }

    public final void L(Object route, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.f48801b.d0(route, navOptions, extras);
    }

    public final void M(String route, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.f48801b.e0(route, navOptions, extras);
    }

    public final void N(String route, Function1 builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f48801b.f0(route, builder);
    }

    public boolean Q() {
        Intent intent;
        if (w() != 1) {
            return R();
        }
        Activity activity = this.f48803d;
        Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
        return (extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null) != null ? e0() : f0();
    }

    public boolean R() {
        return this.f48801b.l0();
    }

    public final boolean S(Object route, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f48801b.o0(route, z2, z3);
    }

    public void W(OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f48801b.A0(listener);
    }

    public void X(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.f48800a.getClassLoader());
        }
        this.f48801b.B0(bundle);
        if (bundle != null) {
            Boolean boolI = SavedStateReader.i(SavedStateReader.a(bundle), "android-support-nav:controller:deepLinkHandled");
            this.f48805f = boolI != null ? boolI.booleanValue() : false;
        }
    }

    public Bundle Y() {
        Pair[] pairArr;
        Bundle bundleE0 = this.f48801b.E0();
        if (this.f48805f) {
            if (bundleE0 == null) {
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
                bundleE0 = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                SavedStateWriter.a(bundleE0);
            }
            SavedStateWriter.f(SavedStateWriter.a(bundleE0), "android-support-nav:controller:deepLinkHandled", this.f48805f);
        }
        return bundleE0;
    }

    public void Z(int i3) {
        this.f48801b.G0(z().b(i3), null);
    }

    public void a0(int i3, Bundle bundle) {
        this.f48801b.G0(z().b(i3), bundle);
    }

    public void b0(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.f48801b.F0(graph);
    }

    public void c0(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f48801b.H0(owner);
    }

    public void d0(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        this.f48801b.I0(viewModelStore);
    }

    public final void h0(NavDeepLinkRequest request, Bundle args) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(args, "args");
        Intent intent = new Intent();
        intent.setDataAndType(request.c(), request.b());
        intent.setAction(request.a());
        SavedStateWriter.x(SavedStateWriter.a(args), "android-support-nav:controller:deepLinkIntent", intent);
    }

    public final boolean i() {
        Activity activity;
        if (this.f48805f || (activity = this.f48803d) == null) {
            return false;
        }
        Intrinsics.checkNotNull(activity);
        return D(activity.getIntent());
    }

    public NavDeepLinkBuilder j() {
        return new NavDeepLinkBuilder(this);
    }

    public final NavControllerNavigatorState k(Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return new NavControllerNavigatorState(this, navigator);
    }

    public final NavDestination l(int i3, NavDestination navDestination) {
        return this.f48801b.A(i3, navDestination);
    }

    public final NavDestination n(NavDestination navDestination, int i3, boolean z2, NavDestination navDestination2) {
        Intrinsics.checkNotNullParameter(navDestination, "<this>");
        return this.f48801b.C(navDestination, i3, z2, navDestination2);
    }

    public NavBackStackEntry q(int i3) {
        return this.f48801b.H(i3);
    }

    public final NavBackStackEntry r(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f48801b.I(route);
    }

    public final Context s() {
        return this.f48800a;
    }

    public NavBackStackEntry t() {
        return this.f48801b.J();
    }

    public final Flow u() {
        return FlowKt.b(this.f48801b.S());
    }

    public NavDestination v() {
        return this.f48801b.K();
    }

    public NavGraph x() {
        return this.f48801b.L();
    }

    public final NavContext y() {
        return this.f48802c;
    }

    public NavInflater z() {
        return (NavInflater) this.f48808i.getValue();
    }

    public static /* synthetic */ boolean T(NavController navController, Object obj, boolean z2, boolean z3, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException(bfIdKSjLOVjG.LbYY);
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return navController.S(obj, z2, z3);
    }
}
