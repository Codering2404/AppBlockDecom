package cz.mobilesoft.coreblock.scene.auto_trial;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity;
import cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreenKt;
import cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialIntroScreenKt;
import cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialReadyScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AutoTrialActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f98899g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f98900h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f98901f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) AutoTrialActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-45752523, true, new Function4() { // from class: r0.p
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.J0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialIntro.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-1772246932, true, new Function4() { // from class: r0.q
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.M0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialAllDistractions.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(436877549, true, new Function4() { // from class: r0.r
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.P0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialUnlimitedSm.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        ComposableLambda composableLambdaC4 = ComposableLambdaKt.c(-1648965266, true, new Function4() { // from class: r0.s
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.S0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialInsights.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC4);
        ComposableLambda composableLambdaC5 = ComposableLambdaKt.c(560159215, true, new Function4() { // from class: r0.t
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.V0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialSchedulePause.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC5);
        ComposableLambda composableLambdaC6 = ComposableLambdaKt.c(-1525683600, true, new Function4() { // from class: r0.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.Y0(navHostController, autoTrialActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialCustomBlockScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC6);
        ComposableLambda composableLambdaC7 = ComposableLambdaKt.c(683440881, true, new Function4() { // from class: r0.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AutoTrialActivity.b1(this.f146804a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAutoTrialReady.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC7);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-45752523, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:59)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.K0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.L0(this.f146784a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialIntroScreenKt.e(function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialAllDistractions.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1772246932, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:66)");
        }
        String strB = StringResources_androidKt.b(R.string.W1, composer, 0);
        String strB2 = StringResources_androidKt.b(R.string.V1, composer, 0);
        int i4 = R.drawable.o7;
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.N0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.O0(this.f146780a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialBenefitScreenKt.f(strB, strB2, i4, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialUnlimitedSm.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(436877549, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:75)");
        }
        String strB = StringResources_androidKt.b(R.string.fF, composer, 0);
        String strB2 = StringResources_androidKt.b(R.string.f95816l2, composer, 0);
        int i4 = R.drawable.f8;
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.Q0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.R0(this.f146789a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialBenefitScreenKt.f(strB, strB2, i4, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialInsights.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1648965266, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:84)");
        }
        String strB = StringResources_androidKt.b(R.string.f95782d2, composer, 0);
        String strB2 = StringResources_androidKt.b(R.string.f95777c2, composer, 0);
        int i4 = R.drawable.M7;
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.T0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.U0(this.f146791a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialBenefitScreenKt.f(strB, strB2, i4, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialSchedulePause.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(560159215, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:93)");
        }
        String strB = StringResources_androidKt.b(R.string.f95799h2, composer, 0);
        String strB2 = StringResources_androidKt.b(R.string.f95795g2, composer, 0);
        int i4 = R.drawable.c8;
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.W0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.X0(this.f146776a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialBenefitScreenKt.f(strB, strB2, i4, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialCustomBlockScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(final NavHostController navHostController, final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1525683600, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:102)");
        }
        String strB = StringResources_androidKt.b(R.string.I3, composer, 0);
        String strB2 = StringResources_androidKt.b(R.string.Y1, composer, 0);
        int i4 = R.drawable.E7;
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.Z0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.a1(this.f146782a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialBenefitScreenKt.f(strB, strB2, i4, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(NavHostController navHostController) {
        NavController.O(navHostController, NavAutoTrialReady.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(final AutoTrialActivity autoTrialActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(683440881, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (AutoTrialActivity.kt:112)");
        }
        boolean zI = composer.I(autoTrialActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: r0.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.c1(this.f146777a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(autoTrialActivity);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: r0.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AutoTrialActivity.d1(this.f146778a);
                }
            };
            composer.w(objG2);
        }
        AutoTrialReadyScreenKt.e(function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(AutoTrialActivity autoTrialActivity) {
        autoTrialActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(AutoTrialActivity autoTrialActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        autoTrialActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(664447796);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(664447796, i4, -1, "cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity.RootCompose (AutoTrialActivity.kt:51)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            NavAutoTrialIntro navAutoTrialIntro = NavAutoTrialIntro.INSTANCE;
            boolean zI = composerK.I(navHostControllerB) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: r0.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoTrialActivity.I0(navHostControllerB, this, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navAutoTrialIntro, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: r0.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialActivity.e1(this.f146786a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f98901f;
    }
}
