package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzibw extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzibp();
    zzibv zza;
    int zzb;
    int zzc;
    final zzibv zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzibr zzh;
    private zzibt zzi;

    public zzibw() {
        this(zze, true);
    }

    private final void zzf(zzibv zzibvVar, zzibv zzibvVar2) {
        zzibv zzibvVar3 = zzibvVar.zza;
        zzibvVar.zza = null;
        if (zzibvVar2 != null) {
            zzibvVar2.zza = zzibvVar3;
        }
        if (zzibvVar3 == null) {
            this.zza = zzibvVar2;
        } else if (zzibvVar3.zzb == zzibvVar) {
            zzibvVar3.zzb = zzibvVar2;
        } else {
            zzibvVar3.zzc = zzibvVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzg(com.google.android.gms.internal.ads.zzibv r9, boolean r10) {
        /*
            r8 = this;
        L0:
            if (r9 == 0) goto L84
            com.google.android.gms.internal.ads.zzibv r0 = r9.zzb
            com.google.android.gms.internal.ads.zzibv r1 = r9.zzc
            r2 = 0
            if (r0 == 0) goto Lc
            int r3 = r0.zzi
            goto Ld
        Lc:
            r3 = r2
        Ld:
            if (r1 == 0) goto L12
            int r4 = r1.zzi
            goto L13
        L12:
            r4 = r2
        L13:
            int r5 = r3 - r4
            r6 = -2
            r7 = 1
            if (r5 != r6) goto L42
            com.google.android.gms.internal.ads.zzibv r0 = r1.zzb
            com.google.android.gms.internal.ads.zzibv r3 = r1.zzc
            if (r3 == 0) goto L22
            int r3 = r3.zzi
            goto L23
        L22:
            r3 = r2
        L23:
            if (r0 == 0) goto L28
            int r0 = r0.zzi
            goto L29
        L28:
            r0 = r2
        L29:
            int r0 = r0 - r3
            r3 = -1
            if (r0 == r3) goto L3a
            if (r0 != 0) goto L32
            if (r10 != 0) goto L33
            goto L3b
        L32:
            r7 = r10
        L33:
            r8.zzi(r1)
            r8.zzh(r9)
            goto L3f
        L3a:
            r2 = r10
        L3b:
            r8.zzh(r9)
            r7 = r2
        L3f:
            if (r7 != 0) goto L84
            goto L80
        L42:
            r1 = 2
            if (r5 != r1) goto L6d
            com.google.android.gms.internal.ads.zzibv r1 = r0.zzb
            com.google.android.gms.internal.ads.zzibv r3 = r0.zzc
            if (r3 == 0) goto L4e
            int r3 = r3.zzi
            goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r1 == 0) goto L54
            int r1 = r1.zzi
            goto L55
        L54:
            r1 = r2
        L55:
            int r1 = r1 - r3
            if (r1 == r7) goto L65
            if (r1 != 0) goto L5d
            if (r10 != 0) goto L5e
            goto L66
        L5d:
            r7 = r10
        L5e:
            r8.zzh(r0)
            r8.zzi(r9)
            goto L6a
        L65:
            r2 = r10
        L66:
            r8.zzi(r9)
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            goto L84
        L6d:
            if (r5 != 0) goto L76
            int r3 = r3 + 1
            r9.zzi = r3
            if (r10 == 0) goto L80
            goto L84
        L76:
            int r0 = java.lang.Math.max(r3, r4)
            int r0 = r0 + r7
            r9.zzi = r0
            if (r10 != 0) goto L80
            goto L84
        L80:
            com.google.android.gms.internal.ads.zzibv r9 = r9.zza
            goto L0
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzibw.zzg(com.google.android.gms.internal.ads.zzibv, boolean):void");
    }

    private final void zzh(zzibv zzibvVar) {
        zzibv zzibvVar2 = zzibvVar.zzb;
        zzibv zzibvVar3 = zzibvVar.zzc;
        zzibv zzibvVar4 = zzibvVar3.zzb;
        zzibv zzibvVar5 = zzibvVar3.zzc;
        zzibvVar.zzc = zzibvVar4;
        if (zzibvVar4 != null) {
            zzibvVar4.zza = zzibvVar;
        }
        zzf(zzibvVar, zzibvVar3);
        zzibvVar3.zzb = zzibvVar;
        zzibvVar.zza = zzibvVar3;
        int iMax = Math.max(zzibvVar2 != null ? zzibvVar2.zzi : 0, zzibvVar4 != null ? zzibvVar4.zzi : 0) + 1;
        zzibvVar.zzi = iMax;
        zzibvVar3.zzi = Math.max(iMax, zzibvVar5 != null ? zzibvVar5.zzi : 0) + 1;
    }

    private final void zzi(zzibv zzibvVar) {
        zzibv zzibvVar2 = zzibvVar.zzb;
        zzibv zzibvVar3 = zzibvVar.zzc;
        zzibv zzibvVar4 = zzibvVar2.zzb;
        zzibv zzibvVar5 = zzibvVar2.zzc;
        zzibvVar.zzb = zzibvVar5;
        if (zzibvVar5 != null) {
            zzibvVar5.zza = zzibvVar;
        }
        zzf(zzibvVar, zzibvVar2);
        zzibvVar2.zzc = zzibvVar;
        zzibvVar.zza = zzibvVar2;
        int iMax = Math.max(zzibvVar3 != null ? zzibvVar3.zzi : 0, zzibvVar5 != null ? zzibvVar5.zzi : 0) + 1;
        zzibvVar.zzi = iMax;
        zzibvVar2.zzi = Math.max(iMax, zzibvVar4 != null ? zzibvVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzibv zzibvVar = this.zzd;
        zzibvVar.zze = zzibvVar;
        zzibvVar.zzd = zzibvVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzb(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzibr zzibrVar = this.zzh;
        if (zzibrVar != null) {
            return zzibrVar;
        }
        zzibr zzibrVar2 = new zzibr(this);
        this.zzh = zzibrVar2;
        return zzibrVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzibv zzibvVarZzb = zzb(obj);
        if (zzibvVarZzb != null) {
            return zzibvVarZzb.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzibt zzibtVar = this.zzi;
        if (zzibtVar != null) {
            return zzibtVar;
        }
        zzibt zzibtVar2 = new zzibt(this);
        this.zzi = zzibtVar2;
        return zzibtVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzibv zzibvVarZza = zza(obj, true);
        Object obj3 = zzibvVarZza.zzh;
        zzibvVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzibv zzibvVarZze = zze(obj);
        if (zzibvVarZze != null) {
            return zzibvVarZze.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzibv zza(Object obj, boolean z2) {
        int iCompareTo;
        zzibv zzibvVar;
        Comparator comparator = this.zzf;
        zzibv zzibvVar2 = this.zza;
        if (zzibvVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzibvVar2.zzf) : comparator.compare(obj, zzibvVar2.zzf);
                if (iCompareTo == 0) {
                    return zzibvVar2;
                }
                zzibv zzibvVar3 = iCompareTo < 0 ? zzibvVar2.zzb : zzibvVar2.zzc;
                if (zzibvVar3 == null) {
                    break;
                }
                zzibvVar2 = zzibvVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i3 = iCompareTo;
        if (!z2) {
            return null;
        }
        zzibv zzibvVar4 = this.zzd;
        if (zzibvVar2 != null) {
            zzibv zzibvVar5 = zzibvVar2;
            zzibvVar = new zzibv(this.zzg, zzibvVar5, obj, zzibvVar4, zzibvVar4.zze);
            if (i3 < 0) {
                zzibvVar5.zzb = zzibvVar;
            } else {
                zzibvVar5.zzc = zzibvVar;
            }
            zzg(zzibvVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzibvVar = new zzibv(this.zzg, null, obj, zzibvVar4, zzibvVar4.zze);
            this.zza = zzibvVar;
        }
        this.zzb++;
        this.zzc++;
        return zzibvVar;
    }

    final zzibv zzb(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    final zzibv zzc(Map.Entry entry) {
        zzibv zzibvVarZzb = zzb(entry.getKey());
        if (zzibvVarZzb == null || !Objects.equals(zzibvVarZzb.zzh, entry.getValue())) {
            return null;
        }
        return zzibvVarZzb;
    }

    final void zzd(zzibv zzibvVar, boolean z2) {
        zzibv zzibvVar2;
        zzibv zzibvVar3;
        int i3;
        if (z2) {
            zzibv zzibvVar4 = zzibvVar.zze;
            zzibvVar4.zzd = zzibvVar.zzd;
            zzibvVar.zzd.zze = zzibvVar4;
        }
        zzibv zzibvVar5 = zzibvVar.zzb;
        zzibv zzibvVar6 = zzibvVar.zzc;
        zzibv zzibvVar7 = zzibvVar.zza;
        int i4 = 0;
        if (zzibvVar5 == null || zzibvVar6 == null) {
            if (zzibvVar5 != null) {
                zzf(zzibvVar, zzibvVar5);
                zzibvVar.zzb = null;
            } else if (zzibvVar6 != null) {
                zzf(zzibvVar, zzibvVar6);
                zzibvVar.zzc = null;
            } else {
                zzf(zzibvVar, null);
            }
            zzg(zzibvVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzibvVar5.zzi > zzibvVar6.zzi) {
            do {
                zzibvVar3 = zzibvVar5;
                zzibvVar5 = zzibvVar5.zzc;
            } while (zzibvVar5 != null);
        } else {
            do {
                zzibvVar2 = zzibvVar6;
                zzibvVar6 = zzibvVar6.zzb;
            } while (zzibvVar6 != null);
            zzibvVar3 = zzibvVar2;
        }
        zzd(zzibvVar3, false);
        zzibv zzibvVar8 = zzibvVar.zzb;
        if (zzibvVar8 != null) {
            i3 = zzibvVar8.zzi;
            zzibvVar3.zzb = zzibvVar8;
            zzibvVar8.zza = zzibvVar3;
            zzibvVar.zzb = null;
        } else {
            i3 = 0;
        }
        zzibv zzibvVar9 = zzibvVar.zzc;
        if (zzibvVar9 != null) {
            i4 = zzibvVar9.zzi;
            zzibvVar3.zzc = zzibvVar9;
            zzibvVar9.zza = zzibvVar3;
            zzibvVar.zzc = null;
        }
        zzibvVar3.zzi = Math.max(i3, i4) + 1;
        zzf(zzibvVar, zzibvVar3);
    }

    final zzibv zze(Object obj) {
        zzibv zzibvVarZzb = zzb(obj);
        if (zzibvVarZzb != null) {
            zzd(zzibvVarZzb, true);
        }
        return zzibvVarZzb;
    }

    public zzibw(Comparator comparator, boolean z2) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z2;
        this.zzd = new zzibv(z2);
    }

    public zzibw(boolean z2) {
        this(zze, false);
    }
}
