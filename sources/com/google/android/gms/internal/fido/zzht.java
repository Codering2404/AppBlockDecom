package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzht {
    private final Deque zza = new ArrayDeque(16);

    private zzht(boolean z2) {
    }

    public static zzht zza() {
        return new zzht(false);
    }

    private final long zzh() {
        if (this.zza.isEmpty()) {
            return 0L;
        }
        return ((Long) this.zza.peek()).longValue();
    }

    private final void zzi(long j3) {
        this.zza.pop();
        this.zza.push(Long.valueOf(j3));
    }

    public final void zzb() throws IOException {
        if (!this.zza.isEmpty()) {
            throw new IOException(String.format("data item not completed, stackSize: %s scope: %s", Integer.valueOf(this.zza.size()), Long.valueOf(zzh())));
        }
    }

    public final void zzc() throws IOException {
        long jZzh = zzh();
        if (jZzh >= 0) {
            throw new IOException(String.format("expected indefinite length scope but found %s", Long.valueOf(jZzh)));
        }
        if (jZzh == -5) {
            throw new IOException("expected a value for dangling key in indefinite-length map");
        }
        this.zza.pop();
    }

    public final void zzd() throws IOException {
        long jZzh = zzh();
        if (jZzh != -1) {
            if (jZzh != -2) {
                return;
            } else {
                jZzh = -2;
            }
        }
        throw new IOException(String.format("expected non-string scope but found %s", Long.valueOf(jZzh)));
    }

    public final void zze(long j3) throws IOException {
        long jZzh = zzh();
        if (jZzh != j3) {
            if (jZzh != -1) {
                if (jZzh != -2) {
                    return;
                } else {
                    jZzh = -2;
                }
            }
            throw new IOException(String.format("expected non-string scope or scope %s but found %s", Long.valueOf(j3), Long.valueOf(jZzh)));
        }
    }

    public final void zzf() {
        long jZzh = zzh();
        if (jZzh == 1) {
            this.zza.pop();
            return;
        }
        if (jZzh > 1) {
            zzi(jZzh - 1);
        } else if (jZzh == -4) {
            zzi(-5L);
        } else if (jZzh == -5) {
            zzi(-4L);
        }
    }

    public final void zzg(long j3) {
        this.zza.push(Long.valueOf(j3));
    }
}
