package cz.mobilesoft.coreblock.util;

import android.content.Context;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import java.util.Iterator;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1", f = "UsageAccessHelper.kt", l = {59, 59, 60, 67, 73, 77, 95, 97}, m = "invokeSuspend", v = 1)
final class UsageAccessHelper$updateApplicationAccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f128068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f128069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f128071d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f128072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f128073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f128074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f128075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function1 f128076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function1 f128077k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$1", f = "UsageAccessHelper.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128079b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f128079b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128079b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128078a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1 function1 = this.f128079b;
            if (function1 != null) {
                function1.invoke(Boxing.a(false));
            }
            Iterator it = UsageAccessHelper.f128039i.iterator();
            while (it.hasNext()) {
                ((UsageAccessHelper.UsageAccessListener) it.next()).v0(false);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$2", f = "UsageAccessHelper.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128081b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f128081b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f128081b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128080a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1 function1 = this.f128081b;
            if (function1 == null) {
                return null;
            }
            function1.invoke(Boxing.c(0.33333334f));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1$6", f = "UsageAccessHelper.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128086b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f128086b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass6(this.f128086b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128085a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1 function1 = this.f128086b;
            if (function1 != null) {
                function1.invoke(Boxing.a(true));
            }
            Iterator it = UsageAccessHelper.f128039i.iterator();
            while (it.hasNext()) {
                ((UsageAccessHelper.UsageAccessListener) it.next()).v0(true);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageAccessHelper$updateApplicationAccess$1(Context context, Function1 function1, Function1 function12, Continuation continuation) {
        super(2, continuation);
        this.f128075i = context;
        this.f128076j = function1;
        this.f128077k = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1) {
        BuildersKt__Builders_commonKt.d(UsageAccessHelper.f128033b, null, null, new UsageAccessHelper$updateApplicationAccess$1$3$1(function1, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1) {
        if (function1 != null) {
            function1.invoke(Float.valueOf(0.6666667f));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UsageAccessHelper$updateApplicationAccess$1(this.f128075i, this.f128076j, this.f128077k, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x02b8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r11, r1, r10) == r0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.UsageAccessHelper$updateApplicationAccess$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UsageAccessHelper$updateApplicationAccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
