package androidx.media3.transformer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioEncoderSettings {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AudioEncoderSettings f47902c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47904b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f47905a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f47906b = -1;

        public AudioEncoderSettings a() {
            return new AudioEncoderSettings(this.f47905a, this.f47906b);
        }

        public Builder b(int i3) {
            this.f47906b = i3;
            return this;
        }
    }

    private AudioEncoderSettings(int i3, int i4) {
        this.f47903a = i3;
        this.f47904b = i4;
    }
}
