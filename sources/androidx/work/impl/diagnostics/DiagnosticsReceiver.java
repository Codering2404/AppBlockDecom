package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f54919a = Logger.i("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger.e().a(f54919a, "Requesting diagnostics");
        try {
            WorkManager.h(context).c(OneTimeWorkRequest.e(DiagnosticsWorker.class));
        } catch (IllegalStateException e3) {
            Logger.e().d(f54919a, "WorkManager is not initialized", e3);
        }
    }
}
