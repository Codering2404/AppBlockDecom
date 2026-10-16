package androidx.compose.foundation;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MagnifierElement extends ModifierNodeElement<MagnifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f4990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f4991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f4992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f4993d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f4994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f4995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f4996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f4997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f4998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PlatformMagnifierFactory f4999k;

    public /* synthetic */ MagnifierElement(Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f3, z2, j3, f4, f5, z3, platformMagnifierFactory);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MagnifierNode create() {
        return new MagnifierNode(this.f4990a, this.f4991b, this.f4992c, this.f4993d, this.f4994f, this.f4995g, this.f4996h, this.f4997i, this.f4998j, this.f4999k, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(MagnifierNode magnifierNode) {
        magnifierNode.u2(this.f4990a, this.f4991b, this.f4993d, this.f4994f, this.f4995g, this.f4996h, this.f4997i, this.f4998j, this.f4992c, this.f4999k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierElement)) {
            return false;
        }
        MagnifierElement magnifierElement = (MagnifierElement) obj;
        return this.f4990a == magnifierElement.f4990a && this.f4991b == magnifierElement.f4991b && this.f4993d == magnifierElement.f4993d && this.f4994f == magnifierElement.f4994f && DpSize.h(this.f4995g, magnifierElement.f4995g) && Dp.i(this.f4996h, magnifierElement.f4996h) && Dp.i(this.f4997i, magnifierElement.f4997i) && this.f4998j == magnifierElement.f4998j && this.f4992c == magnifierElement.f4992c && Intrinsics.areEqual(this.f4999k, magnifierElement.f4999k);
    }

    public int hashCode() {
        int iHashCode = this.f4990a.hashCode() * 31;
        Function1 function1 = this.f4991b;
        int iHashCode2 = (((((((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + Float.hashCode(this.f4993d)) * 31) + Boolean.hashCode(this.f4994f)) * 31) + DpSize.k(this.f4995g)) * 31) + Dp.j(this.f4996h)) * 31) + Dp.j(this.f4997i)) * 31) + Boolean.hashCode(this.f4998j)) * 31;
        Function1 function12 = this.f4992c;
        return ((iHashCode2 + (function12 != null ? function12.hashCode() : 0)) * 31) + this.f4999k.hashCode();
    }

    private MagnifierElement(Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory) {
        this.f4990a = function1;
        this.f4991b = function12;
        this.f4992c = function13;
        this.f4993d = f3;
        this.f4994f = z2;
        this.f4995g = j3;
        this.f4996h = f4;
        this.f4997i = f5;
        this.f4998j = z3;
        this.f4999k = platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("magnifier");
        inspectorInfo.b().c("sourceCenter", this.f4990a);
        inspectorInfo.b().c("magnifierCenter", this.f4991b);
        inspectorInfo.b().c("zoom", Float.valueOf(this.f4993d));
        inspectorInfo.b().c(muQRKXGtpOhe.nSXEPPNio, DpSize.c(this.f4995g));
        inspectorInfo.b().c("cornerRadius", Dp.d(this.f4996h));
        inspectorInfo.b().c("elevation", Dp.d(this.f4997i));
        inspectorInfo.b().c("clippingEnabled", Boolean.valueOf(this.f4998j));
    }
}
