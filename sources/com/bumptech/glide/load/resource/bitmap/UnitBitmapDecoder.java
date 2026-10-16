package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(Bitmap bitmap, int i3, int i4, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap, Options options) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f66929a;

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.f66929a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f66929a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.i(this.f66929a);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void a() {
        }
    }
}
