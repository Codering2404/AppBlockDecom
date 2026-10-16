package com.superwall.sdk.store.abstractions.transactions;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class StorePayment {
    public static final Companion Companion = new Companion(null);
    private final String discountIdentifier;
    private final String productIdentifier;
    private final int quantity;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<StorePayment> serializer() {
            return StorePayment$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ StorePayment(int i3, String str, int i4, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, StorePayment$$serializer.INSTANCE.getDescriptor());
        }
        this.productIdentifier = str;
        this.quantity = i4;
        this.discountIdentifier = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(StorePayment storePayment, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, storePayment.productIdentifier);
        compositeEncoder.w(serialDescriptor, 1, storePayment.quantity);
        compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, storePayment.discountIdentifier);
    }

    public final String getDiscountIdentifier() {
        return this.discountIdentifier;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public StorePayment(String productIdentifier, int i3, String str) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        this.productIdentifier = productIdentifier;
        this.quantity = i3;
        this.discountIdentifier = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StorePayment(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        List listC = purchase.c();
        Intrinsics.checkNotNullExpressionValue(listC, "getProducts(...)");
        Object objFirst = CollectionsKt.first((List<? extends Object>) listC);
        Intrinsics.checkNotNullExpressionValue(objFirst, "first(...)");
        this((String) objFirst, 1, null);
    }
}
