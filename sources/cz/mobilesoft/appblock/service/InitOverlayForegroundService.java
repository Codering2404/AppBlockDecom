package cz.mobilesoft.appblock.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.os.UserManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.facebook.ads.AdError;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.coreblock.storage.datastore.DirectBootDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.context.GlobalContext;

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
public final class InitOverlayForegroundService extends Service {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f94152o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f94153p = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EventDataStore f94155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f94156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WindowManager f94157d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f94158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f94159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Job f94160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f94161i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f94163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f94164l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Job f94166n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94154a = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f94162j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BroadcastReceiver f94165m = new BroadcastReceiver() { // from class: cz.mobilesoft.appblock.service.InitOverlayForegroundService$koinInitializedReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual("cz.mobilesoft.appblock.ACTION_KOIN_INITIALIZED", intent != null ? intent.getAction() : null)) {
                Log.d("InitOverlayService", "Koin initialized broadcast received");
                this.f94180a.F("koin_broadcast");
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RequiredServices {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f94167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f94168b;

        public RequiredServices(boolean z2, boolean z3) {
            this.f94167a = z2;
            this.f94168b = z3;
        }

        public final boolean a() {
            return this.f94168b;
        }

        public final boolean b() {
            return this.f94167a || this.f94168b;
        }

        public final boolean c() {
            return this.f94167a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequiredServices)) {
                return false;
            }
            RequiredServices requiredServices = (RequiredServices) obj;
            return this.f94167a == requiredServices.f94167a && this.f94168b == requiredServices.f94168b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f94167a) * 31) + Boolean.hashCode(this.f94168b);
        }

        public String toString() {
            return "RequiredServices(needsAppBlocking=" + this.f94167a + ", needsAccessibility=" + this.f94168b + ")";
        }
    }

    private final void A() {
        BuildersKt__Builders_commonKt.d(this.f94154a, null, null, new InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(RequiredServices requiredServices) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(!requiredServices.c());
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(!requiredServices.a());
        Function0 function0 = new Function0() { // from class: cz.mobilesoft.appblock.service.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InitOverlayForegroundService.C(atomicBoolean, atomicBoolean2, this);
            }
        };
        if (requiredServices.c()) {
            BuildersKt__Builders_commonKt.d(this.f94154a, null, null, new InitOverlayForegroundService$startWatchingForRequiredServices$1(this, atomicBoolean, function0, null), 3, null);
        }
        if (requiredServices.a()) {
            BuildersKt__Builders_commonKt.d(this.f94154a, null, null, new InitOverlayForegroundService$startWatchingForRequiredServices$2(this, atomicBoolean2, function0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, InitOverlayForegroundService initOverlayForegroundService) {
        if (atomicBoolean.get() && atomicBoolean2.get()) {
            Log.d("InitOverlayService", "initOverlayService all required services ready -> removing overlay");
            initOverlayForegroundService.D("all_required_services_ready");
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String str) {
        if (!this.f94162j.compareAndSet(false, true)) {
            Log.d("InitOverlayService", "initOverlayService stop already in progress, ignoring reason=" + str);
            return;
        }
        l(str);
        t();
        InitOverlayBootDedupStore.f94149a.a(this);
        stopForeground(1);
        stopSelf();
    }

    static /* synthetic */ void E(InitOverlayForegroundService initOverlayForegroundService, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "normal";
        }
        initOverlayForegroundService.D(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F(String str) {
        if (this.f94161i) {
            return true;
        }
        boolean z2 = GlobalContext.f145907a.b() != null;
        this.f94156c = z2;
        if (!z2) {
            return false;
        }
        if (!q()) {
            Log.w("InitOverlayService", "EventDataStore initialization failed, removing overlay");
            D("event_datastore_init_failed_" + str);
            return true;
        }
        this.f94161i = true;
        Log.d("InitOverlayService", "initOverlayService koin ready -> ready flow started source=" + str);
        G(this.f94165m, "Koin initialized");
        A();
        return true;
    }

    private final void G(BroadcastReceiver broadcastReceiver, String str) {
        try {
            unregisterReceiver(broadcastReceiver);
            Log.d("InitOverlayService", str + " receiver unregistered");
        } catch (IllegalArgumentException unused) {
            Log.d("InitOverlayService", str + " receiver already unregistered or not registered");
        } catch (Exception e3) {
            Log.e("InitOverlayService", "Failed to unregister " + str + " receiver", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(1000, r0) == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ca -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(kotlinx.coroutines.flow.Flow r11, java.lang.String r12, kotlin.jvm.functions.Function0 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService.H(kotlinx.coroutines.flow.Flow, java.lang.String, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void l(String str) {
        Job job = this.f94160h;
        if (job != null) {
            if (job.isActive()) {
                Log.d("InitOverlayService", "initOverlayService hardTimeout cancelled reason=" + str);
            }
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f94160h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequiredServices m() {
        return new RequiredServices(true, PermissionHelper.l(this));
    }

    private final void o() {
        NotificationChannel notificationChannel = new NotificationChannel("init_overlay_notification", "AppBlock Initialization", 2);
        notificationChannel.setDescription("Shows while AppBlock is initializing");
        notificationChannel.setShowBadge(false);
        Object systemService = getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
            Log.d("InitOverlayService", "Notification channel created");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$1 r0 = (cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$1) r0
            int r1 = r0.f94171c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f94171c = r1
            goto L18
        L13:
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$1 r0 = new cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f94169a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f94171c
            java.lang.String r3 = "InitOverlayService"
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L2b
            goto L49
        L2b:
            r7 = move-exception
            goto L57
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$2 r7 = new cz.mobilesoft.appblock.service.InitOverlayForegroundService$determineRequiredServicesSafely$2     // Catch: java.lang.Exception -> L2b
            r2 = 0
            r7.<init>(r6, r2)     // Catch: java.lang.Exception -> L2b
            r0.f94171c = r4     // Catch: java.lang.Exception -> L2b
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r4, r7, r0)     // Catch: java.lang.Exception -> L2b
            if (r7 != r1) goto L49
            return r1
        L49:
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$RequiredServices r7 = (cz.mobilesoft.appblock.service.InitOverlayForegroundService.RequiredServices) r7     // Catch: java.lang.Exception -> L2b
            if (r7 != 0) goto L56
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$RequiredServices r7 = r6.m()     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = "initOverlayService required-services check timeout, keeping overlay conservatively"
            android.util.Log.w(r3, r0)     // Catch: java.lang.Exception -> L2b
        L56:
            return r7
        L57:
            java.lang.String r0 = "initOverlayService required-services check failed, keeping overlay conservatively"
            android.util.Log.w(r3, r0, r7)
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$RequiredServices r7 = r6.m()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean q() {
        if (this.f94155b != null) {
            return true;
        }
        try {
            Koin koinB = GlobalContext.f145907a.b();
            if (koinB == null) {
                Log.e("InitOverlayService", "Koin not available during initializeEventDataStore");
                return false;
            }
            this.f94155b = (EventDataStore) koinB.j().d().e(Reflection.b(EventDataStore.class), null, null);
            Log.d("InitOverlayService", "EventDataStore injected via Koin DI");
            return true;
        } catch (Exception e3) {
            Log.e("InitOverlayService", "Failed to initialize EventDataStore", e3);
            return false;
        }
    }

    private final void r() {
        s(this.f94165m, new IntentFilter("cz.mobilesoft.appblock.ACTION_KOIN_INITIALIZED"), "Koin initialized");
    }

    private final void s(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        try {
            registerReceiver(broadcastReceiver, intentFilter, 4);
            Log.d("InitOverlayService", str + " receiver registered");
        } catch (Exception e3) {
            Log.e("InitOverlayService", "Failed to register " + str + " receiver", e3);
        }
    }

    private final void t() {
        View view = this.f94158f;
        if (view == null || !this.f94159g) {
            return;
        }
        try {
            try {
                WindowManager windowManager = this.f94157d;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                windowManager.removeView(view);
                Log.d("InitOverlayService", "Init overlay removed successfully");
            } catch (Exception e3) {
                Log.e("InitOverlayService", "Failed to remove init overlay", e3);
            }
            this.f94159g = false;
            this.f94158f = null;
        } catch (Throwable th) {
            this.f94159g = false;
            this.f94158f = null;
            throw th;
        }
    }

    private final void u() {
        if (this.f94159g) {
            Log.d("InitOverlayService", "Overlay already attached, skipping");
            return;
        }
        try {
            this.f94158f = LayoutInflater.from(this).inflate(R.layout.view_init_overlay, (ViewGroup) null, false);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 67336, -3);
            layoutParams.layoutInDisplayCutoutMode = 1;
            WindowManager windowManager = this.f94157d;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            windowManager.addView(this.f94158f, layoutParams);
            this.f94159g = true;
            Log.d("InitOverlayService", "Init overlay shown successfully");
            y();
            View view = this.f94158f;
            if (view != null) {
                view.post(new Runnable() { // from class: cz.mobilesoft.appblock.service.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        InitOverlayForegroundService.v(this.f95072a);
                    }
                });
            }
        } catch (Exception e3) {
            Log.e("InitOverlayService", "Failed to show init overlay", e3);
            E(this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(InitOverlayForegroundService initOverlayForegroundService) {
        View view = initOverlayForegroundService.f94158f;
        Integer numValueOf = view != null ? Integer.valueOf(view.getWidth()) : null;
        View view2 = initOverlayForegroundService.f94158f;
        Integer numValueOf2 = view2 != null ? Integer.valueOf(view2.getHeight()) : null;
        View view3 = initOverlayForegroundService.f94158f;
        Log.d("InitOverlayService", "Init overlay size: " + numValueOf + "x" + numValueOf2 + ", isShown=" + (view3 != null ? Boolean.valueOf(view3.isShown()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        u();
        if (F("immediate_after_overlay")) {
            return;
        }
        r();
        F("post_register");
    }

    private final void x() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                startForeground(AdError.NO_FILL_ERROR_CODE, n(), 1073741824);
            } else {
                startForeground(AdError.NO_FILL_ERROR_CODE, n());
            }
        } catch (Exception e3) {
            Log.e("InitOverlayService", "Error starting foreground service", e3);
        }
    }

    private final void y() {
        if (this.f94159g) {
            Job job = this.f94160h;
            if (job == null || !job.isActive()) {
                this.f94160h = BuildersKt__Builders_commonKt.d(this.f94154a, null, null, new InitOverlayForegroundService$startIndependentHardTimeout$1(this, null), 3, null);
            }
        }
    }

    private final void z(UserManager userManager) {
        this.f94166n = BuildersKt__Builders_commonKt.d(this.f94154a, null, null, new InitOverlayForegroundService$startPollingForUserUnlock$1(userManager, this, null), 3, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("InitOverlayService", "onCreate() called");
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f94157d = (WindowManager) systemService;
        o();
        boolean zB = DirectBootDataStore.f124280d.b(this);
        Log.d("InitOverlayService", "Is init overlay enabled: " + zB);
        if (!zB) {
            Log.d("InitOverlayService", "Init overlay is disabled, stopping service safely");
            x();
            stopSelf();
            return;
        }
        Object systemService2 = getSystemService("user");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.UserManager");
        UserManager userManager = (UserManager) systemService2;
        boolean z2 = !userManager.isUserUnlocked();
        this.f94163k = z2;
        Log.d("InitOverlayService", "Direct boot mode: " + z2 + ", isUserUnlocked: " + userManager.isUserUnlocked());
        this.f94156c = GlobalContext.f145907a.b() != null;
        x();
        if (!this.f94163k) {
            w();
        } else {
            this.f94164l = true;
            z(userManager);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d("InitOverlayService", "onDestroy() called");
        t();
        G(this.f94165m, "Koin initialized");
        CoroutineScopeKt.e(this.f94154a, null, 1, null);
        Log.d("InitOverlayService", "onDestroy() completed");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        Log.d("InitOverlayService", "onStartCommand called, isDirectBootMode=" + this.f94163k + ", isOverlayPendingFromBoot=" + this.f94164l + ", intent=" + intent);
        if (!(intent != null ? intent.getBooleanExtra("extra_is_boot", false) : false)) {
            Log.d("InitOverlayService", "Service started without EXTRA_IS_BOOT, stopping");
            stopSelf();
            return 2;
        }
        x();
        if (this.f94163k && this.f94164l) {
            return 3;
        }
        u();
        if (!this.f94161i) {
            F("onStartCommand");
        }
        return 3;
    }

    private final Notification n() {
        Notification notificationC = new NotificationCompat.Builder(this, "init_overlay_notification").n("AppBlock").m(HcgZcEUYo.dmNYGsAjgBCyN).B(R.drawable.ic_appblock_notification).x(-1).v(true).c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        return notificationC;
    }
}
