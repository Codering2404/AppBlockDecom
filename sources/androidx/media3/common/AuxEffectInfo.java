package androidx.media3.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AuxEffectInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f40537b;

    public AuxEffectInfo(int i3, float f3) {
        this.f40536a = i3;
        this.f40537b = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AuxEffectInfo.class == obj.getClass()) {
            AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
            if (this.f40536a == auxEffectInfo.f40536a && Float.compare(auxEffectInfo.f40537b, this.f40537b) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f40536a) * 31) + Float.floatToIntBits(this.f40537b);
    }
}
