package com.superwall.sdk.models.triggers;

import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.superwall.sdk.models.triggers.RawInterval;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class TriggerRuleOccurrence {
    public static final Companion Companion = new Companion(null);
    private final Interval interval;
    private final String key;
    private int maxCount;
    private final RawInterval rawInterval;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TriggerRuleOccurrence> serializer() {
            return TriggerRuleOccurrence$$serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final TriggerRuleOccurrence stub() {
            return new TriggerRuleOccurrence("abc", 10, new RawInterval(RawInterval.IntervalType.INFINITY, (Integer) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Interval {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Infinity extends Interval {
            public static final Infinity INSTANCE = new Infinity();

            private Infinity() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Minutes extends Interval {
            private final int minutes;

            public Minutes(int i3) {
                super(null);
                this.minutes = i3;
            }

            public static /* synthetic */ Minutes copy$default(Minutes minutes, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i3 = minutes.minutes;
                }
                return minutes.copy(i3);
            }

            public final int component1() {
                return this.minutes;
            }

            public final Minutes copy(int i3) {
                return new Minutes(i3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Minutes) && this.minutes == ((Minutes) obj).minutes;
            }

            public final int getMinutes() {
                return this.minutes;
            }

            public int hashCode() {
                return Integer.hashCode(this.minutes);
            }

            public String toString() {
                return "Minutes(minutes=" + this.minutes + ")";
            }
        }

        public /* synthetic */ Interval(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Interval() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RawInterval.IntervalType.values().length];
            try {
                iArr[RawInterval.IntervalType.MINUTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RawInterval.IntervalType.INFINITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TriggerRuleOccurrence(int i3, String str, int i4, RawInterval rawInterval, SerializationConstructorMarker serializationConstructorMarker) {
        Interval minutes;
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, TriggerRuleOccurrence$$serializer.INSTANCE.getDescriptor());
        }
        this.key = str;
        this.maxCount = i4;
        this.rawInterval = rawInterval;
        int i5 = WhenMappings.$EnumSwitchMapping$0[rawInterval.getType().ordinal()];
        if (i5 == 1) {
            Integer minutes2 = rawInterval.getMinutes();
            minutes = new Interval.Minutes(minutes2 != null ? minutes2.intValue() : 0);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            minutes = Interval.Infinity.INSTANCE;
        }
        this.interval = minutes;
    }

    public static /* synthetic */ TriggerRuleOccurrence copy$default(TriggerRuleOccurrence triggerRuleOccurrence, String str, int i3, RawInterval rawInterval, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = triggerRuleOccurrence.key;
        }
        if ((i4 & 2) != 0) {
            i3 = triggerRuleOccurrence.maxCount;
        }
        if ((i4 & 4) != 0) {
            rawInterval = triggerRuleOccurrence.rawInterval;
        }
        return triggerRuleOccurrence.copy(str, i3, rawInterval);
    }

    @Transient
    public static /* synthetic */ void getInterval$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getMaxCount$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getRawInterval$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(TriggerRuleOccurrence triggerRuleOccurrence, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, triggerRuleOccurrence.key);
        compositeEncoder.w(serialDescriptor, 1, triggerRuleOccurrence.maxCount);
        compositeEncoder.C(serialDescriptor, 2, RawInterval$$serializer.INSTANCE, triggerRuleOccurrence.rawInterval);
    }

    public final String component1() {
        return this.key;
    }

    public final int component2() {
        return this.maxCount;
    }

    public final RawInterval component3() {
        return this.rawInterval;
    }

    public final TriggerRuleOccurrence copy(String key, int i3, RawInterval rawInterval) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rawInterval, "rawInterval");
        return new TriggerRuleOccurrence(key, i3, rawInterval);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TriggerRuleOccurrence)) {
            return false;
        }
        TriggerRuleOccurrence triggerRuleOccurrence = (TriggerRuleOccurrence) obj;
        return Intrinsics.areEqual(this.key, triggerRuleOccurrence.key) && this.maxCount == triggerRuleOccurrence.maxCount && Intrinsics.areEqual(this.rawInterval, triggerRuleOccurrence.rawInterval);
    }

    public final Interval getInterval() {
        return this.interval;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final RawInterval getRawInterval() {
        return this.rawInterval;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + Integer.hashCode(this.maxCount)) * 31) + this.rawInterval.hashCode();
    }

    public final void setMaxCount(int i3) {
        this.maxCount = i3;
    }

    public String toString() {
        return "TriggerRuleOccurrence(key=" + this.key + ", maxCount=" + this.maxCount + ", rawInterval=" + this.rawInterval + ")";
    }

    public TriggerRuleOccurrence(String str, int i3, RawInterval rawInterval) {
        Interval minutes;
        Intrinsics.checkNotNullParameter(str, wgbAZXYjrv.pWzRdK);
        Intrinsics.checkNotNullParameter(rawInterval, "rawInterval");
        this.key = str;
        this.maxCount = i3;
        this.rawInterval = rawInterval;
        int i4 = WhenMappings.$EnumSwitchMapping$0[rawInterval.getType().ordinal()];
        if (i4 == 1) {
            Integer minutes2 = rawInterval.getMinutes();
            minutes = new Interval.Minutes(minutes2 != null ? minutes2.intValue() : 0);
        } else if (i4 == 2) {
            minutes = Interval.Infinity.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.interval = minutes;
    }
}
