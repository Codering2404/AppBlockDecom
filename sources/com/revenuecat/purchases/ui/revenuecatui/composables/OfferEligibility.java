package com.revenuecat.purchases.ui.revenuecatui.composables;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class OfferEligibility {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Ineligible extends OfferEligibility {
        public static final int $stable = 0;
        public static final Ineligible INSTANCE = new Ineligible();

        private Ineligible() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntroOfferMultiple extends OfferEligibility {
        public static final int $stable = 0;
        public static final IntroOfferMultiple INSTANCE = new IntroOfferMultiple();

        private IntroOfferMultiple() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntroOfferSingle extends OfferEligibility {
        public static final int $stable = 0;
        public static final IntroOfferSingle INSTANCE = new IntroOfferSingle();

        private IntroOfferSingle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PromoOfferIneligible extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferIneligible INSTANCE = new PromoOfferIneligible();

        private PromoOfferIneligible() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PromoOfferMultiple extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferMultiple INSTANCE = new PromoOfferMultiple();

        private PromoOfferMultiple() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PromoOfferSingle extends OfferEligibility {
        public static final int $stable = 0;
        public static final PromoOfferSingle INSTANCE = new PromoOfferSingle();

        private PromoOfferSingle() {
            super(null);
        }
    }

    public /* synthetic */ OfferEligibility(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean getHasMultipleDiscountedPhases() {
        return (this instanceof IntroOfferMultiple) || (this instanceof PromoOfferMultiple);
    }

    public final boolean isIntroOffer() {
        return (this instanceof IntroOfferSingle) || (this instanceof IntroOfferMultiple);
    }

    public final boolean isPromoOffer() {
        return (this instanceof PromoOfferSingle) || (this instanceof PromoOfferMultiple);
    }

    private OfferEligibility() {
    }
}
