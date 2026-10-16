package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LruBitmapPool implements BitmapPool {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f66556k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruPoolStrategy f66557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f66558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f66559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitmapTracker f66560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f66561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f66562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f66563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f66565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f66566j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ThrowingBitmapTracker implements BitmapTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f66567a;

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
            if (!this.f66567a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f66567a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
            if (!this.f66567a.contains(bitmap)) {
                this.f66567a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    LruBitmapPool(long j3, LruPoolStrategy lruPoolStrategy, Set set) {
        this.f66559c = j3;
        this.f66561e = j3;
        this.f66557a = lruPoolStrategy;
        this.f66558b = set;
        this.f66560d = new NullBitmapTracker();
    }

    private static void f(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private static Bitmap g(int i3, int i4, Bitmap.Config config) {
        if (config == null) {
            config = f66556k;
        }
        return Bitmap.createBitmap(i3, i4, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f66563g + ", misses=" + this.f66564h + ", puts=" + this.f66565i + ", evictions=" + this.f66566j + ", currentSize=" + this.f66562f + ", maxSize=" + this.f66561e + "\nStrategy=" + this.f66557a);
    }

    private void j() {
        q(this.f66561e);
    }

    private static Set k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy l() {
        return new SizeConfigStrategy();
    }

    private synchronized Bitmap m(int i3, int i4, Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.f66557a.d(i3, i4, config != null ? config : f66556k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f66557a.b(i3, i4, config));
                }
                this.f66564h++;
            } else {
                this.f66563g++;
                this.f66562f -= (long) this.f66557a.e(bitmapD);
                this.f66560d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f66557a.b(i3, i4, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j3) {
        while (this.f66562f > j3) {
            try {
                Bitmap bitmapRemoveLast = this.f66557a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", YgVrd.eOf);
                        i();
                    }
                    this.f66562f = 0L;
                    return;
                }
                this.f66560d.a(bitmapRemoveLast);
                this.f66562f -= (long) this.f66557a.e(bitmapRemoveLast);
                this.f66566j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f66557a.a(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void a(int i3) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i3);
        }
        if (i3 >= 40 || i3 >= 20) {
            b();
        } else if (i3 >= 20 || i3 == 15) {
            q(n() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f66557a.e(bitmap) <= this.f66561e && this.f66558b.contains(bitmap.getConfig())) {
                int iE = this.f66557a.e(bitmap);
                this.f66557a.c(bitmap);
                this.f66560d.b(bitmap);
                this.f66565i++;
                this.f66562f += (long) iE;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f66557a.a(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f66557a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f66558b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap d(int i3, int i4, Bitmap.Config config) {
        Bitmap bitmapM = m(i3, i4, config);
        if (bitmapM == null) {
            return g(i3, i4, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap e(int i3, int i4, Bitmap.Config config) {
        Bitmap bitmapM = m(i3, i4, config);
        return bitmapM == null ? g(i3, i4, config) : bitmapM;
    }

    public long n() {
        return this.f66561e;
    }

    public LruBitmapPool(long j3) {
        this(j3, l(), k());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
        }
    }
}
