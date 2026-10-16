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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WebBillingPhase {
    public static final Companion Companion = new Companion(null);
    private final int cycleCount;
    private final String periodDuration;
    private final WebBillingPrice price;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WebBillingPhase> serializer() {
            return WebBillingPhase$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public WebBillingPhase() {
        this((WebBillingPrice) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebBillingPhase copy$default(WebBillingPhase webBillingPhase, WebBillingPrice webBillingPrice, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            webBillingPrice = webBillingPhase.price;
        }
        if ((i4 & 2) != 0) {
            str = webBillingPhase.periodDuration;
        }
        if ((i4 & 4) != 0) {
            i3 = webBillingPhase.cycleCount;
        }
        return webBillingPhase.copy(webBillingPrice, str, i3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPhase webBillingPhase, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || webBillingPhase.price != null) {
            compositeEncoder.i(serialDescriptor, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPhase.price);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || webBillingPhase.periodDuration != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, webBillingPhase.periodDuration);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && webBillingPhase.cycleCount == 1) {
            return;
        }
        compositeEncoder.w(serialDescriptor, 2, webBillingPhase.cycleCount);
    }

    public final WebBillingPrice component1() {
        return this.price;
    }

    public final String component2() {
        return this.periodDuration;
    }

    public final int component3() {
        return this.cycleCount;
    }

    public final WebBillingPhase copy(WebBillingPrice webBillingPrice, String str, int i3) {
        return new WebBillingPhase(webBillingPrice, str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPhase)) {
            return false;
        }
        WebBillingPhase webBillingPhase = (WebBillingPhase) obj;
        return Intrinsics.areEqual(this.price, webBillingPhase.price) && Intrinsics.areEqual(this.periodDuration, webBillingPhase.periodDuration) && this.cycleCount == webBillingPhase.cycleCount;
    }

    public final int getCycleCount() {
        return this.cycleCount;
    }

    public final String getPeriodDuration() {
        return this.periodDuration;
    }

    public final WebBillingPrice getPrice() {
        return this.price;
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.price;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        String str = this.periodDuration;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.cycleCount);
    }

    public String toString() {
        return "WebBillingPhase(price=" + this.price + ", periodDuration=" + this.periodDuration + ", cycleCount=" + this.cycleCount + ')';
    }

    @Deprecated
    public /* synthetic */ WebBillingPhase(int i3, WebBillingPrice webBillingPrice, @SerialName String str, @SerialName int i4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.price = null;
        } else {
            this.price = webBillingPrice;
        }
        if ((i3 & 2) == 0) {
            this.periodDuration = null;
        } else {
            this.periodDuration = str;
        }
        if ((i3 & 4) == 0) {
            this.cycleCount = 1;
        } else {
            this.cycleCount = i4;
        }
    }

    public WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i3) {
        this.price = webBillingPrice;
        this.periodDuration = str;
        this.cycleCount = i3;
    }

    public /* synthetic */ WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : webBillingPrice, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? 1 : i3);
    }

    @SerialName
    public static /* synthetic */ void getCycleCount$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPeriodDuration$annotations() {
    }
}
