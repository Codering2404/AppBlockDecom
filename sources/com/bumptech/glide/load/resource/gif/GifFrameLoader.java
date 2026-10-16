package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class GifFrameLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GifDecoder f66980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f66981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f66982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RequestManager f66983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BitmapPool f66984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f66985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f66986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f66987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RequestBuilder f66988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DelayTarget f66989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f66990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private DelayTarget f66991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f66992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Transformation f66993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DelayTarget f66994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OnEveryFrameListener f66995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f66996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f66997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f66998s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DelayTarget extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f66999d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f67000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f67001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Bitmap f67002h;

        DelayTarget(Handler handler, int i3, long j3) {
            this.f66999d = handler;
            this.f67000f = i3;
            this.f67001g = j3;
        }

        Bitmap a() {
            return this.f67002h;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void h(Bitmap bitmap, Transition transition) {
            this.f67002h = bitmap;
            this.f66999d.sendMessageAtTime(this.f66999d.obtainMessage(1, this), this.f67001g);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void g(Drawable drawable) {
            this.f67002h = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FrameCallback {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class FrameLoaderCallback implements Handler.Callback {
        FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                GifFrameLoader.this.m((DelayTarget) message.obj);
                return true;
            }
            if (i3 != 2) {
                return false;
            }
            GifFrameLoader.this.f66983d.l((DelayTarget) message.obj);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnEveryFrameListener {
        void a();
    }

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i3, int i4, Transformation transformation, Bitmap bitmap) {
        this(glide.f(), Glide.t(glide.h()), gifDecoder, null, i(Glide.t(glide.h()), i3, i4), transformation, bitmap);
    }

    private static Key g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private static RequestBuilder i(RequestManager requestManager, int i3, int i4) {
        return requestManager.d().a(((RequestOptions) ((RequestOptions) RequestOptions.v0(DiskCacheStrategy.f66406b).r0(true)).l0(true)).a0(i3, i4));
    }

    private void l() {
        if (!this.f66985f || this.f66986g) {
            return;
        }
        if (this.f66987h) {
            Preconditions.b(this.f66994o == null, "Pending target must be null when starting from the first frame");
            this.f66980a.f();
            this.f66987h = false;
        }
        DelayTarget delayTarget = this.f66994o;
        if (delayTarget != null) {
            this.f66994o = null;
            m(delayTarget);
            return;
        }
        this.f66986g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f66980a.e());
        this.f66980a.b();
        this.f66991l = new DelayTarget(this.f66981b, this.f66980a.g(), jUptimeMillis);
        this.f66988i.a(RequestOptions.w0(g())).J0(this.f66980a).C0(this.f66991l);
    }

    private void n() {
        Bitmap bitmap = this.f66992m;
        if (bitmap != null) {
            this.f66984e.c(bitmap);
            this.f66992m = null;
        }
    }

    private void p() {
        if (this.f66985f) {
            return;
        }
        this.f66985f = true;
        this.f66990k = false;
        l();
    }

    private void q() {
        this.f66985f = false;
    }

    void a() {
        this.f66982c.clear();
        n();
        q();
        DelayTarget delayTarget = this.f66989j;
        if (delayTarget != null) {
            this.f66983d.l(delayTarget);
            this.f66989j = null;
        }
        DelayTarget delayTarget2 = this.f66991l;
        if (delayTarget2 != null) {
            this.f66983d.l(delayTarget2);
            this.f66991l = null;
        }
        DelayTarget delayTarget3 = this.f66994o;
        if (delayTarget3 != null) {
            this.f66983d.l(delayTarget3);
            this.f66994o = null;
        }
        this.f66980a.clear();
        this.f66990k = true;
    }

    ByteBuffer b() {
        return this.f66980a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        DelayTarget delayTarget = this.f66989j;
        return delayTarget != null ? delayTarget.a() : this.f66992m;
    }

    int d() {
        DelayTarget delayTarget = this.f66989j;
        if (delayTarget != null) {
            return delayTarget.f67000f;
        }
        return -1;
    }

    Bitmap e() {
        return this.f66992m;
    }

    int f() {
        return this.f66980a.c();
    }

    int h() {
        return this.f66998s;
    }

    int j() {
        return this.f66980a.h() + this.f66996q;
    }

    int k() {
        return this.f66997r;
    }

    void m(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.f66995p;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.a();
        }
        this.f66986g = false;
        if (this.f66990k) {
            this.f66981b.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        if (!this.f66985f) {
            if (this.f66987h) {
                this.f66981b.obtainMessage(2, delayTarget).sendToTarget();
                return;
            } else {
                this.f66994o = delayTarget;
                return;
            }
        }
        if (delayTarget.a() != null) {
            n();
            DelayTarget delayTarget2 = this.f66989j;
            this.f66989j = delayTarget;
            for (int size = this.f66982c.size() - 1; size >= 0; size--) {
                ((FrameCallback) this.f66982c.get(size)).a();
            }
            if (delayTarget2 != null) {
                this.f66981b.obtainMessage(2, delayTarget2).sendToTarget();
            }
        }
        l();
    }

    void o(Transformation transformation, Bitmap bitmap) {
        this.f66993n = (Transformation) Preconditions.e(transformation);
        this.f66992m = (Bitmap) Preconditions.e(bitmap);
        this.f66988i = this.f66988i.a(new RequestOptions().n0(transformation));
        this.f66996q = Util.i(bitmap);
        this.f66997r = bitmap.getWidth();
        this.f66998s = bitmap.getHeight();
    }

    void r(FrameCallback frameCallback) {
        if (this.f66990k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f66982c.contains(frameCallback)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f66982c.isEmpty();
        this.f66982c.add(frameCallback);
        if (zIsEmpty) {
            p();
        }
    }

    void s(FrameCallback frameCallback) {
        this.f66982c.remove(frameCallback);
        if (this.f66982c.isEmpty()) {
            q();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder requestBuilder, Transformation transformation, Bitmap bitmap) {
        this.f66982c = new ArrayList();
        this.f66983d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.f66984e = bitmapPool;
        this.f66981b = handler;
        this.f66988i = requestBuilder;
        this.f66980a = gifDecoder;
        o(transformation, bitmap);
    }
}
