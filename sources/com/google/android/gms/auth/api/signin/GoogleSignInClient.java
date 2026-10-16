package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zbb f71195a = new zbb(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f71196b = 1;

    public GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.f70961b, googleSignInOptions, new GoogleApi.Settings.Builder().c(new ApiExceptionMapper()).a());
    }

    private final synchronized int i() {
        int i3;
        try {
            i3 = f71196b;
            if (i3 == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailabilityQ = GoogleApiAvailability.q();
                int iJ = googleApiAvailabilityQ.j(applicationContext, 12451000);
                if (iJ == 0) {
                    i3 = 4;
                    f71196b = 4;
                } else if (googleApiAvailabilityQ.d(applicationContext, iJ, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i3 = 2;
                    f71196b = 2;
                } else {
                    i3 = 3;
                    f71196b = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i3;
    }

    public Task h() {
        return PendingResultUtil.b(zbm.b(asGoogleApiClient(), getApplicationContext(), i() == 3));
    }

    public Task signOut() {
        return PendingResultUtil.b(zbm.c(asGoogleApiClient(), getApplicationContext(), i() == 3));
    }
}
