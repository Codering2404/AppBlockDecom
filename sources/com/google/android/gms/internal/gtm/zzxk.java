package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxk {
    private static final zzxk zzb = new zzxk(true);
    final zzaag zza = new zzzw(16);
    private boolean zzc;
    private boolean zzd;

    private zzxk() {
    }

    static int zza(zzaba zzabaVar, int i3, Object obj) {
        int iZzd;
        int iZzD;
        int iZzD2 = zzuq.zzD(i3 << 3);
        if (zzabaVar == zzaba.zzj) {
            byte[] bArr = zzye.zzd;
            if (((zzzg) obj) instanceof zztm) {
                throw null;
            }
            iZzD2 += iZzD2;
        }
        zzabb zzabbVar = zzabb.INT;
        int iZzE = 4;
        switch (zzabaVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iZzE = 8;
                return iZzD2 + iZzE;
            case 1:
                ((Float) obj).getClass();
                return iZzD2 + iZzE;
            case 2:
                iZzE = zzuq.zzE(((Long) obj).longValue());
                return iZzD2 + iZzE;
            case 3:
                iZzE = zzuq.zzE(((Long) obj).longValue());
                return iZzD2 + iZzE;
            case 4:
                iZzE = zzuq.zzz(((Integer) obj).intValue());
                return iZzD2 + iZzE;
            case 5:
                ((Long) obj).getClass();
                iZzE = 8;
                return iZzD2 + iZzE;
            case 6:
                ((Integer) obj).getClass();
                return iZzD2 + iZzE;
            case 7:
                ((Boolean) obj).getClass();
                iZzE = 1;
                return iZzD2 + iZzE;
            case 8:
                if (!(obj instanceof zzud)) {
                    iZzE = zzuq.zzC((String) obj);
                    return iZzD2 + iZzE;
                }
                iZzd = ((zzud) obj).zzd();
                iZzD = zzuq.zzD(iZzd);
                iZzE = iZzD + iZzd;
                return iZzD2 + iZzE;
            case 9:
                iZzE = ((zzzg) obj).zzX();
                return iZzD2 + iZzE;
            case 10:
                if (!(obj instanceof zzyl)) {
                    iZzE = zzuq.zzA((zzzg) obj);
                    return iZzD2 + iZzE;
                }
                iZzd = ((zzyl) obj).zza();
                iZzD = zzuq.zzD(iZzd);
                iZzE = iZzD + iZzd;
                return iZzD2 + iZzE;
            case 11:
                if (obj instanceof zzud) {
                    iZzd = ((zzud) obj).zzd();
                    iZzD = zzuq.zzD(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iZzD = zzuq.zzD(iZzd);
                }
                iZzE = iZzD + iZzd;
                return iZzD2 + iZzE;
            case 12:
                iZzE = zzuq.zzD(((Integer) obj).intValue());
                return iZzD2 + iZzE;
            case 13:
                iZzE = obj instanceof zzxx ? zzuq.zzz(((zzxx) obj).zza()) : zzuq.zzz(((Integer) obj).intValue());
                return iZzD2 + iZzE;
            case 14:
                ((Integer) obj).getClass();
                return iZzD2 + iZzE;
            case 15:
                ((Long) obj).getClass();
                iZzE = 8;
                return iZzD2 + iZzE;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iZzE = zzuq.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzD2 + iZzE;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iZzE = zzuq.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzD2 + iZzE;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzxj zzxjVar, Object obj) {
        zzaba zzabaVarZzd = zzxjVar.zzd();
        int iZza = zzxjVar.zza();
        if (!zzxjVar.zzg()) {
            return zza(zzabaVarZzd, iZza, obj);
        }
        zzxjVar.zzf();
        Iterator it = ((List) obj).iterator();
        int iZza2 = 0;
        while (it.hasNext()) {
            iZza2 += zza(zzabaVarZzd, iZza, it.next());
        }
        return iZza2;
    }

    public static zzxk zze() {
        return zzb;
    }

    private static Object zzn(Object obj) {
        if (obj instanceof zzzl) {
            return ((zzzl) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzo(Map.Entry entry) {
        zzzg zzzgVarZzD;
        zzxj zzxjVar = (zzxj) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzyl) {
            throw null;
        }
        if (zzxjVar.zzg()) {
            Object objZzf = zzf(zzxjVar);
            if (objZzf == null) {
                objZzf = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZzf).add(zzn(it.next()));
            }
            this.zza.put(zzxjVar, objZzf);
            return;
        }
        if (zzxjVar.zze() != zzabb.MESSAGE) {
            this.zza.put(zzxjVar, zzn(value));
            return;
        }
        Object objZzf2 = zzf(zzxjVar);
        if (objZzf2 == null) {
            this.zza.put(zzxjVar, zzn(value));
            return;
        }
        if (objZzf2 instanceof zzzl) {
            zzzgVarZzD = zzxjVar.zzc((zzzl) objZzf2, (zzzl) value);
        } else {
            zzzf zzzfVarZzav = ((zzzg) objZzf2).zzav();
            zzxjVar.zzb(zzzfVarZzav, (zzzg) value);
            zzzgVarZzD = zzzfVarZzav.zzD();
        }
        this.zza.put(zzxjVar, zzzgVarZzD);
    }

    private static boolean zzp(Map.Entry entry) {
        zzxj zzxjVar = (zzxj) entry.getKey();
        if (zzxjVar.zze() != zzabb.MESSAGE) {
            return true;
        }
        if (!zzxjVar.zzg()) {
            return zzq(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzq(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzq(Object obj) {
        if (obj instanceof zzzh) {
            return ((zzzh) obj).zzay();
        }
        if (obj instanceof zzyl) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzr(Map.Entry entry) {
        zzxj zzxjVar = (zzxj) entry.getKey();
        Object value = entry.getValue();
        if (zzxjVar.zze() != zzabb.MESSAGE || zzxjVar.zzg()) {
            return zzb(zzxjVar, value);
        }
        zzxjVar.zzf();
        if (!(value instanceof zzyl)) {
            int iZzD = zzuq.zzD(((zzxj) entry.getKey()).zza());
            int iZzD2 = zzuq.zzD(24) + zzuq.zzA((zzzg) value);
            int iZzD3 = zzuq.zzD(16);
            int iZzD4 = zzuq.zzD(8);
            return iZzD4 + iZzD4 + iZzD3 + iZzD + iZzD2;
        }
        int iZzD5 = zzuq.zzD(((zzxj) entry.getKey()).zza());
        int iZza = ((zzyl) value).zza();
        int iZzD6 = zzuq.zzD(iZza) + iZza;
        int iZzD7 = zzuq.zzD(24);
        int iZzD8 = zzuq.zzD(16);
        int iZzD9 = zzuq.zzD(8);
        return iZzD9 + iZzD9 + iZzD8 + iZzD5 + iZzD7 + iZzD6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzs(com.google.android.gms.internal.gtm.zzxj r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.gtm.zzaba r0 = r2.zzd()
            byte[] r1 = com.google.android.gms.internal.gtm.zzye.zzd
            r3.getClass()
            com.google.android.gms.internal.gtm.zzaba r1 = com.google.android.gms.internal.gtm.zzaba.zza
            com.google.android.gms.internal.gtm.zzabb r1 = com.google.android.gms.internal.gtm.zzabb.INT
            com.google.android.gms.internal.gtm.zzabb r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.gtm.zzzg
            if (r0 != 0) goto L21
            boolean r0 = r3 instanceof com.google.android.gms.internal.gtm.zzyl
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r3 instanceof com.google.android.gms.internal.gtm.zzxx
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.gtm.zzud
            if (r0 != 0) goto L33
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
        L33:
            return
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.gtm.zzaba r2 = r2.zzd()
            com.google.android.gms.internal.gtm.zzabb r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzxk.zzs(com.google.android.gms.internal.gtm.zzxj, java.lang.Object):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzxk) {
            return this.zza.equals(((zzxk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzr = 0;
        for (int i3 = 0; i3 < this.zza.zzb(); i3++) {
            iZzr += zzr(this.zza.zzg(i3));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzr += zzr((Map.Entry) it.next());
        }
        return iZzr;
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzxk clone() {
        zzxk zzxkVar = new zzxk();
        for (int i3 = 0; i3 < this.zza.zzb(); i3++) {
            Map.Entry entryZzg = this.zza.zzg(i3);
            zzxkVar.zzk((zzxj) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzxkVar.zzk((zzxj) entry.getKey(), entry.getValue());
        }
        zzxkVar.zzd = this.zzd;
        return zzxkVar;
    }

    public final Object zzf(zzxj zzxjVar) {
        Object obj = this.zza.get(zzxjVar);
        if (obj instanceof zzyl) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzg() {
        return this.zzd ? new zzyk(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzh(zzxj zzxjVar, Object obj) {
        List arrayList;
        if (!((zzxs) zzxjVar).zzd) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zzs(zzxjVar, obj);
        Object objZzf = zzf(zzxjVar);
        if (objZzf == null) {
            arrayList = new ArrayList();
            this.zza.put(zzxjVar, arrayList);
        } else {
            arrayList = (List) objZzf;
        }
        arrayList.add(obj);
    }

    public final void zzi() {
        if (this.zzc) {
            return;
        }
        for (int i3 = 0; i3 < this.zza.zzb(); i3++) {
            Map.Entry entryZzg = this.zza.zzg(i3);
            if (entryZzg.getValue() instanceof zzxv) {
                ((zzxv) entryZzg.getValue()).zzal();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzj(zzxk zzxkVar) {
        for (int i3 = 0; i3 < zzxkVar.zza.zzb(); i3++) {
            zzo(zzxkVar.zza.zzg(i3));
        }
        Iterator it = zzxkVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzo((Map.Entry) it.next());
        }
    }

    public final void zzk(zzxj zzxjVar, Object obj) {
        if (!zzxjVar.zzg()) {
            zzs(zzxjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                zzs(zzxjVar, arrayList.get(i3));
            }
            obj = arrayList;
        }
        if (obj instanceof zzyl) {
            this.zzd = true;
        }
        this.zza.put(zzxjVar, obj);
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final boolean zzm() {
        for (int i3 = 0; i3 < this.zza.zzb(); i3++) {
            if (!zzp(this.zza.zzg(i3))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzp((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzxk(boolean z2) {
        zzi();
        zzi();
    }
}
