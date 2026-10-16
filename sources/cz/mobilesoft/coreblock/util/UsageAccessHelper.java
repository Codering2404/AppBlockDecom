package cz.mobilesoft.coreblock.util;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.share.HKJ.pnxuebdT;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.util.UsageAccessEventParser;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
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
public final class UsageAccessHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UsageAccessHelper f128032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CoroutineScope f128033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f128034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f128035d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f128036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f128037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f128038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List f128039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f128040j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface UsageAccessListener {
        void v0(boolean z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final UsageAccessHelper usageAccessHelper = new UsageAccessHelper();
        f128032a = usageAccessHelper;
        final Qualifier qualifier = null;
        f128033b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        f128034c = LazyKt.a(lazyThreadSafetyModeB, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.util.UsageAccessHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = usageAccessHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f128035d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.UsageAccessHelper$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = usageAccessHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f128036f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.util.UsageAccessHelper$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = usageAccessHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f128037g = LazyKt.a(lazyThreadSafetyModeB4, new Function0<MigrateStatisticsToInsightsUseCase>() { // from class: cz.mobilesoft.coreblock.util.UsageAccessHelper$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = usageAccessHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(MigrateStatisticsToInsightsUseCase.class), objArr6, objArr7);
            }
        });
        f128039i = new ArrayList();
        f128040j = 8;
    }

    private UsageAccessHelper() {
    }

