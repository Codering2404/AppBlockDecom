package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.app.Application;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.usecase.CreateIntervalsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousUseUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.WeeklyStatisticsComparisonUseCase;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.AggregatedPauseHistory;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import cz.mobilesoft.statistics.model.AppWithType;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class WeeklyInsightsViewModel extends BaseInsightsViewModel<WeeklyInsightsViewState, WeeklyInsightsViewEvent> {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private final long J;
    private InsightsViewModel.InsightTypeConfig K;
    private Map L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f103916u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f103917v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f103918w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f103919x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f103920y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f103921z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$1", f = "WeeklyInsightsViewModel.kt", l = {74, 75}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103922a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            if (r7.P0(r3, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r6.f103922a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r7)
                goto L4b
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.ResultKt.b(r7)
                goto L36
            L1e:
                kotlin.ResultKt.b(r7)
                cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel r7 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.A1(r7)
                cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
                long r4 = r1.n()
                r6.f103922a = r3
                java.lang.Object r7 = r7.M0(r4, r6)
                if (r7 != r0) goto L36
                goto L4a
            L36:
                cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel r7 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.A1(r7)
                cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
                long r3 = r1.n()
                r6.f103922a = r2
                java.lang.Object r7 = r7.P0(r3, r6)
                if (r7 != r0) goto L4b
            L4a:
                return r0
            L4b:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$2", f = "WeeklyInsightsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103924a;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WeeklyInsightsViewState q(WeeklyInsightsViewModel weeklyInsightsViewModel, WeeklyInsightsViewState weeklyInsightsViewState) {
            return WeeklyInsightsViewState.b(weeklyInsightsViewState, false, null, null, weeklyInsightsViewModel.f1().J().f(Product.STATISTICS), null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, false, false, 8388599, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f103924a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final WeeklyInsightsViewModel weeklyInsightsViewModel = WeeklyInsightsViewModel.this;
            weeklyInsightsViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.b3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WeeklyInsightsViewModel.AnonymousClass2.q(weeklyInsightsViewModel, (WeeklyInsightsViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$3", f = "WeeklyInsightsViewModel.kt", l = {87}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103926a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeeklyInsightsViewModel f103928a;

            AnonymousClass1(WeeklyInsightsViewModel weeklyInsightsViewModel) {
                this.f103928a = weeklyInsightsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final WeeklyInsightsViewState f(SessionManager.SignInState signInState, WeeklyInsightsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                SessionManager.SignedIn signedIn = (SessionManager.SignedIn) signInState;
                return WeeklyInsightsViewState.b(updateState, false, SessionManager.f127910a.p(signedIn), signedIn.f(), false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, false, false, 8388601, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                if (signInState instanceof SessionManager.SignedIn) {
                    this.f103928a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.c3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WeeklyInsightsViewModel.AnonymousClass3.AnonymousClass1.f(signInState, (WeeklyInsightsViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103926a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowL = SessionManager.f127910a.l();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(WeeklyInsightsViewModel.this);
                this.f103926a = 1;
                if (stateFlowL.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4", f = "WeeklyInsightsViewModel.kt", l = {105}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f103929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f103930b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4$1", f = "WeeklyInsightsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends IgnoredStatisticsItem>, List<? extends AppWithType>, Continuation<? super List<? extends IgnoredStatisticsItem>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f103932a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f103933b;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, List list2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f103933b = list;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                List list = (List) this.f103933b;
                IntrinsicsKt.f();
                if (this.f103932a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return list;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4$4, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$4$4", f = "WeeklyInsightsViewModel.kt", l = {115, 116}, m = "invokeSuspend", v = 1)
        static final class C02784 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f103934a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ WeeklyInsightsViewModel f103935b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02784(WeeklyInsightsViewModel weeklyInsightsViewModel, Continuation continuation) {
                super(1, continuation);
                this.f103935b = weeklyInsightsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new C02784(this.f103935b, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
            
                if (r5.j1(r1, r4) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r4.f103934a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.b(r5)
                    goto L3f
                L12:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1a:
                    kotlin.ResultKt.b(r5)
                    goto L2c
                L1e:
                    kotlin.ResultKt.b(r5)
                    cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel r5 = r4.f103935b
                    r4.f103934a = r3
                    java.lang.Object r5 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.w1(r5, r4)
                    if (r5 != r0) goto L2c
                    goto L3e
                L2c:
                    cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel r5 = r4.f103935b
                    cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewState r1 = cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.v1(r5)
                    java.lang.String r1 = r1.x()
                    r4.f103934a = r2
                    java.lang.Object r5 = r5.j1(r1, r4)
                    if (r5 != r0) goto L3f
                L3e:
                    return r0
                L3f:
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.AnonymousClass4.C02784.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((C02784) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WeeklyInsightsViewState q(boolean z2, WeeklyInsightsViewState weeklyInsightsViewState) {
            return WeeklyInsightsViewState.b(weeklyInsightsViewState, false, null, null, false, null, null, null, null, null, null, null, null, z2, null, null, false, null, null, false, false, false, false, false, 8384511, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WeeklyInsightsViewModel weeklyInsightsViewModel;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103930b;
            if (i3 == 0) {
                ResultKt.b(obj);
                WeeklyInsightsViewModel weeklyInsightsViewModel2 = WeeklyInsightsViewModel.this;
                Flow flowJ = FlowKt.J(weeklyInsightsViewModel2.O1().S(true), Statistics.f133571a.m(), new AnonymousClass1(null));
                this.f103929a = weeklyInsightsViewModel2;
                this.f103930b = 1;
                Object objD = FlowKt.D(flowJ, this);
                if (objD == objF) {
                    return objF;
                }
                weeklyInsightsViewModel = weeklyInsightsViewModel2;
                obj = objD;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                weeklyInsightsViewModel = (WeeklyInsightsViewModel) this.f103929a;
                ResultKt.b(obj);
            }
            Iterable iterable = (Iterable) obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (Object obj2 : iterable) {
                linkedHashMap.put(((IgnoredStatisticsItem) obj2).c(), obj2);
            }
            weeklyInsightsViewModel.L = linkedHashMap;
            final boolean zN = WeeklyInsightsViewModel.this.t0().n();
            WeeklyInsightsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.d3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return WeeklyInsightsViewModel.AnonymousClass4.q(zN, (WeeklyInsightsViewState) obj3);
                }
            });
            WeeklyInsightsViewModel weeklyInsightsViewModel3 = WeeklyInsightsViewModel.this;
            weeklyInsightsViewModel3.n1(new C02784(weeklyInsightsViewModel3, null));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$5", f = "WeeklyInsightsViewModel.kt", l = {121}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103936a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeeklyInsightsViewModel f103938a;

            AnonymousClass1(WeeklyInsightsViewModel weeklyInsightsViewModel) {
                this.f103938a = weeklyInsightsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final WeeklyInsightsViewState f(boolean z2, WeeklyInsightsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return WeeklyInsightsViewState.b(updateState, false, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, z2, false, false, 7340031, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f103938a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.e3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WeeklyInsightsViewModel.AnonymousClass5.AnonymousClass1.f(z2, (WeeklyInsightsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass5(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103936a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH = WeeklyInsightsViewModel.this.J1().h();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(WeeklyInsightsViewModel.this);
                this.f103936a = 1;
                if (flowH.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$6", f = "WeeklyInsightsViewModel.kt", l = {127}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103939a;

        AnonymousClass6(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final WeeklyInsightsViewState q(boolean z2, WeeklyInsightsViewState weeklyInsightsViewState) {
            return WeeklyInsightsViewState.b(weeklyInsightsViewState, false, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, z2, false, 6291455, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return WeeklyInsightsViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103939a;
            if (i3 == 0) {
                ResultKt.b(obj);
                WeeklyInsightsViewModel weeklyInsightsViewModel = WeeklyInsightsViewModel.this;
                this.f103939a = 1;
                obj = weeklyInsightsViewModel.X1(this);
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
            WeeklyInsightsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.f3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WeeklyInsightsViewModel.AnonymousClass6.q(zBooleanValue, (WeeklyInsightsViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WeeklyInsightsViewModel(Application application) {
        super(application, new WeeklyInsightsViewState(false, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, false, false, 8388607, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f103916u = LazyKt.a(lazyThreadSafetyModeB, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f103917v = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f103918w = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f103919x = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$4
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
        this.f103920y = LazyKt.a(lazyThreadSafetyModeB5, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f103921z = LazyKt.a(lazyThreadSafetyModeB6, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CreateIntervalsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CreateIntervalsUseCase.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB8, new Function0<FetchGraphDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchGraphDataUseCase.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB9, new Function0<WeeklyStatisticsComparisonUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WeeklyStatisticsComparisonUseCase.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB10, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAppDataUseCase.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB11, new Function0<LongestContinuousUseUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LongestContinuousUseUseCase.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB12, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.G = LazyKt.a(lazyThreadSafetyModeB13, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB14, new Function0<SchedulePauseHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SchedulePauseHistoryDao.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        this.I = LazyKt.a(lazyThreadSafetyModeB15, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr28, objArr29);
            }
        });
        this.J = System.currentTimeMillis();
        this.L = MapsKt.emptyMap();
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
        G0(new AnonymousClass3(null));
        G0(new AnonymousClass4(null));
        G0(new AnonymousClass5(null));
        G0(new AnonymousClass6(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x025b A[LOOP:4: B:57:0x0259->B:58:0x025b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02c6 A[LOOP:6: B:66:0x02c0->B:68:0x02c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0480  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H1(kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.H1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewState I1(FetchGraphDataUseCase.GraphResult graphResult, WeeklyStatisticsComparisonUseCase.Result result, FetchGraphDataUseCase.GraphResult graphResult2, InsightsViewState.InsightsInterval insightsInterval, Map map, List list, RecordDuration recordDuration, AggregatedPauseHistory aggregatedPauseHistory, WeeklyInsightsViewState updateState) {
        Float fA;
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Float fA2 = graphResult.a();
        Long lValueOf = fA2 != null ? Long.valueOf((long) fA2.floatValue()) : null;
        Long lValueOf2 = (result == null || (fA = result.a()) == null) ? null : Long.valueOf((long) fA.floatValue());
        Float fB = result != null ? result.b() : null;
        GraphData graphDataB = graphResult.b();
        GraphData graphDataB2 = graphResult2.b();
        AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) CollectionsKt.firstOrNull(list);
        return WeeklyInsightsViewState.b(updateState, false, null, null, false, lValueOf, lValueOf2, fB, graphDataB, graphDataB2, insightsInterval, map, list, false, null, aggregatedItemRecord != null ? aggregatedItemRecord.e() : null, false, recordDuration, aggregatedPauseHistory, false, false, false, false, false, 8171535, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper J1() {
        return (ConsentHelper) this.f103920y.getValue();
    }

    private final CreateIntervalsUseCase K1() {
        return (CreateIntervalsUseCase) this.A.getValue();
    }

    private final DevDataStore L1() {
        return (DevDataStore) this.f103918w.getValue();
    }

    private final FetchAppDataUseCase M1() {
        return (FetchAppDataUseCase) this.D.getValue();
    }

    private final FetchGraphDataUseCase N1() {
        return (FetchGraphDataUseCase) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao O1() {
        return (IgnoredStatisticsItemDao) this.G.getValue();
    }

    private final LongestContinuousUseUseCase P1() {
        return (LongestContinuousUseUseCase) this.E.getValue();
    }

    private final SchedulePauseHistoryDao Q1() {
        return (SchedulePauseHistoryDao) this.H.getValue();
    }

    private final RatingDataStore R1() {
        return (RatingDataStore) this.f103921z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore S1() {
        return (StatisticsDataStore) this.f103916u.getValue();
    }

    private final WeeklyStatisticsComparisonUseCase T1() {
        return (WeeklyStatisticsComparisonUseCase) this.C.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewState V1(WeeklyInsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return WeeklyInsightsViewState.b(updateState, false, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, false, false, 7864319, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewState W1(WeeklyInsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return WeeklyInsightsViewState.b(updateState, false, null, null, false, null, null, null, null, null, null, null, null, false, null, null, false, null, null, false, false, false, false, false, 8126463, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X1(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$shouldShowRatingDialog$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$shouldShowRatingDialog$1 r0 = (cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$shouldShowRatingDialog$1) r0
            int r1 = r0.f103966d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f103966d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$shouldShowRatingDialog$1 r0 = new cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel$shouldShowRatingDialog$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f103964b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f103966d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L48
        L38:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r6 = r5.L1()
            r0.f103966d = r4
            java.lang.Object r6 = r6.q1(r0)
            if (r6 != r1) goto L48
            goto L5e
        L48:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L60
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore r2 = r5.R1()
            r0.f103963a = r6
            r0.f103966d = r3
            java.lang.Object r6 = r2.J0(r0)
            if (r6 != r1) goto L5f
        L5e:
            return r1
        L5f:
            return r6
        L60:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewModel.X1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeeklyInsightsViewState Y1(List list, boolean z2, WeeklyInsightsViewModel weeklyInsightsViewModel, WeeklyInsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return WeeklyInsightsViewState.b(updateState, false, null, null, false, null, null, null, null, null, null, null, null, false, ExtensionsKt.k(list), null, z2, null, null, false, false, false, false, weeklyInsightsViewModel.Y0(list), 4153343, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 f1() {
        return (PremiumRepositoryV2) this.I.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.F.getValue();
    }

    public static final /* synthetic */ WeeklyInsightsViewState v1(WeeklyInsightsViewModel weeklyInsightsViewModel) {
        return (WeeklyInsightsViewState) weeklyInsightsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void O0(WeeklyInsightsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof WeeklyInsightsViewEvent.OnScheduleClicked) {
            k1(((WeeklyInsightsViewEvent.OnScheduleClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, WeeklyInsightsViewEvent.OnDismissBottomSheet.f103911a)) {
            l1();
            return;
        }
        if (event instanceof WeeklyInsightsViewEvent.OnScheduleSelectionConfirmed) {
            String strX = ((WeeklyInsightsViewState) I0()).x();
            if (strX != null) {
                if (!b1()) {
                    q1(((WeeklyInsightsViewEvent.OnScheduleSelectionConfirmed) event).a(), strX);
                    return;
                } else {
                    m1(false);
                    Z0(strX, ((WeeklyInsightsViewEvent.OnScheduleSelectionConfirmed) event).a());
                    return;
                }
            }
            return;
        }
        if (event instanceof WeeklyInsightsViewEvent.OnAddScheduleClicked) {
            if (!((WeeklyInsightsViewState) I0()).g()) {
                G0(new WeeklyInsightsViewModel$onEvent$2(this, null));
                return;
            }
            String strX2 = ((WeeklyInsightsViewState) I0()).x();
            if (strX2 != null) {
                BaseInsightsViewModel.a1(this, strX2, false, 2, null);
                return;
            }
            return;
        }
        if (event instanceof WeeklyInsightsViewEvent.OnAppSelected) {
            G0(new WeeklyInsightsViewModel$onEvent$4(this, event, null));
            return;
        }
        if (Intrinsics.areEqual(event, WeeklyInsightsViewEvent.OnContinuousUseScheduleCreated.f103910a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.z2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsViewModel.V1((WeeklyInsightsViewState) obj);
                }
            });
        } else if (Intrinsics.areEqual(event, WeeklyInsightsViewEvent.OnTypicalDayScheduleCreated.f103915a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.a3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsViewModel.W1((WeeklyInsightsViewState) obj);
                }
            });
        } else {
            if (!Intrinsics.areEqual(event, WeeklyInsightsViewEvent.OnLockedScheduleClicked.f103912a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(B0(), null, null, new WeeklyInsightsViewModel$onEvent$7(this, null), 3, null);
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public List h1() {
        return ((WeeklyInsightsViewState) I0()).w();
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public boolean i1() {
        return ((WeeklyInsightsViewState) I0()).F();
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public void p1(final List schedules) {
        final boolean zE;
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        WeeklyInsightsViewState weeklyInsightsViewState = (WeeklyInsightsViewState) I0();
        AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) CollectionsKt.firstOrNull(weeklyInsightsViewState.c());
        if (Intrinsics.areEqual(aggregatedItemRecord != null ? aggregatedItemRecord.e() : null, weeklyInsightsViewState.x())) {
            List list = schedules;
            zE = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((ScheduleSelectViewState.ScheduleDto) it.next()).i()) {
                        zE = true;
                        break;
                    }
                }
            }
        } else {
            zE = weeklyInsightsViewState.E();
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.x2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WeeklyInsightsViewModel.Y1(schedules, zE, this, (WeeklyInsightsViewState) obj);
            }
        });
    }
}
