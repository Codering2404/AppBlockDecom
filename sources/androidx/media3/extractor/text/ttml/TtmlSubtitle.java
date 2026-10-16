package androidx.media3.extractor.text.ttml;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TtmlSubtitle implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TtmlNode f47249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f47250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f47251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f47252d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f47253f;

    public TtmlSubtitle(TtmlNode ttmlNode, Map map, Map map2, Map map3) {
        this.f47249a = ttmlNode;
        this.f47252d = map2;
        this.f47253f = map3;
        this.f47251c = map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
        this.f47250b = ttmlNode.j();
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int a(long j3) {
        int iF = Util.f(this.f47250b, j3, false, false);
        if (iF < this.f47250b.length) {
            return iF;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List b(long j3) {
        return this.f47249a.h(j3, this.f47251c, this.f47252d, this.f47253f);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long c(int i3) {
        return this.f47250b[i3];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int d() {
        return this.f47250b.length;
    }
}
