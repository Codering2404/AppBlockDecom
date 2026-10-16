package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class Reflection {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Android24 extends Reflection {
        Android24() {
        }

        @Override // retrofit2.Reflection
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            return DefaultMethodSupport.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean c(Method method) {
            return method.isDefault();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Java8 extends Reflection {
        Java8() {
        }

        @Override // retrofit2.Reflection
        String a(Method method, int i3) {
            Parameter parameter = method.getParameters()[i3];
            if (!parameter.isNamePresent()) {
                return super.a(method, i3);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        @Override // retrofit2.Reflection
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            return DefaultMethodSupport.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean c(Method method) {
            return method.isDefault();
        }
    }

    Reflection() {
    }

    String a(Method method, int i3) {
        return "parameter #" + (i3 + 1);
    }

    Object b(Method method, Class cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    boolean c(Method method) {
        return false;
    }
}
