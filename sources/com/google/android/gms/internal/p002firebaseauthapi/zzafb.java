package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafb extends zzaft implements zzagn {
    private zzaev zza;
    private zzaey zzb;
    private zzafy zzc;
    private final zzafc zzd;
    private final FirebaseApp zze;
    private String zzf;
    private zzafe zzg;

    zzafb(FirebaseApp firebaseApp, zzafc zzafcVar) {
        this(firebaseApp, zzafcVar, null, null, null, null);
    }

    private final zzafe zzb() {
        if (this.zzg == null) {
            this.zzg = new zzafe(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzags zzagsVar, zzafv<zzagv> zzafvVar) {
        Preconditions.m(zzagsVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/createAuthUri", this.zzf), zzagsVar, zzafvVar, zzagv.class, zzaevVar.zza);
    }

    private zzafb(FirebaseApp firebaseApp, zzafc zzafcVar, zzafy zzafyVar, zzaev zzaevVar, zzaey zzaeyVar, zzaew zzaewVar) {
        this.zze = firebaseApp;
        this.zzf = firebaseApp.p().b();
        firebaseApp.p().e();
        this.zzd = (zzafc) Preconditions.m(zzafcVar);
        zza(null, null, null, null);
        zzagl.zza(this.zzf, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagu zzaguVar, zzafv<Void> zzafvVar) {
        Preconditions.m(zzaguVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/deleteAccount", this.zzf), zzaguVar, zzafvVar, Void.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagx zzagxVar, zzafv<zzagw> zzafvVar) {
        Preconditions.m(zzagxVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/emailLinkSignin", this.zzf), zzagxVar, zzafvVar, zzagw.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagz zzagzVar, zzafv<zzagy> zzafvVar) {
        Preconditions.m(zzagzVar);
        Preconditions.m(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzagzVar, zzafvVar, zzagy.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahb zzahbVar, zzafv<zzaha> zzafvVar) {
        Preconditions.m(zzahbVar);
        Preconditions.m(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaSignIn:finalize", this.zzf), zzahbVar, zzafvVar, zzaha.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahj zzahjVar, zzafv<zzahv> zzafvVar) {
        Preconditions.m(zzahjVar);
        Preconditions.m(zzafvVar);
        zzafy zzafyVar = this.zzc;
        zzafu.zza(zzafyVar.zza("/token", this.zzf), zzahjVar, zzafvVar, zzahv.class, zzafyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahi zzahiVar, zzafv<zzahl> zzafvVar) {
        Preconditions.m(zzahiVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getAccountInfo", this.zzf), zzahiVar, zzafvVar, zzahl.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahm zzahmVar, zzafv<zzahp> zzafvVar) {
        Preconditions.m(zzahmVar);
        Preconditions.m(zzafvVar);
        if (zzahmVar.zzb() != null) {
            zzb().zzb(zzahmVar.zzb().zze());
        }
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getOobConfirmationCode", this.zzf), zzahmVar, zzafvVar, zzahp.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaho zzahoVar, zzafv<zzahr> zzafvVar) {
        Preconditions.m(zzahoVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getRecaptchaParam", this.zzf), zzafvVar, zzahr.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaht zzahtVar, zzafv<zzahs> zzafvVar) {
        Preconditions.m(zzahtVar);
        Preconditions.m(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        String str = zzaeyVar.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzahtVar.zzb() + "&version=" + zzahtVar.zzc();
        if (!zzac.zzc(zzahtVar.zzd())) {
            str = str + "&tenantId=" + zzahtVar.zzd();
        }
        zzafu.zza(str, zzafvVar, zzahs.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagn
    public final void zza() {
        zza(null, null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaic zzaicVar, zzafv<zzaif> zzafvVar) {
        Preconditions.m(zzaicVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/resetPassword", this.zzf), zzaicVar, zzafvVar, zzaif.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaie zzaieVar, zzafv<zzaig> zzafvVar) {
        Preconditions.m(zzaieVar);
        Preconditions.m(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts:revokeToken", this.zzf), zzaieVar, zzafvVar, zzaig.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaij zzaijVar, zzafv<zzaii> zzafvVar) {
        Preconditions.m(zzaijVar);
        Preconditions.m(zzafvVar);
        if (!TextUtils.isEmpty(zzaijVar.zzc())) {
            zzb().zzb(zzaijVar.zzc());
        }
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/sendVerificationCode", this.zzf), zzaijVar, zzafvVar, zzaii.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzail zzailVar, zzafv<zzaik> zzafvVar) {
        Preconditions.m(zzailVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/setAccountInfo", this.zzf), zzailVar, zzafvVar, zzaik.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(String str, zzafv<Void> zzafvVar) {
        Preconditions.m(zzafvVar);
        zzb().zza(str);
        zzafvVar.zza((Void) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaim zzaimVar, zzafv<zzaip> zzafvVar) {
        Preconditions.m(zzaimVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/signupNewUser", this.zzf), zzaimVar, zzafvVar, zzaip.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaio zzaioVar, zzafv<zzair> zzafvVar) {
        Preconditions.m(zzaioVar);
        Preconditions.m(zzafvVar);
        if (zzaioVar instanceof zzais) {
            zzais zzaisVar = (zzais) zzaioVar;
            if (!TextUtils.isEmpty(zzaisVar.zzb())) {
                zzb().zzb(zzaisVar.zzb());
            }
        }
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:start", this.zzf), zzaioVar, zzafvVar, zzair.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaiq zzaiqVar, zzafv<zzait> zzafvVar) {
        Preconditions.m(zzaiqVar);
        Preconditions.m(zzafvVar);
        if (!TextUtils.isEmpty(zzaiqVar.zzb())) {
            zzb().zzb(zzaiqVar.zzb());
        }
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaSignIn:start", this.zzf), zzaiqVar, zzafvVar, zzait.class, zzaeyVar.zza);
    }

    private final void zza(zzafy zzafyVar, zzaev zzaevVar, zzaey zzaeyVar, zzaew zzaewVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String strZza = zzagi.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzagl.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + strZza);
        }
        if (this.zzc == null) {
            this.zzc = new zzafy(strZza, zzb());
        }
        String strZza2 = zzagi.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzagl.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + strZza2);
        }
        if (this.zza == null) {
            this.zza = new zzaev(strZza2, zzb());
        }
        String strZza3 = zzagi.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzagl.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + strZza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzaey(strZza3, zzb());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajb zzajbVar, zzafv<zzajd> zzafvVar) {
        Preconditions.m(zzajbVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyAssertion", this.zzf), zzajbVar, zzafvVar, zzajd.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajc zzajcVar, zzafv<zzajf> zzafvVar) {
        Preconditions.m(zzajcVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyCustomToken", this.zzf), zzajcVar, zzafvVar, zzajf.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaje zzajeVar, zzafv<zzajh> zzafvVar) {
        Preconditions.m(zzajeVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyPassword", this.zzf), zzajeVar, zzafvVar, zzajh.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajg zzajgVar, zzafv<zzajj> zzafvVar) {
        Preconditions.m(zzajgVar);
        Preconditions.m(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyPhoneNumber", this.zzf), zzajgVar, zzafvVar, zzajj.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaji zzajiVar, zzafv<zzajl> zzafvVar) {
        Preconditions.m(zzajiVar);
        Preconditions.m(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzajiVar, zzafvVar, zzajl.class, zzaeyVar.zza);
    }
}
