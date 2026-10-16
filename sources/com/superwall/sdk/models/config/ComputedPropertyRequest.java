package com.superwall.sdk.models.config;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
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
public final class ComputedPropertyRequest {
    public static final Companion Companion = new Companion(null);
    private final String eventName;
    private final ComputedPropertyRequestType type;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ComputedPropertyRequest> serializer() {
            return ComputedPropertyRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = ComputedPropertyRequestTypeSerializer.class)
    public static final class ComputedPropertyRequestType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ComputedPropertyRequestType[] $VALUES;
        public static final Companion Companion;
        private final String rawValue;

        @SerialName
        public static final ComputedPropertyRequestType MINUTES_SINCE = new ComputedPropertyRequestType("MINUTES_SINCE", 0, "MINUTES_SINCE");

        @SerialName
        public static final ComputedPropertyRequestType HOURS_SINCE = new ComputedPropertyRequestType("HOURS_SINCE", 1, "HOURS_SINCE");

        @SerialName
        public static final ComputedPropertyRequestType DAYS_SINCE = new ComputedPropertyRequestType("DAYS_SINCE", 2, "DAYS_SINCE");

        @SerialName
        public static final ComputedPropertyRequestType MONTHS_SINCE = new ComputedPropertyRequestType("MONTHS_SINCE", 3, "MONTHS_SINCE");

        @SerialName
        public static final ComputedPropertyRequestType YEARS_SINCE = new ComputedPropertyRequestType("YEARS_SINCE", 4, "YEARS_SINCE");

        @SerialName
        public static final ComputedPropertyRequestType PLACEMENTS_IN_DAY = new ComputedPropertyRequestType("PLACEMENTS_IN_DAY", 5, "PLACEMENTS_IN_DAY");

        @SerialName
        public static final ComputedPropertyRequestType PLACEMENTS_IN_HOUR = new ComputedPropertyRequestType("PLACEMENTS_IN_HOUR", 6, "PLACEMENTS_IN_HOUR");

        @SerialName
        public static final ComputedPropertyRequestType PLACEMENTS_IN_WEEK = new ComputedPropertyRequestType("PLACEMENTS_IN_WEEK", 7, "PLACEMENTS_IN_WEEK");

        @SerialName
        public static final ComputedPropertyRequestType PLACEMENTS_IN_MONTH = new ComputedPropertyRequestType("PLACEMENTS_IN_MONTH", 8, "PLACEMENTS_IN_MONTH");

