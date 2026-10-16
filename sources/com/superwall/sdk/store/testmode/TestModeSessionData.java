package com.superwall.sdk.store.testmode;

import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.testmode.models.SuperwallProduct;
import com.superwall.sdk.store.testmode.ui.EntitlementSelection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TestModeSessionData {
    private SubscriptionStatus overriddenSubscriptionStatus;
    private List<SuperwallProduct> products = CollectionsKt.emptyList();
    private Map<String, StoreProduct> testProductsByFullId = MapsKt.emptyMap();
    private final CompletableDeferred<Unit> productsLoaded = CompletableDeferredKt.b(null, 1, null);
    private Set<String> entitlementIds = new LinkedHashSet();
    private List<EntitlementSelection> entitlementSelections = CollectionsKt.emptyList();
    private FreeTrialOverride freeTrialOverride = FreeTrialOverride.UseDefault;

    public final Set<String> getEntitlementIds() {
        return this.entitlementIds;
    }

    public final List<EntitlementSelection> getEntitlementSelections() {
        return this.entitlementSelections;
    }

    public final FreeTrialOverride getFreeTrialOverride() {
        return this.freeTrialOverride;
    }

    public final SubscriptionStatus getOverriddenSubscriptionStatus() {
        return this.overriddenSubscriptionStatus;
    }

    public final List<SuperwallProduct> getProducts() {
        return this.products;
    }

    public final CompletableDeferred<Unit> getProductsLoaded() {
        return this.productsLoaded;
    }

    public final Map<String, StoreProduct> getTestProductsByFullId() {
        return this.testProductsByFullId;
    }

    public final void setEntitlementIds(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.entitlementIds = set;
    }

    public final void setEntitlementSelections(List<EntitlementSelection> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.entitlementSelections = list;
    }

    public final void setFreeTrialOverride(FreeTrialOverride freeTrialOverride) {
        Intrinsics.checkNotNullParameter(freeTrialOverride, "<set-?>");
        this.freeTrialOverride = freeTrialOverride;
    }

    public final void setOverriddenSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.overriddenSubscriptionStatus = subscriptionStatus;
    }

    public final void setProducts(List<SuperwallProduct> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.products = list;
    }

    public final void setTestProductsByFullId(Map<String, StoreProduct> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.testProductsByFullId = map;
    }
}
