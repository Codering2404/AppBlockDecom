package com.google.android.gms.internal.ads;

import android.media.AudioDescriptor;
import android.os.Build;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqq {
    public static zzgwm zza(List list) {
        if (Build.VERSION.SDK_INT < 31 || list == null) {
            return zzgwm.zzi();
        }
        TreeSet treeSet = new TreeSet(Comparator.comparing(zzqp.zza).reversed());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioDescriptor audioDescriptorA = z.a(it.next());
            if (audioDescriptorA.getStandard() == 1) {
                byte[] descriptor = audioDescriptorA.getDescriptor();
                int length = descriptor.length;
                if (length != 3) {
                    StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 20);
                    sb.append("Invalid SAD length: ");
                    sb.append(length);
                    zzeg.zzc(sKeKFMqmvNzY.IMSXwgCETF, sb.toString());
                } else {
                    byte b3 = descriptor[0];
                    int i3 = (b3 & 7) + 1;
                    if (((b3 >> 3) & 15) == 1) {
                        treeSet.add(Integer.valueOf(zzfl.zzE(i3)));
                    }
                }
            }
        }
        return zzgwm.zzq(treeSet);
    }
}
