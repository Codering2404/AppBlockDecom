package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66718a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66719a;

        public Factory(Context context) {
            this.f66719a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f66719a);
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f66718a = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), new FilePathFetcher(this.f66718a, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return MediaStoreUtil.d(uri);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilePathFetcher implements DataFetcher<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f66720c = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f66722b;

        FilePathFetcher(Context context, Uri uri) {
            this.f66721a = context;
            this.f66722b = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            Cursor cursorQuery = this.f66721a.getContentResolver().query(this.f66722b, f66720c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                dataCallback.f(new File(string));
                return;
            }
            dataCallback.c(new FileNotFoundException("Failed to find file path for: " + this.f66722b));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }
}
