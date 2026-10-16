package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class PointerInputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutCoordinates f26896a;

    public boolean a() {
        return false;
    }

    public final LayoutCoordinates b() {
        return this.f26896a;
    }

    public boolean c() {
        return false;
    }

    public abstract void d();

    public abstract void e(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3);

    public final void f(LayoutCoordinates layoutCoordinates) {
        this.f26896a = layoutCoordinates;
    }
}
