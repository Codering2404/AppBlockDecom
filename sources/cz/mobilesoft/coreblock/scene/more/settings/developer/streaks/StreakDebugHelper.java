package cz.mobilesoft.coreblock.scene.more.settings.developer.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.scene.streaks.StreakLossReason;
import cz.mobilesoft.coreblock.scene.streaks.StreakStats;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class StreakDebugHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakDayDao f109369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakActivitySessionDao f109370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakPauseRecordDao f109371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakDataStore f109372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StreakEvaluator f109373e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Snapshot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StreakStats f109374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StreakDayStatus f109375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f109376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f109377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Long f109378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f109379f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f109380g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final StreakLossReason f109381h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f109382i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f109383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f109384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f109385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Set f109386m;

        public Snapshot(StreakStats stats, StreakDayStatus todayStatus, long j3, long j4, Long l3, int i3, long j5, StreakLossReason todayLossReason, boolean z2, int i4, String lastEvaluatedDayKey, String lastPresentationDayKey, Set shownMilestones) {
            Intrinsics.checkNotNullParameter(stats, "stats");
            Intrinsics.checkNotNullParameter(todayStatus, "todayStatus");
            Intrinsics.checkNotNullParameter(todayLossReason, "todayLossReason");
            Intrinsics.checkNotNullParameter(lastEvaluatedDayKey, "lastEvaluatedDayKey");
            Intrinsics.checkNotNullParameter(lastPresentationDayKey, "lastPresentationDayKey");
            Intrinsics.checkNotNullParameter(shownMilestones, "shownMilestones");
            this.f109374a = stats;
            this.f109375b = todayStatus;
            this.f109376c = j3;
            this.f109377d = j4;
            this.f109378e = l3;
            this.f109379f = i3;
            this.f109380g = j5;
            this.f109381h = todayLossReason;
            this.f109382i = z2;
            this.f109383j = i4;
            this.f109384k = lastEvaluatedDayKey;
            this.f109385l = lastPresentationDayKey;
            this.f109386m = shownMilestones;
        }

        public final boolean a() {
            return this.f109382i;
        }

        public final String b() {
            return this.f109384k;
        }

        public final String c() {
            return this.f109385l;
        }

        public final Set d() {
            return this.f109386m;
        }

        public final StreakStats e() {
            return this.f109374a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) obj;
            return Intrinsics.areEqual(this.f109374a, snapshot.f109374a) && this.f109375b == snapshot.f109375b && this.f109376c == snapshot.f109376c && this.f109377d == snapshot.f109377d && Intrinsics.areEqual(this.f109378e, snapshot.f109378e) && this.f109379f == snapshot.f109379f && this.f109380g == snapshot.f109380g && this.f109381h == snapshot.f109381h && this.f109382i == snapshot.f109382i && this.f109383j == snapshot.f109383j && Intrinsics.areEqual(this.f109384k, snapshot.f109384k) && Intrinsics.areEqual(this.f109385l, snapshot.f109385l) && Intrinsics.areEqual(this.f109386m, snapshot.f109386m);
        }

        public final int f() {
            return this.f109383j;
        }

        public final long g() {
            return this.f109376c;
        }

        public final Long h() {
            return this.f109378e;
        }

        public int hashCode() {
            int iHashCode = ((((((this.f109374a.hashCode() * 31) + this.f109375b.hashCode()) * 31) + Long.hashCode(this.f109376c)) * 31) + Long.hashCode(this.f109377d)) * 31;
            Long l3 = this.f109378e;
            return ((((((((((((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Integer.hashCode(this.f109379f)) * 31) + Long.hashCode(this.f109380g)) * 31) + this.f109381h.hashCode()) * 31) + Boolean.hashCode(this.f109382i)) * 31) + Integer.hashCode(this.f109383j)) * 31) + this.f109384k.hashCode()) * 31) + this.f109385l.hashCode()) * 31) + this.f109386m.hashCode();
        }

        public final long i() {
            return this.f109380g;
        }

        public final StreakLossReason j() {
            return this.f109381h;
        }

        public final int k() {
            return this.f109379f;
        }

        public final StreakDayStatus l() {
            return this.f109375b;
        }

        public final long m() {
            return this.f109377d;
        }

        public String toString() {
            return "Snapshot(stats=" + this.f109374a + ", todayStatus=" + this.f109375b + ", todayActiveMillis=" + this.f109376c + ", todayThresholdMillis=" + this.f109377d + ", todayEarnedAtMillis=" + this.f109378e + ", todayPauseCount=" + this.f109379f + ", todayLongestPauseMillis=" + this.f109380g + ", todayLossReason=" + this.f109381h + ", hasEligibleSchedule=" + this.f109382i + ", storedDayCount=" + this.f109383j + ", lastEvaluatedDayKey=" + this.f109384k + ", lastPresentationDayKey=" + this.f109385l + ", shownMilestones=" + this.f109386m + ")";
        }
    }

    public StreakDebugHelper(StreakDayDao streakDayDao, StreakActivitySessionDao sessionDao, StreakPauseRecordDao pauseRecordDao, StreakDataStore streakDataStore, StreakEvaluator streakEvaluator) {
        Intrinsics.checkNotNullParameter(streakDayDao, "streakDayDao");
        Intrinsics.checkNotNullParameter(sessionDao, "sessionDao");
        Intrinsics.checkNotNullParameter(pauseRecordDao, "pauseRecordDao");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(streakEvaluator, "streakEvaluator");
        this.f109369a = streakDayDao;
        this.f109370b = sessionDao;
        this.f109371c = pauseRecordDao;
        this.f109372d = streakDataStore;
        this.f109373e = streakEvaluator;
    }

    public static /* synthetic */ Object b(StreakDebugHelper streakDebugHelper, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = TimeHelperExt.f128663a.f();
        }
        return streakDebugHelper.a(j3, j4, continuation);
    }

    public static /* synthetic */ Object e(StreakDebugHelper streakDebugHelper, List list, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        long j4 = j3;
        if ((i3 & 4) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakDebugHelper.d(list, j4, zoneId, continuation);
    }

    public static /* synthetic */ Object g(StreakDebugHelper streakDebugHelper, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakDebugHelper.f(j3, zoneId, continuation);
    }

    public final Object a(long j3, long j4, Continuation continuation) {
        Object objN = this.f109370b.n(new StreakActivitySessionEntity(0L, null, j4 - TimeUnit.MINUTES.toMillis(j3), j4, j4, 3, null), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d6, code lost:
    
        if (r6.k0(0, r0) != r1) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x024c, code lost:
    
        if (r1.h0("", r2) != r3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d2 A[PHI: r4 r6 r8 r9 r10
      0x01d2: PHI (r4v17 java.util.List) = (r4v14 java.util.List), (r4v20 java.util.List) binds: [B:40:0x01ce, B:15:0x0073] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r6v14 long) = (r6v12 long), (r6v16 long) binds: [B:40:0x01ce, B:15:0x0073] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r8v10 java.time.LocalDate) = (r8v7 java.time.LocalDate), (r8v13 java.time.LocalDate) binds: [B:40:0x01ce, B:15:0x0073] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r9v8 java.time.ZoneId) = (r9v5 java.time.ZoneId), (r9v11 java.time.ZoneId) binds: [B:40:0x01ce, B:15:0x0073] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r10v7 java.util.List) = (r10v4 java.util.List), (r10v9 java.util.List) binds: [B:40:0x01ce, B:15:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0227 A[PHI: r4 r6 r7 r8 r9
      0x0227: PHI (r4v23 long) = (r4v21 long), (r4v26 long) binds: [B:47:0x0224, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r6v20 java.util.List) = (r6v17 java.util.List), (r6v23 java.util.List) binds: [B:47:0x0224, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r7v12 java.time.LocalDate) = (r7v9 java.time.LocalDate), (r7v15 java.time.LocalDate) binds: [B:47:0x0224, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r8v17 java.time.ZoneId) = (r8v14 java.time.ZoneId), (r8v20 java.time.ZoneId) binds: [B:47:0x0224, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r9v15 java.util.List) = (r9v12 java.util.List), (r9v18 java.util.List) binds: [B:47:0x0224, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.util.List r23, long r24, java.time.ZoneId r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper.d(java.util.List, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0272 A[LOOP:1: B:37:0x0270->B:38:0x0272, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02f9 A[LOOP:4: B:63:0x02f3->B:65:0x02f9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(long r46, java.time.ZoneId r48, kotlin.coroutines.Continuation r49) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper.f(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
