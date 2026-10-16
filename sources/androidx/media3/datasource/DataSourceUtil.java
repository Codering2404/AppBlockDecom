package androidx.media3.datasource;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSourceUtil {
    public static void a(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] b(DataSource dataSource) {
        byte[] bArrCopyOf = new byte[1024];
        int i3 = 0;
        int i4 = 0;
        while (i3 != -1) {
            if (i4 == bArrCopyOf.length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
            }
            i3 = dataSource.read(bArrCopyOf, i4, bArrCopyOf.length - i4);
            if (i3 != -1) {
                i4 += i3;
            }
        }
        return Arrays.copyOf(bArrCopyOf, i4);
    }
}
