package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Clock;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class SystemJobInfoConverter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f54835c = Logger.i("SystemJobInfoConverter");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComponentName f54836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f54837b;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f54838a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f54838a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54838a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54838a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f54838a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f54838a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    SystemJobInfoConverter(Context context, Clock clock) {
        this.f54837b = clock;
        this.f54836a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(Constraints.ContentUriTrigger contentUriTrigger) {
        return new JobInfo.TriggerContentUri(contentUriTrigger.a(), contentUriTrigger.b() ? 1 : 0);
    }

    static int c(NetworkType networkType) {
        int i3 = AnonymousClass1.f54838a[networkType.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i3 == 5) {
            return 4;
        }
        Logger.e().a(f54835c, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    JobInfo a(WorkSpec workSpec, int i3) {
        Constraints constraints = workSpec.f55022j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.f55013a);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.f());
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.m());
        JobInfo.Builder extras = new JobInfo.Builder(i3, this.f54836a).setRequiresCharging(constraints.g()).setRequiresDeviceIdle(constraints.h()).setExtras(persistableBundle);
        d(extras, constraints.d());
        if (!constraints.h()) {
            extras.setBackoffCriteria(workSpec.f55025m, workSpec.f55024l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(workSpec.c() - this.f54837b.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!workSpec.f55029q) {
            extras.setImportantWhileForeground(true);
        }
        if (constraints.e()) {
            Iterator it = constraints.c().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b((Constraints.ContentUriTrigger) it.next()));
            }
            extras.setTriggerContentUpdateDelay(constraints.b());
            extras.setTriggerContentMaxDelay(constraints.a());
        }
        extras.setPersisted(false);
        int i4 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(constraints.f());
        extras.setRequiresStorageNotLow(constraints.i());
        boolean z2 = workSpec.f55023k > 0;
        boolean z3 = jMax > 0;
        if (i4 >= 31 && workSpec.f55029q && !z2 && !z3) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
