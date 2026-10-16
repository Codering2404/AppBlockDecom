package cz.mobilesoft.coreblock.scene.streaks.detail;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.scene.streaks.StreakStats;
import java.time.LocalDate;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
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
public final class StreakDetailViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f120718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SummaryState f120719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakStats f120720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f120721d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f120722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f120723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f120724h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DayCell {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f120725f = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f120726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LocalDate f120727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DisplayStatus f120728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f120729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f120730e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DayCell a(int i3) {
                return new DayCell("placeholder-" + i3, null, DisplayStatus.Placeholder, false, false);
            }

            private Companion() {
            }
        }

        public DayCell(String dayKey, LocalDate localDate, DisplayStatus status, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(dayKey, "dayKey");
            Intrinsics.checkNotNullParameter(status, "status");
            this.f120726a = dayKey;
            this.f120727b = localDate;
            this.f120728c = status;
            this.f120729d = z2;
            this.f120730e = z3;
        }

        public final LocalDate a() {
            return this.f120727b;
        }

        public final DisplayStatus b() {
            return this.f120728c;
        }

        public final boolean c() {
            return this.f120730e;
        }

        public final boolean d() {
            return this.f120729d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayCell)) {
                return false;
            }
            DayCell dayCell = (DayCell) obj;
            return Intrinsics.areEqual(this.f120726a, dayCell.f120726a) && Intrinsics.areEqual(this.f120727b, dayCell.f120727b) && this.f120728c == dayCell.f120728c && this.f120729d == dayCell.f120729d && this.f120730e == dayCell.f120730e;
        }

        public int hashCode() {
            int iHashCode = this.f120726a.hashCode() * 31;
            LocalDate localDate = this.f120727b;
            return ((((((iHashCode + (localDate == null ? 0 : localDate.hashCode())) * 31) + this.f120728c.hashCode()) * 31) + Boolean.hashCode(this.f120729d)) * 31) + Boolean.hashCode(this.f120730e);
        }

        public String toString() {
            return "DayCell(dayKey=" + this.f120726a + ", date=" + this.f120727b + ", status=" + this.f120728c + ", isToday=" + this.f120729d + ", isActiveLineDay=" + this.f120730e + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisplayStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DisplayStatus[] $VALUES;
        public static final DisplayStatus Obtained = new DisplayStatus("Obtained", 0);
        public static final DisplayStatus Rest = new DisplayStatus("Rest", 1);
        public static final DisplayStatus Inactive = new DisplayStatus("Inactive", 2);
        public static final DisplayStatus Missing = new DisplayStatus("Missing", 3);
        public static final DisplayStatus Future = new DisplayStatus("Future", 4);
        public static final DisplayStatus TodayPossible = new DisplayStatus("TodayPossible", 5);
        public static final DisplayStatus TodayLost = new DisplayStatus("TodayLost", 6);
        public static final DisplayStatus Placeholder = new DisplayStatus("Placeholder", 7);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f120731a;

            static {
                int[] iArr = new int[DisplayStatus.values().length];
                try {
                    iArr[DisplayStatus.Obtained.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DisplayStatus.TodayPossible.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DisplayStatus.Rest.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DisplayStatus.TodayLost.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DisplayStatus.Inactive.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DisplayStatus.Missing.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[DisplayStatus.Future.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[DisplayStatus.Placeholder.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                f120731a = iArr;
            }
        }

        private static final /* synthetic */ DisplayStatus[] $values() {
            return new DisplayStatus[]{Obtained, Rest, Inactive, Missing, Future, TodayPossible, TodayLost, Placeholder};
        }

        static {
            DisplayStatus[] displayStatusArr$values = $values();
            $VALUES = displayStatusArr$values;
            $ENTRIES = EnumEntriesKt.a(displayStatusArr$values);
        }

        private DisplayStatus(String str, int i3) {
        }

        public static EnumEntries<DisplayStatus> getEntries() {
            return $ENTRIES;
        }

        public static DisplayStatus valueOf(String str) {
            return (DisplayStatus) Enum.valueOf(DisplayStatus.class, str);
        }

        public static DisplayStatus[] values() {
            return (DisplayStatus[]) $VALUES.clone();
        }

        public final Integer getHintRes() {
            switch (WhenMappings.f120731a[ordinal()]) {
                case 1:
                    return Integer.valueOf(R.string.RA);
                case 2:
                    return Integer.valueOf(R.string.UA);
                case 3:
                    return Integer.valueOf(R.string.TA);
                case 4:
                case 5:
                case 6:
                    return Integer.valueOf(R.string.SA);
                case 7:
                    return Integer.valueOf(R.string.QA);
                case 8:
                    return null;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MonthPage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f120732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f120733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f120734c;

        public MonthPage(String yearMonthKey, String title, List dayCells) {
            Intrinsics.checkNotNullParameter(yearMonthKey, "yearMonthKey");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(dayCells, "dayCells");
            this.f120732a = yearMonthKey;
            this.f120733b = title;
            this.f120734c = dayCells;
        }

        public final List a() {
            return this.f120734c;
        }

        public final String b() {
            return this.f120733b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MonthPage)) {
                return false;
            }
            MonthPage monthPage = (MonthPage) obj;
            return Intrinsics.areEqual(this.f120732a, monthPage.f120732a) && Intrinsics.areEqual(this.f120733b, monthPage.f120733b) && Intrinsics.areEqual(this.f120734c, monthPage.f120734c);
        }

        public int hashCode() {
            return (((this.f120732a.hashCode() * 31) + this.f120733b.hashCode()) * 31) + this.f120734c.hashCode();
        }

        public String toString() {
            return "MonthPage(yearMonthKey=" + this.f120732a + ", title=" + this.f120733b + ", dayCells=" + this.f120734c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface SummaryState {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Active implements SummaryState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f120735a;

            public Active(int i3) {
                this.f120735a = i3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Active) && this.f120735a == ((Active) obj).f120735a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f120735a);
            }

            public String toString() {
                return "Active(streakCount=" + this.f120735a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class InactiveHistory implements SummaryState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final InactiveHistory f120736a = new InactiveHistory();

            private InactiveHistory() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof InactiveHistory);
            }

            public int hashCode() {
                return -1661415122;
            }

            public String toString() {
                return "InactiveHistory";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NeverStarted implements SummaryState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NeverStarted f120737a = new NeverStarted();

            private NeverStarted() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NeverStarted);
            }

            public int hashCode() {
                return 695312112;
            }

            public String toString() {
                return "NeverStarted";
            }
        }
    }

    public StreakDetailViewState(boolean z2, SummaryState summaryState, StreakStats stats, List monthPages, int i3, List weekdaySymbols, boolean z3) {
        Intrinsics.checkNotNullParameter(summaryState, "summaryState");
        Intrinsics.checkNotNullParameter(stats, "stats");
        Intrinsics.checkNotNullParameter(monthPages, "monthPages");
        Intrinsics.checkNotNullParameter(weekdaySymbols, "weekdaySymbols");
        this.f120718a = z2;
        this.f120719b = summaryState;
        this.f120720c = stats;
        this.f120721d = monthPages;
        this.f120722f = i3;
        this.f120723g = weekdaySymbols;
        this.f120724h = z3;
    }

    public static /* synthetic */ StreakDetailViewState b(StreakDetailViewState streakDetailViewState, boolean z2, SummaryState summaryState, StreakStats streakStats, List list, int i3, List list2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z2 = streakDetailViewState.f120718a;
        }
        if ((i4 & 2) != 0) {
            summaryState = streakDetailViewState.f120719b;
        }
        if ((i4 & 4) != 0) {
            streakStats = streakDetailViewState.f120720c;
        }
        if ((i4 & 8) != 0) {
            list = streakDetailViewState.f120721d;
        }
        if ((i4 & 16) != 0) {
            i3 = streakDetailViewState.f120722f;
        }
        if ((i4 & 32) != 0) {
            list2 = streakDetailViewState.f120723g;
        }
        if ((i4 & 64) != 0) {
            z3 = streakDetailViewState.f120724h;
        }
        List list3 = list2;
        boolean z4 = z3;
        int i5 = i3;
        StreakStats streakStats2 = streakStats;
        return streakDetailViewState.a(z2, summaryState, streakStats2, list, i5, list3, z4);
    }

    public final StreakDetailViewState a(boolean z2, SummaryState summaryState, StreakStats stats, List monthPages, int i3, List weekdaySymbols, boolean z3) {
        Intrinsics.checkNotNullParameter(summaryState, "summaryState");
        Intrinsics.checkNotNullParameter(stats, "stats");
        Intrinsics.checkNotNullParameter(monthPages, "monthPages");
        Intrinsics.checkNotNullParameter(weekdaySymbols, "weekdaySymbols");
        return new StreakDetailViewState(z2, summaryState, stats, monthPages, i3, weekdaySymbols, z3);
    }

    public final boolean c() {
        return this.f120722f > 0;
    }

    public final boolean d() {
        return this.f120722f < CollectionsKt.getLastIndex(this.f120721d);
    }

    public final List e() {
        return this.f120721d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreakDetailViewState)) {
            return false;
        }
        StreakDetailViewState streakDetailViewState = (StreakDetailViewState) obj;
        return this.f120718a == streakDetailViewState.f120718a && Intrinsics.areEqual(this.f120719b, streakDetailViewState.f120719b) && Intrinsics.areEqual(this.f120720c, streakDetailViewState.f120720c) && Intrinsics.areEqual(this.f120721d, streakDetailViewState.f120721d) && this.f120722f == streakDetailViewState.f120722f && Intrinsics.areEqual(this.f120723g, streakDetailViewState.f120723g) && this.f120724h == streakDetailViewState.f120724h;
    }

    public final MonthPage f() {
        return (MonthPage) CollectionsKt.getOrNull(this.f120721d, this.f120722f);
    }

    public final int g() {
        return this.f120722f;
    }

    public final boolean h() {
        return this.f120724h;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.f120718a) * 31) + this.f120719b.hashCode()) * 31) + this.f120720c.hashCode()) * 31) + this.f120721d.hashCode()) * 31) + Integer.hashCode(this.f120722f)) * 31) + this.f120723g.hashCode()) * 31) + Boolean.hashCode(this.f120724h);
    }

    public final StreakStats i() {
        return this.f120720c;
    }

    public final SummaryState j() {
        return this.f120719b;
    }

    public final List k() {
        return this.f120723g;
    }

    public final boolean l() {
        return this.f120718a;
    }

    public String toString() {
        return "StreakDetailViewState(isLoading=" + this.f120718a + ", summaryState=" + this.f120719b + ", stats=" + this.f120720c + ", monthPages=" + this.f120721d + ", selectedMonthIndex=" + this.f120722f + ", weekdaySymbols=" + this.f120723g + ", showCreateBlockingAction=" + this.f120724h + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ StreakDetailViewState(boolean r7, cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState.SummaryState r8, cz.mobilesoft.coreblock.scene.streaks.StreakStats r9, java.util.List r10, int r11, java.util.List r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L5
            r7 = 1
        L5:
            r15 = r14 & 2
            if (r15 == 0) goto Lb
            cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState$SummaryState$NeverStarted r8 = cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState.SummaryState.NeverStarted.f120737a
        Lb:
            r15 = r14 & 4
            if (r15 == 0) goto L1a
            cz.mobilesoft.coreblock.scene.streaks.StreakStats r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakStats
            r4 = 7
            r5 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            r9 = r0
        L1a:
            r15 = r14 & 8
            if (r15 == 0) goto L22
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
        L22:
            r15 = r14 & 16
            r0 = 0
            if (r15 == 0) goto L28
            r11 = r0
        L28:
            r15 = r14 & 32
            if (r15 == 0) goto L30
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L30:
            r14 = r14 & 64
            if (r14 == 0) goto L3d
            r15 = r0
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r8 = r6
            goto L45
        L3d:
            r15 = r13
            r14 = r12
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
        L45:
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState.<init>(boolean, cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState$SummaryState, cz.mobilesoft.coreblock.scene.streaks.StreakStats, java.util.List, int, java.util.List, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
