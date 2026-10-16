package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileOpener f66696a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FileOpener f66697a;

        public Factory(FileOpener fileOpener) {
            this.f66697a = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f66697a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() { // from class: com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public Class a() {
                    return ParcelFileDescriptor.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public ParcelFileDescriptor c(File file) {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FileOpener<Data> {
        Class a();

        void b(Object obj);

        Object c(File file);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() { // from class: com.bumptech.glide.load.model.FileLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public Class a() {
                    return InputStream.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public void b(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public InputStream c(File file) {
                    return new FileInputStream(file);
                }
            });
        }
    }

    public FileLoader(FileOpener fileOpener) {
        this.f66696a = fileOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(File file, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(file), new FileFetcher(file, this.f66696a));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FileFetcher<Data> implements DataFetcher<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f66698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FileOpener f66699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f66700c;

        FileFetcher(File file, FileOpener fileOpener) {
            this.f66698a = file;
            this.f66699b = fileOpener;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66699b.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            Object obj = this.f66700c;
            if (obj != null) {
                try {
                    this.f66699b.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object objC = this.f66699b.c(this.f66698a);
                this.f66700c = objC;
                dataCallback.f(objC);
            } catch (FileNotFoundException e3) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e3);
                }
                dataCallback.c(e3);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }
}
