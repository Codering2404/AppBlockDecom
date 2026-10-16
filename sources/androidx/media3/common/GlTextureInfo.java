package androidx.media3.common;

import androidx.media3.common.util.GlUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlTextureInfo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GlTextureInfo f40689f = new GlTextureInfo(-1, -1, -1, -1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f40692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f40693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f40694e;

    public GlTextureInfo(int i3, int i4, int i5, int i6, int i7) {
        this.f40690a = i3;
        this.f40691b = i4;
        this.f40692c = i5;
        this.f40693d = i6;
        this.f40694e = i7;
    }

    public void a() throws GlUtil.GlException {
        int i3 = this.f40690a;
        if (i3 != -1) {
            GlUtil.D(i3);
        }
        int i4 = this.f40691b;
        if (i4 != -1) {
            GlUtil.z(i4);
        }
        int i5 = this.f40692c;
        if (i5 != -1) {
            GlUtil.A(i5);
        }
    }
}
