package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f87916a = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult a(String str) {
        Map map;
        try {
            map = zzbh.b(str);
        } catch (zzaao e3) {
            f87916a.b("Error parsing token claims", e3, new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}
