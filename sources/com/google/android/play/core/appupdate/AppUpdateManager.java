package com.google.android.play.core.appupdate;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.install.InstallStateUpdatedListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface AppUpdateManager {
    Task a();

    void b(InstallStateUpdatedListener installStateUpdatedListener);

    boolean c(AppUpdateInfo appUpdateInfo, int i3, Activity activity, int i4);

    void d(InstallStateUpdatedListener installStateUpdatedListener);
}
