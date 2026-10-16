package com.evernote.android.job;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface JobCreator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class AddJobCreatorReceiver extends BroadcastReceiver {
        protected abstract void a(Context context, JobManager jobManager);

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context == null || intent == null || !"com.evernote.android.job.ADD_JOB_CREATOR".equals(intent.getAction())) {
                return;
            }
            try {
                a(context, JobManager.i(context));
            } catch (JobManagerCreateException unused) {
            }
        }
    }

    Job a(String str);
}
