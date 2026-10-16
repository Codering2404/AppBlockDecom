package com.evernote.android.job.v19;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobUtil;
import com.evernote.android.job.v14.JobProxy14;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxy19 extends JobProxy14 {
    public JobProxy19(Context context) {
        super(context, "JobProxy19");
    }

    @Override // com.evernote.android.job.v14.JobProxy14
    protected void o(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.setWindow(1, System.currentTimeMillis() + JobProxy.Common.p(jobRequest), JobProxy.Common.l(jobRequest) - JobProxy.Common.p(jobRequest), pendingIntent);
        this.f67984b.c("Scheduled repeating alarm (flex support), %s, start %s, end %s, flex %s", jobRequest, JobUtil.d(JobProxy.Common.p(jobRequest)), JobUtil.d(JobProxy.Common.l(jobRequest)), JobUtil.d(jobRequest.l()));
    }

    @Override // com.evernote.android.job.v14.JobProxy14
    protected void p(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.setWindow(1, System.currentTimeMillis() + JobProxy.Common.o(jobRequest), JobProxy.Common.j(jobRequest) - JobProxy.Common.o(jobRequest), pendingIntent);
        this.f67984b.c("Schedule alarm, %s, start %s, end %s", jobRequest, JobUtil.d(JobProxy.Common.o(jobRequest)), JobUtil.d(JobProxy.Common.j(jobRequest)));
    }
}
