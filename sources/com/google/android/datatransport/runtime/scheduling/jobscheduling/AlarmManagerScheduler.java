package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AlarmManagerScheduler implements WorkScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f69462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventStore f69463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlarmManager f69464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SchedulerConfig f69465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Clock f69466e;

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void a(TransportContext transportContext, int i3) {
        b(transportContext, i3, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void b(TransportContext transportContext, int i3, boolean z2) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.b());
        builder.appendQueryParameter("priority", String.valueOf(PriorityMapping.a(transportContext.d())));
        if (transportContext.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        Intent intent = new Intent(this.f69462a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i3);
        if (!z2 && c(intent)) {
            Logging.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jZ0 = this.f69463b.Z0(transportContext);
        long jG = this.f69465d.g(transportContext.d(), jZ0, i3);
        Logging.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(jG), Long.valueOf(jZ0), Integer.valueOf(i3));
        this.f69464c.set(3, this.f69466e.a() + jG, PendingIntent.getBroadcast(this.f69462a, 0, intent, 67108864));
    }

    boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f69462a, 0, intent, 603979776) != null;
    }
}
