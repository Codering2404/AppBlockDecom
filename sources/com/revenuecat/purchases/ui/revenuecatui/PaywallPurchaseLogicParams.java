package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;
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
public final class PaywallPurchaseLogicParams {
    public static final int $stable = 8;
    private final ProductChange productChange;
    private final Package rcPackage;
    private final SubscriptionOption subscriptionOption;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        public static final int $stable = 8;
        private String oldProductId;
        private final Package rcPackage;
        private ReplacementMode replacementMode;
        private SubscriptionOption subscriptionOption;

        public Builder(Package rcPackage) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            this.rcPackage = rcPackage;
        }

        public final PaywallPurchaseLogicParams build() {
            Package r02 = this.rcPackage;
            String str = this.oldProductId;
            return new PaywallPurchaseLogicParams(r02, str != null ? new ProductChange(str, this.replacementMode) : null, this.subscriptionOption);
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        public final Builder replacementMode(ReplacementMode replacementMode) {
            this.replacementMode = replacementMode;
            return this;
        }

        public final Builder subscriptionOption(SubscriptionOption subscriptionOption) {
            this.subscriptionOption = subscriptionOption;
            return this;
        }
    }

    public PaywallPurchaseLogicParams(Package rcPackage, ProductChange productChange, SubscriptionOption subscriptionOption) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        this.rcPackage = rcPackage;
        this.productChange = productChange;
        this.subscriptionOption = subscriptionOption;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallPurchaseLogicParams)) {
            return false;
        }
        PaywallPurchaseLogicParams paywallPurchaseLogicParams = (PaywallPurchaseLogicParams) obj;
        return Intrinsics.areEqual(this.rcPackage, paywallPurchaseLogicParams.rcPackage) && Intrinsics.areEqual(this.productChange, paywallPurchaseLogicParams.productChange) && Intrinsics.areEqual(this.subscriptionOption, paywallPurchaseLogicParams.subscriptionOption);
    }

    public final String getOldProductId() {
        ProductChange productChange = this.productChange;
        if (productChange != null) {
            return productChange.getOldProductId();
        }
        return null;
    }

    public final ProductChange getProductChange$revenuecatui_defaultsBc8Release() {
        return this.productChange;
    }

    public final Package getRcPackage() {
        return this.rcPackage;
    }

    public final ReplacementMode getReplacementMode() {
        ProductChange productChange = this.productChange;
        if (productChange != null) {
            return productChange.getReplacementMode();
        }
        return null;
    }

    public final SubscriptionOption getSubscriptionOption() {
        return this.subscriptionOption;
    }

    public int hashCode() {
        int iHashCode = this.rcPackage.hashCode() * 31;
        ProductChange productChange = this.productChange;
        int iHashCode2 = (iHashCode + (productChange == null ? 0 : productChange.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.subscriptionOption;
        return iHashCode2 + (subscriptionOption != null ? subscriptionOption.hashCode() : 0);
    }

    public String toString() {
        return "PaywallPurchaseLogicParams(rcPackage=" + this.rcPackage + ", productChange=" + this.productChange + ", subscriptionOption=" + this.subscriptionOption + ')';
    }
}
