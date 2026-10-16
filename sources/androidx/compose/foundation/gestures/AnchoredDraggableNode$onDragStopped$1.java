package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", l = {434, 436}, m = "invokeSuspend")
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableNode f5473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f5474c;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", l = {438}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ long f5476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AnchoredDraggableNode f5477c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableNode anchoredDraggableNode, Continuation continuation) {
            super(2, continuation);
            this.f5477c = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5477c, continuation);
            anonymousClass1.f5476b = ((Velocity) obj).o();
            return anonymousClass1;
        }

        public final Object h(long j3, Continuation continuation) {
            return ((AnonymousClass1) create(Velocity.b(j3), continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return h(((Velocity) obj).o(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            long jG3;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f5475a;
            if (i3 == 0) {
                ResultKt.b(obj);
                long j3 = this.f5476b;
                AnchoredDraggableNode anchoredDraggableNode = this.f5477c;
                float fD3 = anchoredDraggableNode.d3(j3);
                this.f5476b = j3;
                this.f5475a = 1;
                obj = anchoredDraggableNode.X2(fD3, this);
                if (obj == objF) {
                    return objF;
                }
                jG3 = j3;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jG3 = this.f5476b;
                ResultKt.b(obj);
            }
            float fFloatValue = ((Number) obj).floatValue();
            float fA = this.f5477c.f5445m.A();
            float fE = this.f5477c.f5445m.l().e();
            if (fA >= this.f5477c.f5445m.l().f() || fA <= fE) {
                jG3 = this.f5477c.g3(fFloatValue);
            }
            return Velocity.b(jG3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode anchoredDraggableNode, long j3, Continuation continuation) {
        super(2, continuation);
        this.f5473b = anchoredDraggableNode;
        this.f5474c = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.f5473b, this.f5474c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r1.X2(r8, r7) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        if (r1.c(r3, r8, r7) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f5472a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L17:
            kotlin.ResultKt.b(r8)
            goto L5d
        L1b:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode r8 = r7.f5473b
            long r4 = r7.f5474c
            long r4 = androidx.compose.foundation.gestures.AnchoredDraggableNode.R2(r8, r4)
            float r8 = androidx.compose.foundation.gestures.AnchoredDraggableNode.T2(r8, r4)
            androidx.compose.foundation.gestures.AnchoredDraggableNode r1 = r7.f5473b
            androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.P2(r1)
            if (r1 != 0) goto L3d
            androidx.compose.foundation.gestures.AnchoredDraggableNode r1 = r7.f5473b
            r7.f5472a = r3
            java.lang.Object r8 = androidx.compose.foundation.gestures.AnchoredDraggableNode.O2(r1, r8, r7)
            if (r8 != r0) goto L5d
            goto L5c
        L3d:
            androidx.compose.foundation.gestures.AnchoredDraggableNode r1 = r7.f5473b
            androidx.compose.foundation.OverscrollEffect r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.P2(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.foundation.gestures.AnchoredDraggableNode r3 = r7.f5473b
            long r3 = androidx.compose.foundation.gestures.AnchoredDraggableNode.W2(r3, r8)
            androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 r8 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1
            androidx.compose.foundation.gestures.AnchoredDraggableNode r5 = r7.f5473b
            r6 = 0
            r8.<init>(r5, r6)
            r7.f5472a = r2
            java.lang.Object r8 = r1.c(r3, r8, r7)
            if (r8 != r0) goto L5d
        L5c:
            return r0
        L5d:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
