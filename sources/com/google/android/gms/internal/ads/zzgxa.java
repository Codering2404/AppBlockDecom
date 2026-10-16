package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxa {
    public static boolean zza(Iterable iterable, zzgtk zzgtkVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzgtkVar.getClass();
            return zzc((List) iterable, zzgtkVar);
        }
        Iterator it = iterable.iterator();
        zzgtkVar.getClass();
        boolean z2 = false;
        while (it.hasNext()) {
            if (zzgtkVar.zza(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static Object zzb(Iterable iterable, Object obj) {
        zzgza it = ((zzgyr) iterable).iterator();
        return it.hasNext() ? it.next() : obj;
    }

    private static boolean zzc(List list, zzgtk zzgtkVar) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < list.size()) {
            Object obj = list.get(i3);
            if (!zzgtkVar.zza(obj)) {
                if (i3 > i4) {
                    try {
                        list.set(i4, obj);
                    } catch (IllegalArgumentException unused) {
                        zzd(list, zzgtkVar, i4, i3);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzd(list, zzgtkVar, i4, i3);
                        return true;
                    }
                }
                i4++;
            }
            i3++;
        }
        list.subList(i4, list.size()).clear();
        return i3 != i4;
    }

    private static void zzd(List list, zzgtk zzgtkVar, int i3, int i4) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i4) {
                break;
            } else if (zzgtkVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i4--;
            if (i4 < i3) {
                return;
            } else {
                list.remove(i4);
            }
        }
    }
}
