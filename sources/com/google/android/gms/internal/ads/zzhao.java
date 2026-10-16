package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhao extends zzhbn implements Runnable {
    public static final /* synthetic */ int zzd = 0;
    ListenableFuture zza;
    Class zzb;
    Object zzc;

    zzhao(ListenableFuture listenableFuture, Class cls, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = listenableFuture instanceof zzhcy ? ((zzhcy) listenableFuture).zzl() : null;
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(listenableFuture.getClass());
                String strValueOf2 = String.valueOf(e3.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 19 + strValueOf2.length() + 16);
                sb.append("Future type ");
                sb.append(strValueOf);
                sb.append(" threw ");
                sb.append(strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objZzs = th == null ? zzhbw.zzs(listenableFuture) : null;
        if (th == null) {
            zza(objZzs);
            return;
        }
        if (!cls.isInstance(th)) {
            zzk(listenableFuture);
            return;
        }
        try {
            Object objZzf = zzf(obj, th);
            this.zzb = null;
            this.zzc = null;
            zze(objZzf);
        } catch (Throwable th2) {
            try {
                zzhco.zza(th2);
                zzb(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final void zzc() {
        zzm(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final String zzd() {
        String string;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZzd = super.zzd();
        if (listenableFuture != null) {
            String string2 = listenableFuture.toString();
            StringBuilder sb = new StringBuilder(string2.length() + 16);
            sb.append("inputFuture=[");
            sb.append(string2);
            sb.append("], ");
            string = sb.toString();
        } else {
            string = "";
        }
        if (cls == null || obj == null) {
            if (strZzd != null) {
                return string.concat(strZzd);
            }
            return null;
        }
        int length = string.length();
        String string3 = cls.toString();
        int length2 = string3.length();
        String string4 = obj.toString();
        StringBuilder sb2 = new StringBuilder(length + 15 + length2 + 13 + string4.length() + 1);
        sb2.append(string);
        sb2.append("exceptionType=[");
        sb2.append(string3);
        sb2.append("], fallback=[");
        sb2.append(string4);
        sb2.append("]");
        return sb2.toString();
    }

    abstract void zze(Object obj);

    abstract Object zzf(Object obj, Throwable th) throws Exception;
}
