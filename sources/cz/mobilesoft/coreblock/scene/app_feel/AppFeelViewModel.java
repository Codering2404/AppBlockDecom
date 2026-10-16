package cz.mobilesoft.coreblock.scene.app_feel;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewEvent;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.statistics.api.Statistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
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
public final class AppFeelViewModel extends BaseStatefulViewModel<AppFeelViewState, AppFeelViewEvent, AppFeelViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f98574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f98575p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f98576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f98577r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f98578s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Map f98579t;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$1", f = "AppFeelViewModel.kt", l = {42, 43, 51, 53}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f98580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f98581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f98582c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f98584f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, Continuation continuation) {
            super(1, continuation);
            this.f98584f = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AppFeelViewState q(boolean z2, boolean z3, boolean z4, AppFeelViewState appFeelViewState) {
            return AppFeelViewState.b(appFeelViewState, (z2 && z3 && !z4) ? false : true, null, null, null, 14, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AppFeelViewModel.this.new AnonymousClass1(this.f98584f, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        
            if (r3.J0(r8) == r0) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[PHI: r1 r9
          0x0097: PHI (r1v8 boolean) = (r1v6 boolean), (r1v10 boolean) binds: [B:22:0x007a, B:27:0x0095] A[DONT_GENERATE, DONT_INLINE]
          0x0097: PHI (r9v12 boolean) = (r9v11 boolean), (r9v14 boolean) binds: [B:22:0x007a, B:27:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r8.f98582c
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L34
                if (r1 == r5) goto L30
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                kotlin.ResultKt.b(r9)
                goto Laa
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                boolean r1 = r8.f98581b
                boolean r3 = r8.f98580a
                kotlin.ResultKt.b(r9)
                goto L95
            L2a:
                boolean r1 = r8.f98580a
                kotlin.ResultKt.b(r9)
                goto L68
            L30:
                kotlin.ResultKt.b(r9)
                goto L4a
            L34:
                kotlin.ResultKt.b(r9)
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r9 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r9 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.W0(r9)
                kotlinx.coroutines.flow.Flow r9 = r9.s0()
                r8.f98582c = r5
                java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
                if (r9 != r0) goto L4a
                goto La9
            L4a:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r1 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r1 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.W0(r1)
                kotlinx.coroutines.flow.Flow r1 = r1.p0()
                r8.f98580a = r9
                r8.f98582c = r4
                java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r8)
                if (r1 != r0) goto L65
                goto La9
            L65:
                r7 = r1
                r1 = r9
                r9 = r7
            L68:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r4 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                boolean r5 = r8.f98584f
                cz.mobilesoft.coreblock.scene.app_feel.a0 r6 = new cz.mobilesoft.coreblock.scene.app_feel.a0
                r6.<init>()
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.Z0(r4, r6)
                if (r1 != 0) goto L97
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r4 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r4 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.W0(r4)
                long r5 = java.lang.System.currentTimeMillis()
                r8.f98580a = r1
                r8.f98581b = r9
                r8.f98582c = r3
                java.lang.Object r3 = r4.B0(r5, r8)
                if (r3 != r0) goto L93
                goto La9
            L93:
                r3 = r1
                r1 = r9
            L95:
                r9 = r1
                r1 = r3
            L97:
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r3 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r3 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.W0(r3)
                r8.f98580a = r1
                r8.f98581b = r9
                r8.f98582c = r2
                java.lang.Object r9 = r3.J0(r8)
                if (r9 != r0) goto Laa
            La9:
                return r0
            Laa:
                kotlin.Unit r9 = kotlin.Unit.f139807a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$2", f = "AppFeelViewModel.kt", l = {57, 59}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f98585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f98586b;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AppFeelViewModel.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
        
            if (r1.j1(r7) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f98586b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r7.f98585a
                java.util.List r0 = (java.util.List) r0
                kotlin.ResultKt.b(r8)
                goto L7d
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                kotlin.ResultKt.b(r8)
                goto L34
            L22:
                kotlin.ResultKt.b(r8)
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r8 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r8 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.U0(r8)
                r7.f98586b = r3
                java.lang.Object r8 = r8.R(r3, r7)
                if (r8 != r0) goto L34
                goto L7c
            L34:
                java.util.List r8 = (java.util.List) r8
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r1 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                r3 = r8
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r4)
                int r4 = kotlin.collections.MapsKt.mapCapacity(r4)
                r5 = 16
                int r4 = kotlin.ranges.RangesKt.f(r4, r5)
                java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
                r5.<init>(r4)
                java.util.Iterator r3 = r3.iterator()
            L54:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L69
                java.lang.Object r4 = r3.next()
                r6 = r4
                cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r6
                java.lang.String r6 = r6.c()
                r5.put(r6, r4)
                goto L54
            L69:
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.X0(r1, r5)
                cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r1 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.this
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                r7.f98585a = r8
                r7.f98586b = r2
                java.lang.Object r8 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.Y0(r1, r7)
                if (r8 != r0) goto L7d
            L7c:
                return r0
            L7d:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$3", f = "AppFeelViewModel.kt", l = {63}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f98588a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppFeelViewModel f98590a;

            AnonymousClass1(AppFeelViewModel appFeelViewModel) {
                this.f98590a = appFeelViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AppFeelViewState f(PremiumState premiumState, AppFeelViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return AppFeelViewState.b(updateState, false, null, null, premiumState, 7, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f98590a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelViewModel.AnonymousClass3.AnonymousClass1.f(premiumState, (AppFeelViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AppFeelViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f98588a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = AppFeelViewModel.this.f1().K();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(AppFeelViewModel.this);
                this.f98588a = 1;
                if (stateFlowK.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFeelViewModel(boolean z2, Application application) {
        super(application, new AppFeelViewState(z2, null, null, null, 14, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f98574o = LazyKt.a(lazyThreadSafetyModeB, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAppDataUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f98575p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f98576q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f98577r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr6, objArr7);
            }
        });
        this.f98578s = System.currentTimeMillis();
        this.f98579t = MapsKt.emptyMap();
        G0(new AnonymousClass1(z2, null));
        G0(new AnonymousClass2(null));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
    }

    private final void a1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppFeelViewModel.b1((AppFeelViewState) obj);
            }
        });
        G0(new AppFeelViewModel$finishLabeling$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFeelViewState b1(AppFeelViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AppFeelViewState.b(updateState, false, null, null, null, 14, null);
    }

    private final Map c1() {
        return this.f98579t;
    }

    private final FetchAppDataUseCase d1() {
        return (FetchAppDataUseCase) this.f98574o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao e1() {
        return (IgnoredStatisticsItemDao) this.f98575p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 f1() {
        return (PremiumRepositoryV2) this.f98576q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore g1() {
        return (StatisticsDataStore) this.f98577r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j1(kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            boolean r2 = r1 instanceof cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$updateAppList$1
            if (r2 == 0) goto L17
            r2 = r1
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$updateAppList$1 r2 = (cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$updateAppList$1) r2
            int r3 = r2.f98615d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f98615d = r3
            goto L1c
        L17:
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$updateAppList$1 r2 = new cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$updateAppList$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.f98613b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.f98615d
            r5 = 1
            if (r4 == 0) goto L35
            if (r4 != r5) goto L2d
            kotlin.ResultKt.b(r1)
            goto L75
        L2d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L35:
            kotlin.ResultKt.b(r1)
            long r6 = r0.f98578s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.DAYS
            r8 = 7
            long r8 = r1.toMillis(r8)
            long r13 = r6 - r8
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase r1 = r0.d1()
            java.util.Map r4 = r0.c1()
            java.util.Set r4 = r4.keySet()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r17 = kotlin.collections.CollectionsKt.toList(r4)
            long r6 = r0.f98578s
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase$Params r10 = new cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase$Params
            r21 = 224(0xe0, float:3.14E-43)
            r22 = 0
            r11 = 0
            r12 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r15 = r6
            r10.<init>(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22)
            r2.f98612a = r13
            r2.f98615d = r5
            java.lang.Object r1 = r1.a(r10, r2)
            if (r1 != r3) goto L75
            return r3
        L75:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L80:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto La3
            java.lang.Object r3 = r1.next()
            r4 = r3
            cz.mobilesoft.statistics.model.AggregatedItemRecord r4 = (cz.mobilesoft.statistics.model.AggregatedItemRecord) r4
            int r5 = r4.g()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r6 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r6 = r6.getTypeId()
            if (r5 != r6) goto L80
            int r4 = r4.c()
            if (r4 <= 0) goto L80
            r2.add(r3)
            goto L80
        La3:
            cz.mobilesoft.coreblock.scene.app_feel.z r1 = new cz.mobilesoft.coreblock.scene.app_feel.z
            r1.<init>()
            r0.Q0(r1)
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.j1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFeelViewState k1(List list, AppFeelViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AppFeelViewState.b(updateState, false, list, null, null, 13, null);
    }

    private final void l1(String str, AppDistractionType appDistractionType) {
        final List listE = ((AppFeelViewState) I0()).e();
        listE.add(new Pair(str, appDistractionType));
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppFeelViewModel.m1(listE, (AppFeelViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFeelViewState m1(List list, AppFeelViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AppFeelViewState.b(updateState, false, null, list, null, 11, null);
    }

    private final void n1(String str, AppDistractionType appDistractionType) {
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        String lowerCase = appDistractionType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        answersHelper.l0(str, lowerCase);
        Statistics.f133571a.Y(str, appDistractionType.name());
        G0(new AppFeelViewModel$updateSelectedPackageAppType$1(this, null));
        if (((AppFeelViewState) I0()).h()) {
            l1(str, appDistractionType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void O0(AppFeelViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AppFeelViewEvent.OnAppTypeUpdated) {
            AppFeelViewEvent.OnAppTypeUpdated onAppTypeUpdated = (AppFeelViewEvent.OnAppTypeUpdated) event;
            n1(onAppTypeUpdated.b(), onAppTypeUpdated.a());
        } else if (event instanceof AppFeelViewEvent.OnItemExcludedFromReports) {
            AppFeelViewEvent.OnItemExcludedFromReports onItemExcludedFromReports = (AppFeelViewEvent.OnItemExcludedFromReports) event;
            i1(onItemExcludedFromReports.b(), onItemExcludedFromReports.a());
        } else {
            if (!Intrinsics.areEqual(event, AppFeelViewEvent.OnLabelingFinished.f98573a)) {
                throw new NoWhenBranchMatchedException();
            }
            a1();
        }
    }

    public final void i1(String packageName, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        AnswersHelper.f128199a.m0(packageName, z2);
        G0(new AppFeelViewModel$setIgnoreStatisticsItem$1(this, packageName, z2, null));
        if (((AppFeelViewState) I0()).h()) {
            l1(packageName, null);
        }
    }
}
