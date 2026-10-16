package com.superwall.sdk.models.entitlements;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

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
public final class RedeemRequest {
    private final String aliasId;
    private final List<Redeemable> codes;
    private final String deviceId;
    private final String externalAccountId;
    private final Map<String, JsonElement> metadata;
    private final List<TransactionReceipt> receipts;
    private final String userId;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(Redeemable$$serializer.INSTANCE), new ArrayListSerializer(TransactionReceipt$$serializer.INSTANCE), null, new LinkedHashMapSerializer(StringSerializer.f142891a, JsonElementSerializer.f143009a)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RedeemRequest> serializer() {
            return RedeemRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RedeemRequest(int i3, String str, String str2, String str3, List list, List list2, String str4, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (59 != (i3 & 59)) {
            PluginExceptionsKt.b(i3, 59, RedeemRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.deviceId = str;
        this.userId = str2;
        if ((i3 & 4) == 0) {
            this.aliasId = null;
        } else {
            this.aliasId = str3;
        }
        this.codes = list;
        this.receipts = list2;
        this.externalAccountId = str4;
        if ((i3 & 64) == 0) {
            this.metadata = null;
        } else {
            this.metadata = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RedeemRequest copy$default(RedeemRequest redeemRequest, String str, String str2, String str3, List list, List list2, String str4, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = redeemRequest.deviceId;
        }
        if ((i3 & 2) != 0) {
            str2 = redeemRequest.userId;
        }
        if ((i3 & 4) != 0) {
            str3 = redeemRequest.aliasId;
        }
        if ((i3 & 8) != 0) {
            list = redeemRequest.codes;
        }
        if ((i3 & 16) != 0) {
            list2 = redeemRequest.receipts;
        }
        if ((i3 & 32) != 0) {
            str4 = redeemRequest.externalAccountId;
        }
        if ((i3 & 64) != 0) {
            map = redeemRequest.metadata;
        }
        String str5 = str4;
        Map map2 = map;
        List list3 = list2;
        String str6 = str3;
        return redeemRequest.copy(str, str2, str6, list, list3, str5, map2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(RedeemRequest redeemRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, redeemRequest.deviceId);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        compositeEncoder.i(serialDescriptor, 1, stringSerializer, redeemRequest.userId);
        if (compositeEncoder.z(serialDescriptor, 2) || redeemRequest.aliasId != null) {
            compositeEncoder.i(serialDescriptor, 2, stringSerializer, redeemRequest.aliasId);
        }
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], redeemRequest.codes);
        compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], redeemRequest.receipts);
        compositeEncoder.y(serialDescriptor, 5, redeemRequest.externalAccountId);
        if (!compositeEncoder.z(serialDescriptor, 6) && redeemRequest.metadata == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 6, kSerializerArr[6], redeemRequest.metadata);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.aliasId;
    }

    public final List<Redeemable> component4() {
        return this.codes;
    }

    public final List<TransactionReceipt> component5() {
        return this.receipts;
    }

    public final String component6() {
        return this.externalAccountId;
    }

    public final Map<String, JsonElement> component7() {
        return this.metadata;
    }

    public final RedeemRequest copy(String deviceId, String str, String str2, List<Redeemable> codes, List<TransactionReceipt> receipts, String externalAccountId, Map<String, ? extends JsonElement> map) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        Intrinsics.checkNotNullParameter(externalAccountId, "externalAccountId");
        return new RedeemRequest(deviceId, str, str2, codes, receipts, externalAccountId, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemRequest)) {
            return false;
        }
        RedeemRequest redeemRequest = (RedeemRequest) obj;
        return Intrinsics.areEqual(this.deviceId, redeemRequest.deviceId) && Intrinsics.areEqual(this.userId, redeemRequest.userId) && Intrinsics.areEqual(this.aliasId, redeemRequest.aliasId) && Intrinsics.areEqual(this.codes, redeemRequest.codes) && Intrinsics.areEqual(this.receipts, redeemRequest.receipts) && Intrinsics.areEqual(this.externalAccountId, redeemRequest.externalAccountId) && Intrinsics.areEqual(this.metadata, redeemRequest.metadata);
    }

    public final String getAliasId() {
        return this.aliasId;
    }

    public final List<Redeemable> getCodes() {
        return this.codes;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getExternalAccountId() {
        return this.externalAccountId;
    }

    public final Map<String, JsonElement> getMetadata() {
        return this.metadata;
    }

    public final List<TransactionReceipt> getReceipts() {
        return this.receipts;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iHashCode = this.deviceId.hashCode() * 31;
        String str = this.userId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.aliasId;
        int iHashCode3 = (((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.codes.hashCode()) * 31) + this.receipts.hashCode()) * 31) + this.externalAccountId.hashCode()) * 31;
        Map<String, JsonElement> map = this.metadata;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "RedeemRequest(deviceId=" + this.deviceId + ", userId=" + this.userId + ", aliasId=" + this.aliasId + ", codes=" + this.codes + ", receipts=" + this.receipts + ", externalAccountId=" + this.externalAccountId + ", metadata=" + this.metadata + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RedeemRequest(String deviceId, String str, String str2, List<Redeemable> codes, List<TransactionReceipt> receipts, String externalAccountId, Map<String, ? extends JsonElement> map) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        Intrinsics.checkNotNullParameter(externalAccountId, "externalAccountId");
        this.deviceId = deviceId;
        this.userId = str;
        this.aliasId = str2;
        this.codes = codes;
        this.receipts = receipts;
        this.externalAccountId = externalAccountId;
        this.metadata = map;
    }

    public /* synthetic */ RedeemRequest(String str, String str2, String str3, List list, List list2, String str4, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, list, list2, str4, (i3 & 64) != 0 ? null : map);
    }

    @SerialName
    public static /* synthetic */ void getAliasId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCodes$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getExternalAccountId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getReceipts$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUserId$annotations() {
    }
}
