package cz.mobilesoft.coreblock.scene.streaks;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
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
public final class StreakEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakPauseRecordDao f120270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProfileDao f120271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakActivityRepository f120272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakRepository f120273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StreakAvailability f120274e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DayEvaluation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StreakDayStatus f120275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StreakLossReason f120276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f120277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f120278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f120279e;

        public DayEvaluation(StreakDayStatus status, StreakLossReason lossReason, Long l3, long j3, int i3) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(lossReason, "lossReason");
            this.f120275a = status;
            this.f120276b = lossReason;
            this.f120277c = l3;
            this.f120278d = j3;
            this.f120279e = i3;
        }

        public final Long a() {
            return this.f120277c;
        }

        public final long b() {
            return this.f120278d;
        }

        public final StreakLossReason c() {
            return this.f120276b;
        }

        public final int d() {
            return this.f120279e;
        }

        public final StreakDayStatus e() {
            return this.f120275a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayEvaluation)) {
                return false;
            }
            DayEvaluation dayEvaluation = (DayEvaluation) obj;
            return this.f120275a == dayEvaluation.f120275a && this.f120276b == dayEvaluation.f120276b && Intrinsics.areEqual(this.f120277c, dayEvaluation.f120277c) && this.f120278d == dayEvaluation.f120278d && this.f120279e == dayEvaluation.f120279e;
        }

        public int hashCode() {
            int iHashCode = ((this.f120275a.hashCode() * 31) + this.f120276b.hashCode()) * 31;
            Long l3 = this.f120277c;
            return ((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f120278d)) * 31) + Integer.hashCode(this.f120279e);
        }

        public String toString() {
            return "DayEvaluation(status=" + this.f120275a + ", lossReason=" + this.f120276b + qRMDmh.YlHybxiaT + this.f120277c + ", evaluatedAtMillis=" + this.f120278d + ", rulesVersion=" + this.f120279e + ")";
        }

        public /* synthetic */ DayEvaluation(StreakDayStatus streakDayStatus, StreakLossReason streakLossReason, Long l3, long j3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(streakDayStatus, (i4 & 2) != 0 ? StreakLossReason.NONE : streakLossReason, (i4 & 4) != 0 ? null : l3, j3, (i4 & 16) != 0 ? 2 : i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DayPreview {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StreakDayStatus f120280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f120281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f120282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f120283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final StreakLossReason f120284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ScheduleEligibility f120285f;

        public DayPreview(StreakDayStatus status, long j3, Long l3, long j4, StreakLossReason lossReason, ScheduleEligibility scheduleEligibility) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(lossReason, "lossReason");
            Intrinsics.checkNotNullParameter(scheduleEligibility, "scheduleEligibility");
            this.f120280a = status;
            this.f120281b = j3;
            this.f120282c = l3;
            this.f120283d = j4;
            this.f120284e = lossReason;
            this.f120285f = scheduleEligibility;
        }

        public final Long a() {
            return this.f120282c;
        }

        public final StreakLossReason b() {
            return this.f120284e;
        }

        public final ScheduleEligibility c() {
            return this.f120285f;
        }

        public final StreakDayStatus d() {
            return this.f120280a;
        }

        public final long e() {
            return this.f120283d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayPreview)) {
                return false;
            }
            DayPreview dayPreview = (DayPreview) obj;
            return this.f120280a == dayPreview.f120280a && this.f120281b == dayPreview.f120281b && Intrinsics.areEqual(this.f120282c, dayPreview.f120282c) && this.f120283d == dayPreview.f120283d && this.f120284e == dayPreview.f120284e && Intrinsics.areEqual(this.f120285f, dayPreview.f120285f);
        }

        public final long f() {
            return this.f120281b;
        }

        public int hashCode() {
            int iHashCode = ((this.f120280a.hashCode() * 31) + Long.hashCode(this.f120281b)) * 31;
            Long l3 = this.f120282c;
            return ((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Long.hashCode(this.f120283d)) * 31) + this.f120284e.hashCode()) * 31) + this.f120285f.hashCode();
        }

        public String toString() {
            return "DayPreview(status=" + this.f120280a + ", totalActiveDurationMillis=" + this.f120281b + ", earnedAtMillis=" + this.f120282c + ", thresholdMillis=" + this.f120283d + ", lossReason=" + this.f120284e + ", scheduleEligibility=" + this.f120285f + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PauseRisk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f120286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f120287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f120288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PauseSummary.LossTrigger f120289d;

        public PauseRisk(int i3, int i4, long j3, PauseSummary.LossTrigger trigger) {
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            this.f120286a = i3;
            this.f120287b = i4;
            this.f120288c = j3;
            this.f120289d = trigger;
        }

        public final int a() {
            return this.f120287b;
        }

        public final int b() {
            return this.f120286a;
        }

        public final PauseSummary.LossTrigger c() {
            return this.f120289d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PauseRisk)) {
                return false;
            }
            PauseRisk pauseRisk = (PauseRisk) obj;
            return this.f120286a == pauseRisk.f120286a && this.f120287b == pauseRisk.f120287b && this.f120288c == pauseRisk.f120288c && this.f120289d == pauseRisk.f120289d;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f120286a) * 31) + Integer.hashCode(this.f120287b)) * 31) + Long.hashCode(this.f120288c)) * 31) + this.f120289d.hashCode();
        }

        public String toString() {
            return "PauseRisk(streakCount=" + this.f120286a + ", existingPauseCount=" + this.f120287b + ", candidatePauseDurationMillis=" + this.f120288c + ", trigger=" + this.f120289d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PauseSummary {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f120290d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final PauseSummary f120291e = new PauseSummary(0, 0, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f120292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f120293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LossTrigger f120294c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ PauseSummary b(Companion companion, List list, long j3, int i3, int i4, Object obj) {
                if ((i4 & 2) != 0) {
                    j3 = StreakConfiguration.f120230a.a();
                }
                if ((i4 & 4) != 0) {
                    i3 = 3;
                }
                return companion.a(list, j3, i3);
            }

            public final PauseSummary a(List durationsMillis, long j3, int i3) {
                Intrinsics.checkNotNullParameter(durationsMillis, "durationsMillis");
                ArrayList arrayList = new ArrayList();
                Iterator it = durationsMillis.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Number) next).longValue() > 0) {
                        arrayList.add(next);
                    }
                }
                Long l3 = (Long) CollectionsKt.maxOrNull((Iterable) arrayList);
                long jLongValue = l3 != null ? l3.longValue() : 0L;
                return new PauseSummary(arrayList.size(), jLongValue, jLongValue > j3 ? LossTrigger.PAUSE_TOO_LONG : arrayList.size() > i3 ? LossTrigger.TOO_MANY_PAUSES : null);
            }

            private Companion() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class LossTrigger {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ LossTrigger[] $VALUES;
            public static final LossTrigger PAUSE_TOO_LONG = new LossTrigger("PAUSE_TOO_LONG", 0);
            public static final LossTrigger TOO_MANY_PAUSES = new LossTrigger("TOO_MANY_PAUSES", 1);

            private static final /* synthetic */ LossTrigger[] $values() {
                return new LossTrigger[]{PAUSE_TOO_LONG, TOO_MANY_PAUSES};
            }

            static {
                LossTrigger[] lossTriggerArr$values = $values();
                $VALUES = lossTriggerArr$values;
                $ENTRIES = EnumEntriesKt.a(lossTriggerArr$values);
            }

            private LossTrigger(String str, int i3) {
            }

            public static EnumEntries<LossTrigger> getEntries() {
                return $ENTRIES;
            }

            public static LossTrigger valueOf(String str) {
                return (LossTrigger) Enum.valueOf(LossTrigger.class, str);
            }

            public static LossTrigger[] values() {
                return (LossTrigger[]) $VALUES.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f120295a;

            static {
                int[] iArr = new int[LossTrigger.values().length];
                try {
                    iArr[LossTrigger.PAUSE_TOO_LONG.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LossTrigger.TOO_MANY_PAUSES.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f120295a = iArr;
            }
        }

        public PauseSummary(int i3, long j3, LossTrigger lossTrigger) {
            this.f120292a = i3;
            this.f120293b = j3;
            this.f120294c = lossTrigger;
        }

        public final long a() {
            return this.f120293b;
        }

        public final StreakLossReason b() {
            LossTrigger lossTrigger = this.f120294c;
            int i3 = lossTrigger == null ? -1 : WhenMappings.f120295a[lossTrigger.ordinal()];
            if (i3 == -1) {
                return StreakLossReason.NONE;
            }
            if (i3 == 1) {
                return StreakLossReason.PAUSE_TOO_LONG;
            }
            if (i3 == 2) {
                return StreakLossReason.TOO_MANY_PAUSES;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final LossTrigger c() {
            return this.f120294c;
        }

        public final int d() {
            return this.f120292a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PauseSummary)) {
                return false;
            }
            PauseSummary pauseSummary = (PauseSummary) obj;
            return this.f120292a == pauseSummary.f120292a && this.f120293b == pauseSummary.f120293b && this.f120294c == pauseSummary.f120294c;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.f120292a) * 31) + Long.hashCode(this.f120293b)) * 31;
            LossTrigger lossTrigger = this.f120294c;
            return iHashCode + (lossTrigger == null ? 0 : lossTrigger.hashCode());
        }

        public String toString() {
            return "PauseSummary(pauseCount=" + this.f120292a + ", longestPauseDurationMillis=" + this.f120293b + ", lossTrigger=" + this.f120294c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Resolved {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f120296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DayEvaluation f120297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StreakActivityRepository.DaySummary f120298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ScheduleEligibility f120299d;

        public Resolved(long j3, DayEvaluation evaluation, StreakActivityRepository.DaySummary blockingSummary, ScheduleEligibility scheduleEligibility) {
            Intrinsics.checkNotNullParameter(evaluation, "evaluation");
            Intrinsics.checkNotNullParameter(blockingSummary, "blockingSummary");
            Intrinsics.checkNotNullParameter(scheduleEligibility, "scheduleEligibility");
            this.f120296a = j3;
            this.f120297b = evaluation;
            this.f120298c = blockingSummary;
            this.f120299d = scheduleEligibility;
        }

        public final StreakActivityRepository.DaySummary a() {
            return this.f120298c;
        }

        public final DayEvaluation b() {
            return this.f120297b;
        }

        public final ScheduleEligibility c() {
            return this.f120299d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resolved)) {
                return false;
            }
            Resolved resolved = (Resolved) obj;
            return this.f120296a == resolved.f120296a && Intrinsics.areEqual(this.f120297b, resolved.f120297b) && Intrinsics.areEqual(this.f120298c, resolved.f120298c) && Intrinsics.areEqual(this.f120299d, resolved.f120299d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f120296a) * 31) + this.f120297b.hashCode()) * 31) + this.f120298c.hashCode()) * 31) + this.f120299d.hashCode();
        }

        public String toString() {
            return "Resolved(dayStartMillis=" + this.f120296a + ", evaluation=" + this.f120297b + ", blockingSummary=" + this.f120298c + ", scheduleEligibility=" + this.f120299d + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleEligibility {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f120300c = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ScheduleEligibility f120301d = new ScheduleEligibility(false, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f120302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f120303b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ScheduleEligibility a() {
                return ScheduleEligibility.f120301d;
            }

            private Companion() {
            }
        }

        public ScheduleEligibility(boolean z2, boolean z3) {
            this.f120302a = z2;
            this.f120303b = z3;
        }

        public final boolean b() {
            return this.f120302a || this.f120303b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleEligibility)) {
                return false;
            }
            ScheduleEligibility scheduleEligibility = (ScheduleEligibility) obj;
            return this.f120302a == scheduleEligibility.f120302a && this.f120303b == scheduleEligibility.f120303b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f120302a) * 31) + Boolean.hashCode(this.f120303b);
        }

        public String toString() {
            return "ScheduleEligibility(usageLimit=" + this.f120302a + ", launchCount=" + this.f120303b + ")";
        }
    }

    public StreakEvaluator(StreakPauseRecordDao pauseRecordDao, ProfileDao profileDao, StreakActivityRepository streakActivityRepository, StreakRepository streakRepository, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(pauseRecordDao, "pauseRecordDao");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(streakActivityRepository, "streakActivityRepository");
        Intrinsics.checkNotNullParameter(streakRepository, "streakRepository");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120270a = pauseRecordDao;
        this.f120271b = profileDao;
        this.f120272c = streakActivityRepository;
        this.f120273d = streakRepository;
        this.f120274e = availability;
    }

    public static /* synthetic */ Object e(StreakEvaluator streakEvaluator, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakEvaluator.d(j3, zoneId, continuation);
    }

    public static /* synthetic */ Object g(StreakEvaluator streakEvaluator, long j3, StreakStats streakStats, long j4, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        ZoneId zoneId2;
        if ((i3 & 4) != 0) {
            j4 = TimeHelperExt.f128663a.f();
        }
        long j5 = j4;
        if ((i3 & 8) != 0) {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneIdSystemDefault, "systemDefault(...)");
            zoneId2 = zoneIdSystemDefault;
        } else {
            zoneId2 = zoneId;
        }
        return streakEvaluator.f(j3, streakStats, j5, zoneId2, continuation);
    }

    public static /* synthetic */ Object i(StreakEvaluator streakEvaluator, long j3, long j4, Long l3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            l3 = null;
        }
        return streakEvaluator.h(j3, j4, l3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(java.time.LocalDate r25, long r26, java.time.ZoneId r28, kotlin.coroutines.Continuation r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.k(java.time.LocalDate, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.time.LocalDate r8, long r9, java.time.ZoneId r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$evaluate$1
            if (r0 == 0) goto L14
            r0 = r12
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$evaluate$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$evaluate$1) r0
            int r1 = r0.f120309g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120309g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$evaluate$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$evaluate$1
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f120307d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120309g
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r8 = r6.f120305b
            java.time.ZoneId r8 = (java.time.ZoneId) r8
            java.lang.Object r8 = r6.f120304a
            java.time.LocalDate r8 = (java.time.LocalDate) r8
            kotlin.ResultKt.b(r12)
            goto L59
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r6.f120304a = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f120305b = r12
            r6.f120306c = r9
            r6.f120309g = r2
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            java.lang.Object r12 = r1.k(r2, r3, r5, r6)
            if (r12 != r0) goto L59
            return r0
        L59:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$Resolved r12 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.Resolved) r12
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayEvaluation r8 = r12.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.b(java.time.LocalDate, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DayEvaluation c(long j3, StreakActivityRepository.DaySummary blockingSummary, PauseSummary pauseSummary, boolean z2, boolean z3, long j4) {
        Intrinsics.checkNotNullParameter(blockingSummary, "blockingSummary");
        Intrinsics.checkNotNullParameter(pauseSummary, "pauseSummary");
        StreakLossReason streakLossReasonB = pauseSummary.b();
        if (streakLossReasonB != StreakLossReason.NONE) {
            return new DayEvaluation(StreakDayStatus.LOST, streakLossReasonB, null, j4, 0, 20, null);
        }
        if (blockingSummary.b() >= StreakConfiguration.f120230a.c()) {
            return new DayEvaluation(StreakDayStatus.OBTAINED, null, blockingSummary.a(), j4, 0, 18, null);
        }
        if (z2) {
            return new DayEvaluation(StreakDayStatus.OBTAINED, null, Long.valueOf(j3), j4, 0, 18, null);
        }
        if (z3) {
            return new DayEvaluation(StreakDayStatus.REST, null, null, j4, 0, 22, null);
        }
        return new DayEvaluation(StreakDayStatus.INACTIVE, null, null, j4, 0, 22, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(long r6, java.time.ZoneId r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$isTodayLost$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$isTodayLost$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$isTodayLost$1) r0
            int r1 = r0.f120316h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120316h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$isTodayLost$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$isTodayLost$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f120314f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120316h
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r6 = r0.f120312c
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator r6 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator) r6
            java.lang.Object r6 = r0.f120311b
            java.time.ZoneId r6 = (java.time.ZoneId) r6
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L32
            goto L5a
        L32:
            r6 = move-exception
            goto L6e
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.f139772b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: java.lang.Throwable -> L32
            r0.f120311b = r9     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)     // Catch: java.lang.Throwable -> L32
            r0.f120312c = r9     // Catch: java.lang.Throwable -> L32
            r0.f120310a = r6     // Catch: java.lang.Throwable -> L32
            r0.f120313d = r3     // Catch: java.lang.Throwable -> L32
            r0.f120316h = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = r5.j(r6, r8, r0)     // Catch: java.lang.Throwable -> L32
            if (r9 != r1) goto L5a
            return r1
        L5a:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayPreview r9 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.DayPreview) r9     // Catch: java.lang.Throwable -> L32
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r6 = r9.d()     // Catch: java.lang.Throwable -> L32
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r7 = cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus.LOST     // Catch: java.lang.Throwable -> L32
            if (r6 != r7) goto L65
            r3 = r4
        L65:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L78
        L6e:
            kotlin.Result$Companion r7 = kotlin.Result.f139772b
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L78:
            boolean r7 = kotlin.Result.g(r6)
            if (r7 == 0) goto L7f
            r6 = 0
        L7f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.d(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(long r21, cz.mobilesoft.coreblock.scene.streaks.StreakStats r23, long r24, java.time.ZoneId r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.f(long, cz.mobilesoft.coreblock.scene.streaks.StreakStats, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(long r8, long r10, java.lang.Long r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$pauseSummary$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$pauseSummary$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$pauseSummary$1) r0
            int r1 = r0.f120331g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120331g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$pauseSummary$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$pauseSummary$1
            r0.<init>(r7, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f120329d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120331g
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r8 = r6.f120328c
            r12 = r8
            java.lang.Long r12 = (java.lang.Long) r12
            kotlin.ResultKt.b(r13)
            goto L4e
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao r1 = r7.f120270a
            r6.f120328c = r12
            r6.f120326a = r8
            r6.f120327b = r10
            r6.f120331g = r2
            r2 = r8
            r4 = r10
            java.lang.Object r13 = r1.N(r2, r4, r6)
            if (r13 != r0) goto L4e
            return r0
        L4e:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r9 = r13.iterator()
        L59:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L70
            java.lang.Object r10 = r9.next()
            r11 = r10
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity r11 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity) r11
            boolean r11 = r11.h()
            if (r11 != 0) goto L59
            r8.add(r10)
            goto L59
        L70:
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = 10
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r10)
            r9.<init>(r10)
            int r10 = r8.size()
            r11 = 0
        L80:
            if (r11 >= r10) goto L96
            java.lang.Object r13 = r8.get(r11)
            int r11 = r11 + 1
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity r13 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity) r13
            long r0 = r13.b()
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.e(r0)
            r9.add(r13)
            goto L80
        L96:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$PauseSummary$Companion r0 = cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.PauseSummary.f120290d
            java.util.List r8 = kotlin.collections.CollectionsKt.listOfNotNull(r12)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r1 = kotlin.collections.CollectionsKt.plus(r9, r8)
            r5 = 6
            r6 = 0
            r2 = 0
            r4 = 0
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$PauseSummary r8 = cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.PauseSummary.Companion.b(r0, r1, r2, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.h(long, long, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(long r10, java.time.ZoneId r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$previewToday$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$previewToday$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$previewToday$1) r0
            int r1 = r0.f120337g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120337g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$previewToday$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$previewToday$1
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f120335d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120337g
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r10 = r6.f120334c
            java.time.LocalDate r10 = (java.time.LocalDate) r10
            java.lang.Object r10 = r6.f120333b
            java.time.ZoneId r10 = (java.time.ZoneId) r10
            kotlin.ResultKt.b(r13)
            goto L5f
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r13 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            java.time.LocalDate r13 = r13.f(r10, r12)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r6.f120333b = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r6.f120334c = r1
            r6.f120332a = r10
            r6.f120337g = r2
            r1 = r9
            r3 = r10
            r5 = r12
            r2 = r13
            java.lang.Object r13 = r1.k(r2, r3, r5, r6)
            if (r13 != r0) goto L5f
            return r0
        L5f:
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$Resolved r13 = (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.Resolved) r13
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayPreview r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayPreview
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayEvaluation r10 = r13.b()
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r1 = r10.e()
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$DaySummary r10 = r13.a()
            long r2 = r10.b()
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$DaySummary r10 = r13.a()
            java.lang.Long r4 = r10.a()
            cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration r10 = cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration.f120230a
            long r5 = r10.c()
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$DayEvaluation r10 = r13.b()
            cz.mobilesoft.coreblock.scene.streaks.StreakLossReason r7 = r10.c()
            cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator$ScheduleEligibility r8 = r13.c()
            r0.<init>(r1, r2, r4, r5, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.j(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(java.time.LocalDate r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.l(java.time.LocalDate, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
