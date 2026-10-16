package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WebvttSubtitle implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f47329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f47330c;

    public WebvttSubtitle(List list) {
        this.f47328a = Collections.unmodifiableList(new ArrayList(list));
        this.f47329b = new long[list.size() * 2];
        for (int i3 = 0; i3 < list.size(); i3++) {
            WebvttCueInfo webvttCueInfo = (WebvttCueInfo) list.get(i3);
            int i4 = i3 * 2;
            long[] jArr = this.f47329b;
            jArr[i4] = webvttCueInfo.f47299b;
            jArr[i4 + 1] = webvttCueInfo.f47300c;
        }
        long[] jArr2 = this.f47329b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f47330c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int a(long j3) {
        int iF = Util.f(this.f47330c, j3, false, false);
        if (iF < this.f47330c.length) {
            return iF;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List b(long j3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.f47328a.size(); i3++) {
            long[] jArr = this.f47329b;
            int i4 = i3 * 2;
            if (jArr[i4] <= j3 && j3 < jArr[i4 + 1]) {
                WebvttCueInfo webvttCueInfo = (WebvttCueInfo) this.f47328a.get(i3);
                Cue cue = webvttCueInfo.f47298a;
                if (cue.f41420e == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: androidx.media3.extractor.text.webvtt.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((WebvttCueInfo) obj).f47299b, ((WebvttCueInfo) obj2).f47299b);
            }
        });
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            arrayList.add(((WebvttCueInfo) arrayList2.get(i5)).f47298a.a().h((-1) - i5, 1).a());
        }
        return arrayList;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long c(int i3) {
        Assertions.a(i3 >= 0);
        Assertions.a(i3 < this.f47330c.length);
        return this.f47330c[i3];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int d() {
        return this.f47330c.length;
    }
}
