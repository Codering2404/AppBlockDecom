package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SelectedPurchaseDetailViewKt {
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SelectedPurchaseDetailView(final java.lang.String r30, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r31, final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation r32, final java.util.List<com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath> r33, androidx.compose.ui.Modifier r34, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(java.lang.String, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation, java.util.List, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectedPurchaseDetailViewPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1898383606);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1898383606, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewPreview (SelectedPurchaseDetailView.kt:67)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            final PurchaseInformation purchaseInformationMonthlyRenewing = customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing();
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(1713352777, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1713352777, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewPreview.<anonymous> (SelectedPurchaseDetailView.kt:72)");
                    }
                    SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(customerCenterConfigDataCustomerCenterData$default.getSupport().getEmail(), customerCenterConfigDataCustomerCenterData$default.getLocalization(), purchaseInformationMonthlyRenewing, screen2.getPaths(), null, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.1.1
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, composer2, 196608, 16);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.2
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
                    SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
