package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.i8;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f63167f = TimeUnit.SECONDS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f63169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet f63170c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f63171d = new Object();

    /* JADX INFO: renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InterfaceC0121a {
        void onAdExpired(i8 i8Var);
    }

    public a(j jVar) {
        this.f63168a = jVar;
        this.f63169b = jVar.I();
    }

    private b b(i8 i8Var) {
        synchronized (this.f63171d) {
            try {
                if (i8Var == null) {
                    return null;
                }
                for (b bVar : this.f63170c) {
                    if (i8Var == bVar.b()) {
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(i8 i8Var) {
        synchronized (this.f63171d) {
            try {
                b bVarB = b(i8Var);
                if (bVarB != null) {
                    if (n.a()) {
                        this.f63169b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + i8Var);
                    }
                    bVarB.a();
                    a(bVarB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }

    private void b() {
        HashSet<b> hashSet = new HashSet();
        synchronized (this.f63171d) {
            try {
                for (b bVar : this.f63170c) {
                    i8 i8VarB = bVar.b();
                    if (i8VarB == null) {
                        hashSet.add(bVar);
                    } else {
                        long timeToLiveMillis = i8VarB.getTimeToLiveMillis();
                        if (timeToLiveMillis <= 0) {
                            if (n.a()) {
                                this.f63169b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + i8VarB);
                            }
                            hashSet.add(bVar);
                        } else {
                            if (n.a()) {
                                this.f63169b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + i8VarB);
                            }
                            bVar.a(timeToLiveMillis);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (b bVar2 : hashSet) {
            a(bVar2);
            bVar2.d();
        }
    }

    public boolean a(i8 i8Var, InterfaceC0121a interfaceC0121a) {
        synchronized (this.f63171d) {
            try {
                if (b(i8Var) != null) {
                    if (n.a()) {
                        this.f63169b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + i8Var);
                    }
                    return true;
                }
                if (i8Var.getTimeToLiveMillis() <= f63167f) {
                    if (n.a()) {
                        this.f63169b.a("AdExpirationManager", "Ad has already expired: " + i8Var);
                    }
                    i8Var.setExpired();
                    return false;
                }
                if (n.a()) {
                    this.f63169b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(i8Var.getTimeToLiveMillis()) + " seconds from now for " + i8Var + "...");
                }
                if (this.f63170c.isEmpty()) {
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                    AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                }
                this.f63170c.add(b.a(i8Var, interfaceC0121a, this.f63168a));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.f63171d) {
            try {
                this.f63170c.remove(bVar);
                if (this.f63170c.isEmpty()) {
                    AppLovinBroadcastManager.unregisterReceiver(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a() {
        synchronized (this.f63171d) {
            try {
                Iterator it = this.f63170c.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
