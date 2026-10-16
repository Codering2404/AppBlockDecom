package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.Effect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface GlEffect extends Effect {
    GlShaderProgram a(Context context, boolean z2);

    default boolean i(int i3, int i4) {
        return false;
    }
}
