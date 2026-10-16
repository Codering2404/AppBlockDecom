package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzang<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private Object[] zza;
    private int zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzanm zze;
    private Map<K, V> zzf;

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
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
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzanm(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzang)) {
            return super.equals(obj);
        }
        zzang zzangVar = (zzang) obj;
        int size = size();
        if (size != zzangVar.size()) {
            return false;
        }
        int i3 = this.zzb;
        if (i3 != zzangVar.zzb) {
            return entrySet().equals(zzangVar.entrySet());
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!zza(i4).equals(zzangVar.zza(i4))) {
                return false;
            }
        }
        if (i3 != size) {
            return this.zzc.equals(zzangVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) ((zzank) this.zza[iZza]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i3 = this.zzb;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode += this.zza[i4].hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzb(iZza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb + this.zzc.size();
    }

    private zzang() {
        Map<K, V> map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    final Set<Map.Entry<K, V>> zzd() {
        return new zzanh(this);
    }

    public final boolean zze() {
        return this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zza(K r5) {
        /*
            r4 = this;
            int r0 = r4.zzb
            int r1 = r0 + (-1)
            if (r1 < 0) goto L1f
            java.lang.Object[] r2 = r4.zza
            r2 = r2[r1]
            com.google.android.gms.internal.firebase-auth-api.zzank r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzank) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1c
            int r0 = r0 + 1
        L1a:
            int r5 = -r0
            return r5
        L1c:
            if (r2 != 0) goto L1f
            return r1
        L1f:
            r0 = 0
        L20:
            if (r0 > r1) goto L41
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.lang.Object[] r3 = r4.zza
            r3 = r3[r2]
            com.google.android.gms.internal.firebase-auth-api.zzank r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzank) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3b
            int r1 = r2 + (-1)
            goto L20
        L3b:
            if (r3 <= 0) goto L40
            int r0 = r2 + 1
            goto L20
        L40:
            return r2
        L41:
            int r0 = r0 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzang.zza(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzb(int i3) {
        zzg();
        V v2 = (V) ((zzank) this.zza[i3]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i3 + 1, objArr, i3, (this.zzb - i3) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zza[this.zzb] = new zzank(this, it.next());
            this.zzb++;
            it.remove();
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k3, V v2) {
        zzg();
        int iZza = zza(k3);
        if (iZza >= 0) {
            return (V) ((zzank) this.zza[iZza]).setValue(v2);
        }
        zzg();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i3 = -(iZza + 1);
        if (i3 >= 16) {
            return zzf().put(k3, v2);
        }
        int i4 = this.zzb;
        if (i4 == 16) {
            zzank zzankVar = (zzank) this.zza[15];
            this.zzb = i4 - 1;
            zzf().put((Comparable) zzankVar.getKey(), zzankVar.getValue());
        }
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i3, objArr, i3 + 1, (objArr.length - i3) - 1);
        this.zza[i3] = new zzank(this, k3, v2);
        this.zzb++;
        return null;
    }

    public final Map.Entry<K, V> zza(int i3) {
        if (i3 < this.zzb) {
            return (zzank) this.zza[i3];
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public void zza() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = mapUnmodifiableMap;
        if (this.zzf.isEmpty()) {
            mapUnmodifiableMap2 = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = mapUnmodifiableMap2;
        this.zzd = true;
    }
}
