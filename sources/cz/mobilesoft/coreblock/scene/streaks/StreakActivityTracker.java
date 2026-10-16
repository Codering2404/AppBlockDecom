package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class StreakActivityTracker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f120157e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f120158f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List f120159g = CollectionsKt.listOf((Object[]) new ProfileType[]{ProfileType.LOCATION, ProfileType.WIFI, ProfileType.BLUETOOTH});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakDataStore f120160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakActivitySessionDao f120161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakAvailability f120162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ProfileDao f120163d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Component {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Component[] $VALUES;
        public static final Component SCHEDULES = new Component("SCHEDULES", 0);
        public static final Component QUICK_BLOCK = new Component("QUICK_BLOCK", 1);

        private static final /* synthetic */ Component[] $values() {
            return new Component[]{SCHEDULES, QUICK_BLOCK};
        }

        static {
            Component[] componentArr$values = $values();
            $VALUES = componentArr$values;
            $ENTRIES = EnumEntriesKt.a(componentArr$values);
        }

        private Component(String str, int i3) {
        }

        public static EnumEntries<Component> getEntries() {
            return $ENTRIES;
        }

        public static Component valueOf(String str) {
            return (Component) Enum.valueOf(Component.class, str);
        }

        public static Component[] values() {
            return (Component[]) $VALUES.clone();
        }
    }

    public StreakActivityTracker(StreakDataStore streakDataStore, StreakActivitySessionDao sessionDao, StreakAvailability availability, ProfileDao profileDao) {
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(sessionDao, "sessionDao");
        Intrinsics.checkNotNullParameter(availability, "availability");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        this.f120160a = streakDataStore;
        this.f120161b = sessionDao;
        this.f120162c = availability;
        this.f120163d = profileDao;
    }

    public static /* synthetic */ Object A(StreakActivityTracker streakActivityTracker, Component component, boolean z2, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.z(component, z2, j3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(ProfileWithConfiguration profileWithConfiguration) {
        if (profileWithConfiguration.p().U(ProfileType.TIME) || profileWithConfiguration.p().U(ProfileType.QUICK_BLOCK)) {
            return false;
        }
        List list = f120159g;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (profileWithConfiguration.p().U((ProfileType) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Object n(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.m(j3, continuation);
    }

    public static /* synthetic */ Object p(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.o(j3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(Continuation continuation) {
        Object objH = this.f120160a.H(continuation);
        return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(StreakDataStore.ActivityTransition activityTransition, long j3, Continuation continuation) {
        if (!(activityTransition instanceof StreakDataStore.ActivityTransition.Closed)) {
            return Unit.f139807a;
        }
        StreakDataStore.ActivityTransition.Closed closed = (StreakDataStore.ActivityTransition.Closed) activityTransition;
        long jA = closed.a();
        if (1 > jA || jA >= j3) {
            return Unit.f139807a;
        }
        Object objN = this.f120161b.n(new StreakActivitySessionEntity(0L, null, closed.a(), j3, j3, 3, null), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(StreakActivitySessionEntity streakActivitySessionEntity, long j3, Continuation continuation) {
        if (streakActivitySessionEntity == null) {
            return Unit.f139807a;
        }
        if (j3 <= streakActivitySessionEntity.g()) {
            Object objQ = this.f120161b.q(streakActivitySessionEntity, continuation);
            return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
        }
        Object objP = this.f120161b.p(StreakActivitySessionEntity.b(streakActivitySessionEntity, 0L, null, 0L, j3, 0L, 23, null), continuation);
        return objP == IntrinsicsKt.f() ? objP : Unit.f139807a;
    }

    public static /* synthetic */ Object u(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.t(j3, continuation);
    }

    public static /* synthetic */ Object w(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.v(j3, continuation);
    }

    public static /* synthetic */ Object y(StreakActivityTracker streakActivityTracker, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = TimeHelperExt.f128663a.f();
        }
        return streakActivityTracker.x(j3, j4, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(long r9, long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$hasRecordedSession$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$hasRecordedSession$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$hasRecordedSession$1) r0
            int r1 = r0.f120168f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120168f = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$hasRecordedSession$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$hasRecordedSession$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f120166c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120168f
            r7 = 1
            if (r1 == 0) goto L33
            if (r1 != r7) goto L2b
            kotlin.ResultKt.b(r13)
            goto L47
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r1 = r8.f120161b
            r6.f120164a = r9
            r6.f120165b = r11
            r6.f120168f = r7
            r2 = r9
            r4 = r11
            java.lang.Object r13 = r1.N(r2, r4, r6)
            if (r13 != r0) goto L47
            return r0
        L47:
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r9 = r13.isEmpty()
            r9 = r9 ^ r7
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.i(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$openSessionStartMillis$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$openSessionStartMillis$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$openSessionStartMillis$1) r0
            int r1 = r0.f120171c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120171c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$openSessionStartMillis$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$openSessionStartMillis$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f120169a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120171c
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r7)
            goto L5f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            goto L47
        L39:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r6.f120160a
            r0.f120171c = r5
            java.lang.Object r7 = r7.S(r0)
            if (r7 != r1) goto L47
            goto L5e
        L47:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L50
            return r3
        L50:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r6.f120160a
            kotlinx.coroutines.flow.Flow r7 = r7.J()
            r0.f120171c = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5f
        L5e:
            return r1
        L5f:
            r0 = r7
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L6d
            return r7
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object l(long j3, long j4, Long l3, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$recordPlannedSession$2(this, j4, j3, l3, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object m(long j3, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$refreshConditionState$2(this, j3, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
    
        if (q(r0) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (r2.r((cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.ActivityTransition) r7, r5, r0) != r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[PHI: r5
      0x0091: PHI (r5v8 long) = (r5v6 long), (r5v9 long) binds: [B:32:0x008e, B:14:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(long r5, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$resync$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$resync$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$resync$1) r0
            int r1 = r0.f120185f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120185f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$resync$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$resync$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f120183c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120185f
            switch(r2) {
                case 0: goto L51;
                case 1: goto L4b;
                case 2: goto L47;
                case 3: goto L41;
                case 4: goto L3b;
                case 5: goto L30;
                case 6: goto L2b;
                default: goto L23;
            }
        L23:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2b:
            kotlin.ResultKt.b(r7)
            goto Lb3
        L30:
            long r5 = r0.f120181a
            java.lang.Object r2 = r0.f120182b
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r2 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker) r2
            kotlin.ResultKt.b(r7)
            goto La2
        L3b:
            long r5 = r0.f120181a
            kotlin.ResultKt.b(r7)
            goto L91
        L41:
            long r5 = r0.f120181a
            kotlin.ResultKt.b(r7)
            goto L85
        L47:
            kotlin.ResultKt.b(r7)
            goto L76
        L4b:
            long r5 = r0.f120181a
            kotlin.ResultKt.b(r7)
            goto L62
        L51:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability r7 = r4.f120162c
            r0.f120181a = r5
            r2 = 1
            r0.f120185f = r2
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L62
            goto Lb2
        L62:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L79
            r0.f120181a = r5
            r5 = 2
            r0.f120185f = r5
            java.lang.Object r5 = r4.q(r0)
            if (r5 != r1) goto L76
            goto Lb2
        L76:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L79:
            r0.f120181a = r5
            r7 = 3
            r0.f120185f = r7
            java.lang.Object r7 = r4.m(r5, r0)
            if (r7 != r1) goto L85
            goto Lb2
        L85:
            r0.f120181a = r5
            r7 = 4
            r0.f120185f = r7
            java.lang.Object r7 = r4.v(r5, r0)
            if (r7 != r1) goto L91
            goto Lb2
        L91:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r4.f120160a
            r0.f120182b = r4
            r0.f120181a = r5
            r2 = 5
            r0.f120185f = r2
            java.lang.Object r7 = r7.c0(r5, r0)
            if (r7 != r1) goto La1
            goto Lb2
        La1:
            r2 = r4
        La2:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$ActivityTransition r7 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.ActivityTransition) r7
            r3 = 0
            r0.f120182b = r3
            r0.f120181a = r5
            r3 = 6
            r0.f120185f = r3
            java.lang.Object r5 = r2.r(r7, r5, r0)
            if (r5 != r1) goto Lb3
        Lb2:
            return r1
        Lb3:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.o(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object t(long j3, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$truncateRunningSession$2(this, j3, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object v(long j3, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$truncateSessionsForDisabledProfiles$2(this, j3, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object x(long j3, long j4, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$truncateSessionsForProfile$2(this, j3, j4, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object z(Component component, boolean z2, long j3, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakActivityTracker$update$2(this, component, j3, z2, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }
}
