package cz.mobilesoft.coreblock.scene.premium.host;

import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.dto.PromoCodeDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface PaywallTarget extends Serializable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AutoTrialPromo implements PaywallTarget {
        public static final int $stable = 0;
        private final boolean expired;

        public AutoTrialPromo() {
            this(false, 1, null);
        }

        public static /* synthetic */ AutoTrialPromo copy$default(AutoTrialPromo autoTrialPromo, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = autoTrialPromo.expired;
            }
            return autoTrialPromo.copy(z2);
        }

        public final boolean component1() {
            return this.expired;
        }

        public final AutoTrialPromo copy(boolean z2) {
            return new AutoTrialPromo(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AutoTrialPromo) && this.expired == ((AutoTrialPromo) obj).expired;
        }

        public final boolean getExpired() {
            return this.expired;
        }

        public int hashCode() {
            return Boolean.hashCode(this.expired);
        }

        public String toString() {
            return "AutoTrialPromo(expired=" + this.expired + ")";
        }

        public AutoTrialPromo(boolean z2) {
            this.expired = z2;
        }

        public /* synthetic */ AutoTrialPromo(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Campaign implements PaywallTarget {
        public static final int $stable = 0;
        private final long campaignId;
        private final CampaignSource campaignSource;
        private final String source;

        public Campaign(long j3, CampaignSource campaignSource, String source) {
            Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
            Intrinsics.checkNotNullParameter(source, "source");
            this.campaignId = j3;
            this.campaignSource = campaignSource;
            this.source = source;
        }

        public static /* synthetic */ Campaign copy$default(Campaign campaign, long j3, CampaignSource campaignSource, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = campaign.campaignId;
            }
            if ((i3 & 2) != 0) {
                campaignSource = campaign.campaignSource;
            }
            if ((i3 & 4) != 0) {
                str = campaign.source;
            }
            return campaign.copy(j3, campaignSource, str);
        }

        public final long component1() {
            return this.campaignId;
        }

        public final CampaignSource component2() {
            return this.campaignSource;
        }

        public final String component3() {
            return this.source;
        }

        public final Campaign copy(long j3, CampaignSource campaignSource, String source) {
            Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
            Intrinsics.checkNotNullParameter(source, "source");
            return new Campaign(j3, campaignSource, source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Campaign)) {
                return false;
            }
            Campaign campaign = (Campaign) obj;
            return this.campaignId == campaign.campaignId && this.campaignSource == campaign.campaignSource && Intrinsics.areEqual(this.source, campaign.source);
        }

        public final long getCampaignId() {
            return this.campaignId;
        }

        public final CampaignSource getCampaignSource() {
            return this.campaignSource;
        }

        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            return (((Long.hashCode(this.campaignId) * 31) + this.campaignSource.hashCode()) * 31) + this.source.hashCode();
        }

        public String toString() {
            return "Campaign(campaignId=" + this.campaignId + ", campaignSource=" + this.campaignSource + ", source=" + this.source + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExpiredSub implements PaywallTarget {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        public static final int OFFER_1 = 1;
        public static final int OFFER_2 = 2;
        public static final int OFFER_2_DISCOUNT_PERCENT = 50;
        private final int offerId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.RUNTIME)
        @Metadata
        public @interface ExSubOfferId {
        }

        public ExpiredSub(@ExSubOfferId int i3) {
            this.offerId = i3;
        }

        public static /* synthetic */ ExpiredSub copy$default(ExpiredSub expiredSub, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = expiredSub.offerId;
            }
            return expiredSub.copy(i3);
        }

        public final int component1() {
            return this.offerId;
        }

        public final ExpiredSub copy(@ExSubOfferId int i3) {
            return new ExpiredSub(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ExpiredSub) && this.offerId == ((ExpiredSub) obj).offerId;
        }

        public final int getOfferId() {
            return this.offerId;
        }

        public int hashCode() {
            return Integer.hashCode(this.offerId);
        }

        public String toString() {
            return "ExpiredSub(offerId=" + this.offerId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExpiredSubDiscount implements PaywallTarget {
        public static final int $stable = 0;
        private final boolean openDashboard;

        public ExpiredSubDiscount() {
            this(false, 1, null);
        }

        public static /* synthetic */ ExpiredSubDiscount copy$default(ExpiredSubDiscount expiredSubDiscount, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = expiredSubDiscount.openDashboard;
            }
            return expiredSubDiscount.copy(z2);
        }

        public final boolean component1() {
            return this.openDashboard;
        }

        public final ExpiredSubDiscount copy(boolean z2) {
            return new ExpiredSubDiscount(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ExpiredSubDiscount) && this.openDashboard == ((ExpiredSubDiscount) obj).openDashboard;
        }

        public final boolean getOpenDashboard() {
            return this.openDashboard;
        }

        public int hashCode() {
            return Boolean.hashCode(this.openDashboard);
        }

        public String toString() {
            return "ExpiredSubDiscount(openDashboard=" + this.openDashboard + ")";
        }

        public ExpiredSubDiscount(boolean z2) {
            this.openDashboard = z2;
        }

        public /* synthetic */ ExpiredSubDiscount(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Generic implements PaywallTarget {
        public static final int $stable = 0;
        public static final Generic INSTANCE = new Generic();

        private Generic() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Generic);
        }

        public int hashCode() {
            return 626371562;
        }

        public String toString() {
            return "Generic";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntroTrial implements PaywallTarget {
        public static final int $stable = 0;
        private final boolean fromDevMenu;

        public IntroTrial() {
            this(false, 1, null);
        }

        public static /* synthetic */ IntroTrial copy$default(IntroTrial introTrial, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = introTrial.fromDevMenu;
            }
            return introTrial.copy(z2);
        }

        public final boolean component1() {
            return this.fromDevMenu;
        }

        public final IntroTrial copy(boolean z2) {
            return new IntroTrial(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntroTrial) && this.fromDevMenu == ((IntroTrial) obj).fromDevMenu;
        }

        public final boolean getFromDevMenu() {
            return this.fromDevMenu;
        }

        public int hashCode() {
            return Boolean.hashCode(this.fromDevMenu);
        }

        public String toString() {
            return "IntroTrial(fromDevMenu=" + this.fromDevMenu + ")";
        }

        public IntroTrial(boolean z2) {
            this.fromDevMenu = z2;
        }

        public /* synthetic */ IntroTrial(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntroTrialToggle implements PaywallTarget {
        public static final int $stable = 0;
        public static final IntroTrialToggle INSTANCE = new IntroTrialToggle();

        private IntroTrialToggle() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof IntroTrialToggle);
        }

        public int hashCode() {
            return -850471093;
        }

        public String toString() {
            return "IntroTrialToggle";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LimitScreen implements PaywallTarget {
        public static final int $stable = 0;
        private final PremiumFeature feature;

        public LimitScreen(PremiumFeature feature) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            this.feature = feature;
        }

        public static /* synthetic */ LimitScreen copy$default(LimitScreen limitScreen, PremiumFeature premiumFeature, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                premiumFeature = limitScreen.feature;
            }
            return limitScreen.copy(premiumFeature);
        }

        public final PremiumFeature component1() {
            return this.feature;
        }

        public final LimitScreen copy(PremiumFeature feature) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            return new LimitScreen(feature);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LimitScreen) && this.feature == ((LimitScreen) obj).feature;
        }

        public final PremiumFeature getFeature() {
            return this.feature;
        }

        public int hashCode() {
            return this.feature.hashCode();
        }

        public String toString() {
            return "LimitScreen(feature=" + this.feature + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MySubscription implements PaywallTarget {
        public static final int $stable = 0;
        private final String title;

        public MySubscription(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
        }

        public static /* synthetic */ MySubscription copy$default(MySubscription mySubscription, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = mySubscription.title;
            }
            return mySubscription.copy(str);
        }

        public final String component1() {
            return this.title;
        }

        public final MySubscription copy(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new MySubscription(title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MySubscription) && Intrinsics.areEqual(this.title, ((MySubscription) obj).title);
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "MySubscription(title=" + this.title + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OneTimeToSub implements PaywallTarget {
        public static final int $stable = 0;
        private final String title;

        public OneTimeToSub(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
        }

        public static /* synthetic */ OneTimeToSub copy$default(OneTimeToSub oneTimeToSub, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = oneTimeToSub.title;
            }
            return oneTimeToSub.copy(str);
        }

        public final String component1() {
            return this.title;
        }

        public final OneTimeToSub copy(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new OneTimeToSub(title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OneTimeToSub) && Intrinsics.areEqual(this.title, ((OneTimeToSub) obj).title);
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return this.title.hashCode();
        }

        public String toString() {
            return "OneTimeToSub(title=" + this.title + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PromoCode implements PaywallTarget {
        public static final int $stable = 0;
        private final PromoCodeDTO promoCode;
        private final DiscountSource source;

        public PromoCode(PromoCodeDTO promoCodeDTO, DiscountSource discountSource) {
            this.promoCode = promoCodeDTO;
            this.source = discountSource;
        }

        public static /* synthetic */ PromoCode copy$default(PromoCode promoCode, PromoCodeDTO promoCodeDTO, DiscountSource discountSource, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                promoCodeDTO = promoCode.promoCode;
            }
            if ((i3 & 2) != 0) {
                discountSource = promoCode.source;
            }
            return promoCode.copy(promoCodeDTO, discountSource);
        }

        public final PromoCodeDTO component1() {
            return this.promoCode;
        }

        public final DiscountSource component2() {
            return this.source;
        }

        public final PromoCode copy(PromoCodeDTO promoCodeDTO, DiscountSource discountSource) {
            return new PromoCode(promoCodeDTO, discountSource);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PromoCode)) {
                return false;
            }
            PromoCode promoCode = (PromoCode) obj;
            return Intrinsics.areEqual(this.promoCode, promoCode.promoCode) && this.source == promoCode.source;
        }

        public final PromoCodeDTO getPromoCode() {
            return this.promoCode;
        }

        public final DiscountSource getSource() {
            return this.source;
        }

        public int hashCode() {
            PromoCodeDTO promoCodeDTO = this.promoCode;
            int iHashCode = (promoCodeDTO == null ? 0 : promoCodeDTO.hashCode()) * 31;
            DiscountSource discountSource = this.source;
            return iHashCode + (discountSource != null ? discountSource.hashCode() : 0);
        }

        public String toString() {
            return "PromoCode(promoCode=" + this.promoCode + ", source=" + this.source + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrialRetention implements PaywallTarget {
        public static final int $stable = 0;
        public static final TrialRetention INSTANCE = new TrialRetention();

        private TrialRetention() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof TrialRetention);
        }

        public int hashCode() {
            return 126548789;
        }

        public String toString() {
            return "TrialRetention";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Discount implements PaywallTarget {
        public static final int $stable = 0;
        private final boolean isFromDeeplink;
        private final String offeringFromDeeplink;
        private final RevenueCatPlacement placement;
        private final DiscountSource source;

        public Discount(RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource, boolean z2, String str) {
            this.placement = revenueCatPlacement;
            this.source = discountSource;
            this.isFromDeeplink = z2;
            this.offeringFromDeeplink = str;
        }

        public static /* synthetic */ Discount copy$default(Discount discount, RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource, boolean z2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                revenueCatPlacement = discount.placement;
            }
            if ((i3 & 2) != 0) {
                discountSource = discount.source;
            }
            if ((i3 & 4) != 0) {
                z2 = discount.isFromDeeplink;
            }
            if ((i3 & 8) != 0) {
                str = discount.offeringFromDeeplink;
            }
            return discount.copy(revenueCatPlacement, discountSource, z2, str);
        }

        public final RevenueCatPlacement component1() {
            return this.placement;
        }

        public final DiscountSource component2() {
            return this.source;
        }

        public final boolean component3() {
            return this.isFromDeeplink;
        }

        public final String component4() {
            return this.offeringFromDeeplink;
        }

        public final Discount copy(RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource, boolean z2, String str) {
            return new Discount(revenueCatPlacement, discountSource, z2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Discount)) {
                return false;
            }
            Discount discount = (Discount) obj;
            return this.placement == discount.placement && this.source == discount.source && this.isFromDeeplink == discount.isFromDeeplink && Intrinsics.areEqual(this.offeringFromDeeplink, discount.offeringFromDeeplink);
        }

        public final String getOfferingFromDeeplink() {
            return this.offeringFromDeeplink;
        }

        public final RevenueCatPlacement getPlacement() {
            return this.placement;
        }

        public final DiscountSource getSource() {
            return this.source;
        }

        public int hashCode() {
            RevenueCatPlacement revenueCatPlacement = this.placement;
            int iHashCode = (revenueCatPlacement == null ? 0 : revenueCatPlacement.hashCode()) * 31;
            DiscountSource discountSource = this.source;
            int iHashCode2 = (((iHashCode + (discountSource == null ? 0 : discountSource.hashCode())) * 31) + Boolean.hashCode(this.isFromDeeplink)) * 31;
            String str = this.offeringFromDeeplink;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public final boolean isFromDeeplink() {
            return this.isFromDeeplink;
        }

        public String toString() {
            return "Discount(placement=" + this.placement + ", source=" + this.source + ", isFromDeeplink=" + this.isFromDeeplink + ", offeringFromDeeplink=" + this.offeringFromDeeplink + ")";
        }

        public /* synthetic */ Discount(RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource, boolean z2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(revenueCatPlacement, discountSource, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? null : str);
        }
    }
}
