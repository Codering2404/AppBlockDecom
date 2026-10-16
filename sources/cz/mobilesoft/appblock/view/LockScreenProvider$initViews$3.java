package cz.mobilesoft.appblock.view;

import android.text.Spanned;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.appblock.view.LockScreenProvider;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$initViews$3", f = "LockScreenProvider.kt", l = {647}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$initViews$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f95254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f95255d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f95256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider.LockScreenDTO f95257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ FragmentLockBinding f95259i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$initViews$3(LockScreenProvider.LockScreenDTO lockScreenDTO, LockScreenProvider lockScreenProvider, FragmentLockBinding fragmentLockBinding, Continuation continuation) {
        super(2, continuation);
        this.f95257g = lockScreenDTO;
        this.f95258h = lockScreenProvider;
        this.f95259i = fragmentLockBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$initViews$3(this.f95257g, this.f95258h, this.f95259i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f95256f;
        if (i3 == 0) {
            ResultKt.b(obj);
            StrictModeOption strictModeOptionI = this.f95257g.i();
            if (strictModeOptionI != null) {
                LockScreenProvider lockScreenProvider = this.f95258h;
                FragmentLockBinding fragmentLockBinding = this.f95259i;
                int title = strictModeOptionI.getTitle();
                Spanned spannedH = StringHelper.h(lockScreenProvider.f95160r.getString(R.string.strict_mode_blocking_reason, lockScreenProvider.f95160r.getString(title)));
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                LockScreenProvider$initViews$3$1$1 lockScreenProvider$initViews$3$1$1 = new LockScreenProvider$initViews$3$1$1(fragmentLockBinding, lockScreenProvider, spannedH, null);
                this.f95252a = strictModeOptionI;
                this.f95253b = spannedH;
                this.f95254c = 0;
                this.f95255d = title;
                this.f95256f = 1;
                if (BuildersKt.g(mainCoroutineDispatcherC, lockScreenProvider$initViews$3$1$1, this) == objF) {
                    return objF;
                }
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
        return ((LockScreenProvider$initViews$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
