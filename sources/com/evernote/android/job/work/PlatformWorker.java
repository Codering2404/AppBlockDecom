package com.evernote.android.job.work;

import android.content.Context;
import android.os.Bundle;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PlatformWorker extends Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f68006a = new JobCat("PlatformWorker");

    public PlatformWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private int a() {
        return JobProxyWorkManager.h(getTags());
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Bundle bundleB;
        int iA = a();
        if (iA < 0) {
            return ListenableWorker.Result.a();
        }
        try {
            Context applicationContext = getApplicationContext();
            JobCat jobCat = f68006a;
            JobProxy.Common common = new JobProxy.Common(applicationContext, jobCat, iA);
            JobRequest jobRequestM = common.m(true, true);
            if (jobRequestM == null) {
                return ListenableWorker.Result.a();
            }
            if (jobRequestM.A()) {
                bundleB = TransientBundleHolder.b(iA);
                if (bundleB == null) {
                    jobCat.c("Transient bundle is gone for request %s", jobRequestM);
                    return ListenableWorker.Result.a();
                }
            } else {
                bundleB = null;
            }
            return Job.Result.SUCCESS == common.g(jobRequestM, bundleB) ? ListenableWorker.Result.c() : ListenableWorker.Result.a();
        } finally {
            TransientBundleHolder.a(iA);
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        int iA = a();
        Job jobO = JobManager.i(getApplicationContext()).o(iA);
        if (jobO == null) {
            f68006a.c("Called onStopped, job %d not found", Integer.valueOf(iA));
        } else {
            jobO.a();
            f68006a.c("Called onStopped for %s", jobO);
        }
    }
}
