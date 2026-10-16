package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
@Navigator.Name("navigation")
@Metadata
public class NavGraphNavigator extends Navigator<NavGraph> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f48894e = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final NavigatorProvider f48895d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        super("navigation");
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.f48895d = navigatorProvider;
    }

    private final void r(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.Extras extras) {
        Pair[] pairArr;
        NavDestination navDestinationD = navBackStackEntry.d();
        Intrinsics.checkNotNull(navDestinationD, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        NavGraph navGraph = (NavGraph) navDestinationD;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = navBackStackEntry.b();
        int iP = navGraph.P();
        String strQ = navGraph.Q();
        if (iP == 0 && strQ == null) {
            throw new IllegalStateException(("no start destination defined via app:startDestination for " + navGraph.n()).toString());
        }
        NavDestination navDestinationL = strQ != null ? navGraph.L(strQ, false) : (NavDestination) navGraph.N().g(iP);
        if (navDestinationL == null) {
            throw new IllegalArgumentException("navigation destination " + navGraph.O() + " is not a direct child of this NavGraph");
        }
        if (strQ != null) {
            if (!Intrinsics.areEqual(strQ, navDestinationL.t())) {
                NavDestination.DeepLinkMatch deepLinkMatchW = navDestinationL.w(strQ);
                Bundle bundleC = deepLinkMatchW != null ? deepLinkMatchW.c() : null;
                if (bundleC != null && !SavedStateReader.O(SavedStateReader.a(bundleC))) {
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
                    SavedStateWriter.d(bundleA, bundleC);
                    Bundle bundle = (Bundle) objectRef.f140144a;
                    if (bundle != null) {
                        SavedStateWriter.d(bundleA, bundle);
                    }
                    objectRef.f140144a = bundleB;
                }
            }
            if (!navDestinationL.h().isEmpty()) {
                List listA = NavArgumentKt.a(navDestinationL.h(), new Function1() { // from class: androidx.navigation.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavGraphNavigator.s(objectRef, (String) obj));
                    }
                });
                if (!listA.isEmpty()) {
                    throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestinationL + ". Missing required arguments [" + listA + ']').toString());
                }
            }
        }
        this.f48895d.e(navDestinationL.q()).g(CollectionsKt.listOf(d().b(navDestinationL, navDestinationL.d((Bundle) objectRef.f140144a))), navOptions, extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(Ref.ObjectRef objectRef, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = objectRef.f140144a;
        return obj == null || !SavedStateReader.b(SavedStateReader.a((Bundle) obj), key);
    }

    @Override // androidx.navigation.Navigator
    public void g(List entries, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            r((NavBackStackEntry) it.next(), navOptions, extras);
        }
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public NavGraph c() {
        return new NavGraph(this);
    }
}
