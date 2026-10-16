package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KTypeParameter;
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
public final class TypeParameterReference implements KTypeParameter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f140151f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f140152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f140153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KVariance f140154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile List f140155d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f140156a;

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
                f140156a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i3 = WhenMappings.f140156a[typeParameter.b().ordinal()];
            if (i3 == 1) {
                Unit unit = Unit.f139807a;
            } else if (i3 == 2) {
                sb.append("in ");
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            return sb.toString();
        }

        private Companion() {
        }
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance b() {
        return this.f140154c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeParameterReference)) {
            return false;
        }
        TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
        return Intrinsics.areEqual(this.f140152a, typeParameterReference.f140152a) && Intrinsics.areEqual(getName(), typeParameterReference.getName());
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.f140153b;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List getUpperBounds() {
        List list = this.f140155d;
        if (list != null) {
            return list;
        }
        List listListOf = CollectionsKt.listOf(Reflection.g(Object.class));
        this.f140155d = listListOf;
        return listListOf;
    }

    public int hashCode() {
        Object obj = this.f140152a;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    public String toString() {
        return f140151f.a(this);
    }
}
