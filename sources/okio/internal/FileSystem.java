package okio.internal;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okio.FileMetadata;
import okio.Path;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
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
public final class FileSystem {
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        if (r15.a(r1, r4) == r5) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e8, code lost:
    
        if (r11 != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
    
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
    
        r3 = r3.iterator();
        r3 = r1;
        r1 = r2;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0138, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0139, code lost:
    
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0160, code lost:
    
        if (r10.a(r1, r4) == r5) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fb A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #2 {all -> 0x0138, blocks: (B:48:0x00f5, B:50:0x00fb, B:47:0x00ed), top: B:77:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0130 -> B:19:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.sequences.SequenceScope r15, okio.FileSystem r16, kotlin.collections.ArrayDeque r17, okio.Path r18, boolean r19, boolean r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.a(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Path e(okio.FileSystem fileSystem, Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path pathE = fileSystem.m(path).e();
        if (pathE == null) {
            return null;
        }
        Path pathH = path.h();
        Intrinsics.checkNotNull(pathH);
        return pathH.k(pathE);
    }

    public static final void b(okio.FileSystem fileSystem, Path dir, boolean z2) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path pathH = dir; pathH != null && !fileSystem.j(pathH); pathH = pathH.h()) {
            arrayDeque.addFirst(pathH);
        }
        if (z2 && arrayDeque.isEmpty()) {
            throw new IOException(dir + YgVrd.aapllrvbA);
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.f((Path) it.next());
        }
    }

    public static final boolean c(okio.FileSystem fileSystem, Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, KrzujOtzIk.xzhI);
        return fileSystem.n(path) != null;
    }

    public static final FileMetadata d(okio.FileSystem fileSystem, Path path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(fileSystem, jlWo.VgzDTZ);
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataN = fileSystem.n(path);
        if (fileMetadataN != null) {
            return fileMetadataN;
        }
        throw new FileNotFoundException("no such file: " + path);
    }
}
