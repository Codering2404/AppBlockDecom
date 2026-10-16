package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Joiner f85589a = Joiner.i(", ").l("null");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            Class c(Class cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            Class c(Class cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };


        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final ClassOwnership f85593c = b();

        private static ClassOwnership b() {
            new C1LocalClass<String>() { // from class: com.google.common.reflect.Types.ClassOwnership.3
            };
            ParameterizedType parameterizedType = (ParameterizedType) AnonymousClass3.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.c(C1LocalClass.class) == parameterizedType2.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        abstract Class c(Class cls);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f85595a;

        GenericArrayTypeImpl(Type type) {
            this.f85595a = JavaVersion.f85600f.f(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.common.base.Objects.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f85595a;
        }

        public int hashCode() {
            return this.f85595a.hashCode();
        }

        public String toString() {
            return Types.s(this.f85595a) + "[]";
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.common.reflect.Types$JavaVersion, still in use, count: 1, list:
      (r0v0 com.google.common.reflect.Types$JavaVersion) from 0x0063: SPUT (r0v0 com.google.common.reflect.Types$JavaVersion) (LINE:100) com.google.common.reflect.Types.JavaVersion.f com.google.common.reflect.Types$JavaVersion
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            Type f(Type type) {
                Preconditions.t(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public GenericArrayType c(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                return type instanceof Class ? Types.h((Class) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type f(Type type) {
                return (Type) Preconditions.t(type);
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                return JavaVersion.JAVA7.c(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String d(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
                } catch (IllegalAccessException e3) {
                    e = e3;
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e4) {
                    e = e4;
                    throw new RuntimeException(e);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type f(Type type) {
                return JavaVersion.JAVA7.f(type);
            }
        },
        JAVA9 { // from class: com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.common.reflect.Types.JavaVersion
            boolean b() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                return JavaVersion.JAVA8.c(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String d(Type type) {
                return JavaVersion.JAVA8.d(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type f(Type type) {
                return JavaVersion.JAVA8.f(type);
            }
        };


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final JavaVersion f85600f;

        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new TypeCapture<Map.Entry<String, int[][]>>() { // from class: com.google.common.reflect.Types.JavaVersion.5
                }.a().toString().contains("java.util.Map.java.util.Map")) {
                    f85600f = javaVersion;
                    return;
                } else {
                    f85600f = javaVersion;
                    return;
                }
            }
            if (new TypeCapture<int[]>() { // from class: com.google.common.reflect.Types.JavaVersion.6
            }.a() instanceof Class) {
                f85600f = javaVersion;
            } else {
                f85600f = javaVersion;
            }
        }

        private JavaVersion() {
        }

        public static JavaVersion valueOf(String str) {
            return (JavaVersion) Enum.valueOf(JavaVersion.class, str);
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) f85601g.clone();
        }

        boolean b() {
            return true;
        }

        abstract Type c(Type type);

        String d(Type type) {
            return Types.s(type);
        }

        final ImmutableList e(Type[] typeArr) {
            ImmutableList.Builder builderO = ImmutableList.o();
            for (Type type : typeArr) {
                builderO.a(f(type));
            }
            return builderO.m();
        }

        abstract Type f(Type type);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NativeTypeVariableEquals<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final boolean f85602a = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.k(NativeTypeVariableEquals.class, "X", new Type[0]));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f85603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableList f85604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class f85605c;

        ParameterizedTypeImpl(Type type, Class cls, Type[] typeArr) {
            Preconditions.t(cls);
            Preconditions.d(typeArr.length == cls.getTypeParameters().length);
            Types.f(typeArr, "type parameter");
            this.f85603a = type;
            this.f85605c = cls;
            this.f85604b = JavaVersion.f85600f.e(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.common.base.Objects.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.r(this.f85604b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f85603a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f85605c;
        }

        public int hashCode() {
            Type type = this.f85603a;
            return ((type == null ? 0 : type.hashCode()) ^ this.f85604b.hashCode()) ^ this.f85605c.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f85603a != null) {
                JavaVersion javaVersion = JavaVersion.f85600f;
                if (javaVersion.b()) {
                    sb.append(javaVersion.d(this.f85603a));
                    sb.append('.');
                }
            }
            sb.append(this.f85605c.getName());
            sb.append('<');
            Joiner joiner = Types.f85589a;
            ImmutableList immutableList = this.f85604b;
            final JavaVersion javaVersion2 = JavaVersion.f85600f;
            Objects.requireNonNull(javaVersion2);
            sb.append(joiner.e(Iterables.y(immutableList, new Function() { // from class: com.google.common.reflect.c
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return javaVersion2.d((Type) obj);
                }
            })));
            sb.append('>');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TypeVariableImpl<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GenericDeclaration f85606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f85607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ImmutableList f85608c;

        TypeVariableImpl(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
            Types.f(typeArr, "bound for type variable");
            this.f85606a = (GenericDeclaration) Preconditions.t(genericDeclaration);
            this.f85607b = (String) Preconditions.t(str);
            this.f85608c = ImmutableList.v(typeArr);
        }

        public GenericDeclaration a() {
            return this.f85606a;
        }

        public String b() {
            return this.f85607b;
        }

        public boolean equals(Object obj) {
            if (!NativeTypeVariableEquals.f85602a) {
                if (obj instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) obj;
                    if (this.f85607b.equals(typeVariable.getName()) && this.f85606a.equals(typeVariable.getGenericDeclaration())) {
                        return true;
                    }
                }
                return false;
            }
            if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                TypeVariableImpl typeVariableImpl = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).f85610a;
                if (this.f85607b.equals(typeVariableImpl.b()) && this.f85606a.equals(typeVariableImpl.a()) && this.f85608c.equals(typeVariableImpl.f85608c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f85606a.hashCode() ^ this.f85607b.hashCode();
        }

        public String toString() {
            return this.f85607b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TypeVariableInvocationHandler implements InvocationHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ImmutableMap f85609b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeVariableImpl f85610a;

        static {
            ImmutableMap.Builder builderA = ImmutableMap.a();
            for (Method method : TypeVariableImpl.class.getMethods()) {
                if (method.getDeclaringClass().equals(TypeVariableImpl.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builderA.g(method.getName(), method);
                }
            }
            f85609b = builderA.c();
        }

        TypeVariableInvocationHandler(TypeVariableImpl typeVariableImpl) {
            this.f85610a = typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = (Method) f85609b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f85610a, objArr);
            } catch (InvocationTargetException e3) {
                throw e3.getCause();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f85611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableList f85612b;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.f(typeArr, "lower bound for wildcard");
            Types.f(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.f85600f;
            this.f85611a = javaVersion.e(typeArr);
            this.f85612b = javaVersion.e(typeArr2);
        }

        public boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                if (this.f85611a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.f85612b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.r(this.f85611a);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.r(this.f85612b);
        }

        public int hashCode() {
            return this.f85611a.hashCode() ^ this.f85612b.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableIterator it = this.f85611a.iterator();
            while (it.hasNext()) {
                Type type = (Type) it.next();
                sb.append(" super ");
                sb.append(JavaVersion.f85600f.d(type));
            }
            for (Type type2 : Types.g(this.f85612b)) {
                sb.append(" extends ");
                sb.append(JavaVersion.f85600f.d(type2));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Preconditions.o(!r2.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable g(Iterable iterable) {
        return Iterables.e(iterable, Predicates.j(Predicates.f(Object.class)));
    }

    static Class h(Class cls) {
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    static Type i(Type type) {
        Preconditions.t(type);
        final AtomicReference atomicReference = new AtomicReference();
        new TypeVisitor() { // from class: com.google.common.reflect.Types.1
            @Override // com.google.common.reflect.TypeVisitor
            void b(Class cls) {
                atomicReference.set(cls.getComponentType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable typeVariable) {
                atomicReference.set(Types.p(typeVariable.getBounds()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                atomicReference.set(Types.p(wildcardType.getUpperBounds()));
            }
        }.a(type);
        return (Type) atomicReference.get();
    }

    static Type j(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.f85600f.c(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        Preconditions.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    static TypeVariable k(GenericDeclaration genericDeclaration, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(genericDeclaration, str, typeArr);
    }

    static ParameterizedType l(Class cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.f85593c.c(cls), cls, typeArr);
    }

    static ParameterizedType m(Type type, Class cls, Type... typeArr) {
        if (type == null) {
            return l(cls, typeArr);
        }
        Preconditions.t(typeArr);
        Preconditions.m(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    private static TypeVariable n(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.a(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(genericDeclaration, str, typeArr)));
    }

    static WildcardType o(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type p(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeI = i(type);
            if (typeI != null) {
                if (typeI instanceof Class) {
                    Class cls = (Class) typeI;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(typeI);
            }
        }
        return null;
    }

    static WildcardType q(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] r(Collection collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
