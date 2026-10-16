package cz.mobilesoft.coreblock.service;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class CheckGrantedPermissionService extends ForegroundServiceLauncher.ForegroundService implements KoinComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Runnable f123095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Handler f123096m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Permission f123098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ComponentName f123099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f123100d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f123102g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f123093j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f123094k = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Lazy f123097n = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.service.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CheckGrantedPermissionService.p();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f123101f = System.currentTimeMillis();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f123103h = 10006;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0 f123104i = new Function0() { // from class: cz.mobilesoft.coreblock.service.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CheckGrantedPermissionService.q(this.f123148a);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ForegroundServiceLauncher b() {
            return (ForegroundServiceLauncher) CheckGrantedPermissionService.f123097n.getValue();
        }

        public final void c(Context context, Permission permission, String str, ComponentName source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permission, "permission");
            Intrinsics.checkNotNullParameter(source, "source");
            b().f(context, BundleKt.b(TuplesKt.a("PERMISSIONS", permission), TuplesKt.a(ShareConstants.TITLE, str), TuplesKt.a("SOURCE", source)));
        }

        public final void d(Context context) throws Throwable {
            Intrinsics.checkNotNullParameter(context, "context");
            b().g(context);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m(cz.mobilesoft.coreblock.enums.Permission r8) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.CheckGrantedPermissionService.m(cz.mobilesoft.coreblock.enums.Permission):void");
    }

    private final void n() {
        Handler handler;
        String simpleName = CheckGrantedPermissionService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, "Stopping");
        Runnable runnable = f123095l;
        if (runnable != null && (handler = f123096m) != null) {
            handler.removeCallbacks(runnable);
        }
        stopForeground(1);
        stopSelf();
    }

    private final Notification o() {
        Context applicationContext = getApplicationContext();
        NotificationChannelHelper.Channel channel = NotificationChannelHelper.Channel.STATE;
        int i3 = R.string.Gf;
        int i4 = R.string.f95790f1;
        String string = applicationContext.getString(i3, applicationContext.getString(i4));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(applicationContext, channel.getId());
        String string2 = this.f123100d;
        if (string2 == null) {
            string2 = applicationContext.getString(i4);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        NotificationCompat.Builder builderF = builder.n(string2).m(string).D(new NotificationCompat.BigTextStyle().h(string)).B(R.drawable.C0).k(ContextCompat.getColor(applicationContext, R.color.f95446a)).f(true);
        Intrinsics.checkNotNullExpressionValue(builderF, "setAutoCancel(...)");
        builderF.x(2);
        Notification notificationC = builderF.c();
        Intrinsics.checkNotNullExpressionValue(notificationC, "build(...)");
        return notificationC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ForegroundServiceLauncher p() {
        return new ForegroundServiceLauncher(CheckGrantedPermissionService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Notification q(CheckGrantedPermissionService checkGrantedPermissionService) {
        return checkGrantedPermissionService.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CheckGrantedPermissionService checkGrantedPermissionService) {
        Permission permission = checkGrantedPermissionService.f123098b;
        if (permission != null) {
            checkGrantedPermissionService.m(permission);
        }
    }

    private final void s() {
        ComponentName componentName = this.f123099c;
        if (componentName != null) {
            if (Build.VERSION.SDK_INT < 29 || PermissionHelper.g(this) || !PermissionsManager.f129021a.C(this)) {
                Intent intent = new Intent();
                intent.setComponent(componentName);
                intent.addFlags(872415232);
                startActivity(intent);
            } else {
                JobHelper.N(componentName);
            }
        }
        n();
    }

    public static final void t(Context context, Permission permission, String str, ComponentName componentName) {
        f123093j.c(context, permission, str, componentName);
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public int g() {
        return this.f123103h;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService
    public Function0 h() {
        return this.f123104i;
    }

    @Override // cz.mobilesoft.coreblock.service.ForegroundServiceLauncher.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f123096m = new Handler();
        f123095l = new Runnable() { // from class: cz.mobilesoft.coreblock.service.c
            @Override // java.lang.Runnable
            public final void run() {
                CheckGrantedPermissionService.r(this.f123149a);
            }
        };
        f123093j.b().e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Handler handler;
        String simpleName = CheckGrantedPermissionService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, "On destroy");
        Runnable runnable = f123095l;
        if (runnable != null && (handler = f123096m) != null) {
            handler.removeCallbacks(runnable);
        }
        stopForeground(1);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        Handler handler;
        Bundle extras;
        String simpleName = CheckGrantedPermissionService.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, "Starting");
        this.f123101f = System.currentTimeMillis();
        this.f123100d = intent != null ? intent.getStringExtra(ShareConstants.TITLE) : null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            Serializable serializable = extras.getSerializable("PERMISSIONS");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type cz.mobilesoft.coreblock.enums.Permission");
            this.f123098b = (Permission) serializable;
            this.f123099c = (ComponentName) extras.getParcelable("SOURCE");
        }
        Runnable runnable = f123095l;
        if (runnable != null && (handler = f123096m) != null) {
            handler.post(runnable);
        }
        try {
            startForeground(10006, o());
            return 2;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return 2;
        }
    }

    @Override // android.app.Service
    public void onTimeout(int i3) throws Throwable {
        f123093j.b().g(this);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
