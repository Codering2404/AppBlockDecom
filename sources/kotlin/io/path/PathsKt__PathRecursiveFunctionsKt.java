package kotlin.io.path;

import com.facebook.FacebookContentProvider;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f140088b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.f140024a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.f140026c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.f140025b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f140087a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.f140043b.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.f140042a.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f140088b = iArr2;
        }
    }

    public static final void c(Path path) throws IllegalFileNameException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String strJ = PathsKt__PathUtilsKt.j(path);
        int iHashCode = strJ.hashCode();
        if (iHashCode != 46) {
            if (iHashCode != 1518) {
                if (iHashCode != 45679) {
                    if (iHashCode != 45724) {
                        if (iHashCode != 1472) {
                            if (iHashCode != 1473 || !strJ.equals("./")) {
                                return;
                            }
                        } else if (!strJ.equals(FacebookContentProvider.INVALID_FILE_NAME)) {
                            return;
                        }
                    } else if (!strJ.equals("..\\")) {
                        return;
                    }
                } else if (!strJ.equals("../")) {
                    return;
                }
            } else if (!strJ.equals(".\\")) {
                return;
            }
        } else if (!strJ.equals(".")) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    private static final void d(Path path, Path path2) throws FileSystemLoopException {
        if (!Files.isSymbolicLink(path) && Files.isSameFile(path, path2)) {
            throw new FileSystemLoopException(path.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult e(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Function3 function32, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                c(path4);
                Object objLast = CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                d(path4, (Path) objLast);
            }
            return h((CopyActionResult) function3.invoke(DefaultCopyActionContext.f140029a, path4, f(path, path2, path3, path4)));
        } catch (Exception e3) {
            return g(function32, path, path2, path3, path4, e3);
        }
    }

    private static final Path f(Path path, Path path2, Path path3, Path path4) throws IllegalFileNameException {
        Path pathResolve = path2.resolve(PathsKt__PathUtilsKt.m(path4, path).toString());
        if (!pathResolve.normalize().startsWith(path3)) {
            throw new IllegalFileNameException(path4, pathResolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        }
        Intrinsics.checkNotNull(pathResolve);
        return pathResolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult g(Function3 function3, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return i((OnErrorResult) function3.invoke(path4, f(path, path2, path3, path4), exc));
    }

    private static final FileVisitResult h(CopyActionResult copyActionResult) {
        int i3 = WhenMappings.f140087a[copyActionResult.ordinal()];
        if (i3 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i3 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i3 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final FileVisitResult i(OnErrorResult onErrorResult) {
        int i3 = WhenMappings.f140088b[onErrorResult.ordinal()];
        if (i3 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i3 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
