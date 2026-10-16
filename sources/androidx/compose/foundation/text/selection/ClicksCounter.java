package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
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
final class ClicksCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewConfiguration f11209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PointerInputChange f11211c;

    public ClicksCounter(ViewConfiguration viewConfiguration) {
        this.f11209a = viewConfiguration;
    }

    public final int a() {
        return this.f11210b;
    }

    public final boolean b(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return SelectionGesturesKt.i(this.f11209a, pointerInputChange, pointerInputChange2);
    }

    public final boolean c(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return pointerInputChange2.o() - pointerInputChange.o() < this.f11209a.a();
    }

    public final void d(PointerEvent pointerEvent) {
        PointerInputChange pointerInputChange = this.f11211c;
        PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.c().get(0);
        if (pointerInputChange != null && c(pointerInputChange, pointerInputChange2) && b(pointerInputChange, pointerInputChange2)) {
            this.f11210b++;
        } else {
            this.f11210b = 1;
        }
        this.f11211c = pointerInputChange2;
    }
}
