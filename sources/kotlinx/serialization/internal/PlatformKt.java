package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PlatformKt {
    private static final Object a(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final KSerializer b(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return d(kClass, new KSerializer[0]);
    }

    public static final KSerializer c(Class cls, KSerializer... args) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        if (cls.isEnum() && m(cls)) {
            return e(cls);
        }
        KSerializer kSerializerK = k(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerK != null) {
            return kSerializerK;
        }
        KSerializer kSerializerH = h(cls);
        if (kSerializerH != null) {
            return kSerializerH;
        }
        KSerializer kSerializerF = f(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerF != null) {
            return kSerializerF;
        }
        if (n(cls)) {
            return new PolymorphicSerializer(JvmClassMappingKt.c(cls));
        }
        return null;
    }

    public static final KSerializer d(KClass kClass, KSerializer... args) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return c(JvmClassMappingKt.a(kClass), (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    private static final KSerializer e(Class cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    private static final KSerializer f(Class cls, KSerializer... kSerializerArr) {
        Field field;
        KSerializer kSerializerJ;
        Object objG = g(cls);
        if (objG != null && (kSerializerJ = j(objG, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length))) != null) {
            return kSerializerJ;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i3 = 0;
            Class<?> cls2 = null;
            boolean z2 = false;
            while (true) {
                if (i3 < length) {
                    Class<?> cls3 = declaredClasses[i3];
                    if (Intrinsics.areEqual(cls3.getSimpleName(), "$serializer")) {
                        if (z2) {
                            break;
                        }
                        z2 = true;
                        cls2 = cls3;
                    }
                    i3++;
                } else if (!z2) {
                }
            }
            cls2 = null;
            Object obj = (cls2 == null || (field = cls2.getField("INSTANCE")) == null) ? null : field.get(null);
            if (obj instanceof KSerializer) {
                return (KSerializer) obj;
            }
        } catch (NoSuchFieldException unused) {
        }
        return null;
    }

    private static final Object g(Class cls) {
        Class<?> cls2;
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        int length = declaredClasses.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                cls2 = null;
                break;
            }
            cls2 = declaredClasses[i3];
            if (cls2.getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i3++;
        }
        if (cls2 == null) {
            return null;
        }
        String simpleName = cls2.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return a(cls, simpleName);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlinx.serialization.KSerializer h(java.lang.Class r11) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto Lae
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = kotlin.text.StringsKt.U(r0, r2, r3, r4, r1)
            if (r2 != 0) goto Lae
            java.lang.String r2 = "kotlin."
            boolean r0 = kotlin.text.StringsKt.U(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L1b
            goto Lae
        L1b:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L28:
            r7 = 1
            if (r4 >= r2) goto L56
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto L53
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r11)
            if (r9 == 0) goto L53
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L53
            if (r5 == 0) goto L51
        L4f:
            r6 = r1
            goto L59
        L51:
            r5 = r7
            r6 = r8
        L53:
            int r4 = r4 + 1
            goto L28
        L56:
            if (r5 != 0) goto L59
            goto L4f
        L59:
            if (r6 != 0) goto L5c
            return r1
        L5c:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = r3
        L6c:
            if (r3 >= r2) goto L9d
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L9a
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L9a
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r9 = kotlinx.serialization.KSerializer.class
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L9a
            if (r4 == 0) goto L98
        L96:
            r5 = r1
            goto La0
        L98:
            r5 = r6
            r4 = r7
        L9a:
            int r3 = r3 + 1
            goto L6c
        L9d:
            if (r4 != 0) goto La0
            goto L96
        La0:
            if (r5 != 0) goto La3
            return r1
        La3:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto Lae
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            return r11
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.h(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final Map i() {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put(Reflection.b(String.class), BuiltinSerializersKt.I(StringCompanionObject.f140150a));
        mapCreateMapBuilder.put(Reflection.b(Character.TYPE), BuiltinSerializersKt.C(CharCompanionObject.f140123a));
        mapCreateMapBuilder.put(Reflection.b(char[].class), BuiltinSerializersKt.d());
        mapCreateMapBuilder.put(Reflection.b(Double.TYPE), BuiltinSerializersKt.D(DoubleCompanionObject.f140128a));
        mapCreateMapBuilder.put(Reflection.b(double[].class), BuiltinSerializersKt.e());
        mapCreateMapBuilder.put(Reflection.b(Float.TYPE), BuiltinSerializersKt.E(FloatCompanionObject.f140130a));
        mapCreateMapBuilder.put(Reflection.b(float[].class), BuiltinSerializersKt.f());
        mapCreateMapBuilder.put(Reflection.b(Long.TYPE), BuiltinSerializersKt.G(LongCompanionObject.f140133a));
        mapCreateMapBuilder.put(Reflection.b(long[].class), BuiltinSerializersKt.i());
        mapCreateMapBuilder.put(Reflection.b(ULong.class), BuiltinSerializersKt.x(ULong.f139796b));
        mapCreateMapBuilder.put(Reflection.b(Integer.TYPE), BuiltinSerializersKt.F(IntCompanionObject.f140132a));
        mapCreateMapBuilder.put(Reflection.b(int[].class), BuiltinSerializersKt.g());
        mapCreateMapBuilder.put(Reflection.b(UInt.class), BuiltinSerializersKt.w(UInt.f139791b));
        mapCreateMapBuilder.put(Reflection.b(Short.TYPE), BuiltinSerializersKt.H(ShortCompanionObject.f140148a));
        mapCreateMapBuilder.put(Reflection.b(short[].class), BuiltinSerializersKt.o());
        mapCreateMapBuilder.put(Reflection.b(UShort.class), BuiltinSerializersKt.y(UShort.f139802b));
        mapCreateMapBuilder.put(Reflection.b(Byte.TYPE), BuiltinSerializersKt.B(ByteCompanionObject.f140121a));
        mapCreateMapBuilder.put(Reflection.b(byte[].class), BuiltinSerializersKt.c());
        mapCreateMapBuilder.put(Reflection.b(UByte.class), BuiltinSerializersKt.v(UByte.f139786b));
        mapCreateMapBuilder.put(Reflection.b(Boolean.TYPE), BuiltinSerializersKt.A(BooleanCompanionObject.f140120a));
        mapCreateMapBuilder.put(Reflection.b(boolean[].class), BuiltinSerializersKt.b());
        mapCreateMapBuilder.put(Reflection.b(Unit.class), BuiltinSerializersKt.z(Unit.f139807a));
        mapCreateMapBuilder.put(Reflection.b(Void.class), BuiltinSerializersKt.l());
        try {
            mapCreateMapBuilder.put(Reflection.b(Duration.class), BuiltinSerializersKt.J(Duration.f140631b));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            mapCreateMapBuilder.put(Reflection.b(ULongArray.class), BuiltinSerializersKt.s());
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            mapCreateMapBuilder.put(Reflection.b(UIntArray.class), BuiltinSerializersKt.r());
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            mapCreateMapBuilder.put(Reflection.b(UShortArray.class), BuiltinSerializersKt.t());
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            mapCreateMapBuilder.put(Reflection.b(UByteArray.class), BuiltinSerializersKt.q());
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            mapCreateMapBuilder.put(Reflection.b(Uuid.class), BuiltinSerializersKt.K(Uuid.f140682c));
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final KSerializer j(Object obj, KSerializer... kSerializerArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i3 = 0; i3 < length; i3++) {
                    clsArr2[i3] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (objInvoke instanceof KSerializer) {
                return (KSerializer) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause == null) {
                throw e3;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e3.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    private static final KSerializer k(Class cls, KSerializer... kSerializerArr) {
        Object objA = a(cls, "Companion");
        if (objA == null) {
            return null;
        }
        return j(objA, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final boolean l(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return JvmClassMappingKt.a(kClass).isInterface();
    }

    private static final boolean m(Class cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final boolean n(Class cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && Intrinsics.areEqual(Reflection.b(serializable.with()), Reflection.b(PolymorphicSerializer.class));
    }

    public static final boolean o(KClass rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.a(rootClass).isArray();
    }

    public static final Void p(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.f(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Object[] q(ArrayList arrayList, KClass eClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) JvmClassMappingKt.a(eClass), arrayList.size());
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        return array;
    }
}
