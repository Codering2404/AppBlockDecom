package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CreationContext {
    public static CreationContext a(Context context, Clock clock, Clock clock2, String str) {
        return new AutoValue_CreationContext(context, clock, clock2, str);
    }

    public abstract Context b();

    public abstract String c();

    public abstract Clock d();

    public abstract Clock e();
}
