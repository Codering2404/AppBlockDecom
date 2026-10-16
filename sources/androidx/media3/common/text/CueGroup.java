package androidx.media3.common.text;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CueGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CueGroup f41450c = new CueGroup(ImmutableList.y(), 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41451d = Util.y0(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f41452e = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList f41453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f41454b;

    public CueGroup(List list, long j3) {
        this.f41453a = ImmutableList.t(list);
        this.f41454b = j3;
    }
}
