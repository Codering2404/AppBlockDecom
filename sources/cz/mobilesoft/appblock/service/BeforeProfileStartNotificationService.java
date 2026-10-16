package cz.mobilesoft.appblock.service;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import cz.mobilesoft.coreblock.dto.events.EventWithIdsDTO;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
public final class BeforeProfileStartNotificationService extends ForegroundServiceLauncher.ForegroundService {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f94079m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f94080n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ForegroundServiceLauncher f94081o = new ForegroundServiceLauncher(BeforeProfileStartNotificationService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NotificationDismissed f94082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f94083c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BeforeProfileStartNotificationService.D(this.f94752a);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f94084d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f94085f = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f94086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f94087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f94088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f94089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CountDownTimer f94090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f94091l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, long j3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putLong("INTERVAL_ID", j3);
            BeforeProfileStartNotificationService.f94081o.f(context, bundle);
        }

        public final void b(Context context) throws Throwable {
            Intrinsics.checkNotNullParameter(context, "context");
            BeforeProfileStartNotificationService.f94081o.g(context);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class NotificationDismissed extends BroadcastReceiver {
        public NotificationDismissed() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            BeforeProfileStartNotificationService.this.H();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeforeProfileStartNotificationService() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94086g = LazyKt.a(lazyThreadSafetyMode, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(NotificationDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94087h = LazyKt.a(lazyThreadSafetyMode, new Function0<IntervalDao>() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(IntervalDao.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f94088i = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f94089j = LazyKt.a(lazyThreadSafetyMode, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(EventDataStore.class), objArr6, objArr7);
            }
        });
        this.f94091l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BeforeProfileStartNotificationService.E(this.f94755a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationDataStore A() {
        return (NotificationDataStore) this.f94086g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManagerCompat B() {
        return (NotificationManagerCompat) this.f94083c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao C() {
        return (ProfileDao) this.f94088i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManagerCompat D(BeforeProfileStartNotificationService beforeProfileStartNotificationService) {
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(beforeProfileStartNotificationService.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        return notificationManagerCompatD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 E(final BeforeProfileStartNotificationService beforeProfileStartNotificationService) {
        return new Function0() { // from class: cz.mobilesoft.appblock.service.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BeforeProfileStartNotificationService.F(this.f95052a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Notification F(BeforeProfileStartNotificationService beforeProfileStartNotificationService) {
        return beforeProfileStartNotificationService.y(null).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final BeforeProfileStartNotificationService beforeProfileStartNotificationService, final long j3) {
        FlowExtKt.l(beforeProfileStartNotificationService.x().f1(), beforeProfileStartNotificationService.f94085f, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithIdsDTO eventWithIdsDTO, Continuation continuation) {
                this.f94093a.f94084d.removeAll(eventWithIdsDTO.getIds());
                if (this.f94093a.f94084d.isEmpty()) {
                    this.f94093a.H();
                }
                return Unit.f139807a;
            }
        });
        FlowExtKt.l(beforeProfileStartNotificationService.x().V0(), beforeProfileStartNotificationService.f94085f, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithIdsDTO eventWithIdsDTO, Continuation continuation) {
                List<Long> ids = eventWithIdsDTO.getIds();
                BeforeProfileStartNotificationService beforeProfileStartNotificationService2 = this.f94094a;
                long j4 = j3;
                Iterator<T> it = ids.iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    if (jLongValue != -1 && beforeProfileStartNotificationService2.f94084d.contains(Boxing.e(jLongValue))) {
                        beforeProfileStartNotificationService2.f94084d.remove(Boxing.e(j4));
                        if (beforeProfileStartNotificationService2.f94084d.isEmpty()) {
                            beforeProfileStartNotificationService2.H();
                        }
                    }
                }
                return Unit.f139807a;
            }
        });
        BuildersKt__Builders_commonKt.d(beforeProfileStartNotificationService.f94085f, null, null, new BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3(beforeProfileStartNotificationService, j3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        CountDownTimer countDownTimer = this.f94090k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        stopForeground(1);
        stopSelf();
    }

    private final EventDataStore x() {
        return (EventDataStore) this.f94089j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationCompat.Builder y(String str) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return NotificationHelper.k(applicationContext, str, "before_start_notif_opened");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntervalDao z() {
        return (IntervalDao) this.f94087h.getValue();
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public int g() {
        return 10002;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public Function0 h() {
        return (Function0) this.f94091l.getValue();
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f94081o.e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.d(this.f94085f, null);
        try {
            unregisterReceiver(this.f94082b);
            this.f94082b = null;
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (intent == null || intent.getLongExtra("INTERVAL_ID", 0L) == 0) {
            H();
            return 2;
        }
        final long longExtra = intent.getLongExtra("INTERVAL_ID", 0L);
        this.f94084d.add(Long.valueOf(longExtra));
        try {
            Notification notificationC = y("").c();
            Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
            startForeground(g(), notificationC);
            InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.j
                @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
                public final void onInitialized() {
                    BeforeProfileStartNotificationService.G(this.f94748a, longExtra);
                }
            });
            return 1;
        } catch (Exception e3) {
            H();
            CrashHelper.j(e3);
            return 2;
        }
    }
}
