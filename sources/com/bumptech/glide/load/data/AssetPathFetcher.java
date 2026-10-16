package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f66264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f66265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f66266c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f66265b = assetManager;
        this.f66264a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        Object obj = this.f66266c;
        if (obj == null) {
            return;
        }
        try {
            c(obj);
        } catch (IOException unused) {
        }
    }

    protected abstract void c(Object obj);

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            Object objF = f(this.f66265b, this.f66264a);
            this.f66266c = objF;
            dataCallback.f(objF);
        } catch (IOException e3) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e3);
            }
            dataCallback.c(e3);
        }
    }

    protected abstract Object f(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
