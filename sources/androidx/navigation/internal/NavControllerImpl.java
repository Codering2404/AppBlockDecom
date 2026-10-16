package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.NavUriKt;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.SupportingPane;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializersKt;

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
public final class NavControllerImpl {
    public static final Companion B = new Companion(null);
    private final MutableSharedFlow A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavController f49340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f49341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NavGraph f49342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f49343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bundle[] f49344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f49345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableStateFlow f49346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StateFlow f49347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableStateFlow f49348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final StateFlow f49349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f49350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f49351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map f49352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f49353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LifecycleOwner f49354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private NavControllerViewModel f49355p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f49356q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Lifecycle.State f49357r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final LifecycleObserver f49358s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private NavigatorProvider f49359t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Map f49360u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Function1 f49361v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Function1 f49362w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Map f49363x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f49364y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f49365z;

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

    public NavControllerImpl(NavController navController, Function0 updateOnBackPressedCallbackEnabledCallback) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(updateOnBackPressedCallbackEnabledCallback, "updateOnBackPressedCallbackEnabledCallback");
        this.f49340a = navController;
        this.f49341b = updateOnBackPressedCallbackEnabledCallback;
        this.f49345f = new ArrayDeque();
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(CollectionsKt.emptyList());
        this.f49346g = mutableStateFlowA;
        this.f49347h = FlowKt.c(mutableStateFlowA);
        MutableStateFlow mutableStateFlowA2 = StateFlowKt.a(CollectionsKt.emptyList());
        this.f49348i = mutableStateFlowA2;
        this.f49349j = FlowKt.c(mutableStateFlowA2);
        this.f49350k = new LinkedHashMap();
        this.f49351l = new LinkedHashMap();
        this.f49352m = new LinkedHashMap();
        this.f49353n = new LinkedHashMap();
        this.f49356q = new ArrayList();
        this.f49357r = Lifecycle.State.f39948b;
        this.f49358s = new LifecycleEventObserver() { // from class: androidx.navigation.internal.o
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavControllerImpl.Y(this.f49399a, lifecycleOwner, event);
            }
        };
        this.f49359t = new NavigatorProvider();
        this.f49360u = new LinkedHashMap();
        this.f49363x = new LinkedHashMap();
        this.f49365z = new ArrayList();
        this.A = SharedFlowKt.b(1, 0, BufferOverflow.f141063b, 2, null);
    }

    public static /* synthetic */ NavDestination B(NavControllerImpl navControllerImpl, int i3, NavDestination navDestination, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            navDestination = null;
        }
        return navControllerImpl.A(i3, navDestination);
    }

    private final boolean C0(int i3, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        if (!this.f49352m.containsKey(Integer.valueOf(i3))) {
            return false;
        }
        final String str = (String) this.f49352m.get(Integer.valueOf(i3));
        CollectionsKt.removeAll(this.f49352m.values(), new Function1() { // from class: androidx.navigation.internal.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NavControllerImpl.D0(str, (String) obj));
            }
        });
        return y(V((ArrayDeque) TypeIntrinsics.d(this.f49353n).remove(str)), bundle, navOptions, extras);
    }

    public static /* synthetic */ NavDestination D(NavControllerImpl navControllerImpl, NavDestination navDestination, int i3, boolean z2, NavDestination navDestination2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            navDestination2 = null;
        }
        return navControllerImpl.C(navDestination, i3, z2, navDestination2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0(String str, String str2) {
        return Intrinsics.areEqual(str2, str);
    }

    private final List V(ArrayDeque arrayDeque) {
        NavDestination navDestinationL;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49345f.lastOrNull();
        if (navBackStackEntry == null || (navDestinationL = navBackStackEntry.d()) == null) {
            navDestinationL = L();
        }
        if (arrayDeque != null) {
            Iterator<E> it = arrayDeque.iterator();
            NavDestination navDestination = navDestinationL;
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                NavDestination navDestinationD = D(this, navDestination, navBackStackEntryState.b(), true, null, 8, null);
                if (navDestinationD == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.f48864g.d(N(), navBackStackEntryState.b()) + " cannot be found from the current destination " + navDestination).toString());
                }
                arrayList.add(navBackStackEntryState.d(N(), navDestinationD, M(), this.f49355p));
                navDestination = navDestinationD;
            }
        }
        return arrayList;
    }

    private final boolean W(NavDestination navDestination, Bundle bundle) {
        int iNextIndex;
        NavDestination navDestinationD;
        NavBackStackEntry navBackStackEntryJ = J();
        ArrayDeque arrayDeque = this.f49345f;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            if (((NavBackStackEntry) listIterator.previous()).d() == navDestination) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex == -1) {
            return false;
        }
        if (navDestination instanceof NavGraph) {
            List listS = SequencesKt.S(SequencesKt.M(NavGraph.f48886j.b((NavGraph) navDestination), new Function1() { // from class: androidx.navigation.internal.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(NavControllerImpl.X((NavDestination) obj));
                }
            }));
            if (this.f49345f.size() - iNextIndex != listS.size()) {
                return false;
            }
            ArrayDeque arrayDeque2 = this.f49345f;
            Iterable iterableSubList = arrayDeque2.subList(iNextIndex, arrayDeque2.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableSubList, 10));
            Iterator it = iterableSubList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((NavBackStackEntry) it.next()).d().o()));
            }
            if (!Intrinsics.areEqual(arrayList, listS)) {
                return false;
            }
        } else if (navBackStackEntryJ == null || (navDestinationD = navBackStackEntryJ.d()) == null || navDestination.o() != navDestinationD.o()) {
            return false;
        }
        ArrayDeque<NavBackStackEntry> arrayDeque3 = new ArrayDeque();
        while (CollectionsKt.getLastIndex(this.f49345f) >= iNextIndex) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.removeLast(this.f49345f);
            J0(navBackStackEntry);
            arrayDeque3.addFirst(new NavBackStackEntry(navBackStackEntry, navBackStackEntry.d().d(bundle)));
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque3) {
            NavGraph navGraphS = navBackStackEntry2.d().s();
            if (navGraphS != null) {
                Z(navBackStackEntry2, H(navGraphS.o()));
            }
            this.f49345f.add(navBackStackEntry2);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque3) {
            this.f49359t.e(navBackStackEntry3.d().q()).j(navBackStackEntry3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(NavControllerImpl navControllerImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        navControllerImpl.f49357r = event.c();
        if (navControllerImpl.f49342c != null) {
            Iterator it = CollectionsKt.toMutableList((Collection) navControllerImpl.f49345f).iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).k(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Ref.BooleanRef booleanRef, NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        booleanRef.f140137a = true;
        n(navControllerImpl, navDestination, bundle, it, null, 8, null);
        return Unit.f139807a;
    }

    public static /* synthetic */ void g0(NavControllerImpl navControllerImpl, String str, NavOptions navOptions, Navigator.Extras extras, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            extras = null;
        }
        navControllerImpl.e0(str, navOptions, extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    private final void m(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list) {
        Bundle bundle2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavDestination navDestinationD;
        List list2;
        NavBackStackEntry navBackStackEntry2;
        NavGraph navGraph;
        Object objPrevious;
        Object objPrevious2;
        List list3 = list;
        NavDestination navDestinationD2 = navBackStackEntry.d();
        if (!(navDestinationD2 instanceof FloatingWindow)) {
            while (!this.f49345f.isEmpty() && (((NavBackStackEntry) this.f49345f.last()).d() instanceof FloatingWindow) && u0(this, ((NavBackStackEntry) this.f49345f.last()).d().o(), true, false, 4, null)) {
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        Object obj = null;
        if (navDestination instanceof NavGraph) {
            NavDestination navDestination2 = navDestinationD2;
            while (true) {
                Intrinsics.checkNotNull(navDestination2);
                NavGraph navGraphS = navDestination2.s();
                if (navGraphS != null) {
                    ListIterator listIterator = list3.listIterator(list3.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            objPrevious2 = listIterator.previous();
                            if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious2).d(), navGraphS)) {
                                break;
                            }
                        } else {
                            objPrevious2 = null;
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntryB = (NavBackStackEntry) objPrevious2;
                    if (navBackStackEntryB == null) {
                        bundle2 = bundle;
                        navDestinationD = navDestinationD2;
                        navBackStackEntryB = NavBackStackEntry.Companion.b(NavBackStackEntry.f48787k, N(), navGraphS, bundle2, M(), this.f49355p, null, null, 96, null);
                    } else {
                        bundle2 = bundle;
                        navDestinationD = navDestinationD2;
                    }
                    arrayDeque2.addFirst(navBackStackEntryB);
                    if (this.f49345f.isEmpty() || ((NavBackStackEntry) this.f49345f.last()).d() != navGraphS) {
                        navBackStackEntry2 = navBackStackEntry;
                        list2 = list;
                        arrayDeque = arrayDeque2;
                    } else {
                        list2 = list;
                        arrayDeque = arrayDeque2;
                        navBackStackEntry2 = navBackStackEntry;
                        w0(this, (NavBackStackEntry) this.f49345f.last(), false, null, 6, null);
                    }
                } else {
                    bundle2 = bundle;
                    arrayDeque = arrayDeque2;
                    navDestinationD = navDestinationD2;
                    list2 = list3;
                    navBackStackEntry2 = navBackStackEntry;
                }
                if (navGraphS == null || navGraphS == navDestination) {
                    break;
                }
                list3 = list2;
                navDestination2 = navGraphS;
                arrayDeque2 = arrayDeque;
                navDestinationD2 = navDestinationD;
            }
        } else {
            bundle2 = bundle;
            arrayDeque = arrayDeque2;
            navDestinationD = navDestinationD2;
            list2 = list3;
            navBackStackEntry2 = navBackStackEntry;
        }
        NavDestination navDestinationD3 = arrayDeque.isEmpty() ? navDestinationD : ((NavBackStackEntry) arrayDeque.first()).d();
        while (navDestinationD3 != null && A(navDestinationD3.o(), navDestinationD3) != navDestinationD3) {
            NavGraph navGraphS2 = navDestinationD3.s();
            if (navGraphS2 != null) {
                Bundle bundle3 = (bundle2 == null || !SavedStateReader.O(SavedStateReader.a(bundle2))) ? bundle2 : null;
                ListIterator listIterator2 = list2.listIterator(list2.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        objPrevious = listIterator2.previous();
                        if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious).d(), navGraphS2)) {
                            break;
                        }
                    } else {
                        objPrevious = null;
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntryB2 = (NavBackStackEntry) objPrevious;
                if (navBackStackEntryB2 == null) {
                    navGraph = navGraphS2;
                    navBackStackEntryB2 = NavBackStackEntry.Companion.b(NavBackStackEntry.f48787k, N(), navGraph, navGraphS2.d(bundle3), M(), this.f49355p, null, null, 96, null);
                } else {
                    navGraph = navGraphS2;
                }
                arrayDeque.addFirst(navBackStackEntryB2);
            } else {
                navGraph = navGraphS2;
            }
            navDestinationD3 = navGraph;
        }
        if (!arrayDeque.isEmpty()) {
            navDestinationD = ((NavBackStackEntry) arrayDeque.first()).d();
        }
        while (!this.f49345f.isEmpty() && (((NavBackStackEntry) this.f49345f.last()).d() instanceof NavGraph)) {
            NavDestination navDestinationD4 = ((NavBackStackEntry) this.f49345f.last()).d();
            Intrinsics.checkNotNull(navDestinationD4, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((NavGraph) navDestinationD4).N().g(navDestinationD.o()) != null) {
                break;
            } else {
                w0(this, (NavBackStackEntry) this.f49345f.last(), false, null, 6, null);
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) this.f49345f.firstOrNull();
        if (navBackStackEntry3 == null) {
            navBackStackEntry3 = (NavBackStackEntry) arrayDeque.firstOrNull();
        }
        if (!Intrinsics.areEqual(navBackStackEntry3 != null ? navBackStackEntry3.d() : null, this.f49342c)) {
            ListIterator listIterator3 = list2.listIterator(list2.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                Object objPrevious3 = listIterator3.previous();
                NavDestination navDestinationD5 = ((NavBackStackEntry) objPrevious3).d();
                NavGraph navGraph2 = this.f49342c;
                Intrinsics.checkNotNull(navGraph2);
                if (Intrinsics.areEqual(navDestinationD5, navGraph2)) {
                    obj = objPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryB3 = (NavBackStackEntry) obj;
            if (navBackStackEntryB3 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.f48787k;
                NavContext navContextN = N();
                NavGraph navGraph3 = this.f49342c;
                Intrinsics.checkNotNull(navGraph3);
                NavGraph navGraph4 = this.f49342c;
                Intrinsics.checkNotNull(navGraph4);
                navBackStackEntryB3 = NavBackStackEntry.Companion.b(companion, navContextN, navGraph3, navGraph4.d(bundle2), M(), this.f49355p, null, null, 96, null);
            }
            arrayDeque.addFirst(navBackStackEntryB3);
        }
        for (NavBackStackEntry navBackStackEntry4 : arrayDeque) {
            Object obj2 = this.f49360u.get(this.f49359t.e(navBackStackEntry4.d().q()));
            if (obj2 == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.q() + " should already be created").toString());
            }
            ((NavController.NavControllerNavigatorState) obj2).q(navBackStackEntry4);
        }
        this.f49345f.addAll(arrayDeque);
        this.f49345f.add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry5 : CollectionsKt.plus((Collection<? extends NavBackStackEntry>) arrayDeque, navBackStackEntry2)) {
            NavGraph navGraphS3 = navBackStackEntry5.d().s();
            if (navGraphS3 != null) {
                Z(navBackStackEntry5, H(navGraphS3.o()));
            }
        }
    }

    static /* synthetic */ void n(NavControllerImpl navControllerImpl, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        navControllerImpl.m(navDestination, bundle, navBackStackEntry, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.h(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, NavControllerImpl navControllerImpl, boolean z2, ArrayDeque arrayDeque, NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.f140137a = true;
        booleanRef2.f140137a = true;
        navControllerImpl.v0(entry, z2, arrayDeque);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDestination t(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph navGraphS = destination.s();
        if (navGraphS == null || navGraphS.P() != destination.o()) {
            return null;
        }
        return destination.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.f49352m.containsKey(Integer.valueOf(destination.o()));
    }

    public static /* synthetic */ boolean u0(NavControllerImpl navControllerImpl, int i3, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return navControllerImpl.r0(i3, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDestination v(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavGraph navGraphS = destination.s();
        if (navGraphS == null || navGraphS.P() != destination.o()) {
            return null;
        }
        return destination.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(NavControllerImpl navControllerImpl, NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return !navControllerImpl.f49352m.containsKey(Integer.valueOf(destination.o()));
    }

    public static /* synthetic */ void w0(NavControllerImpl navControllerImpl, NavBackStackEntry navBackStackEntry, boolean z2, ArrayDeque arrayDeque, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navControllerImpl.v0(navBackStackEntry, z2, arrayDeque);
    }

    private final boolean y(final List list, final Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestinationD;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!(((NavBackStackEntry) obj).d() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList2.get(i4);
            i4++;
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            List list2 = (List) CollectionsKt.lastOrNull((List) arrayList);
            if (Intrinsics.areEqual((list2 == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list2)) == null || (navDestinationD = navBackStackEntry.d()) == null) ? null : navDestinationD.q(), navBackStackEntry2.d().q())) {
                list2.add(navBackStackEntry2);
            } else {
                arrayList.add(CollectionsKt.mutableListOf(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj3 = arrayList.get(i3);
            i3++;
            List list3 = (List) obj3;
            Navigator navigatorE = this.f49359t.e(((NavBackStackEntry) CollectionsKt.first(list3)).d().q());
            final Ref.IntRef intRef = new Ref.IntRef();
            h0(navigatorE, list3, navOptions, extras, new Function1() { // from class: androidx.navigation.internal.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return NavControllerImpl.z(booleanRef, list, intRef, this, bundle, (NavBackStackEntry) obj4);
                }
            });
        }
        return booleanRef.f140137a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Ref.BooleanRef booleanRef, List list, Ref.IntRef intRef, NavControllerImpl navControllerImpl, Bundle bundle, NavBackStackEntry entry) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(entry, "entry");
        booleanRef.f140137a = true;
        int iIndexOf = list.indexOf(entry);
        if (iIndexOf != -1) {
            int i3 = iIndexOf + 1;
            listEmptyList = list.subList(intRef.f140142a, i3);
            intRef.f140142a = i3;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        navControllerImpl.m(entry.d(), bundle, entry, listEmptyList);
        return Unit.f139807a;
    }

    public final NavDestination A(int i3, NavDestination navDestination) {
        NavDestination navDestinationD;
        NavGraph navGraph = this.f49342c;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.o() == i3) {
            if (navDestination == null) {
                return this.f49342c;
            }
            if (Intrinsics.areEqual(this.f49342c, navDestination) && navDestination.s() == null) {
                return this.f49342c;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49345f.lastOrNull();
        if (navBackStackEntry == null || (navDestinationD = navBackStackEntry.d()) == null) {
            navDestinationD = this.f49342c;
            Intrinsics.checkNotNull(navDestinationD);
        }
        return C(navDestinationD, i3, false, navDestination);
    }

    public final void A0(NavController.OnDestinationChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f49356q.remove(listener);
    }

    public final void B0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Bundle bundleA = SavedStateReader.a(bundle);
        this.f49343d = SavedStateReader.b(bundleA, "android-support-nav:controller:navigatorState") ? SavedStateReader.C(bundleA, "android-support-nav:controller:navigatorState") : null;
        int i3 = 0;
        this.f49344e = SavedStateReader.b(bundleA, "android-support-nav:controller:backStack") ? (Bundle[]) SavedStateReader.D(bundleA, "android-support-nav:controller:backStack").toArray(new Bundle[0]) : null;
        this.f49353n.clear();
        if (SavedStateReader.b(bundleA, "android-support-nav:controller:backStackDestIds") && SavedStateReader.b(bundleA, "android-support-nav:controller:backStackIds")) {
            int[] iArrT = SavedStateReader.t(bundleA, "android-support-nav:controller:backStackDestIds");
            List listL = SavedStateReader.L(bundleA, "android-support-nav:controller:backStackIds");
            int length = iArrT.length;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 1;
                this.f49352m.put(Integer.valueOf(iArrT[i3]), !Intrinsics.areEqual(listL.get(i4), "") ? (String) listL.get(i4) : null);
                i3++;
                i4 = i5;
            }
        }
        if (SavedStateReader.b(bundleA, "android-support-nav:controller:backStackStates")) {
            for (String str : SavedStateReader.L(bundleA, "android-support-nav:controller:backStackStates")) {
                if (SavedStateReader.b(bundleA, "android-support-nav:controller:backStackStates:" + str)) {
                    List listD = SavedStateReader.D(bundleA, "android-support-nav:controller:backStackStates:" + str);
                    Map map = this.f49353n;
                    ArrayDeque arrayDeque = new ArrayDeque(listD.size());
                    Iterator it = listD.iterator();
                    while (it.hasNext()) {
                        arrayDeque.add(new NavBackStackEntryState((Bundle) it.next()));
                    }
                    map.put(str, arrayDeque);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.navigation.NavDestination, androidx.navigation.NavGraph] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.navigation.NavGraph, java.lang.Object] */
    public final NavDestination C(NavDestination destination, int i3, boolean z2, NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.o() == i3 && (navDestination == null || (Intrinsics.areEqual(destination, navDestination) && Intrinsics.areEqual(destination.s(), navDestination.s())))) {
            return destination;
        }
        ?? S = destination instanceof NavGraph ? (NavGraph) destination : 0;
        if (S == 0) {
            S = destination.s();
            Intrinsics.checkNotNull(S);
        }
        return S.M(i3, S, z2, navDestination);
    }

    public final String E(int[] deepLink) {
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        NavGraph navGraph2 = this.f49342c;
        int length = deepLink.length;
        int i3 = 0;
        while (true) {
            NavDestination navDestinationJ = null;
            if (i3 >= length) {
                return null;
            }
            int i4 = deepLink[i3];
            if (i3 == 0) {
                NavGraph navGraph3 = this.f49342c;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.o() == i4) {
                    navDestinationJ = this.f49342c;
                }
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestinationJ = navGraph2.J(i4);
            }
            if (navDestinationJ == null) {
                return NavDestination.f48864g.d(N(), i4);
            }
            if (i3 != deepLink.length - 1 && (navDestinationJ instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestinationJ;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.J(navGraph.P()) instanceof NavGraph)) {
                        break;
                    }
                    navDestinationJ = navGraph.J(navGraph.P());
                }
                navGraph2 = navGraph;
            }
            i3++;
        }
    }

    public final Bundle E0() {
        Pair[] pairArr;
        Bundle bundleB;
        Pair[] pairArr2;
        Pair[] pairArr3;
        Pair[] pairArr4;
        Pair[] pairArr5;
        ArrayList arrayList = new ArrayList();
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
        Bundle bundleB2 = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB2);
        for (Map.Entry entry2 : this.f49359t.f().entrySet()) {
            String str = (String) entry2.getKey();
            Bundle bundleM = ((Navigator) entry2.getValue()).m();
            if (bundleM != null) {
                arrayList.add(str);
                SavedStateWriter.A(SavedStateWriter.a(bundleB2), str, bundleM);
            }
        }
        if (arrayList.isEmpty()) {
            bundleB = null;
        } else {
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr5 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry3 : mapEmptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.a((String) entry3.getKey(), entry3.getValue()));
                }
                pairArr5 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr5, pairArr5.length));
            Bundle bundleA = SavedStateWriter.a(bundleB);
            SavedStateWriter.H(SavedStateWriter.a(bundleB2), "android-support-nav:controller:navigatorState:names", arrayList);
            SavedStateWriter.A(bundleA, "android-support-nav:controller:navigatorState", bundleB2);
        }
        if (!this.f49345f.isEmpty()) {
            if (bundleB == null) {
                Map mapEmptyMap3 = MapsKt.emptyMap();
                if (mapEmptyMap3.isEmpty()) {
                    pairArr4 = new Pair[0];
                } else {
                    ArrayList arrayList4 = new ArrayList(mapEmptyMap3.size());
                    for (Map.Entry entry4 : mapEmptyMap3.entrySet()) {
                        arrayList4.add(TuplesKt.a((String) entry4.getKey(), entry4.getValue()));
                    }
                    pairArr4 = (Pair[]) arrayList4.toArray(new Pair[0]);
                }
                bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr4, pairArr4.length));
                SavedStateWriter.a(bundleB);
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator<E> it = this.f49345f.iterator();
            while (it.hasNext()) {
                arrayList5.add(new NavBackStackEntryState((NavBackStackEntry) it.next()).f());
            }
            SavedStateWriter.B(SavedStateWriter.a(bundleB), "android-support-nav:controller:backStack", arrayList5);
        }
        if (!this.f49352m.isEmpty()) {
            if (bundleB == null) {
                Map mapEmptyMap4 = MapsKt.emptyMap();
                if (mapEmptyMap4.isEmpty()) {
                    pairArr3 = new Pair[0];
                } else {
                    ArrayList arrayList6 = new ArrayList(mapEmptyMap4.size());
                    for (Map.Entry entry5 : mapEmptyMap4.entrySet()) {
                        arrayList6.add(TuplesKt.a((String) entry5.getKey(), entry5.getValue()));
                    }
                    pairArr3 = (Pair[]) arrayList6.toArray(new Pair[0]);
                }
                bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr3, pairArr3.length));
                SavedStateWriter.a(bundleB);
            }
            int[] iArr = new int[this.f49352m.size()];
            ArrayList arrayList7 = new ArrayList();
            int i3 = 0;
            for (Map.Entry entry6 : this.f49352m.entrySet()) {
                int iIntValue = ((Number) entry6.getKey()).intValue();
                String str2 = (String) entry6.getValue();
                int i4 = i3 + 1;
                iArr[i3] = iIntValue;
                if (str2 == null) {
                    str2 = "";
                }
                arrayList7.add(str2);
                i3 = i4;
            }
            Bundle bundleA2 = SavedStateWriter.a(bundleB);
            SavedStateWriter.r(bundleA2, "android-support-nav:controller:backStackDestIds", iArr);
            SavedStateWriter.H(bundleA2, "android-support-nav:controller:backStackIds", arrayList7);
        }
        if (!this.f49353n.isEmpty()) {
            if (bundleB == null) {
                Map mapEmptyMap5 = MapsKt.emptyMap();
                if (mapEmptyMap5.isEmpty()) {
                    pairArr2 = new Pair[0];
                } else {
                    ArrayList arrayList8 = new ArrayList(mapEmptyMap5.size());
                    for (Map.Entry entry7 : mapEmptyMap5.entrySet()) {
                        arrayList8.add(TuplesKt.a((String) entry7.getKey(), entry7.getValue()));
                    }
                    pairArr2 = (Pair[]) arrayList8.toArray(new Pair[0]);
                }
                bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
                SavedStateWriter.a(bundleB);
            }
            ArrayList arrayList9 = new ArrayList();
            for (Map.Entry entry8 : this.f49353n.entrySet()) {
                String str3 = (String) entry8.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) entry8.getValue();
                arrayList9.add(str3);
                ArrayList arrayList10 = new ArrayList();
                Iterator<E> it2 = arrayDeque.iterator();
                while (it2.hasNext()) {
                    arrayList10.add(((NavBackStackEntryState) it2.next()).f());
                }
                SavedStateWriter.B(SavedStateWriter.a(bundleB), "android-support-nav:controller:backStackStates:" + str3, arrayList10);
            }
            SavedStateWriter.H(SavedStateWriter.a(bundleB), "android-support-nav:controller:backStackStates", arrayList9);
        }
        return bundleB;
    }

    public final String F(Object route) {
        Intrinsics.checkNotNullParameter(route, "route");
        NavDestination navDestinationD = D(this, L(), RouteSerializerKt.j(SerializersKt.c(Reflection.b(route.getClass()))), true, null, 8, null);
        if (navDestinationD == null) {
            throw new IllegalArgumentException(("Destination with route " + Reflection.b(route.getClass()).m() + " cannot be found in navigation graph " + this.f49342c).toString());
        }
        Map mapH = navDestinationD.h();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapH.size()));
        for (Map.Entry entry : mapH.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).a());
        }
        return RouteSerializerKt.r(route, linkedHashMap);
    }

    public final void F0(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        G0(graph, null);
    }

    public final ArrayDeque G() {
        return this.f49345f;
    }

    public final void G0(NavGraph graph, Bundle bundle) {
        NavControllerImpl navControllerImpl;
        Intrinsics.checkNotNullParameter(graph, "graph");
        if (!this.f49345f.isEmpty() && M() == Lifecycle.State.f39947a) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        }
        int i3 = 0;
        if (!Intrinsics.areEqual(this.f49342c, graph)) {
            NavGraph navGraph = this.f49342c;
            if (navGraph != null) {
                ArrayList arrayList = new ArrayList(this.f49352m.keySet());
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    Integer num = (Integer) obj;
                    Intrinsics.checkNotNull(num);
                    p(num.intValue());
                }
                navControllerImpl = this;
                u0(navControllerImpl, navGraph.o(), true, false, 4, null);
            } else {
                navControllerImpl = this;
            }
            navControllerImpl.f49342c = graph;
            i0(bundle);
            return;
        }
        int iQ = graph.N().q();
        while (i3 < iQ) {
            NavDestination navDestination = (NavDestination) graph.N().r(i3);
            NavGraph navGraph2 = this.f49342c;
            Intrinsics.checkNotNull(navGraph2);
            int iK = navGraph2.N().k(i3);
            NavGraph navGraph3 = this.f49342c;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.N().p(iK, navDestination);
            i3++;
        }
        for (NavBackStackEntry navBackStackEntry : this.f49345f) {
            List<NavDestination> listAsReversed = CollectionsKt.asReversed(SequencesKt.S(NavDestination.f48864g.e(navBackStackEntry.d())));
            NavDestination navDestinationJ = this.f49342c;
            Intrinsics.checkNotNull(navDestinationJ);
            for (NavDestination navDestination2 : listAsReversed) {
                if (!Intrinsics.areEqual(navDestination2, this.f49342c) || !Intrinsics.areEqual(navDestinationJ, graph)) {
                    if (navDestinationJ instanceof NavGraph) {
                        navDestinationJ = ((NavGraph) navDestinationJ).J(navDestination2.o());
                        Intrinsics.checkNotNull(navDestinationJ);
                    }
                }
            }
            navBackStackEntry.n(navDestinationJ);
        }
    }

    public final NavBackStackEntry H(int i3) {
        Object objPrevious;
        ArrayDeque arrayDeque = this.f49345f;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((NavBackStackEntry) objPrevious).d().o() == i3) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i3 + " is on the NavController's back stack. The current destination is " + K()).toString());
    }

    public final void H0(LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (Intrinsics.areEqual(owner, this.f49354o)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.f49354o;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.f49358s);
        }
        this.f49354o = owner;
        owner.getLifecycle().addObserver(this.f49358s);
    }

    public final NavBackStackEntry I(String route) {
        Object objPrevious;
        Intrinsics.checkNotNullParameter(route, "route");
        ArrayDeque arrayDeque = this.f49345f;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
            if (navBackStackEntry.d().u(route, navBackStackEntry.b())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + K()).toString());
    }

    public final void I0(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        NavControllerViewModel navControllerViewModel = this.f49355p;
        NavControllerViewModel.Companion companion = NavControllerViewModel.f48812b;
        if (Intrinsics.areEqual(navControllerViewModel, companion.a(viewModelStore))) {
            return;
        }
        if (!this.f49345f.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.f49355p = companion.a(viewModelStore);
    }

    public final NavBackStackEntry J() {
        return (NavBackStackEntry) this.f49345f.lastOrNull();
    }

    public final NavBackStackEntry J0(NavBackStackEntry child) {
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49350k.remove(child);
        if (navBackStackEntry == null) {
            return null;
        }
        AtomicInt atomicInt = (AtomicInt) this.f49351l.get(navBackStackEntry);
        Integer numValueOf = atomicInt != null ? Integer.valueOf(atomicInt.a()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.f49360u.get(this.f49359t.e(navBackStackEntry.d().q()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.f(navBackStackEntry);
            }
            this.f49351l.remove(navBackStackEntry);
        }
        return navBackStackEntry;
    }

    public final NavDestination K() {
        NavBackStackEntry navBackStackEntryJ = J();
        if (navBackStackEntryJ != null) {
            return navBackStackEntryJ.d();
        }
        return null;
    }

    public final void K0() {
        AtomicInt atomicInt;
        StateFlow stateFlowD;
        Set set;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.f49345f);
        if (mutableList.isEmpty()) {
            return;
        }
        NavDestination navDestinationD = ((NavBackStackEntry) CollectionsKt.last(mutableList)).d();
        List listMutableListOf = CollectionsKt.mutableListOf(navDestinationD);
        if (navDestinationD instanceof SupportingPane) {
            boolean z2 = navDestinationD instanceof FloatingWindow;
            Iterator it = CollectionsKt.drop(CollectionsKt.reversed(mutableList), 1).iterator();
            while (it.hasNext()) {
                NavDestination navDestinationD2 = ((NavBackStackEntry) it.next()).d();
                if (z2 && !(navDestinationD2 instanceof FloatingWindow) && !(navDestinationD2 instanceof NavGraph)) {
                    break;
                }
                listMutableListOf.add(navDestinationD2);
                if (!(navDestinationD2 instanceof SupportingPane) && !(navDestinationD2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (CollectionsKt.last(listMutableListOf) instanceof FloatingWindow) {
            Iterator it2 = CollectionsKt.reversed(mutableList).iterator();
            while (it2.hasNext()) {
                NavDestination navDestinationD3 = ((NavBackStackEntry) it2.next()).d();
                arrayList.add(navDestinationD3);
                if (!(navDestinationD3 instanceof FloatingWindow) && !(navDestinationD3 instanceof SupportingPane) && !(navDestinationD3 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State stateH = navBackStackEntry.h();
            NavDestination navDestinationD4 = navBackStackEntry.d();
            NavDestination navDestination = (NavDestination) CollectionsKt.firstOrNull(listMutableListOf);
            if (navDestination != null && navDestination.o() == navDestinationD4.o()) {
                Lifecycle.State state = Lifecycle.State.f39951f;
                if (stateH != state) {
                    NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.f49360u.get(O().e(navBackStackEntry.d().q()));
                    if (Intrinsics.areEqual((navControllerNavigatorState == null || (stateFlowD = navControllerNavigatorState.d()) == null || (set = (Set) stateFlowD.getValue()) == null) ? null : Boolean.valueOf(set.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInt = (AtomicInt) this.f49351l.get(navBackStackEntry)) != null && atomicInt.b() == 0)) {
                        map.put(navBackStackEntry, Lifecycle.State.f39950d);
                    } else {
                        map.put(navBackStackEntry, state);
                    }
                }
                NavDestination navDestination2 = (NavDestination) CollectionsKt.firstOrNull((List) arrayList);
                if (navDestination2 != null && navDestination2.o() == navDestinationD4.o()) {
                    CollectionsKt.removeFirst(arrayList);
                }
                CollectionsKt.removeFirst(listMutableListOf);
                NavGraph navGraphS = navDestinationD4.s();
                if (navGraphS != null) {
                    listMutableListOf.add(navGraphS);
                }
            } else if (arrayList.isEmpty() || navDestinationD4.o() != ((NavDestination) CollectionsKt.first((List) arrayList)).o()) {
                navBackStackEntry.p(Lifecycle.State.f39949c);
            } else {
                NavDestination navDestination3 = (NavDestination) CollectionsKt.removeFirst(arrayList);
                if (stateH == Lifecycle.State.f39951f) {
                    navBackStackEntry.p(Lifecycle.State.f39950d);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.f39950d;
                    if (stateH != state2) {
                        map.put(navBackStackEntry, state2);
                    }
                }
                NavGraph navGraphS2 = navDestination3.s();
                if (navGraphS2 != null && !arrayList.contains(navGraphS2)) {
                    arrayList.add(navGraphS2);
                }
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : mutableList) {
            Lifecycle.State state3 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.p(state3);
            } else {
                navBackStackEntry2.q();
            }
        }
    }

    public final NavGraph L() {
        NavGraph navGraph = this.f49342c;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return navGraph;
    }

    public final Lifecycle.State M() {
        return this.f49354o == null ? Lifecycle.State.f39949c : this.f49357r;
    }

    public final NavContext N() {
        return this.f49340a.y();
    }

    public final NavigatorProvider O() {
        return this.f49359t;
    }

    public final NavBackStackEntry P() {
        Object next;
        Iterator it = CollectionsKt.reversed(this.f49345f).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.e(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!(((NavBackStackEntry) next).d() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) next;
    }

    public final NavGraph Q() {
        NavDestination navDestinationD;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49345f.lastOrNull();
        if (navBackStackEntry == null || (navDestinationD = navBackStackEntry.d()) == null) {
            navDestinationD = this.f49342c;
            Intrinsics.checkNotNull(navDestinationD);
        }
        NavGraph navGraph = navDestinationD instanceof NavGraph ? (NavGraph) navDestinationD : null;
        if (navGraph != null) {
            return navGraph;
        }
        NavGraph navGraphS = navDestinationD.s();
        Intrinsics.checkNotNull(navGraphS);
        return navGraphS;
    }

    public final StateFlow R() {
        return this.f49349j;
    }

    public final MutableSharedFlow S() {
        return this.A;
    }

    public final NavGraph T() {
        return this.f49342c;
    }

    public final NavigatorProvider U() {
        return this.f49359t;
    }

    public final void Z(NavBackStackEntry child, NavBackStackEntry parent) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f49350k.put(child, parent);
        if (this.f49351l.get(parent) == null) {
            this.f49351l.put(parent, new AtomicInt(0));
        }
        Object obj = this.f49351l.get(parent);
        Intrinsics.checkNotNull(obj);
        ((AtomicInt) obj).c();
    }

    public final void a0(NavController.NavControllerNavigatorState state, NavBackStackEntry entry, Function0 superCallback) {
        NavControllerViewModel navControllerViewModel;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        boolean zAreEqual = Intrinsics.areEqual(this.f49363x.get(entry), Boolean.TRUE);
        superCallback.invoke();
        this.f49363x.remove(entry);
        if (this.f49345f.contains(entry)) {
            if (state.e()) {
                return;
            }
            K0();
            this.f49346g.c(CollectionsKt.toMutableList((Collection) this.f49345f));
            this.f49348i.c(x0());
            return;
        }
        J0(entry);
        if (entry.getLifecycle().getCurrentState().b(Lifecycle.State.f39949c)) {
            entry.p(Lifecycle.State.f39947a);
        }
        ArrayDeque arrayDeque = this.f49345f;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).f(), entry.f())) {
                    break;
                }
            }
            if (!zAreEqual && (navControllerViewModel = this.f49355p) != null) {
                navControllerViewModel.y0(entry.f());
            }
        } else if (!zAreEqual) {
            navControllerViewModel.y0(entry.f());
        }
        K0();
        this.f49348i.c(x0());
    }

    public final void c0(final NavDestination node, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        boolean z2;
        boolean z3;
        boolean zR0;
        Intrinsics.checkNotNullParameter(node, "node");
        Iterator it = this.f49360u.values().iterator();
        while (it.hasNext()) {
            ((NavController.NavControllerNavigatorState) it.next()).n(true);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (navOptions == null) {
            z2 = false;
        } else {
            if (navOptions.f() != null) {
                String strF = navOptions.f();
                Intrinsics.checkNotNull(strF);
                zR0 = t0(strF, navOptions.i(), navOptions.k());
            } else if (navOptions.g() != null) {
                KClass kClassG = navOptions.g();
                Intrinsics.checkNotNull(kClassG);
                zR0 = r0(RouteSerializerKt.j(SerializersKt.c(kClassG)), navOptions.i(), navOptions.k());
            } else if (navOptions.h() != null) {
                Object objH = navOptions.h();
                Intrinsics.checkNotNull(objH);
                zR0 = s0(objH, navOptions.i(), navOptions.k());
            } else {
                if (navOptions.e() != -1) {
                    zR0 = r0(navOptions.e(), navOptions.i(), navOptions.k());
                }
                z2 = false;
            }
            z2 = zR0;
        }
        final Bundle bundleD = node.d(bundle);
        if (navOptions != null && navOptions.l() && this.f49352m.containsKey(Integer.valueOf(node.o()))) {
            booleanRef.f140137a = C0(node.o(), bundleD, navOptions, extras);
            z3 = false;
        } else {
            z3 = navOptions != null && navOptions.j() && W(node, bundle);
            if (!z3) {
                h0(this.f49359t.e(node.q()), CollectionsKt.listOf(NavBackStackEntry.Companion.b(NavBackStackEntry.f48787k, N(), node, bundleD, M(), this.f49355p, null, null, 96, null)), navOptions, extras, new Function1() { // from class: androidx.navigation.internal.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavControllerImpl.b0(booleanRef, this, node, bundleD, (NavBackStackEntry) obj);
                    }
                });
            }
        }
        this.f49341b.invoke();
        Iterator it2 = this.f49360u.values().iterator();
        while (it2.hasNext()) {
            ((NavController.NavControllerNavigatorState) it2.next()).n(false);
        }
        if (z2 || booleanRef.f140137a || z3) {
            r();
        } else {
            K0();
        }
    }

    public final void d0(Object route, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(route, "route");
        e0(F(route), navOptions, extras);
    }

    public final void e0(String route, NavOptions navOptions, Navigator.Extras extras) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this.f49342c == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + route + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        NavGraph navGraphQ = Q();
        NavDestination.DeepLinkMatch deepLinkMatchS = navGraphQ.S(route, true, true, navGraphQ);
        if (deepLinkMatchS == null) {
            throw new IllegalArgumentException("Navigation destination that matches route " + route + " cannot be found in the navigation graph " + this.f49342c);
        }
        NavDestination navDestinationB = deepLinkMatchS.b();
        Bundle bundleD = navDestinationB.d(deepLinkMatchS.c());
        if (bundleD == null) {
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
            bundleD = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            SavedStateWriter.a(bundleD);
        }
        NavDestination navDestinationB2 = deepLinkMatchS.b();
        this.f49340a.h0(NavDeepLinkRequest.Builder.f48860d.a(NavUriKt.a(NavDestination.f48864g.c(navDestinationB.t()))).a(), bundleD);
        c0(navDestinationB2, bundleD, navOptions, extras);
    }

    public final void f0(String route, Function1 builder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(builder, "builder");
        g0(this, route, NavOptionsBuilderKt.a(builder), null, 4, null);
    }

    public final void h0(Navigator navigator, List entries, NavOptions navOptions, Navigator.Extras extras, Function1 handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f49361v = handler;
        navigator.g(entries, navOptions, extras);
        this.f49361v = null;
    }

    public final void i0(Bundle bundle) {
        Bundle bundle2 = this.f49343d;
        if (bundle2 != null) {
            Bundle bundleA = SavedStateReader.a(bundle2);
            if (SavedStateReader.b(bundleA, "android-support-nav:controller:navigatorState:names")) {
                for (String str : SavedStateReader.L(bundleA, "android-support-nav:controller:navigatorState:names")) {
                    Navigator navigatorE = this.f49359t.e(str);
                    if (SavedStateReader.b(bundleA, str)) {
                        navigatorE.l(SavedStateReader.C(bundleA, str));
                    }
                }
            }
        }
        Bundle[] bundleArr = this.f49344e;
        int i3 = 0;
        if (bundleArr != null) {
            for (Bundle bundle3 : bundleArr) {
                NavBackStackEntryState navBackStackEntryState = new NavBackStackEntryState(bundle3);
                NavDestination navDestinationB = B(this, navBackStackEntryState.b(), null, 2, null);
                if (navDestinationB == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.f48864g.d(N(), navBackStackEntryState.b()) + " cannot be found from the current destination " + K());
                }
                NavBackStackEntry navBackStackEntryD = navBackStackEntryState.d(N(), navDestinationB, M(), this.f49355p);
                Navigator navigatorE2 = this.f49359t.e(navDestinationB.q());
                Map map = this.f49360u;
                Object objK = map.get(navigatorE2);
                if (objK == null) {
                    objK = this.f49340a.k(navigatorE2);
                    map.put(navigatorE2, objK);
                }
                this.f49345f.add(navBackStackEntryD);
                ((NavController.NavControllerNavigatorState) objK).q(navBackStackEntryD);
                NavGraph navGraphS = navBackStackEntryD.d().s();
                if (navGraphS != null) {
                    Z(navBackStackEntryD, H(navGraphS.o()));
                }
            }
            this.f49341b.invoke();
            this.f49344e = null;
        }
        Collection collectionValues = this.f49359t.f().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Navigator) obj).e()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            Navigator navigator = (Navigator) obj2;
            Map map2 = this.f49360u;
            Object objK2 = map2.get(navigator);
            if (objK2 == null) {
                objK2 = this.f49340a.k(navigator);
                map2.put(navigator, objK2);
            }
            navigator.i((NavController.NavControllerNavigatorState) objK2);
        }
        if (this.f49342c == null || !this.f49345f.isEmpty()) {
            r();
        } else {
            if (this.f49340a.i()) {
                return;
            }
            NavGraph navGraph = this.f49342c;
            Intrinsics.checkNotNull(navGraph);
            c0(navGraph, bundle, null, null);
        }
    }

    public final void k0(NavController.NavControllerNavigatorState state, NavBackStackEntry popUpTo, boolean z2, final Function0 superCallback) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(superCallback, "superCallback");
        Navigator navigatorE = this.f49359t.e(popUpTo.d().q());
        this.f49363x.put(popUpTo, Boolean.valueOf(z2));
        if (!Intrinsics.areEqual(navigatorE, state.r())) {
            Object obj = this.f49360u.get(navigatorE);
            Intrinsics.checkNotNull(obj);
            ((NavController.NavControllerNavigatorState) obj).i(popUpTo, z2);
        } else {
            Function1 function1 = this.f49362w;
            if (function1 == null) {
                p0(popUpTo, new Function0() { // from class: androidx.navigation.internal.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavControllerImpl.j0(superCallback);
                    }
                });
            } else {
                function1.invoke(popUpTo);
                superCallback.invoke();
            }
        }
    }

    public final boolean l0() {
        if (this.f49345f.isEmpty()) {
            return false;
        }
        NavDestination navDestinationK = K();
        Intrinsics.checkNotNull(navDestinationK);
        return m0(navDestinationK.o(), true);
    }

    public final boolean m0(int i3, boolean z2) {
        return n0(i3, z2, false);
    }

    public final boolean n0(int i3, boolean z2, boolean z3) {
        return r0(i3, z2, z3) && r();
    }

    public final boolean o0(Object route, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(route, "route");
        return s0(route, z2, z3) && r();
    }

    public final boolean p(int i3) {
        Iterator it = this.f49360u.values().iterator();
        while (it.hasNext()) {
            ((NavController.NavControllerNavigatorState) it.next()).n(true);
        }
        boolean zC0 = C0(i3, null, NavOptionsBuilderKt.a(new Function1() { // from class: androidx.navigation.internal.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavControllerImpl.o((NavOptionsBuilder) obj);
            }
        }), null);
        Iterator it2 = this.f49360u.values().iterator();
        while (it2.hasNext()) {
            ((NavController.NavControllerNavigatorState) it2.next()).n(false);
        }
        return zC0 && r0(i3, true, false);
    }

    public final void p0(NavBackStackEntry popUpTo, Function0 onComplete) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        int iIndexOf = this.f49345f.indexOf(popUpTo);
        if (iIndexOf < 0) {
            Log.f49317a.a("NavController", "Ignoring pop of " + popUpTo + " as it was not found on the current back stack");
            return;
        }
        int i3 = iIndexOf + 1;
        if (i3 != this.f49345f.size()) {
            r0(((NavBackStackEntry) this.f49345f.get(i3)).d().o(), true, false);
        }
        w0(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        this.f49341b.invoke();
        r();
    }

    public final NavBackStackEntry q(NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return NavBackStackEntry.Companion.b(NavBackStackEntry.f48787k, N(), destination, bundle, M(), this.f49355p, null, null, 96, null);
    }

    public final void q0(Navigator navigator, NavBackStackEntry popUpTo, boolean z2, Function1 handler) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f49362w = handler;
        navigator.n(popUpTo, z2);
        this.f49362w = null;
    }

    public final boolean r() {
        while (!this.f49345f.isEmpty() && (((NavBackStackEntry) this.f49345f.last()).d() instanceof NavGraph)) {
            w0(this, (NavBackStackEntry) this.f49345f.last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49345f.lastOrNull();
        if (navBackStackEntry != null) {
            this.f49365z.add(navBackStackEntry);
        }
        this.f49364y++;
        K0();
        int i3 = this.f49364y - 1;
        this.f49364y = i3;
        if (i3 == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.f49365z);
            this.f49365z.clear();
            for (NavBackStackEntry navBackStackEntry2 : mutableList) {
                Iterator it = CollectionsKt.toList(this.f49356q).iterator();
                while (it.hasNext()) {
                    ((NavController.OnDestinationChangedListener) it.next()).a(this.f49340a, navBackStackEntry2.d(), navBackStackEntry2.b());
                }
                this.A.c(navBackStackEntry2);
            }
            this.f49346g.c(CollectionsKt.toMutableList((Collection) this.f49345f));
            this.f49348i.c(x0());
        }
        return navBackStackEntry != null;
    }

    public final boolean r0(int i3, boolean z2, boolean z3) {
        NavDestination navDestinationD;
        if (this.f49345f.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.f49345f).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestinationD = null;
                break;
            }
            navDestinationD = ((NavBackStackEntry) it.next()).d();
            Navigator navigatorE = this.f49359t.e(navDestinationD.q());
            if (z2 || navDestinationD.o() != i3) {
                arrayList.add(navigatorE);
            }
            if (navDestinationD.o() == i3) {
                break;
            }
        }
        if (navDestinationD != null) {
            return x(arrayList, navDestinationD, z2, z3);
        }
        String strD = NavDestination.f48864g.d(N(), i3);
        Log.f49317a.a("NavController", "Ignoring popBackStack to destination " + strD + " as it was not found on the current back stack");
        return false;
    }

    public final boolean s0(Object route, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(route, "route");
        return t0(F(route), z2, z3);
    }

    public final boolean t0(String route, boolean z2, boolean z3) {
        Object objPrevious;
        Intrinsics.checkNotNullParameter(route, "route");
        if (this.f49345f.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = this.f49345f;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
            boolean zU = navBackStackEntry.d().u(route, navBackStackEntry.b());
            if (z2 || !zU) {
                arrayList.add(this.f49359t.e(navBackStackEntry.d().q()));
            }
            if (zU) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
        NavDestination navDestinationD = navBackStackEntry2 != null ? navBackStackEntry2.d() : null;
        if (navDestinationD != null) {
            return x(arrayList, navDestinationD, z2, z3);
        }
        Log.f49317a.a("NavController", "Ignoring popBackStack to route " + route + " as it was not found on the current back stack");
        return false;
    }

    public final void v0(NavBackStackEntry popUpTo, boolean z2, ArrayDeque savedState) {
        NavControllerViewModel navControllerViewModel;
        StateFlow stateFlowD;
        Set set;
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f49345f.last();
        if (!Intrinsics.areEqual(navBackStackEntry, popUpTo)) {
            throw new IllegalStateException(("Attempted to pop " + popUpTo.d() + ", which is not the top of the back stack (" + navBackStackEntry.d() + ')').toString());
        }
        CollectionsKt.removeLast(this.f49345f);
        NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.f49360u.get(O().e(navBackStackEntry.d().q()));
        boolean z3 = true;
        if ((navControllerNavigatorState == null || (stateFlowD = navControllerNavigatorState.d()) == null || (set = (Set) stateFlowD.getValue()) == null || !set.contains(navBackStackEntry)) && !this.f49351l.containsKey(navBackStackEntry)) {
            z3 = false;
        }
        Lifecycle.State currentState = navBackStackEntry.getLifecycle().getCurrentState();
        Lifecycle.State state = Lifecycle.State.f39949c;
        if (currentState.b(state)) {
            if (z2) {
                navBackStackEntry.p(state);
                savedState.addFirst(new NavBackStackEntryState(navBackStackEntry));
            }
            if (z3) {
                navBackStackEntry.p(state);
            } else {
                navBackStackEntry.p(Lifecycle.State.f39947a);
                J0(navBackStackEntry);
            }
        }
        if (z2 || z3 || (navControllerViewModel = this.f49355p) == null) {
            return;
        }
        navControllerViewModel.y0(navBackStackEntry.f());
    }

    public final boolean x(List popOperations, NavDestination foundDestination, boolean z2, boolean z3) {
        final NavControllerImpl navControllerImpl;
        final boolean z4;
        Intrinsics.checkNotNullParameter(popOperations, "popOperations");
        Intrinsics.checkNotNullParameter(foundDestination, "foundDestination");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque arrayDeque = new ArrayDeque();
        Iterator it = popOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                navControllerImpl = this;
                z4 = z3;
                break;
            }
            Navigator navigator = (Navigator) it.next();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            navControllerImpl = this;
            z4 = z3;
            q0(navigator, (NavBackStackEntry) this.f49345f.last(), z4, new Function1() { // from class: androidx.navigation.internal.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavControllerImpl.s(booleanRef2, booleanRef, navControllerImpl, z4, arrayDeque, (NavBackStackEntry) obj);
                }
            });
            if (!booleanRef2.f140137a) {
                break;
            }
            z3 = z4;
        }
        if (z4) {
            if (!z2) {
                for (NavDestination navDestination : SequencesKt.Q(SequencesKt.h(foundDestination, new Function1() { // from class: androidx.navigation.internal.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavControllerImpl.t((NavDestination) obj);
                    }
                }), new Function1() { // from class: androidx.navigation.internal.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavControllerImpl.u(this.f49395a, (NavDestination) obj));
                    }
                })) {
                    Map map = navControllerImpl.f49352m;
                    Integer numValueOf = Integer.valueOf(navDestination.o());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    map.put(numValueOf, navBackStackEntryState != null ? navBackStackEntryState.c() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                Iterator it2 = SequencesKt.Q(SequencesKt.h(B(this, navBackStackEntryState2.b(), null, 2, null), new Function1() { // from class: androidx.navigation.internal.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavControllerImpl.v((NavDestination) obj);
                    }
                }), new Function1() { // from class: androidx.navigation.internal.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavControllerImpl.w(this.f49396a, (NavDestination) obj));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    navControllerImpl.f49352m.put(Integer.valueOf(((NavDestination) it2.next()).o()), navBackStackEntryState2.c());
                }
                if (navControllerImpl.f49352m.values().contains(navBackStackEntryState2.c())) {
                    navControllerImpl.f49353n.put(navBackStackEntryState2.c(), arrayDeque);
                }
            }
        }
        navControllerImpl.f49341b.invoke();
        return booleanRef.f140137a;
    }

    public final List x0() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f49360u.values().iterator();
        while (it.hasNext()) {
            Iterable iterable = (Iterable) ((NavController.NavControllerNavigatorState) it.next()).d().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.h().b(Lifecycle.State.f39950d)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayDeque arrayDeque = this.f49345f;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.h().b(Lifecycle.State.f39950d)) {
                arrayList3.add(obj2);
            }
        }
        CollectionsKt.addAll(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj3 = arrayList.get(i3);
            i3++;
            if (!(((NavBackStackEntry) obj3).d() instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public final void y0(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.f49345f.contains(entry)) {
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }
        entry.p(Lifecycle.State.f39950d);
    }

    public final void z0(NavController.NavControllerNavigatorState state, NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        Navigator navigatorE = this.f49359t.e(backStackEntry.d().q());
        if (!Intrinsics.areEqual(navigatorE, state.r())) {
            Object obj = this.f49360u.get(navigatorE);
            if (obj != null) {
                ((NavController.NavControllerNavigatorState) obj).l(backStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.d().q() + " should already be created").toString());
        }
        Function1 function1 = this.f49361v;
        if (function1 != null) {
            function1.invoke(backStackEntry);
            state.q(backStackEntry);
            return;
        }
        Log.f49317a.a("NavController", "Ignoring add of destination " + backStackEntry.d() + " outside of the call to navigate(). ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, HcgZcEUYo.iEKWAizLJHB);
        return navDestination.o();
    }
}
