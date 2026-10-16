package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorScreenHeadingKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReason;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
public final class BackdoorFeedbackScreenKt {
    public static final void k(BackdoorReason reason, NavController navController, Composer composer, final int i3) {
        int i4;
        final BackdoorReason backdoorReason;
        Composer composer2;
        final NavController navController2;
        BackdoorFeedbackViewModel backdoorFeedbackViewModel;
        ScaffoldState scaffoldState;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerK = composer.k(-1908350569);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(reason.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navController) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1908350569, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackScreen (BackdoorFeedbackScreen.kt:110)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(BackdoorFeedbackViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            BackdoorFeedbackViewModel backdoorFeedbackViewModel2 = (BackdoorFeedbackViewModel) viewModelA;
            FeedbackViewState feedbackViewState = (FeedbackViewState) FlowExtKt.m(backdoorFeedbackViewModel2, composerK, 0);
            int i5 = i4;
            Function1 function1N = FlowExtKt.n(backdoorFeedbackViewModel2, composerK, 0);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            if (feedbackViewState.k()) {
                composerK.a0(810711630);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                composer2 = composerK;
                ProgressIndicatorKt.b(boxScopeInstance.f(SizeKt.v(companion, Dp.g(100)), companion2.e()), ComposeColorsKt.j(composerK, 0).b(), 0.0f, 0L, 0, composer2, 0, 28);
                if (feedbackViewState.g()) {
                    composer2.a0(-1677984983);
                    Modifier modifierF3 = boxScopeInstance.f(companion, companion2.e());
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                    int iA2 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer2.u();
                    Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierF3);
                    Function0 function0A2 = companion3.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A2);
                    } else {
                        composer2.v();
                    }
                    Composer composerA2 = Updater.a(composer2);
                    Updater.e(composerA2, measurePolicyG2, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF4, companion3.f());
                    ComposeCommonsKt.g(null, Dp.g(130), composer2, 48, 1);
                    composer2.y();
                } else {
                    composer2.a0(-1683375604);
                }
                composer2.U();
                composer2.y();
                composer2.U();
                backdoorFeedbackViewModel = backdoorFeedbackViewModel2;
                backdoorReason = reason;
                scaffoldState = scaffoldStateG;
            } else {
                composer2 = composerK;
                composer2.a0(811243404);
                backdoorFeedbackViewModel = backdoorFeedbackViewModel2;
                o(feedbackViewState, function1N, scaffoldStateG, reason, composerK, (i5 << 9) & 7168);
                scaffoldState = scaffoldStateG;
                backdoorReason = reason;
                composer2.U();
            }
            navController2 = navController;
            m(coroutineScopeI, scaffoldState, backdoorFeedbackViewModel, navController2, composer2, (i5 << 6) & 7168);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            backdoorReason = reason;
            composer2 = composerK;
            navController2 = navController;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorFeedbackScreenKt.l(backdoorReason, navController2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(BackdoorReason backdoorReason, NavController navController, int i3, Composer composer, int i4) {
        k(backdoorReason, navController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void m(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, BackdoorFeedbackViewModel backdoorFeedbackViewModel, final NavController navController, Composer composer, final int i3) {
        int i4;
        BackdoorFeedbackViewModel backdoorFeedbackViewModel2;
        Composer composerK = composer.k(-1123643352);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(backdoorFeedbackViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(navController) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1123643352, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.CommandProcessor (BackdoorFeedbackScreen.kt:155)");
            }
            boolean zI = composerK.I(coroutineScope) | ((i4 & 112) == 32) | composerK.I(navController);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new BackdoorFeedbackScreenKt$CommandProcessor$1$1(coroutineScope, navController, scaffoldState, null);
                composerK.w(objG);
            }
            backdoorFeedbackViewModel2 = backdoorFeedbackViewModel;
            FlowExtKt.g(backdoorFeedbackViewModel2, null, (Function2) objG, composerK, (i4 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            backdoorFeedbackViewModel2 = backdoorFeedbackViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final BackdoorFeedbackViewModel backdoorFeedbackViewModel3 = backdoorFeedbackViewModel2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorFeedbackScreenKt.n(coroutineScope, scaffoldState, backdoorFeedbackViewModel3, navController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(CoroutineScope coroutineScope, ScaffoldState scaffoldState, BackdoorFeedbackViewModel backdoorFeedbackViewModel, NavController navController, int i3, Composer composer, int i4) {
        m(coroutineScope, scaffoldState, backdoorFeedbackViewModel, navController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void o(final FeedbackViewState viewState, final Function1 onEvent, final ScaffoldState scaffoldState, final BackdoorReason reason, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Composer composerK = composer.k(-687839345);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.e(reason.ordinal()) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-687839345, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.RootCompose (BackdoorFeedbackScreen.kt:176)");
            }
            boolean Z = composerK.Z(viewState.i());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(viewState.i(), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final FocusManager focusManager = (FocusManager) composerK.q(CompositionLocalsKt.g());
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new FocusRequester();
                composerK.w(objG2);
            }
            final FocusRequester focusRequester = (FocusRequester) objG2;
            Unit unit = Unit.f139807a;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new BackdoorFeedbackScreenKt$RootCompose$1$1(focusRequester, null);
                composerK.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composerK, 6);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z2 = (i5 & 112) == 32;
            Object objG4 = composerK.G();
            if (z2 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdoorFeedbackScreenKt.r(onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG4);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG4, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(null, scaffoldState, null, ComposableLambdaKt.e(1768605525, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorFeedbackScreenKt.s(reason, viewState, onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableSingletons$BackdoorFeedbackScreenKt.f102253a.h(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-644720819, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BackdoorFeedbackScreenKt.u(focusRequester, mutableState, onEvent, viewState, focusManager, managedActivityResultLauncherA, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 >> 3) & 112) | 27648, 12582912, 131045);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorFeedbackScreenKt.y(viewState, onEvent, scaffoldState, reason, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String p(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void q(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            function1.invoke(new FeedbackViewEvent.OnAddAttachmentClicked(intentC != null ? intentC.getData() : null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final BackdoorReason backdoorReason, final FeedbackViewState feedbackViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1768605525, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.RootCompose.<anonymous> (BackdoorFeedbackScreen.kt:199)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zE = composer.e(backdoorReason.ordinal()) | composer.Z(feedbackViewState) | composer.Z(function1);
            Object objG = composer.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorFeedbackScreenKt.t(backdoorReason, feedbackViewState, function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(BackdoorReason backdoorReason, FeedbackViewState feedbackViewState, Function1 function1) {
        AnswersHelper.f128199a.n7(backdoorReason, !StringsKt.p0(feedbackViewState.i()));
        function1.invoke(FeedbackViewEvent.OnSendClicked.f102079a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(FocusRequester focusRequester, final MutableState mutableState, Function1 function1, FeedbackViewState feedbackViewState, final FocusManager focusManager, final ManagedActivityResultLauncher managedActivityResultLauncher, PaddingValues padding, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        long jP;
        final Function1 function12 = function1;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-644720819, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.RootCompose.<anonymous> (BackdoorFeedbackScreen.kt:218)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(PaddingKt.h(SizeKt.f(companion2, 0.0f, 1, null), padding), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Alignment.Horizontal horizontalG = companion3.g();
            Modifier modifierG = ScrollKt.g(boxScopeInstance.f(companion2, companion3.m()), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierG);
            Function0 function0A2 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 48;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            BackdoorScreenHeadingKt.b(StringResources_androidKt.b(R.string.xC, composer, 0), StringResources_androidKt.b(R.string.yC, composer, 0), 0.0f, composer, 0, 4);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            String strP = p(mutableState);
            Modifier modifierK2 = SizeKt.k(companion2, Dp.g(150), 0.0f, 2, null);
            long jL0 = ComposeColorsKt.j(composer, 0).l0();
            int i5 = R.dimen.f95478l;
            Modifier modifierA = FocusRequesterModifierKt.a(SizeKt.h(columnScopeInstance.c(BackgroundKt.c(modifierK2, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composer, 0))), companion3.g()), 0.0f, 1, null), focusRequester);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composer, 0));
            TextFieldColors textFieldColorsS0 = FeedbackScreenKt.S0(false, composer, 0, 1);
            boolean Z = composer.Z(mutableState) | composer.Z(function12);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BackdoorFeedbackScreenKt.v(function12, mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.c(strP, (Function1) objG, modifierA, false, false, null, null, ComposableSingletons$BackdoorFeedbackScreenKt.f102253a.g(), null, null, false, null, null, null, false, 0, 0, null, roundedCornerShapeD, textFieldColorsS0, composer, 12582912, 0, 262008);
            Composer composer2 = composer;
            if (feedbackViewState.c()) {
                composer2.a0(-1195163476);
                String strF = feedbackViewState.f();
                String strC = StringResources_androidKt.c(R.string.Tm, new Object[]{StringResources_androidKt.b(R.string.Rc, composer2, 0)}, composer2, 0);
                companion = companion2;
                Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null);
                boolean Z2 = composer2.Z(function12);
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BackdoorFeedbackScreenKt.w(function12, (String) obj);
                        }
                    };
                    composer2.w(objG2);
                }
                FeedbackScreenKt.f0(modifierM, strF, (Function1) objG2, strC, false, composer2, 24582, 0);
                composer2 = composer2;
            } else {
                companion = companion2;
                composer2.a0(-1205697927);
            }
            composer2.U();
            Modifier.Companion companion5 = companion;
            TextKt.c(StringResources_androidKt.b(R.string.S1, composer2, 0), SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 48, 0, 65532);
            String strC2 = StringResources_androidKt.c(R.string.Hj, new Object[]{20}, composer, 0);
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            if (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded)) {
                composer.a0(-1562538959);
                jP = ComposeColorsKt.j(composer, 0).k();
            } else {
                composer.a0(-1562538283);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            float f4 = 16;
            TextKt.c(strC2, SizeKt.h(PaddingKt.m(companion5, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), 0.0f, 1, null), jP, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composer, 48, 0, 65528);
            Composer composer3 = composer;
            ButtonType.TinyRound tinyRound = new ButtonType.TinyRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95554q0, composer3, 6), Color.n(ComposeColorsKt.j(composer3, 0).b()), StringResources_androidKt.b(R.string.M, composer3, 0), null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, Color.n(ComposeColorsKt.j(composer3, 0).l0()), false, null, Color.n(ComposeColorsKt.j(composer3, 0).b()), 13, null);
            Modifier modifierC = columnScopeInstance.c(companion5, companion3.k());
            boolean zI = composer3.I(focusManager) | composer3.I(managedActivityResultLauncher);
            Object objG3 = composer3.G();
            if (zI || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorFeedbackScreenKt.x(focusManager, managedActivityResultLauncher);
                    }
                };
                composer3.w(objG3);
            }
            ComposeButtonsKt.i0(modifierC, tinyRound, surface, (Function0) objG3, composer3, 0, 0);
            composer3.a0(-1562504364);
            Iterator<E> it = feedbackViewState.d().iterator();
            while (it.hasNext()) {
                Composer composer4 = composer3;
                FeedbackScreenKt.N(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), (FeedbackViewState.FreshdeskAttachment) it.next(), function12, composer4, 6, 0);
                function12 = function1;
                f4 = f4;
                composer3 = composer4;
            }
            Composer composer5 = composer3;
            composer5.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f4)), composer5, 6);
            composer5.y();
            composer5.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        q(mutableState, it);
        function1.invoke(new FeedbackViewEvent.OnMessageChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new FeedbackViewEvent.OnEmailChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(FocusManager focusManager, ManagedActivityResultLauncher managedActivityResultLauncher) {
        FocusManager.m(focusManager, false, 1, null);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        managedActivityResultLauncher.b(intent);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(FeedbackViewState feedbackViewState, Function1 function1, ScaffoldState scaffoldState, BackdoorReason backdoorReason, int i3, Composer composer, int i4) {
        o(feedbackViewState, function1, scaffoldState, backdoorReason, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
