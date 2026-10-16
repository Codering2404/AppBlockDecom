package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
@Navigator.Name("composable")
@Metadata
public final class ComposeNavigator extends Navigator<Destination> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f49050e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49051f = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f49052d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Destination extends NavDestination {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Function4 f49053i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Function1 f49054j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Function1 f49055k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Function1 f49056l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Function1 f49057m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Function1 f49058n;

        /* JADX INFO: renamed from: androidx.navigation.compose.ComposeNavigator$Destination$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        final class AnonymousClass1 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function3 f49059a;

            public final void c(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i3) {
                if (ComposerKt.M()) {
                    ComposerKt.U(1587956030, i3, -1, "androidx.navigation.compose.ComposeNavigator.Destination.<init>.<anonymous> (ComposeNavigator.kt:109)");
                }
                this.f49059a.invoke(navBackStackEntry, composer, Integer.valueOf((i3 >> 3) & 14));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }
        }

        public Destination(ComposeNavigator composeNavigator, Function4 function4) {
            super(composeNavigator);
            this.f49053i = function4;
        }

        public final Function4 H() {
            return this.f49053i;
        }

        public final Function1 I() {
            return this.f49054j;
        }

        public final Function1 J() {
            return this.f49055k;
        }

        public final Function1 K() {
            return this.f49056l;
        }

        public final Function1 L() {
            return this.f49057m;
        }

        public final Function1 M() {
            return this.f49058n;
        }

        public final void N(Function1 function1) {
            this.f49054j = function1;
        }

        public final void O(Function1 function1) {
            this.f49055k = function1;
        }

        public final void P(Function1 function1) {
            this.f49056l = function1;
        }

        public final void Q(Function1 function1) {
            this.f49057m = function1;
        }

        public final void R(Function1 function1) {
            this.f49058n = function1;
        }
    }

    public ComposeNavigator() {
        super("composable");
        this.f49052d = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
    }

    @Override // androidx.navigation.Navigator
    public void g(List list, NavOptions navOptions, Navigator.Extras extras) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d().m((NavBackStackEntry) it.next());
        }
        this.f49052d.setValue(Boolean.FALSE);
    }

    @Override // androidx.navigation.Navigator
    public void n(NavBackStackEntry navBackStackEntry, boolean z2) {
        d().j(navBackStackEntry, z2);
        this.f49052d.setValue(Boolean.TRUE);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Destination c() {
        return new Destination(this, ComposableSingletons$ComposeNavigatorKt.f49039a.a());
    }

    public final StateFlow q() {
        return d().c();
    }

    public final MutableState r() {
        return this.f49052d;
    }

    public final void s(NavBackStackEntry navBackStackEntry) {
        d().f(navBackStackEntry);
    }

    public final void t(NavBackStackEntry navBackStackEntry) {
        d().k(navBackStackEntry);
    }
}
