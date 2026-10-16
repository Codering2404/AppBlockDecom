package com.superwall.sdk.models.internal;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.Entitlement$$serializer;
import com.superwall.sdk.models.internal.RedemptionResult;
import java.util.List;
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
public final class RedemptionInfo {
    private final List<Entitlement> entitlements;
    private final RedemptionOwnership ownership;
    private final RedemptionResult.PaywallInfo paywallInfo;
    private final PurchaserInfo purchaserInfo;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {RedemptionOwnership.Companion.serializer(), null, null, new ArrayListSerializer(Entitlement$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RedemptionInfo> serializer() {
            return RedemptionInfo$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RedemptionInfo(int i3, RedemptionOwnership redemptionOwnership, PurchaserInfo purchaserInfo, RedemptionResult.PaywallInfo paywallInfo, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i3 & 11)) {
            PluginExceptionsKt.b(i3, 11, RedemptionInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.ownership = redemptionOwnership;
        this.purchaserInfo = purchaserInfo;
        if ((i3 & 4) == 0) {
            this.paywallInfo = null;
        } else {
            this.paywallInfo = paywallInfo;
        }
        this.entitlements = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RedemptionInfo copy$default(RedemptionInfo redemptionInfo, RedemptionOwnership redemptionOwnership, PurchaserInfo purchaserInfo, RedemptionResult.PaywallInfo paywallInfo, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            redemptionOwnership = redemptionInfo.ownership;
        }
        if ((i3 & 2) != 0) {
            purchaserInfo = redemptionInfo.purchaserInfo;
        }
        if ((i3 & 4) != 0) {
            paywallInfo = redemptionInfo.paywallInfo;
        }
        if ((i3 & 8) != 0) {
            list = redemptionInfo.entitlements;
        }
        return redemptionInfo.copy(redemptionOwnership, purchaserInfo, paywallInfo, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(RedemptionInfo redemptionInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], redemptionInfo.ownership);
        compositeEncoder.C(serialDescriptor, 1, PurchaserInfo$$serializer.INSTANCE, redemptionInfo.purchaserInfo);
        if (compositeEncoder.z(serialDescriptor, 2) || redemptionInfo.paywallInfo != null) {
            compositeEncoder.i(serialDescriptor, 2, RedemptionResult$PaywallInfo$$serializer.INSTANCE, redemptionInfo.paywallInfo);
        }
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], redemptionInfo.entitlements);
    }

    public final RedemptionOwnership component1() {
        return this.ownership;
    }

    public final PurchaserInfo component2() {
        return this.purchaserInfo;
    }

    public final RedemptionResult.PaywallInfo component3() {
        return this.paywallInfo;
    }

    public final List<Entitlement> component4() {
        return this.entitlements;
    }

    public final RedemptionInfo copy(RedemptionOwnership ownership, PurchaserInfo purchaserInfo, RedemptionResult.PaywallInfo paywallInfo, List<Entitlement> entitlements) {
        Intrinsics.checkNotNullParameter(ownership, "ownership");
        Intrinsics.checkNotNullParameter(purchaserInfo, "purchaserInfo");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new RedemptionInfo(ownership, purchaserInfo, paywallInfo, entitlements);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedemptionInfo)) {
            return false;
        }
        RedemptionInfo redemptionInfo = (RedemptionInfo) obj;
        return Intrinsics.areEqual(this.ownership, redemptionInfo.ownership) && Intrinsics.areEqual(this.purchaserInfo, redemptionInfo.purchaserInfo) && Intrinsics.areEqual(this.paywallInfo, redemptionInfo.paywallInfo) && Intrinsics.areEqual(this.entitlements, redemptionInfo.entitlements);
    }

    public final List<Entitlement> getEntitlements() {
        return this.entitlements;
    }

    public final RedemptionOwnership getOwnership() {
        return this.ownership;
    }

    public final RedemptionResult.PaywallInfo getPaywallInfo() {
        return this.paywallInfo;
    }

    public final PurchaserInfo getPurchaserInfo() {
        return this.purchaserInfo;
    }

    public int hashCode() {
        int iHashCode = ((this.ownership.hashCode() * 31) + this.purchaserInfo.hashCode()) * 31;
        RedemptionResult.PaywallInfo paywallInfo = this.paywallInfo;
        return ((iHashCode + (paywallInfo == null ? 0 : paywallInfo.hashCode())) * 31) + this.entitlements.hashCode();
    }

    public String toString() {
        return "RedemptionInfo(ownership=" + this.ownership + ", purchaserInfo=" + this.purchaserInfo + ", paywallInfo=" + this.paywallInfo + ", entitlements=" + this.entitlements + ")";
    }

    public RedemptionInfo(RedemptionOwnership ownership, PurchaserInfo purchaserInfo, RedemptionResult.PaywallInfo paywallInfo, List<Entitlement> entitlements) {
        Intrinsics.checkNotNullParameter(ownership, "ownership");
        Intrinsics.checkNotNullParameter(purchaserInfo, "purchaserInfo");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.ownership = ownership;
        this.purchaserInfo = purchaserInfo;
        this.paywallInfo = paywallInfo;
        this.entitlements = entitlements;
    }

    public /* synthetic */ RedemptionInfo(RedemptionOwnership redemptionOwnership, PurchaserInfo purchaserInfo, RedemptionResult.PaywallInfo paywallInfo, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(redemptionOwnership, purchaserInfo, (i3 & 4) != 0 ? null : paywallInfo, list);
    }

    @SerialName
    public static /* synthetic */ void getEntitlements$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOwnership$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPaywallInfo$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPurchaserInfo$annotations() {
    }
}
