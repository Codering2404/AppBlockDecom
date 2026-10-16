package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao_Impl$insertDefault$2", f = "BrowserViewIdDao_Impl.kt", l = {233}, m = "invokeSuspend", v = 1)
final class BrowserViewIdDao_Impl$insertDefault$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BrowserViewIdDao_Impl f125028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f125029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f125030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BrowserViewId.ViewType f125031f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrowserViewIdDao_Impl$insertDefault$2(BrowserViewIdDao_Impl browserViewIdDao_Impl, Context context, String str, BrowserViewId.ViewType viewType, Continuation continuation) {
        super(1, continuation);
        this.f125028b = browserViewIdDao_Impl;
        this.f125029c = context;
        this.f125030d = str;
        this.f125031f = viewType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BrowserViewIdDao_Impl$insertDefault$2(this.f125028b, this.f125029c, this.f125030d, this.f125031f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125027a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BrowserViewIdDao_Impl browserViewIdDao_Impl = this.f125028b;
            Context context = this.f125029c;
            String str = this.f125030d;
            BrowserViewId.ViewType viewType = this.f125031f;
            this.f125027a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao*/.R(context, str, viewType, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BrowserViewIdDao_Impl$insertDefault$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
