package com.superwall.sdk.paywall.presentation.internal.request;

import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.paywall.PaywallProducts;
import com.superwall.sdk.paywall.presentation.internal.request.ProductOverride;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public final class PaywallOverrides {
    public static final Companion Companion = new Companion(null);
    private final boolean ignoreSubscriptionStatus;
    private final PaywallPresentationStyle presentationStyle;
    private final PaywallProducts products;
    private final Map<String, StoreProduct> productsByName;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, StoreProduct> mapFromPaywallProducts(PaywallProducts paywallProducts) {
            StoreProduct tertiary;
            StoreProduct secondary;
            StoreProduct primary;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (paywallProducts != null && (primary = paywallProducts.getPrimary()) != null) {
                linkedHashMap.put("primary", primary);
            }
            if (paywallProducts != null && (secondary = paywallProducts.getSecondary()) != null) {
                linkedHashMap.put("secondary", secondary);
            }
            if (paywallProducts != null && (tertiary = paywallProducts.getTertiary()) != null) {
                linkedHashMap.put("tertiary", tertiary);
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PaywallProducts mapToPaywallProducts(Map<String, StoreProduct> map) {
            StoreProduct storeProduct = map.get("primary");
            StoreProduct storeProduct2 = map.get("secondary");
            StoreProduct storeProduct3 = map.get("tertiary");
            if (storeProduct == null && storeProduct2 == null && storeProduct3 == null) {
                return null;
            }
            return new PaywallProducts(storeProduct, storeProduct2, storeProduct3);
        }

        private Companion() {
        }
    }

    public PaywallOverrides() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallOverrides copy$default(PaywallOverrides paywallOverrides, Map map, boolean z2, PaywallPresentationStyle paywallPresentationStyle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = paywallOverrides.productsByName;
        }
        if ((i3 & 2) != 0) {
            z2 = paywallOverrides.ignoreSubscriptionStatus;
        }
        if ((i3 & 4) != 0) {
            paywallPresentationStyle = paywallOverrides.presentationStyle;
        }
        return paywallOverrides.copy(map, z2, paywallPresentationStyle);
    }

    public final Map<String, StoreProduct> component1() {
        return this.productsByName;
    }

    public final boolean component2() {
        return this.ignoreSubscriptionStatus;
    }

    public final PaywallPresentationStyle component3() {
        return this.presentationStyle;
    }

    public final PaywallOverrides copy(Map<String, StoreProduct> productsByName, boolean z2, PaywallPresentationStyle presentationStyle) {
        Intrinsics.checkNotNullParameter(productsByName, "productsByName");
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        return new PaywallOverrides(productsByName, z2, presentationStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallOverrides)) {
            return false;
        }
        PaywallOverrides paywallOverrides = (PaywallOverrides) obj;
        return Intrinsics.areEqual(this.productsByName, paywallOverrides.productsByName) && this.ignoreSubscriptionStatus == paywallOverrides.ignoreSubscriptionStatus && Intrinsics.areEqual(this.presentationStyle, paywallOverrides.presentationStyle);
    }

    public final boolean getIgnoreSubscriptionStatus() {
        return this.ignoreSubscriptionStatus;
    }

    public final PaywallPresentationStyle getPresentationStyle() {
        return this.presentationStyle;
    }

    public final Map<String, ProductOverride> getProductOverridesByName() {
        Map<String, StoreProduct> map = this.productsByName;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new ProductOverride.ByProduct((StoreProduct) entry.getValue()));
        }
        return linkedHashMap;
    }

    public final PaywallProducts getProducts() {
        return this.products;
    }

    public final Map<String, StoreProduct> getProductsByName() {
        return this.productsByName;
    }

    public int hashCode() {
        return (((this.productsByName.hashCode() * 31) + Boolean.hashCode(this.ignoreSubscriptionStatus)) * 31) + this.presentationStyle.hashCode();
    }

    public String toString() {
        return "PaywallOverrides(productsByName=" + this.productsByName + ", ignoreSubscriptionStatus=" + this.ignoreSubscriptionStatus + ", presentationStyle=" + this.presentationStyle + ")";
    }

    public PaywallOverrides(Map<String, StoreProduct> productsByName, boolean z2, PaywallPresentationStyle presentationStyle) {
        Intrinsics.checkNotNullParameter(productsByName, "productsByName");
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        this.productsByName = productsByName;
        this.ignoreSubscriptionStatus = z2;
        this.presentationStyle = presentationStyle;
        this.products = Companion.mapToPaywallProducts(productsByName);
    }

    public /* synthetic */ PaywallOverrides(Map map, boolean z2, PaywallPresentationStyle paywallPresentationStyle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt.emptyMap() : map, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? PaywallPresentationStyle.None.INSTANCE : paywallPresentationStyle);
    }

    @Deprecated
    public PaywallOverrides(PaywallProducts paywallProducts) {
        this(Companion.mapFromPaywallProducts(paywallProducts), false, null, 6, null);
    }

    @Deprecated
    public PaywallOverrides(PaywallProducts paywallProducts, boolean z2) {
        this(Companion.mapFromPaywallProducts(paywallProducts), z2, null, 4, null);
    }

    @Deprecated
    public static /* synthetic */ void getProducts$annotations() {
    }
}
