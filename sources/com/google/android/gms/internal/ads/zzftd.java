package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzftd {
    private final zzdzl zza;

    zzftd(zzdzl zzdzlVar, Context context) {
        this.zza = zzdzlVar;
    }

    private final void zzv(String str, long j3, String str2, String str3, AdFormat adFormat, int i3, int i4, int i5, String str4) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", str);
        zzdzkVarZza.zzc("pat", Long.toString(j3));
        zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        zzdzkVarZza.zzc("pas", Integer.toString(i5));
        zzdzkVarZza.zzc("pv", "2");
        zzdzkVarZza.zzc("ad_unit_id", str3);
        zzdzkVarZza.zzc("pid", str2);
        zzdzkVarZza.zzd();
    }

    private final void zzw(String str, String str2, long j3, int i3, int i4, String str3, zzftk zzftkVar, String str4) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc(str2, Long.toString(j3));
        if (zzftkVar != null) {
            zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
            zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
            zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        }
        zzdzkVarZza.zzc("action", str);
        if (str3 != null) {
            zzdzkVarZza.zzc("gqi", str3);
        }
        if (i3 >= 0) {
            zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        }
        if (i4 >= 0) {
            zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        }
        zzdzkVarZza.zzc("pv", str4);
        zzdzkVarZza.zzd();
    }

    private final void zzx(String str, long j3, String str2, String str3, AdFormat adFormat, int i3, int i4, int i5, int i6, int i7) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", str);
        zzdzkVarZza.zzc("pat", Long.toString(j3));
        zzdzkVarZza.zzc("pid", str2);
        zzdzkVarZza.zzc("ad_unit_id", str3);
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        zzdzkVarZza.zzc("tpcnt", Integer.toString(i6));
        zzdzkVarZza.zzc("mpl", Integer.toString(i7));
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        if (i5 > 0) {
            zzdzkVarZza.zzc("nptr", Integer.toString(i5));
        }
        zzdzkVarZza.zzd();
    }

    public final void zza(int i3, long j3, zzftk zzftkVar, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "start_preload");
        zzdzkVarZza.zzc("sp_ts", Long.toString(j3));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("pv", str);
        zzdzkVarZza.zzd();
    }

    public final void zzb(Map map, long j3, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "start_preload");
        zzdzkVarZza.zzc("sp_ts", Long.toString(j3));
        zzdzkVarZza.zzc("pv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (AdFormat adFormat : map.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdzkVarZza.zzc(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdzkVarZza.zzd();
    }

    public final void zzc(int i3, int i4, long j3, zzftk zzftkVar) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "cache_resize");
        zzdzkVarZza.zzc("cs_ts", Long.toString(j3));
        zzdzkVarZza.zzc("orig_ma", Integer.toString(i3));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i4));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("pv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzdzkVarZza.zzd();
    }

    public final void zzd(int i3, int i4, long j3, Long l3, String str, zzftk zzftkVar, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("plaac_ts", Long.toString(j3));
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        zzdzkVarZza.zzc("action", "is_ad_available");
        if (zzftkVar != null) {
            zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
            zzdzkVarZza.zzc("pid", zzftkVar.zzc());
            zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        }
        if (l3 != null) {
            zzdzkVarZza.zzc("plaay_ts", Long.toString(l3.longValue()));
        }
        if (str != null) {
            zzdzkVarZza.zzc("gqi", str);
        }
        zzdzkVarZza.zzc("pv", str2);
        zzdzkVarZza.zzd();
    }

    public final void zze(long j3, String str) {
        zzw("poll_ad", "ppacwe_ts", j3, -1, -1, null, null, "2");
    }

    public final void zzf(long j3, zzftk zzftkVar, int i3, int i4, String str) {
        zzw("poll_ad", "ppac_ts", j3, i3, i4, null, zzftkVar, str);
    }

    public final void zzg(long j3, int i3, int i4, String str, zzftk zzftkVar, String str2) {
        zzw("poll_ad", "psvroc_ts", j3, i3, i4, str, zzftkVar, str2);
    }

    public final void zzh(long j3, int i3, int i4, String str, zzftk zzftkVar, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("ppla_ts", Long.toString(j3));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        zzdzkVarZza.zzc("action", "poll_ad");
        if (str != null) {
            zzdzkVarZza.zzc("gqi", str);
        }
        zzdzkVarZza.zzc("pv", str2);
        zzdzkVarZza.zzd();
    }

    public final void zzi(long j3, String str, zzftk zzftkVar, int i3, int i4, String str2) {
        zzw("paa", "pano_ts", j3, i3, i4, str, zzftkVar, str2);
    }

    public final void zzj(long j3, zzftk zzftkVar, int i3, String str) {
        zzw("pae", "paeo_ts", j3, i3, 0, null, zzftkVar, str);
    }

    public final void zzk(long j3, zzftk zzftkVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i3, int i4, String str) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "pftla");
        zzdzkVarZza.zzc("pftlat_ts", Long.toString(j3));
        zzdzkVarZza.zzc("pftlaec", Integer.toString(zzeVar.f69851a));
        zzdzkVarZza.zzc("ad_format", zzftkVar.zzb());
        zzdzkVarZza.zzc("max_ads", Integer.toString(i3));
        zzdzkVarZza.zzc("cache_size", Integer.toString(i4));
        zzdzkVarZza.zzc("ad_unit_id", zzftkVar.zza());
        zzdzkVarZza.zzc("pid", zzftkVar.zzc());
        zzdzkVarZza.zzc("pv", str);
        zzdzkVarZza.zzd();
    }

    public final void zzl(long j3, AdFormat adFormat, int i3) {
        zzv("pda", j3, null, null, adFormat, -1, -1, i3, "2");
    }

    public final void zzm(long j3, String str, String str2, AdFormat adFormat, int i3, int i4) {
        zzv("pd", j3, str, str2, adFormat, i3, i4, 1, "2");
    }

    public final void zzn(AdFormat adFormat, long j3, int i3) {
        zzv("pgcs", j3, null, null, adFormat, -1, -1, i3, "2");
    }

    public final void zzo(long j3, String str, String str2, AdFormat adFormat, int i3, int i4) {
        zzv("pgc", j3, str, str2, adFormat, i3, i4, 1, "2");
    }

    public final void zzp(int i3, long j3, String str, String str2, AdFormat adFormat, int i4) {
        zzv("pnav", j3, str, str2, adFormat, i4, i3, 1, "2");
    }

    public final void zzq(long j3, String str, String str2, AdFormat adFormat, int i3, int i4, int i5, int i6) {
        zzx("acmpa", j3, str, str2, adFormat, i3, i4, 0, i5, i6);
    }

    public final void zzr(long j3, String str, String str2, AdFormat adFormat, int i3, int i4, int i5, int i6, int i7) {
        zzx("acmpr", j3, str, str2, adFormat, i3, i4, i5, i6, i7);
    }

    public final void zzs(long j3, int i3, int i4) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "acmlr");
        zzdzkVarZza.zzc("pat", Long.toString(j3));
        zzdzkVarZza.zzc("mpl", Integer.toString(i3));
        zzdzkVarZza.zzc("pas", Integer.toString(i4));
        zzdzkVarZza.zzd();
    }

    public final void zzt(long j3, AdFormat adFormat, String str, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "poact");
        zzdzkVarZza.zzc("ad_unit_id", str2);
        zzdzkVarZza.zzc("pid", str);
        zzdzkVarZza.zzc("poact_ts", Long.toString(j3));
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        zzdzkVarZza.zzd();
    }

    public final void zzu(long j3, AdFormat adFormat, String str, String str2) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "poac");
        zzdzkVarZza.zzc("ad_unit_id", str2);
        zzdzkVarZza.zzc("pid", str);
        if (adFormat != null) {
            zzdzkVarZza.zzc("ad_format", adFormat.name().toLowerCase(Locale.ENGLISH));
        }
        zzdzkVarZza.zzd();
    }
}
