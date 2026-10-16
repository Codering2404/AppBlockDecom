package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.core.hardware.fingerprint.sD.jJwHbeUtc;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaer;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;
import com.google.android.gms.internal.p002firebaseauthapi.zzagi;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.crashlytics.internal.metadata.rSN.xSRx;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GenericIdpActivity extends FragmentActivity implements zzaes {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f87816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzcg f87817c = zzcg.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f87818a = false;

    public static /* synthetic */ Uri R(Uri uri, Task task) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.a() != null) {
                Log.w("GenericIdpActivity", "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(appCheckTokenResult.a()));
            }
            builderBuildUpon.fragment("fac=" + appCheckTokenResult.b());
        } else {
            Log.e("GenericIdpActivity", "Unexpected error getting App Check token: " + task.getException().getMessage());
        }
        return builderBuildUpon.build();
    }

    public static String S(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(str, string);
                }
            }
        } catch (JSONException unused) {
            Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Status status) {
        f87816b = 0L;
        this.f87818a = false;
        Intent intent = new Intent();
        zzce.c(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (V(intent)) {
            f87817c.a(this);
        } else {
            zzbl.b(getApplicationContext(), status);
        }
        finish();
    }

    public static /* synthetic */ void U(GenericIdpActivity genericIdpActivity, String str, Task task) {
        if (genericIdpActivity.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
            zzaer.zzb(genericIdpActivity, str);
            return;
        }
        List<ResolveInfo> listQueryIntentServices = genericIdpActivity.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
            customTabsIntentA.a(genericIdpActivity, (Uri) task.getResult());
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
            intent.putExtra("com.android.browser.application_id", str);
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            genericIdpActivity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(Intent intent) {
        return LocalBroadcastManager.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        f87816b = 0L;
        this.f87818a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (V(intent)) {
            f87817c.a(this);
        } else {
            zzbl.b(this, zzao.a("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        xSRx.mPQZQzJPU.invoke(null, this, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, InvocationTargetException {
        jJwHbeUtc.WRjeVszUijraP.invoke(null, this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.f87818a);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final Context zza() {
        return getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri.Builder Q(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String strJoin = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        String strS = S(intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS"));
        String string = UUID.randomUUID().toString();
        String strZza = zzaer.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        zzo.b().e(getApplicationContext(), str, string, strZza, action, stringExtra2, stringExtra3, stringExtra4);
        String strB = zzq.a(getApplicationContext(), FirebaseApp.n(stringExtra4).q()).b();
        if (TextUtils.isEmpty(strB)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            T(zzao.a("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (strZza == null) {
            return null;
        }
        builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", strZza).appendQueryParameter(muQRKXGtpOhe.IeJYvtpsgc, string).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", strB);
        if (!TextUtils.isEmpty(strJoin)) {
            builder.appendQueryParameter("scopes", strJoin);
        }
        if (!TextUtils.isEmpty(strS)) {
            builder.appendQueryParameter("customParameters", strS);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder.appendQueryParameter("tid", stringExtra3);
        }
        return builder;
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
        Log.e("GenericIdpActivity", "Found hermetic configuration for identityToolkit URL: " + strZza);
        return strZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) com.google.android.gms.internal.p002firebaseauthapi.zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(String str, Status status) {
        if (status == null) {
            W();
        } else {
            T(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaes
    public final void zza(final Uri uri, final String str, Provider provider) {
        Task taskForResult;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            taskForResult = interopAppCheckTokenProvider.a(false).continueWith(new Continuation() { // from class: com.google.firebase.auth.internal.zzbf
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return GenericIdpActivity.R(uri, task);
                }
            });
        } else {
            taskForResult = Tasks.forResult(uri);
        }
        taskForResult.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzbg
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GenericIdpActivity.U(this.f87913a, str, task);
            }
        });
    }
}
