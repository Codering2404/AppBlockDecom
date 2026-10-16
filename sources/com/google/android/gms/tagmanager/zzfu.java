package com.google.android.gms.tagmanager;

import android.util.Log;
import com.facebook.internal.ServerProtocol;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfu {
    private static final Long zza = new Long(0);
    private static final Double zzb = new Double(0.0d);
    private static final zzft zzc = zzft.zzd(0);
    private static final String zzd;
    private static final Boolean zze;
    private static final List zzf;
    private static final Map zzg;
    private static final com.google.android.gms.internal.gtm.zzam zzh;

    static {
        String str = new String("");
        zzd = str;
        zze = new Boolean(false);
        zzf = new ArrayList(0);
        zzg = new HashMap();
        zzh = zzb(str);
    }

    public static com.google.android.gms.internal.gtm.zzam zza() {
        return zzh;
    }

    public static com.google.android.gms.internal.gtm.zzam zzb(Object obj) {
        com.google.android.gms.internal.gtm.zzan zzanVarZzg = com.google.android.gms.internal.gtm.zzam.zzg();
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        zzanVarZzg.zzt(zzatVar);
        if (obj instanceof com.google.android.gms.internal.gtm.zzam) {
            return (com.google.android.gms.internal.gtm.zzam) obj;
        }
        boolean z2 = false;
        if (obj instanceof String) {
            zzanVarZzg.zzt(zzatVar);
            zzanVarZzg.zzs((String) obj);
        } else if (obj instanceof List) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.LIST);
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                com.google.android.gms.internal.gtm.zzam zzamVarZzb = zzb(it.next());
                com.google.android.gms.internal.gtm.zzam zzamVar = zzh;
                if (zzamVarZzb == zzamVar) {
                    return zzamVar;
                }
                z3 = z3 || zzamVarZzb.zzP();
                arrayList.add(zzamVarZzb);
            }
            zzanVarZzg.zzj();
            zzanVarZzg.zzb(arrayList);
            z2 = z3;
        } else if (obj instanceof Map) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.MAP);
            Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(setEntrySet.size());
            ArrayList arrayList3 = new ArrayList(setEntrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : setEntrySet) {
                com.google.android.gms.internal.gtm.zzam zzamVarZzb2 = zzb(entry.getKey());
                com.google.android.gms.internal.gtm.zzam zzamVarZzb3 = zzb(entry.getValue());
                com.google.android.gms.internal.gtm.zzam zzamVar2 = zzh;
                if (zzamVarZzb2 == zzamVar2 || zzamVarZzb3 == zzamVar2) {
                    return zzamVar2;
                }
                z4 = z4 || zzamVarZzb2.zzP() || zzamVarZzb3.zzP();
                arrayList2.add(zzamVarZzb2);
                arrayList3.add(zzamVarZzb3);
            }
            zzanVarZzg.zzk();
            zzanVarZzg.zzc(arrayList2);
            zzanVarZzg.zzl();
            zzanVarZzg.zzd(arrayList3);
            z2 = z4;
        } else if (zzq(obj)) {
            zzanVarZzg.zzt(zzatVar);
            zzanVarZzg.zzs(obj.toString());
        } else if (zzr(obj)) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.INTEGER);
            zzanVarZzg.zzq(zzo(obj));
        } else {
            if (!(obj instanceof Boolean)) {
                Log.e("GoogleTagManager", "Converting to Value from unknown object type: ".concat(String.valueOf(obj == null ? "null" : obj.getClass().toString())));
                return zzh;
            }
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.BOOLEAN);
            zzanVarZzg.zzn(((Boolean) obj).booleanValue());
        }
        zzanVarZzg.zzo(z2);
        return (com.google.android.gms.internal.gtm.zzam) zzanVarZzg.zzD();
    }

    public static zzft zzc() {
        return zzc;
    }

    public static zzft zzd(Object obj) {
        return obj instanceof zzft ? (zzft) obj : zzr(obj) ? zzft.zzd(zzo(obj)) : zzq(obj) ? zzft.zzc(Double.valueOf(zzn(obj))) : zzp(zzm(obj));
    }

    public static Boolean zze() {
        return zze;
    }

    public static Boolean zzf(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        String strZzm = zzm(obj);
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(strZzm) ? Boolean.TRUE : "false".equalsIgnoreCase(strZzm) ? Boolean.FALSE : zze;
    }

    public static Long zzi() {
        return zza;
    }

    public static Long zzj(Object obj) {
        if (zzr(obj)) {
            return Long.valueOf(zzo(obj));
        }
        zzft zzftVarZzp = zzp(zzm(obj));
        return zzftVarZzp == zzc ? zza : Long.valueOf(zzftVarZzp.zzb());
    }

    public static Object zzk(com.google.android.gms.internal.gtm.zzam zzamVar) {
        if (zzamVar == null) {
            return null;
        }
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        switch (zzamVar.zzh()) {
            case STRING:
                break;
            case LIST:
                ArrayList arrayList = new ArrayList(zzamVar.zza());
                Iterator it = zzamVar.zzs().iterator();
                while (it.hasNext()) {
                    Object objZzk = zzk((com.google.android.gms.internal.gtm.zzam) it.next());
                    if (objZzk != null) {
                        arrayList.add(objZzk);
                    }
                    break;
                }
                break;
            case MAP:
                if (zzamVar.zzc() != zzamVar.zzd()) {
                    Log.e("GoogleTagManager", "Converting an invalid value to object: ".concat(zzamVar.toString()));
                } else {
                    HashMap map = new HashMap(zzamVar.zzd());
                    for (int i3 = 0; i3 < zzamVar.zzc(); i3++) {
                        Object objZzk2 = zzk(zzamVar.zzl(i3));
                        Object objZzk3 = zzk(zzamVar.zzm(i3));
                        if (objZzk2 != null && objZzk3 != null) {
                            map.put(objZzk2, objZzk3);
                        }
                    }
                }
                break;
            case MACRO_REFERENCE:
                Log.e("GoogleTagManager", "Trying to convert a macro reference to object");
                break;
            case FUNCTION_ID:
                Log.e("GoogleTagManager", "Trying to convert a function id to object");
                break;
            case INTEGER:
                break;
            case TEMPLATE:
                StringBuilder sb = new StringBuilder();
                Iterator it2 = zzamVar.zzt().iterator();
                while (it2.hasNext()) {
                    String strZzm = zzm(zzk((com.google.android.gms.internal.gtm.zzam) it2.next()));
                    if (strZzm != zzd) {
                        sb.append(strZzm);
                    }
                    break;
                }
                break;
            case BOOLEAN:
                break;
            default:
                Log.e("GoogleTagManager", "Failed to convert a value of type: ".concat(String.valueOf(zzamVar.zzh())));
                break;
        }
        return null;
    }

    public static String zzl() {
        return zzd;
    }

    public static String zzm(Object obj) {
        return obj == null ? zzd : obj.toString();
    }

    private static double zzn(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        Log.e("GoogleTagManager", "getDouble received non-Number");
        return 0.0d;
    }

    private static long zzo(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        Log.e("GoogleTagManager", "getInt64 received non-Number");
        return 0L;
    }

    private static boolean zzq(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        return (obj instanceof zzft) && ((zzft) obj).zzf();
    }

    private static boolean zzr(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return (obj instanceof zzft) && ((zzft) obj).zzg();
    }

    private static zzft zzp(String str) {
        try {
            return zzft.zze(str);
        } catch (NumberFormatException unused) {
            Log.e(FptyjHFU.sYITmqoVHzvdtn, "Failed to convert '" + str + "' to a number.");
            return zzc;
        }
    }
}
