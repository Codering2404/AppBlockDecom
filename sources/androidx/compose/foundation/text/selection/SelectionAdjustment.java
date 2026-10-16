package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface SelectionAdjustment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f11264a = Companion.f11265a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f11265a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final SelectionAdjustment f11266b = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.a
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            public final Selection a(SelectionLayout selectionLayout) {
                return SelectionAdjustment.Companion.h(selectionLayout);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final SelectionAdjustment f11267c = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.b
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            public final Selection a(SelectionLayout selectionLayout) {
                return SelectionAdjustment.Companion.f(selectionLayout);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final SelectionAdjustment f11268d = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.c
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            public final Selection a(SelectionLayout selectionLayout) {
                return SelectionAdjustment.Companion.j(selectionLayout);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final SelectionAdjustment f11269e = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.d
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            public final Selection a(SelectionLayout selectionLayout) {
                return SelectionAdjustment.Companion.i(selectionLayout);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final SelectionAdjustment f11270f = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.e
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            public final Selection a(SelectionLayout selectionLayout) {
                return SelectionAdjustment.Companion.g(selectionLayout);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection f(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.h(f11266b.a(selectionLayout), selectionLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection g(SelectionLayout selectionLayout) {
            Selection.AnchorInfo anchorInfoC;
            Selection.AnchorInfo anchorInfoL;
            Selection.AnchorInfo anchorInfoE;
            Selection.AnchorInfo anchorInfoC2;
            Selection selectionG = selectionLayout.g();
            if (selectionG == null) {
                return f11268d.a(selectionLayout);
            }
            if (selectionLayout.a()) {
                anchorInfoC = selectionG.e();
                anchorInfoL = SelectionAdjustmentKt.l(selectionLayout, selectionLayout.k(), anchorInfoC);
                anchorInfoC2 = selectionG.c();
                anchorInfoE = anchorInfoL;
            } else {
                anchorInfoC = selectionG.c();
                anchorInfoL = SelectionAdjustmentKt.l(selectionLayout, selectionLayout.j(), anchorInfoC);
                anchorInfoE = selectionG.e();
                anchorInfoC2 = anchorInfoL;
            }
            if (Intrinsics.areEqual(anchorInfoL, anchorInfoC)) {
                return selectionG;
            }
            return SelectionAdjustmentKt.h(new Selection(anchorInfoE, anchorInfoC2, selectionLayout.e() == CrossStatus.f11212a || (selectionLayout.e() == CrossStatus.f11214c && anchorInfoE.d() > anchorInfoC2.d())), selectionLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection h(SelectionLayout selectionLayout) {
            return new Selection(selectionLayout.k().a(selectionLayout.k().g()), selectionLayout.j().a(selectionLayout.j().e()), selectionLayout.e() == CrossStatus.f11212a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection i(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.e(selectionLayout, new BoundaryFunction() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1$1
                @Override // androidx.compose.foundation.text.selection.BoundaryFunction
                public final long a(SelectableInfo selectableInfo, int i3) {
                    return StringHelpersKt.c(selectableInfo.c(), i3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Selection j(SelectionLayout selectionLayout) {
            return SelectionAdjustmentKt.e(selectionLayout, new BoundaryFunction() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1$1
                @Override // androidx.compose.foundation.text.selection.BoundaryFunction
                public final long a(SelectableInfo selectableInfo, int i3) {
                    return selectableInfo.k().C(i3);
                }
            });
        }

        public final SelectionAdjustment k() {
            return f11267c;
        }

        public final SelectionAdjustment l() {
            return f11270f;
        }

        public final SelectionAdjustment m() {
            return f11266b;
        }

        public final SelectionAdjustment n() {
            return f11269e;
        }

        public final SelectionAdjustment o() {
            return f11268d;
        }
    }

    Selection a(SelectionLayout selectionLayout);
}
