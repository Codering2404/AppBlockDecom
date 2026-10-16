package ru.noties.markwon;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Markwon {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Builder {
        Builder a(MarkwonPlugin markwonPlugin);

        Markwon build();
    }

    public static Builder a(Context context) {
        return new MarkwonBuilderImpl(context);
    }

    public abstract void b(TextView textView, String str);
}
