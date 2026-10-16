package com.superwall.sdk.debug;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.superwall.sdk.debug.SWDebugManagerLogic;
import com.superwall.sdk.dependencies.ViewFactory;
import com.superwall.sdk.storage.LocalStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

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
public final class DebugManager {
    public static final Companion Companion = new Companion(null);
    private final Context context;
    private final ViewFactory factory;
    private boolean isDebuggerLaunched;
    private final LocalStorage storage;
    private DebugView view;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: outcomeForDeepLink-IoAF18A, reason: not valid java name */
        public final Object m1267outcomeForDeepLinkIoAF18A(Uri deepLinkUrl) {
            Intrinsics.checkNotNullParameter(deepLinkUrl, "deepLinkUrl");
            SWDebugManagerLogic sWDebugManagerLogic = SWDebugManagerLogic.INSTANCE;
            String queryItemValue = sWDebugManagerLogic.getQueryItemValue(deepLinkUrl, SWDebugManagerLogic.Parameter.SUPERWALL_DEBUG);
            if (queryItemValue == null) {
                Result.Companion companion = Result.f139772b;
                return Result.b(ResultKt.a(new IllegalArgumentException("Not debug link")));
            }
            if (!Boolean.parseBoolean(queryItemValue)) {
                Result.Companion companion2 = Result.f139772b;
                return Result.b(ResultKt.a(new IllegalArgumentException("Not debug link")));
            }
            String queryItemValue2 = sWDebugManagerLogic.getQueryItemValue(deepLinkUrl, SWDebugManagerLogic.Parameter.TOKEN);
            if (queryItemValue2 == null) {
                Result.Companion companion3 = Result.f139772b;
                return Result.b(ResultKt.a(new IllegalArgumentException("Not debug link")));
            }
            String queryItemValue3 = sWDebugManagerLogic.getQueryItemValue(deepLinkUrl, SWDebugManagerLogic.Parameter.PAYWALL_ID);
            Result.Companion companion4 = Result.f139772b;
            return Result.b(new DeepLinkOutcome(queryItemValue2, queryItemValue3));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeepLinkOutcome {
        private final String debugKey;
        private final String paywallId;

        public DeepLinkOutcome(String debugKey, String str) {
            Intrinsics.checkNotNullParameter(debugKey, "debugKey");
            this.debugKey = debugKey;
            this.paywallId = str;
        }

        public static /* synthetic */ DeepLinkOutcome copy$default(DeepLinkOutcome deepLinkOutcome, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = deepLinkOutcome.debugKey;
            }
            if ((i3 & 2) != 0) {
                str2 = deepLinkOutcome.paywallId;
            }
            return deepLinkOutcome.copy(str, str2);
        }

        public final String component1() {
            return this.debugKey;
        }

        public final String component2() {
            return this.paywallId;
        }

        public final DeepLinkOutcome copy(String debugKey, String str) {
            Intrinsics.checkNotNullParameter(debugKey, "debugKey");
            return new DeepLinkOutcome(debugKey, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeepLinkOutcome)) {
                return false;
            }
            DeepLinkOutcome deepLinkOutcome = (DeepLinkOutcome) obj;
            return Intrinsics.areEqual(this.debugKey, deepLinkOutcome.debugKey) && Intrinsics.areEqual(this.paywallId, deepLinkOutcome.paywallId);
        }

        public final String getDebugKey() {
            return this.debugKey;
        }

        public final String getPaywallId() {
            return this.paywallId;
        }

