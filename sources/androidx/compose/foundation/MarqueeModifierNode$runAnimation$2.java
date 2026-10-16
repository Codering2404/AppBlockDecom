package androidx.compose.foundation;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", l = {402}, m = "invokeSuspend")
final class MarqueeModifierNode$runAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MarqueeModifierNode f5061b;

    /* JADX INFO: renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", l = {416, 418, 422, 422}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f5063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f5065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MarqueeModifierNode f5066d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MarqueeModifierNode marqueeModifierNode, Continuation continuation) {
            super(2, continuation);
            this.f5066d = marqueeModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f5066d, continuation);
            anonymousClass2.f5065c = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Float f3, Continuation continuation) {
            return ((AnonymousClass2) create(f3, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00bb, code lost:
        
            if (r0.u(r1, r20) != r8) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MarqueeModifierNode$runAnimation$2(MarqueeModifierNode marqueeModifierNode, Continuation continuation) {
        super(2, continuation);
        this.f5061b = marqueeModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MarqueeModifierNode$runAnimation$2(this.f5061b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5060a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final MarqueeModifierNode marqueeModifierNode = this.f5061b;
            Flow flowQ = SnapshotStateKt.q(new Function0<Float>() { // from class: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    if (marqueeModifierNode.z2() <= marqueeModifierNode.y2()) {
                        return null;
                    }
                    if (!MarqueeAnimationMode.e(marqueeModifierNode.x2(), MarqueeAnimationMode.f5025b.a()) || marqueeModifierNode.B2()) {
                        return Float.valueOf(marqueeModifierNode.z2() + marqueeModifierNode.C2());
                    }
                    return null;
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f5061b, null);
            this.f5060a = 1;
            if (FlowKt.l(flowQ, anonymousClass2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MarqueeModifierNode$runAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
