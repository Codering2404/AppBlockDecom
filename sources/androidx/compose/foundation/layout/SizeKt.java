package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.applovin.sdk.AppLovinMediationProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SizeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final FillElement f7116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final FillElement f7117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FillElement f7118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final WrapContentElement f7119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final WrapContentElement f7120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final WrapContentElement f7121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final WrapContentElement f7122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final WrapContentElement f7123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final WrapContentElement f7124i;

    static {
        FillElement.Companion companion = FillElement.f6766d;
        f7116a = companion.c(1.0f);
        f7117b = companion.a(1.0f);
        f7118c = companion.b(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.f7308g;
        Alignment.Companion companion3 = Alignment.f25072a;
        f7119d = companion2.c(companion3.g(), false);
        f7120e = companion2.c(companion3.k(), false);
        f7121f = companion2.a(companion3.i(), false);
        f7122g = companion2.a(companion3.l(), false);
        f7123h = companion2.b(companion3.e(), false);
        f7124i = companion2.b(companion3.o(), false);
    }

    public static final Modifier A(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(f3, 0.0f, f3, 0.0f, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static final Modifier B(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(f3, 0.0f, f4, 0.0f, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("widthIn");
                inspectorInfo.b().c("min", Dp.d(f3));
                inspectorInfo.b().c(AppLovinMediationProvider.MAX, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static /* synthetic */ Modifier C(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return B(modifier, f3, f4);
    }

    public static final Modifier D(Modifier modifier, Alignment.Vertical vertical, boolean z2) {
        Alignment.Companion companion = Alignment.f25072a;
        return modifier.then((!Intrinsics.areEqual(vertical, companion.i()) || z2) ? (!Intrinsics.areEqual(vertical, companion.l()) || z2) ? WrapContentElement.f7308g.a(vertical, z2) : f7122g : f7121f);
    }

    public static /* synthetic */ Modifier E(Modifier modifier, Alignment.Vertical vertical, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            vertical = Alignment.f25072a.i();
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return D(modifier, vertical, z2);
    }

    public static final Modifier F(Modifier modifier, Alignment alignment, boolean z2) {
        Alignment.Companion companion = Alignment.f25072a;
        return modifier.then((!Intrinsics.areEqual(alignment, companion.e()) || z2) ? (!Intrinsics.areEqual(alignment, companion.o()) || z2) ? WrapContentElement.f7308g.b(alignment, z2) : f7124i : f7123h);
    }

    public static /* synthetic */ Modifier G(Modifier modifier, Alignment alignment, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            alignment = Alignment.f25072a.e();
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return F(modifier, alignment, z2);
    }

    public static final Modifier H(Modifier modifier, Alignment.Horizontal horizontal, boolean z2) {
        Alignment.Companion companion = Alignment.f25072a;
        return modifier.then((!Intrinsics.areEqual(horizontal, companion.g()) || z2) ? (!Intrinsics.areEqual(horizontal, companion.k()) || z2) ? WrapContentElement.f7308g.c(horizontal, z2) : f7120e : f7119d);
    }

    public static /* synthetic */ Modifier I(Modifier modifier, Alignment.Horizontal horizontal, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            horizontal = Alignment.f25072a.g();
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return H(modifier, horizontal, z2);
    }

    public static final Modifier a(Modifier modifier, float f3, float f4) {
        return modifier.then(new UnspecifiedConstraintsElement(f3, f4, null));
    }

    public static /* synthetic */ Modifier b(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return a(modifier, f3, f4);
    }

    public static final Modifier c(Modifier modifier, float f3) {
        return modifier.then(f3 == 1.0f ? f7117b : FillElement.f6766d.a(f3));
    }

    public static /* synthetic */ Modifier d(Modifier modifier, float f3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = 1.0f;
        }
        return c(modifier, f3);
    }

    public static final Modifier e(Modifier modifier, float f3) {
        return modifier.then(f3 == 1.0f ? f7118c : FillElement.f6766d.b(f3));
    }

    public static /* synthetic */ Modifier f(Modifier modifier, float f3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = 1.0f;
        }
        return e(modifier, f3);
    }

    public static final Modifier g(Modifier modifier, float f3) {
        return modifier.then(f3 == 1.0f ? f7116a : FillElement.f6766d.c(f3));
    }

    public static /* synthetic */ Modifier h(Modifier modifier, float f3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = 1.0f;
        }
        return g(modifier, f3);
    }

    public static final Modifier i(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(0.0f, f3, 0.0f, f3, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static final Modifier j(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(0.0f, f3, 0.0f, f4, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("heightIn");
                inspectorInfo.b().c("min", Dp.d(f3));
                inspectorInfo.b().c(AppLovinMediationProvider.MAX, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static /* synthetic */ Modifier k(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return j(modifier, f3, f4);
    }

    public static final Modifier l(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(0.0f, f3, 0.0f, f3, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredHeight");
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static final Modifier m(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(0.0f, f3, 0.0f, f4, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredHeightIn");
                inspectorInfo.b().c("min", Dp.d(f3));
                inspectorInfo.b().c(AppLovinMediationProvider.MAX, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 5, null));
    }

    public static /* synthetic */ Modifier n(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return m(modifier, f3, f4);
    }

    public static final Modifier o(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(f3, f3, f3, f3, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredSize");
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static final Modifier p(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(f3, f4, f3, f4, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredSize");
                inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Dp.d(f3));
                inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static final Modifier q(Modifier modifier, final float f3, final float f4, final float f5, final float f6) {
        return modifier.then(new SizeElement(f3, f4, f5, f6, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredSizeIn");
                inspectorInfo.b().c("minWidth", Dp.d(f3));
                inspectorInfo.b().c("minHeight", Dp.d(f4));
                inspectorInfo.b().c("maxWidth", Dp.d(f5));
                inspectorInfo.b().c("maxHeight", Dp.d(f6));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static /* synthetic */ Modifier r(Modifier modifier, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.f29970b.c();
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.f29970b.c();
        }
        return q(modifier, f3, f4, f5, f6);
    }

    public static final Modifier s(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(f3, 0.0f, f3, 0.0f, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredWidth");
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static final Modifier t(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(f3, 0.0f, f4, 0.0f, false, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("requiredWidthIn");
                inspectorInfo.b().c("min", Dp.d(f3));
                inspectorInfo.b().c(AppLovinMediationProvider.MAX, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), 10, null));
    }

    public static /* synthetic */ Modifier u(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return t(modifier, f3, f4);
    }

    public static final Modifier v(Modifier modifier, final float f3) {
        return modifier.then(new SizeElement(f3, f3, f3, f3, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("size");
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static final Modifier w(Modifier modifier, long j3) {
        return x(modifier, DpSize.j(j3), DpSize.i(j3));
    }

    public static final Modifier x(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new SizeElement(f3, f4, f3, f4, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("size");
                inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Dp.d(f3));
                inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static final Modifier y(Modifier modifier, final float f3, final float f4, final float f5, final float f6) {
        return modifier.then(new SizeElement(f3, f4, f5, f6, true, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("sizeIn");
                inspectorInfo.b().c("minWidth", Dp.d(f3));
                inspectorInfo.b().c("minHeight", Dp.d(f4));
                inspectorInfo.b().c("maxWidth", Dp.d(f5));
                inspectorInfo.b().c("maxHeight", Dp.d(f6));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static /* synthetic */ Modifier z(Modifier modifier, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.f29970b.c();
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.f29970b.c();
        }
        return y(modifier, f3, f4, f5, f6);
    }
}
