package androidx.media3.common;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FrameInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Format f40687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f40688b;

    public FrameInfo(Format format, long j3) {
        Assertions.b(format.C != null, "format colorInfo must be set");
        Assertions.b(format.f40639v > 0, "format width must be positive, but is: " + format.f40639v);
        Assertions.b(format.f40640w > 0, "format height must be positive, but is: " + format.f40640w);
        this.f40687a = format;
        this.f40688b = j3;
    }
}
