package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Okio {
    public static final Sink a(File file) {
        return Okio__JvmOkioKt.b(file);
    }

    public static final Sink b() {
        return Okio__OkioKt.a();
    }

    public static final BufferedSink c(Sink sink) {
        return Okio__OkioKt.b(sink);
    }

    public static final BufferedSource d(Source source) {
        return Okio__OkioKt.c(source);
    }

    public static final boolean e(AssertionError assertionError) {
        return Okio__JvmOkioKt.c(assertionError);
    }

    public static final Sink f(File file) {
        return Okio__JvmOkioKt.d(file);
    }

    public static final Sink g(File file, boolean z2) {
        return Okio__JvmOkioKt.e(file, z2);
    }

    public static final Sink h(OutputStream outputStream) {
        return Okio__JvmOkioKt.f(outputStream);
    }

    public static final Sink i(Socket socket) {
        return Okio__JvmOkioKt.g(socket);
    }

    public static final Source k(File file) {
        return Okio__JvmOkioKt.i(file);
    }

    public static final Source l(InputStream inputStream) {
        return Okio__JvmOkioKt.j(inputStream);
    }

    public static final Source m(Socket socket) {
        return Okio__JvmOkioKt.k(socket);
    }
}
