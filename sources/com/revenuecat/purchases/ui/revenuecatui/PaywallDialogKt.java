package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class PaywallDialogKt {
    public static final void PaywallDialog(final PaywallDialogOptions paywallDialogOptions, Composer composer, final int i3) {
        int i4;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(paywallDialogOptions, "paywallDialogOptions");
        Composer composerK = composer.k(1772149319);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paywallDialogOptions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1772149319, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialog (PaywallDialog.kt:23)");
            }
            final Function1<CustomerInfo, Boolean> shouldDisplayBlock = paywallDialogOptions.getShouldDisplayBlock();
            Object[] objArr = new Object[0];
            composerK.a0(751283007);
            boolean Z = composerK.Z(shouldDisplayBlock);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0<MutableState<Boolean>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$shouldDisplayDialog$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<Boolean> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(shouldDisplayBlock == null), null, 2, null);
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.e(objArr, null, null, (Function0) objG, composerK, 0, 6);
            composerK.a0(751284803);
            if (shouldDisplayBlock != null) {
                composerK.a0(751287246);
                boolean Z2 = composerK.Z(mutableState2) | composerK.Z(shouldDisplayBlock);
                Object objG2 = composerK.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new PaywallDialogKt$PaywallDialog$1$1(shouldDisplayBlock, mutableState2, null);
                    composerK.w(objG2);
                }
                composerK.U();
                EffectsKt.g(paywallDialogOptions, (Function2) objG2, composerK, i4 & 14);
            }
            composerK.U();
            composerK.a0(751292590);
            Object objG3 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(PaywallDialog$lambda$1(mutableState2) ? paywallDialogOptions.getOfferingSelection$revenuecatui_defaultsBc8Release() : null, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState3 = (MutableState) objG3;
            composerK.U();
            composerK.a0(751298534);
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG4);
            }
            MutableState mutableState4 = (MutableState) objG4;
            composerK.U();
            Boolean boolValueOf = Boolean.valueOf(PaywallDialog$lambda$1(mutableState2));
            composerK.a0(751301681);
            int i5 = i4 & 14;
            boolean Z3 = composerK.Z(mutableState2) | (i5 == 4);
            Object objG5 = composerK.G();
            if (Z3 || objG5 == companion.a()) {
                objG5 = new PaywallDialogKt$PaywallDialog$2$1(paywallDialogOptions, mutableState2, mutableState3, null);
                composerK.w(objG5);
            }
            composerK.U();
            EffectsKt.g(boolValueOf, (Function2) objG5, composerK, 0);
            composerK.a0(751307991);
            boolean Z4 = composerK.Z(mutableState2) | (i5 == 4);
            Object objG6 = composerK.G();
            if (Z4 || objG6 == companion.a()) {
                objG6 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$dismissDialog$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m683invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m683invoke() {
                        mutableState3.setValue(null);
                        PaywallDialogKt.PaywallDialog$lambda$2(mutableState2, false);
                        Function0<Unit> dismissRequest = paywallDialogOptions.getDismissRequest();
                        if (dismissRequest != null) {
                            dismissRequest.invoke();
                        }
                    }
                };
                composerK.w(objG6);
            }
            final Function0 function0 = (Function0) objG6;
            composerK.U();
            OfferingSelection offeringSelectionPaywallDialog$lambda$5 = PaywallDialog$lambda$5(mutableState3);
            OfferingSelection offeringSelectionPaywallDialog$lambda$8 = PaywallDialog$lambda$8(mutableState4);
            composerK.a0(751318540);
            boolean Z5 = composerK.Z(shouldDisplayBlock) | composerK.Z(function0);
            Object objG7 = composerK.G();
            if (Z5 || objG7 == companion.a()) {
                PaywallDialogKt$PaywallDialog$3$1 paywallDialogKt$PaywallDialog$3$1 = new PaywallDialogKt$PaywallDialog$3$1(shouldDisplayBlock, function0, mutableState3, mutableState4, null);
                mutableState = mutableState4;
                composerK.w(paywallDialogKt$PaywallDialog$3$1);
                objG7 = paywallDialogKt$PaywallDialog$3$1;
            } else {
                mutableState = mutableState4;
            }
            composerK.U();
            EffectsKt.f(offeringSelectionPaywallDialog$lambda$5, offeringSelectionPaywallDialog$lambda$8, (Function2) objG7, composerK, 0);
            OfferingSelection offeringSelectionPaywallDialog$lambda$52 = PaywallDialog$lambda$5(mutableState3);
            if (offeringSelectionPaywallDialog$lambda$52 != null) {
                composerK.a0(714520786);
                boolean Z6 = composerK.Z(function0);
                Object objG8 = composerK.G();
                if (Z6 || objG8 == companion.a()) {
                    objG8 = new Function1<OfferingSelection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((OfferingSelection) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(OfferingSelection offeringSelection) {
                            if (offeringSelection == null) {
                                function0.invoke();
                            } else {
                                mutableState.setValue(offeringSelection);
                                mutableState3.setValue(null);
                            }
                        }
                    };
                    composerK.w(objG8);
                }
                composerK.U();
                PaywallDialogContent(paywallDialogOptions, offeringSelectionPaywallDialog$lambda$52, (Function1) objG8, composerK, i5);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialog.5
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
                    PaywallDialogKt.PaywallDialog(paywallDialogOptions, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PaywallDialog$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialog$lambda$2(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$5(MutableState<OfferingSelection> mutableState) {
        return (OfferingSelection) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$8(MutableState<OfferingSelection> mutableState) {
        return (OfferingSelection) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialogContent(final PaywallDialogOptions paywallDialogOptions, final OfferingSelection offeringSelection, final Function1<? super OfferingSelection, Unit> function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(217055693);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paywallDialogOptions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(offeringSelection) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(217055693, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent (PaywallDialog.kt:92)");
            }
            composerK.a0(-926362855);
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = buildPaywallOptions(paywallDialogOptions, offeringSelection, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m685invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m685invoke() {
                        function1.invoke(null);
                    }
                }, new Function2<Offering, PaywallResult, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Offering) obj, (PaywallResult) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(Offering offering, PaywallResult paywallResult) {
                        function1.invoke(offering != null ? new OfferingSelection.OfferingType(offering) : null);
                    }
                });
                composerK.w(objG);
            }
            final PaywallOptions paywallOptions = (PaywallOptions) objG;
            composerK.U();
            final PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptions, paywallDialogOptions.getShouldDisplayBlock(), composerK, 0, 0);
            Unit unit = Unit.f139807a;
            composerK.a0(-926343657);
            boolean Z = composerK.Z(paywallViewModel);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new PaywallDialogKt$PaywallDialogContent$1$1(paywallViewModel, null);
                composerK.w(objG2);
            }
            composerK.U();
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            composerK.a0(-926340225);
            boolean Z2 = composerK.Z(paywallViewModel);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new PaywallDialogKt$PaywallDialogContent$2$1(paywallViewModel);
                composerK.w(objG3);
            }
            composerK.U();
            RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold((Function0) objG3, ComposableLambdaKt.e(1910079027, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.3
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
                        ComposerKt.U(1910079027, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent.<anonymous> (PaywallDialog.kt:116)");
                    }
                    InternalPaywallKt.InternalPaywall(paywallOptions, paywallViewModel, composer2, 0, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    PaywallDialogKt.PaywallDialogContent(paywallDialogOptions, offeringSelection, function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final PaywallOptions buildPaywallOptions(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0<Unit> function0, Function2<? super Offering, ? super PaywallResult, Unit> function2) {
        return new PaywallOptions.Builder(function0).setOfferingSelection$revenuecatui_defaultsBc8Release(offeringSelection).setShouldDisplayDismissButton(paywallDialogOptions.getShouldDisplayDismissButton()).setFontProvider(paywallDialogOptions.getFontProvider()).setListener(paywallDialogOptions.getListener()).setPurchaseLogic(paywallDialogOptions.getPurchaseLogic()).setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(function2).setCustomVariables(paywallDialogOptions.getCustomVariables()).build();
    }

    static /* synthetic */ PaywallOptions buildPaywallOptions$default(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0 function0, Function2 function2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function2 = null;
        }
        return buildPaywallOptions(paywallDialogOptions, offeringSelection, function0, function2);
    }
}
