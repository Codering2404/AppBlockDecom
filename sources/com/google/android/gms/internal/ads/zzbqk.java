package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqk implements zzbpq {
    private final Context zza;

    public zzbqk(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        if (!map.containsKey("text") || TextUtils.isEmpty((CharSequence) map.get("text"))) {
            return;
        }
        com.google.android.gms.ads.internal.util.zze.k("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get("text"))));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (String) map.get("text"));
        if (map.containsKey("title")) {
            intent.putExtra(MHoiDDglUlPJC.QvmROmK, (String) map.get("title"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.util.zzs.y(this.zza, intent);
        } catch (RuntimeException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to open Share Sheet", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "ShareSheetGmsgHandler.onGmsg");
        }
    }
}
