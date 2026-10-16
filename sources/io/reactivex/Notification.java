package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class Notification<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Notification f134850b = new Notification(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f134851a;

    private Notification(Object obj) {
        this.f134851a = obj;
    }

    public static Notification a() {
        return f134850b;
    }

    public static Notification b(Throwable th) {
        ObjectHelper.d(th, "error is null");
        return new Notification(NotificationLite.g(th));
    }

    public static Notification c(Object obj) {
        ObjectHelper.d(obj, "value is null");
        return new Notification(obj);
    }

    public Throwable d() {
        Object obj = this.f134851a;
        if (NotificationLite.k(obj)) {
            return NotificationLite.h(obj);
        }
        return null;
    }

    public Object e() {
        Object obj = this.f134851a;
        if (obj == null || NotificationLite.k(obj)) {
            return null;
        }
        return this.f134851a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.c(this.f134851a, ((Notification) obj).f134851a);
        }
        return false;
    }

    public boolean f() {
        return this.f134851a == null;
    }

    public boolean g() {
        return NotificationLite.k(this.f134851a);
    }

    public boolean h() {
        Object obj = this.f134851a;
        return (obj == null || NotificationLite.k(obj)) ? false : true;
    }

    public int hashCode() {
        Object obj = this.f134851a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f134851a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.k(obj)) {
            return "OnErrorNotification[" + NotificationLite.h(obj) + "]";
        }
        return "OnNextNotification[" + this.f134851a + "]";
    }
}
