package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Invokable;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f85564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient TypeResolver f85565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient TypeResolver f85566c;

    /* JADX INFO: renamed from: com.google.common.reflect.TypeToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Invokable.MethodInvokable<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TypeToken f85567d;

        @Override // com.google.common.reflect.Invokable
        public TypeToken a() {
            return this.f85567d;
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            return a() + "." + super.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.TypeToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends Invokable.ConstructorInvokable<Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TypeToken f85568f;

        @Override // com.google.common.reflect.Invokable
        public TypeToken a() {
            return this.f85568f;
        }

        @Override // com.google.common.reflect.Invokable.ConstructorInvokable
        Type[] c() {
            return this.f85568f.j().l(super.c());
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            return a() + "(" + Joiner.i(", ").g(c()) + ")";
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.TypeToken$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends TypeVisitor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TypeToken f85569b;

        @Override // com.google.common.reflect.TypeVisitor
        void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void e(TypeVariable typeVariable) {
            throw new IllegalArgumentException(this.f85569b.f85564a + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.TypeVisitor
        void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Bounds {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient ImmutableSet f85572c;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.m().o2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            ImmutableSet immutableSet = this.f85572c;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet immutableSetN = FluentIterable.g(TypeCollector.f85577a.a().d(TypeToken.this)).d(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).n();
            this.f85572c = immutableSetN;
            return immutableSetN;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet r2() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set z2() {
            return ImmutableSet.u(TypeCollector.f85578b.a().c(TypeToken.this.l()));
        }

        /* synthetic */ ClassSet(TypeToken typeToken, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet o2() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class TypeCollector<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final TypeCollector f85577a = new TypeCollector<TypeToken<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable e(TypeToken typeToken) {
                return typeToken.h();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class f(TypeToken typeToken) {
                return typeToken.k();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken g(TypeToken typeToken) {
                return typeToken.i();
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final TypeCollector f85578b = new TypeCollector<Class<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable e(Class cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class g(Class cls) {
                return cls.getSuperclass();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class f(Class cls) {
                return cls;
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final TypeCollector f85582c;

            ForwardingTypeCollector(TypeCollector typeCollector) {
                super(null);
                this.f85582c = typeCollector;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Iterable e(Object obj) {
                return this.f85582c.e(obj);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Class f(Object obj) {
                return this.f85582c.f(obj);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Object g(Object obj) {
                return this.f85582c.g(obj);
            }
        }

        private TypeCollector() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int b(Object obj, Map map) {
            Integer num = (Integer) map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(obj).isInterface();
            Iterator<T> it = e(obj).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            Object objG = g(obj);
            int iMax2 = iMax;
            if (objG != null) {
                iMax2 = Math.max(iMax, b(objG, map));
            }
            int i3 = iMax2 + 1;
            map.put(obj, Integer.valueOf(i3));
            return i3;
        }

        private static ImmutableList h(final Map map, final Comparator comparator) {
            return new Ordering<Object>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.Ordering, java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    Comparator comparator2 = comparator;
                    Object obj3 = map.get(obj);
                    Objects.requireNonNull(obj3);
                    Object obj4 = map.get(obj2);
                    Objects.requireNonNull(obj4);
                    return comparator2.compare(obj3, obj4);
                }
            }.c(map.keySet());
        }

        final TypeCollector a() {
            return new ForwardingTypeCollector<K>(this) { // from class: com.google.common.reflect.TypeToken.TypeCollector.3
                @Override // com.google.common.reflect.TypeToken.TypeCollector
                ImmutableList c(Iterable iterable) {
                    ImmutableList.Builder builderO = ImmutableList.o();
                    for (T t2 : iterable) {
                        if (!f(t2).isInterface()) {
                            builderO.a(t2);
                        }
                    }
                    return super.c(builderO.m());
                }

                @Override // com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector, com.google.common.reflect.TypeToken.TypeCollector
                Iterable e(Object obj) {
                    return ImmutableSet.z();
                }
            };
        }

        ImmutableList c(Iterable iterable) {
            HashMap mapA = Maps.A();
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapA);
            }
            return h(mapA, Ordering.f().k());
        }

        final ImmutableList d(Object obj) {
            return c(ImmutableList.z(obj));
        }

        abstract Iterable e(Object obj);

        abstract Class f(Object obj);

        abstract Object g(Object obj);

        /* synthetic */ TypeCollector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(TypeToken typeToken) {
                return ((typeToken.f85564a instanceof TypeVariable) || (typeToken.f85564a instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(TypeToken typeToken) {
                return typeToken.k().isInterface();
            }
        };

        /* synthetic */ TypeFilter(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient ImmutableSet f85586a;

        TypeSet() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            ImmutableSet immutableSet = this.f85586a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet immutableSetN = FluentIterable.g(TypeCollector.f85577a.d(TypeToken.this)).d(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).n();
            this.f85586a = immutableSetN;
            return immutableSetN;
        }

        public TypeSet o2() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeSet r2() {
            return new InterfaceSet(this);
        }

        public Set z2() {
            return ImmutableSet.u(TypeCollector.f85578b.c(TypeToken.this.l()));
        }
    }

    /* synthetic */ TypeToken(Type type, AnonymousClass1 anonymousClass1) {
        this(type);
    }

    private TypeToken e(Type type) {
        TypeToken typeTokenO = o(type);
        if (typeTokenO.k().isInterface()) {
            return null;
        }
        return typeTokenO;
    }

    private ImmutableList f(Type[] typeArr) {
        ImmutableList.Builder builderO = ImmutableList.o();
        for (Type type : typeArr) {
            TypeToken typeTokenO = o(type);
            if (typeTokenO.k().isInterface()) {
                builderO.a(typeTokenO);
            }
        }
        return builderO.m();
    }

    private TypeResolver g() {
        TypeResolver typeResolver = this.f85566c;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver typeResolverD = TypeResolver.d(this.f85564a);
        this.f85566c = typeResolverD;
        return typeResolverD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeResolver j() {
        TypeResolver typeResolver = this.f85565b;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver typeResolverF = TypeResolver.f(this.f85564a);
        this.f85565b = typeResolverF;
        return typeResolverF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet l() {
        final ImmutableSet.Builder builderO = ImmutableSet.o();
        new TypeVisitor(this) { // from class: com.google.common.reflect.TypeToken.4

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TypeToken f85571c;

            {
                this.f85571c = this;
            }

            @Override // com.google.common.reflect.TypeVisitor
            void b(Class cls) {
                builderO.e(cls);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                builderO.e(Types.h(TypeToken.o(genericArrayType.getGenericComponentType()).k()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void d(ParameterizedType parameterizedType) {
                builderO.e((Class) parameterizedType.getRawType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable typeVariable) {
                a(typeVariable.getBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }
        }.a(this.f85564a);
        return builderO.n();
    }

    public static TypeToken n(Class cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken o(Type type) {
        return new SimpleTypeToken(type);
    }

    private TypeToken p(Type type) {
        TypeToken typeTokenO = o(g().j(type));
        typeTokenO.f85566c = this.f85566c;
        typeTokenO.f85565b = this.f85565b;
        return typeTokenO;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.f85564a.equals(((TypeToken) obj).f85564a);
        }
        return false;
    }

    final ImmutableList h() {
        Type type = this.f85564a;
        if (type instanceof TypeVariable) {
            return f(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return f(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Builder builderO = ImmutableList.o();
        for (Type type2 : k().getGenericInterfaces()) {
            builderO.a(p(type2));
        }
        return builderO.m();
    }

    public int hashCode() {
        return this.f85564a.hashCode();
    }

    final TypeToken i() {
        Type type = this.f85564a;
        if (type instanceof TypeVariable) {
            return e(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return e(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = k().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return p(genericSuperclass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class k() {
        return (Class) l().iterator().next();
    }

    public final TypeSet m() {
        return new TypeSet();
    }

    public String toString() {
        return Types.s(this.f85564a);
    }

    protected Object writeReplace() {
        return o(new TypeResolver().j(this.f85564a));
    }

    private TypeToken(Type type) {
        this.f85564a = (Type) Preconditions.t(type);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient TypeSet f85574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private transient ImmutableSet f85575d;

        InterfaceSet(TypeSet typeSet) {
            super();
            this.f85574c = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.m().r2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            ImmutableSet immutableSet = this.f85575d;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet immutableSetN = FluentIterable.g(this.f85574c).d(TypeFilter.INTERFACE_ONLY).n();
            this.f85575d = immutableSetN;
            return immutableSetN;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet o2() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set z2() {
            return FluentIterable.g(TypeCollector.f85578b.c(TypeToken.this.l())).d(new Predicate() { // from class: com.google.common.reflect.b
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).n();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet r2() {
            return this;
        }
    }
}
