package cz.mobilesoft.coreblock.view.timeselector;

import cz.mobilesoft.coreblock.base.ViewState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TimeSelectViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f133365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f133366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f133367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeType f133368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f133369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f133370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f133371h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TimeType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TimeType[] $VALUES;
        private final String affix;
        private final int maximumValue;
        private final long valueInMillis;
        public static final TimeType Seconds = new TimeType("Seconds", 0, "s", 59, 1000);
        public static final TimeType Minutes = new TimeType("Minutes", 1, "m", 59, 60000);
        public static final TimeType Hours = new TimeType("Hours", 2, "h", 23, 3600000);
        public static final TimeType Days = new TimeType("Days", 3, "d", 99, 86400000);

        private static final /* synthetic */ TimeType[] $values() {
            return new TimeType[]{Seconds, Minutes, Hours, Days};
        }

        static {
            TimeType[] timeTypeArr$values = $values();
            $VALUES = timeTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(timeTypeArr$values);
        }

        private TimeType(String str, int i3, String str2, int i4, long j3) {
            this.affix = str2;
            this.maximumValue = i4;
            this.valueInMillis = j3;
        }

        public static EnumEntries<TimeType> getEntries() {
            return $ENTRIES;
        }

        public static TimeType valueOf(String str) {
            return (TimeType) Enum.valueOf(TimeType.class, str);
        }

        public static TimeType[] values() {
            return (TimeType[]) $VALUES.clone();
        }

        public final String getAffix() {
            return this.affix;
        }

        public final int getMaximumValue() {
            return this.maximumValue;
        }

        public final long getValueInMillis() {
            return this.valueInMillis;
        }
    }

    public TimeSelectViewState(long j3, long j4, Map availableTimeTypes, TimeType selectedTimeType, boolean z2, long j5, String str) {
        Intrinsics.checkNotNullParameter(availableTimeTypes, "availableTimeTypes");
        Intrinsics.checkNotNullParameter(selectedTimeType, "selectedTimeType");
        this.f133365a = j3;
        this.f133366b = j4;
        this.f133367c = availableTimeTypes;
        this.f133368d = selectedTimeType;
        this.f133369f = z2;
        this.f133370g = j5;
        this.f133371h = str;
    }

    public static /* synthetic */ TimeSelectViewState b(TimeSelectViewState timeSelectViewState, long j3, long j4, Map map, TimeType timeType, boolean z2, long j5, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = timeSelectViewState.f133365a;
        }
        long j6 = j3;
        if ((i3 & 2) != 0) {
            j4 = timeSelectViewState.f133366b;
        }
        return timeSelectViewState.a(j6, j4, (i3 & 4) != 0 ? timeSelectViewState.f133367c : map, (i3 & 8) != 0 ? timeSelectViewState.f133368d : timeType, (i3 & 16) != 0 ? timeSelectViewState.f133369f : z2, (i3 & 32) != 0 ? timeSelectViewState.f133370g : j5, (i3 & 64) != 0 ? timeSelectViewState.f133371h : str);
    }

    public final TimeSelectViewState a(long j3, long j4, Map availableTimeTypes, TimeType selectedTimeType, boolean z2, long j5, String str) {
        Intrinsics.checkNotNullParameter(availableTimeTypes, "availableTimeTypes");
        Intrinsics.checkNotNullParameter(selectedTimeType, "selectedTimeType");
        return new TimeSelectViewState(j3, j4, availableTimeTypes, selectedTimeType, z2, j5, str);
    }

    public final Map c() {
        return this.f133367c;
    }

    public final long d() {
        return this.f133365a;
    }

    public final TimeType e() {
        return this.f133368d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeSelectViewState)) {
            return false;
        }
        TimeSelectViewState timeSelectViewState = (TimeSelectViewState) obj;
        return this.f133365a == timeSelectViewState.f133365a && this.f133366b == timeSelectViewState.f133366b && Intrinsics.areEqual(this.f133367c, timeSelectViewState.f133367c) && this.f133368d == timeSelectViewState.f133368d && this.f133369f == timeSelectViewState.f133369f && this.f133370g == timeSelectViewState.f133370g && Intrinsics.areEqual(this.f133371h, timeSelectViewState.f133371h);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.f133365a) * 31) + Long.hashCode(this.f133366b)) * 31) + this.f133367c.hashCode()) * 31) + this.f133368d.hashCode()) * 31) + Boolean.hashCode(this.f133369f)) * 31) + Long.hashCode(this.f133370g)) * 31;
        String str = this.f133371h;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TimeSelectViewState(initialTimeInMillis=" + this.f133365a + ", previousTimeInMillis=" + this.f133366b + ", availableTimeTypes=" + this.f133367c + ", selectedTimeType=" + this.f133368d + ", isExtendingTimer=" + this.f133369f + ", remainingExtendTime=" + this.f133370g + ", endsAtTime=" + this.f133371h + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TimeSelectViewState(long j3, long j4, Map map, TimeType timeType, boolean z2, long j5, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        j3 = (i3 & 1) != 0 ? 0L : j3;
        j4 = (i3 & 2) != 0 ? 0L : j4;
        Map mapMapOf = (i3 & 4) != 0 ? MapsKt.mapOf(TuplesKt.a(TimeType.Days, 0), TuplesKt.a(TimeType.Hours, 0), TuplesKt.a(TimeType.Minutes, 0)) : map;
        this(j3, j4, mapMapOf, (i3 & 8) != 0 ? (TimeType) CollectionsKt.last(mapMapOf.keySet()) : timeType, (i3 & 16) == 0 ? z2 : false, (i3 & 32) == 0 ? j5 : 0L, (i3 & 64) != 0 ? "" : str);
    }
}
