package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class TypesJVMKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140282a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.f140267b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f140266a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f140268c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f140282a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(KType kType, boolean z2) {
        KClassifier kClassifierD = kType.d();
        if (kClassifierD instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) kClassifierD);
        }
        if (!(kClassifierD instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) kClassifierD;
        Class clsB = z2 ? JvmClassMappingKt.b(kClass) : JvmClassMappingKt.a(kClass);
        List listP = kType.p();
        if (listP.isEmpty()) {
            return clsB;
        }
        if (!clsB.isArray()) {
            return e(clsB, listP);
        }
        if (clsB.getComponentType().isPrimitive()) {
            return clsB;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull(listP);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        KVariance kVarianceA = kTypeProjection.a();
        KType kTypeB = kTypeProjection.b();
        int i3 = kVarianceA == null ? -1 : WhenMappings.f140282a[kVarianceA.ordinal()];
        if (i3 == -1 || i3 == 1) {
            return clsB;
        }
        if (i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(kTypeB);
        Type typeD = d(kTypeB, false, 1, null);
        return typeD instanceof Class ? clsB : new GenericArrayTypeImpl(typeD);
    }

    static /* synthetic */ Type d(KType kType, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return c(kType, z2);
    }

    private static final Type e(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(f((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(f((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(f((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeE, arrayList3);
    }

    private static final Type f(KTypeProjection kTypeProjection) {
        KVariance kVarianceD = kTypeProjection.d();
        if (kVarianceD == null) {
            return WildcardTypeImpl.f140284c.a();
        }
        KType kTypeC = kTypeProjection.c();
        Intrinsics.checkNotNull(kTypeC);
        int i3 = WhenMappings.f140282a[kVarianceD.ordinal()];
        if (i3 == 1) {
            return new WildcardTypeImpl(null, c(kTypeC, true));
        }
        if (i3 == 2) {
            return c(kTypeC, true);
        }
        if (i3 == 3) {
            return new WildcardTypeImpl(c(kTypeC, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        Sequence sequenceH = SequencesKt.h(type, TypesJVMKt$typeToString$unwrap$1.f140283a);
        return ((Class) SequencesKt.L(sequenceH)).getName() + StringsKt.K("[]", SequencesKt.s(sequenceH));
    }
}
