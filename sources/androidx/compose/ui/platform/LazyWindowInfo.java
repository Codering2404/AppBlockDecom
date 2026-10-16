package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LazyWindowInfo implements WindowInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f28123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableState f28124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f28125c = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    @Override // androidx.compose.ui.platform.WindowInfo
    public long a() {
        if (this.f28124b == null) {
            Function0 function0 = this.f28123a;
            this.f28124b = SnapshotStateKt__SnapshotStateKt.e(IntSize.b(function0 != null ? ((IntSize) function0.invoke()).j() : IntSize.f29998b.a()), null, 2, null);
            this.f28123a = null;
        }
        MutableState mutableState = this.f28124b;
        Intrinsics.checkNotNull(mutableState);
        return ((IntSize) mutableState.getValue()).j();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean b() {
        return ((Boolean) this.f28125c.getValue()).booleanValue();
    }

    public void d(int i3) {
        WindowInfoImpl.f28271c.a().setValue(PointerKeyboardModifiers.a(i3));
    }

    public final void e(Function0 function0) {
        if (this.f28124b == null) {
            this.f28123a = function0;
        }
    }

    public void f(boolean z2) {
        this.f28125c.setValue(Boolean.valueOf(z2));
    }
}
