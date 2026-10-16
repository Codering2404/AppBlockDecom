package androidx.media3.transformer;

import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EditedMediaItemSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList f48110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f48111b;

    /* JADX WARN: Multi-variable type inference failed */
    boolean a() {
        for (int i3 = 0; i3 < this.f48110a.size(); i3++) {
            if (((EditedMediaItem) this.f48110a.get(i3)).d()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList.Builder f48112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48113b;

        public Builder(EditedMediaItem... editedMediaItemArr) {
            this.f48112a = new ImmutableList.Builder().j(editedMediaItemArr);
        }

        public EditedMediaItemSequence c() {
            return new EditedMediaItemSequence(this);
        }

        public Builder d(boolean z2) {
            this.f48113b = z2;
            return this;
        }

        public Builder(List list) {
            this.f48112a = new ImmutableList.Builder().k(list);
        }
    }

    private EditedMediaItemSequence(Builder builder) {
        this.f48110a = builder.f48112a.m();
        Assertions.b(!r0.isEmpty(), "The sequence must contain at least one EditedMediaItem.");
        this.f48111b = builder.f48113b;
    }
}
