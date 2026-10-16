package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ListenerHolders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f71587a = Collections.newSetFromMap(new WeakHashMap());

    public static ListenerHolder a(Object obj, Looper looper, String str) {
        Preconditions.n(obj, "Listener must not be null");
        Preconditions.n(looper, "Looper must not be null");
        Preconditions.n(str, "Listener type must not be null");
        return new ListenerHolder(looper, obj, str);
    }

    public static ListenerHolder b(Object obj, Executor executor, String str) {
        Preconditions.n(obj, "Listener must not be null");
        Preconditions.n(executor, "Executor must not be null");
        Preconditions.n(str, "Listener type must not be null");
        return new ListenerHolder(executor, obj, str);
    }

    public static ListenerHolder.ListenerKey c(Object obj, String str) {
        Preconditions.n(obj, "Listener must not be null");
        Preconditions.n(str, "Listener type must not be null");
        Preconditions.h(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey(obj, str);
    }

    public final void d() {
        Iterator it = this.f71587a.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).a();
        }
        this.f71587a.clear();
    }
}
