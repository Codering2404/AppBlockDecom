package com.evernote.android.job.v14;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.util.JobCat;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PlatformAlarmServiceExact extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final JobCat f67987d = new JobCat("PlatformAlarmServiceExact");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f67988a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Set f67989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f67990c;

    public static Intent c(Context context, int i3, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) PlatformAlarmServiceExact.class);
        intent.putExtra("EXTRA_JOB_ID", i3);
        if (bundle != null) {
            intent.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        synchronized (this.f67988a) {
            try {
                Set set = this.f67989b;
                if (set != null) {
                    set.remove(Integer.valueOf(i3));
                    if (set.isEmpty()) {
                        stopSelfResult(this.f67990c);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f67989b = new HashSet();
    }

    @Override // android.app.Service
    public void onDestroy() {
        synchronized (this.f67988a) {
            this.f67989b = null;
            this.f67990c = 0;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i3, final int i4) {
        synchronized (this.f67988a) {
            this.f67989b.add(Integer.valueOf(i4));
            this.f67990c = i4;
        }
        JobConfig.b().execute(new Runnable() { // from class: com.evernote.android.job.v14.PlatformAlarmServiceExact.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PlatformAlarmService.k(intent, PlatformAlarmServiceExact.this, PlatformAlarmServiceExact.f67987d);
                } finally {
                    JobProxy.Common.f(intent);
                    PlatformAlarmServiceExact.this.d(i4);
                }
            }
        });
        return 2;
    }
}
