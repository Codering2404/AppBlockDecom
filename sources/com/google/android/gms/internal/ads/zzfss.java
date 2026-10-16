package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfss {
    private final Map zza;
    private final zzfuc zzb;
    private final zzftd zzc;
    private final Context zzd;
    private volatile ConnectivityManager zze;
    private final AtomicBoolean zzf = new AtomicBoolean(false);
    private final Clock zzg;
    private AtomicInteger zzh;
    private final zzfsn zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;

    zzfss(zzfuc zzfucVar, zzftd zzftdVar, Context context, Clock clock, zzfsn zzfsnVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        HashMap map = new HashMap();
        this.zza = map;
        map.put(AdFormat.APP_OPEN_AD, new HashMap());
        map.put(AdFormat.INTERSTITIAL, new HashMap());
        map.put(AdFormat.REWARDED, new HashMap());
        this.zzb = zzfucVar;
        this.zzc = zzftdVar;
        this.zzd = context;
        this.zzg = clock;
        this.zzi = zzfsnVar;
        this.zzj = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzl(boolean z2) {
        ArrayList arrayList = new ArrayList();
        Map map = this.zza;
        synchronized (map) {
            try {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((Map) it.next()).values());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzfub zzfubVar = (zzfub) arrayList.get(i3);
            if (z2) {
                zzfubVar.zzj();
            } else {
                zzfubVar.zzi();
            }
        }
    }

    private final Object zzn(Class cls, AdFormat adFormat, String str) {
        zzftd zzftdVar = this.zzc;
        Clock clock = this.zzg;
        zzftdVar.zze(clock.currentTimeMillis(), "2");
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return null;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                if (zzfubVar != null && adFormat.equals(zzfubVar.zzq())) {
                    zzftj zzftjVar = new zzftj(zzfubVar.zzr(), zzfubVar.zzq());
                    zzftjVar.zza(str);
                    zzftk zzftkVar = new zzftk(zzftjVar, null);
                    zzftdVar.zzf(clock.currentTimeMillis(), zzftkVar, zzfubVar.zzs(), zzfubVar.zzt(), "2");
                    try {
                        String strZzl = zzfubVar.zzl();
                        Object objZzg = zzfubVar.zzg();
                        Object objCast = objZzg == null ? null : cls.cast(objZzg);
                        if (objCast == null) {
                            return objCast;
                        }
                        zzftdVar.zzh(clock.currentTimeMillis(), zzfubVar.zzs(), zzfubVar.zzt(), strZzl, zzftkVar, "2");
                        return objCast;
                    } catch (ClassCastException e3) {
                        com.google.android.gms.ads.internal.zzt.l().zzg(e3, "PreloadAdManager.pollAd");
                        com.google.android.gms.ads.internal.util.zze.l("Unable to cast ad to the requested type:".concat(cls.getName()), e3);
                    }
                }
                return null;
            } finally {
            }
        }
    }

    private final boolean zzo(AdFormat adFormat) {
        Map map = this.zza;
        int size = map.containsKey(adFormat) ? ((Map) map.get(adFormat)).size() : 0;
        int iOrdinal = adFormat.ordinal();
        return size < (iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 5 ? 0 : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfv)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfu)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzft)).intValue(), 1));
    }

    public final boolean zza(String str, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        int iZzT;
        if (!this.zzf.getAndSet(true)) {
            if (this.zze == null) {
                synchronized (this) {
                    if (this.zze == null) {
                        try {
                            this.zze = (ConnectivityManager) this.zzd.getSystemService("connectivity");
                        } catch (ClassCastException e3) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to get connectivity manager", e3);
                        }
                    }
                }
            }
            if (!PlatformVersion.e() || this.zze == null) {
                this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzH)).intValue());
            } else {
                try {
                    this.zze.registerDefaultNetworkCallback(new zzfsq(this));
                } catch (RuntimeException e4) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("Failed to register network callback", e4);
                    this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzH)).intValue());
                }
            }
            com.google.android.gms.ads.internal.zzt.k().zzb(new zzfsr(this));
        }
        AdFormat adFormatA = AdFormat.a(zzfpVar.f69948b);
        if (adFormatA == null) {
            return false;
        }
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormatA)) {
                    if (!((Map) map.get(adFormatA)).containsKey(str)) {
                        if (zzo(adFormatA)) {
                            if (zzfpVar.f69951f) {
                                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzO)).booleanValue() && (iZzT = this.zzj.zzT()) > 0) {
                                    zzfpVar = zzfpVar.M(iZzT);
                                }
                            }
                            zzfub zzfubVarZzb = this.zzb.zzb(str, zzfpVar, zzceVar);
                            if (zzfubVarZzb != null) {
                                AtomicInteger atomicInteger = this.zzh;
                                if (atomicInteger != null) {
                                    zzfubVarZzb.zzn(atomicInteger.get());
                                }
                                zzftd zzftdVar = this.zzc;
                                zzfubVarZzb.zzm(zzftdVar);
                                synchronized (map) {
                                    if (!((Map) map.get(adFormatA)).containsKey(str) && zzo(adFormatA)) {
                                        ((Map) map.get(adFormatA)).put(str, zzfubVarZzb);
                                        zzfsn zzfsnVar = this.zzi;
                                        if (zzfsnVar != null) {
                                            zzfsnVar.zze(str, adFormatA, zzfubVarZzb);
                                        } else {
                                            zzfubVarZzb.zzd();
                                        }
                                        zzftj zzftjVar = new zzftj(zzfpVar.f69947a, adFormatA);
                                        zzftjVar.zza(str);
                                        zzftdVar.zza(zzfpVar.f69950d, this.zzg.currentTimeMillis(), new zzftk(zzftjVar, null), "2");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
        return false;
    }

    public final boolean zzb(AdFormat adFormat, String str) {
        zzftk zzftkVar;
        Clock clock = this.zzg;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return false;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                String strZzl = zzfubVar == null ? null : zzfubVar.zzl();
                boolean z2 = strZzl != null && adFormat.equals(zzfubVar.zzq());
                Long lValueOf = z2 ? Long.valueOf(clock.currentTimeMillis()) : null;
                if (zzfubVar == null) {
                    zzftkVar = null;
                } else {
                    zzftj zzftjVar = new zzftj(zzfubVar.zzr(), adFormat);
                    zzftjVar.zza(str);
                    zzftkVar = new zzftk(zzftjVar, null);
                }
                this.zzc.zzd(zzfubVar == null ? 0 : zzfubVar.zzs(), zzfubVar != null ? zzfubVar.zzt() : 0, jCurrentTimeMillis, lValueOf, strZzl, zzftkVar, "2");
                return z2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzcci zzc(String str) {
        return (zzcci) zzn(zzcci.class, AdFormat.REWARDED, str);
    }

    public final zzbgj zzd(String str) {
        return (zzbgj) zzn(zzbgj.class, AdFormat.APP_OPEN_AD, str);
    }

    public final com.google.android.gms.ads.internal.client.zzbu zze(String str) {
        return (com.google.android.gms.ads.internal.client.zzbu) zzn(com.google.android.gms.ads.internal.client.zzbu.class, AdFormat.INTERSTITIAL, str);
    }

    public final com.google.android.gms.ads.internal.client.zzfp zzf(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormat)) {
                    zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                    this.zzc.zzo(this.zzg.currentTimeMillis(), str, zzfubVar == null ? null : zzfubVar.zzr(), adFormat, zzfubVar == null ? -1 : zzfubVar.zzs(), zzfubVar != null ? zzfubVar.zzt() : -1);
                    if (zzfubVar != null) {
                        return zzfubVar.zzo();
                    }
                }
            } finally {
            }
        }
        return null;
    }

    public final int zzg(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return 0;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).get(str);
                int iZzt = zzfubVar != null ? zzfubVar.zzt() : 0;
                this.zzc.zzp(iZzt, this.zzg.currentTimeMillis(), str, zzfubVar == null ? null : zzfubVar.zzr(), adFormat, zzfubVar == null ? -1 : zzfubVar.zzs());
                return iZzt;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map zzh(int i3) {
        HashMap map = new HashMap();
        Map map2 = this.zza;
        AdFormat adFormatA = AdFormat.a(i3);
        synchronized (map2) {
            if (adFormatA != null) {
                try {
                    if (map2.containsKey(adFormatA)) {
                        for (zzfub zzfubVar : ((Map) map2.get(adFormatA)).values()) {
                            map.put(zzfubVar.zzp(), zzfubVar.zzo());
                        }
                        this.zzc.zzn(adFormatA, this.zzg.currentTimeMillis(), map.size());
                        return map;
                    }
                } finally {
                }
            }
            return map;
        }
    }

    public final boolean zzi(AdFormat adFormat, String str) {
        Map map = this.zza;
        synchronized (map) {
            try {
                if (!map.containsKey(adFormat)) {
                    return false;
                }
                zzfub zzfubVar = (zzfub) ((Map) map.get(adFormat)).remove(str);
                if (zzfubVar == null) {
                    return false;
                }
                zzfubVar.zzh();
                zzfsn zzfsnVar = this.zzi;
                if (zzfsnVar != null) {
                    zzfsnVar.zzf(zzfubVar);
                }
                int iZzt = zzfubVar.zzt();
                zzfubVar.zzv();
                this.zzc.zzm(this.zzg.currentTimeMillis(), str, zzfubVar.zzr(), adFormat, zzfubVar.zzs(), iZzt);
                return true;
            } finally {
            }
        }
    }

    public final void zzj(int i3) {
        AdFormat adFormatA = AdFormat.a(i3);
        if (adFormatA == null) {
            return;
        }
        Map map = this.zza;
        synchronized (map) {
            try {
                if (map.containsKey(adFormatA)) {
                    Map map2 = (Map) map.get(adFormatA);
                    int size = map2.size();
                    if (size == 0) {
                        return;
                    }
                    zzgwm zzgwmVarZzq = zzgwm.zzq(map2.values());
                    map2.clear();
                    int size2 = zzgwmVarZzq.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        zzfub zzfubVar = (zzfub) zzgwmVarZzq.get(i4);
                        if (zzfubVar != null) {
                            zzfubVar.zzh();
                            zzfsn zzfsnVar = this.zzi;
                            if (zzfsnVar != null) {
                                zzfsnVar.zzf(zzfubVar);
                            }
                            zzfubVar.zzv();
                            String strValueOf = String.valueOf(zzfubVar.zzp());
                            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.e("Destroyed ad preloader for preloadId: ".concat(strValueOf));
                        }
                    }
                    String strConcat = "Destroyed all ad preloaders for ad format: ".concat(adFormatA.toString());
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.e(strConcat);
                    this.zzc.zzl(this.zzg.currentTimeMillis(), adFormatA, size);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void zzk(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzy)).booleanValue()) {
            zzl(z2);
        }
    }
}
