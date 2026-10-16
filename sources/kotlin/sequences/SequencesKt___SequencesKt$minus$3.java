package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

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
public final class SequencesKt___SequencesKt$minus$3 implements Sequence<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f140378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sequence f140379b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Collection collection, Object obj) {
        return collection.contains(obj);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        final Collection collectionConvertToListIfNotCollection = CollectionsKt.convertToListIfNotCollection(this.f140378a);
        return collectionConvertToListIfNotCollection.isEmpty() ? this.f140379b.iterator() : SequencesKt___SequencesKt.B(this.f140379b, new Function1() { // from class: kotlin.sequences.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SequencesKt___SequencesKt$minus$3.d(collectionConvertToListIfNotCollection, obj));
            }
        }).iterator();
    }
}
