package cz.mobilesoft.coreblock;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.UserManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDexApplication;
import androidx.work.Configuration;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.GlobalExceptionHandler;
import cz.mobilesoft.coreblock.util.LockieActivityLifecycleCallbacks;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.lang.Thread;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class LockieApplication extends MultiDexApplication implements Configuration.Provider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f95358c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f95359d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f95360f = "cz.mobilesoft.coreblock";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f95361g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f95363i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f95366a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f95367b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f95362h = TimeHelperExt.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class f95364j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static CoroutineScope f95365k = CoroutineScopeKt.a(SupervisorKt.a(null).plus(CoroutinesHelperExtKt.b()));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UserUnlockedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_UNLOCKED".equals(intent.getAction())) {
                ((LockieApplication) context.getApplicationContext()).q();
            }
        }

        public UserUnlockedReceiver() {
        }
    }

    public static /* synthetic */ void c(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            InitHelper.l();
        }
    }

    private void e() {
        if (this.f95366a) {
            Log.d("LockieApplication", "Already fully initialized, skipping");
            return;
        }
        this.f95366a = true;
        m();
        InitHelper.m(this, f95361g);
        v();
        registerActivityLifecycleCallbacks(new LockieActivityLifecycleCallbacks());
        u();
        t();
    }

    public static Class f() {
        return f95364j;
    }

    public static Context g() {
        return f95361g;
    }

    public static LockieApplication i(Context context) {
        return (LockieApplication) context.getApplicationContext();
    }

    public static String l() {
        return f95358c;
    }

    private void m() {
        try {
            PrefManager prefManager = PrefManager.f126839a;
            prefManager.z1(f95361g);
            AppCompatDelegate.T(prefManager.w0());
        } catch (Exception e3) {
            Log.e("LockieApplication", "Failed to initialize PrefManager", e3);
        }
    }

    private boolean n(UserManager userManager) {
        return (userManager == null || userManager.isUserUnlocked()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Log.d("LockieApplication", "USER_UNLOCKED received, performing full initialization");
        try {
            unregisterReceiver(this.f95367b);
        } catch (IllegalArgumentException e3) {
            Log.w("LockieApplication", "Receiver already unregistered", e3);
        }
        e();
    }

    public static void r(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void s() {
        this.f95367b = new UserUnlockedReceiver();
        registerReceiver(this.f95367b, new IntentFilter("android.intent.action.USER_UNLOCKED"));
    }

    private void t() {
        Intent intent = new Intent("cz.mobilesoft.appblock.ACTION_KOIN_INITIALIZED");
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
        Log.d("LockieApplication", "Koin initialized broadcast sent");
    }

    private void u() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler(f95361g, defaultUncaughtExceptionHandler));
        }
    }

    private void v() {
        ProcessLifecycleOwner.l().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: cz.mobilesoft.coreblock.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LockieApplication.c(lifecycleOwner, event);
            }
        });
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.work.Configuration.Provider
    public Configuration b() {
        return new Configuration.Builder().a();
    }

    public String h() {
        return Application.getProcessName();
    }

    public abstract List j();

    public abstract List k();

    public boolean o() {
        String strH = h();
        f95363i = strH;
        return p(strH);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f95361g = getApplicationContext();
        AppCompatDelegate.P(true);
        if (n((UserManager) getSystemService(UserManager.class))) {
            s();
        } else {
            e();
        }
    }

    public boolean p(String str) {
        return !str.equals(getPackageName());
    }
}
