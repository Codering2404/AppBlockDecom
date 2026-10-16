package com.superwall.sdk.store.testmode.models;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
public final class SuperwallProductPrice {
    public static final Companion Companion = new Companion(null);
    private final int amount;
    private final String currency;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SuperwallProductPrice> serializer() {
            return SuperwallProductPrice$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SuperwallProductPrice(int i3, int i4, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, SuperwallProductPrice$$serializer.INSTANCE.getDescriptor());
        }
        this.amount = i4;
        this.currency = str;
    }

    public static /* synthetic */ SuperwallProductPrice copy$default(SuperwallProductPrice superwallProductPrice, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = superwallProductPrice.amount;
        }
        if ((i4 & 2) != 0) {
            str = superwallProductPrice.currency;
        }
        return superwallProductPrice.copy(i3, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SuperwallProductPrice superwallProductPrice, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.w(serialDescriptor, 0, superwallProductPrice.amount);
        compositeEncoder.y(serialDescriptor, 1, superwallProductPrice.currency);
    }

    public final int component1() {
        return this.amount;
    }

    public final String component2() {
        return this.currency;
    }

    public final SuperwallProductPrice copy(int i3, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new SuperwallProductPrice(i3, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallProductPrice)) {
            return false;
        }
        SuperwallProductPrice superwallProductPrice = (SuperwallProductPrice) obj;
        return this.amount == superwallProductPrice.amount && Intrinsics.areEqual(this.currency, superwallProductPrice.currency);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return (Integer.hashCode(this.amount) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "SuperwallProductPrice(amount=" + this.amount + ", currency=" + this.currency + ")";
    }

    public SuperwallProductPrice(int i3, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.amount = i3;
        this.currency = currency;
    }
}
