package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcb extends Thread {
    private static zzcb zza;
    private final LinkedBlockingQueue zzb;
    private volatile boolean zzc;
    private volatile boolean zzd;
    private volatile zzcc zze;
    private final Context zzf;

    private zzcb(Context context) {
        super("GAThread");
        this.zzb = new LinkedBlockingQueue();
        this.zzc = false;
        this.zzd = false;
        if (context != null) {
            this.zzf = context.getApplicationContext();
        } else {
            this.zzf = null;
        }
        start();
    }

    static zzcb zzb(Context context) {
        if (zza == null) {
            zza = new zzcb(context);
        }
        return zza;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    Runnable runnable = (Runnable) this.zzb.take();
                    if (!this.zzc) {
                        runnable.run();
                    }
                } catch (InterruptedException e3) {
                    zzdg.zzb.zzb(e3.toString());
                }
            } catch (Exception e4) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                e4.printStackTrace(printStream);
                printStream.flush();
                Log.e("GoogleTagManager", "Error on Google TagManager Thread: ".concat(new String(byteArrayOutputStream.toByteArray())));
                Log.e("GoogleTagManager", "Google TagManager is shutting down.");
                this.zzc = true;
            }
        }
    }

    public final void zze(Runnable runnable) {
        this.zzb.add(runnable);
    }

    final void zzf(String str, long j3) {
        this.zzb.add(new zzca(this, this, j3, str));
    }
}
