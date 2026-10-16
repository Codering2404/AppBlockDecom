package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ComputedValueHolder<T> implements ValueHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f23849a;

    public ComputedValueHolder(Function1 function1) {
        this.f23849a = function1;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public ProvidedValue a(CompositionLocal compositionLocal) {
        return new ProvidedValue(compositionLocal, null, false, null, null, this.f23849a, false);
    }

    @Override // androidx.compose.runtime.ValueHolder
    public Object b(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return this.f23849a.invoke(persistentCompositionLocalMap);
    }

    public final Function1 c() {
        return this.f23849a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ComputedValueHolder) && Intrinsics.areEqual(this.f23849a, ((ComputedValueHolder) obj).f23849a);
    }

    public int hashCode() {
        return this.f23849a.hashCode();
    }

    public String toString() {
        return "ComputedValueHolder(compute=" + this.f23849a + ')';
    }
}
