package cz.mobilesoft.coreblock.util.widget;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$stopQuickBlock$1", f = "WidgetDataProviderImpl.kt", l = {309}, m = "invokeSuspend", v = 1)
final class WidgetDataProviderImpl$stopQuickBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f130013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WidgetDataProviderImpl f130014b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetDataProviderImpl$stopQuickBlock$1(WidgetDataProviderImpl widgetDataProviderImpl, Continuation continuation) {
        super(2, continuation);
        this.f130014b = widgetDataProviderImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState q(AppBlockWidgetState appBlockWidgetState) {
        return AppBlockWidgetState.e(appBlockWidgetState, AppBlockWidgetState.QuickBlockWidgetState.Stopped.INSTANCE, null, false, 0, 14, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WidgetDataProviderImpl$stopQuickBlock$1(this.f130014b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f130013a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f130014b.B().n()) {
                WidgetDataProviderImpl.E(this.f130014b, true, false, false, false, null, false, 62, null);
                return Unit.f139807a;
            }
            QuickBlockProfileDTO quickBlockProfileDTOQ = this.f130014b.A().q();
            if (quickBlockProfileDTOQ != null) {
                WidgetDataProviderImpl widgetDataProviderImpl = this.f130014b;
                if (quickBlockProfileDTOQ.h().w() > 0) {
                    AnswersHelper.f128199a.s8();
                } else {
                    AnswersHelper.f128199a.u8();
                }
                widgetDataProviderImpl.A().P();
            }
            QuickBlockWidgetReceiver.Companion companion = QuickBlockWidgetReceiver.f134085h;
            Context context = this.f130014b.f129959a;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.util.widget.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WidgetDataProviderImpl$stopQuickBlock$1.q((AppBlockWidgetState) obj2);
                }
            };
            this.f130013a = 1;
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WidgetDataProviderImpl$stopQuickBlock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
