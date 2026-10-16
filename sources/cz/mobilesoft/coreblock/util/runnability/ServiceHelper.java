package cz.mobilesoft.coreblock.util.runnability;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
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
public final class ServiceHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ServiceHelper f129652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static MutableSharedFlow f129654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CoroutineScope f129655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f129656f;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final ServiceHelper serviceHelper = new ServiceHelper();
        f129652a = serviceHelper;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129653b = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.runnability.ServiceHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = serviceHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        CoroutineScope coroutineScopeA = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        f129655d = coroutineScopeA;
        FlowExtKt.l(serviceHelper.d().E0(), coroutineScopeA, new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.runnability.ServiceHelper.1
            public final Object a(long j3, Continuation continuation) {
                MutableSharedFlow mutableSharedFlow = ServiceHelper.f129654c;
                if (mutableSharedFlow == null) {
                    return Unit.f139807a;
                }
                Object objEmit = mutableSharedFlow.emit(Boxing.a(true), continuation);
                return objEmit == IntrinsicsKt.f() ? objEmit : Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
        f129656f = 8;
    }

    private ServiceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore d() {
        return (EventDataStore) f129653b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlinx.coroutines.CoroutineScope r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$1
            if (r0 == 0) goto L13
            r0 = r11
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$1 r0 = (cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$1) r0
            int r1 = r0.f129662f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129662f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$1 r0 = new cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f129660c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129662f
            java.lang.String r3 = "getSimpleName(...)"
            java.lang.Class<cz.mobilesoft.coreblock.util.runnability.ServiceHelper> r4 = cz.mobilesoft.coreblock.util.runnability.ServiceHelper.class
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L40
            if (r2 != r5) goto L38
            java.lang.Object r10 = r0.f129659b
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r0 = r0.f129658a
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6d
            goto L69
        L36:
            r10 = move-exception
            goto L9e
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            kotlin.ResultKt.b(r11)
            r11 = 7
            r2 = 0
            kotlinx.coroutines.flow.MutableSharedFlow r11 = kotlinx.coroutines.flow.SharedFlowKt.b(r2, r2, r6, r11, r6)
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper.f129654c = r11
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef
            r11.<init>()
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$2 r2 = new cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceRunningByPoll$2     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            r2.<init>(r11, r6)     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            r0.f129658a = r10     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            r0.f129659b = r11     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            r0.f129662f = r5     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            r7 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.c(r7, r2, r0)     // Catch: java.lang.Throwable -> L36 java.util.concurrent.CancellationException -> L6c
            if (r10 != r1) goto L68
            return r1
        L68:
            r10 = r11
        L69:
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper.f129654c = r6
            goto L7a
        L6c:
            r10 = r11
        L6d:
            java.lang.String r11 = "Canceled"
            java.lang.String r0 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L36
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.Throwable -> L36
            android.util.Log.d(r0, r11)     // Catch: java.lang.Throwable -> L36
            goto L69
        L7a:
            boolean r11 = r10.f140137a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Returning "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r0 = r4.getSimpleName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.util.Log.d(r0, r11)
            boolean r10 = r10.f140137a
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r10)
            return r10
        L9e:
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper.f129654c = r6
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.ServiceHelper.e(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Class clsF = LockieApplication.f();
        Intrinsics.checkNotNullExpressionValue(clsF, "getAccessibilityServiceClass(...)");
        return h(context, clsF);
    }

    public static final boolean h(Context context, Class serviceClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return true;
        }
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            if (runningServices == null) {
                return false;
            }
            Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(serviceClass.getName(), it.next().service.getClassName())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(android.content.Context r5, kotlinx.coroutines.CoroutineScope r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceStopped$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceStopped$1 r0 = (cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceStopped$1) r0
            int r1 = r0.f129670f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129670f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceStopped$1 r0 = new cz.mobilesoft.coreblock.util.runnability.ServiceHelper$isAccessibilityServiceStopped$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f129668c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129670f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f129667b
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            java.lang.Object r5 = r0.f129666a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r7)
            goto L67
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r7)
            boolean r7 = g(r5)
            if (r7 == 0) goto L70
            cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper r7 = cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper.f129617a
            boolean r7 = r7.P()
            if (r7 == 0) goto L71
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r7 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            boolean r7 = r7.C1()
            if (r7 == 0) goto L71
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f129666a = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f129667b = r5
            r0.f129670f = r3
            java.lang.Object r7 = r4.e(r6, r0)
            if (r7 != r1) goto L67
            return r1
        L67:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r5 = r7.booleanValue()
            if (r5 != 0) goto L70
            goto L71
        L70:
            r3 = 0
        L71:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.ServiceHelper.f(android.content.Context, kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
