package cz.mobilesoft.coreblock.scene.feedback.backdoorcode;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.deactivated.BackdoorSmDeactivatedKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackScreenKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReasonPickerScreenKt;
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
public final class BackdoorFeedbackActivity extends BaseComposeActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(final NavHostController navHostController, final BackdoorFeedbackActivity backdoorFeedbackActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(1227679280, true, new Function4() { // from class: w0.c
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BackdoorFeedbackActivity.s0(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavDeactivatedViaBackdoor.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(1340741849, true, new Function4() { // from class: w0.d
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BackdoorFeedbackActivity.t0(navHostController, backdoorFeedbackActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavBackdoorReasonPicker.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(855796600, true, new Function4() { // from class: w0.e
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BackdoorFeedbackActivity.v0(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavBackdoorFeedback.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        Function4 function4B = ComposableSingletons$BackdoorFeedbackActivityKt.f102204a.b();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavBackdoorThankYou.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4B);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1227679280, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (BackdoorFeedbackActivity.kt:37)");
        }
        BackdoorSmDeactivatedKt.d(navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(NavHostController navHostController, final BackdoorFeedbackActivity backdoorFeedbackActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1340741849, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (BackdoorFeedbackActivity.kt:42)");
        }
        boolean zI = composer.I(backdoorFeedbackActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: w0.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackdoorFeedbackActivity.u0(this.f147531a);
                }
            };
            composer.w(objG);
        }
        BackdoorReasonPickerScreenKt.h(navHostController, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(BackdoorFeedbackActivity backdoorFeedbackActivity) {
        backdoorFeedbackActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry backstackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backstackEntry, "backstackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(855796600, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (BackdoorFeedbackActivity.kt:50)");
        }
        BackdoorFeedbackScreenKt.k(((NavBackdoorFeedback) NavBackStackEntryKt.a(backstackEntry, Reflection.b(NavBackdoorFeedback.class))).d(), navHostController, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(BackdoorFeedbackActivity backdoorFeedbackActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        backdoorFeedbackActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-776190191);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-776190191, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity.RootCompose (BackdoorFeedbackActivity.kt:30)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            NavDeactivatedViaBackdoor navDeactivatedViaBackdoor = NavDeactivatedViaBackdoor.INSTANCE;
            boolean zI = composerK.I(navHostControllerB) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: w0.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdoorFeedbackActivity.q0(navHostControllerB, this, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navDeactivatedViaBackdoor, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: w0.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorFeedbackActivity.w0(this.f147524a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
