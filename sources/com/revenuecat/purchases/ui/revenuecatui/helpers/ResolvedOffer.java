package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public abstract class ResolvedOffer {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfiguredOffer extends ResolvedOffer {
        public static final int $stable = 8;
        private final SubscriptionOption option;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfiguredOffer(SubscriptionOption option) {
            super(null);
            Intrinsics.checkNotNullParameter(option, "option");
            this.option = option;
        }

        public static /* synthetic */ ConfiguredOffer copy$default(ConfiguredOffer configuredOffer, SubscriptionOption subscriptionOption, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                subscriptionOption = configuredOffer.option;
            }
            return configuredOffer.copy(subscriptionOption);
        }

        public final SubscriptionOption component1() {
            return this.option;
        }

        public final ConfiguredOffer copy(SubscriptionOption option) {
            Intrinsics.checkNotNullParameter(option, "option");
            return new ConfiguredOffer(option);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfiguredOffer) && Intrinsics.areEqual(this.option, ((ConfiguredOffer) obj).option);
        }

        public final SubscriptionOption getOption() {
            return this.option;
        }

        public int hashCode() {
            return this.option.hashCode();
        }

        public String toString() {
            return "ConfiguredOffer(option=" + this.option + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoConfiguration extends ResolvedOffer {
        public static final int $stable = 8;
        private final SubscriptionOption option;

        public NoConfiguration(SubscriptionOption subscriptionOption) {
            super(null);
            this.option = subscriptionOption;
        }

        public static /* synthetic */ NoConfiguration copy$default(NoConfiguration noConfiguration, SubscriptionOption subscriptionOption, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                subscriptionOption = noConfiguration.option;
            }
            return noConfiguration.copy(subscriptionOption);
        }

        public final SubscriptionOption component1() {
            return this.option;
        }

        public final NoConfiguration copy(SubscriptionOption subscriptionOption) {
            return new NoConfiguration(subscriptionOption);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoConfiguration) && Intrinsics.areEqual(this.option, ((NoConfiguration) obj).option);
        }

        public final SubscriptionOption getOption() {
            return this.option;
        }

        public int hashCode() {
            SubscriptionOption subscriptionOption = this.option;
            if (subscriptionOption == null) {
                return 0;
            }
            return subscriptionOption.hashCode();
        }

        public String toString() {
            return "NoConfiguration(option=" + this.option + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OfferNotFound extends ResolvedOffer {
        public static final int $stable = 8;
        private final String configuredOfferId;
        private final SubscriptionOption fallbackOption;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferNotFound(String configuredOfferId, SubscriptionOption subscriptionOption) {
            super(null);
            Intrinsics.checkNotNullParameter(configuredOfferId, "configuredOfferId");
            this.configuredOfferId = configuredOfferId;
            this.fallbackOption = subscriptionOption;
        }

        public static /* synthetic */ OfferNotFound copy$default(OfferNotFound offerNotFound, String str, SubscriptionOption subscriptionOption, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = offerNotFound.configuredOfferId;
            }
            if ((i3 & 2) != 0) {
                subscriptionOption = offerNotFound.fallbackOption;
            }
            return offerNotFound.copy(str, subscriptionOption);
        }

        public final String component1() {
            return this.configuredOfferId;
        }

        public final SubscriptionOption component2() {
            return this.fallbackOption;
        }

        public final OfferNotFound copy(String configuredOfferId, SubscriptionOption subscriptionOption) {
            Intrinsics.checkNotNullParameter(configuredOfferId, "configuredOfferId");
            return new OfferNotFound(configuredOfferId, subscriptionOption);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferNotFound)) {
                return false;
            }
            OfferNotFound offerNotFound = (OfferNotFound) obj;
            return Intrinsics.areEqual(this.configuredOfferId, offerNotFound.configuredOfferId) && Intrinsics.areEqual(this.fallbackOption, offerNotFound.fallbackOption);
        }

        public final String getConfiguredOfferId() {
            return this.configuredOfferId;
        }

        public final SubscriptionOption getFallbackOption() {
            return this.fallbackOption;
        }

        public int hashCode() {
            int iHashCode = this.configuredOfferId.hashCode() * 31;
            SubscriptionOption subscriptionOption = this.fallbackOption;
            return iHashCode + (subscriptionOption == null ? 0 : subscriptionOption.hashCode());
        }

        public String toString() {
            return "OfferNotFound(configuredOfferId=" + this.configuredOfferId + ", fallbackOption=" + this.fallbackOption + ')';
        }
    }

    public /* synthetic */ ResolvedOffer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final SubscriptionOption getSubscriptionOption() {
        if (this instanceof ConfiguredOffer) {
            return ((ConfiguredOffer) this).getOption();
        }
        if (this instanceof NoConfiguration) {
            return ((NoConfiguration) this).getOption();
        }
        if (this instanceof OfferNotFound) {
            return ((OfferNotFound) this).getFallbackOption();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isPromoOffer() {
        return this instanceof ConfiguredOffer;
    }

    private ResolvedOffer() {
    }
}
