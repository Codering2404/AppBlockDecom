package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Unit;
import okhttp3.ResponseBody;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f147013a = new Type[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f147014b = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class GenericArrayTypeImpl implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f147015a;

        GenericArrayTypeImpl(Type type) {
            this.f147015a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils.d(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f147015a;
        }

        public int hashCode() {
            return this.f147015a.hashCode();
        }

        public String toString() {
            return Utils.u(this.f147015a) + "[]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParameterizedTypeImpl implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f147016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f147017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type[] f147018c;

        ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                Utils.b(type3);
            }
            this.f147016a = type;
            this.f147017b = type2;
            this.f147018c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils.d(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f147018c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f147016a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f147017b;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.f147018c) ^ this.f147017b.hashCode();
            Type type = this.f147016a;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f147018c;
            if (typeArr.length == 0) {
                return Utils.u(this.f147017b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Utils.u(this.f147017b));
            sb.append("<");
            sb.append(Utils.u(this.f147018c[0]));
            for (int i3 = 1; i3 < this.f147018c.length; i3++) {
                sb.append(", ");
                sb.append(Utils.u(this.f147018c[i3]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class WildcardTypeImpl implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f147019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f147020b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                typeArr[0].getClass();
                Utils.b(typeArr[0]);
                this.f147020b = null;
                this.f147019a = typeArr[0];
                return;
            }
            typeArr2[0].getClass();
            Utils.b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f147020b = typeArr2[0];
            this.f147019a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils.d(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f147020b;
            return type != null ? new Type[]{type} : Utils.f147013a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f147019a};
        }

        public int hashCode() {
            Type type = this.f147020b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f147019a.hashCode() + 31);
        }

        public String toString() {
            if (this.f147020b != null) {
                return "? super " + Utils.u(this.f147020b);
            }
            if (this.f147019a == Object.class) {
                return "?";
            }
            return "? extends " + Utils.u(this.f147019a);
        }
    }

    static ResponseBody a(ResponseBody responseBody) {
        Buffer buffer = new Buffer();
        responseBody.k().w2(buffer);
        return ResponseBody.j(responseBody.i(), responseBody.f(), buffer);
    }

    static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    private static Class c(TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static boolean d(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return d(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    static Type e(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i3 = 0; i3 < length; i3++) {
                Class<?> cls3 = interfaces[i3];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i3];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return e(cls.getGenericInterfaces()[i3], interfaces[i3], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static Type f(int i3, ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[i3];
        return type instanceof WildcardType ? ((WildcardType) type).getLowerBounds()[0] : type;
    }

    static Type g(int i3, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i3 >= 0 && i3 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i3];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i3 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    static Class h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    static Type i(Type type, Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return r(type, cls, e(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static boolean j(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    private static int k(Object[] objArr, Object obj) {
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (obj.equals(objArr[i3])) {
                return i3;
            }
        }
        throw new NoSuchElementException();
    }

    static boolean l(Annotation[] annotationArr, Class cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    static boolean m(Type type) {
        return f147014b && type == Unit.class;
    }

    static RuntimeException n(Method method, String str, Object... objArr) {
        return o(method, null, str, objArr);
    }

    static RuntimeException o(Method method, Throwable th, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), th);
    }

    static RuntimeException p(Method method, int i3, String str, Object... objArr) {
        return n(method, str + " (" + Platform.f146936b.a(method, i3) + ")", objArr);
    }

    static RuntimeException q(Method method, Throwable th, int i3, String str, Object... objArr) {
        return o(method, th, str + " (" + Platform.f146936b.a(method, i3) + ")", objArr);
    }

    static Type r(Type type, Class cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type typeS = s(type, cls, typeVariable);
            if (typeS == typeVariable) {
                return typeS;
            }
            type3 = typeS;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeR = r(type, cls, componentType);
                return componentType == typeR ? cls2 : new GenericArrayTypeImpl(typeR);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeR2 = r(type, cls, genericComponentType);
            return genericComponentType == typeR2 ? genericArrayType : new GenericArrayTypeImpl(typeR2);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeR3 = r(type, cls, ownerType);
            boolean z2 = typeR3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i3 = 0; i3 < length; i3++) {
                Type typeR4 = r(type, cls, actualTypeArguments[i3]);
                if (typeR4 != actualTypeArguments[i3]) {
                    if (!z2) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z2 = true;
                    }
                    actualTypeArguments[i3] = typeR4;
                }
            }
            return z2 ? new ParameterizedTypeImpl(typeR3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z3 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z3) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeR5 = r(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (typeR5 != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{typeR5});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type typeR6 = r(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (typeR6 != upperBounds[0]) {
                        return new WildcardTypeImpl(new Type[]{typeR6}, f147013a);
                    }
                }
            }
        }
        return type4;
    }

    private static Type s(Type type, Class cls, TypeVariable typeVariable) {
        Class clsC = c(typeVariable);
        if (clsC != null) {
            Type typeE = e(type, cls, clsC);
            if (typeE instanceof ParameterizedType) {
                return ((ParameterizedType) typeE).getActualTypeArguments()[k(clsC.getTypeParameters(), typeVariable)];
            }
        }
        return typeVariable;
    }

    static void t(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    static String u(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
