package cz.mobilesoft.appblock.service;

import android.app.Notification;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import cz.mobilesoft.coreblock.dto.events.EventWithIdsDTO;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
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
public final class BeforeProfilePauseEndNotificationService extends ForegroundServiceLauncher.ForegroundService {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f94036i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f94037j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ForegroundServiceLauncher f94038k = new ForegroundServiceLauncher(BeforeProfilePauseEndNotificationService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94039b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BeforeProfilePauseEndNotificationService.y(this.f94728a);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f94040c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f94041d = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f94042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f94043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f94044h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, long j3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            bundle.putLong("PROFILE_ID", j3);
            BeforeProfilePauseEndNotificationService.f94038k.f(context, bundle);
        }

        public final void b(Context context) throws Throwable {
            Intrinsics.checkNotNullParameter(context, "context");
            BeforeProfilePauseEndNotificationService.f94038k.g(context);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeforeProfilePauseEndNotificationService() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94042f = LazyKt.a(lazyThreadSafetyMode, new Function0<ProfileDao>() { // from class: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f94043g = LazyKt.a(lazyThreadSafetyMode, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
        this.f94044h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.appblock.service.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BeforeProfilePauseEndNotificationService.z(this.f94730a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Notification A(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService) {
        return beforeProfilePauseEndNotificationService.v(null).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(final BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3) {
        FlowExtKt.l(beforeProfilePauseEndNotificationService.u().g1(), beforeProfilePauseEndNotificationService.f94041d, new FlowCollector() { // from class: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(EventWithIdsDTO eventWithIdsDTO, Continuation continuation) {
                if (!eventWithIdsDTO.getIds().isEmpty() && this.f94045a.f94040c.removeAll(eventWithIdsDTO.getIds()) && this.f94045a.f94040c.isEmpty()) {
                    this.f94045a.E();
                }
                return Unit.f139807a;
            }
        });
        BuildersKt__Builders_commonKt.d(beforeProfilePauseEndNotificationService.f94041d, null, null, new BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2(beforeProfilePauseEndNotificationService, j3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object C(long j3, NotificationCompat.Builder builder, Continuation continuation) {
        return BuildersKt.g(Dispatchers.c(), new BeforeProfilePauseEndNotificationService$startForegroundOrSafelyStop$2(this, j3, builder, null), continuation);
    }

    static /* synthetic */ Object D(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, NotificationCompat.Builder builder, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            builder = null;
        }
        return beforeProfilePauseEndNotificationService.C(j3, builder, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        stopForeground(1);
        stopSelf();
    }

    private final EventDataStore u() {
        return (EventDataStore) this.f94043g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationCompat.Builder v(String str) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return NotificationHelper.k(applicationContext, str, "before_pause_end_notif_opened");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManagerCompat w() {
        return (NotificationManagerCompat) this.f94039b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao x() {
        return (ProfileDao) this.f94042f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManagerCompat y(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService) {
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(beforeProfilePauseEndNotificationService.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        return notificationManagerCompatD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 z(final BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService) {
        return new Function0() { // from class: cz.mobilesoft.appblock.service.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BeforeProfilePauseEndNotificationService.A(this.f94739a);
            }
        };
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public int g() {
        return 100014;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public Function0 h() {
        return (Function0) this.f94044h.getValue();
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f94038k.e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.d(this.f94041d, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (intent != null) {
            Long lValueOf = Long.valueOf(intent.getLongExtra("PROFILE_ID", 0L));
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                final long jLongValue = lValueOf.longValue();
                InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.e
                    @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
                    public final void onInitialized() {
                        BeforeProfilePauseEndNotificationService.B(this.f94725a, jLongValue);
                    }
                });
                return 1;
            }
        }
        E();
        return 2;
    }
}
