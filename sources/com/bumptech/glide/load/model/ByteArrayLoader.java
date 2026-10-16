package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Converter f66674a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public Class a() {
                    return ByteBuffer.class;
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Converter<Data> {
        Class a();

        Object b(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public Class a() {
                    return InputStream.class;
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }

    public ByteArrayLoader(Converter converter) {
        this.f66674a = converter;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(byte[] bArr, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(bArr), new Fetcher(bArr, this.f66674a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Fetcher<Data> implements DataFetcher<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f66676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f66677b;

        Fetcher(byte[] bArr, Converter converter) {
            this.f66676a = bArr;
            this.f66677b = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66677b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.f(this.f66677b.b(this.f66676a));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }
}
