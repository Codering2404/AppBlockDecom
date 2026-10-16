package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbqd implements zzbpq {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdzl zzb;
    private final zzbya zzd;
    private final zzekg zze;
    private final zzctj zzf;
    private final zzdbs zzg;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzh = null;
    private final zzhcg zzi = zzcfr.zzh;

    public zzbqd(com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, zzekg zzekgVar, zzdzl zzdzlVar, zzctj zzctjVar, zzdbs zzdbsVar) {
        this.zza = zzbVar;
        this.zzd = zzbyaVar;
        this.zze = zzekgVar;
        this.zzb = zzdzlVar;
        this.zzf = zzctjVar;
        this.zzg = zzdbsVar;
    }

    public static boolean zzb(Map map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    public static int zzc(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzd(Context context, zzbap zzbapVar, Uri uri, View view, Activity activity, zzflc zzflcVar) {
        if (zzbapVar != null) {
            try {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznw)).booleanValue() || zzflcVar == null) {
                    if (zzbapVar.zze(uri)) {
                        return zzbapVar.zzd(uri, context, view, activity);
                    }
                } else if (zzbapVar.zze(uri)) {
                    return zzflcVar.zza(uri, context, view, activity);
                }
            } catch (zzbaq unused) {
            } catch (Exception e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") == null) {
                return uri;
            }
            return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
        } catch (UnsupportedOperationException e3) {
            String strValueOf = String.valueOf(uri.toString());
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error adding click uptime parameter to url: ".concat(strValueOf), e3);
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:132:0x036a  */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.String r27, com.google.android.gms.ads.internal.client.zza r28, java.util.Map r29, java.lang.String r30) {
        /*
            Method dump skipped, instruction units count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzf(java.lang.String, com.google.android.gms.ads.internal.client.zza, java.util.Map, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(com.google.android.gms.internal.ads.zzbiq.zzjO)).booleanValue() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(com.google.android.gms.internal.ads.zzbiq.zzjJ)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(com.google.android.gms.internal.ads.zzbiq.zzjI)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzi(com.google.android.gms.ads.internal.client.zza r10, android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzi(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private final void zzj(Context context, String str, String str2) {
        zzekg zzekgVar = this.zze;
        zzekgVar.zzd(str);
        zzdzl zzdzlVar = this.zzb;
        if (zzdzlVar != null) {
            zzekr.zzk(context, zzdzlVar, zzekgVar, str, "dialog_not_shown", zzgwp.zzb("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        r15 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzk(com.google.android.gms.ads.internal.client.zza r21, java.util.Map r22, boolean r23, java.lang.String r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqd.zzk(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzl(boolean z2) {
        zzbya zzbyaVar = this.zzd;
        if (zzbyaVar != null) {
            zzbyaVar.zzb(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzg(int i3) {
        zzdzl zzdzlVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfz)).booleanValue() || (zzdzlVar = this.zzb) == null) {
            return;
        }
        zzdzk zzdzkVarZza = zzdzlVar.zza();
        zzdzkVarZza.zzc("action", "cct_action");
        switch (i3) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdzkVarZza.zzc("cct_open_status", str);
        zzdzkVarZza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzctj zzctjVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcku zzckuVar = (zzcku) zzaVar;
        if (zzckuVar.zzC() != null) {
            map2 = zzckuVar.zzC().zzaw;
        }
        String strZza = zzceb.zza(str, zzckuVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.b()) {
            zzhbw.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlw)).booleanValue() && (zzctjVar = this.zzf) != null && zzctj.zzc(strZza)) ? zzctjVar.zzb(strZza, com.google.android.gms.ads.internal.client.zzay.h()) : zzhbw.zza(strZza), new zzbpz(this, map, zzaVar, str2), this.zzi);
        } else {
            zzbVar.c(strZza);
        }
    }
}
