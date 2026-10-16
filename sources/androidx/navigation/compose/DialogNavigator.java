package androidx.navigation.compose;

import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes3.dex */
@Navigator.Name("dialog")
@Metadata
public final class DialogNavigator extends Navigator<Destination> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f49083d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49084e = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DialogNavigator() {
        super("dialog");
    }

    @Override // androidx.navigation.Navigator
    public void g(List list, NavOptions navOptions, Navigator.Extras extras) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d().l((NavBackStackEntry) it.next());
        }
    }

    @Override // androidx.navigation.Navigator
    public void n(NavBackStackEntry navBackStackEntry, boolean z2) {
        d().j(navBackStackEntry, z2);
        int iIndexOf = CollectionsKt.indexOf((Iterable<? extends NavBackStackEntry>) d().d().getValue(), navBackStackEntry);
        int i3 = 0;
        for (Object obj : (Iterable) d().d().getValue()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            if (i3 > iIndexOf) {
                t(navBackStackEntry2);
            }
            i3 = i4;
        }
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Destination c() {
        return new Destination(this, null, ComposableSingletons$DialogNavigatorKt.f49042a.a(), 2, null);
    }

    public final void q(NavBackStackEntry navBackStackEntry) {
        n(navBackStackEntry, false);
    }

    public final StateFlow r() {
        return d().c();
    }

    public final StateFlow s() {
        return d().d();
    }

    public final void t(NavBackStackEntry navBackStackEntry) {
        d().f(navBackStackEntry);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Destination extends NavDestination implements FloatingWindow {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final DialogProperties f49085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Function3 f49086j;

        public /* synthetic */ Destination(DialogNavigator dialogNavigator, DialogProperties dialogProperties, Function3 function3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(dialogNavigator, (i3 & 2) != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties, function3);
        }

        public final Function3 H() {
            return this.f49086j;
        }

        public final DialogProperties I() {
            return this.f49085i;
        }

        public Destination(DialogNavigator dialogNavigator, DialogProperties dialogProperties, Function3 function3) {
            super(dialogNavigator);
            this.f49085i = dialogProperties;
            this.f49086j = function3;
        }
    }
}
