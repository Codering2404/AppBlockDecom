package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FileDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RandomAccessFile f41893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f41894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f41895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f41896h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TransferListener f41897a;

        @Override // androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f41897a;
            if (transferListener != null) {
                fileDataSource.c(transferListener);
            }
            return fileDataSource;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FileDataSourceException extends DataSourceException {
        public FileDataSourceException(Throwable th, int i3) {
            super(th, i3);
        }

        public FileDataSourceException(String str, Throwable th, int i3) {
            super(str, th, i3);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile r(Uri uri) throws FileDataSourceException {
        int i3 = AdError.INTERNAL_ERROR_2006;
        try {
            return new RandomAccessFile((String) Assertions.e(uri.getPath()), "r");
        } catch (FileNotFoundException e3) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e3, 1004);
            }
            if (!(e3.getCause() instanceof ErrnoException) || ((ErrnoException) e3.getCause()).errno != OsConstants.EACCES) {
                i3 = 2005;
            }
            throw new FileDataSourceException(e3, i3);
        } catch (SecurityException e4) {
            throw new FileDataSourceException(e4, AdError.INTERNAL_ERROR_2006);
        } catch (RuntimeException e5) {
            throw new FileDataSourceException(e5, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f41829a;
        this.f41894f = uri;
        p(dataSpec);
        RandomAccessFile randomAccessFileR = r(uri);
        this.f41893e = randomAccessFileR;
        try {
            randomAccessFileR.seek(dataSpec.f41835g);
            long length = dataSpec.f41836h;
            if (length == -1) {
                length = this.f41893e.length() - dataSpec.f41835g;
            }
            this.f41895g = length;
            if (length < 0) {
                throw new FileDataSourceException(null, null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            this.f41896h = true;
            q(dataSpec);
            return this.f41895g;
        } catch (IOException e3) {
            throw new FileDataSourceException(e3, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41894f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f41893e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e3) {
                throw new FileDataSourceException(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            this.f41893e = null;
            if (this.f41896h) {
                this.f41896h = false;
                o();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41894f;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws FileDataSourceException {
        if (i4 == 0) {
            return 0;
        }
        if (this.f41895g == 0) {
            return -1;
        }
        try {
            int i5 = ((RandomAccessFile) Util.k(this.f41893e)).read(bArr, i3, (int) Math.min(this.f41895g, i4));
            if (i5 > 0) {
                this.f41895g -= (long) i5;
                n(i5);
            }
            return i5;
        } catch (IOException e3) {
            throw new FileDataSourceException(e3, AdError.SERVER_ERROR_CODE);
        }
    }
}
