package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f60505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f60506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f60507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioManager f60508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f60509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f60510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f60511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f60512h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(int i3, boolean z2);

        void d(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = il.this.f60506b;
            final il ilVar = il.this;
            handler.post(new Runnable() { // from class: com.applovin.impl.fy
                @Override // java.lang.Runnable
                public final void run() {
                    ilVar.d();
                }
            });
        }
    }

    public il(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f60505a = applicationContext;
        this.f60506b = handler;
        this.f60507c = bVar;
        AudioManager audioManager = (AudioManager) b1.b((AudioManager) applicationContext.getSystemService("audio"));
        this.f60508d = audioManager;
        this.f60510f = 3;
        this.f60511g = b(audioManager, 3);
        this.f60512h = a(audioManager, this.f60510f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f60509e = cVar;
        } catch (RuntimeException e3) {
            oc.c("StreamVolumeManager", "Error registering stream volume receiver", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int iB = b(this.f60508d, this.f60510f);
        boolean zA = a(this.f60508d, this.f60510f);
        if (this.f60511g == iB && this.f60512h == zA) {
            return;
        }
        this.f60511g = iB;
        this.f60512h = zA;
        this.f60507c.a(iB, zA);
    }

    public void c() {
        c cVar = this.f60509e;
        if (cVar != null) {
            try {
                this.f60505a.unregisterReceiver(cVar);
            } catch (RuntimeException e3) {
                oc.c("StreamVolumeManager", "Error unregistering stream volume receiver", e3);
            }
            this.f60509e = null;
        }
    }

    private static int b(AudioManager audioManager, int i3) {
        try {
            return audioManager.getStreamVolume(i3);
        } catch (RuntimeException e3) {
            oc.c("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i3, e3);
            return audioManager.getStreamMaxVolume(i3);
        }
    }

    public int a() {
        return this.f60508d.getStreamMaxVolume(this.f60510f);
    }

    public void a(int i3) {
        if (this.f60510f == i3) {
            return;
        }
        this.f60510f = i3;
        d();
        this.f60507c.d(i3);
    }

    public int b() {
        if (xp.f65027a >= 28) {
            return this.f60508d.getStreamMinVolume(this.f60510f);
        }
        return 0;
    }

    private static boolean a(AudioManager audioManager, int i3) {
        if (xp.f65027a >= 23) {
            return audioManager.isStreamMute(i3);
        }
        return b(audioManager, i3) == 0;
    }
}
