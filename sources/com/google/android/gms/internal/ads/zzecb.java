package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecb {
    private final Context zza;
    private final ApplicationInfo zzb;
    private String zze = "";
    private final int zzc = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkB)).intValue();
    private final int zzd = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkC)).intValue();

    public zzecb(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
    }

    public final JSONObject zza() throws JSONException {
        String strC0;
        String strEncodeToString;
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.zza;
            String str = this.zzb.packageName;
            zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.f70374l;
            jSONObject.put("name", Wrappers.a(context).d(str));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("packageName", this.zzb.packageName);
        com.google.android.gms.ads.internal.zzt.g();
        Drawable drawable = null;
        try {
            strC0 = com.google.android.gms.ads.internal.util.zzs.c0(this.zza);
        } catch (RemoteException unused2) {
            strC0 = null;
        }
        jSONObject.put("adMobAppId", strC0);
        if (this.zze.isEmpty()) {
            try {
                drawable = (Drawable) Wrappers.a(this.zza).e(this.zzb.packageName).f34341b;
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (drawable == null) {
                strEncodeToString = "";
            } else {
                int i3 = this.zzc;
                int i4 = this.zzd;
                drawable.setBounds(0, 0, i3, i4);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(bitmapCreateBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = strEncodeToString;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
