package androidx.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

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
public final class ProgressIndicatorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f13494a = ProgressIndicatorDefaults.f13491a.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f13495b = Dp.g(240);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f13496c = Dp.g(40);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CubicBezierEasing f13497d = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CubicBezierEasing f13498e = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CubicBezierEasing f13499f = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CubicBezierEasing f13500g = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final CubicBezierEasing f13501h = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    private static final void I(DrawScope drawScope, float f3, float f4, long j3, Stroke stroke) {
        float f5 = 2;
        float f6 = stroke.f() / f5;
        float fI = Size.i(drawScope.b()) - (f5 * f6);
        DrawScope.F0(drawScope, j3, f3, f4, false, OffsetKt.a(f6, f6), SizeKt.a(fI, fI), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DrawScope drawScope, long j3, Stroke stroke) {
        I(drawScope, 0.0f, 360.0f, j3, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(DrawScope drawScope, float f3, float f4, long j3, Stroke stroke) {
        I(drawScope, f3, f4, j3, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(DrawScope drawScope, float f3, float f4, float f5, long j3, Stroke stroke) {
        I(drawScope, f3 + (StrokeCap.g(stroke.b(), StrokeCap.f25935b.a()) ? 0.0f : ((f4 / Dp.g(f13496c / 2)) * 57.29578f) / 2.0f), Math.max(f5, 0.1f), j3, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(DrawScope drawScope, float f3, float f4, long j3, float f5, int i3) {
        float fI = Size.i(drawScope.b());
        float fG = Size.g(drawScope.b());
        float f6 = 2;
        float f7 = fG / f6;
        boolean z2 = drawScope.getLayoutDirection() == LayoutDirection.f30001a;
        float f8 = (z2 ? f3 : 1.0f - f4) * fI;
        float f9 = (z2 ? f4 : 1.0f - f3) * fI;
        if (StrokeCap.g(i3, StrokeCap.f25935b.a()) || fG > fI) {
            DrawScope.L0(drawScope, j3, OffsetKt.a(f8, f7), OffsetKt.a(f9, f7), f5, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f10 = f5 / f6;
        ClosedFloatingPointRange closedFloatingPointRangeB = RangesKt.b(f10, fI - f10);
        float fFloatValue = ((Number) RangesKt.u(Float.valueOf(f8), closedFloatingPointRangeB)).floatValue();
        float fFloatValue2 = ((Number) RangesKt.u(Float.valueOf(f9), closedFloatingPointRangeB)).floatValue();
        if (Math.abs(f4 - f3) > 0.0f) {
            DrawScope.L0(drawScope, j3, OffsetKt.a(fFloatValue, f7), OffsetKt.a(fFloatValue2, f7), f5, i3, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(DrawScope drawScope, long j3, float f3, int i3) {
        M(drawScope, 0.0f, 1.0f, j3, f3, i3);
    }

    public static final Modifier O(Modifier modifier) {
        final float fG = Dp.g(10);
        return PaddingKt.k(SemanticsModifierKt.e(LayoutModifierKt.a(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m131invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m131invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                final int iZ0 = measureScope.z0(fG);
                int i3 = iZ0 * 2;
                final Placeable placeableN0 = measurable.n0(ConstraintsKt.i(j3, 0, i3));
                return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0() - i3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$1.1
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
                        Placeable.PlacementScope.i(placementScope, placeableN0, 0, -iZ0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$increaseSemanticsBounds$2
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }
        }), 0.0f, fG, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0124  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final float r25, androidx.compose.ui.Modifier r26, long r27, float r29, long r30, int r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.a(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0277  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.ui.Modifier r30, long r31, float r33, long r34, int r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.b(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void c(final float r18, androidx.compose.ui.Modifier r19, long r20, float r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.c(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void d(androidx.compose.ui.Modifier r16, long r17, float r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.d(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(State state) {
        return ((Number) state.getValue()).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ce A[PHI: r10
      0x01ce: PHI (r10v16 long) = (r10v14 long), (r10v17 long) binds: [B:89:0x01cc, B:85:0x01c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(androidx.compose.ui.Modifier r36, long r37, long r39, int r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.i(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final /* synthetic */ void j(Modifier modifier, long j3, long j4, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long j5;
        long j6;
        long jR;
        long j7;
        Modifier modifier3;
        final Modifier modifier4;
        final long j8;
        final long j9;
        int i6;
        Composer composerK = composer.k(-819397058);
        int i7 = i4 & 1;
        if (i7 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            if ((i4 & 2) == 0) {
                j5 = j3;
                int i8 = composerK.f(j5) ? 32 : 16;
                i5 |= i8;
            } else {
                j5 = j3;
            }
            i5 |= i8;
        } else {
            j5 = j3;
        }
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                j6 = j4;
                if (composerK.f(j6)) {
                    i6 = Function.MAX_NARGS;
                }
                i5 |= i6;
            } else {
                j6 = j4;
            }
            i6 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            i5 |= i6;
        } else {
            j6 = j4;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            modifier4 = modifier2;
            j8 = j5;
            j9 = j6;
        } else {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                Modifier modifier5 = i7 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 2) != 0) {
                    j5 = MaterialTheme.f13091a.a(composerK, 6).j();
                    i5 &= -113;
                }
                long j10 = j5;
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                    modifier3 = modifier5;
                    jR = Color.r(j10, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                    j7 = j10;
                } else {
                    jR = j6;
                    j7 = j10;
                    modifier3 = modifier5;
                }
            } else {
                composerK.Q();
                if ((i4 & 2) != 0) {
                    i5 &= -113;
                }
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                jR = j6;
                modifier3 = modifier2;
                j7 = j5;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-819397058, i5, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:242)");
            }
            i(modifier3, j7, jR, StrokeCap.f25935b.a(), composerK, i5 & 1022, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier4 = modifier3;
            j8 = j7;
            j9 = jR;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    ProgressIndicatorKt.j(modifier4, j8, j9, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final float r24, androidx.compose.ui.Modifier r25, long r26, long r28, int r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.k(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void l(final float r24, androidx.compose.ui.Modifier r25, long r26, long r28, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.l(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float m(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float n(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(State state) {
        return ((Number) state.getValue()).floatValue();
    }
}
