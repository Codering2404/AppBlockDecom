package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkContinuationImpl extends WorkContinuation {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f54653j = Logger.i("WorkContinuationImpl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkManagerImpl f54654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f54655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExistingWorkPolicy f54656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f54657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f54658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f54659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f54660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f54661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Operation f54662i;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List list) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean i(WorkContinuationImpl workContinuationImpl, Set set) {
        set.addAll(workContinuationImpl.c());
        Set setL = l(workContinuationImpl);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (setL.contains((String) it.next())) {
                return true;
            }
        }
        List listE = workContinuationImpl.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                if (i((WorkContinuationImpl) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.c());
        return false;
    }

    public static Set l(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List listE = workContinuationImpl.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((WorkContinuationImpl) it.next()).c());
            }
        }
        return hashSet;
    }

    public Operation a() {
        if (this.f54661h) {
            Logger.e().k(f54653j, "Already enqueued work ids (" + TextUtils.join(", ", this.f54658e) + ")");
        } else {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f54654a.x().d(enqueueRunnable);
            this.f54662i = enqueueRunnable.d();
        }
        return this.f54662i;
    }

    public ExistingWorkPolicy b() {
        return this.f54656c;
    }

    public List c() {
        return this.f54658e;
    }

    public String d() {
        return this.f54655b;
    }

    public List e() {
        return this.f54660g;
    }

    public List f() {
        return this.f54657d;
    }

    public WorkManagerImpl g() {
        return this.f54654a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f54661h;
    }

    public void k() {
        this.f54661h = true;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this(workManagerImpl, str, existingWorkPolicy, list, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list, List list2) {
        this.f54654a = workManagerImpl;
        this.f54655b = str;
        this.f54656c = existingWorkPolicy;
        this.f54657d = list;
        this.f54660g = list2;
        this.f54658e = new ArrayList(list.size());
        this.f54659f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f54659f.addAll(((WorkContinuationImpl) it.next()).f54659f);
            }
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (existingWorkPolicy == ExistingWorkPolicy.REPLACE && ((WorkRequest) list.get(i3)).d().g() != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String strB = ((WorkRequest) list.get(i3)).b();
            this.f54658e.add(strB);
            this.f54659f.add(strB);
        }
    }
}
