package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import com.google.firebase.FirebaseApp;
import com.revenuecat.purchases.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagl {
    private static final Map<String, zzagk> zza = new ArrayMap();
    private static final Map<String, List<WeakReference<zzagn>>> zzb = new ArrayMap();

    private static String zza(String str, int i3, boolean z2) {
        if (z2) {
            return "http://[" + str + "]:" + i3 + "/";
        }
        return "http://" + str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i3 + "/";
    }

    public static String zzb(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static String zza(String str) {
        zzagk zzagkVar;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            return zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static void zza(String str, zzagn zzagnVar) {
        Map<String, List<WeakReference<zzagn>>> map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    map.get(str).add(new WeakReference<>(zzagnVar));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference<>(zzagnVar));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i3) {
        String strB = firebaseApp.p().b();
        Map<String, zzagk> map = zza;
        synchronized (map) {
            map.put(strB, new zzagk(str, i3));
        }
        Map<String, List<WeakReference<zzagn>>> map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(strB)) {
                    Iterator<WeakReference<zzagn>> it = map2.get(strB).iterator();
                    boolean z2 = false;
                    while (it.hasNext()) {
                        zzagn zzagnVar = it.next().get();
                        if (zzagnVar != null) {
                            zzagnVar.zza();
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        zza.remove(strB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.p().b());
    }
}
