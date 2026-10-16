package com.evernote.android.job;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.LruCache;
import android.util.SparseArray;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.evernote.android.job.Job;
import com.evernote.android.job.util.JobCat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class JobExecutor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final JobCat f67859e = new JobCat("JobExecutor");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f67860f = TimeUnit.MINUTES.toMillis(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray f67861a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LruCache f67862b = new LruCache(20);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f67863c = new SparseArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f67864d = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class JobCallable implements Callable<Job.Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Job f67865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PowerManager.WakeLock f67866b;

        /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(com.evernote.android.job.Job r6, com.evernote.android.job.Job.Result r7) {
            /*
                r5 = this;
                com.evernote.android.job.Job r0 = r5.f67865a
                com.evernote.android.job.Job$Params r0 = r0.e()
                com.evernote.android.job.JobRequest r0 = r0.c()
                boolean r1 = r0.y()
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L31
                com.evernote.android.job.Job$Result r1 = com.evernote.android.job.Job.Result.RESCHEDULE
                boolean r1 = r1.equals(r7)
                if (r1 == 0) goto L31
                boolean r1 = r6.g()
                if (r1 != 0) goto L31
                com.evernote.android.job.JobRequest r0 = r0.I(r2, r2)
                com.evernote.android.job.Job r7 = r5.f67865a
                int r1 = r0.o()
                r7.s(r1)
            L2d:
                r4 = r3
                r3 = r2
                r2 = r4
                goto L42
            L31:
                boolean r1 = r0.y()
                if (r1 == 0) goto L41
                com.evernote.android.job.Job$Result r1 = com.evernote.android.job.Job.Result.SUCCESS
                boolean r7 = r1.equals(r7)
                if (r7 != 0) goto L2d
                r3 = r2
                goto L42
            L41:
                r2 = r3
            L42:
                boolean r6 = r6.g()
                if (r6 != 0) goto L4f
                if (r2 != 0) goto L4c
                if (r3 == 0) goto L4f
            L4c:
                r0.O(r2, r3)
            L4f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.JobExecutor.JobCallable.b(com.evernote.android.job.Job, com.evernote.android.job.Job$Result):void");
        }

        private Job.Result c() {
            try {
                Job.Result resultU = this.f67865a.u();
                JobExecutor.f67859e.i("Finished %s", this.f67865a);
                b(this.f67865a, resultU);
                return resultU;
            } catch (Throwable th) {
                JobExecutor.f67859e.g(th, "Crashed %s", this.f67865a);
                return this.f67865a.f();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0026 A[DONT_GENERATE] */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.evernote.android.job.Job.Result call() {
            /*
                r5 = this;
                java.lang.String r0 = "Wake lock was not held after job %s was done. The job took too long to complete. This could have unintended side effects on your app."
                com.evernote.android.job.Job r1 = r5.f67865a     // Catch: java.lang.Throwable -> L39
                android.content.Context r1 = r1.c()     // Catch: java.lang.Throwable -> L39
                android.os.PowerManager$WakeLock r2 = r5.f67866b     // Catch: java.lang.Throwable -> L39
                long r3 = com.evernote.android.job.JobExecutor.a()     // Catch: java.lang.Throwable -> L39
                com.evernote.android.job.WakeLockUtil.b(r1, r2, r3)     // Catch: java.lang.Throwable -> L39
                com.evernote.android.job.Job$Result r1 = r5.c()     // Catch: java.lang.Throwable -> L39
                com.evernote.android.job.JobExecutor r2 = com.evernote.android.job.JobExecutor.this
                com.evernote.android.job.Job r3 = r5.f67865a
                r2.i(r3)
                android.os.PowerManager$WakeLock r2 = r5.f67866b
                if (r2 == 0) goto L26
                boolean r2 = r2.isHeld()
                if (r2 != 0) goto L33
            L26:
                com.evernote.android.job.util.JobCat r2 = com.evernote.android.job.JobExecutor.b()
                com.evernote.android.job.Job r3 = r5.f67865a
                java.lang.Object[] r3 = new java.lang.Object[]{r3}
                r2.k(r0, r3)
            L33:
                android.os.PowerManager$WakeLock r0 = r5.f67866b
                com.evernote.android.job.WakeLockUtil.d(r0)
                return r1
            L39:
                r1 = move-exception
                com.evernote.android.job.JobExecutor r2 = com.evernote.android.job.JobExecutor.this
                com.evernote.android.job.Job r3 = r5.f67865a
                r2.i(r3)
                android.os.PowerManager$WakeLock r2 = r5.f67866b
                if (r2 == 0) goto L4b
                boolean r2 = r2.isHeld()
                if (r2 != 0) goto L58
            L4b:
                com.evernote.android.job.util.JobCat r2 = com.evernote.android.job.JobExecutor.b()
                com.evernote.android.job.Job r3 = r5.f67865a
                java.lang.Object[] r3 = new java.lang.Object[]{r3}
                r2.k(r0, r3)
            L58:
                android.os.PowerManager$WakeLock r0 = r5.f67866b
                com.evernote.android.job.WakeLockUtil.d(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.JobExecutor.JobCallable.call():com.evernote.android.job.Job$Result");
        }

        private JobCallable(Job job) {
            this.f67865a = job;
            this.f67866b = WakeLockUtil.a(job.c(), KLAQHFCRAUejH.EmZy, JobExecutor.f67860f);
        }
    }

    void c(LruCache lruCache) {
        HashMap map = new HashMap(lruCache.snapshot());
        for (Integer num : map.keySet()) {
            if (map.get(num) == null || ((WeakReference) map.get(num)).get() == null) {
                lruCache.remove(num);
            }
        }
    }

    public synchronized Future d(Context context, JobRequest jobRequest, Job job, Bundle bundle) {
        this.f67864d.remove(jobRequest);
        if (job == null) {
            f67859e.k("JobCreator returned null for tag %s", jobRequest.t());
            return null;
        }
        if (job.h()) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "Job for tag %s was already run, a creator should always create a new Job instance", jobRequest.t()));
        }
        job.v(context).w(jobRequest, bundle);
        f67859e.i("Executing %s, context %s", jobRequest, context.getClass().getSimpleName());
        this.f67861a.put(jobRequest.o(), job);
        return JobConfig.b().submit(new JobCallable(job));
    }

    public synchronized Set e() {
        return f(null);
    }

    public synchronized Set f(String str) {
        HashSet hashSet;
        try {
            hashSet = new HashSet();
            for (int i3 = 0; i3 < this.f67861a.size(); i3++) {
                Job job = (Job) this.f67861a.valueAt(i3);
                if (str == null || str.equals(job.e().d())) {
                    hashSet.add(job);
                }
            }
            Iterator it = this.f67862b.snapshot().values().iterator();
            while (it.hasNext()) {
                Job job2 = (Job) ((WeakReference) it.next()).get();
                if (job2 != null && (str == null || str.equals(job2.e().d()))) {
                    hashSet.add(job2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return hashSet;
    }

    public synchronized Job g(int i3) {
        Job job = (Job) this.f67861a.get(i3);
        if (job != null) {
            return job;
        }
        WeakReference weakReference = (WeakReference) this.f67862b.get(Integer.valueOf(i3));
        return weakReference != null ? (Job) weakReference.get() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean h(com.evernote.android.job.JobRequest r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L10
            java.util.Set r0 = r1.f67864d     // Catch: java.lang.Throwable -> Ld
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto L10
            r2 = 1
            goto L11
        Ld:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r2
        L10:
            r2 = 0
        L11:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.JobExecutor.h(com.evernote.android.job.JobRequest):boolean");
    }

    synchronized void i(Job job) {
        int iB = job.e().b();
        this.f67861a.remove(iB);
        c(this.f67862b);
        this.f67863c.put(iB, job.f());
        this.f67862b.put(Integer.valueOf(iB), new WeakReference(job));
    }

    public synchronized void j(JobRequest jobRequest) {
        this.f67864d.add(jobRequest);
    }
}
