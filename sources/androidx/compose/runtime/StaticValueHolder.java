package androidx.compose.runtime;

import kotlin.Metadata;
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
public final class StaticValueHolder<T> implements ValueHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24305a;

    public StaticValueHolder(Object obj) {
        this.f24305a = obj;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public ProvidedValue a(CompositionLocal compositionLocal) {
        Object obj = this.f24305a;
        return new ProvidedValue(compositionLocal, obj, obj == null, null, null, null, false);
    }

    @Override // androidx.compose.runtime.ValueHolder
    public Object b(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return this.f24305a;
    }

    public final Object c() {
        return this.f24305a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StaticValueHolder) && Intrinsics.areEqual(this.f24305a, ((StaticValueHolder) obj).f24305a);
    }

    public int hashCode() {
        Object obj = this.f24305a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.f24305a + ')';
    }
}
