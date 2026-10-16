package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzpu;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f74530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f74531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.zzii f74532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitSet f74533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BitSet f74534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f74535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f74536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzad f74537h;

    /* synthetic */ zzy(zzad zzadVar, String str, com.google.android.gms.internal.measurement.zzii zziiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.f74537h = zzadVar;
        this.f74530a = str;
        this.f74533d = bitSet;
        this.f74534e = bitSet2;
        this.f74535f = map;
        this.f74536g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f74536g.put(num, arrayList);
        }
        this.f74531b = false;
        this.f74532c = zziiVar;
    }

    final void a(zzab zzabVar) {
        int iA = zzabVar.a();
        if (zzabVar.f73372c != null) {
            this.f74534e.set(iA, true);
        }
        Boolean bool = zzabVar.f73373d;
        if (bool != null) {
            this.f74533d.set(iA, bool.booleanValue());
        }
        if (zzabVar.f73374e != null) {
            Map map = this.f74535f;
            Integer numValueOf = Integer.valueOf(iA);
            Long l3 = (Long) map.get(numValueOf);
            long jLongValue = zzabVar.f73374e.longValue() / 1000;
            if (l3 == null || jLongValue > l3.longValue()) {
                this.f74535f.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.f73375f != null) {
            Map map2 = this.f74536g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f74536g.put(numValueOf2, arrayList);
            }
            if (zzabVar.b()) {
                arrayList.clear();
            }
            zzpu.zza();
            zzic zzicVar = this.f74537h.f73997a;
            zzal zzalVarW = zzicVar.w();
            String str = this.f74530a;
            zzfx zzfxVar = zzfy.G0;
            if (zzalVarW.H(str, zzfxVar) && zzabVar.c()) {
                arrayList.clear();
            }
            zzpu.zza();
            if (!zzicVar.w().H(this.f74530a, zzfxVar)) {
                arrayList.add(Long.valueOf(zzabVar.f73375f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(zzabVar.f73375f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    final com.google.android.gms.internal.measurement.zzhg b(int i3) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzhf zzhfVarZzh = com.google.android.gms.internal.measurement.zzhg.zzh();
        zzhfVarZzh.zza(i3);
        zzhfVarZzh.zzd(this.f74531b);
        com.google.android.gms.internal.measurement.zzii zziiVar = this.f74532c;
        if (zziiVar != null) {
            zzhfVarZzh.zzc(zziiVar);
        }
        com.google.android.gms.internal.measurement.zzih zzihVarZzi = com.google.android.gms.internal.measurement.zzii.zzi();
        zzihVarZzi.zzc(zzpk.Q(this.f74533d));
        zzihVarZzi.zza(zzpk.Q(this.f74534e));
        Map map = this.f74535f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f74535f.keySet()) {
                int iIntValue = num.intValue();
                Long l3 = (Long) this.f74535f.get(num);
                if (l3 != null) {
                    com.google.android.gms.internal.measurement.zzhp zzhpVarZze = com.google.android.gms.internal.measurement.zzhq.zze();
                    zzhpVarZze.zza(iIntValue);
                    zzhpVarZze.zzb(l3.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zzhpVarZze.zzbc());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzihVarZzi.zze(arrayList);
        }
        Map map2 = this.f74536g;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f74536g.keySet()) {
                com.google.android.gms.internal.measurement.zzij zzijVarZzf = com.google.android.gms.internal.measurement.zzik.zzf();
                zzijVarZzf.zza(num2.intValue());
                List list2 = (List) this.f74536g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzijVarZzf.zzb(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzik) zzijVarZzf.zzbc());
            }
            list = arrayList3;
        }
        zzihVarZzi.zzg(list);
        zzhfVarZzh.zzb(zzihVarZzi);
        return (com.google.android.gms.internal.measurement.zzhg) zzhfVarZzh.zzbc();
    }

    final /* synthetic */ BitSet c() {
        return this.f74533d;
    }

    /* synthetic */ zzy(zzad zzadVar, String str, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.f74537h = zzadVar;
        this.f74530a = str;
        this.f74531b = true;
        this.f74533d = new BitSet();
        this.f74534e = new BitSet();
        this.f74535f = new ArrayMap();
        this.f74536g = new ArrayMap();
    }
}
