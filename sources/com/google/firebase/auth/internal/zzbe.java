package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbe extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f87909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f87910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzax f87911c;

    public zzbe(zzax zzaxVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzaxVar);
        this.f87911c = zzaxVar;
        this.f87909a = new WeakReference(activity);
        this.f87910b = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.f87909a.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f87910b.setException(zzaen.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.d(context);
            return;
        }
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                zzax.e(this.f87911c, intent, this.f87910b, context);
                return;
            }
            this.f87910b.setException(zzaen.zza(zzao.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
            return;
        }
        if (zzce.d(intent)) {
            this.f87910b.setException(zzaen.zza(zzce.a(intent)));
            zzax.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.f87910b.setException(zzaen.zza(zzao.a("WEB_CONTEXT_CANCELED")));
            zzax.d(context);
        }
    }
}
