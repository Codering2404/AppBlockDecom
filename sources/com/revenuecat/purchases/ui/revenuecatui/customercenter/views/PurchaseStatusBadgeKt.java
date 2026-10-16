package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
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
public final class PurchaseStatusBadgeKt {
    public static final void PurchaseStatusBadge(final PurchaseInformation purchaseInformation, final CustomerCenterConfigData.Localization localization, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Composer composerK = composer.k(256749794);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(purchaseInformation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(localization) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(256749794, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadge (PurchaseStatusBadge.kt:21)");
            }
            final BadgeInfo badgeInfo = getBadgeInfo(determinePurchaseStatus(purchaseInformation), localization, composerK, i4 & 112);
            if (badgeInfo.getText() == null || badgeInfo.m1013getColorQN2ZGVo() == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.1
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
                            PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation, localization, composer2, RecomposeScopeImplKt.a(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            SurfaceKt.a(null, RoundedCornerShapeKt.d(CustomerCenterConstants.Card.INSTANCE.m952getBADGE_CORNER_SIZED9Ej5fM()), badgeInfo.m1013getColorQN2ZGVo().B(), 0L, 0.0f, 0.0f, badgeInfo.getBorder(), ComposableLambdaKt.e(1077364541, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.2
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
                        ComposerKt.U(1077364541, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadge.<anonymous> (PurchaseStatusBadge.kt:34)");
                    }
                    String text = badgeInfo.getText();
                    MaterialTheme materialTheme = MaterialTheme.f18110a;
                    int i6 = MaterialTheme.f18111b;
                    TextStyle textStyleK = materialTheme.c(composer2, i6).k();
                    Color colorM1014getTextColorQN2ZGVo = badgeInfo.m1014getTextColorQN2ZGVo();
                    composer2.a0(2012735351);
                    long jD0 = colorM1014getTextColorQN2ZGVo == null ? materialTheme.a(composer2, i6).d0() : colorM1014getTextColorQN2ZGVo.B();
                    composer2.U();
                    Modifier.Companion companion = Modifier.b8;
                    CustomerCenterConstants.Card card = CustomerCenterConstants.Card.INSTANCE;
                    TextKt.c(text, PaddingKt.j(companion, card.m953getBADGE_HORIZONTAL_PADDINGD9Ej5fM(), card.m954getBADGE_VERTICAL_PADDINGD9Ej5fM()), jD0, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleK, composer2, 48, 0, 65528);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 12582912, 57);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.3
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
                    PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation, localization, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final PurchaseStatus determinePurchaseStatus(PurchaseInformation purchaseInformation) {
        return purchaseInformation.isExpired() ? PurchaseStatus.EXPIRED : (purchaseInformation.isCancelled() && purchaseInformation.isTrial()) ? PurchaseStatus.FREE_TRIAL_CANCELLED : (!purchaseInformation.isCancelled() || purchaseInformation.getStore() == Store.PROMOTIONAL) ? purchaseInformation.isTrial() ? PurchaseStatus.FREE_TRIAL : purchaseInformation.isLifetime() ? PurchaseStatus.LIFETIME : purchaseInformation.getExpirationOrRenewal() != null ? PurchaseStatus.ACTIVE : PurchaseStatus.NONE : PurchaseStatus.CANCELLED;
    }

    private static final BadgeInfo getBadgeInfo(PurchaseStatus purchaseStatus, CustomerCenterConfigData.Localization localization, Composer composer, int i3) {
        BadgeInfo badgeInfo;
        BadgeInfo badgeInfo2;
        composer.a0(806722768);
        if (ComposerKt.M()) {
            ComposerKt.U(806722768, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.getBadgeInfo (PurchaseStatusBadge.kt:57)");
        }
        if (purchaseStatus == PurchaseStatus.EXPIRED) {
            badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.EXPIRED), Color.n(ColorKt.b(CustomerCenterConstants.Card.COLOR_BADGE_EXPIRED)), null, null, 12, null);
        } else {
            if (purchaseStatus == PurchaseStatus.FREE_TRIAL_CANCELLED) {
                badgeInfo2 = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_FREE_TRIAL_CANCELLED), Color.n(ColorKt.b(CustomerCenterConstants.Card.COLOR_BADGE_CANCELLED)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.CANCELLED) {
                badgeInfo2 = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_CANCELLED), Color.n(ColorKt.b(CustomerCenterConstants.Card.COLOR_BADGE_CANCELLED)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.FREE_TRIAL) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_FREE_TRIAL), Color.n(ColorKt.b(CustomerCenterConstants.Card.COLOR_BADGE_FREE_TRIAL)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.LIFETIME) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_LIFETIME), Color.n(Color.f25715b.j()), BorderStrokeKt.a(Dp.g(1), Color.r(MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).d0(), 0.29f, 0.0f, 0.0f, 0.0f, 14, null)), null, 8, null);
            } else if (purchaseStatus == PurchaseStatus.ACTIVE) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.ACTIVE), Color.n(ColorKt.d(CustomerCenterConstants.Card.COLOR_BADGE_ACTIVE)), null, null, 12, null);
            } else {
                if (purchaseStatus != PurchaseStatus.NONE) {
                    throw new NoWhenBranchMatchedException();
                }
                badgeInfo = new BadgeInfo(null, null, null, null, 12, null);
            }
            badgeInfo = badgeInfo2;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return badgeInfo;
    }
}
