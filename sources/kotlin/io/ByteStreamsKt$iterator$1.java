package kotlin.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

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
public final class ByteStreamsKt$iterator$1 extends ByteIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f139938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f139939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f139940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BufferedInputStream f139941d;

    private final void a() throws IOException {
        if (this.f139939b || this.f139940c) {
            return;
        }
        int i3 = this.f139941d.read();
        this.f139938a = i3;
        this.f139939b = true;
        this.f139940c = i3 == -1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws IOException {
        a();
        return !this.f139940c;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() throws IOException {
        a();
        if (this.f139940c) {
            throw new NoSuchElementException("Input stream is over.");
        }
        byte b3 = (byte) this.f139938a;
        this.f139939b = false;
        return b3;
    }
}
