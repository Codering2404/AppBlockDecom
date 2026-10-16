package com.jakewharton.processphoenix;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PhoenixService extends IntentService {
    public PhoenixService() {
        super("PhoenixService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        Process.killProcess(intent.getIntExtra("phoenix_main_process_pid", -1));
        int i3 = Build.VERSION.SDK_INT;
        Intent intent2 = i3 >= 33 ? (Intent) intent.getParcelableExtra("phoenix_restart_intent", Intent.class) : (Intent) intent.getParcelableExtra("phoenix_restart_intent");
        if (i3 > 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(StrictMode.getVmPolicy()).permitUnsafeIntentLaunch().build());
        }
        startForegroundService(intent2);
        Runtime.getRuntime().exit(0);
    }
}
