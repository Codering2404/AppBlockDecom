package kotlin.jvm.internal;

import java.util.Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Reflection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ReflectionFactory f140146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final KClass[] f140147b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f140146a = reflectionFactory;
        f140147b = new KClass[0];
    }

    public static KFunction a(FunctionReference functionReference) {
        return f140146a.a(functionReference);
    }

    public static KClass b(Class cls) {
        return f140146a.b(cls);
    }

    public static KDeclarationContainer c(Class cls) {
        return f140146a.c(cls, "");
    }

    public static KMutableProperty0 d(MutablePropertyReference0 mutablePropertyReference0) {
        return f140146a.d(mutablePropertyReference0);
    }

    public static KMutableProperty1 e(MutablePropertyReference1 mutablePropertyReference1) {
        return f140146a.e(mutablePropertyReference1);
    }

    public static KMutableProperty2 f(MutablePropertyReference2 mutablePropertyReference2) {
        return f140146a.f(mutablePropertyReference2);
    }

    public static KType g(Class cls) {
        return f140146a.l(b(cls), Collections.EMPTY_LIST, true);
    }

    public static KProperty0 h(PropertyReference0 propertyReference0) {
        return f140146a.g(propertyReference0);
    }

    public static KProperty1 i(PropertyReference1 propertyReference1) {
        return f140146a.h(propertyReference1);
    }

    public static KProperty2 j(PropertyReference2 propertyReference2) {
        return f140146a.i(propertyReference2);
    }

    public static String k(FunctionBase functionBase) {
        return f140146a.j(functionBase);
    }

    public static String l(Lambda lambda) {
        return f140146a.k(lambda);
    }
}
