package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import com.pairip.VMRunner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class SingletonConnectivityReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile SingletonConnectivityReceiver f67046d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameworkConnectivityMonitor f67047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set f67048b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f67049c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface FrameworkConnectivityMonitor {
        void a();

        boolean b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f67053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ConnectivityMonitor.ConnectivityListener f67054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final GlideSuppliers.GlideSupplier f67055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f67056d = new AnonymousClass1();

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
            AnonymousClass1() {
            }

            private void b(final boolean z2) {
                Util.x(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.a(z2);
                    }
                });
            }

            void a(boolean z2) {
                Util.b();
                FrameworkConnectivityMonitorPostApi24 frameworkConnectivityMonitorPostApi24 = FrameworkConnectivityMonitorPostApi24.this;
                boolean z3 = frameworkConnectivityMonitorPostApi24.f67053a;
                frameworkConnectivityMonitorPostApi24.f67053a = z2;
                if (z3 != z2) {
                    frameworkConnectivityMonitorPostApi24.f67054b.a(z2);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.f67055c = glideSupplier;
            this.f67054b = connectivityListener;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void a() {
            ((ConnectivityManager) this.f67055c.get()).unregisterNetworkCallback(this.f67056d);
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean b() {
            this.f67053a = ((ConnectivityManager) this.f67055c.get()).getActiveNetwork() != null;
            try {
                ((ConnectivityManager) this.f67055c.get()).registerDefaultNetworkCallback(this.f67056d);
                return true;
            } catch (RuntimeException e3) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e3);
                }
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final Executor f67060g = AsyncTask.SERIAL_EXECUTOR;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f67061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ConnectivityMonitor.ConnectivityListener f67062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final GlideSuppliers.GlideSupplier f67063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f67064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f67065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final BroadcastReceiver f67066f;

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FrameworkConnectivityMonitorPreApi24 f67067a;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                VMRunner.invoke("mAyp406Zsr61mV2c", new Object[]{this, context, intent});
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void a() {
            f67060g.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FrameworkConnectivityMonitorPreApi24.this.f67065e) {
                        FrameworkConnectivityMonitorPreApi24.this.f67065e = false;
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi24.f67061a.unregisterReceiver(frameworkConnectivityMonitorPreApi24.f67066f);
                    }
                }
            });
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean b() {
            f67060g.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.2
                @Override // java.lang.Runnable
                public void run() {
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.f67064d = frameworkConnectivityMonitorPreApi24.c();
                    try {
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.f67061a.registerReceiver(frameworkConnectivityMonitorPreApi242.f67066f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        FrameworkConnectivityMonitorPreApi24.this.f67065e = true;
                    } catch (SecurityException e3) {
                        if (Log.isLoggable("ConnectivityMonitor", 5)) {
                            Log.w("ConnectivityMonitor", "Failed to register", e3);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.f67065e = false;
                    }
                }
            });
            return true;
        }

        boolean c() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f67063c.get()).getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e3) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e3);
                }
                return true;
            }
        }

        void d(final boolean z2) {
            Util.x(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.5
                @Override // java.lang.Runnable
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.f67062b.a(z2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e() {
            f67060g.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2 = FrameworkConnectivityMonitorPreApi24.this.f67064d;
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.f67064d = frameworkConnectivityMonitorPreApi24.c();
                    if (z2 != FrameworkConnectivityMonitorPreApi24.this.f67064d) {
                        if (Log.isLoggable("ConnectivityMonitor", 3)) {
                            Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.f67064d);
                        }
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.d(frameworkConnectivityMonitorPreApi242.f67064d);
                    }
                }
            });
        }
    }

    private SingletonConnectivityReceiver(final Context context) {
        this.f67047a = new FrameworkConnectivityMonitorPostApi24(GlideSuppliers.a(new GlideSuppliers.GlideSupplier<ConnectivityManager>() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.1
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ConnectivityManager get() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        }), new ConnectivityMonitor.ConnectivityListener() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.2
            @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
            public void a(boolean z2) {
                ArrayList arrayList;
                Util.b();
                synchronized (SingletonConnectivityReceiver.this) {
                    arrayList = new ArrayList(SingletonConnectivityReceiver.this.f67048b);
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((ConnectivityMonitor.ConnectivityListener) obj).a(z2);
                }
            }
        });
    }

    static SingletonConnectivityReceiver a(Context context) {
        if (f67046d == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                try {
                    if (f67046d == null) {
                        f67046d = new SingletonConnectivityReceiver(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f67046d;
    }

    private void b() {
        if (this.f67049c || this.f67048b.isEmpty()) {
            return;
        }
        this.f67049c = this.f67047a.b();
    }

    private void c() {
        if (this.f67049c && this.f67048b.isEmpty()) {
            this.f67047a.a();
            this.f67049c = false;
        }
    }

    synchronized void d(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f67048b.add(connectivityListener);
        b();
    }

    synchronized void e(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f67048b.remove(connectivityListener);
        c();
    }
}
