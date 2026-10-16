package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadz extends zzaff<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzaaq zzv;

    public zzadz(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j3, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4) {
        super(8);
        Preconditions.m(phoneMultiFactorInfo);
        Preconditions.g(str);
        this.zzv = new zzaaq(phoneMultiFactorInfo, str, str2, j3, z2, z3, str3, str4, str5, z4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafq
    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeoVar) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeoVar.zza(this.zzv, this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final void zzb() {
    }
}
