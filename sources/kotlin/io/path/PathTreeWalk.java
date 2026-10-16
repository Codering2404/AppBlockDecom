package kotlin.io.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.sequences.Sequence;
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
public final class PathTreeWalk implements Sequence<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f140053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathWalkOption[] f140054b;

    private final Iterator g() {
        return SequencesKt.a(new PathTreeWalk$bfsIterator$1(this, null));
    }

    private final Iterator h() {
        return SequencesKt.a(new PathTreeWalk$dfsIterator$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return ArraysKt.contains(this.f140054b, PathWalkOption.f140084c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return ArraysKt.contains(this.f140054b, PathWalkOption.f140082a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] k() {
        return LinkFollowing.f140037a.a(i());
    }

    private final boolean l() {
        return ArraysKt.contains(this.f140054b, PathWalkOption.f140083b);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return l() ? g() : h();
    }
}
