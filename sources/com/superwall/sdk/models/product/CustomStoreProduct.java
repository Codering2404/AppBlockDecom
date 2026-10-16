package com.superwall.sdk.models.product;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class CustomStoreProduct {
    public static final Companion Companion = new Companion(null);
    private final String productIdentifier;
    private final Store store;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CustomStoreProduct> serializer() {
            return CustomStoreProduct$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CustomStoreProduct(int i3, Store store, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i3 & 2)) {
            PluginExceptionsKt.b(i3, 2, CustomStoreProduct$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.store = Store.CUSTOM;
        } else {
            this.store = store;
        }
        this.productIdentifier = str;
    }

    public static /* synthetic */ CustomStoreProduct copy$default(CustomStoreProduct customStoreProduct, Store store, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            store = customStoreProduct.store;
        }
        if ((i3 & 2) != 0) {
            str = customStoreProduct.productIdentifier;
        }
        return customStoreProduct.copy(store, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(CustomStoreProduct customStoreProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || customStoreProduct.store != Store.CUSTOM) {
            compositeEncoder.C(serialDescriptor, 0, StoreSerializer.INSTANCE, customStoreProduct.store);
        }
        compositeEncoder.y(serialDescriptor, 1, customStoreProduct.productIdentifier);
    }

    public final Store component1() {
        return this.store;
    }

    public final String component2() {
        return this.productIdentifier;
    }

    public final CustomStoreProduct copy(Store store, String productIdentifier) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        return new CustomStoreProduct(store, productIdentifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomStoreProduct)) {
            return false;
        }
        CustomStoreProduct customStoreProduct = (CustomStoreProduct) obj;
        return this.store == customStoreProduct.store && Intrinsics.areEqual(this.productIdentifier, customStoreProduct.productIdentifier);
    }

    public final String getFullIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final Store getStore() {
        return this.store;
    }

    public int hashCode() {
        return (this.store.hashCode() * 31) + this.productIdentifier.hashCode();
    }

    public String toString() {
        return "CustomStoreProduct(store=" + this.store + ", productIdentifier=" + this.productIdentifier + ")";
    }

    public CustomStoreProduct(Store store, String productIdentifier) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        this.store = store;
        this.productIdentifier = productIdentifier;
    }

    public /* synthetic */ CustomStoreProduct(Store store, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Store.CUSTOM : store, str);
    }

    @SerialName
    public static /* synthetic */ void getProductIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }
}
