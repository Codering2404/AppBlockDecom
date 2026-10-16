package cz.mobilesoft.coreblock.scene.dashboard;

import android.app.Application;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.storage.datastore.entity.ProfileDisabledSuggestStrictModeState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DashboardViewModel extends BaseStatefulViewModel<DashboardViewState, DashboardViewEvent, DashboardViewCommand> {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final MutableStateFlow D;
    private Job E;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final DashboardActivity.NavBarItem f99254o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final PremiumRepositoryV2 f99255p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f99256q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f99257r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f99258s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f99259t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f99260u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f99261v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f99262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f99263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f99264y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f99265z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$1", f = "DashboardViewModel.kt", l = {101, 102, 104, 105, 108, 126}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f99266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f99267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f99268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f99269d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f99270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f99271g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f99272h;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99274a;

            AnonymousClass2(DashboardViewModel dashboardViewModel) {
                this.f99274a = dashboardViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DashboardViewState f(boolean z2, DashboardViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DashboardViewState.b(updateState, null, null, null, null, null, false, false, false, BuildConfig.f95357b.booleanValue() ? Boolean.valueOf(z2) : null, false, false, false, 3839, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99274a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.v3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardViewModel.AnonymousClass1.AnonymousClass2.f(z2, (DashboardViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DashboardViewState q(List list, DashboardActivity.NavBarItem navBarItem, StrictModeScreenType strictModeScreenType, boolean z2, boolean z3, DashboardViewState dashboardViewState) {
            return DashboardViewState.b(dashboardViewState, null, null, list, navBarItem, strictModeScreenType, false, z2, z3, null, false, false, false, 3875, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0101, code lost:
        
            if (r13 == r0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0153, code lost:
        
            if (r13.collect(r1, r12) != r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[PHI: r1 r2 r3 r13
          0x00b7: PHI (r1v9 boolean) = (r1v6 boolean), (r1v10 boolean) binds: [B:20:0x00b3, B:9:0x004a] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r2v2 java.util.List) = (r2v1 java.util.List), (r2v5 java.util.List) binds: [B:20:0x00b3, B:9:0x004a] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r3v3 cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem) = 
          (r3v1 cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem)
          (r3v6 cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem)
         binds: [B:20:0x00b3, B:9:0x004a] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r13v13 java.lang.Object) = (r13v12 java.lang.Object), (r13v0 java.lang.Object) binds: [B:20:0x00b3, B:9:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x010c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10", f = "DashboardViewModel.kt", l = {225}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99275a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99277a;

            AnonymousClass1(DashboardViewModel dashboardViewModel) {
                this.f99277a = dashboardViewModel;
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
            
                if (r8.P0(r2, r0) == r1) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object a(boolean r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1$emit$1) r0
                    int r1 = r0.f99281d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f99281d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$10$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.f99279b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f99281d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3a
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.b(r8)
                    goto L5b
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    boolean r7 = r0.f99278a
                    kotlin.ResultKt.b(r8)
                    goto L4c
                L3a:
                    kotlin.ResultKt.b(r8)
                    if (r7 == 0) goto L5e
                    r0.f99278a = r7
                    r0.f99281d = r4
                    r4 = 500(0x1f4, double:2.47E-321)
                    java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r4, r0)
                    if (r8 != r1) goto L4c
                    goto L5a
                L4c:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r8 = r6.f99277a
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand$ShowAutoTrialExpiredPaywall r2 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand.ShowAutoTrialExpiredPaywall.f99234a
                    r0.f99278a = r7
                    r0.f99281d = r3
                    java.lang.Object r7 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.o1(r8, r2, r0)
                    if (r7 != r1) goto L5b
                L5a:
                    return r1
                L5b:
                    kotlin.Unit r7 = kotlin.Unit.f139807a
                    return r7
                L5e:
                    kotlin.Unit r7 = kotlin.Unit.f139807a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass10.AnonymousClass1.a(boolean, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99275a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC0 = DashboardViewModel.this.z1().C0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DashboardViewModel.this);
                this.f99275a = 1;
                if (flowC0.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$11", f = "DashboardViewModel.kt", l = {235}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99282a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99284a;

            AnonymousClass1(DashboardViewModel dashboardViewModel) {
                this.f99284a = dashboardViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DashboardViewState f(boolean z2, DashboardViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DashboardViewState.b(updateState, null, null, null, null, null, z2, false, false, null, false, false, false, 4063, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99284a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.w3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardViewModel.AnonymousClass11.AnonymousClass1.f(z2, (DashboardViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass11(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99282a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowP = DashboardViewModel.this.t0().p();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DashboardViewModel.this);
                this.f99282a = 1;
                if (stateFlowP.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$12", f = "DashboardViewModel.kt", l = {248}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99285a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$12$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$12$1", f = "DashboardViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<Long, Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99287a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ long f99288b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f99289c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(long j3, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99288b = j3;
                anonymousClass1.f99289c = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Number) obj).longValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                long j3 = this.f99288b;
                boolean z2 = this.f99289c;
                IntrinsicsKt.f();
                if (this.f99287a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(z2 && TimeHelperExt.f128663a.z(j3));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$12$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99290a;

            AnonymousClass2(DashboardViewModel dashboardViewModel) {
                this.f99290a = dashboardViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DashboardViewState f(boolean z2, DashboardViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DashboardViewState.b(updateState, null, null, null, null, null, false, false, false, null, false, false, z2, 2047, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f99290a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.x3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DashboardViewModel.AnonymousClass12.AnonymousClass2.f(z2, (DashboardViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass12(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99285a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(DashboardViewModel.this.K1().h0(), DashboardViewModel.this.F1().b0(), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(DashboardViewModel.this);
                this.f99285a = 1;
                if (flowM.collect(anonymousClass2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13", f = "DashboardViewModel.kt", l = {Function.MAX_NARGS}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f99292b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f99294a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99295b;

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$1", f = "DashboardViewModel.kt", l = {258}, m = "invokeSuspend", v = 1)
            static final class C02701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f99296a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ DashboardViewModel f99297b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02701(DashboardViewModel dashboardViewModel, Continuation continuation) {
                    super(2, continuation);
                    this.f99297b = dashboardViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C02701(this.f99297b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f99296a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        CoreDataStore coreDataStoreY1 = this.f99297b.y1();
                        this.f99296a = 1;
                        if (coreDataStoreY1.l5("", this) == objF) {
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

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C02701) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            AnonymousClass1(CoroutineScope coroutineScope, DashboardViewModel dashboardViewModel) {
                this.f99294a = coroutineScope;
                this.f99295b = dashboardViewModel;
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
            
                if (r13.P0(r2, r0) == r1) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.String r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r13
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$emit$1) r0
                    int r1 = r0.f99301d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f99301d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$emit$1
                    r0.<init>(r11, r13)
                L18:
                    java.lang.Object r13 = r0.f99299b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f99301d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L38
                    if (r2 != r3) goto L30
                    java.lang.Object r12 = r0.f99298a
                    java.lang.String r12 = (java.lang.String) r12
                    kotlin.ResultKt.b(r13)
                    goto L7d
                L30:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L38:
                    java.lang.Object r12 = r0.f99298a
                    java.lang.String r12 = (java.lang.String) r12
                    kotlin.ResultKt.b(r13)
                    goto L67
                L40:
                    kotlin.ResultKt.b(r13)
                    int r13 = r12.length()
                    if (r13 <= 0) goto L80
                    kotlinx.coroutines.CoroutineScope r5 = r11.f99294a
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$1 r8 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$13$1$1
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r13 = r11.f99295b
                    r2 = 0
                    r8.<init>(r13, r2)
                    r9 = 3
                    r10 = 0
                    r6 = 0
                    r7 = 0
                    kotlinx.coroutines.BuildersKt.d(r5, r6, r7, r8, r9, r10)
                    r0.f99298a = r12
                    r0.f99301d = r4
                    r4 = 500(0x1f4, double:2.47E-321)
                    java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r4, r0)
                    if (r13 != r1) goto L67
                    goto L7c
                L67:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r13 = r11.f99295b
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand$HandleDeeplink r2 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand$HandleDeeplink
                    r2.<init>(r12)
                    java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
                    r0.f99298a = r12
                    r0.f99301d = r3
                    java.lang.Object r12 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.o1(r13, r2, r0)
                    if (r12 != r1) goto L7d
                L7c:
                    return r1
                L7d:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                L80:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass13.AnonymousClass1.emit(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass13(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass13 anonymousClass13 = DashboardViewModel.this.new AnonymousClass13(continuation);
            anonymousClass13.f99292b = obj;
            return anonymousClass13;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f99292b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99291a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM2 = DashboardViewModel.this.y1().M2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, DashboardViewModel.this);
                this.f99292b = SpillingKt.a(coroutineScope);
                this.f99291a = 1;
                if (flowM2.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass13) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$2", f = "DashboardViewModel.kt", l = {136}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99302a;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DashboardViewState q(boolean z2, DashboardViewState dashboardViewState) {
            return DashboardViewState.b(dashboardViewState, null, null, null, null, null, false, false, false, null, z2, false, false, 3583, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99302a;
            if (i3 == 0) {
                ResultKt.b(obj);
                DashboardViewModel dashboardViewModel = DashboardViewModel.this;
                this.f99302a = 1;
                obj = dashboardViewModel.u1(this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            DashboardViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.y3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DashboardViewModel.AnonymousClass2.q(zBooleanValue, (DashboardViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$3", f = "DashboardViewModel.kt", l = {145}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f99304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f99305b;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MutableStateFlow mutableStateFlow;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99305b;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlowC1 = DashboardViewModel.this.C1();
                InAppUpdatesRepository inAppUpdatesRepository = InAppUpdatesRepository.f129855a;
                this.f99304a = mutableStateFlowC1;
                this.f99305b = 1;
                Object objQ = inAppUpdatesRepository.q(this);
                if (objQ == objF) {
                    return objF;
                }
                mutableStateFlow = mutableStateFlowC1;
                obj = objQ;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.f99304a;
                ResultKt.b(obj);
            }
            mutableStateFlow.setValue(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass5<T> implements FlowCollector {
        AnonymousClass5() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        
            if (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.s1(r1, false, false, true, r5, 3, null) == r0) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(long r9, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5$emit$1
                if (r0 == 0) goto L14
                r0 = r11
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5$emit$1) r0
                int r1 = r0.f99312d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.f99312d = r1
            L12:
                r5 = r0
                goto L1a
            L14:
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$5$emit$1
                r0.<init>(r8, r11)
                goto L12
            L1a:
                java.lang.Object r11 = r5.f99310b
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f99312d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3c
                if (r1 == r3) goto L36
                if (r1 != r2) goto L2e
                kotlin.ResultKt.b(r11)
                goto L5e
            L2e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L36:
                long r9 = r5.f99309a
                kotlin.ResultKt.b(r11)
                goto L4c
            L3c:
                kotlin.ResultKt.b(r11)
                r5.f99309a = r9
                r5.f99312d = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r3, r5)
                if (r11 != r0) goto L4c
                goto L5d
            L4c:
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r1 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.this
                r5.f99309a = r9
                r5.f99312d = r2
                r2 = 0
                r3 = 0
                r4 = 1
                r6 = 3
                r7 = 0
                java.lang.Object r9 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.s1(r1, r2, r3, r4, r5, r6, r7)
                if (r9 != r0) goto L5e
            L5d:
                return r0
            L5e:
                kotlin.Unit r9 = kotlin.Unit.f139807a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass5.a(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).longValue(), continuation);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$6", f = "DashboardViewModel.kt", l = {159}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99313a;

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99313a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = DashboardViewModel.this.I1().J();
                this.f99313a = 1;
                obj = FlowKt.D(flowJ, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            if (((Number) obj).longValue() < System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7L)) {
                AcademyRepository.q(null, 1, null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7", f = "DashboardViewModel.kt", l = {168}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f99316b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f99318a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99319b;

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$1", f = "DashboardViewModel.kt", l = {170}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f99320a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ DashboardViewModel f99321b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DashboardViewModel dashboardViewModel, Continuation continuation) {
                    super(2, continuation);
                    this.f99321b = dashboardViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f99321b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f99320a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        CoreDataStore coreDataStoreY1 = this.f99321b.y1();
                        PremiumRepositoryV2.PremiumExpiringFlowState premiumExpiringFlowState = PremiumRepositoryV2.PremiumExpiringFlowState.DoNotShow;
                        this.f99320a = 1;
                        if (coreDataStoreY1.O5(premiumExpiringFlowState, this) == objF) {
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

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            AnonymousClass2(CoroutineScope coroutineScope, DashboardViewModel dashboardViewModel) {
                this.f99318a = coroutineScope;
                this.f99319b = dashboardViewModel;
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
            
                if (r13.P0(r2, r0) == r1) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object a(boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$emit$1
                    if (r0 == 0) goto L13
                    r0 = r13
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$emit$1) r0
                    int r1 = r0.f99325d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f99325d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$emit$1
                    r0.<init>(r11, r13)
                L18:
                    java.lang.Object r13 = r0.f99323b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f99325d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3a
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.b(r13)
                    goto L6c
                L2c:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L34:
                    boolean r12 = r0.f99322a
                    kotlin.ResultKt.b(r13)
                    goto L5d
                L3a:
                    kotlin.ResultKt.b(r13)
                    if (r12 == 0) goto L6f
                    kotlinx.coroutines.CoroutineScope r5 = r11.f99318a
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$1 r8 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$7$2$1
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r13 = r11.f99319b
                    r2 = 0
                    r8.<init>(r13, r2)
                    r9 = 3
                    r10 = 0
                    r6 = 0
                    r7 = 0
                    kotlinx.coroutines.BuildersKt.d(r5, r6, r7, r8, r9, r10)
                    r0.f99322a = r12
                    r0.f99325d = r4
                    r4 = 500(0x1f4, double:2.47E-321)
                    java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r4, r0)
                    if (r13 != r1) goto L5d
                    goto L6b
                L5d:
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r13 = r11.f99319b
                    cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand$ShowPremiumExpiringFlow r2 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand.ShowPremiumExpiringFlow.f99238a
                    r0.f99322a = r12
                    r0.f99325d = r3
                    java.lang.Object r12 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.o1(r13, r2, r0)
                    if (r12 != r1) goto L6c
                L6b:
                    return r1
                L6c:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                L6f:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass7.AnonymousClass2.a(boolean, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass7(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass7 anonymousClass7 = DashboardViewModel.this.new AnonymousClass7(continuation);
            anonymousClass7.f99316b = obj;
            return anonymousClass7;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f99316b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99315a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowW = FlowKt.w(DashboardViewModel.this.f99255p.I().i(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.z3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(DashboardViewModel.AnonymousClass7.q(((Boolean) obj2).booleanValue()));
                    }
                });
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(coroutineScope, DashboardViewModel.this);
                this.f99316b = SpillingKt.a(coroutineScope);
                this.f99315a = 1;
                if (flowW.collect(anonymousClass2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(boolean z2) {
            return z2;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8", f = "DashboardViewModel.kt", l = {SensibleDefaults.X_OFFSET, 181, 183, 184}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99326a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8$1", f = "DashboardViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99328a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f99329b;

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99329b = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f99329b;
                IntrinsicsKt.f();
                if (this.f99328a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(z2);
            }

            public final Object invoke(boolean z2, Continuation continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass8(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        
            if (r8.P0(r1, r7) != r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f99326a
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L28
                if (r1 == r4) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                kotlin.ResultKt.b(r8)
                goto L7e
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                kotlin.ResultKt.b(r8)
                goto L71
            L24:
                kotlin.ResultKt.b(r8)
                goto L59
            L28:
                kotlin.ResultKt.b(r8)
                goto L4a
            L2c:
                kotlin.ResultKt.b(r8)
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.this
                cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.Z0(r8)
                cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase$Params r1 = cz.mobilesoft.coreblock.usecase.CheckAutoTrialEligibilityUseCase.Params.f126978a
                kotlinx.coroutines.flow.Flow r8 = r8.f(r1)
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8$1 r1 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$8$1
                r6 = 0
                r1.<init>(r6)
                r7.f99326a = r5
                java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.E(r8, r1, r7)
                if (r8 != r0) goto L4a
                goto L7d
            L4a:
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.this
                cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.g1(r8)
                r7.f99326a = r4
                java.lang.Object r8 = r8.t(r7)
                if (r8 != r0) goto L59
                goto L7d
            L59:
                boolean r8 = r8 instanceof cz.mobilesoft.coreblock.rest.ApiResponse.Success
                if (r8 == 0) goto L7e
                cz.mobilesoft.coreblock.util.analytics.AnswersHelper r8 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
                r8.u0()
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.c1(r8)
                r7.f99326a = r3
                java.lang.Object r8 = r8.s1(r5, r7)
                if (r8 != r0) goto L71
                goto L7d
            L71:
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.this
                cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand$ShowAutoTrialFlow r1 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand.ShowAutoTrialFlow.f99235a
                r7.f99326a = r2
                java.lang.Object r8 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.o1(r8, r1, r7)
                if (r8 != r0) goto L7e
            L7d:
                return r0
            L7e:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass8.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9", f = "DashboardViewModel.kt", l = {198}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99330a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9$1", f = "DashboardViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function4<CustomerInfo, AutoTrialVariant, Boolean, Continuation<? super Triple<? extends CustomerInfo, ? extends AutoTrialVariant, ? extends Boolean>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f99332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f99333b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f99334c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ boolean f99335d;

            AnonymousClass1(Continuation continuation) {
                super(4, continuation);
            }

            public final Object h(CustomerInfo customerInfo, AutoTrialVariant autoTrialVariant, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f99333b = customerInfo;
                anonymousClass1.f99334c = autoTrialVariant;
                anonymousClass1.f99335d = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return h((CustomerInfo) obj, (AutoTrialVariant) obj2, ((Boolean) obj3).booleanValue(), (Continuation) obj4);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                CustomerInfo customerInfo = (CustomerInfo) this.f99333b;
                AutoTrialVariant autoTrialVariant = (AutoTrialVariant) this.f99334c;
                boolean z2 = this.f99335d;
                IntrinsicsKt.f();
                if (this.f99332a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new Triple(customerInfo, autoTrialVariant, Boxing.a(z2));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DashboardViewModel f99336a;

            AnonymousClass2(DashboardViewModel dashboardViewModel) {
                this.f99336a = dashboardViewModel;
            }

            /* JADX WARN: Code restructure failed: missing block: B:45:0x015e, code lost:
            
                if (r14.P0(r9, r0) != r1) goto L47;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(kotlin.Triple r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 362
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.AnonymousClass9.AnonymousClass2.emit(kotlin.Triple, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass9(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DashboardViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99330a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowN = FlowKt.n(DashboardViewModel.this.f99255p.C(), DashboardViewModel.this.y1().h2(), DashboardViewModel.this.y1().g2(), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(DashboardViewModel.this);
                this.f99330a = 1;
                if (flowN.collect(anonymousClass2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrictModeScreenType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StrictModeScreenType[] $VALUES;
        public static final StrictModeScreenType UNKNOWN = new StrictModeScreenType("UNKNOWN", 0);
        public static final StrictModeScreenType ONBOARDING = new StrictModeScreenType("ONBOARDING", 1);
        public static final StrictModeScreenType OVERVIEW = new StrictModeScreenType("OVERVIEW", 2);

        private static final /* synthetic */ StrictModeScreenType[] $values() {
            return new StrictModeScreenType[]{UNKNOWN, ONBOARDING, OVERVIEW};
        }

        static {
            StrictModeScreenType[] strictModeScreenTypeArr$values = $values();
            $VALUES = strictModeScreenTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(strictModeScreenTypeArr$values);
        }

        private StrictModeScreenType(String str, int i3) {
        }

        public static EnumEntries<StrictModeScreenType> getEntries() {
            return $ENTRIES;
        }

        public static StrictModeScreenType valueOf(String str) {
            return (StrictModeScreenType) Enum.valueOf(StrictModeScreenType.class, str);
        }

        public static StrictModeScreenType[] values() {
            return (StrictModeScreenType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DashboardViewModel(Application application, DashboardActivity.NavBarItem navBarItem, PremiumRepositoryV2 premiumRepository) {
        super(application, new DashboardViewState(premiumRepository.J(), null, null, null, null, false, false, false, null, false, false, false, 4094, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f99254o = navBarItem;
        this.f99255p = premiumRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f99256q = LazyKt.a(lazyThreadSafetyModeB, new Function0<LaunchTimeDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LaunchTimeDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f99257r = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f99258s = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f99259t = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f99260u = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f99261v = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f99262w = LazyKt.a(lazyThreadSafetyModeB7, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f99263x = LazyKt.a(lazyThreadSafetyModeB8, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f99264y = LazyKt.a(lazyThreadSafetyModeB9, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f99265z = LazyKt.a(lazyThreadSafetyModeB10, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB11, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB12, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB13, new Function0<CheckAutoTrialEligibilityUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CheckAutoTrialEligibilityUseCase.class), objArr24, objArr25);
            }
        });
        this.D = StateFlowKt.a(null);
        BuildersKt__Builders_commonKt.d(B0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        FlowExtKt.l(B1().c1(), C0(), new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.4
            public final Object a(long j3, Continuation continuation) {
                Object objS1 = DashboardViewModel.s1(DashboardViewModel.this, false, true, false, continuation, 5, null);
                return objS1 == IntrinsicsKt.f() ? objS1 : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        FlowExtKt.l(B1().L0(), C0(), new AnonymousClass5());
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass6(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass7(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass8(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass9(null), 3, null);
        if (BuildConfig.f95357b.booleanValue()) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass10(null), 3, null);
        }
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass11(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass12(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass13(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore A1() {
        return (DiscountDataStore) this.f99263x.getValue();
    }

    private final EventDataStore B1() {
        return (EventDataStore) this.f99265z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LaunchTimeDao D1() {
        return (LaunchTimeDao) this.f99256q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List E1(boolean z2) {
        if (z2) {
            return DashboardActivity.f99133o.a();
        }
        List listA = DashboardActivity.f99133o.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (!(((DashboardActivity.NavBarItem) obj) instanceof DashboardActivity.NavBarItem.Statistics)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationDataStore F1() {
        return (NotificationDataStore) this.A.getValue();
    }

    private final ProfileDao G1() {
        return (ProfileDao) this.f99257r.getValue();
    }

    private final QuickBlockDataStore H1() {
        return (QuickBlockDataStore) this.f99264y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore I1() {
        return (SessionDataStore) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStartNavItem$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStartNavItem$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStartNavItem$1) r0
            int r1 = r0.f99378c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f99378c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStartNavItem$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStartNavItem$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f99376a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f99378c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L54
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem r5 = r4.f99254o
            if (r5 == 0) goto L43
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem$Statistics r2 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavBarItem.Statistics.f99178i
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r2)
            if (r5 != 0) goto L43
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem r5 = r4.f99254o
            return r5
        L43:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = r4.y1()
            kotlinx.coroutines.flow.Flow r5 = r5.E2()
            r0.f99378c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L54
            return r1
        L54:
            java.lang.String r5 = (java.lang.String) r5
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$Companion r0 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.f99133o
            java.util.List r0 = r0.a()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L62:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r0.next()
            r2 = r1
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem r2 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavBarItem) r2
            java.lang.String r2 = r2.c()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r2 == 0) goto L62
            goto L7b
        L7a:
            r1 = 0
        L7b:
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem r1 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavBarItem) r1
            if (r1 != 0) goto L82
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$NavBarItem$Blocking r5 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.NavBarItem.Blocking.f99175i
            return r5
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.J1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore K1() {
        return (StatisticsDataStore) this.f99262w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore L1() {
        return (StrictModeDataStore) this.f99261v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M1(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStrictModeScreenType$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStrictModeScreenType$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStrictModeScreenType$1) r0
            int r1 = r0.f99383f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f99383f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStrictModeScreenType$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$getStrictModeScreenType$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f99381c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f99383f
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L47
            if (r2 == r6) goto L43
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            int r1 = r0.f99380b
            boolean r0 = r0.f99379a
            kotlin.ResultKt.b(r13)
            goto La7
        L35:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L3d:
            boolean r2 = r0.f99379a
            kotlin.ResultKt.b(r13)
            goto L80
        L43:
            kotlin.ResultKt.b(r13)
            goto L68
        L47:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.repository.StrictModeRepository r13 = r12.t0()
            boolean r13 = r13.n()
            if (r13 == 0) goto L57
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$StrictModeScreenType r13 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.StrictModeScreenType.OVERVIEW
            return r13
        L57:
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r13 = r12.H1()
            kotlinx.coroutines.flow.Flow r13 = r13.F()
            r0.f99383f = r6
            java.lang.Object r13 = kotlinx.coroutines.flow.FlowKt.D(r13, r0)
            if (r13 != r1) goto L68
            goto La3
        L68:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = r12.G1()
            r0.f99379a = r13
            r0.f99383f = r5
            java.lang.Object r2 = r2.O(r0)
            if (r2 != r1) goto L7d
            goto La3
        L7d:
            r11 = r2
            r2 = r13
            r13 = r11
        L80:
            java.lang.Number r13 = (java.lang.Number) r13
            long r7 = r13.longValue()
            r9 = 0
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 <= 0) goto L8e
            r13 = r6
            goto L8f
        L8e:
            r13 = r3
        L8f:
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r5 = r12.L1()
            kotlinx.coroutines.flow.Flow r5 = r5.t0()
            r0.f99379a = r2
            r0.f99380b = r13
            r0.f99383f = r4
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r0 != r1) goto La4
        La3:
            return r1
        La4:
            r1 = r13
            r13 = r0
            r0 = r2
        La7:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r1 == 0) goto Lb0
            r3 = r6
        Lb0:
            cz.mobilesoft.coreblock.scene.dashboard.r3 r1 = new cz.mobilesoft.coreblock.scene.dashboard.r3
            r1.<init>()
            r12.Q0(r1)
            if (r13 == 0) goto Lbd
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$StrictModeScreenType r13 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.StrictModeScreenType.ONBOARDING
            return r13
        Lbd:
            cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$StrictModeScreenType r13 = cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.StrictModeScreenType.OVERVIEW
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.M1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardViewState N1(boolean z2, boolean z3, DashboardViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DashboardViewState.b(updateState, null, null, null, null, null, false, false, false, null, false, (z2 || z3) ? false : true, false, 3071, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardViewState P1(DashboardViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DashboardViewState.b(updateState, null, null, null, null, null, false, false, false, null, false, false, false, 3583, null);
    }

    private final void Q1(Profile.PausedUntil pausedUntil, Long l3) {
        AnswersHelper.f128199a.c5(l3, pausedUntil.a() > 0 ? pausedUntil.a() : 0L);
        if (pausedUntil instanceof Profile.PausedUntil.DisabledByUser) {
            G0(new DashboardViewModel$onProfilePaused$1(this, null));
            return;
        }
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        if (pausedUntil.a() > timeHelperExt.f() + 86400000) {
            return;
        }
        this.E = FlowKt.Q(FlowKt.V(FlowKt.g(timeHelperExt.a(System.currentTimeMillis() + 3000, 50L)), new DashboardViewModel$onProfilePaused$2(this, pausedUntil.a() - timeHelperExt.f(), null)), B0());
    }

    private final void R1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$saveTodayLaunchTime$1(this, null), 3, null);
    }

    private final void S1() {
        U1();
        T1();
        R1();
        q1();
    }

    private final void T1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$updateApplicationAccess$1(this, null), 3, null);
    }

    private final void U1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$updateInsertApplications$1(this, null), 3, null);
    }

    private final void V1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$updateStrictModeScreenType$1(this, null), 3, null);
    }

    private final void W1(long j3, long j4, Function1 function1, long j5) {
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        if (j4 < j5 - timeHelperExt.l() || j3 > j5 - timeHelperExt.l()) {
            function1.invoke(Boolean.TRUE);
        } else {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$checkAndShowDiscount$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a6, code lost:
    
        if (P0(r1, r8) == r9) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ca, code lost:
    
        if (r3.Y0(r1, r8) == r9) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r1(boolean r22, boolean r23, boolean r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.r1(boolean, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object s1(DashboardViewModel dashboardViewModel, boolean z2, boolean z3, boolean z4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        if ((i3 & 4) != 0) {
            z4 = false;
        }
        return dashboardViewModel.r1(z2, z3, z4, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f99258s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(ProfileDisabledSuggestStrictModeState profileDisabledSuggestStrictModeState, long j3, boolean z2) {
        profileDisabledSuggestStrictModeState.setQbCancelCount(z2 ? 1L : 1 + profileDisabledSuggestStrictModeState.getQbCancelCount());
        profileDisabledSuggestStrictModeState.setLastQBCancelTime(j3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x027a, code lost:
    
        if (r7.b5(r14, r2) == r3) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02b4, code lost:
    
        if (r12.R5(false, r2) == r3) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010f A[PHI: r1 r4 r5 r8
      0x010f: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:27:0x010b, B:19:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r4v6 boolean) = (r4v4 boolean), (r4v8 boolean) binds: [B:27:0x010b, B:19:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r5v6 boolean) = (r5v3 boolean), (r5v7 boolean) binds: [B:27:0x010b, B:19:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x010f: PHI (r8v3 cz.mobilesoft.coreblock.enums.PremiumState) = (r8v1 cz.mobilesoft.coreblock.enums.PremiumState), (r8v6 cz.mobilesoft.coreblock.enums.PremiumState) binds: [B:27:0x010b, B:19:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014b A[Catch: PurchasesException -> 0x02bc, TryCatch #0 {PurchasesException -> 0x02bc, blocks: (B:16:0x0098, B:39:0x0162, B:34:0x0143, B:36:0x014b), top: B:97:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0236 A[PHI: r1 r4 r8 r9 r10 r11 r13
      0x0236: PHI (r1v32 boolean) = (r1v21 boolean), (r1v21 boolean), (r1v21 boolean), (r1v42 boolean) binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r4v19 long) = (r4v11 long), (r4v11 long), (r4v11 long), (r4v23 long) binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r8v16 boolean) = (r8v9 boolean), (r8v9 boolean), (r8v9 boolean), (r8v20 boolean) binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r9v10 boolean) = (r9v5 boolean), (r9v5 boolean), (r9v5 boolean), (r9v13 boolean) binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r10v12 cz.mobilesoft.coreblock.enums.PremiumState) = 
      (r10v5 cz.mobilesoft.coreblock.enums.PremiumState)
      (r10v5 cz.mobilesoft.coreblock.enums.PremiumState)
      (r10v5 cz.mobilesoft.coreblock.enums.PremiumState)
      (r10v23 cz.mobilesoft.coreblock.enums.PremiumState)
     binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r11v16 cz.mobilesoft.coreblock.enums.PremiumState) = 
      (r11v7 cz.mobilesoft.coreblock.enums.PremiumState)
      (r11v7 cz.mobilesoft.coreblock.enums.PremiumState)
      (r11v7 cz.mobilesoft.coreblock.enums.PremiumState)
      (r11v22 cz.mobilesoft.coreblock.enums.PremiumState)
     binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r13v9 com.revenuecat.purchases.CustomerInfo) = 
      (r13v2 com.revenuecat.purchases.CustomerInfo)
      (r13v2 com.revenuecat.purchases.CustomerInfo)
      (r13v2 com.revenuecat.purchases.CustomerInfo)
      (r13v14 com.revenuecat.purchases.CustomerInfo)
     binds: [B:47:0x0186, B:49:0x0190, B:55:0x01a2, B:70:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u1(kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel.u1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$collectAdsEnabledState$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        FlowExtKt.i(K1().Y(), C0(), new DashboardViewModel$collectStatisticsEnabledState$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckAutoTrialEligibilityUseCase x1() {
        return (CheckAutoTrialEligibilityUseCase) this.C.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore y1() {
        return (CoreDataStore) this.f99259t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore z1() {
        return (DevDataStore) this.f99260u.getValue();
    }

    public final MutableStateFlow C1() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void O0(DashboardViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof DashboardViewEvent.OnScreenOpened) {
            if (Intrinsics.areEqual(((DashboardViewEvent.OnScreenOpened) event).a(), DashboardActivity.NavBarItem.StrictMode.f99179i)) {
                V1();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$onEvent$1(this, event, null), 3, null);
            return;
        }
        if (event instanceof DashboardViewEvent.OnDashboardResumed) {
            S1();
            return;
        }
        if (event instanceof DashboardViewEvent.InAppUpdateDialogClosed) {
            this.D.setValue(null);
            return;
        }
        if (event instanceof DashboardViewEvent.OnProfilePaused) {
            DashboardViewEvent.OnProfilePaused onProfilePaused = (DashboardViewEvent.OnProfilePaused) event;
            Q1(onProfilePaused.a(), onProfilePaused.b());
            return;
        }
        if (event instanceof DashboardViewEvent.OnStrictModeOnboardingFinished) {
            V1();
            return;
        }
        if (event instanceof DashboardViewEvent.OnRegistrationDialogClosed) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.t3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DashboardViewModel.P1((DashboardViewState) obj);
                }
            });
            return;
        }
        if (event instanceof DashboardViewEvent.OnNavPageRequested) {
            G0(new DashboardViewModel$onEvent$3(this, event, null));
            return;
        }
        if (Intrinsics.areEqual(event, DashboardViewEvent.OnStrictModeSuggestionNeverShowAgainClicked.f99252a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$onEvent$4(this, null), 3, null);
        } else if (Intrinsics.areEqual(event, DashboardViewEvent.OnReferralDeeplinkRequested.f99248a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$onEvent$5(this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, DashboardViewEvent.OnWeeklyInsightsDialogClosed.f99253a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DashboardViewModel$onEvent$6(this, null), 3, null);
        }
    }
}
