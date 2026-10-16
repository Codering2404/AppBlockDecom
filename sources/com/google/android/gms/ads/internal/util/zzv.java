package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzclf;
import com.google.android.gms.internal.ads.zzcmj;
import com.google.android.gms.internal.ads.zzekr;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzv extends zzu {
    @Override // com.google.android.gms.ads.internal.util.zzt, com.google.android.gms.ads.internal.util.zzz
    public final zzclf b(zzcku zzckuVar, zzbhp zzbhpVar, boolean z2, zzekr zzekrVar) {
        return new zzcmj(zzckuVar, zzbhpVar, z2, zzekrVar);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final zzbhv.zzq e(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzt.g();
        return zzs.d(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzbhv.zzq.ENUM_TRUE : zzbhv.zzq.ENUM_FALSE : zzbhv.zzq.ENUM_FALSE;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final void f(Context context, String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjM)).intValue());
        notificationChannel.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final boolean g(Context context, String str) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final Intent h(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }
}
