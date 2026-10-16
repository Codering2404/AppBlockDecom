package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class ScheduleSelectViewModel extends BaseStatefulViewModel<ScheduleSelectViewState, ScheduleSelectViewEvent, ScheduleSelectViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StrictModeAccessMethod f122060o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ProfileDao f122061p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final IntervalDao f122062q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final StrictModeRepository f122063r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final WillBeContinuousUseCase f122064s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f122065t;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1", f = "ScheduleSelectViewModel.kt", l = {40, 41, 48}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f122066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f122067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f122068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f122069d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long[] f122070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ScheduleSelectViewModel f122071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f122072h;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C03021<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f122073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScheduleSelectViewModel f122074b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AccessMethodConfiguration.Schedules.SchedulesBlockingMode f122075c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Set f122076d;

            C03021(boolean z2, ScheduleSelectViewModel scheduleSelectViewModel, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode, Set set) {
                this.f122073a = z2;
                this.f122074b = scheduleSelectViewModel;
                this.f122075c = schedulesBlockingMode;
                this.f122076d = set;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ScheduleSelectViewState f(List list, AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode, boolean z2, boolean z3, int i3, ScheduleSelectViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                List list2 = list;
                ImmutableList immutableListH = ExtensionsKt.h(list2);
                ArrayList arrayList = new ArrayList();
                for (T t2 : list2) {
                    if (((ScheduleSelectViewState.ScheduleDto) t2).j()) {
                        arrayList.add(t2);
                    }
                }
                return ScheduleSelectViewState.b(updateState, false, immutableListH, ExtensionsKt.h(arrayList), schedulesBlockingMode, schedulesBlockingMode, z2, z3, i3, 1, null);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0152  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0158  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x009d -> B:25:0x0150). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00f5 -> B:24:0x00fd). Please report as a decompilation issue!!! */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.util.List r35, kotlin.coroutines.Continuation r36) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 485
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel.AnonymousClass1.C03021.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long[] jArr, ScheduleSelectViewModel scheduleSelectViewModel, boolean z2, Continuation continuation) {
            super(1, continuation);
            this.f122070f = jArr;
            this.f122071g = scheduleSelectViewModel;
            this.f122072h = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f122070f, this.f122071g, this.f122072h, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        
            if (r8 == r0) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
        
            if (r3.collect(r4, r7) != r0) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[PHI: r1 r8
          0x007c: PHI (r1v6 java.util.Set<java.lang.Long>) = (r1v5 java.util.Set<java.lang.Long>), (r1v9 java.util.Set<java.lang.Long>) binds: [B:29:0x0079, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x007c: PHI (r8v16 java.lang.Object) = (r8v13 java.lang.Object), (r8v0 java.lang.Object) binds: [B:29:0x0079, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f122069d
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L37
                if (r1 == r5) goto L33
                if (r1 == r3) goto L2b
                if (r1 != r2) goto L23
                java.lang.Object r0 = r7.f122068c
                kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
                java.lang.Object r0 = r7.f122067b
                cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration$Schedules$SchedulesBlockingMode r0 = (cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration.Schedules.SchedulesBlockingMode) r0
                java.lang.Object r0 = r7.f122066a
                java.util.Set r0 = (java.util.Set) r0
                kotlin.ResultKt.b(r8)
                goto Lac
            L23:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L2b:
                java.lang.Object r1 = r7.f122066a
                java.util.Set r1 = (java.util.Set) r1
                kotlin.ResultKt.b(r8)
                goto L7c
            L33:
                kotlin.ResultKt.b(r8)
                goto L64
            L37:
                kotlin.ResultKt.b(r8)
                long[] r8 = r7.f122070f
                int r1 = r8.length
                if (r1 != 0) goto L41
                r1 = r5
                goto L42
            L41:
                r1 = r4
            L42:
                if (r1 != 0) goto L45
                goto L46
            L45:
                r8 = 0
            L46:
                if (r8 == 0) goto L51
                java.util.Set r8 = kotlin.collections.ArraysKt.toSet(r8)
                if (r8 != 0) goto L4f
                goto L51
            L4f:
                r1 = r8
                goto L67
            L51:
                cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel r8 = r7.f122071g
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r8 = cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel.W0(r8)
                kotlinx.coroutines.flow.Flow r8 = r8.s0()
                r7.f122069d = r5
                java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r7)
                if (r8 != r0) goto L64
                goto Lab
            L64:
                java.util.Set r8 = (java.util.Set) r8
                goto L4f
            L67:
                cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel r8 = r7.f122071g
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r8 = cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel.W0(r8)
                kotlinx.coroutines.flow.Flow r8 = r8.y0()
                r7.f122066a = r1
                r7.f122069d = r3
                java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r7)
                if (r8 != r0) goto L7c
                goto Lab
            L7c:
                cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration$Schedules$SchedulesBlockingMode r8 = (cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration.Schedules.SchedulesBlockingMode) r8
                cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel r3 = r7.f122071g
                cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r3 = cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel.U0(r3)
                kotlinx.coroutines.flow.Flow r3 = r3.Z0(r4, r4)
                cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1$1 r4 = new cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$1$1
                boolean r5 = r7.f122072h
                cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel r6 = r7.f122071g
                r4.<init>(r5, r6, r8, r1)
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
                r7.f122066a = r1
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                r7.f122067b = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
                r7.f122068c = r8
                r7.f122069d = r2
                java.lang.Object r8 = r3.collect(r4, r7)
                if (r8 != r0) goto Lac
            Lab:
                return r0
            Lac:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleSelectViewModel(StrictModeAccessMethod strictModeAccessMethod, long[] scheduleIds, boolean z2, Application application, ProfileDao profileDao, IntervalDao intervalDao, StrictModeRepository strictModeRepository, WillBeContinuousUseCase willBeContinuousUseCase) {
        super(application, new ScheduleSelectViewState(z2, null, null, null, null, false, false, 0, 254, null));
        Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(intervalDao, "intervalDao");
        Intrinsics.checkNotNullParameter(strictModeRepository, "strictModeRepository");
        Intrinsics.checkNotNullParameter(willBeContinuousUseCase, "willBeContinuousUseCase");
        this.f122060o = strictModeAccessMethod;
        this.f122061p = profileDao;
        this.f122062q = intervalDao;
        this.f122063r = strictModeRepository;
        this.f122064s = willBeContinuousUseCase;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122065t = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
        G0(new AnonymousClass1(scheduleIds, this, z2, null));
    }

    public static final /* synthetic */ ScheduleSelectViewState S0(ScheduleSelectViewModel scheduleSelectViewModel) {
        return (ScheduleSelectViewState) scheduleSelectViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore b1() {
        return (StrictModeDataStore) this.f122065t.getValue();
    }

    private final void c1() {
        G0(new ScheduleSelectViewModel$onConfirm$1(this, null));
    }

    private final void d1() {
        if (((ScheduleSelectViewState) I0()).h().isEmpty()) {
            e1();
        } else {
            c1();
        }
    }

    private final void e1() {
        G0(new ScheduleSelectViewModel$onCreateNewSchedule$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleSelectViewState g1(ScheduleSelectViewEvent scheduleSelectViewEvent, ScheduleSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ScheduleSelectViewState.b(updateState, false, null, null, ((ScheduleSelectViewEvent.BlockingModeSelected) scheduleSelectViewEvent).a(), null, false, false, 0, 247, null);
    }

    private final void h1(long j3) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleSelectViewModel$onScheduleClicked$1(this, j3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void O0(final ScheduleSelectViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ScheduleSelectViewEvent.OnScheduleClicked) {
            h1(((ScheduleSelectViewEvent.OnScheduleClicked) event).a());
        } else if (event instanceof ScheduleSelectViewEvent.OnConfirmButtonClicked) {
            d1();
        } else {
            if (!(event instanceof ScheduleSelectViewEvent.BlockingModeSelected)) {
                throw new NoWhenBranchMatchedException();
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.g0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleSelectViewModel.g1(event, (ScheduleSelectViewState) obj);
                }
            });
        }
    }
}
