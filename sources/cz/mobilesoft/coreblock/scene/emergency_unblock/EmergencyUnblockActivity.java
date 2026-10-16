package cz.mobilesoft.coreblock.scene.emergency_unblock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
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
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewEvent;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockAlreadyDisabledScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockCloseSuccessScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockFinalReminderScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockIntroScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockTypeTextScreenKt;
import cz.mobilesoft.coreblock.scene.emergency_unblock.screens.GenericEmergencyUnblockScreenKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f101759f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(EmergencyUnblockViewState emergencyUnblockViewState, NavHostController navHostController) {
        if (emergencyUnblockViewState.e().isEmpty()) {
            NavController.O(navHostController, NavFinalReminder.INSTANCE, null, null, 6, null);
        } else {
            NavController.O(navHostController, NavAlreadyDisabledStrictMode.INSTANCE, null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, EmergencyUnblockViewState emergencyUnblockViewState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1397664582, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:191)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.f0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.D1(this.f101852a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.g0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.E1(navHostController);
                }
            };
            composer.w(objG2);
        }
        EmergencyUnblockAlreadyDisabledScreenKt.g(function0, (Function0) objG2, emergencyUnblockViewState.e().size(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(NavHostController navHostController) {
        NavController.O(navHostController, NavTypeFollowingText.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, EmergencyUnblockViewState emergencyUnblockViewState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(360654181, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:202)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.G1(this.f101860a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.H1(navHostController);
                }
            };
            composer.w(objG2);
        }
        EmergencyUnblockTypeTextScreenKt.i(function0, (Function0) objG2, emergencyUnblockViewState.c(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(NavHostController navHostController) {
        NavController.O(navHostController, NavFinalReminder.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(EmergencyUnblockViewState emergencyUnblockViewState, final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-676356220, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:213)");
        }
        StrictModeGlowColor strictModeGlowColorF = emergencyUnblockViewState.f(composer, 0);
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.J1(this.f102036a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.K1(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean zI3 = composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI3 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.L1(navHostController);
                }
            };
            composer.w(objG3);
        }
        EmergencyUnblockFinalReminderScreenKt.g(function0, function02, (Function0) objG3, strictModeGlowColorF, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(NavHostController navHostController) {
        NavController.O(navHostController, NavCloseSuccessScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(NavHostController navHostController) {
        NavController.O(navHostController, NavDeactivationCooldownScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(EmergencyUnblockActivity emergencyUnblockActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        emergencyUnblockActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void N1(Function1 function1) {
        AnswersHelper.f128199a.n8();
        function1.invoke(EmergencyUnblockViewEvent.OnEmergencyUnblockCanceled.f101760a);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, final EmergencyUnblockViewState emergencyUnblockViewState, final Context context, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(346087267, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.a1(this.f102032a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavIntroUnblocking.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-970207604, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.j0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.e1(this.f101868a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavWhyDidYouBlock.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(-2007218005, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.k0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.n1(this.f101873a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCurrentUrge.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        ComposableLambda composableLambdaC4 = ComposableLambdaKt.c(1250738890, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.l0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.q1(this.f101879a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavHowWouldYouFeel.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC4);
        ComposableLambda composableLambdaC5 = ComposableLambdaKt.c(213728489, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.m0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.t1(this.f101883a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavBreakingRule.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC5);
        ComposableLambda composableLambdaC6 = ComposableLambdaKt.c(-823281912, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.n0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.w1(this.f101888a, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavYouSetThisRule.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC6);
        ComposableLambda composableLambdaC7 = ComposableLambdaKt.c(-1860292313, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.b
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.z1(this.f101827a, function1, emergencyUnblockViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavFeelInControl.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC7);
        ComposableLambda composableLambdaC8 = ComposableLambdaKt.c(1397664582, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.c
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.C1(this.f101833a, function1, navHostController, emergencyUnblockViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavAlreadyDisabledStrictMode.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC8);
        ComposableLambda composableLambdaC9 = ComposableLambdaKt.c(360654181, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.d
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.F1(this.f101838a, function1, navHostController, emergencyUnblockViewState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavTypeFollowingText.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC9);
        ComposableLambda composableLambdaC10 = ComposableLambdaKt.c(-676356220, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.e
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.I1(emergencyUnblockViewState, emergencyUnblockActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavFinalReminder.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC10);
        ComposableLambda composableLambdaC11 = ComposableLambdaKt.c(-1833367050, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.h0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.h1(this.f101858a, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCloseSuccessScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC11);
        ComposableLambda composableLambdaC12 = ComposableLambdaKt.c(1424589845, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.i0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EmergencyUnblockActivity.j1(emergencyUnblockViewState, emergencyUnblockActivity, function1, navHostController, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavDeactivationCooldownScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC12);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(346087267, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:79)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.b1(this.f101905a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.c1(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean zI3 = composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI3 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.d1(navHostController);
                }
            };
            composer.w(objG3);
        }
        EmergencyUnblockIntroScreenKt.g(function0, function02, (Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(NavHostController navHostController) {
        NavController.O(navHostController, NavCloseSuccessScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(NavHostController navHostController) {
        NavController.O(navHostController, NavWhyDidYouBlock.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-970207604, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:92)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.f1(this.f102030a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.x
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.g1(navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Sc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.se, composer, 0), StringResources_androidKt.b(R.string.Fd, composer, 0), StringResources_androidKt.b(R.string.E4, composer, 0), StringResources_androidKt.b(R.string.Je, composer, 0), StringResources_androidKt.b(R.string.HD, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(NavHostController navHostController) {
        NavController.O(navHostController, NavCurrentUrge.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1833367050, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:227)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.i1(this.f101850a, function1);
                }
            };
            composer.w(objG);
        }
        EmergencyUnblockCloseSuccessScreenKt.c((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(EmergencyUnblockViewState emergencyUnblockViewState, final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1424589845, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:234)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.k1(this.f101886a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.l1(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean Z = composer.Z(function1) | composer.I(context) | composer.I(emergencyUnblockActivity);
        Object objG3 = composer.G();
        if (Z || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.m1(function1, context, emergencyUnblockActivity);
                }
            };
            composer.w(objG3);
        }
        EmergencyUnblockDeactivationCooldownScreenKt.i(emergencyUnblockViewState, function0, function02, (Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(NavHostController navHostController) {
        NavController.O(navHostController, NavCloseSuccessScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Function1 function1, Context context, EmergencyUnblockActivity emergencyUnblockActivity) {
        function1.invoke(EmergencyUnblockViewEvent.OnEmergencyUnblockClicked.f101761a);
        context.startActivity(new Intent(context, (Class<?>) BackdoorFeedbackActivity.class));
        emergencyUnblockActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-2007218005, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:110)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.o1(this.f101854a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.p1(navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Tc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.uH, composer, 0), StringResources_androidKt.b(R.string.Ik, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(NavHostController navHostController) {
        NavController.O(navHostController, NavHowWouldYouFeel.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1250738890, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:125)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.r1(this.f101871a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.s1(navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Uc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.uH, composer, 0), StringResources_androidKt.b(R.string.Ik, composer, 0), StringResources_androidKt.b(R.string.ll, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(NavHostController navHostController) {
        NavController.O(navHostController, NavBreakingRule.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(213728489, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:141)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.u1(this.f101831a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.c0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.v1(navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Vc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.uH, composer, 0), StringResources_androidKt.b(R.string.Ik, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(NavHostController navHostController) {
        NavController.O(navHostController, NavYouSetThisRule.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-823281912, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:156)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.x1(this.f101902a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.y1(navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Wc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.uH, composer, 0), StringResources_androidKt.b(R.string.Ik, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(EmergencyUnblockActivity emergencyUnblockActivity, Function1 function1) {
        emergencyUnblockActivity.N1(function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(NavHostController navHostController) {
        NavController.O(navHostController, NavFeelInControl.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(final EmergencyUnblockActivity emergencyUnblockActivity, final Function1 function1, final EmergencyUnblockViewState emergencyUnblockViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1860292313, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (EmergencyUnblockActivity.kt:171)");
        }
        boolean zI = composer.I(emergencyUnblockActivity) | composer.Z(function1);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.d0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.A1(this.f101842a, function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z = composer.Z(emergencyUnblockViewState) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.e0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EmergencyUnblockActivity.B1(emergencyUnblockViewState, navHostController);
                }
            };
            composer.w(objG2);
        }
        GenericEmergencyUnblockScreenKt.j(function0, (Function0) objG2, StringResources_androidKt.b(R.string.Xc, composer, 0), CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.b(R.string.Wf, composer, 0), StringResources_androidKt.b(R.string.Xf, composer, 0), StringResources_androidKt.b(R.string.Tf, composer, 0)}), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f101759f;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1895684292);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1895684292, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity.RootCompose (EmergencyUnblockActivity.kt:67)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(EmergencyUnblockViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, muQRKXGtpOhe.XWlKhxHdZSKP);
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            EmergencyUnblockViewModel emergencyUnblockViewModel = (EmergencyUnblockViewModel) viewModelA;
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            final EmergencyUnblockViewState emergencyUnblockViewState = (EmergencyUnblockViewState) FlowExtKt.m(emergencyUnblockViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(emergencyUnblockViewModel, composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            NavIntroUnblocking navIntroUnblocking = NavIntroUnblocking.INSTANCE;
            boolean zI = composerK.I(this) | composerK.Z(function1N) | composerK.I(navHostControllerB) | composerK.Z(emergencyUnblockViewState) | composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EmergencyUnblockActivity.Z0(this.f101821a, function1N, navHostControllerB, emergencyUnblockViewState, context, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function1);
                objG = function1;
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navIntroUnblocking, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockActivity.M1(this.f101876a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
