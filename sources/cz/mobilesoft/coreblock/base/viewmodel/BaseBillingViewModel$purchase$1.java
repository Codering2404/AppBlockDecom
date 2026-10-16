package cz.mobilesoft.coreblock.base.viewmodel;

import android.app.Activity;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import cz.mobilesoft.coreblock.util.FailedWithError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$purchase$1", f = "BaseBillingViewModel.kt", l = {160, 161, 184}, m = "invokeSuspend", v = 1)
final class BaseBillingViewModel$purchase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseBillingViewModel f96384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f96385d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Activity f96386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ GoogleSubscriptionOption f96387g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$purchase$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseBillingViewModel f96388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f96389b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$purchase$1$1$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f96390a;

            static {
                int[] iArr = new int[PurchasesErrorCode.values().length];
                try {
                    iArr[PurchasesErrorCode.PurchaseCancelledError.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PurchasesErrorCode.ProductAlreadyPurchasedError.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f96390a = iArr;
            }
        }

        AnonymousClass1(BaseBillingViewModel baseBillingViewModel, String str) {
            this.f96388a = baseBillingViewModel;
            this.f96389b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(BaseBillingViewModel baseBillingViewModel, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            baseBillingViewModel.o1(null, true);
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(BaseBillingViewModel baseBillingViewModel, String str, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            baseBillingViewModel.z0(baseBillingViewModel.f96357w, new FailedWithError(new NullPointerException("Product " + str + " purchase not restored"), null, null, null, 14, null));
            baseBillingViewModel.z0(baseBillingViewModel.f96358x, errorMessage);
            return Unit.f139807a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x008e, code lost:
        
            if (r2.emit(null, r3) != r4) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
        
            if (r2.emit(r5, r3) == r4) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
        
            if (r2.emit(r11, r3) == r4) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 344
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$purchase$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBillingViewModel$purchase$1(BaseBillingViewModel baseBillingViewModel, String str, Activity activity, GoogleSubscriptionOption googleSubscriptionOption, Continuation continuation) {
        super(2, continuation);
        this.f96384c = baseBillingViewModel;
        this.f96385d = str;
        this.f96386f = activity;
        this.f96387g = googleSubscriptionOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseBillingViewModel$purchase$1(this.f96384c, this.f96385d, this.f96386f, this.f96387g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r12.emit(r4, r11) != r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e8, code lost:
    
        if (r12.collect(r1, r11) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$purchase$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseBillingViewModel$purchase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
