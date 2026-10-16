package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class SequencesKt___SequencesKt$minus$1 implements Sequence<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sequence f140374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f140375b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Ref.BooleanRef booleanRef, Object obj, Object obj2) {
        if (booleanRef.f140137a || !Intrinsics.areEqual(obj2, obj)) {
            return true;
        }
        booleanRef.f140137a = true;
        return false;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Sequence sequence = this.f140374a;
        final Object obj = this.f140375b;
        return SequencesKt___SequencesKt.A(sequence, new Function1() { // from class: kotlin.sequences.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(SequencesKt___SequencesKt$minus$1.d(booleanRef, obj, obj2));
            }
        }).iterator();
    }
}
