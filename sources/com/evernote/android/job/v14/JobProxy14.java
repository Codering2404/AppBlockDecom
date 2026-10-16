package com.evernote.android.job.v14;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.PendingIntentUtil;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxy14 implements JobProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f67983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JobCat f67984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlarmManager f67985c;

    public JobProxy14(Context context) {
        this(context, "JobProxy14");
    }

    private void m(JobRequest jobRequest) {
        this.f67984b.c("Scheduled alarm, %s, delay %s (from now), exact %b, reschedule count %d", jobRequest, JobUtil.d(JobProxy.Common.h(jobRequest)), Boolean.valueOf(jobRequest.w()), Integer.valueOf(JobProxy.Common.n(jobRequest)));
    }

    @Override // com.evernote.android.job.JobProxy
    public void a(JobRequest jobRequest) {
        PendingIntent pendingIntentJ = j(jobRequest, true);
        AlarmManager alarmManagerG = g();
        if (alarmManagerG != null) {
            alarmManagerG.setRepeating(l(true), k(jobRequest), jobRequest.m(), pendingIntentJ);
        }
        this.f67984b.c("Scheduled repeating alarm, %s, interval %s", jobRequest, JobUtil.d(jobRequest.m()));
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean b(JobRequest jobRequest) {
        return i(jobRequest, 536870912 | PendingIntentUtil.a()) != null;
    }

    @Override // com.evernote.android.job.JobProxy
    public void c(int i3) {
        AlarmManager alarmManagerG = g();
        if (alarmManagerG != null) {
            try {
                alarmManagerG.cancel(h(i3, false, null, f(true)));
                alarmManagerG.cancel(h(i3, false, null, f(false)));
            } catch (Exception e3) {
                this.f67984b.f(e3);
            }
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void d(JobRequest jobRequest) {
        PendingIntent pendingIntentJ = j(jobRequest, false);
        AlarmManager alarmManagerG = g();
        if (alarmManagerG == null) {
            return;
        }
        try {
            o(jobRequest, alarmManagerG, pendingIntentJ);
        } catch (Exception e3) {
            this.f67984b.f(e3);
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void e(JobRequest jobRequest) {
        PendingIntent pendingIntentJ = j(jobRequest, false);
        AlarmManager alarmManagerG = g();
        if (alarmManagerG == null) {
            return;
        }
        try {
            if (!jobRequest.w()) {
                p(jobRequest, alarmManagerG, pendingIntentJ);
            } else if (jobRequest.s() != 1 || jobRequest.k() > 0) {
                n(jobRequest, alarmManagerG, pendingIntentJ);
            } else {
                PlatformAlarmService.l(this.f67983a, jobRequest.o(), jobRequest.u());
            }
        } catch (Exception e3) {
            this.f67984b.f(e3);
        }
    }

    protected int f(boolean z2) {
        int iA = PendingIntentUtil.a();
        return !z2 ? 1207959552 | iA : 134217728 | iA;
    }

    protected AlarmManager g() {
        if (this.f67985c == null) {
            this.f67985c = (AlarmManager) this.f67983a.getSystemService("alarm");
        }
        if (this.f67985c == null) {
            this.f67984b.d("AlarmManager is null");
        }
        return this.f67985c;
    }

    protected PendingIntent h(int i3, boolean z2, Bundle bundle, int i4) {
        try {
            return PendingIntent.getBroadcast(this.f67983a, i3, PlatformAlarmReceiver.a(this.f67983a, i3, z2, bundle), i4);
        } catch (Exception e3) {
            this.f67984b.f(e3);
            return null;
        }
    }

    protected PendingIntent i(JobRequest jobRequest, int i3) {
        return h(jobRequest.o(), jobRequest.w(), jobRequest.u(), i3);
    }

    protected PendingIntent j(JobRequest jobRequest, boolean z2) {
        return i(jobRequest, f(z2));
    }

    protected long k(JobRequest jobRequest) {
        long jA;
        long jH;
        if (JobConfig.i()) {
            jA = JobConfig.a().currentTimeMillis();
            jH = JobProxy.Common.h(jobRequest);
        } else {
            jA = JobConfig.a().a();
            jH = JobProxy.Common.h(jobRequest);
        }
        return jA + jH;
    }

    protected int l(boolean z2) {
        return z2 ? JobConfig.i() ? 0 : 2 : JobConfig.i() ? 1 : 3;
    }

    protected void n(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.setExactAndAllowWhileIdle(l(true), k(jobRequest), pendingIntent);
        m(jobRequest);
    }

    protected void o(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.set(1, JobConfig.a().currentTimeMillis() + JobProxy.Common.i(jobRequest), pendingIntent);
        this.f67984b.c("Scheduled repeating alarm (flex support), %s, interval %s, flex %s", jobRequest, JobUtil.d(jobRequest.m()), JobUtil.d(jobRequest.l()));
    }

    protected void p(JobRequest jobRequest, AlarmManager alarmManager, PendingIntent pendingIntent) {
        alarmManager.set(l(false), k(jobRequest), pendingIntent);
        m(jobRequest);
    }

    protected JobProxy14(Context context, String str) {
        this.f67983a = context;
        this.f67984b = new JobCat(str);
    }
}
