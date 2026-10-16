package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer serializer) {
        super(fileSystem, path, serializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097 A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:42:0x0097, B:48:0x00a4, B:37:0x008c, B:34:0x0087), top: B:60:0x0022, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:42:0x0097, B:48:0x00a4, B:37:0x008c, B:34:0x0087), top: B:60:0x0022, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioWriteScope$writeData$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, okio.FileHandle] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [okio.FileHandle] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.datastore.core.okio.OkioSerializer] */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.Object r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioWriteScope$writeData$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = (androidx.datastore.core.okio.OkioWriteScope$writeData$1) r0
            int r1 = r0.f35888g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35888g = r1
            goto L18
        L13:
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = new androidx.datastore.core.okio.OkioWriteScope$writeData$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f35886d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f35888g
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r9 = r0.f35885c
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r1 = r0.f35884b
            okio.FileHandle r1 = (okio.FileHandle) r1
            java.lang.Object r0 = r0.f35883a
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L36
            goto L72
        L36:
            r10 = move-exception
            goto L85
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L40:
            kotlin.ResultKt.b(r10)
            r8.f()
            okio.FileSystem r10 = r8.g()
            okio.Path r2 = r8.h()
            okio.FileHandle r10 = r10.p(r2)
            r5 = 0
            okio.Sink r2 = okio.FileHandle.F(r10, r5, r3, r4)     // Catch: java.lang.Throwable -> La5
            okio.BufferedSink r2 = okio.Okio.c(r2)     // Catch: java.lang.Throwable -> La5
            androidx.datastore.core.okio.OkioSerializer r5 = r8.i()     // Catch: java.lang.Throwable -> L81
            r0.f35883a = r10     // Catch: java.lang.Throwable -> L81
            r0.f35884b = r10     // Catch: java.lang.Throwable -> L81
            r0.f35885c = r2     // Catch: java.lang.Throwable -> L81
            r0.f35888g = r3     // Catch: java.lang.Throwable -> L81
            java.lang.Object r9 = r5.b(r9, r2, r0)     // Catch: java.lang.Throwable -> L81
            if (r9 != r1) goto L6f
            return r1
        L6f:
            r0 = r10
            r1 = r0
            r9 = r2
        L72:
            r1.flush()     // Catch: java.lang.Throwable -> L36
            kotlin.Unit r10 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L7f
            r9.close()     // Catch: java.lang.Throwable -> L7d
            goto L7f
        L7d:
            r9 = move-exception
            goto L95
        L7f:
            r9 = r4
            goto L95
        L81:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r2
        L85:
            if (r9 == 0) goto L93
            r9.close()     // Catch: java.lang.Throwable -> L8b
            goto L93
        L8b:
            r9 = move-exception
            kotlin.ExceptionsKt.a(r10, r9)     // Catch: java.lang.Throwable -> L90
            goto L93
        L90:
            r9 = move-exception
            r10 = r0
            goto La6
        L93:
            r9 = r10
            r10 = r4
        L95:
            if (r9 != 0) goto La4
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch: java.lang.Throwable -> L90
            kotlin.Unit r9 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto Lb3
            r0.close()     // Catch: java.lang.Throwable -> La2
            goto Lb3
        La2:
            r4 = move-exception
            goto Lb3
        La4:
            throw r9     // Catch: java.lang.Throwable -> L90
        La5:
            r9 = move-exception
        La6:
            if (r10 == 0) goto Lb0
            r10.close()     // Catch: java.lang.Throwable -> Lac
            goto Lb0
        Lac:
            r10 = move-exception
            kotlin.ExceptionsKt.a(r9, r10)
        Lb0:
            r7 = r4
            r4 = r9
            r9 = r7
        Lb3:
            if (r4 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        Lbb:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
