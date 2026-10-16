package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ConstraintsCommandHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f54789f = Logger.i("ConstraintsCmdHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f54791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f54792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SystemAlarmDispatcher f54793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WorkConstraintsTracker f54794e;

    ConstraintsCommandHandler(Context context, Clock clock, int i3, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f54790a = context;
        this.f54791b = clock;
        this.f54792c = i3;
        this.f54793d = systemAlarmDispatcher;
        this.f54794e = new WorkConstraintsTracker(systemAlarmDispatcher.g().v());
    }

    void a() {
        List<WorkSpec> listH = this.f54793d.g().w().t().h();
        ConstraintProxy.a(this.f54790a, listH);
        ArrayList arrayList = new ArrayList(listH.size());
        long jCurrentTimeMillis = this.f54791b.currentTimeMillis();
        for (WorkSpec workSpec : listH) {
            if (jCurrentTimeMillis >= workSpec.c() && (!workSpec.k() || this.f54794e.a(workSpec))) {
                arrayList.add(workSpec);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            WorkSpec workSpec2 = (WorkSpec) obj;
            String str = workSpec2.f55013a;
            Intent intentB = CommandHandler.b(this.f54790a, WorkSpecKt.a(workSpec2));
            Logger.e().a(f54789f, "Creating a delay_met command for workSpec with id (" + str + ")");
            this.f54793d.f().a().execute(new SystemAlarmDispatcher.AddRunnable(this.f54793d, intentB, this.f54792c));
        }
    }
}
