package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f54938g = Logger.i("SystemFgService");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static SystemForegroundService f54939h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f54940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f54941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SystemForegroundDispatcher f54942d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    NotificationManager f54943f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(Service service, int i3, Notification notification, int i4) {
            service.startForeground(i3, notification, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
        static void a(Service service, int i3, Notification notification, int i4) {
            try {
                service.startForeground(i3, notification, i4);
            } catch (ForegroundServiceStartNotAllowedException e3) {
                Logger.e().l(SystemForegroundService.f54938g, "Unable to start foreground service", e3);
            }
        }
    }

    private void f() {
        this.f54940b = new Handler(Looper.getMainLooper());
        this.f54943f = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f54942d = systemForegroundDispatcher;
        systemForegroundDispatcher.n(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void a(final int i3, final Notification notification) {
        this.f54940b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f54943f.notify(i3, notification);
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void c(final int i3, final int i4, final Notification notification) {
        this.f54940b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.1
            @Override // java.lang.Runnable
            public void run() {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 31) {
                    Api31Impl.a(SystemForegroundService.this, i3, notification, i4);
                } else if (i5 >= 29) {
                    Api29Impl.a(SystemForegroundService.this, i3, notification, i4);
                } else {
                    SystemForegroundService.this.startForeground(i3, notification);
                }
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void d(final int i3) {
        this.f54940b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f54943f.cancel(i3);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f54939h = this;
        f();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f54942d.l();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        super.onStartCommand(intent, i3, i4);
        if (this.f54941c) {
            Logger.e().f(f54938g, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f54942d.l();
            f();
            this.f54941c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f54942d.m(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.f54941c = true;
        Logger.e().a(f54938g, "All commands completed.");
        stopForeground(true);
        f54939h = null;
        stopSelf();
    }
}
