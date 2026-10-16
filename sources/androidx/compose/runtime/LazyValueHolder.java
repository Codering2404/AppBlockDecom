package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class LazyValueHolder<T> implements ValueHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f23933a;

    public LazyValueHolder(Function0 function0) {
        this.f23933a = LazyKt.b(function0);
    }

    private final Object c() {
        return this.f23933a.getValue();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public ProvidedValue a(CompositionLocal compositionLocal) {
        ComposerKt.u("Cannot produce a provider from a lazy value holder");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public Object b(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return c();
    }
}
