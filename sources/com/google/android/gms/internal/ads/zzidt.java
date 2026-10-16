package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidt {
    private static final zzidt zzd = new zzidt(true);
    final zzign zza = new zzigj();
    boolean zzb;
    boolean zzc;

    private zzidt() {
    }

    public static zzidt zza() {
        return zzd;
    }

    static void zzf(zzidj zzidjVar, zzihg zzihgVar, int i3, Object obj) throws IOException {
        if (zzihgVar == zzihg.zzj) {
            zzidjVar.zzb(i3, 3);
            ((zzifp) obj).zzcX(zzidjVar);
            zzidjVar.zzb(i3, 4);
            return;
        }
        zzidjVar.zzb(i3, zzihgVar.zzb());
        zzihh zzihhVar = zzihh.INT;
        switch (zzihgVar.ordinal()) {
            case 0:
                zzidjVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzidjVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzidjVar.zzt(((Long) obj).longValue());
                break;
            case 3:
                zzidjVar.zzt(((Long) obj).longValue());
                break;
            case 4:
                zzidjVar.zzq(((Integer) obj).intValue());
                break;
            case 5:
                zzidjVar.zzu(((Long) obj).longValue());
                break;
            case 6:
                zzidjVar.zzs(((Integer) obj).intValue());
                break;
            case 7:
                zzidjVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzida)) {
                    zzidjVar.zzw((String) obj);
                } else {
                    zzidjVar.zzk((zzida) obj);
                }
                break;
            case 9:
                ((zzifp) obj).zzcX(zzidjVar);
                break;
            case 10:
                zzidjVar.zzo((zzifp) obj);
                break;
            case 11:
                if (!(obj instanceof zzida)) {
                    byte[] bArr = (byte[]) obj;
                    zzidjVar.zzl(bArr, 0, bArr.length);
                } else {
                    zzidjVar.zzk((zzida) obj);
                }
                break;
            case 12:
                zzidjVar.zzr(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zziei)) {
                    zzidjVar.zzq(((Integer) obj).intValue());
                } else {
                    zzidjVar.zzq(((zziei) obj).zza());
                }
                break;
            case 14:
                zzidjVar.zzs(((Integer) obj).intValue());
                break;
            case 15:
                zzidjVar.zzu(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzidjVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzidjVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    static int zzh(zzihg zzihgVar, int i3, Object obj) {
        int iZzF = zzidj.zzF(i3 << 3);
        if (zzihgVar == zzihg.zzj) {
            iZzF += iZzF;
        }
        return iZzF + zzi(zzihgVar, obj);
    }

    static int zzi(zzihg zzihgVar, Object obj) {
        int iZzc;
        int iZzF;
        zzihg zzihgVar2 = zzihg.zza;
        zzihh zzihhVar = zzihh.INT;
        switch (zzihgVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i3 = zzidj.zzb;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i4 = zzidj.zzb;
                return 4;
            case 2:
                return zzidj.zzG(((Long) obj).longValue());
            case 3:
                return zzidj.zzG(((Long) obj).longValue());
            case 4:
                return zzidj.zzG(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i5 = zzidj.zzb;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i6 = zzidj.zzb;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i7 = zzidj.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzida)) {
                    int i8 = zzidj.zzb;
                    iZzc = zzihf.zzc((String) obj);
                    iZzF = zzidj.zzF(iZzc);
                } else {
                    int i9 = zzidj.zzb;
                    iZzc = ((zzida) obj).zzb();
                    iZzF = zzidj.zzF(iZzc);
                }
                break;
            case 9:
                return ((zzifp) obj).zzbr();
            case 10:
                if (!(obj instanceof zziey)) {
                    return zzidj.zzH((zzifp) obj);
                }
                iZzc = ((zziey) obj).zzb();
                iZzF = zzidj.zzF(iZzc);
                break;
                break;
            case 11:
                if (!(obj instanceof zzida)) {
                    int i10 = zzidj.zzb;
                    iZzc = ((byte[]) obj).length;
                    iZzF = zzidj.zzF(iZzc);
                } else {
                    int i11 = zzidj.zzb;
                    iZzc = ((zzida) obj).zzb();
                    iZzF = zzidj.zzF(iZzc);
                }
                break;
            case 12:
                return zzidj.zzF(((Integer) obj).intValue());
            case 13:
                return obj instanceof zziei ? zzidj.zzG(((zziei) obj).zza()) : zzidj.zzG(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i12 = zzidj.zzb;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i13 = zzidj.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzidj.zzF((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzidj.zzG((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzF + iZzc;
    }

    public static int zzj(zzids zzidsVar, Object obj) {
        zzihg zzihgVarZzb = zzidsVar.zzb();
        int iZza = zzidsVar.zza();
        if (!zzidsVar.zzd()) {
            return zzh(zzihgVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i3 = 0;
        if (!zzidsVar.zze()) {
            int iZzh = 0;
            while (i3 < size) {
                iZzh += zzh(zzihgVarZzb, iZza, list.get(i3));
                i3++;
            }
            return iZzh;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzi = 0;
        while (i3 < size) {
            iZzi += zzi(zzihgVarZzb, list.get(i3));
            i3++;
        }
        return zzidj.zzF(iZza << 3) + iZzi + zzidj.zzF(iZzi);
    }

    private static boolean zzk(Map.Entry entry) {
        zzids zzidsVar = (zzids) entry.getKey();
        if (zzidsVar.zzc() != zzihh.MESSAGE) {
            return true;
        }
        if (!zzidsVar.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!zzl(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzifq) {
            return ((zzifq) obj).zzbi();
        }
        if (obj instanceof zziey) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i3;
        int iZzF;
        int iZzF2;
        zzids zzidsVar = (zzids) entry.getKey();
        Object value = entry.getValue();
        if (zzidsVar.zzc() != zzihh.MESSAGE || zzidsVar.zzd() || zzidsVar.zze()) {
            return zzj(zzidsVar, value);
        }
        if (value instanceof zziey) {
            int iZza = ((zzids) entry.getKey()).zza();
            int iZzF3 = zzidj.zzF(8);
            i3 = iZzF3 + iZzF3;
            iZzF = zzidj.zzF(16) + zzidj.zzF(iZza);
            int iZzF4 = zzidj.zzF(24);
            int iZzb = ((zziey) value).zzb();
            iZzF2 = iZzF4 + zzidj.zzF(iZzb) + iZzb;
        } else {
            int iZza2 = ((zzids) entry.getKey()).zza();
            int iZzF5 = zzidj.zzF(8);
            i3 = iZzF5 + iZzF5;
            iZzF = zzidj.zzF(16) + zzidj.zzF(iZza2);
            iZzF2 = zzidj.zzF(24) + zzidj.zzH((zzifp) value);
        }
        return i3 + iZzF + iZzF2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzn(com.google.android.gms.internal.ads.zzids r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzihg r0 = r2.zzb()
            r3.getClass()
            com.google.android.gms.internal.ads.zzihg r1 = com.google.android.gms.internal.ads.zzihg.zza
            com.google.android.gms.internal.ads.zzihh r1 = com.google.android.gms.internal.ads.zzihh.INT
            com.google.android.gms.internal.ads.zzihh r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzifp
            if (r0 != 0) goto L1f
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zziey
            if (r0 == 0) goto L46
        L1f:
            return
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L28
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zziei
            if (r0 == 0) goto L46
        L28:
            return
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzida
            if (r0 != 0) goto L31
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L46
        L31:
            return
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.ads.zzihg r2 = r2.zzb()
            com.google.android.gms.internal.ads.zzihh r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzidt.zzn(com.google.android.gms.internal.ads.zzids, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzidt zzidtVar = new zzidt();
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        for (int i3 = 0; i3 < iZzc; i3++) {
            Map.Entry entryZzd = zzignVar.zzd(i3);
            zzidtVar.zzd((zzids) ((zzigk) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzignVar.zze()) {
            zzidtVar.zzd((zzids) entry.getKey(), entry.getValue());
        }
        zzidtVar.zzc = this.zzc;
        return zzidtVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzidt) {
            return this.zza.equals(((zzidt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        for (int i3 = 0; i3 < iZzc; i3++) {
            Object value = zzignVar.zzd(i3).getValue();
            if (value instanceof zziee) {
                ((zziee) value).zzbm();
            }
        }
        Iterator it = zzignVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zziee) {
                ((zziee) value2).zzbm();
            }
        }
        zzignVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzign zzignVar = this.zza;
        return zzignVar.isEmpty() ? Collections.emptyIterator() : this.zzc ? new zziex(zzignVar.entrySet().iterator()) : zzignVar.entrySet().iterator();
    }

    public final void zzd(zzids zzidsVar, Object obj) {
        if (!zzidsVar.zzd()) {
            zzn(zzidsVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                Object obj2 = list.get(i3);
                zzn(zzidsVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zziey) {
            this.zzc = true;
        }
        this.zza.put(zzidsVar, obj);
    }

    public final boolean zze() {
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        for (int i3 = 0; i3 < iZzc; i3++) {
            if (!zzk(zzignVar.zzd(i3))) {
                return false;
            }
        }
        Iterator it = zzignVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzign zzignVar = this.zza;
        int iZzc = zzignVar.zzc();
        int iZzm = 0;
        for (int i3 = 0; i3 < iZzc; i3++) {
            iZzm += zzm(zzignVar.zzd(i3));
        }
        Iterator it = zzignVar.zze().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    private zzidt(boolean z2) {
        zzb();
        zzb();
    }
}
