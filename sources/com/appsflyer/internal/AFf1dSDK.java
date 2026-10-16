package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.AFf1bSDK;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1dSDK implements AFf1cSDK {
    private static final BitSet AFLogger;
    final Runnable AFInAppEventParameterName;
    final Handler AFInAppEventType;
    boolean AFKeystoreWrapper;
    private long AFLogger$LogLevel;
    private Runnable AFVersionDeclaration;
    private final Map<AFf1fSDK, AFf1fSDK> afDebugLog;
    private final Map<AFf1fSDK, Map<String, Object>> afErrorLog;
    private final SensorManager afInfoLog;
    private boolean afRDLog;
    private int afWarnLog;
    private final Runnable getLevel;
    final Object valueOf;
    final Runnable values;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFf1dSDK$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!AFf1dSDK.this.afDebugLog.isEmpty()) {
                    for (AFf1fSDK aFf1fSDK : AFf1dSDK.this.afDebugLog.values()) {
                        AFf1dSDK.this.afInfoLog.unregisterListener(aFf1fSDK);
                        aFf1fSDK.AFInAppEventParameterName(AFf1dSDK.this.afErrorLog, true);
                    }
                }
            } catch (Throwable th) {
                AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
            }
            AFf1dSDK.this.afWarnLog = 0;
            AFf1dSDK.this.afRDLog = false;
        }
    }

    static {
        BitSet bitSet = new BitSet(6);
        AFLogger = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFf1dSDK(SensorManager sensorManager, Handler handler) {
        this.valueOf = new Object();
        BitSet bitSet = AFLogger;
        this.afDebugLog = new HashMap(bitSet.size());
        this.afErrorLog = new ConcurrentHashMap(bitSet.size());
        this.values = new Runnable() { // from class: com.appsflyer.internal.AFf1dSDK.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFf1dSDK.this.valueOf) {
                    final AFf1dSDK aFf1dSDK = AFf1dSDK.this;
                    aFf1dSDK.AFInAppEventType.post(new Runnable() { // from class: com.appsflyer.internal.AFf1dSDK.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                for (Sensor sensor : AFf1dSDK.this.afInfoLog.getSensorList(-1)) {
                                    if (AFf1dSDK.AFInAppEventType(sensor.getType())) {
                                        AFf1fSDK aFf1fSDK = new AFf1fSDK(sensor);
                                        if (!AFf1dSDK.this.afDebugLog.containsKey(aFf1fSDK)) {
                                            AFf1dSDK.this.afDebugLog.put(aFf1fSDK, aFf1fSDK);
                                        }
                                        AFf1dSDK.this.afInfoLog.registerListener((SensorEventListener) AFf1dSDK.this.afDebugLog.get(aFf1fSDK), sensor, 0, AFf1dSDK.this.AFInAppEventType);
                                    }
                                }
                            } catch (Throwable th) {
                                AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
                            }
                            AFf1dSDK.this.afRDLog = true;
                        }
                    });
                    AFf1dSDK aFf1dSDK2 = AFf1dSDK.this;
                    aFf1dSDK2.AFInAppEventType.postDelayed(aFf1dSDK2.getLevel, 100L);
                    AFf1dSDK.this.AFKeystoreWrapper = true;
                }
            }
        };
        this.AFInAppEventParameterName = new Runnable() { // from class: com.appsflyer.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f65654a.afInfoLog();
            }
        };
        this.AFVersionDeclaration = new Runnable() { // from class: com.appsflyer.internal.AFf1dSDK.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFf1dSDK.this.valueOf) {
                    try {
                        AFf1dSDK aFf1dSDK = AFf1dSDK.this;
                        if (aFf1dSDK.AFKeystoreWrapper) {
                            aFf1dSDK.AFInAppEventType.removeCallbacks(aFf1dSDK.values);
                            AFf1dSDK aFf1dSDK2 = AFf1dSDK.this;
                            aFf1dSDK2.AFInAppEventType.removeCallbacks(aFf1dSDK2.AFInAppEventParameterName);
                            AFf1dSDK aFf1dSDK3 = AFf1dSDK.this;
                            aFf1dSDK3.AFInAppEventType.post(aFf1dSDK3.new AnonymousClass3());
                            AFf1dSDK.this.AFKeystoreWrapper = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.afWarnLog = 1;
        this.AFLogger$LogLevel = 0L;
        this.getLevel = new Runnable() { // from class: com.appsflyer.internal.AFf1dSDK.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFf1dSDK.this.valueOf) {
                    try {
                        if (AFf1dSDK.this.afWarnLog == 0) {
                            AFf1dSDK.this.afWarnLog = 1;
                        }
                        AFf1dSDK aFf1dSDK = AFf1dSDK.this;
                        aFf1dSDK.AFInAppEventType.postDelayed(aFf1dSDK.AFInAppEventParameterName, ((long) aFf1dSDK.afWarnLog) * 500);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.afInfoLog = sensorManager;
        this.AFInAppEventType = handler;
    }

    private List<Map<String, Object>> afDebugLog() {
        synchronized (this.valueOf) {
            try {
                if (!this.afDebugLog.isEmpty() && this.afRDLog) {
                    Iterator<AFf1fSDK> it = this.afDebugLog.values().iterator();
                    while (it.hasNext()) {
                        it.next().AFInAppEventParameterName(this.afErrorLog, false);
                    }
                }
                if (this.afErrorLog.isEmpty()) {
                    return new CopyOnWriteArrayList(Collections.EMPTY_LIST);
                }
                return new CopyOnWriteArrayList(this.afErrorLog.values());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void afInfoLog() {
        synchronized (this.valueOf) {
            this.AFInAppEventType.post(new AnonymousClass3());
        }
    }

    private List<Map<String, Object>> valueOf() {
        Iterator<AFf1fSDK> it = this.afDebugLog.values().iterator();
        while (it.hasNext()) {
            it.next().AFInAppEventParameterName(this.afErrorLog, true);
        }
        Map<AFf1fSDK, Map<String, Object>> map = this.afErrorLog;
        return (map == null || map.isEmpty()) ? new CopyOnWriteArrayList(Collections.EMPTY_LIST) : new CopyOnWriteArrayList(this.afErrorLog.values());
    }

    @Override // com.appsflyer.internal.AFf1cSDK
    public final Map<String, Object> AFInAppEventParameterName() throws ParseException {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Iterator<Map<String, Object>> it;
        String str;
        String str2;
        Integer num;
        ArrayList arrayList;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        List<Map<String, Object>> listValueOf = valueOf();
        String str3 = "sensors";
        String str4 = "na";
        if (listValueOf.isEmpty()) {
            concurrentHashMap3.put("sensors", "na");
            return concurrentHashMap3;
        }
        new AFf1bSDK();
        HashMap map = new HashMap();
        Iterator<Map<String, Object>> it2 = listValueOf.iterator();
        while (true) {
            if (!it2.hasNext()) {
                concurrentHashMap = concurrentHashMap3;
                break;
            }
            Map<String, Object> next = it2.next();
            HashMap map2 = new HashMap();
            boolean z2 = next.get("sVS") != null;
            AFf1bSDK.AFa1vSDK aFa1vSDK = (z2 && (next.get("sVE") != null)) ? AFf1bSDK.AFa1vSDK.ALL : z2 ? AFf1bSDK.AFa1vSDK.FIRST : AFf1bSDK.AFa1vSDK.NONE;
            if (aFa1vSDK == AFf1bSDK.AFa1vSDK.NONE) {
                map = new HashMap();
                map.put("er", str4);
                concurrentHashMap = concurrentHashMap3;
                break;
            }
            Integer num2 = (Integer) next.get("sT");
            String str5 = (String) next.get("sN");
            if (str5 != null) {
                map2.put("n", str5);
            } else {
                map2.put("n", "uk");
            }
            AFf1bSDK.AFa1wSDK aFa1wSDK = AFf1bSDK.AFa1wSDK.values()[num2.intValue()];
            ArrayList arrayList2 = new ArrayList(AFf1bSDK.values(next.get("sVS")));
            if (aFa1vSDK == AFf1bSDK.AFa1vSDK.ALL) {
                arrayList2.addAll(AFf1bSDK.values(next.get("sVE")));
            }
            if (aFa1wSDK == AFf1bSDK.AFa1wSDK.MAGNETOMETER) {
                ArrayList arrayList3 = new ArrayList();
                num = num2;
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(1)).doubleValue(), ((BigDecimal) arrayList2.get(0)).doubleValue()) * 57.29577951308232d);
                DecimalFormat decimalFormat = new DecimalFormat("##.#");
                RoundingMode roundingMode = RoundingMode.DOWN;
                decimalFormat.setRoundingMode(roundingMode);
                arrayList3.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat.format(bigDecimalValueOf))));
                BigDecimal bigDecimal = (BigDecimal) arrayList2.get(2);
                DecimalFormat decimalFormat2 = new DecimalFormat("##.#");
                decimalFormat2.setRoundingMode(roundingMode);
                arrayList3.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat2.format(bigDecimal))));
                ArrayList arrayList4 = new ArrayList();
                it = it2;
                if (arrayList2.size() > 5) {
                    concurrentHashMap2 = concurrentHashMap3;
                    str = str3;
                    str2 = str4;
                    BigDecimal bigDecimalSubtract = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(4)).doubleValue(), ((BigDecimal) arrayList2.get(3)).doubleValue()) * 57.29577951308232d).subtract(bigDecimalValueOf);
                    DecimalFormat decimalFormat3 = new DecimalFormat("##.#");
                    decimalFormat3.setRoundingMode(roundingMode);
                    arrayList4.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat3.format(bigDecimalSubtract))));
                    BigDecimal bigDecimalSubtract2 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                    DecimalFormat decimalFormat4 = new DecimalFormat("##.#");
                    decimalFormat4.setRoundingMode(roundingMode);
                    arrayList4.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat4.format(bigDecimalSubtract2))));
                } else {
                    concurrentHashMap2 = concurrentHashMap3;
                    str = str3;
                    str2 = str4;
                }
                arrayList = new ArrayList();
                arrayList.add(arrayList3);
                arrayList.add(arrayList4);
            } else {
                concurrentHashMap2 = concurrentHashMap3;
                it = it2;
                str = str3;
                str2 = str4;
                num = num2;
                ArrayList arrayList5 = new ArrayList();
                if (arrayList2.size() > 5) {
                    BigDecimal bigDecimalSubtract3 = ((BigDecimal) arrayList2.get(3)).subtract((BigDecimal) arrayList2.get(0));
                    DecimalFormat decimalFormat5 = new DecimalFormat("##.#");
                    RoundingMode roundingMode2 = RoundingMode.DOWN;
                    decimalFormat5.setRoundingMode(roundingMode2);
                    arrayList5.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat5.format(bigDecimalSubtract3))));
                    BigDecimal bigDecimalSubtract4 = ((BigDecimal) arrayList2.get(4)).subtract((BigDecimal) arrayList2.get(1));
                    DecimalFormat decimalFormat6 = new DecimalFormat("##.#");
                    decimalFormat6.setRoundingMode(roundingMode2);
                    arrayList5.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat6.format(bigDecimalSubtract4))));
                    BigDecimal bigDecimalSubtract5 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                    DecimalFormat decimalFormat7 = new DecimalFormat("##.#");
                    decimalFormat7.setRoundingMode(roundingMode2);
                    arrayList5.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat7.format(bigDecimalSubtract5))));
                }
                ArrayList arrayList6 = new ArrayList();
                BigDecimal bigDecimal2 = (BigDecimal) arrayList2.get(0);
                DecimalFormat decimalFormat8 = new DecimalFormat("##.#");
                RoundingMode roundingMode3 = RoundingMode.DOWN;
                decimalFormat8.setRoundingMode(roundingMode3);
                arrayList6.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat8.format(bigDecimal2))));
                BigDecimal bigDecimal3 = (BigDecimal) arrayList2.get(1);
                DecimalFormat decimalFormat9 = new DecimalFormat("##.#");
                decimalFormat9.setRoundingMode(roundingMode3);
                arrayList6.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat9.format(bigDecimal3))));
                BigDecimal bigDecimal4 = (BigDecimal) arrayList2.get(2);
                DecimalFormat decimalFormat10 = new DecimalFormat("##.#");
                decimalFormat10.setRoundingMode(roundingMode3);
                arrayList6.add(Double.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(decimalFormat10.format(bigDecimal4))));
                ArrayList arrayList7 = new ArrayList();
                arrayList7.add(arrayList6);
                arrayList7.add(arrayList5);
                arrayList = arrayList7;
            }
            map2.put("v", arrayList);
            map.put(AFf1bSDK.AFa1xSDK.values()[num.intValue()].AFKeystoreWrapper, map2);
            if (aFa1vSDK == AFf1bSDK.AFa1vSDK.FIRST) {
                map.put("er", "no_svs");
            }
            it2 = it;
            concurrentHashMap3 = concurrentHashMap2;
            str3 = str;
            str4 = str2;
        }
        concurrentHashMap.put(str3, map);
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean AFInAppEventType(int i3) {
        return i3 >= 0 && AFLogger.get(i3);
    }

    @Override // com.appsflyer.internal.AFf1cSDK
    public final synchronized void AFKeystoreWrapper() {
        this.AFInAppEventType.post(this.AFVersionDeclaration);
    }

    @Override // com.appsflyer.internal.AFf1cSDK
    public final Map<String, Object> values() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> listAfDebugLog = afDebugLog();
        if (!listAfDebugLog.isEmpty()) {
            concurrentHashMap.put("sensors", listAfDebugLog);
            return concurrentHashMap;
        }
        List<Map<String, Object>> listValueOf = valueOf();
        if (!listValueOf.isEmpty()) {
            concurrentHashMap.put("sensors", listValueOf);
        }
        return concurrentHashMap;
    }

    @Override // com.appsflyer.internal.AFf1cSDK
    public final void AFInAppEventType() {
        this.AFInAppEventType.post(this.AFVersionDeclaration);
        this.AFInAppEventType.post(this.values);
    }

    public AFf1dSDK(Context context) {
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        this(sensorManager, new Handler(handlerThread.getLooper()));
    }
}
