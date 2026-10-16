package cz.mobilesoft.appblock.view;

import android.animation.ObjectAnimator;
import androidx.core.content.ContextCompat;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import java.util.concurrent.TimeUnit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initTimeoutCountDown$1$1$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initTimeoutCountDown$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FragmentLockBinding>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f95249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ double f95251d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initTimeoutCountDown$1$1$1(long j3, LockScreenProvider lockScreenProvider, double d3, Continuation continuation) {
        super(2, continuation);
        this.f95249b = j3;
        this.f95250c = lockScreenProvider;
        this.f95251d = d3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initTimeoutCountDown$1$1$1(this.f95249b, this.f95250c, this.f95251d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f95248a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f95249b);
        FragmentLockBinding fragmentLockBinding = this.f95250c.f95144a;
        LockScreenProvider lockScreenProvider = this.f95250c;
        double d3 = this.f95251d;
        long j3 = this.f95249b;
        fragmentLockBinding.f94005j.setEnabled(false);
        fragmentLockBinding.f94005j.getBackground().setAlpha(220);
        fragmentLockBinding.f94005j.setTextColor(ContextCompat.getColor(lockScreenProvider.f95160r, R.color.secondary_button_title));
        fragmentLockBinding.f94018w.setText(String.valueOf(seconds));
        CircularProgressIndicator circularProgressIndicator = fragmentLockBinding.f94017v;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(circularProgressIndicator, "progress", circularProgressIndicator.getProgress(), (int) ((seconds / d3) * ((double) 100)));
        objectAnimatorOfInt.setDuration(1000L);
        objectAnimatorOfInt.start();
        if (j3 <= 0) {
            fragmentLockBinding.f94017v.setVisibility(8);
            fragmentLockBinding.f94018w.setVisibility(8);
            fragmentLockBinding.f94005j.getBackground().setAlpha(255);
            fragmentLockBinding.f94005j.setBackgroundColor(ContextCompat.getColor(lockScreenProvider.f95160r, R.color.accent));
            fragmentLockBinding.f94005j.setTextColor(ContextCompat.getColor(lockScreenProvider.f95160r, R.color.white));
            fragmentLockBinding.f94005j.setEnabled(true);
        }
        return fragmentLockBinding;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$initTimeoutCountDown$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
