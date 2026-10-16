package androidx.media3.extractor.text;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CuesWithTiming {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList f46934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f46937d;

    public CuesWithTiming(List list, long j3, long j4) {
        this.f46934a = ImmutableList.t(list);
        this.f46935b = j3;
        this.f46936c = j4;
        long j5 = -9223372036854775807L;
        if (j3 != -9223372036854775807L && j4 != -9223372036854775807L) {
            j5 = j3 + j4;
        }
        this.f46937d = j5;
    }
}
