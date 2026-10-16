package androidx.constraintlayout.compose;

import java.util.Map;
import kotlin.Metadata;
import kotlin.properties.ObservableProperty;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BaseKeyFrameScope$addOnPropertyChange$1 extends ObservableProperty<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseKeyFrameScope f30347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f30348c;

    @Override // kotlin.properties.ObservableProperty
    protected void c(KProperty kProperty, Object obj, Object obj2) {
        if (obj2 != null) {
            Map map = this.f30347b.f30344a;
            String name = this.f30348c;
            if (name == null) {
                name = kProperty.getName();
            }
            map.put(name, obj2);
            return;
        }
        Map map2 = this.f30347b.f30344a;
        String name2 = this.f30348c;
        if (name2 == null) {
            name2 = kProperty.getName();
        }
        map2.remove(name2);
    }
}
