package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$SmoothSnapSlider$2$1", f = "InsightsScreenComponents.kt", l = {}, m = "invokeSuspend", v = 1)
final class InsightsScreenComponentsKt$SmoothSnapSlider$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f102617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f102618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f102619d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ State f102620f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsScreenComponentsKt$SmoothSnapSlider$2$1(MutableState mutableState, MutableState mutableState2, Context context, State state, Continuation continuation) {
        super(2, continuation);
        this.f102617b = mutableState;
        this.f102618c = mutableState2;
        this.f102619d = context;
        this.f102620f = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InsightsScreenComponentsKt$SmoothSnapSlider$2$1(this.f102617b, this.f102618c, this.f102619d, this.f102620f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MoodType moodType;
        IntrinsicsKt.f();
        if (this.f102616a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        MutableState mutableState = this.f102617b;
        if (InsightsScreenComponentsKt.p2(this.f102620f) < -6) {
            moodType = MoodType.VeryDistracted;
        } else {
            int iP2 = InsightsScreenComponentsKt.p2(this.f102620f);
            if (-6 > iP2 || iP2 >= -2) {
                int iP22 = InsightsScreenComponentsKt.p2(this.f102620f);
                moodType = (3 > iP22 || iP22 >= 7) ? InsightsScreenComponentsKt.p2(this.f102620f) > 6 ? MoodType.InControl : MoodType.Neutral : MoodType.SomewhatInControl;
            } else {
                moodType = MoodType.SomewhatDistracted;
            }
        }
        mutableState.setValue(moodType);
        this.f102618c.setValue(Boxing.d(InsightsScreenComponentsKt.p2(this.f102620f)));
        ContextExtKt.j(this.f102619d);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InsightsScreenComponentsKt$SmoothSnapSlider$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
