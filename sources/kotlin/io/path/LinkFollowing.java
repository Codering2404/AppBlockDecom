package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

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
public final class LinkFollowing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkFollowing f140037a = new LinkFollowing();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkOption[] f140038b = {LinkOption.NOFOLLOW_LINKS};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkOption[] f140039c = new LinkOption[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set f140040d = SetsKt.emptySet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f140041e = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);

    private LinkFollowing() {
    }

    public final LinkOption[] a(boolean z2) {
        return z2 ? f140039c : f140038b;
    }

    public final Set b(boolean z2) {
        return z2 ? f140041e : f140040d;
    }
}
