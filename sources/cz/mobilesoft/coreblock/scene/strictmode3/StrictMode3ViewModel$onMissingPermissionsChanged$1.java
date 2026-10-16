package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onMissingPermissionsChanged$1", f = "StrictMode3ViewModel.kt", l = {884}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onMissingPermissionsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PermissionRequestReason f121348d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121349a;

        static {
            int[] iArr = new int[PermissionRequestReason.values().length];
            try {
                iArr[PermissionRequestReason.Activation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionRequestReason.General.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f121349a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onMissingPermissionsChanged$1(StrictMode3ViewModel strictMode3ViewModel, PermissionRequestReason permissionRequestReason, Continuation continuation) {
        super(2, continuation);
        this.f121347c = strictMode3ViewModel;
        this.f121348d = permissionRequestReason;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onMissingPermissionsChanged$1(this.f121347c, this.f121348d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121346b;
        if (i3 == 0) {
            ResultKt.b(obj);
            StrictMode3ViewState strictMode3ViewStateH1 = StrictMode3ViewModel.h1(this.f121347c);
            StrictMode3ViewModel strictMode3ViewModel = this.f121347c;
            StrictModeState strictModeStateE = strictMode3ViewStateH1.g().e();
            ImmutableList immutableListR = strictMode3ViewStateH1.r();
            ImmutableList immutableListD = strictMode3ViewStateH1.q().d();
            this.f121345a = SpillingKt.a(strictMode3ViewStateH1);
            this.f121346b = 1;
            if (strictMode3ViewModel.X2(strictModeStateE, immutableListR, immutableListD, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        int i4 = WhenMappings.f121349a[this.f121348d.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (StrictMode3ViewModel.h1(this.f121347c).q().d().isEmpty()) {
            this.f121347c.G2();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$onMissingPermissionsChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
