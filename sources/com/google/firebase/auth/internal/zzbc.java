package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbc extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f87902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f87903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseAuth f87904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FirebaseUser f87905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzax f87906e;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.f87902a.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f87903b.setException(zzaen.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.d(context);
            return;
        }
        if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (zzce.d(intent)) {
                this.f87903b.setException(zzaen.zza(zzce.a(intent)));
                zzax.d(context);
                return;
            } else {
                if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                    this.f87903b.setException(zzaen.zza(zzao.a("WEB_CONTEXT_CANCELED")));
                    zzax.d(context);
                    return;
                }
                return;
            }
        }
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
            zzax zzaxVar = this.f87906e;
            TaskCompletionSource taskCompletionSource = this.f87903b;
            this.f87904c.k(zzax.a(intent)).addOnSuccessListener(new zzaz(zzaxVar, taskCompletionSource, context)).addOnFailureListener(new zzaw(zzaxVar, taskCompletionSource, context));
            return;
        }
        if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
            zzax zzaxVar2 = this.f87906e;
            TaskCompletionSource taskCompletionSource2 = this.f87903b;
            this.f87905d.z0(zzax.a(intent)).addOnSuccessListener(new zzbb(zzaxVar2, taskCompletionSource2, context)).addOnFailureListener(new zzay(zzaxVar2, taskCompletionSource2, context));
        } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
            zzax zzaxVar3 = this.f87906e;
            TaskCompletionSource taskCompletionSource3 = this.f87903b;
            this.f87905d.h1(zzax.a(intent)).addOnSuccessListener(new zzbd(zzaxVar3, taskCompletionSource3, context)).addOnFailureListener(new zzba(zzaxVar3, taskCompletionSource3, context));
        } else {
            this.f87903b.setException(zzaen.zza(zzao.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        }
    }
}
