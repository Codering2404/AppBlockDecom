package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.sessions.api.CrashEventReceiver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class CrashlyticsController {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final FilenameFilter f88343t = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.c
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".ae");
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Charset f88344u = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f88345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataCollectionArbiter f88346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CrashlyticsFileMarker f88347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UserMetadata f88348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrashlyticsWorkers f88349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IdManager f88350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FileStore f88351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppData f88352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LogFileManager f88353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CrashlyticsNativeComponent f88354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AnalyticsEventLogger f88355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f88356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SessionReportingCoordinator f88357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CrashlyticsUncaughtExceptionHandler f88358n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SettingsProvider f88359o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final TaskCompletionSource f88360p = new TaskCompletionSource();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final TaskCompletionSource f88361q = new TaskCompletionSource();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final TaskCompletionSource f88362r = new TaskCompletionSource();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final AtomicBoolean f88363s = new AtomicBoolean(false);

    CrashlyticsController(Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, CrashlyticsWorkers crashlyticsWorkers) {
        this.f88345a = context;
        this.f88350f = idManager;
        this.f88346b = dataCollectionArbiter;
        this.f88351g = fileStore;
        this.f88347c = crashlyticsFileMarker;
        this.f88352h = appData;
        this.f88348d = userMetadata;
        this.f88353i = logFileManager;
        this.f88354j = crashlyticsNativeComponent;
        this.f88355k = analyticsEventLogger;
        this.f88356l = crashlyticsAppQualitySessionsSubscriber;
        this.f88357m = sessionReportingCoordinator;
        this.f88349e = crashlyticsWorkers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A() {
        SortedSet sortedSetQ = this.f88357m.q();
        if (sortedSetQ.isEmpty()) {
            return null;
        }
        return (String) sortedSetQ.first();
    }

    private static long B() {
        return E(System.currentTimeMillis());
    }

    static List C(NativeSessionFileProvider nativeSessionFileProvider, String str, FileStore fileStore, byte[] bArr) {
        File fileQ = fileStore.q(str, "user-data");
        File fileQ2 = fileStore.q(str, "keys");
        File fileQ3 = fileStore.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.d()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.g()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.e()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", DeviceRequestsHelper.DEVICE_INFO_DEVICE, nativeSessionFileProvider.a()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.f()));
        arrayList.add(N(nativeSessionFileProvider));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", fileQ));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", fileQ2));
        arrayList.add(new FileBackedNativeSessionFile("rollouts_file", "rollouts", fileQ3));
        return arrayList;
    }

    private InputStream D(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResourceAsStream(str);
        }
        Logger.f().k("Couldn't get Class Loader");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long E(long j3) {
        return j3 / 1000;
    }

    private Task K(final long j3) {
        if (z()) {
            Logger.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                Bundle bundle = new Bundle();
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", j3);
                CrashlyticsController.this.f88355k.a("_ae", bundle);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task L() {
        ArrayList arrayList = new ArrayList();
        for (File file : J()) {
            try {
                arrayList.add(K(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private static boolean M(String str, File file, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        if (file == null || !file.exists()) {
            Logger.f().k("No minidump data found for session " + str);
        }
        if (applicationExitInfo == null) {
            Logger.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && applicationExitInfo == null;
    }

    private static NativeSessionFile N(NativeSessionFileProvider nativeSessionFileProvider) {
        File fileC = nativeSessionFileProvider.c();
        return (fileC == null || !fileC.exists()) ? new BytesBackedNativeSessionFile("minidump_file", "minidump", new byte[]{0}) : new FileBackedNativeSessionFile("minidump_file", "minidump", fileC);
    }

    private static byte[] P(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private Task V() {
        if (this.f88346b.d()) {
            Logger.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f88360p.trySetResult(Boolean.FALSE);
            return Tasks.forResult(Boolean.TRUE);
        }
        Logger.f().b("Automatic data collection is disabled.");
        Logger.f().i("Notifying that unsent reports are available.");
        this.f88360p.trySetResult(Boolean.TRUE);
        Task taskOnSuccessTask = this.f88346b.j().onSuccessTask(new SuccessContinuation<Void, Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.3
            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Task then(Void r12) {
                return Tasks.forResult(Boolean.TRUE);
            }
        });
        Logger.f().b("Waiting for send/deleteUnsentReports to be called.");
        return CrashlyticsTasks.b(taskOnSuccessTask, this.f88361q.getTask());
    }

    private void W(String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30) {
            Logger.f().i("ANR feature enabled, but device is API " + i3);
            return;
        }
        List historicalProcessExitReasons = ((ActivityManager) this.f88345a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.f88357m.w(str, historicalProcessExitReasons, new LogFileManager(this.f88351g, str), UserMetadata.k(str, this.f88351g, this.f88349e));
        } else {
            Logger.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    private static StaticSessionData.AppData n(IdManager idManager, AppData appData) {
        return StaticSessionData.AppData.b(idManager.f(), appData.f88303f, appData.f88304g, idManager.a().c(), DeliveryMechanism.b(appData.f88301d).c(), appData.f88305h);
    }

    private static StaticSessionData.DeviceData o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.c(CommonUtils.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.x(), CommonUtils.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static StaticSessionData.OsData p() {
        return StaticSessionData.OsData.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(boolean z2, SettingsProvider settingsProvider, boolean z3) {
        String str;
        CrashlyticsWorkers.c();
        ArrayList arrayList = new ArrayList(this.f88357m.q());
        if (arrayList.size() <= z2) {
            Logger.f().i("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList.get(z2 ? 1 : 0);
        if (z3 && settingsProvider.b().f89052b.f89060b) {
            W(str2);
        } else {
            Logger.f().i("ANR feature disabled.");
        }
        if (z3 && this.f88354j.d(str2)) {
            x(str2);
        }
        if (z2 != 0) {
            str = (String) arrayList.get(0);
        } else {
            this.f88356l.e(null);
            str = null;
        }
        this.f88357m.m(B(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Boolean bool) {
        long jB = B();
        Logger.f().b("Opening a new session with ID " + str);
        this.f88354j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.o()), jB, StaticSessionData.b(n(this.f88350f, this.f88352h), p(), o(this.f88345a)));
        if (bool.booleanValue() && str != null) {
            this.f88348d.p(str);
        }
        this.f88353i.e(str);
        this.f88356l.e(str);
        this.f88357m.r(str, jB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j3) {
        try {
            if (this.f88351g.g(".ae" + j3).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e3) {
            Logger.f().l("Could not create app exception marker file.", e3);
        }
    }

    private void x(String str) {
        Logger.f().i("Finalizing native report for session " + str);
        NativeSessionFileProvider nativeSessionFileProviderA = this.f88354j.a(str);
        File fileC = nativeSessionFileProviderA.c();
        CrashlyticsReport.ApplicationExitInfo applicationExitInfoB = nativeSessionFileProviderA.b();
        if (M(str, fileC, applicationExitInfoB)) {
            Logger.f().k("No native core present");
            return;
        }
        long jLastModified = fileC.lastModified();
        LogFileManager logFileManager = new LogFileManager(this.f88351g, str);
        File fileK = this.f88351g.k(str);
        if (!fileK.isDirectory()) {
            Logger.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(jLastModified);
        List listC = C(nativeSessionFileProviderA, str, this.f88351g, logFileManager.b());
        NativeSessionFileGzipper.b(fileK, listC);
        Logger.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f88357m.l(str, listC, applicationExitInfoB);
        logFileManager.a();
    }

    private static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    String F() throws IOException {
        String strR = CommonUtils.r(this.f88345a);
        if (strR != null) {
            Logger.f().b("Read version control info from string resource");
            return Base64.encodeToString(strR.getBytes(f88344u), 0);
        }
        InputStream inputStreamD = D("META-INF/version-control-info.textproto");
        if (inputStreamD == null) {
            if (inputStreamD != null) {
                inputStreamD.close();
            }
            Logger.f().g("No version control information found");
            return null;
        }
        try {
            Logger.f().b("Read version control info from file");
            String strEncodeToString = Base64.encodeToString(P(inputStreamD), 0);
            inputStreamD.close();
            return strEncodeToString;
        } catch (Throwable th) {
            try {
                inputStreamD.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    void G(SettingsProvider settingsProvider, Thread thread, Throwable th) throws Throwable {
        H(settingsProvider, thread, th, false);
    }

    synchronized void H(final SettingsProvider settingsProvider, final Thread thread, final Throwable th, final boolean z2) throws Throwable {
        Throwable th2;
        try {
            try {
                Logger.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
                if (!z2) {
                    try {
                        CrashEventReceiver.b();
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                Task taskE = this.f88349e.f88491a.e(new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Task call() {
                        long jE = CrashlyticsController.E(jCurrentTimeMillis);
                        final String strA = CrashlyticsController.this.A();
                        if (strA == null) {
                            Logger.f().d("Tried to write a fatal exception while no session was open.");
                            return Tasks.forResult(null);
                        }
                        CrashlyticsController.this.f88347c.a();
                        CrashlyticsController.this.f88357m.u(th, thread, strA, jE);
                        CrashlyticsController.this.v(jCurrentTimeMillis);
                        CrashlyticsController.this.s(settingsProvider);
                        CrashlyticsController.this.u(new CLSUUID().c(), Boolean.valueOf(z2));
                        return !CrashlyticsController.this.f88346b.d() ? Tasks.forResult(null) : settingsProvider.a().onSuccessTask(CrashlyticsController.this.f88349e.f88491a, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.2.1
                            @Override // com.google.android.gms.tasks.SuccessContinuation
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public Task then(Settings settings) {
                                if (settings != null) {
                                    return Tasks.whenAll((Task<?>[]) new Task[]{CrashlyticsController.this.L(), CrashlyticsController.this.f88357m.z(CrashlyticsController.this.f88349e.f88491a, z2 ? strA : null)});
                                }
                                Logger.f().k("Received null app settings, cannot send reports at crash time.");
                                return Tasks.forResult(null);
                            }
                        });
                    }
                });
                if (!z2) {
                    try {
                        Utils.b(taskE);
                    } catch (TimeoutException unused) {
                        Logger.f().d("Cannot send reports. Timed out while fetching settings.");
                    } catch (Exception e3) {
                        Logger.f().e("Error handling uncaught exception", e3);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    boolean I() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f88358n;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.a();
    }

    List J() {
        return this.f88351g.h(f88343t);
    }

    void O(final String str) {
        this.f88349e.f88491a.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f88457a.u(str, Boolean.FALSE);
            }
        });
    }

    void Q() {
        try {
            String strF = F();
            if (strF != null) {
                S("com.crashlytics.version-control-info", strF);
                Logger.f().g("Saved version control info");
            }
        } catch (IOException e3) {
            Logger.f().l("Unable to save version control info", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(String str, String str2) {
        try {
            this.f88348d.n(str, str2);
        } catch (IllegalArgumentException e3) {
            Context context = this.f88345a;
            if (context != null && CommonUtils.v(context)) {
                throw e3;
            }
            Logger.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    void S(String str, String str2) {
        try {
            this.f88348d.o(str, str2);
        } catch (IllegalArgumentException e3) {
            Context context = this.f88345a;
            if (context != null && CommonUtils.v(context)) {
                throw e3;
            }
            Logger.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(String str) {
        this.f88348d.q(str);
    }

    void U(final Task task) {
        if (this.f88357m.p()) {
            Logger.f().i("Crash reports are available to be sent.");
            V().onSuccessTask(this.f88349e.f88491a, new SuccessContinuation<Boolean, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4
                @Override // com.google.android.gms.tasks.SuccessContinuation
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Task then(Boolean bool) {
                    if (bool.booleanValue()) {
                        Logger.f().b("Sending cached crash reports...");
                        CrashlyticsController.this.f88346b.c(bool.booleanValue());
                        return task.onSuccessTask(CrashlyticsController.this.f88349e.f88491a, new SuccessContinuation<Settings, Void>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.4.1
                            @Override // com.google.android.gms.tasks.SuccessContinuation
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public Task then(Settings settings) {
                                if (settings == null) {
                                    Logger.f().k("Received null app settings at app startup. Cannot send cached reports");
                                    return Tasks.forResult(null);
                                }
                                CrashlyticsController.this.L();
                                CrashlyticsController.this.f88357m.y(CrashlyticsController.this.f88349e.f88491a);
                                CrashlyticsController.this.f88362r.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                        });
                    }
                    Logger.f().i("Deleting cached crash reports...");
                    CrashlyticsController.q(CrashlyticsController.this.J());
                    CrashlyticsController.this.f88357m.x();
                    CrashlyticsController.this.f88362r.trySetResult(null);
                    return Tasks.forResult(null);
                }
            });
        } else {
            Logger.f().i("No crash reports are available to be sent.");
            this.f88360p.trySetResult(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(Thread thread, Throwable th, Map map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (I()) {
            return;
        }
        long jE = E(jCurrentTimeMillis);
        String strA = A();
        if (strA == null) {
            Logger.f().k("Tried to write a non-fatal exception while no session was open.");
        } else {
            this.f88357m.v(th, thread, new EventMetadata(strA, jE, map));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(long j3, String str) {
        if (I()) {
            return;
        }
        this.f88353i.g(j3, str);
    }

    boolean r() {
        CrashlyticsWorkers.c();
        if (!this.f88347c.c()) {
            String strA = A();
            return strA != null && this.f88354j.d(strA);
        }
        Logger.f().i("Found previous crash marker.");
        this.f88347c.d();
        return true;
    }

    void s(SettingsProvider settingsProvider) {
        t(false, settingsProvider, false);
    }

    void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsProvider settingsProvider) {
        this.f88359o = settingsProvider;
        O(str);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsController.1
            @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void a(SettingsProvider settingsProvider2, Thread thread, Throwable th) throws Throwable {
                CrashlyticsController.this.G(settingsProvider2, thread, th);
            }
        }, settingsProvider, uncaughtExceptionHandler, this.f88354j);
        this.f88358n = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    boolean y(SettingsProvider settingsProvider) {
        CrashlyticsWorkers.c();
        if (I()) {
            Logger.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.f().i("Finalizing previously open sessions.");
        try {
            t(true, settingsProvider, true);
            Logger.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e3) {
            Logger.f().e("Unable to finalize previously open sessions.", e3);
            return false;
        }
    }
}
