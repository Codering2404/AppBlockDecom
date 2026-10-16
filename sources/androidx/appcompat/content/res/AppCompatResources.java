package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatResources {
    public static ColorStateList a(Context context, int i3) {
        return ContextCompat.getColorStateList(context, i3);
    }

    public static Drawable b(Context context, int i3) {
        return ResourceManagerInternal.g().i(context, i3);
    }
}
