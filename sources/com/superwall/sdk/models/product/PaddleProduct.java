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
import kotlinx.serialization.internal.IntSerializer;
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
public final class PaddleProduct {
    public static final Companion Companion = new Companion(null);
    private final String environment;
    private final String productIdentifier;
    private final Store store;
    private final Integer trialDays;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaddleProduct> serializer() {
            return PaddleProduct$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PaddleProduct(int i3, Store store, String str, String str2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (6 != (i3 & 6)) {
            PluginExceptionsKt.b(i3, 6, PaddleProduct$$serializer.INSTANCE.getDescriptor());
        }
        this.store = (i3 & 1) == 0 ? Store.PADDLE : store;
        this.environment = str;
        this.productIdentifier = str2;
        if ((i3 & 8) == 0) {
            this.trialDays = null;
        } else {
            this.trialDays = num;
        }
    }

    public static /* synthetic */ PaddleProduct copy$default(PaddleProduct paddleProduct, Store store, String str, String str2, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            store = paddleProduct.store;
        }
        if ((i3 & 2) != 0) {
            str = paddleProduct.environment;
        }
        if ((i3 & 4) != 0) {
            str2 = paddleProduct.productIdentifier;
        }
        if ((i3 & 8) != 0) {
            num = paddleProduct.trialDays;
        }
        return paddleProduct.copy(store, str, str2, num);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PaddleProduct paddleProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || paddleProduct.store != Store.PADDLE) {
            compositeEncoder.C(serialDescriptor, 0, StoreSerializer.INSTANCE, paddleProduct.store);
        }
        compositeEncoder.y(serialDescriptor, 1, paddleProduct.environment);
        compositeEncoder.y(serialDescriptor, 2, paddleProduct.productIdentifier);
        if (!compositeEncoder.z(serialDescriptor, 3) && paddleProduct.trialDays == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, IntSerializer.f142823a, paddleProduct.trialDays);
    }

    public final Store component1() {
        return this.store;
    }

    public final String component2() {
        return this.environment;
    }

    public final String component3() {
        return this.productIdentifier;
    }

    public final Integer component4() {
        return this.trialDays;
    }

    public final PaddleProduct copy(Store store, String environment, String productIdentifier, Integer num) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        return new PaddleProduct(store, environment, productIdentifier, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddleProduct)) {
            return false;
        }
        PaddleProduct paddleProduct = (PaddleProduct) obj;
        return this.store == paddleProduct.store && Intrinsics.areEqual(this.environment, paddleProduct.environment) && Intrinsics.areEqual(this.productIdentifier, paddleProduct.productIdentifier) && Intrinsics.areEqual(this.trialDays, paddleProduct.trialDays);
    }

    public final String getEnvironment() {
        return this.environment;
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

    public final Integer getTrialDays() {
        return this.trialDays;
    }

    public int hashCode() {
        int iHashCode = ((((this.store.hashCode() * 31) + this.environment.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31;
        Integer num = this.trialDays;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "PaddleProduct(store=" + this.store + ", environment=" + this.environment + ", productIdentifier=" + this.productIdentifier + ", trialDays=" + this.trialDays + ")";
    }

    public PaddleProduct(Store store, String environment, String productIdentifier, Integer num) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        this.store = store;
        this.environment = environment;
        this.productIdentifier = productIdentifier;
        this.trialDays = num;
    }

    public /* synthetic */ PaddleProduct(Store store, String str, String str2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Store.PADDLE : store, str, str2, (i3 & 8) != 0 ? null : num);
    }

    @SerialName
    public static /* synthetic */ void getEnvironment$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTrialDays$annotations() {
    }
}
