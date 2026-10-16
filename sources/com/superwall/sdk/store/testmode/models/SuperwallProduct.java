package com.superwall.sdk.store.testmode.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class SuperwallProduct {
    private final List<SuperwallEntitlementRef> entitlements;
    private final String identifier;
    private final String objectType;
    private final SuperwallProductPlatform platform;
    private final SuperwallProductPrice price;
    private final String storefront;
    private final SuperwallProductSubscription subscription;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, SuperwallProductPlatform.Companion.serializer(), null, null, new ArrayListSerializer(SuperwallEntitlementRef$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SuperwallProduct> serializer() {
            return SuperwallProduct$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SuperwallProduct(int i3, String str, String str2, SuperwallProductPlatform superwallProductPlatform, SuperwallProductPrice superwallProductPrice, SuperwallProductSubscription superwallProductSubscription, List list, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (6 != (i3 & 6)) {
            PluginExceptionsKt.b(i3, 6, SuperwallProduct$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            this.objectType = null;
        } else {
            this.objectType = str;
        }
        this.identifier = str2;
        this.platform = superwallProductPlatform;
        if ((i3 & 8) == 0) {
            this.price = null;
        } else {
            this.price = superwallProductPrice;
        }
        if ((i3 & 16) == 0) {
            this.subscription = null;
        } else {
            this.subscription = superwallProductSubscription;
        }
        if ((i3 & 32) == 0) {
            this.entitlements = CollectionsKt.emptyList();
        } else {
            this.entitlements = list;
        }
        if ((i3 & 64) == 0) {
            this.storefront = null;
        } else {
            this.storefront = str3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuperwallProduct copy$default(SuperwallProduct superwallProduct, String str, String str2, SuperwallProductPlatform superwallProductPlatform, SuperwallProductPrice superwallProductPrice, SuperwallProductSubscription superwallProductSubscription, List list, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = superwallProduct.objectType;
        }
        if ((i3 & 2) != 0) {
            str2 = superwallProduct.identifier;
        }
        if ((i3 & 4) != 0) {
            superwallProductPlatform = superwallProduct.platform;
        }
        if ((i3 & 8) != 0) {
            superwallProductPrice = superwallProduct.price;
        }
        if ((i3 & 16) != 0) {
            superwallProductSubscription = superwallProduct.subscription;
        }
        if ((i3 & 32) != 0) {
            list = superwallProduct.entitlements;
        }
        if ((i3 & 64) != 0) {
            str3 = superwallProduct.storefront;
        }
        List list2 = list;
        String str4 = str3;
        SuperwallProductSubscription superwallProductSubscription2 = superwallProductSubscription;
        SuperwallProductPlatform superwallProductPlatform2 = superwallProductPlatform;
        return superwallProduct.copy(str, str2, superwallProductPlatform2, superwallProductPrice, superwallProductSubscription2, list2, str4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SuperwallProduct superwallProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.z(serialDescriptor, 0) || superwallProduct.objectType != null) {
            compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, superwallProduct.objectType);
        }
        compositeEncoder.y(serialDescriptor, 1, superwallProduct.identifier);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], superwallProduct.platform);
        if (compositeEncoder.z(serialDescriptor, 3) || superwallProduct.price != null) {
            compositeEncoder.i(serialDescriptor, 3, SuperwallProductPrice$$serializer.INSTANCE, superwallProduct.price);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || superwallProduct.subscription != null) {
            compositeEncoder.i(serialDescriptor, 4, SuperwallProductSubscription$$serializer.INSTANCE, superwallProduct.subscription);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || !Intrinsics.areEqual(superwallProduct.entitlements, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], superwallProduct.entitlements);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && superwallProduct.storefront == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 6, StringSerializer.f142891a, superwallProduct.storefront);
    }

    public final String component1() {
        return this.objectType;
    }

    public final String component2() {
        return this.identifier;
    }

    public final SuperwallProductPlatform component3() {
        return this.platform;
    }

    public final SuperwallProductPrice component4() {
        return this.price;
    }

    public final SuperwallProductSubscription component5() {
        return this.subscription;
    }

    public final List<SuperwallEntitlementRef> component6() {
        return this.entitlements;
    }

    public final String component7() {
        return this.storefront;
    }

    public final SuperwallProduct copy(String str, String identifier, SuperwallProductPlatform platform, SuperwallProductPrice superwallProductPrice, SuperwallProductSubscription superwallProductSubscription, List<SuperwallEntitlementRef> entitlements, String str2) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new SuperwallProduct(str, identifier, platform, superwallProductPrice, superwallProductSubscription, entitlements, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallProduct)) {
            return false;
        }
        SuperwallProduct superwallProduct = (SuperwallProduct) obj;
        return Intrinsics.areEqual(this.objectType, superwallProduct.objectType) && Intrinsics.areEqual(this.identifier, superwallProduct.identifier) && this.platform == superwallProduct.platform && Intrinsics.areEqual(this.price, superwallProduct.price) && Intrinsics.areEqual(this.subscription, superwallProduct.subscription) && Intrinsics.areEqual(this.entitlements, superwallProduct.entitlements) && Intrinsics.areEqual(this.storefront, superwallProduct.storefront);
    }

    public final List<SuperwallEntitlementRef> getEntitlements() {
        return this.entitlements;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final SuperwallProductPlatform getPlatform() {
        return this.platform;
    }

    public final SuperwallProductPrice getPrice() {
        return this.price;
    }

    public final String getStorefront() {
        return this.storefront;
    }

    public final SuperwallProductSubscription getSubscription() {
        return this.subscription;
    }

    public int hashCode() {
        String str = this.objectType;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.identifier.hashCode()) * 31) + this.platform.hashCode()) * 31;
        SuperwallProductPrice superwallProductPrice = this.price;
        int iHashCode2 = (iHashCode + (superwallProductPrice == null ? 0 : superwallProductPrice.hashCode())) * 31;
        SuperwallProductSubscription superwallProductSubscription = this.subscription;
        int iHashCode3 = (((iHashCode2 + (superwallProductSubscription == null ? 0 : superwallProductSubscription.hashCode())) * 31) + this.entitlements.hashCode()) * 31;
        String str2 = this.storefront;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SuperwallProduct(objectType=" + this.objectType + ", identifier=" + this.identifier + ", platform=" + this.platform + ", price=" + this.price + ", subscription=" + this.subscription + ", entitlements=" + this.entitlements + ", storefront=" + this.storefront + ")";
    }

    public SuperwallProduct(String str, String identifier, SuperwallProductPlatform platform, SuperwallProductPrice superwallProductPrice, SuperwallProductSubscription superwallProductSubscription, List<SuperwallEntitlementRef> entitlements, String str2) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.objectType = str;
        this.identifier = identifier;
        this.platform = platform;
        this.price = superwallProductPrice;
        this.subscription = superwallProductSubscription;
        this.entitlements = entitlements;
        this.storefront = str2;
    }

    public /* synthetic */ SuperwallProduct(String str, String str2, SuperwallProductPlatform superwallProductPlatform, SuperwallProductPrice superwallProductPrice, SuperwallProductSubscription superwallProductSubscription, List list, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, str2, superwallProductPlatform, (i3 & 8) != 0 ? null : superwallProductPrice, (i3 & 16) != 0 ? null : superwallProductSubscription, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? null : str3);
    }

    @SerialName
    public static /* synthetic */ void getObjectType$annotations() {
    }
}
