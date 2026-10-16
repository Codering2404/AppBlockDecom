package cz.mobilesoft.coreblock.scene.subscriptionob;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.subscriptionob.Screen;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class SubscriptionOnboardingActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f122709g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f122710h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f122711f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, boolean z2, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) SubscriptionOnboardingActivity.class);
            intent.putExtra("IS_TRIAL", z2);
            intent.putExtra("TRIAL_DAYS_VALUE", i3);
            return intent;
        }

        private Companion() {
        }
    }

    private final void I0(final NavHostController navHostController, final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1852879906);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1852879906, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost (SubscriptionOnboardingActivity.kt:89)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                Object value = SessionManager.f127910a.l().getValue();
                SessionManager.SignedIn signedIn = value instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) value : null;
                String strB = signedIn != null ? signedIn.b() : null;
                composerK.w(strB);
                objG2 = strB;
            }
            final String str = (String) objG2;
            final boolean booleanExtra = getIntent().getBooleanExtra("IS_TRIAL", false);
            final int intExtra = getIntent().getIntExtra("TRIAL_DAYS_VALUE", 7);
            Float fJ0 = J0(mutableState);
            boolean zI = composerK.I(this);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SubscriptionOnboardingActivity.L0(this.f122808a);
                    }
                };
                composerK.w(objG3);
            }
            ComposeBackgroundKt.s(null, null, fJ0, (Function0) objG3, ComposableLambdaKt.e(-1391167318, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.q0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SubscriptionOnboardingActivity.M0(paddingValues, navHostController, booleanExtra, this, intExtra, str, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24576, 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SubscriptionOnboardingActivity.f1(this.f122818a, navHostController, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Float J0(MutableState mutableState) {
        return (Float) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(MutableState mutableState, Float f3) {
        mutableState.setValue(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(SubscriptionOnboardingActivity subscriptionOnboardingActivity) {
        subscriptionOnboardingActivity.j1();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(PaddingValues paddingValues, final NavHostController navHostController, final boolean z2, final SubscriptionOnboardingActivity subscriptionOnboardingActivity, final int i3, final String str, final MutableState mutableState, BoxScope GradientBoxWithProgress, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(GradientBoxWithProgress, "$this$GradientBoxWithProgress");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1391167318, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous> (SubscriptionOnboardingActivity.kt:101)");
            }
            ScaffoldKt.a(PaddingKt.h(Modifier.b8, paddingValues), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(59277544, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SubscriptionOnboardingActivity.N0(navHostController, z2, subscriptionOnboardingActivity, i3, str, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 12779520, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(final NavHostController navHostController, final boolean z2, final SubscriptionOnboardingActivity subscriptionOnboardingActivity, final int i3, final String str, final MutableState mutableState, PaddingValues it, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(it) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(59277544, i5, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:106)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            Screen.Welcome welcome = Screen.Welcome.INSTANCE;
            boolean zI = composer.I(navHostController) | composer.b(z2) | composer.I(subscriptionOnboardingActivity) | composer.e(i3);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.t0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SubscriptionOnboardingActivity.O0(str, navHostController, mutableState, z2, subscriptionOnboardingActivity, i3, (NavGraphBuilder) obj);
                    }
                };
                composer.w(function1);
                objG = function1;
            }
            NavHostKt.u(navHostController, welcome, modifierH, null, null, null, null, null, null, null, null, (Function1) objG, composer, 0, 0, 2040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(final String str, final NavHostController navHostController, final MutableState mutableState, final boolean z2, final SubscriptionOnboardingActivity subscriptionOnboardingActivity, final int i3, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-772236247, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.u0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.P0(str, navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.Welcome.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-957328352, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.v0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.R0(navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.ScheduleOverview.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(-139432991, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.w0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.T0(navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.ScheduleCustomization.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        ComposableLambda composableLambdaC4 = ComposableLambdaKt.c(678462370, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.b0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.V0(navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.StrictMode.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC4);
        ComposableLambda composableLambdaC5 = ComposableLambdaKt.c(1496357731, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.c0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.X0(navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.QuickBlockOverview.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC5);
        ComposableLambda composableLambdaC6 = ComposableLambdaKt.c(-1980714204, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.d0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.Z0(z2, subscriptionOnboardingActivity, navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.Allowlist.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC6);
        ComposableLambda composableLambdaC7 = ComposableLambdaKt.c(-1162818843, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.e0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.b1(i3, navHostController, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.Trial.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC7);
        ComposableLambda composableLambdaC8 = ComposableLambdaKt.c(-344923482, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.f0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SubscriptionOnboardingActivity.d1(str, subscriptionOnboardingActivity, mutableState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(Screen.Confirmation.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC8);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(String str, final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-772236247, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:113)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.Welcome.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$1$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.j0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.Q0(navHostController);
                }
            };
            composer.w(objG2);
        }
        WelcomeScreenKt.t(str, (Function0) objG2, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(NavHostController navHostController) {
        NavController.O(navHostController, Screen.ScheduleOverview.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-957328352, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:125)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.ScheduleOverview.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$2$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.o0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.S0(navHostController);
                }
            };
            composer.w(objG2);
        }
        ScheduleOverviewScreenKt.b((Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(NavHostController navHostController) {
        NavController.O(navHostController, Screen.StrictMode.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-139432991, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:136)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.ScheduleCustomization.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$3$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.g0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.U0(navHostController);
                }
            };
            composer.w(objG2);
        }
        ScheduleCustomizationScreenKt.b((Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(NavHostController navHostController) {
        NavController.O(navHostController, Screen.StrictMode.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(678462370, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:147)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.StrictMode.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$4$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        String strB = StringResources_androidKt.b(R.string.lp, composer, 0);
        int i4 = R.drawable.hb;
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.m0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.W0(navHostController);
                }
            };
            composer.w(objG2);
        }
        SubscriptionOnboardingActivityKt.i(strB, (Function0) objG2, i4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(NavHostController navHostController) {
        NavController.O(navHostController, Screen.QuickBlockOverview.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1496357731, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:160)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.QuickBlockOverview.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$5$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.k0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.Y0(navHostController);
                }
            };
            composer.w(objG2);
        }
        QuickBlockOverviewScreenKt.b((Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(NavHostController navHostController) {
        NavController.O(navHostController, Screen.Allowlist.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(final boolean z2, final SubscriptionOnboardingActivity subscriptionOnboardingActivity, final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1980714204, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:169)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.Allowlist.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$6$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        String strB = StringResources_androidKt.b(R.string.hp, composer, 0);
        int i4 = R.drawable.ib;
        boolean zB = composer.b(z2) | composer.I(subscriptionOnboardingActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.i0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.a1(z2, subscriptionOnboardingActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        SubscriptionOnboardingActivityKt.i(strB, (Function0) objG2, i4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(boolean z2, SubscriptionOnboardingActivity subscriptionOnboardingActivity, NavHostController navHostController) {
        if (!z2 || PermissionHelper.o(subscriptionOnboardingActivity) || subscriptionOnboardingActivity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
            NavController.O(navHostController, Screen.Confirmation.INSTANCE, null, null, 6, null);
        } else {
            NavController.O(navHostController, Screen.Trial.INSTANCE, null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(int i3, final NavHostController navHostController, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1162818843, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:214)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.Trial.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$7$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        String strC = StringResources_androidKt.c(R.string.jp, new Object[]{Integer.valueOf(i3)}, composer, 0);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.h0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.c1(navHostController);
                }
            };
            composer.w(objG2);
        }
        SubscriptionOnboardingActivityKt.f(strC, null, (Function0) objG2, ComposableSingletons$SubscriptionOnboardingActivityKt.f122676a.e(), composer, 3072, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(NavHostController navHostController) {
        NavController.O(navHostController, Screen.Confirmation.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(String str, final SubscriptionOnboardingActivity subscriptionOnboardingActivity, MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-344923482, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SubscriptionOnboardingActivity.kt:234)");
        }
        SubscriptionOnboardingActivityKt.l(Screen.Confirmation.INSTANCE, composer, 0);
        Unit unit = Unit.f139807a;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new SubscriptionOnboardingActivity$NavHost$2$1$1$1$8$1$1(mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(unit, (Function2) objG, composer, 6);
        boolean zI = composer.I(subscriptionOnboardingActivity);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.n0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SubscriptionOnboardingActivity.e1(this.f122802a);
                }
            };
            composer.w(objG2);
        }
        ConfirmationScreenKt.b(str, (Function0) objG2, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(SubscriptionOnboardingActivity subscriptionOnboardingActivity) {
        AnswersHelper.f128199a.T7();
        subscriptionOnboardingActivity.j1();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(SubscriptionOnboardingActivity subscriptionOnboardingActivity, NavHostController navHostController, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        subscriptionOnboardingActivity.I0(navHostController, paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(SubscriptionOnboardingActivity subscriptionOnboardingActivity, NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-872211990, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.RootCompose.<anonymous> (SubscriptionOnboardingActivity.kt:77)");
            }
            subscriptionOnboardingActivity.I0(navHostController, it, composer, (i3 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(SubscriptionOnboardingActivity subscriptionOnboardingActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        subscriptionOnboardingActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void j1() {
        finish();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-563485268);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-563485268, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity.RootCompose (SubscriptionOnboardingActivity.kt:64)");
            }
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), false, null, 6, null);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(null, ScaffoldKt.g(null, null, composerK, 0, 3), null, null, ComposableSingletons$SubscriptionOnboardingActivityKt.f122676a.f(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-872211990, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SubscriptionOnboardingActivity.g1(this.f122745a, navHostControllerB, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 24576, 12582912, 131053);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SubscriptionOnboardingActivity.h1(this.f122795a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f122711f;
    }
}
