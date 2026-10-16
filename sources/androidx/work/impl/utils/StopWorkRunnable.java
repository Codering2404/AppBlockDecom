package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class StopWorkRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Processor f55185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StartStopToken f55186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f55187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f55188d;

    public StopWorkRunnable(Processor processor, StartStopToken token, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
        this.f55185a = processor;
        this.f55186b = token;
        this.f55187c = z2;
        this.f55188d = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zS = this.f55187c ? this.f55185a.s(this.f55186b, this.f55188d) : this.f55185a.t(this.f55186b, this.f55188d);
        Logger.e().a(Logger.i("StopWorkRunnable"), "StopWorkRunnable for " + this.f55186b.a().b() + "; Processor.stopWork = " + zS);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor, StartStopToken token, boolean z2) {
        this(processor, token, z2, -512);
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(token, "token");
    }
}
