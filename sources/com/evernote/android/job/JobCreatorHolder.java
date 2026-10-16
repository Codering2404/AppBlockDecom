package com.evernote.android.job;

import com.evernote.android.job.util.JobCat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class JobCreatorHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JobCat f67857b = new JobCat("JobCreatorHolder");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67858a = new CopyOnWriteArrayList();

    public void a(JobCreator jobCreator) {
        this.f67858a.add(jobCreator);
    }

    public Job b(String str) {
        Iterator it = this.f67858a.iterator();
        Job jobA = null;
        boolean z2 = false;
        while (it.hasNext()) {
            jobA = ((JobCreator) it.next()).a(str);
            z2 = true;
            if (jobA != null) {
                break;
            }
        }
        if (!z2) {
            f67857b.j("no JobCreator added");
        }
        return jobA;
    }

    public boolean c() {
        return this.f67858a.isEmpty();
    }
}
