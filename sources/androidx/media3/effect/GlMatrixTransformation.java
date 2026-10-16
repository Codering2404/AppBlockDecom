package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.util.Size;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface GlMatrixTransformation extends GlEffect {
    float[] b(long j3);

    default Size c(int i3, int i4) {
        return new Size(i3, i4);
    }

    default int d() {
        return 9729;
    }

    @Override // androidx.media3.effect.GlEffect
    default BaseGlShaderProgram a(Context context, boolean z2) {
        return DefaultShaderProgram.t(context, ImmutableList.z(this), ImmutableList.y(), z2);
    }
}
