package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class Draggable2DNode extends DragGestureNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Draggable2DState f5893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f5894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f5895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Function1 f5896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Function1 f5897q;

    public Draggable2DNode(Draggable2DState draggable2DState, Function1 function1, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, boolean z4, Function1 function12, Function1 function13) {
        super(function1, z2, mutableInteractionSource, null);
        this.f5893m = draggable2DState;
        this.f5894n = z3;
        this.f5895o = z4;
        this.f5896p = function12;
        this.f5897q = function13;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object B2(Function2 function2, Continuation continuation) {
        Object objA = this.f5893m.a(MutatePriority.f5072b, new Draggable2DNode$drag$2(function2, this, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void F2(long j3) {
        this.f5896p.invoke(Offset.d(j3));
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void G2(long j3) {
        this.f5897q.invoke(Velocity.b(j3));
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean K2() {
        return this.f5894n;
    }

    public final void P2(Draggable2DState draggable2DState, Function1 function1, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, boolean z4, Function1 function12, Function1 function13) {
        boolean z5;
        boolean z6 = true;
        if (Intrinsics.areEqual(this.f5893m, draggable2DState)) {
            z5 = false;
        } else {
            this.f5893m = draggable2DState;
            z5 = true;
        }
        if (this.f5895o != z4) {
            this.f5895o = z4;
        } else {
            z6 = z5;
        }
        this.f5896p = function12;
        this.f5897q = function13;
        this.f5894n = z3;
        M2(function1, z2, mutableInteractionSource, null, z6);
    }
}
