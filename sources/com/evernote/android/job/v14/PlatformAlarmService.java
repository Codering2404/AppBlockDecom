package com.evernote.android.job.v14;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.JobIntentService;
import androidx.core.app.SafeJobIntentService;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PlatformAlarmService extends SafeJobIntentService {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final JobCat f67986k = new JobCat("PlatformAlarmService");

    static void k(Intent intent, Service service, JobCat jobCat) {
        if (intent == null) {
            jobCat.h("Delivered intent is null");
            return;
        }
        int intExtra = intent.getIntExtra("EXTRA_JOB_ID", -1);
        Bundle bundleExtra = intent.getBundleExtra("EXTRA_TRANSIENT_EXTRAS");
        JobProxy.Common common = new JobProxy.Common(service, jobCat, intExtra);
        JobRequest jobRequestM = common.m(true, true);
        if (jobRequestM != null) {
            common.g(jobRequestM, bundleExtra);
        }
    }

    public static void l(Context context, int i3, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_JOB_ID", i3);
        if (bundle != null) {
            intent.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        JobIntentService.d(context, PlatformAlarmService.class, 2147480001, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void h(Intent intent) {
        k(intent, this, f67986k);
    }
}
