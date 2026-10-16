package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class GmsRpc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f89404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Metadata f89405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rpc f89406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider f89407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider f89408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FirebaseInstallationsApi f89409f;

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.l()), provider, provider2, firebaseInstallationsApi);
    }

    public static /* synthetic */ String a(GmsRpc gmsRpc, Task task) {
        gmsRpc.getClass();
        return gmsRpc.g((Bundle) task.getResult(IOException.class));
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task c(Task task) {
        return task.continueWith(new androidx.credentials.c(), new Continuation() { // from class: com.google.firebase.messaging.s
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return GmsRpc.a(this.f89599a, task2);
            }
        });
    }

    private String d() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f89404a.o().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    static boolean h(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    private void i(String str, String str2, Bundle bundle) {
        HeartBeatInfo.HeartBeat heartBeatB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f89404a.p().c());
        bundle.putString("gmsv", Integer.toString(this.f89405b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f89405b.a());
        bundle.putString("app_ver_name", this.f89405b.b());
        bundle.putString("firebase-app-name-hash", d());
        try {
            String strB = ((InstallationTokenResult) Tasks.await(this.f89409f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException e3) {
            e = e3;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e4) {
            e = e4;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString(AppsFlyerProperties.APP_ID, (String) Tasks.await(this.f89409f.getId()));
        bundle.putString("cliv", "fcm-25.0.1");
        HeartBeatInfo heartBeatInfo = (HeartBeatInfo) this.f89408e.get();
        UserAgentPublisher userAgentPublisher = (UserAgentPublisher) this.f89407d.get();
        if (heartBeatInfo == null || userAgentPublisher == null || (heartBeatB = heartBeatInfo.b("fire-iid")) == HeartBeatInfo.HeartBeat.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatB.b()));
        bundle.putString("Firebase-Client", userAgentPublisher.a());
    }

    private Task k(String str, String str2, Bundle bundle) {
        try {
            i(str, str2, bundle);
            return this.f89406c.c(bundle);
        } catch (InterruptedException | ExecutionException e3) {
            return Tasks.forException(e3);
        }
    }

    Task e() {
        return this.f89406c.a();
    }

    Task f() {
        return c(k(Metadata.c(this.f89404a), "*", new Bundle()));
    }

    Task j(boolean z2) {
        return this.f89406c.d(z2);
    }

    Task l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return c(k(str, "/topics/" + str2, bundle));
    }

    Task m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        return c(k(str, "/topics/" + str2, bundle));
    }

    private String g(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString(YgVrd.RbNwvwmlL);
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider provider, Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f89404a = firebaseApp;
        this.f89405b = metadata;
        this.f89406c = rpc;
        this.f89407d = provider;
        this.f89408e = provider2;
        this.f89409f = firebaseInstallationsApi;
    }
}
