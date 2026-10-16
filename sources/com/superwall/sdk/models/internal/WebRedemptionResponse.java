package com.superwall.sdk.models.internal;

import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfo$$serializer;
import com.superwall.sdk.models.entitlements.Redeemable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
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
public final class WebRedemptionResponse {
    private final List<Redeemable> allCodes;
    private final List<RedemptionResult> codes;
    private final CustomerInfo customerInfo;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(RedemptionResult.Companion.serializer()), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<WebRedemptionResponse> serializer() {
            return WebRedemptionResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ WebRedemptionResponse(int i3, List list, CustomerInfo customerInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, WebRedemptionResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.codes = list;
        if ((i3 & 2) == 0) {
            this.customerInfo = null;
        } else {
            this.customerInfo = customerInfo;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new Redeemable(((RedemptionResult) it.next()).getCode(), Boolean.FALSE));
        }
        this.allCodes = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebRedemptionResponse copy$default(WebRedemptionResponse webRedemptionResponse, List list, CustomerInfo customerInfo, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = webRedemptionResponse.codes;
        }
        if ((i3 & 2) != 0) {
            customerInfo = webRedemptionResponse.customerInfo;
        }
        if ((i3 & 4) != 0) {
            list2 = webRedemptionResponse.allCodes;
        }
        return webRedemptionResponse.copy(list, customerInfo, list2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(WebRedemptionResponse webRedemptionResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], webRedemptionResponse.codes);
        if (!compositeEncoder.z(serialDescriptor, 1) && webRedemptionResponse.customerInfo == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, CustomerInfo$$serializer.INSTANCE, webRedemptionResponse.customerInfo);
    }

    public final List<RedemptionResult> component1() {
        return this.codes;
    }

    public final CustomerInfo component2() {
        return this.customerInfo;
    }

    public final List<Redeemable> component3() {
        return this.allCodes;
    }

    public final WebRedemptionResponse copy(List<? extends RedemptionResult> codes, CustomerInfo customerInfo, List<Redeemable> allCodes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(allCodes, "allCodes");
        return new WebRedemptionResponse(codes, customerInfo, allCodes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebRedemptionResponse)) {
            return false;
        }
        WebRedemptionResponse webRedemptionResponse = (WebRedemptionResponse) obj;
        return Intrinsics.areEqual(this.codes, webRedemptionResponse.codes) && Intrinsics.areEqual(this.customerInfo, webRedemptionResponse.customerInfo) && Intrinsics.areEqual(this.allCodes, webRedemptionResponse.allCodes);
    }

    public final List<Redeemable> getAllCodes() {
        return this.allCodes;
    }

    public final List<RedemptionResult> getCodes() {
        return this.codes;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public int hashCode() {
        int iHashCode = this.codes.hashCode() * 31;
        CustomerInfo customerInfo = this.customerInfo;
        return ((iHashCode + (customerInfo == null ? 0 : customerInfo.hashCode())) * 31) + this.allCodes.hashCode();
    }

    public String toString() {
        return "WebRedemptionResponse(codes=" + this.codes + ", customerInfo=" + this.customerInfo + ", allCodes=" + this.allCodes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebRedemptionResponse(List<? extends RedemptionResult> codes, CustomerInfo customerInfo, List<Redeemable> allCodes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(allCodes, "allCodes");
        this.codes = codes;
        this.customerInfo = customerInfo;
        this.allCodes = allCodes;
    }

    public /* synthetic */ WebRedemptionResponse(List list, CustomerInfo customerInfo, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        customerInfo = (i3 & 2) != 0 ? null : customerInfo;
        if ((i3 & 4) != 0) {
            List list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(new Redeemable(((RedemptionResult) it.next()).getCode(), Boolean.FALSE));
            }
            list2 = arrayList;
        }
        this(list, customerInfo, list2);
    }

    @Transient
    public static /* synthetic */ void getAllCodes$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCodes$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCustomerInfo$annotations() {
    }
}
