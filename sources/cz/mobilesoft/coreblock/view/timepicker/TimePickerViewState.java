package cz.mobilesoft.coreblock.view.timepicker;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentList;

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
@Deprecated
@Metadata
public final class TimePickerViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PersistentList f133097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PersistentList f133098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentList f133099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f133100d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PersistentList f133101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f133102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f133103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f133104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f133105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f133106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f133107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f133108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f133109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f133110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f133111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Long f133112q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Long f133113r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f133114s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class TimePickerColumnType {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Days extends TimePickerColumnType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Days f133116a = new Days();

            private Days() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Days);
            }

            public int hashCode() {
                return 2137218920;
            }

            public String toString() {
                return "Days";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Hours extends TimePickerColumnType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Hours f133117a = new Hours();

            private Hours() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Hours);
            }

            public int hashCode() {
                return 1833384478;
            }

            public String toString() {
                return "Hours";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Minutes extends TimePickerColumnType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Minutes f133118a = new Minutes();

            private Minutes() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Minutes);
            }

            public int hashCode() {
                return 910297134;
            }

            public String toString() {
                return "Minutes";
            }
        }

        public /* synthetic */ TimePickerColumnType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Custom extends TimePickerColumnType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Integer f133115a;

            public Custom(Integer num) {
                super(null);
                this.f133115a = num;
            }

            public final Integer a() {
                return this.f133115a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Custom) && Intrinsics.areEqual(this.f133115a, ((Custom) obj).f133115a);
            }

            public int hashCode() {
                Integer num = this.f133115a;
                if (num == null) {
                    return 0;
                }
                return num.hashCode();
            }

            public String toString() {
                return "Custom(resId=" + this.f133115a + ")";
            }

            public /* synthetic */ Custom(Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : num);
            }
        }

        private TimePickerColumnType() {
        }
    }

    public TimePickerViewState(PersistentList persistentList, PersistentList persistentList2, PersistentList persistentList3, boolean z2, PersistentList persistentList4, int i3, int i4, int i5, int i6, boolean z3, long j3, long j4, long j5, long j6, String endsAtTimeString, Long l3, Long l4, boolean z4) {
        Intrinsics.checkNotNullParameter(endsAtTimeString, "endsAtTimeString");
        this.f133097a = persistentList;
        this.f133098b = persistentList2;
        this.f133099c = persistentList3;
        this.f133100d = z2;
        this.f133101f = persistentList4;
        this.f133102g = i3;
        this.f133103h = i4;
        this.f133104i = i5;
        this.f133105j = i6;
        this.f133106k = z3;
        this.f133107l = j3;
        this.f133108m = j4;
        this.f133109n = j5;
        this.f133110o = j6;
        this.f133111p = endsAtTimeString;
        this.f133112q = l3;
        this.f133113r = l4;
        this.f133114s = z4;
    }

    public static /* synthetic */ TimePickerViewState b(TimePickerViewState timePickerViewState, PersistentList persistentList, PersistentList persistentList2, PersistentList persistentList3, boolean z2, PersistentList persistentList4, int i3, int i4, int i5, int i6, boolean z3, long j3, long j4, long j5, long j6, String str, Long l3, Long l4, boolean z4, int i7, Object obj) {
        boolean z5;
        Long l5;
        PersistentList persistentList5 = (i7 & 1) != 0 ? timePickerViewState.f133097a : persistentList;
        PersistentList persistentList6 = (i7 & 2) != 0 ? timePickerViewState.f133098b : persistentList2;
        PersistentList persistentList7 = (i7 & 4) != 0 ? timePickerViewState.f133099c : persistentList3;
        boolean z6 = (i7 & 8) != 0 ? timePickerViewState.f133100d : z2;
        PersistentList persistentList8 = (i7 & 16) != 0 ? timePickerViewState.f133101f : persistentList4;
        int i8 = (i7 & 32) != 0 ? timePickerViewState.f133102g : i3;
        int i9 = (i7 & 64) != 0 ? timePickerViewState.f133103h : i4;
        int i10 = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? timePickerViewState.f133104i : i5;
        int i11 = (i7 & Function.MAX_NARGS) != 0 ? timePickerViewState.f133105j : i6;
        boolean z7 = (i7 & 512) != 0 ? timePickerViewState.f133106k : z3;
        long j7 = (i7 & 1024) != 0 ? timePickerViewState.f133107l : j3;
        long j8 = (i7 & 2048) != 0 ? timePickerViewState.f133108m : j4;
        PersistentList persistentList9 = persistentList5;
        PersistentList persistentList10 = persistentList6;
        long j9 = (i7 & 4096) != 0 ? timePickerViewState.f133109n : j5;
        long j10 = (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? timePickerViewState.f133110o : j6;
        String str2 = (i7 & 16384) != 0 ? timePickerViewState.f133111p : str;
        Long l6 = (32768 & i7) != 0 ? timePickerViewState.f133112q : l3;
        Long l7 = (i7 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? timePickerViewState.f133113r : l4;
        if ((i7 & 131072) != 0) {
            l5 = l7;
            z5 = timePickerViewState.f133114s;
        } else {
            z5 = z4;
            l5 = l7;
        }
        return timePickerViewState.a(persistentList9, persistentList10, persistentList7, z6, persistentList8, i8, i9, i10, i11, z7, j7, j8, j9, j10, str2, l6, l5, z5);
    }

    public final TimePickerViewState a(PersistentList persistentList, PersistentList persistentList2, PersistentList persistentList3, boolean z2, PersistentList persistentList4, int i3, int i4, int i5, int i6, boolean z3, long j3, long j4, long j5, long j6, String endsAtTimeString, Long l3, Long l4, boolean z4) {
        Intrinsics.checkNotNullParameter(endsAtTimeString, "endsAtTimeString");
        return new TimePickerViewState(persistentList, persistentList2, persistentList3, z2, persistentList4, i3, i4, i5, i6, z3, j3, j4, j5, j6, endsAtTimeString, l3, l4, z4);
    }

    public final PersistentList c() {
        return this.f133101f;
    }

    public final PersistentList d() {
        return this.f133097a;
    }

    public final String e() {
        return this.f133111p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimePickerViewState)) {
            return false;
        }
        TimePickerViewState timePickerViewState = (TimePickerViewState) obj;
        return Intrinsics.areEqual(this.f133097a, timePickerViewState.f133097a) && Intrinsics.areEqual(this.f133098b, timePickerViewState.f133098b) && Intrinsics.areEqual(this.f133099c, timePickerViewState.f133099c) && this.f133100d == timePickerViewState.f133100d && Intrinsics.areEqual(this.f133101f, timePickerViewState.f133101f) && this.f133102g == timePickerViewState.f133102g && this.f133103h == timePickerViewState.f133103h && this.f133104i == timePickerViewState.f133104i && this.f133105j == timePickerViewState.f133105j && this.f133106k == timePickerViewState.f133106k && this.f133107l == timePickerViewState.f133107l && this.f133108m == timePickerViewState.f133108m && this.f133109n == timePickerViewState.f133109n && this.f133110o == timePickerViewState.f133110o && Intrinsics.areEqual(this.f133111p, timePickerViewState.f133111p) && Intrinsics.areEqual(this.f133112q, timePickerViewState.f133112q) && Intrinsics.areEqual(this.f133113r, timePickerViewState.f133113r) && this.f133114s == timePickerViewState.f133114s;
    }

    public final Long f() {
        return this.f133112q;
    }

    public final PersistentList g() {
        return this.f133098b;
    }

    public final long h() {
        return this.f133107l;
    }

    public int hashCode() {
        PersistentList persistentList = this.f133097a;
        int iHashCode = (persistentList == null ? 0 : persistentList.hashCode()) * 31;
        PersistentList persistentList2 = this.f133098b;
        int iHashCode2 = (iHashCode + (persistentList2 == null ? 0 : persistentList2.hashCode())) * 31;
        PersistentList persistentList3 = this.f133099c;
        int iHashCode3 = (((iHashCode2 + (persistentList3 == null ? 0 : persistentList3.hashCode())) * 31) + Boolean.hashCode(this.f133100d)) * 31;
        PersistentList persistentList4 = this.f133101f;
        int iHashCode4 = (((((((((((((((((((((iHashCode3 + (persistentList4 == null ? 0 : persistentList4.hashCode())) * 31) + Integer.hashCode(this.f133102g)) * 31) + Integer.hashCode(this.f133103h)) * 31) + Integer.hashCode(this.f133104i)) * 31) + Integer.hashCode(this.f133105j)) * 31) + Boolean.hashCode(this.f133106k)) * 31) + Long.hashCode(this.f133107l)) * 31) + Long.hashCode(this.f133108m)) * 31) + Long.hashCode(this.f133109n)) * 31) + Long.hashCode(this.f133110o)) * 31) + this.f133111p.hashCode()) * 31;
        Long l3 = this.f133112q;
        int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f133113r;
        return ((iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31) + Boolean.hashCode(this.f133114s);
    }

    public final PersistentList i() {
        return this.f133099c;
    }

    public final long j() {
        return this.f133110o;
    }

    public final int k() {
        return this.f133105j;
    }

    public final int l() {
        return this.f133102g;
    }

    public final int m() {
        return this.f133103h;
    }

    public final int n() {
        return this.f133104i;
    }

    public final long o() {
        return this.f133108m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long p() {
        PersistentList persistentList = this.f133101f;
        return persistentList != null ? ((Number) persistentList.get(this.f133105j)).longValue() : this.f133108m;
    }

    public final boolean q() {
        return this.f133100d;
    }

    public final boolean r() {
        return this.f133106k;
    }

    public final boolean s() {
        return this.f133112q != null;
    }

    public final boolean t() {
        return this.f133114s;
    }

    public String toString() {
        return "TimePickerViewState(days=" + this.f133097a + ", hours=" + this.f133098b + ", minutes=" + this.f133099c + ", selectingTimeOfDay=" + this.f133100d + ", custom=" + this.f133101f + ", selectedDayIndex=" + this.f133102g + ", selectedHourIndex=" + this.f133103h + ", selectedMinuteIndex=" + this.f133104i + ", selectedCustomIndex=" + this.f133105j + ", withEndsAtText=" + this.f133106k + ", initialTimeInMillis=" + this.f133107l + ", selectedTimeInMillis=" + this.f133108m + ", selectedTimeOfDayInMillis=" + this.f133109n + ", remainingExtendTime=" + this.f133110o + ", endsAtTimeString=" + this.f133111p + ", extendedTimeInMillis=" + this.f133112q + ", remainingUsageLimit=" + this.f133113r + ", isSmActive=" + this.f133114s + ")";
    }

    public final boolean u() {
        if (this.f133108m > 0 || this.f133100d) {
            return true;
        }
        return this.f133101f != null && this.f133105j > 0;
    }

    public /* synthetic */ TimePickerViewState(PersistentList persistentList, PersistentList persistentList2, PersistentList persistentList3, boolean z2, PersistentList persistentList4, int i3, int i4, int i5, int i6, boolean z3, long j3, long j4, long j5, long j6, String str, Long l3, Long l4, boolean z4, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? null : persistentList, (i7 & 2) != 0 ? null : persistentList2, (i7 & 4) != 0 ? null : persistentList3, (i7 & 8) != 0 ? false : z2, (i7 & 16) != 0 ? null : persistentList4, (i7 & 32) != 0 ? 0 : i3, (i7 & 64) != 0 ? 0 : i4, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i5, (i7 & Function.MAX_NARGS) != 0 ? 0 : i6, (i7 & 512) != 0 ? true : z3, (i7 & 1024) != 0 ? 0L : j3, (i7 & 2048) != 0 ? 0L : j4, (i7 & 4096) != 0 ? 0L : j5, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? j6 : 0L, (i7 & 16384) != 0 ? "" : str, (i7 & 32768) != 0 ? null : l3, (i7 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 0 ? l4 : null, (i7 & 131072) != 0 ? false : z4);
    }
}
