package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class DataLayer {
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zza = "gtm.lifetime".split("\\.");
    private static final Pattern zzb = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final zzaw zzg;
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final Map zzd = new HashMap();
    private final ReentrantLock zze = new ReentrantLock();
    private final LinkedList zzf = new LinkedList();
    private final CountDownLatch zzh = new CountDownLatch(1);

    DataLayer(zzaw zzawVar) {
        this.zzg = zzawVar;
        zzawVar.zzb(new zzas(this));
    }

    public static Map<String, Object> mapOf(Object... objArr) {
        if ((objArr.length & 1) != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            Object obj = objArr[i3];
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException("key is not a string: ".concat(String.valueOf(obj)));
            }
            map.put((String) obj, objArr[i3 + 1]);
        }
        return map;
    }

    private final void zzh(Map map, String str, Collection collection) {
        for (Map.Entry entry : map.entrySet()) {
            int length = str.length();
            String str2 = (String) entry.getKey();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(length == 0 ? "" : ".");
            sb.append(str2);
            String string = sb.toString();
            if (entry.getValue() instanceof Map) {
                zzh((Map) entry.getValue(), string, collection);
            } else if (!string.equals("gtm.lifetime")) {
                collection.add(new zzat(string, entry.getValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(Map map) {
        Long lValueOf;
        long j3;
        this.zze.lock();
        try {
            this.zzf.offer(map);
            if (this.zze.getHoldCount() == 1) {
                int i3 = 0;
                do {
                    Map map2 = (Map) this.zzf.poll();
                    if (map2 != null) {
                        synchronized (this.zzd) {
                            try {
                                for (String str : map2.keySet()) {
                                    zzf(zza(str, map2.get(str)), this.zzd);
                                }
                            } finally {
                            }
                        }
                        Iterator it = this.zzc.keySet().iterator();
                        while (it.hasNext()) {
                            ((zzau) it.next()).zza(map2);
                        }
                        i3++;
                    }
                } while (i3 <= 500);
                this.zzf.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }
            String[] strArr = zza;
            int length = strArr.length;
            Object obj = map;
            int i4 = 0;
            while (true) {
                lValueOf = null;
                if (i4 >= length) {
                    break;
                }
                String str2 = strArr[i4];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i4++;
                }
            }
            if (obj != null) {
                String string = obj.toString();
                Matcher matcher = zzb.matcher(string);
                if (matcher.matches()) {
                    try {
                        String strGroup = matcher.group(1);
                        Preconditions.m(strGroup);
                        j3 = Long.parseLong(strGroup);
                    } catch (NumberFormatException unused) {
                        Log.w("GoogleTagManager", "illegal number in _lifetime value: ".concat(String.valueOf(string)));
                        j3 = 0;
                    }
                    if (j3 <= 0) {
                        zzdg.zzb.zzb("non-positive _lifetime: ".concat(String.valueOf(string)));
                    } else {
                        String strGroup2 = matcher.group(2);
                        Preconditions.m(strGroup2);
                        if (strGroup2.length() == 0) {
                            lValueOf = Long.valueOf(j3);
                        } else {
                            char cCharAt = strGroup2.charAt(0);
                            if (cCharAt == 'd') {
                                lValueOf = Long.valueOf(j3 * 86400000);
                            } else if (cCharAt == 'h') {
                                lValueOf = Long.valueOf(j3 * 3600000);
                            } else if (cCharAt == 'm') {
                                lValueOf = Long.valueOf(j3 * 60000);
                            } else if (cCharAt != 's') {
                                Log.w("GoogleTagManager", "unknown units in _lifetime: ".concat(String.valueOf(string)));
                            } else {
                                lValueOf = Long.valueOf(j3 * 1000);
                            }
                        }
                    }
                } else {
                    zzdg.zzb.zzb("unknown _lifetime: ".concat(String.valueOf(string)));
                }
            }
            if (lValueOf != null) {
                ArrayList arrayList = new ArrayList();
                zzh(map, "", arrayList);
                this.zzg.zzc(arrayList, lValueOf.longValue());
            }
            this.zze.unlock();
        } catch (Throwable th) {
            this.zze.unlock();
            throw th;
        }
    }

    public Object get(String str) {
        synchronized (this.zzd) {
            try {
                Object obj = this.zzd;
                for (String str2 : str.split("\\.")) {
                    if (!(obj instanceof Map)) {
                        return null;
                    }
                    obj = ((Map) obj).get(str2);
                    if (obj == null) {
                        return null;
                    }
                }
                return obj;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void push(String str, Object obj) {
        push(zza(str, obj));
    }

    public void pushEvent(String str, Map<String, Object> map) {
        HashMap map2 = new HashMap(map);
        map2.put("event", str);
        push(map2);
    }

    public String toString() {
        String string;
        synchronized (this.zzd) {
            try {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : this.zzd.entrySet()) {
                    sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    final Map zza(String str, Object obj) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.toString().split("\\.");
        int i3 = 0;
        HashMap map2 = map;
        while (true) {
            int length = strArrSplit.length - 1;
            if (i3 >= length) {
                map2.put(strArrSplit[length], obj);
                return map;
            }
            HashMap map3 = new HashMap();
            map2.put(strArrSplit[i3], map3);
            i3++;
            map2 = map3;
        }
    }

    final void zzd(String str) {
        push(str, null);
        this.zzg.zza(str);
    }

    final void zze(List list, List list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj instanceof List) {
                if (!(list2.get(i3) instanceof List)) {
                    list2.set(i3, new ArrayList());
                }
                Object obj2 = list2.get(i3);
                Preconditions.m(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(list2.get(i3) instanceof Map)) {
                    list2.set(i3, new HashMap());
                }
                Object obj3 = list2.get(i3);
                Preconditions.m(obj3);
                zzf((Map) obj, (Map) obj3);
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i3, obj);
            }
        }
    }

    final void zzf(Map map, Map map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                Object obj2 = map2.get(str);
                Preconditions.m(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                Object obj3 = map2.get(str);
                Preconditions.m(obj3);
                zzf((Map) obj, (Map) obj3);
            } else {
                map2.put(str, obj);
            }
        }
    }

    final void zzg(zzau zzauVar) {
        this.zzc.put(zzauVar, 0);
    }

    @SideEffectFree
    public void push(Map<String, Object> map) {
        try {
            this.zzh.await();
        } catch (InterruptedException unused) {
            Log.w("GoogleTagManager", "DataLayer.push: unexpected InterruptedException");
        }
        zzi(map);
    }
}
