package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.applovin.impl.mediation.nativeAds.es.CBwUegoGfYl;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaer;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;
import com.google.android.gms.internal.p002firebaseauthapi.zzafd;
import com.google.android.gms.internal.p002firebaseauthapi.zzagi;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.internal.metadata.rSN.xSRx;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RecaptchaActivity extends FragmentActivity implements zzaes {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f87819b = "RecaptchaActivity";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f87820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzcg f87821d = zzcg.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f87822a = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri.Builder Q(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String string = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp firebaseAppN = FirebaseApp.n(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseAppN);
        zzo.b().d(getApplicationContext(), str, string, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String strB = zzq.a(getApplicationContext(), firebaseAppN.q()).b();
        if (TextUtils.isEmpty(strB)) {
            Log.e(f87819b, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            S(zzao.a("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", !TextUtils.isEmpty(firebaseAuth.f()) ? firebaseAuth.f() : zzafd.zza()).appendQueryParameter("eventId", string).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", strB);
        return builder;
    }

    public static /* synthetic */ Uri R(Uri uri, Task task) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.a() != null) {
                Log.w(f87819b, "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(appCheckTokenResult.a()));
            }
            builderBuildUpon.fragment("fac=" + appCheckTokenResult.b());
        } else {
            Log.e(f87819b, "Unexpected error getting App Check token: " + task.getException().getMessage());
        }
        return builderBuildUpon.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(Status status) {
        f87820c = 0L;
        this.f87822a = false;
        Intent intent = new Intent();
        zzce.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        U(intent);
        f87821d.a(this);
        finish();
    }

    public static /* synthetic */ void T(RecaptchaActivity recaptchaActivity, String str, Task task) {
        if (recaptchaActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(f87819b, "Device cannot resolve intent for: android.intent.action.VIEW");
            zzaer.zzb(recaptchaActivity, str);
            return;
        }
        List<ResolveInfo> listQueryIntentServices = recaptchaActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
            customTabsIntentA.f2637a.addFlags(1073741824);
            customTabsIntentA.f2637a.addFlags(268435456);
            customTabsIntentA.a(recaptchaActivity, (Uri) task.getResult());
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
        intent.putExtra("com.android.browser.application_id", str);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        recaptchaActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(Intent intent) {
        return LocalBroadcastManager.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        f87820c = 0L;
        this.f87822a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        U(intent);
        f87821d.a(this);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        xSRx.nAyBRdPR.invoke(null, this, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws IllegalAccessException, InvocationTargetException {
        CBwUegoGfYl.aBIGjkTLfJ.invoke(null, this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.f87822a);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return Q(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final String zza(String str) {
        String strZza = zzagi.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza)) {
            return zzagl.zzb(str);
        }
        Log.e(f87819b, "Found hermetic configuration for identityToolkit URL: " + strZza);
        return strZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) com.google.android.gms.internal.p002firebaseauthapi.zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaes.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(String str, Status status) {
        if (status == null) {
            V();
        } else {
            S(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(final Uri uri, final String str, Provider provider) {
        Task taskForResult;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            taskForResult = interopAppCheckTokenProvider.a(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.zzbp
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return RecaptchaActivity.R(uri, task);
                }
            });
        } else {
            taskForResult = Tasks.forResult(uri);
        }
        taskForResult.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzbn
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RecaptchaActivity.T(this.f87925a, str, task);
            }
        });
    }
}
