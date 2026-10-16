package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.RecaptchaActivity;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafz {
    private final FirebaseAuth zza;
    private final Activity zzb;

    public zzafz(FirebaseAuth firebaseAuth, Activity activity) {
        this.zza = firebaseAuth;
        this.zzb = activity;
    }

    public final void zza() {
        Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent.setClass(this.zzb, RecaptchaActivity.class);
        intent.setPackage(this.zzb.getPackageName());
        intent.putExtra("com.google.firebase.auth.KEY_API_KEY", this.zza.b().p().b());
        if (!TextUtils.isEmpty(this.zza.g())) {
            intent.putExtra(KrzujOtzIk.YDgG, this.zza.g());
        }
        intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzafc.zza().zzb());
        intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", this.zza.b().o());
        intent.putExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", this.zza.d());
        this.zzb.startActivity(intent);
    }
}
