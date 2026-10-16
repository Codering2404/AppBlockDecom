package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsingLoadable.Parser f44471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f44472b;

    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FilterableManifest a(Uri uri, InputStream inputStream) {
        FilterableManifest filterableManifest = (FilterableManifest) this.f44471a.a(uri, inputStream);
        List list = this.f44472b;
        return (list == null || list.isEmpty()) ? filterableManifest : (FilterableManifest) filterableManifest.a(this.f44472b);
    }
}
