package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbfz {
    public static void zza(String[] strArr, int i3, int i4, PriorityQueue priorityQueue) {
        int length = strArr.length;
        if (length < 6) {
            zzb(i3, zze(strArr, 0, length), zzc(strArr, 0, length), length, priorityQueue);
            return;
        }
        long jZze = zze(strArr, 0, 6);
        zzb(i3, jZze, zzc(strArr, 0, 6), 6, priorityQueue);
        int i5 = 1;
        while (true) {
            int length2 = strArr.length;
            if (i5 >= length2 - 5) {
                return;
            }
            long jZza = zzbfw.zza(strArr[i5 - 1]);
            long jZza2 = zzbfw.zza(strArr[i5 + 5]);
            String strZzc = zzc(strArr, i5, 6);
            jZze = ((((((jZze + 1073807359) - ((zzd(16785407L, 5) * ((jZza + 2147483647L) % 1073807359)) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((jZza2 + 2147483647L) % 1073807359)) % 1073807359;
            zzb(i3, jZze, strZzc, length2, priorityQueue);
            i5++;
        }
    }

    static void zzb(int i3, long j3, String str, int i4, PriorityQueue priorityQueue) {
        zzbfy zzbfyVar = new zzbfy(j3, str, i4);
        if ((priorityQueue.size() != i3 || (((zzbfy) priorityQueue.peek()).zzc <= zzbfyVar.zzc && ((zzbfy) priorityQueue.peek()).zza <= zzbfyVar.zza)) && !priorityQueue.contains(zzbfyVar)) {
            priorityQueue.add(zzbfyVar);
            if (priorityQueue.size() > i3) {
                priorityQueue.poll();
            }
        }
    }

    static String zzc(String[] strArr, int i3, int i4) {
        int i5 = i4 + i3;
        if (strArr.length < i5) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i7 = i5 - 1;
            if (i3 >= i7) {
                sb.append(strArr[i7]);
                return sb.toString();
            }
            sb.append(strArr[i3]);
            sb.append(' ');
            i3++;
        }
    }

    static long zzd(long j3, int i3) {
        if (i3 == 1) {
            return j3;
        }
        int i4 = i3 >> 1;
        long j4 = (j3 * j3) % 1073807359;
        return ((i3 & 1) == 0 ? zzd(j4, i4) : j3 * (zzd(j4, i4) % 1073807359)) % 1073807359;
    }

    private static long zze(String[] strArr, int i3, int i4) {
        long jZza = (((long) zzbfw.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i5 = 1; i5 < i4; i5++) {
            jZza = (((jZza * 16785407) % 1073807359) + ((((long) zzbfw.zza(strArr[i5])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return jZza;
    }
}
