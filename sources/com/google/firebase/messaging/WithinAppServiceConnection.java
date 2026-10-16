package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class WithinAppServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f89506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f89507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f89508d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WithinAppServiceBinder f89509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f89510g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BindRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f89511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskCompletionSource f89512b = new TaskCompletionSource();

        BindRequest(Intent intent) {
            this.f89511a = intent;
        }

        public static /* synthetic */ void b(BindRequest bindRequest) {
            bindRequest.getClass();
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + bindRequest.f89511a.getAction() + " finishing.");
            bindRequest.d();
        }

        void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.e0
                @Override // java.lang.Runnable
                public final void run() {
                    WithinAppServiceConnection.BindRequest.b(this.f89531a);
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.f0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.f89512b.trySetResult(null);
        }

        Task e() {
            return this.f89512b.getTask();
        }
    }

    WithinAppServiceConnection(Context context, String str) {
        this(context, str, a());
    }

    private static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    private void b() {
        while (!this.f89508d.isEmpty()) {
            ((BindRequest) this.f89508d.poll()).d();
        }
    }

    private synchronized void c() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f89508d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                WithinAppServiceBinder withinAppServiceBinder = this.f89509f;
                if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                    e();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f89509f.b((BindRequest) this.f89508d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f89510g);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f89510g) {
            return;
        }
        this.f89510g = true;
        try {
            if (ConnectionTracker.b().a(this.f89505a, this.f89506b, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e3) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e3);
        }
        this.f89510g = false;
        b();
    }

    synchronized Task d(Intent intent) {
        BindRequest bindRequest;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            bindRequest = new BindRequest(intent);
            bindRequest.c(this.f89507c);
            this.f89508d.add(bindRequest);
            c();
        } catch (Throwable th) {
            throw th;
        }
        return bindRequest.e();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f89510g = false;
            if (iBinder instanceof WithinAppServiceBinder) {
                this.f89509f = (WithinAppServiceBinder) iBinder;
                c();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            b();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        c();
    }

    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f89508d = new ArrayDeque();
        this.f89510g = false;
        Context applicationContext = context.getApplicationContext();
        this.f89505a = applicationContext;
        this.f89506b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f89507c = scheduledExecutorService;
    }
}
