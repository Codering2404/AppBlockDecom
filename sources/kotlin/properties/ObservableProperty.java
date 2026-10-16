package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

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
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f140175a;

    public ObservableProperty(Object obj) {
        this.f140175a = obj;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f140175a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void b(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        Object obj3 = this.f140175a;
        if (d(property, obj3, obj2)) {
            this.f140175a = obj2;
            c(property, obj3, obj2);
        }
    }

    protected void c(KProperty property, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
    }

    protected boolean d(KProperty property, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        return true;
    }

    public String toString() {
        return "ObservableProperty(value=" + this.f140175a + ')';
    }
}
