package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IUnusedAppRestrictionsBackportService.Stub f33836a;

    /* JADX INFO: renamed from: androidx.core.content.UnusedAppRestrictionsBackportService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends IUnusedAppRestrictionsBackportService.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UnusedAppRestrictionsBackportService f33837a;

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void X2(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
            if (iUnusedAppRestrictionsBackportCallback == null) {
                return;
            }
            this.f33837a.a(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
        }
    }

    protected abstract void a(UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f33836a;
    }
}
