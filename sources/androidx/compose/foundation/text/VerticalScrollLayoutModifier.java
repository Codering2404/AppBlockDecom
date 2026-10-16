package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
final class VerticalScrollLayoutModifier implements LayoutModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldScrollerPosition f10084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TransformedText f10086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f10087d;

    public VerticalScrollLayoutModifier(TextFieldScrollerPosition textFieldScrollerPosition, int i3, TransformedText transformedText, Function0 function0) {
        this.f10084a = textFieldScrollerPosition;
        this.f10085b = i3;
        this.f10086c = transformedText;
        this.f10087d = function0;
    }

    public final int a() {
        return this.f10085b;
    }

    public final TextFieldScrollerPosition b() {
        return this.f10084a;
    }

    public final Function0 c() {
        return this.f10087d;
    }

    public final TransformedText d() {
        return this.f10086c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerticalScrollLayoutModifier)) {
            return false;
        }
        VerticalScrollLayoutModifier verticalScrollLayoutModifier = (VerticalScrollLayoutModifier) obj;
        return Intrinsics.areEqual(this.f10084a, verticalScrollLayoutModifier.f10084a) && this.f10085b == verticalScrollLayoutModifier.f10085b && Intrinsics.areEqual(this.f10086c, verticalScrollLayoutModifier.f10086c) && Intrinsics.areEqual(this.f10087d, verticalScrollLayoutModifier.f10087d);
    }

    public int hashCode() {
        return (((((this.f10084a.hashCode() * 31) + Integer.hashCode(this.f10085b)) * 31) + this.f10086c.hashCode()) * 31) + this.f10087d.hashCode();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo45measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, 0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 7, null));
        final int iMin = Math.min(placeableN0.O0(), Constraints.k(j3));
        return MeasureScope.B0(measureScope, placeableN0.X0(), iMin, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.VerticalScrollLayoutModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                MeasureScope measureScope2 = measureScope;
                int iA = this.a();
                TransformedText transformedTextD = this.d();
                TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) this.c().invoke();
                this.b().k(Orientation.f6031a, TextFieldScrollKt.c(measureScope2, iA, transformedTextD, textLayoutResultProxy != null ? textLayoutResultProxy.f() : null, false, placeableN0.X0()), iMin, placeableN0.O0());
                Placeable.PlacementScope.m(placementScope, placeableN0, 0, Math.round(-this.b().d()), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public String toString() {
        return "VerticalScrollLayoutModifier(scrollerPosition=" + this.f10084a + YgVrd.HalICqlyA + this.f10085b + ", transformedText=" + this.f10086c + ", textLayoutResultProvider=" + this.f10087d + ')';
    }
}
