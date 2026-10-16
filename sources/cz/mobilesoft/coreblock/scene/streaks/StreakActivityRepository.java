package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
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
public final class StreakActivityRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakPauseRecordDao f120113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakActivitySessionDao f120114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakActivityTracker f120115c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DaySummary {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f120116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f120117b;

        public DaySummary(long j3, Long l3) {
            this.f120116a = j3;
            this.f120117b = l3;
        }

        public final Long a() {
            return this.f120117b;
        }

        public final long b() {
            return this.f120116a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DaySummary)) {
                return false;
            }
            DaySummary daySummary = (DaySummary) obj;
            return this.f120116a == daySummary.f120116a && Intrinsics.areEqual(this.f120117b, daySummary.f120117b);
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.f120116a) * 31;
            Long l3 = this.f120117b;
            return iHashCode + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "DaySummary(totalActiveDurationMillis=" + this.f120116a + ", earnedAtMillis=" + this.f120117b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Window {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f120118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f120119b;

        public Window(long j3, long j4) {
            this.f120118a = j3;
            this.f120119b = j4;
        }

        public final long a() {
            return this.f120119b;
        }

        public final long b() {
            return this.f120118a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Window)) {
                return false;
            }
            Window window = (Window) obj;
            return this.f120118a == window.f120118a && this.f120119b == window.f120119b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f120118a) * 31) + Long.hashCode(this.f120119b);
        }

        public String toString() {
            return "Window(startMillis=" + this.f120118a + ", endMillis=" + this.f120119b + ")";
        }
    }

    public StreakActivityRepository(StreakPauseRecordDao pauseRecordDao, StreakActivitySessionDao sessionDao, StreakActivityTracker streakActivityTracker) {
        Intrinsics.checkNotNullParameter(pauseRecordDao, "pauseRecordDao");
        Intrinsics.checkNotNullParameter(sessionDao, "sessionDao");
        Intrinsics.checkNotNullParameter(streakActivityTracker, "streakActivityTracker");
        this.f120113a = pauseRecordDao;
        this.f120114b = sessionDao;
        this.f120115c = streakActivityTracker;
    }

    private final DaySummary c(List list, long j3) {
        Iterator it = list.iterator();
        long j4 = 0;
        Long lValueOf = null;
        while (it.hasNext()) {
            Window window = (Window) it.next();
            long jA = window.a() - window.b();
            long j5 = j3 - j4;
            if (lValueOf == null && j5 > 0 && jA >= j5) {
                lValueOf = Long.valueOf(window.b() + j5);
            }
            j4 += jA;
        }
        return new DaySummary(j4, j4 >= j3 ? lValueOf : null);
    }

    private final Window d(Window window, long j3, long j4) {
        long jMax = Math.max(window.b(), j3);
        long jMin = Math.min(window.a(), j4);
        if (jMax < jMin) {
            return new Window(jMax, jMin);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List f(List list) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$merge$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Long.valueOf(((StreakActivityRepository.Window) obj).b()), Long.valueOf(((StreakActivityRepository.Window) obj2).b()));
            }
        });
        List listMutableListOf = CollectionsKt.mutableListOf(CollectionsKt.first(listSortedWith));
        for (Window window : CollectionsKt.drop(listSortedWith, 1)) {
            Window window2 = (Window) CollectionsKt.last(listMutableListOf);
            if (window.b() <= window2.a()) {
                listMutableListOf.set(CollectionsKt.getLastIndex(listMutableListOf), new Window(window2.b(), Math.max(window2.a(), window.a())));
            } else {
                listMutableListOf.add(window);
            }
        }
        return listMutableListOf;
    }

    private final List g(Window window, Window window2) {
        Intrinsics.checkNotNullParameter(window, "<this>");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (window2.a() <= window.b() || window2.b() >= window.a()) {
            listCreateListBuilder.add(window);
        } else {
            if (window2.b() > window.b()) {
                listCreateListBuilder.add(new Window(window.b(), window2.b()));
            }
            if (window2.a() < window.a()) {
                listCreateListBuilder.add(new Window(window2.a(), window.a()));
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0157 -> B:45:0x01cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01b6 -> B:44:0x01be). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(long r25, long r27, long r29, kotlin.coroutines.Continuation r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository.h(long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.util.List r8, long r9, long r11, long r13, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository.i(java.util.List, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object k(StreakActivityRepository streakActivityRepository, LocalDate localDate, ZoneId zoneId, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        ZoneId zoneId2 = zoneId;
        if ((i3 & 4) != 0) {
            j3 = StreakConfiguration.f120230a.c();
        }
        return streakActivityRepository.j(localDate, zoneId2, j3, (i3 & 8) != 0 ? TimeHelperExt.f128663a.f() : j4, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r8.K(r6, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$deleteRecordsOlderThan$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$deleteRecordsOlderThan$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$deleteRecordsOlderThan$1) r0
            int r1 = r0.f120123d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120123d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$deleteRecordsOlderThan$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$deleteRecordsOlderThan$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f120121b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120123d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L57
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            long r6 = r0.f120120a
            kotlin.ResultKt.b(r8)
            goto L4a
        L3a:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r8 = r5.f120114b
            r0.f120120a = r6
            r0.f120123d = r4
            java.lang.Object r8 = r8.J(r6, r0)
            if (r8 != r1) goto L4a
            goto L56
        L4a:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao r8 = r5.f120113a
            r0.f120120a = r6
            r0.f120123d = r3
            java.lang.Object r6 = r8.K(r6, r0)
            if (r6 != r1) goto L57
        L56:
            return r1
        L57:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository.e(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.time.LocalDate r15, java.time.ZoneId r16, long r17, long r19, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            r14 = this;
            r1 = r16
            r2 = r21
            boolean r3 = r2 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$summary$1
            if (r3 == 0) goto L18
            r3 = r2
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$summary$1 r3 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$summary$1) r3
            int r4 = r3.f120156j
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L18
            int r4 = r4 - r5
            r3.f120156j = r4
        L16:
            r11 = r3
            goto L1e
        L18:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$summary$1 r3 = new cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$summary$1
            r3.<init>(r14, r2)
            goto L16
        L1e:
            java.lang.Object r2 = r11.f120154h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r11.f120156j
            r5 = 1
            if (r4 == 0) goto L47
            if (r4 != r5) goto L3f
            long r0 = r11.f120153g
            long r3 = r11.f120152f
            long r5 = r11.f120150c
            java.lang.Object r7 = r11.f120149b
            java.time.ZoneId r7 = (java.time.ZoneId) r7
            java.lang.Object r7 = r11.f120148a
            java.time.LocalDate r7 = (java.time.LocalDate) r7
            kotlin.ResultKt.b(r2)
            r7 = r0
            r0 = r5
            goto L7a
        L3f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L47:
            kotlin.ResultKt.b(r2)
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r2 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            long r6 = r2.d(r15, r1)
            long r8 = r2.a(r15, r1)
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
            r11.f120148a = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r11.f120149b = r0
            r0 = r17
            r11.f120150c = r0
            r12 = r19
            r11.f120151d = r12
            r11.f120152f = r6
            r11.f120153g = r8
            r11.f120156j = r5
            r4 = r14
            r5 = r6
            r7 = r8
            r9 = r12
            java.lang.Object r2 = r4.h(r5, r7, r9, r11)
            if (r2 != r3) goto L79
            return r3
        L79:
            r3 = r5
        L7a:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r2 = r2.iterator()
        L87:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto Laa
            java.lang.Object r6 = r2.next()
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$Window r6 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository.Window) r6
            r15 = r14
            r17 = r3
            r16 = r6
            r19 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$Window r3 = r15.d(r16, r17, r19)
            r6 = r17
            r8 = r19
            if (r3 == 0) goto La7
            r5.add(r3)
        La7:
            r3 = r6
            r7 = r8
            goto L87
        Laa:
            java.util.List r2 = r14.f(r5)
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository$DaySummary r0 = r14.c(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityRepository.j(java.time.LocalDate, java.time.ZoneId, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
