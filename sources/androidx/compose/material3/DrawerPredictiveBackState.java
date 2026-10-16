package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.util.MathHelpersKt;
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
public final class DrawerPredictiveBackState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f17490a = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f17491b = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f17492c = PrimitiveSnapshotStateKt.a(0.0f);

    public final void a() {
        g(true);
        e(0.0f);
        f(0.0f);
    }

    public final float b() {
        return this.f17491b.c();
    }

    public final float c() {
        return this.f17492c.c();
    }

    public final boolean d() {
        return ((Boolean) this.f17490a.getValue()).booleanValue();
    }

    public final void e(float f3) {
        this.f17491b.s(f3);
    }

    public final void f(float f3) {
        this.f17492c.s(f3);
    }

    public final void g(boolean z2) {
        this.f17490a.setValue(Boolean.valueOf(z2));
    }

    public final void h(float f3, boolean z2, boolean z3, float f4, float f5, float f6) {
        g(z2 != z3);
        if (!d()) {
            f4 = f5;
        }
        e(MathHelpersKt.b(0.0f, f4, f3));
        f(MathHelpersKt.b(0.0f, f6, f3));
    }
}
