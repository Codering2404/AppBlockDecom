package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3$1", f = "MotionLayout.kt", l = {473, 483}, m = "invokeSuspend")
final class MotionLayoutKt$MotionLayoutCore$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f30810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f30811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Channel f30812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Animatable f30813d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f30814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f30815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f30816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f30817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableState f30818j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionLayoutKt$MotionLayoutCore$3$1(Channel channel, Animatable animatable, AnimationSpec animationSpec, Function0 function0, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.f30812c = channel;
        this.f30813d = animatable;
        this.f30814f = animationSpec;
        this.f30815g = function0;
        this.f30816h = mutableState;
        this.f30817i = mutableState2;
        this.f30818j = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MotionLayoutKt$MotionLayoutCore$3$1(this.f30812c, this.f30813d, this.f30814f, this.f30815g, this.f30816h, this.f30817i, this.f30818j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[PHI: r0 r1
      0x0027: PHI (r0v3 kotlinx.coroutines.channels.ChannelIterator) = (r0v14 kotlinx.coroutines.channels.ChannelIterator), (r0v17 kotlinx.coroutines.channels.ChannelIterator) binds: [B:13:0x003a, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0027: PHI (r1v0 java.lang.Object) = (r1v12 java.lang.Object), (r1v15 java.lang.Object) binds: [B:13:0x003a, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00af -> B:39:0x00b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c3 -> B:12:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MotionLayoutKt$MotionLayoutCore$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
