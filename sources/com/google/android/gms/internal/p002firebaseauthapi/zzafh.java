package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.internal.zzau;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzafh implements zzaem {
    final /* synthetic */ zzaff zza;

    zzafh(zzaff zzaffVar) {
        Objects.requireNonNull(zzaffVar);
        this.zza = zzaffVar;
    }

    private final void zza(zzafm zzafmVar) {
        this.zza.zzi.execute(new zzafn(this, zzafmVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb(String str) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 8, "Unexpected response type " + i3);
        zza(new zzafj(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc(String str) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 7, "Unexpected response type " + i3);
        zzaff.zza(this.zza);
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzaff.zza(this.zza, status);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzn = authCredential;
        zzaffVar.zzo = str;
        zzaffVar.zzp = str2;
        zzau zzauVar = zzaffVar.zzf;
        if (zzauVar != null) {
            zzauVar.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb() throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 6, "Unexpected response type " + i3);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc() throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 9, "Unexpected response type " + i3);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(String str) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 8, "Unexpected response type " + i3);
        this.zza.zzu = true;
        zza(new zzafl(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzagv zzagvVar) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 3, "Unexpected response type " + i3);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzl = zzagvVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza() throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 5, "Unexpected response type " + i3);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaap zzaapVar) {
        zza(zzaapVar.zza(), zzaapVar.zzb(), zzaapVar.zzc(), zzaapVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaas zzaasVar) {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzq = zzaasVar;
        zzaffVar.zza(zzao.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 2, "Unexpected response type " + i3);
        zza(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status) throws RemoteException {
        String strG0 = status.g0();
        if (strG0 != null) {
            if (strG0.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (strG0.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (strG0.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (strG0.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (strG0.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (strG0.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (strG0.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (strG0.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (strG0.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (strG0.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzaff zzaffVar = this.zza;
        if (zzaffVar.zza == 8) {
            zzaffVar.zzu = true;
            zza(new zzafk(this, status));
        } else {
            zzaff.zza(zzaffVar, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahr zzahrVar) throws RemoteException {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzs = zzahrVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahs zzahsVar) throws RemoteException {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzr = zzahsVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar, zzahk zzahkVar) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 2, "Unexpected response type: " + i3);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzj = zzahvVar;
        zzaffVar.zzk = zzahkVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaif zzaifVar) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 4, "Unexpected response type " + i3);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzm = zzaifVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaig zzaigVar) throws RemoteException {
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzair zzairVar) throws RemoteException {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzt = zzairVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 1, "Unexpected response type: " + i3);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzj = zzahvVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i3 = this.zza.zza;
        Preconditions.r(i3 == 8, "Unexpected response type " + i3);
        this.zza.zzu = true;
        zza(new zzafi(this, phoneAuthCredential));
    }
}
