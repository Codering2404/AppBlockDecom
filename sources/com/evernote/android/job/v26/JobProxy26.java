package com.evernote.android.job.v26;

import android.app.job.JobInfo;
import android.content.Context;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.v24.JobProxy24;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxy26 extends JobProxy24 {

    /* JADX INFO: renamed from: com.evernote.android.job.v26.JobProxy26$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68002a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f68002a = iArr;
            try {
                iArr[JobRequest.NetworkType.METERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public JobProxy26(Context context) {
        super(context, "JobProxy26");
    }

    @Override // com.evernote.android.job.v24.JobProxy24, com.evernote.android.job.v21.JobProxy21
    protected int f(JobRequest.NetworkType networkType) {
        if (AnonymousClass1.f68002a[networkType.ordinal()] != 1) {
            return super.f(networkType);
        }
        return 4;
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    protected JobInfo.Builder g(JobRequest jobRequest, boolean z2) {
        return super.g(jobRequest, z2).setRequiresBatteryNotLow(jobRequest.E()).setRequiresStorageNotLow(jobRequest.H());
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    protected boolean k(JobInfo jobInfo, JobRequest jobRequest) {
        return jobInfo != null && jobInfo.getId() == jobRequest.o();
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    protected JobInfo.Builder n(JobRequest jobRequest, JobInfo.Builder builder) {
        return builder.setTransientExtras(jobRequest.u());
    }
}
