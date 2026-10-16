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
public class oj implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f62325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f62326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SensorManager f62327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Sensor f62328d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Sensor f62329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f62330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f62331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f62332i;

    public oj(com.applovin.impl.sdk.j jVar) {
        this.f62330g = jVar;
        SensorManager sensorManager = (SensorManager) com.applovin.impl.sdk.j.m().getSystemService("sensor");
        this.f62327c = sensorManager;
        this.f62328d = sensorManager.getDefaultSensor(9);
        this.f62329f = sensorManager.getDefaultSensor(4);
        this.f62325a = ((Integer) jVar.a(sj.h4)).intValue();
        this.f62326b = ((Float) jVar.a(sj.g4)).floatValue();
    }

    public float a() {
        if (this.f62331h == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(r0[2] / 9.81f));
    }

    public float b() {
        return this.f62332i;
    }

    public void c() {
        if (Boolean.parseBoolean(this.f62330g.f0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f62327c.unregisterListener(this);
        if (((Boolean) this.f62330g.g0().a(sj.d4)).booleanValue()) {
            a(this.f62328d);
        }
        if (((Boolean) this.f62330g.g0().a(sj.e4)).booleanValue()) {
            a(this.f62329f);
        }
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f62327c.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f62331h = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f3 = this.f62332i * this.f62326b;
            this.f62332i = f3;
            this.f62332i = f3 + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }

    private void a(Sensor sensor) {
        try {
            this.f62327c.registerListener(this, sensor, (int) TimeUnit.MILLISECONDS.toMicros(this.f62325a));
        } catch (Throwable th) {
            this.f62330g.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f62330g.I().a("SensorDataManager", "Unable to register sensor listener", th);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
