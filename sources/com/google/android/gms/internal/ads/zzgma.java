package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgma implements zzglb {
    private final zzgfs zza;
    private final zzgox zzb;
    private final zzgoe zzc;
    private final ExecutorService zzd;
    private final zzgpc zze;
    private final zzgqh zzf;
    private final Object zzg = new Object();
    private final String zzh;
    private final long zzi;
    private final long zzj;
    private final boolean zzk;
    private final boolean zzl;
    private zzglz zzm;

    zzgma(zzgfs zzgfsVar, zzinj zzinjVar, zzgox zzgoxVar, zzgoe zzgoeVar, zzgpc zzgpcVar, zzgqh zzgqhVar, zzgdf zzgdfVar, ExecutorService executorService) {
        this.zza = zzgfsVar;
        this.zzb = zzgoxVar;
        this.zzc = zzgoeVar;
        this.zzd = executorService;
        this.zze = zzgpcVar;
        this.zzf = zzgqhVar;
        this.zzh = zzgdfVar.zzd();
        this.zzi = zzgdfVar.zzm();
        this.zzj = zzgdfVar.zzl();
        this.zzk = zzgdfVar.zzb();
        this.zzl = zzgdfVar.zzc();
    }

    private final ListenableFuture zzs() {
        return zzhbw.zzk(this.zzc.zzf(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzglu
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzo((byte[]) obj);
                return null;
            }
        }, zzhcn.zza());
    }

    private final void zzt(zzaux zzauxVar, byte[] bArr, boolean z2) {
        zzgqf zzgqfVarZza = this.zzf.zza(20102);
        try {
            try {
                zzgqfVarZza.zza();
                synchronized (this.zzg) {
                    this.zzm = zzglz.zza(zzauxVar, bArr, z2);
                }
                zzgqfVarZza.zzc();
            } catch (zzauv e3) {
                e = e3;
                zzgqfVarZza.zzb(e);
                throw new zzglc(2, e);
            } catch (zzauz e4) {
                e = e4;
                zzgqfVarZza.zzb(e);
                throw new zzglc(2, e);
            } catch (Throwable th) {
                zzgqfVarZza.zzb(th);
                throw th;
            }
        } catch (Throwable th2) {
            zzgqfVarZza.zzc();
            throw th2;
        }
    }

    private final String zzu(Map map) throws zzauv, zzauz {
        String strZzb;
        zzgqh zzgqhVar = this.zzf;
        try {
            zzgqhVar.zza(20110).zza();
            synchronized (this.zzg) {
                try {
                    zzglz zzglzVar = this.zzm;
                    if (zzglzVar == null) {
                        zzgqhVar.zzb(20109);
                        strZzb = "";
                    } else {
                        strZzb = zzglzVar.zzb(map);
                    }
                } finally {
                }
            }
            return strZzb;
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final String zza() {
        synchronized (this.zzg) {
            try {
                zzglz zzglzVar = this.zzm;
                if (zzglzVar == null) {
                    return "3.878096153.-1";
                }
                return zzglzVar.zzd();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzb() {
        if (this.zzl) {
            return zzs();
        }
        zzhbo zzhboVarZzw = zzhbo.zzw(this.zzc.zzb());
        ExecutorService executorService = this.zzd;
        return (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzj((zzhbo) zzhbw.zzg(zzhboVarZzw, Throwable.class, zzgly.zza, executorService), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzglo
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzi((zzgfq) obj);
            }
        }, executorService), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzglp
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj((Throwable) obj);
            }
        }, zzhcn.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzc(final Context context) {
        return zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzglq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzk(context);
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zzd(final Context context, String str, final View view, final Activity activity) {
        final String str2 = null;
        return zzhbw.zzd(new Callable(context, str2, view, activity) { // from class: com.google.android.gms.internal.ads.zzglr
            private final /* synthetic */ Context zzb;
            private final /* synthetic */ View zzc;
            private final /* synthetic */ Activity zzd;

            {
                this.zzc = view;
                this.zzd = activity;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzl(this.zzb, null, this.zzc, this.zzd);
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final ListenableFuture zze(final Context context, final String str, final View view, Activity activity) {
        final Activity activity2 = null;
        return zzhbw.zzd(new Callable(context, str, view, activity2) { // from class: com.google.android.gms.internal.ads.zzgls
            private final /* synthetic */ Context zzb;
            private final /* synthetic */ String zzc;
            private final /* synthetic */ View zzd;

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzm(this.zzb, this.zzc, this.zzd, null);
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final void zzf(InputEvent inputEvent) {
        try {
            synchronized (this.zzg) {
                try {
                    zzglz zzglzVar = this.zzm;
                    if (zzglzVar != null) {
                        HashMap map = new HashMap();
                        map.put("evt", inputEvent);
                        zzglzVar.zzc(map);
                    } else {
                        this.zzf.zzb(20105);
                    }
                } finally {
                }
            }
        } catch (zzauv | zzauz e3) {
            this.zzf.zzd(20104, e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzglb
    public final int zzg() {
        return 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzh(java.util.Map r12) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgma.zzh(java.util.Map):void");
    }

    final /* synthetic */ ListenableFuture zzi(zzgfq zzgfqVar) {
        if (zzgfqVar != null) {
            this.zza.zzd(zzgfqVar.zzd());
        }
        if (this.zzb.zzb(zzgfqVar)) {
            return zzhbw.zzk(this.zzc.zze(), new zzgta() { // from class: com.google.android.gms.internal.ads.zzglt
                @Override // com.google.android.gms.internal.ads.zzgta
                public final /* synthetic */ Object apply(Object obj) {
                    this.zza.zzn((byte[]) obj);
                    return null;
                }
            }, zzhcn.zza());
        }
        this.zzf.zzb(20103);
        throw new zzglc(1);
    }

    final /* synthetic */ ListenableFuture zzj(Throwable th) {
        return this.zzk ? zzs() : zzhbw.zzc(th);
    }

    final /* synthetic */ String zzk(final Context context) throws zzauv, zzauz {
        final HashMap map = new HashMap();
        this.zzf.zzf(20106, new Runnable() { // from class: com.google.android.gms.internal.ads.zzglv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzp(map, context);
            }
        });
        String strZzu = zzu(map);
        map.clear();
        return strZzu;
    }

    final /* synthetic */ String zzl(final Context context, String str, final View view, final Activity activity) throws zzauv, zzauz {
        final HashMap map = new HashMap();
        final String str2 = null;
        this.zzf.zzf(20106, new Runnable(map, context, view, activity, str2) { // from class: com.google.android.gms.internal.ads.zzglw
            private final /* synthetic */ Map zzb;
            private final /* synthetic */ Context zzc;
            private final /* synthetic */ View zzd;
            private final /* synthetic */ Activity zze;

            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, null);
            }
        });
        String strZzu = zzu(map);
        map.clear();
        return strZzu;
    }

    final /* synthetic */ String zzm(final Context context, final String str, final View view, Activity activity) throws zzauv, zzauz {
        final HashMap map = new HashMap();
        final Activity activity2 = null;
        this.zzf.zzf(20106, new Runnable(map, context, view, activity2, str) { // from class: com.google.android.gms.internal.ads.zzglx
            private final /* synthetic */ Map zzb;
            private final /* synthetic */ Context zzc;
            private final /* synthetic */ View zzd;
            private final /* synthetic */ String zze;

            {
                this.zze = str;
            }

            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzr(this.zzb, this.zzc, this.zzd, null, this.zze);
            }
        });
        String strZzu = zzu(map);
        map.clear();
        return strZzu;
    }

    final /* synthetic */ Void zzn(byte[] bArr) {
        zzt(zzgmd.zzc(), bArr, false);
        return null;
    }

    final /* synthetic */ Void zzo(byte[] bArr) {
        zzt(zzgmd.zzc(), bArr, true);
        return null;
    }

    final /* synthetic */ void zzp(Map map, Context context) {
        map.putAll(this.zze.zzb());
        zzh(map);
        map.put("f", "q");
        map.put("ctx", context);
    }

    final /* synthetic */ void zzq(Map map, Context context, View view, Activity activity, String str) {
        map.putAll(this.zze.zzc(context, view));
        zzh(map);
        map.put("f", "v");
        map.put("ctx", context);
        map.put(ViewHierarchyConstants.VIEW_KEY, view);
        map.put("act", activity);
        map.put("bds", null);
    }

    final /* synthetic */ void zzr(Map map, Context context, View view, Activity activity, String str) {
        map.putAll(this.zze.zzd());
        zzh(map);
        map.put("f", "c");
        map.put("ctx", context);
        map.put(ViewHierarchyConstants.VIEW_KEY, view);
        map.put("act", null);
        map.put("bds", str);
    }
}
