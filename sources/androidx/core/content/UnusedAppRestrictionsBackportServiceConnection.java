package androidx.core.content;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IUnusedAppRestrictionsBackportService f33838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ResolvableFuture f33839b;

    private IUnusedAppRestrictionsBackportCallback a() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void P1(boolean z2, boolean z3) {
                if (!z2) {
                    UnusedAppRestrictionsBackportServiceConnection.this.f33839b.o(0);
                    Log.e("PackageManagerCompat", "Unable to retrieve the permission revocation setting from the backport");
                } else if (z3) {
                    UnusedAppRestrictionsBackportServiceConnection.this.f33839b.o(3);
                } else {
                    UnusedAppRestrictionsBackportServiceConnection.this.f33839b.o(2);
                }
            }
        };
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService iUnusedAppRestrictionsBackportServiceX3 = IUnusedAppRestrictionsBackportService.Stub.x3(iBinder);
        this.f33838a = iUnusedAppRestrictionsBackportServiceX3;
        try {
            iUnusedAppRestrictionsBackportServiceX3.X2(a());
        } catch (RemoteException unused) {
            this.f33839b.o(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f33838a = null;
    }
}
