package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
final class StateLayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f15430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Animatable f15431c = AnimatableKt.b(0.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f15432d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Interaction f15433e;

    public StateLayer(boolean z2, Function0 function0) {
        this.f15429a = z2;
        this.f15430b = function0;
    }

    public final void b(DrawScope drawScope, float f3, long j3) {
        long j4;
        float fFloatValue = ((Number) this.f15431c.n()).floatValue();
        if (fFloatValue <= 0.0f) {
            return;
        }
        long jR = Color.r(j3, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f15429a) {
            DrawScope.e2(drawScope, jR, f3, 0L, 0.0f, null, null, 0, 124, null);
            return;
        }
        float fI = Size.i(drawScope.b());
        float fG = Size.g(drawScope.b());
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(0.0f, 0.0f, fI, fG, iB);
            j4 = jB;
            try {
                DrawScope.e2(drawScope, jR, f3, 0L, 0.0f, null, null, 0, 124, null);
                drawContextQ1.g().k();
                drawContextQ1.h(j4);
            } catch (Throwable th) {
                th = th;
                drawContextQ1.g().k();
                drawContextQ1.h(j4);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j4 = jB;
        }
    }

    public final void c(Interaction interaction, CoroutineScope coroutineScope) {
        boolean z2 = interaction instanceof HoverInteraction.Enter;
        if (z2) {
            this.f15432d.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.f15432d.remove(((HoverInteraction.Exit) interaction).a());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.f15432d.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.f15432d.remove(((FocusInteraction.Unfocus) interaction).a());
        } else if (interaction instanceof DragInteraction.Start) {
            this.f15432d.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.f15432d.remove(((DragInteraction.Stop) interaction).a());
        } else if (!(interaction instanceof DragInteraction.Cancel)) {
            return;
        } else {
            this.f15432d.remove(((DragInteraction.Cancel) interaction).a());
        }
        Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull(this.f15432d);
        if (Intrinsics.areEqual(this.f15433e, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            RippleAlpha rippleAlpha = (RippleAlpha) this.f15430b.invoke();
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StateLayer$handleInteraction$1(this, z2 ? rippleAlpha.c() : interaction instanceof FocusInteraction.Focus ? rippleAlpha.b() : interaction instanceof DragInteraction.Start ? rippleAlpha.a() : 0.0f, RippleKt.d(interaction2), null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StateLayer$handleInteraction$2(this, RippleKt.e(this.f15433e), null), 3, null);
        }
        this.f15433e = interaction2;
    }
}
