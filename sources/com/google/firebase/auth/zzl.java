package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzl extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PhoneAuthOptions f88054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ com.google.firebase.auth.internal.zzj f88055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks f88056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88057d;

    zzl(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, com.google.firebase.auth.internal.zzj zzjVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.f88054a = phoneAuthOptions;
        this.f88055b = zzjVar;
        this.f88056c = onVerificationStateChangedCallbacks;
        Objects.requireNonNull(firebaseAuth);
        this.f88057d = firebaseAuth;
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.f88056c.onCodeAutoRetrievalTimeOut(str);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.f88056c.onCodeSent(str, forceResendingToken);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.f88056c.onVerificationCompleted(phoneAuthCredential);
    }

    @Override // com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
    public final void onVerificationFailed(FirebaseException firebaseException) {
        if (zzaen.zza(firebaseException)) {
            this.f88054a.b(true);
            Log.d("FirebaseAuth", "Re-triggering phone verification with Recaptcha flow forced for phone number " + this.f88054a.j());
            FirebaseAuth.D(this.f88054a);
            return;
        }
        if (TextUtils.isEmpty(this.f88055b.c())) {
            Log.d("FirebaseAuth", "Invoking original failure callbacks after phone verification failure for " + this.f88054a.j() + ", error - " + firebaseException.getMessage());
            this.f88056c.onVerificationFailed(firebaseException);
            return;
        }
        if (zzaen.zzb(firebaseException) && this.f88057d.H().d("PHONE_PROVIDER") && TextUtils.isEmpty(this.f88055b.b())) {
            this.f88054a.d(true);
            Log.d("FirebaseAuth", "Re-triggering phone verification with non-reCAPTCHA Enterprise flow for phone number " + this.f88054a.j());
            FirebaseAuth.D(this.f88054a);
            return;
        }
        Log.d("FirebaseAuth", "Invoking original failure callbacks after reCAPTCHA Enterprise + phone verification failure for " + this.f88054a.j() + ", error - " + firebaseException.getMessage());
        this.f88056c.onVerificationFailed(firebaseException);
    }
}
