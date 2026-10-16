package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzign extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzigm zze;
    private Map zzf;

    private zzign() {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final Object zzg(int i3) {
        zzh();
        Object value = ((zzigk) this.zza[i3]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i3 + 1, objArr, i3, (this.zzb - i3) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzo().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i4 = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i4] = new zzigk(this, (Comparable) entry.getKey(), entry.getValue());
            this.zzb++;
            it.remove();
        }
        return value;
    }

    private final int zzm(Comparable comparable) {
        int i3 = this.zzb;
        int i4 = i3 - 1;
        int i5 = 0;
        if (i4 >= 0) {
            int iCompareTo = comparable.compareTo(((zzigk) this.zza[i4]).zza());
            if (iCompareTo > 0) {
                return -(i3 + 1);
            }
            if (iCompareTo == 0) {
                return i4;
            }
        }
        while (i5 <= i4) {
            int i6 = (i5 + i4) / 2;
            int iCompareTo2 = comparable.compareTo(((zzigk) this.zza[i6]).zza());
            if (iCompareTo2 < 0) {
                i4 = i6 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i6;
                }
                i5 = i6 + 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final void zzh() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap zzo() {
        zzh();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzh();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzm(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzigm(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzign)) {
            return super.equals(obj);
        }
        zzign zzignVar = (zzign) obj;
        int size = size();
        if (size != zzignVar.size()) {
            return false;
        }
        int i3 = this.zzb;
        if (i3 != zzignVar.zzb) {
            return entrySet().equals(zzignVar.entrySet());
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!zzd(i4).equals(zzignVar.zzd(i4))) {
                return false;
            }
        }
        if (i3 != size) {
            return this.zzc.equals(zzignVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzm = zzm(comparable);
        return iZzm >= 0 ? ((zzigk) this.zza[iZzm]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i3 = this.zzb;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode += this.zza[i4].hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzh();
        Comparable comparable = (Comparable) obj;
        int iZzm = zzm(comparable);
        if (iZzm >= 0) {
            return zzg(iZzm);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb + this.zzc.size();
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Map.Entry zzd(int i3) {
        if (i3 < this.zzb) {
            return (zzigk) this.zza[i3];
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public final Iterable zze() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzh();
        int iZzm = zzm(comparable);
        if (iZzm >= 0) {
            return ((zzigk) this.zza[iZzm]).setValue(obj);
        }
        zzh();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i3 = -(iZzm + 1);
        if (i3 >= 16) {
            return zzo().put(comparable, obj);
        }
        if (this.zzb == 16) {
            zzigk zzigkVar = (zzigk) this.zza[15];
            this.zzb = 15;
            zzo().put(zzigkVar.zza(), zzigkVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i3, objArr, i3 + 1, 15 - i3);
        this.zza[i3] = new zzigk(this, comparable, obj);
        this.zzb++;
        return null;
    }

    final /* synthetic */ Object[] zzi() {
        return this.zza;
    }

    final /* synthetic */ int zzj() {
        return this.zzb;
    }

    final /* synthetic */ Map zzk() {
        return this.zzc;
    }

    /* synthetic */ zzign(byte[] bArr) {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }
}
