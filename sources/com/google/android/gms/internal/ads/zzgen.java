package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgen implements zzgel {
    private final Executor zza;
    private final Queue zzb = new PriorityQueue();

    public zzgen(Executor executor, zzgcn zzgcnVar) {
        this.zza = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zza(Runnable runnable, long j3) {
        if (j3 <= 0) {
            this.zza.execute(runnable);
            return;
        }
        zzgep zzgepVar = new zzgep(runnable, System.currentTimeMillis() + j3);
        Queue queue = this.zzb;
        synchronized (queue) {
            queue.add(zzgepVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zzb() {
        Queue queue = this.zzb;
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                    return;
                }
                PriorityQueue priorityQueue = new PriorityQueue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (zzgep zzgepVar = (zzgep) queue.peek(); zzgepVar != null && zzgepVar.zzb <= jCurrentTimeMillis; zzgepVar = (zzgep) queue.peek()) {
                    priorityQueue.add(zzgepVar);
                }
                Iterator it = priorityQueue.iterator();
                while (it.hasNext()) {
                    try {
                        this.zza.execute(((zzgep) it.next()).zza);
                    } catch (RuntimeException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
