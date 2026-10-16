package cz.mobilesoft.coreblock.scene.schedule.preview;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1", f = "SchedulePreviewBlockingDetailScreen.kt", l = {312}, m = "invokeSuspend", v = 1)
final class SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f117365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f117366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppIconCache f117367d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ApplicationDTO f117368f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1(MutableState mutableState, AppIconCache appIconCache, ApplicationDTO applicationDTO, Continuation continuation) {
        super(2, continuation);
        this.f117366c = mutableState;
        this.f117367d = appIconCache;
        this.f117368f = applicationDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1(this.f117366c, this.f117367d, this.f117368f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutableState mutableState;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f117365b;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableState mutableState2 = this.f117366c;
            AppIconCache appIconCache = this.f117367d;
            String strF = this.f117368f.f();
            this.f117364a = mutableState2;
            this.f117365b = 1;
            Object objF2 = appIconCache.f(strF, this);
            if (objF2 == objF) {
                return objF;
            }
            mutableState = mutableState2;
            obj = objF2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.f117364a;
            ResultKt.b(obj);
        }
        mutableState.setValue(obj);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
