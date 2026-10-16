package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.ExpirationOrRenewal;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
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
public final class PurchaseInformationCardViewKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ButtonPosition.values().length];
            try {
                iArr[ButtonPosition.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonPosition.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonPosition.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonPosition.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Store.values().length];
            try {
                iArr2[Store.APP_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Store.MAC_APP_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Store.PLAY_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Store.AMAZON.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Store.GALAXY.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Store.PROMOTIONAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Store.STRIPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Store.EXTERNAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Store.PADDLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[Store.RC_BILLING.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[Store.UNKNOWN_STORE.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[Store.TEST_STORE.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PurchaseInformationCardView(final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation r21, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r22, androidx.compose.ui.Modifier r23, com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ButtonPosition r24, boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ButtonPosition, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseInformationCardView_Preview(@PreviewParameter final PurchaseInformation purchaseInformation, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1729898988);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(purchaseInformation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1729898988, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview (PurchaseInformationCardView.kt:201)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(832472595, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.1
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
                        ComposerKt.U(832472595, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview.<anonymous> (PurchaseInformationCardView.kt:203)");
                    }
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 2, null).getLocalization(), null, null, false, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.1.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1056invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1056invoke();
                            return Unit.f139807a;
                        }
                    }, composer2, 196608, 28);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview.2
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
                    PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview(purchaseInformation, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseInformationCardView_Preview_Scale2(@PreviewParameter final PurchaseInformation purchaseInformation, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1576933981);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(purchaseInformation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1576933981, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview_Scale2 (PurchaseInformationCardView.kt:218)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(184551620, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.1
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
                        ComposerKt.U(184551620, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardView_Preview_Scale2.<anonymous> (PurchaseInformationCardView.kt:220)");
                    }
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 2, null).getLocalization(), null, null, false, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.1.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1057invoke() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1057invoke();
                            return Unit.f139807a;
                        }
                    }, composer2, 196608, 28);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2.2
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
                    PurchaseInformationCardViewKt.PurchaseInformationCardView_Preview_Scale2(purchaseInformation, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final String getPrice(PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        PriceDetails pricePaid = purchaseInformation.getPricePaid();
        if (pricePaid instanceof PriceDetails.Paid) {
            return ((PriceDetails.Paid) purchaseInformation.getPricePaid()).getPrice();
        }
        if (Intrinsics.areEqual(pricePaid, PriceDetails.Free.INSTANCE)) {
            return localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE);
        }
        if (Intrinsics.areEqual(pricePaid, PriceDetails.Unknown.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getStoreText(Store store, CustomerCenterConfigData.Localization localization) {
        CustomerCenterConfigData.Localization.CommonLocalizedString commonLocalizedString;
        switch (WhenMappings.$EnumSwitchMapping$1[store.ordinal()]) {
            case 1:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.APP_STORE;
                break;
            case 2:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.MAC_APP_STORE;
                break;
            case 3:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.GOOGLE_PLAY_STORE;
                break;
            case 4:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.AMAZON_STORE;
                break;
            case 5:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.GALAXY_STORE;
                break;
            case 6:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.CARD_STORE_PROMOTIONAL;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.WEB_STORE;
                break;
            case 11:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.UNKNOWN_STORE;
                break;
            case 12:
                commonLocalizedString = CustomerCenterConfigData.Localization.CommonLocalizedString.TEST_STORE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return localization.commonLocalizedString(commonLocalizedString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSubtitle(PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        ExpirationOrRenewal expirationOrRenewal = purchaseInformation.getExpirationOrRenewal();
        if (expirationOrRenewal instanceof ExpirationOrRenewal.Expiration) {
            return purchaseInformation.expirationString(((ExpirationOrRenewal.Expiration) purchaseInformation.getExpirationOrRenewal()).getDate(), localization);
        }
        if (expirationOrRenewal instanceof ExpirationOrRenewal.Renewal) {
            return purchaseInformation.renewalString(((ExpirationOrRenewal.Renewal) purchaseInformation.getExpirationOrRenewal()).getDate(), localization);
        }
        if (expirationOrRenewal == null) {
            return getPrice(purchaseInformation, localization);
        }
        throw new NoWhenBranchMatchedException();
    }
}
