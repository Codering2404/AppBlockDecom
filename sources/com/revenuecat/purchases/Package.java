package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import java.net.URL;
import kotlin.Deprecated;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Package {
    private final String identifier;
    private final PackageType packageType;
    private final PresentedOfferingContext presentedOfferingContext;
    private final StoreProduct product;
    private final URL webCheckoutURL;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        this(identifier, packageType, product, presentedOfferingContext, null, 16, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
    }

    public final Package copy$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        return new Package(this.identifier, this.packageType, this.product.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext, this.webCheckoutURL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Package)) {
            return false;
        }
        Package r5 = (Package) obj;
        return Intrinsics.areEqual(this.identifier, r5.identifier) && this.packageType == r5.packageType && Intrinsics.areEqual(this.product, r5.product) && Intrinsics.areEqual(this.presentedOfferingContext, r5.presentedOfferingContext) && Intrinsics.areEqual(this.webCheckoutURL, r5.webCheckoutURL);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getOffering() {
        String offeringIdentifier = this.presentedOfferingContext.getOfferingIdentifier();
        return offeringIdentifier == null ? "" : offeringIdentifier;
    }

    public final PackageType getPackageType() {
        return this.packageType;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public final URL getWebCheckoutURL() {
        return this.webCheckoutURL;
    }

    public int hashCode() {
        int iHashCode = ((((((this.identifier.hashCode() * 31) + this.packageType.hashCode()) * 31) + this.product.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31;
        URL url = this.webCheckoutURL;
        return iHashCode + (url == null ? 0 : url.hashCode());
    }

    public String toString() {
        return "Package(identifier=" + this.identifier + ", packageType=" + this.packageType + ", product=" + this.product + ", presentedOfferingContext=" + this.presentedOfferingContext + ", webCheckoutURL=" + this.webCheckoutURL + ')';
    }

    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext, URL url) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        this.identifier = identifier;
        this.packageType = packageType;
        this.product = product;
        this.presentedOfferingContext = presentedOfferingContext;
        this.webCheckoutURL = url;
    }

    public /* synthetic */ Package(String str, PackageType packageType, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext, URL url, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, packageType, storeProduct, presentedOfferingContext, (i3 & 16) != 0 ? null : url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Package(String identifier, PackageType packageType, StoreProduct product, String offering) {
        this(identifier, packageType, product, new PresentedOfferingContext(offering), null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(packageType, "packageType");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(offering, "offering");
    }

    @Deprecated
    public static /* synthetic */ void getOffering$annotations() {
    }
}
