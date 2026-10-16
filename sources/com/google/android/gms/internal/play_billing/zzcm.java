package com.google.android.gms.internal.play_billing;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzcm<V> extends zzcn<V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzcn.zzc) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        zza(boolean z2, Throwable th) {
            this.zzc = z2;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class zzb<V> implements Runnable {
        final zzcm<V> zza;
        final zzdc<? extends V> zzb;

        zzb(zzcm zzcmVar, zzdc zzdcVar) {
            this.zza = zzcmVar;
            this.zzb = zzdcVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzcn.zzq(this.zza, this, zzcm.zzr(this.zzb))) {
                zzcm.zzu(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.play_billing.zzcm.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface zze<V> extends zzdc<V> {
    }

    protected zzcm() {
    }

    static Object zzc(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzcn.zza) {
            return null;
        }
        return obj;
    }

    static boolean zzh(Object obj) {
        return !(obj instanceof zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zzr(zzdc zzdcVar) {
        Throwable thZze;
        if (zzdcVar instanceof zze) {
            Object zzaVar = ((zzcm) zzdcVar).valueField;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.zzc) {
                    Throwable th = zzaVar2.zzd;
                    zzaVar = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            Objects.requireNonNull(zzaVar);
            return zzaVar;
        }
        if ((zzdcVar instanceof zzdi) && (thZze = ((zzdi) zzdcVar).zze()) != null) {
            return new zzc(thZze);
        }
        boolean zIsCancelled = zzdcVar.isCancelled();
        if ((!zzcn.zzc) && zIsCancelled) {
            zza zzaVar3 = zza.zzb;
            Objects.requireNonNull(zzaVar3);
            return zzaVar3;
        }
        try {
            Object objZzs = zzs(zzdcVar);
            if (!zIsCancelled) {
                return objZzs == null ? zzcn.zza : objZzs;
            }
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzdcVar)));
        } catch (Error | Exception e3) {
            return new zzc(e3);
        } catch (CancellationException e4) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzdcVar)), e4)) : new zza(false, e4);
        } catch (ExecutionException e5) {
            return zIsCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzdcVar)), e5)) : new zzc(e5.getCause());
        }
    }

    private static Object zzs(Future future) throws ExecutionException {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzt(StringBuilder sb) {
        try {
            Object objZzs = zzs(this);
            sb.append("SUCCESS, result=[");
            if (objZzs == null) {
                sb.append("null");
            } else if (objZzs == this) {
                sb.append("this future");
            } else {
                sb.append(objZzs.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzs)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        } catch (Exception e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzu(zzcm zzcmVar, boolean z2) {
        zzd zzdVar;
        zzd zzdVar2 = null;
        while (true) {
            zzcmVar.zzo();
            zzcmVar.zzg();
            zzd zzdVar3 = zzdVar2;
            zzd zzdVarZzk = zzcmVar.zzk(zzd.zza);
            zzd zzdVar4 = zzdVar3;
            while (zzdVarZzk != null) {
                zzd zzdVar5 = zzdVarZzk.next;
                zzdVarZzk.next = zzdVar4;
                zzdVar4 = zzdVarZzk;
                zzdVarZzk = zzdVar5;
            }
            while (zzdVar4 != null) {
                Runnable runnable = zzdVar4.zzb;
                zzdVar = zzdVar4.next;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzcmVar = zzbVar.zza;
                    if (zzcmVar.valueField != zzbVar || !zzcn.zzq(zzcmVar, zzbVar, zzr(zzbVar.zzb))) {
                    }
                } else {
                    Executor executor = zzdVar4.zzc;
                    Objects.requireNonNull(executor);
                    zzv(runnable2, executor);
                }
                zzdVar4 = zzdVar;
            }
            return;
            zzdVar2 = zzdVar;
        }
    }

    private static void zzv(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e3) {
            zzcn.zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.valueField
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.zzcm.zzb
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L5f
            boolean r1 = com.google.android.gms.internal.play_billing.zzcn.zzc
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.play_billing.zzcm$zza r1 = new com.google.android.gms.internal.play_billing.zzcm$zza
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.play_billing.zzcm$zza r1 = com.google.android.gms.internal.play_billing.zzcm.zza.zza
            goto L26
        L24:
            com.google.android.gms.internal.play_billing.zzcm$zza r1 = com.google.android.gms.internal.play_billing.zzcm.zza.zzb
        L26:
            java.util.Objects.requireNonNull(r1)
        L29:
            r4 = r7
            r5 = r2
        L2b:
            boolean r6 = com.google.android.gms.internal.play_billing.zzcn.zzq(r4, r0, r1)
            if (r6 == 0) goto L56
            zzu(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzcm.zzb
            if (r4 == 0) goto L55
            com.google.android.gms.internal.play_billing.zzcm$zzb r0 = (com.google.android.gms.internal.play_billing.zzcm.zzb) r0
            com.google.android.gms.internal.play_billing.zzdc<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzcm.zze
            if (r4 == 0) goto L52
            r4 = r0
            com.google.android.gms.internal.play_billing.zzcm r4 = (com.google.android.gms.internal.play_billing.zzcm) r4
            java.lang.Object r0 = r4.valueField
            if (r0 != 0) goto L49
            r5 = r3
            goto L4a
        L49:
            r5 = r2
        L4a:
            boolean r6 = r0 instanceof com.google.android.gms.internal.play_billing.zzcm.zzb
            r5 = r5 | r6
            if (r5 == 0) goto L51
            r5 = r3
            goto L2b
        L51:
            return r3
        L52:
            r0.cancel(r8)
        L55:
            return r3
        L56:
            java.lang.Object r0 = r4.valueField
            boolean r6 = zzh(r0)
            if (r6 == 0) goto L2b
            return r5
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzcm.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return zzl();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzh(obj);
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.valueField instanceof zza) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzt(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                zzdc<? extends V> zzdcVar = ((zzb) obj).zzb;
                try {
                    if (zzdcVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzdcVar);
                    }
                } catch (Throwable th) {
                    zzdd.zza(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = zzbm.zza(zzd());
                } catch (Throwable th2) {
                    zzdd.zza(th2);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                }
                if (strConcat != null) {
                    sb.append(", info=[");
                    sb.append(strConcat);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzt(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdc
    public final void zzb(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzbj.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzp(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzv(runnable, executor);
    }

    protected String zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdi
    protected final Throwable zze() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    protected final boolean zzi(Throwable th) {
        if (!zzcn.zzq(this, null, new zzc(th))) {
            return false;
        }
        zzu(this, false);
        return true;
    }

    protected final boolean zzj(zzdc zzdcVar) {
        zzc zzcVar;
        Object obj = this.valueField;
        if (obj == null) {
            if (zzdcVar.isDone()) {
                if (!zzcn.zzq(this, null, zzr(zzdcVar))) {
                    return false;
                }
                zzu(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, zzdcVar);
            if (zzcn.zzq(this, null, zzbVar)) {
                try {
                    zzdcVar.zzb(zzbVar, zzcs.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzcn.zzq(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            zzdcVar.cancel(((zza) obj).zzc);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j3, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzm(j3, timeUnit);
    }

    protected void zzg() {
    }
}
