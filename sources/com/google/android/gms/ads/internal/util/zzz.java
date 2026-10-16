package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzclf;
import com.google.android.gms.internal.ads.zzekr;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzz {
    /* synthetic */ zzz(byte[] bArr) {
    }

    public CookieManager a(Context context) {
        throw null;
    }

    public zzclf b(zzcku zzckuVar, zzbhp zzbhpVar, boolean z2, zzekr zzekrVar) {
        throw null;
    }

    public WebResourceResponse c(String str, String str2, int i3, String str3, Map map, InputStream inputStream) {
        throw null;
    }

    public boolean d(Activity activity, Configuration configuration) {
        return false;
    }

    public zzbhv.zzq e(Context context, TelephonyManager telephonyManager) {
        return zzbhv.zzq.ENUM_UNKNOWN;
    }

    public boolean g(Context context, String str) {
        return false;
    }

    public Intent h(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public int j(AudioManager audioManager) {
        return 0;
    }

    public int k(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    public void i(Activity activity) {
    }

    public void f(Context context, String str, String str2) {
    }
}
