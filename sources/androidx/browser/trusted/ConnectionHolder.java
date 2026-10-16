package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ConnectionHolder implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f2692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WrapperFactory f2693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TrustedWebActivityServiceConnection f2695d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f2696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Exception f2697g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WrapperFactory {
        TrustedWebActivityServiceConnection a(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(ITrustedWebActivityService.Stub.x3(iBinder), componentName);
        }
    }

    public void a(Exception exc) {
        Iterator it = this.f2696f.iterator();
        while (it.hasNext()) {
            ((CallbackToFutureAdapter.Completer) it.next()).f(exc);
        }
        this.f2696f.clear();
        this.f2692a.run();
        this.f2694c = 3;
        this.f2697g = exc;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2695d = this.f2693b.a(componentName, iBinder);
        Iterator it = this.f2696f.iterator();
        while (it.hasNext()) {
            ((CallbackToFutureAdapter.Completer) it.next()).c(this.f2695d);
        }
        this.f2696f.clear();
        this.f2694c = 1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2695d = null;
        this.f2692a.run();
        this.f2694c = 2;
    }
}
