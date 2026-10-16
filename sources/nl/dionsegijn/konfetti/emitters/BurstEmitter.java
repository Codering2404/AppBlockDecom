package nl.dionsegijn.konfetti.emitters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class BurstEmitter extends Emitter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f143735c;

    private final void f(int i3) {
        if (i3 > 1000) {
            i3 = 1000;
        }
        this.f143734b = i3;
    }

    @Override // nl.dionsegijn.konfetti.emitters.Emitter
    public void a(float f3) {
        if (this.f143735c) {
            return;
        }
        int i3 = 1;
        this.f143735c = true;
        int i4 = this.f143734b;
        if (1 > i4) {
            return;
        }
        while (true) {
            Function0 function0B = b();
            if (function0B != null) {
            }
            if (i3 == i4) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // nl.dionsegijn.konfetti.emitters.Emitter
    public boolean c() {
        return this.f143735c;
    }

    public final Emitter e(int i3) {
        f(i3);
        this.f143735c = false;
        return this;
    }
}
