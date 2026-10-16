package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbyu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class NotificationHandlerActivity extends Activity {
    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzbyu zzbyuVarJ = zzay.b().j(this, new zzbuy());
            if (zzbyuVarJ == null) {
                zzo.c("OfflineUtils is null");
            } else {
                zzbyuVarJ.zze(getIntent());
            }
        } catch (RemoteException e3) {
            zzo.c("RemoteException calling handleNotificationIntent: ".concat(e3.toString()));
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        finish();
    }
}
