package com.singular.sdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class NetworkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92607a = SingularLog.f(NetworkMonitor.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConnectivityManager.NetworkCallback f92608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static BroadcastReceiver f92609c;

    /* JADX INFO: renamed from: com.singular.sdk.internal.NetworkMonitor$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f92612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ApiManager f92613b;

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkMonitor.f92607a.a("onAvailable");
            NetworkMonitor.j(this.f92612a, this.f92613b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NetworkChange extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ApiManager f92615a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkMonitor.f92607a.b("onReceive() action=%s ", intent.getAction());
            NetworkMonitor.j(context, this.f92615a);
        }
    }

    static String c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return d(connectivityManager);
        }
        f92607a.a("connectivityManager is null, returning unknown");
        return "unknown";
    }

    private static String d(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? "unknown" : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(0) ? "wwan" : "unknown";
        } catch (Throwable th) {
            f92607a.c("NetworkMonitor.getConnectionTypeAndroid23AndAbove: " + Utils.l(th));
            return "unknown";
        }
    }

    private static ConnectivityManager e(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    static boolean f(Context context) {
        ConnectivityManager connectivityManagerE = e(context);
        if (connectivityManagerE == null) {
            f92607a.a("connectivityManager is null");
        }
        return h(connectivityManagerE) != i(connectivityManagerE);
    }

    static boolean g(Context context) {
        ConnectivityManager connectivityManagerE = e(context);
        if (connectivityManagerE != null) {
            return h(connectivityManagerE);
        }
        f92607a.a("connectivityManager is null, returning false");
        return false;
    }

    private static boolean h(ConnectivityManager connectivityManager) {
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                f92607a.a("getActiveNetwork is null, returning false");
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(12);
            }
            f92607a.a("getNetworkCapabilities is null, returning false");
            return false;
        } catch (Throwable th) {
            f92607a.c("NetworkMonitor.isConnectedAndroid23AndAbove: " + Utils.l(th));
            return false;
        }
    }

    private static boolean i(ConnectivityManager connectivityManager) {
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            f92607a.c("NetworkMonitor.isConnectedAndroidBelow23: " + Utils.l(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context, final ApiManager apiManager) {
        if (!g(context)) {
            f92607a.a("notifyNetworkChange isConnected = false");
        } else {
            f92607a.a("notifyNetworkChange isConnected = true");
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.NetworkMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    apiManager.e();
                }
            });
        }
    }

    private static void k(ConnectivityManager connectivityManager, Context context, final ApiManager apiManager) {
        n(connectivityManager);
        try {
            final Context applicationContext = context.getApplicationContext();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.singular.sdk.internal.NetworkMonitor.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    NetworkMonitor.f92607a.a("onAvailable");
                    NetworkMonitor.j(applicationContext, apiManager);
                }
            };
            f92608b = networkCallback;
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            f92607a.a("NetworkMonitor: registerNetworkChangeListener() - NetworkCallback registered (API 24+)");
        } catch (Throwable th) {
            f92607a.c("NetworkMonitor: Error registering NetworkCallback: " + Utils.l(th));
            f92608b = null;
        }
    }

    static void l(Context context, ApiManager apiManager) {
        ConnectivityManager connectivityManagerE = e(context);
        if (connectivityManagerE == null) {
            return;
        }
        k(connectivityManagerE, context, apiManager);
    }

    private static void m(Context context) {
        if (f92609c == null) {
            f92607a.a("NetworkMonitor: BroadcastReceiver not registered, skipping unregister");
            return;
        }
        try {
            context.getApplicationContext().unregisterReceiver(f92609c);
            f92607a.a("NetworkMonitor: unregisterNetworkChangeListener() - BroadcastReceiver unregistered");
        } catch (Throwable th) {
            f92607a.a("NetworkMonitor: Error unregistering BroadcastReceiver: " + Utils.l(th));
        }
        f92609c = null;
    }

    private static void n(ConnectivityManager connectivityManager) {
        ConnectivityManager.NetworkCallback networkCallback = f92608b;
        if (networkCallback != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                f92607a.a("NetworkMonitor: Error unregistering existing NetworkCallback: " + Utils.l(th));
            }
            f92608b = null;
        }
    }

    private static void o(ConnectivityManager connectivityManager) {
        ConnectivityManager.NetworkCallback networkCallback = f92608b;
        if (networkCallback == null) {
            f92607a.a("NetworkMonitor: NetworkCallback not registered, skipping unregister");
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
            f92607a.a("NetworkMonitor: unregisterNetworkChangeListener() - NetworkCallback unregistered");
        } catch (Throwable th) {
            f92607a.c("NetworkMonitor: Error unregistering NetworkCallback: " + Utils.l(th));
        }
        f92608b = null;
    }

    static void p(Context context) {
        ConnectivityManager connectivityManagerE = e(context);
        if (connectivityManagerE != null) {
            o(connectivityManagerE);
        } else {
            m(context);
        }
    }
}
