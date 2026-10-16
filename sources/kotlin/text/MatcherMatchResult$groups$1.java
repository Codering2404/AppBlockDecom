package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;

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
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f140572a;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f140572a = matcherMatchResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchGroup e(MatcherMatchResult$groups$1 matcherMatchResult$groups$1, int i3) {
        return matcherMatchResult$groups$1.get(i3);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return d((MatchGroup) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int i3) {
        IntRange intRangeH = RegexKt.h(this.f140572a.f(), i3);
        if (intRangeH.a().intValue() < 0) {
            return null;
        }
        String strGroup = this.f140572a.f().group(i3);
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return new MatchGroup(strGroup, intRangeH);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f140572a.f().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return SequencesKt.M(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Function1() { // from class: kotlin.text.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MatcherMatchResult$groups$1.e(this.f140610a, ((Integer) obj).intValue());
            }
        }).iterator();
    }
}
