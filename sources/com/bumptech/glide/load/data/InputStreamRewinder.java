package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclableBufferedInputStream f66286a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayPool f66287a;

        public Factory(ArrayPool arrayPool) {
            this.f66287a = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public DataRewinder b(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f66287a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f66286a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void b() {
        this.f66286a.c();
    }

    public void c() {
        this.f66286a.b();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f66286a.reset();
        return this.f66286a;
    }
}
