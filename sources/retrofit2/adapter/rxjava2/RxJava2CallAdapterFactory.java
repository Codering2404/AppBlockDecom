package retrofit2.adapter.rxjava2;

import androidx.legacy.content.Werj.QgXempTBEfV;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Scheduler f147046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f147047b;

    private RxJava2CallAdapterFactory(Scheduler scheduler, boolean z2) {
        this.f147046a = scheduler;
        this.f147047b = z2;
    }

    public static RxJava2CallAdapterFactory d() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z2;
        boolean z3;
        boolean z4;
        Type typeB;
        boolean z5;
        boolean z6;
        String str;
        Class clsC = CallAdapter.Factory.c(type);
        if (clsC == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.f147046a, this.f147047b, false, true, false, false, false, true);
        }
        if (clsC == Flowable.class) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clsC == Single.class) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (clsC == Maybe.class) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (clsC != Observable.class && !z2 && !z3 && !z4) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (!z2) {
                if (z3) {
                    str = QgXempTBEfV.WWRaQkMAXAb;
                } else if (z4) {
                    str = "Maybe";
                } else {
                    str = "Observable";
                }
            } else {
                str = "Flowable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeB2 = CallAdapter.Factory.b(0, (ParameterizedType) type);
        Class clsC2 = CallAdapter.Factory.c(typeB2);
        if (clsC2 == Response.class) {
            if (typeB2 instanceof ParameterizedType) {
                typeB = CallAdapter.Factory.b(0, (ParameterizedType) typeB2);
                z6 = false;
                z5 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (clsC2 == Result.class) {
            if (typeB2 instanceof ParameterizedType) {
                typeB = CallAdapter.Factory.b(0, (ParameterizedType) typeB2);
                z6 = true;
                z5 = false;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            typeB = typeB2;
            z5 = true;
            z6 = false;
        }
        return new RxJava2CallAdapter(typeB, this.f147046a, this.f147047b, z6, z5, z2, z3, z4, false);
    }
}
