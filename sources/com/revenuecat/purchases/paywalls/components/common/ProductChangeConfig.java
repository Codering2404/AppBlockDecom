package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.paywalls.components.common.serializers.DowngradeReplacementModeDeserializer;
import com.revenuecat.purchases.paywalls.components.common.serializers.UpgradeReplacementModeDeserializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class ProductChangeConfig {
    public static final Companion Companion = new Companion(null);
    private final StoreReplacementMode downgradeReplacementMode;
    private final StoreReplacementMode upgradeReplacementMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ProductChangeConfig> serializer() {
            return ProductChangeConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductChangeConfig() {
        this((StoreReplacementMode) null, (StoreReplacementMode) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ProductChangeConfig productChangeConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(productChangeConfig.upgradeReplacementMode, StoreReplacementMode.CHARGE_PRORATED_PRICE)) {
            compositeEncoder.C(serialDescriptor, 0, UpgradeReplacementModeDeserializer.INSTANCE, productChangeConfig.upgradeReplacementMode);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && Intrinsics.areEqual(productChangeConfig.downgradeReplacementMode, StoreReplacementMode.DEFERRED)) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 1, DowngradeReplacementModeDeserializer.INSTANCE, productChangeConfig.downgradeReplacementMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductChangeConfig)) {
            return false;
        }
        ProductChangeConfig productChangeConfig = (ProductChangeConfig) obj;
        return Intrinsics.areEqual(this.upgradeReplacementMode, productChangeConfig.upgradeReplacementMode) && Intrinsics.areEqual(this.downgradeReplacementMode, productChangeConfig.downgradeReplacementMode);
    }

    public final /* synthetic */ StoreReplacementMode getDowngradeReplacementMode() {
        return this.downgradeReplacementMode;
    }

    public final /* synthetic */ StoreReplacementMode getUpgradeReplacementMode() {
        return this.upgradeReplacementMode;
    }

    public int hashCode() {
        return (this.upgradeReplacementMode.hashCode() * 31) + this.downgradeReplacementMode.hashCode();
    }

    public String toString() {
        return "ProductChangeConfig(upgradeReplacementMode=" + this.upgradeReplacementMode + ", downgradeReplacementMode=" + this.downgradeReplacementMode + ')';
    }

    @Deprecated
    public /* synthetic */ ProductChangeConfig(int i3, @SerialName @Serializable(with = UpgradeReplacementModeDeserializer.class) StoreReplacementMode storeReplacementMode, @SerialName @Serializable(with = DowngradeReplacementModeDeserializer.class) StoreReplacementMode storeReplacementMode2, SerializationConstructorMarker serializationConstructorMarker) {
        this.upgradeReplacementMode = (i3 & 1) == 0 ? StoreReplacementMode.CHARGE_PRORATED_PRICE : storeReplacementMode;
        if ((i3 & 2) == 0) {
            this.downgradeReplacementMode = StoreReplacementMode.DEFERRED;
        } else {
            this.downgradeReplacementMode = storeReplacementMode2;
        }
    }

    public ProductChangeConfig(StoreReplacementMode upgradeReplacementMode, StoreReplacementMode downgradeReplacementMode) {
        Intrinsics.checkNotNullParameter(upgradeReplacementMode, "upgradeReplacementMode");
        Intrinsics.checkNotNullParameter(downgradeReplacementMode, "downgradeReplacementMode");
        this.upgradeReplacementMode = upgradeReplacementMode;
        this.downgradeReplacementMode = downgradeReplacementMode;
    }

    public /* synthetic */ ProductChangeConfig(StoreReplacementMode storeReplacementMode, StoreReplacementMode storeReplacementMode2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? StoreReplacementMode.CHARGE_PRORATED_PRICE : storeReplacementMode, (i3 & 2) != 0 ? StoreReplacementMode.DEFERRED : storeReplacementMode2);
    }

    @SerialName
    @Serializable(with = DowngradeReplacementModeDeserializer.class)
    public static /* synthetic */ void getDowngradeReplacementMode$annotations() {
    }

    @SerialName
    @Serializable(with = UpgradeReplacementModeDeserializer.class)
    public static /* synthetic */ void getUpgradeReplacementMode$annotations() {
    }
}
