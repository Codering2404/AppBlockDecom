package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata
public abstract class Navigator<D extends NavDestination> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f48982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavigatorState f48983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f48984c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Extras {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Name {
        String value();
    }

    public Navigator() {
        this.f48982a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavBackStackEntry h(Navigator navigator, NavOptions navOptions, Extras extras, NavBackStackEntry backStackEntry) {
        NavDestination navDestinationF;
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        NavDestination navDestinationD = backStackEntry.d();
        if (navDestinationD == null) {
            navDestinationD = null;
        }
        if (navDestinationD == null || (navDestinationF = navigator.f(navDestinationD, backStackEntry.b(), navOptions, extras)) == null) {
            return null;
        }
        return Intrinsics.areEqual(navDestinationF, navDestinationD) ? backStackEntry : navigator.d().b(navDestinationF, navDestinationF.d(backStackEntry.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.e(true);
        return Unit.f139807a;
    }

    public abstract NavDestination c();

    protected final NavigatorState d() {
        NavigatorState navigatorState = this.f48983b;
        if (navigatorState != null) {
            return navigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public final boolean e() {
        return this.f48984c;
    }

    public NavDestination f(NavDestination destination, Bundle bundle, NavOptions navOptions, Extras extras) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return destination;
    }

    public void g(List entries, final NavOptions navOptions, final Extras extras) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Iterator it = SequencesKt.C(SequencesKt.M(CollectionsKt.asSequence(entries), new Function1() { // from class: androidx.navigation.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Navigator.h(this.f49243a, navOptions, extras, (NavBackStackEntry) obj);
            }
        })).iterator();
        while (it.hasNext()) {
            d().l((NavBackStackEntry) it.next());
        }
    }

    public void i(NavigatorState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f48983b = state;
        this.f48984c = true;
    }

    public void j(NavBackStackEntry backStackEntry) {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        NavDestination navDestinationD = backStackEntry.d();
        if (navDestinationD == null) {
            navDestinationD = null;
        }
        if (navDestinationD == null) {
            return;
        }
        f(navDestinationD, null, NavOptionsBuilderKt.a(new Function1() { // from class: androidx.navigation.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Navigator.k((NavOptionsBuilder) obj);
            }
        }), null);
        d().g(backStackEntry);
    }

    public void l(Bundle savedState) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
    }

    public Bundle m() {
        return null;
    }

    public void n(NavBackStackEntry popUpTo, boolean z2) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        List list = (List) d().c().getValue();
        if (!list.contains(popUpTo)) {
            throw new IllegalStateException(("popBackStack was called with " + popUpTo + " which does not exist in back stack " + list).toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        NavBackStackEntry navBackStackEntry = null;
        while (o()) {
            navBackStackEntry = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry, popUpTo)) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            d().i(navBackStackEntry, z2);
        }
    }

    public boolean o() {
        return true;
    }

    public Navigator(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f48982a = name;
    }
}
