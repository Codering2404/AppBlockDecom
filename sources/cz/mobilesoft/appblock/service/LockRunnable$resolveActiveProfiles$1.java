package cz.mobilesoft.appblock.service;

import android.content.Context;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$resolveActiveProfiles$1", f = "LockRunnable.kt", l = {625}, m = "invokeSuspend", v = 1)
final class LockRunnable$resolveActiveProfiles$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockRunnable f94470b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockRunnable$resolveActiveProfiles$1(LockRunnable lockRunnable, Continuation continuation) {
        super(1, continuation);
        this.f94470b = lockRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState q(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LockRunnable$resolveActiveProfiles$1(this.f94470b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94469a;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockWidgetReceiver.Companion companion = QuickBlockWidgetReceiver.f134085h;
            Context context = this.f94470b.f94406a;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.appblock.service.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return LockRunnable$resolveActiveProfiles$1.q((AppBlockWidgetState) obj2);
                }
            };
            this.f94469a = 1;
            if (companion.a(context, function1, this) == objF) {
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
        return ((LockRunnable$resolveActiveProfiles$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
