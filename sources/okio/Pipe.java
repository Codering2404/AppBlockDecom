package okio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
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
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Pipe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f145082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Buffer f145083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f145084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f145085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f145086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Sink f145087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ReentrantLock f145088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Condition f145089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Sink f145090i;

    public final Buffer a() {
        return this.f145083b;
    }

    public final boolean b() {
        return this.f145084c;
    }

    public final Condition c() {
        return this.f145089h;
    }

    public final Sink d() {
        return this.f145087f;
    }

    public final ReentrantLock e() {
        return this.f145088g;
    }

    public final long f() {
        return this.f145082a;
    }

    public final boolean g() {
        return this.f145085d;
    }

    public final boolean h() {
        return this.f145086e;
    }

    public final void i(boolean z2) {
        this.f145085d = z2;
    }

    public final void j(boolean z2) {
        this.f145086e = z2;
    }

    public final Sink k() {
        return this.f145090i;
    }
}
