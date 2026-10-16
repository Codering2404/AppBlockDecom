package androidx.media3.transformer;

import androidx.media3.common.Effect;
import androidx.media3.common.MediaItem;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class EditedMediaItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaItem f48095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f48096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f48097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f48098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f48099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f48100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Effects f48101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f48102h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediaItem f48103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f48105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f48106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f48107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f48108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Effects f48109g;

        public EditedMediaItem a() {
            return new EditedMediaItem(this.f48103a, this.f48104b, this.f48105c, this.f48106d, this.f48107e, this.f48108f, this.f48109g);
        }

        public Builder b(long j3) {
            Assertions.a(j3 > 0);
            this.f48107e = j3;
            return this;
        }

        public Builder c(Effects effects) {
            this.f48109g = effects;
            return this;
        }

        Builder d(MediaItem mediaItem) {
            this.f48103a = mediaItem;
            return this;
        }

        public Builder e(boolean z2) {
            this.f48104b = z2;
            return this;
        }

        public Builder f(boolean z2) {
            this.f48105c = z2;
            return this;
        }

        public Builder(MediaItem mediaItem) {
            this.f48103a = mediaItem;
            MediaItem.LocalConfiguration localConfiguration = mediaItem.f40714b;
            this.f48107e = localConfiguration == null ? -9223372036854775807L : Util.P0(localConfiguration.f40819j);
            this.f48108f = -2147483647;
            this.f48109g = Effects.f48125c;
        }

        private Builder(EditedMediaItem editedMediaItem) {
            this.f48103a = editedMediaItem.f48095a;
            this.f48104b = editedMediaItem.f48096b;
            this.f48105c = editedMediaItem.f48097c;
            this.f48106d = editedMediaItem.f48098d;
            this.f48107e = editedMediaItem.f48099e;
            this.f48108f = editedMediaItem.f48100f;
            this.f48109g = editedMediaItem.f48101g;
        }
    }

    public Builder a() {
        return new Builder();
    }

    long b(long j3) {
        long jG;
        long j4 = -9223372036854775807L;
        if (this.f48096b) {
            jG = -9223372036854775807L;
        } else {
            UnmodifiableIterator it = this.f48101g.f48126a.iterator();
            jG = j3;
            while (it.hasNext()) {
                jG = ((AudioProcessor) it.next()).g(jG);
            }
        }
        if (!this.f48097c) {
            UnmodifiableIterator it2 = this.f48101g.f48127b.iterator();
            while (it2.hasNext()) {
                j3 = ((Effect) it2.next()).e(j3);
            }
            j4 = j3;
        }
        return Math.max(jG, j4);
    }

    long c() {
        if (this.f48102h == -9223372036854775807L) {
            if (this.f48095a.f40718f.equals(MediaItem.ClippingConfiguration.f40738h) || this.f48099e == -9223372036854775807L) {
                this.f48102h = this.f48099e;
            } else {
                MediaItem.ClippingConfiguration clippingConfiguration = this.f48095a.f40718f;
                Assertions.a(!clippingConfiguration.f40751f);
                long j3 = clippingConfiguration.f40749d;
                if (j3 == Long.MIN_VALUE) {
                    this.f48102h = this.f48099e - clippingConfiguration.f40747b;
                } else {
                    Assertions.a(j3 <= this.f48099e);
                    this.f48102h = clippingConfiguration.f40749d - clippingConfiguration.f40747b;
                }
            }
            this.f48102h = b(this.f48102h);
        }
        return this.f48102h;
    }

    boolean d() {
        return e(this.f48095a);
    }

    private EditedMediaItem(MediaItem mediaItem, boolean z2, boolean z3, boolean z4, long j3, int i3, Effects effects) {
        Assertions.h((z2 && z3) ? false : true, "Audio and video cannot both be removed");
        if (e(mediaItem)) {
            Assertions.a(j3 != -9223372036854775807L);
            Assertions.a((z2 || z4 || !effects.f48126a.isEmpty()) ? false : true);
        }
        this.f48095a = mediaItem;
        this.f48096b = z2;
        this.f48097c = z3;
        this.f48098d = z4;
        this.f48099e = j3;
        this.f48100f = i3;
        this.f48101g = effects;
        this.f48102h = -9223372036854775807L;
    }

    private static boolean e(MediaItem mediaItem) {
        return Objects.equals(mediaItem.f40713a, FptyjHFU.ASTzAFOC);
    }
}
