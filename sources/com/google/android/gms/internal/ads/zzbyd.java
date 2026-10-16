package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyd extends zzbyg {
    private final Map zza;
    private final Context zzb;

    public zzbyd(zzcku zzckuVar, Map map) {
        super(zzckuVar, "storePicture");
        this.zza = map;
        this.zzb = zzckuVar.zzj();
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.g();
        if (!new zzbhx(context).zza()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzg("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzg("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.g();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzg("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = com.google.android.gms.ads.internal.util.zzs.n(context);
        builderN.setTitle(resourcesZzf != null ? resourcesZzf.getString(R.string.f69759n) : "Save image");
        builderN.setMessage(resourcesZzf != null ? resourcesZzf.getString(R.string.f69760o) : "Allow Ad to store image in Picture gallery?");
        builderN.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f69761p) : "Accept", new zzbyb(this, str, lastPathSegment));
        builderN.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f69762q) : "Decline", new zzbyc(this));
        builderN.create().show();
    }

    final /* synthetic */ Context zzb() {
        return this.zzb;
    }
}
