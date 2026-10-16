package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzui {
    public final int zza;
    public final zzxk zzb;
    private final CopyOnWriteArrayList zzc;

    private zzui(CopyOnWriteArrayList copyOnWriteArrayList, int i3, zzxk zzxkVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzxkVar;
    }

    public final zzui zza(int i3, zzxk zzxkVar) {
        return new zzui(this.zzc, 0, zzxkVar);
    }

    public final void zzb(Handler handler, zzuj zzujVar) {
        this.zzc.add(new zzuh(handler, zzujVar));
    }

    public final void zzc(zzuj zzujVar) {
        CopyOnWriteArrayList<zzuh> copyOnWriteArrayList = this.zzc;
        for (zzuh zzuhVar : copyOnWriteArrayList) {
            if (zzuhVar.zza == zzujVar) {
                copyOnWriteArrayList.remove(zzuhVar);
            }
        }
    }

    public zzui() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
