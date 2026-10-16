package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class StreakRepository {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f120407c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f120408d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakDayDao f120409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakDataStore f120410b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DayToStore {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocalDate f120411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StreakEvaluator.DayEvaluation f120412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f120413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ZoneId f120414d;

        public DayToStore(LocalDate date, StreakEvaluator.DayEvaluation evaluation, long j3, ZoneId zoneId) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(evaluation, "evaluation");
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            this.f120411a = date;
            this.f120412b = evaluation;
            this.f120413c = j3;
            this.f120414d = zoneId;
        }

        public final LocalDate a() {
            return this.f120411a;
        }

        public final long b() {
            return this.f120413c;
        }

        public final StreakEvaluator.DayEvaluation c() {
            return this.f120412b;
        }

        public final ZoneId d() {
            return this.f120414d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayToStore)) {
                return false;
            }
            DayToStore dayToStore = (DayToStore) obj;
            return Intrinsics.areEqual(this.f120411a, dayToStore.f120411a) && Intrinsics.areEqual(this.f120412b, dayToStore.f120412b) && this.f120413c == dayToStore.f120413c && Intrinsics.areEqual(this.f120414d, dayToStore.f120414d);
        }

        public int hashCode() {
            return (((((this.f120411a.hashCode() * 31) + this.f120412b.hashCode()) * 31) + Long.hashCode(this.f120413c)) * 31) + this.f120414d.hashCode();
        }

        public String toString() {
            return "DayToStore(date=" + this.f120411a + ", evaluation=" + this.f120412b + ", dayStartMillis=" + this.f120413c + ", zoneId=" + this.f120414d + ")";
        }
    }

    public StreakRepository(StreakDayDao streakDayDao, StreakDataStore streakDataStore) {
        Intrinsics.checkNotNullParameter(streakDayDao, "streakDayDao");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        this.f120409a = streakDayDao;
        this.f120410b = streakDataStore;
    }

    public static /* synthetic */ Object c(StreakRepository streakRepository, Function2 function2, long j3, ZoneId zoneId, int i3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        long j4 = j3;
        if ((i4 & 4) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        ZoneId zoneId2 = zoneId;
        if ((i4 & 8) != 0) {
            i3 = 90;
        }
        return streakRepository.b(function2, j4, zoneId2, i3, continuation);
    }

    private final StreakDayEntity e(LocalDate localDate, StreakEvaluator.DayEvaluation dayEvaluation, long j3, ZoneId zoneId) {
        String strC = StreakDates.f120261a.c(localDate);
        String id = zoneId.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return new StreakDayEntity(strC, j3, id, dayEvaluation.e(), dayEvaluation.c(), dayEvaluation.b(), dayEvaluation.a(), dayEvaluation.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r7.f0(true, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakRepository$markMeaningfulHistoryIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$markMeaningfulHistoryIfNeeded$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$markMeaningfulHistoryIfNeeded$1) r0
            int r1 = r0.f120440c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120440c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$markMeaningfulHistoryIfNeeded$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakRepository$markMeaningfulHistoryIfNeeded$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f120438a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120440c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            goto L7d
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            kotlin.ResultKt.b(r7)
            goto L67
        L3b:
            kotlin.ResultKt.b(r7)
            goto L51
        L3f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r6.f120410b
            kotlinx.coroutines.flow.Flow r7 = r7.K()
            r0.f120440c = r5
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L51
            goto L7c
        L51:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5c
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L5c:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao r7 = r6.f120409a
            r0.f120440c = r4
            java.lang.Object r7 = r7.J(r0)
            if (r7 != r1) goto L67
            goto L7c
        L67:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L72
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L72:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r7 = r6.f120410b
            r0.f120440c = r3
            java.lang.Object r7 = r7.f0(r5, r0)
            if (r7 != r1) goto L7d
        L7c:
            return r1
        L7d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x018d, code lost:
    
        if (r12.i0(r8, r5) == r6) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x030c, code lost:
    
        if (g(r5) != r6) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x025b -> B:15:0x00ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.jvm.functions.Function2 r30, long r31, java.time.ZoneId r33, int r34, kotlin.coroutines.Continuation r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository.b(kotlin.jvm.functions.Function2, long, java.time.ZoneId, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakRepository$days$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$days$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$days$1) r0
            int r1 = r0.f120433d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120433d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$days$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakRepository$days$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f120431b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120433d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.f120430a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r7)
            goto L53
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao r7 = r5.f120409a
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r2 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            java.time.LocalDate r4 = r2.e()
            java.lang.String r2 = r2.c(r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f120430a = r4
            r0.f120433d = r3
            java.lang.Object r7 = r7.L(r2, r6, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r0)
            r6.<init>(r0)
            java.util.Iterator r7 = r7.iterator()
        L64:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L78
            java.lang.Object r0 = r7.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity) r0
            cz.mobilesoft.coreblock.scene.streaks.StreakDay r0 = cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntityKt.a(r0)
            r6.add(r0)
            goto L64
        L78:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.String r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakRepository$isDayStoredAsLost$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$isDayStoredAsLost$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$isDayStoredAsLost$1) r0
            int r1 = r0.f120437d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120437d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$isDayStoredAsLost$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakRepository$isDayStoredAsLost$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f120435b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120437d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f120434a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r6)
            goto L49
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao r6 = r4.f120409a
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f120434a = r2
            r0.f120437d = r3
            java.lang.Object r6 = r6.K(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity) r6
            if (r6 == 0) goto L52
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r5 = r6.g()
            goto L53
        L52:
            r5 = 0
        L53:
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r6 = cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus.LOST
            if (r5 != r6) goto L58
            goto L59
        L58:
            r3 = 0
        L59:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow h() {
        final Flow flowN = this.f120409a.N();
        return new Flow<List<? extends StreakDay>>() { // from class: cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f120442a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2", f = "StreakRepository.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f120443a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f120444b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f120445c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f120447f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f120448g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f120449h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f120450i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f120443a = obj;
                        this.f120444b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f120442a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f120444b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f120444b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f120443a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f120444b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f120449h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f120447f
                        cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L8a
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f120442a
                        r2 = r7
                        java.util.List r2 = (java.util.List) r2
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r5 = 10
                        int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
                        r4.<init>(r5)
                        java.util.Iterator r2 = r2.iterator()
                    L52:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L66
                        java.lang.Object r5 = r2.next()
                        cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity) r5
                        cz.mobilesoft.coreblock.scene.streaks.StreakDay r5 = cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntityKt.a(r5)
                        r4.add(r5)
                        goto L52
                    L66:
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f120445c = r2
                        java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f120447f = r2
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f120448g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f120449h = r7
                        r7 = 0
                        r0.f120450i = r7
                        r0.f120444b = r3
                        java.lang.Object r7 = r8.emit(r4, r0)
                        if (r7 != r1) goto L8a
                        return r1
                    L8a:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository$observeDays$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowN.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(java.time.LocalDate r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakRepository$shouldContinueAsRestDay$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$shouldContinueAsRestDay$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakRepository$shouldContinueAsRestDay$1) r0
            int r1 = r0.f120455f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120455f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository$shouldContinueAsRestDay$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakRepository$shouldContinueAsRestDay$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f120453c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120455f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.f120452b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.f120451a
            java.time.LocalDate r7 = (java.time.LocalDate) r7
            kotlin.ResultKt.b(r8)
            goto L64
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r8 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            r4 = 1
            java.time.LocalDate r2 = r7.minusDays(r4)
            java.lang.String r4 = "minusDays(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r8 = r8.c(r2)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao r2 = r6.f120409a
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f120451a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f120452b = r7
            r0.f120455f = r3
            java.lang.Object r8 = r2.M(r8, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity r8 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity) r8
            r7 = 0
            if (r8 != 0) goto L6e
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r7
        L6e:
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r0 = r8.g()
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r1 = cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus.OBTAINED
            if (r0 == r1) goto L80
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r8 = r8.g()
            cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus r0 = cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus.REST
            if (r8 != r0) goto L7f
            goto L80
        L7f:
            r3 = r7
        L80:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakRepository.i(java.time.LocalDate, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object j(LocalDate localDate, StreakEvaluator.DayEvaluation dayEvaluation, long j3, ZoneId zoneId, Continuation continuation) {
        Object objF = this.f120409a.f(e(localDate, dayEvaluation, j3, zoneId), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final Object k(List list, Continuation continuation) {
        if (list.isEmpty()) {
            return Unit.f139807a;
        }
        StreakDayDao streakDayDao = this.f120409a;
        List<DayToStore> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DayToStore dayToStore : list2) {
            arrayList.add(e(dayToStore.a(), dayToStore.c(), dayToStore.b(), dayToStore.d()));
        }
        Object objJ = streakDayDao.j(arrayList, continuation);
        return objJ == IntrinsicsKt.f() ? objJ : Unit.f139807a;
    }
}
