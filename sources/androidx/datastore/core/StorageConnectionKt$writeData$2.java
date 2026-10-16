package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", l = {77}, m = "invokeSuspend")
final class StorageConnectionKt$writeData$2 extends SuspendLambda implements Function2<WriteScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f35829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f35830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f35831c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StorageConnectionKt$writeData$2(Object obj, Continuation continuation) {
        super(2, continuation);
        this.f35831c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StorageConnectionKt$writeData$2 storageConnectionKt$writeData$2 = new StorageConnectionKt$writeData$2(this.f35831c, continuation);
        storageConnectionKt$writeData$2.f35830b = obj;
        return storageConnectionKt$writeData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(WriteScope writeScope, Continuation continuation) {
        return ((StorageConnectionKt$writeData$2) create(writeScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f35829a;
        if (i3 == 0) {
            ResultKt.b(obj);
            WriteScope writeScope = (WriteScope) this.f35830b;
            Object obj2 = this.f35831c;
            this.f35829a = 1;
            if (writeScope.a(obj2, this) == objF) {
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
}
