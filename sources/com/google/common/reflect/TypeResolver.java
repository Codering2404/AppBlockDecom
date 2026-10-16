package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class TypeResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeTable f85551a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TypeMappingIntrospector extends TypeVisitor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f85554b = Maps.A();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap g(Type type) {
            Preconditions.t(type);
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.a(type);
            return ImmutableMap.e(typeMappingIntrospector.f85554b);
        }

        private void h(TypeVariableKey typeVariableKey, Type type) {
            if (this.f85554b.containsKey(typeVariableKey)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (typeVariableKey.a(type2)) {
                    while (type != null) {
                        type = (Type) this.f85554b.remove(TypeVariableKey.c(type));
                    }
                    return;
                }
                type2 = (Type) this.f85554b.get(TypeVariableKey.c(type2));
            }
            this.f85554b.put(typeVariableKey, type);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void b(Class cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.z(typeParameters.length == actualTypeArguments.length);
            for (int i3 = 0; i3 < typeParameters.length; i3++) {
                h(new TypeVariableKey(typeParameters[i3]), actualTypeArguments[i3]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void e(TypeVariable typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TypeVariableKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeVariable f85559a;

        TypeVariableKey(TypeVariable typeVariable) {
            this.f85559a = (TypeVariable) Preconditions.t(typeVariable);
        }

        private boolean b(TypeVariable typeVariable) {
            return this.f85559a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f85559a.getName().equals(typeVariable.getName());
        }

        static TypeVariableKey c(Type type) {
            if (type instanceof TypeVariable) {
                return new TypeVariableKey((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof TypeVariableKey) {
                return b(((TypeVariableKey) obj).f85559a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f85559a.getGenericDeclaration(), this.f85559a.getName());
        }

        public String toString() {
            return this.f85559a.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WildcardCapturer {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final WildcardCapturer f85560b = new WildcardCapturer();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f85561a;

        private Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private WildcardCapturer d(final TypeVariable typeVariable) {
            return new WildcardCapturer(this, this.f85561a) { // from class: com.google.common.reflect.TypeResolver.WildcardCapturer.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ WildcardCapturer f85563d;

                {
                    this.f85563d = this;
                }

                @Override // com.google.common.reflect.TypeResolver.WildcardCapturer
                TypeVariable b(Type[] typeArr) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private WildcardCapturer e() {
            return new WildcardCapturer(this.f85561a);
        }

        final Type a(Type type) {
            Preconditions.t(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                actualTypeArguments[i3] = d(typeParameters[i3]).a(actualTypeArguments[i3]);
            }
            return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        TypeVariable b(Type[] typeArr) {
            return Types.k(WildcardCapturer.class, "capture#" + this.f85561a.incrementAndGet() + "-of ? extends " + Joiner.h('&').g(typeArr), typeArr);
        }

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger atomicInteger) {
            this.f85561a = atomicInteger;
        }
    }

    static TypeResolver d(Type type) {
        return new TypeResolver().n(TypeMappingIntrospector.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object e(Class cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    static TypeResolver f(Type type) {
        return new TypeResolver().n(TypeMappingIntrospector.g(WildcardCapturer.f85560b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Map map, Type type, final Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new TypeVisitor() { // from class: com.google.common.reflect.TypeResolver.1
            @Override // com.google.common.reflect.TypeVisitor
            void b(Class cls) {
                if (type2 instanceof WildcardType) {
                    return;
                }
                throw new IllegalArgumentException("No type mapping from " + cls + " to " + type2);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                Type type3 = type2;
                if (type3 instanceof WildcardType) {
                    return;
                }
                Type typeI = Types.i(type3);
                Preconditions.m(typeI != null, "%s is not an array type.", type2);
                TypeResolver.g(map, genericArrayType.getGenericComponentType(), typeI);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void d(ParameterizedType parameterizedType) {
                Type type3 = type2;
                if (type3 instanceof WildcardType) {
                    return;
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeResolver.e(ParameterizedType.class, type3);
                if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                    TypeResolver.g(map, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                Preconditions.o(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Preconditions.o(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                    TypeResolver.g(map, actualTypeArguments[i3], actualTypeArguments2[i3]);
                }
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable typeVariable) {
                map.put(new TypeVariableKey(typeVariable), type2);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                Type type3 = type2;
                if (type3 instanceof WildcardType) {
                    WildcardType wildcardType2 = (WildcardType) type3;
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Type[] upperBounds2 = wildcardType2.getUpperBounds();
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                    Preconditions.o(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, type2);
                    for (int i3 = 0; i3 < upperBounds.length; i3++) {
                        TypeResolver.g(map, upperBounds[i3], upperBounds2[i3]);
                    }
                    for (int i4 = 0; i4 < lowerBounds.length; i4++) {
                        TypeResolver.g(map, lowerBounds[i4], lowerBounds2[i4]);
                    }
                }
            }
        }.a(type);
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i3 = 0; i3 < typeArr.length; i3++) {
            typeArr2[i3] = j(typeArr[i3]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        Preconditions.t(type);
        return type instanceof TypeVariable ? this.f85551a.a((TypeVariable) type) : type instanceof ParameterizedType ? i((ParameterizedType) type) : type instanceof GenericArrayType ? h((GenericArrayType) type) : type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    Type[] l(Type[] typeArr) {
        for (int i3 = 0; i3 < typeArr.length; i3++) {
            typeArr[i3] = j(typeArr[i3]);
        }
        return typeArr;
    }

    TypeResolver n(Map map) {
        return new TypeResolver(this.f85551a.c(map));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TypeTable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap f85555a;

        TypeTable() {
            this.f85555a = ImmutableMap.n();
        }

        final Type a(final TypeVariable typeVariable) {
            return b(typeVariable, new TypeTable(this) { // from class: com.google.common.reflect.TypeResolver.TypeTable.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ TypeTable f85558d;

                {
                    this.f85558d = this;
                }

                @Override // com.google.common.reflect.TypeResolver.TypeTable
                public Type b(TypeVariable typeVariable2, TypeTable typeTable) {
                    return typeVariable2.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable2 : this.b(typeVariable2, typeTable);
                }
            });
        }

        Type b(TypeVariable typeVariable, TypeTable typeTable) {
            Type type = (Type) this.f85555a.get(new TypeVariableKey(typeVariable));
            if (type != null) {
                return new TypeResolver(typeTable).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 0) {
                Type[] typeArrK = new TypeResolver(typeTable).k(bounds);
                if (!Types.NativeTypeVariableEquals.f85602a || !Arrays.equals(bounds, typeArrK)) {
                    return Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrK);
                }
            }
            return typeVariable;
        }

        final TypeTable c(Map map) {
            ImmutableMap.Builder builderA = ImmutableMap.a();
            builderA.j(this.f85555a);
            for (Map.Entry entry : map.entrySet()) {
                TypeVariableKey typeVariableKey = (TypeVariableKey) entry.getKey();
                Type type = (Type) entry.getValue();
                Preconditions.m(!typeVariableKey.a(type), "Type variable %s bound to itself", typeVariableKey);
                builderA.g(typeVariableKey, type);
            }
            return new TypeTable(builderA.d());
        }

        private TypeTable(ImmutableMap immutableMap) {
            this.f85555a = immutableMap;
        }
    }

    public TypeResolver() {
        this.f85551a = new TypeTable();
    }

    private TypeResolver(TypeTable typeTable) {
        this.f85551a = typeTable;
    }
}
