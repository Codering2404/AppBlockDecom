package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.install.InstallState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzc extends com.google.android.play.core.appupdate.internal.zzl {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.play.core.appupdate.internal.zzl
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f82863a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f82863a.a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f82863a.a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        InstallState installStateF = InstallState.f(intent, this.f82863a);
        this.f82863a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", installStateF);
        d(installStateF);
    }
}
