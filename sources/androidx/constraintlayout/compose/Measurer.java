package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.collection.IntIntPair;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class Measurer implements BasicMeasure.Measurer, DesignInfoProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30639a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInformationReceiver f30640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstraintWidgetContainer f30641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f30642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f30643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f30644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final State f30645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f30646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f30647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f30648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f30649k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30650a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30650a = iArr;
        }
    }

    public Measurer(Density density) {
        ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer(0, 0);
        constraintWidgetContainer.e2(this);
        this.f30641c = constraintWidgetContainer;
        this.f30642d = new LinkedHashMap();
        this.f30643e = new LinkedHashMap();
        this.f30644f = new LinkedHashMap();
        this.f30645g = new State(density);
        this.f30646h = new int[2];
        this.f30647i = new int[2];
        this.f30648j = Float.NaN;
        this.f30649k = new ArrayList();
    }

    private final void f(Integer[] numArr, BasicMeasure.Measure measure) {
        numArr[0] = Integer.valueOf(measure.f32414e);
        numArr[1] = Integer.valueOf(measure.f32415f);
        numArr[2] = Integer.valueOf(measure.f32416g);
    }

    private final long j(String str, long j3) {
        if (str != null && StringsKt.Y0(str, '#', false, 2, null)) {
            String strSubstring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (strSubstring.length() == 6) {
                strSubstring = "FF" + strSubstring;
            }
            try {
                return ColorKt.b((int) Long.parseLong(strSubstring, 16));
            } catch (Exception unused) {
            }
        }
        return j3;
    }

    static /* synthetic */ long k(Measurer measurer, String str, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor-wrIjXm8");
        }
        if ((i3 & 2) != 0) {
            j3 = Color.f25715b.a();
        }
        return measurer.j(str, j3);
    }

    private final TextStyle t(HashMap map) {
        String str = (String) map.get("size");
        long jA = TextUnit.f30006b.a();
        if (str != null) {
            jA = TextUnitKt.h(Float.parseFloat(str));
        }
        return new TextStyle(k(this, (String) map.get("color"), 0L, 2, null), jA, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
    }

    private final long u(ConstraintWidget constraintWidget, long j3) {
        Object objU = constraintWidget.u();
        String str = constraintWidget.f32299o;
        int i3 = 0;
        if (constraintWidget instanceof VirtualLayout) {
            int i4 = Constraints.j(j3) ? 1073741824 : Constraints.h(j3) ? Integer.MIN_VALUE : 0;
            if (Constraints.i(j3)) {
                i3 = 1073741824;
            } else if (Constraints.g(j3)) {
                i3 = Integer.MIN_VALUE;
            }
            VirtualLayout virtualLayout = (VirtualLayout) constraintWidget;
            virtualLayout.J1(i4, Constraints.l(j3), i3, Constraints.k(j3));
            return IntIntPair.b(virtualLayout.E1(), virtualLayout.D1());
        }
        if (objU instanceof Measurable) {
            Placeable placeableN0 = ((Measurable) objU).n0(j3);
            this.f30642d.put(objU, placeableN0);
            return IntIntPair.b(placeableN0.X0(), placeableN0.O0());
        }
        Log.w("CCL", "Nothing to measure for widget: " + str);
        return IntIntPair.b(0, 0);
    }

    private final boolean v(ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i3, int i4, int i5, boolean z2, boolean z3, int i6, int[] iArr) {
        int i7 = WhenMappings.f30650a[dimensionBehaviour.ordinal()];
        if (i7 == 1) {
            iArr[0] = i3;
            iArr[1] = i3;
            return false;
        }
        if (i7 == 2) {
            iArr[0] = 0;
            iArr[1] = i6;
            return true;
        }
        if (i7 != 3) {
            if (i7 == 4) {
                iArr[0] = i6;
                iArr[1] = i6;
                return false;
            }
            throw new IllegalStateException((dimensionBehaviour + " is not supported").toString());
        }
        if (ConstraintLayoutKt.f30437a) {
            Log.d("CCL", "Measure strategy " + i5);
            Log.d("CCL", "DW " + i4);
            Log.d("CCL", "ODR " + z2);
            Log.d("CCL", "IRH " + z3);
        }
        boolean z4 = z3 || ((i5 == BasicMeasure.Measure.f32408l || i5 == BasicMeasure.Measure.f32409m) && (i5 == BasicMeasure.Measure.f32409m || i4 != 1 || z2));
        if (ConstraintLayoutKt.f30437a) {
            Log.d("CCL", "UD " + z4);
        }
        iArr[0] = z4 ? i3 : 0;
        if (!z4) {
            i3 = i6;
        }
        iArr[1] = i3;
        return !z4;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(androidx.constraintlayout.core.widgets.ConstraintWidget r20, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r21) {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.Measurer.b(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
    }

    public final void c(LayoutInformationReceiver layoutInformationReceiver) {
        this.f30640b = layoutInformationReceiver;
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.i(this.f30639a);
        }
    }

    protected final void d(long j3) {
        this.f30641c.r1(Constraints.l(j3));
        this.f30641c.S0(Constraints.k(j3));
        this.f30648j = Float.NaN;
        LayoutInformationReceiver layoutInformationReceiver = this.f30640b;
        if (layoutInformationReceiver != null && (layoutInformationReceiver == null || layoutInformationReceiver.p() != Integer.MIN_VALUE)) {
            LayoutInformationReceiver layoutInformationReceiver2 = this.f30640b;
            Intrinsics.checkNotNull(layoutInformationReceiver2);
            int iP = layoutInformationReceiver2.p();
            if (iP > this.f30641c.a0()) {
                this.f30648j = this.f30641c.a0() / iP;
            } else {
                this.f30648j = 1.0f;
            }
            this.f30641c.r1(iP);
        }
        LayoutInformationReceiver layoutInformationReceiver3 = this.f30640b;
        if (layoutInformationReceiver3 != null) {
            if (layoutInformationReceiver3 == null || layoutInformationReceiver3.g() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver4 = this.f30640b;
                Intrinsics.checkNotNull(layoutInformationReceiver4);
                int iG = layoutInformationReceiver4.g();
                if (Float.isNaN(this.f30648j)) {
                    this.f30648j = 1.0f;
                }
                float fZ = iG > this.f30641c.z() ? this.f30641c.z() / iG : 1.0f;
                if (fZ < this.f30648j) {
                    this.f30648j = fZ;
                }
                this.f30641c.S0(iG);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v10 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(androidx.compose.runtime.Composer r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.Measurer.g(androidx.compose.runtime.Composer, int):void");
    }

    public final void h(final BoxScope boxScope, final float f3, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2126574786);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2126574786, i4, -1, "androidx.constraintlayout.compose.Measurer.drawDebugBounds (ConstraintLayout.kt:2069)");
            }
            Modifier modifierH = boxScope.h(Modifier.b8);
            boolean zI = ((i4 & 112) == 32) | composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$drawDebugBounds$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        this.f30654a.i(drawScope, f3);
                    }
                };
                composerK.w(objG);
            }
            CanvasKt.b(modifierH, (Function1) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$drawDebugBounds$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    this.f30656a.h(boxScope, f3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public final void i(DrawScope drawScope, float f3) {
        float fO = o() * f3;
        float fN = n() * f3;
        float fI = (Size.i(drawScope.b()) - fO) / 2.0f;
        float fG = (Size.g(drawScope.b()) - fN) / 2.0f;
        Color.Companion companion = Color.f25715b;
        long jL = companion.l();
        float f4 = fI + fO;
        DrawScope.L0(drawScope, jL, OffsetKt.a(fI, fG), OffsetKt.a(f4, fG), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        long jA = OffsetKt.a(f4, fG);
        float f5 = fG + fN;
        DrawScope.L0(drawScope, jL, jA, OffsetKt.a(f4, f5), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.L0(drawScope, jL, OffsetKt.a(f4, f5), OffsetKt.a(fI, f5), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.L0(drawScope, jL, OffsetKt.a(fI, f5), OffsetKt.a(fI, fG), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        float f6 = 1;
        float f7 = fI + f6;
        float f8 = fG + f6;
        long jA2 = companion.a();
        float f9 = f7 + fO;
        DrawScope.L0(drawScope, jA2, OffsetKt.a(f7, f8), OffsetKt.a(f9, f8), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        float f10 = f8 + fN;
        DrawScope.L0(drawScope, jA2, OffsetKt.a(f9, f8), OffsetKt.a(f9, f10), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.L0(drawScope, jA2, OffsetKt.a(f9, f10), OffsetKt.a(f7, f10), 0.0f, 0, null, 0.0f, null, 0, 504, null);
        DrawScope.L0(drawScope, jA2, OffsetKt.a(f7, f10), OffsetKt.a(f7, f8), 0.0f, 0, null, 0.0f, null, 0, 504, null);
    }

    public final float l() {
        return this.f30648j;
    }

    protected final Map m() {
        return this.f30644f;
    }

    public final int n() {
        return this.f30641c.z();
    }

    public final int o() {
        return this.f30641c.a0();
    }

    protected final LayoutInformationReceiver p() {
        return this.f30640b;
    }

    protected final Map q() {
        return this.f30642d;
    }

    protected final ConstraintWidgetContainer r() {
        return this.f30641c;
    }

    protected final State s() {
        return this.f30645g;
    }

    public final void w(Placeable.PlacementScope placementScope, List list) {
        Measurable measurable;
        Placeable placeable;
        Placeable.PlacementScope placementScope2;
        int i3 = 0;
        if (this.f30644f.isEmpty()) {
            ArrayList arrayListZ1 = this.f30641c.z1();
            int size = arrayListZ1.size();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i4);
                Object objU = constraintWidget.u();
                if (objU instanceof Measurable) {
                    this.f30644f.put(objU, new WidgetFrame(constraintWidget.f32297n.v()));
                }
            }
        }
        int size2 = list.size();
        while (true) {
            if (i3 >= size2) {
                LayoutInformationReceiver layoutInformationReceiver = this.f30640b;
                if ((layoutInformationReceiver != null ? layoutInformationReceiver.j() : null) == LayoutInfoFlags.BOUNDS) {
                    e();
                    return;
                }
                return;
            }
            Measurable measurable2 = (Measurable) list.get(i3);
            if (this.f30644f.containsKey(measurable2)) {
                measurable = measurable2;
            } else {
                Iterator it = this.f30644f.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Measurable measurable3 = (Measurable) next;
                    if (LayoutIdKt.a(measurable3) != null && Intrinsics.areEqual(LayoutIdKt.a(measurable3), LayoutIdKt.a(measurable2))) {
                        obj = next;
                        break;
                    }
                }
                measurable = (Measurable) obj;
                if (measurable == null) {
                    placementScope2 = placementScope;
                }
                i3++;
                placementScope = placementScope2;
            }
            WidgetFrame widgetFrame = (WidgetFrame) this.f30644f.get(measurable);
            if (widgetFrame == null || (placeable = (Placeable) this.f30642d.get(measurable)) == null) {
                return;
            }
            if (this.f30644f.containsKey(measurable2)) {
                placementScope2 = placementScope;
                ConstraintLayoutKt.o(placementScope2, placeable, widgetFrame, 0L, 4, null);
            } else {
                placementScope2 = placementScope;
                ConstraintLayoutKt.o(placementScope2, measurable2.n0(Constraints.f29963b.c(placeable.X0(), placeable.O0())), widgetFrame, 0L, 4, null);
            }
            i3++;
            placementScope = placementScope2;
        }
    }

    public final long x(long j3, LayoutDirection layoutDirection, ConstraintSet constraintSet, List list, int i3) {
        String string;
        Object objA;
        if (list.isEmpty()) {
            return IntSizeKt.a(Constraints.n(j3), Constraints.m(j3));
        }
        this.f30645g.E(Constraints.j(j3) ? androidx.constraintlayout.core.state.Dimension.b(Constraints.l(j3)) : androidx.constraintlayout.core.state.Dimension.h().o(Constraints.n(j3)));
        this.f30645g.m(Constraints.i(j3) ? androidx.constraintlayout.core.state.Dimension.b(Constraints.k(j3)) : androidx.constraintlayout.core.state.Dimension.h().o(Constraints.m(j3)));
        this.f30645g.f32033f.E().a(this.f30645g, this.f30641c, 0);
        this.f30645g.f32033f.C().a(this.f30645g, this.f30641c, 1);
        this.f30645g.I(j3);
        this.f30645g.z(layoutDirection == LayoutDirection.f30002b);
        y();
        if (constraintSet.b(list)) {
            this.f30645g.u();
            constraintSet.a(this.f30645g, list);
            ConstraintLayoutKt.l(this.f30645g, list);
            this.f30645g.a(this.f30641c);
        } else {
            ConstraintLayoutKt.l(this.f30645g, list);
        }
        d(j3);
        this.f30641c.j2();
        if (ConstraintLayoutKt.f30437a) {
            this.f30641c.J0("ConstraintLayout");
            ArrayList arrayListZ1 = this.f30641c.z1();
            int size = arrayListZ1.size();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i4);
                Object objU = constraintWidget.u();
                Measurable measurable = objU instanceof Measurable ? (Measurable) objU : null;
                if (measurable == null || (objA = LayoutIdKt.a(measurable)) == null || (string = objA.toString()) == null) {
                    string = "NOTAG";
                }
                constraintWidget.J0(string);
            }
            Log.d("CCL", "ConstraintLayout is asked to measure with " + ((Object) Constraints.q(j3)));
            Log.d("CCL", ConstraintLayoutKt.p(this.f30641c));
            ArrayList arrayListZ12 = this.f30641c.z1();
            int size2 = arrayListZ12.size();
            for (int i5 = 0; i5 < size2; i5++) {
                Log.d("CCL", ConstraintLayoutKt.p((ConstraintWidget) arrayListZ12.get(i5)));
            }
        }
        this.f30641c.f2(i3);
        ConstraintWidgetContainer constraintWidgetContainer = this.f30641c;
        constraintWidgetContainer.a2(constraintWidgetContainer.S1(), 0, 0, 0, 0, 0, 0, 0, 0);
        if (ConstraintLayoutKt.f30437a) {
            Log.d("CCL", "ConstraintLayout is at the end " + this.f30641c.a0() + ' ' + this.f30641c.z());
        }
        return IntSizeKt.a(this.f30641c.a0(), this.f30641c.z());
    }

    public final void y() {
        this.f30642d.clear();
        this.f30643e.clear();
        this.f30644f.clear();
    }

    public void e() {
        ConstraintWidget constraintWidget;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("  right:   ");
        sb2.append(this.f30641c.a0());
        String str = pMpIcGE.SCaoMZoTPNU;
        sb2.append(str);
        sb.append(sb2.toString());
        sb.append("  bottom:  " + this.f30641c.z() + str);
        sb.append(" } }");
        ArrayList arrayListZ1 = this.f30641c.z1();
        int size = arrayListZ1.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListZ1.get(i3);
            i3++;
            ConstraintWidget constraintWidget2 = (ConstraintWidget) obj;
            Object objU = constraintWidget2.u();
            if (objU instanceof Measurable) {
                WidgetFrame widgetFrame = null;
                if (constraintWidget2.f32299o == null) {
                    Measurable measurable = (Measurable) objU;
                    Object objA = LayoutIdKt.a(measurable);
                    if (objA == null) {
                        objA = ConstraintLayoutTagKt.a(measurable);
                    }
                    constraintWidget2.f32299o = objA != null ? objA.toString() : null;
                }
                WidgetFrame widgetFrame2 = (WidgetFrame) this.f30644f.get(objU);
                if (widgetFrame2 != null && (constraintWidget = widgetFrame2.f32150a) != null) {
                    widgetFrame = constraintWidget.f32297n;
                }
                if (widgetFrame != null) {
                    sb.append(' ' + constraintWidget2.f32299o + ": {");
                    sb.append(" interpolated : ");
                    widgetFrame.p(sb, true);
                    sb.append("}, ");
                }
            } else if (constraintWidget2 instanceof Guideline) {
                sb.append(' ' + constraintWidget2.f32299o + ": {");
                Guideline guideline = (Guideline) constraintWidget2;
                if (guideline.z1() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + guideline.b0() + ", top: " + guideline.c0() + ", right: " + (guideline.b0() + guideline.a0()) + ", bottom: " + (guideline.c0() + guideline.z()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String string = sb.toString();
        this.f30639a = string;
        LayoutInformationReceiver layoutInformationReceiver = this.f30640b;
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.i(string);
        }
    }
}
