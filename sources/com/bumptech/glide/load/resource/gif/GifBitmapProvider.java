package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapPool f66965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayPool f66966b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f66965a = bitmapPool;
        this.f66966b = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void a(Bitmap bitmap) {
        this.f66965a.c(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] b(int i3) {
        ArrayPool arrayPool = this.f66966b;
        return arrayPool == null ? new byte[i3] : (byte[]) arrayPool.c(i3, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap c(int i3, int i4, Bitmap.Config config) {
        return this.f66965a.e(i3, i4, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] d(int i3) {
        ArrayPool arrayPool = this.f66966b;
        return arrayPool == null ? new int[i3] : (int[]) arrayPool.c(i3, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void e(byte[] bArr) {
        ArrayPool arrayPool = this.f66966b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void f(int[] iArr) {
        ArrayPool arrayPool = this.f66966b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }
}
