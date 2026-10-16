package coil.disk;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class FaultHidingSink extends ForwardingSink {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f55795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f55796c;

    public FaultHidingSink(Sink sink, Function1 function1) {
        super(sink);
        this.f55795b = function1;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void H0(Buffer buffer, long j3) throws EOFException {
        if (this.f55796c) {
            buffer.skip(j3);
            return;
        }
        try {
            super.H0(buffer, j3);
        } catch (IOException e3) {
            this.f55796c = true;
            this.f55795b.invoke(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e3) {
            this.f55796c = true;
            this.f55795b.invoke(e3);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        try {
            super.flush();
        } catch (IOException e3) {
            this.f55796c = true;
            this.f55795b.invoke(e3);
        }
    }
}
