package cz.mobilesoft.coreblock.scene.more.help;

import android.app.Application;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.HelpViewModel$updatePermissionsAndHelpItems$1", f = "HelpViewModel.kt", l = {81}, m = "invokeSuspend", v = 1)
final class HelpViewModel$updatePermissionsAndHelpItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HelpViewModel f107767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f107768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f107769d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.help.HelpViewModel$updatePermissionsAndHelpItems$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.HelpViewModel$updatePermissionsAndHelpItems$1$1", f = "HelpViewModel.kt", l = {94, 113}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f107771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f107772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f107773d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f107774f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f107775g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f107776h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ HelpViewModel f107777i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, List list2, boolean z2, HelpViewModel helpViewModel, Continuation continuation) {
            super(2, continuation);
            this.f107774f = list;
            this.f107775g = list2;
            this.f107776h = z2;
            this.f107777i = helpViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(boolean z2, HelpItem helpItem) {
            return helpItem == HelpItem.ACCESSIBILITY_SPLIT_SCREEN_BLOCKING && z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f107774f, this.f107775g, this.f107776h, this.f107777i, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        
            if (r2 == r1) goto L49;
         */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 341
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.help.HelpViewModel$updatePermissionsAndHelpItems$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HelpViewModel$updatePermissionsAndHelpItems$1(HelpViewModel helpViewModel, List list, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f107767b = helpViewModel;
        this.f107768c = list;
        this.f107769d = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HelpViewModel$updatePermissionsAndHelpItems$1(this.f107767b, this.f107768c, this.f107769d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HelpViewModel$updatePermissionsAndHelpItems$1 helpViewModel$updatePermissionsAndHelpItems$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f107766a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PermissionsManager permissionsManager = PermissionsManager.f129021a;
            Application applicationY0 = this.f107767b.y0();
            this.f107766a = 1;
            helpViewModel$updatePermissionsAndHelpItems$1 = this;
            obj = permissionsManager.l(true, applicationY0, true, true, helpViewModel$updatePermissionsAndHelpItems$1);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            helpViewModel$updatePermissionsAndHelpItems$1 = this;
        }
        BuildersKt__Builders_commonKt.d(helpViewModel$updatePermissionsAndHelpItems$1.f107767b.B0(), null, null, new AnonymousClass1((List) obj, helpViewModel$updatePermissionsAndHelpItems$1.f107768c, helpViewModel$updatePermissionsAndHelpItems$1.f107769d, helpViewModel$updatePermissionsAndHelpItems$1.f107767b, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HelpViewModel$updatePermissionsAndHelpItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
