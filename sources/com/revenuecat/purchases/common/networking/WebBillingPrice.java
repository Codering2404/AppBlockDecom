package com.revenuecat.purchases.common.networking;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WebBillingPrice {
    public static final Companion Companion = new Companion(null);
    private final long amountMicros;
    private final String currency;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WebBillingPrice> serializer() {
            return WebBillingPrice$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ WebBillingPrice(int i3, @SerialName long j3, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, WebBillingPrice$$serializer.INSTANCE.getDescriptor());
        }
        this.amountMicros = j3;
        this.currency = str;
    }

    public static /* synthetic */ WebBillingPrice copy$default(WebBillingPrice webBillingPrice, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = webBillingPrice.amountMicros;
        }
        if ((i3 & 2) != 0) {
            str = webBillingPrice.currency;
        }
        return webBillingPrice.copy(j3, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPrice webBillingPrice, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.F(serialDescriptor, 0, webBillingPrice.amountMicros);
        compositeEncoder.y(serialDescriptor, 1, webBillingPrice.currency);
    }

    public final long component1() {
        return this.amountMicros;
    }

    public final String component2() {
        return this.currency;
    }

    public final WebBillingPrice copy(long j3, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new WebBillingPrice(j3, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPrice)) {
            return false;
        }
        WebBillingPrice webBillingPrice = (WebBillingPrice) obj;
        return this.amountMicros == webBillingPrice.amountMicros && Intrinsics.areEqual(this.currency, webBillingPrice.currency);
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return (Long.hashCode(this.amountMicros) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "WebBillingPrice(amountMicros=" + this.amountMicros + ", currency=" + this.currency + ')';
    }

    public WebBillingPrice(long j3, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.amountMicros = j3;
        this.currency = currency;
    }

    @SerialName
    public static /* synthetic */ void getAmountMicros$annotations() {
    }
}
