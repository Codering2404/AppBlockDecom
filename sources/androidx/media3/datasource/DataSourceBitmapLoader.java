package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSourceBitmapLoader implements BitmapLoader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Supplier f41817e = Suppliers.a(new Supplier() { // from class: androidx.media3.datasource.c
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return MoreExecutors.c(Executors.newSingleThreadExecutor());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListeningExecutorService f41818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSource.Factory f41819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BitmapFactory.Options f41820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f41821d;

    public DataSourceBitmapLoader(Context context) {
        this((ListeningExecutorService) Assertions.i((ListeningExecutorService) f41817e.get()), new DefaultDataSource.Factory(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap e(DataSource dataSource, Uri uri, BitmapFactory.Options options, int i3) {
        try {
            dataSource.b(new DataSpec(uri));
            byte[] bArrB = DataSourceUtil.b(dataSource);
            return BitmapUtil.a(bArrB, bArrB.length, options, i3);
        } finally {
            dataSource.close();
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public boolean a(String str) {
        return Util.A0(str);
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture b(final Uri uri) {
        return this.f41818a.submit(new Callable() { // from class: androidx.media3.datasource.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DataSourceBitmapLoader dataSourceBitmapLoader = this.f42121a;
                return DataSourceBitmapLoader.e(dataSourceBitmapLoader.f41819b.a(), uri, dataSourceBitmapLoader.f41820c, dataSourceBitmapLoader.f41821d);
            }
        });
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory) {
        this(listeningExecutorService, factory, null);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory, BitmapFactory.Options options) {
        this(listeningExecutorService, factory, options, -1);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory, BitmapFactory.Options options, int i3) {
        this.f41818a = listeningExecutorService;
        this.f41819b = factory;
        this.f41820c = options;
        this.f41821d = i3;
    }
}
