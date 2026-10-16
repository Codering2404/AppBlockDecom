package androidx.media3.extractor.text.cea;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CeaSubtitle implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47063a;

    public CeaSubtitle(List list) {
        this.f47063a = list;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int a(long j3) {
        return j3 < 0 ? 0 : -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List b(long j3) {
        return j3 >= 0 ? this.f47063a : Collections.EMPTY_LIST;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long c(int i3) {
        Assertions.a(i3 == 0);
        return 0L;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int d() {
        return 1;
    }
}
