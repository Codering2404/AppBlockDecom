package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeo {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaar zzb;
    private final zzagc zzc;

    zzaeo(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.m(firebaseApp);
        Context contextL = firebaseApp.l();
        Preconditions.m(contextL);
        this.zzb = new zzaar(new zzafb(firebaseApp, zzafc.zza()));
        this.zzc = new zzagc(contextL, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(zzaemVar);
        this.zzb.zzb(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzc(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(zzaemVar);
        this.zzb.zzc(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzd(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zzd(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zze(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        this.zzb.zze(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzf(String str, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(zzaemVar);
        this.zzb.zzf(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zze(String str, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zzf(str, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaic zzaicVar, zzaem zzaemVar) {
        Preconditions.m(zzaicVar);
        Preconditions.g(zzaicVar.zzb());
        Preconditions.m(zzaemVar);
        this.zzb.zza(zzaicVar, new zzael(zzaemVar, zza));
    }

    public final void zzd(String str, zzaem zzaemVar) {
        Preconditions.m(zzaemVar);
        this.zzb.zze(str, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zzb(str, new zzael(zzaemVar, zza));
    }

    public final void zzc(String str, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zzc(str, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, str2, str3, str4, new zzael(zzaemVar, zza));
    }

    public final void zzb(zzahm zzahmVar, zzaem zzaemVar) {
        Preconditions.m(zzahmVar);
        Preconditions.g(zzahmVar.zzc());
        Preconditions.m(zzaemVar);
        this.zzb.zzb(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zzc(zzahm zzahmVar, zzaem zzaemVar) {
        Preconditions.m(zzahmVar);
        this.zzb.zzc(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.m(zzaemVar);
        Preconditions.m(zzaemVar);
        this.zzb.zzb(str, str2, str3, str4, new zzael(zzaemVar, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaem zzaemVar) {
        zzagz zzagzVarZza;
        Preconditions.m(multiFactorAssertion);
        Preconditions.h(str, "cachedTokenState should not be empty.");
        Preconditions.m(zzaemVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialA = ((PhoneMultiFactorAssertion) multiFactorAssertion).a();
            zzagzVarZza = zzahd.zza(str, (String) Preconditions.m(phoneAuthCredentialA.zzc()), (String) Preconditions.m(phoneAuthCredentialA.g0()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzagzVarZza = zzahf.zza(str, Preconditions.g(str2), Preconditions.g(((TotpSecret) Preconditions.m(totpMultiFactorAssertion.a())).a()), Preconditions.g(totpMultiFactorAssertion.c()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagzVarZza, str, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(multiFactorAssertion);
        Preconditions.m(zzaemVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialA = ((PhoneMultiFactorAssertion) multiFactorAssertion).a();
            this.zzb.zza(zzahc.zza(str, (String) Preconditions.m(phoneAuthCredentialA.zzc()), (String) Preconditions.m(phoneAuthCredentialA.g0()), str2), new zzael(zzaemVar, zza));
        } else {
            if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
                TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
                this.zzb.zza(zzahe.zza(str, Preconditions.g(totpMultiFactorAssertion.c()), str2, Preconditions.g(totpMultiFactorAssertion.b())), new zzael(zzaemVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzaho zzahoVar, zzaem zzaemVar) {
        Preconditions.m(zzahoVar);
        this.zzb.zza(zzahoVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaht zzahtVar, zzaem zzaemVar) {
        Preconditions.m(zzahtVar);
        this.zzb.zza(zzahtVar, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.g(str3);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, zzajb zzajbVar, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(zzajbVar);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, zzajbVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzahz zzahzVar, zzaem zzaemVar) {
        Preconditions.m(zzaemVar);
        Preconditions.m(zzahzVar);
        this.zzb.zza(Preconditions.g(zzahzVar.zzb()), zzahzVar.zza(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzaie zzaieVar, zzaem zzaemVar) {
        Preconditions.m(zzaieVar);
        this.zzb.zza(zzaieVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzahm zzahmVar, zzaem zzaemVar) {
        Preconditions.m(zzahmVar);
        Preconditions.g(zzahmVar.zzd());
        Preconditions.m(zzaemVar);
        this.zzb.zza(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaij zzaijVar, zzaem zzaemVar) {
        Preconditions.m(zzaemVar);
        Preconditions.m(zzaijVar);
        String strZzd = zzaijVar.zzd();
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(strZzd)) {
            if (zzaijVar.zze()) {
                this.zzc.zzb(strZzd);
            } else {
                this.zzc.zzb(zzaelVar, strZzd);
                return;
            }
        }
        long jZzb = zzaijVar.zzb();
        boolean zZzf = zzaijVar.zzf();
        if (zza(jZzb, zZzf)) {
            zzaijVar.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(strZzd, zzaelVar, jZzb, zZzf);
        this.zzb.zza(zzaijVar, this.zzc.zza(zzaelVar, strZzd));
    }

    public final void zza(zzain zzainVar, zzaem zzaemVar) {
        Preconditions.m(zzainVar);
        Preconditions.m(zzaemVar);
        this.zzb.zzd(zzainVar.zza(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzajb zzajbVar, zzaem zzaemVar) {
        Preconditions.m(zzajbVar);
        Preconditions.m(zzaemVar);
        this.zzb.zza(zzajbVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzajc zzajcVar, zzaem zzaemVar) {
        Preconditions.m(zzajcVar);
        Preconditions.m(zzaemVar);
        this.zzb.zza(zzajcVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzagx zzagxVar, zzaem zzaemVar) {
        Preconditions.m(zzaemVar);
        Preconditions.m(zzagxVar.zzb());
        this.zzb.zza(zzagxVar.zzb(), zzagxVar.zzc(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzaan zzaanVar, zzaem zzaemVar) {
        Preconditions.m(zzaemVar);
        Preconditions.m(zzaanVar);
        this.zzb.zza(zzafw.zza((PhoneAuthCredential) Preconditions.m(zzaanVar.zza())), new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j3, boolean z2, boolean z3, String str4, String str5, String str6, boolean z4, zzaem zzaemVar) {
        Preconditions.h(str, "idToken should not be empty.");
        Preconditions.m(zzaemVar);
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z2) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaelVar, str2);
                return;
            }
        }
        zzais zzaisVarZza = zzais.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j3, z4)) {
            zzaisVarZza.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaelVar, j3, z4);
        this.zzb.zza(zzaisVarZza, this.zzc.zza(zzaelVar, str2));
    }

    public final void zza(zzaaq zzaaqVar, zzaem zzaemVar) {
        Preconditions.m(zzaaqVar);
        Preconditions.m(zzaemVar);
        String strW0 = zzaaqVar.zzb().w0();
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(strW0)) {
            if (zzaaqVar.zzh()) {
                this.zzc.zzb(strW0);
            } else {
                this.zzc.zzb(zzaelVar, strW0);
                return;
            }
        }
        long jZza = zzaaqVar.zza();
        boolean zZzi = zzaaqVar.zzi();
        zzaiq zzaiqVarZza = zzaiq.zza(zzaaqVar.zze(), zzaaqVar.zzb().g0(), zzaaqVar.zzb().w0(), zzaaqVar.zzd(), zzaaqVar.zzg(), zzaaqVar.zzf(), zzaaqVar.zzc());
        if (zza(jZza, zZzi)) {
            zzaiqVarZza.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(strW0, zzaelVar, jZza, zZzi);
        this.zzb.zza(zzaiqVarZza, this.zzc.zza(zzaelVar, strW0));
    }

    public final void zza(zzaiu zzaiuVar, zzaem zzaemVar) {
        this.zzb.zza(zzaiuVar, new zzael((zzaem) Preconditions.m(zzaemVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaem zzaemVar) {
        Preconditions.h(str, "cachedTokenState should not be empty.");
        Preconditions.h(str2, "uid should not be empty.");
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, str2, str3, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaem zzaemVar) {
        Preconditions.g(str);
        Preconditions.m(userProfileChangeRequest);
        Preconditions.m(zzaemVar);
        this.zzb.zza(str, userProfileChangeRequest, new zzael(zzaemVar, zza));
    }

    private static boolean zza(long j3, boolean z2) {
        if (j3 > 0 && z2) {
            return true;
        }
        zza.h("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
