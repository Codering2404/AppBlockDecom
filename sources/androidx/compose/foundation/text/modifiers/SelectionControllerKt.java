package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class SelectionControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier b(final SelectionRegistrar selectionRegistrar, final long j3, final Function0 function0) {
        TextDragObserver textDragObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f11076a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f11077b;

            {
                Offset.Companion companion = Offset.f25596b;
                this.f11076a = companion.c();
                this.f11077b = companion.c();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void b(long j4) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    if (!layoutCoordinates.m()) {
                        return;
                    }
                    selectionRegistrar2.i(layoutCoordinates, j4, SelectionAdjustment.f11264a.o(), true);
                    this.f11076a = j4;
                }
                if (SelectionRegistrarKt.b(selectionRegistrar, j3)) {
                    this.f11077b = Offset.f25596b.c();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void d(long j4) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j5 = j3;
                    if (layoutCoordinates.m() && SelectionRegistrarKt.b(selectionRegistrar2, j5)) {
                        long jQ = Offset.q(this.f11077b, j4);
                        this.f11077b = jQ;
                        long jQ2 = Offset.q(this.f11076a, jQ);
                        if (selectionRegistrar2.f(layoutCoordinates, jQ2, this.f11076a, false, SelectionAdjustment.f11264a.o(), true)) {
                            this.f11076a = jQ2;
                            this.f11077b = Offset.f25596b.c();
                        }
                    }
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                if (SelectionRegistrarKt.b(selectionRegistrar, j3)) {
                    selectionRegistrar.g();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                if (SelectionRegistrarKt.b(selectionRegistrar, j3)) {
                    selectionRegistrar.g();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void c() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void a(long j4) {
            }
        };
        return SelectionGesturesKt.m(Modifier.b8, new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f11081a = Offset.f25596b.c();

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void a() {
                selectionRegistrar.g();
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean b(long j4) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j5 = j3;
                if (!layoutCoordinates.m() || !SelectionRegistrarKt.b(selectionRegistrar2, j5)) {
                    return false;
                }
                if (!selectionRegistrar2.f(layoutCoordinates, j4, this.f11081a, false, SelectionAdjustment.f11264a.m(), false)) {
                    return true;
                }
                this.f11081a = j4;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean c(long j4, SelectionAdjustment selectionAdjustment) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j5 = j3;
                if (!layoutCoordinates.m()) {
                    return false;
                }
                selectionRegistrar2.i(layoutCoordinates, j4, selectionAdjustment, false);
                this.f11081a = j4;
                return SelectionRegistrarKt.b(selectionRegistrar2, j5);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean d(long j4, SelectionAdjustment selectionAdjustment) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j5 = j3;
                if (!layoutCoordinates.m() || !SelectionRegistrarKt.b(selectionRegistrar2, j5)) {
                    return false;
                }
                if (!selectionRegistrar2.f(layoutCoordinates, j4, this.f11081a, false, selectionAdjustment, false)) {
                    return true;
                }
                this.f11081a = j4;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public boolean e(long j4) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) function0.invoke();
                if (layoutCoordinates == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j5 = j3;
                if (!layoutCoordinates.m()) {
                    return false;
                }
                if (selectionRegistrar2.f(layoutCoordinates, j4, this.f11081a, false, SelectionAdjustment.f11264a.m(), false)) {
                    this.f11081a = j4;
                }
                return SelectionRegistrarKt.b(selectionRegistrar2, j5);
            }
        }, textDragObserver);
    }
}
