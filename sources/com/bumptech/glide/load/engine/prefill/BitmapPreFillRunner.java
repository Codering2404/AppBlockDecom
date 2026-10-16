package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class BitmapPreFillRunner implements Runnable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Clock f66650j = new Clock();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final long f66651k = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapPool f66652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryCache f66653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PreFillQueue f66654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Clock f66655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f66656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f66657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f66658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f66659i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Clock {
        Clock() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void b(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    private long b() {
        return this.f66653b.c() - this.f66653b.d();
    }

    private long c() {
        long j3 = this.f66658h;
        this.f66658h = Math.min(4 * j3, f66651k);
        return j3;
    }

    private boolean d(long j3) {
        return this.f66655d.a() - j3 >= 32;
    }

    boolean a() {
        Bitmap bitmapCreateBitmap;
        long jA = this.f66655d.a();
        while (!this.f66654c.a() && !d(jA)) {
            PreFillType preFillTypeB = this.f66654c.b();
            if (this.f66656f.contains(preFillTypeB)) {
                bitmapCreateBitmap = Bitmap.createBitmap(preFillTypeB.c(), preFillTypeB.b(), preFillTypeB.a());
            } else {
                this.f66656f.add(preFillTypeB);
                bitmapCreateBitmap = this.f66652a.e(preFillTypeB.c(), preFillTypeB.b(), preFillTypeB.a());
            }
            int i3 = Util.i(bitmapCreateBitmap);
            if (b() >= i3) {
                this.f66653b.e(new UniqueKey(), BitmapResource.d(bitmapCreateBitmap, this.f66652a));
            } else {
                this.f66652a.c(bitmapCreateBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + preFillTypeB.c() + "x" + preFillTypeB.b() + "] " + preFillTypeB.a() + " size: " + i3);
            }
        }
        return (this.f66659i || this.f66654c.a()) ? false : true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f66657g.postDelayed(this, c());
        }
    }
}
