package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Retrofit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f146994a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Call.Factory f146995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final HttpUrl f146996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List f146997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f146998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List f146999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f147000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Executor f147001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f147002i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Call.Factory f147006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HttpUrl f147007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f147008c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f147009d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Executor f147010e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f147011f;

        public Builder a(CallAdapter.Factory factory) {
            List list = this.f147009d;
            Objects.requireNonNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder b(Converter.Factory factory) {
            List list = this.f147008c;
            Objects.requireNonNull(factory, "factory == null");
            list.add(factory);
            return this;
        }

        public Builder c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(HttpUrl.h(str));
        }

        public Builder d(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.m().get(r0.size() - 1))) {
                this.f147007b = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public Retrofit e() {
            if (this.f147007b == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory okHttpClient = this.f147006a;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Call.Factory factory = okHttpClient;
            Executor executor = this.f147010e;
            if (executor == null) {
                executor = Platform.f146935a;
            }
            Executor executor2 = executor;
            BuiltInFactories builtInFactories = Platform.f146937c;
            ArrayList arrayList = new ArrayList(this.f147009d);
            List listA = builtInFactories.a(executor2);
            arrayList.addAll(listA);
            List listB = builtInFactories.b();
            int size = listB.size();
            ArrayList arrayList2 = new ArrayList(this.f147008c.size() + 1 + size);
            arrayList2.add(new BuiltInConverters());
            arrayList2.addAll(this.f147008c);
            arrayList2.addAll(listB);
            return new Retrofit(factory, this.f147007b, Collections.unmodifiableList(arrayList2), size, Collections.unmodifiableList(arrayList), listA.size(), executor2, this.f147011f);
        }

        public Builder f(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.f147006a = factory;
            return this;
        }

        public Builder g(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return f(okHttpClient);
        }
    }

    Retrofit(Call.Factory factory, HttpUrl httpUrl, List list, int i3, List list2, int i4, Executor executor, boolean z2) {
        this.f146995b = factory;
        this.f146996c = httpUrl;
        this.f146997d = list;
        this.f146998e = i3;
        this.f146999f = list2;
        this.f147000g = i4;
        this.f147001h = executor;
        this.f147002i = z2;
    }

    private void j(Class cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f147002i) {
            Reflection reflection = Platform.f146936b;
            for (Method method : cls.getDeclaredMethods()) {
                if (!reflection.c(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                    c(cls, method);
                }
            }
        }
    }

    public CallAdapter a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public Object b(final Class cls) {
        j(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object[] f147003a = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (objArr == null) {
                    objArr = this.f147003a;
                }
                Reflection reflection = Platform.f146936b;
                return reflection.c(method) ? reflection.b(method, cls, obj, objArr) : Retrofit.this.c(cls, method).a(obj, objArr);
            }
        });
    }

    ServiceMethod c(Class cls, Method method) {
        while (true) {
            Object objPutIfAbsent = this.f146994a.get(method);
            if (objPutIfAbsent instanceof ServiceMethod) {
                return (ServiceMethod) objPutIfAbsent;
            }
            if (objPutIfAbsent == null) {
                Object obj = new Object();
                synchronized (obj) {
                    try {
                        objPutIfAbsent = this.f146994a.putIfAbsent(method, obj);
                        if (objPutIfAbsent == null) {
                            try {
                                ServiceMethod serviceMethodB = ServiceMethod.b(this, cls, method);
                                this.f146994a.put(method, serviceMethodB);
                                return serviceMethodB;
                            } catch (Throwable th) {
                                this.f146994a.remove(method);
                                throw th;
                            }
                        }
                    } finally {
                    }
                }
            }
            synchronized (objPutIfAbsent) {
                try {
                    Object obj2 = this.f146994a.get(method);
                    if (obj2 != null) {
                        return (ServiceMethod) obj2;
                    }
                } finally {
                }
            }
        }
    }

    public CallAdapter d(CallAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f146999f.indexOf(factory) + 1;
        int size = this.f146999f.size();
        for (int i3 = iIndexOf; i3 < size; i3++) {
            CallAdapter callAdapterA = ((CallAdapter.Factory) this.f146999f.get(i3)).a(type, annotationArr, this);
            if (callAdapterA != null) {
                return callAdapterA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i4 = 0; i4 < iIndexOf; i4++) {
                sb.append("\n   * ");
                sb.append(((CallAdapter.Factory) this.f146999f.get(i4)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f146999f.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((CallAdapter.Factory) this.f146999f.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public Converter e(Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f146997d.indexOf(factory) + 1;
        int size = this.f146997d.size();
        for (int i3 = iIndexOf; i3 < size; i3++) {
            Converter converterC = ((Converter.Factory) this.f146997d.get(i3)).c(type, annotationArr, annotationArr2, this);
            if (converterC != null) {
                return converterC;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i4 = 0; i4 < iIndexOf; i4++) {
                sb.append("\n   * ");
                sb.append(((Converter.Factory) this.f146997d.get(i4)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f146997d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((Converter.Factory) this.f146997d.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public Converter f(Converter.Factory factory, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f146997d.indexOf(factory) + 1;
        int size = this.f146997d.size();
        for (int i3 = iIndexOf; i3 < size; i3++) {
            Converter converterD = ((Converter.Factory) this.f146997d.get(i3)).d(type, annotationArr, this);
            if (converterD != null) {
                return converterD;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (factory != null) {
            sb.append("  Skipped:");
            for (int i4 = 0; i4 < iIndexOf; i4++) {
                sb.append("\n   * ");
                sb.append(((Converter.Factory) this.f146997d.get(i4)).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f146997d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((Converter.Factory) this.f146997d.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public Converter g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public Converter h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public Converter i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f146997d.size();
        for (int i3 = 0; i3 < size; i3++) {
            Converter converterE = ((Converter.Factory) this.f146997d.get(i3)).e(type, annotationArr, this);
            if (converterE != null) {
                return converterE;
            }
        }
        return BuiltInConverters.ToStringConverter.f146825a;
    }
}
