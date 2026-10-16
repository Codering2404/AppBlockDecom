package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", l = {604}, m = "invokeSuspend")
final class SeparatorsKt$insertEventSeparators$separatorState$1 extends SuspendLambda implements Function3<Object, Object, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f50624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f50625d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeparatorsKt$insertEventSeparators$separatorState$1(Function3 function3, Continuation continuation) {
        super(3, continuation);
        this.f50625d = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Object obj, Object obj2, Continuation continuation) {
        SeparatorsKt$insertEventSeparators$separatorState$1 separatorsKt$insertEventSeparators$separatorState$1 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.f50625d, continuation);
        separatorsKt$insertEventSeparators$separatorState$1.f50623b = obj;
        separatorsKt$insertEventSeparators$separatorState$1.f50624c = obj2;
        return separatorsKt$insertEventSeparators$separatorState$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50622a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Object obj2 = this.f50623b;
        Object obj3 = this.f50624c;
        Function3 function3 = this.f50625d;
        this.f50623b = null;
        this.f50622a = 1;
        Object objInvoke = function3.invoke(obj2, obj3, this);
        return objInvoke == objF ? objF : objInvoke;
    }
}
