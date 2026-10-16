package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
import com.revenuecat.purchases.ui.revenuecatui.utils.PreviewDataCreatorsKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final /* synthetic */ class PromotionalOfferScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void PromotionalOfferScreen(final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData r48, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance r49, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r50, final kotlin.jvm.functions.Function1 r51, final kotlin.jvm.functions.Function0 r52, androidx.compose.ui.Modifier r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 1051
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferScreen(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Appearance, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void PromotionalOfferViewPreview(Composer composer, final int i3) {
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerK = composer.k(-552832253);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-552832253, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferViewPreview (PromotionalOfferScreen.kt:109)");
            }
            CustomerCenterConfigData.Screen managementScreen = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getManagementScreen();
            if (managementScreen != null && (paths = managementScreen.getPaths()) != null) {
                for (CustomerCenterConfigData.HelpPath helpPath : paths) {
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            helpPath = null;
            Intrinsics.checkNotNull(helpPath);
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer = helpPath.getPromotionalOffer();
            Intrinsics.checkNotNull(promotionalOffer);
            PromotionalOfferData promotionalOfferData = new PromotionalOfferData(promotionalOffer, PreviewDataCreatorsKt.previewSubscriptionOption$default("rc-cancel-offer", "monthly", null, null, null, null, 60, null), new CustomerCenterConfigData.HelpPath(AppEventsConstants.EVENT_PARAM_VALUE_YES, "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 248, (DefaultConstructorMarker) null), "1 month for $7.99, then $9.99/mth");
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            PromotionalOfferScreen(promotionalOfferData, CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), new Function1<SubscriptionOption, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.1
                public final void invoke(SubscriptionOption it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SubscriptionOption) obj);
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1054invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1054invoke();
                    return Unit.f139807a;
                }
            }, null, composerK, 27648, 32);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PromotionalOfferScreenKt.PromotionalOfferViewPreview.3
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
                    PromotionalOfferScreenKt.PromotionalOfferViewPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
