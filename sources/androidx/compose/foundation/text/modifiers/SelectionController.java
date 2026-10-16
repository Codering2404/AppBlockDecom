package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class SelectionController implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SelectionRegistrar f11068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f11069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StaticTextSelectionParams f11070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Selectable f11071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Modifier f11072g;

    public /* synthetic */ SelectionController(long j3, SelectionRegistrar selectionRegistrar, long j4, StaticTextSelectionParams staticTextSelectionParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, selectionRegistrar, j4, staticTextSelectionParams);
    }

    public final void b(DrawScope drawScope) {
        Selection selection = (Selection) this.f11068b.b().b(this.f11067a);
        if (selection == null) {
            return;
        }
        int iD = !selection.d() ? selection.e().d() : selection.c().d();
        int iD2 = !selection.d() ? selection.c().d() : selection.e().d();
        if (iD == iD2) {
            return;
        }
        Selectable selectable = this.f11071f;
        int iH = selectable != null ? selectable.h() : 0;
        Path pathE = this.f11070d.e(RangesKt.k(iD, iH), RangesKt.k(iD2, iH));
        if (pathE == null) {
            return;
        }
        if (!this.f11070d.f()) {
            DrawScope.u0(drawScope, pathE, this.f11069c, 0.0f, null, null, 0, 60, null);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.b() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L));
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, iB);
            DrawScope.u0(drawScope, pathE, this.f11069c, 0.0f, null, null, 0, 60, null);
        } finally {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        this.f11071f = this.f11068b.h(new MultiWidgetSelectionDelegate(this.f11067a, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final LayoutCoordinates invoke() {
                return this.f11074a.f11070d.d();
            }
        }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TextLayoutResult invoke() {
                return this.f11075a.f11070d.g();
            }
        }));
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        Selectable selectable = this.f11071f;
        if (selectable != null) {
            this.f11068b.d(selectable);
            this.f11071f = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        Selectable selectable = this.f11071f;
        if (selectable != null) {
            this.f11068b.d(selectable);
            this.f11071f = null;
        }
    }

    public final Modifier f() {
        return this.f11072g;
    }

    public final void g(LayoutCoordinates layoutCoordinates) {
        this.f11070d = StaticTextSelectionParams.c(this.f11070d, layoutCoordinates, null, 2, null);
        this.f11068b.c(this.f11067a);
    }

    public final void h(TextLayoutResult textLayoutResult) {
        TextLayoutResult textLayoutResultG = this.f11070d.g();
        if (textLayoutResultG != null && !Intrinsics.areEqual(textLayoutResultG.l().j(), textLayoutResult.l().j())) {
            this.f11068b.e(this.f11067a);
        }
        this.f11070d = StaticTextSelectionParams.c(this.f11070d, null, textLayoutResult, 1, null);
    }

    private SelectionController(long j3, SelectionRegistrar selectionRegistrar, long j4, StaticTextSelectionParams staticTextSelectionParams) {
        this.f11067a = j3;
        this.f11068b = selectionRegistrar;
        this.f11069c = j4;
        this.f11070d = staticTextSelectionParams;
        this.f11072g = PointerIconKt.b(SelectionControllerKt.b(selectionRegistrar, j3, new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.modifiers.SelectionController$modifier$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final LayoutCoordinates invoke() {
                return this.f11073a.f11070d.d();
            }
        }), TextPointerIcon_androidKt.b(), false, 2, null);
    }

    public /* synthetic */ SelectionController(long j3, SelectionRegistrar selectionRegistrar, long j4, StaticTextSelectionParams staticTextSelectionParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, selectionRegistrar, j4, (i3 & 8) != 0 ? StaticTextSelectionParams.f11085c.a() : staticTextSelectionParams, null);
    }
}
