package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@JvmInline
public final class Result<T> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f139772b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f139773a;

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
    public static final class Failure implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f139774a;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.f139774a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual(this.f139774a, ((Failure) obj).f139774a);
        }

        public int hashCode() {
            return this.f139774a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f139774a + ')';
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.f139773a = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f139774a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof Failure);
    }

    public static String i(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f139773a, obj);
    }

    public int hashCode() {
        return f(this.f139773a);
    }

    public final /* synthetic */ Object j() {
        return this.f139773a;
    }

    public String toString() {
        return i(this.f139773a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
