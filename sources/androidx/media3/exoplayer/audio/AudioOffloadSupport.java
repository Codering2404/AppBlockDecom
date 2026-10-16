package androidx.media3.exoplayer.audio;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioOffloadSupport {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AudioOffloadSupport f43693d = new Builder().d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f43694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f43695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f43696c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f43697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f43698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f43699c;

        public AudioOffloadSupport d() {
            if (this.f43697a || !(this.f43698b || this.f43699c)) {
                return new AudioOffloadSupport(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public Builder e(boolean z2) {
            this.f43697a = z2;
            return this;
        }

        public Builder f(boolean z2) {
            this.f43698b = z2;
            return this;
        }

        public Builder g(boolean z2) {
            this.f43699c = z2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioOffloadSupport.class == obj.getClass()) {
            AudioOffloadSupport audioOffloadSupport = (AudioOffloadSupport) obj;
            if (this.f43694a == audioOffloadSupport.f43694a && this.f43695b == audioOffloadSupport.f43695b && this.f43696c == audioOffloadSupport.f43696c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f43694a ? 1 : 0) << 2) + ((this.f43695b ? 1 : 0) << 1) + (this.f43696c ? 1 : 0);
    }

    private AudioOffloadSupport(Builder builder) {
        this.f43694a = builder.f43697a;
        this.f43695b = builder.f43698b;
        this.f43696c = builder.f43699c;
    }
}
