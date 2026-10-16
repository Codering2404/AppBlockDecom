package androidx.core.app;

import androidx.core.app.JobIntentService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SafeJobIntentService extends JobIntentService {
    @Override // androidx.core.app.JobIntentService
    JobIntentService.GenericWorkItem a() {
        try {
            return super.a();
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f33603a = new SafeJobServiceEngineImpl(this);
    }
}