    private final UsageAccessEventParser.ParseResult i(UsageStatsManager usageStatsManager, long j3, long j4) {
        UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(j3, j4);
        UsageEvents.Event event = new UsageEvents.Event();
        ArrayList arrayList = new ArrayList();
        while (usageEventsQueryEvents.hasNextEvent()) {
            usageEventsQueryEvents.getNextEvent(event);
            arrayList.add(new UsageAccessEventParser.Event(event.getPackageName(), event.getEventType(), event.getTimeStamp()));
        }
        return UsageAccessEventParser.f128021a.b(arrayList, j3, System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageAccessEventParser.ParseResult j(Context context, long j3, long j4) {
        if (f128038h) {
            if (BuildConfig.f95357b.booleanValue()) {
                String simpleName = UsageAccessHelper.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                Log.d(simpleName, "Skipping application access update: UsageAccessHelper is busy");
            }
            return null;
        }
        if (!PermissionHelper.k(context)) {
            if (BuildConfig.f95357b.booleanValue()) {
                String simpleName2 = UsageAccessHelper.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                Log.d(simpleName2, "Skipping application access update: usage stats permission is missing");
            }
            return null;
        }
        f128038h = true;
        try {
            Object systemService = context.getSystemService("usagestats");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.UsageStatsManager");
            return i((UsageStatsManager) systemService, j3, j4);
        } finally {
            f128038h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[LOOP:1: B:25:0x0072->B:26:0x0074, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List k(android.app.usage.UsageStatsManager r24, long r25, long r27) {
        /*
            r23 = this;
            r1 = 0
            java.lang.Class<android.app.usage.UsageStats> r0 = android.app.usage.UsageStats.class
            java.lang.String r2 = "getAppLaunchCount"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r1)     // Catch: java.lang.NoSuchMethodException -> La
            goto Lf
        La:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
        Lf:
            r3 = 0
            r2 = r24
            r4 = r25
            r6 = r27
            java.util.List r2 = r2.queryUsageStats(r3, r4, r6)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L23:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L96
            java.lang.Object r4 = r2.next()
            android.app.usage.UsageStats r4 = (android.app.usage.UsageStats) r4
            java.lang.String r5 = r4.getPackageName()
            if (r5 == 0) goto L23
            long r5 = r4.getTotalTimeInForeground()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 > 0) goto L40
            goto L23
        L40:
            r5 = 1
            if (r0 == 0) goto L54
            java.lang.Object r6 = r0.invoke(r4, r1)     // Catch: java.lang.Exception -> L53
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Int"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch: java.lang.Exception -> L53
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Exception -> L53
            int r6 = r6.intValue()     // Catch: java.lang.Exception -> L53
            goto L55
        L53:
            r0 = r1
        L54:
            r6 = r5
        L55:
            if (r6 != 0) goto L58
            goto L59
        L58:
            r5 = r6
        L59:
            long r6 = r4.getFirstTimeStamp()
            long r8 = r4.getLastTimeStamp()
            long r6 = r6 + r8
            r8 = 2
            long r8 = (long) r8
            long r6 = r6 / r8
            long r8 = r4.getTotalTimeInForeground()
            long r10 = r4.getTotalTimeInForeground()
            long r12 = (long) r5
            long r10 = r10 / r12
            long r6 = r6 - r8
            r8 = 0
            r15 = r6
        L72:
            if (r8 >= r5) goto L23
            long r17 = r15 + r10
            cz.mobilesoft.coreblock.dto.UsageAccess r12 = new cz.mobilesoft.coreblock.dto.UsageAccess
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r13 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            java.lang.String r14 = r4.getPackageName()
            java.lang.String r6 = "getPackageName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)
            r21 = 48
            r22 = 0
            r19 = 0
            r20 = 0
            r12.<init>(r13, r14, r15, r17, r19, r20, r21, r22)
            r3.add(r12)
            int r8 = r8 + 1
            r15 = r17
            goto L72
        L96:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.UsageAccessHelper.k(android.app.usage.UsageStatsManager, long, long):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore l() {
        return (StatisticsDataStore) f128034c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore m() {
        return (EventDataStore) f128035d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MigrateStatisticsToInsightsUseCase n() {
        return (MigrateStatisticsToInsightsUseCase) f128037g.getValue();
    }

    public static final void q(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        s(context, null, null, 6, null);
    }

    public static /* synthetic */ void s(Context context, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            function12 = null;
        }
        r(context, function1, function12);
    }

    public final void h(UsageAccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List list = f128039i;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(android.content.Context r9, long r10, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.util.UsageAccessHelper$getOngoingSession$1
            if (r0 == 0) goto L13
            r0 = r12
            cz.mobilesoft.coreblock.util.UsageAccessHelper$getOngoingSession$1 r0 = (cz.mobilesoft.coreblock.util.UsageAccessHelper$getOngoingSession$1) r0
            int r1 = r0.f128054f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128054f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.UsageAccessHelper$getOngoingSession$1 r0 = new cz.mobilesoft.coreblock.util.UsageAccessHelper$getOngoingSession$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.f128052c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128054f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            long r10 = r0.f128051b
            java.lang.Object r9 = r0.f128050a
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.b(r12)
        L2e:
            r3 = r9
            r6 = r10
            goto L51
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r12 = r8.l()
            kotlinx.coroutines.flow.Flow r12 = r12.c0()
            r0.f128050a = r9
            r0.f128051b = r10
            r0.f128054f = r3
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r0)
            if (r12 != r1) goto L2e
            return r1
        L51:
            java.lang.Number r12 = (java.lang.Number) r12
            long r9 = r12.longValue()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 - r11
            r11 = 0
            long r4 = kotlin.ranges.RangesKt.g(r9, r11)
            r2 = r8
            cz.mobilesoft.coreblock.util.UsageAccessEventParser$ParseResult r9 = r2.j(r3, r4, r6)
            if (r9 == 0) goto L6c
            cz.mobilesoft.coreblock.util.UsageAccessEventParser$OpenSession r9 = r9.a()
            return r9
        L6c:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.UsageAccessHelper.o(android.content.Context, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object p(Context context, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        s(context, new Function1<Boolean, Unit>() { // from class: cz.mobilesoft.coreblock.util.UsageAccessHelper$syncApplicationAccess$2$1
            public final void c(boolean z2) {
                if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(Boolean.valueOf(z2)));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }
        }, null, 4, null);
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public static final void r(Context context, Function1 function1, Function1 function12) {
        Intrinsics.checkNotNullParameter(context, pnxuebdT.zUIKWGV);
        BuildersKt__Builders_commonKt.d(f128033b, null, null, new UsageAccessHelper$updateApplicationAccess$1(context, function1, function12, null), 3, null);
    }
}
