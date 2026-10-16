package androidx.media;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f40341a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f40342b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f40343c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f40344d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f40342b;
    }

    public int b() {
        int i3 = this.f40343c;
        int iC = c();
        if (iC == 6) {
            i3 |= 4;
        } else if (iC == 7) {
            i3 |= 1;
        }
        return i3 & 273;
    }

    public int c() {
        int i3 = this.f40344d;
        return i3 != -1 ? i3 : AudioAttributesCompat.a(false, this.f40343c, this.f40341a);
    }

    public int d() {
        return this.f40341a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f40342b == audioAttributesImplBase.a() && this.f40343c == audioAttributesImplBase.b() && this.f40341a == audioAttributesImplBase.d() && this.f40344d == audioAttributesImplBase.f40344d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f40342b), Integer.valueOf(this.f40343c), Integer.valueOf(this.f40341a), Integer.valueOf(this.f40344d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f40344d != -1) {
            sb.append(" stream=");
            sb.append(this.f40344d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f40341a));
        sb.append(" content=");
        sb.append(this.f40342b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f40343c).toUpperCase());
        return sb.toString();
    }
}
