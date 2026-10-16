package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CrashlyticsCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f88379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseApp f88380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataCollectionArbiter f88381c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CrashlyticsFileMarker f88384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CrashlyticsFileMarker f88385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f88386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CrashlyticsController f88387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IdManager f88388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FileStore f88389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BreadcrumbSource f88390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AnalyticsEventLogger f88391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f88392n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CrashlyticsNativeComponent f88393o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final RemoteConfigDeferredProxy f88394p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final CrashlyticsWorkers f88395q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f88383e = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OnDemandCounter f88382d = new OnDemandCounter();

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, RemoteConfigDeferredProxy remoteConfigDeferredProxy, CrashlyticsWorkers crashlyticsWorkers) {
        this.f88380b = firebaseApp;
        this.f88381c = dataCollectionArbiter;
        this.f88379a = firebaseApp.l();
        this.f88388j = idManager;
        this.f88393o = crashlyticsNativeComponent;
        this.f88390l = breadcrumbSource;
        this.f88391m = analyticsEventLogger;
        this.f88389k = fileStore;
        this.f88392n = crashlyticsAppQualitySessionsSubscriber;
        this.f88394p = remoteConfigDeferredProxy;
        this.f88395q = crashlyticsWorkers;
    }

    private void i() {
        try {
            this.f88386h = Boolean.TRUE.equals((Boolean) this.f88395q.f88491a.c().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.common.k
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f88475a.f88387i.r());
                }
            }).get(3L, TimeUnit.SECONDS));
        } catch (Exception unused) {
            this.f88386h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(SettingsProvider settingsProvider) {
        CrashlyticsWorkers.c();
        t();
        try {
            try {
                this.f88390l.a(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.m
                    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                    public final void a(String str) {
                        this.f88478a.q(str);
                    }
                });
                this.f88387i.Q();
                if (!settingsProvider.b().f89052b.f89059a) {
                    Logger.f().b("Collection of crash reports disabled in Crashlytics settings.");
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.f88387i.y(settingsProvider)) {
                    Logger.f().k("Previous sessions could not be finalized.");
                }
                this.f88387i.U(settingsProvider.a());
                s();
            } catch (Exception e3) {
                Logger.f().e("Crashlytics encountered a problem during asynchronous initialization.", e3);
                s();
            }
        } catch (Throwable th) {
            s();
            throw th;
        }
    }

    private void n(final SettingsProvider settingsProvider) {
        Future<?> futureSubmit = this.f88395q.f88491a.c().submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f88476a.l(settingsProvider);
            }
        });
        Logger.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e3) {
            Logger.f().e("Crashlytics was interrupted during initialization.", e3);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e4) {
            Logger.f().e("Crashlytics encountered a problem during initialization.", e4);
        } catch (TimeoutException e5) {
            Logger.f().e("Crashlytics timed out during initialization.", e5);
        }
    }

    public static String o() {
        return "20.0.2";
    }

    static boolean p(String str, boolean z2) {
        if (!z2) {
            Logger.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    public boolean j() {
        return this.f88386h;
    }

    boolean k() {
        return this.f88384f.c();
    }

    public Task m(final SettingsProvider settingsProvider) {
        return this.f88395q.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f88473a.l(settingsProvider);
            }
        });
    }

    public void q(final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis() - this.f88383e;
        this.f88395q.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.h
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsCore crashlyticsCore = this.f88467a;
                crashlyticsCore.f88395q.f88492b.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        crashlyticsCore.f88387i.Y(j, str);
                    }
                });
            }
        });
    }

    public void r(final Throwable th, final Map map) {
        this.f88395q.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f88464a.f88387i.X(Thread.currentThread(), th, map);
            }
        });
    }

    void s() {
        CrashlyticsWorkers.c();
        try {
            if (this.f88384f.d()) {
                return;
            }
            Logger.f().k("Initialization marker file was not properly removed.");
        } catch (Exception e3) {
            Logger.f().e("Problem encountered deleting Crashlytics initialization marker.", e3);
        }
    }

    void t() {
        CrashlyticsWorkers.c();
        this.f88384f.a();
        Logger.f().i("Initialization marker file was created.");
    }

    public boolean u(AppData appData, SettingsProvider settingsProvider) {
        if (!p(appData.f88299b, CommonUtils.i(this.f88379a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String strC = new CLSUUID().c();
        try {
            this.f88385g = new CrashlyticsFileMarker("crash_marker", this.f88389k);
            this.f88384f = new CrashlyticsFileMarker("initialization_marker", this.f88389k);
            UserMetadata userMetadata = new UserMetadata(strC, this.f88389k, this.f88395q);
            LogFileManager logFileManager = new LogFileManager(this.f88389k);
            MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
            this.f88394p.b(userMetadata);
            this.f88387i = new CrashlyticsController(this.f88379a, this.f88388j, this.f88381c, this.f88389k, this.f88385g, appData, userMetadata, logFileManager, SessionReportingCoordinator.j(this.f88379a, this.f88388j, this.f88389k, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsProvider, this.f88382d, this.f88392n, this.f88395q), this.f88393o, this.f88391m, this.f88392n, this.f88395q);
            boolean zK = k();
            i();
            this.f88387i.w(strC, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
            if (!zK || !CommonUtils.d(this.f88379a)) {
                Logger.f().b("Successfully configured exception handler.");
                return true;
            }
            Logger.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            n(settingsProvider);
            return false;
        } catch (Exception e3) {
            Logger.f().e("Crashlytics was not started due to an exception during initialization", e3);
            this.f88387i = null;
            return false;
        }
    }

    public void v(Boolean bool) {
        this.f88381c.h(bool);
    }

    public void w(final String str, final String str2) {
        this.f88395q.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f88461a.f88387i.R(str, str2);
            }
        });
    }

    public void x(final String str) {
        this.f88395q.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f88459a.f88387i.T(str);
            }
        });
    }
}
