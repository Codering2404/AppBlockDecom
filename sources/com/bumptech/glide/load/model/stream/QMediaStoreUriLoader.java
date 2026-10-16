package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ModelLoader f66789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ModelLoader f66790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class f66791d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f66793b;

        Factory(Context context, Class cls) {
            this.f66792a = context;
            this.f66793b = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f66792a, multiModelLoaderFactory.d(File.class, this.f66793b), multiModelLoaderFactory.d(Uri.class, this.f66793b), this.f66793b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String[] f66794l = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ModelLoader f66796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ModelLoader f66797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f66798d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f66799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f66800g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Options f66801h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Class f66802i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f66803j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private volatile DataFetcher f66804k;

        QMediaStoreUriFetcher(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Uri uri, int i3, int i4, Options options, Class cls) {
            this.f66795a = context.getApplicationContext();
            this.f66796b = modelLoader;
            this.f66797c = modelLoader2;
            this.f66798d = uri;
            this.f66799f = i3;
            this.f66800g = i4;
            this.f66801h = options;
            this.f66802i = cls;
        }

        private ModelLoader.LoadData c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.f66796b.b(h(this.f66798d), this.f66799f, this.f66800g, this.f66801h);
            }
            if (MediaStoreUtil.a(this.f66798d)) {
                return this.f66797c.b(this.f66798d, this.f66799f, this.f66800g, this.f66801h);
            }
            return this.f66797c.b(g() ? MediaStore.setRequireOriginal(this.f66798d) : this.f66798d, this.f66799f, this.f66800g, this.f66801h);
        }

        private DataFetcher f() {
            ModelLoader.LoadData loadDataC = c();
            if (loadDataC != null) {
                return loadDataC.f66731c;
            }
            return null;
        }

        private boolean g() {
            return this.f66795a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        private File h(Uri uri) {
            try {
                Cursor cursorQuery = this.f66795a.getContentResolver().query(uri, f66794l, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } finally {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66802i;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            DataFetcher dataFetcher = this.f66804k;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f66803j = true;
            DataFetcher dataFetcher = this.f66804k;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                DataFetcher dataFetcherF = f();
                if (dataFetcherF == null) {
                    dataCallback.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f66798d));
                    return;
                }
                this.f66804k = dataFetcherF;
                if (this.f66803j) {
                    cancel();
                } else {
                    dataFetcherF.e(priority, dataCallback);
                }
            } catch (FileNotFoundException e3) {
                dataCallback.c(e3);
            }
        }
    }

    QMediaStoreUriLoader(Context context, ModelLoader modelLoader, ModelLoader modelLoader2, Class cls) {
        this.f66788a = context.getApplicationContext();
        this.f66789b = modelLoader;
        this.f66790c = modelLoader2;
        this.f66791d = cls;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f66788a, this.f66789b, this.f66790c, uri, i3, i4, options, this.f66791d));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.d(uri);
    }
}
