package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", f = "Clickable.kt", l = {1263, 1265, 1272, 1273, 1283}, m = "invokeSuspend")
final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f4524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f4526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PressGestureScope f4527d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f4528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f4529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AbstractClickableNode f4530h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope pressGestureScope, long j3, MutableInteractionSource mutableInteractionSource, AbstractClickableNode abstractClickableNode, Continuation continuation) {
        super(2, continuation);
        this.f4527d = pressGestureScope;
        this.f4528f = j3;
        this.f4529g = mutableInteractionSource;
        this.f4530h = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.f4527d, this.f4528f, this.f4529g, this.f4530h, continuation);
        abstractClickableNode$handlePressInteraction$2$1.f4526c = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (r3.a(r2, r16) != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r4.a(r5, r16) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
