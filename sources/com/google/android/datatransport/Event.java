package com.google.android.datatransport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Event<T> {
    public static Event f(Object obj) {
        return new AutoValue_Event(null, obj, Priority.DEFAULT, null, null);
    }

    public static Event g(Object obj, ProductData productData) {
        return new AutoValue_Event(null, obj, Priority.DEFAULT, productData, null);
    }

    public static Event h(Object obj) {
        return new AutoValue_Event(null, obj, Priority.HIGHEST, null, null);
    }

    public abstract Integer a();

    public abstract EventContext b();

    public abstract Object c();

    public abstract Priority d();

    public abstract ProductData e();
}
