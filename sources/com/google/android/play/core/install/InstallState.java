package com.google.android.play.core.install;

import android.content.Intent;
import com.google.android.play.core.appupdate.internal.zzm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class InstallState {
    public static InstallState f(Intent intent, zzm zzmVar) {
        zzmVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        zzmVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        zzmVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        return new zza(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
    }

    public abstract long a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract long e();
}
