package cz.mobilesoft.coreblock.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LazyMutable<T> implements ReadWriteProperty<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f127892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f127893b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UNINITIALIZED_VALUE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UNINITIALIZED_VALUE f127894a = new UNINITIALIZED_VALUE();

        private UNINITIALIZED_VALUE() {
        }
    }

    public LazyMutable(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.f127892a = initializer;
        this.f127893b = UNINITIALIZED_VALUE.f127894a;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object a(Object obj, KProperty property) {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(property, "property");
        Object obj2 = this.f127893b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f127894a;
        if (!Intrinsics.areEqual(obj2, uninitialized_value)) {
            return this.f127893b;
        }
        synchronized (this) {
            try {
                if (Intrinsics.areEqual(this.f127893b, uninitialized_value)) {
                    objInvoke = this.f127892a.invoke();
                    this.f127893b = objInvoke;
                } else {
                    objInvoke = this.f127893b;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objInvoke;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void b(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        synchronized (this) {
            this.f127893b = obj2;
            Unit unit = Unit.f139807a;
        }
    }
}
