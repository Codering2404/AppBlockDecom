package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f139780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f139781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f139782c;

    public SynchronizedLazyImpl(Function0 initializer, Object obj) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f139780a = initializer;
        this.f139781b = UNINITIALIZED_VALUE.f139801a;
        this.f139782c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        Object objInvoke;
        Object obj = this.f139781b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f139801a;
        if (obj != uninitialized_value) {
            return obj;
        }
        synchronized (this.f139782c) {
            objInvoke = this.f139781b;
            if (objInvoke == uninitialized_value) {
                Function0 function0 = this.f139780a;
                Intrinsics.checkNotNull(function0);
                objInvoke = function0.invoke();
                this.f139781b = objInvoke;
                this.f139780a = null;
            }
        }
        return objInvoke;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f139781b != UNINITIALIZED_VALUE.f139801a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i3 & 2) != 0 ? null : obj);
    }
}
