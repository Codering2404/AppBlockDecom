package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjg implements zzly {
    public static final zzgwm zza = zzgwm.zzn("file", AppLovinEventTypes.USER_VIEWED_CONTENT, "data", "android.resource", "rawresource", "asset");
    private final zzbe zzb;
    private final zzbd zzc;
    private final zzabr zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;
    private final long zzk;
    private final long zzl;
    private final long zzm;
    private final zzgwp zzn;
    private final ConcurrentHashMap zzo;
    private long zzp;

    public zzjg() {
        zzabr zzabrVar = new zzabr(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        zzgwp zzgwpVarZza = zzgwp.zza();
        zzq(1000, 0, "bufferForPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzq(1000, 0, "bufferForPlaybackForLocalPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzq(AdError.SERVER_ERROR_CODE, 0, "bufferForPlaybackAfterRebufferMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzq(1000, 0, "bufferForPlaybackAfterRebufferForLocalPlaybackMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zzq(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        zzq(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackForLocalPlaybackMs");
        zzq(50000, AdError.SERVER_ERROR_CODE, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzq(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackAfterRebufferForLocalPlaybackMs");
        zzq(50000, 50000, "maxBufferMs", "minBufferMs");
        zzq(50000, 1000, "maxBufferForLocalPlaybackMs", "minBufferForLocalPlaybackMs");
        zzq(0, 0, "backBufferDurationMs", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzb = new zzbe();
        this.zzc = new zzbd();
        this.zzd = zzabrVar;
        this.zze = zzfl.zzs(50000L);
        this.zzf = zzfl.zzs(1000L);
        this.zzg = zzfl.zzs(50000L);
        this.zzh = zzfl.zzs(50000L);
        this.zzi = zzfl.zzs(1000L);
        this.zzj = zzfl.zzs(1000L);
        this.zzk = zzfl.zzs(2000L);
        this.zzl = zzfl.zzs(1000L);
        this.zzm = zzfl.zzs(0L);
        this.zzo = new ConcurrentHashMap();
        this.zzn = zzgwp.zzc(zzgwpVarZza);
        this.zzp = -1L;
    }

    private final int zzm(zzqf zzqfVar) {
        Integer num = (Integer) this.zzn.get(zzqfVar.zzb);
        if (num == null || num.intValue() == -1) {
            return -1;
        }
        return num.intValue();
    }

    private final void zzn(zzqf zzqfVar) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzjf zzjfVar = (zzjf) concurrentHashMap.get(zzqfVar);
        if (zzjfVar != null) {
            int i3 = zzjfVar.zza - 1;
            zzjfVar.zza = i3;
            if (i3 == 0) {
                concurrentHashMap.remove(zzqfVar);
                zzo();
            }
        }
    }

    private final void zzo() {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        if (concurrentHashMap.isEmpty()) {
            this.zzd.zze();
            return;
        }
        zzabr zzabrVar = this.zzd;
        Iterator it = concurrentHashMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((zzjf) it.next()).zzc;
        }
        zzabrVar.zzf(i3);
    }

    private final boolean zzp(zzlx zzlxVar) {
        zzbf zzbfVar = zzlxVar.zzb;
        zzag zzagVar = zzbfVar.zzb(zzbfVar.zzo(zzlxVar.zzc.zza, this.zzc).zzc, this.zzb, 0L).zzd.zzb;
        if (zzagVar == null) {
            return false;
        }
        String scheme = zzagVar.zza.getScheme();
        return TextUtils.isEmpty(scheme) || zza.contains(scheme);
    }

    private static void zzq(int i3, int i4, String str, String str2) {
        zzgtj.zzh(i3 >= i4, "%s cannot be less than %s", str, str2);
    }

    private final int zzr(zzqf zzqfVar) {
        zzjf zzjfVar = (zzjf) this.zzo.get(zzqfVar);
        zzjfVar.getClass();
        return zzjfVar.zzc() * NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private final int zzs(zzqf zzqfVar) {
        zzjf zzjfVar = (zzjf) this.zzo.get(zzqfVar);
        zzjfVar.getClass();
        return zzjfVar.zzc;
    }

    private static final boolean zzt(boolean z2) {
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zza(zzqf zzqfVar) {
        long id = Thread.currentThread().getId();
        long j3 = this.zzp;
        zzgtj.zzj(j3 == -1 || j3 == id, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzp = id;
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzjf zzjfVar = (zzjf) concurrentHashMap.get(zzqfVar);
        if (zzjfVar == null) {
            concurrentHashMap.put(zzqfVar, new zzjf());
        } else {
            zzjfVar.zza++;
        }
        zzjf zzjfVar2 = (zzjf) concurrentHashMap.get(zzqfVar);
        zzjfVar2.getClass();
        int iZzm = zzm(zzqfVar);
        if (iZzm == -1) {
            iZzm = 13107200;
        }
        zzjfVar2.zzc = iZzm;
        zzjfVar2.zzb = false;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzb(zzlx zzlxVar, zzzn zzznVar, zzaba[] zzabaVarArr) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzqf zzqfVar = zzlxVar.zza;
        int iZzm = zzm(zzqfVar);
        zzjf zzjfVar = (zzjf) concurrentHashMap.get(zzqfVar);
        zzjfVar.getClass();
        if (iZzm == -1) {
            boolean zZzp = zzp(zzlxVar);
            int length = zzabaVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = 13107200;
                if (i3 < length) {
                    zzaba zzabaVar = zzabaVarArr[i3];
                    if (zzabaVar != null) {
                        switch (zzabaVar.zza().zzc) {
                            case -1:
                            case 1:
                                break;
                            case 0:
                                i5 = 144310272;
                                break;
                            case 2:
                                i5 = !zZzp ? 131072000 : 19660800;
                                break;
                            case 3:
                            case 5:
                            default:
                                i5 = 131072;
                                break;
                            case 4:
                                i5 = 26214400;
                                break;
                        }
                        i4 += i5;
                    }
                    i3++;
                } else {
                    String str = zzfl.zza;
                    iZzm = Math.max(13107200, Math.min(i4, 210239488));
                }
            }
        }
        zzjfVar.zzc = iZzm;
        zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzc(zzqf zzqfVar) {
        zzn(zzqfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzd(zzqf zzqfVar) {
        zzn(zzqfVar);
        if (this.zzo.isEmpty()) {
            this.zzp = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final zzabl zze(zzqf zzqfVar) {
        return new zzje(this, zzqfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final long zzf(zzqf zzqfVar) {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzg(zzqf zzqfVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzh(zzlx zzlxVar) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzqf zzqfVar = zzlxVar.zza;
        zzjf zzjfVar = (zzjf) concurrentHashMap.get(zzqfVar);
        zzjfVar.getClass();
        int iZzr = zzr(zzqfVar);
        int iZzs = zzs(zzqfVar);
        boolean z2 = false;
        if (zzqfVar.equals(zzqf.zza)) {
            return iZzr < iZzs;
        }
        boolean zZzp = zzp(zzlxVar);
        long jMin = zZzp ? this.zzf : this.zze;
        long j3 = zZzp ? this.zzh : this.zzg;
        float f3 = zzlxVar.zzf;
        if (f3 > 1.0f) {
            jMin = Math.min(zzfl.zzx(jMin, f3), j3);
        }
        long j4 = zzlxVar.zze;
        if (j4 < Math.max(jMin, 500000L)) {
            boolean zZzt = zzt(zZzp);
            Runtime runtime = Runtime.getRuntime();
            long jMaxMemory = runtime.maxMemory();
            boolean z3 = runtime.totalMemory() < jMaxMemory || runtime.freeMemory() + ((long) this.zzd.zzh()) >= jMaxMemory / 25;
            if (!zZzt ? iZzr < iZzs : !(!z3 && iZzr >= iZzs)) {
                z2 = true;
            }
            zzjfVar.zzb = z2;
            if (!z2 && zZzt && !z3) {
                zzeg.zzb("DefaultLoadControl", "Stopped loading before minBufferUs reached due to memory pressure, despite prioritizeTimeOverSizeThresholds=true.");
            }
            if (!zzjfVar.zzb && j4 < 500000) {
                zzeg.zzc("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j4 >= j3 || iZzr >= iZzs) {
            zzjfVar.zzb = false;
        }
        return zzjfVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzi(zzlx zzlxVar) {
        long jMin;
        boolean z2;
        boolean z3 = zzlxVar.zzg;
        long j3 = zzlxVar.zze;
        float f3 = zzlxVar.zzf;
        boolean zZzp = zzp(zzlxVar);
        long jZzy = zzfl.zzy(j3, f3);
        if (z3) {
            if (zZzp) {
                jMin = this.zzl;
                z2 = true;
            } else {
                jMin = this.zzk;
                z2 = false;
            }
        } else if (zZzp) {
            jMin = this.zzj;
            z2 = true;
        } else {
            jMin = this.zzi;
            z2 = false;
        }
        long j4 = zzlxVar.zzh;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(j4 / 2, jMin);
        }
        if (jMin <= 0 || jZzy >= jMin) {
            return true;
        }
        if (!zzt(z2)) {
            zzqf zzqfVar = zzlxVar.zza;
            if (zzr(zzqfVar) >= zzs(zzqfVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzj(zzqf zzqfVar, zzbf zzbfVar, zzxk zzxkVar, long j3) {
        Iterator it = this.zzo.values().iterator();
        while (it.hasNext()) {
            if (((zzjf) it.next()).zzb) {
                return false;
            }
        }
        return true;
    }

    final /* synthetic */ zzabr zzk() {
        return this.zzd;
    }

    final /* synthetic */ ConcurrentHashMap zzl() {
        return this.zzo;
    }
}
