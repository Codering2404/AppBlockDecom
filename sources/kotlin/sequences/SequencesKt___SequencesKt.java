package kotlin.sequences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static Sequence A(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static final Sequence B(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static Sequence C(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Sequence sequenceB = B(sequence, new Function1() { // from class: kotlin.sequences.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SequencesKt___SequencesKt.D(obj));
            }
        });
        Intrinsics.checkNotNull(sequenceB, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return sequenceB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(Object obj) {
        return obj == null;
    }

    public static Object E(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Sequence F(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, SequencesKt___SequencesKt$flatMap$2.f140369a);
    }

    public static Sequence G(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new FlatteningSequence(sequence, transform, SequencesKt___SequencesKt$flatMap$1.f140368a);
    }

    public static final int H(Sequence sequence, Object obj) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i3 = 0;
        for (Object obj2 : sequence) {
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(obj, obj2)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final Appendable I(Sequence sequence, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1 function1) throws IOException {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i4 = 0;
        for (Object obj : sequence) {
            i4++;
            if (i4 > 1) {
                buffer.append(separator);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            StringsKt.a(buffer, obj, function1);
        }
        if (i3 >= 0 && i4 > i3) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String J(Sequence sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) I(sequence, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
    }

    public static /* synthetic */ String K(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i4 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i4 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i4 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return J(sequence, charSequence, charSequence2, charSequence3, i3, charSequence5, function12);
    }

    public static Object L(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Sequence M(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static Sequence N(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return C(new TransformingSequence(sequence, transform));
    }

    public static Sequence O(final Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new Sequence<Comparable<Object>>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$sorted$1
            @Override // kotlin.sequences.Sequence
            public Iterator iterator() {
                List listT = SequencesKt___SequencesKt.T(sequence);
                CollectionsKt.sort(listT);
                return listT.iterator();
            }
        };
    }

    public static Sequence P(Sequence sequence, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i3 >= 0) {
            return i3 == 0 ? SequencesKt__SequencesKt.g() : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).b(i3) : new TakeSequence(sequence, i3);
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static Sequence Q(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new TakeWhileSequence(sequence, predicate);
    }

    public static final Collection R(Sequence sequence, Collection destination) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List S(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static final List T(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (List) R(sequence, new ArrayList());
    }

    public static Set U(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return SetsKt.emptySet();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return SetsKt.setOf(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static Iterable q(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static boolean r(Sequence sequence, Object obj) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return H(sequence, obj) >= 0;
    }

    public static int s(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator it = sequence.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            it.next();
            i3++;
            if (i3 < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i3;
    }

    public static Sequence t(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return v(sequence, new Function1() { // from class: kotlin.sequences.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SequencesKt___SequencesKt.u(obj);
            }
        });
    }

    public static Sequence v(Sequence sequence, Function1 selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new DistinctSequence(sequence, selector);
    }

    public static Sequence w(Sequence sequence, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (i3 >= 0) {
            return i3 == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).a(i3) : new DropSequence(sequence, i3);
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static Object x(Sequence sequence, final int i3) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return z(sequence, i3, new Function1() { // from class: kotlin.sequences.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SequencesKt___SequencesKt.y(i3, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object y(int i3, int i4) {
        throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + i3 + '.');
    }

    public static final Object z(Sequence sequence, int i3, Function1 defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (i3 < 0) {
            return defaultValue.invoke(Integer.valueOf(i3));
        }
        int i4 = 0;
        for (Object obj : sequence) {
            int i5 = i4 + 1;
            if (i3 == i4) {
                return obj;
            }
            i4 = i5;
        }
        return defaultValue.invoke(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object u(Object obj) {
        return obj;
    }
}
