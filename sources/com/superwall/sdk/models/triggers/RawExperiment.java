package com.superwall.sdk.models.triggers;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
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
public final class RawExperiment {
    private String groupId;
    private String id;
    private List<VariantOption> variants;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(VariantOption$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<RawExperiment> serializer() {
            return RawExperiment$$serializer.INSTANCE;
        }

        public final RawExperiment stub() {
            return new RawExperiment("abc", "def", CollectionsKt.listOf(VariantOption.Companion.stub()));
        }

        private Companion() {
        }
    }

    public /* synthetic */ RawExperiment(int i3, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, RawExperiment$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.groupId = str2;
        this.variants = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RawExperiment copy$default(RawExperiment rawExperiment, String str, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rawExperiment.id;
        }
        if ((i3 & 2) != 0) {
            str2 = rawExperiment.groupId;
        }
        if ((i3 & 4) != 0) {
            list = rawExperiment.variants;
        }
        return rawExperiment.copy(str, str2, list);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(RawExperiment rawExperiment, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, rawExperiment.id);
        compositeEncoder.y(serialDescriptor, 1, rawExperiment.groupId);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], rawExperiment.variants);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.groupId;
    }

    public final List<VariantOption> component3() {
        return this.variants;
    }

    public final RawExperiment copy(String id, String groupId, List<VariantOption> variants) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(variants, "variants");
        return new RawExperiment(id, groupId, variants);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RawExperiment)) {
            return false;
        }
        RawExperiment rawExperiment = (RawExperiment) obj;
        return Intrinsics.areEqual(this.id, rawExperiment.id) && Intrinsics.areEqual(this.groupId, rawExperiment.groupId) && Intrinsics.areEqual(this.variants, rawExperiment.variants);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<VariantOption> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.groupId.hashCode()) * 31) + this.variants.hashCode();
    }

    public final void setGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setVariants(List<VariantOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.variants = list;
    }

    public String toString() {
        return "RawExperiment(id=" + this.id + ", groupId=" + this.groupId + ", variants=" + this.variants + ")";
    }

    public RawExperiment(String id, String groupId, List<VariantOption> variants) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(variants, "variants");
        this.id = id;
        this.groupId = groupId;
        this.variants = variants;
    }
}
