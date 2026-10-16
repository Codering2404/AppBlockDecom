package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class PathNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f140046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f140047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PathNode f140048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Iterator f140049d;

    public PathNode(Path path, Object obj, PathNode pathNode) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f140046a = path;
        this.f140047b = obj;
        this.f140048c = pathNode;
    }

    public final Iterator a() {
        return this.f140049d;
    }

    public final Object b() {
        return this.f140047b;
    }

    public final PathNode c() {
        return this.f140048c;
    }

    public final Path d() {
        return this.f140046a;
    }

    public final void e(Iterator it) {
        this.f140049d = it;
    }
}
