package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class HorizontalScrollLayoutModifier implements LayoutModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldScrollerPosition f9713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TransformedText f9715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f9716d;

    public HorizontalScrollLayoutModifier(TextFieldScrollerPosition textFieldScrollerPosition, int i3, TransformedText transformedText, Function0 function0) {
        this.f9713a = textFieldScrollerPosition;
        this.f9714b = i3;
        this.f9715c = transformedText;
        this.f9716d = function0;
    }

    public final int a() {
        return this.f9714b;
    }

    public final TextFieldScrollerPosition b() {
        return this.f9713a;
    }

    public final Function0 c() {
        return this.f9716d;
    }

    public final TransformedText d() {
        return this.f9715c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HorizontalScrollLayoutModifier)) {
            return false;
        }
        HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = (HorizontalScrollLayoutModifier) obj;
        return Intrinsics.areEqual(this.f9713a, horizontalScrollLayoutModifier.f9713a) && this.f9714b == horizontalScrollLayoutModifier.f9714b && Intrinsics.areEqual(this.f9715c, horizontalScrollLayoutModifier.f9715c) && Intrinsics.areEqual(this.f9716d, horizontalScrollLayoutModifier.f9716d);
    }

    public int hashCode() {
        return (((((this.f9713a.hashCode() * 31) + Integer.hashCode(this.f9714b)) * 31) + this.f9715c.hashCode()) * 31) + this.f9716d.hashCode();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo45measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        long j4;
        if (measurable.l0(Constraints.k(j3)) < Constraints.l(j3)) {
            j4 = j3;
        } else {
            j4 = j3;
            j3 = Constraints.d(j4, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, 13, null);
        }
        final Placeable placeableN0 = measurable.n0(j3);
        final int iMin = Math.min(placeableN0.X0(), Constraints.l(j4));
        return MeasureScope.B0(measureScope, iMin, placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.HorizontalScrollLayoutModifier$measure$1
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
                this.b().k(Orientation.f6032b, TextFieldScrollKt.c(measureScope2, iA, transformedTextD, textLayoutResultProxy != null ? textLayoutResultProxy.f() : null, measureScope.getLayoutDirection() == LayoutDirection.f30002b, placeableN0.X0()), iMin, placeableN0.X0());
                Placeable.PlacementScope.m(placementScope, placeableN0, Math.round(-this.b().d()), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.f9713a + ", cursorOffset=" + this.f9714b + ", transformedText=" + this.f9715c + ", textLayoutResultProvider=" + this.f9716d + ')';
    }
}
