package androidx.constraintlayout.compose;

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
public final class BaseKeyFrameScope$addNameOnPropertyChange$1 extends ObservableProperty<NamedPropertyOrValue> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f30345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseKeyFrameScope f30346c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.properties.ObservableProperty
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(KProperty kProperty, NamedPropertyOrValue namedPropertyOrValue, NamedPropertyOrValue namedPropertyOrValue2) {
        String name = this.f30345b;
        if (name == null) {
            name = kProperty.getName();
        }
        if (namedPropertyOrValue2 != null) {
            this.f30346c.f30344a.put(name, namedPropertyOrValue2.getName());
        }
    }
}
