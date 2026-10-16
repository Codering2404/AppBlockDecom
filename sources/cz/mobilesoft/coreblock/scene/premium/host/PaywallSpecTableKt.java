package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.Context;
import android.text.BidiFormatter;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.Review;
import cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PromoCodeDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallLayout;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class PaywallSpecTableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PaywallChrome f113351a = new PaywallChrome(RemoteButtonText.Discount, null, null, false, true, 14, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaywallLayout.Standard f113352b = new PaywallLayout.Standard(true, true, true, true, true, false, 32, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final String A(String str, String str2, DiscountSource discountSource, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        if (str != null && str.length() != 0) {
            return str;
        }
        if (str2 != null) {
            return context.getString(R.string.mc, context.getString(R.string.f95790f1), str2);
        }
        if (discountSource == DiscountSource.REFERRAL_SENDER) {
            return context.getString(R.string.hs);
        }
        if (discountSource == DiscountSource.REFERRAL_RECEIVER) {
            return context.getString(R.string.gs);
        }
        return null;
    }

    public static final PaywallSpec B(final PaywallTarget target, String str) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (Intrinsics.areEqual(target, PaywallTarget.Generic.INSTANCE)) {
            return new PaywallSpec(RevenueCatPlacement.General, f113352b, new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.u0
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.D(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.w0
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.E(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.OfferDiscountUnlessFirstStart, new PaywallAnalytics(null, ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER, null, null, false, false, 61, null), new PaywallChrome(RemoteButtonText.PremiumScreen, null, null, true, false, 22, null), null, null, null, null, false, false, false, false, false, false, false, false, false, 524224, null);
        }
        if (target instanceof PaywallTarget.LimitScreen) {
            return new PaywallSpec(RevenueCatPlacement.LimitScreen, f113352b, new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.x0
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.P(target, context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.y0
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.R(target, context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.OfferDiscount, new PaywallAnalytics("limit", ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER, null, null, false, false, 60, null), new PaywallChrome(RemoteButtonText.PremiumScreen, null, null, true, false, 22, null), null, null, null, null, false, false, false, false, false, false, false, false, false, 524224, null);
        }
        if (target instanceof PaywallTarget.IntroTrial) {
            return new PaywallSpec(RevenueCatPlacement.TrialHeadsUp, PaywallLayout.RcTrial.f113324a, PaywallCopy.f113178e.a(), CloseBehaviour.DashboardOnTopUnlessFirstStart, new PaywallAnalytics(null, "ethical_trial", null, null, false, true, 29, null), new PaywallChrome(null, null, null, false, false, 31, null), null, null, null, OtherOptionsSheet.RcTrial, true, false, false, false, true, false, false, false, false, 506304, null);
        }
        if (Intrinsics.areEqual(target, PaywallTarget.IntroTrialToggle.INSTANCE)) {
            return new PaywallSpec(RevenueCatPlacement.TrialToggle, PaywallLayout.IntroTrialToggle.f113322a, new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.z0
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.S(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.a1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.T(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "trial_toggle", null, null, false, false, 61, null), null, null, null, null, null, false, false, false, false, false, false, false, false, true, 262112, null);
        }
        if (target instanceof PaywallTarget.Discount) {
            PaywallTarget.Discount discount = (PaywallTarget.Discount) target;
            DiscountSource source = discount.getSource();
            if (source == null) {
                source = DiscountSource.DEEPLINK;
                if (!discount.isFromDeeplink()) {
                    source = null;
                }
            }
            RevenueCatPlacement placement = discount.getPlacement();
            if (placement == null) {
                placement = x(source);
            }
            return y(placement, source, null, str, discount.isFromDeeplink());
        }
        if (target instanceof PaywallTarget.PromoCode) {
            PaywallTarget.PromoCode promoCode = (PaywallTarget.PromoCode) target;
            RevenueCatPlacement revenueCatPlacementX = x(promoCode.getSource());
            DiscountSource source2 = promoCode.getSource();
            PromoCodeDTO promoCode2 = promoCode.getPromoCode();
            return y(revenueCatPlacementX, source2, promoCode2 != null ? promoCode2.getLabel() : null, str, true);
        }
        if (target instanceof PaywallTarget.Campaign) {
            return new PaywallSpec(RevenueCatPlacement.Campaign, new PaywallLayout.Illustrated(false, false, false, false, false, null, 63, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.b1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.U(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.c1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.V(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "discount", Long.valueOf(((PaywallTarget.Campaign) target).getCampaignId()), null, false, false, 57, null), f113351a, PaywallViewModelKind.Campaign, PaywallOnOpen.ClearCampaignRequest, null, null, false, true, false, false, false, false, false, false, false, 489216, null);
        }
        if (target instanceof PaywallTarget.ExpiredSub) {
            return new PaywallSpec(RevenueCatPlacement.RenewPremium, new PaywallLayout.Illustrated(false, true, false, false, false, null, 61, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.d1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.W(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.e1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.F(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "exsub", null, null, false, false, 61, null), new PaywallChrome(RemoteButtonText.PremiumScreen, Integer.valueOf(R.string.bC), Integer.valueOf(R.drawable.K7), false, false, 24, null), null, PaywallOnOpen.ClearExpiredSubOfferMarker, null, null, false, false, false, false, false, false, false, false, false, 524096, null);
        }
        if (target instanceof PaywallTarget.ExpiredSubDiscount) {
            return new PaywallSpec(RevenueCatPlacement.PremiumRetention, new PaywallLayout.Illustrated(false, false, true, false, false, Integer.valueOf(R.string.Im), 2, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.f1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.G(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.i1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.H(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.DashboardWhenOpeningDashboard, new PaywallAnalytics(null, "exsub", null, null, false, false, 61, null), new PaywallChrome(RemoteButtonText.PremiumScreen, Integer.valueOf(R.string.bC), Integer.valueOf(R.drawable.S7), false, false, 24, null), null, null, null, null, false, false, false, ((PaywallTarget.ExpiredSubDiscount) target).getOpenDashboard(), false, false, false, false, false, 516032, null);
        }
        if (Intrinsics.areEqual(target, PaywallTarget.TrialRetention.INSTANCE)) {
            return new PaywallSpec(RevenueCatPlacement.TrialRetention, new PaywallLayout.Standard(true, false, false, true, false, false, 54, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.j1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.I(context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.k1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.J(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.DashboardWhenOpeningDashboard, new PaywallAnalytics(null, "trial_retention", null, null, false, false, 61, null), new PaywallChrome(null, Integer.valueOf(R.string.os), null, false, false, 29, null), null, null, OfferUsedMarker.TrialRetentionOffer, null, false, false, false, false, false, false, false, false, false, 523968, null);
        }
        if (target instanceof PaywallTarget.OneTimeToSub) {
            return new PaywallSpec(RevenueCatPlacement.OnetimeToSub, new PaywallLayout.Illustrated(false, false, false, false, false, null, 63, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.l1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.K(target, context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.m1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.L(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "onetime", null, null, false, false, 61, null), null, null, null, null, null, false, false, false, false, false, false, false, false, false, 524256, null);
        }
        if (target instanceof PaywallTarget.MySubscription) {
            return new PaywallSpec(RevenueCatPlacement.PremiumScreen, PaywallLayout.MySubscription.f113323a, new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.n1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.M(target, context, premiumScreenViewState);
                }
            }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.o1
                @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
                public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                    return PaywallSpecTableKt.N(context, premiumScreenViewState);
                }
            }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "mysub", null, null, false, false, 61, null), null, PaywallViewModelKind.MySubscription, null, null, null, false, false, false, false, false, false, false, true, false, 360352, null);
        }
        if (!(target instanceof PaywallTarget.AutoTrialPromo)) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallText paywallText = new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.p1
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallSpecTableKt.O(target, context, premiumScreenViewState);
            }
        };
        PaywallText paywallText2 = new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.v0
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallSpecTableKt.Q(target, context, premiumScreenViewState);
            }
        };
        return new PaywallSpec(RevenueCatPlacement.PromoTrialUpgrade, new PaywallLayout.Illustrated(false, false, true, false, false, null, 51, null), new PaywallCopy(paywallText, paywallText2, paywallText, paywallText2), CloseBehaviour.Finish, new PaywallAnalytics(null, "promo_trial_upgrade", null, null, false, false, 61, null), new PaywallChrome(RemoteButtonText.PremiumScreen, Integer.valueOf(R.string.bC), Integer.valueOf(R.drawable.H7), false, false, 24, null), null, null, ((PaywallTarget.AutoTrialPromo) target).getExpired() ? OfferUsedMarker.AutoTrialExpiredScreen : OfferUsedMarker.Nothing, null, false, false, false, false, false, false, false, false, false, 523968, null);
    }

    public static /* synthetic */ PaywallSpec C(PaywallTarget paywallTarget, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return B(paywallTarget, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String D(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        return state.Y() ? context.getString(R.string.ME) : context.getString(R.string.Me);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String E(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!state.Y()) {
            return context.getString(R.string.Hi);
        }
        return context.getString(R.string.hq) + "\n" + context.getString(R.string.Hi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String F(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.H9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String G(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.Sp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.Rp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String I(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String J(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.rE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String K(PaywallTarget paywallTarget, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        String title = ((PaywallTarget.OneTimeToSub) paywallTarget).getTitle();
        if (!StringsKt.p0(title)) {
            return title;
        }
        String string = context.getString(R.string.r2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String L(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.Jm, context.getString(R.string.f95790f1), NumberFormat.getPercentInstance().format(0.5d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String M(PaywallTarget paywallTarget, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return ((PaywallTarget.MySubscription) paywallTarget).getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String N(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O(PaywallTarget paywallTarget, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return ((PaywallTarget.AutoTrialPromo) paywallTarget).getExpired() ? context.getString(R.string.f95769a2) : context.getString(R.string.vd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String P(PaywallTarget paywallTarget, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(((PaywallTarget.LimitScreen) paywallTarget).getFeature().getTitleResId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q(PaywallTarget paywallTarget, Context context, PremiumScreenViewState state) {
        Integer numB;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        PremiumOptionDTO premiumOptionDTOD = state.D();
        String strUnicodeWrap = (premiumOptionDTOD == null || (numB = premiumOptionDTOD.b()) == null) ? null : BidiFormatter.getInstance().unicodeWrap(NumberFormat.getPercentInstance(Locale.getDefault()).format(((double) numB.intValue()) / 100.0d));
        if (strUnicodeWrap == null) {
            strUnicodeWrap = "";
        }
        return ((PaywallTarget.AutoTrialPromo) paywallTarget).getExpired() ? context.getString(R.string.mi, strUnicodeWrap) : context.getString(R.string.ji, strUnicodeWrap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String R(PaywallTarget paywallTarget, Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return ((PaywallTarget.LimitScreen) paywallTarget).getFeature().getDescription(context).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String S(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        return state.Z() ? context.getString(R.string.Ce) : context.getString(R.string.Nq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        return state.Z() ? context.getString(R.string.Qf) : context.getString(R.string.up, 97);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String U(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(state, "state");
        CampaignOfferResponse campaignOfferResponseW = w(state);
        if (campaignOfferResponseW != null) {
            return campaignOfferResponseW.getTitle();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V(Context context, PremiumScreenViewState state) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(state, "state");
        CampaignOfferResponse campaignOfferResponseW = w(state);
        if (campaignOfferResponseW != null) {
            return campaignOfferResponseW.getBody();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String W(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return context.getString(R.string.RD);
    }

    public static final List X(PaywallTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return target instanceof PaywallTarget.LimitScreen ? Review.Companion.j(((PaywallTarget.LimitScreen) target).getFeature()) : target instanceof PaywallTarget.IntroTrial ? Review.Companion.i() : Review.Companion.d();
    }

    private static final CampaignOfferResponse w(PremiumScreenViewState premiumScreenViewState) {
        PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewStateX = premiumScreenViewState.x();
        CampaignPaywallViewModel.CampaignScreenTypeViewState campaignScreenTypeViewState = premiumScreenTypeViewStateX instanceof CampaignPaywallViewModel.CampaignScreenTypeViewState ? (CampaignPaywallViewModel.CampaignScreenTypeViewState) premiumScreenTypeViewStateX : null;
        if (campaignScreenTypeViewState != null) {
            return campaignScreenTypeViewState.j();
        }
        return null;
    }

    private static final RevenueCatPlacement x(DiscountSource discountSource) {
        return discountSource == DiscountSource.NOTIFICATION ? RevenueCatPlacement.Campaign : RevenueCatPlacement.PremiumScreen;
    }

    private static final PaywallSpec y(RevenueCatPlacement revenueCatPlacement, final DiscountSource discountSource, final String str, final String str2, boolean z2) {
        return new PaywallSpec(revenueCatPlacement, new PaywallLayout.Illustrated(false, false, false, false, false, null, 63, null), new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.g1
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallSpecTableKt.z(context, premiumScreenViewState);
            }
        }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.h1
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallSpecTableKt.A(str2, str, discountSource, context, premiumScreenViewState);
            }
        }, null, null, 12, null), CloseBehaviour.Finish, new PaywallAnalytics(null, "discount", null, discountSource != null ? discountSource.getAnalyticsString() : null, true, false, 37, null), f113351a, PaywallViewModelKind.Discount, PaywallOnOpen.CancelScheduledDiscountNotification, null, null, false, true, true, z2, false, false, true, false, false, 411392, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z(Context context, PremiumScreenViewState state) {
        Integer numB;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        PremiumOptionDTO premiumOptionDTOD = state.D();
        if (premiumOptionDTOD != null && (numB = premiumOptionDTOD.b()) != null) {
            int iIntValue = numB.intValue();
            String string = context.getString(R.string.pc, iIntValue + " %");
            if (string != null) {
                return string;
            }
        }
        String string2 = context.getString(R.string.nc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }
}
