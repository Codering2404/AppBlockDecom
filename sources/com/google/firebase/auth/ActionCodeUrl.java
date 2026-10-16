package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ActionCodeUrl {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzal f87728g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f87731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f87732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f87733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f87734f;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        f87728g = com.google.android.gms.internal.p002firebaseauthapi.zzal.zza(map);
    }

    private ActionCodeUrl(String str) {
        String strD = d(str, "apiKey");
        String strD2 = d(str, "oobCode");
        String strD3 = d(str, "mode");
        if (strD == null || strD2 == null || strD3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.f87729a = Preconditions.g(strD);
        this.f87730b = Preconditions.g(strD2);
        this.f87731c = Preconditions.g(strD3);
        this.f87732d = d(str, "continueUrl");
        this.f87733e = d(str, "lang");
        this.f87734f = d(str, "tenantId");
    }

    public static ActionCodeUrl b(String str) {
        Preconditions.g(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String d(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(Preconditions.g(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String a() {
        return this.f87730b;
    }

    public final String c() {
        return this.f87734f;
    }
}
