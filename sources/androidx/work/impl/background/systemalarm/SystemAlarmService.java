package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f54830d = Logger.i("SystemAlarmService");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SystemAlarmDispatcher f54831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f54832c;

    private void e() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f54831b = systemAlarmDispatcher;
        systemAlarmDispatcher.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.CommandsCompletedListener
    public void b() {
        this.f54832c = true;
        Logger.e().a(f54830d, "All commands completed in dispatcher");
        WakeLocks.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f54832c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f54832c = true;
        this.f54831b.k();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        super.onStartCommand(intent, i3, i4);
        if (this.f54832c) {
            Logger.e().f(f54830d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            this.f54831b.k();
            e();
            this.f54832c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f54831b.a(intent, i4);
        return 3;
    }
}
