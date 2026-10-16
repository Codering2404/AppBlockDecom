package androidx.datastore.core;

import java.io.File;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer serializer) {
        super(file, serializer);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.WriteScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.f35729f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35729f = r1
            goto L18
        L13:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f35727c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f35729f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f35726b
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.f35725a
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L62
        L31:
            r6 = move-exception
            goto L74
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r7)
            r5.f()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.g()
            r7.<init>(r2)
            androidx.datastore.core.Serializer r2 = r5.h()     // Catch: java.lang.Throwable -> L72
            androidx.datastore.core.UncloseableOutputStream r4 = new androidx.datastore.core.UncloseableOutputStream     // Catch: java.lang.Throwable -> L72
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L72
            r0.f35725a = r7     // Catch: java.lang.Throwable -> L72
            r0.f35726b = r7     // Catch: java.lang.Throwable -> L72
            r0.f35729f = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r6 = r2.writeTo(r6, r4, r0)     // Catch: java.lang.Throwable -> L72
            if (r6 != r1) goto L60
            return r1
        L60:
            r6 = r7
            r0 = r6
        L62:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L31
            r6.sync()     // Catch: java.lang.Throwable -> L31
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L31
            r6 = 0
            kotlin.io.CloseableKt.a(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L72:
            r6 = move-exception
            r0 = r7
        L74:
            throw r6     // Catch: java.lang.Throwable -> L75
        L75:
            r7 = move-exception
            kotlin.io.CloseableKt.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
