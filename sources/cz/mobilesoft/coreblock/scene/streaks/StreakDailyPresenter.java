package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class StreakDailyPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakStore f120235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakDataStore f120236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakAvailability f120237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Mutex f120238d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f120239a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Presentation {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Banner implements Presentation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f120240a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f120241b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final List f120242c;

            public Banner(int i3, boolean z2, List weekDays) {
                Intrinsics.checkNotNullParameter(weekDays, "weekDays");
                this.f120240a = i3;
                this.f120241b = z2;
                this.f120242c = weekDays;
            }

            public final int a() {
                return this.f120240a;
            }

            public final List b() {
                return this.f120242c;
            }

            public final boolean c() {
                return this.f120241b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Banner)) {
                    return false;
                }
                Banner banner = (Banner) obj;
                return this.f120240a == banner.f120240a && this.f120241b == banner.f120241b && Intrinsics.areEqual(this.f120242c, banner.f120242c);
            }

            public int hashCode() {
                return (((Integer.hashCode(this.f120240a) * 31) + Boolean.hashCode(this.f120241b)) * 31) + this.f120242c.hashCode();
            }

            public String toString() {
                return "Banner(streakCount=" + this.f120240a + ", isIntact=" + this.f120241b + ", weekDays=" + this.f120242c + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Milestone implements Presentation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f120243a;

            public Milestone(int i3) {
                this.f120243a = i3;
            }

            public final int a() {
                return this.f120243a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Milestone) && this.f120243a == ((Milestone) obj).f120243a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f120243a);
            }

            public String toString() {
                return "Milestone(streakCount=" + this.f120243a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Nothing implements Presentation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Nothing f120244a = new Nothing();

            private Nothing() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Nothing);
            }

            public int hashCode() {
                return 330888820;
            }

            public String toString() {
                return "Nothing";
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WeekDayStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WeekDayStatus[] $VALUES;
        public static final WeekDayStatus Obtained = new WeekDayStatus("Obtained", 0);
        public static final WeekDayStatus Rest = new WeekDayStatus("Rest", 1);
        public static final WeekDayStatus Inactive = new WeekDayStatus("Inactive", 2);
        public static final WeekDayStatus Future = new WeekDayStatus("Future", 3);

        private static final /* synthetic */ WeekDayStatus[] $values() {
            return new WeekDayStatus[]{Obtained, Rest, Inactive, Future};
        }

        static {
            WeekDayStatus[] weekDayStatusArr$values = $values();
            $VALUES = weekDayStatusArr$values;
            $ENTRIES = EnumEntriesKt.a(weekDayStatusArr$values);
        }

        private WeekDayStatus(String str, int i3) {
        }

        public static EnumEntries<WeekDayStatus> getEntries() {
            return $ENTRIES;
        }

        public static WeekDayStatus valueOf(String str) {
            return (WeekDayStatus) Enum.valueOf(WeekDayStatus.class, str);
        }

        public static WeekDayStatus[] values() {
            return (WeekDayStatus[]) $VALUES.clone();
        }
    }

    public StreakDailyPresenter(StreakStore streakStore, StreakDataStore streakDataStore, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(streakStore, "streakStore");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120235a = streakStore;
        this.f120236b = streakDataStore;
        this.f120237c = availability;
        this.f120238d = MutexKt.b(false, 1, null);
    }

    public static /* synthetic */ Object c(StreakDailyPresenter streakDailyPresenter, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakDailyPresenter.b(j3, zoneId, continuation);
    }

    private final Presentation d(StreakState streakState, StreakLine streakLine, int i3) {
        LocalDate localDateH = StreakDates.f120261a.h(streakLine.a());
        if (localDateH == null) {
            return Presentation.Nothing.f120244a;
        }
        LocalDate localDateMinusDays = localDateH.minusDays(localDateH.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue());
        List listB = streakState.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listB, 10)), 16));
        for (Object obj : listB) {
            linkedHashMap.put(((StreakDay) obj).a(), obj);
        }
        IntRange indices = CollectionsKt.getIndices(EntriesMappings.f120239a);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LocalDate localDatePlusDays = localDateMinusDays.plusDays(((IntIterator) it).nextInt());
            StreakDates streakDates = StreakDates.f120261a;
            Intrinsics.checkNotNull(localDatePlusDays);
            StreakDay streakDay = (StreakDay) linkedHashMap.get(streakDates.c(localDatePlusDays));
            arrayList.add((streakDay != null ? streakDay.b() : null) == StreakDayStatus.OBTAINED ? WeekDayStatus.Obtained : (streakDay != null ? streakDay.b() : null) == StreakDayStatus.REST ? WeekDayStatus.Rest : streakDay != null ? WeekDayStatus.Inactive : localDatePlusDays.isAfter(localDateH) ? WeekDayStatus.Future : WeekDayStatus.Inactive);
        }
        StreakDay streakDay2 = (StreakDay) linkedHashMap.get(streakLine.a());
        return new Presentation.Banner(i3, (streakDay2 != null ? streakDay2.b() : null) == StreakDayStatus.REST, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(int r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$shouldPresentMilestone$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$shouldPresentMilestone$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$shouldPresentMilestone$1) r0
            int r1 = r0.f120260d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120260d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$shouldPresentMilestone$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$shouldPresentMilestone$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f120258b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120260d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.f120257a
            kotlin.ResultKt.b(r6)
            goto L5d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration r6 = cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration.f120230a
            java.util.List r6 = r6.b()
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.d(r5)
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        L4c:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r6 = r4.f120236b
            kotlinx.coroutines.flow.Flow r6 = r6.Q()
            r0.f120257a = r5
            r0.f120260d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L5d
            return r1
        L5d:
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r5)
            boolean r5 = r6.contains(r5)
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.e(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00bd: MOVE (r4 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:190), block:B:31:0x00bd */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017f A[Catch: all -> 0x004c, TryCatch #3 {all -> 0x004c, blocks: (B:13:0x0047, B:81:0x025b, B:70:0x01ee, B:71:0x01f2, B:65:0x01b9, B:62:0x019c, B:56:0x0179, B:58:0x017f, B:59:0x0183, B:52:0x0151), top: B:90:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0183 A[Catch: all -> 0x004c, TryCatch #3 {all -> 0x004c, blocks: (B:13:0x0047, B:81:0x025b, B:70:0x01ee, B:71:0x01f2, B:65:0x01b9, B:62:0x019c, B:56:0x0179, B:58:0x017f, B:59:0x0183, B:52:0x0151), top: B:90:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9 A[Catch: all -> 0x004c, PHI: r0 r4 r5 r7 r8 r10 r11
      0x01b9: PHI (r0v23 java.lang.Object) = (r0v22 java.lang.Object), (r0v1 java.lang.Object) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r4v17 kotlinx.coroutines.sync.Mutex) = (r4v14 kotlinx.coroutines.sync.Mutex), (r4v19 kotlinx.coroutines.sync.Mutex) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r5v7 int) = (r5v5 int), (r5v9 int) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r7v11 int) = (r7v8 int), (r7v14 int) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r8v3 long) = (r8v1 long), (r8v4 long) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r10v13 java.lang.String) = (r10v9 java.lang.String), (r10v17 java.lang.String) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x01b9: PHI (r11v9 java.time.ZoneId) = (r11v6 java.time.ZoneId), (r11v12 java.time.ZoneId) binds: [B:63:0x01b5, B:29:0x00b5] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x004c, blocks: (B:13:0x0047, B:81:0x025b, B:70:0x01ee, B:71:0x01f2, B:65:0x01b9, B:62:0x019c, B:56:0x0179, B:58:0x017f, B:59:0x0183, B:52:0x0151), top: B:90:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ee A[Catch: all -> 0x004c, TryCatch #3 {all -> 0x004c, blocks: (B:13:0x0047, B:81:0x025b, B:70:0x01ee, B:71:0x01f2, B:65:0x01b9, B:62:0x019c, B:56:0x0179, B:58:0x017f, B:59:0x0183, B:52:0x0151), top: B:90:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f2 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #3 {all -> 0x004c, blocks: (B:13:0x0047, B:81:0x025b, B:70:0x01ee, B:71:0x01f2, B:65:0x01b9, B:62:0x019c, B:56:0x0179, B:58:0x017f, B:59:0x0183, B:52:0x0151), top: B:90:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022a A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:18:0x006b, B:75:0x0222, B:77:0x022a, B:83:0x0266), top: B:89:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0266 A[Catch: all -> 0x0070, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:18:0x006b, B:75:0x0222, B:77:0x022a, B:83:0x0266), top: B:89:0x006b }] */
    /* JADX WARN: Type inference failed for: r17v0, types: [cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(long r18, java.time.ZoneId r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.b(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
