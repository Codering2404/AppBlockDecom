package cz.mobilesoft.appblock.view;

import androidx.core.content.ContextCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initTimeoutCountDown$1", f = "LockScreenProvider.kt", l = {429}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initTimeoutCountDown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f95242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f95243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f95244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f95245d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ double f95247g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initTimeoutCountDown$1(LockScreenProvider lockScreenProvider, double d3, Continuation continuation) {
        super(2, continuation);
        this.f95246f = lockScreenProvider;
        this.f95247g = d3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockScreenProvider$initTimeoutCountDown$1 lockScreenProvider$initTimeoutCountDown$1 = new LockScreenProvider$initTimeoutCountDown$1(this.f95246f, this.f95247g, continuation);
        lockScreenProvider$initTimeoutCountDown$1.f95245d = obj;
        return lockScreenProvider$initTimeoutCountDown$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((LockScreenProvider$initTimeoutCountDown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Long l3 = (Long) this.f95245d;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95244c;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (l3 != null) {
                LockScreenProvider lockScreenProvider = this.f95246f;
                double d3 = this.f95247g;
                long jLongValue = l3.longValue();
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                LockScreenProvider$initTimeoutCountDown$1$1$1 lockScreenProvider$initTimeoutCountDown$1$1$1 = new LockScreenProvider$initTimeoutCountDown$1$1$1(jLongValue, lockScreenProvider, d3, null);
                this.f95245d = l3;
                this.f95242a = jLongValue;
                this.f95243b = 0;
                this.f95244c = 1;
                obj = BuildersKt.g(mainCoroutineDispatcherC, lockScreenProvider$initTimeoutCountDown$1$1$1, this);
                if (obj == objF) {
                    return objF;
                }
            }
            LockScreenProvider lockScreenProvider2 = this.f95246f;
            FragmentLockBinding fragmentLockBinding = lockScreenProvider2.f95144a;
            fragmentLockBinding.f94017v.setVisibility(8);
            fragmentLockBinding.f94018w.setVisibility(8);
            fragmentLockBinding.f94005j.getBackground().setAlpha(255);
            fragmentLockBinding.f94005j.setBackgroundColor(ContextCompat.getColor(lockScreenProvider2.f95160r, R.color.accent));
            fragmentLockBinding.f94005j.setTextColor(ContextCompat.getColor(lockScreenProvider2.f95160r, R.color.white));
            fragmentLockBinding.f94005j.setEnabled(true);
            Unit unit = Unit.f139807a;
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((FragmentLockBinding) obj) == null) {
            LockScreenProvider lockScreenProvider22 = this.f95246f;
            FragmentLockBinding fragmentLockBinding2 = lockScreenProvider22.f95144a;
            fragmentLockBinding2.f94017v.setVisibility(8);
            fragmentLockBinding2.f94018w.setVisibility(8);
            fragmentLockBinding2.f94005j.getBackground().setAlpha(255);
            fragmentLockBinding2.f94005j.setBackgroundColor(ContextCompat.getColor(lockScreenProvider22.f95160r, R.color.accent));
            fragmentLockBinding2.f94005j.setTextColor(ContextCompat.getColor(lockScreenProvider22.f95160r, R.color.white));
            fragmentLockBinding2.f94005j.setEnabled(true);
            Unit unit2 = Unit.f139807a;
        }
        return Unit.f139807a;
    }
}
