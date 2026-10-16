package com.revenuecat.purchases.ui.revenuecatui;

import android.content.Context;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.composables.CloseButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.DisableTouchesComposableKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.Fade;
import com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderDefaults;
import com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProviderKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.templates.Template2Kt;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class LoadingPaywallKt {
    public static final void LoadingPaywall(final PaywallMode mode, final boolean z2, final Function0<Unit> onDismiss, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-1867064258);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(mode) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1867064258, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadingPaywall (LoadingPaywall.kt:56)");
            }
            ResourceProvider resourceProvider = PaywallResourceProviderKt.toResourceProvider((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            PaywallData.Companion companion = PaywallData.Companion;
            LoadingPaywallConstants loadingPaywallConstants = LoadingPaywallConstants.INSTANCE;
            PaywallData paywallDataCreateDefault = PaywallDataExtensionsKt.createDefault(companion, loadingPaywallConstants.getPackages(), MaterialTheme.f18110a.a(composerK, MaterialTheme.f18111b), resourceProvider);
            PaywallState legacyPaywallState = OfferingToStateMapperKt.toLegacyPaywallState(new Offering(LoadingPaywallConstants.offeringIdentifier, "Loading paywall", MapsKt.emptyMap(), loadingPaywallConstants.getPackages(), paywallDataCreateDefault, null, null, 96, null), new VariableDataProvider(resourceProvider, HelperFunctionsKt.isInPreviewMode(composerK, 0)), mode, paywallDataCreateDefault, loadingPaywallConstants.getTemplate(), z2, null, (64 & 64) != 0 ? null : null);
            if (legacyPaywallState instanceof PaywallState.Error ? true : legacyPaywallState instanceof PaywallState.Loading ? true : legacyPaywallState instanceof PaywallState.Loaded.Components) {
                composerK.a0(1291732133);
                Modifier.Companion companion2 = Modifier.b8;
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
                Updater.e(composerA, modifierF, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                composerK.y();
                composerK.U();
            } else if (legacyPaywallState instanceof PaywallState.Loaded.Legacy) {
                composerK.a0(1291733770);
                LoadingPaywall((PaywallState.Loaded.Legacy) legacyPaywallState, new LoadingViewModel(legacyPaywallState, resourceProvider), onDismiss, composerK, i5 & 896);
                composerK.U();
            } else {
                composerK.a0(1389119235);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallKt.LoadingPaywall.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    LoadingPaywallKt.LoadingPaywall(mode, z2, onDismiss, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void LoadingPaywallPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(234924211);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(234924211, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallPreview (LoadingPaywall.kt:246)");
            }
            LoadingPaywall(PaywallMode.FULL_SCREEN, false, (Function0<Unit>) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallKt.LoadingPaywallPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m682invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m682invoke();
                    return Unit.f139807a;
                }
            }, composerK, 438);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallKt.LoadingPaywallPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadingPaywallKt.LoadingPaywallPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadingPaywall(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, Function0<Unit> function0, Composer composer, final int i3) {
        int i4;
        final Function0<Unit> function02;
        Composer composerK = composer.k(1534111610);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(legacy) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paywallViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            function02 = function0;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1534111610, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadingPaywall (LoadingPaywall.kt:102)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            DisableTouchesComposableKt.DisableTouchesComposable(false, ComposableLambdaKt.e(-1190756256, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallKt$LoadingPaywall$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1190756256, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadingPaywall.<anonymous>.<anonymous> (LoadingPaywall.kt:106)");
                    }
                    PaywallState.Loaded.Legacy legacy2 = legacy;
                    PaywallViewModel paywallViewModel2 = paywallViewModel;
                    Modifier.Companion companion3 = Modifier.b8;
                    RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(UIConstant.INSTANCE.m692getDefaultPackageCornerRadiusD9Ej5fM());
                    LoadingPaywallConstants loadingPaywallConstants = LoadingPaywallConstants.INSTANCE;
                    Template2Kt.Template2(legacy2, paywallViewModel2, PlaceholderKt.m920placeholderTgFrcIs(companion3, true, loadingPaywallConstants.m681getPlaceholderColor0d7_KjU(), roundedCornerShapeD, new Fade(loadingPaywallConstants.m681getPlaceholderColor0d7_KjU(), PlaceholderDefaults.INSTANCE.getFadeAnimationSpec(), null), null, null, composer2, (InfiniteRepeatableSpec.f3963d << 12) | 54, 48), composer2, 0, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48, 1);
            function02 = function0;
            CloseButtonKt.m872CloseButtondrOMvmE(boxScopeInstance, legacy.getShouldDisplayDismissButton(), null, ((Boolean) paywallViewModel.getActionInProgress().getValue()).booleanValue(), function02, composerK, 390 | ((i4 << 6) & 57344));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.LoadingPaywallKt.LoadingPaywall.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    LoadingPaywallKt.LoadingPaywall(legacy, paywallViewModel, function02, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
