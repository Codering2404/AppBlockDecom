package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzeu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MobileAds {
    public static RequestConfiguration a() {
        return zzeu.f().n();
    }

    public static void b(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzeu.f().g(context, null, onInitializationCompleteListener);
    }

    public static void c(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzeu.f().m(context, onAdInspectorClosedListener);
    }

    public static void d(boolean z2) {
        zzeu.f().j(z2);
    }

    public static void e(RequestConfiguration requestConfiguration) {
        zzeu.f().o(requestConfiguration);
    }

    private static void setPlugin(String str) {
        zzeu.f().p(str);
    }

    private static void stop() {
        zzeu.f().h();
    }
}
