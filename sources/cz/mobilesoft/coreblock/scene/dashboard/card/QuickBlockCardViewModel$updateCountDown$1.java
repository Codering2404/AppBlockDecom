package cz.mobilesoft.coreblock.scene.dashboard.card;

import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
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
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$updateCountDown$1", f = "QuickBlockCardViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class QuickBlockCardViewModel$updateCountDown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f100539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockCardViewModel f100540c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardViewModel$updateCountDown$1(QuickBlockCardViewModel quickBlockCardViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100540c = quickBlockCardViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockViewState y(Long l3, QuickBlockViewState quickBlockViewState) {
        return QuickBlockViewState.b(quickBlockViewState, null, null, null, null, null, null, false, null, l3 != null ? l3.longValue() : 0L, 0L, false, false, null, false, null, false, false, false, false, false, 1048319, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        QuickBlockCardViewModel$updateCountDown$1 quickBlockCardViewModel$updateCountDown$1 = new QuickBlockCardViewModel$updateCountDown$1(this.f100540c, continuation);
        quickBlockCardViewModel$updateCountDown$1.f100539b = obj;
        return quickBlockCardViewModel$updateCountDown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f100539b;
        IntrinsicsKt.f();
        if (this.f100538a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f100540c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return QuickBlockCardViewModel$updateCountDown$1.y(l3, (QuickBlockViewState) obj2);
            }
        });
        if (l3 == null || ComparableExtKt.d(l3, Boxing.e(0L))) {
            MutableStateFlow mutableStateFlow = this.f100540c.f100449x;
            mutableStateFlow.setValue(Boxing.d(((Number) mutableStateFlow.getValue()).intValue() + 1));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((QuickBlockCardViewModel$updateCountDown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
