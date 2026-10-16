package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f40341a = versionedParcel.p(audioAttributesImplBase.f40341a, 1);
        audioAttributesImplBase.f40342b = versionedParcel.p(audioAttributesImplBase.f40342b, 2);
        audioAttributesImplBase.f40343c = versionedParcel.p(audioAttributesImplBase.f40343c, 3);
        audioAttributesImplBase.f40344d = versionedParcel.p(audioAttributesImplBase.f40344d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f40341a, 1);
        versionedParcel.F(audioAttributesImplBase.f40342b, 2);
        versionedParcel.F(audioAttributesImplBase.f40343c, 3);
        versionedParcel.F(audioAttributesImplBase.f40344d, 4);
    }
}
