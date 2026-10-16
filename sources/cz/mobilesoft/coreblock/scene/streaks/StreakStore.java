package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.ZoneId;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
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
public final class StreakStore {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Companion f120516i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f120517j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakRepository f120518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakPauseRecordDao f120519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakEvaluator f120520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakActivityRepository f120521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StreakDataStore f120522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StreakAvailability f120523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Mutex f120524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Flow f120525h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class StateInputs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f120526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f120527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f120528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f120529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f120530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f120531f;

        public StateInputs(List days, List pauseRecords, long j3, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(days, "days");
            Intrinsics.checkNotNullParameter(pauseRecords, "pauseRecords");
            this.f120526a = days;
            this.f120527b = pauseRecords;
            this.f120528c = j3;
            this.f120529d = z2;
            this.f120530e = z3;
            this.f120531f = z4;
        }

        public final List a() {
            return this.f120526a;
        }

        public final boolean b() {
            return this.f120531f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StateInputs)) {
                return false;
            }
            StateInputs stateInputs = (StateInputs) obj;
            return Intrinsics.areEqual(this.f120526a, stateInputs.f120526a) && Intrinsics.areEqual(this.f120527b, stateInputs.f120527b) && this.f120528c == stateInputs.f120528c && this.f120529d == stateInputs.f120529d && this.f120530e == stateInputs.f120530e && this.f120531f == stateInputs.f120531f;
        }

        public int hashCode() {
            return (((((((((this.f120526a.hashCode() * 31) + this.f120527b.hashCode()) * 31) + Long.hashCode(this.f120528c)) * 31) + Boolean.hashCode(this.f120529d)) * 31) + Boolean.hashCode(this.f120530e)) * 31) + Boolean.hashCode(this.f120531f);
        }

        public String toString() {
            return "StateInputs(days=" + this.f120526a + ", pauseRecords=" + this.f120527b + ", activityStartMillis=" + this.f120528c + ", isSchedulesActive=" + this.f120529d + ", isQuickBlockActive=" + this.f120530e + ", isEnabled=" + this.f120531f + ")";
        }
    }

    public StreakStore(StreakRepository streakRepository, StreakPauseRecordDao pauseRecordDao, StreakEvaluator streakEvaluator, StreakActivityRepository streakActivityRepository, StreakDataStore streakDataStore, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(streakRepository, "streakRepository");
        Intrinsics.checkNotNullParameter(pauseRecordDao, "pauseRecordDao");
        Intrinsics.checkNotNullParameter(streakEvaluator, "streakEvaluator");
        Intrinsics.checkNotNullParameter(streakActivityRepository, "streakActivityRepository");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120518a = streakRepository;
        this.f120519b = pauseRecordDao;
        this.f120520c = streakEvaluator;
        this.f120521d = streakActivityRepository;
        this.f120522e = streakDataStore;
        this.f120523f = availability;
        this.f120524g = MutexKt.b(false, 1, null);
        final Flow[] flowArr = {streakRepository.h(), pauseRecordDao.O(), streakDataStore.J(), streakDataStore.P(), streakDataStore.N(), availability.c()};
        this.f120525h = FlowKt.R(FlowKt.u(new Flow<StateInputs>() { // from class: cz.mobilesoft.coreblock.scene.streaks.StreakStore$special$$inlined$combine$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.streaks.StreakStore$special$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakStore$special$$inlined$combine$1$3", f = "StreakStore.kt", l = {234}, m = "invokeSuspend", v = 1)
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super StreakStore.StateInputs>, Object[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f120586a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f120587b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f120588c;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.f120587b = flowCollector;
                    anonymousClass3.f120588c = objArr;
                    return anonymousClass3.invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f120586a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        FlowCollector flowCollector = (FlowCollector) this.f120587b;
                        Object[] objArr = (Object[]) this.f120588c;
                        Object obj2 = objArr[0];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<cz.mobilesoft.coreblock.scene.streaks.StreakDay>");
                        Object obj3 = objArr[1];
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity>");
                        Object obj4 = objArr[2];
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
                        long jLongValue = ((Long) obj4).longValue();
                        Object obj5 = objArr[3];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) obj5).booleanValue();
                        Object obj6 = objArr[4];
                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                        Object obj7 = objArr[5];
                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Boolean");
                        StreakStore.StateInputs stateInputs = new StreakStore.StateInputs((List) obj2, (List) obj3, jLongValue, zBooleanValue, zBooleanValue2, ((Boolean) obj7).booleanValue());
                        this.f120587b = SpillingKt.a(flowCollector);
                        this.f120588c = SpillingKt.a(objArr);
                        this.f120586a = 1;
                        if (flowCollector.emit(stateInputs, this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f139807a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object objA = CombineKt.a(flowCollector, flowArr2, new Function0<Object[]>() { // from class: cz.mobilesoft.coreblock.scene.streaks.StreakStore$special$$inlined$combine$1.2
                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Object[] invoke() {
                        return new Object[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        }), new StreakStore$state$2(this, null));
    }

    public static /* synthetic */ Object f(StreakStore streakStore, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakStore.e(j3, zoneId, continuation);
    }

    public static /* synthetic */ Object i(StreakStore streakStore, List list, boolean z2, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        long j4 = j3;
        if ((i3 & 8) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakStore.h(list, z2, j4, zoneId, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0174, code lost:
    
        if (r6.j(r7, (cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator.DayEvaluation) r4, r13, r10, r11) != r5) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(long r19, java.time.ZoneId r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakStore.j(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object l(StreakStore streakStore, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakStore.k(j3, zoneId, continuation);
    }

    public static /* synthetic */ Object n(StreakStore streakStore, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakStore.m(j3, zoneId, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(long r10, java.time.ZoneId r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakStore$currentState$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.scene.streaks.StreakStore$currentState$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakStore$currentState$1) r0
            int r1 = r0.f120538h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120538h = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakStore$currentState$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakStore$currentState$1
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.f120536f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f120538h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L62
            if (r1 == r4) goto L51
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r10 = r7.f120533b
            java.time.ZoneId r10 = (java.time.ZoneId) r10
            kotlin.ResultKt.b(r13)
            return r13
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3d:
            long r10 = r7.f120532a
            java.lang.Object r12 = r7.f120535d
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r1 = r7.f120534c
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r1 = (cz.mobilesoft.coreblock.scene.streaks.StreakStore) r1
            java.lang.Object r3 = r7.f120533b
            java.time.ZoneId r3 = (java.time.ZoneId) r3
            kotlin.ResultKt.b(r13)
            r6 = r3
        L4f:
            r4 = r10
            goto L96
        L51:
            long r10 = r7.f120532a
            java.lang.Object r12 = r7.f120534c
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r12 = (cz.mobilesoft.coreblock.scene.streaks.StreakStore) r12
            java.lang.Object r1 = r7.f120533b
            java.time.ZoneId r1 = (java.time.ZoneId) r1
            kotlin.ResultKt.b(r13)
            r8 = r1
            r1 = r12
            r12 = r8
            goto L7d
        L62:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakRepository r13 = r9.f120518a
            cz.mobilesoft.coreblock.scene.streaks.StreakDates r1 = cz.mobilesoft.coreblock.scene.streaks.StreakDates.f120261a
            java.lang.String r1 = r1.b(r10, r12)
            r7.f120533b = r12
            r7.f120534c = r9
            r7.f120532a = r10
            r7.f120538h = r4
            java.lang.Object r13 = r13.d(r1, r7)
            if (r13 != r0) goto L7c
            goto Lb2
        L7c:
            r1 = r9
        L7d:
            java.util.List r13 = (java.util.List) r13
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability r4 = r9.f120523f
            r7.f120533b = r12
            r7.f120534c = r1
            r7.f120535d = r13
            r7.f120532a = r10
            r7.f120538h = r3
            java.lang.Object r3 = r4.d(r7)
            if (r3 != r0) goto L92
            goto Lb2
        L92:
            r6 = r12
            r12 = r13
            r13 = r3
            goto L4f
        L96:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r3 = r13.booleanValue()
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r7.f120533b = r10
            r10 = 0
            r7.f120534c = r10
            r7.f120535d = r10
            r7.f120532a = r4
            r7.f120538h = r2
            r2 = r12
            java.lang.Object r10 = r1.h(r2, r3, r4, r6, r7)
            if (r10 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakStore.e(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow g() {
        return this.f120525h;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019f A[LOOP:1: B:58:0x0199->B:60:0x019f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(java.util.List r21, boolean r22, long r23, java.time.ZoneId r25, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakStore.h(java.util.List, boolean, long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object k(long j3, ZoneId zoneId, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakStore$recordTodayLossIfNeeded$2(this, j3, zoneId, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x015e, code lost:
    
        if (r0 != r12) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0148 A[Catch: all -> 0x004b, PHI: r2 r4 r5
      0x0148: PHI (r2v22 long) = (r2v19 long), (r2v23 long) binds: [B:54:0x0145, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x0148: PHI (r4v19 ??) = (r4v23 ??), (r4v24 ??) binds: [B:54:0x0145, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x0148: PHI (r5v13 java.time.ZoneId) = (r5v11 java.time.ZoneId), (r5v15 java.time.ZoneId) binds: [B:54:0x0145, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:15:0x0046, B:56:0x0148, B:53:0x0128), top: B:74:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r18v0, types: [cz.mobilesoft.coreblock.scene.streaks.StreakStore] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(long r19, java.time.ZoneId r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakStore.m(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
