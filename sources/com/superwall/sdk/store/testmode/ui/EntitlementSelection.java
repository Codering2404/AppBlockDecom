package com.superwall.sdk.store.testmode.ui;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.Store;
import java.util.Date;
import java.util.Set;
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
public final class EntitlementSelection {
    private final String identifier;
    private final OfferTypeOption offerType;
    private final EntitlementStateOption state;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, EntitlementStateOption.Companion.serializer(), OfferTypeOption.Companion.serializer()};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<EntitlementSelection> serializer() {
            return EntitlementSelection$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ EntitlementSelection(int i3, String str, EntitlementStateOption entitlementStateOption, OfferTypeOption offerTypeOption, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, EntitlementSelection$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        if ((i3 & 2) == 0) {
            this.state = EntitlementStateOption.Inactive;
        } else {
            this.state = entitlementStateOption;
        }
        if ((i3 & 4) == 0) {
            this.offerType = OfferTypeOption.None;
        } else {
            this.offerType = offerTypeOption;
        }
    }

    public static /* synthetic */ EntitlementSelection copy$default(EntitlementSelection entitlementSelection, String str, EntitlementStateOption entitlementStateOption, OfferTypeOption offerTypeOption, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = entitlementSelection.identifier;
        }
        if ((i3 & 2) != 0) {
            entitlementStateOption = entitlementSelection.state;
        }
        if ((i3 & 4) != 0) {
            offerTypeOption = entitlementSelection.offerType;
        }
        return entitlementSelection.copy(str, entitlementStateOption, offerTypeOption);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(EntitlementSelection entitlementSelection, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, entitlementSelection.identifier);
        if (compositeEncoder.z(serialDescriptor, 1) || entitlementSelection.state != EntitlementStateOption.Inactive) {
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], entitlementSelection.state);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && entitlementSelection.offerType == OfferTypeOption.None) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], entitlementSelection.offerType);
    }

    public final String component1() {
        return this.identifier;
    }

    public final EntitlementStateOption component2() {
        return this.state;
    }

    public final OfferTypeOption component3() {
        return this.offerType;
    }

    public final EntitlementSelection copy(String identifier, EntitlementStateOption state, OfferTypeOption offerType) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        return new EntitlementSelection(identifier, state, offerType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntitlementSelection)) {
            return false;
        }
        EntitlementSelection entitlementSelection = (EntitlementSelection) obj;
        return Intrinsics.areEqual(this.identifier, entitlementSelection.identifier) && this.state == entitlementSelection.state && this.offerType == entitlementSelection.offerType;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final OfferTypeOption getOfferType() {
        return this.offerType;
    }

    public final EntitlementStateOption getState() {
        return this.state;
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + this.state.hashCode()) * 31) + this.offerType.hashCode();
    }

    public final Entitlement toEntitlement() {
        return new Entitlement(this.identifier, Entitlement.Type.SERVICE_LEVEL, this.state.isActive(), (Set) null, (String) null, (Date) null, (Date) null, (Date) null, (Boolean) null, (Boolean) null, this.state.toSubscriptionState(), this.offerType.toPeriodType(), Store.PLAY_STORE, 1016, (DefaultConstructorMarker) null);
    }

    public String toString() {
        return "EntitlementSelection(identifier=" + this.identifier + ", state=" + this.state + ", offerType=" + this.offerType + ")";
    }

    public EntitlementSelection(String identifier, EntitlementStateOption state, OfferTypeOption offerType) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this.identifier = identifier;
        this.state = state;
        this.offerType = offerType;
    }

    public /* synthetic */ EntitlementSelection(String str, EntitlementStateOption entitlementStateOption, OfferTypeOption offerTypeOption, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? EntitlementStateOption.Inactive : entitlementStateOption, (i3 & 4) != 0 ? OfferTypeOption.None : offerTypeOption);
    }
}
