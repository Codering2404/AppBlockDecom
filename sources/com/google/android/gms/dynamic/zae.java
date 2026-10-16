package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zae implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f72391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f72392b;

    zae(Context context, Intent intent) {
        this.f72391a = context;
        this.f72392b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f72391a.startActivity(this.f72392b);
        } catch (ActivityNotFoundException e3) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e3);
        }
    }
}
