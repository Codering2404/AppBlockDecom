package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzael implements zzaem {
    private final zzaem zza;
    private final Logger zzb;

    public zzael(zzael zzaelVar) {
        this(zzaelVar.zza, zzaelVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending auto retrieval timeout response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending send verification code response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending set account info response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzagv zzagvVar) {
        try {
            this.zza.zza(zzagvVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending create auth uri response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending email verification response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when setting FirebaseUI Version", e3, new Object[0]);
        }
    }

    public zzael(zzaem zzaemVar, Logger logger) {
        this.zza = (zzaem) Preconditions.m(zzaemVar);
        this.zzb = (Logger) Preconditions.m(logger);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending delete account response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaap zzaapVar) {
        try {
            this.zza.zza(zzaapVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending failure result with credential", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaas zzaasVar) {
        try {
            this.zza.zza(zzaasVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending failure result for mfa", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(status, phoneAuthCredential);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending failure result.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending failure result.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahr zzahrVar) {
        try {
            this.zza.zza(zzahrVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending Play Integrity Producer project response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahs zzahsVar) {
        try {
            this.zza.zza(zzahsVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending get recaptcha config response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar, zzahk zzahkVar) {
        try {
            this.zza.zza(zzahvVar, zzahkVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending get token and account info user response", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaif zzaifVar) {
        try {
            this.zza.zza(zzaifVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending password reset response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaig zzaigVar) {
        try {
            this.zza.zza(zzaigVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending revoke token response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzair zzairVar) {
        try {
            this.zza.zza(zzairVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending start mfa enrollment response.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar) {
        try {
            this.zza.zza(zzahvVar);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending token result.", e3, new Object[0]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(phoneAuthCredential);
        } catch (RemoteException e3) {
            this.zzb.b("RemoteException when sending verification completed response.", e3, new Object[0]);
        }
    }
}
