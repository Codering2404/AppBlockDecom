package com.facebook.appevents.iap;

import java.util.Currency;
import kotlin.Metadata;
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
public final class InAppPurchase {
    private final double amount;
    private final Currency currency;
    private final String eventName;

    public InAppPurchase(String eventName, double d3, Currency currency) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.eventName = eventName;
        this.amount = d3;
        this.currency = currency;
    }

    public static /* synthetic */ InAppPurchase copy$default(InAppPurchase inAppPurchase, String str, double d3, Currency currency, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inAppPurchase.eventName;
        }
        if ((i3 & 2) != 0) {
            d3 = inAppPurchase.amount;
        }
        if ((i3 & 4) != 0) {
            currency = inAppPurchase.currency;
        }
        return inAppPurchase.copy(str, d3, currency);
    }

    public final String component1() {
        return this.eventName;
    }

    public final double component2() {
        return this.amount;
    }

    public final Currency component3() {
        return this.currency;
    }

    public final InAppPurchase copy(String eventName, double d3, Currency currency) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new InAppPurchase(eventName, d3, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppPurchase)) {
            return false;
        }
        InAppPurchase inAppPurchase = (InAppPurchase) obj;
        return Intrinsics.areEqual(this.eventName, inAppPurchase.eventName) && Double.compare(this.amount, inAppPurchase.amount) == 0 && Intrinsics.areEqual(this.currency, inAppPurchase.currency);
    }

    public final double getAmount() {
        return this.amount;
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        return (((this.eventName.hashCode() * 31) + Double.hashCode(this.amount)) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "InAppPurchase(eventName=" + this.eventName + ", amount=" + this.amount + ", currency=" + this.currency + ')';
    }
}
