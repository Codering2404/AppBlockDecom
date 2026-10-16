package com.superwall.sdk.models.entitlements;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class Redeemable {
    public static final Companion Companion = new Companion(null);
    private final String code;
    private final Boolean firstRedemption;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Redeemable> serializer() {
            return Redeemable$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Redeemable(int i3, String str, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, Redeemable$$serializer.INSTANCE.getDescriptor());
        }
        this.code = str;
        if ((i3 & 2) == 0) {
            this.firstRedemption = Boolean.FALSE;
        } else {
            this.firstRedemption = bool;
        }
    }

    public static /* synthetic */ Redeemable copy$default(Redeemable redeemable, String str, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = redeemable.code;
        }
        if ((i3 & 2) != 0) {
            bool = redeemable.firstRedemption;
        }
        return redeemable.copy(str, bool);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Redeemable redeemable, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, redeemable.code);
        if (!compositeEncoder.z(serialDescriptor, 1) && Intrinsics.areEqual(redeemable.firstRedemption, Boolean.FALSE)) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, redeemable.firstRedemption);
    }

    public final String component1() {
        return this.code;
    }

    public final Boolean component2() {
        return this.firstRedemption;
    }

    public final Redeemable copy(String code, Boolean bool) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new Redeemable(code, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Redeemable)) {
            return false;
        }
        Redeemable redeemable = (Redeemable) obj;
        return Intrinsics.areEqual(this.code, redeemable.code) && Intrinsics.areEqual(this.firstRedemption, redeemable.firstRedemption);
    }

    public final String getCode() {
        return this.code;
    }

    public final Boolean getFirstRedemption() {
        return this.firstRedemption;
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        Boolean bool = this.firstRedemption;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "Redeemable(code=" + this.code + ", firstRedemption=" + this.firstRedemption + ")";
    }

    public Redeemable(String code, Boolean bool) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.firstRedemption = bool;
    }

    public /* synthetic */ Redeemable(String str, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? Boolean.FALSE : bool);
    }

    @SerialName
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getFirstRedemption$annotations() {
    }
}
