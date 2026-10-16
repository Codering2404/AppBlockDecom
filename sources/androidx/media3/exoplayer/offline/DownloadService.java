package androidx.media3.exoplayer.offline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.Scheduler;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadService extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final HashMap f44447l = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ForegroundNotificationUpdater f44448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f44450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f44451d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadManagerHelper f44452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f44453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f44454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f44455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f44456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f44457k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DownloadManagerHelper implements DownloadManager.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f44458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DownloadManager f44459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f44460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Scheduler f44461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Class f44462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private DownloadService f44463f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Requirements f44464g;

        private void g() {
            Requirements requirements = new Requirements(0);
            if (j(requirements)) {
                this.f44461d.cancel();
                this.f44464g = requirements;
            }
        }

        private void i() {
            if (this.f44460c) {
                try {
                    Util.k1(this.f44458a, DownloadService.g(this.f44458a, this.f44462e, "androidx.media3.exoplayer.downloadService.action.RESTART"));
                    return;
                } catch (IllegalStateException unused) {
                    Log.i("DownloadService", "Failed to restart (foreground launch restriction)");
                    return;
                }
            }
            try {
                this.f44458a.startService(DownloadService.g(this.f44458a, this.f44462e, "androidx.media3.exoplayer.downloadService.action.INIT"));
            } catch (IllegalStateException unused2) {
                Log.i("DownloadService", "Failed to restart (process is idle)");
            }
        }

        private boolean j(Requirements requirements) {
            return !Objects.equals(this.f44464g, requirements);
        }

        private boolean k() {
            DownloadService downloadService = this.f44463f;
            return downloadService == null || downloadService.i();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public void a(DownloadManager downloadManager, boolean z2) {
            if (z2 || downloadManager.d() || !k()) {
                return;
            }
            List listC = downloadManager.c();
            for (int i3 = 0; i3 < listC.size(); i3++) {
                if (((Download) listC.get(i3)).f44371b == 0) {
                    i();
                    return;
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public void c(DownloadManager downloadManager, Requirements requirements, int i3) {
            l();
        }

        public void f(final DownloadService downloadService) {
            Assertions.g(this.f44463f == null);
            this.f44463f = downloadService;
            if (this.f44459b.h()) {
                Util.E().postAtFrontOfQueue(new Runnable() { // from class: androidx.media3.exoplayer.offline.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        downloadService.k(this.f44508a.f44459b.c());
                    }
                });
            }
        }

        public void h(DownloadService downloadService) {
            Assertions.g(this.f44463f == downloadService);
            this.f44463f = null;
        }

        public boolean l() {
            boolean zI = this.f44459b.i();
            if (this.f44461d == null) {
                return !zI;
            }
            if (!zI) {
                g();
                return true;
            }
            Requirements requirementsF = this.f44459b.f();
            if (!this.f44461d.b(requirementsF).equals(requirementsF)) {
                g();
                return false;
            }
            if (!j(requirementsF)) {
                return true;
            }
            if (this.f44461d.a(requirementsF, this.f44458a.getPackageName(), "androidx.media3.exoplayer.downloadService.action.RESTART")) {
                this.f44464g = requirementsF;
                return true;
            }
            Log.i("DownloadService", "Failed to schedule restart");
            g();
            return false;
        }

        private DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean z2, Scheduler scheduler, Class cls) {
            this.f44458a = context;
            this.f44459b = downloadManager;
            this.f44460c = z2;
            this.f44461d = scheduler;
            this.f44462e = cls;
            downloadManager.b(this);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ForegroundNotificationUpdater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f44465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f44466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f44467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f44469e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DownloadService f44470f;

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            DownloadManager downloadManager = ((DownloadManagerHelper) Assertions.e(this.f44470f.f44452f)).f44459b;
            Notification notificationF = this.f44470f.f(downloadManager.c(), downloadManager.e());
            if (this.f44469e) {
                ((NotificationManager) this.f44470f.getSystemService("notification")).notify(this.f44465a, notificationF);
            } else {
                Util.e1(this.f44470f, this.f44465a, notificationF, 1, "dataSync");
                this.f44469e = true;
            }
            if (this.f44468d) {
                this.f44467c.removeCallbacksAndMessages(null);
                this.f44467c.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.offline.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44510a.e();
                    }
                }, this.f44466b);
            }
        }

        public void b() {
            if (this.f44469e) {
                return;
            }
            e();
        }

        public void c() {
            this.f44468d = true;
            e();
        }

        public void d() {
            this.f44468d = false;
            this.f44467c.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent g(Context context, Class cls, String str) {
        return new Intent(context, (Class<?>) cls).setAction(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return this.f44456j;
    }

    private static boolean j(int i3) {
        return i3 == 2 || i3 == 5 || i3 == 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(List list) {
        if (this.f44448a != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (j(((Download) list.get(i3)).f44371b)) {
                    this.f44448a.c();
                    return;
                }
            }
        }
    }

    private void l() {
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.f44448a;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.d();
        }
        if (((DownloadManagerHelper) Assertions.e(this.f44452f)).l()) {
            if (Util.f41609a >= 28 || !this.f44455i) {
                this.f44456j |= stopSelfResult(this.f44453g);
            } else {
                stopSelf();
                this.f44456j = true;
            }
        }
    }

    protected abstract DownloadManager e();

    protected abstract Notification f(List list, int i3);

    protected abstract Scheduler h();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f44449b;
        if (str != null) {
            NotificationUtil.a(this, str, this.f44450c, this.f44451d, 2);
        }
        Class<?> cls = getClass();
        HashMap map = f44447l;
        DownloadManagerHelper downloadManagerHelper = (DownloadManagerHelper) map.get(cls);
        if (downloadManagerHelper == null) {
            boolean z2 = this.f44448a != null;
            Scheduler schedulerH = (z2 && (Util.f41609a < 31)) ? h() : null;
            DownloadManager downloadManagerE = e();
            downloadManagerE.p();
            DownloadManagerHelper downloadManagerHelper2 = new DownloadManagerHelper(getApplicationContext(), downloadManagerE, z2, schedulerH, cls);
            map.put(cls, downloadManagerHelper2);
            downloadManagerHelper = downloadManagerHelper2;
        }
        this.f44452f = downloadManagerHelper;
        downloadManagerHelper.f(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f44457k = true;
        ((DownloadManagerHelper) Assertions.e(this.f44452f)).h(this);
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.f44448a;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.d();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        String action;
        String stringExtra;
        DownloadManager downloadManager;
        ForegroundNotificationUpdater foregroundNotificationUpdater;
        this.f44453g = i4;
        this.f44455i = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra(AppLovinEventParameters.CONTENT_IDENTIFIER);
            this.f44454h |= intent.getBooleanExtra("foreground", false) || "androidx.media3.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "androidx.media3.exoplayer.downloadService.action.INIT";
        }
        downloadManager = ((DownloadManagerHelper) Assertions.e(this.f44452f)).f44459b;
        switch (action) {
            case "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) Assertions.e(intent)).hasExtra("stop_reason")) {
                    Log.d("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.s(stringExtra, intent.getIntExtra("stop_reason", 0));
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    downloadManager.o(stringExtra);
                    break;
                } else {
                    Log.d("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESTART":
            case "androidx.media3.exoplayer.downloadService.action.INIT":
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.p();
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.n();
                break;
            case "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD":
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) Assertions.e(intent)).getParcelableExtra("download_request");
                if (downloadRequest != null) {
                    downloadManager.a(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    Log.d("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS":
                Requirements requirements = (Requirements) ((Intent) Assertions.e(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    downloadManager.r(requirements);
                    break;
                } else {
                    Log.d("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.m();
                break;
            default:
                Log.d("DownloadService", "Ignored unrecognized action: " + action);
                break;
        }
        if (Util.f41609a >= 26 && this.f44454h && (foregroundNotificationUpdater = this.f44448a) != null) {
            foregroundNotificationUpdater.b();
        }
        this.f44456j = false;
        if (downloadManager.g()) {
            l();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f44455i = true;
    }
}
