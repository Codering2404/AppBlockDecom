package kotlinx.collections.immutable;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;

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
public final class ExtensionsKt {
    public static final PersistentList a() {
        return UtilsKt.b();
    }

    public static final PersistentList b(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return UtilsKt.b().addAll((Collection) ArraysKt.asList(elements));
    }

    public static final PersistentSet c() {
        return PersistentOrderedSet.f140845d.a();
    }

    public static final PersistentSet d(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return PersistentOrderedSet.f140845d.a().addAll((Collection) ArraysKt.asList(elements));
    }

    public static final PersistentList e(PersistentList persistentList, Iterable elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentList.addAll((Collection) elements);
        }
        PersistentList.Builder builder = persistentList.builder();
        CollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final PersistentList f(PersistentList persistentList, Sequence elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder builder = persistentList.builder();
        CollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final PersistentSet g(PersistentSet persistentSet, Iterable elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.addAll((Collection) elements);
        }
        PersistentSet.Builder builder = persistentSet.builder();
        CollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final ImmutableList h(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ImmutableList immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? k(iterable) : immutableList;
    }

    public static final ImmutableList i(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return l(sequence);
    }

    public static final PersistentList k(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentList persistentList = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList != null) {
            return persistentList;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        PersistentList persistentListBuild = builder != null ? builder.build() : null;
        return persistentListBuild == null ? e(a(), iterable) : persistentListBuild;
    }

    public static final PersistentList l(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return f(a(), sequence);
    }

    public static final ImmutableSet j(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, pMpIcGE.ZgWbKcYTkJ);
        ImmutableSet immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        PersistentSet persistentSetBuild = builder != null ? builder.build() : null;
        return persistentSetBuild == null ? g(c(), iterable) : persistentSetBuild;
    }
}
