package com.google.android.recaptcha.internal;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzpe extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzpc zze;
    private Map zzf;

    private zzpe() {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    private final int zzl(Comparable comparable) {
        int i3 = this.zzb;
        int i4 = i3 - 1;
        int i5 = 0;
        if (i4 >= 0) {
            int iCompareTo = comparable.compareTo(((zzpa) this.zza[i4]).zza());
            if (iCompareTo > 0) {
                return -(i3 + 1);
            }
            if (iCompareTo == 0) {
                return i4;
            }
        }
        while (i5 <= i4) {
            int i6 = (i5 + i4) / 2;
            int iCompareTo2 = comparable.compareTo(((zzpa) this.zza[i6]).zza());
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
    public final Object zzm(int i3) {
        zzo();
        Object value = ((zzpa) this.zza[i3]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i3 + 1, objArr, i3, (this.zzb - i3) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzn().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i4 = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i4] = new zzpa(this, (Comparable) entry.getKey(), entry.getValue());
            this.zzb++;
            it.remove();
        }
        return value;
    }

    private final SortedMap zzn() {
        zzo();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzo();
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
        return zzl(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzpc(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpe)) {
            return super.equals(obj);
        }
        zzpe zzpeVar = (zzpe) obj;
        int size = size();
        if (size != zzpeVar.size()) {
            return false;
        }
        int i3 = this.zzb;
        if (i3 != zzpeVar.zzb) {
            return entrySet().equals(zzpeVar.entrySet());
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!zzg(i4).equals(zzpeVar.zzg(i4))) {
                return false;
            }
        }
        if (i3 != size) {
            return this.zzc.equals(zzpeVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzl = zzl(comparable);
        return iZzl >= 0 ? ((zzpa) this.zza[iZzl]).getValue() : this.zzc.get(comparable);
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
        zzo();
        Comparable comparable = (Comparable) obj;
        int iZzl = zzl(comparable);
        if (iZzl >= 0) {
            return zzm(iZzl);
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

    public final int zzc() {
        return this.zzb;
    }

    public final Iterable zzd() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzo();
        int iZzl = zzl(comparable);
        if (iZzl >= 0) {
            return ((zzpa) this.zza[iZzl]).setValue(obj);
        }
        zzo();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i3 = -(iZzl + 1);
        if (i3 >= 16) {
            return zzn().put(comparable, obj);
        }
        if (this.zzb == 16) {
            zzpa zzpaVar = (zzpa) this.zza[15];
            this.zzb = 15;
            zzn().put(zzpaVar.zza(), zzpaVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i3, objArr, i3 + 1, 15 - i3);
        this.zza[i3] = new zzpa(this, comparable, obj);
        this.zzb++;
        return null;
    }

    public final Map.Entry zzg(int i3) {
        if (i3 < this.zzb) {
            return (zzpa) this.zza[i3];
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    /* synthetic */ zzpe(zzpd zzpdVar) {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }
}
