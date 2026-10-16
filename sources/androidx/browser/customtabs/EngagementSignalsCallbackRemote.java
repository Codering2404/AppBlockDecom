package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.IEngagementSignalsCallback;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
final class EngagementSignalsCallbackRemote implements EngagementSignalsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IEngagementSignalsCallback f2666a;

    private EngagementSignalsCallbackRemote(IEngagementSignalsCallback iEngagementSignalsCallback) {
        this.f2666a = iEngagementSignalsCallback;
    }

    static EngagementSignalsCallbackRemote a(IBinder iBinder) {
        return new EngagementSignalsCallbackRemote(IEngagementSignalsCallback.Stub.x3(iBinder));
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void A(int i3, Bundle bundle) {
        try {
            this.f2666a.A(i3, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void u(boolean z2, Bundle bundle) {
        try {
            this.f2666a.u(z2, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public void x(boolean z2, Bundle bundle) {
        try {
            this.f2666a.x(z2, bundle);
        } catch (RemoteException unused) {
            Log.e("EngagementSigsCallbkRmt", "RemoteException during IEngagementSignalsCallback transaction");
        }
    }
}
