package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.Experiment;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
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
public final class VariantOption {
    private String id;
    private String paywallId;
    private int percentage;
    private Experiment.Variant.VariantType type;
    private final Experiment.Variant variant;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {Experiment.Variant.VariantType.Companion.serializer(), null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VariantOption> serializer() {
            return VariantOption$$serializer.INSTANCE;
        }

        public final VariantOption stub() {
            Experiment.Variant.VariantType variantType = Experiment.Variant.VariantType.TREATMENT;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new VariantOption(variantType, string, 100, UUID.randomUUID().toString());
        }

        private Companion() {
        }
    }

    public /* synthetic */ VariantOption(int i3, Experiment.Variant.VariantType variantType, String str, int i4, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, VariantOption$$serializer.INSTANCE.getDescriptor());
        }
        this.type = variantType;
        this.id = str;
        this.percentage = i4;
        if ((i3 & 8) == 0) {
            this.paywallId = null;
        } else {
            this.paywallId = str2;
        }
        this.variant = toVariant();
    }

    public static /* synthetic */ VariantOption copy$default(VariantOption variantOption, Experiment.Variant.VariantType variantType, String str, int i3, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            variantType = variantOption.type;
        }
        if ((i4 & 2) != 0) {
            str = variantOption.id;
        }
        if ((i4 & 4) != 0) {
            i3 = variantOption.percentage;
        }
        if ((i4 & 8) != 0) {
            str2 = variantOption.paywallId;
        }
        return variantOption.copy(variantType, str, i3, str2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(VariantOption variantOption, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], variantOption.type);
        compositeEncoder.y(serialDescriptor, 1, variantOption.id);
        compositeEncoder.w(serialDescriptor, 2, variantOption.percentage);
        if (!compositeEncoder.z(serialDescriptor, 3) && variantOption.paywallId == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, variantOption.paywallId);
    }

    public final Experiment.Variant.VariantType component1() {
        return this.type;
    }

    public final String component2() {
        return this.id;
    }

    public final int component3() {
        return this.percentage;
    }

    public final String component4() {
        return this.paywallId;
    }

    public final VariantOption copy(Experiment.Variant.VariantType type, String id, int i3, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        return new VariantOption(type, id, i3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VariantOption)) {
            return false;
        }
        VariantOption variantOption = (VariantOption) obj;
        return this.type == variantOption.type && Intrinsics.areEqual(this.id, variantOption.id) && this.percentage == variantOption.percentage && Intrinsics.areEqual(this.paywallId, variantOption.paywallId);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPaywallId() {
        return this.paywallId;
    }

    public final int getPercentage() {
        return this.percentage;
    }

    public final Experiment.Variant.VariantType getType() {
        return this.type;
    }

    public final Experiment.Variant getVariant() {
        return this.variant;
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + Integer.hashCode(this.percentage)) * 31;
        String str = this.paywallId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setPaywallId(String str) {
        this.paywallId = str;
    }

    public final void setPercentage(int i3) {
        this.percentage = i3;
    }

    public final void setType(Experiment.Variant.VariantType variantType) {
        Intrinsics.checkNotNullParameter(variantType, "<set-?>");
        this.type = variantType;
    }

    public String toString() {
        return "VariantOption(type=" + this.type + ", id=" + this.id + ", percentage=" + this.percentage + ", paywallId=" + this.paywallId + ")";
    }

    public final Experiment.Variant toVariant() {
        return new Experiment.Variant(this.id, this.type, this.paywallId);
    }

    public VariantOption(Experiment.Variant.VariantType type, String id, int i3, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        this.type = type;
        this.id = id;
        this.percentage = i3;
        this.paywallId = str;
        this.variant = toVariant();
    }

    public /* synthetic */ VariantOption(Experiment.Variant.VariantType variantType, String str, int i3, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(variantType, str, i3, (i4 & 8) != 0 ? null : str2);
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPaywallId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPercentage$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getType$annotations() {
    }

    @Transient
    public static /* synthetic */ void getVariant$annotations() {
    }
}
