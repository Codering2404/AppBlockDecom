package cz.mobilesoft.coreblock.scene.more.changelog.intro;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ChangelogIntroActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f106994h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f106995i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f106996f = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106997g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, Bundle redirectBundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(redirectBundle, "redirectBundle");
            Intent intent = new Intent(context, (Class<?>) ChangelogIntroActivity.class);
            intent.putExtra("EXTRAS", redirectBundle);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f106998a;

        static {
            int[] iArr = new int[NavItem.values().length];
            try {
                iArr[NavItem.NAV_THIRD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavItem.NAV_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f106998a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChangelogIntroActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106997g = LazyKt.a(lazyThreadSafetyMode, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(NavHostController navHostController, ChangelogIntroActivity changelogIntroActivity) {
        NavDestination navDestinationD;
        String strT;
        NavBackStackEntry navBackStackEntryT = navHostController.t();
        if (navBackStackEntryT != null && (navDestinationD = navBackStackEntryT.d()) != null && (strT = navDestinationD.t()) != null) {
            changelogIntroActivity.y0(navHostController, NavItem.valueOf(strT));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(final ChangelogIntroActivity changelogIntroActivity, final NavHostController navHostController, NavGraphBuilder navGraphBuilder) {
        NavGraphBuilder NavHost = navGraphBuilder;
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavItem[] navItemArrValues = NavItem.values();
        int length = navItemArrValues.length;
        int i3 = 0;
        while (i3 < length) {
            final NavItem navItem = navItemArrValues[i3];
            NavGraphBuilderKt.c(NavHost, navItem.name(), null, null, null, null, null, null, null, ComposableLambdaKt.c(222244965, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.d
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ChangelogIntroActivity.t0(navItem, changelogIntroActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 254, null);
            i3++;
            NavHost = navGraphBuilder;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(final NavItem navItem, final ChangelogIntroActivity changelogIntroActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(222244965, i3, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChangelogIntroActivity.kt:86)");
        }
        boolean zI = composer.I(changelogIntroActivity) | composer.I(navHostController) | composer.e(navItem.ordinal());
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChangelogIntroActivity.u0(this.f107019a, navHostController, navItem);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zE = composer.e(navItem.ordinal()) | composer.I(changelogIntroActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zE || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChangelogIntroActivity.v0(navItem, changelogIntroActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        ChangelogIntroActivityKt.j(navItem, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ChangelogIntroActivity changelogIntroActivity, NavHostController navHostController, NavItem navItem) {
        changelogIntroActivity.y0(navHostController, navItem);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(NavItem navItem, ChangelogIntroActivity changelogIntroActivity, NavHostController navHostController) {
        if (WhenMappings.f106998a[navItem.ordinal()] == 1) {
            changelogIntroActivity.x0();
        } else {
            NavController.P(navHostController, NavItem.values()[navItem.ordinal() + 1].name(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(ChangelogIntroActivity changelogIntroActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        changelogIntroActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void x0() {
        BuildersKt__Builders_commonKt.d(this.f106996f, null, null, new ChangelogIntroActivity$continueToNextActivity$1(this, null), 3, null);
    }

    private final void y0(NavHostController navHostController, NavItem navItem) {
        if (WhenMappings.f106998a[navItem.ordinal()] == 2) {
            x0();
        } else {
            NavController.P(navHostController, NavItem.values()[navItem.ordinal() - 1].name(), null, null, 6, null);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-2100947773);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2100947773, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroActivity.RootCompose (ChangelogIntroActivity.kt:70)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            boolean zI = composerK.I(navHostControllerB) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChangelogIntroActivity.q0(navHostControllerB, this);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            boolean zI2 = composerK.I(this) | composerK.I(navHostControllerB);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChangelogIntroActivity.s0(this.f107011a, navHostControllerB, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG2);
            }
            NavHostKt.v(navHostControllerB, "NAV_FIRST", modifierF, null, null, null, null, null, null, null, (Function1) objG2, composerK, 384, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivity.w0(this.f107013a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
