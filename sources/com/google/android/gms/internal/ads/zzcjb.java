package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjb implements zzbpq {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = (String) map.get(str);
            StringBuilder sb = new StringBuilder(str.length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(string);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcja zzcjdVar;
        int i3;
        zzchn zzchnVar = (zzchn) obj;
        if (com.google.android.gms.ads.internal.util.client.zzo.j(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.a("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcit zzcitVarB = com.google.android.gms.ads.internal.zzt.b();
        if (map.containsKey("abort")) {
            if (zzcitVarB.zza(zzchnVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.f("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzchm zzchmVar = new zzchm((String) map.get("flags"));
        boolean z2 = zzchmVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzcis zzcisVarZzb = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    i3 = 0;
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        try {
                            strArr2[i4] = jSONArray.getString(i4);
                        } catch (JSONException unused) {
                            com.google.android.gms.ads.internal.util.client.zzo.f("Malformed demuxed URL list for precache: ".concat(str2));
                            strArr = null;
                        }
                    }
                    strArr = strArr2;
                } catch (JSONException unused2) {
                    i3 = 0;
                }
            } else {
                i3 = 0;
            }
            if (strArr == null) {
                strArr = new String[1];
                strArr[i3] = str;
            }
            if (z2) {
                Iterator it = zzcitVarB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zzcis zzcisVar = (zzcis) it.next();
                    if (zzcisVar.zza == zzchnVar && str.equals(zzcisVar.zzd())) {
                        zzcisVarZzb = zzcisVar;
                        break;
                    }
                }
            } else {
                zzcisVarZzb = zzcitVarB.zzb(zzchnVar);
            }
            if (zzcisVarZzb != null) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Precache task is already running.");
                return;
            }
            if (zzchnVar.zzk() == null) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = Integer.valueOf(i3);
            }
            if (numZzb != null) {
                zzchnVar.zzo(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzchnVar.zzA(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzchnVar.zzB(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzcik zzcikVar = zzchnVar.zzk().f70388b;
            if (iIntValue > 0) {
                int i5 = zzchmVar.zzg;
                int iZzQ = zzche.zzQ();
                if (iZzQ < i5) {
                    zzcjdVar = new zzcjj(zzchnVar, zzchmVar);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzr)).booleanValue()) {
                        iZzQ = zzcjg.zzr();
                    }
                    zzcjdVar = iZzQ < zzchmVar.zzb ? new zzcjg(zzchnVar, zzchmVar) : new zzcje(zzchnVar);
                }
            } else {
                zzcjdVar = new zzcjd(zzchnVar);
            }
            new zzcis(zzchnVar, zzcjdVar, str, strArr).zzb();
        } else {
            zzcis zzcisVarZzb2 = zzcitVarB.zzb(zzchnVar);
            if (zzcisVarZzb2 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Precache must specify a source.");
                return;
            }
            zzcjdVar = zzcisVarZzb2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzcjdVar.zzi(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzcjdVar.zzh(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzcjdVar.zzj(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzcjdVar.zzk(numZzb8.intValue());
        }
    }
}
