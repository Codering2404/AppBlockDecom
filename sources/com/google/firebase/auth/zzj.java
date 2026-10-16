package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzj implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PhoneAuthOptions f88048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f88049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88050c;

    zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.f88048a = phoneAuthOptions;
        this.f88049b = str;
        Objects.requireNonNull(firebaseAuth);
        this.f88050c = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String strD;
        String strB;
        String strC;
        if (task.isSuccessful()) {
            strD = task.getResult().d();
            strB = task.getResult().b();
            strC = task.getResult().c();
        } else {
            Exception exception = task.getException();
            String str = "Error while validating application identity: ";
            if (exception != null) {
                str = "Error while validating application identity: " + exception.getMessage();
            }
            Log.e("FirebaseAuth", str);
            if (exception != null && com.google.firebase.auth.internal.zzb.i(exception)) {
                FirebaseAuth.y((FirebaseException) exception, this.f88048a, this.f88049b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            strC = null;
            strD = null;
            strB = null;
        }
        long jLongValue = this.f88048a.i().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksX = this.f88050c.x(this.f88048a.j(), this.f88048a.g());
        if (TextUtils.isEmpty(strD)) {
            onVerificationStateChangedCallbacksX = this.f88050c.w(this.f88048a, onVerificationStateChangedCallbacksX, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = onVerificationStateChangedCallbacksX;
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) Preconditions.m(this.f88048a.e());
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(strC) && this.f88050c.H() != null && this.f88050c.H().d("PHONE_PROVIDER")) {
            strC = "NO_RECAPTCHA";
        }
        String str2 = strC;
        if (zzamVar.zzd()) {
            this.f88050c.f87745e.zza(zzamVar, (String) Preconditions.m(this.f88048a.j()), this.f88050c.f87749i, jLongValue, this.f88048a.f() != null, this.f88048a.m(), strD, strB, str2, this.f88050c.U(), onVerificationStateChangedCallbacks, this.f88048a.k(), this.f88048a.a());
        } else {
            this.f88050c.f87745e.zza(zzamVar, (PhoneMultiFactorInfo) Preconditions.m(this.f88048a.h()), this.f88050c.f87749i, jLongValue, this.f88048a.f() != null, this.f88048a.m(), strD, strB, str2, this.f88050c.U(), onVerificationStateChangedCallbacks, this.f88048a.k(), this.f88048a.a());
        }
    }
}
