package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import com.google.common.collect.Sets;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FileDescriptorDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Set f41898l = Sets.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FileDescriptor f41899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f41900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f41901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f41902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FileInputStream f41903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f41904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f41905k;

    private static void r(FileDescriptor fileDescriptor, long j3) throws DataSourceException {
        try {
            Os.lseek(fileDescriptor, j3, OsConstants.SEEK_SET);
        } catch (ErrnoException e3) {
            throw new DataSourceException(e3, AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws DataSourceException {
        try {
            this.f41902h = dataSpec.f41829a;
            p(dataSpec);
            if (!f41898l.add(this.f41899e)) {
                throw new DataSourceException(new IllegalStateException("Attempted to re-use an already in-use file descriptor"), -2);
            }
            long j3 = this.f41901g;
            if (j3 != -1 && dataSpec.f41835g > j3) {
                throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            r(this.f41899e, this.f41900f + dataSpec.f41835g);
            FileInputStream fileInputStream = new FileInputStream(this.f41899e);
            this.f41903i = fileInputStream;
            long j4 = this.f41901g;
            if (j4 == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f41904j = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f41904j = jPosition;
                    if (jPosition < 0) {
                        throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            } else {
                long j5 = j4 - dataSpec.f41835g;
                this.f41904j = j5;
                if (j5 < 0) {
                    throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
                }
            }
            long jMin = dataSpec.f41836h;
            if (jMin != -1) {
                long j6 = this.f41904j;
                if (j6 != -1) {
                    jMin = Math.min(j6, jMin);
                }
                this.f41904j = jMin;
            }
            this.f41905k = true;
            q(dataSpec);
            long j7 = dataSpec.f41836h;
            return j7 != -1 ? j7 : this.f41904j;
        } catch (DataSourceException e3) {
            throw e3;
        } catch (IOException e4) {
            throw new DataSourceException(e4, e4 instanceof FileNotFoundException ? 2005 : AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41902h = null;
        f41898l.remove(this.f41899e);
        try {
            try {
                FileInputStream fileInputStream = this.f41903i;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e3) {
                throw new DataSourceException(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            this.f41903i = null;
            if (this.f41905k) {
                this.f41905k = false;
                o();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41902h;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws DataSourceException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41904j;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            i4 = (int) Math.min(j3, i4);
        }
        try {
            int i5 = ((FileInputStream) Util.k(this.f41903i)).read(bArr, i3, i4);
            if (i5 == -1) {
                return -1;
            }
            long j4 = this.f41904j;
            if (j4 != -1) {
                this.f41904j = j4 - ((long) i5);
            }
            n(i5);
            return i5;
        } catch (IOException e3) {
            throw new DataSourceException(e3, AdError.SERVER_ERROR_CODE);
        }
    }
}