        @SerialName
        public static final ComputedPropertyRequestType PLACEMENTS_SINCE_INSTALL = new ComputedPropertyRequestType("PLACEMENTS_SINCE_INSTALL", 9, "PLACEMENTS_SINCE_INSTALL");

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ComputedPropertyRequestType> serializer() {
                return ComputedPropertyRequestTypeSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ComputedPropertyRequestType.values().length];
                try {
                    iArr[ComputedPropertyRequestType.MINUTES_SINCE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ComputedPropertyRequestType.HOURS_SINCE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ComputedPropertyRequestType.DAYS_SINCE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ComputedPropertyRequestType.MONTHS_SINCE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ComputedPropertyRequestType.YEARS_SINCE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ComputedPropertyRequestType.PLACEMENTS_IN_DAY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ComputedPropertyRequestType.PLACEMENTS_IN_HOUR.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ComputedPropertyRequestType.PLACEMENTS_IN_WEEK.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ComputedPropertyRequestType.PLACEMENTS_IN_MONTH.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ComputedPropertyRequestType.PLACEMENTS_SINCE_INSTALL.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ ComputedPropertyRequestType[] $values() {
            return new ComputedPropertyRequestType[]{MINUTES_SINCE, HOURS_SINCE, DAYS_SINCE, MONTHS_SINCE, YEARS_SINCE, PLACEMENTS_IN_DAY, PLACEMENTS_IN_HOUR, PLACEMENTS_IN_WEEK, PLACEMENTS_IN_MONTH, PLACEMENTS_SINCE_INSTALL};
        }

        static {
            ComputedPropertyRequestType[] computedPropertyRequestTypeArr$values = $values();
            $VALUES = computedPropertyRequestTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(computedPropertyRequestTypeArr$values);
            Companion = new Companion(null);
        }

        private ComputedPropertyRequestType(String str, int i3, String str2) {
            this.rawValue = str2;
        }

        public static EnumEntries<ComputedPropertyRequestType> getEntries() {
            return $ENTRIES;
        }

        public static ComputedPropertyRequestType valueOf(String str) {
            return (ComputedPropertyRequestType) Enum.valueOf(ComputedPropertyRequestType.class, str);
        }

        public static ComputedPropertyRequestType[] values() {
            return (ComputedPropertyRequestType[]) $VALUES.clone();
        }

        public final Integer dateComponent(Map<Integer, Integer> components) {
            Intrinsics.checkNotNullParameter(components, "components");
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return components.get(12);
                case 2:
                    return components.get(11);
                case 3:
                    return components.get(5);
                case 4:
                    return components.get(2);
                case 5:
                    return components.get(1);
                case 6:
                    return components.get(5);
                case 7:
                    return components.get(11);
                case 8:
                    return components.get(3);
                case 9:
                    return components.get(2);
                case 10:
                    return components.get(1);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final int getCalendarComponent() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 12;
                case 2:
                    return 11;
                case 3:
                    return 5;
                case 4:
                    return 2;
                case 5:
                    return 1;
                case 6:
                    return 5;
                case 7:
                    return 11;
                case 8:
                    return 3;
                case 9:
                    return 2;
                case 10:
                    return 1;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final String getPrefix() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "minutesSince_";
                case 2:
                    return "hoursSince_";
                case 3:
                    return "daysSince_";
                case 4:
                    return "monthsSince_";
                case 5:
                    return "yearsSince_";
                case 6:
                    return "placementsInDay";
                case 7:
                    return "placementsInHour";
                case 8:
                    return "placementsInWeek";
                case 9:
                    return "placementsInMonth";
                case 10:
                    return "placementsSinceInstall";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ComputedPropertyRequestTypeSerializer implements KSerializer<ComputedPropertyRequestType> {
        public static final ComputedPropertyRequestTypeSerializer INSTANCE = new ComputedPropertyRequestTypeSerializer();
        private static final SerialDescriptor descriptor;

        static {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.config.ComputedPropertyRequest.ComputedPropertyRequestType", null, 1);
            pluginGeneratedSerialDescriptor.p("rawValue", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        private ComputedPropertyRequestTypeSerializer() {
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public ComputedPropertyRequestType deserialize(Decoder decoder) {
            ComputedPropertyRequestType computedPropertyRequestType;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            String strZ = decoder.z();
            ComputedPropertyRequestType[] computedPropertyRequestTypeArrValues = ComputedPropertyRequestType.values();
            int length = computedPropertyRequestTypeArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    computedPropertyRequestType = null;
                    break;
                }
                computedPropertyRequestType = computedPropertyRequestTypeArrValues[i3];
                if (Intrinsics.areEqual(computedPropertyRequestType.getRawValue(), strZ)) {
                    break;
                }
                i3++;
            }
            if (computedPropertyRequestType != null) {
                return computedPropertyRequestType;
            }
            throw new IllegalArgumentException("Unsupported computed property type.");
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder, ComputedPropertyRequestType value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.G(value.getRawValue());
        }
    }

    public /* synthetic */ ComputedPropertyRequest(int i3, ComputedPropertyRequestType computedPropertyRequestType, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i3 & 3)) {
            PluginExceptionsKt.b(i3, 3, ComputedPropertyRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.type = computedPropertyRequestType;
        this.eventName = str;
    }

    public static /* synthetic */ ComputedPropertyRequest copy$default(ComputedPropertyRequest computedPropertyRequest, ComputedPropertyRequestType computedPropertyRequestType, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            computedPropertyRequestType = computedPropertyRequest.type;
        }
        if ((i3 & 2) != 0) {
            str = computedPropertyRequest.eventName;
        }
        return computedPropertyRequest.copy(computedPropertyRequestType, str);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(ComputedPropertyRequest computedPropertyRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, ComputedPropertyRequestTypeSerializer.INSTANCE, computedPropertyRequest.type);
        compositeEncoder.y(serialDescriptor, 1, computedPropertyRequest.eventName);
    }

    public final ComputedPropertyRequestType component1() {
        return this.type;
    }

    public final String component2() {
        return this.eventName;
    }

    public final ComputedPropertyRequest copy(ComputedPropertyRequestType type, String eventName) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new ComputedPropertyRequest(type, eventName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComputedPropertyRequest)) {
            return false;
        }
        ComputedPropertyRequest computedPropertyRequest = (ComputedPropertyRequest) obj;
        return this.type == computedPropertyRequest.type && Intrinsics.areEqual(this.eventName, computedPropertyRequest.eventName);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final ComputedPropertyRequestType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.eventName.hashCode();
    }

    public String toString() {
        return "ComputedPropertyRequest(type=" + this.type + ", eventName=" + this.eventName + ")";
    }

    public ComputedPropertyRequest(ComputedPropertyRequestType type, String eventName) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.type = type;
        this.eventName = eventName;
    }
}
