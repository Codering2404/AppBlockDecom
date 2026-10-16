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
public final class WebBillingPurchaseOption {
    public static final Companion Companion = new Companion(null);
    private final WebBillingPhase base;
    private final WebBillingPrice basePrice;
    private final WebBillingPhase introPrice;
    private final WebBillingPhase trial;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WebBillingPurchaseOption> serializer() {
            return WebBillingPurchaseOption$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public WebBillingPurchaseOption() {
        this((WebBillingPrice) null, (WebBillingPhase) null, (WebBillingPhase) null, (WebBillingPhase) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebBillingPurchaseOption copy$default(WebBillingPurchaseOption webBillingPurchaseOption, WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            webBillingPrice = webBillingPurchaseOption.basePrice;
        }
        if ((i3 & 2) != 0) {
            webBillingPhase = webBillingPurchaseOption.base;
        }
        if ((i3 & 4) != 0) {
            webBillingPhase2 = webBillingPurchaseOption.trial;
        }
        if ((i3 & 8) != 0) {
            webBillingPhase3 = webBillingPurchaseOption.introPrice;
        }
        return webBillingPurchaseOption.copy(webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPurchaseOption webBillingPurchaseOption, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || webBillingPurchaseOption.basePrice != null) {
            compositeEncoder.i(serialDescriptor, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPurchaseOption.basePrice);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || webBillingPurchaseOption.base != null) {
            compositeEncoder.i(serialDescriptor, 1, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.base);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || webBillingPurchaseOption.trial != null) {
            compositeEncoder.i(serialDescriptor, 2, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.trial);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && webBillingPurchaseOption.introPrice == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.introPrice);
    }

    public final WebBillingPrice component1() {
        return this.basePrice;
    }

    public final WebBillingPhase component2() {
        return this.base;
    }

    public final WebBillingPhase component3() {
        return this.trial;
    }

    public final WebBillingPhase component4() {
        return this.introPrice;
    }

    public final WebBillingPurchaseOption copy(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3) {
        return new WebBillingPurchaseOption(webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPurchaseOption)) {
            return false;
        }
        WebBillingPurchaseOption webBillingPurchaseOption = (WebBillingPurchaseOption) obj;
        return Intrinsics.areEqual(this.basePrice, webBillingPurchaseOption.basePrice) && Intrinsics.areEqual(this.base, webBillingPurchaseOption.base) && Intrinsics.areEqual(this.trial, webBillingPurchaseOption.trial) && Intrinsics.areEqual(this.introPrice, webBillingPurchaseOption.introPrice);
    }

    public final WebBillingPhase getBase() {
        return this.base;
    }

    public final WebBillingPrice getBasePrice() {
        return this.basePrice;
    }

    public final WebBillingPhase getIntroPrice() {
        return this.introPrice;
    }

    public final WebBillingPhase getTrial() {
        return this.trial;
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.basePrice;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        WebBillingPhase webBillingPhase = this.base;
        int iHashCode2 = (iHashCode + (webBillingPhase == null ? 0 : webBillingPhase.hashCode())) * 31;
        WebBillingPhase webBillingPhase2 = this.trial;
        int iHashCode3 = (iHashCode2 + (webBillingPhase2 == null ? 0 : webBillingPhase2.hashCode())) * 31;
        WebBillingPhase webBillingPhase3 = this.introPrice;
        return iHashCode3 + (webBillingPhase3 != null ? webBillingPhase3.hashCode() : 0);
    }

    public String toString() {
        return "WebBillingPurchaseOption(basePrice=" + this.basePrice + ", base=" + this.base + ", trial=" + this.trial + ", introPrice=" + this.introPrice + ')';
    }

    @Deprecated
    public /* synthetic */ WebBillingPurchaseOption(int i3, @SerialName WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, @SerialName WebBillingPhase webBillingPhase3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.basePrice = null;
        } else {
            this.basePrice = webBillingPrice;
        }
        if ((i3 & 2) == 0) {
            this.base = null;
        } else {
            this.base = webBillingPhase;
        }
        if ((i3 & 4) == 0) {
            this.trial = null;
        } else {
            this.trial = webBillingPhase2;
        }
        if ((i3 & 8) == 0) {
            this.introPrice = null;
        } else {
            this.introPrice = webBillingPhase3;
        }
    }

    public WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3) {
        this.basePrice = webBillingPrice;
        this.base = webBillingPhase;
        this.trial = webBillingPhase2;
        this.introPrice = webBillingPhase3;
    }

    public /* synthetic */ WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : webBillingPrice, (i3 & 2) != 0 ? null : webBillingPhase, (i3 & 4) != 0 ? null : webBillingPhase2, (i3 & 8) != 0 ? null : webBillingPhase3);
    }

    @SerialName
    public static /* synthetic */ void getBasePrice$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIntroPrice$annotations() {
    }
}
