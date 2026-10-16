package cz.mobilesoft.coreblock.scene.more.settings.statistics;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class StatisticsSettingsViewModel extends BaseStatefulViewModel<StatisticsSettingsViewState, StatisticsSettingsViewEvent, StatisticsSettingsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f110204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f110205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f110206q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$1", f = "StatisticsSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110207a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StatisticsSettingsViewState q(boolean z2, StatisticsSettingsViewState statisticsSettingsViewState) {
            return StatisticsSettingsViewState.b(statisticsSettingsViewState, z2, false, false, false, false, 30, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StatisticsSettingsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f110207a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean zN = StatisticsSettingsViewModel.this.t0().n();
            StatisticsSettingsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StatisticsSettingsViewModel.AnonymousClass1.q(zN, (StatisticsSettingsViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$2", f = "StatisticsSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function5<Boolean, Boolean, Boolean, Boolean, Continuation<? super StatisticsSettingsViewState>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f110210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ boolean f110211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ boolean f110212d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ boolean f110213f;

        AnonymousClass2(Continuation continuation) {
            super(5, continuation);
        }

        public final Object h(boolean z2, boolean z3, boolean z4, boolean z5, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.f110210b = z2;
            anonymousClass2.f110211c = z3;
            anonymousClass2.f110212d = z4;
            anonymousClass2.f110213f = z5;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return h(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), (Continuation) obj5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = this.f110210b;
            boolean z6 = this.f110211c;
            boolean z7 = this.f110212d;
            boolean z8 = this.f110213f;
            IntrinsicsKt.f();
            if (this.f110209a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            boolean z9 = false;
            if (z6 && z5) {
                z2 = z8;
                z3 = true;
            } else {
                z2 = z8;
                z3 = false;
            }
            if (z7 && z5) {
                z4 = false;
                z9 = true;
            } else {
                z4 = false;
            }
            return new StatisticsSettingsViewState(false, z5, z3, z9, (z2 && z5) ? true : z4, 1, null);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass3<T> implements FlowCollector {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StatisticsSettingsViewState f(StatisticsSettingsViewState statisticsSettingsViewState, StatisticsSettingsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StatisticsSettingsViewState.b(updateState, false, statisticsSettingsViewState.e(), statisticsSettingsViewState.c(), statisticsSettingsViewState.f(), statisticsSettingsViewState.d(), 1, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final StatisticsSettingsViewState statisticsSettingsViewState, Continuation continuation) {
            StatisticsSettingsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatisticsSettingsViewModel.AnonymousClass3.f(statisticsSettingsViewState, (StatisticsSettingsViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StatisticsSettingsViewModel(Application app) {
        super(app, new StatisticsSettingsViewState(false, false, false, false, false, 31, null));
        Intrinsics.checkNotNullParameter(app, "app");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f110204o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f110205p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f110206q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr4, objArr5);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        FlowExtKt.i(FlowKt.o(V0().Y(), V0().W(), V0().Z(), V0().X(), new AnonymousClass2(null)), C0(), new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore V0() {
        return (StatisticsDataStore) this.f110206q.getValue();
    }

    private final void X0() {
        if (((StatisticsSettingsViewState) I0()).e()) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onStatisticsEnabledClicked$2(this, null), 3, null);
        } else {
            AnswersHelper.f128199a.S6(false, "ALL");
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onStatisticsEnabledClicked$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f110205p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void O0(StatisticsSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StatisticsSettingsViewEvent.OnAppStatisticsClick) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onEvent$1(event, this, null), 3, null);
            return;
        }
        if (event instanceof StatisticsSettingsViewEvent.OnIncognitoStatisticsClick) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onEvent$2(event, this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, StatisticsSettingsViewEvent.OnStatisticsEnabledClick.f110202a)) {
            X0();
            Unit unit = Unit.f139807a;
        } else if (event instanceof StatisticsSettingsViewEvent.OnWebStatisticsClick) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onEvent$3(event, this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, StatisticsSettingsViewEvent.OnStatisticsDisabledClick.f110201a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new StatisticsSettingsViewModel$onEvent$4(this, null), 3, null);
        }
    }
}
