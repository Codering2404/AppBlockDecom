package androidx.media3.exoplayer.upstream;

import androidx.media3.common.ParserException;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f45529a;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public long a(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.f45532c;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.a(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((loadErrorInfo.f45533d - 1) * 1000, 5000);
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public int b(int i3) {
        int i4 = this.f45529a;
        return i4 == -1 ? i3 == 7 ? 6 : 3 : i4;
    }

    public DefaultLoadErrorHandlingPolicy(int i3) {
        this.f45529a = i3;
    }
}
