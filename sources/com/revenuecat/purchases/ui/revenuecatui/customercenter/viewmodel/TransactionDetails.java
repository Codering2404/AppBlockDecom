package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.net.Uri;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Date;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class TransactionDetails {
    public static final int $stable = 0;
    private final boolean isSandbox;
    private final Price price;
    private final String productIdentifier;
    private final Store store;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NonSubscription extends TransactionDetails {
        public static final int $stable = 0;
        private final boolean isSandbox;
        private final Price price;
        private final String productIdentifier;
        private final Store store;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonSubscription(String productIdentifier, Store store, Price price, boolean z2) {
            super(productIdentifier, store, price, z2, null);
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(store, "store");
            this.productIdentifier = productIdentifier;
            this.store = store;
            this.price = price;
            this.isSandbox = z2;
        }

        public static /* synthetic */ NonSubscription copy$default(NonSubscription nonSubscription, String str, Store store, Price price, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = nonSubscription.productIdentifier;
            }
            if ((i3 & 2) != 0) {
                store = nonSubscription.store;
            }
            if ((i3 & 4) != 0) {
                price = nonSubscription.price;
            }
            if ((i3 & 8) != 0) {
                z2 = nonSubscription.isSandbox;
            }
            return nonSubscription.copy(str, store, price, z2);
        }

        public final String component1() {
            return this.productIdentifier;
        }

        public final Store component2() {
            return this.store;
        }

        public final Price component3() {
            return this.price;
        }

        public final boolean component4() {
            return this.isSandbox;
        }

        public final NonSubscription copy(String productIdentifier, Store store, Price price, boolean z2) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(store, "store");
            return new NonSubscription(productIdentifier, store, price, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NonSubscription)) {
                return false;
            }
            NonSubscription nonSubscription = (NonSubscription) obj;
            return Intrinsics.areEqual(this.productIdentifier, nonSubscription.productIdentifier) && this.store == nonSubscription.store && Intrinsics.areEqual(this.price, nonSubscription.price) && this.isSandbox == nonSubscription.isSandbox;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public Price getPrice() {
            return this.price;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public String getProductIdentifier() {
            return this.productIdentifier;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public Store getStore() {
            return this.store;
        }

        public int hashCode() {
            int iHashCode = ((this.productIdentifier.hashCode() * 31) + this.store.hashCode()) * 31;
            Price price = this.price;
            return ((iHashCode + (price == null ? 0 : price.hashCode())) * 31) + Boolean.hashCode(this.isSandbox);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public boolean isSandbox() {
            return this.isSandbox;
        }

        public String toString() {
            return "NonSubscription(productIdentifier=" + this.productIdentifier + ", store=" + this.store + ", price=" + this.price + ", isSandbox=" + this.isSandbox + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Subscription extends TransactionDetails {
        public static final int $stable = 0;
        private final Date expiresDate;
        private final boolean isActive;
        private final boolean isSandbox;
        private final boolean isTrial;
        private final Uri managementURL;
        private final Price price;
        private final String productIdentifier;
        private final String productPlanIdentifier;
        private final Store store;
        private final boolean willRenew;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Subscription(String productIdentifier, String str, Store store, boolean z2, boolean z3, Date date, boolean z4, Uri uri, Price price, boolean z5) {
            super(productIdentifier, store, price, z5, null);
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(store, "store");
            this.productIdentifier = productIdentifier;
            this.productPlanIdentifier = str;
            this.store = store;
            this.isActive = z2;
            this.willRenew = z3;
            this.expiresDate = date;
            this.isTrial = z4;
            this.managementURL = uri;
            this.price = price;
            this.isSandbox = z5;
        }

        public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, String str2, Store store, boolean z2, boolean z3, Date date, boolean z4, Uri uri, Price price, boolean z5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = subscription.productIdentifier;
            }
            if ((i3 & 2) != 0) {
                str2 = subscription.productPlanIdentifier;
            }
            if ((i3 & 4) != 0) {
                store = subscription.store;
            }
            if ((i3 & 8) != 0) {
                z2 = subscription.isActive;
            }
            if ((i3 & 16) != 0) {
                z3 = subscription.willRenew;
            }
            if ((i3 & 32) != 0) {
                date = subscription.expiresDate;
            }
            if ((i3 & 64) != 0) {
                z4 = subscription.isTrial;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                uri = subscription.managementURL;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                price = subscription.price;
            }
            if ((i3 & 512) != 0) {
                z5 = subscription.isSandbox;
            }
            Price price2 = price;
            boolean z6 = z5;
            boolean z7 = z4;
            Uri uri2 = uri;
            boolean z8 = z3;
            Date date2 = date;
            return subscription.copy(str, str2, store, z2, z8, date2, z7, uri2, price2, z6);
        }

        public final String component1() {
            return this.productIdentifier;
        }

        public final boolean component10() {
            return this.isSandbox;
        }

        public final String component2() {
            return this.productPlanIdentifier;
        }

        public final Store component3() {
            return this.store;
        }

        public final boolean component4() {
            return this.isActive;
        }

        public final boolean component5() {
            return this.willRenew;
        }

        public final Date component6() {
            return this.expiresDate;
        }

        public final boolean component7() {
            return this.isTrial;
        }

        public final Uri component8() {
            return this.managementURL;
        }

        public final Price component9() {
            return this.price;
        }

        public final Subscription copy(String productIdentifier, String str, Store store, boolean z2, boolean z3, Date date, boolean z4, Uri uri, Price price, boolean z5) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            Intrinsics.checkNotNullParameter(store, "store");
            return new Subscription(productIdentifier, str, store, z2, z3, date, z4, uri, price, z5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subscription)) {
                return false;
            }
            Subscription subscription = (Subscription) obj;
            return Intrinsics.areEqual(this.productIdentifier, subscription.productIdentifier) && Intrinsics.areEqual(this.productPlanIdentifier, subscription.productPlanIdentifier) && this.store == subscription.store && this.isActive == subscription.isActive && this.willRenew == subscription.willRenew && Intrinsics.areEqual(this.expiresDate, subscription.expiresDate) && this.isTrial == subscription.isTrial && Intrinsics.areEqual(this.managementURL, subscription.managementURL) && Intrinsics.areEqual(this.price, subscription.price) && this.isSandbox == subscription.isSandbox;
        }

        public final Date getExpiresDate() {
            return this.expiresDate;
        }

        public final Uri getManagementURL() {
            return this.managementURL;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public Price getPrice() {
            return this.price;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final String getProductPlanIdentifier() {
            return this.productPlanIdentifier;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public Store getStore() {
            return this.store;
        }

        public final boolean getWillRenew() {
            return this.willRenew;
        }

        public int hashCode() {
            int iHashCode = this.productIdentifier.hashCode() * 31;
            String str = this.productPlanIdentifier;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + Boolean.hashCode(this.willRenew)) * 31;
            Date date = this.expiresDate;
            int iHashCode3 = (((iHashCode2 + (date == null ? 0 : date.hashCode())) * 31) + Boolean.hashCode(this.isTrial)) * 31;
            Uri uri = this.managementURL;
            int iHashCode4 = (iHashCode3 + (uri == null ? 0 : uri.hashCode())) * 31;
            Price price = this.price;
            return ((iHashCode4 + (price != null ? price.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSandbox);
        }

        public final boolean isActive() {
            return this.isActive;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails
        public boolean isSandbox() {
            return this.isSandbox;
        }

        public final boolean isTrial() {
            return this.isTrial;
        }

        public String toString() {
            return "Subscription(productIdentifier=" + this.productIdentifier + ", productPlanIdentifier=" + this.productPlanIdentifier + ", store=" + this.store + ", isActive=" + this.isActive + ", willRenew=" + this.willRenew + ", expiresDate=" + this.expiresDate + ", isTrial=" + this.isTrial + ", managementURL=" + this.managementURL + ", price=" + this.price + ", isSandbox=" + this.isSandbox + ')';
        }
    }

    public /* synthetic */ TransactionDetails(String str, Store store, Price price, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, store, price, z2);
    }

    public Price getPrice() {
        return this.price;
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    public Store getStore() {
        return this.store;
    }

    public boolean isSandbox() {
        return this.isSandbox;
    }

    private TransactionDetails(String str, Store store, Price price, boolean z2) {
        this.productIdentifier = str;
        this.store = store;
        this.price = price;
        this.isSandbox = z2;
    }
}
