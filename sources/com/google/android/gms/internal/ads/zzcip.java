package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcip implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchn zzchnVar = (zzchn) obj;
        zzcma zzcmaVarZzh = zzchnVar.zzh();
        if (zzcmaVarZzh == null) {
            try {
                zzcma zzcmaVar = new zzcma(zzchnVar, Float.parseFloat((String) map.get("duration")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("customControlsAllowed")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("clickToExpandAllowed")));
                zzchnVar.zzw(zzcmaVar);
                zzcmaVarZzh = zzcmaVar;
            } catch (NullPointerException e3) {
                e = e3;
                Throwable th = e;
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to parse videoMeta message.", th);
                com.google.android.gms.ads.internal.zzt.l().zzg(th, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e4) {
                e = e4;
                Throwable th2 = e;
                int i32 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to parse videoMeta message.", th2);
                com.google.android.gms.ads.internal.zzt.l().zzg(th2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f3 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("muted"));
        float f4 = Float.parseFloat((String) map.get("currentTime"));
        int i4 = Integer.parseInt((String) map.get("playbackState"));
        if (i4 < 0 || i4 > 3) {
            i4 = 0;
        }
        String str = (String) map.get("aspectRatio");
        float f5 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (com.google.android.gms.ads.internal.util.client.zzo.j(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(f4).length() + 45 + String.valueOf(f3).length() + 13 + String.valueOf(zEquals).length() + 19 + String.valueOf(i4).length() + 17 + String.valueOf(str).length());
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(f4);
            sb.append(" , duration : ");
            sb.append(f3);
            sb.append(" , isMuted : ");
            sb.append(zEquals);
            sb.append(" , playbackState : ");
            sb.append(i4);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        }
        zzcmaVarZzh.zzs(f4, f3, i4, zEquals, f5);
    }
}
