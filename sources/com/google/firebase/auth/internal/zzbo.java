package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbo<T> {
    public static /* synthetic */ Task a(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) Preconditions.m(task.getException());
        if (zzaen.zzd(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.H() == null) {
                firebaseAuth.F(new zzbx(firebaseAuth.b(), firebaseAuth));
            }
            return c(firebaseAuth.H(), recaptchaAction, str, continuation);
        }
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + String.valueOf(recaptchaAction) + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }

    public static Task c(zzbx zzbxVar, RecaptchaAction recaptchaAction, String str, Continuation continuation) {
        Task taskB = zzbxVar.b(str, Boolean.FALSE, recaptchaAction);
        return taskB.continueWithTask(continuation).continueWithTask(new zzbt(str, zzbxVar, recaptchaAction, continuation));
    }

    public final Task b(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: com.google.firebase.auth.internal.zzbq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzbo zzboVar = this.f87928a;
                if (task.isSuccessful()) {
                    return zzboVar.d((String) task.getResult());
                }
                Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) Preconditions.m(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
                return zzboVar.d("NO_RECAPTCHA");
            }
        };
        zzbx zzbxVarH = firebaseAuth.H();
        return (zzbxVarH == null || !zzbxVarH.e(str2)) ? d(null).continueWithTask(new Continuation() { // from class: com.google.firebase.auth.internal.zzbr
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzbo.a(recaptchaAction, firebaseAuth, str, continuation, task);
            }
        }) : c(zzbxVarH, recaptchaAction, str, continuation);
    }

    public abstract Task d(String str);
}
