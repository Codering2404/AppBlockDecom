package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributes f40339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f40340b = -1;

    AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f40339a.equals(((AudioAttributesImplApi21) obj).f40339a);
        }
        return false;
    }

    public int hashCode() {
        return this.f40339a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f40339a;
    }
}
