package cz.mobilesoft.appblock.view;

import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$9", f = "LockScreenProvider.kt", l = {705}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initViews$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95283c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initViews$9(LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
        super(2, continuation);
        this.f95282b = lockScreenProvider;
        this.f95283c = fragmentLockBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initViews$9(this.f95282b, this.f95283c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95281a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f95282b.f95158p;
            final FragmentLockBinding fragmentLockBinding = this.f95283c;
            final LockScreenProvider lockScreenProvider = this.f95282b;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.appblock.view.LockScreenProvider$initViews$9.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Long l3, Continuation continuation) {
                    if (l3 == null || l3.longValue() == 0) {
                        TextView motivationalTextView = fragmentLockBinding.f94015t;
                        Intrinsics.checkNotNullExpressionValue(motivationalTextView, "motivationalTextView");
                        motivationalTextView.setVisibility(0);
                        MaterialCardView campaignCardView = fragmentLockBinding.f94003h;
                        Intrinsics.checkNotNullExpressionValue(campaignCardView, "campaignCardView");
                        campaignCardView.setVisibility(8);
                    } else {
                        TextView motivationalTextView2 = fragmentLockBinding.f94015t;
                        Intrinsics.checkNotNullExpressionValue(motivationalTextView2, "motivationalTextView");
                        motivationalTextView2.setVisibility(8);
                        MaterialCardView inAppUpdateCardView = fragmentLockBinding.f94011p;
                        Intrinsics.checkNotNullExpressionValue(inAppUpdateCardView, "inAppUpdateCardView");
                        inAppUpdateCardView.setVisibility(8);
                        MaterialCardView campaignCardView2 = fragmentLockBinding.f94003h;
                        Intrinsics.checkNotNullExpressionValue(campaignCardView2, "campaignCardView");
                        campaignCardView2.setVisibility(0);
                        if (l3.longValue() > Constants.f128444b) {
                            fragmentLockBinding.f94004i.setText(lockScreenProvider.f95160r.getString(R.string.description_get_premium_discount_now, lockScreenProvider.f95160r.getString(R.string.app_name)));
                        } else {
                            MaterialTextView campaignTextView = fragmentLockBinding.f94004i;
                            Intrinsics.checkNotNullExpressionValue(campaignTextView, "campaignTextView");
                            String string = lockScreenProvider.f95160r.getString(R.string.campaign_block_screen_description, lockScreenProvider.f95160r.getString(R.string.app_name), lockScreenProvider.b0(), DateHelper.l(lockScreenProvider.f95160r, l3.longValue(), true));
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            ViewHelperExtKt.m(campaignTextView, string, false, 2, null);
                        }
                    }
                    return Unit.f139807a;
                }
            };
            this.f95281a = 1;
            if (mutableStateFlow.collect(flowCollector, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initViews$9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
