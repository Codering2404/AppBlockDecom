package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends zzfs {
    static final String zza;
    private static final String zzb;
    private static final String zzc;
    private static final String zzd;
    private static final String zze;
    private static final Set zzf;
    private final zzn zzg;
    private final Context zzh;

    static {
        String string = com.google.android.gms.internal.gtm.zza.ARBITRARY_PIXEL.toString();
        zzb = string;
        zzc = com.google.android.gms.internal.gtm.zzb.URL.toString();
        zzd = com.google.android.gms.internal.gtm.zzb.ADDITIONAL_PARAMS.toString();
        zze = com.google.android.gms.internal.gtm.zzb.UNREPEATABLE.toString();
        zza = "gtm_" + string + "_unrepeatable";
        zzf = new HashSet();
    }

    public zzo(Context context) {
        zzm zzmVar = new zzm(context);
        super(zzb, zzc);
        this.zzg = zzmVar;
        this.zzh = context;
    }

    private final synchronized boolean zzd(String str) {
        Set set = zzf;
        if (set.contains(str)) {
            return true;
        }
        if (!this.zzh.getSharedPreferences(zza, 0).contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzfs
    public final void zzc(Map map) {
        String str = zze;
        String strZzm = map.get(str) != null ? zzfu.zzm(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(str))) : null;
        if (strZzm == null || !zzd(strZzm)) {
            Uri.Builder builderBuildUpon = Uri.parse(zzfu.zzm(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(zzc)))).buildUpon();
            com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
            if (zzamVar != null) {
                Object objZzk = zzfu.zzk(zzamVar);
                if (!(objZzk instanceof List)) {
                    Log.e("GoogleTagManager", FptyjHFU.UnkxsSItgZyBL.concat(String.valueOf(builderBuildUpon.build().toString())));
                    return;
                }
                for (Object obj : (List) objZzk) {
                    if (!(obj instanceof Map)) {
                        Log.e("GoogleTagManager", "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(String.valueOf(builderBuildUpon.build().toString())));
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String string = builderBuildUpon.build().toString();
            zzbg.zzb(((zzm) this.zzg).zza).zza(string);
            zzdg.zzb.zzd("ArbitraryPixel: url = ".concat(String.valueOf(string)));
            if (strZzm != null) {
                synchronized (zzo.class) {
                    zzf.add(strZzm);
                    zzff.zza(this.zzh, zza, strZzm, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }
}
