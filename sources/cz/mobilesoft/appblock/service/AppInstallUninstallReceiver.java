package cz.mobilesoft.appblock.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.repository.ApplicationRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class AppInstallUninstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AppInstallUninstallReceiver f94032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f94033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Runnable f94034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List f94035d = CollectionsKt.listOf((Object[]) new String[]{"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_REMOVED"});

    public static void c(Context context) {
        AppInstallUninstallReceiver appInstallUninstallReceiver = f94032a;
        if (appInstallUninstallReceiver == null) {
            f94032a = new AppInstallUninstallReceiver();
        } else {
            context.unregisterReceiver(appInstallUninstallReceiver);
        }
        IntentFilter intentFilter = new IntentFilter();
        Iterator it = f94035d.iterator();
        while (it.hasNext()) {
            intentFilter.addAction((String) it.next());
        }
        intentFilter.addDataScheme("package");
        intentFilter.setPriority(999);
        context.registerReceiver(f94032a, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (!CollectionsKt.none(f94035d, new Function1() { // from class: cz.mobilesoft.appblock.service.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(((String) obj).equals(action));
            }
        }) || action.equals("android.intent.action.PACKAGE_FULLY_REMOVED")) {
            if (f94033b == null) {
                f94033b = new Handler();
            }
            if (f94034c == null) {
                f94034c = new Runnable() { // from class: cz.mobilesoft.appblock.service.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApplicationRepository.f97454a.r(LockieApplication.g(), true);
                    }
                };
            }
            f94033b.removeCallbacks(f94034c);
            f94033b.postDelayed(f94034c, 5000L);
        }
    }
}
