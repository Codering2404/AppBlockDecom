package kotlin.jvm.internal;

import com.facebook.FacebookContentProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

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
public final class TypeReference implements KType {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140157f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClassifier f140158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f140159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KType f140160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f140161d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140162a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.f140266a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f140267b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f140268c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f140162a = iArr;
        }
    }

    public TypeReference(KClassifier classifier, List arguments, KType kType, int i3) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.f140158a = classifier;
        this.f140159b = arguments;
        this.f140160c = kType;
        this.f140161d = i3;
    }

    private final String f(KTypeProjection kTypeProjection) {
        String strValueOf;
        if (kTypeProjection.d() == null) {
            return "*";
        }
        KType kTypeC = kTypeProjection.c();
        TypeReference typeReference = kTypeC instanceof TypeReference ? (TypeReference) kTypeC : null;
        if (typeReference == null || (strValueOf = typeReference.g(true)) == null) {
            strValueOf = String.valueOf(kTypeProjection.c());
        }
        int i3 = WhenMappings.f140162a[kTypeProjection.d().ordinal()];
        if (i3 == 1) {
            return strValueOf;
        }
        if (i3 == 2) {
            return "in " + strValueOf;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }

    private final String g(boolean z2) {
        String name;
        KClassifier kClassifierD = d();
        KClass kClass = kClassifierD instanceof KClass ? (KClass) kClassifierD : null;
        Class clsA = kClass != null ? JvmClassMappingKt.a(kClass) : null;
        if (clsA == null) {
            name = d().toString();
        } else if ((this.f140161d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsA.isArray()) {
            name = j(clsA);
        } else if (z2 && clsA.isPrimitive()) {
            KClassifier kClassifierD2 = d();
            Intrinsics.checkNotNull(kClassifierD2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = JvmClassMappingKt.b((KClass) kClassifierD2).getName();
        } else {
            name = clsA.getName();
        }
        String str = name + (p().isEmpty() ? "" : CollectionsKt.joinToString$default(p(), ", ", "<", ">", 0, null, new Function1() { // from class: kotlin.jvm.internal.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TypeReference.i(this.f140163a, (KTypeProjection) obj);
            }
        }, 24, null)) + (c() ? "?" : "");
        KType kType = this.f140160c;
        if (!(kType instanceof TypeReference)) {
            return str;
        }
        String strG = ((TypeReference) kType).g(true);
        if (Intrinsics.areEqual(strG, str)) {
            return str;
        }
        if (Intrinsics.areEqual(strG, str + '?')) {
            return str + '!';
        }
        return '(' + str + FacebookContentProvider.INVALID_FILE_NAME + strG + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence i(TypeReference typeReference, KTypeProjection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return typeReference.f(it);
    }

    private final String j(Class cls) {
        return Intrinsics.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.areEqual(cls, char[].class) ? "kotlin.CharArray" : Intrinsics.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : Intrinsics.areEqual(cls, short[].class) ? "kotlin.ShortArray" : Intrinsics.areEqual(cls, int[].class) ? "kotlin.IntArray" : Intrinsics.areEqual(cls, float[].class) ? "kotlin.FloatArray" : Intrinsics.areEqual(cls, long[].class) ? "kotlin.LongArray" : Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @Override // kotlin.reflect.KType
    public boolean c() {
        return (this.f140161d & 1) != 0;
    }

    @Override // kotlin.reflect.KType
    public KClassifier d() {
        return this.f140158a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeReference)) {
            return false;
        }
        TypeReference typeReference = (TypeReference) obj;
        return Intrinsics.areEqual(d(), typeReference.d()) && Intrinsics.areEqual(p(), typeReference.p()) && Intrinsics.areEqual(this.f140160c, typeReference.f140160c) && this.f140161d == typeReference.f140161d;
    }

    public int hashCode() {
        return (((d().hashCode() * 31) + p().hashCode()) * 31) + Integer.hashCode(this.f140161d);
    }

    @Override // kotlin.reflect.KType
    public List p() {
        return this.f140159b;
    }

    public String toString() {
        return g(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(KClassifier classifier, List arguments, boolean z2) {
        this(classifier, arguments, null, z2 ? 1 : 0);
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
    }
}
