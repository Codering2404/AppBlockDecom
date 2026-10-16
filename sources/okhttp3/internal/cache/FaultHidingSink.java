package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

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
public class FaultHidingSink extends ForwardingSink {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f144362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f144363c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(Sink delegate, Function1 onException) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onException, "onException");
        this.f144362b = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void H0(Buffer source, long j3) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f144363c) {
            source.skip(j3);
            return;
        }
        try {
            super.H0(source, j3);
        } catch (IOException e3) {
            this.f144363c = true;
            this.f144362b.invoke(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f144363c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e3) {
            this.f144363c = true;
            this.f144362b.invoke(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f144363c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e3) {
            this.f144363c = true;
            this.f144362b.invoke(e3);
        }
    }
}
