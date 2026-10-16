package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$updateLimitedCountdown$1", f = "StrictMode3ViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$updateLimitedCountdown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f121442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121443c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$updateLimitedCountdown$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121443c = strictMode3ViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState y(Long l3, StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, DateHelper.e(TimeUnit.MILLISECONDS.toSeconds(l3.longValue())), 0L, false, false, false, null, null, null, null, 0L, 2095103, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictMode3ViewModel$updateLimitedCountdown$1 strictMode3ViewModel$updateLimitedCountdown$1 = new StrictMode3ViewModel$updateLimitedCountdown$1(this.f121443c, continuation);
        strictMode3ViewModel$updateLimitedCountdown$1.f121442b = obj;
        return strictMode3ViewModel$updateLimitedCountdown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f121442b;
        IntrinsicsKt.f();
        if (this.f121441a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (l3 == null || ComparableExtKt.d(l3, Boxing.e(0L))) {
            StrictMode3ViewModel.R1(this.f121443c, false, false, false, 4, null);
        } else {
            this.f121443c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.h4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StrictMode3ViewModel$updateLimitedCountdown$1.y(l3, (StrictMode3ViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((StrictMode3ViewModel$updateLimitedCountdown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
