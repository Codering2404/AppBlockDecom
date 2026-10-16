package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.DataReader;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface DataSource extends DataReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        DataSource a();
    }

    long b(DataSpec dataSpec);

    void c(TransferListener transferListener);

    void close();

    default Map e() {
        return Collections.EMPTY_MAP;
    }

    Uri getUri();
}
