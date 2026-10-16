package androidx.navigation.internal;

import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavGraphImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavGraph f49373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArrayCompat f49374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f49375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f49376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f49377e;

    public NavGraphImpl(NavGraph graph) {
        Intrinsics.checkNotNullParameter(graph, "graph");
        this.f49373a = graph;
        this.f49374b = new SparseArrayCompat(0, 1, null);
    }

    public static /* synthetic */ NavDestination h(NavGraphImpl navGraphImpl, int i3, NavDestination navDestination, boolean z2, NavDestination navDestination2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            navDestination2 = null;
        }
        return navGraphImpl.g(i3, navDestination, z2, navDestination2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(Object obj, NavDestination startDestination) {
        Intrinsics.checkNotNullParameter(startDestination, "startDestination");
        Map mapH = startDestination.h();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapH.size()));
        for (Map.Entry entry : mapH.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).a());
        }
        return RouteSerializerKt.r(obj, linkedHashMap);
    }

    public final void A(String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (Intrinsics.areEqual(str, this.f49373a.t())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this.f49373a).toString());
            }
            if (StringsKt.p0(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            iHashCode = NavDestination.f48864g.c(str).hashCode();
        }
        this.f49375c = iHashCode;
        this.f49377e = str;
    }

    public final void b(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int iO = node.o();
        String strT = node.t();
        if (iO == 0 && strT == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (this.f49373a.t() != null && Intrinsics.areEqual(strT, this.f49373a.t())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this.f49373a).toString());
        }
        if (iO == this.f49373a.o()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this.f49373a).toString());
        }
        NavDestination navDestination = (NavDestination) this.f49374b.g(iO);
        if (navDestination == node) {
            return;
        }
        if (node.s() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.D(null);
        }
        node.D(this.f49373a);
        this.f49374b.m(node.o(), node);
    }

    public final void c(Collection nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        Iterator it = nodes.iterator();
        while (it.hasNext()) {
            NavDestination navDestination = (NavDestination) it.next();
            if (navDestination != null) {
                b(navDestination);
            }
        }
    }

    public final NavDestination d(int i3) {
        return h(this, i3, this.f49373a, false, null, 8, null);
    }

    public final NavDestination e(String str) {
        if (str == null || StringsKt.p0(str)) {
            return null;
        }
        return f(str, true);
    }

    public final NavDestination f(String route, boolean z2) {
        Object next;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it = SequencesKt.e(SparseArrayKt.b(this.f49374b)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            NavDestination navDestination = (NavDestination) next;
            if (StringsKt.G(navDestination.t(), route, false, 2, null) || navDestination.w(route) != null) {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) next;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z2 || this.f49373a.s() == null) {
            return null;
        }
        NavGraph navGraphS = this.f49373a.s();
        Intrinsics.checkNotNull(navGraphS);
        return navGraphS.K(route);
    }

    public final NavDestination g(int i3, NavDestination navDestination, boolean z2, NavDestination navDestination2) {
        NavDestination navDestination3 = (NavDestination) this.f49374b.g(i3);
        if (navDestination2 != null) {
            if (Intrinsics.areEqual(navDestination3, navDestination2) && Intrinsics.areEqual(navDestination3.s(), navDestination2.s())) {
                return navDestination3;
            }
            navDestination3 = null;
        } else if (navDestination3 != null) {
            return navDestination3;
        }
        if (z2) {
            Iterator it = SequencesKt.e(SparseArrayKt.b(this.f49374b)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    navDestination3 = null;
                    break;
                }
                NavDestination navDestination4 = (NavDestination) it.next();
                NavDestination navDestinationM = (!(navDestination4 instanceof NavGraph) || Intrinsics.areEqual(navDestination4, navDestination)) ? null : ((NavGraph) navDestination4).M(i3, this.f49373a, true, navDestination2);
                if (navDestinationM != null) {
                    navDestination3 = navDestinationM;
                    break;
                }
            }
        }
        if (navDestination3 != null) {
            return navDestination3;
        }
        if (this.f49373a.s() == null || Intrinsics.areEqual(this.f49373a.s(), navDestination)) {
            return null;
        }
        NavGraph navGraphS = this.f49373a.s();
        Intrinsics.checkNotNull(navGraphS);
        return navGraphS.M(i3, this.f49373a, z2, navDestination2);
    }

    public final String i(String superName) {
        Intrinsics.checkNotNullParameter(superName, "superName");
        return this.f49373a.o() != 0 ? superName : "the root navigation";
    }

    public final SparseArrayCompat j() {
        return this.f49374b;
    }

    public final String k() {
        if (this.f49376d == null) {
            String strValueOf = this.f49377e;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.f49375c);
            }
            this.f49376d = strValueOf;
        }
        String str = this.f49376d;
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final int l() {
        return this.f49375c;
    }

    public final String m() {
        return this.f49376d;
    }

    public final int n() {
        return this.f49375c;
    }

    public final String o() {
        return this.f49377e;
    }

    public final Iterator p() {
        return new NavGraphImpl$iterator$1(this);
    }

    public final NavDestination.DeepLinkMatch q(NavDestination.DeepLinkMatch deepLinkMatch, NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return r(deepLinkMatch, navDeepLinkRequest, true, false, this.f49373a);
    }

    public final NavDestination.DeepLinkMatch r(NavDestination.DeepLinkMatch deepLinkMatch, NavDeepLinkRequest navDeepLinkRequest, boolean z2, boolean z3, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch2;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchR = null;
        if (z2) {
            NavGraph navGraph = this.f49373a;
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : navGraph) {
                NavDestination.DeepLinkMatch deepLinkMatchV = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.v(navDeepLinkRequest) : null;
                if (deepLinkMatchV != null) {
                    arrayList.add(deepLinkMatchV);
                }
            }
            deepLinkMatch2 = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch2 = null;
        }
        NavGraph navGraphS = this.f49373a.s();
        if (navGraphS != null && z3 && !Intrinsics.areEqual(navGraphS, lastVisited)) {
            deepLinkMatchR = navGraphS.R(navDeepLinkRequest, z2, true, this.f49373a);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatch, deepLinkMatch2, deepLinkMatchR}));
    }

    public final NavDestination.DeepLinkMatch s(String route, boolean z2, boolean z3, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch deepLinkMatchW = this.f49373a.w(route);
        NavDestination.DeepLinkMatch deepLinkMatchS = null;
        if (z2) {
            NavGraph navGraph = this.f49373a;
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : navGraph) {
                NavDestination.DeepLinkMatch deepLinkMatchS2 = Intrinsics.areEqual(navDestination, lastVisited) ? null : navDestination instanceof NavGraph ? ((NavGraph) navDestination).S(route, true, false, this.f49373a) : navDestination.w(route);
                if (deepLinkMatchS2 != null) {
                    arrayList.add(deepLinkMatchS2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph navGraphS = this.f49373a.s();
        if (navGraphS != null && z3 && !Intrinsics.areEqual(navGraphS, lastVisited)) {
            deepLinkMatchS = navGraphS.S(route, z2, true, this.f49373a);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{deepLinkMatchW, deepLinkMatch, deepLinkMatchS}));
    }

    public final void t(String str) {
        this.f49376d = str;
    }

    public final void v(int i3) {
        z(i3);
    }

    public final void w(final Object startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        y(SerializersKt.c(Reflection.b(startDestRoute.getClass())), new Function1() { // from class: androidx.navigation.internal.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavGraphImpl.u(startDestRoute, (NavDestination) obj);
            }
        });
    }

    public final void x(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        A(startDestRoute);
    }

    public final void y(KSerializer serializer, Function1 parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int iJ = RouteSerializerKt.j(serializer);
        NavDestination navDestinationD = d(iJ);
        if (navDestinationD != null) {
            A((String) parseRoute.invoke(navDestinationD));
            this.f49375c = iJ;
        } else {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().i() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
    }

    public final void z(int i3) {
        if (i3 != this.f49373a.o()) {
            if (this.f49377e != null) {
                A(null);
            }
            this.f49375c = i3;
            this.f49376d = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i3 + " cannot use the same id as the graph " + this.f49373a).toString());
    }
}
