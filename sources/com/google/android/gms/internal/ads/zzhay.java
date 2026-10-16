package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhay extends zzhbc {
    private static final zzhce zza = new zzhce(zzhay.class);
    private zzgwi zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzhay(zzgwi zzgwiVar, boolean z2, boolean z3) {
        super(zzgwiVar.size());
        this.zzb = zzgwiVar;
        this.zzc = z2;
        this.zzd = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public final void zzy(int i3, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i3, listenableFuture);
            }
            zzz(null);
        } catch (Throwable th) {
            zzz(null);
            throw th;
        }
    }

    private final void zzE(Throwable th) {
        th.getClass();
        if (this.zzc && !zzb(th) && zzI(zzB(), th)) {
            zzF(th);
        } else if (th instanceof Error) {
            zzF(th);
        }
    }

    private static void zzF(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private final void zzG(int i3, Future future) {
        try {
            zzw(i3, zzhcx.zza(future));
        } catch (ExecutionException e3) {
            zzE(e3.getCause());
        } catch (Throwable th) {
            zzE(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzz(zzgwi zzgwiVar) {
        int iZzC = zzC();
        int i3 = 0;
        zzgtj.zzj(iZzC >= 0, "Less than 0 remaining futures");
        if (iZzC == 0) {
            if (zzgwiVar != null) {
                zzgza it = zzgwiVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i3, future);
                    }
                    i3++;
                }
            }
            this.seenExceptionsField = null;
            zzx();
            zzA(2);
        }
    }

    private static boolean zzI(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    void zzA(int i3) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final void zzc() {
        zzgwi zzgwiVar = this.zzb;
        zzA(1);
        if ((zzgwiVar != null) && isCancelled()) {
            boolean zZzj = zzj();
            zzgza it = zzgwiVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final String zzd() {
        zzgwi zzgwiVar = this.zzb;
        return zzgwiVar != null ? "futures=".concat(zzgwiVar.toString()) : super.zzd();
    }

    final void zze() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzx();
            return;
        }
        if (this.zzc) {
            zzgza it = this.zzb.iterator();
            final int i3 = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i4 = i3 + 1;
                if (listenableFuture.isDone()) {
                    zzy(i3, listenableFuture);
                } else {
                    listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzhax
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzy(i3, listenableFuture);
                        }
                    }, zzhbl.INSTANCE);
                }
                i3 = i4;
            }
            return;
        }
        zzgwi zzgwiVar = this.zzb;
        final zzgwi zzgwiVar2 = true != this.zzd ? null : zzgwiVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzhaw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgwiVar2);
            }
        };
        zzgza it2 = zzgwiVar.iterator();
        while (it2.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture) it2.next();
            if (listenableFuture2.isDone()) {
                zzz(zzgwiVar2);
            } else {
                listenableFuture2.addListener(runnable, zzhbl.INSTANCE);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbc
    final void zzf(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzI(set, thZzl);
    }

    abstract void zzw(int i3, Object obj);

    abstract void zzx();
}
