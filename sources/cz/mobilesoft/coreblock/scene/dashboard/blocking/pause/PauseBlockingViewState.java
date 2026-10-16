package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PauseBlockingViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumState f100181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f100182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateTimePicker f100183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f100184d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StreakPauseWarning f100185f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PauseBlockingType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f100190a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Custom extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f100191b;

            public Custom(long j3) {
                super(4, null);
                this.f100191b = j3;
            }

            public final long a() {
                return this.f100191b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Custom) && this.f100191b == ((Custom) obj).f100191b;
            }

            public int hashCode() {
                return Long.hashCode(this.f100191b);
            }

            public String toString() {
                return "Custom(timer=" + this.f100191b + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FifteenMinutes extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final FifteenMinutes f100192b = new FifteenMinutes();

            private FifteenMinutes() {
                super(1, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof FifteenMinutes);
            }

            public int hashCode() {
                return -596107890;
            }

            public String toString() {
                return "FifteenMinutes";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ForToday extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final ForToday f100193b = new ForToday();

            private ForToday() {
                super(3, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof ForToday);
            }

            public int hashCode() {
                return -706866748;
            }

            public String toString() {
                return "ForToday";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Indefinitely extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final Indefinitely f100194b = new Indefinitely();

            private Indefinitely() {
                super(5, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Indefinitely);
            }

            public int hashCode() {
                return 654793902;
            }

            public String toString() {
                return "Indefinitely";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OneHour extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final OneHour f100195b = new OneHour();

            private OneHour() {
                super(2, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof OneHour);
            }

            public int hashCode() {
                return 1550561822;
            }

            public String toString() {
                return "OneHour";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class UntilDateAndTime extends PauseBlockingType {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f100196b;

            public UntilDateAndTime(long j3) {
                super(6, null);
                this.f100196b = j3;
            }

            public final long a() {
                return this.f100196b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UntilDateAndTime) && this.f100196b == ((UntilDateAndTime) obj).f100196b;
            }

            public int hashCode() {
                return Long.hashCode(this.f100196b);
            }

            public String toString() {
                return "UntilDateAndTime(dateAndTimeInMillis=" + this.f100196b + ")";
            }
        }

        public /* synthetic */ PauseBlockingType(int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3);
        }

        private PauseBlockingType(int i3) {
            this.f100190a = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StreakPauseWarning {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StreakEvaluator.PauseRisk f100197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PauseBlockingType f100198b;

        public StreakPauseWarning(StreakEvaluator.PauseRisk risk, PauseBlockingType type) {
            Intrinsics.checkNotNullParameter(risk, "risk");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f100197a = risk;
            this.f100198b = type;
        }

        public final StreakEvaluator.PauseRisk a() {
            return this.f100197a;
        }

        public final PauseBlockingType b() {
            return this.f100198b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StreakPauseWarning)) {
                return false;
            }
            StreakPauseWarning streakPauseWarning = (StreakPauseWarning) obj;
            return Intrinsics.areEqual(this.f100197a, streakPauseWarning.f100197a) && Intrinsics.areEqual(this.f100198b, streakPauseWarning.f100198b);
        }

        public int hashCode() {
            return (this.f100197a.hashCode() * 31) + this.f100198b.hashCode();
        }

        public String toString() {
            return "StreakPauseWarning(risk=" + this.f100197a + ", type=" + this.f100198b + ")";
        }
    }

    public PauseBlockingViewState(PremiumState premiumState, List customPresetsHistory, DateTimePicker dateTimePicker, List presetsHistory, StreakPauseWarning streakPauseWarning) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(customPresetsHistory, "customPresetsHistory");
        Intrinsics.checkNotNullParameter(dateTimePicker, "dateTimePicker");
        Intrinsics.checkNotNullParameter(presetsHistory, "presetsHistory");
        this.f100181a = premiumState;
        this.f100182b = customPresetsHistory;
        this.f100183c = dateTimePicker;
        this.f100184d = presetsHistory;
        this.f100185f = streakPauseWarning;
    }

    public static /* synthetic */ PauseBlockingViewState b(PauseBlockingViewState pauseBlockingViewState, PremiumState premiumState, List list, DateTimePicker dateTimePicker, List list2, StreakPauseWarning streakPauseWarning, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            premiumState = pauseBlockingViewState.f100181a;
        }
        if ((i3 & 2) != 0) {
            list = pauseBlockingViewState.f100182b;
        }
        if ((i3 & 4) != 0) {
            dateTimePicker = pauseBlockingViewState.f100183c;
        }
        if ((i3 & 8) != 0) {
            list2 = pauseBlockingViewState.f100184d;
        }
        if ((i3 & 16) != 0) {
            streakPauseWarning = pauseBlockingViewState.f100185f;
        }
        StreakPauseWarning streakPauseWarning2 = streakPauseWarning;
        DateTimePicker dateTimePicker2 = dateTimePicker;
        return pauseBlockingViewState.a(premiumState, list, dateTimePicker2, list2, streakPauseWarning2);
    }

    public final PauseBlockingViewState a(PremiumState premiumState, List customPresetsHistory, DateTimePicker dateTimePicker, List presetsHistory, StreakPauseWarning streakPauseWarning) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(customPresetsHistory, "customPresetsHistory");
        Intrinsics.checkNotNullParameter(dateTimePicker, "dateTimePicker");
        Intrinsics.checkNotNullParameter(presetsHistory, "presetsHistory");
        return new PauseBlockingViewState(premiumState, customPresetsHistory, dateTimePicker, presetsHistory, streakPauseWarning);
    }

    public final List c() {
        return this.f100182b;
    }

    public final List d() {
        Pair pairT = TimeHelperExt.f128663a.t();
        int iIntValue = ((Number) pairT.a()).intValue();
        int iIntValue2 = ((Number) pairT.b()).intValue();
        List list = this.f100184d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            int iD = ((SchedulePauseHistoryEntity) obj).d();
            if (iIntValue <= iD && iD <= iIntValue2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final DateTimePicker e() {
        return this.f100183c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PauseBlockingViewState)) {
            return false;
        }
        PauseBlockingViewState pauseBlockingViewState = (PauseBlockingViewState) obj;
        return Intrinsics.areEqual(this.f100181a, pauseBlockingViewState.f100181a) && Intrinsics.areEqual(this.f100182b, pauseBlockingViewState.f100182b) && Intrinsics.areEqual(this.f100183c, pauseBlockingViewState.f100183c) && Intrinsics.areEqual(this.f100184d, pauseBlockingViewState.f100184d) && Intrinsics.areEqual(this.f100185f, pauseBlockingViewState.f100185f);
    }

    public final PremiumState f() {
        return this.f100181a;
    }

    public final List g() {
        return this.f100184d;
    }

    public final StreakPauseWarning h() {
        return this.f100185f;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f100181a.hashCode() * 31) + this.f100182b.hashCode()) * 31) + this.f100183c.hashCode()) * 31) + this.f100184d.hashCode()) * 31;
        StreakPauseWarning streakPauseWarning = this.f100185f;
        return iHashCode + (streakPauseWarning == null ? 0 : streakPauseWarning.hashCode());
    }

    public String toString() {
        return "PauseBlockingViewState(premiumState=" + this.f100181a + ", customPresetsHistory=" + this.f100182b + ", dateTimePicker=" + this.f100183c + ", presetsHistory=" + this.f100184d + ", streakPauseWarning=" + this.f100185f + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DateTimePicker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f100186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f100187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f100188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f100189d;

        public DateTimePicker(String selectedTimeFormatted, String selectedDateWithTimeFormatted, long j3, long j4) {
            Intrinsics.checkNotNullParameter(selectedTimeFormatted, "selectedTimeFormatted");
            Intrinsics.checkNotNullParameter(selectedDateWithTimeFormatted, "selectedDateWithTimeFormatted");
            this.f100186a = selectedTimeFormatted;
            this.f100187b = selectedDateWithTimeFormatted;
            this.f100188c = j3;
            this.f100189d = j4;
        }

        public static /* synthetic */ DateTimePicker b(DateTimePicker dateTimePicker, String str, String str2, long j3, long j4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = dateTimePicker.f100186a;
            }
            if ((i3 & 2) != 0) {
                str2 = dateTimePicker.f100187b;
            }
            if ((i3 & 4) != 0) {
                j3 = dateTimePicker.f100188c;
            }
            if ((i3 & 8) != 0) {
                j4 = dateTimePicker.f100189d;
            }
            long j5 = j4;
            return dateTimePicker.a(str, str2, j3, j5);
        }

        public final DateTimePicker a(String selectedTimeFormatted, String selectedDateWithTimeFormatted, long j3, long j4) {
            Intrinsics.checkNotNullParameter(selectedTimeFormatted, "selectedTimeFormatted");
            Intrinsics.checkNotNullParameter(selectedDateWithTimeFormatted, "selectedDateWithTimeFormatted");
            return new DateTimePicker(selectedTimeFormatted, selectedDateWithTimeFormatted, j3, j4);
        }

        public final long c() {
            return this.f100188c;
        }

        public final String d() {
            return this.f100187b;
        }

        public final String e() {
            return this.f100186a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DateTimePicker)) {
                return false;
            }
            DateTimePicker dateTimePicker = (DateTimePicker) obj;
            return Intrinsics.areEqual(this.f100186a, dateTimePicker.f100186a) && Intrinsics.areEqual(this.f100187b, dateTimePicker.f100187b) && this.f100188c == dateTimePicker.f100188c && this.f100189d == dateTimePicker.f100189d;
        }

        public final long f() {
            return this.f100189d;
        }

        public int hashCode() {
            return (((((this.f100186a.hashCode() * 31) + this.f100187b.hashCode()) * 31) + Long.hashCode(this.f100188c)) * 31) + Long.hashCode(this.f100189d);
        }

        public String toString() {
            return "DateTimePicker(selectedTimeFormatted=" + this.f100186a + ", selectedDateWithTimeFormatted=" + this.f100187b + ", selectedDateInMillis=" + this.f100188c + ", selectedTimeInMillis=" + this.f100189d + ")";
        }

        public /* synthetic */ DateTimePicker(String str, String str2, long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j4);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PauseBlockingViewState(cz.mobilesoft.coreblock.enums.PremiumState r11, java.util.List r12, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState.DateTimePicker r13, java.util.List r14, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState.StreakPauseWarning r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r10 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L6
            cz.mobilesoft.coreblock.enums.PremiumState$None r11 = cz.mobilesoft.coreblock.enums.PremiumState.None.INSTANCE
        L6:
            r0 = r16 & 2
            if (r0 == 0) goto Le
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        Le:
            r0 = r16 & 4
            if (r0 == 0) goto L21
            cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$DateTimePicker r1 = new cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$DateTimePicker
            r8 = 15
            r9 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r1.<init>(r2, r3, r4, r6, r8, r9)
            r13 = r1
        L21:
            r0 = r16 & 8
            if (r0 == 0) goto L2a
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L2b
        L2a:
            r0 = r14
        L2b:
            r1 = r16 & 16
            if (r1 == 0) goto L39
            r1 = 0
            r17 = r1
            r14 = r12
            r15 = r13
            r16 = r0
            r12 = r10
        L37:
            r13 = r11
            goto L41
        L39:
            r17 = r15
            r14 = r12
            r16 = r0
            r12 = r10
            r15 = r13
            goto L37
        L41:
            r12.<init>(r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState.<init>(cz.mobilesoft.coreblock.enums.PremiumState, java.util.List, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$DateTimePicker, java.util.List, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState$StreakPauseWarning, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
