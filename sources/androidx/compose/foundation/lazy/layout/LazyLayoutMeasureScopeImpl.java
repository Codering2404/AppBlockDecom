package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
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
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f8143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SubcomposeMeasureScope f8144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyLayoutItemProvider f8145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableIntObjectMap f8146d = IntObjectMapKt.c();

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        this.f8143a = lazyLayoutItemContentFactory;
        this.f8144b = subcomposeMeasureScope;
        this.f8145c = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.d().invoke();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    public float F(int i3) {
        return this.f8144b.F(i3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    public float G(float f3) {
        return this.f8144b.G(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float J0(long j3) {
        return this.f8144b.J0(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f8144b.K1();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    public long M(long j3) {
        return this.f8144b.M(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float M1(float f3) {
        return this.f8144b.M1(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public int T1(long j3) {
        return this.f8144b.T1(j3);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult U1(int i3, int i4, Map map, Function1 function1, Function1 function12) {
        return this.f8144b.U1(i3, i4, map, function1, function12);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult c1(int i3, int i4, Map map, Function1 function1) {
        return this.f8144b.c1(i3, i4, map, function1);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f8144b.getDensity();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.f8144b.getLayoutDirection();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public List m0(int i3, long j3) {
        List list = (List) this.f8146d.b(i3);
        if (list != null) {
            return list;
        }
        Object objD = this.f8145c.d(i3);
        List listV = this.f8144b.V(objD, this.f8143a.b(i3, objD, this.f8145c.f(i3)));
        int size = listV.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Measurable) listV.get(i4)).n0(j3));
        }
        this.f8146d.r(i3, arrayList);
        return arrayList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return this.f8144b.n(f3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    public long o(long j3) {
        return this.f8144b.o(j3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        return this.f8144b.q(j3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean q0() {
        return this.f8144b.q0();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    public long v(float f3) {
        return this.f8144b.v(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public int z0(float f3) {
        return this.f8144b.z0(f3);
    }
}
