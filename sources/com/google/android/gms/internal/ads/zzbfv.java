package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfv {
    private final int zza;
    private final zzbfs zzb = new zzbfx();

    public zzbfv(int i3) {
        this.zza = i3;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append(((String) arrayList.get(i3)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzbfu zzbfuVar = new zzbfu();
        int i4 = this.zza;
        PriorityQueue priorityQueue = new PriorityQueue(i4, new zzbft(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzbfw.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzbfz.zza(strArrZzb, i4, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbfuVar.zzb.write(this.zzb.zza(((zzbfy) it.next()).zzb));
            } catch (IOException e3) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error while writing hash to byteStream", e3);
            }
        }
        return zzbfuVar.toString();
    }
}
