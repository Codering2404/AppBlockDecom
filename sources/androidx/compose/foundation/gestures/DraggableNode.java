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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;

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
public final class DraggableNode extends DragGestureNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DraggableState f5920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Orientation f5921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f5922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Function3 f5923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Function3 f5924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f5925r;

    public DraggableNode(DraggableState draggableState, Function1 function1, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, Function3 function3, Function3 function32, boolean z4) {
        super(function1, z2, mutableInteractionSource, orientation);
        this.f5920m = draggableState;
        this.f5921n = orientation;
        this.f5922o = z3;
        this.f5923p = function3;
        this.f5924q = function32;
        this.f5925r = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T2(long j3) {
        return Velocity.m(j3, this.f5925r ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long U2(long j3) {
        return Offset.r(j3, this.f5925r ? -1.0f : 1.0f);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object B2(Function2 function2, Continuation continuation) {
        Object objA = this.f5920m.a(MutatePriority.f5072b, new DraggableNode$drag$2(function2, this, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void F2(long j3) {
        if (!isAttached() || Intrinsics.areEqual(this.f5923p, DraggableKt.f5915a)) {
            return;
        }
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new DraggableNode$onDragStarted$1(this, j3, null), 1, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void G2(long j3) {
        if (!isAttached() || Intrinsics.areEqual(this.f5924q, DraggableKt.f5916b)) {
            return;
        }
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new DraggableNode$onDragStopped$1(this, j3, null), 1, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean K2() {
        return this.f5922o;
    }

    public final void V2(DraggableState draggableState, Function1 function1, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, Function3 function3, Function3 function32, boolean z4) {
        boolean z5;
        boolean z6 = true;
        if (Intrinsics.areEqual(this.f5920m, draggableState)) {
            z5 = false;
        } else {
            this.f5920m = draggableState;
            z5 = true;
        }
        if (this.f5921n != orientation) {
            this.f5921n = orientation;
            z5 = true;
        }
        if (this.f5925r != z4) {
            this.f5925r = z4;
        } else {
            z6 = z5;
        }
        this.f5923p = function3;
        this.f5924q = function32;
        this.f5922o = z3;
        M2(function1, z2, mutableInteractionSource, orientation, z6);
    }
}
