package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static Sequence e(final Iterator it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return f(new Sequence<Object>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator iterator() {
                return it;
            }
        });
    }

    public static Sequence f(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static Sequence g() {
        return EmptySequence.f140304a;
    }

    public static Sequence h(final Object obj, Function1 nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return obj == null ? EmptySequence.f140304a : new GeneratorSequence(new Function0() { // from class: kotlin.sequences.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SequencesKt__SequencesKt.l(obj);
            }
        }, nextFunction);
    }

    public static Sequence i(final Function0 nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return f(new GeneratorSequence(nextFunction, new Function1() { // from class: kotlin.sequences.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.k(nextFunction, obj);
            }
        }));
    }

    public static Sequence j(Function0 seedFunction, Function1 nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new GeneratorSequence(seedFunction, nextFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(Function0 function0, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return function0.invoke();
    }

    public static Sequence m(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.asSequence(elements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(Object obj) {
        return obj;
    }
}
