package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.os.Bundle;
import cz.mobilesoft.coreblock.service.ForegroundServiceLauncher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LockServiceInAccessibilityProcess extends LockServiceV2 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final ForegroundServiceLauncher f94526z = new ForegroundServiceLauncher(LockServiceInAccessibilityProcess.class);

    public static void c0(Context context, Bundle bundle) {
        LockServiceHelperKt.a(context, bundle, f94526z, LockServiceV2.f94536y);
    }

    public static void e0(Context context) {
        f94526z.g(context);
    }

    @Override // cz.mobilesoft.appblock.service.LockServiceV2
    protected ForegroundServiceLauncher G() {
        return f94526z;
    }
}
