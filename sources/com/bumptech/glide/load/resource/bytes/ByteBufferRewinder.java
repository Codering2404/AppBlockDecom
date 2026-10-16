package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f66941a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public DataRewinder b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f66941a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f66941a.position(0);
        return this.f66941a;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void b() {
    }
}
