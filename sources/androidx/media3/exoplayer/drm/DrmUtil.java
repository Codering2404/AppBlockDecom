package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.facebook.ads.AdError;
import com.google.common.io.ByteStreams;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DrmUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static boolean a(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorSource {
    }

    public static byte[] a(DataSource dataSource, String str, byte[] bArr, Map map) throws MediaDrmCallbackException {
        StatsDataSource statsDataSource = new StatsDataSource(dataSource);
        DataSpec dataSpecA = new DataSpec.Builder().j(str).e(map).d(2).c(bArr).b(1).a();
        int i3 = 0;
        DataSpec dataSpecA2 = dataSpecA;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecA2);
                try {
                    byte[] bArrJ = ByteStreams.j(dataSourceInputStream);
                    Util.o(dataSourceInputStream);
                    return bArrJ;
                } catch (HttpDataSource.InvalidResponseCodeException e3) {
                    try {
                        String strC = c(e3, i3);
                        if (strC == null) {
                            throw e3;
                        }
                        i3++;
                        dataSpecA2 = dataSpecA2.a().j(strC).a();
                        Util.o(dataSourceInputStream);
                    } catch (Throwable th) {
                        Util.o(dataSourceInputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                throw new MediaDrmCallbackException(dataSpecA, statsDataSource.o(), statsDataSource.e(), statsDataSource.n(), e4);
            }
        }
    }

    public static int b(Throwable th, int i3) {
        if (th instanceof MediaDrm.MediaDrmStateException) {
            return Util.a0(Util.b0(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
        if (Util.f41609a >= 23 && Api23.a(th)) {
            return 6006;
        }
        if ((th instanceof NotProvisionedException) || d(th)) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        if (th instanceof DeniedByServerException) {
            return 6007;
        }
        if (th instanceof UnsupportedDrmException) {
            return AdError.MEDIAVIEW_MISSING_ERROR_CODE;
        }
        if (th instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        if (th instanceof KeysExpiredException) {
            return 6008;
        }
        if (i3 == 1) {
            return 6006;
        }
        if (i3 == 2) {
            return 6004;
        }
        if (i3 == 3) {
            return AdError.ICONVIEW_MISSING_ERROR_CODE;
        }
        throw new IllegalArgumentException();
    }

    private static String c(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i3) {
        Map map;
        List list;
        int i4 = invalidResponseCodeException.f41910d;
        if ((i4 != 307 && i4 != 308) || i3 >= 5 || (map = invalidResponseCodeException.f41912g) == null || (list = (List) map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public static boolean d(Throwable th) {
        return Util.f41609a == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean e(Throwable th) {
        return Util.f41609a == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }
}
