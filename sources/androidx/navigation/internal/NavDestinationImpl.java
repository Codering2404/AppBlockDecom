package androidx.navigation.internal;

import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavArgument;
import androidx.navigation.NavArgumentKt;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavUriKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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
import kotlin.text.StringsKt;

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
public final class NavDestinationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavDestination f49366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f49367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f49368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f49369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f49370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f49371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Lazy f49372g;

    public NavDestinationImpl(NavDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.f49366a = destination;
        this.f49368c = new ArrayList();
        this.f49369d = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(NavDeepLink navDeepLink, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return !navDeepLink.q().contains(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavDeepLink f(String str) {
        return new NavDeepLink.Builder().d(str).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(NavDeepLink navDeepLink, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return !navDeepLink.q().contains(key);
    }

    private final boolean p(NavDeepLink navDeepLink, Uri uri, Map map) {
        final Bundle bundleX = navDeepLink.x(uri, map);
        return NavArgumentKt.a(map, new Function1() { // from class: androidx.navigation.internal.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NavDestinationImpl.q(bundleX, (String) obj));
            }
        }).isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return !SavedStateReader.b(SavedStateReader.a(bundle), key);
    }

    public final void g(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.f49369d.put(argumentName, argument);
    }

    public final void i(final NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        List listA = NavArgumentKt.a(this.f49369d, new Function1() { // from class: androidx.navigation.internal.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(NavDestinationImpl.h(navDeepLink, (String) obj));
            }
        });
        if (listA.isEmpty()) {
            this.f49368c.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.G() + " can't be used to open destination " + this.f49366a + ".\nFollowing required arguments are missing: " + listA).toString());
    }

    public final Bundle j(Bundle bundle) {
        Pair[] pairArr;
        if (bundle == null && this.f49369d.isEmpty()) {
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
        SavedStateWriter.a(bundleB);
        for (Map.Entry entry2 : this.f49369d.entrySet()) {
            ((NavArgument) entry2.getValue()).e((String) entry2.getKey(), bundleB);
        }
        if (bundle != null) {
            SavedStateWriter.d(SavedStateWriter.a(bundleB), bundle);
            for (Map.Entry entry3 : this.f49369d.entrySet()) {
                String str = (String) entry3.getKey();
                NavArgument navArgument = (NavArgument) entry3.getValue();
                if (!navArgument.c() && !navArgument.f(str, bundleB)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument savedState. " + navArgument.a().b() + " expected.").toString());
                }
            }
        }
        return bundleB;
    }

    public final Map k() {
        return this.f49369d;
    }

    public final List l() {
        return this.f49368c;
    }

    public final int m() {
        return this.f49370e;
    }

    public final String n() {
        return this.f49367b;
    }

    public final String o() {
        return this.f49371f;
    }

    public final boolean r(String route, Bundle bundle) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (Intrinsics.areEqual(this.f49371f, route)) {
            return true;
        }
        NavDestination.DeepLinkMatch deepLinkMatchT = t(route);
        if (Intrinsics.areEqual(this.f49366a, deepLinkMatchT != null ? deepLinkMatchT.b() : null)) {
            return deepLinkMatchT.d(bundle);
        }
        return false;
    }

    public final NavDestination.DeepLinkMatch s(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.f49368c.isEmpty()) {
            return null;
        }
        NavDestination.DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.f49368c) {
            Uri uriC = navDeepLinkRequest.c();
            if (navDeepLink.N(navDeepLinkRequest)) {
                Bundle bundleV = uriC != null ? navDeepLink.v(uriC, this.f49369d) : null;
                int iK = navDeepLink.k(uriC);
                String strA = navDeepLinkRequest.a();
                boolean z2 = strA != null && Intrinsics.areEqual(strA, navDeepLink.p());
                String strB = navDeepLinkRequest.b();
                int iC = strB != null ? navDeepLink.C(strB) : -1;
                if (bundleV == null) {
                    if (z2 || iC > -1) {
                        if (p(navDeepLink, uriC, this.f49369d)) {
                        }
                    }
                }
                NavDestination.DeepLinkMatch deepLinkMatch2 = new NavDestination.DeepLinkMatch(this.f49366a, bundleV, navDeepLink.H(), iK, z2, iC);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    public final NavDestination.DeepLinkMatch t(String route) {
        NavDeepLink navDeepLink;
        Uri uriA;
        Bundle bundleV;
        Intrinsics.checkNotNullParameter(route, "route");
        Lazy lazy = this.f49372g;
        if (lazy == null || (navDeepLink = (NavDeepLink) lazy.getValue()) == null || (bundleV = navDeepLink.v((uriA = NavUriKt.a(NavDestination.f48864g.c(route))), this.f49369d)) == null) {
            return null;
        }
        return new NavDestination.DeepLinkMatch(this.f49366a, bundleV, navDeepLink.H(), navDeepLink.k(uriA), false, -1);
    }

    public final void u(int i3) {
        this.f49370e = i3;
        this.f49367b = null;
    }

    public final void v(String str) {
        this.f49367b = str;
    }

    public final void w(String str) {
        if (str == null) {
            u(0);
        } else {
            if (StringsKt.p0(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            final String strC = NavDestination.f48864g.c(str);
            final NavDeepLink navDeepLinkA = new NavDeepLink.Builder().d(strC).a();
            List listA = NavArgumentKt.a(this.f49369d, new Function1() { // from class: androidx.navigation.internal.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(NavDestinationImpl.e(navDeepLinkA, (String) obj));
                }
            });
            if (!listA.isEmpty()) {
                throw new IllegalArgumentException(("Cannot set route \"" + str + "\" for destination " + this.f49366a + ". Following required arguments are missing: " + listA).toString());
            }
            this.f49372g = LazyKt.b(new Function0() { // from class: androidx.navigation.internal.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavDestinationImpl.f(strC);
                }
            });
            u(strC.hashCode());
        }
        this.f49371f = str;
    }
}
