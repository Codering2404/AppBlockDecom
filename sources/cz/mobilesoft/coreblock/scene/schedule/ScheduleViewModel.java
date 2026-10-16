package cz.mobilesoft.coreblock.scene.schedule;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.repository.SubAppRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.AppBlockingSetting;
import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockType;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase;
import cz.mobilesoft.coreblock.service.receiver.PowerConnectionReceiver;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase;
import cz.mobilesoft.coreblock.util.AdultContentDownloadWorker;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ScheduleViewModel extends BaseStatefulViewModel<ScheduleViewState, ScheduleViewEvent, ScheduleViewCommand> {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private final Lazy J;
    private final Lazy K;
    private final Lazy L;
    private final Lazy M;
    private ScheduleDTO N;
    private List O;
    private boolean P;
    private ItemsDTO Q;
    private boolean R;
    private boolean S;
    private final MutableStateFlow T;
    private final MutableStateFlow U;
    private final MutableStateFlow V;
    private Job W;
    private Job X;
    private PowerConnectionReceiver Y;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ScheduleDescriptor f114589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f114590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final InitApplicationsUseCase f114591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final PremiumRepositoryV2 f114592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f114593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f114594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f114595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f114596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f114597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f114598x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f114599y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f114600z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$1", f = "ScheduleViewModel.kt", l = {258, 259}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f114601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f114602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f114603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f114604d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f114605f;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ScheduleViewState q(GraphData graphData, ScheduleViewState scheduleViewState) {
            return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, null, graphData, null, null, false, null, null, null, 130047, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ScheduleViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x00cf, code lost:
        
            if (r2 == r1) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114608a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f114608a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleViewModel(Application application, ScheduleDescriptor scheduleDescriptor, boolean z2, InitApplicationsUseCase initApplicationsUseCase, PremiumRepositoryV2 premiumRepository) {
        super(application, new ScheduleViewState(null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, scheduleDescriptor, premiumRepository.J(), 32767, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(scheduleDescriptor, "scheduleDescriptor");
        Intrinsics.checkNotNullParameter(initApplicationsUseCase, "initApplicationsUseCase");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f114589o = scheduleDescriptor;
        this.f114590p = z2;
        this.f114591q = initApplicationsUseCase;
        this.f114592r = premiumRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f114593s = LazyKt.a(lazyThreadSafetyModeB, new Function0<GetProfileRuntimeStateUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetProfileRuntimeStateUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f114594t = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f114595u = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f114596v = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f114597w = LazyKt.a(lazyThreadSafetyModeB5, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f114598x = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f114599y = LazyKt.a(lazyThreadSafetyModeB7, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f114600z = LazyKt.a(lazyThreadSafetyModeB8, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB9, new Function0<SubAppRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRepository.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB10, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB11, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB12, new Function0<SubAppRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRelationDao.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB13, new Function0<QuickBlockTimerHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockTimerHistoryDao.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB14, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        this.G = LazyKt.a(lazyThreadSafetyModeB15, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAppDataUseCase.class), objArr28, objArr29);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB16 = koinPlatformTools.b();
        final Object[] objArr30 = 0 == true ? 1 : 0;
        final Object[] objArr31 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB16, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr30, objArr31);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB17 = koinPlatformTools.b();
        final Object[] objArr32 = 0 == true ? 1 : 0;
        final Object[] objArr33 = 0 == true ? 1 : 0;
        this.I = LazyKt.a(lazyThreadSafetyModeB17, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr32, objArr33);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB18 = koinPlatformTools.b();
        final Object[] objArr34 = 0 == true ? 1 : 0;
        final Object[] objArr35 = 0 == true ? 1 : 0;
        this.J = LazyKt.a(lazyThreadSafetyModeB18, new Function0<WillBeContinuousUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WillBeContinuousUseCase.class), objArr34, objArr35);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB19 = koinPlatformTools.b();
        final Object[] objArr36 = 0 == true ? 1 : 0;
        final Object[] objArr37 = 0 == true ? 1 : 0;
        this.K = LazyKt.a(lazyThreadSafetyModeB19, new Function0<SchedulingConflictUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SchedulingConflictUseCase.class), objArr36, objArr37);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB20 = koinPlatformTools.b();
        final Object[] objArr38 = 0 == true ? 1 : 0;
        final Object[] objArr39 = 0 == true ? 1 : 0;
        this.L = LazyKt.a(lazyThreadSafetyModeB20, new Function0<FetchGraphDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$special$$inlined$inject$default$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchGraphDataUseCase.class), objArr38, objArr39);
            }
        });
        this.M = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.t2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(ScheduleViewModel.M2(this.f117949a));
            }
        });
        this.N = new ScheduleDTO(null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870911, null);
        this.O = CollectionsKt.emptyList();
        this.Q = new ItemsDTO(null, null, null, 7, null);
        this.T = StateFlowKt.a(new ScheduleDTO(null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870911, null));
        this.U = StateFlowKt.a(new BaseSelectionViewModel.ApplicationWebsiteSelectDTO(null, null, null, null, null, false, null, null, false, false, false, false, false, null, null, null, null, null, null, null, false, false, 4194302, null));
        this.V = StateFlowKt.a(new LockState(false, false, null, null, 15, null));
        this.Y = new PowerConnectionReceiver();
        if (scheduleDescriptor instanceof ScheduleDescriptor.NewSchedule) {
            AnswersHelper.f128199a.I4(null);
            z3(((ScheduleDescriptor.NewSchedule) scheduleDescriptor).d(), ((ScheduleDescriptor.NewSchedule) scheduleDescriptor).e(), ((ScheduleDescriptor.NewSchedule) scheduleDescriptor).c());
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.ScheduleContainer) {
            AnswersHelper.f128199a.V4(((ScheduleDescriptor.ScheduleContainer) scheduleDescriptor).c());
            w3(((ScheduleDescriptor.ScheduleContainer) scheduleDescriptor).d());
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.ScheduleId) {
            AnswersHelper.f128199a.W4(((ScheduleDescriptor.ScheduleId) scheduleDescriptor).c(), ((ScheduleDescriptor.ScheduleId) scheduleDescriptor).d());
            y3(((ScheduleDescriptor.ScheduleId) scheduleDescriptor).c());
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.QuickBlock) {
            A3(((ScheduleDescriptor.QuickBlock) scheduleDescriptor).e());
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.QuickBlockOnboarding) {
            B3();
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.CombinationOnboardingV2) {
            z3(null, null, ((ScheduleDescriptor.CombinationOnboardingV2) scheduleDescriptor).c());
        } else {
            if (!(scheduleDescriptor instanceof ScheduleDescriptor.ScheduleTemplateDescriptor)) {
                throw new NoWhenBranchMatchedException();
            }
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            ScheduleTemplate scheduleTemplateC = ((ScheduleDescriptor.ScheduleTemplateDescriptor) scheduleDescriptor).c();
            answersHelper.I4(scheduleTemplateC != null ? scheduleTemplateC.getAnalyticsKey() : null);
            ScheduleTemplate scheduleTemplateC2 = ((ScheduleDescriptor.ScheduleTemplateDescriptor) scheduleDescriptor).c();
            C3(scheduleTemplateC2 == null ? ScheduleTemplate.Focus : scheduleTemplateC2);
        }
        G0(new AnonymousClass1(null));
        Context contextA0 = A0();
        PowerConnectionReceiver powerConnectionReceiver = this.Y;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        Unit unit = Unit.f139807a;
        contextA0.registerReceiver(powerConnectionReceiver, intentFilter);
        FlowExtKt.l(b3().Q0(), C0(), new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.3
            public final Object a(long j3, Continuation continuation) {
                if (ScheduleViewModel.this.f114589o instanceof ScheduleDescriptor.ScheduleId) {
                    ScheduleViewModel.this.v4();
                }
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
    }

    private final void A3(boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$initScheduleForQuickBlock$1(this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A4() {
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.B4((ScheduleDTO) obj);
            }
        });
    }

    private final void B3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$initScheduleForQuickBlockOnboarding$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO B4(ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 528482303, null);
    }

    private final void C3(ScheduleTemplate scheduleTemplate) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$initScheduleWithTemplate$1(scheduleTemplate, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C4(final ConditionDTO.UsageLimitDTO usageLimitDTO) {
        ConditionDTO.TimeDTO timeDTOI = usageLimitDTO.i();
        if (timeDTOI != null) {
            L4(timeDTOI);
        }
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.r2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.D4(usageLimitDTO, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D3(cz.mobilesoft.coreblock.enums.ProfileType r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            cz.mobilesoft.coreblock.enums.ProfileType r6 = cz.mobilesoft.coreblock.enums.ProfileType.USAGE_LIMIT
            if (r5 == r6) goto L8
            cz.mobilesoft.coreblock.enums.ProfileType r6 = cz.mobilesoft.coreblock.enums.ProfileType.LAUNCH_COUNT
            if (r5 != r6) goto L3f
        L8:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r6 = r4.N
            int r6 = r6.z()
            boolean r5 = r5.isSetTo(r6)
            if (r5 == 0) goto L3f
            cz.mobilesoft.coreblock.repository.StrictModeRepository r5 = r4.t0()
            boolean r5 = r5.n()
            if (r5 == 0) goto L3f
            cz.mobilesoft.coreblock.scene.schedule.detail.LockState r5 = r4.Q2()
            java.lang.Long r5 = r5.d()
            r6 = 0
            if (r5 == 0) goto L34
            long r0 = r5.longValue()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L34
            goto L35
        L34:
            r5 = r6
        L35:
            if (r5 != 0) goto L3f
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor r5 = r4.f114589o
            boolean r5 = r5 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor.ScheduleTemplateDescriptor
            if (r5 != 0) goto L3f
            r5 = 1
            goto L40
        L3f:
            r5 = 0
        L40:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.D3(cz.mobilesoft.coreblock.enums.ProfileType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO D4(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.UsageLimitDTO r35, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r36) {
        /*
            java.lang.String r0 = "$this$updateSchedule"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            cz.mobilesoft.coreblock.enums.ProfileType r0 = r35.a()
            int r2 = r1.z()
            int r10 = r0.setTo(r2)
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO r0 = r1.A()
            if (r0 == 0) goto L35
            long r2 = r0.j()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r0 = r0.g()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r3 = r35.g()
            if (r0 != r3) goto L2c
            goto L2d
        L2c:
            r2 = 0
        L2d:
            if (r2 == 0) goto L35
            long r2 = r2.longValue()
        L33:
            r15 = r2
            goto L38
        L35:
            r2 = 0
            goto L33
        L38:
            r19 = 27
            r20 = 0
            r12 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r11 = r35
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO r14 = cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.UsageLimitDTO.d(r11, r12, r14, r15, r17, r18, r19, r20)
            r33 = 536866559(0x1fffeeff, float:1.08392087E-19)
            r34 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r0 = cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31, r32, r33, r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.D4(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO):cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E3() {
        QuickBlockProfileDTO quickBlockProfileDTOQ = j3().q();
        return quickBlockProfileDTOQ != null && quickBlockProfileDTOQ.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E4(final ConditionDTO.WifisDTO wifisDTO) {
        ConditionDTO.TimeDTO timeDTOE = wifisDTO.e();
        if (timeDTOE != null) {
            L4(timeDTOE);
        }
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.p2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.F4(wifisDTO, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean F3() {
        /*
            r8 = this;
            cz.mobilesoft.coreblock.scene.schedule.detail.LockState r0 = r8.Q2()
            boolean r1 = r0.f()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L23
            java.lang.Long r0 = r0.d()
            r1 = 0
            if (r0 == 0) goto L1e
            long r4 = r0.longValue()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L1e
            goto L1f
        L1e:
            r0 = r1
        L1f:
            if (r0 != 0) goto L23
            r0 = r3
            goto L24
        L23:
            r0 = r2
        L24:
            cz.mobilesoft.coreblock.base.ViewState r1 = r8.I0()
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r1 = (cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) r1
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState r1 = r1.g()
            boolean r1 = r1.E()
            if (r1 == 0) goto L3e
            if (r0 == 0) goto L3d
            boolean r0 = r8.E3()
            if (r0 == 0) goto L3d
            return r3
        L3d:
            return r2
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.F3():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO F4(ConditionDTO.WifisDTO wifisDTO, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, wifisDTO.a().setTo(updateSchedule.z()), null, null, null, null, null, null, wifisDTO, null, null, null, null, null, true, false, false, 0L, 0L, null, false, null, 534740735, null);
    }

    private final void G3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$observePowerConnectionEvent$1(this, null), 3, null);
    }

    private final void G4(ScheduleDTO scheduleDTO) {
        n4((!scheduleDTO.e().isEmpty() || scheduleDTO.C().isEmpty()) ? TabItem.Apps : TabItem.Webs, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.n2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScheduleViewModel.H4(this.f117305a);
            }
        });
    }

    private final void H3() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onActivityCreated$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H4(ScheduleViewModel scheduleViewModel) {
        scheduleViewModel.G0(new ScheduleViewModel$openBlocklistInternal$1$1(scheduleViewModel, null));
        return Unit.f139807a;
    }

    private final void I3() {
        if (((ScheduleViewState) I0()).g().y()) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onAddConditionClicked$1(this, null), 3, null);
        } else {
            l4();
        }
    }

    private final boolean I4(ScheduleViewCommand scheduleViewCommand) {
        return scheduleViewCommand != null;
    }

    private final void J3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onAdultContentTurnOnClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J4(final ProfileType profileType, final boolean z2) {
        final ScheduleDTO scheduleDTOR2 = R2();
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.K4(profileType, z2, this, scheduleDTOR2, (ScheduleDTO) obj);
            }
        });
    }

    private final void K3(AppBlockingSetting appBlockingSetting, boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onAppBlockingSettingCheckedChanged$1(appBlockingSetting, this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO K4(ProfileType profileType, boolean z2, ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        int iClearFrom = profileType.clearFrom(updateSchedule.z());
        boolean zH = updateSchedule.H();
        if (z2) {
            zH = false;
        } else {
            ScheduleViewState scheduleViewState = (ScheduleViewState) scheduleViewModel.I0();
            int i3 = WhenMappings.f114608a[profileType.ordinal()];
            AnswersHelper.f128199a.O4(i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? null : scheduleDTO.D() : scheduleDTO.r() : scheduleDTO.x() : scheduleDTO.A() : scheduleDTO.q(), profileType, scheduleViewState.g().D(), scheduleViewModel.R2().o());
        }
        boolean z3 = zH;
        int i4 = WhenMappings.f114608a[profileType.ordinal()];
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? updateSchedule : ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, iClearFrom, null, null, null, null, null, null, null, null, null, null, null, null, z3, false, false, 0L, 0L, null, false, null, 534740735, null) : ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, iClearFrom, null, null, null, null, null, null, null, null, null, null, null, null, z3, false, false, 0L, 0L, null, false, null, 534771455, null) : ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, iClearFrom, null, null, null, null, null, null, null, null, null, null, null, null, z3, false, false, 0L, 0L, null, false, null, 534757119, null) : ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, iClearFrom, null, null, null, null, null, null, null, null, null, null, null, null, z3, false, false, 0L, 0L, null, false, null, 534769407, null) : ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, iClearFrom, null, null, null, null, null, null, null, null, null, null, null, null, z3, false, false, 0L, 0L, null, false, null, 534765311, null);
    }

    private final void L3(List list, List list2, List list3, boolean z2, List list4) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onApplicationsWebsitesSelected$1(z2, this, list, list4, list2, list3, null), 3, null);
    }

    private final void L4(final ConditionDTO.TimeDTO timeDTO) {
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.M4(timeDTO, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long M2(ScheduleViewModel scheduleViewModel) {
        return scheduleViewModel.A0().getResources().getInteger(R.integer.config_longAnimTime);
    }

    private final void M3(Profile.BlockingMode blockingMode) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onBlockingModeSelected$1(this, blockingMode, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO M4(ConditionDTO.TimeDTO timeDTO, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, timeDTO.a().mask(), null, null, null, null, null, timeDTO, null, null, null, null, null, null, true, false, false, 0L, 0L, null, false, null, 534757119, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (P0(r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object N2(cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$checkAndRequestedPermissionsBeforeClosing$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$checkAndRequestedPermissionsBeforeClosing$1 r0 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$checkAndRequestedPermissionsBeforeClosing$1) r0
            int r1 = r0.f114613f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f114613f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$checkAndRequestedPermissionsBeforeClosing$1 r0 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$checkAndRequestedPermissionsBeforeClosing$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f114611c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f114613f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r7 = r0.f114610b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r7 = r0.f114609a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand r7 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand) r7
            kotlin.ResultKt.b(r8)
            goto L85
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.f114609a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand r7 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand) r7
            kotlin.ResultKt.b(r8)
            goto L5e
        L45:
            kotlin.ResultKt.b(r8)
            boolean r8 = r6.I4(r7)
            if (r8 != 0) goto L8f
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f114609a = r8
            r0.f114613f = r5
            r8 = 0
            java.lang.Object r8 = a3(r6, r8, r0, r5, r8)
            if (r8 != r1) goto L5e
            goto L84
        L5e:
            java.util.List r8 = (java.util.List) r8
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L8a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowPermissionActivity r2 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowPermissionActivity
            cz.mobilesoft.coreblock.scene.schedule.PermissionRequestReason r3 = cz.mobilesoft.coreblock.scene.schedule.PermissionRequestReason.Saving
            r2.<init>(r8, r3)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f114609a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f114610b = r7
            r0.f114613f = r4
            java.lang.Object r7 = r6.P0(r2, r0)
            if (r7 != r1) goto L85
        L84:
            return r1
        L85:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r7
        L8a:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        L8f:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.N2(cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void N3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onBlockingModeSettingsClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (P0(r7, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        if (r7.o(r2, true, r0) != r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object N4(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$showSelectionWithLoading$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$showSelectionWithLoading$1 r0 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$showSelectionWithLoading$1) r0
            int r1 = r0.f114953c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f114953c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$showSelectionWithLoading$1 r0 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$showSelectionWithLoading$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f114951a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f114953c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            goto L7e
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            kotlin.ResultKt.b(r7)
            goto L6f
        L3b:
            kotlin.ResultKt.b(r7)
            goto L59
        L3f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.base.ViewState r7 = r6.I0()
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r7 = (cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState) r7
            boolean r7 = r7.n()
            if (r7 == 0) goto L5c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowApplicationSelection r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand.ShowApplicationSelection.f114512a
            r0.f114953c = r5
            java.lang.Object r7 = r6.P0(r7, r0)
            if (r7 != r1) goto L59
            goto L7d
        L59:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L5c:
            cz.mobilesoft.coreblock.scene.schedule.v2 r7 = new cz.mobilesoft.coreblock.scene.schedule.v2
            r7.<init>()
            r6.Q0(r7)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowApplicationSelection r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand.ShowApplicationSelection.f114512a
            r0.f114953c = r4
            java.lang.Object r7 = r6.P0(r7, r0)
            if (r7 != r1) goto L6f
            goto L7d
        L6f:
            cz.mobilesoft.coreblock.repository.ApplicationRepository r7 = cz.mobilesoft.coreblock.repository.ApplicationRepository.f97454a
            android.content.Context r2 = r6.A0()
            r0.f114953c = r3
            java.lang.Object r7 = r7.o(r2, r5, r0)
            if (r7 != r1) goto L7e
        L7d:
            return r1
        L7e:
            cz.mobilesoft.coreblock.scene.schedule.w2 r7 = new cz.mobilesoft.coreblock.scene.schedule.w2
            r7.<init>()
            r6.Q0(r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.N4(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d3, code lost:
    
        if (P0(r2, r0) == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O2(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.O2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void O3() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onBlockingModeSettingsClosed$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState O4(ScheduleViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ScheduleViewState.b(updateState, null, null, false, null, false, true, false, true, null, null, null, null, null, false, null, null, null, 130911, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object P2(Continuation continuation) {
        ScheduleDTO scheduleDTOR2 = R2();
        if (scheduleDTOR2.J()) {
            G4(scheduleDTOR2);
            return Unit.f139807a;
        }
        Object objP0 = P0(ScheduleViewCommand.ShowScheduleDetail.f114530a, continuation);
        return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
    }

    private final void P3() {
        ScheduleViewState scheduleViewState = (ScheduleViewState) I0();
        if (scheduleViewState.e() == ScheduleViewState.DetailBottomSheetType.AdultContentBottomSheet && (scheduleViewState.c().d() instanceof Loading)) {
            AnswersHelper.f128199a.S(R2().o());
            AdultContentDownloadWorker.f127702i.b(A0());
            T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.a3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleViewModel.Q3((ScheduleDTO) obj);
                }
            });
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.b3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.R3((ScheduleViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState P4(ScheduleViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ScheduleViewState.b(updateState, null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131039, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LockState Q2() {
        LockState lockState;
        synchronized (this.V) {
            lockState = (LockState) this.V.getValue();
        }
        return lockState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO Q3(ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870895, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q4(LockType lockType, boolean z2) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$startLockSetup$1(lockType, this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduleDTO R2() {
        ScheduleDTO scheduleDTO;
        synchronized (this.T) {
            scheduleDTO = (ScheduleDTO) this.T.getValue();
        }
        return scheduleDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState R3(ScheduleViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ScheduleViewState.b(updateState, null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131067, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R4(long j3, String str) {
        Job job = this.X;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.X = BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$startSummaryTicker$1(j3, this, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S2(java.util.List r8, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$filterProfilesToCopy$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$filterProfilesToCopy$1 r0 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$filterProfilesToCopy$1) r0
            int r1 = r0.f114623f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f114623f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$filterProfilesToCopy$1 r0 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$filterProfilesToCopy$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f114621c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f114623f
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r8 = r0.f114620b
            r9 = r8
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r9 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) r9
            java.lang.Object r8 = r0.f114619a
            java.util.List r8 = (java.util.List) r8
            kotlin.ResultKt.b(r10)
            goto L52
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r10 = r7.i3()
            kotlinx.coroutines.flow.Flow r10 = r10.B()
            r0.f114619a = r8
            r0.f114620b = r9
            r0.f114623f = r3
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L63:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto Lab
            java.lang.Object r1 = r8.next()
            r2 = r1
            cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r2 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r2
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r3 = r2.p()
            long r3 = r3.r()
            java.lang.Long r5 = r9.o()
            if (r5 != 0) goto L7f
            goto L87
        L7f:
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L63
        L87:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r3 = r2.p()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r3 = r3.o()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r4 = r9.k()
            if (r3 != r4) goto L63
            boolean r3 = r2.b()
            if (r3 == 0) goto L63
            if (r10 != 0) goto La7
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r2 = r2.p()
            boolean r2 = r2.R()
            if (r2 != 0) goto L63
        La7:
            r0.add(r1)
            goto L63
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.S2(java.util.List, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void S3(boolean z2) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onCloseClicked$1(this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S4(Function1 function1) {
        synchronized (this.V) {
            MutableStateFlow mutableStateFlow = this.V;
            mutableStateFlow.setValue(function1.invoke(mutableStateFlow.getValue()));
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T2() {
        return ((Number) this.M.getValue()).longValue();
    }

    private final void T3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onConditionSelectClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T4(Function1 function1) {
        synchronized (this.T) {
            MutableStateFlow mutableStateFlow = this.T;
            mutableStateFlow.setValue(function1.invoke(mutableStateFlow.getValue()));
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao U2() {
        return (ApplicationDao) this.f114596v.getValue();
    }

    private final void U3(ProfileType profileType) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onConditionSelected$1(this, profileType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01ae, code lost:
    
        if (P0(r6, r3) == r4) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object U4(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r22, int r23, cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.TimeDTO r24, boolean r25, boolean r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.U4(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, int, cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$TimeDTO, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao V2() {
        return (ApplicationDao) this.C.getValue();
    }

    private final void V3(ConditionDTO conditionDTO, boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onConditionSet$1(this, conditionDTO, z2, null), 3, null);
    }

    static /* synthetic */ Object V4(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO, int i3, ConditionDTO.TimeDTO timeDTO, boolean z2, boolean z3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i4 & 16) != 0) {
            z3 = true;
        }
        return scheduleViewModel.U4(scheduleDTO, i3, timeDTO, z4, z3, continuation);
    }

    static /* synthetic */ void W3(ScheduleViewModel scheduleViewModel, ConditionDTO conditionDTO, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        scheduleViewModel.V3(conditionDTO, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W4(ConditionDTO conditionDTO, Continuation continuation) {
        ScheduleDTO scheduleDTOR2 = R2();
        ConditionDTO.TimeDTO timeDTOB = conditionDTO.b();
        int iZ = scheduleDTOR2.z() & ProfileType.STRICT_MODE.mask();
        if (conditionDTO instanceof ConditionDTO.CombinationDTO) {
            Iterator it = ((ConditionDTO.CombinationDTO) conditionDTO).c().iterator();
            while (it.hasNext()) {
                iZ = ((ConditionDTO) it.next()).a().setTo(iZ);
            }
        } else {
            iZ = conditionDTO.a().setTo(iZ);
        }
        if (timeDTOB != null) {
            iZ = ProfileType.TIME.setTo(iZ);
        }
        return V4(this, scheduleDTOR2, iZ, timeDTOB, false, false, continuation, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper X2() {
        return (ConsentHelper) this.H.getValue();
    }

    private final void X3() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onEmojiEditClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X4(ProfileType profileType, Continuation continuation) {
        ScheduleDTO scheduleDTOR2 = R2();
        int iClearFrom = profileType.clearFrom(scheduleDTOR2.z());
        ConditionDTO.TimeDTO timeDTOX = scheduleDTOR2.x();
        return V4(this, scheduleDTOR2, iClearFrom, (timeDTOX == null || !ProfileType.TIME.isSetTo(iClearFrom)) ? null : timeDTOX, false, false, continuation, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore Y2() {
        return (CoreDataStore) this.f114598x.getValue();
    }

    private final void Y3(final ScheduleEmoji scheduleEmoji) {
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.o2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.Z3(scheduleEmoji, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z2(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.Z2(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO Z3(ScheduleEmoji scheduleEmoji, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, scheduleEmoji, false, null, 469762047, null);
    }

    static /* synthetic */ Object a3(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            scheduleDTO = scheduleViewModel.R2();
        }
        return scheduleViewModel.Z2(scheduleDTO, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore b3() {
        return (EventDataStore) this.f114599y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b4(ScheduleViewModel scheduleViewModel) {
        scheduleViewModel.G0(new ScheduleViewModel$onEvent$2$1(scheduleViewModel, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchAppDataUseCase c3() {
        return (FetchAppDataUseCase) this.G.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO c4(ScheduleViewEvent scheduleViewEvent, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, 0, null, ((ScheduleViewEvent.OnWebBrowsingModeChanged) scheduleViewEvent).a(), null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536869887, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchGraphDataUseCase d3() {
        return (FetchGraphDataUseCase) this.L.getValue();
    }

    private final void d4(ExtraOption extraOption) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onExtraOptionClicked$1(this, extraOption, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetProfileRuntimeStateUseCase e3() {
        return (GetProfileRuntimeStateUseCase) this.f114593s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e4(final ConditionDTO.LaunchCountDTO launchCountDTO) {
        ConditionDTO.TimeDTO timeDTOI = launchCountDTO.i();
        if (timeDTOI != null) {
            L4(timeDTOI);
        }
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.m2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.f4(launchCountDTO, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao f3() {
        return (IgnoredStatisticsItemDao) this.F.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO f4(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.LaunchCountDTO r35, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r36) {
        /*
            java.lang.String r0 = "$this$updateSchedule"
            r1 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            cz.mobilesoft.coreblock.enums.ProfileType r0 = r35.a()
            int r2 = r1.z()
            int r10 = r0.setTo(r2)
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO r0 = r1.q()
            if (r0 == 0) goto L35
            long r2 = r0.j()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r0 = r0.g()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r3 = r35.g()
            if (r0 != r3) goto L2c
            goto L2d
        L2c:
            r2 = 0
        L2d:
            if (r2 == 0) goto L35
            long r2 = r2.longValue()
        L33:
            r15 = r2
            goto L38
        L35:
            r2 = 0
            goto L33
        L38:
            r19 = 27
            r20 = 0
            r12 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r11 = r35
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO r15 = cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.LaunchCountDTO.d(r11, r12, r14, r15, r17, r18, r19, r20)
            r33 = 536862463(0x1fffdeff, float:1.0836562E-19)
            r34 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r0 = cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r31, r32, r33, r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.f4(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LaunchCountDTO, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO):cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore g3() {
        return (CoreMultiProcessDataStore) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g4(final ConditionDTO.LocationDTO locationDTO) {
        ConditionDTO.TimeDTO timeDTOF = locationDTO.f();
        if (timeDTOF != null) {
            L4(timeDTOF);
        }
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.s2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.h4(locationDTO, (ScheduleDTO) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao h3() {
        return (ProfileDao) this.f114597w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO h4(ConditionDTO.LocationDTO locationDTO, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, locationDTO.a().setTo(updateSchedule.z()), null, null, locationDTO, null, null, null, null, null, null, null, null, null, true, false, false, 0L, 0L, null, false, null, 534771455, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockDataStore i3() {
        return (QuickBlockDataStore) this.f114595u.getValue();
    }

    private final void i4(LockType lockType) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onLockTypeClicked$1(this, lockType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository j3() {
        return (QuickBlockRepository) this.f114600z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j4(final Long l3, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            PrefManager.f126839a.E2(false);
        }
        if (l3 != null) {
            s3(l3.longValue());
        }
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.k4(l3, (ScheduleDTO) obj);
            }
        });
        u4(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockTimerHistoryDao k3() {
        return (QuickBlockTimerHistoryDao) this.E.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO k4(Long l3, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, l3 == null, l3 != null ? l3.longValue() : 0L, 0L, null, false, null, 511705087, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l4() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onLockedActionClicked$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SchedulingConflictUseCase m3() {
        return (SchedulingConflictUseCase) this.K.getValue();
    }

    private final void m4(PermissionRequestReason permissionRequestReason, boolean z2) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onMissingPermissionsChanged$1(permissionRequestReason, this, z2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore n3() {
        return (StrictModeDataStore) this.f114594t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n4(TabItem tabItem, Function0 function0) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onOpenBlocklistRequested$2(this, tabItem, function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubAppRelationDao o3() {
        return (SubAppRelationDao) this.D.getValue();
    }

    static /* synthetic */ void o4(ScheduleViewModel scheduleViewModel, TabItem tabItem, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.z2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleViewModel.p4();
                }
            };
        }
        scheduleViewModel.n4(tabItem, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubAppRepository p3() {
        return (SubAppRepository) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p4() {
        return Unit.f139807a;
    }

    public static final /* synthetic */ ScheduleViewState q1(ScheduleViewModel scheduleViewModel) {
        return (ScheduleViewState) scheduleViewModel.I0();
    }

    private final WillBeContinuousUseCase q3() {
        return (WillBeContinuousUseCase) this.J.getValue();
    }

    private final void q4() {
        PrefManager.f126839a.x2(false);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.l2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.r4((ScheduleViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3(long j3) {
        long jF = j3 - TimeHelperExt.f128663a.f();
        if (jF > 0) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$handlePossibleFutureStrictModeLock$1(jF, this, j3, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState r4(ScheduleViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ScheduleViewState.b(updateState, ScheduleViewState.DetailViewState.b(updateState.g(), null, null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 62914559, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s3(long j3) {
        TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
        if (j3 <= timeHelperExt.f()) {
            return;
        }
        Job job = this.W;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.W = FlowKt.Q(FlowKt.V(FlowKt.g(timeHelperExt.a(j3, 500L)), new ScheduleViewModel$handleRemainingLockTimer$1(this, null)), B0());
    }

    private final void s4(ProfileType profileType) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onRemoveConditionClicked$1(this, profileType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.I.getValue();
    }

    private final void t3(Long l3, Long l4) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$init$1(this, l3, l4, null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$init$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$init$3(this, null), 3, null);
        G3();
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$init$4(this, null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$init$5(this, null), 3, null);
    }

    private final void t4(boolean z2) {
        if (z2 || !((ScheduleViewState) I0()).g().D() || ((ScheduleViewState) I0()).f().isEmpty()) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onSaveClicked$2(this, null), 3, null);
        } else {
            G0(new ScheduleViewModel$onSaveClicked$1(this, null));
        }
    }

    static /* synthetic */ void u3(ScheduleViewModel scheduleViewModel, Long l3, Long l4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        if ((i3 & 2) != 0) {
            l4 = null;
        }
        scheduleViewModel.t3(l3, l4);
    }

    static /* synthetic */ void u4(ScheduleViewModel scheduleViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        scheduleViewModel.t4(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v3(kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initAllowlist$1
            if (r2 == 0) goto L17
            r2 = r1
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initAllowlist$1 r2 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initAllowlist$1) r2
            int r3 = r2.f114667d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f114667d = r3
            goto L1c
        L17:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initAllowlist$1 r2 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initAllowlist$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.f114665b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.f114667d
            r5 = 1
            if (r4 == 0) goto L39
            if (r4 != r5) goto L31
            java.lang.Object r2 = r2.f114664a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r2 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel) r2
            kotlin.ResultKt.b(r1)
            goto L5f
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            kotlin.ResultKt.b(r1)
            cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase r1 = r0.f114591q
            cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase$Params r6 = new cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase$Params
            r15 = 179(0xb3, float:2.51E-43)
            r16 = 0
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlinx.coroutines.flow.Flow r1 = r1.c(r6)
            r2.f114664a = r0
            r2.f114667d = r5
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r2)
            if (r1 != r3) goto L5e
            return r3
        L5e:
            r2 = r0
        L5f:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L6a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L81
            java.lang.Object r4 = r1.next()
            r5 = r4
            cz.mobilesoft.coreblock.dto.ApplicationDTO r5 = (cz.mobilesoft.coreblock.dto.ApplicationDTO) r5
            boolean r5 = r5.h()
            if (r5 == 0) goto L6a
            r3.add(r4)
            goto L6a
        L81:
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
            r1.<init>(r4)
            int r4 = r3.size()
            r5 = 0
        L91:
            if (r5 >= r4) goto Lb0
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            cz.mobilesoft.coreblock.dto.ApplicationDTO r6 = (cz.mobilesoft.coreblock.dto.ApplicationDTO) r6
            cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO r7 = new cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO
            java.lang.String r8 = r6.f()
            java.lang.String r9 = r6.d()
            java.util.List r6 = r6.c()
            r7.<init>(r8, r9, r6)
            r1.add(r7)
            goto L91
        Lb0:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r1)
            cz.mobilesoft.coreblock.scene.schedule.ItemsDTO r10 = new cz.mobilesoft.coreblock.scene.schedule.ItemsDTO
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            r10.<init>(r11, r12, r13, r14, r15)
            r2.Q = r10
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.v3(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v4() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onScheduleChangedInDB$1(this, null), 3, null);
    }

    private final void w3(ScheduleDTO scheduleDTO) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$initScheduleForDuplicate$1(this, scheduleDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w4() {
        G0(new ScheduleViewModel$onSummaryRequested$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x3(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r37, kotlin.coroutines.Continuation r38) throws java.lang.Throwable {
        /*
            r36 = this;
            r0 = r36
            r1 = r38
            boolean r2 = r1 instanceof cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$2
            if (r2 == 0) goto L17
            r2 = r1
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$2 r2 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$2) r2
            int r3 = r2.f114681d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f114681d = r3
            goto L1c
        L17:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$2 r2 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$2
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.f114679b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.f114681d
            r5 = 1
            if (r4 == 0) goto L39
            if (r4 != r5) goto L31
            java.lang.Object r2 = r2.f114678a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r2 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r2
            kotlin.ResultKt.b(r1)
            goto L4f
        L31:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L39:
            kotlin.ResultKt.b(r1)
            cz.mobilesoft.coreblock.repository.ScheduleRepository r1 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r37)
            r2.f114678a = r4
            r2.f114681d = r5
            r4 = r37
            java.lang.Object r1 = r1.T(r4, r2)
            if (r1 != r3) goto L4f
            return r3
        L4f:
            r2 = r1
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r2 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO) r2
            r0.N = r2
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r1 = r0.f114592r
            cz.mobilesoft.coreblock.enums.PremiumState r1 = r1.J()
            java.util.List r1 = cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.x(r2, r1)
            r0.O = r1
            r34 = 536870911(0x1fffffff, float:1.0842021E-19)
            r35 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO.b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r33, r34, r35)
            kotlinx.coroutines.flow.MutableStateFlow r3 = r0.T
            r3.setValue(r1)
            long r3 = r2.s()
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.e(r3)
            long r3 = r2.t()
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.e(r3)
            r0.t3(r1, r3)
            kotlinx.coroutines.CoroutineScope r4 = r0.C0()
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$3 r7 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$3
            r1 = 0
            r7.<init>(r0, r2, r1)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.BuildersKt.d(r4, r5, r6, r7, r8, r9)
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.x3(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x4(ConditionDTO.TimeDTO timeDTO) {
        L4(timeDTO);
    }

    private final void y3(long j3) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$initScheduleForEdit$1(this, j3, null), 3, null);
    }

    private final void y4(final String str) {
        T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleViewModel.z4(str, (ScheduleDTO) obj);
            }
        });
    }

    private final void z3(List list, List list2, ConditionDTO conditionDTO) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$initScheduleForNew$1(list, list2, this, conditionDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO z4(String str, ScheduleDTO updateSchedule) {
        Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
        return ScheduleDTO.b(updateSchedule, null, str, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870909, null);
    }

    public final Flow W2() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: a4, reason: merged with bridge method [inline-methods] */
    public void O0(final ScheduleViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ScheduleViewEvent.OnCloseClicked) {
            S3(((ScheduleViewEvent.OnCloseClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnConflictingSchedulesClicked.f114560a)) {
            G0(new ScheduleViewModel$onEvent$1(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnScheduleChangedInDB.f114578a)) {
            v4();
            return;
        }
        if (event instanceof ScheduleViewEvent.OnTitleChanged) {
            y4(((ScheduleViewEvent.OnTitleChanged) event).a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnBlockingCardClicked) {
            n4(((ScheduleViewEvent.OnBlockingCardClicked) event).a(), new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.x2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleViewModel.b4(this.f118035a);
                }
            });
            return;
        }
        if (event instanceof ScheduleViewEvent.OnApplicationsWebsitesSelected) {
            ScheduleViewEvent.OnApplicationsWebsitesSelected onApplicationsWebsitesSelected = (ScheduleViewEvent.OnApplicationsWebsitesSelected) event;
            L3(onApplicationsWebsitesSelected.a(), onApplicationsWebsitesSelected.e(), onApplicationsWebsitesSelected.d(), onApplicationsWebsitesSelected.c(), onApplicationsWebsitesSelected.b());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnMissingPermissionsChanged) {
            ScheduleViewEvent.OnMissingPermissionsChanged onMissingPermissionsChanged = (ScheduleViewEvent.OnMissingPermissionsChanged) event;
            m4(onMissingPermissionsChanged.b(), onMissingPermissionsChanged.a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnSaveButtonClicked) {
            t4(((ScheduleViewEvent.OnSaveButtonClicked) event).a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnAppBlockingSettingCheckedChanged) {
            ScheduleViewEvent.OnAppBlockingSettingCheckedChanged onAppBlockingSettingCheckedChanged = (ScheduleViewEvent.OnAppBlockingSettingCheckedChanged) event;
            K3(onAppBlockingSettingCheckedChanged.a(), onAppBlockingSettingCheckedChanged.b());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnRemoveConditionClicked) {
            s4(((ScheduleViewEvent.OnRemoveConditionClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnAddConditionClicked.f114539a)) {
            I3();
            return;
        }
        if (event instanceof ScheduleViewEvent.OnConditionSelected) {
            U3(((ScheduleViewEvent.OnConditionSelected) event).a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnConditionSet) {
            ScheduleViewEvent.OnConditionSet onConditionSet = (ScheduleViewEvent.OnConditionSet) event;
            V3(onConditionSet.a(), onConditionSet.b());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnLockTypeClicked) {
            i4(((ScheduleViewEvent.OnLockTypeClicked) event).a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnLockChargerDialogConfirmed) {
            j4(null, Boolean.valueOf(((ScheduleViewEvent.OnLockChargerDialogConfirmed) event).a()));
            return;
        }
        if (event instanceof ScheduleViewEvent.OnLockTimeSelected) {
            j4(Long.valueOf(((ScheduleViewEvent.OnLockTimeSelected) event).a()), null);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnLockUnsavedChangesDialogConfirmed) {
            Q4(((ScheduleViewEvent.OnLockUnsavedChangesDialogConfirmed) event).a(), true);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnExtraOptionClicked) {
            d4(((ScheduleViewEvent.OnExtraOptionClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnUnlocked.f114586a)) {
            A4();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.QuickBlockTileHintClosed.f114588a)) {
            q4();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnActivityCreated.f114538a)) {
            H3();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnBlockingModeSettingsClicked.f114551a)) {
            N3();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnBlockingModeSettingsClosed.f114552a)) {
            O3();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnConditionSelectClicked.f114556a)) {
            T3();
            return;
        }
        if (event instanceof ScheduleViewEvent.OnBlockingModeSelected) {
            M3(((ScheduleViewEvent.OnBlockingModeSelected) event).a());
            return;
        }
        if (event instanceof ScheduleViewEvent.OnWebBrowsingModeChanged) {
            ScheduleViewEvent.OnWebBrowsingModeChanged onWebBrowsingModeChanged = (ScheduleViewEvent.OnWebBrowsingModeChanged) event;
            if (R2().B() != onWebBrowsingModeChanged.a()) {
                T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.y2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleViewModel.c4(event, (ScheduleDTO) obj);
                    }
                });
                AnswersHelper.f128199a.K4(onWebBrowsingModeChanged.a(), R2().o());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnEmojiEditClicked.f114564a)) {
            X3();
            return;
        }
        if (event instanceof ScheduleViewEvent.OnEmojiSelected) {
            Y3(((ScheduleViewEvent.OnEmojiSelected) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnAdultContentTurnOnClicked.f114541a)) {
            J3();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnBottomSheetHidden.f114553a)) {
            P3();
            return;
        }
        if (event instanceof ScheduleViewEvent.OnSetProfileUsageLimitTime) {
            ScheduleViewEvent.OnSetProfileUsageLimitTime onSetProfileUsageLimitTime = (ScheduleViewEvent.OnSetProfileUsageLimitTime) event;
            long jB = onSetProfileUsageLimitTime.b() / 60000;
            boolean zF = this.f114592r.J().f(Product.USAGE_LIMIT);
            if (jB > Limit.USAGE_LIMIT.getLimitValue() && !zF) {
                G0(new ScheduleViewModel$onEvent$4(this, event, null));
                return;
            }
            long jB2 = onSetProfileUsageLimitTime.b();
            UsageLimit.PeriodType periodTypeA = onSetProfileUsageLimitTime.a();
            ConditionDTO.UsageLimitDTO usageLimitDTOA = R2().A();
            W3(this, new ConditionDTO.UsageLimitDTO(jB2, null, usageLimitDTOA != null ? usageLimitDTOA.j() : 0L, periodTypeA, null, 18, null), false, 2, null);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnSetProfileLaunchCount) {
            boolean zF2 = this.f114592r.J().f(Product.LAUNCH_COUNT);
            ScheduleViewEvent.OnSetProfileLaunchCount onSetProfileLaunchCount = (ScheduleViewEvent.OnSetProfileLaunchCount) event;
            if (onSetProfileLaunchCount.a() <= Limit.LAUNCH_COUNT.getLimitValue() || zF2) {
                W3(this, new ConditionDTO.LaunchCountDTO(onSetProfileLaunchCount.a(), null, 0L, onSetProfileLaunchCount.b(), null, 22, null), false, 2, null);
                return;
            } else {
                G0(new ScheduleViewModel$onEvent$5(this, event, null));
                return;
            }
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnNavigateBack.f114574a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onEvent$6(this, null), 3, null);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnCategoriesAllowed) {
            G0(new ScheduleViewModel$onEvent$7(event, this, null));
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnCopyClicked.f114561a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onEvent$8(this, null), 3, null);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnCopyProfileClicked) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new ScheduleViewModel$onEvent$9(event, this, null), 3, null);
            return;
        }
        if (event instanceof ScheduleViewEvent.OnAddToFollowSchedulesClicked) {
            G0(new ScheduleViewModel$onEvent$10(event, this, null));
            return;
        }
        if (event instanceof ScheduleViewEvent.OnDisabledConditionClick) {
            int i3 = WhenMappings.f114608a[((ScheduleViewEvent.OnDisabledConditionClick) event).a().ordinal()];
            if (i3 == 1) {
                G0(new ScheduleViewModel$onEvent$11(event, this, null));
                return;
            } else {
                if (i3 != 2) {
                    return;
                }
                G0(new ScheduleViewModel$onEvent$12(event, this, null));
                return;
            }
        }
        if (event instanceof ScheduleViewEvent.OnLockedActionClicked) {
            l4();
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnStrictModeActionBlocked.f114583a)) {
            G0(new ScheduleViewModel$onEvent$13(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, ScheduleViewEvent.OnOnboardingFinished.f114575a)) {
            G0(new ScheduleViewModel$onEvent$14(this, null));
            G0(new ScheduleViewModel$onEvent$15(this, null));
        } else {
            if (!Intrinsics.areEqual(event, ScheduleViewEvent.OnSummaryBackClicked.f114584a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ScheduleViewModel$onEvent$16(this, null), 3, null);
        }
    }

    public final Flow l3() {
        return this.T;
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        A0().unregisterReceiver(this.Y);
        Job job = this.X;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        super.onCleared();
    }
}
