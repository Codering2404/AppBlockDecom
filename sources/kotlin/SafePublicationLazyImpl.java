package kotlin;

import androidx.concurrent.futures.a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f139775d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f139776f = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Function0 f139777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f139778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f139779c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SafePublicationLazyImpl(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f139777a = initializer;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f139801a;
        this.f139778b = uninitialized_value;
        this.f139779c = uninitialized_value;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        Object obj = this.f139778b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f139801a;
        if (obj != uninitialized_value) {
            return obj;
        }
        Function0 function0 = this.f139777a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (a.a(f139776f, this, uninitialized_value, objInvoke)) {
                this.f139777a = null;
                return objInvoke;
            }
        }
        return this.f139778b;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f139778b != UNINITIALIZED_VALUE.f139801a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
