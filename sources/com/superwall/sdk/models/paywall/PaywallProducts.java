package com.superwall.sdk.models.paywall;

import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@Deprecated
@Metadata
public final class PaywallProducts {
    private final List<String> ids;
    private final StoreProduct primary;
    private final StoreProduct secondary;
    private final StoreProduct tertiary;

    public PaywallProducts() {
        this(null, null, null, 7, null);
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final StoreProduct getPrimary() {
        return this.primary;
    }

    public final StoreProduct getSecondary() {
        return this.secondary;
    }

    public final StoreProduct getTertiary() {
        return this.tertiary;
    }

    public PaywallProducts(StoreProduct storeProduct, StoreProduct storeProduct2, StoreProduct storeProduct3) {
        this.primary = storeProduct;
        this.secondary = storeProduct2;
        this.tertiary = storeProduct3;
        this.ids = CollectionsKt.listOfNotNull((Object[]) new String[]{storeProduct != null ? storeProduct.getFullIdentifier() : null, storeProduct2 != null ? storeProduct2.getFullIdentifier() : null, storeProduct3 != null ? storeProduct3.getFullIdentifier() : null});
    }

    public /* synthetic */ PaywallProducts(StoreProduct storeProduct, StoreProduct storeProduct2, StoreProduct storeProduct3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : storeProduct, (i3 & 2) != 0 ? null : storeProduct2, (i3 & 4) != 0 ? null : storeProduct3);
    }
}
