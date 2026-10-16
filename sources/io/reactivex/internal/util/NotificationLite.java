package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum NotificationLite {
    COMPLETE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Disposable f139215a;

        DisposableNotification(Disposable disposable) {
            this.f139215a = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f139215a + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f139216a;

        ErrorNotification(Throwable th) {
            this.f139216a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.c(this.f139216a, ((ErrorNotification) obj).f139216a);
            }
            return false;
        }

        public int hashCode() {
            return this.f139216a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f139216a + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscription f139217a;

        SubscriptionNotification(Subscription subscription) {
            this.f139217a = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f139217a + "]";
        }
    }

    public static boolean a(Object obj, Observer observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f139216a);
            return true;
        }
        observer.h(obj);
        return false;
    }

    public static boolean b(Object obj, Subscriber subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f139216a);
            return true;
        }
        subscriber.h(obj);
        return false;
    }

    public static boolean c(Object obj, Observer observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f139216a);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            observer.a(((DisposableNotification) obj).f139215a);
            return false;
        }
        observer.h(obj);
        return false;
    }

    public static boolean d(Object obj, Subscriber subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f139216a);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            subscriber.g(((SubscriptionNotification) obj).f139217a);
            return false;
        }
        subscriber.h(obj);
        return false;
    }

    public static Object e() {
        return COMPLETE;
    }

    public static Object f(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object g(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Throwable h(Object obj) {
        return ((ErrorNotification) obj).f139216a;
    }

    public static boolean j(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean k(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static Object m(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object i(Object obj) {
        return obj;
    }

    public static Object l(Object obj) {
        return obj;
    }
}
