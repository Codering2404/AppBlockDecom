package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile FirebaseAnalytics f87647b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzfb f87648a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ConsentStatus {
        GRANTED,
        DENIED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ConsentType {
        AD_STORAGE,
        ANALYTICS_STORAGE,
        AD_USER_DATA,
        AD_PERSONALIZATION
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Event {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Param {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UserProperty {
    }

    public FirebaseAnalytics(zzfb zzfbVar) {
        Preconditions.m(zzfbVar);
        this.f87648a = zzfbVar;
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (f87647b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f87647b == null) {
                        f87647b = new FirebaseAnalytics(zzfb.zza(context, null));
                    }
                } finally {
                }
            }
        }
        return f87647b;
    }

    public static zzlk getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzfb zzfbVarZza = zzfb.zza(context, bundle);
        if (zzfbVarZza == null) {
            return null;
        }
        return new zzd(zzfbVarZza);
    }

    public void a(String str, Bundle bundle) {
        this.f87648a.zzh(str, bundle);
    }

    public void b(boolean z2) {
        this.f87648a.zzq(Boolean.valueOf(z2));
    }

    public void c(String str, String str2) {
        this.f87648a.zzk(null, str, str2, false);
    }

    final /* synthetic */ zzfb d() {
        return this.f87648a;
    }

    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            throw new IllegalStateException(e3);
        } catch (ExecutionException e4) {
            throw new IllegalStateException(e4.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.f87648a.zzp(zzdf.zza(activity), str, str2);
    }
}
