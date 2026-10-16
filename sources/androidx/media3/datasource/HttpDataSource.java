package androidx.media3.datasource;

import androidx.media3.datasource.DataSource;
import com.facebook.ads.AdError;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface HttpDataSource extends DataSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class BaseFactory implements Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RequestProperties f41906a;

        protected abstract HttpDataSource b(RequestProperties requestProperties);

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource a() {
            return b(this.f41906a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, 2007, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory extends DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        HttpDataSource a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InvalidContentTypeException extends HttpDataSourceException {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f41909d;

        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, AdError.INTERNAL_ERROR_2003, 1);
            this.f41909d = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41910d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f41911f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map f41912g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f41913h;

        public InvalidResponseCodeException(int i3, String str, IOException iOException, Map map, DataSpec dataSpec, byte[] bArr) {
            super("Response code: " + i3, iOException, dataSpec, AdError.INTERNAL_ERROR_2004, 1);
            this.f41910d = i3;
            this.f41911f = str;
            this.f41912g = map;
            this.f41913h = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class RequestProperties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f41914a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f41915b;

        public synchronized Map a() {
            try {
                if (this.f41915b == null) {
                    this.f41915b = Collections.unmodifiableMap(new HashMap(this.f41914a));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f41915b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class HttpDataSourceException extends DataSourceException {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataSpec f41907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41908c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(DataSpec dataSpec, int i3, int i4) {
            super(b(i3, i4));
            this.f41907b = dataSpec;
            this.f41908c = i4;
        }

        private static int b(int i3, int i4) {
            return (i3 == 2000 && i4 == 1) ? AdError.INTERNAL_ERROR_CODE : i3;
        }

        public static HttpDataSourceException c(IOException iOException, DataSpec dataSpec, int i3) {
            String message = iOException.getMessage();
            int i4 = iOException instanceof SocketTimeoutException ? AdError.CACHE_ERROR_CODE : iOException instanceof InterruptedIOException ? 1004 : (message == null || !Ascii.e(message).matches("cleartext.*not permitted.*")) ? AdError.INTERNAL_ERROR_CODE : 2007;
            return i4 == 2007 ? new CleartextNotPermittedException(iOException, dataSpec) : new HttpDataSourceException(iOException, dataSpec, i4, i3);
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i3, int i4) {
            super(str, b(i3, i4));
            this.f41907b = dataSpec;
            this.f41908c = i4;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i3, int i4) {
            super(iOException, b(i3, i4));
            this.f41907b = dataSpec;
            this.f41908c = i4;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i3, int i4) {
            super(str, iOException, b(i3, i4));
            this.f41907b = dataSpec;
            this.f41908c = i4;
        }
    }
}
