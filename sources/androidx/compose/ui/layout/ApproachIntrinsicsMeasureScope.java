package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class ApproachIntrinsicsMeasureScope implements ApproachMeasureScope, ApproachIntrinsicMeasureScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutDirection f27015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ApproachIntrinsicMeasureScope f27016b;

    public ApproachIntrinsicsMeasureScope(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, LayoutDirection layoutDirection) {
        this.f27015a = layoutDirection;
        this.f27016b = approachIntrinsicMeasureScope;
    }

    @Override // androidx.compose.ui.unit.Density
    public float F(int i3) {
        return this.f27016b.F(i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float G(float f3) {
        return this.f27016b.G(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float J0(long j3) {
        return this.f27016b.J0(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f27016b.K1();
    }

    @Override // androidx.compose.ui.unit.Density
    public long M(long j3) {
        return this.f27016b.M(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float M1(float f3) {
        return this.f27016b.M1(f3);
    }

    @Override // androidx.compose.ui.layout.ApproachIntrinsicMeasureScope
    public long P0() {
        return this.f27016b.P0();
    }

    @Override // androidx.compose.ui.unit.Density
    public int T1(long j3) {
        return this.f27016b.T1(j3);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult U1(final int i3, final int i4, final Map map, final Function1 function1, Function1 function12) {
        boolean z2 = false;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        if ((i3 & (-16777216)) == 0 && ((-16777216) & i4) == 0) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.c("Size(" + i3 + " x " + i4 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.layout.ApproachIntrinsicsMeasureScope$layout$1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 B() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return i4;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return i3;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
            }
        };
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f27016b.getDensity();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.f27015a;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return this.f27016b.n(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public long o(long j3) {
        return this.f27016b.o(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        return this.f27016b.q(j3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean q0() {
        return this.f27016b.q0();
    }

    @Override // androidx.compose.ui.unit.Density
    public long v(float f3) {
        return this.f27016b.v(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public int z0(float f3) {
        return this.f27016b.z0(f3);
    }
}
