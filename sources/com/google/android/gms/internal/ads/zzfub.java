package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfub {
    protected final ClientApi zza;
    protected final Context zzb;
    protected final int zzc;
    protected final zzflu zzd;
    protected AtomicReference zze;
    protected final zzfsn zzf;
    protected AtomicBoolean zzg;
    protected com.google.android.gms.ads.internal.client.zzce zzh;
    protected final ScheduledExecutorService zzi;
    private com.google.android.gms.ads.internal.client.zzcb zzj;
    private final Queue zzk;
    private final zzfsw zzl;
    private final String zzm;
    private AtomicBoolean zzn;
    private final zzfoo zzo;
    private AtomicBoolean zzp;
    private AtomicBoolean zzq;
    private zzftd zzr;
    private final Clock zzs;
    private final zzftk zzt;

    public zzfub(ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock) {
        this(IntegrityManager.INTEGRITY_TYPE_NONE, clientApi, context, i3, zzfluVar, zzfpVar, scheduledExecutorService, zzfooVar, zzfswVar, clock, null);
        this.zzj = zzcbVar;
    }

    private final boolean zzR() {
        boolean zIsEmpty;
        Queue queue = this.zzk;
        synchronized (queue) {
            zIsEmpty = queue.isEmpty();
        }
        return zIsEmpty;
    }

    private final void zzS(boolean z2) {
        zzfsn zzfsnVar = this.zzf;
        if (zzfsnVar != null) {
            if (z2) {
                this.zzl.zzc();
            }
            zzfsnVar.zza(this);
        } else {
            zzfsw zzfswVar = this.zzl;
            if (zzfswVar.zze()) {
                return;
            }
            if (z2) {
                zzfswVar.zzc();
            }
            this.zzi.schedule(new zzftp(this), zzfswVar.zzb(), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzT, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzF() {
        int i3;
        int i4;
        Queue queue = this.zzk;
        synchronized (queue) {
            try {
                Iterator it = queue.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (((zzftm) it.next()).zzb()) {
                        it.remove();
                        i3++;
                    }
                }
                i4 = (i3 <= 0 || !queue.isEmpty()) ? i3 : i3 - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
        zzfsn zzfsnVar = this.zzf;
        if (zzfsnVar == null || i3 <= 0) {
            return;
        }
        zzfsnVar.zzd(this, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzU, reason: merged with bridge method [inline-methods] */
    public final String zzM() {
        return true != IntegrityManager.INTEGRITY_TYPE_NONE.equals(this.zzm) ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzV(com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        if (zzdxVar instanceof zzdck) {
            return ((zzdck) zzdxVar).zzk();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzA(final int r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 <= 0) goto L6
            r2 = r0
            goto L7
        L6:
            r2 = r1
        L7:
            com.google.android.gms.common.internal.Preconditions.a(r2)
            java.util.concurrent.atomic.AtomicReference r2 = r10.zze
            com.google.android.gms.internal.ads.zzftw r3 = new com.google.android.gms.internal.ads.zzftw
            r3.<init>()
            java.lang.Object r2 = r2.getAndUpdate(r3)
            com.google.android.gms.ads.internal.client.zzfp r2 = (com.google.android.gms.ads.internal.client.zzfp) r2
            int r3 = r2.f69948b
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.a(r3)
            int r5 = r2.f69950d
            java.util.Queue r2 = r10.zzk
            monitor-enter(r2)
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L51
            int r6 = r2.size()     // Catch: java.lang.Throwable -> L51
            if (r6 <= r11) goto L62
            com.google.android.gms.internal.ads.zzbih r6 = com.google.android.gms.internal.ads.zzbiq.zzx     // Catch: java.lang.Throwable -> L51
            com.google.android.gms.internal.ads.zzbio r7 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L51
            java.lang.Object r6 = r7.zzd(r6)     // Catch: java.lang.Throwable -> L51
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L51
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L51
            if (r6 == 0) goto L62
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L51
            r6.<init>()     // Catch: java.lang.Throwable -> L51
        L43:
            if (r1 >= r11) goto L57
            java.lang.Object r7 = r2.poll()     // Catch: java.lang.Throwable -> L51
            com.google.android.gms.internal.ads.zzftm r7 = (com.google.android.gms.internal.ads.zzftm) r7     // Catch: java.lang.Throwable -> L51
            if (r7 == 0) goto L54
            r6.add(r7)     // Catch: java.lang.Throwable -> L51
            goto L54
        L51:
            r0 = move-exception
            r11 = r0
            goto L9a
        L54:
            int r1 = r1 + 1
            goto L43
        L57:
            r2.clear()     // Catch: java.lang.Throwable -> L51
            r2.addAll(r6)     // Catch: java.lang.Throwable -> L51
            int r1 = r6.size()     // Catch: java.lang.Throwable -> L51
            goto L63
        L62:
            r0 = r1
        L63:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L74
            if (r4 <= r1) goto L74
            com.google.android.gms.internal.ads.zzfsn r0 = r10.zzf
            if (r0 == 0) goto L74
            int r4 = r4 - r1
            if (r1 != 0) goto L71
            int r4 = r4 + (-1)
        L71:
            r0.zzd(r10, r4)
        L74:
            com.google.android.gms.internal.ads.zzftd r4 = r10.zzr
            if (r4 == 0) goto L99
            if (r3 == 0) goto L99
            com.google.android.gms.common.util.Clock r0 = r10.zzs
            long r7 = r0.currentTimeMillis()
            com.google.android.gms.internal.ads.zzftj r0 = new com.google.android.gms.internal.ads.zzftj
            java.util.concurrent.atomic.AtomicReference r1 = r10.zze
            java.lang.Object r1 = r1.get()
            com.google.android.gms.ads.internal.client.zzfp r1 = (com.google.android.gms.ads.internal.client.zzfp) r1
            java.lang.String r1 = r1.f69947a
            r0.<init>(r1, r3)
            com.google.android.gms.internal.ads.zzftk r9 = new com.google.android.gms.internal.ads.zzftk
            r1 = 0
            r9.<init>(r0, r1)
            r6 = r11
            r4.zzc(r5, r6, r7, r9)
        L99:
            return
        L9a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L51
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfub.zzA(int):void");
    }

    protected final void zzB(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzC)).booleanValue()) {
            Bundle bundle = zzmVar.C;
            bundle.putInt("plcs", zzt());
            bundle.putInt("plbs", zzs());
            bundle.putString("plid", this.zzm);
        }
    }

    final long zzC() {
        long jZzb = zzb();
        if (jZzb >= 0) {
            return jZzb;
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzP)).longValue();
    }

    final /* synthetic */ void zzD(int i3, zzftm zzftmVar, zzftm zzftmVar2, long j3, int i4, int i5) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzL)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzK)).booleanValue() || i3 == 1) {
                this.zzl.zza();
            }
        }
        if (zzftmVar != null && zzftmVar2 != null) {
            AdFormat adFormatA = AdFormat.a(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69948b);
            String strZzV = zzV(zzc(zzftmVar.zza()));
            if (adFormatA != null && strZzV != null && zzftmVar2.zzd() < zzftmVar.zzd()) {
                this.zzr.zzg(j3, i4, i5, strZzV, this.zzt, zzM());
            }
        }
        zzfsn zzfsnVar = this.zzf;
        if (zzfsnVar != null) {
            zzfsnVar.zzb(this);
            return;
        }
        long jZzC = zzC();
        if (jZzC > 0) {
            this.zzi.schedule(new zzftp(this), jZzC, TimeUnit.MILLISECONDS);
        } else {
            zzy();
        }
    }

    final /* synthetic */ void zzG(Object obj) {
        Object obj2;
        if (obj != null) {
            this.zzl.zza();
            this.zzq.set(true);
            com.google.android.gms.ads.internal.client.zzdx zzdxVarZzc = zzc(obj);
            double dZzl = !(zzdxVarZzc instanceof zzdck) ? 0.0d : ((zzdck) zzdxVarZzc).zzl();
            com.google.android.gms.ads.internal.client.zzdx zzdxVarZzc2 = zzc(obj);
            obj2 = obj;
            zzftm zzftmVar = new zzftm(obj2, this.zzs, dZzl, zzdxVarZzc2 instanceof zzdck ? ((zzdck) zzdxVarZzc2).zzm() : 2);
            Queue queue = this.zzk;
            synchronized (queue) {
                queue.add(zzftmVar);
            }
            com.google.android.gms.ads.internal.client.zzdx zzdxVarZzc3 = zzc(obj2);
            long jCurrentTimeMillis = this.zzs.currentTimeMillis();
            if (this.zzp.get()) {
                com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzftq(this, zzdxVarZzc3));
            }
            ScheduledExecutorService scheduledExecutorService = this.zzi;
            scheduledExecutorService.execute(new zzftr(this, jCurrentTimeMillis, zzdxVarZzc3));
            if (this.zzf != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzE)).booleanValue()) {
                    this.zzo.zzb(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzF();
                        }
                    }, zzftmVar.zzc(), TimeUnit.MILLISECONDS);
                } else {
                    scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfty
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzE();
                        }
                    }, zzftmVar.zzc(), TimeUnit.MILLISECONDS);
                }
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzE)).booleanValue()) {
                    this.zzo.zzb(new zzftp(this), zzftmVar.zzc(), TimeUnit.MILLISECONDS);
                } else {
                    scheduledExecutorService.schedule(new zzftp(this), zzftmVar.zzc(), TimeUnit.MILLISECONDS);
                }
            }
        } else {
            obj2 = obj;
        }
        this.zzn.set(false);
        if (obj2 == null || this.zzf == null) {
            zzS(obj2 == null);
        }
    }

    final /* synthetic */ void zzH(Throwable th) {
        this.zzn.set(false);
        if ((th instanceof zzfso) && ((zzfso) th).zza() == 0) {
            throw null;
        }
        zzS(true);
    }

    final /* synthetic */ void zzI(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zzp.get()) {
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzfts(this, zzeVar));
        }
        this.zzn.set(false);
        int i3 = zzeVar.f69851a;
        if (i3 != 1 && i3 != 8 && i3 != 10 && i3 != 11) {
            zzS(true);
            return;
        }
        int i4 = ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69948b;
        String str = ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69947a;
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 26 + String.valueOf(str).length() + 61);
        sb.append("Preloading ");
        sb.append(i4);
        sb.append(", for adUnitId:");
        sb.append(str);
        sb.append(", Ad load failed. Stop preloading due to non-retriable error:");
        String string = sb.toString();
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e(string);
        this.zzg.set(false);
        zzfsn zzfsnVar = this.zzf;
        if (zzfsnVar != null) {
            zzfsnVar.zza(this);
        }
        zzftj zzftjVar = new zzftj(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69947a, zzq());
        zzftjVar.zza(this.zzm);
        this.zzr.zzk(this.zzs.currentTimeMillis(), new zzftk(zzftjVar, null), zzeVar, zzs(), zzt(), zzM());
    }

    final /* synthetic */ void zzJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zzce zzceVar = this.zzh;
        if (zzceVar != null) {
            try {
                zzceVar.p3(this.zzm, zzeVar);
            } catch (RemoteException unused) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdFailedToPreload");
            }
        }
    }

    final /* synthetic */ void zzK(com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        com.google.android.gms.ads.internal.client.zzcb zzcbVar = this.zzj;
        if (zzcbVar != null) {
            try {
                zzcbVar.Q0((com.google.android.gms.ads.internal.client.zzfp) this.zze.get());
            } catch (RemoteException unused) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdsAvailable");
            }
        }
        com.google.android.gms.ads.internal.client.zzce zzceVar = this.zzh;
        if (zzceVar != null) {
            try {
                zzceVar.b5(this.zzm, zzdxVar);
            } catch (RemoteException unused2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdPreloaded");
            }
        }
    }

    final /* synthetic */ void zzL() {
        com.google.android.gms.ads.internal.client.zzcb zzcbVar = this.zzj;
        if (zzcbVar != null) {
            try {
                zzcbVar.J((com.google.android.gms.ads.internal.client.zzfp) this.zze.get());
            } catch (RemoteException unused) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdsExhausted");
            }
        }
        com.google.android.gms.ads.internal.client.zzce zzceVar = this.zzh;
        if (zzceVar != null) {
            try {
                zzceVar.zzf(this.zzm);
            } catch (RemoteException unused2) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Failed to call onAdsExhausted");
            }
        }
    }

    final /* synthetic */ zzftd zzN() {
        return this.zzr;
    }

    final /* synthetic */ Clock zzO() {
        return this.zzs;
    }

    final /* synthetic */ zzftk zzP() {
        return this.zzt;
    }

    protected abstract ListenableFuture zza(Context context);

    protected long zzb() {
        throw null;
    }

    protected abstract com.google.android.gms.ads.internal.client.zzdx zzc(Object obj);

    public final zzfub zzd() {
        this.zzi.submit(new zzftp(this));
        return this;
    }

    public final void zze() {
        if (this.zzn.compareAndSet(false, true)) {
            if (!this.zzg.get() || zzt() >= ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69950d) {
                this.zzn.set(false);
            } else {
                this.zzi.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfua
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzz();
                    }
                });
            }
        }
    }

    public final boolean zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzJ)).booleanValue()) {
            this.zzl.zza();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzD)).booleanValue() && this.zzf == null) {
            zzy();
        } else {
            zzF();
        }
        return !zzR();
    }

    public final Object zzg() {
        final zzftm zzftmVar;
        final zzftm zzftmVar2;
        Queue queue = this.zzk;
        final int iZzt = zzt();
        synchronized (queue) {
            try {
                zzftm zzftmVar3 = (zzftm) queue.poll();
                this.zzq.set(zzftmVar3 != null);
                if (zzftmVar3 == null) {
                    zzftmVar = null;
                    zzftmVar2 = null;
                } else if (queue.isEmpty()) {
                    zzftmVar = zzftmVar3;
                    zzftmVar2 = null;
                } else {
                    zzftmVar = zzftmVar3;
                    zzftmVar2 = (zzftm) queue.peek();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final long jCurrentTimeMillis = this.zzs.currentTimeMillis();
        final int iZzs = zzs();
        final int iZzt2 = zzt();
        this.zzi.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzD(iZzt, zzftmVar, zzftmVar2, jCurrentTimeMillis, iZzs, iZzt2);
            }
        });
        if (zzftmVar == null) {
            return null;
        }
        return zzftmVar.zza();
    }

    public final void zzh() {
        this.zzg.set(false);
        this.zzp.set(false);
    }

    public final void zzi() {
        this.zzg.set(false);
    }

    public final void zzj() {
        this.zzg.set(true);
        this.zzp.set(true);
        if (this.zzf == null) {
            this.zzi.submit(new zzftp(this));
        }
    }

    public final boolean zzk(com.google.android.gms.ads.internal.client.zzfp zzfpVar) {
        return ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).equals(zzfpVar);
    }

    public final String zzl() {
        zzftm zzftmVar;
        Queue queue = this.zzk;
        synchronized (queue) {
            zzftmVar = (zzftm) queue.peek();
        }
        Object objZza = zzftmVar == null ? null : zzftmVar.zza();
        return zzV(objZza != null ? zzc(objZza) : null);
    }

    public final void zzm(zzftd zzftdVar) {
        this.zzr = zzftdVar;
    }

    public final void zzn(int i3) {
        Preconditions.a(i3 >= 5);
        this.zzl.zzf(i3);
    }

    protected final com.google.android.gms.ads.internal.client.zzfp zzo() {
        return (com.google.android.gms.ads.internal.client.zzfp) this.zze.get();
    }

    protected final String zzp() {
        return this.zzm;
    }

    protected final AdFormat zzq() {
        return AdFormat.a(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69948b);
    }

    protected final String zzr() {
        return ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69947a;
    }

    protected final int zzs() {
        return ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69950d;
    }

    protected final int zzt() {
        int size;
        Queue queue = this.zzk;
        synchronized (queue) {
            size = queue.size();
        }
        return size;
    }

    protected final boolean zzu() {
        if (!this.zzg.get() || this.zzn.get() || zzt() >= zzs()) {
            return false;
        }
        zzfsw zzfswVar = this.zzl;
        return (zzfswVar.zzd() || zzfswVar.zze()) ? false : true;
    }

    protected final void zzv() {
        Queue queue = this.zzk;
        synchronized (queue) {
            queue.clear();
        }
    }

    protected final boolean zzw() {
        return this.zzn.get();
    }

    protected final int zzx() {
        int iZzt = zzt();
        int i3 = iZzt - 1;
        if (!this.zzn.get()) {
            iZzt = i3;
        }
        return Math.max(iZzt, 0);
    }

    protected final void zzy() {
        zzF();
        if (zzR() && this.zzq.compareAndSet(true, false)) {
            if (this.zzp.get()) {
                com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzftt(this));
            }
            this.zzi.execute(new zzftu(this));
        }
        if (this.zzn.compareAndSet(false, true)) {
            if (!this.zzg.get() || zzt() >= ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69950d) {
                this.zzn.set(false);
            } else {
                zzz();
            }
        }
    }

    protected final void zzz() {
        ListenableFuture listenableFutureZza;
        Activity activityZzd = com.google.android.gms.ads.internal.zzt.k().zzd();
        if (activityZzd == null) {
            String strValueOf = String.valueOf(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69947a);
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Empty activity context at preloading: ".concat(strValueOf));
            listenableFutureZza = zza(this.zzb);
        } else {
            listenableFutureZza = zza(activityZzd);
        }
        zzhbw.zzr(listenableFutureZza, new zzftn(this), this.zzi);
    }

    public zzfub(String str, ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock, zzfsn zzfsnVar) {
        this(str, clientApi, context, i3, zzfluVar, zzfpVar, scheduledExecutorService, zzfooVar, zzfswVar, clock, zzfsnVar);
        this.zzh = zzceVar;
    }

    private zzfub(String str, ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock, zzfsn zzfsnVar) {
        Queue priorityQueue;
        this.zzm = str;
        this.zza = clientApi;
        this.zzb = context;
        this.zzc = i3;
        this.zzd = zzfluVar;
        this.zze = new AtomicReference(zzfpVar);
        int iMax = Math.max(1, zzfpVar.f69950d);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzab)).booleanValue()) {
            priorityQueue = new zzfue();
        } else {
            priorityQueue = new PriorityQueue(iMax, zzftx.zza);
        }
        this.zzk = priorityQueue;
        this.zzg = new AtomicBoolean(true);
        this.zzn = new AtomicBoolean(false);
        this.zzi = scheduledExecutorService;
        this.zzo = zzfooVar;
        this.zzl = zzfswVar;
        this.zzp = new AtomicBoolean(true);
        this.zzq = new AtomicBoolean(false);
        this.zzs = clock;
        zzftj zzftjVar = new zzftj(zzfpVar.f69947a, AdFormat.a(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).f69948b));
        zzftjVar.zza(str);
        this.zzt = new zzftk(zzftjVar, null);
        this.zzf = zzfsnVar;
    }
}
