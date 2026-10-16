package androidx.media3.transformer;

import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Composition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList f47968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoCompositorSettings f47969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Effects f47970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f47971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f47972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f47973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f47974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f47975h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImmutableList f47976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private VideoCompositorSettings f47977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Effects f47978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f47980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f47981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f47983h;

        public Composition a() {
            ImmutableList immutableList = this.f47976a;
            VideoCompositorSettings videoCompositorSettings = this.f47977b;
            Effects effects = this.f47978c;
            boolean z2 = this.f47979d;
            boolean z3 = this.f47980e;
            boolean z4 = this.f47981f;
            int i3 = this.f47982g;
            return new Composition(immutableList, videoCompositorSettings, effects, z2, z3, z4, i3, this.f47983h && i3 == 0);
        }

        Builder b(List list) {
            Assertions.b(!list.isEmpty(), "The composition must contain at least one EditedMediaItemSequence.");
            this.f47976a = ImmutableList.t(list);
            return this;
        }

        public Builder c(boolean z2) {
            this.f47981f = z2;
            return this;
        }

        public Builder(EditedMediaItemSequence editedMediaItemSequence, EditedMediaItemSequence... editedMediaItemSequenceArr) {
            this(new ImmutableList.Builder().a(editedMediaItemSequence).j(editedMediaItemSequenceArr).m());
        }

        public Builder(List list) {
            Assertions.b(!list.isEmpty(), "The composition must contain at least one EditedMediaItemSequence.");
            this.f47976a = ImmutableList.t(list);
            this.f47977b = VideoCompositorSettings.f41251a;
            this.f47978c = Effects.f48125c;
        }

        private Builder(Composition composition) {
            this.f47976a = composition.f47968a;
            this.f47977b = composition.f47969b;
            this.f47978c = composition.f47970c;
            this.f47979d = composition.f47971d;
            this.f47980e = composition.f47972e;
            this.f47981f = composition.f47973f;
            this.f47982g = composition.f47974g;
            this.f47983h = composition.f47975h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HdrMode {
    }

    Builder a() {
        return new Builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean b() {
        for (int i3 = 0; i3 < this.f47968a.size(); i3++) {
            if (((EditedMediaItemSequence) this.f47968a.get(i3)).a()) {
                return true;
            }
        }
        return false;
    }

    private Composition(List list, VideoCompositorSettings videoCompositorSettings, Effects effects, boolean z2, boolean z3, boolean z4, int i3, boolean z5) {
        Assertions.b((z3 && z2) ? false : true, "Audio transmuxing and audio track forcing are not allowed together.");
        this.f47968a = ImmutableList.t(list);
        this.f47969b = videoCompositorSettings;
        this.f47970c = effects;
        this.f47972e = z3;
        this.f47973f = z4;
        this.f47971d = z2;
        this.f47974g = i3;
        this.f47975h = z5;
    }
}
