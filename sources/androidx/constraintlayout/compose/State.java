package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.CorePixelDp;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class State extends androidx.constraintlayout.core.state.State {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Density f30940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f30941m = ConstraintsKt.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LayoutDirection f30942n = LayoutDirection.f30001a;

    public State(Density density) {
        this.f30940l = density;
        x(new CorePixelDp() { // from class: androidx.constraintlayout.compose.c
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float a(float f3) {
                return State.G(this.f31014a, f3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float G(State state, float f3) {
        return state.f30940l.getDensity() * f3;
    }

    public final long H() {
        return this.f30941m;
    }

    public final void I(long j3) {
        this.f30941m = j3;
    }

    @Override // androidx.constraintlayout.core.state.State
    public int e(Object obj) {
        return obj instanceof Dp ? this.f30940l.z0(((Dp) obj).l()) : super.e(obj);
    }
}
