package cz.mobilesoft.appblock.view;

import android.text.Spanned;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$3$1$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initViews$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Spanned f95263d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initViews$3$1$1(FragmentLockBinding fragmentLockBinding, LockScreenProvider lockScreenProvider, Spanned spanned, Continuation continuation) {
        super(2, continuation);
        this.f95261b = fragmentLockBinding;
        this.f95262c = lockScreenProvider;
        this.f95263d = spanned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LockScreenProvider lockScreenProvider, Spanned spanned, View view) {
        lockScreenProvider.F0(spanned);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initViews$3$1$1(this.f95261b, this.f95262c, this.f95263d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f95260a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AppCompatImageView blockingReasonButton = this.f95261b.f94002g;
        Intrinsics.checkNotNullExpressionValue(blockingReasonButton, "blockingReasonButton");
        blockingReasonButton.setVisibility(0);
        AppCompatImageView appCompatImageView = this.f95261b.f94002g;
        final LockScreenProvider lockScreenProvider = this.f95262c;
        final Spanned spanned = this.f95263d;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.appblock.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LockScreenProvider$initViews$3$1$1.q(lockScreenProvider, spanned, view);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initViews$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
