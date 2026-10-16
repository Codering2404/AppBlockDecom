package androidx.datastore.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public class FileReadScope<T> implements ReadScope<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f35690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Serializer f35691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicBoolean f35692c;

    public FileReadScope(File file, Serializer serializer) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f35690a = file;
        this.f35691b = serializer;
        this.f35692c = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.datastore.core.FileReadScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.datastore.core.FileReadScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object i(androidx.datastore.core.FileReadScope r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.f35697f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35697f = r1
            goto L18
        L13:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f35695c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f35697f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f35693a
            java.io.Closeable r7 = (java.io.Closeable) r7
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L9d
        L32:
            r8 = move-exception
            goto La5
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.f35694b
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.f35693a
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L6b
        L49:
            r8 = move-exception
            goto L76
        L4b:
            kotlin.ResultKt.b(r8)
            r7.f()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7c
            java.io.File r2 = r7.f35690a     // Catch: java.io.FileNotFoundException -> L7c
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7c
            androidx.datastore.core.Serializer r2 = r7.f35691b     // Catch: java.lang.Throwable -> L71
            r0.f35693a = r7     // Catch: java.lang.Throwable -> L71
            r0.f35694b = r8     // Catch: java.lang.Throwable -> L71
            r0.f35697f = r4     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 != r1) goto L67
            goto L99
        L67:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6b:
            kotlin.io.CloseableKt.a(r7, r5)     // Catch: java.io.FileNotFoundException -> L6f
            return r8
        L6f:
            r7 = r2
            goto L7c
        L71:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L76:
            throw r8     // Catch: java.lang.Throwable -> L77
        L77:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r7, r8)     // Catch: java.io.FileNotFoundException -> L6f
            throw r4     // Catch: java.io.FileNotFoundException -> L6f
        L7c:
            java.io.File r8 = r7.f35690a
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.f35690a
            r8.<init>(r2)
            androidx.datastore.core.Serializer r7 = r7.f35691b     // Catch: java.lang.Throwable -> La1
            r0.f35693a = r8     // Catch: java.lang.Throwable -> La1
            r0.f35694b = r5     // Catch: java.lang.Throwable -> La1
            r0.f35697f = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != r1) goto L9a
        L99:
            return r1
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
        L9d:
            kotlin.io.CloseableKt.a(r7, r5)
            return r8
        La1:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La5:
            throw r8     // Catch: java.lang.Throwable -> La6
        La6:
            r0 = move-exception
            kotlin.io.CloseableKt.a(r7, r8)
            throw r0
        Lab:
            androidx.datastore.core.Serializer r7 = r7.f35691b
            java.lang.Object r7 = r7.getDefaultValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.i(androidx.datastore.core.FileReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.ReadScope
    public Object c(Continuation continuation) {
        return i(this, continuation);
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.f35692c.set(true);
    }

    protected final void f() {
        if (this.f35692c.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    protected final File g() {
        return this.f35690a;
    }

    protected final Serializer h() {
        return this.f35691b;
    }
}
