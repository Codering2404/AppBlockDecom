package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbt implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f87933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbx f87934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecaptchaAction f87935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Continuation f87936d;

    public zzbt(String str, zzbx zzbxVar, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.f87933a = str;
        this.f87934b = zzbxVar;
        this.f87935c = recaptchaAction;
        this.f87936d = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzaen.zzc((Exception) Preconditions.m(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + this.f87933a);
        }
        return this.f87934b.b(this.f87933a, Boolean.TRUE, this.f87935c).continueWithTask(this.f87936d);
    }
}
