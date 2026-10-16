package cz.mobilesoft.coreblock.scene.selection.recommended;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.CheckboxKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import coil.compose.SingletonAsyncImageKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt;
import cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RecommendedAppsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, RecommendedAppsViewState recommendedAppsViewState, Integer num, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1711433196, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.Content.<anonymous>.<anonymous> (RecommendedAppsScreen.kt:219)");
            }
            v(it, function1, recommendedAppsViewState, num, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(RecommendedAppsViewState recommendedAppsViewState, Integer num, MutableState mutableState, Function1 function1, int i3, Composer composer, int i4) {
        w(recommendedAppsViewState, num, mutableState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1) {
        function1.invoke(new RecommendedAppsViewEvent.FinishWithApplications(true, false, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(PaddingValues paddingValues, Function1 function1, RecommendedAppsViewState recommendedAppsViewState, Integer num, int i3, Composer composer, int i4) {
        v(paddingValues, function1, recommendedAppsViewState, num, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void E(final ApplicationDTO application, final Function1 onEvent, final AppIconCache appIconCache, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(appIconCache, "appIconCache");
        Composer composerK = composer.k(-82692738);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(application) : composerK.I(application) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(appIconCache) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-82692738, i4, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsRow (RecommendedAppsScreen.kt:348)");
            }
            Drawable drawableE = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue() ? null : appIconCache.e(application.f());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            boolean z2 = ((i4 & 14) == 4 || ((i4 & 8) != 0 && composerK.I(application))) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.F(onEvent, application);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF = ClickableKt.f(modifierH, false, null, null, (Function0) objG, 7, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f3 = 16;
            SingletonAsyncImageKt.b(drawableE, null, rowScopeInstance.d(SizeKt.v(PaddingKt.m(companion, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), Dp.g(34)), companion2.i()), null, null, PainterResources_androidKt.c(R.drawable.H6, composerK, 0), null, null, null, null, null, 0.0f, null, 0, composerK, 48, 0, 16344);
            Modifier modifierM = PaddingKt.m(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.g(f3), 0.0f, Dp.g(20), 0.0f, 10, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.c(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, companion);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            TextKt.c(application.d(), RowScope.c(rowScopeInstance, PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).i(), composerK, 0, 0, 65532);
            composer2 = composerK;
            CheckboxKt.a(application.h(), null, PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), false, null, null, composer2, 432, 56);
            composer2.y();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.G(application, onEvent, appIconCache, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1, ApplicationDTO applicationDTO) {
        function1.invoke(new RecommendedAppsViewEvent.OnAppSelected(applicationDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(ApplicationDTO applicationDTO, Function1 function1, AppIconCache appIconCache, int i3, Composer composer, int i4) {
        E(applicationDTO, function1, appIconCache, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void H(final List recommendedApps, final Integer num, final MutableState isFirstShown, final Function3 onApplicationsWebsitesSelected, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(recommendedApps, "recommendedApps");
        Intrinsics.checkNotNullParameter(isFirstShown, "isFirstShown");
        Intrinsics.checkNotNullParameter(onApplicationsWebsitesSelected, "onApplicationsWebsitesSelected");
        Composer composerK = composer.k(-196886559);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(recommendedApps) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(num) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(isFirstShown) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onApplicationsWebsitesSelected) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-196886559, i5, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreen (RecommendedAppsScreen.kt:141)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(recommendedApps);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.I(recommendedApps);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
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
            KClass kClassB = Reflection.b(RecommendedAppsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            RecommendedAppsViewModel recommendedAppsViewModel = (RecommendedAppsViewModel) viewModelA;
            final ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composerK, 6, 14);
            final Function1 function1N = FlowExtKt.n(recommendedAppsViewModel, composerK, 0);
            final RecommendedAppsViewState recommendedAppsViewState = (RecommendedAppsViewState) FlowExtKt.m(recommendedAppsViewModel, composerK, 0);
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG2);
            }
            final CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG2, CoroutinesHelperExtKt.b());
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.J();
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 48, 1);
            Unit unit = Unit.f139807a;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new RecommendedAppsScreenKt$RecommendedAppsScreen$2$1(null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            int i6 = ModalBottomSheetState.f13222e;
            t(coroutineScopeI, context, onApplicationsWebsitesSelected, modalBottomSheetStateJ, recommendedAppsViewModel, composerK, ((i5 >> 3) & 896) | (i6 << 9));
            ComposeDialogsKt.n1(ComposableLambdaKt.e(175781337, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RecommendedAppsScreenKt.K(modalBottomSheetStateJ, coroutineScopeI, recommendedAppsViewState, function1N, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), null, modalBottomSheetStateJ, null, 0.0f, 0L, 0L, 0L, ComposableLambdaKt.e(1694779473, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.P(recommendedAppsViewState, num, isFirstShown, function1N, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i6 << 6) | 100663302, 250);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.Q(recommendedApps, num, isFirstShown, onApplicationsWebsitesSelected, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder I(List list) {
        return ParametersHolderKt.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, final RecommendedAppsViewState recommendedAppsViewState, final Function1 function1, ColumnScope ThemedBottomSheetLayout, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ThemedBottomSheetLayout, "$this$ThemedBottomSheetLayout");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(175781337, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreen.<anonymous> (RecommendedAppsScreen.kt:170)");
            }
            if (modalBottomSheetState.e() != ModalBottomSheetValue.Hidden) {
                composer.a0(1136801489);
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(410721493, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.j
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return RecommendedAppsScreenKt.L(recommendedAppsViewState, modalBottomSheetState, coroutineScope, function1, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                boolean zI = composer.I(coroutineScope) | composer.I(modalBottomSheetState);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RecommendedAppsScreenKt.O(coroutineScope, modalBottomSheetState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composer, 3456, 19);
            } else {
                composer.a0(1128944105);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(RecommendedAppsViewState recommendedAppsViewState, ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope, final Function1 function1, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(410721493, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreen.<anonymous>.<anonymous> (RecommendedAppsScreen.kt:174)");
            }
            ImmutableList immutableListD = recommendedAppsViewState.d();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.M(function1);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.N(function1);
                    }
                };
                composer.w(objG2);
            }
            WebsitesForSelectedAppsBottomSheetKt.e(immutableListD, modalBottomSheetState, coroutineScope, function0, (Function0) objG2, composer, ModalBottomSheetState.f13222e << 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1) {
        function1.invoke(new RecommendedAppsViewEvent.FinishWithApplications(false, false, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1) {
        function1.invoke(new RecommendedAppsViewEvent.FinishWithApplications(false, true, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new RecommendedAppsScreenKt$RecommendedAppsScreen$3$2$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(RecommendedAppsViewState recommendedAppsViewState, Integer num, MutableState mutableState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1694779473, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreen.<anonymous> (RecommendedAppsScreen.kt:196)");
            }
            w(recommendedAppsViewState, num, mutableState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(List list, Integer num, MutableState mutableState, Function3 function3, int i3, Composer composer, int i4) {
        H(list, num, mutableState, function3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void t(final CoroutineScope coroutineScope, final Context context, final Function3 function3, final ModalBottomSheetState modalBottomSheetState, final RecommendedAppsViewModel recommendedAppsViewModel, Composer composer, final int i3) {
        int i4;
        Function3 function32;
        RecommendedAppsViewModel recommendedAppsViewModel2;
        Composer composerK = composer.k(-1703532315);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(context) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function32 = function3;
            i4 |= composerK.I(function32) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function32 = function3;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            recommendedAppsViewModel2 = recommendedAppsViewModel;
            i4 |= composerK.I(recommendedAppsViewModel2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            recommendedAppsViewModel2 = recommendedAppsViewModel;
        }
        int i5 = i4;
        boolean z2 = false;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1703532315, i5, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.CommandProcessor (RecommendedAppsScreen.kt:254)");
            }
            boolean zI = composerK.I(context) | ((i5 & 896) == 256) | composerK.I(coroutineScope);
            if ((i5 & 7168) == 2048 || ((i5 & 4096) != 0 && composerK.I(modalBottomSheetState))) {
                z2 = true;
            }
            boolean z3 = zI | z2;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                RecommendedAppsScreenKt$CommandProcessor$1$1 recommendedAppsScreenKt$CommandProcessor$1$1 = new RecommendedAppsScreenKt$CommandProcessor$1$1(context, function32, coroutineScope, modalBottomSheetState, null);
                composerK.w(recommendedAppsScreenKt$CommandProcessor$1$1);
                objG = recommendedAppsScreenKt$CommandProcessor$1$1;
            }
            FlowExtKt.g(recommendedAppsViewModel2, null, (Function2) objG, composerK, (i5 >> 12) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.u(coroutineScope, context, function3, modalBottomSheetState, recommendedAppsViewModel, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(CoroutineScope coroutineScope, Context context, Function3 function3, ModalBottomSheetState modalBottomSheetState, RecommendedAppsViewModel recommendedAppsViewModel, int i3, Composer composer, int i4) {
        t(coroutineScope, context, function3, modalBottomSheetState, recommendedAppsViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [boolean, int] */
    private static final void v(final PaddingValues paddingValues, final Function1 function1, final RecommendedAppsViewState recommendedAppsViewState, final Integer num, Composer composer, final int i3) {
        Composer composer2;
        ColumnScopeInstance columnScopeInstance;
        float f3;
        int i4;
        Modifier.Companion companion;
        float f4;
        int i5;
        ?? r3;
        Composer composerK = composer.k(-375852898);
        int i6 = (i3 & 6) == 0 ? (composerK.Z(paddingValues) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i6 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= composerK.Z(recommendedAppsViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerK.Z(num) ? 2048 : 1024;
        }
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-375852898, i6, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.Content (RecommendedAppsScreen.kt:284)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new AppIconCache();
                composerK.w(objG);
            }
            AppIconCache appIconCache = (AppIconCache) objG;
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f5 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(SizeKt.f(WindowInsetsPaddingKt.d(PaddingKt.h(companion2, paddingValues), WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(32), 0.0f, Dp.g(f5), 5, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            ScreenProgressBarKt.b(null, 0.9f, composerK, 48, 1);
            if (num == null) {
                composerK.a0(891198646);
                composerK.U();
                i5 = i6;
                f3 = f5;
                columnScopeInstance = columnScopeInstance2;
                companion = companion2;
                r3 = 0;
                i4 = 6;
                f4 = 0.0f;
            } else {
                composerK.a0(891198647);
                int iIntValue = num.intValue();
                SpacerKt.a(SizeKt.i(companion2, Dp.g(30)), composerK, 6);
                columnScopeInstance = columnScopeInstance2;
                f3 = f5;
                i4 = 6;
                companion = companion2;
                f4 = 0.0f;
                i5 = i6;
                r3 = 0;
                TextKt.c(StringResources_androidKt.b(iIntValue, composerK, 0), PaddingKt.k(companion2, Dp.g(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65020);
                composerK = composerK;
                Unit unit = Unit.f139807a;
                composerK.U();
            }
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composerK, i4);
            Composer composer3 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.rA, composerK, r3), SizeKt.h(PaddingKt.m(PaddingKt.k(companion, Dp.g(f3), f4, 2, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), f4, 1, null), ComposeColorsKt.j(composerK, r3).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, r3).g(), composer3, 48, 0, 65016);
            composer3.a0(-386867504);
            for (ApplicationDTO applicationDTO : recommendedAppsViewState.c()) {
                Modifier modifierK = PaddingKt.k(Modifier.b8, f4, Dp.g(4), 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), r3);
                int iA2 = ComposablesKt.a(composer3, r3);
                CompositionLocalMap compositionLocalMapU2 = composer3.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierK);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A2 = companion4.a();
                if (composer3.m() == null) {
                    ComposablesKt.c();
                }
                composer3.L();
                if (composer3.i()) {
                    composer3.P(function0A2);
                } else {
                    composer3.v();
                }
                Composer composerA2 = Updater.a(composer3);
                Updater.e(composerA2, measurePolicyG, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                E(applicationDTO, function1, appIconCache, composer3, ApplicationDTO.f96901j | 384 | (i5 & 112));
                composer3.y();
                f4 = 0.0f;
            }
            composer3.U();
            Modifier.Companion companion5 = Modifier.b8;
            SpacerKt.a(SizeKt.v(companion5, Dp.g(f3)), composer3, i4);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.Fv, composer3, r3), null, true, 11, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            Modifier modifierC = columnScopeInstance.c(companion5, Alignment.f25072a.g());
            ?? r12 = (i5 & 112) != 32 ? r3 : 1;
            Object objG2 = composer3.G();
            if (r12 != 0 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.C(function1);
                    }
                };
                composer3.w(objG2);
            }
            ComposeButtonsKt.i0(modifierC, smallRound, surface, (Function0) objG2, composer3, 0, 0);
            composer2 = composer3;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.D(paddingValues, function1, recommendedAppsViewState, num, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final RecommendedAppsViewState recommendedAppsViewState, final Integer num, final MutableState mutableState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        MutableState mutableState2;
        String strB;
        Composer composerK = composer.k(1484094340);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(recommendedAppsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(num) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            mutableState2 = mutableState;
            i4 |= composerK.Z(mutableState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            mutableState2 = mutableState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1484094340, i4, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.Content (RecommendedAppsScreen.kt:211)");
            }
            boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composerK.a0(285529601);
                strB = StringResources_androidKt.b(R.string.cm, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(261547674);
                composerK.U();
                strB = "";
            }
            ComposeBackgroundKt.m(null, false, false, zBooleanValue, strB, 1000L, null, ComposableLambdaKt.e(-1583213934, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RecommendedAppsScreenKt.x(function1, recommendedAppsViewState, num, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12779520, 71);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.B(recommendedAppsViewState, num, mutableState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(final Function1 function1, final RecommendedAppsViewState recommendedAppsViewState, final Integer num, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1583213934, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.Content.<anonymous> (RecommendedAppsScreen.kt:217)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, null, ComposableLambdaKt.e(-2050429684, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedAppsScreenKt.y(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1711433196, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.q
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RecommendedAppsScreenKt.A(function1, recommendedAppsViewState, num, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2050429684, i3, -1, "cz.mobilesoft.coreblock.scene.selection.recommended.Content.<anonymous>.<anonymous> (RecommendedAppsScreen.kt:222)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalI, composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.recommended.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedAppsScreenKt.z(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(modifierC, big, accent, (Function0) objG, composer, 0, 0);
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
    public static final Unit z(Function1 function1) {
        function1.invoke(RecommendedAppsViewEvent.SearchWebsitesForSelectedApps.f119196a);
        return Unit.f139807a;
    }
}
