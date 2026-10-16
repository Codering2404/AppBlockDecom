package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataDecoder f66680a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DataDecoder<Data> {
        Class a();

        void b(Object obj);

        Object c(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataDecoder f66684a = new DataDecoder<InputStream>() { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public Class a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        };

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f66684a);
        }
    }

    public DataUrlLoader(DataDecoder dataDecoder) {
        this.f66680a = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData b(Object obj, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new DataUriFetcher(obj.toString(), this.f66680a));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f66681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DataDecoder f66682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f66683c;

        DataUriFetcher(String str, DataDecoder dataDecoder) {
            this.f66681a = str;
            this.f66682b = dataDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66682b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            try {
                this.f66682b.b(this.f66683c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object objC = this.f66682b.c(this.f66681a);
                this.f66683c = objC;
                dataCallback.f(objC);
            } catch (IllegalArgumentException e3) {
                dataCallback.c(e3);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }
}
