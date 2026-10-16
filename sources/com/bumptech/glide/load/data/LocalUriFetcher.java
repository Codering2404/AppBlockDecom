package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f66288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f66289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f66290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f66291d;

    LocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z2) {
        this.f66290c = contentResolver;
        this.f66289b = uri;
        this.f66288a = z2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        Object obj = this.f66291d;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(Object obj);

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void e(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object objF = f(this.f66289b, this.f66290c);
            this.f66291d = objF;
            dataCallback.f(objF);
        } catch (FileNotFoundException e3) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e3);
            }
            dataCallback.c(e3);
        }
    }

    protected abstract Object f(Uri uri, ContentResolver contentResolver);

    protected AssetFileDescriptor g(Uri uri) {
        return (this.f66288a && MediaStoreUtil.d(uri) && MediaStoreUtil.c()) ? MediaStoreUtil.h(uri, this.f66290c) : this.f66290c.openAssetFileDescriptor(uri, "r");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
