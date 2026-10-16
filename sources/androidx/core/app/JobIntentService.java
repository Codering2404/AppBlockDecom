package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Object f33601i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final HashMap f33602j = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CompatJobEngine f33603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    WorkEnqueuer f33604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CommandProcessor f33605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f33606d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f33607f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f33608g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ArrayList f33609h = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem genericWorkItemA = JobIntentService.this.a();
                if (genericWorkItemA == null) {
                    return null;
                }
                JobIntentService.this.h(genericWorkItemA.getIntent());
                genericWorkItemA.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface CompatJobEngine {
        IBinder a();

        GenericWorkItem b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Context f33611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f33612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f33613f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f33614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f33615h;

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f33626a);
            if (this.f33611d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f33614g) {
                            this.f33614g = true;
                            if (!this.f33615h) {
                                this.f33612e.acquire(60000L);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void c() {
            synchronized (this) {
                try {
                    if (this.f33615h) {
                        if (this.f33614g) {
                            this.f33612e.acquire(60000L);
                        }
                        this.f33615h = false;
                        this.f33613f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void d() {
            synchronized (this) {
                try {
                    if (!this.f33615h) {
                        this.f33615h = true;
                        this.f33613f.acquire(600000L);
                        this.f33612e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void e() {
            synchronized (this) {
                this.f33614g = false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class CompatWorkItem implements GenericWorkItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f33616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f33617b;

        CompatWorkItem(Intent intent, int i3) {
            this.f33616a = intent;
            this.f33617b = i3;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void b() {
            JobIntentService.this.stopSelf(this.f33617b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f33616a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface GenericWorkItem {
        void b();

        Intent getIntent();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JobIntentService f33619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f33620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JobParameters f33621c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class WrapperWorkItem implements GenericWorkItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final JobWorkItem f33622a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f33622a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void b() {
                synchronized (JobServiceEngineImpl.this.f33620b) {
                    try {
                        JobParameters jobParameters = JobServiceEngineImpl.this.f33621c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f33622a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.f33622a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f33620b = new Object();
            this.f33619a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem b() {
            synchronized (this.f33620b) {
                try {
                    JobParameters jobParameters = this.f33621c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                    if (jobWorkItemDequeueWork == null) {
                        return null;
                    }
                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f33619a.getClassLoader());
                    return new WrapperWorkItem(jobWorkItemDequeueWork);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f33621c = jobParameters;
            this.f33619a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f33619a.b();
            synchronized (this.f33620b) {
                this.f33621c = null;
            }
            return zB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JobInfo f33624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final JobScheduler f33625e;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i3) {
            super(componentName);
            b(i3);
            this.f33624d = new JobInfo.Builder(i3, this.f33626a).setOverrideDeadline(0L).build();
            this.f33625e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            this.f33625e.enqueue(this.f33624d, new JobWorkItem(intent));
        }
    }

    public static void c(Context context, ComponentName componentName, int i3, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f33601i) {
            WorkEnqueuer workEnqueuerF = f(context, componentName, true, i3);
            workEnqueuerF.b(i3);
            workEnqueuerF.a(intent);
        }
    }

    public static void d(Context context, Class cls, int i3, Intent intent) {
        c(context, new ComponentName(context, (Class<?>) cls), i3, intent);
    }

    static WorkEnqueuer f(Context context, ComponentName componentName, boolean z2, int i3) {
        HashMap map = f33602j;
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) map.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (!z2) {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        JobWorkEnqueuer jobWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i3);
        map.put(componentName, jobWorkEnqueuer);
        return jobWorkEnqueuer;
    }

    GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.f33603a;
        if (compatJobEngine != null) {
            return compatJobEngine.b();
        }
        synchronized (this.f33609h) {
            try {
                if (this.f33609h.size() <= 0) {
                    return null;
                }
                return (GenericWorkItem) this.f33609h.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b() {
        CommandProcessor commandProcessor = this.f33605c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.f33606d);
        }
        this.f33607f = true;
        return i();
    }

    void e(boolean z2) {
        if (this.f33605c == null) {
            this.f33605c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f33604b;
            if (workEnqueuer != null && z2) {
                workEnqueuer.d();
            }
            this.f33605c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean g() {
        return this.f33607f;
    }

    protected abstract void h(Intent intent);

    public boolean i() {
        return true;
    }

    void j() {
        ArrayList arrayList = this.f33609h;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f33605c = null;
                    ArrayList arrayList2 = this.f33609h;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.f33608g) {
                        this.f33604b.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f33603a;
        if (compatJobEngine != null) {
            return compatJobEngine.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f33603a = new JobServiceEngineImpl(this);
        this.f33604b = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f33609h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f33608g = true;
                this.f33604b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (this.f33609h == null) {
            return 2;
        }
        this.f33604b.e();
        synchronized (this.f33609h) {
            ArrayList arrayList = this.f33609h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i4));
            e(true);
        }
        return 3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class WorkEnqueuer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f33626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f33627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33628c;

        WorkEnqueuer(ComponentName componentName) {
            this.f33626a = componentName;
        }

        abstract void a(Intent intent);

        void b(int i3) {
            if (!this.f33627b) {
                this.f33627b = true;
                this.f33628c = i3;
            } else {
                if (this.f33628c == i3) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i3 + " is different than previous " + this.f33628c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }
}
