package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzaif;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzu implements ActionCodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f88003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f88005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActionCodeInfo f88006d;

    public zzu(zzaif zzaifVar) {
        int i3;
        this.f88004b = zzaifVar.zzg() ? zzaifVar.zzc() : zzaifVar.zzb();
        this.f88005c = zzaifVar.zzb();
        ActionCodeInfo zzsVar = null;
        if (!zzaifVar.zzh()) {
            this.f88003a = 3;
            this.f88006d = null;
            return;
        }
        String strZzd = zzaifVar.zzd();
        strZzd.getClass();
        i3 = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i3 = 6;
                break;
            case "PASSWORD_RESET":
                i3 = 0;
                break;
            case "VERIFY_EMAIL":
                i3 = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i3 = 4;
                break;
            case "RECOVER_EMAIL":
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        this.f88003a = i3;
        if (i3 == 4 || i3 == 3) {
            this.f88006d = null;
            return;
        }
        if (zzaifVar.zzf()) {
            zzsVar = new zzv(zzaifVar.zzb(), zzbk.a(zzaifVar.zza()));
        } else if (zzaifVar.zzg()) {
            zzsVar = new zzt(zzaifVar.zzc(), zzaifVar.zzb());
        } else if (zzaifVar.zze()) {
            zzsVar = new zzs(zzaifVar.zzb());
        }
        this.f88006d = zzsVar;
    }

    public final int a() {
        return this.f88003a;
    }
}
