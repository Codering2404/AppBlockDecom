package cz.mobilesoft.coreblock.service.job;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.ProfileDeactivationJob$onRunJob$4", f = "ProfileDeactivationJob.kt", l = {57}, m = "invokeSuspend", v = 1)
final class ProfileDeactivationJob$onRunJob$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileDeactivationJob f123421b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileDeactivationJob$onRunJob$4(ProfileDeactivationJob profileDeactivationJob, Continuation continuation) {
        super(2, continuation);
        this.f123421b = profileDeactivationJob;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState q(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileDeactivationJob$onRunJob$4(this.f123421b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f123420a;
        if (i3 == 0) {
            ResultKt.b(obj);
            QuickBlockWidgetReceiver.Companion companion = QuickBlockWidgetReceiver.f134085h;
            Context contextC = this.f123421b.c();
            Intrinsics.checkNotNullExpressionValue(contextC, "access$getContext(...)");
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.service.job.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ProfileDeactivationJob$onRunJob$4.q((AppBlockWidgetState) obj2);
                }
            };
            this.f123420a = 1;
            if (companion.a(contextC, function1, this) == objF) {
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
        return ((ProfileDeactivationJob$onRunJob$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
