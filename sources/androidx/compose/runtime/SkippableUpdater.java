package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class SkippableUpdater<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Composer f24166a;

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.f24166a = composer;
    }

    public static final /* synthetic */ SkippableUpdater a(Composer composer) {
        return new SkippableUpdater(composer);
    }

    public static boolean c(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).f());
    }

    public static int d(Composer composer) {
        return composer.hashCode();
    }

    public static String e(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f24166a, obj);
    }

    public final /* synthetic */ Composer f() {
        return this.f24166a;
    }

    public int hashCode() {
        return d(this.f24166a);
    }

    public String toString() {
        return e(this.f24166a);
    }

    public static Composer b(Composer composer) {
        return composer;
    }
}
