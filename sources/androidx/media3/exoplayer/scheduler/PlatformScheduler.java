package androidx.media3.exoplayer.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformScheduler implements Scheduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f44525d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f44526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f44527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JobScheduler f44528c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int iD = new Requirements(extras.getInt("requirements")).d(this);
            if (iD == 0) {
                Util.k1(this, new Intent((String) Assertions.e(extras.getString("service_action"))).setPackage((String) Assertions.e(extras.getString("service_package"))));
                return false;
            }
            Log.i("PlatformScheduler", "Requirements not met: " + iD);
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        f44525d = (Util.f41609a >= 26 ? 16 : 0) | 15;
    }

    private static JobInfo c(int i3, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements requirementsA = requirements.a(f44525d);
        if (!requirementsA.equals(requirements)) {
            Log.i("PlatformScheduler", "Ignoring unsupported requirements: " + (requirementsA.e() ^ requirements.e()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i3, componentName);
        if (requirements.n()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.k()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.i());
        builder.setRequiresCharging(requirements.f());
        if (Util.f41609a >= 26 && requirements.m()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("service_action", str);
        persistableBundle.putString("service_package", str2);
        persistableBundle.putInt("requirements", requirements.e());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    @Override // androidx.media3.exoplayer.scheduler.Scheduler
    public boolean a(Requirements requirements, String str, String str2) {
        return this.f44528c.schedule(c(this.f44526a, this.f44527b, requirements, str2, str)) == 1;
    }

    @Override // androidx.media3.exoplayer.scheduler.Scheduler
    public Requirements b(Requirements requirements) {
        return requirements.a(f44525d);
    }

    @Override // androidx.media3.exoplayer.scheduler.Scheduler
    public boolean cancel() {
        this.f44528c.cancel(this.f44526a);
        return true;
    }
}
