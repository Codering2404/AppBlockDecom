package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class VirtualCurrencyBalancesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void EmptyStateView(final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.EmptyStateView(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void InternalVirtualCurrencyBalancesScreen(final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance r18, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r19, final com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState r20, androidx.compose.ui.Modifier r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Appearance, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void VirtualCurrencyBalancesScreen(final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance r17, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r18, androidx.compose.ui.Modifier r19, com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreen(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Appearance, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final VirtualCurrencyBalancesScreenViewState VirtualCurrencyBalancesScreen$lambda$0(State<? extends VirtualCurrencyBalancesScreenViewState> state) {
        return (VirtualCurrencyBalancesScreenViewState) state.getValue();
    }

    public static final void VirtualCurrencyBalancesScreenErrorPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-508614020);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-508614020, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenErrorPreview (VirtualCurrencyBalancesScreen.kt:253)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m1023getLambda6$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenErrorPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenErrorPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoaded0VCsPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(800159975);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(800159975, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoaded0VCsPreview (VirtualCurrencyBalancesScreen.kt:189)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m1019getLambda2$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded0VCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded0VCsPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoaded4VCsPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1776254187);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1776254187, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoaded4VCsPreview (VirtualCurrencyBalancesScreen.kt:204)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m1020getLambda3$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded4VCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded4VCsPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoadedVCsPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1774472093);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1774472093, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoadedVCsPreview (VirtualCurrencyBalancesScreen.kt:221)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m1021getLambda4$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadedVCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadedVCsPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoadingPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(126970760);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(126970760, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoadingPreview (VirtualCurrencyBalancesScreen.kt:238)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m1022getLambda5$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadingPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadingPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final VirtualCurrencyBalancesScreenViewModel getVirtualCurrencyBalancesScreenViewModel(PurchasesType purchasesType, VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel, Composer composer, int i3, int i4) {
        Composer composer2;
        composer.a0(-1589946380);
        if ((i4 & 1) != 0) {
            purchasesType = new PurchasesImpl(null, 1, 0 == true ? 1 : 0);
        }
        if ((i4 & 2) != 0) {
            VirtualCurrencyBalancesScreenViewModelFactory virtualCurrencyBalancesScreenViewModelFactory = new VirtualCurrencyBalancesScreenViewModelFactory(purchasesType);
            composer.F(1729797275);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer, 6);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            composer2 = composer;
            ViewModel viewModelB = ViewModelKt.b(Reflection.b(VirtualCurrencyBalancesScreenViewModel.class), viewModelStoreOwnerC, null, virtualCurrencyBalancesScreenViewModelFactory, viewModelStoreOwnerC instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwnerC).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f40230c, composer2, 0, 0);
            composer2.Y();
            virtualCurrencyBalancesScreenViewModel = (VirtualCurrencyBalancesScreenViewModel) viewModelB;
        } else {
            composer2 = composer;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1589946380, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.getVirtualCurrencyBalancesScreenViewModel (VirtualCurrencyBalancesScreen.kt:180)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return virtualCurrencyBalancesScreenViewModel;
    }
}
