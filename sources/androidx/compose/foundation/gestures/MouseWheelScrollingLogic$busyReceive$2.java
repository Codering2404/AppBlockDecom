package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$busyReceive$2", f = "MouseWheelScrollable.kt", l = {170}, m = "invokeSuspend")
final class MouseWheelScrollingLogic$busyReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MouseWheelScrollingLogic.MouseWheelScrollDelta>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Channel f5977c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MouseWheelScrollingLogic$busyReceive$2(Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f5977c = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MouseWheelScrollingLogic$busyReceive$2 mouseWheelScrollingLogic$busyReceive$2 = new MouseWheelScrollingLogic$busyReceive$2(this.f5977c, continuation);
        mouseWheelScrollingLogic$busyReceive$2.f5976b = obj;
        return mouseWheelScrollingLogic$busyReceive$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        ?? r12 = this.f5975a;
        try {
            if (r12 == 0) {
                ResultKt.b(obj);
                Job jobD = BuildersKt__Builders_commonKt.d((CoroutineScope) this.f5976b, null, null, new MouseWheelScrollingLogic$busyReceive$2$job$1(null), 3, null);
                Channel channel = this.f5977c;
                this.f5976b = jobD;
                this.f5975a = 1;
                obj = channel.v(this);
                r12 = jobD;
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (r12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Job job = (Job) this.f5976b;
                ResultKt.b(obj);
                r12 = job;
            }
            MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollingLogic.MouseWheelScrollDelta) obj;
            Job.DefaultImpls.b(r12, null, 1, null);
            return mouseWheelScrollDelta;
        } catch (Throwable th) {
            Job.DefaultImpls.b(r12, null, 1, null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MouseWheelScrollingLogic$busyReceive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
