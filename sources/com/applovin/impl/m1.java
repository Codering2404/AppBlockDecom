package com.applovin.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f61322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f61323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f61324c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f61325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f61326b;

        public a(Handler handler, b bVar) {
            this.f61326b = handler;
            this.f61325a = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f61326b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m1.this.f61324c) {
                this.f61325a.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void c();
    }

    public m1(Context context, Handler handler, b bVar) {
        this.f61322a = context.getApplicationContext();
        this.f61323b = new a(handler, bVar);
    }

    public void a(boolean z2) {
        if (z2 && !this.f61324c) {
            this.f61322a.registerReceiver(this.f61323b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f61324c = true;
        } else {
            if (z2 || !this.f61324c) {
                return;
            }
            this.f61322a.unregisterReceiver(this.f61323b);
            this.f61324c = false;
        }
    }
}
