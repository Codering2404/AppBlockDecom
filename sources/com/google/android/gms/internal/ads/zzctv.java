package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzctv implements zzdcr, zzdef, zzddl, com.google.android.gms.ads.internal.client.zza, zzddh, zzdkp, zzdfm {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfkq zze;
    private final zzfkf zzf;
    private final zzfry zzg;
    private final zzfll zzh;
    private final zzbap zzi;
    private final zzbjx zzj;
    private final WeakReference zzk;
    private final WeakReference zzl;
    private final zzdbu zzm;
    private final zzdfg zzn;
    private final zzdbn zzo;
    private final Set zzp;
    private boolean zzq;
    private final AtomicBoolean zzr = new AtomicBoolean();
    private zzcfe zzs = null;

    zzctv(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfkq zzfkqVar, zzfkf zzfkfVar, zzfry zzfryVar, zzfll zzfllVar, View view, zzcku zzckuVar, zzbap zzbapVar, zzbjx zzbjxVar, zzbjz zzbjzVar, zzfqg zzfqgVar, zzdbu zzdbuVar, zzdfg zzdfgVar, zzdbn zzdbnVar, Set set) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfkqVar;
        this.zzf = zzfkfVar;
        this.zzg = zzfryVar;
        this.zzh = zzfllVar;
        this.zzi = zzbapVar;
        this.zzk = new WeakReference(view);
        this.zzl = new WeakReference(zzckuVar);
        this.zzj = zzbjxVar;
        this.zzm = zzdbuVar;
        this.zzn = zzdfgVar;
        this.zzo = zzdbnVar;
        this.zzp = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final List zzp() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmO)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.g();
            Context context = this.zza;
            if (com.google.android.gms.ads.internal.util.zzs.e(context)) {
                com.google.android.gms.ads.internal.zzt.g();
                Integer numF0 = com.google.android.gms.ads.internal.util.zzs.f0(context);
                if (numF0 != null) {
                    int iMin = Math.min(numF0.intValue(), 20);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.zzf.zzd.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse((String) it.next()).buildUpon().appendQueryParameter("dspct", Integer.toString(iMin)).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    private final void zzy(final int i3, final int i4) {
        View view;
        if (i3 <= 0 || !((view = (View) this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzo();
        } else {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(i3, i4);
                }
            }, i4, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final void zzo() {
        String strZzj;
        int i3;
        zzfkf zzfkfVar = this.zzf;
        List list = zzfkfVar.zzd;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpk)).booleanValue() && this.zzs == null) {
            this.zzs = com.google.android.gms.ads.internal.zzt.l().zzr().zzm(this.zzp, this.zze.zza.zza.zzg);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzet)).booleanValue()) {
            strZzj = this.zzi.zzb().zzj(this.zza, (View) this.zzk.get(), null);
        } else {
            strZzj = null;
        }
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbd)).booleanValue() && this.zze.zzb.zzb.zzh) || !((Boolean) zzbkp.zzh.zze()).booleanValue()) {
            this.zzh.zza(this.zzg.zzb(this.zze, zzfkfVar, false, strZzj, null, zzp(), this.zzo, this.zzs), this.zzn);
            return;
        }
        if (((Boolean) zzbkp.zzg.zze()).booleanValue() && ((i3 = zzfkfVar.zzb) == 1 || i3 == 2 || i3 == 5)) {
        }
        zzhbw.zzr((zzhbo) zzhbw.zzi(zzhbo.zzw(zzhbw.zza(null)), ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbH)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzctp(this, strZzj), this.zzb);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (!(((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbd)).booleanValue() && this.zze.zzb.zzb.zzh) && ((Boolean) zzbkp.zzd.zze()).booleanValue()) {
            zzhbw.zzr((zzhbo) zzhbw.zzg(zzhbo.zzw(this.zzj.zzb()), Throwable.class, zzctu.zza, zzcfr.zzh), new zzcto(this), this.zzb);
            return;
        }
        zzfll zzfllVar = this.zzh;
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zzb(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzc), true == com.google.android.gms.ads.internal.zzt.l().zzs(this.zza) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
        zzfry zzfryVar = this.zzg;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zzc(zzfkfVar, zzfkfVar.zzh, zzcbpVar), null);
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        if (this.zzr.compareAndSet(false, true)) {
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeC)).intValue();
            if (iIntValue > 0) {
                zzy(iIntValue, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeD)).intValue());
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeB)).booleanValue()) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctq
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzl();
                    }
                });
            } else {
                zzo();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzg), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzi), null);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final synchronized void zzg() {
        zzdbu zzdbuVar;
        try {
            if (this.zzq) {
                ArrayList arrayList = new ArrayList(zzp());
                zzfkf zzfkfVar = this.zzf;
                arrayList.addAll(zzfkfVar.zzf);
                this.zzh.zza(this.zzg.zzb(this.zze, zzfkfVar, true, null, null, arrayList, null, null), null);
            } else {
                zzfll zzfllVar = this.zzh;
                zzfry zzfryVar = this.zzg;
                zzfkq zzfkqVar = this.zze;
                zzfkf zzfkfVar2 = this.zzf;
                zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar2, zzfkfVar2.zzm), null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzey)).booleanValue() && (zzdbuVar = this.zzm) != null) {
                    List list = zzdbuVar.zzb().zzm;
                    String strZzg = zzdbuVar.zzc().zzg();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(zzfry.zzd((String) it.next(), "@gw_adnetstatus@", strZzg));
                    }
                    long jZzh = zzdbuVar.zzc().zzh();
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        arrayList3.add(zzfry.zzd((String) obj, "@gw_ttr@", Long.toString(jZzh, 10)));
                    }
                    zzfllVar.zza(zzfryVar.zza(zzdbuVar.zza(), zzdbuVar.zzb(), arrayList3), null);
                }
                zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar2, zzfkfVar2.zzf), null);
            }
            this.zzq = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkp
    public final void zzi() {
        zzfry zzfryVar = this.zzg;
        zzfkq zzfkqVar = this.zze;
        zzfll zzfllVar = this.zzh;
        zzfkf zzfkfVar = this.zzf;
        zzfllVar.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzau), null);
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcg)).booleanValue()) {
            int i3 = zzeVar.f69851a;
            zzfkf zzfkfVar = this.zzf;
            ArrayList arrayList = new ArrayList();
            for (String str : zzfkfVar.zzo) {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 2);
                sb.append("2.");
                sb.append(i3);
                arrayList.add(zzfry.zzd(str, "@gw_mpe@", sb.toString()));
            }
            this.zzh.zza(this.zzg.zza(this.zze, zzfkfVar, arrayList), null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzk() {
        zzfkf zzfkfVar = this.zzf;
        if (zzfkfVar.zze == 4) {
            this.zzh.zza(this.zzg.zza(this.zze, zzfkfVar, zzfkfVar.zzaA), null);
        }
    }

    final /* synthetic */ void zzl() {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzo();
            }
        });
    }

    final /* synthetic */ void zzm(final int i3, final int i4) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcts
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzn(i3, i4);
            }
        });
    }

    final /* synthetic */ void zzn(int i3, int i4) {
        zzy(i3 - 1, i4);
    }

    final /* synthetic */ Context zzq() {
        return this.zza;
    }

    final /* synthetic */ zzfkq zzr() {
        return this.zze;
    }

    final /* synthetic */ zzfkf zzs() {
        return this.zzf;
    }

    final /* synthetic */ zzfry zzt() {
        return this.zzg;
    }

    final /* synthetic */ zzfll zzu() {
        return this.zzh;
    }

    final /* synthetic */ zzdfg zzv() {
        return this.zzn;
    }

    final /* synthetic */ zzdbn zzw() {
        return this.zzo;
    }

    final /* synthetic */ zzcfe zzx() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
    }
}
