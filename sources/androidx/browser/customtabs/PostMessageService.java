package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPostMessageService.Stub f2667a;

    /* JADX INFO: renamed from: androidx.browser.customtabs.PostMessageService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends IPostMessageService.Stub {
        @Override // android.support.customtabs.IPostMessageService
        public void F3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            iCustomTabsCallback.P4(str, bundle);
        }

        @Override // android.support.customtabs.IPostMessageService
        public void G0(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            iCustomTabsCallback.W4(bundle);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2667a;
    }
}
