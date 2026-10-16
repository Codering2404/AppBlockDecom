package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzg implements AppUpdateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzr f82911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzc f82912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f82913c;

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task a() {
        return this.f82911a.d(this.f82913c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void b(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f82912b.b(installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean c(AppUpdateInfo appUpdateInfo, int i3, Activity activity, int i4) {
        AppUpdateOptions appUpdateOptionsC = AppUpdateOptions.c(i3);
        if (activity == null) {
            return false;
        }
        return e(appUpdateInfo, new zzf(this, activity), appUpdateOptionsC, i4);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void d(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f82912b.c(installStateUpdatedListener);
    }

    public final boolean e(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i3) {
        if (appUpdateInfo == null || intentSenderForResultStarter == null || appUpdateOptions == null || !appUpdateInfo.e(appUpdateOptions) || appUpdateInfo.j()) {
            return false;
        }
        appUpdateInfo.i();
        intentSenderForResultStarter.a(appUpdateInfo.g(appUpdateOptions).getIntentSender(), i3, null, 0, 0, 0, null);
        return true;
    }
}
