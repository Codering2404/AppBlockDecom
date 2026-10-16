package com.evernote.android.job;

import android.content.Context;
import android.os.Bundle;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.Device;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Job {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final JobCat f67814j = new JobCat("Job");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Params f67815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f67816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f67817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f67818d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f67819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile long f67820g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Result f67821h = Result.FAILURE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f67822i = new Object();

    /* JADX INFO: renamed from: com.evernote.android.job.Job$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67823a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f67823a = iArr;
            try {
                iArr[JobRequest.NetworkType.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67823a[JobRequest.NetworkType.NOT_ROAMING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67823a[JobRequest.NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67823a[JobRequest.NetworkType.METERED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JobRequest f67824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PersistableBundleCompat f67825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f67826c;

        /* synthetic */ Params(JobRequest jobRequest, Bundle bundle, AnonymousClass1 anonymousClass1) {
            this(jobRequest, bundle);
        }

        public PersistableBundleCompat a() {
            if (this.f67825b == null) {
                PersistableBundleCompat persistableBundleCompatJ = this.f67824a.j();
                this.f67825b = persistableBundleCompatJ;
                if (persistableBundleCompatJ == null) {
                    this.f67825b = new PersistableBundleCompat();
                }
            }
            return this.f67825b;
        }

        public int b() {
            return this.f67824a.o();
        }

        JobRequest c() {
            return this.f67824a;
        }

        public String d() {
            return this.f67824a.t();
        }

        public Bundle e() {
            return this.f67826c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Params.class != obj.getClass()) {
                return false;
            }
            return this.f67824a.equals(((Params) obj).f67824a);
        }

        public boolean f() {
            return this.f67824a.y();
        }

        public int hashCode() {
            return this.f67824a.hashCode();
        }

        private Params(JobRequest jobRequest, Bundle bundle) {
            this.f67824a = jobRequest;
            this.f67826c = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Result {
        SUCCESS,
        FAILURE,
        RESCHEDULE
    }

    public final void a() {
        b(false);
    }

    final boolean b(boolean z2) {
        synchronized (this.f67822i) {
            try {
                if (h()) {
                    return false;
                }
                if (!this.f67818d) {
                    this.f67818d = true;
                    q();
                }
                this.f67819f = z2 | this.f67819f;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final Context c() {
        Context context = (Context) this.f67816b.get();
        return context == null ? this.f67817c : context;
    }

    final long d() {
        long j3;
        synchronized (this.f67822i) {
            j3 = this.f67820g;
        }
        return j3;
    }

    protected final Params e() {
        return this.f67815a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f67815a.equals(((Job) obj).f67815a);
    }

    final Result f() {
        return this.f67821h;
    }

    final boolean g() {
        boolean z2;
        synchronized (this.f67822i) {
            z2 = this.f67819f;
        }
        return z2;
    }

    public final boolean h() {
        boolean z2;
        synchronized (this.f67822i) {
            z2 = this.f67820g > 0;
        }
        return z2;
    }

    public int hashCode() {
        return this.f67815a.hashCode();
    }

    protected boolean j() {
        return (e().c().E() && Device.a(c()).a()) ? false : true;
    }

    protected boolean k() {
        return !e().c().F() || Device.a(c()).b();
    }

    protected boolean l() {
        return !e().c().G() || Device.c(c());
    }

    protected boolean m() {
        JobRequest.NetworkType networkTypeC = e().c().C();
        JobRequest.NetworkType networkType = JobRequest.NetworkType.ANY;
        if (networkTypeC == networkType) {
            return true;
        }
        JobRequest.NetworkType networkTypeB = Device.b(c());
        int i3 = AnonymousClass1.f67823a[networkTypeC.ordinal()];
        if (i3 == 1) {
            return networkTypeB != networkType;
        }
        if (i3 == 2) {
            return networkTypeB == JobRequest.NetworkType.NOT_ROAMING || networkTypeB == JobRequest.NetworkType.UNMETERED || networkTypeB == JobRequest.NetworkType.METERED;
        }
        if (i3 == 3) {
            return networkTypeB == JobRequest.NetworkType.UNMETERED;
        }
        if (i3 == 4) {
            return networkTypeB == JobRequest.NetworkType.CONNECTED || networkTypeB == JobRequest.NetworkType.NOT_ROAMING;
        }
        throw new IllegalStateException("not implemented");
    }

    protected boolean o() {
        return (e().c().H() && Device.e()) ? false : true;
    }

    boolean p(boolean z2) {
        if (z2 && !e().c().D()) {
            return true;
        }
        if (!k()) {
            f67814j.j("Job requires charging, reschedule");
            return false;
        }
        if (!l()) {
            f67814j.j("Job requires device to be idle, reschedule");
            return false;
        }
        if (!m()) {
            f67814j.k("Job requires network to be %s, but was %s", e().c().C(), Device.b(c()));
            return false;
        }
        if (!j()) {
            f67814j.j("Job requires battery not be low, reschedule");
            return false;
        }
        if (o()) {
            return true;
        }
        f67814j.j("Job requires storage not be low, reschedule");
        return false;
    }

    protected abstract Result t(Params params);

    public String toString() {
        return "job{id=" + this.f67815a.b() + ", finished=" + h() + ", result=" + this.f67821h + ", canceled=" + this.f67818d + ", periodic=" + this.f67815a.f() + ", class=" + getClass().getSimpleName() + ", tag=" + this.f67815a.d() + '}';
    }

    final Result u() {
        try {
            if ((this instanceof DailyJob) || p(true)) {
                this.f67821h = t(e());
            } else {
                this.f67821h = e().f() ? Result.FAILURE : Result.RESCHEDULE;
            }
            Result result = this.f67821h;
            this.f67820g = System.currentTimeMillis();
            return result;
        } catch (Throwable th) {
            this.f67820g = System.currentTimeMillis();
            throw th;
        }
    }

    final Job v(Context context) {
        this.f67816b = new WeakReference(context);
        this.f67817c = context.getApplicationContext();
        return this;
    }

    final Job w(JobRequest jobRequest, Bundle bundle) {
        this.f67815a = new Params(jobRequest, bundle, null);
        return this;
    }

    protected void q() {
    }

    protected void s(int i3) {
    }
}
