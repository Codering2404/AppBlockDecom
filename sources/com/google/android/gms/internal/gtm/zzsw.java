package com.google.android.gms.internal.gtm;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzsw implements Map, Serializable {

    @CheckForNull
    private transient zzsx zza;

    @CheckForNull
    private transient zzsx zzb;

    @CheckForNull
    private transient zzsq zzc;

    zzsw() {
    }

    public static zzsw zzc(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        zzso.zza(obj, obj2);
        zzso.zza(obj3, obj4);
        zzso.zza(obj5, obj6);
        zzso.zza(obj7, obj8);
        zzso.zza(obj9, obj10);
        zzso.zza(obj11, "&cu");
        return zzte.zzg(6, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, "&cu"}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zztg.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzsx zzsxVar = this.zzb;
        if (zzsxVar != null) {
            return zzsxVar;
        }
        zzsx zzsxVarZze = zze();
        this.zzb = zzsxVarZze;
        return zzsxVarZze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z2 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzsq zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzsq values() {
        zzsq zzsqVar = this.zzc;
        if (zzsqVar != null) {
            return zzsqVar;
        }
        zzsq zzsqVarZza = zza();
        this.zzc = zzsqVarZza;
        return zzsqVarZza;
    }

    abstract zzsx zzd();

    abstract zzsx zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzsx entrySet() {
        zzsx zzsxVar = this.zza;
        if (zzsxVar != null) {
            return zzsxVar;
        }
        zzsx zzsxVarZzd = zzd();
        this.zza = zzsxVarZzd;
        return zzsxVarZzd;
    }
}
