package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.GraphRequest;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv extends zzbu {
    protected String zza;
    protected String zzb;
    protected boolean zzc;
    protected int zzd;
    protected boolean zze;
    protected boolean zzf;

    public zzfv(zzbx zzbxVar) {
        super(zzbxVar);
    }

    public final String zza() {
        zzV();
        return this.zzb;
    }

    public final String zzb() {
        zzV();
        return this.zza;
    }

    public final boolean zzc() {
        zzV();
        return this.zzf;
    }

    public final boolean zze() {
        zzV();
        return this.zze;
    }

    public final boolean zzf() {
        zzV();
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        ApplicationInfo applicationInfo;
        int i3;
        int i4;
        Context contextZzo = zzo();
        try {
            applicationInfo = contextZzo.getPackageManager().getApplicationInfo(contextZzo.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        } catch (PackageManager.NameNotFoundException e3) {
            zzR("PackageManager doesn't know about the app package", e3);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzQ("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i3 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0) {
            zzbx zzbxVarZzt = zzt();
            zzey zzeyVar = (zzey) new zzcu(zzbxVarZzt, new zzex(zzbxVarZzt)).zza(i3);
            if (zzeyVar != null) {
                zzN("Loading global XML config values");
                String str = zzeyVar.zza;
                if (str != null) {
                    this.zzb = str;
                    zzF(CbYNFSEGaQj.lEVc, str);
                }
                String str2 = zzeyVar.zzb;
                if (str2 != null) {
                    this.zza = str2;
                    zzF("XML config - app version", str2);
                }
                String str3 = zzeyVar.zzc;
                boolean z2 = false;
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.US);
                    if ("verbose".equals(lowerCase)) {
                        i4 = 0;
                    } else if (GraphRequest.DEBUG_SEVERITY_INFO.equals(lowerCase)) {
                        i4 = 1;
                    } else if (GraphRequest.DEBUG_SEVERITY_WARNING.equals(lowerCase)) {
                        i4 = 2;
                    } else if ("error".equals(lowerCase)) {
                        i4 = 3;
                    } else {
                        i4 = -1;
                    }
                    if (i4 >= 0) {
                        zzO("XML config - log level", Integer.valueOf(i4));
                    }
                }
                int i5 = zzeyVar.zzd;
                if (i5 >= 0) {
                    this.zzd = i5;
                    this.zzc = true;
                    zzF("XML config - dispatch period (sec)", Integer.valueOf(i5));
                }
                int i6 = zzeyVar.zze;
                if (i6 != -1) {
                    if (1 == i6) {
                        z2 = true;
                    }
                    this.zzf = z2;
                    this.zze = true;
                    zzF("XML config - dry run", Boolean.valueOf(z2));
                }
            }
        }
    }
}
