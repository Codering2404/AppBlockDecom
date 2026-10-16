package com.singular.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92444a = SingularLog.f(Singular.class.getSimpleName());

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Utils.U(action)) {
            f92444a.a("Install.onReceive() action is empty");
            return;
        }
        if (!action.equals("com.android.vending.INSTALL_REFERRER")) {
            f92444a.b("Install.onReceive() unknown action = %s", action);
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        if (Utils.U(stringExtra)) {
            return;
        }
        Utils.j0(context, stringExtra);
        f92444a.b("saved referrer = %s", stringExtra);
    }
}
