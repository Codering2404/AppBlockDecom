package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafe {
    private Context zza;
    private zzafx zzb;
    private String zzc;
    private final FirebaseApp zzd;
    private boolean zze;
    private String zzf;

    public zzafe(FirebaseApp firebaseApp, String str) {
        this(firebaseApp.l(), firebaseApp, str);
    }

    private static String zza(FirebaseApp firebaseApp) {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) FirebaseAuth.getInstance(firebaseApp).M().get();
        if (interopAppCheckTokenProvider == null) {
            return null;
        }
        try {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) Tasks.await(interopAppCheckTokenProvider.a(false));
            if (appCheckTokenResult.a() != null) {
                Log.w("LocalRequestInterceptor", "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(appCheckTokenResult.a()));
            }
            return appCheckTokenResult.b();
        } catch (InterruptedException e3) {
            e = e3;
            Log.e("LocalRequestInterceptor", "Unexpected error getting App Check token: " + e.getMessage());
            return null;
        } catch (ExecutionException e4) {
            e = e4;
            Log.e("LocalRequestInterceptor", "Unexpected error getting App Check token: " + e.getMessage());
            return null;
        }
    }

    private static String zzb(FirebaseApp firebaseApp) {
        HeartBeatController heartBeatController = (HeartBeatController) FirebaseAuth.getInstance(firebaseApp).N().get();
        if (heartBeatController != null) {
            try {
                return (String) Tasks.await(heartBeatController.a());
            } catch (InterruptedException | ExecutionException e3) {
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: " + e3.getMessage());
            }
        }
        return null;
    }

    public zzafe(Context context, FirebaseApp firebaseApp, String str) {
        this.zze = false;
        this.zza = (Context) Preconditions.m(context);
        this.zzd = (FirebaseApp) Preconditions.m(firebaseApp);
        this.zzc = String.format("Android/%s/%s", "Fallback", str);
    }

    public final void zzb(String str) {
        this.zzf = str;
    }

    public final void zza(URLConnection uRLConnection) {
        String str;
        if (this.zze) {
            str = this.zzc + "/FirebaseUI-Android";
        } else {
            str = this.zzc + "/FirebaseCore-Android";
        }
        if (this.zzb == null) {
            this.zzb = new zzafx(this.zza);
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty(GraphRequest.ACCEPT_LANGUAGE_HEADER, zzafd.zza());
        uRLConnection.setRequestProperty("X-Client-Version", str);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.p().c());
        uRLConnection.setRequestProperty("X-Firebase-Client", zzb(this.zzd));
        String strZza = zza(this.zzd);
        if (!TextUtils.isEmpty(strZza)) {
            uRLConnection.setRequestProperty("X-Firebase-AppCheck", strZza);
        }
        this.zzf = null;
    }

    public final void zza(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }
}
