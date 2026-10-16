package com.evernote.android.job.v14;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.evernote.android.job.JobProxy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PlatformAlarmReceiver extends BroadcastReceiver {
    static Intent a(Context context, int i3, boolean z2, Bundle bundle) {
        Intent intentPutExtra = new Intent(context, (Class<?>) PlatformAlarmReceiver.class).putExtra("EXTRA_JOB_ID", i3).putExtra("EXTRA_JOB_EXACT", z2);
        if (bundle != null) {
            intentPutExtra.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        return intentPutExtra;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.hasExtra("EXTRA_JOB_ID") && intent.hasExtra("EXTRA_JOB_EXACT")) {
            int intExtra = intent.getIntExtra("EXTRA_JOB_ID", -1);
            Bundle bundleExtra = intent.getBundleExtra("EXTRA_TRANSIENT_EXTRAS");
            if (intent.getBooleanExtra("EXTRA_JOB_EXACT", false)) {
                JobProxy.Common.r(context, PlatformAlarmServiceExact.c(context, intExtra, bundleExtra));
            } else {
                PlatformAlarmService.l(context, intExtra, bundleExtra);
            }
        }
    }
}
