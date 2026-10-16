package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemAlarmScheduler implements Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f54828b = Logger.i("SystemAlarmScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54829a;

    private void c(WorkSpec workSpec) {
        Logger.e().a(f54828b, "Scheduling work with workSpecId " + workSpec.f55013a);
        this.f54829a.startService(CommandHandler.e(this.f54829a, WorkSpecKt.a(workSpec)));
    }

    @Override // androidx.work.impl.Scheduler
    public void a(String str) {
        this.f54829a.startService(CommandHandler.g(this.f54829a, str));
    }

    @Override // androidx.work.impl.Scheduler
    public void b(WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            c(workSpec);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean d() {
        return true;
    }
}
