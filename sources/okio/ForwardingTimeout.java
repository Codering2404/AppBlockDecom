package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class ForwardingTimeout extends Timeout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Timeout f145041f;

    public ForwardingTimeout(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f145041f = delegate;
    }

    @Override // okio.Timeout
    public Timeout b() {
        return this.f145041f.b();
    }

    @Override // okio.Timeout
    public Timeout c() {
        return this.f145041f.c();
    }

    @Override // okio.Timeout
    public long d() {
        return this.f145041f.d();
    }

    @Override // okio.Timeout
    public Timeout e(long j3) {
        return this.f145041f.e(j3);
    }

    @Override // okio.Timeout
    public boolean f() {
        return this.f145041f.f();
    }

    @Override // okio.Timeout
    public void g() throws InterruptedIOException {
        this.f145041f.g();
    }

    @Override // okio.Timeout
    public Timeout h(long j3, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.f145041f.h(j3, unit);
    }

    @Override // okio.Timeout
    public long i() {
        return this.f145041f.i();
    }

    public final Timeout k() {
        return this.f145041f;
    }

    public final ForwardingTimeout l(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f145041f = delegate;
        return this;
    }
}
