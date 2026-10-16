package androidx.glance.appwidget;

import android.os.Build;
import android.os.Bundle;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.Applier;
import androidx.glance.appwidget.SizeMode;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

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
public final class SizeBoxKt {
    public static final void a(final SizeMode sizeMode, final long j3, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Function2 function22;
        Set setA;
        List listD;
        SizeMode sizeMode2 = sizeMode;
        Composer composerK = composer.k(1526030150);
        if ((i3 & 14) == 0) {
            i4 = (composerK.Z(sizeMode2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            function22 = function2;
            i4 |= composerK.Z(function22) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function22 = function2;
        }
        int i5 = i4;
        if ((i5 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1526030150, i5, -1, "androidx.glance.appwidget.ForEachSize (SizeBox.kt:90)");
            }
            if (sizeMode2 instanceof SizeMode.Single) {
                composerK.F(1209069742);
                composerK.Y();
                setA = CollectionsKt.listOf(DpSize.c(j3));
            } else if (sizeMode2 instanceof SizeMode.Exact) {
                composerK.F(1209069787);
                if (Build.VERSION.SDK_INT >= 31) {
                    composerK.F(1209069839);
                    Bundle bundle = (Bundle) composerK.q(CompositionLocalsKt.a());
                    DpSize dpSizeC = DpSize.c(j3);
                    composerK.F(1157296644);
                    boolean Z = composerK.Z(dpSizeC);
                    Object objG = composerK.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0<DpSize>() { // from class: androidx.glance.appwidget.SizeBoxKt$ForEachSize$sizes$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final long c() {
                                return j3;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                return DpSize.c(c());
                            }
                        };
                        composerK.w(objG);
                    }
                    composerK.Y();
                    listD = AppWidgetUtilsKt.d(bundle, (Function0) objG);
                    composerK.Y();
                } else {
                    composerK.F(1209069926);
                    List listF = AppWidgetUtilsKt.f((Bundle) composerK.q(CompositionLocalsKt.a()));
                    if (listF.isEmpty()) {
                        listF = CollectionsKt.listOf(DpSize.c(j3));
                    }
                    listD = listF;
                    composerK.Y();
                }
                composerK.Y();
                setA = listD;
            } else {
                if (!(sizeMode2 instanceof SizeMode.Responsive)) {
                    composerK.F(1209066450);
                    composerK.Y();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.F(1209070085);
                if (Build.VERSION.SDK_INT >= 31) {
                    setA = ((SizeMode.Responsive) sizeMode2).a();
                } else {
                    SizeMode.Responsive responsive = (SizeMode.Responsive) sizeMode2;
                    long jM = ((DpSize) AppWidgetUtilsKt.n(responsive.a()).get(0)).m();
                    List listF2 = AppWidgetUtilsKt.f((Bundle) composerK.q(CompositionLocalsKt.a()));
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listF2, 10));
                    Iterator it = listF2.iterator();
                    while (it.hasNext()) {
                        DpSize dpSizeH = AppWidgetUtilsKt.h(((DpSize) it.next()).m(), responsive.a());
                        arrayList.add(DpSize.c(dpSizeH != null ? dpSizeH.m() : jM));
                    }
                    if (arrayList.isEmpty()) {
                        arrayList = CollectionsKt.listOf((Object[]) new DpSize[]{DpSize.c(jM), DpSize.c(jM)});
                    }
                    setA = arrayList;
                }
                composerK.Y();
            }
            List listDistinct = CollectionsKt.distinct(setA);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDistinct, 10));
            Iterator it2 = listDistinct.iterator();
            while (it2.hasNext()) {
                b(((DpSize) it2.next()).m(), sizeMode2, function22, composerK, ((i5 << 3) & 112) | (i5 & 896));
                arrayList2.add(Unit.f139807a);
                sizeMode2 = sizeMode;
                function22 = function2;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$ForEachSize$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                SizeBoxKt.a(sizeMode, j3, function2, composer2, i3 | 1);
            }
        });
    }

    public static final void b(final long j3, final SizeMode sizeMode, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-53921383);
        if ((i3 & 14) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= composerK.Z(sizeMode) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= composerK.Z(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        final int i5 = i4;
        if ((i5 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-53921383, i5, -1, "androidx.glance.appwidget.SizeBox (SizeBox.kt:68)");
            }
            CompositionLocalKt.c(new ProvidedValue[]{androidx.glance.CompositionLocalsKt.d().d(DpSize.c(j3))}, ComposableLambdaKt.b(composerK, -1209815847, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1

                /* JADX INFO: renamed from: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<EmittableSizeBox> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final AnonymousClass1 f38444a = new AnonymousClass1();

                    AnonymousClass1() {
                        super(0, EmittableSizeBox.class, "<init>", "<init>()V", 0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
                    public final EmittableSizeBox invoke() {
                        return new EmittableSizeBox();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    if ((i6 & 11) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1209815847, i6, -1, "androidx.glance.appwidget.SizeBox.<anonymous> (SizeBox.kt:73)");
                    }
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.f38444a;
                    long j4 = j3;
                    SizeMode sizeMode2 = sizeMode;
                    Function2 function22 = function2;
                    int i7 = i5;
                    composer2.F(578571862);
                    int i8 = i7 & 896;
                    composer2.F(-548224868);
                    if (!(composer2.m() instanceof Applier)) {
                        ComposablesKt.c();
                    }
                    composer2.o();
                    if (composer2.i()) {
                        composer2.P(anonymousClass1);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, DpSize.c(j4), new Function2<EmittableSizeBox, DpSize, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$2$1
                        public final void c(EmittableSizeBox emittableSizeBox, long j5) {
                            emittableSizeBox.j(j5);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            c((EmittableSizeBox) obj, ((DpSize) obj2).m());
                            return Unit.f139807a;
                        }
                    });
                    Updater.e(composerA, sizeMode2, new Function2<EmittableSizeBox, SizeMode, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$1$2$2
                        public final void c(EmittableSizeBox emittableSizeBox, SizeMode sizeMode3) {
                            emittableSizeBox.k(sizeMode3);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            c((EmittableSizeBox) obj, (SizeMode) obj2);
                            return Unit.f139807a;
                        }
                    });
                    function22.invoke(composer2, Integer.valueOf((i8 >> 6) & 14));
                    composer2.y();
                    composer2.Y();
                    composer2.Y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }), composerK, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.SizeBoxKt$SizeBox$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                SizeBoxKt.b(j3, sizeMode, function2, composer2, i3 | 1);
            }
        });
    }
}
