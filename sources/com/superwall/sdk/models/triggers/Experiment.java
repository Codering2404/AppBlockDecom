package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.Experiment;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
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
public final class Experiment {
    public static final Companion Companion = new Companion(null);
    private final String groupId;
    private final String id;
    private final Variant variant;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Experiment presentById(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Experiment(id, "", new Variant("", Variant.VariantType.TREATMENT, id));
        }

        public final KSerializer<Experiment> serializer() {
            return Experiment$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Variant {
        private final String id;
        private final String paywallId;
        private final VariantType type;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, VariantType.Companion.serializer(), null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Variant> serializer() {
                return Experiment$Variant$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class VariantType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ VariantType[] $VALUES;
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
            public static final Companion Companion;

            @SerialName
            public static final VariantType TREATMENT = new VariantType("TREATMENT", 0);

            @SerialName
            public static final VariantType HOLDOUT = new VariantType("HOLDOUT", 1);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) VariantType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<VariantType> serializer() {
                    return get$cachedSerializer();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private static final /* synthetic */ VariantType[] $values() {
                return new VariantType[]{TREATMENT, HOLDOUT};
            }

            static {
                VariantType[] variantTypeArr$values = $values();
                $VALUES = variantTypeArr$values;
                $ENTRIES = EnumEntriesKt.a(variantTypeArr$values);
                Companion = new Companion(null);
                $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Experiment.Variant.VariantType._init_$_anonymous_();
                    }
                });
            }

            private VariantType(String str, int i3) {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return EnumsKt.a("com.superwall.sdk.models.triggers.Experiment.Variant.VariantType", values(), new String[]{"TREATMENT", "HOLDOUT"}, new Annotation[][]{null, null}, null);
            }

            public static EnumEntries<VariantType> getEntries() {
                return $ENTRIES;
            }

            public static VariantType valueOf(String str) {
                return (VariantType) Enum.valueOf(VariantType.class, str);
            }

            public static VariantType[] values() {
                return (VariantType[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Variant(int i3, String str, VariantType variantType, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, Experiment$Variant$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.type = variantType;
            this.paywallId = str2;
        }

        public static /* synthetic */ Variant copy$default(Variant variant, String str, VariantType variantType, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = variant.id;
            }
            if ((i3 & 2) != 0) {
                variantType = variant.type;
            }
            if ((i3 & 4) != 0) {
                str2 = variant.paywallId;
            }
            return variant.copy(str, variantType, str2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Variant variant, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, variant.id);
            compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], variant.type);
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, variant.paywallId);
        }

        public final String component1() {
            return this.id;
        }

        public final VariantType component2() {
            return this.type;
        }

        public final String component3() {
            return this.paywallId;
        }

        public final Variant copy(String id, VariantType type, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Variant(id, type, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variant)) {
                return false;
            }
            Variant variant = (Variant) obj;
            return Intrinsics.areEqual(this.id, variant.id) && this.type == variant.type && Intrinsics.areEqual(this.paywallId, variant.paywallId);
        }

        public final String getId() {
            return this.id;
        }

        public final String getPaywallId() {
            return this.paywallId;
        }

        public final VariantType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.paywallId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Variant(id=" + this.id + ", type=" + this.type + ", paywallId=" + this.paywallId + ")";
        }

        public Variant(String id, VariantType type, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.paywallId = str;
        }

        @SerialName
        public static /* synthetic */ void getId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaywallId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getType$annotations() {
        }
    }

    public /* synthetic */ Experiment(int i3, String str, String str2, Variant variant, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, Experiment$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.groupId = str2;
        this.variant = variant;
    }

    public static /* synthetic */ Experiment copy$default(Experiment experiment, String str, String str2, Variant variant, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = experiment.id;
        }
        if ((i3 & 2) != 0) {
            str2 = experiment.groupId;
        }
        if ((i3 & 4) != 0) {
            variant = experiment.variant;
        }
        return experiment.copy(str, str2, variant);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Experiment experiment, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, experiment.id);
        compositeEncoder.y(serialDescriptor, 1, experiment.groupId);
        compositeEncoder.C(serialDescriptor, 2, Experiment$Variant$$serializer.INSTANCE, experiment.variant);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.groupId;
    }

    public final Variant component3() {
        return this.variant;
    }

    public final Experiment copy(String id, String groupId, Variant variant) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(variant, "variant");
        return new Experiment(id, groupId, variant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) obj;
        return Intrinsics.areEqual(this.id, experiment.id) && Intrinsics.areEqual(this.groupId, experiment.groupId) && Intrinsics.areEqual(this.variant, experiment.variant);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getId() {
        return this.id;
    }

    public final Variant getVariant() {
        return this.variant;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.groupId.hashCode()) * 31) + this.variant.hashCode();
    }

    public String toString() {
        return "Experiment(id=" + this.id + ", groupId=" + this.groupId + ", variant=" + this.variant + ")";
    }

    public Experiment(String id, String groupId, Variant variant) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(variant, "variant");
        this.id = id;
        this.groupId = groupId;
        this.variant = variant;
    }

    @SerialName
    public static /* synthetic */ void getGroupId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVariant$annotations() {
    }
}
