package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzbbx;
import com.google.android.libraries.places.internal.zzbby;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbbx<MessageType extends zzbby<MessageType, BuilderType>, BuilderType extends zzbbx<MessageType, BuilderType>> implements zzbew {
    private static void m(List list, int i3) {
        int size = list.size() - i3;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String string = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i3) {
                throw new NullPointerException(string);
            }
            list.remove(size2);
        }
    }

    protected static void q(Iterable iterable, List list) {
        byte[] bArr = zzbeb.f76092b;
        iterable.getClass();
        if (!(iterable instanceof zzbej)) {
            if (iterable instanceof zzbfg) {
                list.addAll((Collection) iterable);
                return;
            }
            if (iterable instanceof Collection) {
                int size = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size);
                } else if (list instanceof zzbfi) {
                    ((zzbfi) list).d(list.size() + size);
                }
            }
            int size2 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object obj : iterable) {
                    if (obj == null) {
                        m(list, size2);
                    }
                    list.add(obj);
                }
                return;
            }
            List list2 = (List) iterable;
            int size3 = list2.size();
            for (int i3 = 0; i3 < size3; i3++) {
                Object obj2 = list2.get(i3);
                if (obj2 == null) {
                    m(list, size2);
                }
                list.add(obj2);
            }
            return;
        }
        List listZza = ((zzbej) iterable).zza();
        zzbej zzbejVar = (zzbej) list;
        int size4 = list.size();
        for (Object obj3 : listZza) {
            if (obj3 == null) {
                int size5 = zzbejVar.size() - size4;
                StringBuilder sb = new StringBuilder(String.valueOf(size5).length() + 26);
                sb.append("Element at index ");
                sb.append(size5);
                sb.append(" is null.");
                String string = sb.toString();
                int size6 = zzbejVar.size();
                while (true) {
                    size6--;
                    if (size6 < size4) {
                        throw new NullPointerException(string);
                    }
                    zzbejVar.remove(size6);
                }
            } else if (obj3 instanceof zzbcl) {
                zzbejVar.zzb();
            } else if (obj3 instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj3;
                try {
                    zzbcl.n(bArr2, 0, bArr2.length, false);
                    zzbejVar.zzb();
                } catch (zzbed e3) {
                    throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
                }
            } else {
                zzbejVar.add((String) obj3);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbew
    public final /* bridge */ /* synthetic */ zzbew a1(zzbex zzbexVar) {
        if (e().getClass().isInstance(zzbexVar)) {
            return p((zzbby) zzbexVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.libraries.places.internal.zzbew
    public /* bridge */ /* synthetic */ zzbew m2(zzbco zzbcoVar, zzbdb zzbdbVar) {
        throw null;
    }

    @Override // 
    public abstract zzbbx o();

    protected abstract zzbbx p(zzbby zzbbyVar);
}
