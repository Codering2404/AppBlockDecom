package com.superwall.sdk.models.entitlements;

import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfo$$serializer;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class WebEntitlements {
    public static final Companion Companion = new Companion(null);
    private final CustomerInfo customerInfo;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<WebEntitlements> serializer() {
            return WebEntitlements$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebEntitlements() {
        this((CustomerInfo) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ WebEntitlements copy$default(WebEntitlements webEntitlements, CustomerInfo customerInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customerInfo = webEntitlements.customerInfo;
        }
        return webEntitlements.copy(customerInfo);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(WebEntitlements webEntitlements, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (!compositeEncoder.z(serialDescriptor, 0) && webEntitlements.customerInfo == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 0, CustomerInfo$$serializer.INSTANCE, webEntitlements.customerInfo);
    }

    public final CustomerInfo component1() {
        return this.customerInfo;
    }

    public final WebEntitlements copy(CustomerInfo customerInfo) {
        return new WebEntitlements(customerInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WebEntitlements) && Intrinsics.areEqual(this.customerInfo, ((WebEntitlements) obj).customerInfo);
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public int hashCode() {
        CustomerInfo customerInfo = this.customerInfo;
        if (customerInfo == null) {
            return 0;
        }
        return customerInfo.hashCode();
    }

    public String toString() {
        return "WebEntitlements(customerInfo=" + this.customerInfo + ")";
    }

    public /* synthetic */ WebEntitlements(int i3, CustomerInfo customerInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.customerInfo = null;
        } else {
            this.customerInfo = customerInfo;
        }
    }

    public WebEntitlements(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public /* synthetic */ WebEntitlements(CustomerInfo customerInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : customerInfo);
    }

    @SerialName
    public static /* synthetic */ void getCustomerInfo$annotations() {
    }
}
