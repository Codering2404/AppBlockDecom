package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzckc extends zzche implements zzin, zznp {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcjm zzc;
    private final zzaay zzd;
    private final zzchm zze;
    private final WeakReference zzf;
    private final zzyt zzg;
    private zzjv zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzchd zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcjp zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzckc(android.content.Context r4, com.google.android.gms.internal.ads.zzchm r5, com.google.android.gms.internal.ads.zzchn r6, java.lang.Integer r7) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckc.<init>(android.content.Context, com.google.android.gms.internal.ads.zzchm, com.google.android.gms.internal.ads.zzchn, java.lang.Integer):void");
    }

    private final boolean zzY() {
        return this.zzt != null && this.zzt.zzl();
    }

    public final void finalize() {
        zzche.zzf().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            com.google.android.gms.ads.internal.util.zze.k("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzA(int i3) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcjl zzcjlVar = (zzcjl) ((WeakReference) it.next()).get();
            if (zzcjlVar != null) {
                zzcjlVar.zzk(i3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final boolean zzB() {
        return this.zzh != null;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final int zzC() {
        return this.zzh.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzD() {
        return this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzE(boolean z2) {
        this.zzh.zzj(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzF(int i3) {
        this.zzc.zzk(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzG(int i3) {
        this.zzc.zzl(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzH() {
        return this.zzh.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzI() {
        if (zzY()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzJ() {
        if (zzY() && this.zzt.zzm()) {
            return Math.min(this.zzl, this.zzt.zzo());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzK() {
        if (zzY()) {
            return this.zzt.zzp();
        }
        synchronized (this.zzq) {
            while (true) {
                ArrayList arrayList = this.zzs;
                if (!arrayList.isEmpty()) {
                    long j3 = this.zzn;
                    Map mapZzj = ((zzii) arrayList.remove(0)).zzj();
                    long j4 = 0;
                    if (mapZzj != null) {
                        Iterator it = mapZzj.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzgss.zze("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j4 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j3 + j4;
                }
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final int zzL() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzM(boolean z2) {
        if (this.zzh == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            this.zzh.zzF();
            if (i3 >= 2) {
                return;
            }
            zzaay zzaayVar = this.zzd;
            zzaal zzaalVarZzd = zzaayVar.zzc().zzd();
            zzaalVarZzd.zzy(i3, !z2);
            zzaayVar.zzf(zzaalVarZzd);
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzN() {
        return this.zzh.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzO() {
        return this.zzl;
    }

    final zzxm zzR(Uri uri) {
        zzz zzzVar = new zzz();
        zzzVar.zzb(uri);
        zzak zzakVarZzc = zzzVar.zzc();
        zzyt zzytVar = this.zzg;
        zzytVar.zza(this.zze.zzf);
        return zzytVar.zzb(zzakVarZzc);
    }

    final /* synthetic */ zzhp zzS(String str, boolean z2) {
        zzckc zzckcVar = true != z2 ? null : this;
        zzchm zzchmVar = this.zze;
        return new zzckf(str, zzckcVar, zzchmVar.zzd, zzchmVar.zze, zzchmVar.zzm, zzchmVar.zzn);
    }

    final /* synthetic */ zzhp zzT(String str, boolean z2) {
        zzhw zzhwVar = new zzhw();
        zzhwVar.zzb(str);
        zzhwVar.zzf(true != z2 ? null : this);
        zzchm zzchmVar = this.zze;
        zzhwVar.zzc(zzchmVar.zzd);
        zzhwVar.zzd(zzchmVar.zze);
        zzhwVar.zze(true);
        return zzhwVar.zza();
    }

    final /* synthetic */ zzhp zzU(String str, boolean z2) {
        zzckc zzckcVar = true != z2 ? null : this;
        zzchm zzchmVar = this.zze;
        zzcjl zzcjlVar = new zzcjl(str, zzckcVar, zzchmVar.zzd, zzchmVar.zze, zzchmVar.zzh);
        this.zzu.add(new WeakReference(zzcjlVar));
        return zzcjlVar;
    }

    final /* synthetic */ zzhp zzV(zzho zzhoVar) {
        zzhp zzhpVarZza = zzhoVar.zza();
        zzcjn zzcjnVar = new zzcjn() { // from class: com.google.android.gms.internal.ads.zzcka
            @Override // com.google.android.gms.internal.ads.zzcjn
            public final /* synthetic */ void zza(boolean z2, long j3) {
                this.zza.zzX(z2, j3);
            }
        };
        return new zzcjp(this.zzb, zzhpVarZza, this.zzo, this.zzp, this, zzcjnVar);
    }

    final /* synthetic */ zzna[] zzW(Handler handler, zzaep zzaepVar, zzrv zzrvVar, zzzq zzzqVar, zzwi zzwiVar) {
        zzvv zzvvVar = zzvv.zzb;
        Context context = this.zzb;
        zztx zztxVar = new zztx(context, new zzvb(context, null, null), zzvvVar, false, handler, zzrvVar, new zztk(context).zza());
        zzadc zzadcVar = new zzadc(context);
        zzadcVar.zza(zzvvVar);
        zzadcVar.zzb(handler);
        zzadcVar.zzc(zzaepVar);
        return new zzna[]{zztxVar, zzadcVar.zzd()};
    }

    final /* synthetic */ void zzX(boolean z2, long j3) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzr(z2, j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zza(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzb(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
        if (zzhpVar instanceof zzii) {
            synchronized (this.zzq) {
                this.zzs.add((zzii) zzhpVar);
            }
        } else if (zzhpVar instanceof zzcjp) {
            this.zzt = (zzcjp) zzhpVar;
            final zzchn zzchnVar = (zzchn) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue() && zzchnVar != null && this.zzt.zzk()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzm()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzn()));
                com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        int i3 = zzckc.zza;
                        zzchnVar.zze("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzc(zzhp zzhpVar, zzht zzhtVar, boolean z2, int i3) {
        this.zzl += i3;
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzd(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zze(zznn zznnVar, int i3) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzs(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzg(zznn zznnVar, zzau zzauVar) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzu("onPlayerError", zzauVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzh(zznn zznnVar, zzxb zzxbVar, zzxg zzxgVar, IOException iOException, boolean z2) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            if (this.zze.zzj) {
                zzchdVar.zzv("onLoadException", iOException);
            } else {
                zzchdVar.zzu("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final Integer zzj() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzk(zznn zznnVar, zzv zzvVar, zzjc zzjcVar) {
        zzchn zzchnVar = (zzchn) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue() || zzchnVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzvVar.zzo;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzvVar.zzp;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzchnVar.zze("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzm(zznn zznnVar, int i3, long j3) {
        this.zzm += i3;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzn(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzo(zznn zznnVar, Object obj, long j3) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzD();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzp(zznn zznnVar, zzbv zzbvVar) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzt(zzbvVar.zzb, zzbvVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzq(Uri[] uriArr, String str) {
        zzr(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzr(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z2) {
        zzxm zzybVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z2;
            int length = uriArr.length;
            if (length == 1) {
                zzybVar = zzR(uriArr[0]);
            } else {
                zzxm[] zzxmVarArr = new zzxm[length];
                for (int i3 = 0; i3 < uriArr.length; i3++) {
                    zzxmVarArr[i3] = zzR(uriArr[i3]);
                }
                zzybVar = new zzyb(false, false, new zzwv(), zzxmVarArr);
            }
            this.zzh.zzG(zzybVar);
            this.zzh.zzg();
            zzche.zzi().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzs(zzchd zzchdVar) {
        this.zzk = zzchdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzt() {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzE(this);
            this.zzh.zzH();
            this.zzh = null;
            zzche.zzi().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzu(Surface surface, boolean z2) {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzC(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzv(float f3, boolean z2) {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzB(f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzw() {
        this.zzh.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzx(long j3) {
        this.zzh.zzb(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzy(int i3) {
        this.zzc.zzm(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzz(int i3) {
        this.zzc.zzn(i3);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzl(zznn zznnVar, zzv zzvVar, zzjc zzjcVar) {
        zzchn zzchnVar = (zzchn) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcB)).booleanValue() || zzchnVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzvVar.zzA));
        map.put("bitRate", String.valueOf(zzvVar.zzj));
        int i3 = zzvVar.zzw;
        int i4 = zzvVar.zzx;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(i4).length());
        sb.append(i3);
        sb.append("x");
        sb.append(i4);
        map.put(KrzujOtzIk.ZYhFLrmOcrb, sb.toString());
        String str = zzvVar.zzo;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzvVar.zzp;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzchnVar.zze("onMetadataEvent", map);
    }
}
