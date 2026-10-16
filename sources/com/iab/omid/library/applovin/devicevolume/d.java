package com.iab.omid.library.applovin.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f92128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f92129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f92130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f92131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f92132e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f92128a = context;
        this.f92129b = (AudioManager) context.getSystemService("audio");
        this.f92130c = aVar;
        this.f92131d = cVar;
    }

    private float a() {
        return this.f92130c.a(this.f92129b.getStreamVolume(3), this.f92129b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f92131d.a(this.f92132e);
    }

    public void c() {
        this.f92132e = a();
        b();
        this.f92128a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f92128a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        super.onChange(z2);
        float fA = a();
        if (a(fA)) {
            this.f92132e = fA;
            b();
        }
    }

    private boolean a(float f3) {
        return f3 != this.f92132e;
    }
}
