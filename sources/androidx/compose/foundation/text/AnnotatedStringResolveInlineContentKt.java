package androidx.compose.foundation.text;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class AnnotatedStringResolveInlineContentKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pair f9048a = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    public static final void a(final AnnotatedString annotatedString, final List list, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1794596951);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(annotatedString) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(list) ? 32 : 16;
        }
        int i5 = 0;
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1794596951, i4, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:67)");
            }
            int size = list.size();
            int i6 = 0;
            while (i6 < size) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i6);
                Function3 function3 = (Function3) range.a();
                int iB = range.b();
                int iC = range.c();
                AnnotatedStringResolveInlineContentKt$InlineChildren$1$2 annotatedStringResolveInlineContentKt$InlineChildren$1$2 = new MeasurePolicy() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$InlineChildren$1$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list2, long j3) {
                        final ArrayList arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i7 = 0; i7 < size2; i7++) {
                            arrayList.add(((Measurable) list2.get(i7)).n0(j3));
                        }
                        return MeasureScope.B0(measureScope, Constraints.l(j3), Constraints.k(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$InlineChildren$1$2.1
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
                                List list3 = arrayList;
                                int size3 = list3.size();
                                for (int i8 = 0; i8 < size3; i8++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list3.get(i8), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                Modifier.Companion companion = Modifier.b8;
                int iA = ComposablesKt.a(composerK, i5);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                int i7 = i5;
                Updater.e(composerA, annotatedStringResolveInlineContentKt$InlineChildren$1$2, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                function3.invoke(annotatedString.subSequence(iB, iC).k(), composerK, Integer.valueOf(i7));
                composerK.y();
                i6++;
                i5 = i7;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$InlineChildren$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    AnnotatedStringResolveInlineContentKt.a(annotatedString, list, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final boolean b(AnnotatedString annotatedString) {
        return annotatedString.p("androidx.compose.foundation.text.inlineContent", 0, annotatedString.k().length());
    }

    public static final Pair c(AnnotatedString annotatedString, Map map) {
        if (map == null || map.isEmpty()) {
            return f9048a;
        }
        List listJ = annotatedString.j("androidx.compose.foundation.text.inlineContent", 0, annotatedString.k().length());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = listJ.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) listJ.get(i3);
            InlineTextContent inlineTextContent = (InlineTextContent) map.get(range.g());
            if (inlineTextContent != null) {
                arrayList.add(new AnnotatedString.Range(inlineTextContent.b(), range.h(), range.f()));
                arrayList2.add(new AnnotatedString.Range(inlineTextContent.a(), range.h(), range.f()));
            }
        }
        return new Pair(arrayList, arrayList2);
    }
}
