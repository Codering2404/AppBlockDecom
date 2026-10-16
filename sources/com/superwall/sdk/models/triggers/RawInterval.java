package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.RawInterval;
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
import kotlinx.serialization.internal.IntSerializer;
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
public final class RawInterval {
    private final Integer minutes;
    private final IntervalType type;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {IntervalType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RawInterval> serializer() {
            return RawInterval$$serializer.INSTANCE;
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
    public static final class IntervalType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IntervalType[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
        public static final Companion Companion;

        @SerialName
        public static final IntervalType MINUTES = new IntervalType("MINUTES", 0);

        @SerialName
        public static final IntervalType INFINITY = new IntervalType("INFINITY", 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) IntervalType.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<IntervalType> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ IntervalType[] $values() {
            return new IntervalType[]{MINUTES, INFINITY};
        }

        static {
            IntervalType[] intervalTypeArr$values = $values();
            $VALUES = intervalTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(intervalTypeArr$values);
            Companion = new Companion(null);
            $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RawInterval.IntervalType._init_$_anonymous_();
                }
            });
        }

        private IntervalType(String str, int i3) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.a("com.superwall.sdk.models.triggers.RawInterval.IntervalType", values(), new String[]{"MINUTES", "INFINITY"}, new Annotation[][]{null, null}, null);
        }

        public static EnumEntries<IntervalType> getEntries() {
            return $ENTRIES;
        }

        public static IntervalType valueOf(String str) {
            return (IntervalType) Enum.valueOf(IntervalType.class, str);
        }

        public static IntervalType[] values() {
            return (IntervalType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ RawInterval(int i3, IntervalType intervalType, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, RawInterval$$serializer.INSTANCE.getDescriptor());
        }
        this.type = intervalType;
        if ((i3 & 2) == 0) {
            this.minutes = null;
        } else {
            this.minutes = num;
        }
    }

    public static /* synthetic */ RawInterval copy$default(RawInterval rawInterval, IntervalType intervalType, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            intervalType = rawInterval.type;
        }
        if ((i3 & 2) != 0) {
            num = rawInterval.minutes;
        }
        return rawInterval.copy(intervalType, num);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(RawInterval rawInterval, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], rawInterval.type);
        if (!compositeEncoder.z(serialDescriptor, 1) && rawInterval.minutes == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, rawInterval.minutes);
    }

    public final IntervalType component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.minutes;
    }

    public final RawInterval copy(IntervalType type, Integer num) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new RawInterval(type, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RawInterval)) {
            return false;
        }
        RawInterval rawInterval = (RawInterval) obj;
        return this.type == rawInterval.type && Intrinsics.areEqual(this.minutes, rawInterval.minutes);
    }

    public final Integer getMinutes() {
        return this.minutes;
    }

    public final IntervalType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Integer num = this.minutes;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "RawInterval(type=" + this.type + ", minutes=" + this.minutes + ")";
    }

    public RawInterval(IntervalType type, Integer num) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.minutes = num;
    }

    public /* synthetic */ RawInterval(IntervalType intervalType, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intervalType, (i3 & 2) != 0 ? null : num);
    }

    @SerialName
    public static /* synthetic */ void getType$annotations() {
    }
}
