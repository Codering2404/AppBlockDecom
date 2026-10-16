package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ICustomTabsCallback f2669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IPostMessageService f2670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2671d;

    private boolean a(Bundle bundle) {
        if (this.f2670c == null) {
            return false;
        }
        synchronized (this.f2668a) {
            try {
                try {
                    this.f2670c.G0(this.f2669b, bundle);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void b() {
        if (this.f2671d) {
            a(null);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2670c = IPostMessageService.Stub.x3(iBinder);
        b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2670c = null;
        c();
    }

    public void c() {
    }
}
