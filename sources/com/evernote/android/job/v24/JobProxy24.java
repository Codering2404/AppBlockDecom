package com.evernote.android.job.v24;

import android.app.job.JobInfo;
import android.content.Context;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.v21.JobProxy21;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxy24 extends JobProxy21 {

    /* JADX INFO: renamed from: com.evernote.android.job.v24.JobProxy24$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68001a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f68001a = iArr;
            try {
                iArr[JobRequest.NetworkType.NOT_ROAMING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public JobProxy24(Context context) {
        this(context, "JobProxy24");
    }

    @Override // com.evernote.android.job.v21.JobProxy21, com.evernote.android.job.JobProxy
    public boolean b(JobRequest jobRequest) {
        try {
            return k(j().getPendingJob(jobRequest.o()), jobRequest);
        } catch (Exception e3) {
            this.f67995b.f(e3);
            return false;
        }
    }

    @Override // com.evernote.android.job.v21.JobProxy21, com.evernote.android.job.JobProxy
    public void d(JobRequest jobRequest) {
        this.f67995b.j("plantPeriodicFlexSupport called although flex is supported");
        super.d(jobRequest);
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    protected int f(JobRequest.NetworkType networkType) {
        if (AnonymousClass1.f68001a[networkType.ordinal()] != 1) {
            return super.f(networkType);
        }
        return 3;
    }

    @Override // com.evernote.android.job.v21.JobProxy21
    protected JobInfo.Builder i(JobInfo.Builder builder, long j3, long j4) {
        return builder.setPeriodic(j3, j4);
    }

    public JobProxy24(Context context, String str) {
        super(context, str);
    }
}
