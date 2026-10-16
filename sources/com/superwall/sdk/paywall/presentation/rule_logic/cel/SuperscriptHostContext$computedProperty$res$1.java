package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptExposedFunction;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.rule_logic.cel.SuperscriptHostContext$computedProperty$res$1", f = "SuperscriptHostContext.kt", l = {43, 44, 45, 46}, m = "invokeSuspend")
final class SuperscriptHostContext$computedProperty$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<PassableValue> $_args;
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ SuperscriptHostContext this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SuperscriptHostContext$computedProperty$res$1(String str, List<? extends PassableValue> list, SuperscriptHostContext superscriptHostContext, Continuation<? super SuperscriptHostContext$computedProperty$res$1> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$_args = list;
        this.this$0 = superscriptHostContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuperscriptHostContext$computedProperty$res$1(this.$name, this.$_args, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.b(obj);
                return obj;
            }
            if (i3 == 2) {
                ResultKt.b(obj);
                return obj;
            }
            if (i3 == 3) {
                ResultKt.b(obj);
                return obj;
            }
            if (i3 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Object objFrom = SuperscriptExposedFunction.Companion.from(this.$name, this.$_args);
        if (objFrom == null) {
            return null;
        }
        if (objFrom instanceof TimeSince) {
            CoreDataManager coreDataManager = this.this$0.storage;
            this.label = 1;
            Object objInvoke = ((TimeSince) objFrom).invoke(coreDataManager, this);
            if (objInvoke != objF) {
                return objInvoke;
            }
        } else if (objFrom instanceof SuperscriptExposedFunction.PlacementCount) {
            CoreDataManager coreDataManager2 = this.this$0.storage;
            this.label = 2;
            Object objInvoke2 = ((SuperscriptExposedFunction.PlacementCount) objFrom).invoke(coreDataManager2, this);
            if (objInvoke2 != objF) {
                return objInvoke2;
            }
        } else if (objFrom instanceof SuperscriptExposedFunction.ReviewRequestCount) {
            CoreDataManager coreDataManager3 = this.this$0.storage;
            this.label = 3;
            Object objInvoke3 = ((SuperscriptExposedFunction.ReviewRequestCount) objFrom).invoke(coreDataManager3, this);
            if (objInvoke3 != objF) {
                return objInvoke3;
            }
        } else {
            if (!(objFrom instanceof SuperscriptExposedFunction.RequestReview)) {
                throw new NoWhenBranchMatchedException();
            }
            CoreDataManager coreDataManager4 = this.this$0.storage;
            this.label = 4;
            Object objInvoke4 = ((SuperscriptExposedFunction.RequestReview) objFrom).invoke(coreDataManager4, this);
            if (objInvoke4 != objF) {
                return objInvoke4;
            }
        }
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((SuperscriptHostContext$computedProperty$res$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
