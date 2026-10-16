package com.singular.sdk.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.singular.sdk.internal.utils.UriUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLPushNotificationsManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static SLPushNotificationsManager f92644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SingularLog f92645e = SingularLog.f(SLPushNotificationsManager.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f92646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f92647b = Boolean.FALSE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f92648c;

    private SLPushNotificationsManager() {
    }

    static HashMap c(Bundle bundle) {
        HashMap map = new HashMap();
        try {
            for (String str : bundle.keySet()) {
                map.put(str, bundle.get(str));
            }
            return map;
        } catch (Throwable th) {
            f92645e.a(Utils.l(th));
            return map;
        }
    }

    public static SLPushNotificationsManager e() {
        if (f92644d == null) {
            f92644d = new SLPushNotificationsManager();
        }
        return f92644d;
    }

    void a() {
        f92645e.a("app moved to background");
        this.f92647b = Boolean.FALSE;
        this.f92646a = null;
    }

    public void b() {
        this.f92647b = Boolean.TRUE;
    }

    Boolean d() {
        return this.f92647b;
    }

    Uri f() {
        return this.f92646a;
    }

    String g(Intent intent, String[]... strArr) {
        try {
        } catch (Throwable th) {
            f92645e.a(Utils.l(th));
        }
        if (intent.getExtras() != null && !intent.getExtras().isEmpty()) {
            if (strArr != null && strArr.length != 0) {
                HashMap mapC = c(intent.getExtras());
                for (String[] strArr2 : strArr) {
                    int length = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            Object obj = mapC.get(strArr2[i3]);
                            if (obj instanceof HashMap) {
                                mapC = (HashMap) obj;
                            } else if (obj instanceof Bundle) {
                                mapC = c((Bundle) obj);
                            } else if (obj instanceof String) {
                                f92645e.a("a value was found in push payload, returning it.");
                                return String.valueOf(obj);
                            }
                            i3++;
                        }
                    }
                }
                f92645e.a("no value was found in push payload, returning nil");
                return null;
            }
            f92645e.a("path selectors not provided or empty");
            return null;
        }
        f92645e.a("push payload extras is null or empty");
        return null;
    }

    public Boolean h(Intent intent, String[]... strArr) {
        if (intent == null) {
            f92645e.a("push payload intent is null");
            return Boolean.FALSE;
        }
        Intent intent2 = this.f92648c;
        if (intent2 != null && intent2.hashCode() == intent.hashCode()) {
            f92645e.a("push is processed already. so ignoring");
            return Boolean.FALSE;
        }
        this.f92648c = intent;
        String strG = g(intent, strArr);
        if (Utils.U(strG)) {
            f92645e.a("extracted value in push payload is null or empty.");
            return Boolean.FALSE;
        }
        try {
            Uri uri = Uri.parse(strG);
            if (!UriUtils.a(uri)) {
                f92645e.a("push payload value is an invalid URL.");
                return Boolean.FALSE;
            }
            if (!Utils.T(uri) && !Utils.S(uri) && !Utils.c0(uri)) {
                f92645e.a("push link is neither esp link nor branded link nor sng link");
                return Boolean.FALSE;
            }
            f92645e.a("payload value is a valid url. the SDK can enqeue a new /start with this value: " + uri);
            this.f92646a = uri;
            return Boolean.TRUE;
        } catch (Throwable th) {
            f92645e.a(Utils.l(th));
            return Boolean.FALSE;
        }
    }
}
