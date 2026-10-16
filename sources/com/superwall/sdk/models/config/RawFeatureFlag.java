package com.superwall.sdk.models.config;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class RawFeatureFlag {
    public static final Companion Companion = new Companion(null);
    private final boolean enabled;
    private final String key;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RawFeatureFlag> serializer() {
            return RawFeatureFlag$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RawFeatureFlag(int i3, String str, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, RawFeatureFlag$$serializer.INSTANCE.getDescriptor());
        }
        this.key = str;
        this.enabled = z2;
    }

    public static /* synthetic */ RawFeatureFlag copy$default(RawFeatureFlag rawFeatureFlag, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rawFeatureFlag.key;
        }
        if ((i3 & 2) != 0) {
            z2 = rawFeatureFlag.enabled;
        }
        return rawFeatureFlag.copy(str, z2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(RawFeatureFlag rawFeatureFlag, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, rawFeatureFlag.key);
        compositeEncoder.x(serialDescriptor, 1, rawFeatureFlag.enabled);
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final RawFeatureFlag copy(String key, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new RawFeatureFlag(key, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RawFeatureFlag)) {
            return false;
        }
        RawFeatureFlag rawFeatureFlag = (RawFeatureFlag) obj;
        return Intrinsics.areEqual(this.key, rawFeatureFlag.key) && this.enabled == rawFeatureFlag.enabled;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "RawFeatureFlag(key=" + this.key + ", enabled=" + this.enabled + ")";
    }

    public RawFeatureFlag(String key, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.enabled = z2;
    }

    @SerialName
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getKey$annotations() {
    }
}
