package com.google.android.gms.internal.ads;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaik extends zzaim {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzaik() {
        super(new zzafv());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzet zzetVar) {
        return Double.valueOf(Double.longBitsToDouble(zzetVar.zzD()));
    }

    private static String zzh(zzet zzetVar) {
        int iZzt = zzetVar.zzt();
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(iZzt);
        return new String(zzetVar.zzi(), iZzg, iZzt);
    }

    private static HashMap zzi(zzet zzetVar) {
        int iZzH = zzetVar.zzH();
        HashMap map = new HashMap(iZzH);
        for (int i3 = 0; i3 < iZzH; i3++) {
            String strZzh = zzh(zzetVar);
            Object objZzj = zzj(zzetVar, zzetVar.zzs());
            if (objZzj != null) {
                map.put(strZzh, objZzj);
            }
        }
        return map;
    }

    private static Object zzj(zzet zzetVar, int i3) {
        if (i3 == 0) {
            return zzg(zzetVar);
        }
        if (i3 == 1) {
            return Boolean.valueOf(zzetVar.zzs() == 1);
        }
        if (i3 == 2) {
            return zzh(zzetVar);
        }
        if (i3 != 3) {
            if (i3 == 8) {
                return zzi(zzetVar);
            }
            if (i3 != 10) {
                if (i3 != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzetVar).doubleValue());
                zzetVar.zzk(2);
                return date;
            }
            int iZzH = zzetVar.zzH();
            ArrayList arrayList = new ArrayList(iZzH);
            for (int i4 = 0; i4 < iZzH; i4++) {
                Object objZzj = zzj(zzetVar, zzetVar.zzs());
                if (objZzj != null) {
                    arrayList.add(objZzj);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzh = zzh(zzetVar);
            int iZzs = zzetVar.zzs();
            if (iZzs == 9) {
                return map;
            }
            Object objZzj2 = zzj(zzetVar, iZzs);
            if (objZzj2 != null) {
                map.put(strZzh, objZzj2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zza(zzet zzetVar) {
        return true;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzc;
    }

    public final long[] zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zzb(zzet zzetVar, long j3) {
        if (zzetVar.zzs() == 2 && "onMetaData".equals(zzh(zzetVar)) && zzetVar.zzd() != 0 && zzetVar.zzs() == 8) {
            HashMap mapZzi = zzi(zzetVar);
            Object obj = mapZzi.get("duration");
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzi.get(jlWo.UPUVYokxZ);
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        Object obj5 = list.get(i3);
                        Object obj6 = list2.get(i3);
                        if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                            this.zzc[i3] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                            this.zzd[i3] = ((Double) obj5).longValue();
                        } else {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}
