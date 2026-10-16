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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class SuperwallEntitlementRef {
    public static final Companion Companion = new Companion(null);
    private final String identifier;
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SuperwallEntitlementRef> serializer() {
            return SuperwallEntitlementRef$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SuperwallEntitlementRef(int i3, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, SuperwallEntitlementRef$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        if ((i3 & 2) == 0) {
            this.type = null;
        } else {
            this.type = str2;
        }
    }

    public static /* synthetic */ SuperwallEntitlementRef copy$default(SuperwallEntitlementRef superwallEntitlementRef, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = superwallEntitlementRef.identifier;
        }
        if ((i3 & 2) != 0) {
            str2 = superwallEntitlementRef.type;
        }
        return superwallEntitlementRef.copy(str, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SuperwallEntitlementRef superwallEntitlementRef, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, superwallEntitlementRef.identifier);
        if (!compositeEncoder.z(serialDescriptor, 1) && superwallEntitlementRef.type == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, superwallEntitlementRef.type);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.type;
    }

    public final SuperwallEntitlementRef copy(String identifier, String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new SuperwallEntitlementRef(identifier, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperwallEntitlementRef)) {
            return false;
        }
        SuperwallEntitlementRef superwallEntitlementRef = (SuperwallEntitlementRef) obj;
        return Intrinsics.areEqual(this.identifier, superwallEntitlementRef.identifier) && Intrinsics.areEqual(this.type, superwallEntitlementRef.type);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.identifier.hashCode() * 31;
        String str = this.type;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SuperwallEntitlementRef(identifier=" + this.identifier + ", type=" + this.type + ")";
    }

    public SuperwallEntitlementRef(String identifier, String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.type = str;
    }

    public /* synthetic */ SuperwallEntitlementRef(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }
}
