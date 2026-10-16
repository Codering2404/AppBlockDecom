package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ParsingLoadable<T> implements Loader.Loadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45554a = LoadEventInfo.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSpec f45555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StatsDataSource f45557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parser f45558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f45559f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Parser<T> {
        Object a(Uri uri, InputStream inputStream);
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i3, Parser parser) {
        this.f45557d = new StatsDataSource(dataSource);
        this.f45555b = dataSpec;
        this.f45556c = i3;
        this.f45558e = parser;
    }

    public static Object d(DataSource dataSource, Parser parser, DataSpec dataSpec, int i3) {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, i3, parser);
        parsingLoadable.a();
        return Assertions.e(parsingLoadable.b());
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        this.f45557d.q();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f45557d, this.f45555b);
        try {
            dataSourceInputStream.b();
            this.f45559f = this.f45558e.a((Uri) Assertions.e(this.f45557d.getUri()), dataSourceInputStream);
        } finally {
            Util.o(dataSourceInputStream);
        }
    }

    public final Object b() {
        return this.f45559f;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void c() {
    }
}
