package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1fSDK implements SensorEventListener {
    private final String AFInAppEventType;
    private Executor afDebugLog;
    private final int afErrorLog;
    private double afInfoLog;
    private long afRDLog;
    private final String valueOf;
    private final int values;
    private final float[][] AFInAppEventParameterName = new float[2][];
    private final long[] AFKeystoreWrapper = new long[2];

    AFf1fSDK(Sensor sensor) {
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        name = name == null ? "" : name;
        this.valueOf = name;
        String vendor = sensor.getVendor();
        String str = vendor != null ? vendor : "";
        this.AFInAppEventType = str;
        this.afErrorLog = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private static List<Float> AFInAppEventParameterName(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f3 : fArr) {
            arrayList.add(Float.valueOf(f3));
        }
        return arrayList;
    }

    private synchronized Executor AFInAppEventType() {
        try {
            if (this.afDebugLog == null) {
                this.afDebugLog = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.afDebugLog;
    }

    private boolean valueOf() {
        return this.AFInAppEventParameterName[0] != null;
    }

    private static double values(float[] fArr, float[] fArr2) {
        int iMin = Math.min(fArr.length, fArr2.length);
        double dPow = 0.0d;
        for (int i3 = 0; i3 < iMin; i3++) {
            dPow += StrictMath.pow(fArr[i3] - fArr2[i3], 2.0d);
        }
        return Math.sqrt(dPow);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AFf1fSDK)) {
            return false;
        }
        AFf1fSDK aFf1fSDK = (AFf1fSDK) obj;
        return values(aFf1fSDK.values, aFf1fSDK.valueOf, aFf1fSDK.AFInAppEventType);
    }

    public final int hashCode() {
        return this.afErrorLog;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(final SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AFInAppEventType().execute(new Runnable() { // from class: com.appsflyer.internal.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65655a.AFKeystoreWrapper(sensorEvent);
                }
            });
        } else {
            AFKeystoreWrapper(sensorEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: AFInAppEventParameterName, reason: merged with bridge method [inline-methods] */
    public void AFKeystoreWrapper(SensorEvent sensorEvent) {
        long j3 = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long jCurrentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.AFInAppEventParameterName;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.AFKeystoreWrapper[0] = jCurrentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            this.AFInAppEventParameterName[1] = fArrCopyOf;
            this.AFKeystoreWrapper[1] = jCurrentTimeMillis;
            this.afInfoLog = values(fArr3, fArrCopyOf);
            return;
        }
        if (50000000 <= j3 - this.afRDLog) {
            this.afRDLog = j3;
            if (Arrays.equals(fArr4, fArr)) {
                this.AFKeystoreWrapper[1] = jCurrentTimeMillis;
                return;
            }
            double dValues = values(fArr3, fArr);
            if (dValues > this.afInfoLog) {
                this.AFInAppEventParameterName[1] = Arrays.copyOf(fArr, fArr.length);
                this.AFKeystoreWrapper[1] = jCurrentTimeMillis;
                this.afInfoLog = dValues;
            }
        }
    }

    private boolean values(int i3, String str, String str2) {
        return this.values == i3 && this.valueOf.equals(str) && this.AFInAppEventType.equals(str2);
    }

    final void AFInAppEventParameterName(Map<AFf1fSDK, Map<String, Object>> map, boolean z2) {
        if (valueOf()) {
            map.put(this, AFInAppEventParameterName());
            if (z2) {
                int length = this.AFInAppEventParameterName.length;
                for (int i3 = 0; i3 < length; i3++) {
                    this.AFInAppEventParameterName[i3] = null;
                }
                int length2 = this.AFKeystoreWrapper.length;
                for (int i4 = 0; i4 < length2; i4++) {
                    this.AFKeystoreWrapper[i4] = 0;
                }
                this.afInfoLog = 0.0d;
                this.afRDLog = 0L;
                return;
            }
            return;
        }
        if (map.containsKey(this)) {
            return;
        }
        map.put(this, AFInAppEventParameterName());
    }

    private Map<String, Object> AFInAppEventParameterName() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.valueOf);
        concurrentHashMap.put("sV", this.AFInAppEventType);
        float[] fArr = this.AFInAppEventParameterName[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", AFInAppEventParameterName(fArr));
        }
        float[] fArr2 = this.AFInAppEventParameterName[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", AFInAppEventParameterName(fArr2));
        }
        return concurrentHashMap;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
