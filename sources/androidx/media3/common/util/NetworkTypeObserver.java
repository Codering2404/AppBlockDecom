package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.media3.common.util.NetworkTypeObserver;
import com.pairip.VMRunner;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class NetworkTypeObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static NetworkTypeObserver f41565f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f41566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f41567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f41568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f41569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f41570e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31 {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final NetworkTypeObserver f41571a;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.f41571a = networkTypeObserver;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f41571a.m(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) Assertions.e((TelephonyManager) context.getSystemService("phone"));
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(networkTypeObserver.f41566a, displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.m(5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ListenerHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f41572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f41573b;

        public ListenerHolder(Listener listener, Executor executor) {
            this.f41572a = new WeakReference(listener);
            this.f41573b = executor;
        }

        public static /* synthetic */ void a(ListenerHolder listenerHolder) {
            Listener listener = (Listener) listenerHolder.f41572a.get();
            if (listener != null) {
                listener.a(NetworkTypeObserver.this.g());
            }
        }

        public void b() {
            this.f41573b.execute(new Runnable() { // from class: androidx.media3.common.util.j
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkTypeObserver.ListenerHolder.a(this.f41638a);
                }
            });
        }

        public boolean c() {
            return this.f41572a.get() == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    final class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VMRunner.invoke("tBHMB9xGSqgdI4ER", new Object[]{this, context, intent});
        }
    }

    private NetworkTypeObserver(final Context context) {
        Executor executorA = BackgroundExecutor.a();
        this.f41566a = executorA;
        this.f41567b = new CopyOnWriteArrayList();
        this.f41568c = new Object();
        this.f41569d = 0;
        executorA.execute(new Runnable() { // from class: androidx.media3.common.util.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f41636a.j(context);
            }
        });
    }

    public static synchronized NetworkTypeObserver e(Context context) {
        try {
            if (f41565f == null) {
                f41565f = new NetworkTypeObserver(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f41565f;
    }

    private static int f(NetworkInfo networkInfo) {
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
                return Util.f41609a >= 29 ? 9 : 0;
        }
    }

    private static int h(Context context) {
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
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return f(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context) {
        int iH = h(context);
        if (Util.f41609a < 31 || iH != 5) {
            m(iH);
        } else {
            Api31.a(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new Receiver(), intentFilter);
    }

    private void l() {
        for (ListenerHolder listenerHolder : this.f41567b) {
            if (listenerHolder.c()) {
                this.f41567b.remove(listenerHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i3) {
        l();
        synchronized (this.f41568c) {
            try {
                if (this.f41570e && this.f41569d == i3) {
                    return;
                }
                this.f41570e = true;
                this.f41569d = i3;
                Iterator it = this.f41567b.iterator();
                while (it.hasNext()) {
                    ((ListenerHolder) it.next()).b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int g() {
        int i3;
        synchronized (this.f41568c) {
            i3 = this.f41569d;
        }
        return i3;
    }

    public void k(Listener listener, Executor executor) {
        boolean z2;
        l();
        ListenerHolder listenerHolder = new ListenerHolder(listener, executor);
        synchronized (this.f41568c) {
            this.f41567b.add(listenerHolder);
            z2 = this.f41570e;
        }
        if (z2) {
            listenerHolder.b();
        }
    }
}
