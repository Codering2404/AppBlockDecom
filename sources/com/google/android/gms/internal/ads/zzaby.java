package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaby extends Handler implements Runnable {
    final /* synthetic */ zzacd zza;
    private final zzabz zzb;
    private final long zzc;
    private zzabv zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaby(zzacd zzacdVar, Looper looper, zzabz zzabzVar, zzabv zzabvVar, int i3, long j3) {
        super(looper);
        Objects.requireNonNull(zzacdVar);
        this.zza = zzacdVar;
        this.zzb = zzabzVar;
        this.zzd = zzabvVar;
        this.zzc = j3;
    }

    private final void zzd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = jElapsedRealtime - this.zzc;
        zzabv zzabvVar = this.zzd;
        zzabvVar.getClass();
        zzabvVar.zzC(this.zzb, jElapsedRealtime, j3, this.zzf);
        this.zze = null;
        zzacd zzacdVar = this.zza;
        zzaby zzabyVarZzj = zzacdVar.zzj();
        zzabyVarZzj.getClass();
        zzacdVar.zzi().execute(zzabyVarZzj);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i3 = message.what;
        if (i3 == 1) {
            zzd();
            return;
        }
        if (i3 == 4) {
            throw ((Error) message.obj);
        }
        zzacd zzacdVar = this.zza;
        zzacdVar.zzk(null);
        long j3 = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = jElapsedRealtime - j3;
        zzabv zzabvVar = this.zzd;
        zzabvVar.getClass();
        if (this.zzh) {
            zzabvVar.zzA(this.zzb, jElapsedRealtime, j4, false);
            return;
        }
        int i4 = message.what;
        if (i4 == 2) {
            try {
                zzabvVar.zzB(this.zzb, jElapsedRealtime, j4);
                return;
            } catch (RuntimeException e3) {
                zzeg.zzf("LoadTask", "Unexpected exception handling load completed", e3);
                this.zza.zzl(new zzacc(e3));
                return;
            }
        }
        if (i4 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i5 = this.zzf + 1;
        this.zzf = i5;
        zzabx zzabxVarZzz = zzabvVar.zzz(this.zzb, jElapsedRealtime, j4, iOException, i5);
        if (zzabxVarZzz.zzb() == 3) {
            zzacdVar.zzl(this.zze);
        } else if (zzabxVarZzz.zzb() != 2) {
            if (zzabxVarZzz.zzb() == 1) {
                this.zzf = 1;
            }
            zzb(zzabxVarZzz.zzc() != -9223372036854775807L ? zzabxVarZzz.zzc() : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        try {
            synchronized (this) {
                z2 = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z2) {
                zzabz zzabzVar = this.zzb;
                String simpleName = zzabzVar.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(simpleName.length() + 5);
                sb.append("load:");
                sb.append(simpleName);
                Trace.beginSection(sb.toString());
                try {
                    zzabzVar.zzc();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e3) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e3).sendToTarget();
        } catch (Exception e4) {
            if (this.zzi) {
                return;
            }
            zzeg.zzf("LoadTask", "Unexpected exception loading stream", e4);
            obtainMessage(3, new zzacc(e4)).sendToTarget();
        } catch (OutOfMemoryError e5) {
            if (this.zzi) {
                return;
            }
            zzeg.zzf("LoadTask", "OutOfMemory error loading stream", e5);
            obtainMessage(3, new zzacc(e5)).sendToTarget();
        } catch (Error e6) {
            if (!this.zzi) {
                zzeg.zzf("LoadTask", "Unexpected error loading stream", e6);
                obtainMessage(4, e6).sendToTarget();
            }
            throw e6;
        }
    }

    public final void zza(int i3) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i3) {
            throw iOException;
        }
    }

    public final void zzb(long j3) {
        zzacd zzacdVar = this.zza;
        zzgtj.zzi(zzacdVar.zzj() == null);
        zzacdVar.zzk(this);
        if (j3 > 0) {
            sendEmptyMessageDelayed(1, j3);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z2) {
        this.zzi = z2;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z2) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzb();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z2) {
            this.zza.zzk(null);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzabv zzabvVar = this.zzd;
            zzabvVar.getClass();
            zzabvVar.zzA(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }
}
