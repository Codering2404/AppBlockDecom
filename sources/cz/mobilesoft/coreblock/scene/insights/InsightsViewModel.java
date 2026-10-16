package cz.mobilesoft.coreblock.scene.insights;

import android.app.Application;
import android.text.format.DateUtils;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.Lifecycle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.InsightsBlockingSessions;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewModel;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.usecase.AppDifferenceUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.CreateIntervalsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.DailyStatisticsComparisonUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAggregatedAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousUseUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.WeeklyStatisticsComparisonUseCase;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.MoodCheckInEntityDao;
import cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.StatisticsHelper;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedCategoryRecord;
import cz.mobilesoft.statistics.model.RecordDuration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsViewModel extends BaseInsightsViewModel<InsightsViewState, InsightsViewEvent> {
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
    private final Lazy N;
    private final Lazy O;
    private final Lazy P;
    private final Lazy Q;
    private InsightTypeConfig R;
    private final long S;
    private Map T;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f102697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f102698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f102699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f102700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f102701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f102702z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$1", f = "InsightsViewModel.kt", l = {113, 117, 126, 126, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f102703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f102704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f102705c;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InsightsViewState y(InsightsViewModel insightsViewModel, Set set, AppDistractionType appDistractionType, InsightsViewState insightsViewState) {
            return InsightsViewState.d(insightsViewState, null, null, PermissionHelper.l(insightsViewModel.A0()), set, null, null, null, 0, null, appDistractionType, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -525, 32767, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InsightsViewState z(List list, InsightsViewState insightsViewState) {
            return InsightsViewState.d(insightsViewState, null, list, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -3, 32767, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return InsightsViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0135, code lost:
        
            if (r9 != r0) goto L44;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0117 A[PHI: r5 r9
          0x0117: PHI (r5v7 java.util.Set) = (r5v3 java.util.Set), (r5v4 java.util.Set), (r5v8 java.util.Set) binds: [B:28:0x00c7, B:40:0x0115, B:39:0x0112] A[DONT_GENERATE, DONT_INLINE]
          0x0117: PHI (r9v21 cz.mobilesoft.coreblock.enums.AppDistractionType) = 
          (r9v11 cz.mobilesoft.coreblock.enums.AppDistractionType)
          (r9v16 cz.mobilesoft.coreblock.enums.AppDistractionType)
          (r9v24 cz.mobilesoft.coreblock.enums.AppDistractionType)
         binds: [B:28:0x00c7, B:40:0x0115, B:39:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 342
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$2", f = "InsightsViewModel.kt", l = {174, 177, 178}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f102707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f102708b;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return InsightsViewModel.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
        
            if (r11.P0(r3, r10) != r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f102708b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L24
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.b(r11)
                goto L8c
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1e:
                boolean r1 = r10.f102707a
                kotlin.ResultKt.b(r11)
                goto L7d
            L24:
                kotlin.ResultKt.b(r11)
                goto L68
            L28:
                kotlin.ResultKt.b(r11)
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r11 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r11 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r11)
                kotlinx.coroutines.flow.Flow r11 = r11.s0()
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r1)
                kotlinx.coroutines.flow.Flow r1 = r1.i0()
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r5 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r5 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r5)
                kotlinx.coroutines.flow.Flow r5 = r5.p0()
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r6 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r6 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r6)
                kotlinx.coroutines.flow.Flow r6 = r6.V()
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$2$showAppFeel$1 r7 = new cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$2$showAppFeel$1
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r8 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                r9 = 0
                r7.<init>(r8, r9)
                kotlinx.coroutines.flow.Flow r11 = kotlinx.coroutines.flow.FlowKt.o(r11, r1, r5, r6, r7)
                r10.f102708b = r4
                java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.D(r11, r10)
                if (r11 != r0) goto L68
                goto L8b
            L68:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r1 = r11.booleanValue()
                if (r1 == 0) goto L8c
                r10.f102707a = r1
                r10.f102708b = r3
                r3 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r3, r10)
                if (r11 != r0) goto L7d
                goto L8b
            L7d:
                cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r11 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.this
                cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand$OpenAppFeel r3 = cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand.OpenAppFeel.f102662a
                r10.f102707a = r1
                r10.f102708b = r2
                java.lang.Object r11 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.N1(r11, r3, r10)
                if (r11 != r0) goto L8c
            L8b:
                return r0
            L8c:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$3", f = "InsightsViewModel.kt", l = {183}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102717a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InsightsViewModel f102719a;

            AnonymousClass1(InsightsViewModel insightsViewModel) {
                this.f102719a = insightsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final InsightsViewState f(boolean z2, InsightsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, z2, 0L, false, false, false, null, false, false, false, -1, 32703, null);
            }

            public final Object b(long j3, Continuation continuation) {
                final boolean zIsToday = DateUtils.isToday(j3);
                this.f102719a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.j7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsViewModel.AnonymousClass3.AnonymousClass1.f(zIsToday, (InsightsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).longValue(), continuation);
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return InsightsViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102717a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowU0 = InsightsViewModel.this.q2().u0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(InsightsViewModel.this);
                this.f102717a = 1;
                if (flowU0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$4", f = "InsightsViewModel.kt", l = {195}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102720a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InsightsViewModel f102722a;

            AnonymousClass1(InsightsViewModel insightsViewModel) {
                this.f102722a = insightsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final InsightsViewState f(long j3, InsightsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, j3, false, false, false, null, false, false, false, -1, 32639, null);
            }

            public final Object b(final long j3, Continuation continuation) {
                this.f102722a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.k7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsViewModel.AnonymousClass4.AnonymousClass1.f(j3, (InsightsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).longValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return InsightsViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102720a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowF0 = InsightsViewModel.this.q2().f0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(InsightsViewModel.this);
                this.f102720a = 1;
                if (flowF0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$5", f = "InsightsViewModel.kt", l = {205}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102723a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InsightsViewModel f102725a;

            AnonymousClass1(InsightsViewModel insightsViewModel) {
                this.f102725a = insightsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final InsightsViewState f(boolean z2, InsightsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, z2, false, false, null, false, false, false, -1, 32511, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f102725a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.l7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InsightsViewModel.AnonymousClass5.AnonymousClass1.f(z2, (InsightsViewState) obj);
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
            return InsightsViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102723a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = InsightsViewModel.this.q2().e0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(InsightsViewModel.this);
                this.f102723a = 1;
                if (flowE0.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f102730a;

        static {
            int[] iArr = new int[InsightsViewState.InsightsPeriodType.values().length];
            try {
                iArr[InsightsViewState.InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f102730a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InsightsViewModel(Application application, String str, InsightsViewState.InsightsPeriodType selectedInsightType) {
        super(application, new InsightsViewState(Loading.f127895a, null, false, null, str, null, selectedInsightType, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -82, 32767, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(selectedInsightType, "selectedInsightType");
        this.f102697u = str;
        this.f102698v = 120;
        this.f102700x = TimeUnit.SECONDS.toMillis(15L);
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102701y = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f102702z = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$2
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
        this.A = LazyKt.a(lazyThreadSafetyModeB3, new Function0<BrowserViewIdDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BrowserViewIdDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StatisticsPermissionsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsPermissionsUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB5, new Function0<CreateIntervalsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CreateIntervalsUseCase.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DailyStatisticsComparisonUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DailyStatisticsComparisonUseCase.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB7, new Function0<WeeklyStatisticsComparisonUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WeeklyStatisticsComparisonUseCase.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB8, new Function0<FetchGraphDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$8
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
        this.G = LazyKt.a(lazyThreadSafetyModeB9, new Function0<FetchAggregatedAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAggregatedAppDataUseCase.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB10, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$10
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
        this.I = LazyKt.a(lazyThreadSafetyModeB11, new Function0<LongestContinuousUseUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$11
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
        this.J = LazyKt.a(lazyThreadSafetyModeB12, new Function0<LongestContinuousBreakUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LongestContinuousBreakUseCase.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.K = LazyKt.a(lazyThreadSafetyModeB13, new Function0<AppDifferenceUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppDifferenceUseCase.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.L = LazyKt.a(lazyThreadSafetyModeB14, new Function0<FetchBlockingSessionsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchBlockingSessionsUseCase.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        this.M = LazyKt.a(lazyThreadSafetyModeB15, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr28, objArr29);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB16 = koinPlatformTools.b();
        final Object[] objArr30 = 0 == true ? 1 : 0;
        final Object[] objArr31 = 0 == true ? 1 : 0;
        this.N = LazyKt.a(lazyThreadSafetyModeB16, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr30, objArr31);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB17 = koinPlatformTools.b();
        final Object[] objArr32 = 0 == true ? 1 : 0;
        final Object[] objArr33 = 0 == true ? 1 : 0;
        this.O = LazyKt.a(lazyThreadSafetyModeB17, new Function0<MoodCheckInEntityDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(MoodCheckInEntityDao.class), objArr32, objArr33);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB18 = koinPlatformTools.b();
        final Object[] objArr34 = 0 == true ? 1 : 0;
        final Object[] objArr35 = 0 == true ? 1 : 0;
        this.P = LazyKt.a(lazyThreadSafetyModeB18, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr34, objArr35);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB19 = koinPlatformTools.b();
        final Object[] objArr36 = 0 == true ? 1 : 0;
        final Object[] objArr37 = 0 == true ? 1 : 0;
        this.Q = LazyKt.a(lazyThreadSafetyModeB19, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr36, objArr37);
            }
        });
        this.S = System.currentTimeMillis();
        this.T = MapsKt.emptyMap();
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
        G0(new AnonymousClass3(null));
        G0(new AnonymousClass4(null));
        G0(new AnonymousClass5(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A2(Continuation continuation) throws Throwable {
        if (this.R == null) {
            return Unit.f139807a;
        }
        InsightsViewState insightsViewState = (InsightsViewState) I0();
        if (insightsViewState.K().isEmpty()) {
            J2(insightsViewState.a0());
            return Unit.f139807a;
        }
        ImmutableList immutableListK = insightsViewState.K();
        InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = insightsViewState.a0();
        AppDistractionType appDistractionTypeF = insightsViewState.f();
        int iB0 = insightsViewState.b0();
        int iV = insightsViewState.v();
        Category categoryZ = insightsViewState.Z();
        GraphData graphDataL = insightsViewState.l();
        Object objG2 = G2(immutableListK, iV, insightsPeriodTypeA0, iB0, categoryZ, appDistractionTypeF, graphDataL != null ? graphDataL.f() : null, continuation);
        return objG2 == IntrinsicsKt.f() ? objG2 : Unit.f139807a;
    }

    private final void C2(String str) {
        G0(new InsightsViewModel$updateAppType$1(str, this, null));
    }

    private final void D2() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.g7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InsightsViewModel.E2((InsightsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState E2(InsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, updateState.h() + 1, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -4194305, 32767, null);
    }

    private final void F2(Category category) {
        G0(new InsightsViewModel$updateCategory$1(this, category, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0b3f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0b6f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0b7a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0b80  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0b8b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0be3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0c06  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0c5a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0ce7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0d13  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0db1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0dd2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0e7b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0f2b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0f92  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x1145  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x1237  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x12a4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x1369  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x13af  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x13b9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x13d0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x13d6  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x13e4  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x13fd  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x1407  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x1415  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x085d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x09a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x09cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0a77  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0ab9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0b03  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G2(java.util.List r50, int r51, cz.mobilesoft.coreblock.scene.insights.InsightsViewState.InsightsPeriodType r52, int r53, cz.mobilesoft.coreblock.dto.Category r54, cz.mobilesoft.coreblock.enums.AppDistractionType r55, java.lang.Integer r56, kotlin.coroutines.Continuation r57) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 5218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.G2(java.util.List, int, cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType, int, cz.mobilesoft.coreblock.dto.Category, cz.mobilesoft.coreblock.enums.AppDistractionType, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object H2(InsightsViewModel insightsViewModel, List list, int i3, InsightsViewState.InsightsPeriodType insightsPeriodType, int i4, Category category, AppDistractionType appDistractionType, Integer num, Continuation continuation, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            category = null;
        }
        if ((i5 & 32) != 0) {
            appDistractionType = null;
        }
        if ((i5 & 64) != 0) {
            num = null;
        }
        return insightsViewModel.G2(list, i3, insightsPeriodType, i4, category, appDistractionType, num, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState I2(FetchGraphDataUseCase.GraphResult graphResult, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, List list, WeeklyStatisticsComparisonUseCase.Result result, DailyStatisticsComparisonUseCase.Result result2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Ref.ObjectRef objectRef8, InsightsViewState.InsightsPeriodType insightsPeriodType, int i3, Category category, AppDistractionType appDistractionType, int i4, GraphData graphData, LinkedHashMap linkedHashMap, RecordDuration recordDuration, Long l3, Double d3, Double d4, InsightsBlockingSessions insightsBlockingSessions, boolean z2, InsightsViewModel insightsViewModel, InsightsViewState updateState) {
        Map mapEmptyMap;
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Success success = Success.f128020a;
        GraphData graphDataB = graphResult.b();
        List list2 = (List) objectRef.f140144a;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((AggregatedCategoryRecord) obj).b() > insightsViewModel.f102698v) {
                    arrayList.add(obj);
                }
            }
            mapEmptyMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                AggregatedCategoryRecord aggregatedCategoryRecord = (AggregatedCategoryRecord) obj2;
                Pair pairA = TuplesKt.a(Category.Companion.b(aggregatedCategoryRecord.a()), Integer.valueOf(aggregatedCategoryRecord.b()));
                mapEmptyMap.put(pairA.e(), pairA.f());
            }
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map map = mapEmptyMap;
        Float fA = graphResult.a();
        Long lValueOf = fA != null ? Long.valueOf((long) fA.floatValue()) : null;
        Float fC = graphResult.c();
        Long lValueOf2 = fC != null ? Long.valueOf((long) fC.floatValue()) : null;
        Float f3 = (Float) objectRef2.f140144a;
        return InsightsViewState.d(updateState, success, null, false, null, null, null, insightsPeriodType, i3, category, appDistractionType, ExtensionsKt.k(list), i4, lValueOf, f3 != null ? Long.valueOf((long) f3.floatValue()) : null, lValueOf2, graphDataB, graphData, result != null ? result.b() : null, result2 != null ? Long.valueOf(result2.a()) : null, map, (List) objectRef3.f140144a, (Map) objectRef4.f140144a, 0, null, false, false, (List) objectRef5.f140144a, false, false, linkedHashMap, recordDuration, l3, d3, d4, (List) objectRef6.f140144a, (GraphData) objectRef7.f140144a, (GraphData) objectRef8.f140144a, insightsBlockingSessions, false, 0L, false, false, false, null, false, false, z2, 461373502, 16320, null);
    }

    private final void J2(InsightsViewState.InsightsPeriodType insightsPeriodType) {
        G0(new InsightsViewModel$updateInsightsType$1(this, insightsPeriodType, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState K2(List list, InsightsViewModel insightsViewModel, InsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, ExtensionsKt.k(list), false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, insightsViewModel.Y0(list), false, -8388609, 24575, null);
    }

    private final void L2(AppDistractionType appDistractionType) {
        String str = this.f102697u;
        if (str != null) {
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            String lowerCase = appDistractionType.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            answersHelper.m2(str, lowerCase);
            Statistics.f133571a.Y(this.f102697u, appDistractionType.name());
            G0(new InsightsViewModel$updateSelectedPackageAppType$1(this, null));
        }
    }

    private final void M2(InsightsViewState.TrendInterval trendInterval) {
        G0(new InsightsViewModel$updateTrendInterval$1(this, trendInterval, null));
    }

    private final LinkedHashMap T1(FetchGraphDataUseCase.GraphResult graphResult) {
        List listB = graphResult.b().b();
        final ArrayList arrayList = new ArrayList();
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((GraphData.GraphValueData) it.next()).f());
        }
        Grouping<GraphData.GraphValueData.GraphValueSection, AppDistractionType> grouping = new Grouping<GraphData.GraphValueData.GraphValueSection, AppDistractionType>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$averageValues$$inlined$groupingBy$1
            @Override // kotlin.collections.Grouping
            public AppDistractionType keyOf(GraphData.GraphValueData.GraphValueSection graphValueSection) {
                return graphValueSection.a();
            }

            @Override // kotlin.collections.Grouping
            public Iterator<GraphData.GraphValueData.GraphValueSection> sourceIterator() {
                return arrayList.iterator();
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<GraphData.GraphValueData.GraphValueSection> itSourceIterator = grouping.sourceIterator();
        while (true) {
            double dDoubleValue = 0.0d;
            if (!itSourceIterator.hasNext()) {
                break;
            }
            GraphData.GraphValueData.GraphValueSection next = itSourceIterator.next();
            AppDistractionType appDistractionTypeKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(appDistractionTypeKeyOf);
            if (obj == null) {
                linkedHashMap.containsKey(appDistractionTypeKeyOf);
            }
            GraphData.GraphValueData.GraphValueSection graphValueSection = next;
            Double d3 = (Double) obj;
            if (d3 != null) {
                dDoubleValue = d3.doubleValue();
            }
            linkedHashMap.put(appDistractionTypeKeyOf, Double.valueOf(dDoubleValue + ((double) graphValueSection.b())));
        }
        EnumEntries<AppDistractionType> entries = AppDistractionType.getEntries();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (AppDistractionType appDistractionType : entries) {
            linkedHashMap2.put(appDistractionType, Double.valueOf(((Number) linkedHashMap.getOrDefault(appDistractionType, Double.valueOf(0.0d))).doubleValue()));
        }
        List<Map.Entry> listSortedWith = CollectionsKt.sortedWith(linkedHashMap2.entrySet(), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$averageValues$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ComparisonsKt.d(Double.valueOf(-((Number) ((Map.Entry) obj2).getValue()).doubleValue()), Double.valueOf(-((Number) ((Map.Entry) obj3).getValue()).doubleValue()));
            }
        });
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : listSortedWith) {
            Pair pairA = TuplesKt.a(entry.getKey(), entry.getValue());
            linkedHashMap3.put(pairA.e(), pairA.f());
        }
        return linkedHashMap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List U1(InsightsViewState.InsightsPeriodType insightsPeriodType) {
        CreateIntervalsUseCase createIntervalsUseCaseE2 = e2();
        InsightTypeConfig insightTypeConfig = this.R;
        if (insightTypeConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statisticsIntervalConfig");
            insightTypeConfig = null;
        }
        return createIntervalsUseCaseE2.m(new CreateIntervalsUseCase.Param(insightsPeriodType, insightTypeConfig, this.S));
    }

    private final Pair V1(FetchGraphDataUseCase.GraphResult graphResult, Integer num) {
        GraphData.GraphValueData graphValueData;
        if (num != null && (graphValueData = (GraphData.GraphValueData) CollectionsKt.getOrNull(graphResult.b().b(), 1)) != null) {
            long jC = graphValueData.c();
            GraphData.GraphValueData graphValueData2 = (GraphData.GraphValueData) CollectionsKt.getOrNull(graphResult.b().b(), 2);
            if (graphValueData2 != null) {
                long jC2 = graphValueData2.c() - jC;
                GraphData.GraphValueData graphValueData3 = (GraphData.GraphValueData) CollectionsKt.getOrNull(graphResult.b().b(), num.intValue());
                if (graphValueData3 != null) {
                    long jC3 = graphValueData3.c();
                    return TuplesKt.a(Long.valueOf(jC3), Long.valueOf(jC2 + jC3));
                }
            }
        }
        return null;
    }

    private final Object W1(InsightsViewState.InsightsPeriodType insightsPeriodType, Category category, List list, long j3, long j4, Continuation continuation) {
        if (insightsPeriodType == InsightsViewState.InsightsPeriodType.Day) {
            return f2().a(new DailyStatisticsComparisonUseCase.Params(j3, j4, list, category), continuation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1() {
        InsightsViewState.InsightsInterval insightsIntervalW;
        InsightsViewState insightsViewState = (InsightsViewState) I0();
        Long lValueOf = (insightsViewState.a0() == InsightsViewState.InsightsPeriodType.Day && (insightsIntervalW = insightsViewState.w()) != null) ? Long.valueOf(insightsIntervalW.b()) : null;
        if (lValueOf == null) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.e7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsViewModel.Y1((InsightsViewState) obj);
                }
            });
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(lValueOf.longValue());
        G0(new InsightsViewModel$fetchMoodCheckData$1(this, LocalDate.of(calendar.get(1), calendar.get(2) + 1, calendar.get(5)), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState Y1(InsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, false, null, false, false, false, -1, 30719, null);
    }

    private final Object Z1(InsightsViewState.InsightsPeriodType insightsPeriodType, Category category, List list, long j3, Continuation continuation) {
        if (insightsPeriodType == InsightsViewState.InsightsPeriodType.Week) {
            return s2().b(new WeeklyStatisticsComparisonUseCase.Params(j3, category, list), continuation);
        }
        return null;
    }

    private final AppDifferenceUseCase a2() {
        return (AppDifferenceUseCase) this.K.getValue();
    }

    private final FetchBlockingSessionsUseCase b2() {
        return (FetchBlockingSessionsUseCase) this.L.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrowserViewIdDao c2() {
        return (BrowserViewIdDao) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore d2() {
        return (CoreMultiProcessDataStore) this.N.getValue();
    }

    private final CreateIntervalsUseCase e2() {
        return (CreateIntervalsUseCase) this.C.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 f1() {
        return (PremiumRepositoryV2) this.P.getValue();
    }

    private final DailyStatisticsComparisonUseCase f2() {
        return (DailyStatisticsComparisonUseCase) this.D.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore g2() {
        return (DevDataStore) this.Q.getValue();
    }

    private final Map h2() {
        return this.f102697u != null ? MapsKt.emptyMap() : this.T;
    }

    private final FetchAggregatedAppDataUseCase i2() {
        return (FetchAggregatedAppDataUseCase) this.G.getValue();
    }

    private final FetchAppDataUseCase j2() {
        return (FetchAppDataUseCase) this.H.getValue();
    }

    private final FetchGraphDataUseCase k2() {
        return (FetchGraphDataUseCase) this.F.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao l2() {
        return (IgnoredStatisticsItemDao) this.f102702z.getValue();
    }

    private final LongestContinuousBreakUseCase m2() {
        return (LongestContinuousBreakUseCase) this.J.getValue();
    }

    private final LongestContinuousUseUseCase n2() {
        return (LongestContinuousUseUseCase) this.I.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MoodCheckInEntityDao o2() {
        return (MoodCheckInEntityDao) this.O.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore q2() {
        return (StatisticsDataStore) this.M.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsPermissionsUseCase r2() {
        return (StatisticsPermissionsUseCase) this.B.getValue();
    }

    private final WeeklyStatisticsComparisonUseCase s2() {
        return (WeeklyStatisticsComparisonUseCase) this.E.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f102701y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2() {
        G0(new InsightsViewModel$initialize$1(this, null));
        G0(new InsightsViewModel$initialize$2(this, null));
        G0(new InsightsViewModel$initialize$3(this, null));
        G0(new InsightsViewModel$initialize$4(this, null));
        G0(new InsightsViewModel$initialize$5(this, null));
        G0(new InsightsViewModel$initialize$6(this, null));
        G0(new InsightsViewModel$initialize$7(this, null));
        G0(new InsightsViewModel$initialize$8(this, null));
        G0(new InsightsViewModel$initialize$9(this, null));
    }

    private final void u2(int i3) {
        G0(new InsightsViewModel$navigateToInterval$1(this, i3, null));
    }

    private final void v2(Integer num) {
        GraphData graphDataL;
        List listB;
        GraphData.GraphValueData graphValueData;
        List listF;
        InsightsViewState insightsViewState = (InsightsViewState) I0();
        GraphData graphDataL2 = insightsViewState.l();
        if (Intrinsics.areEqual(graphDataL2 != null ? graphDataL2.f() : null, num) || num == null || ((graphDataL = insightsViewState.l()) != null && (listB = graphDataL.b()) != null && (graphValueData = (GraphData.GraphValueData) CollectionsKt.getOrNull(listB, num.intValue())) != null && (listF = graphValueData.f()) != null && listF.isEmpty())) {
            num = null;
        }
        GraphData graphDataL3 = insightsViewState.l();
        if (Intrinsics.areEqual(graphDataL3 != null ? graphDataL3.f() : null, num)) {
            return;
        }
        G0(new InsightsViewModel$onBarSelected$1(this, insightsViewState, num, null));
    }

    public static final /* synthetic */ InsightsViewState x1(InsightsViewModel insightsViewModel) {
        return (InsightsViewState) insightsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InsightsViewState x2(InsightsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return InsightsViewState.d(updateState, null, null, false, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, null, false, false, null, false, false, null, null, null, null, null, null, null, null, null, false, 0L, false, false, true, null, false, false, false, -1, 31743, null);
    }

    private final void z2(ActivityResult activityResult) {
        G0(new InsightsViewModel$onStatisticsPermissionResult$1(activityResult, this, null));
    }

    public final void B2(boolean z2) {
        String str = this.f102697u;
        if (str == null) {
            return;
        }
        AnswersHelper.f128199a.i0(str, z2);
        G0(new InsightsViewModel$setIgnoreStatisticsItem$1(this, str, z2, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public List h1() {
        return ((InsightsViewState) I0()).Y();
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public boolean i1() {
        return ((InsightsViewState) I0()).u0();
    }

    @Override // cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel
    public void p1(final List schedules) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.f7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InsightsViewModel.K2(schedules, this, (InsightsViewState) obj);
            }
        });
    }

    public final String p2() {
        return this.f102697u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: w2, reason: merged with bridge method [inline-methods] */
    public void O0(InsightsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof InsightsViewEvent.OnPermissionResult) {
            z2(((InsightsViewEvent.OnPermissionResult) event).a());
            return;
        }
        if (event instanceof InsightsViewEvent.OnInsightTypeSelected) {
            J2(((InsightsViewEvent.OnInsightTypeSelected) event).a());
            return;
        }
        if (event instanceof InsightsViewEvent.OnTrendIntervalSelected) {
            M2(((InsightsViewEvent.OnTrendIntervalSelected) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnNextIntervalClicked.f102690a)) {
            u2(((InsightsViewState) I0()).v() + 1);
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnPreviousIntervalClicked.f102692a)) {
            u2(((InsightsViewState) I0()).v() - 1);
            return;
        }
        if (event instanceof InsightsViewEvent.OnBarSelected) {
            v2(((InsightsViewEvent.OnBarSelected) event).a());
            return;
        }
        if (event instanceof InsightsViewEvent.OnCategorySelected) {
            F2(((InsightsViewEvent.OnCategorySelected) event).a());
            return;
        }
        if (event instanceof InsightsViewEvent.OnAppTypeSelected) {
            C2(((InsightsViewEvent.OnAppTypeSelected) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnMoreAppsClicked.f102689a)) {
            D2();
            return;
        }
        if (event instanceof InsightsViewEvent.OnAppTypeUpdated) {
            L2(((InsightsViewEvent.OnAppTypeUpdated) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnAppFeelBannerSortAppsClicked.f102673a)) {
            G0(new InsightsViewModel$onEvent$1(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnAppFeelBannerDismissed.f102672a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.d7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InsightsViewModel.x2((InsightsViewState) obj);
                }
            });
            G0(new InsightsViewModel$onEvent$3(this, null));
            return;
        }
        if (event instanceof InsightsViewEvent.OnScheduleClicked) {
            k1(((InsightsViewEvent.OnScheduleClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnDismissBottomSheet.f102678a)) {
            l1();
            return;
        }
        if (event instanceof InsightsViewEvent.OnScheduleSelectionConfirmed) {
            if (this.f102697u != null) {
                if (b1()) {
                    m1(false);
                    Z0(this.f102697u, ((InsightsViewEvent.OnScheduleSelectionConfirmed) event).a());
                    return;
                } else {
                    q1(((InsightsViewEvent.OnScheduleSelectionConfirmed) event).a(), this.f102697u);
                    return;
                }
            }
            return;
        }
        if (event instanceof InsightsViewEvent.OnItemExcludedFromReports) {
            B2(((InsightsViewEvent.OnItemExcludedFromReports) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnAddScheduleClicked.f102671a)) {
            if (!((InsightsViewState) I0()).o()) {
                G0(new InsightsViewModel$onEvent$4(this, null));
                return;
            }
            String str = this.f102697u;
            if (str != null) {
                BaseInsightsViewModel.a1(this, str, false, 2, null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.ShowExcludedAppsBottomSheet.f102696a)) {
            G0(new InsightsViewModel$onEvent$5(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnExcludePremiumCardClicked.f102679a)) {
            G0(new InsightsViewModel$onEvent$6(this, null));
            return;
        }
        if (event instanceof InsightsViewEvent.OnMoodChekInShowDate) {
            G0(new InsightsViewModel$onEvent$7(this, event, null));
            return;
        }
        if (Intrinsics.areEqual(event, InsightsViewEvent.OnMoodChekInClosed.f102687a)) {
            G0(new InsightsViewModel$onEvent$8(this, null));
            return;
        }
        if (event instanceof InsightsViewEvent.OnMoodCheckInSaved) {
            G0(new InsightsViewModel$onEvent$9(this, event, null));
        } else if (Intrinsics.areEqual(event, InsightsViewEvent.OnMoodCheckInAutoDisableClicked.f102683a)) {
            G0(new InsightsViewModel$onEvent$10(this, null));
        } else {
            if (!Intrinsics.areEqual(event, InsightsViewEvent.OnLockedScheduleClicked.f102682a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(B0(), null, null, new InsightsViewModel$onEvent$11(this, null), 3, null);
        }
    }

    public final void y2(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_RESUME) {
            return;
        }
        G0(new InsightsViewModel$onLifecycleEvent$1(this, null));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InsightTypeConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f102726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f102727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f102728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f102729d;

        public InsightTypeConfig(long j3, long j4, int i3, int i4) {
            this.f102726a = j3;
            this.f102727b = j4;
            this.f102728c = i3;
            this.f102729d = i4;
        }

        public final long a() {
            return this.f102726a;
        }

        public final long b() {
            return this.f102727b;
        }

        public final int c() {
            return this.f102728c;
        }

        public final int d() {
            return this.f102729d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InsightTypeConfig)) {
                return false;
            }
            InsightTypeConfig insightTypeConfig = (InsightTypeConfig) obj;
            return this.f102726a == insightTypeConfig.f102726a && this.f102727b == insightTypeConfig.f102727b && this.f102728c == insightTypeConfig.f102728c && this.f102729d == insightTypeConfig.f102729d;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f102726a) * 31) + Long.hashCode(this.f102727b)) * 31) + Integer.hashCode(this.f102728c)) * 31) + Integer.hashCode(this.f102729d);
        }

        public String toString() {
            return "InsightTypeConfig(firstDayStart=" + this.f102726a + ", firstWeekStart=" + this.f102727b + ", totalDaysCount=" + this.f102728c + ", totalWeeksCount=" + this.f102729d + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public InsightTypeConfig(long j3, long j4) {
            long jG = StatisticsHelper.g(j3);
            long jK = StatisticsHelper.k(j3);
            StatisticsHelper statisticsHelper = StatisticsHelper.f128018a;
            this(jG, jK, statisticsHelper.h(j3, j4), statisticsHelper.i(j3, j4));
        }
    }
}
