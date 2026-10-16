package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableIntState;
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
@DebugMetadata(c = "androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$4$1", f = "ConstraintLayout.kt", l = {774, 784}, m = "invokeSuspend")
public final class ConstraintLayoutKt$ConstraintLayout$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f30450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f30451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Channel f30452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableIntState f30453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Animatable f30454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f30455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f30456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f30457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableState f30458j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$4$1(Channel channel, MutableIntState mutableIntState, Animatable animatable, AnimationSpec animationSpec, Function0 function0, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f30452c = channel;
        this.f30453d = mutableIntState;
        this.f30454f = animatable;
        this.f30455g = animationSpec;
        this.f30456h = function0;
        this.f30457i = mutableState;
        this.f30458j = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ConstraintLayoutKt$ConstraintLayout$4$1(this.f30452c, this.f30453d, this.f30454f, this.f30455g, this.f30456h, this.f30457i, this.f30458j, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r5, r6, r7, null, null, r10, 12, null) == r0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ab -> B:7:0x0016). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c5 -> B:12:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ConstraintLayoutKt$ConstraintLayout$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
