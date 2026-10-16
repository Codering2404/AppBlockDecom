package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzr extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzs f70373a;

    /* synthetic */ zzr(zzs zzsVar, byte[] bArr) {
        Objects.requireNonNull(zzsVar);
        this.f70373a = zzsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), "android.intent.action.USER_PRESENT")) {
            this.f70373a.X(true);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f70373a.X(false);
        }
    }
}
