package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbw implements Continuation<zzahs, Task<RecaptchaTasksClient>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f87937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbx f87938b;

    public zzbw(zzbx zzbxVar, String str) {
        this.f87937a = str;
        Objects.requireNonNull(zzbxVar);
        this.f87938b = zzbxVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzahs> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbu((String) Preconditions.m(((Exception) Preconditions.m(task.getException())).getMessage())));
        }
        zzahs result = task.getResult();
        String strZza = result.zza();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(strZza)) {
            return Tasks.forException(new zzbu("No Recaptcha Enterprise siteKey configured for tenant/project " + this.f87937a));
        }
        List<String> listZza = com.google.android.gms.internal.p002firebaseauthapi.zzt.zza('/').zza((CharSequence) strZza);
        String str = listZza.size() != 4 ? null : listZza.get(3);
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + strZza));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.f87937a);
        }
        zzbx zzbxVar = this.f87938b;
        Task<RecaptchaTasksClient> taskA = zzbxVar.f87944f.a((Application) zzbxVar.f87942d.l(), str);
        zzbx.c(this.f87938b, result, taskA, this.f87937a);
        return taskA;
    }
}
