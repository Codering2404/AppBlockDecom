package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class eg {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static eg f59486e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f59487a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f59488b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f59489c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f59490d = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile boolean f59491a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iC = eg.c(context);
            int i3 = xp.f65027a;
            if (i3 >= 29 && !b.f59491a && iC == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) b1.a((TelephonyManager) context.getSystemService("phone"));
                    e eVar = new e();
                    if (i3 < 31) {
                        telephonyManager.listen(eVar, 1);
                    } else {
                        telephonyManager.listen(eVar, 1048576);
                    }
                    telephonyManager.listen(eVar, 0);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            eg.this.a(iC);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class e extends PhoneStateListener {
        private e() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
            eg.this.a(overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            String string = serviceState == null ? "" : serviceState.toString();
            eg.this.a(string.contains("nrState=CONNECTED") || string.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }
    }

    private eg(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i3 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i3 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type == 9) {
                        return 7;
                    }
                    if (type != 4 && type != 5) {
                        return type != 6 ? 8 : 5;
                    }
                }
                return a(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i3;
    }

    public void b(final c cVar) {
        b();
        this.f59488b.add(new WeakReference(cVar));
        this.f59487a.post(new Runnable() { // from class: com.applovin.impl.zu
            @Override // java.lang.Runnable
            public final void run() {
                this.f65490a.a(cVar);
            }
        });
    }

    private static int a(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return xp.f65027a >= 29 ? 9 : 0;
        }
    }

    private void b() {
        for (WeakReference weakReference : this.f59488b) {
            if (weakReference.get() == null) {
                this.f59488b.remove(weakReference);
            }
        }
    }

    public int a() {
        int i3;
        synchronized (this.f59489c) {
            i3 = this.f59490d;
        }
        return i3;
    }

    public static synchronized eg b(Context context) {
        try {
            if (f59486e == null) {
                f59486e = new eg(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f59486e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar) {
        cVar.a(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        synchronized (this.f59489c) {
            try {
                if (this.f59490d == i3) {
                    return;
                }
                this.f59490d = i3;
                for (WeakReference weakReference : this.f59488b) {
                    c cVar = (c) weakReference.get();
                    if (cVar != null) {
                        cVar.a(i3);
                    } else {
                        this.f59488b.remove(weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
