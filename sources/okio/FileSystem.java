package okio;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.ResourceFileSystem;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public abstract class FileSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f145033a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FileSystem f145034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f145035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FileSystem f145036d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        f145034b = jvmSystemFileSystem;
        Path.Companion companion = Path.f145073b;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"java.io.tmpdir\")");
        f145035c = Path.Companion.e(companion, property, false, 1, null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "ResourceFileSystem::class.java.classLoader");
        f145036d = new ResourceFileSystem(classLoader, false);
    }

    public final Sink a(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return b(file, false);
    }

    public abstract Sink b(Path path, boolean z2);

    public abstract void c(Path path, Path path2);

    public final void d(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        e(dir, false);
    }

    public final void e(Path dir, boolean z2) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        okio.internal.FileSystem.b(this, dir, z2);
    }

    public final void f(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        g(dir, false);
    }

    public abstract void g(Path path, boolean z2);

    public final void h(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        i(path, false);
    }

    public abstract void i(Path path, boolean z2);

    public final boolean j(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.c(this, path);
    }

    public abstract List k(Path path);

    public abstract List l(Path path);

    public final FileMetadata m(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return okio.internal.FileSystem.d(this, path);
    }

    public abstract FileMetadata n(Path path);

    public abstract FileHandle o(Path path);

    public final FileHandle p(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return q(file, false, false);
    }

    public abstract FileHandle q(Path path, boolean z2, boolean z3);

    public final Sink r(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return s(file, false);
    }

    public abstract Sink s(Path path, boolean z2);

    public abstract Source t(Path path);
}
