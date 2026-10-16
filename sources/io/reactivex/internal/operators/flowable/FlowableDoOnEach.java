package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f135593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f135594d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Action f135595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Action f135596g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Consumer f135597g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Consumer f135598h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Action f135599i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Action f135600j;

        DoOnEachConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Consumer consumer, Consumer consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f135597g = consumer;
            this.f135598h = consumer2;
            this.f135599i = action;
            this.f135600j = action2;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139114d) {
                return;
            }
            if (this.f139115f != 0) {
                this.f139111a.h(null);
                return;
            }
            try {
                this.f135597g.accept(obj);
                this.f139111a.h(obj);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (this.f139114d) {
                return false;
            }
            try {
                this.f135597g.accept(obj);
                return this.f139111a.o(obj);
            } catch (Throwable th) {
                c(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f139114d) {
                return;
            }
            try {
                this.f135599i.run();
                this.f139114d = true;
                this.f139111a.onComplete();
                try {
                    this.f135600j.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f139114d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f139114d = true;
            try {
                this.f135598h.accept(th);
                this.f139111a.onError(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f139111a.onError(new CompositeException(th, th2));
            }
            try {
                this.f135600j.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            CompositeException compositeException;
            try {
                Object objPoll = this.f139113c.poll();
                if (objPoll == null) {
                    if (this.f139115f == 1) {
                        this.f135599i.run();
                        this.f135600j.run();
                    }
                    return objPoll;
                }
                try {
                    this.f135597g.accept(objPoll);
                    this.f135600j.run();
                    return objPoll;
                } catch (Throwable th) {
                    try {
                        Exceptions.b(th);
                        try {
                            this.f135598h.accept(th);
                            throw ExceptionHelper.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f135600j.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                try {
                    this.f135598h.accept(th3);
                    throw ExceptionHelper.c(th3);
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Consumer f135601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Consumer f135602h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Action f135603i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Action f135604j;

        DoOnEachSubscriber(Subscriber subscriber, Consumer consumer, Consumer consumer2, Action action, Action action2) {
            super(subscriber);
            this.f135601g = consumer;
            this.f135602h = consumer2;
            this.f135603i = action;
            this.f135604j = action2;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139119d) {
                return;
            }
            if (this.f139120f != 0) {
                this.f139116a.h(null);
                return;
            }
            try {
                this.f135601g.accept(obj);
                this.f139116a.h(obj);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f139119d) {
                return;
            }
            try {
                this.f135603i.run();
                this.f139119d = true;
                this.f139116a.onComplete();
                try {
                    this.f135604j.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f139119d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f139119d = true;
            try {
                this.f135602h.accept(th);
                this.f139116a.onError(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f139116a.onError(new CompositeException(th, th2));
            }
            try {
                this.f135604j.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            CompositeException compositeException;
            try {
                Object objPoll = this.f139118c.poll();
                if (objPoll == null) {
                    if (this.f139120f == 1) {
                        this.f135603i.run();
                        this.f135604j.run();
                    }
                    return objPoll;
                }
                try {
                    this.f135601g.accept(objPoll);
                    this.f135604j.run();
                    return objPoll;
                } catch (Throwable th) {
                    try {
                        Exceptions.b(th);
                        try {
                            this.f135602h.accept(th);
                            throw ExceptionHelper.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f135604j.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                try {
                    this.f135602h.accept(th3);
                    throw ExceptionHelper.c(th3);
                } finally {
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new DoOnEachConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135593c, this.f135594d, this.f135595f, this.f135596g));
        } else {
            this.f135196b.w(new DoOnEachSubscriber(subscriber, this.f135593c, this.f135594d, this.f135595f, this.f135596g));
        }
    }
}
