package cz.mobilesoft.coreblock.view.timepicker;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

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
public final class TimePickerConfig implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f133036h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f133037i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimePickerType.Minutes f133038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimePickerType.Hours f133039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimePickerType.Days f133040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f133041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimePickerType.Custom f133042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f133043g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimePickerConfig a() {
            return new TimePickerConfig(new TimePickerType.Minutes(CollectionsKt.listOf((Object[]) new Long[]{2L, 3L, 5L, 10L, 15L, 30L})), null, null, false, null, false, 62, null);
        }

        public final TimePickerConfig b() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new TimePickerConfig(new TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerType.Hours(0L, 0L, 3, defaultConstructorMarker), null, false, null, false, 60, defaultConstructorMarker);
        }

        public final TimePickerConfig c() {
            return new TimePickerConfig(new TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerType.Hours(0L, 0L, 3, null), null, true, null, false, 52, null);
        }

        public final TimePickerConfig d() {
            return new TimePickerConfig(new TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerType.Hours(1L, 12L), null, true, new TimePickerType.Custom(CollectionsKt.listOf((Object[]) new Long[]{0L, 1L}), 0), true, 4, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class TimePickerType implements Serializable {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Days extends TimePickerType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f133046a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Days(List values) {
                super(null);
                Intrinsics.checkNotNullParameter(values, "values");
                this.f133046a = values;
            }

            public List a() {
                return this.f133046a;
            }

            public Days(long j3, long j4) {
                this(CollectionsKt.toList(new LongRange(j3, j4)));
            }

            public /* synthetic */ Days(long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 9L : j4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Hours extends TimePickerType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f133047a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Hours(List values) {
                super(null);
                Intrinsics.checkNotNullParameter(values, "values");
                this.f133047a = values;
            }

            public List a() {
                return this.f133047a;
            }

            public Hours(long j3, long j4) {
                this(CollectionsKt.toList(new LongRange(j3, j4)));
            }

            public /* synthetic */ Hours(long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 23L : j4);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Minutes extends TimePickerType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f133048a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Minutes(List values) {
                super(null);
                Intrinsics.checkNotNullParameter(values, "values");
                this.f133048a = values;
            }

            public List a() {
                return this.f133048a;
            }

            public Minutes(long j3, long j4) {
                this(CollectionsKt.toList(new LongRange(j3, j4)));
            }

            public /* synthetic */ Minutes(long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 59L : j4);
            }

            public Minutes(long j3, long j4, long j5) {
                this(CollectionsKt.toList(RangesKt.A(new LongRange(j3, j4), j5)));
            }
        }

        public /* synthetic */ TimePickerType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TimePickerType() {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Custom extends TimePickerType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f133044a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f133045b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(List values, int i3) {
                super(null);
                Intrinsics.checkNotNullParameter(values, "values");
                this.f133044a = values;
                this.f133045b = i3;
            }

            public final int a() {
                return this.f133045b;
            }

            public List b() {
                return this.f133044a;
            }

            public Custom(long j3, long j4, int i3) {
                this(CollectionsKt.toList(new LongRange(j3, j4)), i3);
            }
        }
    }

    public TimePickerConfig(TimePickerType.Minutes minutes, TimePickerType.Hours hours, TimePickerType.Days days, boolean z2, TimePickerType.Custom custom, boolean z3) {
        this.f133038a = minutes;
        this.f133039b = hours;
        this.f133040c = days;
        this.f133041d = z2;
        this.f133042f = custom;
        this.f133043g = z3;
    }

    public final TimePickerType.Custom a() {
        return this.f133042f;
    }

    public final List b() {
        TimePickerType.Custom custom = this.f133042f;
        if (custom != null) {
            return custom.b();
        }
        return null;
    }

    public final TimePickerType.Days c() {
        return this.f133040c;
    }

    public final List d() {
        TimePickerType.Days days = this.f133040c;
        if (days != null) {
            return days.a();
        }
        return null;
    }

    public final TimePickerType.Hours e() {
        return this.f133039b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimePickerConfig)) {
            return false;
        }
        TimePickerConfig timePickerConfig = (TimePickerConfig) obj;
        return Intrinsics.areEqual(this.f133038a, timePickerConfig.f133038a) && Intrinsics.areEqual(this.f133039b, timePickerConfig.f133039b) && Intrinsics.areEqual(this.f133040c, timePickerConfig.f133040c) && this.f133041d == timePickerConfig.f133041d && Intrinsics.areEqual(this.f133042f, timePickerConfig.f133042f) && this.f133043g == timePickerConfig.f133043g;
    }

    public final List f() {
        TimePickerType.Hours hours = this.f133039b;
        if (hours != null) {
            return hours.a();
        }
        return null;
    }

    public final TimePickerType.Minutes g() {
        return this.f133038a;
    }

    public final List h() {
        TimePickerType.Minutes minutes = this.f133038a;
        if (minutes != null) {
            return minutes.a();
        }
        return null;
    }

    public int hashCode() {
        TimePickerType.Minutes minutes = this.f133038a;
        int iHashCode = (minutes == null ? 0 : minutes.hashCode()) * 31;
        TimePickerType.Hours hours = this.f133039b;
        int iHashCode2 = (iHashCode + (hours == null ? 0 : hours.hashCode())) * 31;
        TimePickerType.Days days = this.f133040c;
        int iHashCode3 = (((iHashCode2 + (days == null ? 0 : days.hashCode())) * 31) + Boolean.hashCode(this.f133041d)) * 31;
        TimePickerType.Custom custom = this.f133042f;
        return ((iHashCode3 + (custom != null ? custom.hashCode() : 0)) * 31) + Boolean.hashCode(this.f133043g);
    }

    public final boolean i() {
        return this.f133041d;
    }

    public final boolean j() {
        return this.f133043g;
    }

    public String toString() {
        return "TimePickerConfig(minutes=" + this.f133038a + ", hours=" + this.f133039b + ", days=" + this.f133040c + ", pickTimeOfDay=" + this.f133041d + ", custom=" + this.f133042f + ", use12HourFormat=" + this.f133043g + ")";
    }

    public /* synthetic */ TimePickerConfig(TimePickerType.Minutes minutes, TimePickerType.Hours hours, TimePickerType.Days days, boolean z2, TimePickerType.Custom custom, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : minutes, (i3 & 2) != 0 ? null : hours, (i3 & 4) != 0 ? null : days, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? null : custom, (i3 & 32) != 0 ? false : z3);
    }
}
