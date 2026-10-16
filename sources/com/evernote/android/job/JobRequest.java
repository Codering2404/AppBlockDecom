package com.evernote.android.job;

import android.app.AlarmManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobPreconditions;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobRequest {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BackoffPolicy f67882g = BackoffPolicy.EXPONENTIAL;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final NetworkType f67883h = NetworkType.ANY;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JobScheduledCallback f67884i = new JobScheduledCallback() { // from class: com.evernote.android.job.JobRequest.1
        @Override // com.evernote.android.job.JobRequest.JobScheduledCallback
        public void a(int i3, String str, Exception exc) {
            if (exc != null) {
                JobRequest.f67887l.g(exc, "The job with tag %s couldn't be scheduled", str);
            }
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f67885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f67886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final JobCat f67887l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Builder f67888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f67889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f67890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f67891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f67892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f67893f;

    /* JADX INFO: renamed from: com.evernote.android.job.JobRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JobScheduledCallback f67894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JobRequest f67895b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f67894a.a(this.f67895b.J(), this.f67895b.t(), null);
            } catch (Exception e3) {
                this.f67894a.a(-1, this.f67895b.t(), e3);
            }
        }
    }

    /* JADX INFO: renamed from: com.evernote.android.job.JobRequest$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67896a;

        static {
            int[] iArr = new int[BackoffPolicy.values().length];
            f67896a = iArr;
            try {
                iArr[BackoffPolicy.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67896a[BackoffPolicy.EXPONENTIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum BackoffPolicy {
        LINEAR,
        EXPONENTIAL
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f67900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f67901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f67902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f67903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f67904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private BackoffPolicy f67905f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f67906g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f67907h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f67908i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f67909j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f67910k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f67911l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f67912m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f67913n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private NetworkType f67914o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private PersistableBundleCompat f67915p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f67916q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f67917r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f67918s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Bundle f67919t;

        /* JADX INFO: Access modifiers changed from: private */
        public void x(ContentValues contentValues) {
            contentValues.put("_id", Integer.valueOf(this.f67900a));
            contentValues.put("tag", this.f67901b);
            contentValues.put("startMs", Long.valueOf(this.f67902c));
            contentValues.put("endMs", Long.valueOf(this.f67903d));
            contentValues.put("backoffMs", Long.valueOf(this.f67904e));
            contentValues.put("backoffPolicy", this.f67905f.toString());
            contentValues.put("intervalMs", Long.valueOf(this.f67906g));
            contentValues.put("flexMs", Long.valueOf(this.f67907h));
            contentValues.put("requirementsEnforced", Boolean.valueOf(this.f67908i));
            contentValues.put("requiresCharging", Boolean.valueOf(this.f67909j));
            contentValues.put("requiresDeviceIdle", Boolean.valueOf(this.f67910k));
            contentValues.put("requiresBatteryNotLow", Boolean.valueOf(this.f67911l));
            contentValues.put("requiresStorageNotLow", Boolean.valueOf(this.f67912m));
            contentValues.put("exact", Boolean.valueOf(this.f67913n));
            contentValues.put("networkType", this.f67914o.toString());
            PersistableBundleCompat persistableBundleCompat = this.f67915p;
            if (persistableBundleCompat != null) {
                contentValues.put("extras", persistableBundleCompat.l());
            } else if (!TextUtils.isEmpty(this.f67916q)) {
                contentValues.put("extras", this.f67916q);
            }
            contentValues.put(FacebookRequestErrorClassification.KEY_TRANSIENT, Boolean.valueOf(this.f67918s));
        }

        public Builder A(long j3, long j4) {
            this.f67902c = JobPreconditions.d(j3, "startInMs must be greater than 0");
            this.f67903d = JobPreconditions.a(j4, j3, Long.MAX_VALUE, "endInMs");
            if (this.f67902c > 6148914691236517204L) {
                JobCat jobCat = JobRequest.f67887l;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jobCat.i("startInMs reduced from %d days to %d days", Long.valueOf(timeUnit.toDays(this.f67902c)), Long.valueOf(timeUnit.toDays(6148914691236517204L)));
                this.f67902c = 6148914691236517204L;
            }
            if (this.f67903d > 6148914691236517204L) {
                JobCat jobCat2 = JobRequest.f67887l;
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                jobCat2.i("endInMs reduced from %d days to %d days", Long.valueOf(timeUnit2.toDays(this.f67903d)), Long.valueOf(timeUnit2.toDays(6148914691236517204L)));
                this.f67903d = 6148914691236517204L;
            }
            return this;
        }

        public Builder B(PersistableBundleCompat persistableBundleCompat) {
            if (persistableBundleCompat != null) {
                this.f67915p = new PersistableBundleCompat(persistableBundleCompat);
                return this;
            }
            this.f67915p = null;
            this.f67916q = null;
            return this;
        }

        public Builder C(long j3) {
            return D(j3, j3);
        }

        public Builder D(long j3, long j4) {
            this.f67906g = JobPreconditions.a(j3, JobRequest.q(), Long.MAX_VALUE, "intervalMs");
            this.f67907h = JobPreconditions.a(j4, JobRequest.p(), this.f67906g, "flexMs");
            return this;
        }

        public Builder E(NetworkType networkType) {
            this.f67914o = networkType;
            return this;
        }

        public Builder F(boolean z2) {
            this.f67908i = z2;
            return this;
        }

        public Builder G(Bundle bundle) {
            boolean z2 = (bundle == null || bundle.isEmpty()) ? false : true;
            this.f67918s = z2;
            this.f67919t = z2 ? new Bundle(bundle) : Bundle.EMPTY;
            return this;
        }

        public Builder H(boolean z2) {
            this.f67917r = z2;
            return this;
        }

        public Builder I() {
            return z(1L);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && Builder.class == obj.getClass() && this.f67900a == ((Builder) obj).f67900a;
        }

        public int hashCode() {
            return this.f67900a;
        }

        public Builder v(PersistableBundleCompat persistableBundleCompat) {
            PersistableBundleCompat persistableBundleCompat2 = this.f67915p;
            if (persistableBundleCompat2 == null) {
                this.f67915p = persistableBundleCompat;
            } else {
                persistableBundleCompat2.g(persistableBundleCompat);
            }
            this.f67916q = null;
            return this;
        }

        public Builder y(long j3, BackoffPolicy backoffPolicy) {
            this.f67904e = JobPreconditions.d(j3, "backoffMs must be > 0");
            this.f67905f = (BackoffPolicy) JobPreconditions.f(backoffPolicy);
            return this;
        }

        public Builder z(long j3) {
            this.f67913n = true;
            if (j3 > 6148914691236517204L) {
                JobCat jobCat = JobRequest.f67887l;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jobCat.i(tDEtWsFLJfe.NfouGEFZta, Long.valueOf(timeUnit.toDays(j3)), Long.valueOf(timeUnit.toDays(6148914691236517204L)));
                j3 = 6148914691236517204L;
            }
            return A(j3, j3);
        }

        public JobRequest w() {
            JobPreconditions.e(this.f67901b);
            JobPreconditions.d(this.f67904e, "backoffMs must be > 0");
            JobPreconditions.f(this.f67905f);
            JobPreconditions.f(this.f67914o);
            long j3 = this.f67906g;
            if (j3 > 0) {
                JobPreconditions.a(j3, JobRequest.q(), Long.MAX_VALUE, "intervalMs");
                JobPreconditions.a(this.f67907h, JobRequest.p(), this.f67906g, "flexMs");
                long j4 = this.f67906g;
                long j5 = JobRequest.f67885j;
                if (j4 < j5 || this.f67907h < JobRequest.f67886k) {
                    JobRequest.f67887l.k("AllowSmallerIntervals enabled, this will crash on Android N and later, interval %d (minimum is %d), flex %d (minimum is %d)", Long.valueOf(this.f67906g), Long.valueOf(j5), Long.valueOf(this.f67907h), Long.valueOf(JobRequest.f67886k));
                }
            }
            boolean z2 = this.f67913n;
            if (z2 && this.f67906g > 0) {
                throw new IllegalArgumentException("Can't call setExact() on a periodic job.");
            }
            if (z2 && this.f67902c != this.f67903d) {
                throw new IllegalArgumentException("Can't call setExecutionWindow() for an exact job.");
            }
            if (z2 && (this.f67908i || this.f67910k || this.f67909j || !JobRequest.f67883h.equals(this.f67914o) || this.f67911l || this.f67912m)) {
                throw new IllegalArgumentException("Can't require any condition for an exact job.");
            }
            long j6 = this.f67906g;
            if (j6 <= 0 && (this.f67902c == -1 || this.f67903d == -1)) {
                throw new IllegalArgumentException("You're trying to build a job with no constraints, this is not allowed.");
            }
            if (j6 > 0 && (this.f67902c != -1 || this.f67903d != -1)) {
                throw new IllegalArgumentException("Can't call setExecutionWindow() on a periodic job.");
            }
            if (j6 > 0 && (this.f67904e != 30000 || !JobRequest.f67882g.equals(this.f67905f))) {
                throw new IllegalArgumentException("A periodic job will not respect any back-off policy, so calling setBackoffCriteria() with setPeriodic() is an error.");
            }
            if (this.f67906g <= 0 && (this.f67902c > 3074457345618258602L || this.f67903d > 3074457345618258602L)) {
                JobRequest.f67887l.j("Attention: your execution window is too large. This could result in undesired behavior, see https://github.com/evernote/android-job/wiki/FAQ");
            }
            if (this.f67906g <= 0 && this.f67902c > TimeUnit.DAYS.toMillis(365L)) {
                JobRequest.f67887l.k("Warning: job with tag %s scheduled over a year in the future", this.f67901b);
            }
            int i3 = this.f67900a;
            String str = CbYNFSEGaQj.VyJTTEdzdvXa;
            if (i3 != -8765) {
                JobPreconditions.b(i3, str);
            }
            Builder builder = new Builder(this);
            if (this.f67900a == -8765) {
                int iN = JobManager.v().u().n();
                builder.f67900a = iN;
                JobPreconditions.b(iN, str);
            }
            return new JobRequest(builder);
        }

        public Builder(String str) {
            this.f67919t = Bundle.EMPTY;
            this.f67901b = (String) JobPreconditions.e(str);
            this.f67900a = -8765;
            this.f67902c = -1L;
            this.f67903d = -1L;
            this.f67904e = 30000L;
            this.f67905f = JobRequest.f67882g;
            this.f67914o = JobRequest.f67883h;
        }

        private Builder(Cursor cursor) {
            this.f67919t = Bundle.EMPTY;
            this.f67900a = cursor.getInt(cursor.getColumnIndex("_id"));
            this.f67901b = cursor.getString(cursor.getColumnIndex("tag"));
            this.f67902c = cursor.getLong(cursor.getColumnIndex("startMs"));
            this.f67903d = cursor.getLong(cursor.getColumnIndex("endMs"));
            this.f67904e = cursor.getLong(cursor.getColumnIndex("backoffMs"));
            try {
                this.f67905f = BackoffPolicy.valueOf(cursor.getString(cursor.getColumnIndex("backoffPolicy")));
            } catch (Throwable th) {
                JobRequest.f67887l.f(th);
                this.f67905f = JobRequest.f67882g;
            }
            this.f67906g = cursor.getLong(cursor.getColumnIndex("intervalMs"));
            this.f67907h = cursor.getLong(cursor.getColumnIndex("flexMs"));
            this.f67908i = cursor.getInt(cursor.getColumnIndex("requirementsEnforced")) > 0;
            this.f67909j = cursor.getInt(cursor.getColumnIndex("requiresCharging")) > 0;
            this.f67910k = cursor.getInt(cursor.getColumnIndex("requiresDeviceIdle")) > 0;
            this.f67911l = cursor.getInt(cursor.getColumnIndex("requiresBatteryNotLow")) > 0;
            this.f67912m = cursor.getInt(cursor.getColumnIndex("requiresStorageNotLow")) > 0;
            this.f67913n = cursor.getInt(cursor.getColumnIndex("exact")) > 0;
            try {
                this.f67914o = NetworkType.valueOf(cursor.getString(cursor.getColumnIndex("networkType")));
            } catch (Throwable th2) {
                JobRequest.f67887l.f(th2);
                this.f67914o = JobRequest.f67883h;
            }
            this.f67916q = cursor.getString(cursor.getColumnIndex("extras"));
            this.f67918s = cursor.getInt(cursor.getColumnIndex(FacebookRequestErrorClassification.KEY_TRANSIENT)) > 0;
        }

        private Builder(Builder builder) {
            this(builder, false);
        }

        private Builder(Builder builder, boolean z2) {
            this.f67919t = Bundle.EMPTY;
            this.f67900a = z2 ? -8765 : builder.f67900a;
            this.f67901b = builder.f67901b;
            this.f67902c = builder.f67902c;
            this.f67903d = builder.f67903d;
            this.f67904e = builder.f67904e;
            this.f67905f = builder.f67905f;
            this.f67906g = builder.f67906g;
            this.f67907h = builder.f67907h;
            this.f67908i = builder.f67908i;
            this.f67909j = builder.f67909j;
            this.f67910k = builder.f67910k;
            this.f67911l = builder.f67911l;
            this.f67912m = builder.f67912m;
            this.f67913n = builder.f67913n;
            this.f67914o = builder.f67914o;
            this.f67915p = builder.f67915p;
            this.f67916q = builder.f67916q;
            this.f67917r = builder.f67917r;
            this.f67918s = builder.f67918s;
            this.f67919t = builder.f67919t;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface JobScheduledCallback {
        void a(int i3, String str, Exception exc);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum NetworkType {
        ANY,
        CONNECTED,
        UNMETERED,
        NOT_ROAMING,
        METERED
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f67885j = timeUnit.toMillis(15L);
        f67886k = timeUnit.toMillis(5L);
        f67887l = new JobCat("JobRequest");
    }

    private static Context c() {
        return JobManager.v().n();
    }

    static JobRequest e(Cursor cursor) {
        JobRequest jobRequestW = new Builder(cursor).w();
        jobRequestW.f67889b = cursor.getInt(cursor.getColumnIndex("numFailures"));
        jobRequestW.f67890c = cursor.getLong(cursor.getColumnIndex("scheduledAt"));
        jobRequestW.f67891d = cursor.getInt(cursor.getColumnIndex("started")) > 0;
        jobRequestW.f67892e = cursor.getInt(cursor.getColumnIndex("flexSupport")) > 0;
        jobRequestW.f67893f = cursor.getLong(cursor.getColumnIndex("lastRun"));
        JobPreconditions.b(jobRequestW.f67889b, "failure count can't be negative");
        JobPreconditions.c(jobRequestW.f67890c, "scheduled at can't be negative");
        return jobRequestW;
    }

    static long p() {
        return JobConfig.e() ? TimeUnit.SECONDS.toMillis(30L) : f67886k;
    }

    static long q() {
        return JobConfig.e() ? TimeUnit.MINUTES.toMillis(1L) : f67885j;
    }

    public boolean A() {
        return this.f67888a.f67918s;
    }

    public boolean B() {
        return this.f67888a.f67917r;
    }

    public NetworkType C() {
        return this.f67888a.f67914o;
    }

    public boolean D() {
        return this.f67888a.f67908i;
    }

    public boolean E() {
        return this.f67888a.f67911l;
    }

    public boolean F() {
        return this.f67888a.f67909j;
    }

    public boolean G() {
        return this.f67888a.f67910k;
    }

    public boolean H() {
        return this.f67888a.f67912m;
    }

    JobRequest I(boolean z2, boolean z3) {
        JobRequest jobRequestW = new Builder(this.f67888a, z3).w();
        if (z2) {
            jobRequestW.f67889b = this.f67889b + 1;
        }
        try {
            jobRequestW.J();
            return jobRequestW;
        } catch (Exception e3) {
            f67887l.f(e3);
            return jobRequestW;
        }
    }

    public int J() throws PermissionException {
        if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(c().getApplicationContext(), "android.permission.SCHEDULE_EXACT_ALARM") == 0 || ((AlarmManager) c().getSystemService("alarm")).canScheduleExactAlarms()) {
            JobManager.v().w(this);
            return o();
        }
        throw new PermissionException("Missing permission android.permission.SCHEDULE_EXACT_ALARM for job " + t());
    }

    void K(boolean z2) {
        this.f67892e = z2;
    }

    void L(long j3) {
        this.f67890c = j3;
    }

    void M(boolean z2) {
        this.f67891d = z2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("started", Boolean.valueOf(this.f67891d));
        JobManager.v().u().t(this, contentValues);
    }

    ContentValues N() {
        ContentValues contentValues = new ContentValues();
        this.f67888a.x(contentValues);
        contentValues.put("numFailures", Integer.valueOf(this.f67889b));
        contentValues.put("scheduledAt", Long.valueOf(this.f67890c));
        contentValues.put("started", Boolean.valueOf(this.f67891d));
        contentValues.put("flexSupport", Boolean.valueOf(this.f67892e));
        contentValues.put("lastRun", Long.valueOf(this.f67893f));
        return contentValues;
    }

    void O(boolean z2, boolean z3) {
        ContentValues contentValues = new ContentValues();
        if (z2) {
            int i3 = this.f67889b + 1;
            this.f67889b = i3;
            contentValues.put("numFailures", Integer.valueOf(i3));
        }
        if (z3) {
            long jCurrentTimeMillis = JobConfig.a().currentTimeMillis();
            this.f67893f = jCurrentTimeMillis;
            contentValues.put("lastRun", Long.valueOf(jCurrentTimeMillis));
        }
        JobManager.v().u().t(this, contentValues);
    }

    public Builder b() {
        long j3 = this.f67890c;
        JobManager.v().d(o());
        Builder builder = new Builder(this.f67888a);
        this.f67891d = false;
        if (!y()) {
            long jCurrentTimeMillis = JobConfig.a().currentTimeMillis() - j3;
            builder.A(Math.max(1L, s() - jCurrentTimeMillis), Math.max(1L, i() - jCurrentTimeMillis));
        }
        return builder;
    }

    Builder d() {
        return new Builder(this.f67888a, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JobRequest.class != obj.getClass()) {
            return false;
        }
        return this.f67888a.equals(((JobRequest) obj).f67888a);
    }

    public long f() {
        return this.f67888a.f67904e;
    }

    long g(boolean z2) {
        long jF = 0;
        if (y()) {
            return 0L;
        }
        int i3 = AnonymousClass3.f67896a[h().ordinal()];
        if (i3 == 1) {
            jF = ((long) this.f67889b) * f();
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("not implemented");
            }
            if (this.f67889b != 0) {
                jF = (long) (f() * Math.pow(2.0d, this.f67889b - 1));
            }
        }
        if (z2 && !w()) {
            jF = (long) (jF * 1.2f);
        }
        return Math.min(jF, TimeUnit.HOURS.toMillis(5L));
    }

    public BackoffPolicy h() {
        return this.f67888a.f67905f;
    }

    public int hashCode() {
        return this.f67888a.hashCode();
    }

    public long i() {
        return this.f67888a.f67903d;
    }

    public PersistableBundleCompat j() {
        if (this.f67888a.f67915p == null && !TextUtils.isEmpty(this.f67888a.f67916q)) {
            Builder builder = this.f67888a;
            builder.f67915p = PersistableBundleCompat.b(builder.f67916q);
        }
        return this.f67888a.f67915p;
    }

    public int k() {
        return this.f67889b;
    }

    public long l() {
        return this.f67888a.f67907h;
    }

    public long m() {
        return this.f67888a.f67906g;
    }

    JobApi n() {
        return this.f67888a.f67913n ? JobApi.V_14 : JobApi.c(c());
    }

    public int o() {
        return this.f67888a.f67900a;
    }

    public long r() {
        return this.f67890c;
    }

    public long s() {
        return this.f67888a.f67902c;
    }

    public String t() {
        return this.f67888a.f67901b;
    }

    public String toString() {
        return "request{id=" + o() + ", tag=" + t() + ", transient=" + A() + '}';
    }

    public Bundle u() {
        return this.f67888a.f67919t;
    }

    public boolean v() {
        return F() || G() || E() || H() || C() != f67883h;
    }

    public boolean w() {
        return this.f67888a.f67913n;
    }

    boolean x() {
        return this.f67892e;
    }

    public boolean y() {
        return m() > 0;
    }

    boolean z() {
        return this.f67891d;
    }

    private JobRequest(Builder builder) {
        this.f67888a = builder;
    }
}
