package cz.mobilesoft.coreblock.view.viewholder;

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
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.viewholder.PermissionsCardSimpleViewHolder$isAnyPermissionMissing$1", f = "PermissionsCardSimpleViewHolder.kt", l = {47}, m = "invokeSuspend", v = 1)
final class PermissionsCardSimpleViewHolder$isAnyPermissionMissing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PermissionsCardSimpleViewHolder f133478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f133479c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsCardSimpleViewHolder$isAnyPermissionMissing$1(PermissionsCardSimpleViewHolder permissionsCardSimpleViewHolder, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f133478b = permissionsCardSimpleViewHolder;
        this.f133479c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionsCardSimpleViewHolder$isAnyPermissionMissing$1(this.f133478b, this.f133479c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f133477a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f133478b.g();
            this.f133477a = 1;
            if (DelayKt.b(1500L, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Function0 function0 = this.f133478b.f133474b;
        if (function0 != null) {
            function0.invoke();
        }
        this.f133478b.f(this.f133479c);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionsCardSimpleViewHolder$isAnyPermissionMissing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
