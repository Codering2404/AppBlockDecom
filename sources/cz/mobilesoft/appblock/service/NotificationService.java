package cz.mobilesoft.appblock.service;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.util.Log;
import com.superwall.sdk.billing.BillingClientUseCaseKt;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import cz.mobilesoft.statistics.api.Statistics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NotificationService extends NotificationListenerService implements KoinComponent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f94560k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f94561l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f94562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f94565d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f94566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f94567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f94568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f94569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f94570j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$1", f = "NotificationService.kt", l = {200}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f94579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f94580c;

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$1$1", f = "NotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02611 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f94581a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f94582b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f94583c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02611(String str, long j3, Continuation continuation) {
                super(1, continuation);
                this.f94582b = str;
                this.f94583c = j3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new C02611(this.f94582b, this.f94583c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f94581a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Statistics statistics = Statistics.f133571a;
                String str = this.f94582b;
                Intrinsics.checkNotNull(str);
                statistics.R(str, this.f94583c);
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((C02611) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, long j3, Continuation continuation) {
            super(1, continuation);
            this.f94579b = str;
            this.f94580c = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f94579b, this.f94580c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94578a;
            if (i3 == 0) {
                ResultKt.b(obj);
                C02611 c02611 = new C02611(this.f94579b, this.f94580c, null);
                this.f94578a = 1;
                if (DatabaseExtKt.b(0, 0L, c02611, this, 3, null) == objF) {
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
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$2", f = "NotificationService.kt", l = {266}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f94584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f94585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f94586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f94587d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f94588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ StatusBarNotification f94589g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ NotificationService f94590h;

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.NotificationService$onNotificationPosted$2$1", f = "NotificationService.kt", l = {267}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f94591a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ NotificationService f94592b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ BlockedNotification f94593c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(NotificationService notificationService, BlockedNotification blockedNotification, Continuation continuation) {
                super(1, continuation);
                this.f94592b = notificationService;
                this.f94593c = blockedNotification;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(this.f94592b, this.f94593c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f94591a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    BlockedNotificationDao blockedNotificationDaoI = this.f94592b.i();
                    BlockedNotification blockedNotification = this.f94593c;
                    this.f94591a = 1;
                    if (blockedNotificationDaoI.n(blockedNotification, this) == objF) {
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
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, long j3, List list, StatusBarNotification statusBarNotification, NotificationService notificationService, Continuation continuation) {
            super(1, continuation);
            this.f94586c = str;
            this.f94587d = j3;
            this.f94588f = list;
            this.f94589g = statusBarNotification;
            this.f94590h = notificationService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.f94586c, this.f94587d, this.f94588f, this.f94589g, this.f94590h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String string;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94585b;
            if (i3 == 0) {
                ResultKt.b(obj);
                String str = this.f94586c;
                Intrinsics.checkNotNull(str);
                long j3 = this.f94587d;
                long jR = ((ProfileWithConfiguration) this.f94588f.get(0)).p().r();
                String string2 = this.f94589g.getNotification().extras.getString("android.title");
                Object obj2 = this.f94589g.getNotification().extras.get("android.text");
                if (obj2 instanceof String) {
                    string = (String) obj2;
                } else if (obj2 instanceof SpannableString) {
                    string = ((SpannableString) obj2).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                } else {
                    string = "";
                }
                BlockedNotification blockedNotification = new BlockedNotification(0L, str, j3, jR, string2, string, 1, null);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f94590h, blockedNotification, null);
                this.f94584a = blockedNotification;
                this.f94585b = 1;
                if (DatabaseExtKt.b(0, 0L, anonymousClass1, this, 3, null) == objF) {
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
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationService() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94562a = LazyKt.a(lazyThreadSafetyModeB, new Function0<BlockedNotificationDao>() { // from class: cz.mobilesoft.appblock.service.NotificationService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockedNotificationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94563b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.service.NotificationService$special$$inlined$inject$default$2
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
        this.f94564c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.appblock.service.NotificationService$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f94565d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<GetUsageLimitsForCurrentPeriodUseCase>() { // from class: cz.mobilesoft.appblock.service.NotificationService$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetUsageLimitsForCurrentPeriodUseCase.class), objArr6, objArr7);
            }
        });
        this.f94566f = CoroutinesHelperExtKt.a(Dispatchers.b());
        this.f94570j = CollectionsKt.emptyList();
    }

    private final void h(long j3) {
        if (j3 - LockieApplication.f95362h > BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS) {
            JobHelper.y();
            LockieApplication.f95362h = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockedNotificationDao i() {
        return (BlockedNotificationDao) this.f94562a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore j() {
        return (CoreMultiProcessDataStore) this.f94564c.getValue();
    }

    private final GetUsageLimitsForCurrentPeriodUseCase k() {
        return (GetUsageLimitsForCurrentPeriodUseCase) this.f94565d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao l() {
        return (ProfileDao) this.f94563b.getValue();
    }

    private final List m(String str) {
        List list;
        try {
            ApplicationInfo applicationInfo = getPackageManager().getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo == null) {
                return CollectionsKt.listOf(str);
            }
            String[] packagesForUid = getPackageManager().getPackagesForUid(applicationInfo.uid);
            if (packagesForUid != null && (list = ArraysKt.toList(packagesForUid)) != null) {
                return list;
            }
            return CollectionsKt.listOf(str);
        } catch (Exception unused) {
            return CollectionsKt.listOf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(NotificationService notificationService) {
        PrefManager prefManager = PrefManager.f126839a;
        if (!prefManager.H1()) {
            Context applicationContext = notificationService.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            prefManager.z1(applicationContext);
        }
        BuildersKt__Builders_commonKt.d(notificationService.f94566f, null, null, new NotificationService$onCreate$1$1(notificationService, null), 3, null);
        BuildersKt__Builders_commonKt.d(notificationService.f94566f, null, null, new NotificationService$onCreate$1$2(notificationService, null), 3, null);
    }

    @Override // android.app.Service
    public void onCreate() {
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.c1
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                NotificationService.n(this.f94720a);
            }
        });
        super.onCreate();
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d("NotificationService", "onDestroy called");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        this.f94569i = true;
        try {
            getActiveNotifications();
        } catch (SecurityException unused) {
        }
        Log.d("NotificationService", "Listener connected");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        this.f94569i = false;
        Log.d("NotificationService", "Requesting rebind");
        NotificationListenerService.requestRebind(new ComponentName(this, (Class<?>) NotificationService.class));
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification sbn) {
        List listJ;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        if (this.f94569i && this.f94568h) {
            String packageName = sbn.getPackageName();
            if (Intrinsics.areEqual(packageName, "cz.mobilesoft.appblock")) {
                return;
            }
            if (PrefManager.f126839a.G1() && Intrinsics.areEqual(sbn.getPackageName(), "android") && Intrinsics.areEqual(sbn.getNotification().getChannelId(), "FOREGROUND_SERVICE")) {
                snoozeNotification(sbn.getKey(), 86400000L);
            }
            Log.d("NotificationService", "Notification posted: " + packageName);
            Intrinsics.checkNotNull(packageName);
            List listM = m(packageName);
            List list = this.f94570j;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
                if (profileWithConfiguration.z() && profileWithConfiguration.p().m() && profileWithConfiguration.A(listM)) {
                    arrayList.add(obj);
                }
            }
            boolean z2 = (sbn.getNotification().flags & 512) != 0;
            long jF = TimeHelperExt.f128663a.f();
            if (!z2) {
                CoroutinesHelperExtKt.d(new AnonymousClass1(packageName, jF, null));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            if (arrayList.isEmpty()) {
                listJ = k().j(new GetUsageLimitsForCurrentPeriodUseCase.Params(arrayList, null, null, null, 14, null));
                if (!listJ.isEmpty() && ((UsageLimit) listJ.get(0)).m() < ((UsageLimit) listJ.get(0)).f()) {
                    return;
                }
            } else {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    ProfileWithConfiguration profileWithConfiguration2 = (ProfileWithConfiguration) obj2;
                    if (!profileWithConfiguration2.p().U(ProfileType.USAGE_LIMIT) && !profileWithConfiguration2.p().U(ProfileType.LAUNCH_COUNT)) {
                        break;
                    }
                }
                listJ = k().j(new GetUsageLimitsForCurrentPeriodUseCase.Params(arrayList, null, null, null, 14, null));
                if (!listJ.isEmpty()) {
                    return;
                }
            }
            h(jF);
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).cancel(sbn.getId());
            try {
                cancelNotification(sbn.getKey());
            } catch (SecurityException e3) {
                CrashHelper.j(e3);
            }
            if (z2) {
                return;
            }
            CoroutinesHelperExtKt.d(new AnonymousClass2(packageName, jF, arrayList, sbn, this, null));
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
