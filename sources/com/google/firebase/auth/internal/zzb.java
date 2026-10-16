package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzafz;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f87895b = "zzb";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzb f87896c = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f87897a;

    public static zzb b() {
        return f87896c;
    }

    private final void c(FirebaseAuth firebaseAuth, zzcg zzcgVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbl.d(firebaseAuth.b().l(), firebaseAuth);
        Preconditions.m(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (zzax.b().h(activity, taskCompletionSource2)) {
            new zzafz(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzaen.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new zzg(this, taskCompletionSource)).addOnFailureListener(new zzh(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z2, boolean z3, final zzcg zzcgVar, final TaskCompletionSource taskCompletionSource) {
        if (!z2 || z3) {
            c(firebaseAuth, zzcgVar, activity, taskCompletionSource);
        } else {
            (!TextUtils.isEmpty(this.f87897a) ? Tasks.forResult(new zzahr(this.f87897a)) : firebaseAuth.m()).continueWithTask(firebaseAuth.S(), new zze(this, str, IntegrityManagerFactory.create(firebaseAuth.b().l()))).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzd
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzb.f(this.f87976a, taskCompletionSource, firebaseAuth, zzcgVar, activity, task);
                }
            });
        }
    }

    public static /* synthetic */ void e(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z2, boolean z3, zzcg zzcgVar, Task task) {
        if (!task.isSuccessful()) {
            Log.e(f87895b, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.H() == null || !firebaseAuth.H().e("PHONE_PROVIDER")) {
            zzbVar.d(firebaseAuth, str, activity, z2, z3, zzcgVar, taskCompletionSource);
        } else {
            firebaseAuth.H().b(firebaseAuth.g(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new zzf(zzbVar, taskCompletionSource)).addOnFailureListener(new zzc(zzbVar, firebaseAuth, str, activity, z2, z3, zzcgVar, taskCompletionSource));
        }
    }

    public static /* synthetic */ void f(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzcg zzcgVar, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zzm().a(((IntegrityTokenResponse) task.getResult()).token()).b());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(f87895b, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        zzbVar.c(firebaseAuth, zzcgVar, activity, taskCompletionSource);
    }

    public static boolean i(Exception exc) {
        if (exc instanceof FirebaseAuthMissingActivityForRecaptchaException) {
            return true;
        }
        return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).a().endsWith("UNAUTHORIZED_DOMAIN");
    }

    public final Task a(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z2, boolean z3, boolean z4, final RecaptchaAction recaptchaAction) {
        zzac zzacVar = (zzac) firebaseAuth.e();
        final zzcg zzcgVarD = zzcg.d();
        if (zzagl.zza(firebaseAuth.b()) || zzacVar.e()) {
            return Tasks.forResult(new zzm().b());
        }
        String str2 = f87895b;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z3 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzacVar.c());
        boolean z5 = z3 || zzacVar.c();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task taskC = zzcgVarD.c();
        if (taskC != null) {
            if (taskC.isSuccessful()) {
                return Tasks.forResult(new zzm().d((String) taskC.getResult()).b());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskC.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z5 || z4) {
            d(firebaseAuth, str, activity, z2, z5, zzcgVarD, taskCompletionSource);
        } else {
            Task taskI = firebaseAuth.i();
            final boolean z6 = false;
            OnCompleteListener onCompleteListener = new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zza
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzb.e(this.f87823a, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z2, z6, zzcgVarD, task);
                }
            };
            taskCompletionSource = taskCompletionSource;
            taskI.addOnCompleteListener(onCompleteListener);
        }
        return taskCompletionSource.getTask();
    }
}
