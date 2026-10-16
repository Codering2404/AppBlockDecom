package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f71257a = new Logger("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f71257a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static PendingResult b(GoogleApiClient googleApiClient, Context context, boolean z2) {
        f71257a.a("Revoking access", new Object[0]);
        String strE = Storage.b(context).e();
        d(context);
        return z2 ? zbb.a(strE) : googleApiClient.h(new zbk(googleApiClient));
    }

    public static PendingResult c(GoogleApiClient googleApiClient, Context context, boolean z2) {
        f71257a.a("Signing out", new Object[0]);
        d(context);
        return z2 ? PendingResults.b(Status.f71537g, googleApiClient) : googleApiClient.h(new zbi(googleApiClient));
    }

    private static void d(Context context) {
        zbn.a(context).b();
        Iterator it = GoogleApiClient.i().iterator();
        while (it.hasNext()) {
            ((GoogleApiClient) it.next()).n();
        }
        GoogleApiManager.a();
    }
}
