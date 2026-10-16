package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzax {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static zzax f87888c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f87889a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f87890b;

    public static AuthCredential a(Intent intent) {
        Preconditions.m(intent);
        return com.google.firebase.auth.zze.h1(((zzajb) SafeParcelableSerializer.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzajb.CREATOR)).zzc(true));
    }

    public static zzax b() {
        if (f87888c == null) {
            f87888c = new zzax();
        }
        return f87888c;
    }

    private final void c(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f87890b = broadcastReceiver;
        LocalBroadcastManager.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public static void d(Context context) {
        zzax zzaxVar = f87888c;
        zzaxVar.f87889a = false;
        if (zzaxVar.f87890b != null) {
            LocalBroadcastManager.b(context).e(f87888c.f87890b);
        }
        f87888c.f87890b = null;
    }

    public static /* synthetic */ void e(zzax zzaxVar, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        d(context);
    }

    public final boolean h(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (this.f87889a) {
            return false;
        }
        c(activity, new zzbe(this, activity, taskCompletionSource));
        this.f87889a = true;
        return true;
    }
}
