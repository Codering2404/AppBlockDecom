package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class r6 implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f62794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f62795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f62796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f62797d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f62798f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a();

        void b();
    }

    public r6(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f62794a = jVar;
        SensorManager sensorManager = (SensorManager) com.applovin.impl.sdk.j.m().getSystemService("sensor");
        this.f62795b = sensorManager;
        this.f62796c = sensorManager.getDefaultSensor(1);
        this.f62797d = aVar;
    }

    public void a() {
        if (Boolean.parseBoolean(this.f62794a.f0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f62795b.unregisterListener(this);
        this.f62795b.registerListener(this, this.f62796c, (int) TimeUnit.MILLISECONDS.toMicros(50L));
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void b() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.f62795b.unregisterListener(this);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f62795b.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float fMax = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f3 = this.f62798f;
            float f4 = (f3 * 0.5f) + (fMax * 0.5f);
            this.f62798f = f4;
            if (f3 < 0.8f && f4 > 0.8f) {
                this.f62797d.a();
            } else {
                if (f3 <= -0.8f || f4 >= -0.8f) {
                    return;
                }
                this.f62797d.b();
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
