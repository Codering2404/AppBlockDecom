package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.zzc;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FakeAppUpdateManager implements AppUpdateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzc f82895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f82896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f82897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f82898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f82899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f82900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f82901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f82902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f82903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f82904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f82905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f82906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f82907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Integer f82908n;

    private static int e() {
        return 67108864;
    }

    private final int f() {
        if (!this.f82900f) {
            return 1;
        }
        int i3 = this.f82898d;
        return (i3 == 0 || i3 == 4 || i3 == 5 || i3 == 6) ? 2 : 3;
    }

    private final boolean g(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        if (!appUpdateInfo.e(appUpdateOptions) && (!AppUpdateOptions.c(appUpdateOptions.b()).equals(appUpdateOptions) || !appUpdateInfo.d(appUpdateOptions.b()))) {
            return false;
        }
        if (appUpdateOptions.b() == 1) {
            this.f82907m = true;
            this.f82908n = 1;
        } else {
            this.f82906l = true;
            this.f82908n = 0;
        }
        return true;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task a() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent broadcast;
        PendingIntent pendingIntent3;
        PendingIntent broadcast2;
        PendingIntent broadcast3;
        if (this.f82899e != 0) {
            return Tasks.forException(new InstallException(this.f82899e));
        }
        if (f() == 2) {
            if (this.f82897c.contains(0)) {
                broadcast2 = PendingIntent.getBroadcast(this.f82896b, 0, new Intent(), e());
                broadcast3 = PendingIntent.getBroadcast(this.f82896b, 0, new Intent(), e());
            } else {
                broadcast2 = null;
                broadcast3 = null;
            }
            if (this.f82897c.contains(1)) {
                PendingIntent broadcast4 = PendingIntent.getBroadcast(this.f82896b, 0, new Intent(), e());
                pendingIntent2 = broadcast2;
                broadcast = PendingIntent.getBroadcast(this.f82896b, 0, new Intent(), e());
                pendingIntent = broadcast4;
            } else {
                pendingIntent2 = broadcast2;
                pendingIntent = null;
                broadcast = null;
            }
            pendingIntent3 = broadcast3;
        } else {
            pendingIntent = null;
            pendingIntent2 = null;
            broadcast = null;
            pendingIntent3 = null;
        }
        return Tasks.forResult(AppUpdateInfo.h(this.f82896b.getPackageName(), this.f82901g, f(), this.f82898d, this.f82902h, this.f82903i, this.f82904j, this.f82905k, 0L, 0L, pendingIntent, pendingIntent2, broadcast, pendingIntent3, new HashMap()));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void b(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f82895a.b(installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean c(AppUpdateInfo appUpdateInfo, int i3, Activity activity, int i4) {
        return g(appUpdateInfo, AppUpdateOptions.d(i3).a());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void d(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f82895a.c(installStateUpdatedListener);
    }
}