        public int hashCode() {
            int iHashCode = this.debugKey.hashCode() * 31;
            String str = this.paywallId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DeepLinkOutcome(debugKey=" + this.debugKey + ", paywallId=" + this.paywallId + ")";
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugManager$launchDebugger$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugManager", f = "DebugManager.kt", l = {67, 68, 71, 72, 74, 75}, m = "launchDebugger")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugManager.this.launchDebugger(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugManager$presentDebugger$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugManager", f = "DebugManager.kt", l = {88}, m = "presentDebugger")
    static final class C27891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C27891(Continuation<? super C27891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugManager.this.presentDebugger(null, this);
        }
    }

    public DebugManager(Context context, LocalStorage storage, ViewFactory factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.context = context;
        this.storage = storage;
        this.factory = factory;
    }

    public static /* synthetic */ Object launchDebugger$default(DebugManager debugManager, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return debugManager.launchDebugger(str, continuation);
    }

    public static /* synthetic */ Object presentDebugger$default(DebugManager debugManager, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return debugManager.presentDebugger(str, continuation);
    }

    public final Object closeDebugger(boolean z2, Continuation<? super Unit> continuation) {
        AppCompatActivity encapsulatingActivity;
        DebugView debugView = this.view;
        if (debugView != null && (encapsulatingActivity = debugView.getEncapsulatingActivity()) != null) {
            encapsulatingActivity.finish();
        }
        this.view = null;
        this.isDebuggerLaunched = false;
        return Unit.f139807a;
    }

    public final DebugView getView() {
        return this.view;
    }

    public final boolean handle(Uri deepLinkUrl) {
        Intrinsics.checkNotNullParameter(deepLinkUrl, "deepLinkUrl");
        Object objM1267outcomeForDeepLinkIoAF18A = Companion.m1267outcomeForDeepLinkIoAF18A(deepLinkUrl);
        if (Result.h(objM1267outcomeForDeepLinkIoAF18A)) {
            this.storage.setDebugKey(((DeepLinkOutcome) objM1267outcomeForDeepLinkIoAF18A).getDebugKey());
        }
        if (Result.h(objM1267outcomeForDeepLinkIoAF18A)) {
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new DebugManager$handle$2$1(this, (DeepLinkOutcome) objM1267outcomeForDeepLinkIoAF18A, null), 3, null);
        }
        return Result.h(objM1267outcomeForDeepLinkIoAF18A);
    }

    public final boolean isDebuggerLaunched() {
        return this.isDebuggerLaunched;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        if (r2.launchDebugger(r7, r0) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        if (r2.presentDebugger(r7, r0) != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
    
        if (r2.launchDebugger(r7, r0) != r1) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object launchDebugger(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugManager.launchDebugger(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object presentDebugger(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.debug.DebugManager.C27891
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.debug.DebugManager$presentDebugger$1 r0 = (com.superwall.sdk.debug.DebugManager.C27891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.debug.DebugManager$presentDebugger$1 r0 = new com.superwall.sdk.debug.DebugManager$presentDebugger$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            com.superwall.sdk.debug.DebugView r5 = (com.superwall.sdk.debug.DebugView) r5
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.debug.DebugManager r0 = (com.superwall.sdk.debug.DebugManager) r0
            kotlin.ResultKt.b(r6)
            goto L5d
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            r4.isDebuggerLaunched = r3
            com.superwall.sdk.debug.DebugView r6 = r4.view
            if (r6 == 0) goto L65
            boolean r2 = r6.isActive$superwall_release()
            if (r2 == 0) goto L4b
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L4b:
            r6.setPaywallDatabaseId$superwall_release(r5)
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r6.loadPreview(r0)
            if (r5 != r1) goto L5b
            return r1
        L5b:
            r0 = r4
            r5 = r6
        L5d:
            com.superwall.sdk.debug.DebugViewActivity$Companion r6 = com.superwall.sdk.debug.DebugViewActivity.Companion
            android.content.Context r0 = r0.context
            r6.startWithView(r0, r5)
            goto L74
        L65:
            com.superwall.sdk.dependencies.ViewFactory r6 = r4.factory
            com.superwall.sdk.debug.DebugView r5 = r6.makeDebugView(r5)
            com.superwall.sdk.debug.DebugViewActivity$Companion r6 = com.superwall.sdk.debug.DebugViewActivity.Companion
            android.content.Context r0 = r4.context
            r6.startWithView(r0, r5)
            r4.view = r5
        L74:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugManager.presentDebugger(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setDebuggerLaunched(boolean z2) {
        this.isDebuggerLaunched = z2;
    }

    public final void setView(DebugView debugView) {
        this.view = debugView;
    }
}
