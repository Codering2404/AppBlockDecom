package kotlin;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
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
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f139808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f139809b;

    public UnsafeLazyImpl(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f139808a = initializer;
        this.f139809b = UNINITIALIZED_VALUE.f139801a;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        if (this.f139809b == UNINITIALIZED_VALUE.f139801a) {
            Function0 function0 = this.f139808a;
            Intrinsics.checkNotNull(function0);
            this.f139809b = function0.invoke();
            this.f139808a = null;
        }
        return this.f139809b;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f139809b != UNINITIALIZED_VALUE.f139801a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
